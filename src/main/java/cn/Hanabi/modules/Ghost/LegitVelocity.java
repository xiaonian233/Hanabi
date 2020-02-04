package cn.Hanabi.modules.Ghost;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.entity.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class LegitVelocity extends Mod
{
    private Value<Double> chance;
    private Value<Double> verti;
    private Value<Double> hori;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIlllIlIll;
    
    public LegitVelocity() {
        super("LegitVelocity", Category.GHOST);
        this.chance = new Value<Double>("LegitVelocity_Chance", 100.0, 0.0, 100.0, 1.0);
        this.verti = new Value<Double>("LegitVelocity_Vertical", 100.0, 0.0, 100.0, 1.0);
        this.hori = new Value<Double>("LegitVelocity_Horizontal", 100.0, 0.0, 100.0, 1.0);
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        final int field_70771_an = LegitVelocity.mc.field_71439_g.field_70771_an;
        if (b == null) {
            if (field_70771_an != LegitVelocity.mc.field_71439_g.field_70172_ad) {
                return;
            }
            final int field_70771_an2 = LegitVelocity.mc.field_71439_g.field_70771_an;
        }
        if (field_70771_an != 0) {
            final Double value = Math.random() * 100.0;
            if (b == null) {
                if (value < (int)(Object)this.chance.value) {
                    final float n = (float)(Object)this.hori.value / 100.0f;
                    final float n2 = (float)(Object)this.verti.value / 100.0f;
                    final EntityPlayerSP field_71439_g = LegitVelocity.mc.field_71439_g;
                    field_71439_g.field_70159_w *= n;
                    final EntityPlayerSP field_71439_g2 = LegitVelocity.mc.field_71439_g;
                    field_71439_g2.field_70179_y *= n;
                    final EntityPlayerSP field_71439_g3 = LegitVelocity.mc.field_71439_g;
                    field_71439_g3.field_70181_x *= n2;
                    if (b == null) {
                        return;
                    }
                }
                final EntityPlayerSP field_71439_g4 = LegitVelocity.mc.field_71439_g;
                field_71439_g4.field_70159_w = field_71439_g4.field_70159_w;
                final EntityPlayerSP field_71439_g5 = LegitVelocity.mc.field_71439_g;
                field_71439_g5.field_70181_x = field_71439_g5.field_70181_x;
            }
            final EntityPlayerSP field_71439_g6 = LegitVelocity.mc.field_71439_g;
            field_71439_g6.field_70179_y = field_71439_g6.field_70179_y;
        }
    }
    
    static {
        lIIIlIIllllI();
        Class169.a(1758621052431799541L, 2315942624726400701L, MethodHandles.lookup().lookupClass()).a(278329930363290L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(LegitVelocity.lIlllIlIll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(LegitVelocity.lIlllIlIll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(48454838474561L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = LegitVelocity.lIlllIlIll[2]).length();
        int n4 = 56;
        int n5 = -1;
    Label_0150:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s3.getBytes(LegitVelocity.lIlllIlIll[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = LegitVelocity.lIlllIlIll[3]).length();
                            n4 = 40;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0150;
                        }
                    }
                    ++n5;
                    final String s4 = s;
                    final int n8 = n5;
                    s3 = s4.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        c = c2;
        d = new String[4];
    }
    
    private static RuntimeException a(final RuntimeException ex) {
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
    
    private static String b(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7588;
        if (LegitVelocity.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = LegitVelocity.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(LegitVelocity.lIlllIlIll[5]);
                    array[1] = SecretKeyFactory.getInstance(LegitVelocity.lIlllIlIll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    LegitVelocity.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(LegitVelocity.lIlllIlIll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            LegitVelocity.d[n3] = b(((Cipher)array[0]).doFinal(LegitVelocity.c[n3].getBytes(LegitVelocity.lIlllIlIll[8])));
        }
        return LegitVelocity.d[n3];
    }
    
    private static void lIIIlIIllllI() {
        (lIlllIlIll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        LegitVelocity.lIlllIlIll[1] = "DES";
        LegitVelocity.lIlllIlIll[2] = "øðé¬d\u001dË\u0084\u0003\u000bÑb\u0013mxo\u0010r\u0089²üÞt\u0097(\u009b\u0095\u000eûKë©!³\\}p\u0080x\u0010&')\u000e¥iAè!7å\u0097w¾\u0017?($s\u008e\u0099ójg\u0088\u00adOüJH\u0006\u00ad\u0004\u0092ô£Ponlÿ0Ú©èC8\u000eÀáÖ¹\u001f»kÌ\u0010";
        LegitVelocity.lIlllIlIll[3] = "\u0099;B «¥\\\u007f/\u008e\u001b\u0099 \u0014r\u008cz\u009b=ð\u0005\u001d½é\u009f§ÒÂ\u0003ÿ4R\u000e5K3Î©\u0002\u0091 §}`¾b\u0091Õðp\u000f\u0000~\u0090l;ãA×û\u0081×\u0014D\u001eðL1\rs\\Òâ";
        LegitVelocity.lIlllIlIll[4] = "ISO-8859-1";
        LegitVelocity.lIlllIlIll[5] = "DES/CBC/PKCS5Padding";
        LegitVelocity.lIlllIlIll[6] = "DES";
        LegitVelocity.lIlllIlIll[7] = "你是不是煤山挖煤的替补队员你开始向我摇尾乞怜让我高抬贵手了废物二卡子自以为天塌不败的速度但是我在你眼里永远都是神圣而不可侵犯的不要在那里说什么我装BNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u200e\u2004\u200e";
        LegitVelocity.lIlllIlIll[8] = "ISO-8859-1";
        LegitVelocity.lIlllIlIll[9] = "你是不是煤山挖煤的替补队员你开始向我摇尾乞怜让我高抬贵手了废物二卡子自以为天塌不败的速度但是我在你眼里永远都是神圣而不可侵犯的不要在那里说什么我装BNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u200e\u2004\u200e";
        LegitVelocity.lIlllIlIll[10] = " : ";
        LegitVelocity.lIlllIlIll[11] = " : ";
    }
    
    private static String lIIIlIIllIll(String s, final String s2) {
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
    
    private static String lIIIlIIlllIl(final String s, final String s2) {
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
    
    private static String lIIIlIIlllII(final String s, final String s2) {
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
    
    private static boolean lIIIlIlIIlII(final int n) {
        return n < 0;
    }
    
    private static int lIIIlIIlllll(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
