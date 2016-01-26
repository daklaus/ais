package at.game.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import java.util.Random;

public class NewGameActivity extends Activity {
    private String[] playerNames;

    public NewGameActivity() {
        this.playerNames = new String[]{"Hugo", "Emil", "T\u00f6lpel", "Dummel", "Brubbel", "Wusel", "Br\u00f6sel", "Toffel"};
    }

    private void setRandomPlayerNames() {
        int nextInt;
        Random random = new Random();
        int nextInt2 = random.nextInt(this.playerNames.length);
        do {
            nextInt = random.nextInt(this.playerNames.length);
        } while (nextInt2 == nextInt);
//        EditText editText = (EditText) findViewById(2131165190);
//        ((EditText) findViewById(2131165187)).setText(this.playerNames[nextInt2]);
//        editText.setText(this.playerNames[nextInt]);
        ((EditText) findViewById(R.id.editText2)).setText(this.playerNames[nextInt]);
        ((EditText) findViewById(R.id.editText1)).setText(this.playerNames[nextInt2]);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
//        setContentView(2130903041);
        setContentView(R.layout.activity_new_game);
        setRandomPlayerNames();
    }

    public void startNewGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        CheckBox checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
//        CheckBox checkBox1 = (CheckBox) findViewById(2131165188);
//        CheckBox checkBox2 = (CheckBox) findViewById(2131165191);
//        intent.putExtra("at.game.tictactoe.PLAYER1", ((EditText) findViewById(2131165187)).getText().toString());
//        intent.putExtra("at.game.tictactoe.PLAYER2", ((EditText) findViewById(2131165190)).getText().toString());
        intent.putExtra("at.game.tictactoe.PLAYER1", editText1.getText().toString());
        intent.putExtra("at.game.tictactoe.PLAYER2", editText2.getText().toString());
        intent.putExtra("at.game.tictactoe.AI1", checkBox1.isChecked());
        intent.putExtra("at.game.tictactoe.AI2", checkBox2.isChecked());
        startActivity(intent);
    }
}
