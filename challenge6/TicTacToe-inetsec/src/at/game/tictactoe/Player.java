package at.game.tictactoe;

/* renamed from: at.game.tictactoe.d */
public class Player {
    private String name;
    private PlayerMark playerMark;
    private boolean ai;

    public Player(PlayerMark playerMark) {
        this.playerMark = playerMark;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAi(boolean ai) {
        this.ai = ai;
    }

    public boolean isAi() {
        return this.ai;
    }

    public PlayerMark getPlayerMark() {
        return this.playerMark;
    }
}
