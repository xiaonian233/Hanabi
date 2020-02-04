package cn.Hanabi.modules.World;

import net.minecraft.util.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.multiplayer.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.entity.player.*;
import net.minecraft.world.*;
import net.minecraft.init.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class SpeedMine extends Mod
{
    private boolean bzs;
    private float bzx;
    private BlockPos blockPos;
    private EnumFacing facing;
    private C07PacketPlayerDigging curPacket;
    private static final long b;
    private static final String c;
    private static final String[] lIlllIIIlIl;
    
    public SpeedMine() {
        super("SpeedMine", Category.WORLD);
        this.bzs = false;
        this.bzx = 0.0f;
    }
    
    @EventTarget
    private void onDamageBlock(final EventPacket eventPacket) {
        final int[] b = Class139.b();
        final Packet packet = eventPacket.packet;
        if (b == null) {
            if (!(packet instanceof C07PacketPlayerDigging)) {
                return;
            }
            final Packet packet2 = eventPacket.packet;
        }
        if (llllllllllIl(packet, this.curPacket)) {
            final PlayerControllerMP field_71442_b = SpeedMine.mc.field_71442_b;
            if (b == null) {
                if (field_71442_b.func_78749_i()) {
                    return;
                }
                final PlayerControllerMP field_71442_b2 = SpeedMine.mc.field_71442_b;
            }
            if (field_71442_b != null) {
                final C07PacketPlayerDigging c07PacketPlayerDigging;
                C07PacketPlayerDigging$Action c07PacketPlayerDigging$Action2;
                final C07PacketPlayerDigging$Action c07PacketPlayerDigging$Action = c07PacketPlayerDigging$Action2 = (c07PacketPlayerDigging = (C07PacketPlayerDigging)eventPacket.packet).func_180762_c();
                C07PacketPlayerDigging$Action c07PacketPlayerDigging$Action4;
                final C07PacketPlayerDigging$Action c07PacketPlayerDigging$Action3 = c07PacketPlayerDigging$Action4 = C07PacketPlayerDigging$Action.START_DESTROY_BLOCK;
                if (b == null) {
                    if (lIIIIIIIIIIlI(c07PacketPlayerDigging$Action, c07PacketPlayerDigging$Action3)) {
                        this.bzs = true;
                        this.blockPos = c07PacketPlayerDigging.func_179715_a();
                        this.facing = c07PacketPlayerDigging.func_179714_b();
                        this.bzx = 0.0f;
                        if (b == null) {
                            return;
                        }
                    }
                    final C07PacketPlayerDigging$Action func_180762_c;
                    c07PacketPlayerDigging$Action2 = (func_180762_c = c07PacketPlayerDigging.func_180762_c());
                    final C07PacketPlayerDigging$Action abort_DESTROY_BLOCK;
                    c07PacketPlayerDigging$Action4 = (abort_DESTROY_BLOCK = C07PacketPlayerDigging$Action.ABORT_DESTROY_BLOCK);
                }
                Label_0142: {
                    if (b == null) {
                        if (!llllllllllIl(c07PacketPlayerDigging$Action, c07PacketPlayerDigging$Action3)) {
                            break Label_0142;
                        }
                        c07PacketPlayerDigging$Action2 = c07PacketPlayerDigging.func_180762_c();
                        c07PacketPlayerDigging$Action4 = C07PacketPlayerDigging$Action.STOP_DESTROY_BLOCK;
                    }
                    if (!lIIIIIIIIIIlI(c07PacketPlayerDigging$Action2, c07PacketPlayerDigging$Action4)) {
                        return;
                    }
                }
                this.bzs = false;
                this.blockPos = null;
                this.facing = null;
            }
        }
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        final PlayerControllerMP field_71442_b = SpeedMine.mc.field_71442_b;
        final int[] array = b;
        final boolean func_78749_i = SpeedMine.mc.field_71442_b.func_78749_i();
        Label_0043: {
            if (array == null) {
                if (func_78749_i && array == null) {
                    return;
                }
                if (array != null) {
                    break Label_0043;
                }
                final boolean bzs = this.bzs;
            }
            if (!func_78749_i) {
                return;
            }
        }
        this.bzx += (float)(SpeedMine.mc.field_71441_e.func_180495_p(this.blockPos).func_177230_c().func_180647_a((EntityPlayer)SpeedMine.mc.field_71439_g, (World)SpeedMine.mc.field_71441_e, this.blockPos) * 1.4);
        final float n = fcmpl(this.bzx, 1.0f);
        if (array == null) {
            if (n < 0) {
                return;
            }
            SpeedMine.mc.field_71441_e.func_180501_a(this.blockPos, Blocks.field_150350_a.func_176223_P(), 11);
        }
        final C07PacketPlayerDigging curPacket = new C07PacketPlayerDigging(C07PacketPlayerDigging$Action.STOP_DESTROY_BLOCK, this.blockPos, this.facing);
        this.curPacket = curPacket;
        SpeedMine.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)curPacket);
        this.bzx = 0.0f;
        this.bzs = false;
    }
    
    static {
        lllllllIlIIl();
        Class169.a(3689413617275302446L, 1061687704629415215L, MethodHandles.lookup().lookupClass()).a(204164809087501L);
        final Cipher instance = Cipher.getInstance(SpeedMine.lIlllIIIlIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(SpeedMine.lIlllIIIlIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(86761467882751L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(SpeedMine.lIlllIIIlIl[2].getBytes(SpeedMine.lIlllIIIlIl[3]))).intern();
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
    
    private static void lllllllIlIIl() {
        (lIlllIIIlIl = new String[4])[0] = "DES/CBC/PKCS5Padding";
        SpeedMine.lIlllIIIlIl[1] = "DES";
        SpeedMine.lIlllIIIlIl[2] = "\u009f\u0081\\Ñ¥\"ÿÉÕÑOõõ\u0088Ø\u0001";
        SpeedMine.lIlllIIIlIl[3] = "ISO-8859-1";
    }
    
    private static String lllllllIIlll(String s, final String s2) {
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
    
    private static String lllllllIlIII(final String s, final String s2) {
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
    
    private static boolean llllllllllIl(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIIIIIIIIIlI(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIIIIIIIlIll(final int n) {
        return n >= 0;
    }
    
    private static int lIIIIIIIIlIlI$2548a28(final float n) {
        return fcmpl(n, 1.0f);
    }
}
