package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class217 extends Class129
{
    private ArrayList shapes;
    private float offset;
    private Class129 current;
    private Class129 next;
    private static final long a;
    private static final String b;
    private static final String[] lllIIIlllI;
    
    private Class217(final Class129 class129) {
        super();
        (this.shapes = new ArrayList()).add(class129);
        this.points = new float[class129.points.length];
        this.current = class129;
        this.next = class129;
    }
    
    private void addShape(final Class129 class129) {
        final int[] b = Class139.b();
        Object o;
        final float[] array = (float[])(o = class129.points);
        if (b == null) {
            if (array.length != this.points.length) {
                throw new RuntimeException("Attempt to morph between two shapes with different vertex counts");
            }
            o = this.shapes.get(this.shapes.size() - 1);
        }
        final Class129 class130;
        final boolean equalShapes = equalShapes(class130 = (Class129)o, class129);
        Label_0093: {
            if (b == null) {
                if (equalShapes) {
                    this.shapes.add(class130);
                    if (b == null) {
                        break Label_0093;
                    }
                }
                this.shapes.add(class129);
            }
        }
        Class217 class131 = this;
        if (b == null) {
            if (this.shapes.size() != 2) {
                return;
            }
            class131 = this;
        }
        class131.next = this.shapes.get(1);
    }
    
    private static boolean equalShapes(final Class129 class129, final Class129 class130) {
        class129.checkPoints();
        class130.checkPoints();
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        while (i < class129.points.length) {
            final float n2;
            final float n = n2 = fcmpl(class129.points[i], class130.points[i]);
            if (array != null) {
                return n2 != 0.0f;
            }
            if (array != null || n != 0) {
                return n != 0.0f;
            }
            ++i;
            if (array != null) {
                break;
            }
        }
        float n2 = true ? 1 : 0;
        return n2 != 0.0f;
    }
    
    private void setMorphTime(float n) {
        final int n3;
        final int n2 = (n3 = (int)n) + 1;
        n -= n3;
        this.setFrame(this.rational(n3), this.rational(n2), n);
    }
    
    private void updateMorphTime(final float n) {
        final int[] b = Class139.b();
        this.offset += n;
        final int[] array = b;
        final float n2 = fcmpg(this.offset, 0.0f);
        Class217 class217 = null;
        Label_0181: {
            if (array == null) {
                if (n2 < 0) {
                    int n5;
                    int n4;
                    final int n3 = n4 = (n5 = this.shapes.indexOf(this.current));
                    if (array == null) {
                        if (n3 < 0) {
                            n4 = this.shapes.size() - 1;
                        }
                        n5 = this.rational(n4 + 1);
                    }
                    this.setFrame(n4, n5, this.offset);
                    ++this.offset;
                    if (array == null) {
                        return;
                    }
                }
                class217 = this;
                if (array != null) {
                    break Label_0181;
                }
                final float n6 = fcmpl(this.offset, 1.0f);
            }
            if (n2 > 0) {
                int n9;
                int n8;
                final int n7 = n8 = (n9 = this.shapes.indexOf(this.next));
                if (array == null) {
                    if (n7 <= 0) {
                        n8 = 0;
                    }
                    n9 = this.rational(n8 + 1);
                }
                this.setFrame(n8, n9, this.offset);
                --this.offset;
                if (array == null) {
                    return;
                }
            }
            class217 = this;
        }
        class217.pointsDirty = true;
    }
    
    private void setExternalFrame(final Class129 current) {
        this.current = current;
        this.next = this.shapes.get(0);
        this.offset = 0.0f;
    }
    
    private int rational(int i) {
        final int[] b = Class139.b();
        int n = 0;
        while (lIlIIlIIllII(i, this.shapes.size())) {
            i -= this.shapes.size();
            if (b != null) {
                return n;
            }
            if (b != null) {
                break;
            }
        }
        while (i < 0) {
            n = i + this.shapes.size();
            if (b != null) {
                break;
            }
            i = n;
            if (b != null) {
                break;
            }
        }
        return n;
    }
    
    private void setFrame(final int n, final int n2, final float offset) {
        this.current = this.shapes.get(n);
        this.next = this.shapes.get(n2);
        this.offset = offset;
        this.pointsDirty = true;
    }
    
    @Override
    protected final void createPoints() {
        final int[] b = Class139.b();
        final Class129 current = this.current;
        if (b == null) {
            if (current == this.next) {
                System.arraycopy(this.current.points, 0, this.points, 0, this.points.length);
                return;
            }
            final Class129 current2 = this.current;
        }
        final float[] points = current.points;
        final float[] points2 = this.next.points;
        int i = 0;
        while (i < this.points.length) {
            this.points[i] = points[i] * (1.0f - this.offset);
            final float[] points3 = this.points;
            final int n = i;
            points3[n] += points2[i] * this.offset;
            ++i;
            if (b != null) {
                break;
            }
        }
    }
    
    @Override
    public final Class129 transform(final Class24 class24) {
        this.createPoints();
        return new Class140(this.points);
    }
    
    static {
        lIlIIIlllIIl();
        Class169.a(-4049540825594961075L, 436801426102563159L, MethodHandles.lookup().lookupClass()).a(254264885077851L);
        final Cipher instance = Cipher.getInstance(Class217.lllIIIlllI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class217.lllIIIlllI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(31620256058110L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class217.lllIIIlllI[2].getBytes(Class217.lllIIIlllI[3]))).intern();
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
    
    private static void lIlIIIlllIIl() {
        (lllIIIlllI = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class217.lllIIIlllI[1] = "DES";
        Class217.lllIIIlllI[2] = "gß2S\u008a\u001bòÀK\fÂ´Tvv#\u009b\u009bìH\\\u0089Þ]¨LÕ\u008d\u0003ã×S>\u0015EÜ\u000f\u000fp\u0090\u008aÌöïÁ\u009f·ÇêZ¶/´21ÈÖ¯\"É\u0082:Ñ\u0089\u0083\u009a\u008d\u008dy4?1";
        Class217.lllIIIlllI[3] = "ISO-8859-1";
    }
    
    private static String lIlIIIllIIlI(final String s, final String s2) {
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
    
    private static String lIlIIIllIlIl(final String s, final String s2) {
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
    
    private static boolean lIlIIlIIllII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIlIIlIIllIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIlIIlIIlIIl(final int n) {
        return n < 0;
    }
    
    private static boolean lIlIIlIIlIll(final int n) {
        return n > 0;
    }
    
    private static boolean lIlIIlIIIIIl(final int n, final int n2) {
        return n != n2;
    }
    
    private static int lIlIIlIIIlIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIlIIlIIlIII$2548a28(final float n) {
        return fcmpl(n, 1.0f);
    }
    
    private static int lIlIIlIIIlll$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
}
