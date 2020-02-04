package ClassSub;

import net.minecraft.client.*;
import net.minecraft.block.material.*;
import net.minecraft.entity.*;
import net.minecraft.network.*;
import net.minecraft.enchantment.*;
import net.minecraft.potion.*;
import net.minecraft.block.*;
import net.minecraft.client.entity.*;
import net.minecraft.network.play.client.*;
import net.minecraft.util.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.modules.Player.*;
import cn.Hanabi.modules.Combat.*;
import net.minecraft.entity.item.*;
import net.minecraft.item.*;
import net.minecraft.block.state.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class160
{
    private static Minecraft mc;
    private static Random rand;
    private static boolean spectator;
    private static ArrayList<Integer> blackList;
    private static double x;
    private static double y;
    private static double z;
    private static double xPreEn;
    private static double yPreEn;
    private static double zPreEn;
    private static double xPre;
    private static double yPre;
    private static double zPre;
    private static Vec3 lastLoc;
    private static final long a;
    private static final String b;
    private static final String[] llllll;
    
    public Class160() {
        super();
    }
    
    private static void preInfiniteReach$a71984c() {
    }
    
    private static void postInfiniteReach() {
    }
    
    private static boolean infiniteReach(final double n, final double n2, final double n3, final ArrayList<Vec3> list, final ArrayList<Vec3> list2, final EntityLivingBase entityLivingBase) {
        Class160.xPreEn = entityLivingBase.field_70165_t;
        Class160.yPreEn = entityLivingBase.field_70163_u;
        Class160.zPreEn = entityLivingBase.field_70161_v;
        final double field_70165_t = Class160.mc.field_71439_g.field_70165_t;
        final double field_70163_u = Class160.mc.field_71439_g.field_70163_u;
        final double field_70161_v = Class160.mc.field_71439_g.field_70161_v;
        double n4 = 1;
        boolean b = false;
        final int[] b2 = Class139.b();
        final boolean func_70093_af = Class160.mc.field_71439_g.func_70093_af();
        list2.clear();
        list.clear();
        final double n5 = n2 / n;
        final int[] array = b2;
        int n6 = 0;
        int n7 = 0;
        while (n7 < n) {
            ++n6;
            if (array == null) {
                if (n2 * n6 > n && array == null) {
                    break;
                }
                ++n7;
            }
            if (array != null) {
                break;
            }
        }
        MovingObjectPosition movingObjectPosition = null;
        final Vec3 vec3 = new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v);
        final Vec3 vec4 = new Vec3(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v);
        boolean b3 = true;
        Label_1028: {
            MovingObjectPosition movingObjectPosition5 = null;
            MovingObjectPosition movingObjectPosition4 = null;
            MovingObjectPosition movingObjectPosition3 = null;
            MovingObjectPosition movingObjectPosition2 = null;
            Label_0379: {
                Label_0315: {
                    if (array == null) {
                        if (rayTraceWide$4035701d(vec3, vec4)) {
                            break Label_0315;
                        }
                        final Vec3 vec5 = new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), Class160.mc.field_71439_g.field_70161_v);
                        final Vec3 vec6 = new Vec3(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), entityLivingBase.field_70161_v);
                        b3 = true;
                    }
                    movingObjectPosition = (movingObjectPosition2 = (movingObjectPosition3 = (movingObjectPosition4 = (movingObjectPosition5 = rayTracePos$2f3fbb3f(vec3, vec4, b3)))));
                    if (array != null) {
                        break Label_0379;
                    }
                    if (movingObjectPosition == null) {
                        break Label_1028;
                    }
                }
                movingObjectPosition3 = (movingObjectPosition2 = (movingObjectPosition4 = (movingObjectPosition5 = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, Class160.mc.field_71439_g.field_70163_u, entityLivingBase.field_70161_v), true))));
            }
            final MovingObjectPosition movingObjectPosition6 = movingObjectPosition2;
            Label_0962: {
                Label_0902: {
                    Label_0486: {
                        if (array == null) {
                            if (movingObjectPosition3 != null) {
                                break Label_0486;
                            }
                            movingObjectPosition4 = (movingObjectPosition = (movingObjectPosition5 = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), Class160.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, Class160.mc.field_71439_g.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), entityLivingBase.field_70161_v), true)));
                        }
                        if (array != null) {
                            break Label_0962;
                        }
                        if (movingObjectPosition4 == null) {
                            break Label_0902;
                        }
                    }
                    MovingObjectPosition movingObjectPosition7 = null;
                    final MovingObjectPosition movingObjectPosition8 = movingObjectPosition6;
                    if (array != null || movingObjectPosition8 == null) {
                        movingObjectPosition7 = movingObjectPosition8;
                    }
                    MovingObjectPosition movingObjectPosition10;
                    final MovingObjectPosition movingObjectPosition9 = movingObjectPosition10 = movingObjectPosition;
                    if (array == null) {
                        if (movingObjectPosition9 == null) {
                            movingObjectPosition7 = movingObjectPosition6;
                        }
                        final MovingObjectPosition movingObjectPosition11;
                        movingObjectPosition10 = (movingObjectPosition11 = movingObjectPosition7);
                    }
                    Label_0897: {
                        if (array == null) {
                            if (movingObjectPosition9 == null) {
                                break Label_0897;
                            }
                            movingObjectPosition10 = movingObjectPosition7;
                        }
                        if (movingObjectPosition10.func_178782_a() != null) {
                            final BlockPos func_178782_a = movingObjectPosition7.func_178782_a();
                            b = true;
                            Class160.y = func_178782_a.func_177984_a().func_177956_o();
                            Class160.yPreEn = func_178782_a.func_177984_a().func_177956_o();
                            Block block = null;
                            Boolean b4 = Boolean.FALSE;
                            int n8 = 0;
                            while (n8 < n3) {
                                final MovingObjectPosition rayTracePos$2f3fbb3f = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, (double)(func_178782_a.func_177956_o() + n8), Class160.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, (double)(func_178782_a.func_177956_o() + n8), entityLivingBase.field_70161_v), true);
                                if (array != null) {
                                    break Label_0897;
                                }
                                final MovingObjectPosition movingObjectPosition12 = rayTracePos$2f3fbb3f;
                                Label_0847: {
                                    if (array != null || (movingObjectPosition12 != null || array != null)) {
                                        final BlockPos func_178782_a2 = movingObjectPosition12.func_178782_a();
                                        if (array == null) {
                                            if (func_178782_a2 == null && array == null) {
                                                break Label_0847;
                                            }
                                            rayTracePos$2f3fbb3f.func_178782_a();
                                        }
                                        Block func_177230_c;
                                        final Block block2 = func_177230_c = Class160.mc.field_71441_e.func_180495_p(func_178782_a2).func_177230_c();
                                        if (array == null) {
                                            if (lIIlIIll(block2.func_149688_o(), Material.field_151579_a)) {
                                                block = block2;
                                                if (array == null) {
                                                    break Label_0847;
                                                }
                                            }
                                            func_177230_c = block;
                                        }
                                        final boolean b5 = func_177230_c instanceof BlockFence;
                                        Class160.y = func_178782_a.func_177956_o() + n8;
                                        Class160.yPreEn = func_178782_a.func_177956_o() + n8;
                                        final boolean b7;
                                        final boolean b6 = b7 = b5;
                                        final double n9;
                                        if (array == null) {
                                            if (b6) {
                                                ++Class160.y;
                                                ++Class160.yPreEn;
                                                n9 = dcmpl((double)(n8 + 1), n3);
                                                if (array == null) {
                                                    if (n9 > 0) {
                                                        b4 = Boolean.FALSE;
                                                        if (array == null) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        b4 = (n9 != 0.0);
                                        if (array == null) {
                                            break;
                                        }
                                    }
                                }
                                ++n8;
                                if (array != null) {
                                    break;
                                }
                            }
                            final double field_70165_t2 = Class160.mc.field_71439_g.field_70165_t;
                            final double field_70161_v2 = Class160.mc.field_71439_g.field_70161_v;
                            final boolean booleanValue = b4;
                            if (array != null || booleanValue) {
                                return booleanValue;
                            }
                            if (array == null) {
                                break Label_0897;
                            }
                        }
                        return false;
                    }
                    if (array == null) {
                        break Label_1028;
                    }
                }
                movingObjectPosition5 = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v), new Vec3(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u, entityLivingBase.field_70161_v), false);
            }
            final MovingObjectPosition movingObjectPosition13 = movingObjectPosition5;
            if (array == null) {
                if (movingObjectPosition13 != null && movingObjectPosition13.field_72308_g == null) {
                    Class160.y = Class160.mc.field_71439_g.field_70163_u;
                    Class160.yPreEn = Class160.mc.field_71439_g.field_70163_u;
                    if (array == null) {
                        break Label_1028;
                    }
                }
                Class160.y = Class160.mc.field_71439_g.field_70163_u;
            }
            Class160.yPreEn = entityLivingBase.field_70163_u;
        }
        boolean b8;
        int n10 = (b8 = true) ? 1 : 0;
        if (array == null) {
            n10 = ((b8 = func_70093_af) ? 1 : 0);
        }
        if (array == null) {
            if (b8) {
                Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class160.mc.field_71439_g, C0BPacketEntityAction$Action.STOP_SNEAKING));
            }
            n10 = 0;
        }
        int i = n10;
        while (true) {
            while (i < n6) {
                final int size;
                final int n11 = size = i;
                final int n13;
                final int n12 = n13 = 1;
                if (array != null) {
                    int j = size - n13;
                    while (true) {
                        while (j >= 0) {
                            Class160.x = list2.get(j).field_72450_a;
                            Class160.y = list2.get(j).field_72448_b;
                            Class160.z = list2.get(j).field_72449_c;
                            sendPacket$1c1dda81(list2);
                            --j;
                            if (array != null) {
                                boolean b11;
                                boolean b10;
                                final boolean b9 = b10 = (b11 = (n4 != 0.0));
                                if (array == null) {
                                    if (!b9) {
                                        final boolean b12 = func_70093_af;
                                        if (array == null) {
                                            if (b12) {
                                                Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class160.mc.field_71439_g, C0BPacketEntityAction$Action.START_SNEAKING));
                                            }
                                            list2.clear();
                                            list.clear();
                                        }
                                        return b12;
                                    }
                                    b11 = (b10 = func_70093_af);
                                }
                                if (array == null) {
                                    if (b10) {
                                        Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class160.mc.field_71439_g, C0BPacketEntityAction$Action.START_SNEAKING));
                                    }
                                    b11 = true;
                                }
                                return b11;
                            }
                            if (array != null) {
                                break;
                            }
                        }
                        Class160.x = Class160.mc.field_71439_g.field_70165_t;
                        Class160.y = Class160.mc.field_71439_g.field_70163_u;
                        Class160.z = Class160.mc.field_71439_g.field_70161_v;
                        sendPacket$1c1dda81(list2);
                        continue;
                    }
                }
                if (array == null) {
                    if (n11 != n12) {
                        goto Label_1141;
                    }
                    final boolean b13 = b;
                    if (array == null && b13) {
                        Class160.x = Class160.mc.field_71439_g.field_70165_t;
                        Class160.y = Class160.yPreEn;
                        Class160.z = Class160.mc.field_71439_g.field_70161_v;
                        sendPacket$1c1dda81(list2);
                        goto Label_1141;
                    }
                }
                Label_1824: {
                    if (lIIllIlI(n11, n12)) {
                        final double n14 = Class160.mc.field_71439_g.field_70165_t - Class160.xPreEn;
                        final double n15 = Class160.mc.field_71439_g.field_70163_u - Class160.yPreEn;
                        final double n16 = Class160.mc.field_71439_g.field_70161_v - Class160.zPreEn;
                        final double n17 = n5 * i;
                        final double field_70165_t3 = Class160.mc.field_71439_g.field_70165_t;
                        final double n18 = n14;
                        final double n19 = n17;
                        if (array == null) {
                            Class160.x = field_70165_t3 - n18 * n19;
                            final double field_70163_u2 = Class160.mc.field_71439_g.field_70163_u;
                            if (b) {}
                        }
                        Class160.y = field_70165_t3 - n18 * n19;
                        Class160.z = Class160.mc.field_71439_g.field_70161_v - n16 * n17;
                        sendPacket$1c1dda81(list2);
                        if (array == null) {
                            break Label_1824;
                        }
                    }
                    final double n20 = Class160.mc.field_71439_g.field_70165_t - Class160.xPreEn;
                    final double n21 = Class160.mc.field_71439_g.field_70163_u - Class160.yPreEn;
                    final double n22 = Class160.mc.field_71439_g.field_70161_v - Class160.zPreEn;
                    final double n23 = n5 * i;
                    final double field_70165_t4 = Class160.mc.field_71439_g.field_70165_t;
                    final double n24 = n20;
                    final double n25 = n23;
                    if (array == null) {
                        Class160.x = field_70165_t4 - n24 * n25;
                        final double field_70163_u3 = Class160.mc.field_71439_g.field_70163_u;
                        if (b) {}
                    }
                    Class160.y = field_70165_t4 - n24 * n25;
                    Class160.z = Class160.mc.field_71439_g.field_70161_v - n22 * n23;
                    sendPacket$1c1dda81(list2);
                    final double n26 = Class160.x - Class160.xPreEn;
                    final double n27 = Class160.z - Class160.zPreEn;
                    final double n28 = Class160.y - entityLivingBase.field_70163_u;
                    final double n29 = n26;
                    final double n30 = n29 * n29;
                    final double n31 = n27;
                    final double sqrt;
                    double n34;
                    double n33;
                    final int n32 = (int)(n33 = (n34 = dcmpl(sqrt = Math.sqrt(n30 + n31 * n31), 4.0)));
                    Label_1562: {
                        Label_1554: {
                            if (array == null) {
                                if (n32 > 0) {
                                    Class160.x = Class160.xPreEn;
                                    Class160.y = Class160.yPreEn;
                                    Class160.z = Class160.zPreEn;
                                    sendPacket$1c1dda81(list2);
                                    if (array == null) {
                                        break Label_1554;
                                    }
                                }
                                final double n35;
                                n33 = (n35 = (n34 = dcmpl(sqrt, 0.05)));
                            }
                            if (array != null) {
                                break Label_1562;
                            }
                            if (n32 > 0) {
                                final int n36 = (int)(n33 = (n34 = (b ? 1 : 0)));
                                if (array != null) {
                                    break Label_1562;
                                }
                                if (n36 != 0) {
                                    Class160.x = Class160.xPreEn;
                                    Class160.y = Class160.yPreEn;
                                    Class160.z = Class160.zPreEn;
                                    sendPacket$1c1dda81(list2);
                                }
                            }
                        }
                        n34 = (n33 = dcmpg(Math.abs(n28), n3));
                    }
                    Label_1822: {
                        if (array == null) {
                            if (n33 < 0) {
                                final float n37 = (float)(n34 = fcmpl(Class160.mc.field_71439_g.func_70032_d((Entity)entityLivingBase), 4.0f));
                                if (array != null) {
                                    break Label_1822;
                                }
                                if (n37 >= 0) {
                                    Class160.x = Class160.xPreEn;
                                    Class160.y = entityLivingBase.field_70163_u;
                                    Class160.z = Class160.zPreEn;
                                    sendPacket$1c1dda81(list2);
                                    final int[] b14 = Class139.b();
                                    Class160.mc.field_71439_g.func_71038_i();
                                    Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C02PacketUseEntity((Entity)entityLivingBase, C02PacketUseEntity$Action.ATTACK));
                                    final float func_152377_a = EnchantmentHelper.func_152377_a(Class160.mc.field_71439_g.func_70694_bm(), entityLivingBase.func_70668_bt());
                                    final int[] array2 = b14;
                                    boolean b15;
                                    boolean func_70090_H;
                                    int n39;
                                    final int n38 = n39 = ((func_70090_H = (b15 = fcmpl(Class160.mc.field_71439_g.field_70143_R, 0.0f))) ? 1 : 0);
                                    Label_1791: {
                                        if (array2 == null) {
                                            if (n38 <= 0) {
                                                break Label_1791;
                                            }
                                            final boolean b16;
                                            n39 = ((b16 = (func_70090_H = (b15 = Class160.mc.field_71439_g.field_70122_E))) ? 1 : 0);
                                        }
                                        if (array2 == null) {
                                            if (n38 != 0) {
                                                break Label_1791;
                                            }
                                            func_70090_H = ((n39 = ((b15 = Class160.mc.field_71439_g.func_70617_f_()) ? 1 : 0)) != 0);
                                        }
                                        if (array2 == null) {
                                            if (n39 != 0) {
                                                break Label_1791;
                                            }
                                            b15 = (func_70090_H = Class160.mc.field_71439_g.func_70090_H());
                                        }
                                        if (array2 == null) {
                                            if (func_70090_H) {
                                                break Label_1791;
                                            }
                                            final EntityPlayerSP field_71439_g = Class160.mc.field_71439_g;
                                            if (array2 != null) {
                                                break Label_1791;
                                            }
                                            b15 = field_71439_g.func_70644_a(Potion.field_76440_q);
                                        }
                                        if (!b15) {
                                            final Entity field_70154_o = Class160.mc.field_71439_g.field_70154_o;
                                        }
                                    }
                                    if (func_152377_a > 0.0f) {
                                        Class160.mc.field_71439_g.func_71047_c((Entity)entityLivingBase);
                                    }
                                    if (array == null) {
                                        break Label_1824;
                                    }
                                }
                            }
                            n34 = 0;
                        }
                    }
                    n4 = n34;
                }
                ++i;
                if (array != null) {
                    break;
                }
            }
            int size = list2.size();
            int n13 = 2;
            continue;
        }
    }
    
    private static boolean infiniteReach(final double n, final double n2, final double n3, final ArrayList<Vec3> list, final ArrayList<Vec3> list2, final BlockPos blockPos) {
        list2.clear();
        final int[] b = Class139.b();
        list.clear();
        final double n4 = n2 / n;
        final int[] array = b;
        int n5 = 0;
        int n6 = 0;
        while (true) {
            while (n6 < n) {
                ++n5;
                if (array == null) {
                    final double n7 = dcmpl(n2 * n5, n);
                    if (array != null) {
                        final double xPreEn = n7 + 0.5;
                        final double y = blockPos.func_177956_o() + 1.0;
                        final double zPreEn = blockPos.func_177952_p() + 0.5;
                        Class160.xPreEn = xPreEn;
                        Class160.yPreEn = y;
                        Class160.zPreEn = zPreEn;
                        final double field_70165_t = Class160.mc.field_71439_g.field_70165_t;
                        final double field_70163_u = Class160.mc.field_71439_g.field_70163_u;
                        final double field_70161_v = Class160.mc.field_71439_g.field_70161_v;
                        int n8 = true ? 1 : 0;
                        boolean b2 = false;
                        final boolean func_70093_af = Class160.mc.field_71439_g.func_70093_af();
                        MovingObjectPosition movingObjectPosition = null;
                        final Vec3 vec3 = new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v);
                        final Vec3 vec4 = new Vec3(xPreEn, y, zPreEn);
                        boolean b3 = true;
                        Label_1017: {
                            MovingObjectPosition movingObjectPosition5 = null;
                            MovingObjectPosition movingObjectPosition4 = null;
                            MovingObjectPosition movingObjectPosition3 = null;
                            MovingObjectPosition movingObjectPosition2 = null;
                            Label_0384: {
                                Label_0326: {
                                    if (array == null) {
                                        if (rayTraceWide$4035701d(vec3, vec4)) {
                                            break Label_0326;
                                        }
                                        final Vec3 vec5 = new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), Class160.mc.field_71439_g.field_70161_v);
                                        final Vec3 vec6 = new Vec3(xPreEn, y + Class160.mc.field_71439_g.func_70047_e(), zPreEn);
                                        b3 = true;
                                    }
                                    movingObjectPosition = (movingObjectPosition2 = (movingObjectPosition3 = (movingObjectPosition4 = (movingObjectPosition5 = rayTracePos$2f3fbb3f(vec3, vec4, b3)))));
                                    if (array != null) {
                                        break Label_0384;
                                    }
                                    if (movingObjectPosition == null) {
                                        break Label_1017;
                                    }
                                }
                                movingObjectPosition3 = (movingObjectPosition2 = (movingObjectPosition4 = (movingObjectPosition5 = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, Class160.mc.field_71439_g.field_70163_u, zPreEn), true))));
                            }
                            final MovingObjectPosition movingObjectPosition6 = movingObjectPosition2;
                            Label_0951: {
                                Label_0900: {
                                    Label_0485: {
                                        if (array == null) {
                                            if (movingObjectPosition3 != null) {
                                                break Label_0485;
                                            }
                                            movingObjectPosition4 = (movingObjectPosition = (movingObjectPosition5 = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), Class160.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, Class160.mc.field_71439_g.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), zPreEn), true)));
                                        }
                                        if (array != null) {
                                            break Label_0951;
                                        }
                                        if (movingObjectPosition4 == null) {
                                            break Label_0900;
                                        }
                                    }
                                    MovingObjectPosition movingObjectPosition7 = null;
                                    final MovingObjectPosition movingObjectPosition8 = movingObjectPosition6;
                                    if (array != null || movingObjectPosition8 == null) {
                                        movingObjectPosition7 = movingObjectPosition8;
                                    }
                                    MovingObjectPosition movingObjectPosition10;
                                    final MovingObjectPosition movingObjectPosition9 = movingObjectPosition10 = movingObjectPosition;
                                    if (array == null) {
                                        if (movingObjectPosition9 == null) {
                                            movingObjectPosition7 = movingObjectPosition6;
                                        }
                                        final MovingObjectPosition movingObjectPosition11;
                                        movingObjectPosition10 = (movingObjectPosition11 = movingObjectPosition7);
                                    }
                                    Label_0895: {
                                        if (array == null) {
                                            if (movingObjectPosition9 == null) {
                                                break Label_0895;
                                            }
                                            movingObjectPosition10 = movingObjectPosition7;
                                        }
                                        if (movingObjectPosition10.func_178782_a() != null) {
                                            final BlockPos func_178782_a = movingObjectPosition7.func_178782_a();
                                            b2 = true;
                                            Class160.y = func_178782_a.func_177984_a().func_177956_o();
                                            Class160.yPreEn = func_178782_a.func_177984_a().func_177956_o();
                                            Block block = null;
                                            Boolean b4 = Boolean.FALSE;
                                            int n9 = 0;
                                            while (n9 < n3) {
                                                final MovingObjectPosition rayTracePos$2f3fbb3f = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, (double)(func_178782_a.func_177956_o() + n9), Class160.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, (double)(func_178782_a.func_177956_o() + n9), zPreEn), true);
                                                if (array != null) {
                                                    break Label_0895;
                                                }
                                                final MovingObjectPosition movingObjectPosition12 = rayTracePos$2f3fbb3f;
                                                Label_0845: {
                                                    if (array != null || (movingObjectPosition12 != null || array != null)) {
                                                        final BlockPos func_178782_a2 = movingObjectPosition12.func_178782_a();
                                                        if (array == null) {
                                                            if (func_178782_a2 == null && array == null) {
                                                                break Label_0845;
                                                            }
                                                            rayTracePos$2f3fbb3f.func_178782_a();
                                                        }
                                                        Block func_177230_c;
                                                        final Block block2 = func_177230_c = Class160.mc.field_71441_e.func_180495_p(func_178782_a2).func_177230_c();
                                                        if (array == null) {
                                                            if (lIIlIIll(block2.func_149688_o(), Material.field_151579_a)) {
                                                                block = block2;
                                                                if (array == null) {
                                                                    break Label_0845;
                                                                }
                                                            }
                                                            func_177230_c = block;
                                                        }
                                                        final boolean b5 = func_177230_c instanceof BlockFence;
                                                        Class160.y = func_178782_a.func_177956_o() + n9;
                                                        Class160.yPreEn = func_178782_a.func_177956_o() + n9;
                                                        final boolean b7;
                                                        final boolean b6 = b7 = b5;
                                                        final double n10;
                                                        if (array == null) {
                                                            if (b6) {
                                                                ++Class160.y;
                                                                ++Class160.yPreEn;
                                                                n10 = dcmpl((double)(n9 + 1), n3);
                                                                if (array == null) {
                                                                    if (n10 > 0) {
                                                                        b4 = Boolean.FALSE;
                                                                        if (array == null) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        b4 = (n10 != 0.0);
                                                        if (array == null) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                ++n9;
                                                if (array != null) {
                                                    break;
                                                }
                                            }
                                            final double field_70165_t2 = Class160.mc.field_71439_g.field_70165_t;
                                            final double field_70161_v2 = Class160.mc.field_71439_g.field_70161_v;
                                            final boolean booleanValue = b4;
                                            if (array != null || booleanValue) {
                                                return booleanValue;
                                            }
                                            if (array == null) {
                                                break Label_0895;
                                            }
                                        }
                                        return false;
                                    }
                                    if (array == null) {
                                        break Label_1017;
                                    }
                                }
                                movingObjectPosition5 = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v), new Vec3(xPreEn, y, zPreEn), false);
                            }
                            final MovingObjectPosition movingObjectPosition13 = movingObjectPosition5;
                            if (array == null) {
                                if (movingObjectPosition13 != null && movingObjectPosition13.field_72308_g == null) {
                                    Class160.y = Class160.mc.field_71439_g.field_70163_u;
                                    Class160.yPreEn = Class160.mc.field_71439_g.field_70163_u;
                                    if (array == null) {
                                        break Label_1017;
                                    }
                                }
                                Class160.y = Class160.mc.field_71439_g.field_70163_u;
                            }
                            Class160.yPreEn = y;
                        }
                        boolean b8;
                        int n11 = (b8 = true) ? 1 : 0;
                        if (array == null) {
                            n11 = ((b8 = func_70093_af) ? 1 : 0);
                        }
                        if (array == null) {
                            if (b8) {
                                Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class160.mc.field_71439_g, C0BPacketEntityAction$Action.STOP_SNEAKING));
                            }
                            n11 = 0;
                        }
                        int i = n11;
                        while (true) {
                            while (i < n5) {
                                final int size;
                                final int n12 = size = i;
                                final int n14;
                                final int n13 = n14 = 1;
                                if (array != null) {
                                    int j = size - n14;
                                    while (true) {
                                        while (j >= 0) {
                                            Class160.x = list2.get(j).field_72450_a;
                                            Class160.y = list2.get(j).field_72448_b;
                                            Class160.z = list2.get(j).field_72449_c;
                                            sendPacket$1c1dda81(list2);
                                            --j;
                                            if (array != null) {
                                                int n16;
                                                int n15;
                                                final boolean b9 = (n15 = (n16 = n8)) != 0;
                                                if (array == null) {
                                                    if (!b9) {
                                                        final boolean b10 = func_70093_af;
                                                        if (array == null) {
                                                            if (b10) {
                                                                Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class160.mc.field_71439_g, C0BPacketEntityAction$Action.START_SNEAKING));
                                                            }
                                                            list2.clear();
                                                            list.clear();
                                                        }
                                                        return b10;
                                                    }
                                                    n16 = (n15 = (func_70093_af ? 1 : 0));
                                                }
                                                if (array == null) {
                                                    if (n15 != 0) {
                                                        Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class160.mc.field_71439_g, C0BPacketEntityAction$Action.START_SNEAKING));
                                                    }
                                                    n16 = (true ? 1 : 0);
                                                }
                                                return n16 != 0;
                                            }
                                            if (array != null) {
                                                break;
                                            }
                                        }
                                        Class160.x = Class160.mc.field_71439_g.field_70165_t;
                                        Class160.y = Class160.mc.field_71439_g.field_70163_u;
                                        Class160.z = Class160.mc.field_71439_g.field_70161_v;
                                        sendPacket$1c1dda81(list2);
                                        continue;
                                    }
                                }
                                if (array == null) {
                                    if (n12 != n13) {
                                        goto Label_1131;
                                    }
                                    final boolean b11 = b2;
                                    if (array == null && b11) {
                                        Class160.x = Class160.mc.field_71439_g.field_70165_t;
                                        Class160.y = Class160.yPreEn;
                                        Class160.z = Class160.mc.field_71439_g.field_70161_v;
                                        sendPacket$1c1dda81(list2);
                                        goto Label_1131;
                                    }
                                }
                                Label_1692: {
                                    if (lIIllIlI(n12, n13)) {
                                        final double n17 = Class160.mc.field_71439_g.field_70165_t - Class160.xPreEn;
                                        final double n18 = Class160.mc.field_71439_g.field_70163_u - Class160.yPreEn;
                                        final double n19 = Class160.mc.field_71439_g.field_70161_v - Class160.zPreEn;
                                        final double n20 = n4 * i;
                                        final double field_70165_t3 = Class160.mc.field_71439_g.field_70165_t;
                                        final double n21 = n17;
                                        final double n22 = n20;
                                        if (array == null) {
                                            Class160.x = field_70165_t3 - n21 * n22;
                                            final double field_70163_u2 = Class160.mc.field_71439_g.field_70163_u;
                                            if (b2) {}
                                        }
                                        Class160.y = field_70165_t3 - n21 * n22;
                                        Class160.z = Class160.mc.field_71439_g.field_70161_v - n19 * n20;
                                        sendPacket$1c1dda81(list2);
                                        if (array == null) {
                                            break Label_1692;
                                        }
                                    }
                                    final double n23 = Class160.mc.field_71439_g.field_70165_t - Class160.xPreEn;
                                    final double n24 = Class160.mc.field_71439_g.field_70163_u - Class160.yPreEn;
                                    final double n25 = Class160.mc.field_71439_g.field_70161_v - Class160.zPreEn;
                                    final double n26 = n4 * i;
                                    final double field_70165_t4 = Class160.mc.field_71439_g.field_70165_t;
                                    final double n27 = n23;
                                    final double n28 = n26;
                                    if (array == null) {
                                        Class160.x = field_70165_t4 - n27 * n28;
                                        final double field_70163_u3 = Class160.mc.field_71439_g.field_70163_u;
                                        if (b2) {}
                                    }
                                    Class160.y = field_70165_t4 - n27 * n28;
                                    Class160.z = Class160.mc.field_71439_g.field_70161_v - n25 * n26;
                                    sendPacket$1c1dda81(list2);
                                    final double n29 = Class160.x - Class160.xPreEn;
                                    final double n30 = Class160.z - Class160.zPreEn;
                                    final double n31 = Class160.y - y;
                                    final double n32 = n29;
                                    final double n33 = n32 * n32;
                                    final double n34 = n30;
                                    final double sqrt;
                                    double n37;
                                    double n36;
                                    final double n35 = n36 = (n37 = dcmpl(sqrt = Math.sqrt(n33 + n34 * n34), 4.0));
                                    Label_1549: {
                                        Label_1541: {
                                            if (array == null) {
                                                if (n35 > 0) {
                                                    Class160.x = Class160.xPreEn;
                                                    Class160.y = Class160.yPreEn;
                                                    Class160.z = Class160.zPreEn;
                                                    sendPacket$1c1dda81(list2);
                                                    if (array == null) {
                                                        break Label_1541;
                                                    }
                                                }
                                                final double n38;
                                                n36 = (n38 = (n37 = dcmpl(sqrt, 0.05)));
                                            }
                                            if (array != null) {
                                                break Label_1549;
                                            }
                                            if (n35 > 0) {
                                                final int n39 = (int)(n36 = (n37 = (b2 ? 1 : 0)));
                                                if (array != null) {
                                                    break Label_1549;
                                                }
                                                if (n39 != 0) {
                                                    Class160.x = Class160.xPreEn;
                                                    Class160.y = Class160.yPreEn;
                                                    Class160.z = Class160.zPreEn;
                                                    sendPacket$1c1dda81(list2);
                                                }
                                            }
                                        }
                                        n36 = dcmpg(Math.abs(n31), n3);
                                    }
                                    final double n40;
                                    if (array == null) {
                                        if (n36 < 0) {
                                            n40 = dcmpl(Class160.mc.field_71439_g.func_70011_f(xPreEn, y, zPreEn), 4.0);
                                            if (array == null) {
                                                if (n40 >= 0) {
                                                    Class160.x = Class160.xPreEn;
                                                    Class160.y = y;
                                                    Class160.z = Class160.zPreEn;
                                                    sendPacket$1c1dda81(list2);
                                                    Class160.mc.field_71439_g.func_71038_i();
                                                    Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging$Action.START_DESTROY_BLOCK, blockPos, EnumFacing.UP));
                                                    Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging$Action.STOP_DESTROY_BLOCK, blockPos, EnumFacing.UP));
                                                    if (array == null) {
                                                        break Label_1692;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    n8 = (int)n40;
                                }
                                ++i;
                                if (array != null) {
                                    break;
                                }
                            }
                            int size = list2.size();
                            int n14 = 2;
                            continue;
                        }
                    }
                    if (n7 > 0 && array == null) {
                        break;
                    }
                    ++n6;
                }
                if (array != null) {
                    break;
                }
            }
            blockPos.func_177958_n();
            continue;
        }
    }
    
    private static boolean infiniteReach$5d9754f3(final Vec3 vec3, final double n, final double n2, final double n3, final ArrayList<Vec3> list, final ArrayList<Vec3> list2) {
        list2.clear();
        final int[] b = Class139.b();
        list.clear();
        final double n4 = n2 / n;
        final int[] array = b;
        int n5 = 0;
        int n6 = 0;
        while (true) {
            while (n6 < n) {
                ++n5;
                if (array == null) {
                    final double n7 = dcmpl(n2 * n5, n);
                    if (array != null) {
                        double n8 = n7;
                        int n9 = 0;
                        final int func_70093_af = Class160.mc.field_71439_g.func_70093_af() ? 1 : 0;
                        MovingObjectPosition movingObjectPosition = null;
                        final Vec3 vec4 = new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v);
                        final Vec3 vec5 = new Vec3(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
                        boolean b2 = true;
                        Label_1024: {
                            MovingObjectPosition movingObjectPosition5 = null;
                            MovingObjectPosition movingObjectPosition4 = null;
                            MovingObjectPosition movingObjectPosition3 = null;
                            MovingObjectPosition movingObjectPosition2 = null;
                            Label_0372: {
                                Label_0310: {
                                    if (array == null) {
                                        if (rayTraceWide$4035701d(vec4, vec5)) {
                                            break Label_0310;
                                        }
                                        final Vec3 vec6 = new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), Class160.mc.field_71439_g.field_70161_v);
                                        final Vec3 vec7 = new Vec3(vec3.field_72450_a, vec3.field_72448_b + Class160.mc.field_71439_g.func_70047_e(), vec3.field_72449_c);
                                        b2 = true;
                                    }
                                    movingObjectPosition = (movingObjectPosition2 = (movingObjectPosition3 = (movingObjectPosition4 = (movingObjectPosition5 = rayTracePos$2f3fbb3f(vec4, vec5, b2)))));
                                    if (array != null) {
                                        break Label_0372;
                                    }
                                    if (movingObjectPosition == null) {
                                        break Label_1024;
                                    }
                                }
                                movingObjectPosition3 = (movingObjectPosition2 = (movingObjectPosition4 = (movingObjectPosition5 = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v), new Vec3(vec3.field_72450_a, Class160.mc.field_71439_g.field_70163_u, vec3.field_72449_c), true))));
                            }
                            final MovingObjectPosition movingObjectPosition6 = movingObjectPosition2;
                            Label_0956: {
                                Label_0899: {
                                    Label_0478: {
                                        if (array == null) {
                                            if (movingObjectPosition3 != null) {
                                                break Label_0478;
                                            }
                                            movingObjectPosition4 = (movingObjectPosition = (movingObjectPosition5 = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), Class160.mc.field_71439_g.field_70161_v), new Vec3(vec3.field_72450_a, Class160.mc.field_71439_g.field_70163_u + Class160.mc.field_71439_g.func_70047_e(), vec3.field_72449_c), true)));
                                        }
                                        if (array != null) {
                                            break Label_0956;
                                        }
                                        if (movingObjectPosition4 == null) {
                                            break Label_0899;
                                        }
                                    }
                                    MovingObjectPosition movingObjectPosition7 = null;
                                    final MovingObjectPosition movingObjectPosition8 = movingObjectPosition6;
                                    if (array != null || movingObjectPosition8 == null) {
                                        movingObjectPosition7 = movingObjectPosition8;
                                    }
                                    MovingObjectPosition movingObjectPosition10;
                                    final MovingObjectPosition movingObjectPosition9 = movingObjectPosition10 = movingObjectPosition;
                                    if (array == null) {
                                        if (movingObjectPosition9 == null) {
                                            movingObjectPosition7 = movingObjectPosition6;
                                        }
                                        final MovingObjectPosition movingObjectPosition11;
                                        movingObjectPosition10 = (movingObjectPosition11 = movingObjectPosition7);
                                    }
                                    Label_0894: {
                                        if (array == null) {
                                            if (movingObjectPosition9 == null) {
                                                break Label_0894;
                                            }
                                            movingObjectPosition10 = movingObjectPosition7;
                                        }
                                        if (movingObjectPosition10.func_178782_a() != null) {
                                            final BlockPos func_178782_a = movingObjectPosition7.func_178782_a();
                                            n9 = 1;
                                            Class160.y = func_178782_a.func_177984_a().func_177956_o();
                                            Class160.yPreEn = func_178782_a.func_177984_a().func_177956_o();
                                            Block block = null;
                                            Boolean b3 = Boolean.FALSE;
                                            int n10 = 0;
                                            while (n10 < n3) {
                                                final MovingObjectPosition rayTracePos$2f3fbb3f = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, (double)(func_178782_a.func_177956_o() + n10), Class160.mc.field_71439_g.field_70161_v), new Vec3(vec3.field_72450_a, (double)(func_178782_a.func_177956_o() + n10), vec3.field_72449_c), true);
                                                if (array != null) {
                                                    break Label_0894;
                                                }
                                                final MovingObjectPosition movingObjectPosition12 = rayTracePos$2f3fbb3f;
                                                Label_0844: {
                                                    if (array != null || (movingObjectPosition12 != null || array != null)) {
                                                        final BlockPos func_178782_a2 = movingObjectPosition12.func_178782_a();
                                                        if (array == null) {
                                                            if (func_178782_a2 == null && array == null) {
                                                                break Label_0844;
                                                            }
                                                            rayTracePos$2f3fbb3f.func_178782_a();
                                                        }
                                                        Block func_177230_c;
                                                        final Block block2 = func_177230_c = Class160.mc.field_71441_e.func_180495_p(func_178782_a2).func_177230_c();
                                                        if (array == null) {
                                                            if (lIIlIIll(block2.func_149688_o(), Material.field_151579_a)) {
                                                                block = block2;
                                                                if (array == null) {
                                                                    break Label_0844;
                                                                }
                                                            }
                                                            func_177230_c = block;
                                                        }
                                                        final boolean b4 = func_177230_c instanceof BlockFence;
                                                        Class160.y = func_178782_a.func_177956_o() + n10;
                                                        Class160.yPreEn = func_178782_a.func_177956_o() + n10;
                                                        final boolean b6;
                                                        final boolean b5 = b6 = b4;
                                                        final double n11;
                                                        if (array == null) {
                                                            if (b5) {
                                                                ++Class160.y;
                                                                ++Class160.yPreEn;
                                                                n11 = dcmpl((double)(n10 + 1), n3);
                                                                if (array == null) {
                                                                    if (n11 > 0) {
                                                                        b3 = Boolean.FALSE;
                                                                        if (array == null) {
                                                                            break;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                        b3 = (n11 != 0.0);
                                                        if (array == null) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                ++n10;
                                                if (array != null) {
                                                    break;
                                                }
                                            }
                                            final double field_70165_t = Class160.mc.field_71439_g.field_70165_t;
                                            final double field_70161_v = Class160.mc.field_71439_g.field_70161_v;
                                            final boolean booleanValue = b3;
                                            if (array != null || booleanValue) {
                                                return booleanValue;
                                            }
                                            if (array == null) {
                                                break Label_0894;
                                            }
                                        }
                                        return false;
                                    }
                                    if (array == null) {
                                        break Label_1024;
                                    }
                                }
                                movingObjectPosition5 = rayTracePos$2f3fbb3f(new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v), new Vec3(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c), false);
                            }
                            final MovingObjectPosition movingObjectPosition13 = movingObjectPosition5;
                            if (array == null) {
                                if (movingObjectPosition13 != null && movingObjectPosition13.field_72308_g == null) {
                                    Class160.y = Class160.mc.field_71439_g.field_70163_u;
                                    Class160.yPreEn = Class160.mc.field_71439_g.field_70163_u;
                                    if (array == null) {
                                        break Label_1024;
                                    }
                                }
                                Class160.y = Class160.mc.field_71439_g.field_70163_u;
                            }
                            Class160.yPreEn = vec3.field_72448_b;
                        }
                        double n13;
                        final double n12 = n13 = n8;
                        if (array == null) {
                            if (n12 == 0) {
                                return false;
                            }
                            final int n14;
                            n13 = (n14 = func_70093_af);
                        }
                        if (array == null) {
                            if (n12 != 0) {
                                Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class160.mc.field_71439_g, C0BPacketEntityAction$Action.STOP_SNEAKING));
                            }
                            n13 = 0;
                        }
                        double n15 = n13;
                        while (true) {
                            while (n15 < n5) {
                                final int size;
                                final int n16 = size = (int)n15;
                                final int n18;
                                final int n17 = n18 = 1;
                                if (array != null) {
                                    int i = size - n18;
                                    while (true) {
                                        while (i >= 0) {
                                            Class160.x = list2.get(i).field_72450_a;
                                            Class160.y = list2.get(i).field_72448_b;
                                            Class160.z = list2.get(i).field_72449_c;
                                            sendPacket$1c1dda81(list2);
                                            --i;
                                            if (array != null) {
                                                boolean b9;
                                                boolean b8;
                                                final boolean b7 = b8 = (b9 = (n8 != 0.0));
                                                if (array == null) {
                                                    if (!b7) {
                                                        final boolean b10 = func_70093_af != 0;
                                                        if (array == null) {
                                                            if (b10) {
                                                                Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class160.mc.field_71439_g, C0BPacketEntityAction$Action.START_SNEAKING));
                                                            }
                                                            list2.clear();
                                                            list.clear();
                                                        }
                                                        return b10;
                                                    }
                                                    b9 = (b8 = (func_70093_af != 0));
                                                }
                                                if (array == null) {
                                                    if (b8) {
                                                        Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C0BPacketEntityAction((Entity)Class160.mc.field_71439_g, C0BPacketEntityAction$Action.START_SNEAKING));
                                                    }
                                                    b9 = true;
                                                }
                                                return b9;
                                            }
                                            if (array != null) {
                                                break;
                                            }
                                        }
                                        Class160.x = Class160.mc.field_71439_g.field_70165_t;
                                        Class160.y = Class160.mc.field_71439_g.field_70163_u;
                                        Class160.z = Class160.mc.field_71439_g.field_70161_v;
                                        sendPacket$1c1dda81(list2);
                                        continue;
                                    }
                                }
                                if (array == null) {
                                    if (n16 != n17) {
                                        goto Label_1142;
                                    }
                                    final int n19 = n9;
                                    if (array == null && n19 != 0) {
                                        Class160.x = Class160.mc.field_71439_g.field_70165_t;
                                        Class160.y = Class160.yPreEn;
                                        Class160.z = Class160.mc.field_71439_g.field_70161_v;
                                        sendPacket$1c1dda81(list2);
                                        goto Label_1142;
                                    }
                                }
                                Label_1609: {
                                    if (lIIllIlI(n16, n17)) {
                                        final double n20 = Class160.mc.field_71439_g.field_70165_t - Class160.xPreEn;
                                        final double n21 = Class160.mc.field_71439_g.field_70163_u - Class160.yPreEn;
                                        final double n22 = Class160.mc.field_71439_g.field_70161_v - Class160.zPreEn;
                                        final double n23 = n4 * n15;
                                        final double field_70165_t2 = Class160.mc.field_71439_g.field_70165_t;
                                        final double n24 = n20;
                                        final double n25 = n23;
                                        if (array == null) {
                                            Class160.x = field_70165_t2 - n24 * n25;
                                            final double field_70163_u = Class160.mc.field_71439_g.field_70163_u;
                                            if (n9 != 0) {}
                                        }
                                        Class160.y = field_70165_t2 - n24 * n25;
                                        Class160.z = Class160.mc.field_71439_g.field_70161_v - n22 * n23;
                                        sendPacket$1c1dda81(list2);
                                        if (array == null) {
                                            break Label_1609;
                                        }
                                    }
                                    final double n26 = Class160.mc.field_71439_g.field_70165_t - Class160.xPreEn;
                                    final double n27 = Class160.mc.field_71439_g.field_70163_u - Class160.yPreEn;
                                    final double n28 = Class160.mc.field_71439_g.field_70161_v - Class160.zPreEn;
                                    final double n29 = n4 * n15;
                                    final double field_70165_t3 = Class160.mc.field_71439_g.field_70165_t;
                                    final double n30 = n26;
                                    final double n31 = n29;
                                    if (array == null) {
                                        Class160.x = field_70165_t3 - n30 * n31;
                                        final double field_70163_u2 = Class160.mc.field_71439_g.field_70163_u;
                                        if (n9 != 0) {}
                                    }
                                    Class160.y = field_70165_t3 - n30 * n31;
                                    Class160.z = Class160.mc.field_71439_g.field_70161_v - n28 * n29;
                                    sendPacket$1c1dda81(list2);
                                    final double n32 = Class160.x - Class160.xPreEn;
                                    final double n33 = Class160.z - Class160.zPreEn;
                                    final double n34 = Class160.y - vec3.field_72448_b;
                                    final double n35 = n32;
                                    final double n36 = n35 * n35;
                                    final double n37 = n33;
                                    final double sqrt;
                                    double n40;
                                    double n39;
                                    final int n38 = (int)(n39 = (n40 = dcmpl(sqrt = Math.sqrt(n36 + n37 * n37), 4.0)));
                                    Label_1562: {
                                        Label_1554: {
                                            if (array == null) {
                                                if (n38 > 0) {
                                                    Class160.x = Class160.xPreEn;
                                                    Class160.y = Class160.yPreEn;
                                                    Class160.z = Class160.zPreEn;
                                                    sendPacket$1c1dda81(list2);
                                                    if (array == null) {
                                                        break Label_1554;
                                                    }
                                                }
                                                final double n41;
                                                n39 = (n41 = (n40 = dcmpl(sqrt, 0.05)));
                                            }
                                            if (array != null) {
                                                break Label_1562;
                                            }
                                            if (n38 > 0) {
                                                final int n42 = (int)(n39 = (n40 = n9));
                                                if (array != null) {
                                                    break Label_1562;
                                                }
                                                if (n42 != 0) {
                                                    Class160.x = Class160.xPreEn;
                                                    Class160.y = Class160.yPreEn;
                                                    Class160.z = Class160.zPreEn;
                                                    sendPacket$1c1dda81(list2);
                                                }
                                            }
                                        }
                                        n40 = (n39 = dcmpg(Math.abs(n34), n3));
                                    }
                                    if (array == null) {
                                        if (n39 < 0) {
                                            Class160.x = Class160.xPreEn;
                                            Class160.y = vec3.field_72448_b;
                                            Class160.z = Class160.zPreEn;
                                            sendPacket$1c1dda81(list2);
                                            if (array == null) {
                                                break Label_1609;
                                            }
                                        }
                                        n40 = 0;
                                    }
                                    n8 = n40;
                                }
                                ++n15;
                                if (array != null) {
                                    break;
                                }
                            }
                            int size = list2.size();
                            int n18 = 2;
                            continue;
                        }
                    }
                    if (n7 > 0 && array == null) {
                        break;
                    }
                    ++n6;
                }
                if (array != null) {
                    break;
                }
            }
            Class160.xPreEn = vec3.field_72450_a;
            Class160.yPreEn = vec3.field_72448_b;
            Class160.zPreEn = vec3.field_72449_c;
            final double field_70165_t4 = Class160.mc.field_71439_g.field_70165_t;
            final double field_70163_u3 = Class160.mc.field_71439_g.field_70163_u;
            final double field_70161_v2 = Class160.mc.field_71439_g.field_70161_v;
            continue;
        }
    }
    
    private static void attackInf(final EntityLivingBase entityLivingBase) {
        final int[] b = Class139.b();
        Class160.mc.field_71439_g.func_71038_i();
        Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C02PacketUseEntity((Entity)entityLivingBase, C02PacketUseEntity$Action.ATTACK));
        final float func_152377_a = EnchantmentHelper.func_152377_a(Class160.mc.field_71439_g.func_70694_bm(), entityLivingBase.func_70668_bt());
        final int[] array = b;
        boolean b2;
        boolean func_70090_H;
        int n2;
        final int n = n2 = ((func_70090_H = (b2 = fcmpl(Class160.mc.field_71439_g.field_70143_R, 0.0f))) ? 1 : 0);
        Label_0155: {
            if (array == null) {
                if (n <= 0) {
                    break Label_0155;
                }
                final boolean b3;
                n2 = ((b3 = (func_70090_H = (b2 = Class160.mc.field_71439_g.field_70122_E))) ? 1 : 0);
            }
            if (array == null) {
                if (n != 0) {
                    break Label_0155;
                }
                func_70090_H = ((n2 = ((b2 = Class160.mc.field_71439_g.func_70617_f_()) ? 1 : 0)) != 0);
            }
            if (array == null) {
                if (n2 != 0) {
                    break Label_0155;
                }
                b2 = (func_70090_H = Class160.mc.field_71439_g.func_70090_H());
            }
            if (array == null) {
                if (func_70090_H) {
                    break Label_0155;
                }
                final EntityPlayerSP field_71439_g = Class160.mc.field_71439_g;
                if (array != null) {
                    break Label_0155;
                }
                b2 = field_71439_g.func_70644_a(Potion.field_76440_q);
            }
            if (!b2) {
                final Entity field_70154_o = Class160.mc.field_71439_g.field_70154_o;
            }
        }
        if (func_152377_a > 0.0f) {
            Class160.mc.field_71439_g.func_71047_c((Entity)entityLivingBase);
        }
    }
    
    private static void sendPacket$1c1dda81(final ArrayList<Vec3> list) {
        final int[] b = Class139.b();
        Class160.mc.func_147114_u().func_147298_b().func_179290_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(Class160.x, Class160.y, Class160.z, true));
        if (b == null) {
            list.add(new Vec3(Class160.x, Class160.y, Class160.z));
        }
    }
    
    private static MovingObjectPosition rayTracePos$2f3fbb3f(final Vec3 p0, final Vec3 p1, final boolean p2) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_0        
        //     2: invokestatic    ClassSub/Class160.getFacePosRemote:(Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;)[F
        //     5: iconst_0       
        //     6: faload         
        //     7: dup            
        //     8: fstore_3       
        //     9: ldc             360.0
        //    11: fadd           
        //    12: ldc             360.0
        //    14: frem           
        //    15: f2d            
        //    16: invokestatic    java/lang/Math.toRadians:(D)D
        //    19: dstore          7
        //    21: fload_3        
        //    22: ldc             360.0
        //    24: fadd           
        //    25: ldc             360.0
        //    27: frem           
        //    28: ldc             180.0
        //    30: fadd           
        //    31: f2d            
        //    32: invokestatic    java/lang/Math.toRadians:(D)D
        //    35: dstore          9
        //    37: invokestatic    ClassSub/Class139.b:()[I
        //    40: new             Lnet/minecraft/util/Vec3;
        //    43: dup            
        //    44: aload_0        
        //    45: getfield        net/minecraft/util/Vec3.field_72450_a:D
        //    48: dload           7
        //    50: invokestatic    java/lang/Math.cos:(D)D
        //    53: ldc2_w          2.1
        //    56: dmul           
        //    57: dadd           
        //    58: aload_0        
        //    59: getfield        net/minecraft/util/Vec3.field_72448_b:D
        //    62: aload_0        
        //    63: getfield        net/minecraft/util/Vec3.field_72449_c:D
        //    66: dload           7
        //    68: invokestatic    java/lang/Math.sin:(D)D
        //    71: ldc2_w          2.1
        //    74: dmul           
        //    75: dadd           
        //    76: invokespecial   net/minecraft/util/Vec3.<init>:(DDD)V
        //    79: astore          4
        //    81: new             Lnet/minecraft/util/Vec3;
        //    84: dup            
        //    85: aload_0        
        //    86: getfield        net/minecraft/util/Vec3.field_72450_a:D
        //    89: dload           9
        //    91: invokestatic    java/lang/Math.cos:(D)D
        //    94: ldc2_w          2.1
        //    97: dmul           
        //    98: dadd           
        //    99: aload_0        
        //   100: getfield        net/minecraft/util/Vec3.field_72448_b:D
        //   103: aload_0        
        //   104: getfield        net/minecraft/util/Vec3.field_72449_c:D
        //   107: dload           9
        //   109: invokestatic    java/lang/Math.sin:(D)D
        //   112: ldc2_w          2.1
        //   115: dmul           
        //   116: dadd           
        //   117: invokespecial   net/minecraft/util/Vec3.<init>:(DDD)V
        //   120: astore_3       
        //   121: new             Lnet/minecraft/util/Vec3;
        //   124: dup            
        //   125: aload_1        
        //   126: getfield        net/minecraft/util/Vec3.field_72450_a:D
        //   129: dload           7
        //   131: invokestatic    java/lang/Math.cos:(D)D
        //   134: ldc2_w          2.1
        //   137: dmul           
        //   138: dadd           
        //   139: aload_1        
        //   140: getfield        net/minecraft/util/Vec3.field_72448_b:D
        //   143: aload_1        
        //   144: getfield        net/minecraft/util/Vec3.field_72449_c:D
        //   147: dload           7
        //   149: invokestatic    java/lang/Math.sin:(D)D
        //   152: ldc2_w          2.1
        //   155: dmul           
        //   156: dadd           
        //   157: invokespecial   net/minecraft/util/Vec3.<init>:(DDD)V
        //   160: astore          5
        //   162: new             Lnet/minecraft/util/Vec3;
        //   165: dup            
        //   166: aload_1        
        //   167: getfield        net/minecraft/util/Vec3.field_72450_a:D
        //   170: dload           9
        //   172: invokestatic    java/lang/Math.cos:(D)D
        //   175: ldc2_w          2.1
        //   178: dmul           
        //   179: dadd           
        //   180: aload_1        
        //   181: getfield        net/minecraft/util/Vec3.field_72448_b:D
        //   184: aload_1        
        //   185: getfield        net/minecraft/util/Vec3.field_72449_c:D
        //   188: dload           9
        //   190: invokestatic    java/lang/Math.sin:(D)D
        //   193: ldc2_w          2.1
        //   196: dmul           
        //   197: dadd           
        //   198: invokespecial   net/minecraft/util/Vec3.<init>:(DDD)V
        //   201: astore          6
        //   203: new             Lnet/minecraft/util/Vec3;
        //   206: aload_0        
        //   207: getfield        net/minecraft/util/Vec3.field_72450_a:D
        //   210: dload           7
        //   212: invokestatic    java/lang/Math.cos:(D)D
        //   215: ldc2_w          2.1
        //   218: dmul           
        //   219: dadd           
        //   220: aload_0        
        //   221: getfield        net/minecraft/util/Vec3.field_72448_b:D
        //   224: aload_0        
        //   225: getfield        net/minecraft/util/Vec3.field_72449_c:D
        //   228: dload           7
        //   230: invokestatic    java/lang/Math.sin:(D)D
        //   233: ldc2_w          2.1
        //   236: dmul           
        //   237: dadd           
        //   238: invokespecial   net/minecraft/util/Vec3.<init>:(DDD)V
        //   241: new             Lnet/minecraft/util/Vec3;
        //   244: aload_0        
        //   245: getfield        net/minecraft/util/Vec3.field_72450_a:D
        //   248: dload           9
        //   250: invokestatic    java/lang/Math.cos:(D)D
        //   253: ldc2_w          2.1
        //   256: dmul           
        //   257: dadd           
        //   258: aload_0        
        //   259: getfield        net/minecraft/util/Vec3.field_72448_b:D
        //   262: aload_0        
        //   263: getfield        net/minecraft/util/Vec3.field_72449_c:D
        //   266: dload           9
        //   268: invokestatic    java/lang/Math.sin:(D)D
        //   271: ldc2_w          2.1
        //   274: dmul           
        //   275: dadd           
        //   276: invokespecial   net/minecraft/util/Vec3.<init>:(DDD)V
        //   279: new             Lnet/minecraft/util/Vec3;
        //   282: aload_1        
        //   283: getfield        net/minecraft/util/Vec3.field_72450_a:D
        //   286: dload           7
        //   288: invokestatic    java/lang/Math.cos:(D)D
        //   291: ldc2_w          2.1
        //   294: dmul           
        //   295: dadd           
        //   296: aload_1        
        //   297: getfield        net/minecraft/util/Vec3.field_72448_b:D
        //   300: aload_1        
        //   301: getfield        net/minecraft/util/Vec3.field_72449_c:D
        //   304: dload           7
        //   306: invokestatic    java/lang/Math.sin:(D)D
        //   309: ldc2_w          2.1
        //   312: dmul           
        //   313: dadd           
        //   314: invokespecial   net/minecraft/util/Vec3.<init>:(DDD)V
        //   317: new             Lnet/minecraft/util/Vec3;
        //   320: aload_1        
        //   321: getfield        net/minecraft/util/Vec3.field_72450_a:D
        //   324: dload           9
        //   326: invokestatic    java/lang/Math.cos:(D)D
        //   329: ldc2_w          2.1
        //   332: dmul           
        //   333: dadd           
        //   334: aload_1        
        //   335: getfield        net/minecraft/util/Vec3.field_72448_b:D
        //   338: aload_1        
        //   339: getfield        net/minecraft/util/Vec3.field_72449_c:D
        //   342: dload           9
        //   344: invokestatic    java/lang/Math.sin:(D)D
        //   347: ldc2_w          2.1
        //   350: dmul           
        //   351: dadd           
        //   352: invokespecial   net/minecraft/util/Vec3.<init>:(DDD)V
        //   355: getstatic       ClassSub/Class160.mc:Lnet/minecraft/client/Minecraft;
        //   358: getfield        net/minecraft/client/Minecraft.field_71441_e:Lnet/minecraft/client/multiplayer/WorldClient;
        //   361: aload           4
        //   363: aload           5
        //   365: iconst_0       
        //   366: iconst_0       
        //   367: iload_2        
        //   368: invokevirtual   net/minecraft/client/multiplayer/WorldClient.func_147447_a:(Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
        //   371: astore          4
        //   373: getstatic       ClassSub/Class160.mc:Lnet/minecraft/client/Minecraft;
        //   376: getfield        net/minecraft/client/Minecraft.field_71441_e:Lnet/minecraft/client/multiplayer/WorldClient;
        //   379: aload_0        
        //   380: aload_1        
        //   381: iconst_0       
        //   382: iconst_0       
        //   383: iload_2        
        //   384: invokevirtual   net/minecraft/client/multiplayer/WorldClient.func_147447_a:(Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
        //   387: astore_1       
        //   388: astore_0       
        //   389: getstatic       ClassSub/Class160.mc:Lnet/minecraft/client/Minecraft;
        //   392: getfield        net/minecraft/client/Minecraft.field_71441_e:Lnet/minecraft/client/multiplayer/WorldClient;
        //   395: aload_3        
        //   396: aload           6
        //   398: iconst_0       
        //   399: iconst_0       
        //   400: iload_2        
        //   401: invokevirtual   net/minecraft/client/multiplayer/WorldClient.func_147447_a:(Lnet/minecraft/util/Vec3;Lnet/minecraft/util/Vec3;ZZZ)Lnet/minecraft/util/MovingObjectPosition;
        //   404: astore_3       
        //   405: aload_1        
        //   406: ifnull          413
        //   409: aload_0        
        //   410: ifnonnull       414
        //   413: aload_1        
        //   414: aload_0        
        //   415: ifnonnull       458
        //   418: ifnonnull       457
        //   421: aload_3        
        //   422: aload_0        
        //   423: ifnonnull       456
        //   426: ifnonnull       455
        //   429: aload           4
        //   431: aload_0        
        //   432: ifnonnull       454
        //   435: ifnonnull       452
        //   438: aconst_null    
        //   439: aload_0        
        //   440: ifnonnull       451
        //   443: aconst_null    
        //   444: aload_0        
        //   445: ifnonnull       450
        //   448: aconst_null    
        //   449: areturn        
        //   450: areturn        
        //   451: areturn        
        //   452: aload           4
        //   454: areturn        
        //   455: aload_3        
        //   456: areturn        
        //   457: aload_1        
        //   458: areturn        
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0414 (coming from #0410).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2181)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:210)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static boolean rayTraceWide$4035701d(final Vec3 vec3, final Vec3 vec4) {
        final int[] b = Class139.b();
        final float func_76142_g;
        final double radians = Math.toRadians(func_76142_g = MathHelper.func_76142_g((getFacePosRemote(vec4, vec3)[0] + 360.0f) % 360.0f + 180.0f));
        final double radians2 = Math.toRadians(func_76142_g + 180.0f);
        final int[] array = b;
        final Vec3 vec5 = new Vec3(vec3.field_72450_a + Math.cos(radians) * 2.1, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians) * 2.1);
        final Vec3 vec6 = new Vec3(vec3.field_72450_a + Math.cos(radians2) * 2.1, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians2) * 2.1);
        final Vec3 vec7 = new Vec3(vec4.field_72450_a + Math.cos(radians) * 2.1, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians) * 2.1);
        final Vec3 vec8 = new Vec3(vec4.field_72450_a + Math.cos(radians2) * 2.1, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians2) * 2.1);
        new Vec3(vec3.field_72450_a + Math.cos(radians) * 2.1, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians) * 2.1);
        new Vec3(vec3.field_72450_a + Math.cos(radians2) * 2.1, vec3.field_72448_b, vec3.field_72449_c + Math.sin(radians2) * 2.1);
        new Vec3(vec4.field_72450_a + Math.cos(radians) * 2.1, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians) * 2.1);
        new Vec3(vec4.field_72450_a + Math.cos(radians2) * 2.1, vec4.field_72448_b, vec4.field_72449_c + Math.sin(radians2) * 2.1);
        final MovingObjectPosition func_147447_a = Class160.mc.field_71441_e.func_147447_a(vec5, vec7, false, false, true);
        final MovingObjectPosition func_147447_a2 = Class160.mc.field_71441_e.func_147447_a(vec3, vec4, false, false, true);
        Class160.mc.field_71441_e.func_147447_a(vec6, vec8, false, false, true);
        MovingObjectPosition movingObjectPosition3;
        final MovingObjectPosition movingObjectPosition2;
        final MovingObjectPosition movingObjectPosition = movingObjectPosition2 = (movingObjectPosition3 = func_147447_a);
        final MovingObjectPosition movingObjectPosition4;
        if (array == null) {
            if (movingObjectPosition != null) {
                movingObjectPosition4 = (movingObjectPosition3 = func_147447_a);
                if (array == null) {
                    if (!lIlIllIl(getBlock(movingObjectPosition4.func_178782_a()).func_149688_o(), Material.field_151579_a)) {
                        return true;
                    }
                }
            }
        }
        final MovingObjectPosition movingObjectPosition5;
        if (array == null) {
            if (movingObjectPosition != null) {
                movingObjectPosition5 = func_147447_a2;
                if (array == null) {
                    if (!lIlIllIl(getBlock(movingObjectPosition5.func_178782_a()).func_149688_o(), Material.field_151579_a)) {
                        return true;
                    }
                }
            }
        }
        if ((array == null && movingObjectPosition4 == null) || lIlIllIl(getBlock(movingObjectPosition5.func_178782_a()).func_149688_o(), Material.field_151579_a)) {
            MovingObjectPosition movingObjectPosition6 = null;
            if (array == null) {
                movingObjectPosition6 = null;
            }
            if (array != null) {
                if (lIIlIIll(getBlock(movingObjectPosition6.func_178782_a()).func_149688_o(), Material.field_151579_a)) {
                    return true;
                }
            }
            return false;
        }
        return true;
    }
    
    private static void blinkToPosFromPos(final Vec3 vec3, final Vec3 vec4, final double n) {
        final double n2 = vec3.field_72450_a - vec4.field_72450_a;
        final double n3 = vec3.field_72448_b - vec4.field_72448_b;
        final int[] b = Class139.b();
        final double n4 = vec3.field_72449_c - vec4.field_72449_c;
        final double field_72450_a = vec3.field_72450_a;
        final double field_72448_b = vec3.field_72448_b;
        final double field_72449_c = vec3.field_72449_c;
        final double field_72450_a2 = vec4.field_72450_a;
        final double field_72448_b2 = vec4.field_72448_b;
        final double field_72449_c2 = vec4.field_72449_c;
        final double n5 = n2;
        final double n6 = n5 * n5;
        final double n7 = n3;
        final double n8 = n6 + n7 * n7;
        final double n9 = n4;
        final double sqrt = Math.sqrt(n8 + n9 * n9);
        final double n10 = n / sqrt;
        int n11 = 0;
        int n12 = 0;
        final int[] array = b;
        double n13 = 0.0;
        Label_0161: {
            while (n12 < sqrt) {
                ++n11;
                if (array == null) {
                    n13 = dcmpl(n * n11, sqrt);
                    if (array != null || (n13 > 0 && array == null)) {
                        break Label_0161;
                    }
                    ++n12;
                }
                if (array != null) {
                    goto Label_0160;
                }
            }
            goto Label_0160;
        }
        int i = (int)n13;
        while (i < n11) {
            final double n14 = field_72450_a - field_72450_a2;
            final double n15 = field_72448_b - field_72448_b2;
            final double n16 = field_72449_c - field_72449_c2;
            final double n17 = n10 * i;
            Class160.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(field_72450_a - n14 * n17, field_72448_b - n15 * n17, field_72449_c - n16 * n17, true));
            ++i;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        Class160.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(field_72450_a2, field_72448_b2, field_72449_c2, true));
    }
    
    private static boolean isBlacklisted(final Entity entity) {
        final int[] b = Class139.b();
        final Iterator<Integer> iterator = Class160.blackList.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final int intValue = iterator.next();
            final int func_145782_y;
            final int n = func_145782_y = entity.func_145782_y();
            if (array != null) {
                return func_145782_y != 0;
            }
            if (array != null || n == intValue) {
                return n != 0;
            }
            if (array != null) {
                break;
            }
        }
        int func_145782_y = false ? 1 : 0;
        return func_145782_y != 0;
    }
    
    private static ArrayList<EntityLivingBase> getClosestEntitiesToEntity(final float n, final Entity entity) {
        final ArrayList<EntityLivingBase> list = new ArrayList<EntityLivingBase>();
        final int[] b = Class139.b();
        final Iterator<EntityLivingBase> iterator = (Iterator<EntityLivingBase>)Minecraft.func_71410_x().field_71441_e.field_72996_f.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final EntityLivingBase next;
            final boolean notItem = isNotItem(next = iterator.next());
            Label_0111: {
                Object o = null;
                Label_0076: {
                    if (array == null) {
                        if (!notItem) {
                            break Label_0111;
                        }
                        o = entity;
                        if (array != null) {
                            break Label_0076;
                        }
                        entity.func_70028_i((Entity)next);
                    }
                    if (notItem) {
                        break Label_0111;
                    }
                    o = next;
                }
                final EntityLivingBase entityLivingBase = (EntityLivingBase)o;
                final float n2 = fcmpg(entity.func_70032_d((Entity)entityLivingBase), n);
                if (array == null) {
                    if (n2 < 0) {
                        list.add(entityLivingBase);
                    }
                }
            }
            if (array != null) {
                break;
            }
        }
        return list;
    }
    
    private static float getDistanceToEntityFromEntity(final Entity entity, final Entity entity2) {
        final float n = (float)(entity.field_70165_t - entity2.field_70165_t);
        final float n2 = (float)(entity.field_70163_u - entity2.field_70163_u);
        final float n3 = (float)(entity.field_70161_v - entity2.field_70161_v);
        final float n4 = n;
        final float n5 = n4 * n4;
        final float n6 = n2;
        final float n7 = n5 + n6 * n6;
        final float n8 = n3;
        return MathHelper.func_76129_c(n7 + n8 * n8);
    }
    
    private static ArrayList<EntityLivingBase> getClosestEntities(final float n) {
        final ArrayList<EntityLivingBase> list = new ArrayList<EntityLivingBase>();
        final int[] b = Class139.b();
        final Iterator<EntityLivingBase> iterator = (Iterator<EntityLivingBase>)Minecraft.func_71410_x().field_71441_e.field_72996_f.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final EntityLivingBase next;
            final boolean notItem = isNotItem(next = iterator.next());
            Label_0124: {
                final EntityLivingBase entityLivingBase;
                Label_0069: {
                    if (array == null) {
                        if (!notItem) {
                            break Label_0124;
                        }
                        entityLivingBase = next;
                        if (array != null) {
                            break Label_0069;
                        }
                        final boolean b2 = entityLivingBase instanceof EntityPlayerSP;
                    }
                    if (notItem) {
                        break Label_0124;
                    }
                }
                final EntityLivingBase entityLivingBase2;
                float validEntity;
                final int n2 = (int)(validEntity = (validEntity((Entity)(entityLivingBase2 = entityLivingBase)) ? 1 : 0));
                if (array == null) {
                    if (n2 == 0 && array == null) {
                        continue;
                    }
                    validEntity = fcmpg(Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase2), n);
                }
                if (array == null) {
                    if (validEntity < 0) {
                        list.add(entityLivingBase2);
                    }
                }
            }
            if (array != null) {
                break;
            }
        }
        return list;
    }
    
    private static boolean validEntity(final Entity entity) {
        final int[] b = Class139.b();
        Entity entity2 = entity;
        Entity entity3 = entity;
        if (b == null) {
            if (entity == null) {
                return false;
            }
            entity2 = entity;
            entity3 = entity;
        }
        if (b == null) {
            if (lIlIllIl(entity3, Class160.mc.field_71439_g)) {
                return false;
            }
            entity2 = entity;
        }
        boolean b6;
        boolean b5;
        boolean b4;
        boolean b3;
        final boolean b2 = b3 = (b4 = (b5 = (b6 = entity2.func_70005_c_().equalsIgnoreCase("?6Dealer"))));
        if (b == null) {
            if (b2) {
                return false;
            }
            final boolean b7;
            b3 = (b7 = (b4 = (b5 = (b6 = entity.field_70128_L))));
        }
        if (b == null) {
            if (b2) {
                return false;
            }
            b4 = (b3 = (b5 = (b6 = Class160.mc.field_71439_g.field_70128_L)));
        }
        if (b == null) {
            if (b3) {
                return false;
            }
            b4 = (b6 = (entity instanceof EntityPlayer));
        }
        final boolean b8;
        Label_0121: {
            if (b == null) {
                if (b4) {
                    final boolean onSameTeam = Teams.isOnSameTeam(entity);
                    if (b != null || onSameTeam) {
                        return onSameTeam;
                    }
                    b8 = (b6 = AntiBot.isBot(entity));
                    if (b != null) {
                        break Label_0121;
                    }
                    if (b8) {
                        goto Label_0115;
                    }
                }
                b6 = (b5 = (entity instanceof EntityLivingBase));
            }
        }
        if (b == null) {
            if (!b8) {
                return false;
            }
            b6 = true;
        }
        return b6;
    }
    
    private static EntityLivingBase getClosestEntity(float n) {
        final int[] b = Class139.b();
        EntityLivingBase entityLivingBase = null;
        final int[] array = b;
        final Iterator iterator = Minecraft.func_71410_x().field_71441_e.field_72996_f.iterator();
        while (iterator.hasNext()) {
            final EntityLivingBase next;
            final boolean notItem = isNotItem(next = iterator.next());
            Label_0126: {
                final EntityLivingBase entityLivingBase2;
                Label_0063: {
                    if (array == null) {
                        if (!notItem) {
                            break Label_0126;
                        }
                        entityLivingBase2 = next;
                        if (array != null) {
                            break Label_0063;
                        }
                        final boolean b2 = entityLivingBase2 instanceof EntityPlayerSP;
                    }
                    if (notItem) {
                        break Label_0126;
                    }
                }
                final EntityLivingBase entityLivingBase3;
                float validEntity;
                final int n2 = (int)(validEntity = (validEntity((Entity)(entityLivingBase3 = entityLivingBase2)) ? 1 : 0));
                final float func_70032_d;
                Label_0122: {
                    if (array == null) {
                        if (n2 == 0 && array == null) {
                            continue;
                        }
                        func_70032_d = Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase3);
                        if (array != null) {
                            break Label_0122;
                        }
                        validEntity = fcmpg(func_70032_d, n);
                    }
                    if (validEntity >= 0) {
                        break Label_0126;
                    }
                    Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase3);
                }
                n = func_70032_d;
                entityLivingBase = entityLivingBase3;
            }
            if (array != null) {
                break;
            }
        }
        return entityLivingBase;
    }
    
    private static EntityLivingBase getClosestEntitySkipValidCheck(final float n) {
        final int[] b = Class139.b();
        EntityLivingBase entityLivingBase = null;
        float n2 = n;
        final int[] array = b;
        final Iterator<EntityLivingBase> iterator = (Iterator<EntityLivingBase>)Minecraft.func_71410_x().field_71441_e.field_72996_f.iterator();
        while (iterator.hasNext()) {
            final EntityLivingBase next;
            final boolean notItem = isNotItem(next = iterator.next());
            Label_0113: {
                final EntityLivingBase entityLivingBase2;
                Label_0065: {
                    if (array == null) {
                        if (!notItem) {
                            break Label_0113;
                        }
                        entityLivingBase2 = next;
                        if (array != null) {
                            break Label_0065;
                        }
                        final boolean b2 = entityLivingBase2 instanceof EntityPlayerSP;
                    }
                    if (notItem) {
                        break Label_0113;
                    }
                }
                final EntityLivingBase entityLivingBase3 = entityLivingBase2;
                final float func_70032_d = Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase3);
                if (array == null) {
                    if (func_70032_d >= n2) {
                        break Label_0113;
                    }
                    Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityLivingBase3);
                }
                n2 = func_70032_d;
                entityLivingBase = entityLivingBase3;
            }
            if (array != null) {
                break;
            }
        }
        return entityLivingBase;
    }
    
    private static EntityLivingBase getClosestEntityToEntity(final float n, final Entity entity) {
        EntityLivingBase entityLivingBase = null;
        final int[] b = Class139.b();
        float n2 = n;
        final Iterator<EntityLivingBase> iterator = (Iterator<EntityLivingBase>)Minecraft.func_71410_x().field_71441_e.field_72996_f.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final EntityLivingBase next;
            final boolean notItem = isNotItem(next = iterator.next());
            Label_0110: {
                Object o = null;
                Label_0072: {
                    if (array == null) {
                        if (!notItem) {
                            break Label_0110;
                        }
                        o = entity;
                        if (array != null) {
                            break Label_0072;
                        }
                        entity.func_70028_i((Entity)next);
                    }
                    if (notItem) {
                        break Label_0110;
                    }
                    o = next;
                }
                final EntityLivingBase entityLivingBase2 = (EntityLivingBase)o;
                final float func_70032_d = entity.func_70032_d((Entity)entityLivingBase2);
                if (array == null) {
                    if (func_70032_d >= n2) {
                        break Label_0110;
                    }
                    entity.func_70032_d((Entity)entityLivingBase2);
                }
                n2 = func_70032_d;
                entityLivingBase = entityLivingBase2;
            }
            if (array != null) {
                break;
            }
        }
        return entityLivingBase;
    }
    
    private static boolean isNotItem(final Object o) {
        final int[] b = Class139.b();
        final boolean b2 = o instanceof EntityLivingBase;
        return (b != null || b2) && b2;
    }
    
    private static void faceEntity(final Entity entity) {
        facePos(new Vec3(entity.field_70165_t - 0.5, entity.field_70163_u + (entity.func_70047_e() - entity.field_70131_O / 1.5), entity.field_70161_v - 0.5));
    }
    
    private static void faceBlock(final BlockPos blockPos) {
        facePos(new Vec3((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p()));
    }
    
    private static Vec3 getVec3(final BlockPos blockPos) {
        return new Vec3((double)blockPos.func_177958_n(), (double)blockPos.func_177956_o(), (double)blockPos.func_177952_p());
    }
    
    private static BlockPos getBlockPos(final Vec3 vec3) {
        return new BlockPos(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
    }
    
    private static void facePos(final Vec3 vec3) {
        final double n = vec3.field_72450_a + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n2 = vec3.field_72448_b + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        final double n3 = vec3.field_72449_c + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double n4 = n;
        final double n5 = n4 * n4;
        final double n6 = n3;
        final double n7 = MathHelper.func_76133_a(n5 + n6 * n6);
        final float n8 = (float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f;
        final float n9 = (float)(-(Math.atan2(n2, n7) * 180.0 / 3.141592653589793));
        Minecraft.func_71410_x().field_71439_g.field_70177_z += MathHelper.func_76142_g(n8 - Minecraft.func_71410_x().field_71439_g.field_70177_z);
        Minecraft.func_71410_x().field_71439_g.field_70125_A += MathHelper.func_76142_g(n9 - Minecraft.func_71410_x().field_71439_g.field_70125_A);
    }
    
    private static float[] getFacePos(final Vec3 vec3) {
        final double n = vec3.field_72450_a + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n2 = vec3.field_72448_b + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        final double n3 = vec3.field_72449_c + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double n4 = n;
        final double n5 = n4 * n4;
        final double n6 = n3;
        return new float[] { Minecraft.func_71410_x().field_71439_g.field_70177_z + MathHelper.func_76142_g((float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f - Minecraft.func_71410_x().field_71439_g.field_70177_z), Minecraft.func_71410_x().field_71439_g.field_70125_A + MathHelper.func_76142_g((float)(-(Math.atan2(n2, MathHelper.func_76133_a(n5 + n6 * n6)) * 180.0 / 3.141592653589793)) - Minecraft.func_71410_x().field_71439_g.field_70125_A) };
    }
    
    private static float[] getFacePosRemote(final Vec3 vec3, final Vec3 vec4) {
        final double n = vec4.field_72450_a - vec3.field_72450_a;
        final double n2 = vec4.field_72448_b - vec3.field_72448_b;
        final double n3 = vec4.field_72449_c - vec3.field_72449_c;
        final double n4 = n;
        final double n5 = n4 * n4;
        final double n6 = n3;
        return new float[] { MathHelper.func_76142_g((float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f), MathHelper.func_76142_g((float)(-(Math.atan2(n2, MathHelper.func_76133_a(n5 + n6 * n6)) * 180.0 / 3.141592653589793))) };
    }
    
    private static float[] getFacePosEntity(final Entity entity) {
        if (entity == null) {
            return new float[] { Minecraft.func_71410_x().field_71439_g.field_70759_as, Minecraft.func_71410_x().field_71439_g.field_70125_A };
        }
        final Vec3 vec3;
        final double n = (vec3 = new Vec3(entity.field_70165_t - 0.5, entity.field_70163_u + (entity.func_70047_e() - entity.field_70131_O / 1.5), entity.field_70161_v - 0.5)).field_72450_a + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n2 = vec3.field_72448_b + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        final double n3 = vec3.field_72449_c + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double n4 = n;
        final double n5 = n4 * n4;
        final double n6 = n3;
        return new float[] { Minecraft.func_71410_x().field_71439_g.field_70177_z + MathHelper.func_76142_g((float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f - Minecraft.func_71410_x().field_71439_g.field_70177_z), Minecraft.func_71410_x().field_71439_g.field_70125_A + MathHelper.func_76142_g((float)(-(Math.atan2(n2, MathHelper.func_76133_a(n5 + n6 * n6)) * 180.0 / 3.141592653589793)) - Minecraft.func_71410_x().field_71439_g.field_70125_A) };
    }
    
    private static float[] getFacePosEntityRemote(final EntityLivingBase entityLivingBase, final Entity entity) {
        if (entity == null) {
            return new float[] { entityLivingBase.field_70759_as, entityLivingBase.field_70125_A };
        }
        return getFacePosRemote(new Vec3(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + entity.func_70047_e(), entityLivingBase.field_70161_v), new Vec3(entity.field_70165_t, entity.field_70163_u + entity.func_70047_e(), entity.field_70161_v));
    }
    
    private static void smoothFacePos(final Vec3 vec3) {
        final double n = vec3.field_72450_a + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n2 = vec3.field_72448_b + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        final double n3 = vec3.field_72449_c + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double n4 = n;
        final double n5 = n4 * n4;
        final double n6 = n3;
        final double n7 = MathHelper.func_76133_a(n5 + n6 * n6);
        final int[] b = Class139.b();
        final float n8 = (float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f;
        final int[] array = b;
        final float n9 = (float)(-(Math.atan2(n2, n7) * 180.0 / 3.141592653589793));
        final float n10 = fcmpl(MathHelper.func_76142_g(n8 - Minecraft.func_71410_x().field_71439_g.field_70177_z), 10.0f);
        if (array == null) {
            if (n10 <= 0 || array != null) {
                MathHelper.func_76142_g(n8 - Minecraft.func_71410_x().field_71439_g.field_70177_z);
            }
        }
        final float n11 = fcmpl(MathHelper.func_76142_g(n9 - Minecraft.func_71410_x().field_71439_g.field_70125_A), 20.0f);
        if (array == null) {
            if (n11 <= 0 || array != null) {
                MathHelper.func_76142_g(n9 - Minecraft.func_71410_x().field_71439_g.field_70125_A);
            }
        }
    }
    
    private static void smoothFacePos$25d1eaa(final Vec3 vec3) {
        final double n = vec3.field_72450_a + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70165_t;
        final double n2 = vec3.field_72448_b + 0.5 - (Minecraft.func_71410_x().field_71439_g.field_70163_u + Minecraft.func_71410_x().field_71439_g.func_70047_e());
        final double n3 = vec3.field_72449_c + 0.5 - Minecraft.func_71410_x().field_71439_g.field_70161_v;
        final double n4 = n;
        final double n5 = n4 * n4;
        final double n6 = n3;
        final double n7 = MathHelper.func_76133_a(n5 + n6 * n6);
        Math.atan2(n3, n);
        Math.atan2(n2, n7);
    }
    
    private static float getPlayerBlockDistance(final BlockPos blockPos) {
        final double n = blockPos.func_177958_n();
        final double n2 = blockPos.func_177956_o();
        final double n3 = blockPos.func_177952_p();
        final double n4 = n2;
        final float n5 = (float)(Minecraft.func_71410_x().field_71439_g.field_70165_t - n);
        final float n6 = (float)(Minecraft.func_71410_x().field_71439_g.field_70163_u - n4);
        final float n7 = (float)(Minecraft.func_71410_x().field_71439_g.field_70161_v - n3);
        final float n8 = n5;
        final float n9 = n6;
        final float n10 = n7;
        final float n11 = n9;
        return MathHelper.func_76129_c((n8 - 0.5f) * (n8 - 0.5f) + (n11 - 0.5f) * (n11 - 0.5f) + (n10 - 0.5f) * (n10 - 0.5f));
    }
    
    private static float getPlayerBlockDistance(final double n, final double n2, final double n3) {
        final float n4 = (float)(Minecraft.func_71410_x().field_71439_g.field_70165_t - n);
        final float n5 = (float)(Minecraft.func_71410_x().field_71439_g.field_70163_u - n2);
        final float n6 = (float)(Minecraft.func_71410_x().field_71439_g.field_70161_v - n3);
        return MathHelper.func_76129_c((n4 - 0.5f) * (n4 - 0.5f) + (n5 - 0.5f) * (n5 - 0.5f) + (n6 - 0.5f) * (n6 - 0.5f));
    }
    
    private static float getBlockDistance(final float n, final float n2, final float n3) {
        return MathHelper.func_76129_c((n - 0.5f) * (n - 0.5f) + (n2 - 0.5f) * (n2 - 0.5f) + (n3 - 0.5f) * (n3 - 0.5f));
    }
    
    private static ArrayList<EntityItem> getNearbyItems(final int n) {
        final ArrayList<EntityItem> list = new ArrayList<EntityItem>();
        final int[] b = Class139.b();
        final Iterator<EntityItem> iterator = (Iterator<EntityItem>)Minecraft.func_71410_x().field_71441_e.func_72910_y().iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            EntityItem next;
            final EntityItem entityItem = next = iterator.next();
            if (array == null) {
                if (!(entityItem instanceof EntityItem) && array == null) {
                    continue;
                }
                next = entityItem;
            }
            final EntityItem entityItem2 = next;
            final float n2 = fcmpl(Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityItem2), (float)n);
            if (array == null) {
                if (n2 >= 0 && array == null) {
                    continue;
                }
                list.add(entityItem2);
            }
            if (array != null) {
                break;
            }
        }
        return list;
    }
    
    private static EntityItem getClosestItem(final float n) {
        EntityItem entityItem = null;
        final int[] b = Class139.b();
        final Iterator<EntityItem> iterator = (Iterator<EntityItem>)Minecraft.func_71410_x().field_71441_e.func_72910_y().iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            EntityItem next;
            final EntityItem entityItem2 = next = iterator.next();
            if (array == null) {
                if (!(entityItem2 instanceof EntityItem) && array == null) {
                    continue;
                }
                next = entityItem2;
            }
            final EntityItem entityItem3 = next;
            if (array == null) {
                if (Minecraft.func_71410_x().field_71439_g.func_70032_d((Entity)entityItem3) >= n && array == null) {
                    continue;
                }
                entityItem = entityItem3;
            }
            if (array != null) {
                break;
            }
        }
        return entityItem;
    }
    
    private static Entity getClosestItemOrXPOrb(final float n) {
        final int[] b = Class139.b();
        Object o = null;
        for (final Entity next : Minecraft.func_71410_x().field_71441_e.func_72910_y()) {
            final Entity entity = next;
            final Entity entity2;
            if (b == null) {
                if (!(entity instanceof EntityItem)) {
                    entity2 = entity;
                    if (b == null) {
                        if (!(entity2 instanceof EntityXPOrb) && b == null) {
                            continue;
                        }
                    }
                }
            }
            final Entity entity3 = entity2;
            Entity field_71439_g;
            final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(field_71439_g = (Entity)Minecraft.func_71410_x().field_71439_g);
            if (b == null) {
                if (entityPlayerSP.func_70032_d(entity3) >= n && b == null) {
                    continue;
                }
                field_71439_g = entity3;
            }
            o = field_71439_g;
            if (b != null) {
                break;
            }
        }
        return (Entity)o;
    }
    
    private static final float limitAngleChange(final float n, final float n2, final float n3) {
        final int[] b = Class139.b();
        float n4 = n2 - n;
        final int[] array = b;
        final float n5 = fcmpl(n4, n3);
        final float n6;
        final float n7;
        if (array == null) {
            if (n5 > 0) {
                n4 = n3;
                if (array == null) {
                    return n6 + n7;
                }
            }
            n6 = n4;
            n7 = -n3;
            if (array != null) {
                return n6 + n7;
            }
            final float n8 = fcmpg(n6, n7);
        }
        if (n5 < 0) {
            n4 = -n3;
        }
        return n6 + n7;
    }
    
    private static double normalizeAngle(final double n) {
        return (n + 360.0) % 360.0;
    }
    
    private static float normalizeAngle(final float n) {
        return (n + 360.0f) % 360.0f;
    }
    
    private static int getItemIndexHotbar(final int n) {
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        while (i < 9) {
            Label_0051: {
                final ItemStack func_70301_a;
                if ((func_70301_a = Class160.mc.field_71439_g.field_71071_by.func_70301_a(i)) != null || array != null) {
                    int n2 = n;
                    if (array == null) {
                        if (n != Item.func_150891_b(func_70301_a.func_77973_b())) {
                            break Label_0051;
                        }
                        n2 = i;
                    }
                    return n2;
                }
            }
            ++i;
            if (array != null) {
                break;
            }
        }
        return -1;
    }
    
    private static boolean isBlockPosAir(final BlockPos blockPos) {
        return lIlIllIl(Class160.mc.field_71441_e.func_180495_p(blockPos).func_177230_c().func_149688_o(), Material.field_151579_a);
    }
    
    private static Block getBlockRelativeToEntity(final Entity entity, final double n) {
        return getBlock(new BlockPos(entity.field_70165_t, entity.field_70163_u + n, entity.field_70161_v));
    }
    
    private static BlockPos getBlockPosRelativeToEntity(final Entity entity, final double n) {
        return new BlockPos(entity.field_70165_t, entity.field_70163_u + n, entity.field_70161_v);
    }
    
    private static Block getBlock(final BlockPos blockPos) {
        return Class160.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
    }
    
    private static Vec3 getLastGroundLocation() {
        return Class160.lastLoc;
    }
    
    private static void updateLastGroundLocation() {
        if (Class160.mc.field_71439_g.field_70122_E) {
            Class160.lastLoc = new Vec3(Class160.mc.field_71439_g.field_70165_t, Class160.mc.field_71439_g.field_70163_u, Class160.mc.field_71439_g.field_70161_v);
        }
    }
    
    private static IBlockState getBlockState(final BlockPos blockPos) {
        return Class160.mc.field_71441_e.func_180495_p(blockPos);
    }
    
    static {
        lIIIIllI();
        Class169.a(5103194440941235671L, 7721299862250205812L, MethodHandles.lookup().lookupClass()).a(70359758551012L);
        final Cipher instance = Cipher.getInstance(Class160.llllll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class160.llllll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(123282258863359L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class160.llllll[2].getBytes(Class160.llllll[3]))).intern();
        Class160.mc = Minecraft.func_71410_x();
        new Random();
        Class160.blackList = new ArrayList<Integer>();
        Class160.lastLoc = null;
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
    
    private static void lIIIIllI() {
        (llllll = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class160.llllll[1] = "DES";
        Class160.llllll[2] = "T\u008e{\u0082\u000b\u009d\r'\u0006\u0086¬dneç\u001f";
        Class160.llllll[3] = "ISO-8859-1";
    }
    
    private static String lIIIIlII(final String s, final String s2) {
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
    
    private static String lIIIIlIl(String s, final String s2) {
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
    
    private static boolean lIIlllII$255f299(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIlIIll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIlIllIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIllIll(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIIlllI(final int n) {
        return n < 0;
    }
    
    private static boolean lIIlIIII(final int n) {
        return n > 0;
    }
    
    private static boolean lIIllIlI(final int n, final int n2) {
        return n != n2;
    }
    
    private static int lIIIllIl$2548a28(final float n) {
        return fcmpl(n, 4.0f);
    }
    
    private static int lIIIllII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIIlIll(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIIllllI(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIlllIl(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIlIIlII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIIIll(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIlIllII$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIlIllll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIlllI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIllIIIl(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIllIIlI(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIllIlII(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIllIlIl(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIllIlll(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIlllIII(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIlllIIl(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIlllIll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllllII(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllllIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIlllllI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllllll(final float n, final float n2) {
        return fcmpg(n, n2);
    }
}
