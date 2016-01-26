package at.game.tictactoe;

// $FF: synthetic class
class h {

   // $FF: synthetic field
   static final int[] a = new int[CellState.values().length];


   static {
      try {
         a[CellState.CROSS.ordinal()] = 1;
      } catch (NoSuchFieldError var2) {
         ;
      }

      try {
         a[CellState.NOUGHT.ordinal()] = 2;
      } catch (NoSuchFieldError var1) {
         ;
      }
   }
}
