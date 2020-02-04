package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public class Class354 extends Class129
{
    protected float width;
    protected float height;
    private static final long a;
    private static final String d;
    private static final String[] llIlIlIIlI;
    
    public Class354(final float x, final float y, final float width, final float height) {
        super();
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxX = x + width;
        this.maxY = y + height;
        this.checkPoints();
    }
    
    @Override
    public final boolean contains(final float n, final float n2) {
        final int[] b = Class139.b();
        float n6;
        int n5;
        float n4;
        final int n3 = (int)(n4 = (n5 = (int)(n6 = fcmpg(n, this.getX()))));
        if (b == null) {
            if (n3 <= 0) {
                return false;
            }
            final float n7;
            n4 = (n7 = (n5 = (int)(n6 = fcmpg(n2, this.getY()))));
        }
        if (b == null) {
            if (n3 <= 0) {
                return false;
            }
            n5 = (int)(n4 = (n6 = fcmpl(n, this.maxX)));
        }
        if (b == null) {
            if (n4 >= 0) {
                return false;
            }
            n6 = (n5 = fcmpl(n2, this.maxY));
        }
        if (b == null) {
            if (n5 >= 0) {
                return false;
            }
            n6 = 1;
        }
        return n6 != 0.0f;
    }
    
    private void setBounds(final Class354 class354) {
        this.setBounds(class354.getX(), class354.getY(), class354.getWidth(), class354.getHeight());
    }
    
    public final void setBounds(final float x, final float y, final float n, final float n2) {
        this.setX(x);
        this.setY(y);
        this.setSize(n, n2);
    }
    
    private void setSize(final float width, final float height) {
        this.setWidth(width);
        this.setHeight(height);
    }
    
    @Override
    public float getWidth() {
        return this.width;
    }
    
    @Override
    public float getHeight() {
        return this.height;
    }
    
    private void grow(final float n, final float n2) {
        this.setX(this.getX() - n);
        this.setY(this.getY() - n2);
        this.setWidth(this.getWidth() + n * 2.0f);
        this.setHeight(this.getHeight() + n2 * 2.0f);
    }
    
    private void scaleGrow(final float n, float n2) {
        final float n3 = this.getWidth() * (n - 1.0f);
        final float n4 = this.getHeight() * (n2 - 1.0f);
        n2 = n3;
        this.setX(this.getX() - n2);
        this.setY(this.getY() - n4);
        this.setWidth(this.getWidth() + n2 * 2.0f);
        this.setHeight(this.getHeight() + n4 * 2.0f);
    }
    
    public void setWidth(final float width) {
        if (Class139.b() == null) {
            if (width == this.width) {
                return;
            }
            this.pointsDirty = true;
            this.width = width;
        }
        this.maxX = this.x + width;
    }
    
    public void setHeight(final float height) {
        if (Class139.b() == null) {
            if (height == this.height) {
                return;
            }
            this.pointsDirty = true;
            this.height = height;
        }
        this.maxY = this.y + height;
    }
    
    @Override
    public final boolean intersects(final Class129 class129) {
        final int[] b = Class139.b();
        boolean intersects;
        final boolean b2 = intersects = (class129 instanceof Class354);
        if (b == null) {
            if (b2) {
                final Class354 class130 = (Class354)class129;
                final float n = fcmpl(this.x, class130.x + class130.width);
                if (b == null && n <= 0) {
                    float n3;
                    final float n2 = n3 = fcmpg(this.x + this.width, class130.x);
                    if (b == null) {
                        if (n2 < 0) {
                            goto Label_0078;
                        }
                        final int n4;
                        n3 = (n4 = fcmpl(this.y, class130.y + class130.height));
                    }
                    if (b == null) {
                        if (n2 <= 0) {
                            final float n5 = fcmpg(this.y + this.height, class130.y);
                            if (b != null || n5 >= 0) {
                                return n5 != 0.0f;
                            }
                        }
                        n3 = 0;
                    }
                    return n3 != 0.0f;
                }
                return n != 0.0f;
            }
            else {
                final boolean b3;
                intersects = (b3 = (class129 instanceof Class43));
            }
        }
        if (b == null) {
            if (b2) {
                return ((Class43)class129).intersects((Class129)this);
            }
            intersects = super.intersects(class129);
        }
        return intersects;
    }
    
    @Override
    protected void createPoints() {
        final float width = this.width;
        final float height = this.height;
        (this.points = new float[8])[0] = this.x;
        this.points[1] = this.y;
        this.points[2] = this.x + width;
        this.points[3] = this.y;
        this.points[4] = this.x + width;
        this.points[5] = this.y + height;
        this.points[6] = this.x;
        this.points[7] = this.y + height;
        this.maxX = this.points[2];
        this.maxY = this.points[5];
        this.minX = this.points[0];
        this.minY = this.points[1];
        this.findCenter();
        this.calculateRadius();
    }
    
    private boolean intersects(final Class43 class43) {
        return class43.intersects((Class129)this);
    }
    
    @Override
    public String toString() {
        return String.valueOf(new StringBuilder("[Rectangle ").append(this.width).append(Class354.llIlIlIIlI[0]).append(this.height).append(Class354.llIlIlIIlI[1]));
    }
    
    private static boolean contains(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        final int[] b = Class139.b();
        float n10;
        int n9;
        float n8;
        final int n7 = (int)(n8 = (n9 = (int)(n10 = fcmpl(n, n3))));
        if (b == null) {
            if (n7 < 0) {
                return false;
            }
            final float n11;
            n8 = (n11 = (n9 = (int)(n10 = fcmpl(n2, n4))));
        }
        if (b == null) {
            if (n7 < 0) {
                return false;
            }
            n9 = (int)(n8 = (n10 = fcmpg(n, n3 + n5)));
        }
        if (b == null) {
            if (n8 > 0) {
                return false;
            }
            n10 = (n9 = fcmpg(n2, n4 + n6));
        }
        if (b == null) {
            if (n9 > 0) {
                return false;
            }
            n10 = 1;
        }
        return n10 != 0.0f;
    }
    
    @Override
    public Class129 transform(final Class24 class24) {
        this.checkPoints();
        final Class140 class25 = new Class140();
        final float[] points = new float[this.points.length];
        class24.transform$3b3ff12(this.points, points, this.points.length / 2);
        class25.points = points;
        class25.findCenter();
        class25.checkPoints();
        return class25;
    }
    
    static {
        lIIllIIllIll();
        Class169.a(-7075808299999745221L, 1375473081291116956L, MethodHandles.lookup().lookupClass()).a(244476385133394L);
        final Cipher instance = Cipher.getInstance(Class354.llIlIlIIlI[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class354.llIlIlIIlI[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(5729860824051L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class354.llIlIlIIlI[4].getBytes(Class354.llIlIlIIlI[5]))).intern();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static String a(final byte[] array) {
        int n = 0;
        final int length;
        final char[] array2 = new char[length = array.length];
        for (int i = 0; i < length; ++i) {
            final int n2;
            if ((n2 = (0xFF & array[i])) < 192) {
                array2[n++] = (char)n2;
            }
            else if (n2 < 224) {
                array2[n++] = (char)((char)((char)(n2 & 0x1F) << 6) | (char)(array[++i] & 0x3F));
            }
            else if (i < length - 2) {
                array2[n++] = (char)((char)((char)((char)(n2 & 0xF) << 12) | (char)(array[++i] & 0x3F) << 6) | (char)(array[++i] & 0x3F));
            }
        }
        return new String(array2, 0, n);
    }
    
    private static void lIIllIIllIll() {
        (llIlIlIIlI = new String[6])[0] = "x";
        Class354.llIlIlIIlI[1] = "]";
        Class354.llIlIlIIlI[2] = "DES/CBC/PKCS5Padding";
        Class354.llIlIlIIlI[3] = "DES";
        Class354.llIlIlIIlI[4] = "6\u0015h\u008da'¸øÏ\u0016\u0093ÿ¿(^\u0015";
        Class354.llIlIlIIlI[5] = "ISO-8859-1";
    }
    
    private static String lIIllIIllIII(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("Blowfish")).init(2, new SecretKeySpec(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), "Blowfish"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String lIIllIIllIlI(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("DES")).init(2, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), 8), "DES"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String lIIllIIllIIl(String s, final String s2) {
        s = new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        final StringBuilder sb = new StringBuilder();
        final char[] charArray = s2.toCharArray();
        int n = 0;
        char[] charArray2;
        for (int length = (charArray2 = s.toCharArray()).length, i = 0; i < length; ++i) {
            sb.append((char)(charArray2[i] ^ charArray[n % charArray.length]));
            ++n;
        }
        return String.valueOf(sb);
    }
    
    private static boolean lIIllIlIlIlI(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIllIllIIII(final int n) {
        return n < 0;
    }
    
    private static boolean lIIllIlIlIIl(final int n) {
        return n <= 0;
    }
    
    private static int lIIllIlIIlll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIllIlIIllI(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIIllIlIlIll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIllIlIllIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIllIlIlllI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIllIlIllll(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIIllIllIIlI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIllIllIIll(final float n, final float n2) {
        return fcmpg(n, n2);
    }
}
