package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class246
{
    private static final long a;
    private static final String b;
    private static final String[] lllIIIIllI;
    
    public Class246() {
        super();
    }
    
    private static void checkGLContext() {
        try {
            Class110.get().glGetError();
        }
        catch (NullPointerException ex) {
            throw new RuntimeException("OpenGL based resources (images, fonts, sprites etc) must be loaded as part of init() or the game loop. They cannot be loaded before initialisation.");
        }
    }
    
    static {
        lIlIIIIlIIll();
        Class169.a(647057702183450665L, 4521248927426896898L, MethodHandles.lookup().lookupClass()).a(83912409184171L);
        final Cipher instance = Cipher.getInstance(Class246.lllIIIIllI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class246.lllIIIIllI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(61910258956613L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class246.lllIIIIllI[2].getBytes(Class246.lllIIIIllI[3]))).intern();
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
    
    private static void lIlIIIIlIIll() {
        (lllIIIIllI = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class246.lllIIIIllI[1] = "DES";
        Class246.lllIIIIllI[2] = "2\u001c\u008d\u009e;6Ü\u0086ÀÆø\u0091\u0081\u0090Z\u001fá¼/C\u0003\u0099\u0091@z\n¡3Õ4øðçÇ±:×Ôç^\n±Ç\u008c´SÈ'\u0080!\u0015@\u0011¤e\u0015VXS\u0096`É\u00822÷Ú\u000f\u0015×Õ\u001d\u007fÞÒ'ª×JÝÌ\u0017Iâ\u0016\u009c6\u0086\u0014¹.óËêE¯Ð®}êæÔî\u0087\u0086\u0086\u0093\b$\u0099$c\fo¨\u000e%X^xâ§\u007fÈ7\u0010¹\u0097%áS\u0005\u0094@ì\u001f\u0083F]V\u009b\u009aàQ\u00145jÆs\tjNí";
        Class246.lllIIIIllI[3] = "ISO-8859-1";
    }
    
    private static String lIlIIIIlIIlI(final String s, final String s2) {
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
    
    private static String lIlIIIIlIIIl(String s, final String s2) {
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
