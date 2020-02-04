package cn.Hanabi.modules.Movement;

import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Sprint extends Mod
{
    private static boolean isSprinting;
    private static final long b;
    private static final String c;
    private static final String[] lIlIIIlIIlI;
    
    public Sprint() {
        super("Sprint", Category.MOVEMENT);
        this.setState(true);
    }
    
    @EventTarget
    private static void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        final float n = fcmpl((float)Sprint.mc.field_71439_g.func_71024_bL().func_75116_a(), 6.0f);
        if (b == null) {
            if (n <= 0) {
                final boolean field_75101_c;
                final boolean b2 = field_75101_c = Sprint.mc.field_71439_g.field_71075_bZ.field_75101_c;
                if (b == null) {
                    if (b2) {}
                }
            }
        }
        final int n2 = (int)n;
        final boolean movementInput = Class333.MovementInput();
        if (b == null) {
            if (movementInput) {
                final int n3 = n2;
                if (b == null) {
                    if (n3 != 0) {
                        Sprint.mc.field_71439_g.func_70031_b(true);
                    }
                }
            }
        }
    }
    
    @Override
    public final void onDisable() {
        Sprint.mc.field_71439_g.func_70031_b(false);
        super.onDisable();
    }
    
    static {
        lllIIIlIIlII();
        Class169.a(-1088143074409563753L, 9089482333117183052L, MethodHandles.lookup().lookupClass()).a(68534210455900L);
        final Cipher instance = Cipher.getInstance(Sprint.lIlIIIlIIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Sprint.lIlIIIlIIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(60274557336607L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(Sprint.lIlIIIlIIlI[2].getBytes(Sprint.lIlIIIlIIlI[3]))).intern();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
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
    
    private static void lllIIIlIIlII() {
        (lIlIIIlIIlI = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Sprint.lIlIIIlIIlI[1] = "DES";
        Sprint.lIlIIIlIIlI[2] = "\u00adaÑéQÿ\u008e\u0000";
        Sprint.lIlIIIlIIlI[3] = "ISO-8859-1";
    }
    
    private static String lllIIIlIIIlI(final String s, final String s2) {
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
    
    private static String lllIIIlIIIll(final String s, final String s2) {
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
    
    private static boolean lllIIIlIlIII(final int n) {
        return n <= 0;
    }
    
    private static int lllIIIlIIlIl$2548a28(final float n) {
        return fcmpl(n, 6.0f);
    }
}
