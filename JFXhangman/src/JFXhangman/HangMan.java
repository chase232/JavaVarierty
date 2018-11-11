
// Program:     HangMan.java
// Developer:   Chase Dickerson
// Date:        11/14/2018
// Purpose:     Creates a simple hangman game

//***************This is my javafx version of hangman

package JFXhangman;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Arc;
import javafx.scene.layout.Pane;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

/**
 * @author Chase Dickerson
 */
public class HangMan extends Application {
    /*
    Global variables are defined below
    */
    public boolean gameOver = false;
    public boolean won = false;
    public static BufferedReader consoleReader;
    public List<String> wordList = new ArrayList<String>();
    public int wordListIndex = 0; // Position in word list
    public String correctLetterCount = "";
    public int attempts = 0; // Number of tries
    public int fails = 0; // Number of tries
    public String message = ""; // Message to the user 
    public String currentWord = ""; // Current hangman word
    public String wordUnderscores = ""; // Underscore and letters string
    public String option = ""; // Current selected user option
    public List<Character> correctCharList; // Correct character guesses
    public List<Character> incorrectCharList; // Incorrect character guesses

    // Create a pane
    Pane pane = new Pane();
    GridPane gridPane = new GridPane();

    double x1 = 50.0;
    double y1 = 220.0;
    double y2 = 2.0;
    double x3 = 125.0;

    private Label lbloption = new Label("\tPlease select an option: ");
    private Label lblenterLetter = new Label("Please enter a letter: ");
    private Label lblenterWord = new Label("Please enter a word: ");
    private Label outcome = new Label("");
    private Label playAgain = new Label("Play Again?");

    private Button btnGuessLetter = new Button("Guess A Letter");
    private Button btnGuessWord = new Button("Guess A Word ");
    private Button btnGiveUp = new Button("Give Up ");
    private Button btnQuit = new Button("Quit ");
    private Button btnCheckLetter = new Button("Check Letter");
    private Button btnCheckWord = new Button("Check Word");
    private Button btnYes = new Button("Yes");
    private Button btnNo = new Button("No");

    TextField checkLetter = new TextField();
    TextField checkWord = new TextField();

    TextArea textAreaCorrect = new TextArea();
    TextArea textAreaIncorrect = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        correctCharList = new ArrayList<Character>();
        incorrectCharList = new ArrayList<Character>();

        // Load the words from the word file into memory
        Helper.loadWordsIntoMemory(wordList);

        generateNewWord();
        straightLines();
        addGridPane();
        hideGuess();

        Scene scene = new Scene(pane, 1000, 400);
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(scene);
        primaryStage.show();

        btnGuessLetter.setOnAction(event -> {
            hideStartMenu();
            showGuessLetter();
        });

        btnGuessWord.setOnAction(event -> {
            hideStartMenu();
            showGuessWord();
        });

        btnGiveUp.setOnAction(event -> {
            hideStartMenu();
            showCurrentWord();
            gameOver = true;
            won = false;
            checkGameOver();
        });

        btnQuit.setOnAction(event -> {
            primaryStage.close();
        });

        btnYes.setOnAction(event -> {
            pane.getChildren().clear();
            gridPane.getChildren().clear();
            addGridPane();
            straightLines();
            correctCharList.clear();
            incorrectCharList.clear();
            fails = 0;
            textAreaIncorrect.setText(" ");
            textAreaCorrect.setText(" ");
            gameOver = false;
            won = false;
            generateNewWord();
            showStartMenu();
        });

        btnNo.setOnAction(event -> {
            primaryStage.close();
        });

        btnCheckLetter.setOnAction(event -> {

            char letter = ' ';
            letter = checkLetter.getText().charAt(0);
            attempts++;
            char[] charArray = currentWord.toCharArray();
            boolean found = false;

            for (char a : charArray) {
                if (a == letter) {
                    correctCharList.add(a);
                    found = true;
                    break;
                }
            }
            if (found == false) {
                incorrectCharList.add(letter);
                fails++;
                addLimb(fails);
            }
            showWord();
        });

        btnCheckWord.setOnAction(event -> {
            String guess = checkWord.getText();
            char[] characterArray = currentWord.toCharArray();
            if (guess.equals(currentWord)) {
                for (char c : characterArray) {
                    correctCharList.add(c);
                }
                gameOver = true;
                won = true;
            } else {
                fails++;
                addLimb(fails);
            }
            showWord();
        });
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void addGridPane() {
        gridPane.setHgap(5);
        gridPane.setVgap(5);

        //Create Bread size radio buttons
        gridPane.add(lbloption, 46, 4);
        gridPane.add(btnGuessLetter, 50, 6);
        gridPane.add(btnGuessWord, 50, 8);
        gridPane.add(btnGiveUp, 50, 10);
        gridPane.add(btnQuit, 50, 12);

        gridPane.add(lblenterLetter, 46, 4);
        gridPane.add(checkLetter, 46, 6);
        gridPane.add(btnCheckLetter, 46, 8);

        gridPane.add(lblenterWord, 46, 4);
        gridPane.add(checkWord, 46, 6);
        gridPane.add(btnCheckWord, 46, 8);

        gridPane.add(textAreaIncorrect, 50, 16);
        gridPane.add(textAreaCorrect, 50, 18);

        textAreaIncorrect.setPrefHeight(50);
        textAreaCorrect.setPrefHeight(50);
        textAreaIncorrect.setEditable(false);
        textAreaCorrect.setEditable(false);

        gridPane.add(outcome, 46, 4);
        gridPane.add(playAgain, 46, 6);
        gridPane.add(btnYes, 46, 8);
        gridPane.add(btnNo, 46, 10);

        pane.getChildren().add(gridPane);
    }

    private void hideGuess() {
        lblenterLetter.setVisible(false);
        lblenterWord.setVisible(false);
        btnCheckLetter.setVisible(false);
        btnCheckWord.setVisible(false);
        checkLetter.setVisible(false);
        checkWord.setVisible(false);
        playAgain.setVisible(false);
        outcome.setVisible(false);
        btnYes.setVisible(false);
        btnNo.setVisible(false);
    }

    private void hideStartMenu() {
        lbloption.setVisible(false);
        btnGuessLetter.setVisible(false);
        btnGuessWord.setVisible(false);
        btnGiveUp.setVisible(false);
        btnQuit.setVisible(false);
    }

    private void showGuessLetter() {
        lblenterLetter.setVisible(true);
        btnCheckLetter.setVisible(true);
        checkLetter.setVisible(true);
    }

    private void showGuessWord() {
        lblenterWord.setVisible(true);
        btnCheckWord.setVisible(true);
        checkWord.setVisible(true);
    }

    private void showStartMenu() {
        hideGuess();
        lbloption.setVisible(true);
        btnGuessLetter.setVisible(true);
        btnGuessWord.setVisible(true);
        btnGiveUp.setVisible(true);
        btnQuit.setVisible(true);
        checkGameOver();
    }

    private void displayGameOver() {
        outcome.setVisible(true);
        playAgain.setVisible(true);
        btnYes.setVisible(true);
        btnNo.setVisible(true);
    }

    private void generateNewWord() {

        Random rand = new Random();
        int length = wordList.size();
        int index = rand.nextInt(length);
        currentWord = wordList.get(index);
    }

    private void showWord() {

        String correctLetters = " ";
        String incorrectLetters = " ";

        wordListIndex++;
        // Build the underscores and characters
        correctLetterCount = "";
        char[] characterArray = currentWord.toCharArray();
        for (char c : characterArray) {

            if (correctCharList.contains(c)) {
                correctLetters += (c + " ");
                correctLetterCount += c;
            } else {
                correctLetters += ("_" + " ");
            }
        }

        if (correctLetterCount.equals(currentWord)) {
            gameOver = true;
            won = true;
        }
        incorrectLetters += incorrectCharList.toString() + " ";

        textAreaIncorrect.setText(incorrectLetters);
        textAreaCorrect.setText(correctLetters);

        showStartMenu();
    }

    private void addLimb(int fails) {

        switch (fails) {
            case 1:
                head();
                break;
            case 2:
                body();
                head();
                straightLines();
                break;
            case 3:
                leftArm();
                break;
            case 4:
                rightArm();
                break;
            case 5:
                leftLeg();
                break;
            case 6:
                rightLeg();
                gameOver = true;
                break;
            default:
                break;
        }
    }

    private void showCurrentWord() {
        String display = "The word was: " + currentWord;
        textAreaCorrect.setText(display);
    }

    private void checkGameOver() {
        if (gameOver == true) {
            hideStartMenu();
            displayGameOver();
            if (won == true) {
                outcome.setText("You Won!");
            } else {
                outcome.setText("You lost... The word was: " + currentWord);
            }
        }
    }

    private void head() {
        // This one creates a circle
        Circle circle = new Circle(x3, y1 * .25, 25);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(2);
        pane.getChildren().add(circle);
    }

    private void body() {
        head();
        Polyline polyline1 = new Polyline();
        pane.getChildren().add(polyline1);
        polyline1.setStroke(Color.BLACK);
        polyline1.setStrokeWidth(2);
        ObservableList list = polyline1.getPoints();
        list.addAll(x1, (y1 * 1.35), x1, y2, x3, y2, x3, y1 * .90);
    }

    private void straightLines() {

        // This one is used to place all of the straight lines
        // (the stand and the body of the hangman)
        Polyline polyline1 = new Polyline();
        pane.getChildren().add(polyline1);
        polyline1.setStroke(Color.BROWN);
        polyline1.setStrokeWidth(4);
        ObservableList list = polyline1.getPoints();
        //list.addAll(x1, (y1 * 1.35), x1, y2, x3, y2, x3, y1 * .90);
        list.addAll(x1, (y1 * 1.35), x1, y2, x3, y2, x3, 30.0 * .90);

        // This one creates an arc used at the bottom
        Arc arc = new Arc(x1, y1 + 80, 25, 15, 0, 180);
        arc.setFill(Color.WHITE);
        arc.setStroke(Color.BROWN);
        arc.setStrokeWidth(4);
        pane.getChildren().add(arc);
    }

    private void leftArm() {
        // This one is used to create the arms
        Polyline polyline2 = new Polyline();
        pane.getChildren().add(polyline2);
        polyline2.setStroke(Color.BLACK);
        polyline2.setStrokeWidth(2);
        ObservableList list2 = polyline2.getPoints();
        //list2.addAll((x1 + x3) * .5, y1 * .7, x3, y1 * .45, x3 + (x3 - x1) * .5, y1 * .7);
        list2.addAll((x1 + x3) * .5, y1 * .7, x3, y1 * .45);
    }

    private void rightArm() {
        // This one is used to create the arms
        Polyline polyline2 = new Polyline();
        pane.getChildren().add(polyline2);
        polyline2.setStroke(Color.BLACK);
        polyline2.setStrokeWidth(2);
        ObservableList list2 = polyline2.getPoints();
        //list2.addAll((x1 + x3) * .5, y1 * .7, x3, y1 * .45, x3 + (x3 - x1) * .5, y1 * .7);
        list2.addAll((x1 + x3) * .5, y1 * .7, x3, y1 * .45, x3 + (x3 - x1) * .5, y1 * .7);
    }

    private void leftLeg() {
        // This one is used to create the legs
        Polyline polyline3 = new Polyline();
        pane.getChildren().add(polyline3);
        polyline3.setStroke(Color.BLACK);
        polyline3.setStrokeWidth(2);
        ObservableList list3 = polyline3.getPoints();
        //list3.addAll((x1 + x3) * .5, y1 * 1.25, x3, y1 * .9, x3 + (x3 - x1) * .5, y1 * 1.25);
        list3.addAll((x1 + x3) * .5, y1 * 1.25, x3, y1 * .9);
    }

    private void rightLeg() {
        Polyline polyline3 = new Polyline();
        pane.getChildren().add(polyline3);
        polyline3.setStroke(Color.BLACK);
        polyline3.setStrokeWidth(2);
        ObservableList list3 = polyline3.getPoints();
        list3.addAll((x1 + x3) * .5, y1 * 1.25, x3, y1 * .9, x3 + (x3 - x1) * .5, y1 * 1.25);
    }
}