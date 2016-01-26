package at.game.tictactoe;

/* renamed from: at.game.tictactoe.a */
public class GameField {
    private Cell[][] cells;
    private CellTriple[] cellTriples;

    public GameField() {
        this.cells = new Cell[3][];
        for (int i = 0; i < 3; i++) {
            this.cells[i] = new Cell[3];
            for (int i2 = 0; i2 < 3; i2++) {
                this.cells[i][i2] = new Cell();
            }
        }
        this.cellTriples = new CellTriple[8];
        this.cellTriples[0] = new CellTriple(this.cells[0][0], this.cells[0][1], this.cells[0][2]);
        this.cellTriples[1] = new CellTriple(this.cells[1][0], this.cells[1][1], this.cells[1][2]);
        this.cellTriples[2] = new CellTriple(this.cells[2][0], this.cells[2][1], this.cells[2][2]);
        this.cellTriples[3] = new CellTriple(this.cells[0][0], this.cells[1][0], this.cells[2][0]);
        this.cellTriples[4] = new CellTriple(this.cells[0][1], this.cells[1][1], this.cells[2][1]);
        this.cellTriples[5] = new CellTriple(this.cells[0][2], this.cells[1][2], this.cells[2][2]);
        this.cellTriples[6] = new CellTriple(this.cells[0][0], this.cells[1][1], this.cells[2][2]);
        this.cellTriples[7] = new CellTriple(this.cells[0][2], this.cells[1][1], this.cells[2][0]);
    }

    public PlayerMark getMarkOfCell(int i, int j) {
        return this.cells[i][j].getMark();
    }

    public void emptyAllCells() {
        for (Cell[] cellArr : this.cells) {
            for (Cell a : cellArr) {
                a.setMark(PlayerMark.EMPTY);
            }
        }
    }

	/**
     * @return false if the cell is not markable (it is already marked)
     */
    public boolean tryMarkCell(int i, int j, PlayerMark playerMark) {
        if (this.cells[i][j].getMark() != PlayerMark.EMPTY && playerMark != PlayerMark.EMPTY) {
            return false;
        }
        this.cells[i][j].setMark(playerMark);
        return true;
    }

    public boolean hasPlayerWon(PlayerMark playerMark) {
        for (CellTriple a : this.cellTriples) {
            if (a.allMarkedWith(playerMark)) {
                return true;
            }
        }
        return false;
    }

    public boolean allCellsMarked() {
        for (Cell[] cellArr : this.cells) {
            for (Cell a : cellArr) {
                if (a.getMark() == PlayerMark.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
