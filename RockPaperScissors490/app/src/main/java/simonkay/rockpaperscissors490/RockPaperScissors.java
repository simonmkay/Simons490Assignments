package simonkay.rockpaperscissors490;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;


public class RockPaperScissors extends Activity implements OnClickListener {

    public enum Option {
        ROCK, PAPER, SCISSORS
    }

    public enum Result {
        WIN, LOSS, DRAW
    }

    private Option userSelection;
    private Result gameResult;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rock_paper_scissors);

        //ID for buttons

        Button buttonRock = (Button) findViewById(R.id.buttonRock);
        Button buttonPaper = (Button) findViewById(R.id.buttonPaper);
        Button buttonScissors = (Button) findViewById(R.id.buttonScissors);
        ImageButton buttonHome = (ImageButton) findViewById(R.id.imageButtonHome);

        // Set click listening event for all buttons.
        buttonRock.setOnClickListener(this);
        buttonPaper.setOnClickListener(this);
        buttonScissors.setOnClickListener(this);
        buttonHome.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.rock_paper_scissors, menu);
        return true;
    }

    @Override
    public void onClick(View v) {

        ImageView imageView = (ImageView) findViewById(R.id.imageViewAnswerUser);
        boolean play = true;

        switch (v.getId()) {
            case R.id.buttonRock:
                userSelection = Option.ROCK;
                imageView.setImageResource(R.drawable.rock_small);
                break;
            case R.id.buttonPaper:
                userSelection = Option.PAPER;
                imageView.setImageResource(R.drawable.paper_small);
                break;
            case R.id.buttonScissors:
                userSelection = Option.SCISSORS;
                imageView.setImageResource(R.drawable.scissors_small);
                break;
            case R.id.imageButtonHome:
               // startActivity(new Intent(RockPaperScissors.this, ChooseActivity.class)); // To go home.
                play = false;
                break;
        }

        if(play) {
            play();
            showResults();
        }
    }

    private void showResults() {
        AlertDialog.Builder builder = new AlertDialog.Builder(RockPaperScissors.this);
        builder.setCancelable(false);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Do nothing
            }
        });

        // Sets the right message according to result.
        if(gameResult == Result.LOSS) {
            builder.setMessage("You Lose!");
        } else if(gameResult == Result.WIN) {
            builder.setMessage("You Win!");
        } else if(gameResult == Result.DRAW) {
            builder.setMessage("It's a draw!");
        }

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void play() {
        // Generates a random play.
        int rand =  ((int)(Math.random() * 10)) % 3;
        Option androidSelection = null;
        ImageView imageView = (ImageView) findViewById(R.id.ImageViewAnswerAndroid);

        // Sets the right image according to random selection.
        switch (rand) {
            case 0:
                androidSelection = Option.ROCK;
                imageView.setImageResource(R.drawable.rock_small);
                break;
            case 1:
                androidSelection = Option.PAPER;
                imageView.setImageResource(R.drawable.paper_small);
                break;
            case 2:
                androidSelection = Option.SCISSORS;
                imageView.setImageResource(R.drawable.scissors_small);
                break;
        }
        // Determine game result according to user selection and Android selection.
        if(androidSelection == userSelection) {
            gameResult = Result.DRAW;
        }
        else if(androidSelection == Option.ROCK && userSelection == Option.SCISSORS) {
            gameResult = Result.LOSS;
        }
        else if(androidSelection == Option.PAPER && userSelection == Option.ROCK) {
            gameResult = Result.LOSS;
        }
        else if(androidSelection == Option.SCISSORS && userSelection == Option.PAPER) {
            gameResult = Result.LOSS;
        } else {
            gameResult = Result.WIN;
        }
    }
}