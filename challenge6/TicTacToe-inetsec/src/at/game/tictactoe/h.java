package at.game.tictactoe;

import at.game.tictactoe.g;

// $FF: synthetic class
class h {

   // $FF: synthetic field
   static final int[] a = new int[g.values().length];


   static {
      try {
         a[g.c.ordinal()] = 1;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         a[g.b.ordinal()] = 2;
      } catch (NoSuchFieldError var1) {
         ;
      }
   }
}
