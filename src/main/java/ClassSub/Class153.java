package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public enum Class153
{
    SUCCESS, 
    INFO, 
    WARNING, 
    ERROR;
    
    private static final Class153[] $VALUES;
    private static final String[] lllIllII;
    
    public static Class153[] values() {
        return Class153.$VALUES.clone();
    }
    
    public static Class153 valueOf(final String s) {
        return Enum.valueOf(Class153.class, s);
    }
    
    static {
        lIlIIllIIl();
        final long n = Class169.a(6916390340614348176L, 4112419564998334472L, MethodHandles.lookup().lookupClass()).a(78660109797884L) ^ 0x727AFA14DB65L;
        final Cipher instance = Cipher.getInstance(Class153.lllIllII[0]);
        final int n2 = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class153.lllIllII[1]);
        final byte[] array = new byte[8];
        array[0] = (byte)(n >>> 56);
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(n << i * 8 >>> 56);
        }
        instance.init(n2, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] array2 = new String[4];
        int n3 = 0;
        String s;
        int n4 = (s = Class153.lllIllII[2]).length();
        int n5 = 8;
        int n6 = -1;
    Label_0148:
        while (true) {
            while (true) {
                ++n6;
                final String s2 = s;
                final int n7 = n6;
                String s3 = s2.substring(n7, n7 + n5);
                int n8 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class153.lllIllII[4]))).intern();
                    switch (n8) {
                        default: {
                            array2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                continue Label_0148;
                            }
                            n4 = (s = Class153.lllIllII[3]).length();
                            n5 = 8;
                            n6 = -1;
                            break;
                        }
                        case 0: {
                            array2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                break;
                            }
                            break Label_0148;
                        }
                    }
                    ++n6;
                    final String s4 = s;
                    final int n9 = n6;
                    s3 = s4.substring(n9, n9 + n5);
                    n8 = 0;
                }
            }
            break;
        }
        final String[] array3 = array2;
        $VALUES = new Class153[] { Class153.SUCCESS, Class153.INFO, Class153.WARNING, Class153.ERROR };
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
    
    private static void lIlIIllIIl() {
        (lllIllII = new String[5])[0] = "DES/CBC/PKCS5Padding";
        Class153.lllIllII[1] = "DES";
        Class153.lllIllII[2] = "\u0003\u009awê\u001a»\u0084ñ\bÅ\u009d\u0096\n\u0093ñ\u0004y";
        Class153.lllIllII[3] = "rlPÔý?Ó\u000f\b¾\"\u001aås«Ê\u0005";
        Class153.lllIllII[4] = "ISO-8859-1";
    }
    
    private static String lIlIIlIlII(final String s, final String s2) {
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
    
    private static String lIlIIlIlll(final String s, final String s2) {
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
    
    private static String lIlIIlIllI(String s, final String s2) {
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
