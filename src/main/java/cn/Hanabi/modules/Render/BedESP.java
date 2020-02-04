package cn.Hanabi.modules.Render;

import cn.Hanabi.modules.*;
import net.minecraft.util.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class BedESP extends Mod
{
    private static final long b;
    private static final String c;
    private static final String[] lIllIlIIIlI;
    
    public BedESP() {
        super("BedESP", Category.RENDER);
    }
    
    @EventTarget
    private static void onRender$1f20be12() {
        final int[] b = Class139.b();
        final Iterator<BlockPos> iterator = Class315.list.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final BlockPos blockPos;
            final double n = (blockPos = iterator.next()).func_177958_n();
            BedESP.mc.func_175598_ae();
            final double n2 = blockPos.func_177956_o();
            BedESP.mc.func_175598_ae();
            final double n3 = blockPos.func_177952_p();
            BedESP.mc.func_175598_ae();
            Class69.drawSolidBlockESP$51f2a797(n, n2, n3, 1.0f, 1.0f, 1.0f);
            if (array != null) {
                break;
            }
        }
    }
    
    static {
        lllllIIllIIl();
        Class169.a(5796154125194106312L, 2995134680370532522L, MethodHandles.lookup().lookupClass()).a(251404755222076L);
        final Cipher instance = Cipher.getInstance(BedESP.lIllIlIIIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(BedESP.lIllIlIIIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(69796565614920L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(BedESP.lIllIlIIIlI[2].getBytes(BedESP.lIllIlIIIlI[3]))).intern();
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
    
    private static void lllllIIllIIl() {
        (lIllIlIIIlI = new String[4])[0] = "DES/CBC/PKCS5Padding";
        BedESP.lIllIlIIIlI[1] = "DES";
        BedESP.lIllIlIIIlI[2] = "s2n\u001c>ÓØá";
        BedESP.lIllIlIIIlI[3] = "ISO-8859-1";
    }
    
    private static String lllllIIlIIll(final String s, final String s2) {
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
    
    private static String lllllIIlIlII(final String s, final String s2) {
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
