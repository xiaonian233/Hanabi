package cn.Hanabi.command;

import org.jetbrains.annotations.*;
import cn.Hanabi.modules.*;
import org.lwjgl.input.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Binds extends Command
{
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIIIlllIlll;
    
    public Binds() {
        super("binds", new String[0]);
    }
    
    @Override
    public final void run(final String s, @NotNull final String[] array) {
        final int[] b = Class139.b();
        final List<Mod> modules = Class4.modules;
        try {
            for (final Mod mod : modules) {
                if (b != null) {
                    return;
                }
                if (mod.keybind != 0) {
                    Class333.tellPlayer(String.valueOf(new StringBuilder("§b[Hanabi]§a").append(mod.getName()).append(" - ").append(Keyboard.getKeyName(mod.keybind))));
                }
                if (b != null) {
                    break;
                }
            }
        }
        catch (Exception ex) {}
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
    
    static {
        llIIlllIlIlI();
        Class169.a(-6439662540921493190L, 6116886736759738154L, MethodHandles.lookup().lookupClass()).a(82806483982891L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Binds.lIIIlllIlll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Binds.lIIIlllIlll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(98058064706313L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Binds.lIIIlllIlll[2]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            d2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Binds.lIIIlllIlll[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        d = d2;
        e = new String[3];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7926;
        if (Binds.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Binds.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Binds.lIIIlllIlll[4]);
                    array[1] = SecretKeyFactory.getInstance(Binds.lIIIlllIlll[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Binds.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Binds.lIIIlllIlll[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Binds.e[n3] = a(((Cipher)array[0]).doFinal(Binds.d[n3].getBytes(Binds.lIIIlllIlll[7])));
        }
        return Binds.e[n3];
    }
    
    private static void llIIlllIlIlI() {
        (lIIIlllIlll = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Binds.lIIIlllIlll[1] = "DES";
        Binds.lIIIlllIlll[2] = "s\u009bð\u001cñ\u0091ÐsåáÉQ,/m#\u0010ß¹üd$½\b0ð\r. vÑJÁ \u0019Î?\u0012V»ºUÀ=2¶\u0002fã\u009cûñßÑ¬Î©\u009a\u008f\u0001:ªÃ\r\r\u0007";
        Binds.lIIIlllIlll[3] = "ISO-8859-1";
        Binds.lIIIlllIlll[4] = "DES/CBC/PKCS5Padding";
        Binds.lIIIlllIlll[5] = "DES";
        Binds.lIIIlllIlll[6] = "你看看你所谓的词汇真的没有什么客观价值了呢你是不是觉得莫名其妙的啊小蜗牛我看你也就是一个蜗牛速度了你能面对我了吗你以为你是天龙八部里的慕容复吗垃圾狗族废材爹爹我不想埋汰你们了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u200c \u200d";
        Binds.lIIIlllIlll[7] = "ISO-8859-1";
        Binds.lIIIlllIlll[8] = "你看看你所谓的词汇真的没有什么客观价值了呢你是不是觉得莫名其妙的啊小蜗牛我看你也就是一个蜗牛速度了你能面对我了吗你以为你是天龙八部里的慕容复吗垃圾狗族废材爹爹我不想埋汰你们了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u200c \u200d";
        Binds.lIIIlllIlll[9] = " : ";
        Binds.lIIIlllIlll[10] = " : ";
    }
    
    private static String llIIlllIlIIl(final String s, final String s2) {
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
    
    private static String llIIlllIlIII(final String s, final String s2) {
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
    
    private static String llIIlllIIlll(String s, final String s2) {
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
