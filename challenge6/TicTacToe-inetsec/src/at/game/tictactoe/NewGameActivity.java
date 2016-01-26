package at.game.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import java.util.Random;

public class NewGameActivity extends Activity {
    private String[] f1a;

    public NewGameActivity() {
        this.f1a = new String[]{"Hugo", "Emil", "T\u00f6lpel", "Dummel", "Brubbel", "Wusel", "Br\u00f6sel", "Toffel"};
    }

    private void m0a() {
        int nextInt;
        Random random = new Random();
        int nextInt2 = random.nextInt(this.f1a.length);
        do {
            nextInt = random.nextInt(this.f1a.length);
        } while (nextInt2 == nextInt);
        EditText editText = (EditText) findViewById(2131165190);
        ((EditText) findViewById(2131165187)).setText(this.f1a[nextInt2]);
        editText.setText(this.f1a[nextInt]);
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(2130903041);
        m0a();
    }

    public void startNewGame(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        EditText editText = (EditText) findViewById(2131165190);
        CheckBox checkBox = (CheckBox) findViewById(2131165188);
        CheckBox checkBox2 = (CheckBox) findViewById(2131165191);
        intent.putExtra("at.game.tictactoe.PLAYER1", ((EditText) findViewById(2131165187)).getText().toString());
        intent.putExtra("at.game.tictactoe.PLAYER2", editText.getText().toString());
        intent.putExtra("at.game.tictactoe.AI1", checkBox.isChecked());
        intent.putExtra("at.game.tictactoe.AI2", checkBox2.isChecked());
        startActivity(intent);
    }
}
