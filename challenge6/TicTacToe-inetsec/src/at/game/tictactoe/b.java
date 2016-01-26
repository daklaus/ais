package at.game.tictactoe;

import at.game.tictactoe.a;
import at.game.tictactoe.d;
import at.game.tictactoe.g;

public class b {

   private d a;
   private d b;
   private d c;
   private d d;
   private d e;
   private a f = new a();
   private boolean g;


   public b() {
      this.a = new d(g.c);
      this.b = new d(g.b);
      this.c = this.a;
      this.g = false;
      this.d = null;
      this.e = null;
      this.c = null;
   }

   private void f() {
      int var3 = -99;
      int var4 = 0;
      int var2 = 0;

      int var1;
      int var6;
      for(var1 = 0; var4 < 3; ++var4) {
         for(int var5 = 0; var5 < 3; var1 = var6) {
            if(this.f.a(var4, var5) == g.a) {
               this.f.a(var4, var5, this.c.c());
               if(this.f.a(this.c.c())) {
                  this.d = this.c;
                  d var7;
                  if(this.c == this.a) {
                     var7 = this.b;
                  } else {
                     var7 = this.a;
                  }

                  this.e = var7;
                  this.g = true;
                  return;
               }

               if(this.f.b()) {
                  this.g = true;
                  return;
               }

               var6 = this.h();
               if(var6 > var3) {
                  var2 = var5;
                  var3 = var4;
                  var1 = var6;
               } else {
                  var6 = var1;
                  var1 = var3;
                  var3 = var6;
               }

               this.f.a(var4, var5, g.a);
            } else {
               var6 = var1;
               var1 = var3;
               var3 = var6;
            }

            ++var5;
            var6 = var3;
            var3 = var1;
         }
      }

      this.a(var1, var2);
   }

   private int g() {
      int var1 = -99;
      int var2 = 0;

      while(true) {
         int var3 = var1;
         if(var2 >= 3) {
            return var3;
         }

         for(var3 = 0; var3 < 3; ++var3) {
            if(this.f.a(var2, var3) == g.a) {
               this.f.a(var2, var3, this.c.c());
               if(this.f.a(this.c.c())) {
                  this.f.a(var2, var3, g.a);
                  var3 = 1;
                  return var3;
               }

               if(this.f.b()) {
                  this.f.a(var2, var3, g.a);
                  return 0;
               }

               int var4 = this.h();
               if(var1 < var4) {
                  var1 = var4;
               }

               this.f.a(var2, var3, g.a);
            }
         }

         ++var2;
      }
   }

   private int h() {
      int var1 = 99;
      d var5;
      if(this.c == this.a) {
         var5 = this.b;
      } else {
         var5 = this.a;
      }

      for(int var2 = 0; var2 < 3; ++var2) {
         for(int var3 = 0; var3 < 3; ++var3) {
            if(this.f.a(var2, var3) == g.a) {
               this.f.a(var2, var3, var5.c());
               if(this.f.a(var5.c())) {
                  this.f.a(var2, var3, g.a);
                  return -1;
               }

               if(this.f.b()) {
                  this.f.a(var2, var3, g.a);
                  return 0;
               }

               int var4 = this.g();
               if(var1 > var4) {
                  var1 = var4;
               }

               this.f.a(var2, var3, g.a);
            }
         }
      }

      return var1;
   }

   public void a() {
      this.f.a();
      this.c = this.a;
      this.g = false;
      this.d = null;
      this.e = null;
      if(this.c.b()) {
         this.f();
      }

   }

   public void a(String var1, boolean var2) {
      this.a.a(var1);
      this.a.a(var2);
   }

   public boolean a(int var1, int var2) {
      if(this.c != null && !this.g && this.f.a(var1, var2, this.c.c())) {
         if(this.f.a(this.c.c())) {
            this.g = true;
            this.d = this.c;
            d var3;
            if(this.c == this.a) {
               var3 = this.b;
            } else {
               var3 = this.a;
            }

            this.e = var3;
         } else if(this.f.b()) {
            this.g = true;
         } else if(this.c == this.a) {
            this.c = this.b;
         } else {
            this.c = this.a;
         }

         if(this.c.b()) {
            this.f();
         }

         return true;
      } else {
         return false;
      }
   }

   public d b() {
      return this.d;
   }

   public g b(int var1, int var2) {
      return this.f.a(var1, var2);
   }

   public void b(String var1, boolean var2) {
      this.b.a(var1);
      this.b.a(var2);
   }

   public d c() {
      return this.e;
   }

   public d d() {
      return this.c;
   }

   public boolean e() {
      return this.g;
   }
}
