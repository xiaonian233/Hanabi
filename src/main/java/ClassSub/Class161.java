package ClassSub;

import java.io.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class161 extends IOException
{
    ArrayList exceptions;
    private static final long a;
    private static final String b;
    private static final String[] lllIlllll;
    
    public Class161() {
        super();
        this.exceptions = new ArrayList();
    }
    
    private void addException(final Exception ex) {
        this.exceptions.add(ex);
    }
    
    @Override
    public final String getMessage() {
        final int[] b = Class139.b();
        String s = "Composite Exception: \n";
        int i = 0;
        final int[] array = b;
        String value = null;
        while (i < this.exceptions.size()) {
            value = String.valueOf(new StringBuilder().append(s).append(Class161.lllIlllll[0]).append(this.exceptions.get(i).getMessage()).append(Class161.lllIlllll[1]));
            if (array != null) {
                return value;
            }
            s = value;
            ++i;
            if (array != null) {
                break;
            }
        }
        return value;
    }
    
    static {
        lIlIllIIIII();
        Class169.a(2452643604947909482L, 4392156472877342067L, MethodHandles.lookup().lookupClass()).a(172492324697466L);
        final Cipher instance = Cipher.getInstance(Class161.lllIlllll[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class161.lllIlllll[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(135651139534478L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class161.lllIlllll[4].getBytes(Class161.lllIlllll[5]))).intern();
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
    
    private static void lIlIllIIIII() {
        (lllIlllll = new String[6])[0] = "\t";
        Class161.lllIlllll[1] = "\n";
        Class161.lllIlllll[2] = "DES/CBC/PKCS5Padding";
        Class161.lllIlllll[3] = "DES";
        Class161.lllIlllll[4] = "u\u009c0¥,p¾f\u0098?Ò\u00107Jqq8ý\u008c§\u0002°«µ";
        Class161.lllIlllll[5] = "ISO-8859-1";
    }
    
    private static String lIlIlIllIlI(final String s, final String s2) {
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
    
    private static String lIlIlIllIIl(String s, final String s2) {
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
    
    private static String lIlIlIlIllI(final String s, final String s2) {
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
