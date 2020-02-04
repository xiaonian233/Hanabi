package ClassSub;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.client.entity.*;
import cn.Hanabi.events.*;
import net.minecraft.network.play.client.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.network.*;
import com.darkmagician6.eventapi.*;
import java.util.*;
import net.minecraft.util.*;
import java.lang.invoke.*;

public final class Class89
{
    private static Minecraft mc;
    private static boolean l;
    private static float ll;
    private static float l1;
    private static int l11;
    private static boolean lll;
    public static float[] ll1;
    private static double llll;
    private static double lll1;
    private static double lmc;
    private static final long a;
    
    public Class89() {
        super();
    }
    
    private static double ll(final Entity entity) {
        final int[] b = Class139.b();
        final int[] b2 = Class139.b();
        float[] l$4950b7a1 = null;
        Label_0039: {
            Label_0024: {
                if (entity != null) {
                    Object field_71439_g;
                    final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(field_71439_g = Class89.mc.field_71439_g);
                    if (b2 == null) {
                        if (entityPlayerSP == null) {
                            break Label_0024;
                        }
                        field_71439_g = entity;
                    }
                    l$4950b7a1 = l$4950b7a1(l(((Entity)field_71439_g).func_174813_aQ(), false));
                    break Label_0039;
                }
            }
            l$4950b7a1 = null;
        }
        final float[] array = l$4950b7a1;
        final int[] array2 = b;
        final float[] array3 = array;
        if (array2 == null && array3 == null) {
            return 0.0;
        }
        return Math.sqrt(Math.pow(Math.abs(l(Class89.ll1[0] % 360.0f, (double)array3[0])), 2.0) + Math.pow(Math.abs(l(Class89.ll1[1], (double)array[1])), 2.0));
    }
    
    private static double l(final float n, final float n2) {
        return Math.sqrt(Math.pow(Math.abs(l(Class89.ll1[0] % 360.0f, (double)n)), 2.0) + Math.pow(Math.abs(l(Class89.ll1[1], (double)n2)), 2.0));
    }
    
    private static void l1() {
        Class89.l = false;
        Class89.l11 = 0;
        Class89.ll = 0.0f;
        Class89.l1 = 0.0f;
    }
    
    @EventTarget
    private static void l(final EventPacket eventPacket) {
        final int[] b = Class139.b();
        final Packet packet = eventPacket.packet;
        if (b == null) {
            if (!(packet instanceof C03PacketPlayer)) {
                return;
            }
            final Packet packet2 = eventPacket.packet;
        }
        final C03PacketPlayer c03PacketPlayer = (C03PacketPlayer)packet;
        float l;
        final boolean b2 = (l = (Class89.l ? 1 : 0)) != 0.0f;
        final float n4;
        Label_0118: {
            if (b == null) {
                Label_0109: {
                    if (b2) {
                        final int n = (int)(l = 0);
                        if (b != null) {
                            break Label_0118;
                        }
                        if (n == 0) {
                            final float n3;
                            final float n2 = n3 = (l = fcmpl(Class89.ll, Class89.ll1[0]));
                            Label_0076: {
                                if (b == null) {
                                    if (n2 != 0) {
                                        break Label_0076;
                                    }
                                    n4 = fcmpl(Class89.l1, Class89.ll1[1]);
                                }
                                if (b != null) {
                                    break Label_0118;
                                }
                                if (n2 == 0) {
                                    break Label_0109;
                                }
                            }
                            ((IC03PacketPlayer)c03PacketPlayer).setYaw(Class89.ll);
                            ((IC03PacketPlayer)c03PacketPlayer).setPitch(Class89.l1);
                            ((IC03PacketPlayer)c03PacketPlayer).setRotate$1385ff();
                        }
                    }
                }
                ((IC03PacketPlayer)c03PacketPlayer).getRotate();
            }
        }
        if (b != null || b2) {
            final float[] ll1 = new float[n4];
            ll1[0] = ((IC03PacketPlayer)c03PacketPlayer).getYaw();
            ll1[1] = ((IC03PacketPlayer)c03PacketPlayer).getPitch();
            Class89.ll1 = ll1;
        }
    }
    
    @EventTarget
    private static void update$3d4b95ff() {
        final int[] b = Class139.b();
        final int l = Class89.l ? 1 : 0;
        Label_0052: {
            if (b == null) {
                if (l == 0) {
                    break Label_0052;
                }
                ++Class89.l11;
            }
            if (l > 15) {
                Class89.l = false;
                Class89.l11 = 0;
                Class89.ll = 0.0f;
                Class89.l1 = 0.0f;
            }
        }
        final Random random;
        double n2;
        final double n = n2 = dcmpl((random = new Random()).nextGaussian() * 100.0, 80.0);
        if (b == null) {
            if (n > 0) {
                Class89.llll = Math.random() / 3.0;
            }
            final double n3;
            n2 = (n3 = dcmpl(random.nextGaussian() * 100.0, 80.0));
        }
        final double n4;
        double n5 = 0.0;
        Label_0171: {
            if (b == null) {
                if (n > 0) {
                    Class89.lll1 = Math.random() / 3.0;
                }
                n4 = random.nextGaussian() * 100.0;
                n5 = 80.0;
                if (b != null) {
                    break Label_0171;
                }
                n2 = dcmpl(n4, 80.0);
            }
            if (n2 <= 0) {
                return;
            }
            Math.random();
            n5 = 3.0;
        }
        Class89.lmc = n4 / n5;
    }
    
    private static Vec3 l(final AxisAlignedBB axisAlignedBB) {
        return new Vec3(axisAlignedBB.field_72340_a + (axisAlignedBB.field_72336_d - axisAlignedBB.field_72340_a) * 0.5, axisAlignedBB.field_72338_b + (axisAlignedBB.field_72337_e - axisAlignedBB.field_72338_b) * 0.5, axisAlignedBB.field_72339_c + (axisAlignedBB.field_72334_f - axisAlignedBB.field_72339_c) * 0.5);
    }
    
    public static float[] l(final float[] array, final float[] array2, final float n) {
        final int[] b = Class139.b();
        final double l = l(array2[0], (double)array[0]);
        final double i = l(array2[1], (double)array[1]);
        final int[] array3 = b;
        final int n2 = 0;
        final double n3 = array[0];
        final double n5;
        final double n4 = dcmpl(l, n5 = n);
        final double n6;
        Label_0090: {
            if (array3 == null) {
                if (n4 > 0) {
                    break Label_0090;
                }
                n6 = l;
                if (array3 != null) {
                    break Label_0090;
                }
                final double n7 = dcmpg(n6, (double)(-n));
            }
            if (n4 < 0) {
                final double n8 = -n;
            }
        }
        array[n2] = (float)(n3 + n6);
        final int n9 = 1;
        final double n10 = array[1];
        final double n11 = dcmpl(i, n5);
        final double n12;
        Label_0155: {
            if (array3 == null) {
                if (n11 > 0) {
                    break Label_0155;
                }
                n12 = i;
                if (array3 != null) {
                    break Label_0155;
                }
                final double n13 = dcmpg(n12, (double)(-n));
            }
            if (n11 < 0) {
                final double n14 = -n;
            }
        }
        array[n9] = (float)(n10 + n12);
        return array;
    }
    
    private static Vec3 ll() {
        return new Vec3(Class89.mc.field_71439_g.field_70165_t, Class89.mc.field_71439_g.func_174813_aQ().field_72338_b + Class89.mc.field_71439_g.func_70047_e(), Class89.mc.field_71439_g.field_70161_v);
    }
    
    private static double l(final double n, final double n2) {
        return ((n - n2) % 360.0 + 540.0) % 360.0 - 180.0;
    }
    
    public static Vec3 l(final AxisAlignedBB axisAlignedBB, final boolean b) {
        if (b) {
            return new Vec3(axisAlignedBB.field_72340_a + (axisAlignedBB.field_72336_d - axisAlignedBB.field_72340_a) * (Class89.llll * 0.3 + 1.0), axisAlignedBB.field_72338_b + (axisAlignedBB.field_72337_e - axisAlignedBB.field_72338_b) * (Class89.lll1 * 0.3 + 1.0), axisAlignedBB.field_72339_c + (axisAlignedBB.field_72334_f - axisAlignedBB.field_72339_c) * (Class89.lmc * 0.3 + 1.0));
        }
        return new Vec3(axisAlignedBB.field_72340_a + (axisAlignedBB.field_72336_d - axisAlignedBB.field_72340_a) * Class89.llll * 0.8, axisAlignedBB.field_72338_b + (axisAlignedBB.field_72337_e - axisAlignedBB.field_72338_b) * Class89.lll1 * 0.8, axisAlignedBB.field_72339_c + (axisAlignedBB.field_72334_f - axisAlignedBB.field_72339_c) * Class89.lmc * 0.8);
    }
    
    private static boolean l() {
        return true;
    }
    
    private static Vec3 ll(float func_76126_a, float func_76126_a2) {
        final float func_76134_b = MathHelper.func_76134_b(-func_76126_a2 * 0.017453292f - 3.1415927f);
        func_76126_a2 = MathHelper.func_76126_a(-func_76126_a2 * 0.017453292f - 3.1415927f);
        final float n = -MathHelper.func_76134_b(-func_76126_a * 0.017453292f);
        func_76126_a = MathHelper.func_76126_a(-func_76126_a * 0.017453292f);
        return new Vec3((double)(func_76126_a2 * n), (double)func_76126_a, (double)(func_76134_b * n));
    }
    
    private static void l(final Entity entity, final boolean b, final boolean b2, float n) {
        final int[] b3 = Class139.b();
        final EntityPlayerSP field_71439_g = Class89.mc.field_71439_g;
        final int[] array = b3;
        final double n2 = entity.field_70165_t + (b2 ? ((entity.field_70165_t - entity.field_70169_q) * n) : 0.0) - (field_71439_g.field_70165_t + (b2 ? (field_71439_g.field_70165_t - field_71439_g.field_70169_q) : 0.0));
        final double n3 = entity.func_174813_aQ().field_72338_b + (b2 ? ((entity.func_174813_aQ().field_72338_b - entity.field_70167_r) * n) : 0.0) + entity.func_70047_e() - 0.15 - (field_71439_g.func_174813_aQ().field_72338_b + (b2 ? (field_71439_g.field_70163_u - field_71439_g.field_70167_r) : 0.0)) - field_71439_g.func_70047_e();
        final double n4 = entity.field_70161_v + (b2 ? ((entity.field_70161_v - entity.field_70166_s) * n) : 0.0) - (field_71439_g.field_70161_v + (b2 ? (field_71439_g.field_70161_v - field_71439_g.field_70166_s) : 0.0));
        final double n5 = n2;
        final double n6 = n4;
        final double n7 = n5;
        final double n8 = n7 * n7;
        final double n9 = n6;
        final double sqrt = Math.sqrt(n8 + n9 * n9);
        final float n10 = field_71439_g.func_71052_bv() / 20.0f;
        float n13;
        float n12;
        final float n11 = n12 = (n13 = (n10 * n10 + n10 * 2.0f) / 3.0f);
        float n14 = 1.0f;
        if (array == null) {
            if (n11 > 1.0f) {
                n12 = 1.0f;
            }
            n13 = (float)(Math.atan2(n4, n2) * 180.0 / 3.141592653589793);
            n14 = 90.0f;
        }
        n = n13 - n14;
        final float n15 = n12;
        final float n16 = n12;
        final double n17 = sqrt;
        final float n18 = n12;
        final float n19 = n15;
        final double n20 = n19 * n19;
        final float n21 = n16;
        final double n22 = n21 * n21 * n12 * n12;
        final double n23 = 0.006000000052154064;
        final double n24 = 0.006000000052154064;
        final double n25 = n17;
        final double n26 = n24 * (n25 * n25);
        final double n27 = n3 * 2.0;
        final float n28 = n18;
        float n29 = (float)(-Math.toDegrees(Math.atan((n20 - Math.sqrt(n22 - n23 * (n26 + n27 * (n28 * n28)))) / (sqrt * 0.006000000052154064))));
        float n31;
        final float n30 = n31 = fcmpg(n12, 0.1f);
        if (array == null) {
            if (n30 < 0) {
                final AxisAlignedBB func_174813_aQ = entity.func_174813_aQ();
                final float[] l$4950b7a1;
                n = (l$4950b7a1 = l$4950b7a1(new Vec3(func_174813_aQ.field_72340_a + (func_174813_aQ.field_72336_d - func_174813_aQ.field_72340_a) * 0.5, func_174813_aQ.field_72338_b + (func_174813_aQ.field_72337_e - func_174813_aQ.field_72338_b) * 0.5, func_174813_aQ.field_72339_c + (func_174813_aQ.field_72334_f - func_174813_aQ.field_72339_c) * 0.5)))[0];
                n29 = l$4950b7a1[1];
            }
            n31 = (b ? 1 : 0);
        }
        if (array == null) {
            if (n30 != 0) {
                l1(n, n29);
                return;
            }
            n31 = 2;
        }
        final float[] array2 = new float[n31];
        array2[0] = field_71439_g.field_70177_z;
        array2[1] = field_71439_g.field_70125_A;
        final float[] l = l(array2, new float[] { n, n29 }, 10 + new Random().nextInt(6));
        if (array == null) {
            if (l == null) {
                return;
            }
            field_71439_g.field_70177_z = l[0];
            field_71439_g.field_70125_A = l[1];
        }
    }
    
    private static void l1(final float ll, final float l1) {
        final int[] b = Class139.b();
        boolean naN;
        final boolean b2 = naN = Double.isNaN(ll);
        if (b == null) {
            if (b2) {
                return;
            }
            final boolean naN2;
            naN = (naN2 = Double.isNaN(l1));
        }
        if (b == null) {
            if (b2) {
                return;
            }
            Class89.ll = ll;
            Class89.l1 = l1;
            Class89.l = true;
            naN = false;
        }
        Class89.l11 = (naN ? 1 : 0);
    }
    
    private static float[] l(final Entity entity) {
        final int[] b = Class139.b();
        if (entity != null) {
            Object field_71439_g;
            final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(field_71439_g = Class89.mc.field_71439_g);
            if (b == null) {
                if (entityPlayerSP == null) {
                    return null;
                }
                field_71439_g = entity;
            }
            return l$4950b7a1(l(((Entity)field_71439_g).func_174813_aQ(), false));
        }
        return null;
    }
    
    public static float[] l$4950b7a1(final Vec3 vec3) {
        final Vec3 ll;
        (ll = ll()).func_72441_c(Class89.mc.field_71439_g.field_70159_w, Class89.mc.field_71439_g.field_70181_x, Class89.mc.field_71439_g.field_70179_y);
        final double n = vec3.field_72450_a - ll.field_72450_a;
        final double n2 = vec3.field_72448_b - ll.field_72448_b;
        final double n3 = vec3.field_72449_c - ll.field_72449_c;
        final double n4 = n;
        final double n5 = n4 * n4;
        final double n6 = n3;
        return new float[] { MathHelper.func_76142_g((float)Math.toDegrees(Math.atan2(n3, n)) - 90.0f), MathHelper.func_76142_g((float)(-Math.toDegrees(Math.atan2(n2, Math.sqrt(n5 + n6 * n6))))) };
    }
    
    private static void l(final BlockPos blockPos) {
        final int[] b = Class139.b();
        BlockPos blockPos2 = blockPos;
        if (b == null) {
            if (blockPos == null) {
                return;
            }
            blockPos2 = blockPos;
        }
        final double n = blockPos2.func_177958_n() + 0.5 - Class89.mc.field_71439_g.field_70165_t;
        final double n2 = blockPos.func_177956_o() + 0.5 - (Class89.mc.field_71439_g.func_174813_aQ().field_72338_b + Class89.mc.field_71439_g.func_70047_e());
        final double n3 = blockPos.func_177952_p() + 0.5 - Class89.mc.field_71439_g.field_70161_v;
        final double n4 = n;
        final double n5 = n3;
        final double n6 = n4;
        final double n7 = n6 * n6;
        final double n8 = n5;
        l1(Class89.mc.field_71439_g.field_70177_z + MathHelper.func_76142_g((float)(Math.atan2(n3, n) * 180.0 / 3.141592653589793) - 90.0f - Class89.mc.field_71439_g.field_70177_z), Class89.mc.field_71439_g.field_70125_A + MathHelper.func_76142_g((float)(-Math.atan2(n2, Math.sqrt(n7 + n8 * n8)) * 180.0 / 3.141592653589793) - Class89.mc.field_71439_g.field_70125_A));
    }
    
    static {
        Class169.a(2922765016053164291L, 3175393765180442988L, MethodHandles.lookup().lookupClass()).a(94439507177159L);
        Class89.mc = Minecraft.func_71410_x();
        Class89.ll1 = new float[] { 0.0f, 0.0f };
        Class89.llll = Math.random() / 3.0;
        Class89.lll1 = Math.random() / 3.0;
        Class89.lmc = Math.random() / 3.0;
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean llIllllIIIll$255f299(final int n) {
        return n > 15;
    }
    
    private static boolean llIllllIIlll(final int n) {
        return n < 0;
    }
    
    private static boolean llIllllIIlII(final int n) {
        return n > 0;
    }
    
    private static int llIlllIlllll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int llIllllIIIlI$25399e8(final double n) {
        return dcmpl(n, 80.0);
    }
    
    private static int llIllllIIlIl(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int llIllllIIllI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int llIllllIlIII$2548a28(final float n) {
        return fcmpl(n, 1.0f);
    }
    
    private static int llIllllIlIIl$2548a28(final float n) {
        return fcmpg(n, 0.1f);
    }
}
