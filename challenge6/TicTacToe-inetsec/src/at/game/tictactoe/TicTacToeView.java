package at.game.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import at.game.tictactoe.b;
import at.game.tictactoe.h;

public class TicTacToeView extends View {

   protected static final char[] a = "0123456789ABCDEF".toCharArray();
   private Paint b = new Paint();
   private Paint c = new Paint();
   private Paint d = new Paint();
   private b e = new b();
   private int f = 640;
   private int g = 480;
   private int h = 140;
   private int i;
   private int j;
   private int k;
   private int l;
   private String m;
   private int n;


   public TicTacToeView(Context var1) {
      super(var1);
      this.i = (this.f - this.h * 3) / 2;
      this.j = (this.g - this.h * 3) / 2;
      this.k = 10;
      this.l = 10;
      this.m = "To start a new game press the New Game Button";
      this.n = 20;
      this.a();
   }

   public TicTacToeView(Context var1, AttributeSet var2) {
      super(var1, var2);
      this.i = (this.f - this.h * 3) / 2;
      this.j = (this.g - this.h * 3) / 2;
      this.k = 10;
      this.l = 10;
      this.m = "To start a new game press the New Game Button";
      this.n = 20;
      this.a();
   }

   public TicTacToeView(Context var1, AttributeSet var2, int var3) {
      super(var1, var2, var3);
      this.i = (this.f - this.h * 3) / 2;
      this.j = (this.g - this.h * 3) / 2;
      this.k = 10;
      this.l = 10;
      this.m = "To start a new game press the New Game Button";
      this.n = 20;
      this.a();
   }

   private void a() {
      this.c.setStrokeWidth((float)this.l);
      this.c.setStyle(Style.STROKE);
      this.d.setTextAlign(Align.CENTER);
      this.d.setTypeface(Typeface.SANS_SERIF);
      this.d.setTextSize((float)this.n);
   }

   private void a(Canvas var1, int var2, int var3) {
      int var4 = this.i + this.h * var2 + this.k;
      var2 = this.i + (var2 + 1) * this.h - this.k;
      int var5 = this.j + this.h * var3 + this.k;
      var3 = this.j + (var3 + 1) * this.h - this.k;
      var1.drawLine((float)var4, (float)var5, (float)var2, (float)var3, this.c);
      var1.drawLine((float)var2, (float)var5, (float)var4, (float)var3, this.c);
   }

   public static byte[] a(String var0) {
      int var2 = var0.length();
      byte[] var3 = new byte[var2 / 2];

      for(int var1 = 0; var1 < var2; var1 += 2) {
         var3[var1 / 2] = (byte)((Character.digit(var0.charAt(var1), 16) << 4) + Character.digit(var0.charAt(var1 + 1), 16));
      }

      return var3;
   }

   public static String b(String var0) {
      StringBuilder var4 = new StringBuilder();

      for(int var3 = 0; var3 < var0.length(); ++var3) {
         char var2 = var0.charAt(var3);
         char var1;
         if(var2 >= 97 && var2 <= 109) {
            var1 = (char)(var2 + 13);
         } else if(var2 >= 65 && var2 <= 77) {
            var1 = (char)(var2 + 13);
         } else if(var2 >= 110 && var2 <= 122) {
            var1 = (char)(var2 - 13);
         } else {
            var1 = var2;
            if(var2 >= 78) {
               var1 = var2;
               if(var2 <= 90) {
                  var1 = (char)(var2 - 13);
               }
            }
         }

         var4.append(var1);
      }

      return var4.toString();
   }

   private void b() {
      // $FF: Couldn't be decompiled
   }

   private void b(Canvas var1, int var2, int var3) {
      var2 = this.i + this.h * var2 + this.k;
      var3 = this.j + this.h * var3 + this.k;
      int var4 = this.h - this.k * 2;
      var1.drawOval(new RectF((float)var2, (float)var3, (float)(var2 + var4), (float)(var3 + var4)), this.c);
   }

   public void a(float var1, float var2) {
      if(var1 > (float)this.i && var1 < (float)(this.i + this.h * 3) && var2 > (float)this.j && var2 < (float)(this.j + this.h * 3)) {
         int var3 = (int)((var1 - (float)this.i) / (float)this.h);
         int var4 = (int)((var2 - (float)this.j) / (float)this.h);
         if(this.e.a(var3, var4)) {
            this.b();
         }
      }

   }

   public void newGame(String var1, String var2, boolean var3, boolean var4) {
      this.e.a(var1, var3);
      this.e.b(var2, var4);
      this.e.a();
      this.b();
   }

   public void onDraw(Canvas var1) {
      super.onDraw(var1);
      var1.drawARGB(255, 255, 255, 255);
      this.b.setColor(-16777216);
      var1.drawText(this.m, (float)(this.f / 2), (float)(this.j / 2), this.d);
      var1.drawLine((float)(this.i + this.h), (float)this.j, (float)(this.i + this.h), (float)(this.j + this.h * 3), this.b);
      var1.drawLine((float)(this.i + this.h * 2), (float)this.j, (float)(this.i + this.h * 2), (float)(this.j + this.h * 3), this.b);
      var1.drawLine((float)this.i, (float)(this.j + this.h), (float)(this.i + this.h * 3), (float)(this.j + this.h), this.b);
      var1.drawLine((float)this.i, (float)(this.j + this.h * 2), (float)(this.i + this.h * 3), (float)(this.j + this.h * 2), this.b);

      for(int var2 = 0; var2 < 3; ++var2) {
         for(int var3 = 0; var3 < 3; ++var3) {
            switch(h.a[this.e.b(var2, var3).ordinal()]) {
            case 1:
               this.a(var1, var2, var3);
               break;
            case 2:
               this.b(var1, var2, var3);
            }
         }
      }

   }

   public void onSizeChanged(int var1, int var2, int var3, int var4) {
      this.f = var1;
      this.g = var2;
      this.i = (this.f - this.h * 3) / 2;
      this.j = (this.g - this.h * 3) / 2;
      super.onSizeChanged(var1, var2, var3, var4);
   }

   public boolean performClick() {
      super.performClick();
      return true;
   }
}
