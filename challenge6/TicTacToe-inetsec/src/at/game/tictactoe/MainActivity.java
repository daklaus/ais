package at.game.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import at.game.tictactoe.NewGameActivity;
import at.game.tictactoe.TicTacToeView;
import at.game.tictactoe.c;

public class MainActivity extends Activity {

   TicTacToeView a;


   public void newGame(View var1) {
      this.startActivity(new Intent(this, NewGameActivity.class));
   }

   protected void onCreate(Bundle var1) {
      boolean var3 = true;
      boolean var5 = false;
      super.onCreate(var1);
      Intent var7 = this.getIntent();
      this.setContentView(2130903040);
      this.a = (TicTacToeView)this.findViewById(2131165185);
      this.a.setOnTouchListener(new c(this));
      boolean var2;
      boolean var4;
      String var6;
      String var8;
      if(var7 != null && var7.getExtras() != null) {
         if(var7.getExtras().containsKey("at.game.tictactoe.PLAYER1")) {
            var8 = var7.getStringExtra("at.game.tictactoe.PLAYER1");
            var2 = true;
         } else {
            var8 = "Brubbel";
            var2 = false;
         }

         if(var7.getExtras().containsKey("at.game.tictactoe.PLAYER2")) {
            var6 = var7.getStringExtra("at.game.tictactoe.PLAYER2");
            var2 = true;
         } else {
            var6 = "Emil";
         }

         if(var7.getExtras().containsKey("at.game.tictactoe.AI1")) {
            var4 = var7.getBooleanExtra("at.game.tictactoe.AI1", false);
            var2 = true;
         } else {
            var4 = false;
         }

         if(var7.getExtras().containsKey("at.game.tictactoe.AI2")) {
            var5 = var7.getBooleanExtra("at.game.tictactoe.AI2", false);
            var2 = var3;
         }
      } else {
         var8 = "Brubbel";
         var2 = false;
         var6 = "Emil";
         var4 = false;
      }

      if(var2) {
         this.a.newGame(var8, var6, var4, var5);
      }

   }
}
