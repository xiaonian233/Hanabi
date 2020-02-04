package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Class309 extends Enum<Class309>
{
    public static final int SEND$299aaa4;
    public static final int RECIEVE$299aaa4;
    private static final /* synthetic */ int[] $VALUES$53ed8921;
    private static final String[] lIlIIIlIllI;
    
    private static int[] values$5d5203a2() {
        return Class309.$VALUES$53ed8921.clone();
    }
    
    private Class309(final String s) {
        super(s, 0);
    }
    
    static {
        lllIIIlIllIl();
        final long n = Class169.a(5760781369417502699L, 2990169170132061583L, MethodHandles.lookup().lookupClass()).a(276353782840027L) ^ 0x31D487931408L;
        final Cipher instance = Cipher.getInstance(Class309.lIlIIIlIllI[0]);
        final int n2 = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class309.lIlIIIlIllI[1]);
        final byte[] array = new byte[8];
        array[0] = (byte)(n >>> 56);
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(n << i * 8 >>> 56);
        }
        instance.init(n2, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] array2 = new String[2];
        int n3 = 0;
        final String s;
        final int length = (s = Class309.lIlIIIlIllI[2]).length();
        int char1 = 8;
        int n4 = -1;
        while (true) {
            ++n4;
            final String s2 = s;
            final int n5 = n4;
            array2[n3++] = a(instance.doFinal(s2.substring(n5, n5 + char1).getBytes(Class309.lIlIIIlIllI[3]))).intern();
            if ((n4 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n4);
        }
        final String[] array3 = array2;
        new Class309();
        SEND$299aaa4 = 1;
        new Class309();
        RECIEVE$299aaa4 = 2;
        $VALUES$53ed8921 = new int[] { 1, 2 };
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
    
    private static void lllIIIlIllIl() {
        (lIlIIIlIllI = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class309.lIlIIIlIllI[1] = "DES";
        Class309.lIlIIIlIllI[2] = "½-\u0092\u00ad:\u000f\u0087>\b\t7n(\u0080`zþ";
        Class309.lIlIIIlIllI[3] = "ISO-8859-1";
    }
    
    private static String lllIIIlIIllI(String s, final String s2) {
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
    
    private static String lllIIIlIlIIl(final String s, final String s2) {
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
