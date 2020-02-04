package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.client.*;
import net.minecraft.block.material.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class TP2Bed extends Mod
{
    private BlockPos playerBed;
    private BlockPos fuckingBed;
    private ArrayList<BlockPos> posList;
    private Class220 timer;
    private Value<Double> delay;
    private ArrayList<Class63> path;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIIIlIIIl;
    
    public TP2Bed() {
        super("TP2Bed", Category.PLAYER);
        this.timer = new Class220();
        this.delay = new Value<Double>("TP2Bed_Delay", 600.0, 200.0, 3000.0, 100.0);
        this.path = new ArrayList<Class63>();
    }
    
    @Override
    public final void onEnable() {
        final int[] b = Class139.b();
        try {
            (this.posList = new ArrayList<BlockPos>(Class315.list)).sort(this::lambda$onEnable$0);
            final ArrayList<BlockPos> posList = this.posList;
            if (b == null) {
                if (posList.size() < 3) {
                    this.set(false);
                }
                final ArrayList list = new ArrayList(this.posList);
            }
            final ArrayList<BlockPos> list2 = posList;
            int n = 1;
            while (true) {
                for (final BlockPos blockPos : list2) {
                    final int n2 = ++n % 2;
                    if (b != null) {
                        Label_0334: {
                            if (n2 != 0) {
                                int field_70124_G;
                                final int n3 = field_70124_G = (TP2Bed.mc.field_71439_g.field_70124_G ? 1 : 0);
                                if (b == null) {
                                    if (n3 == 0) {
                                        break Label_0334;
                                    }
                                    final boolean onGround;
                                    field_70124_G = ((onGround = Class33.isOnGround(0.01)) ? 1 : 0);
                                }
                                if (b == null) {
                                    if (n3 == 0) {
                                        break Label_0334;
                                    }
                                    field_70124_G = 0;
                                }
                                int i = field_70124_G;
                                while (true) {
                                    while (i < 49) {
                                        TP2Bed.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(TP2Bed.mc.field_71439_g.field_70165_t, TP2Bed.mc.field_71439_g.field_70163_u + 0.06249, TP2Bed.mc.field_71439_g.field_70161_v, false));
                                        TP2Bed.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(TP2Bed.mc.field_71439_g.field_70165_t, TP2Bed.mc.field_71439_g.field_70163_u, TP2Bed.mc.field_71439_g.field_70161_v, false));
                                        ++i;
                                        if (b != null) {
                                            TP2Bed.mc.field_71439_g.field_70747_aH = 0.0f;
                                            break Label_0334;
                                        }
                                        if (b != null) {
                                            break;
                                        }
                                    }
                                    TP2Bed.mc.field_71439_g.field_70122_E = false;
                                    Class33.setMotion(0.0);
                                    continue;
                                }
                            }
                        }
                        this.fuckingBed = this.posList.get(0);
                        return;
                    }
                    if (b == null) {
                        if (n2 == 1) {
                            this.posList.remove(blockPos);
                        }
                    }
                    if (b != null) {
                        break;
                    }
                }
                this.posList.get(0);
                this.posList.remove(0);
                if (b == null) {
                    final boolean field_70122_E = TP2Bed.mc.field_71439_g.field_70122_E;
                    continue;
                }
                break;
            }
        }
        catch (Throwable t) {
            this.set(false);
        }
    }
    
    @EventTarget
    private static void onPacket$1d2175e0() {
    }
    
    @EventTarget
    private void onRender$1f20be12() {
        final int[] b = Class139.b();
        try {
            for (final Class63 class63 : this.path) {
                TP2Bed.mc.func_175598_ae();
                final double x = class63.x;
                TP2Bed.mc.func_175598_ae();
                final double n = x;
                TP2Bed.mc.func_175598_ae();
                final double y = class63.y;
                TP2Bed.mc.func_175598_ae();
                final double n2 = y;
                TP2Bed.mc.func_175598_ae();
                final double z = class63.z;
                TP2Bed.mc.func_175598_ae();
                Class69.drawEntityESP(n, n2, z, TP2Bed.mc.field_71439_g.func_174813_aQ().field_72336_d - TP2Bed.mc.field_71439_g.func_174813_aQ().field_72340_a, TP2Bed.mc.field_71439_g.func_174813_aQ().field_72337_e - TP2Bed.mc.field_71439_g.func_174813_aQ().field_72338_b + 0.25, 0.0f, 1.0f, 0.0f, 0.2f, 0.0f, 0.0f, 0.0f, 1.0f, 2.0f);
                if (b != null) {
                    return;
                }
                if (b != null) {
                    break;
                }
            }
        }
        catch (Exception ex) {}
    }
    
    @Override
    public final void onDisable() {
        Class94.canSendMotionPacket = true;
        super.onDisable();
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        final Iterator<BlockPos> iterator = this.posList.iterator();
        final int[] array = b;
        while (true) {
            while (iterator.hasNext()) {
                final BlockPos blockPos = iterator.next();
                int size;
                int delayComplete;
                final int n = delayComplete = (size = ((TP2Bed.mc.field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockBed) ? 1 : 0));
                if (array != null) {
                    if (array == null) {
                        if (n < 0) {
                            Class94.canSendMotionPacket = true;
                            Class333.tellPlayer("§b[Hanabi]Teleported! :3");
                            this.set(false);
                        }
                        size = (delayComplete = (this.timer.isDelayComplete(this.delay.value) ? 1 : 0));
                    }
                    TP2Bed tp2Bed2 = null;
                    Label_0443: {
                        if (array == null) {
                            Label_0428: {
                                if (delayComplete != 0) {
                                    final Class63 class63 = new Class63(TP2Bed.mc.field_71439_g.field_70165_t, TP2Bed.mc.field_71439_g.field_70163_u, TP2Bed.mc.field_71439_g.field_70161_v);
                                    final Class63 class64 = new Class63(this.fuckingBed.func_177958_n() + 1, this.fuckingBed.func_177956_o(), this.fuckingBed.func_177952_p() + 1);
                                    TP2Bed tp2Bed = this;
                                    if (array == null) {
                                        this.path = computePath(class63, class64);
                                        if (TP2Bed.mc.field_71439_g.func_70011_f((double)this.fuckingBed.func_177958_n(), (double)this.fuckingBed.func_177956_o(), (double)this.fuckingBed.func_177952_p()) > 4.0) {
                                            Class333.tellPlayer("§b[Hanabi]Trying to teleport...");
                                            Class94.canSendMotionPacket = false;
                                            for (final Class63 class65 : this.path) {
                                                TP2Bed.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(class65.x, class65.y, class65.z, true));
                                                if (array != null) {
                                                    break Label_0428;
                                                }
                                                if (array != null) {
                                                    break;
                                                }
                                            }
                                        }
                                        tp2Bed = this;
                                    }
                                    tp2Bed.timer.lastMs = System.currentTimeMillis();
                                }
                            }
                            tp2Bed2 = this;
                            if (array != null) {
                                break Label_0443;
                            }
                            size = this.posList.size();
                        }
                        if (size != 0) {
                            return;
                        }
                        tp2Bed2 = this;
                    }
                    tp2Bed2.set(false);
                    return;
                }
                Label_0116: {
                    if (array == null) {
                        if (n != 0) {
                            break Label_0116;
                        }
                        Class333.tellPlayer(String.valueOf(new StringBuilder("§b[Hanabi]Destory!").append(blockPos)));
                        this.posList.remove(blockPos);
                    }
                    this.posList.sort(this::lambda$onUpdate$1);
                    this.fuckingBed = this.posList.get(0);
                }
                if (array != null) {
                    break;
                }
            }
            int size;
            final double n2;
            int delayComplete = (int)(n2 = (size = dcmpg(TP2Bed.mc.field_71439_g.func_70011_f((double)this.fuckingBed.func_177958_n(), (double)this.fuckingBed.func_177956_o(), (double)this.fuckingBed.func_177952_p()), 4.0)));
            continue;
        }
    }
    
    private static double getDistanceToBlock(final BlockPos blockPos) {
        return TP2Bed.mc.field_71439_g.func_70011_f((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
    }
    
    private static boolean canPassThrow(final BlockPos blockPos) {
        final int[] b = Class139.b();
        final Block func_177230_c = Minecraft.func_71410_x().field_71441_e.func_180495_p(new BlockPos(blockPos.func_177958_n(), blockPos.func_177956_o(), blockPos.func_177952_p())).func_177230_c();
        final int[] array = b;
        Material material2;
        final Material material = material2 = func_177230_c.func_149688_o();
        Material material4;
        final Material material3 = material4 = Material.field_151579_a;
        if (array == null) {
            if (!llIIIIllIl(material, material3)) {
                return true;
            }
            final Material func_149688_o;
            material2 = (func_149688_o = func_177230_c.func_149688_o());
            final Material field_151585_k;
            material4 = (field_151585_k = Material.field_151585_k);
        }
        Block block5 = null;
        Block block4 = null;
        Block block3 = null;
        Block block2 = null;
        final Block block;
        Label_0090: {
            if (array == null) {
                if (!llIIIIllIl(material, material3)) {
                    return true;
                }
                block = (block2 = (block3 = (block4 = (block5 = func_177230_c))));
                if (array != null) {
                    break Label_0090;
                }
                material2 = block.func_149688_o();
                material4 = Material.field_151582_l;
            }
            if (!llIIIIllIl(material2, material4)) {
                return true;
            }
            final Block block6;
            block2 = (block6 = (block3 = (block4 = (block5 = func_177230_c))));
        }
        if (array == null) {
            if (!llIIIIllIl(block, Blocks.field_150468_ap)) {
                return true;
            }
            block3 = (block2 = (block4 = (block5 = func_177230_c)));
        }
        if (array == null) {
            if (!llIIIIllIl(block2, Blocks.field_150355_j)) {
                return true;
            }
            block4 = (block3 = (block5 = func_177230_c));
        }
        Block block7;
        BlockDynamicLiquid field_150444_as;
        final BlockDynamicLiquid blockDynamicLiquid = field_150444_as = (BlockDynamicLiquid)(block7 = (Block)Blocks.field_150358_i);
        if (array == null) {
            if (!llIIIIllIl(block3, blockDynamicLiquid)) {
                return true;
            }
            block5 = (block4 = func_177230_c);
            block7 = (Block)(field_150444_as = (BlockDynamicLiquid)Blocks.field_150444_as);
        }
        if (array == null) {
            if (!llIIIIllIl(block4, field_150444_as)) {
                return true;
            }
            block5 = func_177230_c;
            block7 = Blocks.field_150472_an;
        }
        if (block5 != block7) {
            return false;
        }
        return true;
    }
    
    private static ArrayList<Class63> computePath(Class63 addVector, final Class63 class63) {
        final int[] b = Class139.b();
        final Class63 class64 = addVector;
        final BlockPos blockPos = new BlockPos(new Vec3(class64.x, class64.y, class64.z));
        final int[] b2 = Class139.b();
        final Block func_177230_c = Minecraft.func_71410_x().field_71441_e.func_180495_p(new BlockPos(blockPos.func_177958_n(), blockPos.func_177956_o(), blockPos.func_177952_p())).func_177230_c();
        final int[] array = b2;
        Material material2;
        final Material material = material2 = func_177230_c.func_149688_o();
        Material material4;
        final Material material3 = material4 = Material.field_151579_a;
        boolean b3 = false;
        Label_0211: {
            Label_0206: {
                if (array == null) {
                    if (!llIIIIllIl(material, material3)) {
                        break Label_0206;
                    }
                    final Material func_149688_o;
                    material2 = (func_149688_o = func_177230_c.func_149688_o());
                    final Material field_151585_k;
                    material4 = (field_151585_k = Material.field_151585_k);
                }
                Block block5 = null;
                Block block4 = null;
                Block block3 = null;
                Block block2 = null;
                final Block block;
                Label_0132: {
                    if (array == null) {
                        if (!llIIIIllIl(material, material3)) {
                            break Label_0206;
                        }
                        block = (block2 = (block3 = (block4 = (block5 = func_177230_c))));
                        if (array != null) {
                            break Label_0132;
                        }
                        material2 = block.func_149688_o();
                        material4 = Material.field_151582_l;
                    }
                    if (!llIIIIllIl(material2, material4)) {
                        break Label_0206;
                    }
                    final Block block6;
                    block2 = (block6 = (block3 = (block4 = (block5 = func_177230_c))));
                }
                if (array == null) {
                    if (!llIIIIllIl(block, Blocks.field_150468_ap)) {
                        break Label_0206;
                    }
                    block3 = (block2 = (block4 = (block5 = func_177230_c)));
                }
                if (array == null) {
                    if (!llIIIIllIl(block2, Blocks.field_150355_j)) {
                        break Label_0206;
                    }
                    block4 = (block3 = (block5 = func_177230_c));
                }
                Block block7;
                BlockDynamicLiquid field_150444_as;
                final BlockDynamicLiquid blockDynamicLiquid = field_150444_as = (BlockDynamicLiquid)(block7 = (Block)Blocks.field_150358_i);
                if (array == null) {
                    if (!llIIIIllIl(block3, blockDynamicLiquid)) {
                        break Label_0206;
                    }
                    block5 = (block4 = func_177230_c);
                    block7 = (Block)(field_150444_as = (BlockDynamicLiquid)Blocks.field_150444_as);
                }
                if (array == null) {
                    if (!llIIIIllIl(block4, field_150444_as)) {
                        break Label_0206;
                    }
                    block5 = func_177230_c;
                    block7 = Blocks.field_150472_an;
                }
                if (block5 != block7) {
                    b3 = false;
                    break Label_0211;
                }
            }
            b3 = true;
        }
        if (!b3) {
            addVector = addVector.addVector(0.0, 1.0, 0.0);
        }
        final Class174 class65;
        (class65 = new Class174(addVector, class63)).compute();
        int n = 0;
        Class63 class66 = null;
        Class63 class67 = null;
        final ArrayList<Class63> list = new ArrayList<Class63>();
        ArrayList<Class63> path;
        for (final Class63 class68 : path = class65.path) {
            final int n3;
            final int n2 = n3 = n;
            Label_0639: {
                if ((b != null || n2 != 0) && (b != null || n2 != path.size() - 1)) {
                    final double squareDistanceTo = class68.squareDistanceTo(class67);
                    double x = 25.0;
                    int n6 = 0;
                    Label_0610: {
                        if (b == null) {
                            if (squareDistanceTo > 25.0 && b == null) {
                                break Label_0610;
                            }
                            final double x2 = class67.x;
                            x = class68.x;
                        }
                        final double min = Math.min(squareDistanceTo, x);
                        final double min2 = Math.min(class67.y, class68.y);
                        final double min3 = Math.min(class67.z, class68.z);
                        final double max = Math.max(class67.x, class68.x);
                        final double max2 = Math.max(class67.y, class68.y);
                        final double max3 = Math.max(class67.z, class68.z);
                        int n4 = (int)min;
                        do {
                            double n5 = 0.0;
                            Label_0493: {
                                n5 = dcmpg((double)n4, max);
                            }
                            Label_0499:
                            while (n5 <= 0) {
                                n6 = (int)min2;
                                if (b == null) {
                                    int n7 = n6;
                                    do {
                                        Label_0519:
                                        double n8 = dcmpg((double)n7, max2);
                                        Label_0525:
                                        while (n8 <= 0) {
                                            final int n9 = (int)(n5 = (int)min3);
                                            if (b == null) {
                                                int n10 = n9;
                                                while (n10 <= max3) {
                                                    final boolean checkPositionValidity$3b4dbe76;
                                                    final int n11 = (int)(n8 = ((checkPositionValidity$3b4dbe76 = Class174.checkPositionValidity$3b4dbe76(n4, n7, n10)) ? 1 : 0));
                                                    if (b != null) {
                                                        continue Label_0525;
                                                    }
                                                    if ((b != null || n11 == 0) && b == null) {
                                                        break Label_0610;
                                                    }
                                                    ++n10;
                                                    if (b != null) {
                                                        break;
                                                    }
                                                }
                                                ++n7;
                                                continue Label_0519;
                                            }
                                            continue Label_0499;
                                        }
                                        break;
                                    } while (b == null);
                                    ++n4;
                                    continue Label_0493;
                                }
                                break;
                            }
                            break;
                        } while (b == null);
                    }
                    if (b == null) {
                        if (n6 != 0) {
                            break Label_0639;
                        }
                        list.add(class66.addVector(0.5, 0.0, 0.5));
                    }
                    class67 = class66;
                }
                else {
                    final Class63 class69 = class66;
                    if (b == null) {
                        if (class69 != null) {
                            list.add(class66.addVector(0.5, 0.0, 0.5));
                        }
                        list.add(class68.addVector(0.5, 0.0, 0.5));
                    }
                    class67 = class69;
                    if (b != null) {
                        goto Label_0358;
                    }
                }
            }
            class66 = class68;
            ++n;
            if (b != null) {
                break;
            }
        }
        return list;
    }
    
    private int lambda$onUpdate$1(final BlockPos blockPos, final BlockPos blockPos2) {
        return (int)(getDistanceToBlock(blockPos) - getDistanceToBlock(blockPos2));
    }
    
    private int lambda$onEnable$0(final BlockPos blockPos, final BlockPos blockPos2) {
        return (int)(getDistanceToBlock(blockPos) - getDistanceToBlock(blockPos2));
    }
    
    static {
        lIlllllIll();
        Class169.a(-4951111296986521079L, 4479888207926400859L, MethodHandles.lookup().lookupClass()).a(101568445877071L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(TP2Bed.lIIIlIIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(TP2Bed.lIIIlIIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(95909452569379L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = TP2Bed.lIIIlIIIl[2]).length();
        int n4 = 40;
        int n5 = -1;
    Label_0150:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s3.getBytes(TP2Bed.lIIIlIIIl[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = TP2Bed.lIIIlIIIl[3]).length();
                            n4 = 24;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0150;
                        }
                    }
                    ++n5;
                    final String s4 = s;
                    final int n8 = n5;
                    s3 = s4.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        c = c2;
        d = new String[5];
    }
    
    private static Throwable a(final Throwable t) {
        return t;
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
    
    private static String b(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x35AA;
        if (TP2Bed.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = TP2Bed.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(TP2Bed.lIIIlIIIl[5]);
                    array[1] = SecretKeyFactory.getInstance(TP2Bed.lIIIlIIIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    TP2Bed.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(TP2Bed.lIIIlIIIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            TP2Bed.d[n3] = b(((Cipher)array[0]).doFinal(TP2Bed.c[n3].getBytes(TP2Bed.lIIIlIIIl[8])));
        }
        return TP2Bed.d[n3];
    }
    
    private static void lIlllllIll() {
        (lIIIlIIIl = new String[12])[0] = "DES/CBC/PKCS5Padding";
        TP2Bed.lIIIlIIIl[1] = "DES";
        TP2Bed.lIIIlIIIl[2] = "Qó²\u007fý\u009aúò\u0006ø¨mý:Wñ&éBtÈQuB\u0019Ø×ÙkGtÂæ[a\u0098Ûê.\u008f@$ÿtç\u0015o\u0085óvólû·\u001f\u0082\u0094(óÂ¦\u0007Zw«6îH¹\u001dî5\u008f¤0Ègó\u0096\u0096WÕíH\u008fè\u0081ãW\u0014?Fá\u0080Æ\u0018\u001dÜo?d¥'0o\u0010n^\u0088mOócÇÙ+ð\u008dñ[U÷";
        TP2Bed.lIIIlIIIl[3] = "àé·Á¢ÎY\u0088Új}1NWáe£²px\u0002e©Æ8\u0003øù\u001fggz\u009f«i\u0099\u008fÐãHÇ\u0015lø¥ç{ÐÎæD{£:\u0006\t\u008f?\u0013è\u0098®\u0085C¦«\u0091Û*z¥yRÍ\u0016kH-k\u0091×";
        TP2Bed.lIIIlIIIl[4] = "ISO-8859-1";
        TP2Bed.lIIIlIIIl[5] = "DES/CBC/PKCS5Padding";
        TP2Bed.lIIIlIIIl[6] = "DES";
        TP2Bed.lIIIlIIIl[7] = "你是不是气急败坏恼羞成怒无言以对了酒囊饭袋你在想怎么扳回局势是吗你看看你所谓的词汇真的没有什么客观价值了呢你看看你的字里行间有哪一句经过大脑不知廉耻可是你一直被大家蒙在谷里NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u2009\u2001\u200d";
        TP2Bed.lIIIlIIIl[8] = "ISO-8859-1";
        TP2Bed.lIIIlIIIl[9] = "你是不是气急败坏恼羞成怒无言以对了酒囊饭袋你在想怎么扳回局势是吗你看看你所谓的词汇真的没有什么客观价值了呢你看看你的字里行间有哪一句经过大脑不知廉耻可是你一直被大家蒙在谷里NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u2009\u2001\u200d";
        TP2Bed.lIIIlIIIl[10] = " : ";
        TP2Bed.lIIIlIIIl[11] = " : ";
    }
    
    private static String lIllllIllI(final String s, final String s2) {
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
    
    private static String lIllllIlll(String s, final String s2) {
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
    
    private static String lIlllllIII(final String s, final String s2) {
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
    
    private static boolean llIIIIllIl(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean llIIIIllll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean llIIIIlIll(final int n) {
        return n < 0;
    }
    
    private static boolean llIIIlIIlI(final int n) {
        return n <= 0;
    }
    
    private static boolean llIIIIllII(final int n) {
        return n > 0;
    }
    
    private static int llIIIIlIIl$25399e8(final double n) {
        return dcmpl(n, 4.0);
    }
    
    private static int llIIIIlIII$25399e8(final double n) {
        return dcmpg(n, 4.0);
    }
    
    private static int llIIIlIIII$25399e8(final double n) {
        return dcmpl(n, 25.0);
    }
    
    private static int llIIIlIIIl(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
