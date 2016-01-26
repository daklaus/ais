package at.game.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    TicTacToeView ticTacToeView;

    public void newGame(View view) {
        startActivity(new Intent(this, NewGameActivity.class));
    }

    protected void onCreate(Bundle savedInstanceState) {
        String player1Name;
        String player2Name;
        boolean player1Ai;
        boolean z2 = true;
        boolean player2Ai = false;
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
//        setContentView(2130903040);
//        this.ticTacToeView = (TicTacToeView) findViewById(2131165185);
        setContentView(R.layout.activity_main);
        this.ticTacToeView = (TicTacToeView) findViewById(R.id.view1);
        this.ticTacToeView.setOnTouchListener(new TttOnTouchListener(this));
        if (intent == null || intent.getExtras() == null) {
            player1Name = "Brubbel";
            player2Name = "Emil";
            player1Ai = false;
            z2 = false;
        } else {
            boolean z4;
            boolean z5;
            if (intent.getExtras().containsKey("at.game.tictactoe.PLAYER1")) {
                player1Name = intent.getStringExtra("at.game.tictactoe.PLAYER1");
                z4 = true;
            } else {
                player1Name = "Brubbel";
                z4 = false;
            }
            if (intent.getExtras().containsKey("at.game.tictactoe.PLAYER2")) {
                player2Name = intent.getStringExtra("at.game.tictactoe.PLAYER2");
                player1Ai = true;
            } else {
                player1Ai = z4;
                player2Name = "Emil";
            }
            if (intent.getExtras().containsKey("at.game.tictactoe.AI1")) {
                player1Ai = intent.getBooleanExtra("at.game.tictactoe.AI1", false);
                z5 = true;
            } else {
                z5 = player1Ai;
                player1Ai = false;
            }
            if (intent.getExtras().containsKey("at.game.tictactoe.AI2")) {
                player2Ai = intent.getBooleanExtra("at.game.tictactoe.AI2", false);
            } else {
                z2 = z5;
            }
        }
        if (z2) {
            this.ticTacToeView.newGame(player1Name, player2Name, player1Ai, player2Ai);
        }
    }
}
