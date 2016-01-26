package at.game.tictactoe;


public enum CellState {

   EMPTY("EMPTY", 0),
   NOUGHT("NOUGHT", 1),
   CROSS("CROSS", 2);
   // $FF: synthetic field
   private static final CellState[] d = new CellState[]{EMPTY, NOUGHT, CROSS};


   private CellState(String name, int value) {}
}
