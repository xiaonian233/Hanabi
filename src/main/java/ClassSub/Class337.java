package ClassSub;

import java.awt.image.*;
import java.awt.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class337
{
    private static BufferedImage scratchImage;
    private static final long a;
    private static final String b;
    private static final String[] lIlIllIIlIl;
    
    public Class337() {
        super();
    }
    
    private static BufferedImage getScratchImage() {
        final Graphics2D graphics2D;
        (graphics2D = (Graphics2D)Class337.scratchImage.getGraphics()).setComposite(AlphaComposite.Clear);
        graphics2D.fillRect(0, 0, 256, 256);
        graphics2D.setComposite(AlphaComposite.SrcOver);
        graphics2D.setColor(Color.white);
        return Class337.scratchImage;
    }
    
    public static Class52 colorValue(final String s, final Color color) {
        return new Class314(s, toString(color));
    }
    
    private static Class52 intValue(final String s, final int n, final String s2) {
        return new Class106(s, String.valueOf(n), n, s2);
    }
    
    private static Class52 floatValue(final String s, final float n, final float n2, final float n3, final String s2) {
        return new Class162(s, String.valueOf(n), n, n2, n3, s2);
    }
    
    private static Class52 booleanValue(final String s, final boolean b, final String s2) {
        return new Class273(s, String.valueOf(b), b, s2);
    }
    
    private static Class52 optionValue(final String s, final String s2, final String[][] array, final String s3) {
        return new Class136(s, s2.toString(), array, s2, s3);
    }
    
    public static String toString(final Color color) {
        final int[] b = Class139.b();
        Color color2 = color;
        if (b == null) {
            if (color == null) {
                throw new IllegalArgumentException("color cannot be null.");
            }
            color2 = color;
        }
        String s;
        final int length = (s = Integer.toHexString(color2.getRed())).length();
        if (b == null) {
            if (length == 1) {
                s = String.valueOf(new StringBuilder().append(Class337.lIlIllIIlIl[0]).append(s));
            }
            color.getGreen();
        }
        String s2;
        final int length2 = (s2 = Integer.toHexString(length)).length();
        if (b == null) {
            if (length2 == 1) {
                s2 = String.valueOf(new StringBuilder().append(Class337.lIlIllIIlIl[1]).append(s2));
            }
            color.getBlue();
        }
        String s4;
        String value;
        final String s3 = value = (s4 = Integer.toHexString(length2));
        if (b == null) {
            if (s3.length() == 1) {
                value = String.valueOf(new StringBuilder().append(Class337.lIlIllIIlIl[2]).append(value));
            }
            s4 = String.valueOf(new StringBuilder().append(s).append(s2).append(value));
        }
        return s4;
    }
    
    public static Color fromString(final String s) {
        final int[] b = Class139.b();
        String s2 = s;
        if (b == null) {
            if (s == null) {
                return Color.white;
            }
            s2 = s;
        }
        if (s2.length() == 6) {
            return new Color(Integer.parseInt(s.substring(0, 2), 16), Integer.parseInt(s.substring(2, 4), 16), Integer.parseInt(s.substring(4, 6), 16));
        }
        return Color.white;
    }
    
    static {
        llllIIlIIIll();
        Class169.a(2202313193583338189L, 3944779988695761026L, MethodHandles.lookup().lookupClass()).a(123908032659680L);
        final Cipher instance = Cipher.getInstance(Class337.lIlIllIIlIl[3]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class337.lIlIllIIlIl[4]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(131247998557649L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class337.lIlIllIIlIl[5].getBytes(Class337.lIlIllIIlIl[6]))).intern();
        Class337.scratchImage = new BufferedImage(256, 256, 2);
    }
    
    private static IllegalArgumentException a(final IllegalArgumentException ex) {
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
    
    private static void llllIIlIIIll() {
        (lIlIllIIlIl = new String[7])[0] = "0";
        Class337.lIlIllIIlIl[1] = "0";
        Class337.lIlIllIIlIl[2] = "0";
        Class337.lIlIllIIlIl[3] = "DES/CBC/PKCS5Padding";
        Class337.lIlIllIIlIl[4] = "DES";
        Class337.lIlIllIIlIl[5] = "\u0014¾f\"ó_ÂCØ1àëÌ\u00955\u001eù\u0081¡Sm=³\u0094";
        Class337.lIlIllIIlIl[6] = "ISO-8859-1";
    }
    
    private static String llllIIlIIIlI(String s, final String s2) {
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
    
    private static String llllIIIlllll(final String s, final String s2) {
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
    
    private static String llllIIlIIIIl(final String s, final String s2) {
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
    
    private static boolean llllIIlIIlll$255f299(final int n) {
        return n != 6;
    }
}
