package at.game.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
    TicTacToeView f0a;

    public void newGame(View view) {
        startActivity(new Intent(this, NewGameActivity.class));
    }

    protected void onCreate(Bundle bundle) {
        String str;
        String str2;
        boolean z;
        boolean z2 = true;
        boolean z3 = false;
        super.onCreate(bundle);
        Intent intent = getIntent();
        setContentView(2130903040);
        this.f0a = (TicTacToeView) findViewById(2131165185);
        this.f0a.setOnTouchListener(new C0002c(this));
        if (intent == null || intent.getExtras() == null) {
            str = "Brubbel";
            str2 = "Emil";
            z = false;
            z2 = false;
        } else {
            boolean z4;
            boolean z5;
            if (intent.getExtras().containsKey("at.game.tictactoe.PLAYER1")) {
                str = intent.getStringExtra("at.game.tictactoe.PLAYER1");
                z4 = true;
            } else {
                str = "Brubbel";
                z4 = false;
            }
            if (intent.getExtras().containsKey("at.game.tictactoe.PLAYER2")) {
                str2 = intent.getStringExtra("at.game.tictactoe.PLAYER2");
                z = true;
            } else {
                z = z4;
                str2 = "Emil";
            }
            if (intent.getExtras().containsKey("at.game.tictactoe.AI1")) {
                z = intent.getBooleanExtra("at.game.tictactoe.AI1", false);
                z5 = true;
            } else {
                z5 = z;
                z = false;
            }
            if (intent.getExtras().containsKey("at.game.tictactoe.AI2")) {
                z3 = intent.getBooleanExtra("at.game.tictactoe.AI2", false);
            } else {
                z2 = z5;
            }
        }
        if (z2) {
            this.f0a.newGame(str, str2, z, z3);
        }
    }
}
