package at.game.tictactoe;

/* renamed from: at.game.tictactoe.b */
public class GameEngine {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player winner;
    private Player loser;
    private GameField gameField;
    private boolean gameOver;

    public GameEngine() {
        this.gameField = new GameField();
        this.player1 = new Player(PlayerMark.CROSS);
        this.player2 = new Player(PlayerMark.NOUGHT);
        this.currentPlayer = this.player1;
        this.gameOver = false;
        this.winner = null;
        this.loser = null;
        this.currentPlayer = null;
    }

    private void m13f() {
        int i = -99;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = 0;
            while (i5 < 3) {
                int h;
                if (this.gameField.getMarkOfCell(i4, i5) == PlayerMark.EMPTY) {
                    this.gameField.tryMarkCell(i4, i5, this.currentPlayer.getPlayerMark());
                    if (this.gameField.hasPlayerWon(this.currentPlayer.getPlayerMark())) {
                        this.winner = this.currentPlayer;
                        this.loser = this.currentPlayer == this.player1 ? this.player2 : this.player1;
                        this.gameOver = true;
                        return;
                    } else if (this.gameField.allCellsMarked()) {
                        this.gameOver = true;
                        return;
                    } else {
                        h = m15h();
                        if (h > i) {
                            i3 = i4;
                            i2 = i5;
                        } else {
                            h = i;
                        }
                        this.gameField.tryMarkCell(i4, i5, PlayerMark.EMPTY);
                    }
                } else {
                    h = i;
                }
                i5++;
                i = h;
            }
        }
        m18a(i3, i2);
    }

    private int m14g() {
        int i = -99;
        int i2 = 0;
        while (i2 < 3) {
            int i3 = 0;
            int i4 = i;
            while (i3 < 3) {
                if (this.gameField.getMarkOfCell(i2, i3) == PlayerMark.EMPTY) {
                    this.gameField.tryMarkCell(i2, i3, this.currentPlayer.getPlayerMark());
                    if (this.gameField.hasPlayerWon(this.currentPlayer.getPlayerMark())) {
                        this.gameField.tryMarkCell(i2, i3, PlayerMark.EMPTY);
                        return 1;
                    } else if (this.gameField.allCellsMarked()) {
                        this.gameField.tryMarkCell(i2, i3, PlayerMark.EMPTY);
                        return 0;
                    } else {
                        i = m15h();
                        if (i4 >= i) {
                            i = i4;
                        }
                        this.gameField.tryMarkCell(i2, i3, PlayerMark.EMPTY);
                    }
                } else {
                    i = i4;
                }
                i3++;
                i4 = i;
            }
            i2++;
            i = i4;
        }
        return i;
    }

    private int m15h() {
        int i = 99;
        Player player = this.currentPlayer == this.player1 ? this.player2 : this.player1;
        int i2 = 0;
        while (i2 < 3) {
            int i3 = 0;
            int i4 = i;
            while (i3 < 3) {
                if (this.gameField.getMarkOfCell(i2, i3) == PlayerMark.EMPTY) {
                    this.gameField.tryMarkCell(i2, i3, player.getPlayerMark());
                    if (this.gameField.hasPlayerWon(player.getPlayerMark())) {
                        this.gameField.tryMarkCell(i2, i3, PlayerMark.EMPTY);
                        return -1;
                    } else if (this.gameField.allCellsMarked()) {
                        this.gameField.tryMarkCell(i2, i3, PlayerMark.EMPTY);
                        return 0;
                    } else {
                        i = m14g();
                        if (i4 <= i) {
                            i = i4;
                        }
                        this.gameField.tryMarkCell(i2, i3, PlayerMark.EMPTY);
                    }
                } else {
                    i = i4;
                }
                i3++;
                i4 = i;
            }
            i2++;
            i = i4;
        }
        return i;
    }

    public void m16a() {
        this.gameField.emptyAllCells();
        this.currentPlayer = this.player1;
        this.gameOver = false;
        this.winner = null;
        this.loser = null;
        if (this.currentPlayer.isAi()) {
            m13f();
        }
    }

    public void setPlayer1(String player1Name, boolean player1Ai) {
        this.player1.setName(player1Name);
        this.player1.setAi(player1Ai);
    }

    public boolean m18a(int i, int i2) {
        if (this.currentPlayer == null || this.gameOver || !this.gameField.tryMarkCell(i, i2, this.currentPlayer.getPlayerMark())) {
            return false;
        }
        if (this.gameField.hasPlayerWon(this.currentPlayer.getPlayerMark())) {
            this.gameOver = true;
            this.winner = this.currentPlayer;
            this.loser = this.currentPlayer == this.player1 ? this.player2 : this.player1;
        } else if (this.gameField.allCellsMarked()) {
            this.gameOver = true;
        } else if (this.currentPlayer == this.player1) {
            this.currentPlayer = this.player2;
        } else {
            this.currentPlayer = this.player1;
        }
        if (this.currentPlayer.isAi()) {
            m13f();
        }
        return true;
    }

    public Player getWinner() {
        return this.winner;
    }

    public PlayerMark getMarkOfCell(int i, int j) {
        return this.gameField.getMarkOfCell(i, j);
    }

    public void setPlayer2(String player2Name, boolean player2Ai) {
        this.player2.setName(player2Name);
        this.player2.setAi(player2Ai);
    }

    public Player getLoser() {
        return this.loser;
    }

    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean isGameOver() {
        return this.gameOver;
    }
}
