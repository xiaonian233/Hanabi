package ClassSub;

import java.nio.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

final class Class73
{
    int srcPixelFormat;
    private int componentCount;
    int minFilter;
    int magFilter;
    ByteBuffer textureBuffer;
    Class154 this$0;
    private static final long a;
    private static final String b;
    private static final String[] llIIIllllII;
    
    private Class73(final Class154 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    private int reload() {
        Class355.error(String.valueOf(new StringBuilder("Reloading texture: ").append(Class154.access$600(this.this$0))));
        return Class294.get().reload$e1231c9(this.this$0, this.srcPixelFormat, this.minFilter, this.magFilter, this.textureBuffer);
    }
    
    Class73(final Class154 class154, final byte b) {
        this(class154);
    }
    
    static int access$102(final Class73 class73, final int srcPixelFormat) {
        return class73.srcPixelFormat = srcPixelFormat;
    }
    
    static int access$202$490a62bf(final int n) {
        return n;
    }
    
    static int access$302(final Class73 class73, final int minFilter) {
        return class73.minFilter = minFilter;
    }
    
    static int access$402(final Class73 class73, final int magFilter) {
        return class73.magFilter = magFilter;
    }
    
    static ByteBuffer access$502(final Class73 class73, final ByteBuffer textureBuffer) {
        return class73.textureBuffer = textureBuffer;
    }
    
    static {
        lIIIlIIllIlIl();
        Class169.a(4251813156408167907L, 9117525139752778650L, MethodHandles.lookup().lookupClass()).a(81044330179348L);
        final Cipher instance = Cipher.getInstance(Class73.llIIIllllII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class73.llIIIllllII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(52609930336261L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class73.llIIIllllII[2].getBytes(Class73.llIIIllllII[3]))).intern();
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
    
    private static void lIIIlIIllIlIl() {
        (llIIIllllII = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class73.llIIIllllII[1] = "DES";
        Class73.llIIIllllII[2] = "G\u009fqÍ\u0096\u001a$Tª\u0096»\u008a¦#²;ªÕ¼\u0080ç\røu";
        Class73.llIIIllllII[3] = "ISO-8859-1";
    }
    
    private static String lIIIlIIllIIll(String s, final String s2) {
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
    
    private static String lIIIlIIllIIIl(final String s, final String s2) {
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
    
    private static String lIIIlIIllIlII(final String s, final String s2) {
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
