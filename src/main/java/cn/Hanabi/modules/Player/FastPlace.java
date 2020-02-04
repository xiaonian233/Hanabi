package cn.Hanabi.modules.Player;

import cn.Hanabi.modules.*;
import net.minecraft.client.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class FastPlace extends Mod
{
    private static final long b;
    private static final String c;
    private static final String[] lIIllIIIIlI;
    
    public FastPlace() {
        super("FastPlace", Category.PLAYER);
    }
    
    @EventTarget
    private static void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        final Minecraft mc = FastPlace.mc;
        if (b == null) {
            mc.field_71439_g.func_70694_bm().func_77973_b();
        }
    }
    
    static {
        llIllIIIlIlI();
        Class169.a(-2650138933175902436L, 4746664915760835689L, MethodHandles.lookup().lookupClass()).a(170569003367447L);
        final Cipher instance = Cipher.getInstance(FastPlace.lIIllIIIIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(FastPlace.lIIllIIIIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(36671289635576L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(FastPlace.lIIllIIIIlI[2].getBytes(FastPlace.lIIllIIIIlI[3]))).intern();
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
    
    private static void llIllIIIlIlI() {
        (lIIllIIIIlI = new String[4])[0] = "DES/CBC/PKCS5Padding";
        FastPlace.lIIllIIIIlI[1] = "DES";
        FastPlace.lIIllIIIIlI[2] = "\u0080Ü¡\u008e\u0002ê\u001d\u0011Bl§d®è/l";
        FastPlace.lIIllIIIIlI[3] = "ISO-8859-1";
    }
    
    private static String llIllIIIlIIl(final String s, final String s2) {
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
    
    private static String llIllIIIlIII(final String s, final String s2) {
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
