package at.game.tictactoe;

/* renamed from: at.game.tictactoe.f */
public class Cell {
    private PlayerMark mark;

    public Cell() {
        this.mark = PlayerMark.EMPTY;
    }

    public PlayerMark getMark() {
        return this.mark;
    }

    public void setMark(PlayerMark playerMark) {
        this.mark = playerMark;
    }
}
