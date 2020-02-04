package ClassSub;

import cn.Hanabi.command.*;
import org.jetbrains.annotations.*;
import cn.Hanabi.modules.*;
import java.util.function.*;
import java.util.stream.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class152 extends Command
{
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIIlIllIll;
    
    public Class152() {
        super("toggle", new String[] { Class152.lIIlIllIll[0] });
    }
    
    @Override
    public final void run(final String s, @NotNull final String[] array) {
        final int[] b = Class139.b();
        String[] array2 = array;
        if (b == null) {
            if (array.length <= 0) {
                throw new Class109(String.valueOf(new StringBuilder("Usage: .").append(s).append(" <module> [<on/off>]")));
            }
            final Class139 instance = Class139.INSTANCE;
            array2 = array;
        }
        Mod module$49fab75c;
        final Mod mod2;
        final Mod mod = mod2 = (module$49fab75c = Class4.getModule$49fab75c(array2[0]));
        if (b == null) {
            if (mod == null) {
                throw new Class109(String.valueOf(new StringBuilder("The module '").append(array[0]).append("' does not exist")));
            }
            module$49fab75c = mod2;
        }
        final boolean state = module$49fab75c.state;
        if (b == null && state) {}
        boolean b2 = state;
        if (b == null) {
            Label_0203: {
                if (array.length >= 2) {
                    boolean equalsIgnoreCase;
                    final boolean b3 = equalsIgnoreCase = array[1].equalsIgnoreCase("on");
                    if (b == null) {
                        if (b3) {
                            b2 = true;
                            if (b == null) {
                                break Label_0203;
                            }
                        }
                        final boolean equalsIgnoreCase2;
                        equalsIgnoreCase = (equalsIgnoreCase2 = array[1].equalsIgnoreCase("off"));
                    }
                    if (b == null) {
                        if (!b3) {
                            throw new Class109(String.valueOf(new StringBuilder("Usage: .").append(s).append(" <module> <on/off>")));
                        }
                        equalsIgnoreCase = false;
                    }
                    b2 = equalsIgnoreCase;
                    if (b == null) {
                        break Label_0203;
                    }
                    throw new Class109(String.valueOf(new StringBuilder("Usage: .").append(s).append(" <module> <on/off>")));
                }
            }
            mod2.setState(b2, true);
        }
        final StringBuilder append = new StringBuilder().append(mod2.getName()).append(" was ");
        final String s2 = "§7";
        if (b == null) {
            append.append(s2);
            if (b2) {}
        }
        Class100.success(String.valueOf(append.append(s2)));
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        final int[] b = Class139.b();
        String s = Class152.lIIlIllIll[1];
        final int[] array2 = b;
        int n2 = 0;
        int n3 = n;
        boolean b2 = n != 0;
        final int[] array3 = array2;
        try {
            Label_0046: {
                if (array3 == null) {
                    if (n == 0) {
                        n2 = 1;
                        if (array2 == null) {
                            break Label_0046;
                        }
                    }
                    n3 = n;
                    b2 = (n != 0);
                }
                if (array2 == null) {
                    if (!b2) {
                        break Label_0046;
                    }
                    n3 = 1;
                }
                n2 = n3;
                s = array[0];
            }
        }
        catch (Exception ex) {}
        if (n2 != 0) {
            final String s2 = s;
            final Class139 instance = Class139.INSTANCE;
            return Class4.getModules().stream().filter((Predicate<? super Object>)Class152::lambda$autocomplete$0).map((Function<? super Object, ?>)Mod::getName).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
        }
        return new ArrayList<String>();
    }
    
    private static boolean lambda$autocomplete$0(final String s, final Mod mod) {
        return mod.getName().toLowerCase().startsWith(s);
    }
    
    static {
        llIllllIlll();
        Class169.a(-1555362317282000022L, 1215830442112604171L, MethodHandles.lookup().lookupClass()).a(54008508708163L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class152.lIIlIllIll[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class152.lIIlIllIll[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(85582102508608L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[13];
        int n2 = 0;
        String s;
        int n3 = (s = Class152.lIIlIllIll[4]).length();
        int n4 = 24;
        int n5 = -1;
    Label_0152:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class152.lIIlIllIll[6]))).intern();
                    switch (n7) {
                        default: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class152.lIIlIllIll[5]).length();
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
                            break Label_0152;
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
        e = new String[13];
    }
    
    private static Exception a(final Exception ex) {
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
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x89D;
        if (Class152.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class152.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class152.lIIlIllIll[7]);
                    array[1] = SecretKeyFactory.getInstance(Class152.lIIlIllIll[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class152.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class152.lIIlIllIll[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class152.e[n3] = a(((Cipher)array[0]).doFinal(Class152.d[n3].getBytes(Class152.lIIlIllIll[10])));
        }
        return Class152.e[n3];
    }
    
    private static void llIllllIlll() {
        (lIIlIllIll = new String[14])[0] = "t";
        Class152.lIIlIllIll[1] = "";
        Class152.lIIlIllIll[2] = "DES/CBC/PKCS5Padding";
        Class152.lIIlIllIll[3] = "DES";
        Class152.lIIlIllIll[4] = "GÒð>Ì\u008ag>õ\r\u0083\u008avwKÌ©\u0091\u0087:3Q\u009f² Zèh¼{Ëónãf\u0089ñ?Û&G9Åf»Rnt\u0000n\u0081\u0095Í\u00870\u0007\u0093(ß´[0ý\u0015*\u0081è`\u0087«½/6\u0002kw\u0007\u0010Ò2_ Mþì\u009cIem!\u00ad\rQ°iÔ\u0088>(ãÿkV\u0006\u0091ÙÇ5\u0080÷\u000f\u0083C#¶i\u0013\u0099\u001eÛ%I\u0003J7V>\u0084§ k\u0091&7sC\u0080Iÿ\u0010Õ_£ÌÜk\u0003Ç[X=Ru\u0007é\u0000\u0010ÏÊ\u008c9\u000fØp oü+\u0099ªJ\u0092{\u0010&\u0085½Èú¿ \u00ad\u008b3i\u001dÛS¹ù(\u0087Ï;¤ðÌ~\u008e£®7G\u0017\u008c\u007fOÒD\u009ck\u0000ÞÉ®u\u009d\u0097Vè«K`,9\u00180ç!¯>\u0010\u0088¢Ù{,ö:\u0097j`µà\u008cÎ¤(\u0010¥CL\u000f\u000eÈ·I\u0080Ë[b÷\u0002\u0003Ã º\u0089\u0099Ô&[\u0010\u0017èV\u009fâ\u007f:è\u0094¬Ñ$\u009c)Ç»½v\u007f¢,É\u0007W¤";
        Class152.lIIlIllIll[5] = "fÕdÎ\u0084öà\u009að\u0081\u00adÐ8\u0012¼³ ¿\u000e\u0014Ï\u009c:å9\u008d\u0089IÃRY\u0010PÞ^f®¢Y\u0012±Ìj\u0084í\u001cÚßÑ";
        Class152.lIIlIllIll[6] = "ISO-8859-1";
        Class152.lIIlIllIll[7] = "DES/CBC/PKCS5Padding";
        Class152.lIIlIllIll[8] = "DES";
        Class152.lIIlIllIll[9] = "小伙子肆无忌惮啊你看到我这种才华横溢的人你是不是就开始害怕了觉得你要输给你登峰造极的爸爸我啊继续滚吗滚赢我吗小伙子你是不是啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2006\u200f\u200f";
        Class152.lIIlIllIll[10] = "ISO-8859-1";
        Class152.lIIlIllIll[11] = "小伙子肆无忌惮啊你看到我这种才华横溢的人你是不是就开始害怕了觉得你要输给你登峰造极的爸爸我啊继续滚吗滚赢我吗小伙子你是不是啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2006\u200f\u200f";
        Class152.lIIlIllIll[12] = " : ";
        Class152.lIIlIllIll[13] = " : ";
    }
    
    private static String llIllllIIll(final String s, final String s2) {
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
    
    private static String llIllllIlIl(final String s, final String s2) {
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
    
    private static String llIllllIlII(String s, final String s2) {
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
    
    private static boolean llIllllllll$255f299(final int n) {
        return n >= 2;
    }
}
