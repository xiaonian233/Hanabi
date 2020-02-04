package cn.Hanabi.modules.World;

import cn.Hanabi.modules.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.*;
import net.minecraft.client.settings.*;
import net.minecraft.client.entity.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Eagle extends Mod
{
    private static final long b;
    private static final String c;
    private static final String[] llllllIIl;
    
    public Eagle() {
        super("Eagle", Category.WORLD);
    }
    
    private static Block getBlock(final BlockPos blockPos) {
        return Eagle.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
    }
    
    private static Block getBlockUnderPlayer(final EntityPlayer entityPlayer) {
        return Eagle.mc.field_71441_e.func_180495_p(new BlockPos(entityPlayer.field_70165_t, entityPlayer.field_70163_u - 1.0, entityPlayer.field_70161_v)).func_177230_c();
    }
    
    @EventTarget
    private static void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        final EntityPlayerSP field_71439_g = Eagle.mc.field_71439_g;
        int func_151463_i;
        final int n = func_151463_i = ((Eagle.mc.field_71441_e.func_180495_p(new BlockPos(((EntityPlayer)field_71439_g).field_70165_t, ((EntityPlayer)field_71439_g).field_70163_u - 1.0, ((EntityPlayer)field_71439_g).field_70161_v)).func_177230_c() instanceof BlockAir) ? 1 : 0);
        if (b == null) {
            if (n != 0) {
                final int field_70122_E = Eagle.mc.field_71439_g.field_70122_E ? 1 : 0;
                if (b == null) {
                    if (field_70122_E == 0) {
                        return;
                    }
                    Eagle.mc.field_71474_y.field_74311_E.func_151463_i();
                }
                KeyBinding.func_74510_a(field_70122_E, true);
                if (b == null) {
                    return;
                }
            }
            final boolean field_70122_E2;
            func_151463_i = ((field_70122_E2 = Eagle.mc.field_71439_g.field_70122_E) ? 1 : 0);
        }
        if (b == null) {
            if (n == 0) {
                return;
            }
            func_151463_i = Eagle.mc.field_71474_y.field_74311_E.func_151463_i();
        }
        KeyBinding.func_74510_a(func_151463_i, false);
    }
    
    @Override
    public final void onEnable() {
        Eagle.mc.field_71439_g.func_70095_a(false);
        super.onEnable();
    }
    
    @Override
    public final void onDisable() {
        KeyBinding.func_74510_a(Eagle.mc.field_71474_y.field_74311_E.func_151463_i(), false);
        super.onDisable();
    }
    
    static {
        lIllIlIlllI();
        Class169.a(1478197499470267011L, 5736048995637901009L, MethodHandles.lookup().lookupClass()).a(46974005823211L);
        final Cipher instance = Cipher.getInstance(Eagle.llllllIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Eagle.llllllIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(33624486564654L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(Eagle.llllllIIl[2].getBytes(Eagle.llllllIIl[3]))).intern();
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
    
    private static void lIllIlIlllI() {
        (llllllIIl = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Eagle.llllllIIl[1] = "DES";
        Eagle.llllllIIl[2] = "\u009fA\u008bè\u0006*\"\u001b";
        Eagle.llllllIIl[3] = "ISO-8859-1";
    }
    
    private static String lIllIlIlIll(final String s, final String s2) {
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
    
    private static String lIllIlIllIl(String s, final String s2) {
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
    
    private static String lIllIlIlIlI(final String s, final String s2) {
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
