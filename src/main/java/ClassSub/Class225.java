package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class225
{
    private static ArrayList<Class297> types;
    private static final String[] lIllIIIIIII;
    
    public Class225() {
        super();
    }
    
    public static Class297 getTypeByName(final String s) {
        for (final Class297 class297 : Class225.types) {
            if (Class297.getClientName().equals(s)) {
                return class297;
            }
        }
        return null;
    }
    
    static {
        llllIlIlllll();
        final long n = Class169.a(4297870623995460362L, 5305354024256451677L, MethodHandles.lookup().lookupClass()).a(32654438881242L) ^ 0x66B0C388E2C9L;
        final Cipher instance = Cipher.getInstance(Class225.lIllIIIIIII[0]);
        final int n2 = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class225.lIllIIIIIII[1]);
        final byte[] array = new byte[8];
        array[0] = (byte)(n >>> 56);
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(n << i * 8 >>> 56);
        }
        instance.init(n2, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class225.lIllIIIIIII[2].getBytes(Class225.lIllIIIIIII[3]))).intern();
        (Class225.types = new ArrayList<Class297>()).add(new Class229());
        Class225.types.add(new Class167());
        Class225.types.add(new Class307());
        Class225.types.add(new Class326());
    }
    
    private static RuntimeException a(final RuntimeException ex) {
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
    
    private static void llllIlIlllll() {
        (lIllIIIIIII = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class225.lIllIIIIIII[1] = "DES";
        Class225.lIllIIIIIII[2] = "\u009d\tG\u0003\u0016k\u001cÑ";
        Class225.lIllIIIIIII[3] = "ISO-8859-1";
    }
    
    private static String llllIlIllllI(final String s, final String s2) {
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
    
    private static String llllIlIlllIl(String s, final String s2) {
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
