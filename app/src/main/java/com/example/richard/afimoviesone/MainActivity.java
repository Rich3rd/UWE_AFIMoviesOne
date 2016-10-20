package com.example.richard.afimoviesone;

import java.util.Random;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
    private TextView filmOne;
    private String movieTitle;
    String filmSelection [] = new String[5];
    int filmChosen=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filmOne = (TextView) findViewById(R.id.filmOne);
        filmSelection[0] = "Citizen Kane";
        filmSelection[1] = "The Graduate";
        filmSelection[2] = "Star Wars";
        filmSelection[3] = "Butch Cassidy and the Sundance Kid";
        filmSelection[4] = "American Graffiti";
        Button button = (Button) findViewById(R.id.button1); button.setOnClickListener(new ButtonHandler());
    } // end onCreate

    class ButtonHandler implements OnClickListener { public void onClick(View view) {
        filmChosen = getRandomFilmNumber(5);
        movieTitle = filmSelection[filmChosen];
        filmOne.setText(filmSelection[filmChosen]);
    }
    } // endButtonHandler
    public void onClickmyTextView(View v) { searchWeb("IMDB " + movieTitle);
    } // end onClickmyTextView

    public void searchWeb(String query) {
        Intent intent = new Intent(Intent.ACTION_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
    if (intent.resolveActivity(getPackageManager()) != null) {
        startActivity(intent);
    }

} // end searchWeb
    private int getRandomFilmNumber(int maxNumber){ Random randomNumber = new Random();
        int randomFilmNumber = 0;
        randomFilmNumber = randomNumber.nextInt(maxNumber); return randomFilmNumber;
    } // end getRandomFilmNumber
} // end MainActivity

