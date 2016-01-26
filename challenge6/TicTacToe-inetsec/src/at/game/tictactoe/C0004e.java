package at.game.tictactoe;

/* renamed from: at.game.tictactoe.e */
public class C0004e {
    private C0005f[] f29a;

    public C0004e(C0005f c0005f, C0005f c0005f2, C0005f c0005f3) {
        this.f29a = new C0005f[3];
        this.f29a[0] = c0005f;
        this.f29a[1] = c0005f2;
        this.f29a[2] = c0005f3;
    }

    public boolean m30a(C0006g c0006g) {
        return this.f29a[0].m31a() == c0006g && this.f29a[1].m31a() == c0006g && this.f29a[2].m31a() == c0006g;
    }
}
