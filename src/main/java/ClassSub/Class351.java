package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class351 extends Class129
{
    Class176 start;
    Class176 end;
    Class176 vec;
    private float lenSquared;
    private Class176 loc;
    private Class176 v;
    private Class176 v2;
    private Class176 proj;
    Class176 closest;
    private Class176 other;
    private boolean outerEdge;
    private boolean innerEdge;
    private static final long a;
    private static final String b;
    private static final String[] lllllIIlII;
    
    private Class351(final float n, final float n2) {
        this(0.0f, 0.0f, n, n2);
    }
    
    private Class351(final float n, final float n2, final byte b) {
        this(n, n2);
    }
    
    public Class351(final float n, final float n2, final float n3, final float n4) {
        this(new Class176(n, n2), new Class176(n3, n4));
    }
    
    private Class351(final float n, final float n2, final float n3, final float n4, final byte b) {
        this(new Class176(n, n2), new Class176(n + n3, n2 + n4));
    }
    
    private Class351(float[] array, float[] array2) {
        super();
        this.loc = new Class176(0.0f, 0.0f);
        new Class176(0.0f, 0.0f);
        new Class176(0.0f, 0.0f);
        new Class176(0.0f, 0.0f);
        this.closest = new Class176(0.0f, 0.0f);
        new Class176(0.0f, 0.0f);
        final float[] array3 = array;
        array = array2;
        array2 = array3;
        this.set(array3[0], array2[1], array[0], array[1]);
    }
    
    private Class351(final Class176 class176, Class176 class177) {
        super();
        this.loc = new Class176(0.0f, 0.0f);
        new Class176(0.0f, 0.0f);
        new Class176(0.0f, 0.0f);
        new Class176(0.0f, 0.0f);
        this.closest = new Class176(0.0f, 0.0f);
        new Class176(0.0f, 0.0f);
        final Class176 class178 = class177;
        class177 = class176;
        final int[] b = Class139.b();
        super.pointsDirty = true;
        final int[] array = b;
        final Class176 start = this.start;
        if (array == null) {
            if (start == null) {
                this.start = new Class176();
            }
            this.start.set(class177);
            final Class176 end = this.end;
        }
        if (array == null) {
            if (start == null) {
                this.end = new Class176();
            }
            this.end.set(class178);
            (this.vec = new Class176(class178)).sub(class177);
        }
        this.vec.lengthSquared();
    }
    
    private void set(final float[] array, final float[] array2) {
        this.set(array[0], array[1], array2[0], array2[1]);
    }
    
    private Class176 getStart() {
        return this.start;
    }
    
    private Class176 getEnd() {
        return this.end;
    }
    
    private float length() {
        return this.vec.length();
    }
    
    private float lengthSquared() {
        return this.vec.lengthSquared();
    }
    
    private void set(final Class176 class176, final Class176 class177) {
        final int[] b = Class139.b();
        super.pointsDirty = true;
        final int[] array = b;
        final Class176 start = this.start;
        if (array == null) {
            if (start == null) {
                this.start = new Class176();
            }
            this.start.set(class176);
            final Class176 end = this.end;
        }
        if (array == null) {
            if (start == null) {
                this.end = new Class176();
            }
            this.end.set(class177);
            (this.vec = new Class176(class177)).sub(class176);
        }
        this.vec.lengthSquared();
    }
    
    public final void set(float n, float n2, final float n3, final float n4) {
        super.pointsDirty = true;
        this.start.set(n, n2);
        this.end.set(n3, n4);
        n = n3 - n;
        n2 = n4 - n2;
        this.vec.set(n, n2);
    }
    
    private float getDX() {
        return this.end.x - this.start.x;
    }
    
    private float getDY() {
        return this.end.y - this.start.y;
    }
    
    @Override
    public final float getX() {
        return this.start.x;
    }
    
    @Override
    public final float getY() {
        return this.start.y;
    }
    
    private float getX1() {
        return this.start.x;
    }
    
    private float getY1() {
        return this.start.y;
    }
    
    private float getX2() {
        return this.end.x;
    }
    
    private float getY2() {
        return this.end.y;
    }
    
    public final float distance(final Class176 class176) {
        return (float)Math.sqrt(this.distanceSquared(class176));
    }
    
    private boolean on(final Class176 class176) {
        this.getClosestPoint(class176, this.closest);
        return class176.equals(this.closest);
    }
    
    public final float distanceSquared(final Class176 class176) {
        this.getClosestPoint(class176, this.closest);
        this.closest.sub(class176);
        return this.closest.lengthSquared();
    }
    
    public final void getClosestPoint(final Class176 class176, final Class176 class177) {
        final int[] b = Class139.b();
        this.loc.set(class176);
        this.loc.sub(this.start);
        final int[] array = b;
        final float n2;
        final float n = fcmpg(n2 = this.vec.dot(this.loc) / this.vec.lengthSquared(), 0.0f);
        if (array == null) {
            if (n < 0) {
                class177.set(this.start);
                return;
            }
            final float n3 = fcmpl(n2, 1.0f);
        }
        if (n > 0) {
            class177.set(this.end);
            return;
        }
        class177.x = this.start.x + n2 * this.vec.x;
        class177.y = this.start.y + n2 * this.vec.y;
    }
    
    @Override
    public final String toString() {
        return String.valueOf(new StringBuilder("[Line ").append(this.start).append(Class351.lllllIIlII[0]).append(this.end).append(Class351.lllllIIlII[1]));
    }
    
    private Class176 intersect(final Class351 class351) {
        return this.intersect(class351, false);
    }
    
    public final Class176 intersect(final Class351 class351, final boolean b) {
        final Class176 class352 = new Class176();
        if (!this.intersect(class351, b, class352)) {
            return null;
        }
        return class352;
    }
    
    private boolean intersect(final Class351 class351, final boolean b, final Class176 class352) {
        final int[] b2 = Class139.b();
        final float n = this.end.x - this.start.x;
        final int[] array = b2;
        final float n2 = class351.end.x - class351.start.x;
        final float n3 = this.end.y - this.start.y;
        final float n7;
        float n6;
        final float n5;
        final float n4 = n5 = (n6 = (n7 = class351.end.y - class351.start.y) * n - n2 * n3);
        float n8 = 0.0f;
        if (array == null) {
            if (n4 == 0.0f) {
                return false;
            }
            n6 = n2 * (this.start.y - class351.start.y);
            n8 = n7 * (this.start.x - class351.start.x);
        }
        final float n9 = (n6 - n8) / n5;
        final float n10 = (n * (this.start.y - class351.start.y) - n3 * (this.start.x - class351.start.x)) / n5;
        Label_0274: {
            if (array == null) {
                final float n11 = n10;
                Label_0272: {
                    if (b) {
                        final float n12 = fcmpg(n9, 0.0f);
                        if (array == null) {
                            if (n12 >= 0) {
                                final float n13 = fcmpl(n9, 1.0f);
                                if (array == null) {
                                    if (n13 <= 0) {
                                        final float n14 = fcmpg(n11, 0.0f);
                                        if (array == null) {
                                            if (n14 >= 0) {
                                                final float n15 = n11;
                                                if (array != null) {
                                                    break Label_0274;
                                                }
                                                if (n15 <= 1.0f) {
                                                    break Label_0272;
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        return n12 != 0.0f;
                    }
                }
            }
        }
        final float n16 = n10;
        class352.set(this.start.x + n16 * (this.end.x - this.start.x), this.start.y + n16 * (this.end.y - this.start.y));
        return true;
    }
    
    @Override
    protected final void createPoints() {
        (this.points = new float[4])[0] = this.start.x;
        this.points[1] = this.start.y;
        this.points[2] = this.end.x;
        this.points[3] = this.end.y;
    }
    
    @Override
    public final Class129 transform(final Class24 class24) {
        final float[] array = new float[4];
        this.createPoints();
        class24.transform$3b3ff12(this.points, array, 2);
        return new Class351(array[0], array[1], array[2], array[3]);
    }
    
    @Override
    public final boolean closed() {
        return false;
    }
    
    @Override
    public final boolean intersects(final Class129 class129) {
        final int[] b = Class139.b();
        final boolean b2 = class129 instanceof Class43;
        if (b == null) {
            if (b2) {
                return class129.intersects(this);
            }
            super.intersects(class129);
        }
        return b2;
    }
    
    static {
        lIllIIllIIlI();
        Class169.a(7944914659427099814L, 8377602349836331102L, MethodHandles.lookup().lookupClass()).a(277292986176933L);
        final Cipher instance = Cipher.getInstance(Class351.lllllIIlII[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class351.lllllIIlII[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(20240029251534L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class351.lllllIIlII[4].getBytes(Class351.lllllIIlII[5]))).intern();
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
    
    private static void lIllIIllIIlI() {
        (lllllIIlII = new String[6])[0] = ",";
        Class351.lllllIIlII[1] = "]";
        Class351.lllllIIlII[2] = "DES/CBC/PKCS5Padding";
        Class351.lllllIIlII[3] = "DES";
        Class351.lllllIIlII[4] = "d\u009c²fD\u001a\"ò";
        Class351.lllllIIlII[5] = "ISO-8859-1";
    }
    
    private static String lIllIIllIIII(final String s, final String s2) {
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
    
    private static String lIllIIlIllll(final String s, final String s2) {
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
    
    private static String lIllIIllIIIl(String s, final String s2) {
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
    
    private static boolean lIllIIlllllI(final int n) {
        return n >= 0;
    }
    
    private static boolean lIllIIlllIII(final int n) {
        return n < 0;
    }
    
    private static boolean lIllIIllllll(final int n) {
        return n <= 0;
    }
    
    private static boolean lIllIIlllIIl(final int n) {
        return n > 0;
    }
    
    private static int lIllIIllIlll$2548a28(final float n) {
        return fcmpl(n, 1.0f);
    }
    
    private static int lIllIIllIllI$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
    
    private static int lIllIIlllIll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllIIllllII$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
}
