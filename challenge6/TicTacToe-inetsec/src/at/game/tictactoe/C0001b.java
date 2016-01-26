package at.game.tictactoe;

/* renamed from: at.game.tictactoe.b */
public class C0001b {
    private C0003d f18a;
    private C0003d f19b;
    private C0003d f20c;
    private C0003d f21d;
    private C0003d f22e;
    private C0000a f23f;
    private boolean f24g;

    public C0001b() {
        this.f23f = new C0000a();
        this.f18a = new C0003d(C0006g.CROSS);
        this.f19b = new C0003d(C0006g.NOUGHT);
        this.f20c = this.f18a;
        this.f24g = false;
        this.f21d = null;
        this.f22e = null;
        this.f20c = null;
    }

    private void m13f() {
        int i = -99;
        int i2 = 0;
        int i3 = 0;
        for (int i4 = 0; i4 < 3; i4++) {
            int i5 = 0;
            while (i5 < 3) {
                int h;
                if (this.f23f.m8a(i4, i5) == C0006g.EMPTY) {
                    this.f23f.m10a(i4, i5, this.f20c.m29c());
                    if (this.f23f.m11a(this.f20c.m29c())) {
                        this.f21d = this.f20c;
                        this.f22e = this.f20c == this.f18a ? this.f19b : this.f18a;
                        this.f24g = true;
                        return;
                    } else if (this.f23f.m12b()) {
                        this.f24g = true;
                        return;
                    } else {
                        h = m15h();
                        if (h > i) {
                            i3 = i4;
                            i2 = i5;
                        } else {
                            h = i;
                        }
                        this.f23f.m10a(i4, i5, C0006g.EMPTY);
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
                if (this.f23f.m8a(i2, i3) == C0006g.EMPTY) {
                    this.f23f.m10a(i2, i3, this.f20c.m29c());
                    if (this.f23f.m11a(this.f20c.m29c())) {
                        this.f23f.m10a(i2, i3, C0006g.EMPTY);
                        return 1;
                    } else if (this.f23f.m12b()) {
                        this.f23f.m10a(i2, i3, C0006g.EMPTY);
                        return 0;
                    } else {
                        i = m15h();
                        if (i4 >= i) {
                            i = i4;
                        }
                        this.f23f.m10a(i2, i3, C0006g.EMPTY);
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
        C0003d c0003d = this.f20c == this.f18a ? this.f19b : this.f18a;
        int i2 = 0;
        while (i2 < 3) {
            int i3 = 0;
            int i4 = i;
            while (i3 < 3) {
                if (this.f23f.m8a(i2, i3) == C0006g.EMPTY) {
                    this.f23f.m10a(i2, i3, c0003d.m29c());
                    if (this.f23f.m11a(c0003d.m29c())) {
                        this.f23f.m10a(i2, i3, C0006g.EMPTY);
                        return -1;
                    } else if (this.f23f.m12b()) {
                        this.f23f.m10a(i2, i3, C0006g.EMPTY);
                        return 0;
                    } else {
                        i = m14g();
                        if (i4 <= i) {
                            i = i4;
                        }
                        this.f23f.m10a(i2, i3, C0006g.EMPTY);
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
        this.f23f.m9a();
        this.f20c = this.f18a;
        this.f24g = false;
        this.f21d = null;
        this.f22e = null;
        if (this.f20c.m28b()) {
            m13f();
        }
    }

    public void m17a(String str, boolean z) {
        this.f18a.m26a(str);
        this.f18a.m27a(z);
    }

    public boolean m18a(int i, int i2) {
        if (this.f20c == null || this.f24g || !this.f23f.m10a(i, i2, this.f20c.m29c())) {
            return false;
        }
        if (this.f23f.m11a(this.f20c.m29c())) {
            this.f24g = true;
            this.f21d = this.f20c;
            this.f22e = this.f20c == this.f18a ? this.f19b : this.f18a;
        } else if (this.f23f.m12b()) {
            this.f24g = true;
        } else if (this.f20c == this.f18a) {
            this.f20c = this.f19b;
        } else {
            this.f20c = this.f18a;
        }
        if (this.f20c.m28b()) {
            m13f();
        }
        return true;
    }

    public C0003d m19b() {
        return this.f21d;
    }

    public C0006g m20b(int i, int i2) {
        return this.f23f.m8a(i, i2);
    }

    public void m21b(String str, boolean z) {
        this.f19b.m26a(str);
        this.f19b.m27a(z);
    }

    public C0003d m22c() {
        return this.f22e;
    }

    public C0003d m23d() {
        return this.f20c;
    }

    public boolean m24e() {
        return this.f24g;
    }
}
