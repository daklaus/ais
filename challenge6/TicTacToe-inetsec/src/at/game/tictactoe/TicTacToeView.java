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

public class TicTacToeView extends View {

   protected static final char[] hexChars = "0123456789ABCDEF".toCharArray();
   private Paint b = new Paint();
   private Paint c = new Paint();
   private Paint textPaint = new Paint();
   private b e = new b();
   private int textWidth = 640;
   private int g = 480;
   private int cellSize = 140;
   private int i;
   private int textHeight;
   private int k;
   private int l;
   private String message;
   private int textSize;


   public TicTacToeView(Context context) {
      super(context);
      this.i = (this.textWidth - this.cellSize * 3) / 2;
      this.textHeight = (this.g - this.cellSize * 3) / 2;
      this.k = 10;
      this.l = 10;
      this.message = "To start a new game press the New Game Button";
      this.textSize = 20;
      this.a();
   }

   public TicTacToeView(Context context, AttributeSet var2) {
      super(context, var2);
      this.i = (this.textWidth - this.cellSize * 3) / 2;
      this.textHeight = (this.g - this.cellSize * 3) / 2;
      this.k = 10;
      this.l = 10;
      this.message = "To start a new game press the New Game Button";
      this.textSize = 20;
      this.a();
   }

   public TicTacToeView(Context context, AttributeSet var2, int var3) {
      super(context, var2, var3);
      this.i = (this.textWidth - this.cellSize * 3) / 2;
      this.textHeight = (this.g - this.cellSize * 3) / 2;
      this.k = 10;
      this.l = 10;
      this.message = "To start a new game press the New Game Button";
      this.textSize = 20;
      this.a();
   }

   private void a() {
      this.c.setStrokeWidth((float)this.l);
      this.c.setStyle(Style.STROKE);
      this.textPaint.setTextAlign(Align.CENTER);
      this.textPaint.setTypeface(Typeface.SANS_SERIF);
      this.textPaint.setTextSize((float)this.textSize);
   }

   private void setXMark(Canvas canvas, int var2, int var3) {
      int var4 = this.i + this.cellSize * var2 + this.k;
      var2 = this.i + (var2 + 1) * this.cellSize - this.k;
      int var5 = this.textHeight + this.cellSize * var3 + this.k;
      var3 = this.textHeight + (var3 + 1) * this.cellSize - this.k;
      canvas.drawLine((float)var4, (float)var5, (float)var2, (float)var3, this.c);
      canvas.drawLine((float)var2, (float)var5, (float)var4, (float)var3, this.c);
   }

   public static byte[] a(String var0) {
      int var2 = var0.length();
      byte[] var3 = new byte[var2 / 2];

      for(int var1 = 0; var1 < var2; var1 += 2) {
         var3[var1 / 2] = (byte)((Character.digit(var0.charAt(var1), 16) << 4) + Character.digit(var0.charAt(var1 + 1), 16));
      }

      return var3;
   }

   public static String b(String input) {
      StringBuilder stringBuilder = new StringBuilder();

      for(int i = 0; i < input.length(); ++i) {
         char currChar = input.charAt(i);
         char var1;
         if(currChar >= 97 && currChar <= 109) {
            var1 = (char)(currChar + 13);
         } else if(currChar >= 65 && currChar <= 77) {
            var1 = (char)(currChar + 13);
         } else if(currChar >= 110 && currChar <= 122) {
            var1 = (char)(currChar - 13);
         } else {
            var1 = currChar;
            if(currChar >= 78) {
               var1 = currChar;
               if(currChar <= 90) {
                  var1 = (char)(currChar - 13);
               }
            }
         }

         stringBuilder.append(var1);
      }

      return stringBuilder.toString();
   }

   private void b() {
      // $FF: Couldn't be decompiled
   }

   private void setOMark(Canvas var1, int var2, int var3) {
      var2 = this.i + this.cellSize * var2 + this.k;
      var3 = this.textHeight + this.cellSize * var3 + this.k;
      int var4 = this.cellSize - this.k * 2;
      var1.drawOval(new RectF((float)var2, (float)var3, (float)(var2 + var4), (float)(var3 + var4)), this.c);
   }

   public void a(float x, float y) {
      if(x > (float)this.i && x < (float)(this.i + this.cellSize * 3) && y > (float)this.textHeight && y < (float)(this.textHeight + this.cellSize * 3)) {
         int var3 = (int)((x - (float)this.i) / (float)this.cellSize);
         int var4 = (int)((y - (float)this.textHeight) / (float)this.cellSize);
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

   public void onDraw(Canvas canvas) {
      super.onDraw(canvas);
      canvas.drawARGB(255, 255, 255, 255);
      this.b.setColor(0xff000000);
      canvas.drawText(this.message, (float)(this.textWidth / 2), (float)(this.textHeight / 2), this.textPaint);
      canvas.drawLine((float)(this.i + this.cellSize), (float)this.textHeight, (float)(this.i + this.cellSize), (float)(this.textHeight + this.cellSize * 3), this.b);
      canvas.drawLine((float)(this.i + this.cellSize * 2), (float)this.textHeight, (float)(this.i + this.cellSize * 2), (float)(this.textHeight + this.cellSize * 3), this.b);
      canvas.drawLine((float)this.i, (float)(this.textHeight + this.cellSize), (float)(this.i + this.cellSize * 3), (float)(this.textHeight + this.cellSize), this.b);
      canvas.drawLine((float)this.i, (float)(this.textHeight + this.cellSize * 2), (float)(this.i + this.cellSize * 3), (float)(this.textHeight + this.cellSize * 2), this.b);

      for(int var2 = 0; var2 < 3; ++var2) {
         for(int var3 = 0; var3 < 3; ++var3) {
            switch(cellSize.a[this.e.b(var2, var3).ordinal()]) {
            case 1:
               this.setXMark(canvas, var2, var3);
               break;
            case 2:
               this.setOMark(canvas, var2, var3);
            }
         }
      }

   }

   public void onSizeChanged(int var1, int var2, int var3, int var4) {
      this.textWidth = var1;
      this.g = var2;
      this.i = (this.textWidth - this.cellSize * 3) / 2;
      this.textHeight = (this.g - this.cellSize * 3) / 2;
      super.onSizeChanged(var1, var2, var3, var4);
   }

   public boolean performClick() {
      super.performClick();
      return true;
   }
}
