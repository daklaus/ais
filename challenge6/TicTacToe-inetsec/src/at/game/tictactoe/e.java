package at.game.tictactoe;

import at.game.tictactoe.f;
import at.game.tictactoe.g;

public class e {

   private f[] a = new f[3];


   public e(f var1, f var2, f var3) {
      this.a[0] = var1;
      this.a[1] = var2;
      this.a[2] = var3;
   }

   public boolean a(g var1) {
      return this.a[0].a() == var1 && this.a[1].a() == var1 && this.a[2].a() == var1;
   }
}
