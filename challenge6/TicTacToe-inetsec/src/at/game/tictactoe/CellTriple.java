package at.game.tictactoe;

/* renamed from: at.game.tictactoe.e */
public class CellTriple {
    private Cell[] cells;

    public CellTriple(Cell cell1, Cell cell2, Cell cell3) {
        this.cells = new Cell[3];
        this.cells[0] = cell1;
        this.cells[1] = cell2;
        this.cells[2] = cell3;
    }

    public boolean allMarkedWith(PlayerMark playerMark) {
        return this.cells[0].getMark() == playerMark && this.cells[1].getMark() == playerMark && this.cells[2].getMark() == playerMark;
    }
}
