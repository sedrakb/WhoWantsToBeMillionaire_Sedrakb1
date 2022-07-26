package com.example.whowantstobemillionaire_sedrakb1;
/*
Bichoy Sedrak - CSIT551 Mobile Computing Summer 2022
Creating Who wants to be a Millionaire game
 */

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    TextView Score;
    private TextView quesTV, quesNumberTV;

    // creating the buttons
    private Button btoption1, btoption2, btoption3, btoption4;

    // setting up the array list for the questions
    private ArrayList<QuizBody> quizBodyArrayList;

    // to generate random questions
    Random random;

    int currentScore = 1000, questionAttempted = 0, CurrentPos;

    // creating Alert Dialog to ask the user to confirm the answer.
    private AlertDialog.Builder confirmation;

    // Linking all views
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Score = (TextView) findViewById(R.id.Score);
        quesTV = (TextView) findViewById(R.id.TVQuestion);
        quesNumberTV = (TextView) findViewById(R.id.Timer);
        btoption1 = (Button) findViewById(R.id.buttonA);
        btoption2 = (Button) findViewById(R.id.buttonB);
        btoption3 = (Button) findViewById(R.id.buttonC);
        btoption4 = (Button) findViewById(R.id.buttonD);

        // setting up the arraylist
        quizBodyArrayList = new ArrayList<>();

        // to generate random questions.
        random = new Random();
        getQuizQuestion(quizBodyArrayList);

        Collections.shuffle(quizBodyArrayList);
        CurrentPos = random.nextInt(quizBodyArrayList.size());
        setDataToViews(CurrentPos);

        // Setting up all OnClick Listener for all options Buttons.
        btoption1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // the confirmation dialog (yes or no)
                confirmation = new AlertDialog.Builder(MainActivity.this);
                confirmation.setTitle("Confirmation");
                confirmation.setMessage("Are you sure ?");
                confirmation.setCancelable(false);
                // if yes the evaluation starts.
                confirmation.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // if to check the correct answer.
                        if(quizBodyArrayList.get(CurrentPos).getAnswer().trim().equalsIgnoreCase(btoption1.getText().toString().trim())){

                            //increase the score if it is a correct answer.
                            currentScore*=2;
                            questionAttempted++;
                            CurrentPos = random.nextInt(quizBodyArrayList.size());
                            Collections.shuffle(quizBodyArrayList);
                            setDataToViews(CurrentPos);
                            Score.setText("$" + currentScore );

                            // toast to show it's a correct answer.
                            Toast.makeText(MainActivity.this, "Correct Answer!" , Toast.LENGTH_LONG).show();
                        }
                        else {
                            // if wrong the game will end.
                            GameOver();
                        }
                    }
                });
                // setting up the No button
                confirmation.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // if no is pressed nothing will happen just return to the screen
                        dialog.cancel();
                    }
                });
                // to create the confirmation window
                AlertDialog dialog = confirmation.create();
                dialog.show();
            }

        });
        btoption2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // the confirmation dialog (yes or no)
                confirmation = new AlertDialog.Builder(MainActivity.this);
                confirmation.setTitle("Confirmation");
                confirmation.setMessage("Are you sure ?");
                confirmation.setCancelable(false);
                // if yes the evaluation starts.
                confirmation.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // if to check the correct answer.
                        if(quizBodyArrayList.get(CurrentPos).getAnswer().trim().equalsIgnoreCase(btoption2.getText().toString().trim())){
                            //increase the score if it is a correct answer.
                            currentScore*=2;
                            // increase the number of attempted questions
                            questionAttempted++;
                            CurrentPos = random.nextInt(quizBodyArrayList.size());
                            Collections.shuffle(quizBodyArrayList);
                            setDataToViews(CurrentPos);
                            Score.setText("$" + currentScore );
                            Toast.makeText(MainActivity.this, "Correct Answer!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            // if wrong the game will end.
                            GameOver();
                        }
                    }
                });
                confirmation.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // if no is pressed nothing will happen just return to the screen
                        dialog.cancel();
                    }
                });
                // to create the confirmation window
                AlertDialog dialog = confirmation.create();
                dialog.show();

            }

        });

        btoption3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // the confirmation dialog (yes or no)
                confirmation = new AlertDialog.Builder(MainActivity.this);
                confirmation.setTitle("Confirmation");
                confirmation.setMessage("Are you sure ?");
                confirmation.setCancelable(false);
                // if yes the evaluation starts.
                confirmation.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // if to check the correct answer.
                        if(quizBodyArrayList.get(CurrentPos).getAnswer().trim().equalsIgnoreCase(btoption3.getText().toString().trim())){
                            //increase the score if it is a correct answer.
                            currentScore*=2;
                            Score.setText("$" + currentScore );
                            questionAttempted++;
                            CurrentPos = random.nextInt(quizBodyArrayList.size());
                            Collections.shuffle(quizBodyArrayList);
                            setDataToViews(CurrentPos);
                            Toast.makeText(MainActivity.this, "Correct Answer!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            // if wrong the game will end.
                            GameOver();
                        }
                    }
                });
                confirmation.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = confirmation.create();
                dialog.show();

            }

        });

        btoption4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // the confirmation dialog (yes or no)
                confirmation = new AlertDialog.Builder(MainActivity.this);
                confirmation.setTitle("Confirmation");
                confirmation.setMessage("Are you sure? ");
                confirmation.setCancelable(false);

                // if yes the evaluation starts.
                confirmation.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @SuppressLint("SetTextI18n")
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // if to check the correct answer.
                        if(quizBodyArrayList.get(CurrentPos).getAnswer().trim().equalsIgnoreCase(btoption4.getText().toString().trim())){
                            //increase the score if it is a correct answer.
                            currentScore*=2;
                            Score.setText("$" + currentScore );
                            questionAttempted++;
                            CurrentPos = random.nextInt(quizBodyArrayList.size());
                            Collections.shuffle(quizBodyArrayList);
                            setDataToViews(CurrentPos);
                            Toast.makeText(MainActivity.this, "Correct Answer!", Toast.LENGTH_LONG).show();
                        }
                        else {
                            // if wrong the game will end.
                            GameOver();
                        }
                    }
                });
                confirmation.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog dialog = confirmation.create();
                dialog.show();

            }

        });
    }
// setting up the Game Over Dialog
    @SuppressLint("SetTextI18n")
    private void GameOver(){
        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.gameover, (LinearLayout)findViewById(R.id.score));
        TextView message = bottomSheetView.findViewById(R.id.message);
        TextView ScoreTV = bottomSheetView.findViewById(R.id.tvscore);
        Button ResetQuiz = bottomSheetView.findViewById(R.id.reset);
        message.setText("Game Over!");
        ScoreTV.setText("You Won $0");

        // on click listener for the reset button
        ResetQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // reset all
                CurrentPos = random.nextInt(quizBodyArrayList.size());
                setDataToViews(CurrentPos);
                questionAttempted = 0;
                currentScore = 1000;
                //close the dialog
                bottomSheetDialog.dismiss();
                Score.setText("$0 " );
            }
        });
        // can't escape the dialog
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    //creating method to show the Win Dialog and the reset button
    @SuppressLint("SetTextI18n")
    private void WinDialog (){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(MainActivity.this);
        View bottomSheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.windialog, (LinearLayout)findViewById(R.id.score));
        TextView message = bottomSheetView.findViewById(R.id.message);
        TextView ScoreTV = bottomSheetView.findViewById(R.id.tvscore);
        Button ResetQuiz = bottomSheetView.findViewById(R.id.reset);
        message.setText("Congratulations!");
        ScoreTV.setText("You Won $ " + currentScore);


        // on click listener for the reset button
        ResetQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // reset all
                CurrentPos = random.nextInt(quizBodyArrayList.size());
                setDataToViews(CurrentPos);
                questionAttempted = 0;
                currentScore = 1000;
                //close the dialog
                bottomSheetDialog.dismiss();
                Score.setText("$0");
            }
        });
        // can't escape the dialog
        bottomSheetDialog.setCancelable(false);
        bottomSheetDialog.setContentView(bottomSheetView);
        bottomSheetDialog.show();
    }


    // Setting up the method to display all the questions data to the TextView
    @SuppressLint("SetTextI18n")
    private void setDataToViews(int CurrentPos){
        quesNumberTV.setText( questionAttempted + "/10");
        if (questionAttempted == 10) {
            WinDialog();
        } else {
            quesTV.setText(quizBodyArrayList.get(CurrentPos).getQuestion());
            btoption1.setText(quizBodyArrayList.get(CurrentPos).getOption1());
            btoption2.setText(quizBodyArrayList.get(CurrentPos).getOption2());
            btoption3.setText(quizBodyArrayList.get(CurrentPos).getOption3());
            btoption4.setText(quizBodyArrayList.get(CurrentPos).getOption4());
        }

    }
    //Setting up the Data ArrayList with all questions to display I tried to add a lot of questions to make it a real game :)
    private void getQuizQuestion(ArrayList<QuizBody> quizBodyArrayList) {
        quizBodyArrayList.add(new QuizBody("What country has the longest coastline in the world?", "USA", "Russia", "Canada", "China", "Canada"));
        quizBodyArrayList.add(new QuizBody("By size, what is the smallest country in the world?","Ireland","Vatican", "Lebanon", "Israel", "Vatican" ));
        quizBodyArrayList.add(new QuizBody("Which country is brie cheese originally from? ","Italy", "Swizerland", "France", "Germany", "France"));
        quizBodyArrayList.add(new QuizBody("Who painted the Mona Lisa?", "Leonardo da Vinci", "Vincent van Gogh", "Micheangelo","Salvador Dali", "Leonardo da Vinci"));
        quizBodyArrayList.add(new QuizBody("Where would you be if you were standing on the Spanish Steps? ", "Mexico City", "Madrid", "Barcelona", "Rome", "Rome"));
        quizBodyArrayList.add(new QuizBody("Who was the Ancient Greek God of the Sun?", "Zeus", "Artemis", "Hermes", "Apollo","Apollo"));
        quizBodyArrayList.add(new QuizBody("What year was the United Nations established?", "1938", "1951", "1945", "1944","1945"));
        quizBodyArrayList.add(new QuizBody("What sports car company manufactures the 911?", "Ferrari", "Porsche","McLaren", "Lamborghini","Porsche"));
        quizBodyArrayList.add(new QuizBody("Which planet has the most moons?", "Jupiter", "Saturn", "Venus", "Mars", "Saturn"));
        quizBodyArrayList.add(new QuizBody("In what country is the Chernobyl nuclear plant located?", "Moldova", "Russia", "lithuania", "Ukraine", "Ukraine"));
        quizBodyArrayList.add(new QuizBody("How many elements are in the periodic table?", "118", "119", "111","113","118"));
        quizBodyArrayList.add(new QuizBody("Name the Coffee shop in US sitcom Friends", "Club Coffee", "Coffee House", "Central Perk", "Cup o'Joe","Central Perk"));
        quizBodyArrayList.add(new QuizBody("What is the capital of New Zealand?","Auckland","Bristol", "Wellington", "Queenstown","Wellington"));
        quizBodyArrayList.add(new QuizBody("What Band sings MamaMia?", "Abba", "Boney M","Pink Floyd", "Eagles", "Abba"));
        quizBodyArrayList.add(new QuizBody("Name the composer behind the soundtracks of The Lion King, Inception and Pirates of the Caribbean.", "John Williams", "Hanz Zimmer", "Richard Harris","Issac Albeniz", "Hanz Zimmer"));
        quizBodyArrayList.add(new QuizBody("What is the capital of Iceland?", "Edinburgh", "Reykholt", "Reykjavík", "Dublin", "Reykjavík"));
        quizBodyArrayList.add(new QuizBody("What is the tallest mountain in the world?", "Mount Kilimanjaro", "Aconcagua", "Mount Everest", "Denali", "Mount Everest"));
        quizBodyArrayList.add(new QuizBody("What's the name of the talking snowman in Disney's Frozen?", "Olaf", "Jim", "Tim", "Neve","Olaf"));
        quizBodyArrayList.add(new QuizBody("What’s the name of the cowboy in Toy Story?", "Buzz", "Andy", "Woody", "Slingy", "Woody"));
        quizBodyArrayList.add(new QuizBody("How many keys are there on a piano?", "88", "89","90","92","88"));
        quizBodyArrayList.add(new QuizBody("What is the best-selling novel of all time?", "Harry Potter", "The lord of the rings", "The little Prince", "Don Quixote", "Don Quixote"));
        quizBodyArrayList.add(new QuizBody("Where is the smallest bone in the human body located?", "Nose", "Finger", "Leg", "Ear","Ear"));
        quizBodyArrayList.add(new QuizBody("How many hearts does an octopus have?", "1", "2", "3", "4","3"));
        quizBodyArrayList.add(new QuizBody("Which operating system does a Google Pixel phone use?", "Chrome", "Android", "IOS", "Windows","Android"));
        quizBodyArrayList.add(new QuizBody("Who discovered penicillin?", "Alexander Fleming", "Marie Curie", "Louis Pasteur", "Albert Einstein", "Alexander Fleming"));
        quizBodyArrayList.add(new QuizBody("Which year did the European Union first introduce the Euro as currency?", "1989", "1998","1899","1999","1999"));
        quizBodyArrayList.add(new QuizBody("What is the capital of Bulgaria?", "Plovdiv", "Varna", "Bucharest","Sofia","Sofia"));
        quizBodyArrayList.add(new QuizBody("What is the capital of Brazil?", "Sao Paulo", "Rio de Janeiro", "Brasilia","Buenos Aires","Brasilia"));
        quizBodyArrayList.add(new QuizBody("O’Hare Airport serves which American city", "Las Vegas", "Los Angeles", "Chicago", "Seattle", "Chicago"));
        quizBodyArrayList.add(new QuizBody("Bohemian Switzerland National Park is in which country?","Slovakia", "Swizerland", "Slovenia", "Czech Republic", "Czech Republic"));
        quizBodyArrayList.add(new QuizBody("What is the largest animal on the planet?", "Elephant", "Gorilla", "White Whale", "Blue Whale","Blue Whale"));
        quizBodyArrayList.add(new QuizBody("Which country has the largest population in the world? ", "India", "United States", "Russia", "China", "China"));
        quizBodyArrayList.add(new QuizBody("What is the name of the longest river?", "Nile", "Congo", "Amazon", "Mackenzie", "Amazon"));
        quizBodyArrayList.add(new QuizBody("What American city is the Golden Gate Bridge located in?", "Las Vegas", "San Francisco", "Los Angeles", "New York", "San Francisco"));
        quizBodyArrayList.add(new QuizBody("What is the name of the largest country in the world?", "Russia", "China", "United States", "Canada", "Russia"));
        quizBodyArrayList.add(new QuizBody("What is the capital of Canada?", "Toronto", "Vancouver", "calgary", "Ottawa", "Ottawa"));
        quizBodyArrayList.add(new QuizBody("What is the name of the largest ocean in the world? ", "Atlantic", "Indian","Arctic", "Pacific", "Pacific"));
        quizBodyArrayList.add(new QuizBody("What planet is closest to Earth? ", "Mars", "Venus", "Mercury", "Neptune", "Venus"));
        quizBodyArrayList.add(new QuizBody("Which country invented tea?","India", "Pakistan", "China", "Turkey", "China" ));
        quizBodyArrayList.add(new QuizBody("The Statue of Liberty was given to the US by which country?", "Germany", "France", "England", "Ireland","France"));
        quizBodyArrayList.add(new QuizBody("Which horoscope sign has a crab? ", "Scorpio", "Gemini", "Aries", "Cancer","Cancer"));
    }
}

// end by Bichoy Sedrak