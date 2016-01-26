package at.game.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

   TicTacToeView ticTacToeView;


   public void newGame(View var1) {
      this.startActivity(new Intent(this, NewGameActivity.class));
   }

   protected void onCreate(Bundle savedInstanceState) {
      boolean player2Ai = false;
      super.onCreate(savedInstanceState);
      Intent intent = this.getIntent();
      this.setContentView(2130903040);
      this.ticTacToeView = (TicTacToeView)this.findViewById(2131165185);
      this.ticTacToeView.setOnTouchListener(new TttOnTouchListener(this));
      boolean var2;
      boolean player1Ai;
      String player2;
      String player1;
      if(intent != null && intent.getExtras() != null) {
         if(intent.getExtras().containsKey("at.game.tictactoe.PLAYER1")) {
            player1 = intent.getStringExtra("at.game.tictactoe.PLAYER1");
            var2 = true;
         } else {
            player1 = "Brubbel";
            var2 = false;
         }

         if(intent.getExtras().containsKey("at.game.tictactoe.PLAYER2")) {
            player2 = intent.getStringExtra("at.game.tictactoe.PLAYER2");
            var2 = true;
         } else {
            player2 = "Emil";
         }

         if(intent.getExtras().containsKey("at.game.tictactoe.AI1")) {
            player1Ai = intent.getBooleanExtra("at.game.tictactoe.AI1", false);
            var2 = true;
         } else {
            player1Ai = false;
         }

         if(intent.getExtras().containsKey("at.game.tictactoe.AI2")) {
            player2Ai = intent.getBooleanExtra("at.game.tictactoe.AI2", false);
            var2 = true;
         }
      } else {
         player1 = "Brubbel";
         var2 = false;
         player2 = "Emil";
         player1Ai = false;
      }

      if(var2) {
         this.ticTacToeView.newGame(player1, player2, player1Ai, player2Ai);
      }

   }
}
