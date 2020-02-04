package cn.Hanabi.command;

import org.jetbrains.annotations.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Whois extends Command
{
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIIllllIlll;
    
    public Whois() {
        super("whois", new String[0]);
    }
    
    @Override
    public final void run(final String s, @NotNull final String[] array) {
        if (Class139.b() == null) {
            if (array.length != 1) {
                return;
            }
            Class333.tellPlayer(String.valueOf(new StringBuilder("§c[Whois]Trying to search §e").append(array[0]).append("§c...")));
        }
        new Class195(array[0]).sendPacketToServer(Class206.socket.writer);
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
    
    static {
        llIllllllIll();
        Class169.a(-7877890483041017594L, 8211129400775635508L, MethodHandles.lookup().lookupClass()).a(210946607796435L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Whois.lIIllllIlll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Whois.lIIllllIlll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(105976288496051L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Whois.lIIllllIlll[2]).length();
        int char1 = 48;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            d2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Whois.lIIllllIlll[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        d = d2;
        e = new String[3];
    }
    
    private static RuntimeException b(final RuntimeException ex) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x4202;
        if (Whois.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Whois.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Whois.lIIllllIlll[4]);
                    array[1] = SecretKeyFactory.getInstance(Whois.lIIllllIlll[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Whois.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Whois.lIIllllIlll[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Whois.e[n3] = a(((Cipher)array[0]).doFinal(Whois.d[n3].getBytes(Whois.lIIllllIlll[7])));
        }
        return Whois.e[n3];
    }
    
    private static void llIllllllIll() {
        (lIIllllIlll = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Whois.lIIllllIlll[1] = "DES";
        Whois.lIIllllIlll[2] = "ì\u008b\u007fõ\u0010ê\u009dhá@â¶\n\u0087ðøP\\\u0086\u0011O|^\u000b\u0017ÒÂ\u000e«Ñ\u0011\u0013¤\u0092D\u008c«\u0087ì\u008dz¢.kÇ%¢y\u0010;\u0084\u0015ÚÖi¿A\u0086\u0092°â{>Ô«\u0010óåü¸î\u0017«ô´\u001aCM\u0097\u009c·1";
        Whois.lIIllllIlll[3] = "ISO-8859-1";
        Whois.lIIllllIlll[4] = "DES/CBC/PKCS5Padding";
        Whois.lIIllllIlll[5] = "DES";
        Whois.lIIllllIlll[6] = "你还没那个实力就你那样缺斤少两的身体还想装什么重量级的大手是不是你连一句所谓的我是你爸爸投向你妈妈的怀抱痛哭一场偶尔的灵光一现你有什么资格再来跟我对话你为什么总是这样呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2009\u2001\u2004";
        Whois.lIIllllIlll[7] = "ISO-8859-1";
        Whois.lIIllllIlll[8] = "你还没那个实力就你那样缺斤少两的身体还想装什么重量级的大手是不是你连一句所谓的我是你爸爸投向你妈妈的怀抱痛哭一场偶尔的灵光一现你有什么资格再来跟我对话你为什么总是这样呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2009\u2001\u2004";
        Whois.lIIllllIlll[9] = " : ";
        Whois.lIIllllIlll[10] = " : ";
    }
    
    private static String llIllllllIII(final String s, final String s2) {
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
    
    private static String llIllllllIlI(final String s, final String s2) {
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
    
    private static String llIllllllIIl(String s, final String s2) {
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
