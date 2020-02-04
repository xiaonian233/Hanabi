package cn.Hanabi.modules.Movement;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.client.entity.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.block.*;
import net.minecraftforge.fml.common.*;
import net.minecraft.client.*;
import net.minecraft.potion.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Speed extends Mod
{
    private static Value mode;
    private Value<Boolean> lagback;
    private Class222 GlobalHypixel;
    private Class266 GlobalHypixel2;
    private Class19 Hypixel;
    private Class177 GudHop;
    private Class259 AAC;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIIIIIlIll;
    
    public Speed() {
        super("Speed", Category.MOVEMENT);
        this.lagback = new Value<Boolean>("Speed_LagBackChecks", Boolean.TRUE);
        new Class222();
        this.GlobalHypixel2 = new Class266();
        new Class19();
        this.GudHop = new Class177();
        this.AAC = new Class259();
        Speed.mode.addValue("AAC");
        Speed.mode.addValue("GudHop");
        Speed.mode.addValue("Hypixel");
    }
    
    @EventTarget
    private void onStep$16e8f2e4() {
        if (Class139.b() == null) {
            if (!Speed.mode.isCurrentMode("Hypixel")) {
                return;
            }
            final Class266 globalHypixel2 = this.GlobalHypixel2;
            final int[] b = Class139.b();
            final double n = globalHypixel2.mc.field_71439_g.func_174813_aQ().field_72338_b - globalHypixel2.mc.field_71439_g.field_70163_u;
            final int[] array = b;
            final double n2 = dcmpl(n, 0.7);
            if (array == null) {
                if (n2 > 0) {
                    globalHypixel2.less = 0.0;
                }
                final double n3 = dcmpl(n, 0.5);
            }
            if (n2 == 0) {
                globalHypixel2.stair = 0.75;
            }
        }
    }
    
    @EventTarget
    private void onUpdate$3a3d1cb1() {
        if (Class139.b() == null) {
            if (!Speed.mode.isCurrentMode("GudHop")) {
                return;
            }
            this.setDisplayName("GudHop");
            final Class177 gudHop = this.GudHop;
            final int[] b = Class139.b();
            final boolean field_70122_E;
            final boolean b2 = field_70122_E = gudHop.mc.field_71439_g.field_70122_E;
            final boolean movementInput;
            Label_0130: {
                Label_0127: {
                    Label_0097: {
                        if (b == null) {
                            if (b2) {
                                movementInput = Class333.MovementInput();
                                if (b != null) {
                                    break Label_0097;
                                }
                                if (movementInput) {
                                    final boolean func_70090_H = gudHop.mc.field_71439_g.func_70090_H();
                                    if (b != null) {
                                        break Label_0097;
                                    }
                                    if (!func_70090_H) {
                                        Class94.getTimer();
                                        gudHop.mc.field_71439_g.func_70664_aZ();
                                        if (b == null) {
                                            break Label_0127;
                                        }
                                    }
                                }
                            }
                            Class333.MovementInput();
                        }
                    }
                    if (b != null) {
                        break Label_0130;
                    }
                    if (b2) {
                        final boolean func_70090_H2 = gudHop.mc.field_71439_g.func_70090_H();
                        if (b != null) {
                            break Label_0130;
                        }
                        if (!func_70090_H2) {
                            Class333.setSpeed(0.8);
                        }
                    }
                }
                Class333.MovementInput();
            }
            if (!movementInput) {
                final EntityPlayerSP field_71439_g = gudHop.mc.field_71439_g;
                final EntityPlayerSP field_71439_g2 = gudHop.mc.field_71439_g;
                final double n = 0.0;
                field_71439_g2.field_70179_y = n;
                field_71439_g.field_70159_w = n;
            }
        }
    }
    
    @EventTarget
    private void onPullback$51d3ef3c() {
        final int[] b = Class139.b();
        final boolean booleanValue = this.lagback.value;
        if (b == null) {
            if (booleanValue) {
                Class23.sendClientMessage("(LagBackCheck) Speed Disabled", Class153.WARNING);
                this.set(false);
            }
            Speed.mode.isCurrentMode("Hypixel");
        }
        if (booleanValue) {
            this.GlobalHypixel2.stage = -4;
        }
    }
    
    @EventTarget
    private void onMove(final EventMove eventMove) {
        final int[] b = Class139.b();
        final boolean currentMode = Speed.mode.isCurrentMode("Hypixel");
        if (b == null) {
            if (currentMode) {
                this.setDisplayName("Hypixel");
                final Class266 globalHypixel2 = this.GlobalHypixel2;
                final int[] b2 = Class139.b();
                double field_70123_F;
                final int n = (int)(field_70123_F = (globalHypixel2.mc.field_71439_g.field_70123_F ? 1 : 0));
                if (b2 == null) {
                    if (n != 0) {
                        globalHypixel2.collided = true;
                    }
                    final boolean collided;
                    field_70123_F = ((collided = globalHypixel2.collided) ? 1 : 0);
                }
                Class266 class267 = null;
                final Class266 class266;
                Label_0112: {
                    if (b2 == null) {
                        if (n != 0) {
                            Class94.getTimer();
                            globalHypixel2.stage = -1;
                        }
                        class266 = (class267 = globalHypixel2);
                        if (b2 != null) {
                            break Label_0112;
                        }
                        field_70123_F = dcmpl(class266.stair, 0.0);
                    }
                    if (field_70123_F > 0) {
                        final Class266 class268 = globalHypixel2;
                        class268.stair -= 0.25;
                    }
                    final Class266 class269;
                    class267 = (class269 = globalHypixel2);
                }
                final double less = class266.less;
                final double less2 = globalHypixel2.less;
                if (b2 == null && less2 <= 1.0) {}
                class267.less = less - less2;
                float n7;
                int inLiquid;
                int n6;
                int n5;
                int n4;
                int n3;
                final int n2 = n3 = (n4 = (n5 = (n6 = (inLiquid = (int)(n7 = dcmpg(globalHypixel2.less, 0.0))))));
                final int n8;
                if (b2 == null) {
                    if (n2 < 0) {
                        globalHypixel2.less = 0.0;
                    }
                    n8 = (n6 = (inLiquid = (int)(n7 = (globalHypixel2.isInLiquid() ? 1 : 0))));
                }
                final int n16;
                Label_0769: {
                    if (b2 == null) {
                        if (n2 == 0) {
                            final int n9 = n3 = (n4 = (n5 = (n6 = (inLiquid = (int)(n7 = (Class33.isOnGround(0.01) ? 1 : 0))))));
                            if (b2 != null) {
                                break Label_0769;
                            }
                            if (n9 != 0) {
                                final int n10 = n3 = (n4 = (n5 = (n6 = (inLiquid = (int)(n7 = (Class333.isMoving2() ? 1 : 0))))));
                                if (b2 != null) {
                                    break Label_0769;
                                }
                                if (n10 != 0) {
                                    final Class266 class270 = globalHypixel2;
                                    class270.collided = class270.mc.field_71439_g.field_70123_F;
                                    final Class266 class271 = globalHypixel2;
                                    if (b2 == null && class271.stage < 0) {
                                        final int n11 = n3 = (n4 = (n5 = (n6 = (inLiquid = (int)(n7 = (globalHypixel2.collided ? 1 : 0))))));
                                        if (b2 != null) {
                                            break Label_0769;
                                        }
                                        if (n11 != 0) {
                                            goto Label_0254;
                                        }
                                    }
                                    else {
                                        class271.stage = 0;
                                        final double n12 = 0.40020502030059285 + Class33.getJumpEffect() * 0.1;
                                        final double n13 = dcmpl(globalHypixel2.stair, 0.0);
                                        Label_0369: {
                                            final Class266 class273;
                                            Label_0365: {
                                                if (b2 == null) {
                                                    if (n13 == 0) {
                                                        globalHypixel2.mc.field_71439_g.func_70664_aZ();
                                                        final EntityPlayerSP field_71439_g = globalHypixel2.mc.field_71439_g;
                                                        final double n14 = n12;
                                                        field_71439_g.field_70181_x = n14;
                                                        eventMove.y = n14;
                                                    }
                                                    final Class266 class272 = globalHypixel2;
                                                    ++class272.less;
                                                    class273 = globalHypixel2;
                                                    if (b2 != null) {
                                                        break Label_0365;
                                                    }
                                                    final double n15 = dcmpl(class273.less, 1.0);
                                                }
                                                if (n13 > 0) {
                                                    final Class266 class274 = globalHypixel2;
                                                    if (b2 == null) {
                                                        if (!class274.lessSlow) {
                                                            globalHypixel2.lessSlow = true;
                                                            if (b2 == null) {
                                                                break Label_0369;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            class273.lessSlow = false;
                                        }
                                        n16 = (n4 = (n5 = (n6 = (inLiquid = (int)(n7 = dcmpl(globalHypixel2.less, 1.12))))));
                                        if (b2 != null) {
                                            break Label_0769;
                                        }
                                        if (n16 > 0) {
                                            globalHypixel2.less = 1.12;
                                        }
                                    }
                                }
                            }
                        }
                        final Class266 class275 = globalHypixel2;
                        final int stage = globalHypixel2.stage;
                        final Class266 class276 = class275;
                        double n17 = Class33.getArBaseMoveSpeed() + 0.028 * Class33.getSpeedEffect() + Class33.getSpeedEffect() / 15.0;
                        final int[] b3 = Class139.b();
                        final double n18 = 0.4145 + Class33.getSpeedEffect() / 12.5;
                        final double n19 = stage / 500.0 * 2.0;
                        final int[] array = b3;
                        int n21;
                        final int n20 = n21 = stage;
                        int n24 = 0;
                        int shouldslow = 0;
                        Label_0658: {
                            Label_0653: {
                                if (array == null) {
                                    if (n20 == 0) {
                                        boolean b5;
                                        final boolean b4 = b5 = class276.timer.isDelayComplete(300.0f);
                                        if (array == null) {
                                            if (b4) {
                                                class276.timer.lastMs = System.currentTimeMillis();
                                            }
                                            final boolean delayComplete;
                                            b5 = (delayComplete = class276.lastCheck.isDelayComplete(500.0f));
                                        }
                                        Label_0564: {
                                            final Class266 class278;
                                            Label_0560: {
                                                if (array == null) {
                                                    if (!b4) {
                                                        final Class266 class277 = class276;
                                                        if (array == null && class277.shouldslow) {
                                                            break Label_0564;
                                                        }
                                                        class277.shouldslow = true;
                                                        if (array == null) {
                                                            break Label_0564;
                                                        }
                                                    }
                                                    class278 = class276;
                                                    if (array != null) {
                                                        break Label_0560;
                                                    }
                                                    b5 = class278.shouldslow;
                                                }
                                                if (!b5) {
                                                    break Label_0564;
                                                }
                                            }
                                            class278.shouldslow = false;
                                        }
                                        n17 = 0.64 + (Class33.getSpeedEffect() + 0.028 * Class33.getSpeedEffect()) * 0.134;
                                        if (array == null) {
                                            break Label_0653;
                                        }
                                    }
                                    final int n22;
                                    n21 = (n22 = stage);
                                }
                                final int n23 = 1;
                                if (array == null) {
                                    if (n20 == n23) {
                                        final float field_74278_d = Class94.getTimer().field_74278_d;
                                        n17 = n18;
                                        if (array == null) {
                                            break Label_0653;
                                        }
                                    }
                                    shouldslow = (n21 = (n24 = stage));
                                    if (array != null) {
                                        break Label_0658;
                                    }
                                }
                                if (n21 >= n23) {
                                    final float field_74278_d2 = Class94.getTimer().field_74278_d;
                                    n17 = n18 - n19;
                                }
                            }
                            n24 = (shouldslow = (class276.shouldslow ? 1 : 0));
                        }
                        final double n25;
                        Label_0715: {
                            Label_0709: {
                                if (array == null) {
                                    if (shouldslow == 0) {
                                        final boolean b6 = (n24 = (class276.lastCheck.isDelayComplete(500.0f) ? 1 : 0)) != 0;
                                        if (array != null) {
                                            break Label_0709;
                                        }
                                        if (b6) {
                                            final boolean b7 = (n24 = (class276.collided ? 1 : 0)) != 0;
                                            if (array != null) {
                                                break Label_0709;
                                            }
                                            if (!b7) {
                                                break Label_0715;
                                            }
                                        }
                                    }
                                    n25 = 0.2;
                                    if (array != null) {
                                        break Label_0715;
                                    }
                                    n17 = n25;
                                    n24 = stage;
                                }
                            }
                            if (n24 == 0) {
                                n17 = 0.0;
                            }
                        }
                        class275.speed = Math.max(n25, class276.shouldslow ? n17 : (Class33.getArBaseMoveSpeed() + 0.028 * Class333.getBaseMoveSpeed())) + 0.033147214;
                        final Class266 class279 = globalHypixel2;
                        class279.speed *= 0.9021;
                        n6 = (inLiquid = (int)(n7 = dcmpl(globalHypixel2.stair, 0.0)));
                    }
                }
                if (b2 == null) {
                    if (n16 > 0) {
                        final Class266 class280 = globalHypixel2;
                        class280.speed *= 0.7071 - Class33.getSpeedEffect() * 0.1;
                    }
                    n6 = (inLiquid = (int)(n7 = globalHypixel2.stage));
                }
                if (b2 == null) {
                    if (n8 < 0) {
                        globalHypixel2.speed = Class33.getArBaseMoveSpeed();
                    }
                    n6 = (n5 = (inLiquid = (int)(n7 = (globalHypixel2.lessSlow ? 1 : 0))));
                }
                if (b2 == null) {
                    if (n8 != 0) {
                        final Class266 class281 = globalHypixel2;
                        class281.speed *= 0.9471;
                    }
                    inLiquid = (n6 = (int)(n7 = (globalHypixel2.lessSlow ? 1 : 0)));
                }
                if (b2 == null) {
                    if (n6 != 0) {
                        final Class266 class282 = globalHypixel2;
                        class282.speed *= 0.9347214521;
                    }
                    n7 = (inLiquid = (globalHypixel2.isInLiquid() ? 1 : 0));
                }
                final Class266 class283;
                final Class266 class285;
                Label_1307: {
                    if (b2 == null) {
                        if (inLiquid != 0) {
                            globalHypixel2.speed = 0.10123456789;
                        }
                        final Class266 class284;
                        class283 = (class284 = globalHypixel2);
                        if (b2 != null) {
                            break Label_1307;
                        }
                        n7 = fcmpl(class283.mc.field_71439_g.field_70701_bs, 0.0f);
                    }
                    if (n7 == 0) {
                        class285 = globalHypixel2;
                        if (b2 != null) {
                            break Label_1307;
                        }
                        if (class285.mc.field_71439_g.field_70702_br == 0.0f) {
                            return;
                        }
                    }
                    final Class266 class286 = globalHypixel2;
                    final double speed = globalHypixel2.speed;
                    final Class266 class287 = class286;
                    final int[] b8 = Class139.b();
                    double n26 = class287.mc.field_71439_g.field_71158_b.field_78900_b;
                    double n27 = class287.mc.field_71439_g.field_71158_b.field_78902_a;
                    float field_70177_z = class287.mc.field_71439_g.field_70177_z;
                    final int[] array2 = b8;
                    double n32;
                    double n31;
                    int n30;
                    final double n29;
                    final int n28 = (int)(n29 = (n30 = (int)(n31 = (n32 = dcmpl(n26, 0.0)))));
                    final double n33;
                    final double n34;
                    Label_1037: {
                        if (array2 == null) {
                            if (n28 == 0) {
                                n33 = (n30 = (int)(n31 = (n32 = dcmpl(n27, 0.0))));
                                if (array2 != null) {
                                    break Label_1037;
                                }
                                if (n33 == 0) {
                                    eventMove.x = 0.0;
                                    eventMove.z = 0.0;
                                    if (array2 == null) {
                                        break Label_1307;
                                    }
                                }
                            }
                            n34 = (n32 = dcmpl(n26, 0.0));
                        }
                    }
                    Label_1199: {
                        if (array2 == null) {
                            if (n28 == 0) {
                                break Label_1199;
                            }
                            n32 = dcmpl(n27, 0.0);
                        }
                        Label_1153: {
                            Label_1146: {
                                if (array2 == null) {
                                    if (n33 > 0) {
                                        final float n35 = field_70177_z;
                                        final double n36 = dcmpl(n26, 0.0);
                                        if (array2 == null && n36 <= 0) {}
                                        field_70177_z = n35 + (float)n36;
                                        if (array2 == null) {
                                            break Label_1146;
                                        }
                                    }
                                    n32 = dcmpg(n27, 0.0);
                                }
                                if (array2 != null) {
                                    break Label_1153;
                                }
                                if (n34 < 0) {
                                    final float n37 = field_70177_z;
                                    final double n38 = dcmpl(n26, 0.0);
                                    if (array2 == null && n38 <= 0) {}
                                    field_70177_z = n37 + (float)n38;
                                }
                            }
                            n27 = 0.0;
                            n32 = (n31 = dcmpl(n26, 0.0));
                        }
                        final double n39;
                        Label_1197: {
                            if (array2 == null) {
                                if (n34 > 0) {
                                    n26 = 1.0;
                                    if (array2 == null) {
                                        break Label_1199;
                                    }
                                }
                                n39 = n26;
                                if (array2 != null) {
                                    break Label_1197;
                                }
                                n32 = dcmpg(n39, 0.0);
                            }
                            if (n32 >= 0) {
                                break Label_1199;
                            }
                        }
                        n26 = n39;
                    }
                    final EntityPlayerSP field_71439_g2 = class287.mc.field_71439_g;
                    final double n40 = n26 * speed * Math.cos(Math.toRadians(field_70177_z + 88.0)) + n27 * speed * Math.sin(Math.toRadians(field_70177_z + 87.9000015258789));
                    field_71439_g2.field_70159_w = n40;
                    eventMove.x = n40;
                    final EntityPlayerSP field_71439_g3 = class287.mc.field_71439_g;
                    final double n41 = n26 * speed * Math.sin(Math.toRadians(field_70177_z + 88.0)) - n27 * speed * Math.cos(Math.toRadians(field_70177_z + 87.9000015258789));
                    field_71439_g3.field_70179_y = n41;
                    eventMove.z = n41;
                }
                class285.stage = class283.stage + 1;
                return;
            }
            Speed.mode.isCurrentMode("AAC");
        }
        if (currentMode) {
            this.setDisplayName("AAC");
            final Class259 aac = this.AAC;
            final int[] b9 = Class139.b();
            float n45;
            float n44;
            int n43;
            final int n42 = n43 = (int)(n44 = (n45 = (Class4.getModule("Scaffold").state ? 1 : 0)));
            if (b9 == null) {
                if (n42 != 0) {
                    final EntityPlayerSP field_71439_g4 = aac.mc.field_71439_g;
                    if (b9 == null) {
                        if (!field_71439_g4.field_70122_E) {
                            return;
                        }
                        final EntityPlayerSP field_71439_g5 = aac.mc.field_71439_g;
                    }
                    field_71439_g4.func_70664_aZ();
                    eventMove.y = aac.mc.field_71439_g.field_70181_x;
                    return;
                }
                final int n46;
                n43 = (n46 = (int)(n44 = (n45 = dcmpl((double)aac.mc.field_71439_g.field_70143_R, 1.2))));
            }
            if (b9 == null) {
                if (n42 > 0) {
                    aac.lastFall.lastMs = System.currentTimeMillis();
                }
                n44 = (n43 = (int)(n45 = (aac.isInLiquid() ? 1 : 0)));
            }
            Label_2758: {
                if (b9 == null) {
                    Label_1583: {
                        if (n43 == 0) {
                            final int n47 = (int)(n44 = (n45 = (aac.mc.field_71439_g.field_70124_G ? 1 : 0)));
                            if (b9 != null) {
                                break Label_2758;
                            }
                            if (n47 != 0) {
                                final int n48 = (int)(n44 = (n45 = (Class33.isOnGround(0.01) ? 1 : 0)));
                                if (b9 != null) {
                                    break Label_2758;
                                }
                                if (n48 != 0) {
                                    final float n49 = n44 = (n45 = fcmpl(aac.mc.field_71439_g.field_70701_bs, 0.0f));
                                    if (b9 == null) {
                                        if (n49 == 0) {
                                            final float n50 = n44 = (n45 = fcmpl(aac.mc.field_71439_g.field_70702_br, 0.0f));
                                            if (b9 != null) {
                                                break Label_2758;
                                            }
                                            if (n50 == 0) {
                                                break Label_1583;
                                            }
                                        }
                                        aac.stage = 0;
                                        aac.mc.field_71439_g.func_70664_aZ();
                                        final EntityPlayerSP field_71439_g6 = aac.mc.field_71439_g;
                                        final double n51 = 0.41999998688698 + Class33.getJumpEffect();
                                        field_71439_g6.field_70181_x = n51;
                                        eventMove.y = n51;
                                        final int n52;
                                        n44 = (n52 = (int)(n45 = aac.aacCount));
                                    }
                                    if (b9 != null) {
                                        break Label_2758;
                                    }
                                    if (n49 < 4) {
                                        final Class259 class288 = aac;
                                        ++class288.aacCount;
                                    }
                                }
                            }
                        }
                    }
                    final Class259 class289 = aac;
                    final int stage2 = aac.stage;
                    final int aacCount = aac.aacCount;
                    final int n53 = stage2;
                    final Class259 class290 = class289;
                    final int[] b10 = Class139.b();
                    double speed2 = 0.29;
                    final int[] array3 = b10;
                    final double n54 = 0.0286 - n53 / 1000.0;
                    int n68;
                    int n67;
                    int n66;
                    int n65;
                    int n64;
                    int n63;
                    int n62;
                    int n61;
                    int n60;
                    int n59;
                    int n58;
                    int n57;
                    int n56;
                    final int n55 = n56 = (n57 = (n58 = (n59 = (n60 = (n61 = (n62 = (n63 = (n64 = (n65 = (n66 = (n67 = (n68 = n53))))))))))));
                    float field_70123_F2 = 0.0f;
                    int n88 = 0;
                    Label_2684: {
                        Label_2671: {
                            if (array3 == null) {
                                if (n55 == 0) {
                                    speed2 = 0.497;
                                    final int n69 = aacCount;
                                    final int n70 = 2;
                                    if (array3 == null && Class259.lIIIIIII(n69, n70)) {
                                        speed2 = 0.6039;
                                        goto Label_1657;
                                    }
                                    if (Class259.lIIIIIII(n69, n70)) {
                                        speed2 += 0.046;
                                    }
                                    final Block blockUnderPlayer$345a1aee;
                                    final boolean b11 = (blockUnderPlayer$345a1aee = Class33.getBlockUnderPlayer$345a1aee((EntityPlayer)class290.mc.field_71439_g)) instanceof BlockIce;
                                    Label_1713: {
                                        Label_1708: {
                                            if (array3 == null) {
                                                if (b11) {
                                                    break Label_1708;
                                                }
                                                final boolean b12 = blockUnderPlayer$345a1aee instanceof BlockPackedIce;
                                            }
                                            if (!b11) {
                                                break Label_1713;
                                            }
                                        }
                                        speed2 = 0.59;
                                    }
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                final int n71;
                                n56 = (n71 = (n57 = (n58 = (n59 = (n60 = (n61 = (n62 = (n63 = (n64 = (n65 = (n66 = (n67 = (n68 = n53)))))))))))));
                            }
                            int n85;
                            int n84;
                            int n83;
                            int n82;
                            int n81;
                            int n80;
                            int n79;
                            int n78;
                            int n77;
                            int n76;
                            int n75;
                            int n74;
                            int n73;
                            final int n72 = n73 = (n74 = (n75 = (n76 = (n77 = (n78 = (n79 = (n80 = (n81 = (n82 = (n83 = (n84 = (n85 = 1))))))))))));
                            if (array3 == null) {
                                if (n55 == n72) {
                                    speed2 = 0.3031;
                                    final int n86 = aacCount;
                                    final int n87 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n86, n87)) {
                                            speed2 = 0.36729999999999996;
                                        }
                                        final int n89;
                                        n88 = (n89 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n86, n87)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n57 = (n56 = (n58 = (n59 = (n60 = (n61 = (n62 = (n63 = (n64 = (n65 = (n66 = (n67 = (n68 = n53))))))))))));
                                n74 = (n73 = (n75 = (n76 = (n77 = (n78 = (n79 = (n80 = (n81 = (n82 = (n83 = (n84 = (n85 = 2))))))))))));
                            }
                            if (array3 == null) {
                                if (n56 == n73) {
                                    speed2 = 0.302;
                                    final int n90 = aacCount;
                                    final int n91 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n90, n91)) {
                                            speed2 = 0.3649;
                                        }
                                        final int n92;
                                        n88 = (n92 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n90, n91)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n58 = (n57 = (n59 = (n60 = (n61 = (n62 = (n63 = (n64 = (n65 = (n66 = (n67 = (n68 = n53)))))))))));
                                n75 = (n74 = (n76 = (n77 = (n78 = (n79 = (n80 = (n81 = (n82 = (n83 = (n84 = (n85 = 3)))))))))));
                            }
                            if (array3 == null) {
                                if (n57 == n74) {
                                    speed2 = 0.3019;
                                    final int n93 = aacCount;
                                    final int n94 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n93, n94)) {
                                            speed2 = 0.3626;
                                        }
                                        final int n95;
                                        n88 = (n95 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n93, n94)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n59 = (n58 = (n60 = (n61 = (n62 = (n63 = (n64 = (n65 = (n66 = (n67 = (n68 = n53))))))))));
                                n76 = (n75 = (n77 = (n78 = (n79 = (n80 = (n81 = (n82 = (n83 = (n84 = (n85 = 4))))))))));
                            }
                            if (array3 == null) {
                                if (n58 == n75) {
                                    speed2 = 0.3019;
                                    final int n96 = aacCount;
                                    final int n97 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n96, n97)) {
                                            speed2 = 0.3603;
                                        }
                                        final int n98;
                                        n88 = (n98 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n96, n97)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n60 = (n59 = (n61 = (n62 = (n63 = (n64 = (n65 = (n66 = (n67 = (n68 = n53)))))))));
                                n77 = (n76 = (n78 = (n79 = (n80 = (n81 = (n82 = (n83 = (n84 = (n85 = 5)))))))));
                            }
                            if (array3 == null) {
                                if (n59 == n76) {
                                    speed2 = 0.3019;
                                    final int n99 = aacCount;
                                    final int n100 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n99, n100)) {
                                            speed2 = 0.358;
                                        }
                                        final int n101;
                                        n88 = (n101 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n99, n100)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n61 = (n60 = (n62 = (n63 = (n64 = (n65 = (n66 = (n67 = (n68 = n53))))))));
                                n78 = (n77 = (n79 = (n80 = (n81 = (n82 = (n83 = (n84 = (n85 = 6))))))));
                            }
                            if (array3 == null) {
                                if (n60 == n77) {
                                    speed2 = 0.3019;
                                    final int n102 = aacCount;
                                    final int n103 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n102, n103)) {
                                            speed2 = 0.3558;
                                        }
                                        final int n104;
                                        n88 = (n104 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n102, n103)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n62 = (n61 = (n63 = (n64 = (n65 = (n66 = (n67 = (n68 = n53)))))));
                                n79 = (n78 = (n80 = (n81 = (n82 = (n83 = (n84 = (n85 = 7)))))));
                            }
                            if (array3 == null) {
                                if (n61 == n78) {
                                    speed2 = 0.3019;
                                    final int n105 = aacCount;
                                    final int n106 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n105, n106)) {
                                            speed2 = 0.3536;
                                        }
                                        final int n107;
                                        n88 = (n107 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n105, n106)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n63 = (n62 = (n64 = (n65 = (n66 = (n67 = (n68 = n53))))));
                                n80 = (n79 = (n81 = (n82 = (n83 = (n84 = (n85 = 8))))));
                            }
                            if (array3 == null) {
                                if (n62 == n79) {
                                    speed2 = 0.3019;
                                    int onGround;
                                    final int n108 = onGround = (Class33.isOnGround(0.05) ? 1 : 0);
                                    if (array3 == null) {
                                        if (n108 != 0) {
                                            speed2 = 0.2999;
                                        }
                                        final int n109;
                                        onGround = (n109 = aacCount);
                                    }
                                    final int n110 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n108, n110)) {
                                            speed2 += 0.0496;
                                        }
                                        n88 = (onGround = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(onGround, n110)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n64 = (n63 = (n65 = (n66 = (n67 = (n68 = n53)))));
                                n81 = (n80 = (n82 = (n83 = (n84 = (n85 = 9)))));
                            }
                            if (array3 == null) {
                                if (n63 == n80) {
                                    speed2 = 0.3019;
                                    final int n111 = aacCount;
                                    final int n112 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n111, n112)) {
                                            speed2 = 0.3494;
                                        }
                                        final int n113;
                                        n88 = (n113 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n111, n112)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n65 = (n64 = (n66 = (n67 = (n68 = n53))));
                                n82 = (n81 = (n83 = (n84 = (n85 = 10))));
                            }
                            if (array3 == null) {
                                if (n64 == n81) {
                                    speed2 = 0.3019;
                                    final int n114 = aacCount;
                                    final int n115 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n114, n115)) {
                                            speed2 = 0.3474;
                                        }
                                        final int n116;
                                        n88 = (n116 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n114, n115)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n66 = (n65 = (n67 = (n68 = n53)));
                                n83 = (n82 = (n84 = (n85 = 11)));
                            }
                            if (array3 == null) {
                                if (n65 == n82) {
                                    speed2 = 0.3;
                                    final int n117 = aacCount;
                                    final int n118 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n117, n118)) {
                                            speed2 = 0.345;
                                        }
                                        final int n119;
                                        n88 = (n119 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n117, n118)) {
                                        break Label_2671;
                                    }
                                    speed2 += 0.018;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n67 = (n66 = (n68 = n53));
                                n84 = (n83 = (n85 = 12));
                            }
                            if (array3 == null) {
                                if (n66 == n83) {
                                    speed2 = 0.301;
                                    int n121;
                                    final int n120 = n121 = aacCount;
                                    int n123;
                                    int n122 = n123 = 2;
                                    if (array3 == null) {
                                        if (n120 <= 2) {
                                            class290.aacCount = 0;
                                        }
                                        final int n124;
                                        n121 = (n124 = aacCount);
                                        n122 = (n123 = 2);
                                    }
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n120, n123)) {
                                            speed2 = 0.34299999999999997;
                                        }
                                        n88 = (n121 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                        n122 = 3;
                                    }
                                    if (!Class259.lIIIIIII(n121, n122)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54 + 0.001;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n68 = (n67 = n53);
                                n85 = (n84 = 13);
                            }
                            if (array3 == null) {
                                if (n67 == n84) {
                                    speed2 = 0.298;
                                    final int n125 = aacCount;
                                    final int n126 = 2;
                                    if (array3 == null) {
                                        if (Class259.lIIIIIII(n125, n126)) {
                                            speed2 = 0.33999999999999997;
                                        }
                                        final int n127;
                                        n88 = (n127 = (int)(field_70123_F2 = aacCount));
                                        if (array3 != null) {
                                            break Label_2684;
                                        }
                                    }
                                    if (!Class259.lIIIIIII(n125, n126)) {
                                        break Label_2671;
                                    }
                                    speed2 += n54 + 0.001;
                                    if (array3 == null) {
                                        break Label_2671;
                                    }
                                }
                                n88 = (n68 = (int)(field_70123_F2 = n53));
                                if (array3 != null) {
                                    break Label_2684;
                                }
                                n85 = 14;
                            }
                            if (n68 == n85) {
                                speed2 = 0.297;
                                final int n128 = aacCount;
                                final int n129 = 2;
                                if (array3 == null) {
                                    if (Class259.lIIIIIII(n128, n129)) {
                                        speed2 = 0.33899999999999997;
                                    }
                                    final int n130;
                                    n88 = (n130 = (int)(field_70123_F2 = aacCount));
                                    if (array3 != null) {
                                        break Label_2684;
                                    }
                                }
                                if (Class259.lIIIIIII(n128, n129)) {
                                    speed2 += n54 + 0.001;
                                }
                            }
                        }
                        field_70123_F2 = (n88 = fcmpg(class290.mc.field_71439_g.field_70701_bs, 0.0f));
                    }
                    Label_2741: {
                        final Class259 class291;
                        Label_2737: {
                            if (array3 == null) {
                                if (n88 <= 0) {
                                    speed2 -= 0.06;
                                }
                                class291 = class290;
                                if (array3 != null) {
                                    break Label_2737;
                                }
                                field_70123_F2 = (class291.mc.field_71439_g.field_70123_F ? 1 : 0);
                            }
                            if (field_70123_F2 == 0) {
                                break Label_2741;
                            }
                            speed2 -= 0.1;
                        }
                        class291.aacCount = 0;
                    }
                    class289.speed = speed2;
                    n45 = (n44 = fcmpl(aac.mc.field_71439_g.field_70701_bs, 0.0f));
                }
            }
            final Class259 class293;
            final Class259 class295;
            Label_2861: {
                final float n131;
                Label_2838: {
                    Label_2822: {
                        final Class259 class292;
                        Label_2803: {
                            if (b9 == null) {
                                if (n44 == 0) {
                                    n131 = fcmpl(aac.mc.field_71439_g.field_70702_br, 0.0f);
                                    if (b9 != null) {
                                        break Label_2838;
                                    }
                                    if (n131 == 0) {
                                        break Label_2822;
                                    }
                                }
                                class292 = aac;
                                if (b9 != null) {
                                    break Label_2803;
                                }
                                n45 = (class292.isInLiquid() ? 1 : 0);
                            }
                            if (n45 != 0) {
                                aac.speed = 0.075;
                            }
                        }
                        ((IEntityPlayerSP)class292.mc.field_71439_g).setMoveSpeed(eventMove, aac.speed);
                    }
                    final Class259 class294;
                    class293 = (class294 = aac);
                    if (b9 != null) {
                        break Label_2861;
                    }
                    final float n132 = fcmpl(class293.mc.field_71439_g.field_70701_bs, 0.0f);
                }
                if (n131 == 0) {
                    class295 = aac;
                    if (b9 == null) {
                        if (class295.mc.field_71439_g.field_70702_br == 0.0f) {
                            return;
                        }
                    }
                }
            }
            class295.stage = class293.stage + 1;
        }
    }
    
    @Override
    public final void onDisable() {
        final int[] b = Class139.b();
        final Class263 aes_UTILS = Class139.AES_UTILS;
        final String hwid_VERIFY = Class139.HWID_VERIFY;
        try {
            final boolean contains = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
            Label_0038: {
                if (b == null) {
                    if (contains) {
                        break Label_0038;
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
        final boolean currentMode = Speed.mode.isCurrentMode("Hypixel");
        if (b == null) {
            if (currentMode) {
                Class266.onDisable();
                return;
            }
            Speed.mode.isCurrentMode("AAC");
        }
        if (currentMode) {
            this.AAC.aacCount = 0;
        }
    }
    
    @Override
    public final void onEnable() {
        if (Class139.b() == null) {
            if (!Speed.mode.isCurrentMode("Hypixel")) {
                return;
            }
            final Class266 globalHypixel2;
            (globalHypixel2 = this.GlobalHypixel2).lessSlow = false;
            final int[] b = Class139.b();
            final boolean func_70644_a = Minecraft.func_71410_x().field_71439_g.func_70644_a(Potion.field_76424_c);
            if (b == null) {
                if (func_70644_a) {
                    Minecraft.func_71410_x().field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c();
                }
            }
            globalHypixel2.less = 0.0;
            globalHypixel2.stage = 2;
            globalHypixel2.stage = 1;
            globalHypixel2.stage = 2;
            Class94.getTimer();
            final Class266 class266 = globalHypixel2;
            class266.lessSlow = class266.mc.field_71439_g.field_71071_by.field_70459_e;
        }
    }
    
    static {
        lIllllllIll();
        Class169.a(7270861405322491305L, 143587778765223145L, MethodHandles.lookup().lookupClass()).a(116345590173512L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Speed.lIIIIIlIll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Speed.lIIIIIlIll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(103647370430641L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[11];
        int n2 = 0;
        String s;
        int n3 = (s = Speed.lIIIIIlIll[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(Speed.lIIIIIlIll[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Speed.lIIIIIlIll[3]).length();
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
        d = new String[11];
        Speed.mode = new Value("Speed", "Mode", 5);
    }
    
    private static Exception a(final Exception ex) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x4182;
        if (Speed.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Speed.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Speed.lIIIIIlIll[5]);
                    array[1] = SecretKeyFactory.getInstance(Speed.lIIIIIlIll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Speed.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Speed.lIIIIIlIll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Speed.d[n3] = b(((Cipher)array[0]).doFinal(Speed.c[n3].getBytes(Speed.lIIIIIlIll[8])));
        }
        return Speed.d[n3];
    }
    
    private static void lIllllllIll() {
        (lIIIIIlIll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Speed.lIIIIIlIll[1] = "DES";
        Speed.lIIIIIlIll[2] = "áìH4ÓèzË\u0098{KI§(¹\u0088AÚ$û\u0098¬\u0010]k\u001fFo»²_b×lêøsE\u0013°\u0010_\"$Ñt\u0018%\u0092Wå\u0098²V~V58ï}\u0080[/\u0093N°|\u0092\u001d©AÁtÜH\u008c_ãÎë\u009bkõ½A¿\u001b¡H\u0019\u0087bM\u0086×\u00ady½\u0083!äá}ñ\u0083\u001eB¦ïfÀ\u0081\u0018J\u0010)´âb¬\u0019ïD÷\u0095\u001cZ³ULv\u0010ûó«ËÖA\u009c¼l\b\u008eGUF´b\u0010h\u000bíA\u008eôVà\u0014¤mÚ^¾rä\u0010\u009c\u0006$ßbyè#Lj\u009d\u0014FÙ\u0017Ü\u0010\b(<íûoÀì4P¤ÔWrGi\u0010\u0091\fÿb\u0097R×ÕÄ×\u0094þë'\u009aê";
        Speed.lIIIIIlIll[3] = "Õ*\tà-\bæMÑ\\ÏµRMÆÎ\u0010çLgñÝñ\\äâÆ?ºv\u008c$\u0080";
        Speed.lIIIIIlIll[4] = "ISO-8859-1";
        Speed.lIIIIIlIll[5] = "DES/CBC/PKCS5Padding";
        Speed.lIIIIIlIll[6] = "DES";
        Speed.lIIIIIlIll[7] = "你是滚神爸爸我叫你去当窝囊废啊复制机似的反复那几句没有意义的词语很有必要落魄的离开这个舞台吧因为只有你妈妈才能拯救你知道吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u2004\u200c\u200b";
        Speed.lIIIIIlIll[8] = "ISO-8859-1";
        Speed.lIIIIIlIll[9] = "你是滚神爸爸我叫你去当窝囊废啊复制机似的反复那几句没有意义的词语很有必要落魄的离开这个舞台吧因为只有你妈妈才能拯救你知道吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u2004\u200c\u200b";
        Speed.lIIIIIlIll[10] = " : ";
        Speed.lIIIIIlIll[11] = " : ";
    }
    
    private static String lIlllllIlIl(final String s, final String s2) {
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
    
    private static String lIllllllIII(String s, final String s2) {
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
    
    private static String lIllllllIIl(final String s, final String s2) {
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
