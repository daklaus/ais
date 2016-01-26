package at.game.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import at.game.tictactoe.MainActivity;
import java.util.Random;

public class NewGameActivity extends Activity {

   private String[] a = new String[]{"Hugo", "Emil", "Tölpel", "Dummel", "Brubbel", "Wusel", "Brösel", "Toffel"};


   private void a() {
      Random var3 = new Random();
      int var1 = var3.nextInt(this.a.length);

      int var2;
      do {
         var2 = var3.nextInt(this.a.length);
      } while(var1 == var2);

      EditText var5 = (EditText)this.findViewById(2131165187);
      EditText var4 = (EditText)this.findViewById(2131165190);
      var5.setText(this.a[var1]);
      var4.setText(this.a[var2]);
   }

   protected void onCreate(Bundle var1) {
      super.onCreate(var1);
      this.setContentView(2130903041);
      this.a();
   }

   public void startNewGame(View var1) {
      Intent var6 = new Intent(this, MainActivity.class);
      EditText var2 = (EditText)this.findViewById(2131165187);
      EditText var3 = (EditText)this.findViewById(2131165190);
      CheckBox var4 = (CheckBox)this.findViewById(2131165188);
      CheckBox var5 = (CheckBox)this.findViewById(2131165191);
      var6.putExtra("at.game.tictactoe.PLAYER1", var2.getText().toString());
      var6.putExtra("at.game.tictactoe.PLAYER2", var3.getText().toString());
      var6.putExtra("at.game.tictactoe.AI1", var4.isChecked());
      var6.putExtra("at.game.tictactoe.AI2", var5.isChecked());
      this.startActivity(var6);
   }
}
