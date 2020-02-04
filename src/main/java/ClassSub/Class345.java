package ClassSub;

import cn.Hanabi.command.*;
import org.jetbrains.annotations.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class345 extends Command
{
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIlIllI;
    
    public Class345() {
        super("wdr", new String[] { Class345.lIlIllI[0] });
    }
    
    @Override
    public final void run(final String s, @NotNull final String[] array) {
        if (Class139.b() == null) {
            if (array.length <= 0) {
                throw new Class109(String.valueOf(new StringBuilder("Usage: .").append(s).append(" player")));
            }
            Class333.tellPlayer("§b[Hanabi]§a暂时停用。");
        }
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
    
    static {
        lllllIIl();
        Class169.a(-7999614721224667227L, 3088536077400971023L, MethodHandles.lookup().lookupClass()).a(69085813019253L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class345.lIlIllI[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class345.lIlIllI[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(21545793660243L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = Class345.lIlIllI[3]).length();
        int n4 = 24;
        int n5 = -1;
    Label_0151:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class345.lIlIllI[5]))).intern();
                    switch (n7) {
                        default: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0151;
                            }
                            n3 = (s = Class345.lIlIllI[4]).length();
                            n4 = 16;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0151;
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
        d = d2;
        e = new String[4];
    }
    
    private static Class109 a(final Class109 class109) {
        return class109;
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
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5F20;
        if (Class345.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class345.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class345.lIlIllI[6]);
                    array[1] = SecretKeyFactory.getInstance(Class345.lIlIllI[7]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class345.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class345.lIlIllI[8], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class345.e[n3] = a(((Cipher)array[0]).doFinal(Class345.d[n3].getBytes(Class345.lIlIllI[9])));
        }
        return Class345.e[n3];
    }
    
    private static void lllllIIl() {
        (lIlIllI = new String[13])[0] = "w";
        Class345.lIlIllI[1] = "DES/CBC/PKCS5Padding";
        Class345.lIlIllI[2] = "DES";
        Class345.lIlIllI[3] = "\u0084\u000f\u001arÆH¢¦µÚ©¦:ñ\u0081\u009dÙ\u0091íc_Ndt\u0010*¢Iåò\u0088\u0003\u007f\u008c\u0085Y4gº\u0014Ä";
        Class345.lIlIllI[4] = "KuwdeÇÚ\u0083\"äTA\\ãmN0ì\u0015Ê®\u0092\u009e¶RgN*ÿ\u0014O\u0014ºb1OÅE©0\u0092ÕK¥À\u009cÆI<ø\u0017G\u0011\n\u0014»\u0018ÕK\u000eÑ\u0004JU¤";
        Class345.lIlIllI[5] = "ISO-8859-1";
        Class345.lIlIllI[6] = "DES/CBC/PKCS5Padding";
        Class345.lIlIllI[7] = "DES";
        Class345.lIlIllI[8] = "还狼狈为奸啊你在我眼里就是一块废材什么都不要说了走之前记住了孩子我是你永远不可战胜的神话哦你所谓的大手不过造谣而出你看看你的语言质量你的眼神对我来怎么就好象是扭曲感NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200d \u200f ";
        Class345.lIlIllI[9] = "ISO-8859-1";
        Class345.lIlIllI[10] = "还狼狈为奸啊你在我眼里就是一块废材什么都不要说了走之前记住了孩子我是你永远不可战胜的神话哦你所谓的大手不过造谣而出你看看你的语言质量你的眼神对我来怎么就好象是扭曲感NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200d \u200f ";
        Class345.lIlIllI[11] = " : ";
        Class345.lIlIllI[12] = " : ";
    }
    
    private static String llllIIlI(final String s, final String s2) {
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
    
    private static String llllIIIl(String s, final String s2) {
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
    
    private static String llllIlII(final String s, final String s2) {
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
}
