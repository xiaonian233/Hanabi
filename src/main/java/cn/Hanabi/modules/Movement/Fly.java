package cn.Hanabi.modules.Movement;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.entity.player.*;
import net.minecraft.network.play.client.*;
import net.minecraft.block.*;
import com.darkmagician6.eventapi.*;
import java.math.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.entity.*;
import net.minecraft.client.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import net.minecraftforge.fml.common.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Fly extends Mod
{
    private Value<String> mode;
    private Value<Boolean> lagback;
    private Class274 GlobalHypixel;
    private Class212 MotionFly;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIIlIIIllll;
    
    public Fly() {
        super("Fly", Category.MOVEMENT);
        this.mode = new Value<String>("Fly", "Mode", 0);
        this.lagback = new Value<Boolean>("Fly_LagBackChecks", Boolean.TRUE);
        this.GlobalHypixel = new Class274();
        this.MotionFly = new Class212();
        this.mode.addValue("Motion");
        this.mode.addValue("Hypixel");
    }
    
    @EventTarget
    private void onPacket(final EventPacket eventPacket) {
        final int[] b = Class139.b();
        Fly fly = this;
        if (b == null) {
            if (!this.mode.isCurrentMode("Hypixel")) {
                return;
            }
            fly = this;
        }
        final Class274 globalHypixel = fly.GlobalHypixel;
        final int[] b2 = Class139.b();
        final Block blockUnderPlayer$345a1aee = Class274.getBlockUnderPlayer$345a1aee((EntityPlayer)globalHypixel.mc.field_71439_g);
        final int[] array = b2;
        boolean onGround$13336d;
        boolean func_149730_j;
        final boolean b3 = func_149730_j = (onGround$13336d = (eventPacket.packet instanceof C03PacketPlayer));
        if (array == null) {
            if (!b3) {
                return;
            }
            final boolean b4;
            func_149730_j = (b4 = (onGround$13336d = globalHypixel.isOnGround$13336d()));
        }
        if (array == null) {
            if (b3) {
                return;
            }
            onGround$13336d = (func_149730_j = blockUnderPlayer$345a1aee.func_149730_j());
        }
        if (array == null) {
            if (func_149730_j) {
                return;
            }
            onGround$13336d = (blockUnderPlayer$345a1aee instanceof BlockGlass);
        }
        if (!onGround$13336d) {
            ((IC03PacketPlayer)eventPacket.packet).setOnGround(false);
        }
    }
    
    @EventTarget
    private void onUpdate$3a3d1cb1() {
        final int[] b = Class139.b();
        final boolean currentMode = this.mode.isCurrentMode("Hypixel");
        Fly fly = null;
        Label_1451: {
            if (b == null) {
                if (currentMode) {
                    this.setDisplayName("Hypixel");
                    final Class274 globalHypixel = this.GlobalHypixel;
                    final int[] b2 = Class139.b();
                    int fastFlew;
                    int hurtted;
                    int n3;
                    int n2;
                    final int n = n2 = (n3 = (hurtted = (fastFlew = (globalHypixel.mode.isCurrentMode("Normal") ? 1 : 0))));
                    if (b2 == null) {
                        if (n != 0) {
                            int n4;
                            final boolean b3 = (n4 = (globalHypixel.mc.field_71439_g.field_70122_E ? 1 : 0)) != 0;
                            Label_0281: {
                                while (true) {
                                    final Class274 class275;
                                    Label_0137: {
                                        if (b2 == null) {
                                            if (b3) {
                                                globalHypixel.mc.field_71439_g.func_70664_aZ();
                                                if (b2 == null) {
                                                    break Label_0281;
                                                }
                                            }
                                            globalHypixel.mc.field_71439_g.field_70181_x = 0.0;
                                            final Class274 class274 = globalHypixel;
                                            ++class274.stage;
                                            class275 = globalHypixel;
                                            if (b2 != null) {
                                                break Label_0137;
                                            }
                                            n4 = class275.stage;
                                        }
                                        Label_0232: {
                                            switch (n4) {
                                                case 2: {
                                                    globalHypixel.mc.field_71439_g.func_70107_b(globalHypixel.mc.field_71439_g.field_70165_t, globalHypixel.mc.field_71439_g.field_70163_u - 1.0E-12, globalHypixel.mc.field_71439_g.field_70161_v);
                                                    if (b2 != null) {
                                                        break Label_0232;
                                                    }
                                                    break Label_0281;
                                                }
                                                case 3: {
                                                    globalHypixel.mc.field_71439_g.func_70107_b(globalHypixel.mc.field_71439_g.field_70165_t, globalHypixel.mc.field_71439_g.field_70163_u + 1.0E-12, globalHypixel.mc.field_71439_g.field_70161_v);
                                                    globalHypixel.stage = 0;
                                                    break Label_0281;
                                                }
                                            }
                                        }
                                    }
                                    class275.mc.field_71439_g.func_70107_b(globalHypixel.mc.field_71439_g.field_70165_t, globalHypixel.mc.field_71439_g.field_70163_u + 1.0E-12, globalHypixel.mc.field_71439_g.field_70161_v);
                                    if (b2 != null) {
                                        continue;
                                    }
                                    break;
                                }
                            }
                            Class333.setSpeed(Class333.getSpeed());
                        }
                        final boolean b4;
                        n2 = ((b4 = ((n3 = (hurtted = (fastFlew = (globalHypixel.mode.isCurrentMode("Boost") ? 1 : 0)))) != 0)) ? 1 : 0);
                    }
                    if (b2 == null) {
                        if (n != 0) {
                            final double n5 = globalHypixel.mc.field_71439_g.field_70165_t - globalHypixel.mc.field_71439_g.field_70169_q;
                            final double n6 = globalHypixel.mc.field_71439_g.field_70161_v - globalHypixel.mc.field_71439_g.field_70166_s;
                            final Class274 class276 = globalHypixel;
                            final double n7 = n5;
                            final double n8 = n7 * n7;
                            final double n9 = n6;
                            class276.lastDist = Math.sqrt(n8 + n9 * n9);
                            int n11;
                            double func_151470_d;
                            final int n10 = (int)(func_151470_d = (n11 = (globalHypixel.canboost ? 1 : 0)));
                            Label_0507: {
                                if (b2 == null) {
                                    if (n10 != 0) {
                                        final int n12 = (int)(func_151470_d = (n11 = (globalHypixel.hypixelboost ? 1 : 0)));
                                        if (b2 != null) {
                                            break Label_0507;
                                        }
                                        if (n12 != 0) {
                                            final Class274 class277 = globalHypixel;
                                            class277.timervalue += (float)(globalHypixel.decreasing2 ? -0.01 : 0.05);
                                            int n14;
                                            final int n13 = n14 = (int)(func_151470_d = (n11 = dcmpl((double)globalHypixel.timervalue, 1.4)));
                                            if (b2 == null) {
                                                if (n13 >= 0) {
                                                    globalHypixel.decreasing2 = true;
                                                }
                                                final int n15;
                                                n14 = (n15 = (int)(func_151470_d = (n11 = dcmpg((double)globalHypixel.timervalue, 0.9))));
                                            }
                                            if (b2 == null) {
                                                if (n13 <= 0) {
                                                    globalHypixel.decreasing2 = false;
                                                }
                                                func_151470_d = (n14 = (n11 = (globalHypixel.timer.isDelayComplete(4000L) ? 1 : 0)));
                                            }
                                            if (b2 != null) {
                                                break Label_0507;
                                            }
                                            if (n14 != 0) {
                                                globalHypixel.canboost = false;
                                            }
                                        }
                                    }
                                    n11 = (int)(func_151470_d = (globalHypixel.mc.field_71474_y.field_74314_A.func_151470_d() ? 1 : 0));
                                }
                            }
                            final EntityPlayerSP field_71439_g3;
                            Label_0763: {
                                if (b2 == null) {
                                    if (func_151470_d != 0) {
                                        globalHypixel.mc.field_71439_g.func_70634_a(globalHypixel.mc.field_71439_g.field_70165_t, globalHypixel.mc.field_71439_g.field_70163_u + 0.4, globalHypixel.mc.field_71439_g.field_70161_v);
                                        globalHypixel.mc.field_71439_g.field_70181_x = 0.8;
                                        final EntityPlayerSP field_71439_g = globalHypixel.mc.field_71439_g;
                                        field_71439_g.field_70159_w *= 0.1;
                                        final EntityPlayerSP field_71439_g2 = globalHypixel.mc.field_71439_g;
                                        field_71439_g2.field_70179_y *= 0.1;
                                    }
                                    field_71439_g3 = globalHypixel.mc.field_71439_g;
                                    if (b2 != null) {
                                        break Label_0763;
                                    }
                                    n11 = field_71439_g3.field_70173_aa % 2;
                                }
                                if (n11 == 0) {
                                    final EntityPlayerSP field_71439_g4 = globalHypixel.mc.field_71439_g;
                                    final double field_70165_t = globalHypixel.mc.field_71439_g.field_70165_t;
                                    final double field_70163_u = globalHypixel.mc.field_71439_g.field_70163_u;
                                    final int[] b5 = Class139.b();
                                    final Random random = new Random();
                                    final int[] array = b5;
                                    double n17;
                                    double n16 = n17 = random.nextDouble() * 1.111881179271171E-13;
                                    double n18 = 1.2354235325235233E-13;
                                    if (array == null) {
                                        if (n16 > 1.2354235325235233E-13) {
                                            n16 = 1.2354235325235233E-13;
                                        }
                                        n17 = n16;
                                        n18 = 1.2354235325235235E-14;
                                    }
                                    double n20;
                                    double n19 = n20 = n17 + n18;
                                    if (array == null) {
                                        if (n19 > 1.2354235325235233E-13) {
                                            n19 = 1.2354235325235233E-13;
                                        }
                                        n20 = n19;
                                    }
                                    field_71439_g4.func_70107_b(field_70165_t, field_70163_u + n20, globalHypixel.mc.field_71439_g.field_70161_v);
                                }
                                final EntityPlayerSP field_71439_g5 = globalHypixel.mc.field_71439_g;
                            }
                            field_71439_g3.field_70181_x = 0.0;
                            if (b2 == null) {
                                return;
                            }
                        }
                        n3 = (n2 = (hurtted = (fastFlew = (globalHypixel.mode.isCurrentMode("Zoom") ? 1 : 0))));
                    }
                    if (b2 == null) {
                        if (n2 == 0) {
                            return;
                        }
                        hurtted = (n3 = (fastFlew = (globalHypixel.delayTimer.isDelayComplete(globalHypixel.delay.value) ? 1 : 0)));
                    }
                    if (b2 == null) {
                        if (n3 == 0) {
                            return;
                        }
                        fastFlew = (hurtted = (globalHypixel.hurtted ? 1 : 0));
                    }
                    if (b2 == null) {
                        if (hurtted == 0) {
                            globalHypixel.hurtted = true;
                            final Class274 class278 = globalHypixel;
                            if (b2 == null && class278.selfHurt.value) {
                                globalHypixel.damagePlayer(1);
                                if (b2 != null) {
                                    goto Label_0856;
                                }
                            }
                            else {
                                class278.damagePlayerNew();
                            }
                            Class33.setMotion(0.3 + globalHypixel.getSpeedEffect() * 0.05f);
                            globalHypixel.mc.field_71439_g.field_70181_x = 0.42;
                            Class274.fastFlew = 25;
                            Class274.hypixel = 18.4;
                        }
                        fastFlew = Class274.fastFlew + 1;
                    }
                    Class274.fastFlew = fastFlew;
                    final Block blockUnderPlayer$345a1aee = Class274.getBlockUnderPlayer$345a1aee((EntityPlayer)globalHypixel.mc.field_71439_g);
                    boolean onGround$13336d;
                    final boolean b6 = onGround$13336d = globalHypixel.isOnGround$13336d();
                    if (b2 == null) {
                        if (b6) {
                            return;
                        }
                        final boolean func_149730_j;
                        onGround$13336d = (func_149730_j = blockUnderPlayer$345a1aee.func_149730_j());
                    }
                    if (b2 == null) {
                        if (b6) {
                            return;
                        }
                        onGround$13336d = (blockUnderPlayer$345a1aee instanceof BlockGlass);
                    }
                    if (!onGround$13336d) {
                        globalHypixel.mc.field_71439_g.field_70181_x = 0.0;
                        globalHypixel.mc.field_71439_g.field_70159_w = 0.0;
                        globalHypixel.mc.field_71439_g.field_70179_y = 0.0;
                        float n21 = 0.29f + globalHypixel.getSpeedEffect() * 0.06f;
                        double booleanValue;
                        double n24;
                        double n23;
                        final int n22 = (int)(n23 = (n24 = (booleanValue = dcmpl(Class274.hypixel, 0.0))));
                        if (b2 == null) {
                            if (n22 > 0) {
                                final float n25 = fcmpl(globalHypixel.mc.field_71439_g.field_70701_bs, 0.0f);
                                Label_1072: {
                                    Label_1068: {
                                        Label_1065: {
                                            if (b2 == null) {
                                                if (n25 == 0) {
                                                    final float n26 = fcmpl(globalHypixel.mc.field_71439_g.field_70702_br, 0.0f);
                                                    if (b2 != null) {
                                                        break Label_1065;
                                                    }
                                                    if (n26 == 0) {
                                                        break Label_1068;
                                                    }
                                                }
                                                final boolean field_70123_F = globalHypixel.mc.field_71439_g.field_70123_F;
                                            }
                                        }
                                        if (n25 == 0) {
                                            break Label_1072;
                                        }
                                    }
                                    Class274.hypixel = 0.0;
                                }
                                n21 += (float)(Class274.hypixel / 18.0);
                                Class274.hypixel -= new BigDecimal(0.155).setScale(2, RoundingMode.HALF_UP).doubleValue() + globalHypixel.getSpeedEffect() * 0.006;
                            }
                            final int n27;
                            n23 = (n27 = (int)(n24 = (booleanValue = (((boolean)globalHypixel.ultraBoost.value) ? 1 : 0))));
                        }
                        if (b2 == null) {
                            if (n22 != 0) {
                                Class94.getTimer();
                                globalHypixel.delayTimer.isDelayComplete(Double.valueOf(globalHypixel.delay.value + 750.0));
                            }
                            Class33.setMotion(n21);
                            globalHypixel.mc.field_71439_g.field_70747_aH = 0.0f;
                            globalHypixel.mc.field_71439_g.field_70122_E = false;
                            final Class274 class279 = globalHypixel;
                            ++class279.count;
                            final EntityPlayerSP field_71439_g6 = globalHypixel.mc.field_71439_g;
                            n24 = (n23 = (booleanValue = dcmpg(globalHypixel.count, 2.0)));
                        }
                        if (b2 == null) {
                            if (n23 <= 0) {
                                globalHypixel.mc.field_71439_g.func_70107_b(globalHypixel.mc.field_71439_g.field_70165_t, globalHypixel.mc.field_71439_g.field_70163_u + 8.3467347E-12, globalHypixel.mc.field_71439_g.field_70161_v);
                                if (b2 == null) {
                                    return;
                                }
                            }
                            booleanValue = (n24 = dcmpl(globalHypixel.count, 4.0));
                        }
                        final Class274 class280;
                        Label_1423: {
                            if (b2 == null) {
                                if (n24 == 0) {
                                    globalHypixel.mc.field_71439_g.func_70107_b(globalHypixel.mc.field_71439_g.field_70165_t, globalHypixel.mc.field_71439_g.field_70163_u + 3.575474E-12, globalHypixel.mc.field_71439_g.field_70161_v);
                                    if (b2 == null) {
                                        return;
                                    }
                                }
                                class280 = globalHypixel;
                                if (b2 != null) {
                                    break Label_1423;
                                }
                                booleanValue = dcmpl(class280.count, 5.0);
                            }
                            if (booleanValue < 0) {
                                return;
                            }
                            globalHypixel.mc.field_71439_g.func_70107_b(globalHypixel.mc.field_71439_g.field_70165_t, globalHypixel.mc.field_71439_g.field_70163_u + 7.57457457E-12, globalHypixel.mc.field_71439_g.field_70161_v);
                        }
                        class280.count = 0.0;
                    }
                    return;
                }
                fly = this;
                if (b != null) {
                    break Label_1451;
                }
                this.mode.isCurrentMode("Motion");
            }
            if (!currentMode) {
                return;
            }
            this.setDisplayName("Motion");
            fly = this;
        }
        final Class212 motionFly = fly.MotionFly;
        final int[] b7 = Class139.b();
        motionFly.mc.field_71439_g.field_70181_x = 0.0;
        final int[] array2;
        Label_1508: {
            Label_1504: {
                if ((array2 = b7) == null) {
                    if (!Class333.MovementInput()) {
                        break Label_1504;
                    }
                    Class333.setSpeed(motionFly.timer.value * 0.5);
                }
                if (array2 == null) {
                    break Label_1508;
                }
            }
            Class333.setSpeed(0.0);
        }
        final boolean press = ((IKeyBinding)motionFly.mc.field_71474_y.field_74311_E).getPress();
        final Minecraft mc;
        Label_1582: {
            if (array2 == null) {
                if (press) {
                    final EntityPlayerSP field_71439_g7 = motionFly.mc.field_71439_g;
                    --field_71439_g7.field_70181_x;
                    if (array2 == null) {
                        return;
                    }
                }
                mc = motionFly.mc;
                if (array2 != null) {
                    break Label_1582;
                }
                ((IKeyBinding)mc.field_71474_y.field_74314_A).getPress();
            }
            if (!press) {
                return;
            }
            final Minecraft mc2 = motionFly.mc;
        }
        final EntityPlayerSP field_71439_g8 = mc.field_71439_g;
        ++field_71439_g8.field_70181_x;
    }
    
    @EventTarget
    private void onPullback$51d3ef3c() {
        final int[] b = Class139.b();
        final boolean booleanValue = this.lagback.value;
        Label_0054: {
            if (b == null) {
                if (booleanValue) {
                    Class23.sendClientMessage("(LagBackCheck) Fly Disabled", Class153.WARNING);
                    this.set(false);
                }
                if (b != null) {
                    break Label_0054;
                }
                this.mode.isCurrentMode("Hypixel");
            }
            if (!booleanValue) {
                return;
            }
        }
        Class274.onLagback$51d3ef3c();
    }
    
    @EventTarget
    private void onMove(final EventMove eventMove) {
        final int[] b = Class139.b();
        Fly fly = this;
        if (b == null) {
            if (!this.mode.isCurrentMode("Hypixel")) {
                return;
            }
            fly = this;
        }
        final Class274 globalHypixel = fly.GlobalHypixel;
        final int[] b2 = Class139.b();
        boolean b4;
        final boolean b3 = b4 = globalHypixel.mode.isCurrentMode("Boost");
        if (b2 == null) {
            if (b3) {
                final float field_70177_z = globalHypixel.mc.field_71439_g.field_70177_z;
                double n = globalHypixel.mc.field_71439_g.field_71158_b.field_78902_a;
                double n2 = globalHypixel.mc.field_71439_g.field_71158_b.field_78900_b;
                final double n3 = -Math.sin(Math.toRadians(field_70177_z));
                final double cos = Math.cos(Math.toRadians(field_70177_z));
                int n7;
                double level;
                int n6;
                final double n5;
                final int n4 = (int)(n5 = (n6 = (int)(level = (n7 = dcmpl(n2, 0.0)))));
                final double n8;
                final double n9;
                Label_0150: {
                    if (b2 == null) {
                        if (n4 == 0) {
                            n8 = (n6 = (int)(level = (n7 = dcmpl(n, 0.0))));
                            if (b2 != null) {
                                break Label_0150;
                            }
                            if (n8 == 0) {
                                eventMove.x = 0.0;
                                eventMove.z = 0.0;
                            }
                        }
                        n9 = dcmpl(n2, 0.0);
                    }
                }
                final double n10;
                Label_0194: {
                    if (b2 == null) {
                        if (n4 != 0) {
                            n10 = (level = (n7 = dcmpl(n, 0.0)));
                            if (b2 != null) {
                                break Label_0194;
                            }
                            if (n10 != 0) {
                                n2 *= Math.sin(0.7853981633974483);
                                n *= Math.cos(0.7853981633974483);
                            }
                        }
                        n7 = (globalHypixel.hypixelboost ? 1 : 0);
                    }
                }
                Label_0578: {
                    if (b2 == null) {
                        if (n8 == 0) {
                            break Label_0578;
                        }
                        n7 = globalHypixel.level;
                    }
                    int n13;
                    int n12;
                    final int n11 = n12 = (n13 = 1);
                    Label_0486: {
                        final float n14;
                        Label_0458: {
                            Label_0439: {
                                if (b2 == null) {
                                    if (n10 == n11) {
                                        n14 = fcmpl(globalHypixel.mc.field_71439_g.field_70701_bs, 0.0f);
                                        if (b2 != null) {
                                            break Label_0458;
                                        }
                                        if (n14 != 0) {
                                            break Label_0439;
                                        }
                                        final float n15 = fcmpl(globalHypixel.mc.field_71439_g.field_70702_br, 0.0f);
                                        if (b2 != null) {
                                            break Label_0458;
                                        }
                                        if (n15 != 0) {
                                            break Label_0439;
                                        }
                                    }
                                    level = globalHypixel.level;
                                    n13 = (n12 = 2);
                                }
                                final Class274 class276;
                                Label_0414: {
                                    int size = 0;
                                    Label_0385: {
                                        if (b2 == null) {
                                            if (n9 == n12) {
                                                globalHypixel.level = 3;
                                                final Class274 class274 = globalHypixel;
                                                class274.moveSpeed *= 2.1499999;
                                                if (b2 == null) {
                                                    break Label_0486;
                                                }
                                            }
                                            size = (n7 = globalHypixel.level);
                                            if (b2 != null) {
                                                break Label_0385;
                                            }
                                            n13 = 3;
                                        }
                                        if (n9 == n13) {
                                            globalHypixel.level = 4;
                                            final double n16 = 0.73 * (globalHypixel.lastDist - Class274.getBaseMoveSpeed());
                                            final Class274 class275 = globalHypixel;
                                            class275.moveSpeed = class275.lastDist - n16;
                                            if (b2 == null) {
                                                break Label_0486;
                                            }
                                        }
                                        class276 = globalHypixel;
                                        if (b2 != null) {
                                            break Label_0414;
                                        }
                                        size = class276.mc.field_71441_e.func_72945_a((Entity)globalHypixel.mc.field_71439_g, globalHypixel.mc.field_71439_g.func_174813_aQ().func_72317_d(0.0, globalHypixel.mc.field_71439_g.field_70181_x, 0.0)).size();
                                    }
                                    if (size <= 0) {
                                        final Class274 class277 = globalHypixel;
                                        if (b2 != null || !class277.mc.field_71439_g.field_70124_G) {
                                            class277.moveSpeed = globalHypixel.lastDist - globalHypixel.lastDist / 159.0;
                                            if (b2 != null) {
                                                break Label_0439;
                                            }
                                            break Label_0486;
                                        }
                                    }
                                }
                                class276.level = 1;
                                goto Label_0418;
                            }
                            globalHypixel.level = 2;
                            globalHypixel.mc.field_71439_g.func_70644_a(Potion.field_76424_c);
                        }
                        globalHypixel.moveSpeed = ((n14 != 0) ? 1.706 : 2.034) * Class274.getBaseMoveSpeed() - 0.01;
                    }
                    final Class274 class278 = globalHypixel;
                    class278.moveSpeed = Math.max(class278.moveSpeed, Class274.getBaseMoveSpeed());
                    eventMove.x = n2 * globalHypixel.moveSpeed * n3 + n * globalHypixel.moveSpeed * cos;
                    eventMove.z = n2 * globalHypixel.moveSpeed * cos - n * globalHypixel.moveSpeed * n3;
                    final double n17 = dcmpl(n2, 0.0);
                    if (b2 == null) {
                        if (n17 != 0) {
                            break Label_0578;
                        }
                        final double n18 = dcmpl(n, 0.0);
                    }
                    if (n17 == 0) {
                        eventMove.x = 0.0;
                        eventMove.z = 0.0;
                    }
                }
                if (b2 == null) {
                    return;
                }
            }
            final boolean currentMode;
            b4 = (currentMode = globalHypixel.mode.isCurrentMode("Zoom"));
        }
        if (b2 == null) {
            if (!b3) {
                return;
            }
            b4 = globalHypixel.delayTimer.isDelayComplete(globalHypixel.delay.value);
        }
        if (!b4) {
            eventMove.x = 0.0;
            eventMove.y = 0.0;
            eventMove.z = 0.0;
        }
    }
    
    @Override
    public final void onEnable() {
        final int[] b = Class139.b();
        Fly fly = this;
        if (b == null) {
            if (this.mode.isCurrentMode("Hypixel")) {
                final Class274 globalHypixel;
                (globalHypixel = this.GlobalHypixel).stage = 0;
                globalHypixel.level = 1;
                globalHypixel.moveSpeed = 0.1;
                final int[] b2 = Class139.b();
                globalHypixel.lastDist = 0.0;
                globalHypixel.hurtted = false;
                globalHypixel.delayTimer.lastMs = System.currentTimeMillis();
                final int[] array = b2;
                final Class263 aes_UTILS = Class139.AES_UTILS;
                final String hwid_VERIFY = Class139.HWID_VERIFY;
                try {
                    final boolean contains = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
                    Label_0100: {
                        if (array == null) {
                            if (contains) {
                                break Label_0100;
                            }
                            FMLCommonHandler.instance().exitJava(0, true);
                        }
                        Class258.sleep = contains;
                    }
                }
                catch (Exception ex) {
                    FMLCommonHandler.instance().exitJava(0, true);
                    Class258.sleep = true;
                }
                Class274.hypixel = 0.0;
                globalHypixel.count = 0.0;
                Class274.fastFlew = 100;
                final boolean currentMode = globalHypixel.mode.isCurrentMode("Boost");
                if (array == null) {
                    if (currentMode) {
                        globalHypixel.canboost = true;
                        double field_70181_x = 0.40123128;
                        globalHypixel.timervalue = 1.0f;
                        final EntityPlayerSP field_71439_g = globalHypixel.mc.field_71439_g;
                        Label_0405: {
                            if (array == null) {
                                if (field_71439_g.field_70122_E) {
                                    final float n = fcmpl(globalHypixel.mc.field_71439_g.field_70701_bs, 0.0f);
                                    final EntityPlayerSP field_71439_g2;
                                    Label_0298: {
                                        Label_0291: {
                                            if (array == null) {
                                                if (n == 0) {
                                                    field_71439_g2 = globalHypixel.mc.field_71439_g;
                                                    if (array != null) {
                                                        break Label_0298;
                                                    }
                                                    if (field_71439_g2.field_70702_br == 0.0f) {
                                                        break Label_0291;
                                                    }
                                                }
                                                final EntityPlayerSP field_71439_g3 = globalHypixel.mc.field_71439_g;
                                                if (array != null) {
                                                    break Label_0298;
                                                }
                                                final boolean field_70124_G = field_71439_g3.field_70124_G;
                                            }
                                            if (n != 0) {
                                                final EntityPlayerSP field_71439_g4 = globalHypixel.mc.field_71439_g;
                                                if (array == null) {
                                                    if (field_71439_g4.func_70644_a(Potion.field_76430_j)) {
                                                        field_70181_x = 0.40123128 + (globalHypixel.mc.field_71439_g.func_70660_b(Potion.field_76430_j).func_76458_c() + 1) * 0.1f;
                                                    }
                                                    final EntityPlayerSP field_71439_g5 = globalHypixel.mc.field_71439_g;
                                                }
                                                field_71439_g4.field_70181_x = field_70181_x;
                                            }
                                        }
                                        final EntityPlayerSP field_71439_g6 = globalHypixel.mc.field_71439_g;
                                    }
                                    field_71439_g2.func_70107_b(globalHypixel.mc.field_71439_g.field_70165_t, globalHypixel.mc.field_71439_g.field_70163_u - 1.28E-10, globalHypixel.mc.field_71439_g.field_70161_v);
                                    globalHypixel.level = 1;
                                    globalHypixel.moveSpeed = 0.1;
                                    globalHypixel.hypixelboost = true;
                                    globalHypixel.lastDist = 0.0;
                                    if (array == null) {
                                        break Label_0405;
                                    }
                                }
                                final EntityPlayerSP field_71439_g7 = globalHypixel.mc.field_71439_g;
                            }
                            field_71439_g.func_70107_b(globalHypixel.mc.field_71439_g.field_70165_t, globalHypixel.mc.field_71439_g.field_70163_u - 1.26E-10, globalHypixel.mc.field_71439_g.field_70161_v);
                        }
                        globalHypixel.timer.lastMs = System.currentTimeMillis();
                    }
                    globalHypixel.mode.isCurrentMode("Zoom");
                }
                return;
            }
            fly = this;
        }
        fly.onEnable();
    }
    
    @Override
    public final void onDisable() {
        final int[] b = Class139.b();
        Fly fly = this;
        if (b == null) {
            if (this.mode.isCurrentMode("Hypixel")) {
                final Class274 globalHypixel;
                (globalHypixel = this.GlobalHypixel).level = 1;
                globalHypixel.moveSpeed = 0.1;
                globalHypixel.lastDist = 0.0;
                globalHypixel.count = 0.0;
                Class274.fastFlew = 100;
                final EntityPlayerSP field_71439_g = globalHypixel.mc.field_71439_g;
                field_71439_g.field_70159_w *= 0.0;
                final EntityPlayerSP field_71439_g2 = globalHypixel.mc.field_71439_g;
                field_71439_g2.field_70179_y *= 0.0;
                globalHypixel.mc.field_71439_g.field_70747_aH = 0.1f;
                Class94.getTimer();
                Class33.setMotion(0.2);
                return;
            }
            fly = this;
        }
        fly.onDisable();
    }
    
    static {
        llIlIIIlIlll();
        Class169.a(-3945362473870308821L, 2809115120748028714L, MethodHandles.lookup().lookupClass()).a(95895109487268L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Fly.lIIlIIIllll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Fly.lIIlIIIllll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(47395468609664L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[9];
        int n2 = 0;
        String s;
        int n3 = (s = Fly.lIIlIIIllll[2]).length();
        int n4 = 16;
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
                    final String intern = b(instance.doFinal(s3.getBytes(Fly.lIIlIIIllll[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Fly.lIIlIIIllll[3]).length();
                            n4 = 16;
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
        d = new String[9];
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
    
    private static String b(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1DA6;
        if (Fly.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Fly.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Fly.lIIlIIIllll[5]);
                    array[1] = SecretKeyFactory.getInstance(Fly.lIIlIIIllll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Fly.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Fly.lIIlIIIllll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Fly.d[n3] = b(((Cipher)array[0]).doFinal(Fly.c[n3].getBytes(Fly.lIIlIIIllll[8])));
        }
        return Fly.d[n3];
    }
    
    private static void llIlIIIlIlll() {
        (lIIlIIIllll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Fly.lIIlIIIllll[1] = "DES";
        Fly.lIIlIIIllll[2] = "â\u0084v±º8\u009dÜÿ\u0011¢\u0086$J±ò\u0010ôòã\u0095®\u009c\u0087âKô½\u0084=Þ!÷\u0010\nê{\u0015ÞÓP\u009d\u0011µ\u009a\u000e¢ÊÎZ\u0010\u0007_R*\u0006\u0097êÎ3\u009cëâGæ1l\u0010Ë\u009e\u008d\u001d6á@4e\u0088`gW\u0095âM8\u0098\u0002\u000frÝ³\u0011º\fG\u0092\u009f\u009fÈ<\u0095¨\u0086÷\u0017öÃlID\u0004\u0011\u009cåiU\u0014$7Éï\u001f¼åÙtØ\u00004\u0088\u008dæO|&½{<ÿI~(¢\u008f8 \u0013×Ï¸íELÞ\u009b\u0099)y31\u0095Û\f\u0090ì\u001f\u0003ö\u0093\u008c\t\u0018èZÁ!§F]®]E";
        Fly.lIIlIIIllll[3] = "4>fg6Ú*=\u0084VQ +^+\u0091\u00103\u0083³sïùV}rO±\u008c\u0088\u0010`ñ";
        Fly.lIIlIIIllll[4] = "ISO-8859-1";
        Fly.lIIlIIIllll[5] = "DES/CBC/PKCS5Padding";
        Fly.lIIlIIIllll[6] = "DES";
        Fly.lIIlIIIllll[7] = "是不是汗流浃背了啊有本事拿出你的词汇让我心服口服不要自欺欺人所以请你滚蛋吧你怎么还是此地无银三百两的间接说你是窝囊废你自己看看你现在的语言是否还有逻辑自己告诉你亲爹地我稳坐如山NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u200d\u2008\u2002";
        Fly.lIIlIIIllll[8] = "ISO-8859-1";
        Fly.lIIlIIIllll[9] = "是不是汗流浃背了啊有本事拿出你的词汇让我心服口服不要自欺欺人所以请你滚蛋吧你怎么还是此地无银三百两的间接说你是窝囊废你自己看看你现在的语言是否还有逻辑自己告诉你亲爹地我稳坐如山NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2005\u200d\u2008\u2002";
        Fly.lIIlIIIllll[10] = " : ";
        Fly.lIIlIIIllll[11] = " : ";
    }
    
    private static String llIlIIIlIllI(final String s, final String s2) {
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
    
    private static String llIlIIIlIlII(String s, final String s2) {
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
    
    private static String llIlIIIlIlIl(final String s, final String s2) {
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
