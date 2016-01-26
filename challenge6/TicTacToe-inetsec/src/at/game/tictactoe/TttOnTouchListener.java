package at.game.tictactoe;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class TttOnTouchListener implements OnTouchListener {

   // $FF: synthetic field
   final MainActivity mainActivity;


   TttOnTouchListener(MainActivity var1) {
      this.mainActivity = var1;
   }

   public boolean onTouch(View var1, MotionEvent var2) {
      switch(var2.getAction()) {
      case 0:
         this.mainActivity.ticTacToeView.a(var2.getX(), var2.getY());
         break;
      case 1:
         var1.performClick();
      }

      return true;
   }
}
