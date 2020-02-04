package cn.Hanabi.modules.Player;

import cn.Hanabi.modules.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class ChestAura extends Mod
{
    private static final long b;
    private static final String c;
    private static final String[] lIIllIIIlII;
    
    public ChestAura() {
        super("ChestAura", Category.PLAYER);
    }
    
    static {
        llIllIIlIIII();
        Class169.a(-5354835894382422083L, 4758986976276038288L, MethodHandles.lookup().lookupClass()).a(30548152725689L);
        final Cipher instance = Cipher.getInstance(ChestAura.lIIllIIIlII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(ChestAura.lIIllIIIlII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(30188082887993L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(ChestAura.lIIllIIIlII[2].getBytes(ChestAura.lIIllIIIlII[3]))).intern();
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
    
    private static void llIllIIlIIII() {
        (lIIllIIIlII = new String[4])[0] = "DES/CBC/PKCS5Padding";
        ChestAura.lIIllIIIlII[1] = "DES";
        ChestAura.lIIllIIIlII[2] = "\u009cjÞo¬ÙÆ½\u007f+^Ô\u0011\u00ad\u0084N";
        ChestAura.lIIllIIIlII[3] = "ISO-8859-1";
    }
    
    private static String llIllIIIlllI(final String s, final String s2) {
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
    
    private static String llIllIIIllll(String s, final String s2) {
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
