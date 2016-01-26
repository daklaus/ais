package at.game.tictactoe;

/* renamed from: at.game.tictactoe.a */
public class C0000a {
    private C0005f[][] f16a;
    private C0004e[] f17b;

    public C0000a() {
        this.f16a = new C0005f[3][];
        for (int i = 0; i < 3; i++) {
            this.f16a[i] = new C0005f[3];
            for (int i2 = 0; i2 < 3; i2++) {
                this.f16a[i][i2] = new C0005f();
            }
        }
        this.f17b = new C0004e[8];
        this.f17b[0] = new C0004e(this.f16a[0][0], this.f16a[0][1], this.f16a[0][2]);
        this.f17b[1] = new C0004e(this.f16a[1][0], this.f16a[1][1], this.f16a[1][2]);
        this.f17b[2] = new C0004e(this.f16a[2][0], this.f16a[2][1], this.f16a[2][2]);
        this.f17b[3] = new C0004e(this.f16a[0][0], this.f16a[1][0], this.f16a[2][0]);
        this.f17b[4] = new C0004e(this.f16a[0][1], this.f16a[1][1], this.f16a[2][1]);
        this.f17b[5] = new C0004e(this.f16a[0][2], this.f16a[1][2], this.f16a[2][2]);
        this.f17b[6] = new C0004e(this.f16a[0][0], this.f16a[1][1], this.f16a[2][2]);
        this.f17b[7] = new C0004e(this.f16a[0][2], this.f16a[1][1], this.f16a[2][0]);
    }

    public C0006g m8a(int i, int i2) {
        return this.f16a[i][i2].m31a();
    }

    public void m9a() {
        for (C0005f[] c0005fArr : this.f16a) {
            for (C0005f a : r3[r2]) {
                a.m32a(C0006g.EMPTY);
            }
        }
    }

    public boolean m10a(int i, int i2, C0006g c0006g) {
        if (this.f16a[i][i2].m31a() != C0006g.EMPTY && c0006g != C0006g.EMPTY) {
            return false;
        }
        this.f16a[i][i2].m32a(c0006g);
        return true;
    }

    public boolean m11a(C0006g c0006g) {
        for (C0004e a : this.f17b) {
            if (a.m30a(c0006g)) {
                return true;
            }
        }
        return false;
    }

    public boolean m12b() {
        for (C0005f[] c0005fArr : this.f16a) {
            for (C0005f a : r3[r2]) {
                if (a.m31a() == C0006g.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }
}
