package cn.Hanabi.modules.Combat;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Reach extends Mod
{
    private long lastAttack;
    private Class220 timer;
    private static Value<Double> reach;
    private Value<Boolean> combo;
    private Random rand;
    private double currentRange;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIlllIIlIlI;
    
    public Reach() {
        super("Reach", Category.COMBAT);
        new Class220();
        new Value("Reach_ComboMode", Boolean.FALSE);
        new Random();
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        this.setDisplayName(String.valueOf(new StringBuilder("Range:").append(Reach.reach.value)));
    }
    
    public static double getReach() {
        final int[] b = Class139.b();
        Double n;
        final Mod mod = (Mod)(n = (Double)Class4.getModule("Reach"));
        if (b == null) {
            if (!mod.state) {
                return 3.0;
            }
            n = Reach.reach.value;
        }
        return (float)(Object)n;
    }
    
    static {
        lIIIIIIIIllIl();
        Class169.a(-7880105961702944563L, 3219226048286298617L, MethodHandles.lookup().lookupClass()).a(142822049669634L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Reach.lIlllIIlIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Reach.lIlllIIlIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(137127244426741L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Reach.lIlllIIlIlI[2]).length();
        int n4 = 16;
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
                    final String intern = b(instance.doFinal(s3.getBytes(Reach.lIlllIIlIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Reach.lIlllIIlIlI[3]).length();
                            n4 = 32;
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
        d = new String[5];
        Reach.reach = new Value<Double>("Reach_Reach", 3.0, 3.0, 6.0, 0.1);
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x36E4;
        if (Reach.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Reach.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Reach.lIlllIIlIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(Reach.lIlllIIlIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Reach.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Reach.lIlllIIlIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Reach.d[n3] = b(((Cipher)array[0]).doFinal(Reach.c[n3].getBytes(Reach.lIlllIIlIlI[8])));
        }
        return Reach.d[n3];
    }
    
    private static void lIIIIIIIIllIl() {
        (lIlllIIlIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Reach.lIlllIIlIlI[1] = "DES";
        Reach.lIlllIIlIlI[2] = "\u00adµ-9\u009euC,ßâ¢OéÔár\u0010\u0094âÊýª\u0094pEv\u0096\fÇçÈH6\u0018¾#Ïn.µ\u0000÷ÒÕ/4UÈÛQÝÇêî\u0095\u0089Å&";
        Reach.lIlllIIlIlI[3] = "'kWç\u0007üÊA/ÿ|qÞ\u0089¹û3í68ãî9Ø~O\u00961Pû\u0011\n\u0010|ÓÈ\u009cºsüÊ\u009af{\u007f.S-5";
        Reach.lIlllIIlIlI[4] = "ISO-8859-1";
        Reach.lIlllIIlIlI[5] = "DES/CBC/PKCS5Padding";
        Reach.lIlllIIlIlI[6] = "DES";
        Reach.lIlllIIlIlI[7] = "不要再继续跳梁小丑的和我自导自演陈情烂调了垃圾狗篮子呢你干什么啊你觉得你还有什么呢你就是一个废物你懂吗就算你不相信我还是比你火1个个没实力却闪亮登场和叔叔大爷们玩着幼稚的游戏NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2009\u2005\u2004";
        Reach.lIlllIIlIlI[8] = "ISO-8859-1";
        Reach.lIlllIIlIlI[9] = "不要再继续跳梁小丑的和我自导自演陈情烂调了垃圾狗篮子呢你干什么啊你觉得你还有什么呢你就是一个废物你懂吗就算你不相信我还是比你火1个个没实力却闪亮登场和叔叔大爷们玩着幼稚的游戏NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2009\u2005\u2004";
        Reach.lIlllIIlIlI[10] = " : ";
        Reach.lIlllIIlIlI[11] = " : ";
    }
    
    private static String lIIIIIIIIIlIl(final String s, final String s2) {
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
    
    private static String lIIIIIIIIlIIl(final String s, final String s2) {
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
    
    private static String lIIIIIIIIIlII(String s, final String s2) {
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
}
