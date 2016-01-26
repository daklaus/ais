package at.game.tictactoe;

public class a {

   private f[][] a = new f[3][];
   private e[] b;


   public a() {
      for(int var1 = 0; var1 < 3; ++var1) {
         this.a[var1] = new f[3];

         for(int var2 = 0; var2 < 3; ++var2) {
            this.a[var1][var2] = new f();
         }
      }

      this.b = new e[8];
      this.b[0] = new e(this.a[0][0], this.a[0][1], this.a[0][2]);
      this.b[1] = new e(this.a[1][0], this.a[1][1], this.a[1][2]);
      this.b[2] = new e(this.a[2][0], this.a[2][1], this.a[2][2]);
      this.b[3] = new e(this.a[0][0], this.a[1][0], this.a[2][0]);
      this.b[4] = new e(this.a[0][1], this.a[1][1], this.a[2][1]);
      this.b[5] = new e(this.a[0][2], this.a[1][2], this.a[2][2]);
      this.b[6] = new e(this.a[0][0], this.a[1][1], this.a[2][2]);
      this.b[7] = new e(this.a[0][2], this.a[1][1], this.a[2][0]);
   }

   public CellState a(int var1, int var2) {
      return this.a[var1][var2].a();
   }

   public void a() {
      f[][] var5 = this.a;
      int var3 = var5.length;

      for(int var1 = 0; var1 < var3; ++var1) {
         f[] var6 = var5[var1];
         int var4 = var6.length;

         for(int var2 = 0; var2 < var4; ++var2) {
            var6[var2].a(CellState.EMPTY);
         }
      }

   }

   public boolean a(int var1, int var2, CellState var3) {
      if(this.a[var1][var2].a() != CellState.EMPTY && var3 != CellState.EMPTY) {
         return false;
      } else {
         this.a[var1][var2].a(var3);
         return true;
      }
   }

   public boolean a(CellState var1) {
      boolean var5 = false;
      e[] var6 = this.b;
      int var3 = var6.length;
      int var2 = 0;

      boolean var4;
      while(true) {
         var4 = var5;
         if(var2 >= var3) {
            break;
         }

         if(var6[var2].a(var1)) {
            var4 = true;
            break;
         }

         ++var2;
      }

      return var4;
   }

   public boolean b() {
      f[][] var5 = this.a;
      int var3 = var5.length;

      for(int var1 = 0; var1 < var3; ++var1) {
         f[] var6 = var5[var1];
         int var4 = var6.length;

         for(int var2 = 0; var2 < var4; ++var2) {
            if(var6[var2].a() == CellState.EMPTY) {
               return false;
            }
         }
      }

      return true;
   }
}
