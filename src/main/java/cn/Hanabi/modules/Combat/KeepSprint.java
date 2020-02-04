package cn.Hanabi.modules.Combat;

import cn.Hanabi.modules.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.util.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;

public class KeepSprint extends Mod
{
    private static final long b;
    private static final String c;
    private static final String[] llIlIlIIIll;
    
    public KeepSprint() {
        super("KeepSprint", Category.COMBAT);
    }
    
    static {
        lIIlIIlIlllII();
        Class169.a(2999052711137273619L, 2021005250904220519L, MethodHandles.lookup().lookupClass()).a(120457310183399L);
        final Cipher instance = Cipher.getInstance(KeepSprint.llIlIlIIIll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(KeepSprint.llIlIlIIIll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(59420076465634L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(KeepSprint.llIlIlIIIll[2].getBytes(KeepSprint.llIlIlIIIll[3]))).intern();
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
    
    private static void lIIlIIlIlllII() {
        (llIlIlIIIll = new String[4])[0] = "DES/CBC/PKCS5Padding";
        KeepSprint.llIlIlIIIll[1] = "DES";
        KeepSprint.llIlIlIIIll[2] = "z\u0002À\b\"µ2ßãÉ\\B\"ÉüÚ";
        KeepSprint.llIlIlIIIll[3] = "ISO-8859-1";
    }
    
    private static String lIIlIIlIllIII(String s, final String s2) {
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
    
    private static String lIIlIIlIllIIl(final String s, final String s2) {
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
