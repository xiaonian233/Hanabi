package ClassSub;

import javax.swing.*;
import java.awt.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

final class Class314 extends Class197
{
    private static final long b;
    private static final String c;
    private static final String[] llIIlIIllI;
    
    Class314(final String s, final String s2) {
        super(s, s2);
    }
    
    @Override
    public final void showDialog() {
        final Color showDialog;
        if ((showDialog = JColorChooser.showDialog(null, "Choose a color", Class337.fromString(this.value))) != null) {
            this.value = Class337.toString(showDialog);
        }
    }
    
    @Override
    public final Object getObject() {
        return Class337.fromString(this.value);
    }
    
    static {
        lIIlIIIlIllI();
        Class169.a(-2827133956524693392L, 4665465709378556691L, MethodHandles.lookup().lookupClass()).a(271248121274189L);
        final Cipher instance = Cipher.getInstance(Class314.llIIlIIllI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class314.llIIlIIllI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(16158256857728L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class314.llIIlIIllI[2].getBytes(Class314.llIIlIIllI[3]))).intern();
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
    
    private static void lIIlIIIlIllI() {
        (llIIlIIllI = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class314.llIIlIIllI[1] = "DES";
        Class314.llIIlIIllI[2] = "5þ+#$@\u008a\u0001M\u00ad>Ð6\u000e÷p";
        Class314.llIIlIIllI[3] = "ISO-8859-1";
    }
    
    private static String lIIlIIIlIlIl(final String s, final String s2) {
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
    
    private static String lIIlIIIlIlII(final String s, final String s2) {
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
