package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class188
{
    private static Class188 single;
    ArrayList deferred;
    int total;
    private static final long a;
    private static final String b;
    private static final String[] llIIlllll;
    
    public static Class188 get() {
        return Class188.single;
    }
    
    private static void setDeferredLoading(final boolean deferred) {
        Class188.single = new Class188();
        Class294.get().deferred = deferred;
    }
    
    private static boolean isDeferredLoading() {
        return Class294.get().deferred;
    }
    
    private Class188() {
        super();
        this.deferred = new ArrayList();
    }
    
    private void add(final Class210 class210) {
        ++this.total;
        this.deferred.add(class210);
    }
    
    private void remove(final Class210 class210) {
        Class355.info(String.valueOf(new StringBuilder("Early loading of deferred resource due to req: ").append(class210.getDescription())));
        --this.total;
        this.deferred.remove(class210);
    }
    
    private int getTotalResources() {
        return this.total;
    }
    
    private int getRemainingResources() {
        return this.deferred.size();
    }
    
    private Class210 getNext() {
        final int[] b = Class139.b();
        Object o;
        final ArrayList list = (ArrayList)(o = this.deferred);
        if (b == null) {
            if (list.size() == 0) {
                return null;
            }
            o = this.deferred.remove(0);
        }
        return (Class210)o;
    }
    
    static {
        lIIIlllllll();
        Class169.a(773749592936172612L, 1524319159885829448L, MethodHandles.lookup().lookupClass()).a(32821477580947L);
        final Cipher instance = Cipher.getInstance(Class188.llIIlllll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class188.llIIlllll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(38773696828L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class188.llIIlllll[2].getBytes(Class188.llIIlllll[3]))).intern();
        Class188.single = new Class188();
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
    
    private static void lIIIlllllll() {
        (llIIlllll = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class188.llIIlllll[1] = "DES";
        Class188.llIIlllll[2] = "\u0094\u0015Á§)ÙØ¿ÞdDTÔú¨K¯\u008en¤&\u0081§Ö\u0007È\u0007\u000b\u0098\u00adÙ\u0011o\u009dRP\u0012QT=\u009fÒ{ÞA5æß";
        Class188.llIIlllll[3] = "ISO-8859-1";
    }
    
    private static String lIIIlllllIl(final String s, final String s2) {
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
    
    private static String lIIIlllllII(String s, final String s2) {
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
