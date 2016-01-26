package at.game.tictactoe;

/* renamed from: at.game.tictactoe.h */
/* synthetic */ class C0007h {
    static final /* synthetic */ int[] f35a;

    static {
        f35a = new int[PlayerMark.values().length];
        try {
            f35a[PlayerMark.CROSS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f35a[PlayerMark.NOUGHT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
    }
}
