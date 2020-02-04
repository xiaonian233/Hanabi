package ClassSub;

import net.minecraft.client.*;
import net.minecraft.potion.*;
import net.minecraft.block.material.*;
import net.minecraft.client.entity.*;
import net.minecraft.entity.player.*;
import net.minecraft.block.*;
import org.lwjgl.util.vector.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.world.*;
import net.minecraft.entity.ai.attributes.*;
import com.google.common.collect.*;
import java.util.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import java.lang.invoke.*;

public final class Class333
{
    private static Minecraft mc;
    private static final long a;
    
    public Class333() {
        super();
    }
    
    private static void portMove(final float n, final float n2, final float n3) {
        Class333.mc.field_71439_g.func_70107_b(-Math.sin(Math.toRadians(n)) * n2 + Class333.mc.field_71439_g.field_70165_t, n3 + Class333.mc.field_71439_g.field_70163_u, Math.cos(Math.toRadians(n)) * n2 + Class333.mc.field_71439_g.field_70161_v);
    }
    
    public static double getBaseMoveSpeed() {
        final int[] b = Class139.b();
        double n = 0.2873;
        final int[] array = b;
        int n3;
        final int n2 = n3 = (Minecraft.func_71410_x().field_71439_g.func_70644_a(Potion.field_76424_c) ? 1 : 0);
        if (array == null) {
            if (n2 == 0) {
                return n;
            }
            n3 = Minecraft.func_71410_x().field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c();
        }
        n = 0.2873 * (1.0 + 0.2 * (n3 + 1));
        return n;
    }
    
    private static float getDirection() {
        final int[] b = Class139.b();
        float field_70177_z = Class333.mc.field_71439_g.field_70177_z;
        final int[] array = b;
        final float field_70701_bs = Class333.mc.field_71439_g.field_70701_bs;
        if (array == null && field_70701_bs < 0.0f) {
            field_70177_z += 180.0f;
            goto Label_0045;
        }
        float n = field_70701_bs;
        float n4;
        int n3;
        final float n2 = n3 = (int)(n4 = fcmpg(Class333.mc.field_71439_g.field_70701_bs, 0.0f));
        Label_0120: {
            Label_0109: {
                if (array == null) {
                    if (n2 < 0) {
                        n = -0.5f;
                        if (array == null) {
                            break Label_0109;
                        }
                    }
                    final float n5;
                    n3 = (int)(n5 = (n4 = fcmpl(Class333.mc.field_71439_g.field_70701_bs, 0.0f)));
                }
                if (array != null) {
                    break Label_0120;
                }
                if (n2 > 0) {
                    n = 0.5f;
                }
            }
            n4 = (n3 = fcmpl(Class333.mc.field_71439_g.field_70702_br, 0.0f));
        }
        final float field_70702_br;
        if (array == null) {
            if (n3 > 0) {
                field_70177_z -= 90.0f * n;
            }
            field_70702_br = Class333.mc.field_71439_g.field_70702_br;
            final float n6 = 0.0f;
            if (array != null) {
                return field_70702_br * n6;
            }
            n4 = fcmpg(field_70702_br, 0.0f);
        }
        if (n4 < 0) {
            field_70177_z += 90.0f * n;
        }
        final float n6 = 0.017453292f;
        return field_70702_br * n6;
    }
    
    public static boolean isInWater() {
        return llllllllIIIl(Class333.mc.field_71441_e.func_180495_p(new BlockPos(Class333.mc.field_71439_g.field_70165_t, Class333.mc.field_71439_g.field_70163_u, Class333.mc.field_71439_g.field_70161_v)).func_177230_c().func_149688_o(), Material.field_151586_h);
    }
    
    private static void toFwd(final double n) {
        final float n2 = Class333.mc.field_71439_g.field_70177_z * 0.017453292f;
        final EntityPlayerSP field_71439_g = Class333.mc.field_71439_g;
        field_71439_g.field_70159_w -= MathHelper.func_76126_a(n2) * n;
        final EntityPlayerSP field_71439_g2 = Class333.mc.field_71439_g;
        field_71439_g2.field_70179_y += MathHelper.func_76134_b(n2) * n;
    }
    
    public static void setSpeed(final double n) {
        Class333.mc.field_71439_g.field_70159_w = -(Math.sin(getDirection()) * n);
        Class333.mc.field_71439_g.field_70179_y = Math.cos(getDirection()) * n;
    }
    
    public static double getSpeed() {
        return Math.sqrt(Minecraft.func_71410_x().field_71439_g.field_70159_w * Minecraft.func_71410_x().field_71439_g.field_70159_w + Minecraft.func_71410_x().field_71439_g.field_70179_y * Minecraft.func_71410_x().field_71439_g.field_70179_y);
    }
    
    private static Block getBlockUnderPlayer(final EntityPlayer entityPlayer) {
        return getBlock(new BlockPos(entityPlayer.field_70165_t, entityPlayer.field_70163_u - 1.0, entityPlayer.field_70161_v));
    }
    
    private static Block getBlock(final BlockPos blockPos) {
        return Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c();
    }
    
    private static Block getBlockAtPosC(final EntityPlayer entityPlayer, final double n, final double n2, final double n3) {
        return getBlock(new BlockPos(entityPlayer.field_70165_t - n, entityPlayer.field_70163_u - n2, entityPlayer.field_70161_v - n3));
    }
    
    private static ArrayList<Vector3f> vanillaTeleportPositions(final double n, final double n2, final double n3, final double n4) {
        final ArrayList<Vector3f> list = new ArrayList<Vector3f>();
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        final double n5 = n - func_71410_x.field_71439_g.field_70165_t;
        final double n6 = n2 - (func_71410_x.field_71439_g.field_70163_u + func_71410_x.field_71439_g.func_70047_e() + 1.1);
        final double n7 = n3 - func_71410_x.field_71439_g.field_70161_v;
        final int[] b = Class139.b();
        final float n8 = (float)(Math.atan2(n7, n5) * 180.0 / 3.141592653589793 - 90.0);
        final double n9 = n6;
        final double n10 = n5;
        final double n11 = n10 * n10;
        final double n12 = n7;
        Math.atan2(n9, Math.sqrt(n11 + n12 * n12));
        final int[] array = b;
        final double field_70165_t = func_71410_x.field_71439_g.field_70165_t;
        double field_70163_u = func_71410_x.field_71439_g.field_70163_u;
        final double field_70161_v = func_71410_x.field_71439_g.field_70161_v;
        double n13 = 1.0;
        double n14 = n4;
        while (true) {
            while (n14 < getDistance(func_71410_x.field_71439_g.field_70165_t, func_71410_x.field_71439_g.field_70163_u, func_71410_x.field_71439_g.field_70161_v, n, n2, n3)) {
                ++n13;
                n14 += n4;
                if (array != null) {
                    while (n14 < getDistance(func_71410_x.field_71439_g.field_70165_t, func_71410_x.field_71439_g.field_70163_u, func_71410_x.field_71439_g.field_70161_v, n, n2, n3)) {
                        final double n15 = func_71410_x.field_71439_g.field_70165_t - Math.sin(getDirection(n8)) * n14;
                        final double n16 = func_71410_x.field_71439_g.field_70161_v + Math.cos(getDirection(n8)) * n14;
                        field_70163_u -= (func_71410_x.field_71439_g.field_70163_u - n2) / n13;
                        list.add(new Vector3f((float)n15, (float)field_70163_u, (float)n16));
                        n14 += n4;
                        if (array != null) {
                            return list;
                        }
                        if (array != null) {
                            break;
                        }
                    }
                    list.add(new Vector3f((float)n, (float)n2, (float)n3));
                    return list;
                }
                if (array != null) {
                    break;
                }
            }
            n14 = n4;
            continue;
        }
    }
    
    private static float getDirection(float n) {
        final int[] b = Class139.b();
        final float field_70701_bs = Minecraft.func_71410_x().field_71439_g.field_70701_bs;
        if (b == null && field_70701_bs < 0.0f) {
            n += 180.0f;
            goto Label_0035;
        }
        float n2 = field_70701_bs;
        float n5;
        int n4;
        final float n3 = n4 = (int)(n5 = fcmpg(Minecraft.func_71410_x().field_71439_g.field_70701_bs, 0.0f));
        Label_0110: {
            Label_0099: {
                if (b == null) {
                    if (n3 < 0) {
                        n2 = -0.5f;
                        if (b == null) {
                            break Label_0099;
                        }
                    }
                    final float n6;
                    n4 = (int)(n6 = (n5 = fcmpl(Minecraft.func_71410_x().field_71439_g.field_70701_bs, 0.0f)));
                }
                if (b != null) {
                    break Label_0110;
                }
                if (n3 > 0) {
                    n2 = 0.5f;
                }
            }
            n5 = (n4 = fcmpl(Minecraft.func_71410_x().field_71439_g.field_70702_br, 0.0f));
        }
        final float field_70702_br;
        if (b == null) {
            if (n4 > 0) {
                n -= 90.0f * n2;
            }
            field_70702_br = Minecraft.func_71410_x().field_71439_g.field_70702_br;
            final float n7 = 0.0f;
            if (b != null) {
                return field_70702_br * n7;
            }
            n5 = fcmpg(field_70702_br, 0.0f);
        }
        if (n5 < 0) {
            n += 90.0f * n2;
        }
        final float n7 = 0.017453292f;
        return field_70702_br * n7;
    }
    
    private static double getDistance(final double n, final double n2, final double n3, final double n4, final double n5, final double n6) {
        final double n7 = n - n4;
        final double n8 = n2 - n5;
        final double n9 = n3 - n6;
        final double n10 = n7;
        final double n11 = n10 * n10;
        final double n12 = n8;
        final double n13 = n11 + n12 * n12;
        final double n14 = n9;
        return MathHelper.func_76133_a(n13 + n14 * n14);
    }
    
    public static boolean MovementInput() {
        final int[] b = Class139.b();
        final boolean press = ((IKeyBinding)Class333.mc.field_71474_y.field_74351_w).getPress();
        if (b == null) {
            if (!press) {
                final boolean press2 = ((IKeyBinding)Class333.mc.field_71474_y.field_74370_x).getPress();
                if (b == null) {
                    if (!press2) {
                        final boolean press3 = ((IKeyBinding)Class333.mc.field_71474_y.field_74366_z).getPress();
                        if (b == null) {
                            if (!press3) {
                                final boolean press4 = ((IKeyBinding)Class333.mc.field_71474_y.field_74368_y).getPress();
                                if (b == null) {
                                    if (!press4) {
                                        return false;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return press;
    }
    
    private static void blockHit(final Entity entity, final boolean b) {
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        final int[] b2 = Class139.b();
        final ItemStack func_71045_bC = func_71410_x.field_71439_g.func_71045_bC();
        final int[] array = b2;
        Object field_71439_g;
        final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(field_71439_g = func_71410_x.field_71439_g);
        if (array == null) {
            if (entityPlayerSP.func_71045_bC() == null) {
                return;
            }
            field_71439_g = entity;
        }
        if (field_71439_g != null) {
            double n = b ? 1 : 0;
            boolean b3 = b;
            if (array == null) {
                if (!b) {
                    return;
                }
                n = ((b3 = (func_71045_bC.func_77973_b() instanceof ItemSword)) ? 1 : 0);
            }
            final EntityPlayerSP field_71439_g2;
            Label_0089: {
                if (array == null) {
                    if (!b3) {
                        return;
                    }
                    field_71439_g2 = func_71410_x.field_71439_g;
                    if (array != null) {
                        break Label_0089;
                    }
                    n = dcmpl((double)field_71439_g2.field_70733_aJ, 0.2);
                }
                if (n <= 0) {
                    return;
                }
                final EntityPlayerSP field_71439_g3 = func_71410_x.field_71439_g;
            }
            field_71439_g2.func_71045_bC().func_77957_a((World)func_71410_x.field_71441_e, (EntityPlayer)func_71410_x.field_71439_g);
        }
    }
    
    private static float getItemAtkDamage(final ItemStack itemStack) {
        final int[] b = Class139.b();
        final Multimap func_111283_C = itemStack.func_111283_C();
        final int[] array = b;
        final Multimap multimap = func_111283_C;
        if (array != null || multimap.isEmpty()) {
            Object o;
            final Iterator iterator = (Iterator)(o = multimap.entries().iterator());
            if (array == null) {
                if (!iterator.hasNext()) {
                    return 1.0f;
                }
                o = iterator.next();
            }
            final AttributeModifier attributeModifier3;
            final AttributeModifier attributeModifier2;
            final AttributeModifier attributeModifier = attributeModifier2 = (attributeModifier3 = ((Map.Entry<K, AttributeModifier>)o).getValue());
            double func_111164_d = 0.0;
            Label_0111: {
                final AttributeModifier attributeModifier4;
                if (array == null) {
                    if (lllllllllIII(attributeModifier.func_111169_c(), 1)) {
                        attributeModifier4 = attributeModifier2;
                        if (array == null) {
                            if (lllllllllIII(attributeModifier4.func_111169_c(), 2)) {
                                func_111164_d = attributeModifier2.func_111164_d();
                                break Label_0111;
                            }
                        }
                    }
                }
                func_111164_d = attributeModifier4.func_111164_d() * 100.0;
            }
            final double n = func_111164_d;
            if (attributeModifier2.func_111164_d() > 1.0) {
                return 1.0f + (float)n;
            }
            return 1.0f;
        }
        return 1.0f;
    }
    
    private static int bestWeapon$49504ea4() {
        final Minecraft func_71410_x;
        (func_71410_x = Minecraft.func_71410_x()).field_71439_g.field_71071_by.field_70461_c = 0;
        final int[] b = Class139.b();
        int n = -1;
        int n2 = 1;
        int i = 0;
        final int[] array = b;
        while (i < 9) {
            func_71410_x.field_71439_g.field_71071_by.field_70461_c = i;
            final ItemStack func_70694_bm = func_71410_x.field_71439_g.func_70694_bm();
            if (array != null) {
                goto Label_0287;
            }
            if (array == null) {
                int n6 = 0;
                final int n7;
                Label_0265: {
                    if (func_70694_bm != null) {
                        final ItemStack itemStack = func_70694_bm;
                        final int[] b2 = Class139.b();
                        final Multimap func_111283_C = itemStack.func_111283_C();
                        final int[] array2 = b2;
                        final Multimap multimap = func_111283_C;
                        float n4 = 0.0f;
                        Label_0230: {
                            Label_0229: {
                                if (array2 != null || multimap.isEmpty()) {
                                    Object o;
                                    final Iterator iterator = (Iterator)(o = multimap.entries().iterator());
                                    if (array2 == null) {
                                        if (!iterator.hasNext()) {
                                            break Label_0229;
                                        }
                                        o = iterator.next();
                                    }
                                    final AttributeModifier attributeModifier3;
                                    final AttributeModifier attributeModifier2;
                                    final AttributeModifier attributeModifier = attributeModifier2 = (attributeModifier3 = ((Map.Entry<K, AttributeModifier>)o).getValue());
                                    double func_111164_d = 0.0;
                                    Label_0197: {
                                        final AttributeModifier attributeModifier4;
                                        if (array2 == null) {
                                            if (lllllllllIII(attributeModifier.func_111169_c(), 1)) {
                                                attributeModifier4 = attributeModifier2;
                                                if (array2 == null) {
                                                    if (lllllllllIII(attributeModifier4.func_111169_c(), 2)) {
                                                        func_111164_d = attributeModifier2.func_111164_d();
                                                        break Label_0197;
                                                    }
                                                }
                                            }
                                        }
                                        func_111164_d = attributeModifier4.func_111164_d() * 100.0;
                                    }
                                    final double n3 = func_111164_d;
                                    n4 = ((attributeModifier2.func_111164_d() > 1.0) ? (1.0f + (float)n3) : 1.0f);
                                    break Label_0230;
                                }
                            }
                            n4 = 1.0f;
                        }
                        final int n5 = n6 = (int)((int)n4 + EnchantmentHelper.func_152377_a(func_70694_bm, EnumCreatureAttribute.UNDEFINED));
                        n7 = n2;
                        if (array != null) {
                            break Label_0265;
                        }
                        if (lllllllllIlI(n5, n7)) {
                            n2 = n5;
                            n = i;
                        }
                    }
                    n6 = i;
                }
                i = (byte)(n6 + n7);
            }
            if (array != null) {
                break;
            }
        }
        final int n8 = n;
        if (array == null && lllllllllIII(n8, -1)) {
            return n;
        }
        return n8;
    }
    
    private static void shiftClick(final Item item) {
        final int[] b = Class139.b();
        int i = 9;
        final int[] array = b;
        while (i < 37) {
            final ItemStack func_75211_c = Class333.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
            if (array == null) {
                Label_0077: {
                    if (func_75211_c != null) {
                        final ItemStack itemStack = func_75211_c;
                        if (array == null) {
                            if (!llllllllIIIl(itemStack.func_77973_b(), item)) {
                                break Label_0077;
                            }
                            Class333.mc.field_71442_b.func_78753_a(0, i, 0, 1, (EntityPlayer)Class333.mc.field_71439_g);
                        }
                        if (array == null) {
                            break;
                        }
                    }
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
    }
    
    private static boolean hotbarIsFull() {
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        while (i <= 36) {
            final ItemStack func_70301_a = Class333.mc.field_71439_g.field_71071_by.func_70301_a(i);
            if (array == null) {
                if (func_70301_a == null) {
                    return false;
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
        return true;
    }
    
    public static void tellPlayer(final String s) {
        final int[] b = Class139.b();
        if (s != null) {
            final EntityPlayerSP field_71439_g = Class333.mc.field_71439_g;
            if (b == null) {
                if (field_71439_g == null) {
                    return;
                }
                final EntityPlayerSP field_71439_g2 = Class333.mc.field_71439_g;
            }
            field_71439_g.func_145747_a((IChatComponent)new ChatComponentText(s));
        }
    }
    
    public static boolean isMoving() {
        final int[] b = Class139.b();
        final boolean field_70123_F = Class333.mc.field_71439_g.field_70123_F;
        if (b == null) {
            if (!field_70123_F) {
                final boolean func_70093_af = Class333.mc.field_71439_g.func_70093_af();
                if (b == null) {
                    if (!func_70093_af) {
                        final float n = fcmpl(Class333.mc.field_71439_g.field_71158_b.field_78900_b, 0.0f);
                        if (b == null) {
                            if (n == 0) {
                                final float n2 = fcmpl(Class333.mc.field_71439_g.field_71158_b.field_78902_a, 0.0f);
                                if (b == null) {
                                    if (n2 == 0) {
                                        return false;
                                    }
                                }
                            }
                        }
                        return n != 0.0f;
                    }
                }
            }
        }
        return field_70123_F;
    }
    
    public static boolean isMoving2() {
        final int[] b = Class139.b();
        final float n = fcmpl(Class333.mc.field_71439_g.field_70701_bs, 0.0f);
        if (b == null) {
            if (n == 0) {
                final float n2 = fcmpl(Class333.mc.field_71439_g.field_70702_br, 0.0f);
                if (b == null) {
                    if (n2 == 0) {
                        return false;
                    }
                }
            }
        }
        return n != 0.0f;
    }
    
    private static void blinkToPos(final double[] array, final BlockPos blockPos, final double n, final double[] array2) {
        final int[] b = Class139.b();
        double n2 = array[0];
        double n3 = array[1];
        final int[] array3 = b;
        double n4 = array[2];
        final double n5 = blockPos.func_177958_n() + 0.5;
        final double n6 = blockPos.func_177956_o() + 1.0;
        final double n7 = blockPos.func_177952_p() + 0.5;
        double n8 = Math.abs(n2 - n5) + Math.abs(n3 - n6) + Math.abs(n4 - n7);
        int n9 = 0;
        while (n8 > n) {
            n8 = Math.abs(n2 - n5) + Math.abs(n3 - n6) + Math.abs(n4 - n7);
            final int n10 = n9;
            if (array3 == null && (lllllllllIlI(n10, 120) && array3 == null)) {
                break;
            }
            final double n11 = n2 - n5;
            final double n12 = n3 - n6;
            final double n13 = n4 - n7;
            final double n14 = ((n9 & 0x1) == 0x0) ? array2[0] : array2[1];
            double n20;
            double n19;
            double n18;
            int n17;
            int n16;
            final int n15 = n16 = (n17 = (int)(n18 = (n19 = (n20 = dcmpg(n11, 0.0)))));
            if (array3 == null) {
                Label_0252: {
                    if (n15 < 0) {
                        final double abs = Math.abs(n11);
                        final double n21 = n14;
                        if (array3 == null) {
                            if (abs > n21) {
                                n2 += n14;
                                if (array3 == null) {
                                    break Label_0252;
                                }
                            }
                            Math.abs(n11);
                        }
                        n2 = abs + n21;
                    }
                }
                final int n22;
                n16 = (n22 = (n17 = (int)(n18 = (n19 = (n20 = dcmpl(n11, 0.0))))));
            }
            if (array3 == null) {
                Label_0318: {
                    if (n15 > 0) {
                        final double abs2 = Math.abs(n11);
                        final double n23 = n14;
                        if (array3 == null) {
                            if (abs2 > n23) {
                                n2 -= n14;
                                if (array3 == null) {
                                    break Label_0318;
                                }
                            }
                            Math.abs(n11);
                        }
                        n2 = abs2 - n23;
                    }
                }
                n17 = (n16 = (int)(n18 = (n19 = (n20 = dcmpg(n12, 0.0)))));
            }
            if (array3 == null) {
                Label_0390: {
                    if (n16 < 0) {
                        final double abs3 = Math.abs(n12);
                        double abs4 = 0.25;
                        if (array3 == null) {
                            if (abs3 > 0.25) {
                                n3 += 0.25;
                                if (array3 == null) {
                                    break Label_0390;
                                }
                            }
                            abs4 = Math.abs(n12);
                        }
                        n3 = abs3 + abs4;
                    }
                }
                n18 = (n17 = (int)(n19 = (n20 = dcmpl(n12, 0.0))));
            }
            if (array3 == null) {
                Label_0462: {
                    if (n17 > 0) {
                        final double abs5 = Math.abs(n12);
                        double abs6 = 0.25;
                        if (array3 == null) {
                            if (abs5 > 0.25) {
                                n3 -= 0.25;
                                if (array3 == null) {
                                    break Label_0462;
                                }
                            }
                            abs6 = Math.abs(n12);
                        }
                        n3 = abs5 - abs6;
                    }
                }
                n19 = (n18 = (n20 = dcmpg(n13, 0.0)));
            }
            if (array3 == null) {
                Label_0528: {
                    if (n18 < 0) {
                        final double abs7 = Math.abs(n13);
                        final double n24 = n14;
                        if (array3 == null) {
                            if (abs7 > n24) {
                                n4 += n14;
                                if (array3 == null) {
                                    break Label_0528;
                                }
                            }
                            Math.abs(n13);
                        }
                        n4 = abs7 + n24;
                    }
                }
                n20 = (n19 = dcmpl(n13, 0.0));
            }
            Label_0594: {
                final double abs8;
                final double n25;
                Label_0591: {
                    if (array3 == null) {
                        if (n19 <= 0) {
                            break Label_0594;
                        }
                        abs8 = Math.abs(n13);
                        n25 = n14;
                        if (array3 != null) {
                            break Label_0591;
                        }
                        n20 = dcmpl(abs8, n25);
                    }
                    if (n20 > 0) {
                        n4 -= n14;
                        if (array3 == null) {
                            break Label_0594;
                        }
                    }
                    Math.abs(n13);
                }
                n4 = abs8 - n25;
            }
            Minecraft.func_71410_x().func_147114_u().func_147297_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(n2, n3, n4, true));
            ++n9;
            if (array3 != null) {
                break;
            }
        }
    }
    
    static {
        Class169.a(7768650321146399172L, 6041534508621272275L, MethodHandles.lookup().lookupClass()).a(135018122204620L);
        Class333.mc = Minecraft.func_71410_x();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIIIIIIIIIIII$255f299(final int n) {
        return n <= 36;
    }
    
    private static boolean lllllllllIlI(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean llllllllIIIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lllllllIlllI(final int n) {
        return n < 0;
    }
    
    private static boolean llllllllIIII(final int n) {
        return n > 0;
    }
    
    private static boolean lllllllllIII(final int n, final int n2) {
        return n != n2;
    }
    
    private static int lllllllIllIl$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lllllllIllII$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
    
    private static int llllllllIIlI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int llllllllIlII$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int llllllllIIll$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
    
    private static int llllllllIllI$25399e8(final double n) {
        return dcmpl(n, 0.2);
    }
    
    private static int llllllllIlll$25399e8(final double n) {
        return dcmpl(n, 1.0);
    }
    
    private static int lIIIIIIIIIIll$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIIIIIIIIIllI$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIIIIIIIIIlll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIIIIIIIlIII$25399e8(final double n) {
        return dcmpg(n, 0.0);
    }
}
