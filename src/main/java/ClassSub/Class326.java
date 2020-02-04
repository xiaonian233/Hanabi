package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

final class Class326 extends Class297
{
    private static final long b;
    private static final String d;
    private static final String[] lIllIlIIIl;
    
    Class326() {
        super();
    }
    
    @Override
    public final String getPrefix(final String s) {
        return Class138.doGet(String.valueOf(new StringBuilder("https://flux.today/irc_veriry/getprefix.php?user=").append(s)));
    }
    
    static {
        lIIIIlIIlIII();
        Class169.a(4146715087003675097L, 628500609706042123L, MethodHandles.lookup().lookupClass()).a(150536478596191L);
        final Cipher instance = Cipher.getInstance(Class326.lIllIlIIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class326.lIllIlIIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(24343068407637L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(Class326.lIllIlIIIl[2].getBytes(Class326.lIllIlIIIl[3]))).intern();
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
    
    private static void lIIIIlIIlIII() {
        (lIllIlIIIl = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class326.lIllIlIIIl[1] = "DES";
        Class326.lIllIlIIIl[2] = "l\u0099ªv¤\u008e\u0087k\u001e¼lÛ\u0085ÕBxa\u0094\u009dZÛÝ\u0098Û1]|\u008dÏ£üÔÄ¦\\~õiîcXµÀ3\u008d\u009e(s´§ª\u0007\u0081SÍ ";
        Class326.lIllIlIIIl[3] = "ISO-8859-1";
    }
    
    private static String lIIIIlIIIlll(final String s, final String s2) {
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
    
    private static String lIIIIlIIIllI(final String s, final String s2) {
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
}
