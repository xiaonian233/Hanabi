package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class207 extends Class354
{
    private static int TOP_LEFT;
    private static int TOP_RIGHT;
    private static int BOTTOM_RIGHT;
    private static int BOTTOM_LEFT;
    private static int ALL;
    private static final int DEFAULT_SEGMENT_COUNT;
    private float cornerRadius;
    private int segmentCount;
    private int cornerFlags;
    private static final long b;
    private static final String e;
    private static final String[] lllllIllII;
    
    private Class207(final float n, final float n2, final float n3, final float n4, final float n5) {
        this(n, n2, n3, n4, n5, (byte)0);
    }
    
    private Class207(final float n, final float n2, final float n3, final float n4, final float n5, final byte b) {
        this(n, n2, n3, n4, n5, '\0');
    }
    
    private Class207(final float x, final float y, final float width, final float height, final float cornerRadius, final char c) {
        final int[] b = Class139.b();
        super(x, y, width, height);
        if (b == null) {
            if (cornerRadius < 0.0f) {
                throw new IllegalArgumentException("corner radius must be >= 0");
            }
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.cornerRadius = cornerRadius;
            this.segmentCount = 25;
            this.pointsDirty = true;
            this.cornerFlags = 15;
        }
    }
    
    private float getCornerRadius() {
        return this.cornerRadius;
    }
    
    private void setCornerRadius(final float cornerRadius) {
        final int[] b = Class139.b();
        final float n = fcmpl(cornerRadius, 0.0f);
        if (b == null) {
            if (n < 0) {
                return;
            }
            final float n2 = fcmpl(cornerRadius, this.cornerRadius);
        }
        if (n != 0) {
            this.cornerRadius = cornerRadius;
            this.pointsDirty = true;
        }
    }
    
    @Override
    public final float getHeight() {
        return this.height;
    }
    
    @Override
    public final void setHeight(final float height) {
        final int[] b = Class139.b();
        Class207 class207 = this;
        if (b == null) {
            if (this.height == height) {
                return;
            }
            this.height = height;
            class207 = this;
        }
        class207.pointsDirty = true;
    }
    
    @Override
    public final float getWidth() {
        return this.width;
    }
    
    @Override
    public final void setWidth(final float width) {
        if (Class139.b() == null) {
            if (width == this.width) {
                return;
            }
            this.width = width;
        }
        this.pointsDirty = true;
    }
    
    @Override
    protected final void createPoints() {
        final int[] b = Class139.b();
        this.maxX = this.x + this.width;
        this.maxY = this.y + this.height;
        this.minX = this.x;
        this.minY = this.y;
        final float n = this.width - 1.0f;
        final float n2 = this.height - 1.0f;
        final int[] array = b;
        final float cornerRadius = this.cornerRadius;
        float n3 = 0.0f;
        Label_0669: {
            if (array == null) {
                if (cornerRadius == 0.0f) {
                    (this.points = new float[8])[0] = this.x;
                    this.points[1] = this.y;
                    this.points[2] = this.x + n;
                    this.points[3] = this.y;
                    this.points[4] = this.x + n;
                    this.points[5] = this.y + n2;
                    this.points[6] = this.x;
                    this.points[7] = this.y + n2;
                    if (array == null) {
                        break Label_0669;
                    }
                }
                final float cornerRadius2 = this.cornerRadius;
                n3 = 2.0f;
            }
            float n5;
            final float n4 = fcmpl(n5 = cornerRadius * n3, n);
            Label_0247: {
                final float n6;
                Label_0237: {
                    if (array == null) {
                        if (n4 > 0) {
                            n5 = n;
                            this.cornerRadius = n / 2.0f;
                        }
                        n6 = n5;
                        if (array != null) {
                            break Label_0237;
                        }
                        final float n7 = fcmpl(n6, n2);
                    }
                    if (n4 <= 0) {
                        break Label_0247;
                    }
                }
                this.cornerRadius = n6 / 2.0f;
            }
            final ArrayList<Float> list = new ArrayList<Float>();
            final int n8 = this.cornerFlags & 0x1;
            Label_0338: {
                if (array == null) {
                    if (n8 != 0) {
                        list.addAll(createPoints(this.segmentCount, this.cornerRadius, this.x + this.cornerRadius, this.y + this.cornerRadius, 180.0f, 270.0f));
                        if (array == null) {
                            break Label_0338;
                        }
                    }
                    list.add(this.x);
                    list.add(this.y);
                }
            }
            final int n9 = this.cornerFlags & 0x2;
            Label_0429: {
                if (array == null) {
                    if (n9 != 0) {
                        list.addAll(createPoints(this.segmentCount, this.cornerRadius, this.x + n - this.cornerRadius, this.y + this.cornerRadius, 270.0f, 360.0f));
                        if (array == null) {
                            break Label_0429;
                        }
                    }
                    list.add(new Float(this.x + n));
                    list.add(this.y);
                }
            }
            final int n10 = this.cornerFlags & 0x4;
            Label_0527: {
                if (array == null) {
                    if (n10 != 0) {
                        list.addAll(createPoints(this.segmentCount, this.cornerRadius, this.x + n - this.cornerRadius, this.y + n2 - this.cornerRadius, 0.0f, 90.0f));
                        if (array == null) {
                            break Label_0527;
                        }
                    }
                    list.add(new Float(this.x + n));
                    list.add(new Float(this.y + n2));
                }
            }
            final int n11 = this.cornerFlags & 0x8;
            Label_0618: {
                if (array == null) {
                    if (n11 != 0) {
                        list.addAll(createPoints(this.segmentCount, this.cornerRadius, this.x + this.cornerRadius, this.y + n2 - this.cornerRadius, 90.0f, 180.0f));
                        if (array == null) {
                            break Label_0618;
                        }
                    }
                    list.add(this.x);
                    list.add(new Float(this.y + n2));
                }
            }
            this.points = new float[list.size()];
            int i = 0;
            while (i < list.size()) {
                this.points[i] = list.get(i);
                ++i;
                if (array != null) {
                    return;
                }
                if (array != null) {
                    break;
                }
            }
        }
        this.findCenter();
        this.calculateRadius();
    }
    
    private static List createPoints(final int n, final float n2, final float n3, final float n4, float n5, final float n6) {
        final ArrayList<Float> list = new ArrayList<Float>();
        final int[] b = Class139.b();
        final int n7 = 360 / n;
        final int[] array = b;
        while (n5 <= n6 + n7) {
            float n10;
            float n9;
            final float n8 = n9 = (n10 = n5);
            if (array == null) {
                if (n8 > n6) {
                    n9 = n6;
                }
                n10 = (float)(n3 + Class243.cos(Math.toRadians(n9)) * n2);
            }
            final float n11 = n10;
            final float n12 = (float)(n4 + Class243.sin(Math.toRadians(n9)) * n2);
            list.add(n11);
            list.add(n12);
            n5 += n7;
            if (array != null) {
                break;
            }
        }
        return list;
    }
    
    @Override
    public final Class129 transform(final Class24 class24) {
        this.checkPoints();
        final Class140 class25 = new Class140();
        final float[] points = new float[this.points.length];
        class24.transform$3b3ff12(this.points, points, this.points.length / 2);
        class25.points = points;
        class25.findCenter();
        return class25;
    }
    
    static {
        lIllIlIIllll();
        Class169.a(-3065399690562676775L, 4859436870496699424L, MethodHandles.lookup().lookupClass()).a(143203922568368L);
        final Cipher instance = Cipher.getInstance(Class207.lllllIllII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class207.lllllIllII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(118350235061629L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(Class207.lllllIllII[2].getBytes(Class207.lllllIllII[3]))).intern();
    }
    
    private static IllegalArgumentException a(final IllegalArgumentException ex) {
        return ex;
    }
    
    private static String b(final byte[] array) {
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
    
    private static void lIllIlIIllll() {
        (lllllIllII = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class207.lllllIllII[1] = "DES";
        Class207.lllllIllII[2] = "ñ\u009d*ÎKÚart\u0004±WI#]\u0000\u000eH\fÃ¡Ë\u0005@Íx©² f¢A";
        Class207.lllllIllII[3] = "ISO-8859-1";
    }
    
    private static String lIllIlIIllII(final String s, final String s2) {
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
    
    private static String lIllIlIIlIlI(final String s, final String s2) {
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
    
    private static String lIllIlIIlIll(String s, final String s2) {
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
    
    private static boolean lIllIlIllIIl(final int n) {
        return n >= 0;
    }
    
    private static boolean lIllIlIlIlll(final int n) {
        return n < 0;
    }
    
    private static boolean lIllIllIIlIl(final int n) {
        return n <= 0;
    }
    
    private static boolean lIllIllIIIII(final int n) {
        return n > 0;
    }
    
    private static int lIllIlIlIlIl$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
    
    private static int lIllIlIllIII(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllIlIllIll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllIlIlllII(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllIlIlllIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllIllIIlII(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllIllIIIll(final float n, final float n2) {
        return fcmpg(n, n2);
    }
}
