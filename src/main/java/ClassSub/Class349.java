package ClassSub;

import java.io.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public abstract class Class349
{
    private final File file;
    private final String name;
    private boolean load;
    private static final long a;
    private static final String c;
    private static final String[] lIIlIIlIIl;
    
    public Class349(final String name) {
        final int[] b = Class139.b();
        super();
        final int[] array = b;
        this.name = name;
        this.load = true;
        this.file = new File(Class96.access$100(), String.valueOf(new StringBuilder().append(String.valueOf(name)).append(".txt")));
        Class349 class349 = this;
        if (array == null) {
            if (this.file.exists()) {
                return;
            }
            class349 = this;
        }
        try {
            class349.saveFile();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public final File getFile() {
        return this.file;
    }
    
    private boolean loadOnStart() {
        return this.load;
    }
    
    private String getName() {
        return this.name;
    }
    
    public abstract void loadFile() throws IOException;
    
    public abstract void saveFile() throws IOException;
    
    static boolean access$000(final Class349 class349) {
        return class349.load;
    }
    
    static {
        llIlIllIIIl();
        Class169.a(1698818767333352497L, 593116669705881519L, MethodHandles.lookup().lookupClass()).a(98521538333609L);
        final Cipher instance = Cipher.getInstance(Class349.lIIlIIlIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class349.lIIlIIlIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(138753211147349L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class349.lIIlIIlIIl[2].getBytes(Class349.lIIlIIlIIl[3]))).intern();
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
    
    private static void llIlIllIIIl() {
        (lIIlIIlIIl = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class349.lIIlIIlIIl[1] = "DES";
        Class349.lIIlIIlIIl[2] = "LZ°K¢\u009aid";
        Class349.lIIlIIlIIl[3] = "ISO-8859-1";
    }
    
    private static String llIlIlIllll(final String s, final String s2) {
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
    
    private static String llIlIllIIII(String s, final String s2) {
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
