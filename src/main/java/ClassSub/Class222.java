package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.*;
import net.minecraft.potion.*;
import cn.Hanabi.modules.World.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class222
{
    private boolean shouldslow;
    private Minecraft mc;
    private boolean collided;
    private boolean lessSlow;
    private int stage;
    private int stageOG;
    private double moveSpeed;
    private double lastDist;
    private double less;
    private double stair;
    private double speed;
    private double speedvalue;
    private Class220 timer;
    private Class220 lastCheck;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIIIlllIIl;
    
    public Class222() {
        super();
        this.shouldslow = false;
        this.mc = Minecraft.func_71410_x();
        this.stage = 1;
        this.speed = 0.07999999821186066;
        this.timer = new Class220();
        this.lastCheck = new Class220();
    }
    
    private void onPullback$51d3ef3c() {
        this.stage = -4;
    }
    
    private void onStep$16e8f2e4() {
        final int[] b = Class139.b();
        final double n = this.mc.field_71439_g.func_174813_aQ().field_72338_b - this.mc.field_71439_g.field_70163_u;
        final int[] array = b;
        final double n2 = dcmpl(n, 0.7);
        if (array == null) {
            if (n2 > 0) {
                this.less = 0.0;
            }
            final double n3 = dcmpl(n, 0.5);
        }
        if (n2 == 0) {
            this.stair = 0.75;
        }
    }
    
    private void onUpdate$3d4b95ff() {
        Math.sqrt((this.mc.field_71439_g.field_70165_t - this.mc.field_71439_g.field_70169_q) * (this.mc.field_71439_g.field_70165_t - this.mc.field_71439_g.field_70169_q) + (this.mc.field_71439_g.field_70161_v - this.mc.field_71439_g.field_70166_s) * (this.mc.field_71439_g.field_70161_v - this.mc.field_71439_g.field_70166_s));
    }
    
    private double getHypixelSpeed(final int n) {
        double n2 = defaultSpeed() + 0.028 * this.getSpeedEffect() + this.getSpeedEffect() / 15.0;
        final double n3 = 0.4145 + this.getSpeedEffect() / 12.5;
        final double n4 = 0.4045 + this.getSpeedEffect() / 12.5;
        final int[] b = Class139.b();
        final double n5 = n / 500.0 * 3.0;
        final int[] array = b;
        int n6 = n;
        int n7 = n;
        int n8 = n;
        int n12 = 0;
        int shouldslow = 0;
        Label_0261: {
            Label_0257: {
                if (array == null) {
                    if (n == 0) {
                        boolean b3;
                        final boolean b2 = b3 = this.timer.isDelayComplete(300L);
                        if (array == null) {
                            if (b2) {
                                this.timer.lastMs = System.currentTimeMillis();
                            }
                            final boolean delayComplete;
                            b3 = (delayComplete = this.lastCheck.isDelayComplete(500L));
                        }
                        Label_0158: {
                            Class222 class223 = null;
                            Label_0154: {
                                if (array == null) {
                                    if (!b2) {
                                        Class222 class222 = this;
                                        if (array == null) {
                                            if (this.shouldslow) {
                                                break Label_0158;
                                            }
                                            class222 = this;
                                        }
                                        class222.shouldslow = true;
                                        if (array == null) {
                                            break Label_0158;
                                        }
                                    }
                                    class223 = this;
                                    if (array != null) {
                                        break Label_0154;
                                    }
                                    b3 = this.shouldslow;
                                }
                                if (!b3) {
                                    break Label_0158;
                                }
                                class223 = this;
                            }
                            class223.shouldslow = false;
                        }
                        n2 = 0.64 + (this.getSpeedEffect() + 0.028 * this.getSpeedEffect()) * 0.134;
                        if (array == null) {
                            break Label_0257;
                        }
                    }
                    n6 = n;
                    n7 = n;
                    n8 = n;
                }
                int n10;
                final int n9 = n10 = 1;
                if (array == null) {
                    if (n8 == n9) {
                        n2 = n3;
                        if (array == null) {
                            break Label_0257;
                        }
                    }
                    n6 = n;
                    n7 = n;
                    final int n11;
                    n10 = (n11 = 2);
                }
                if (array == null) {
                    if (n7 == n9) {
                        final float field_74278_d = Class94.getTimer().field_74278_d;
                        n2 = n4;
                        if (array == null) {
                            break Label_0257;
                        }
                    }
                    n12 = n;
                    shouldslow = n;
                    n6 = n;
                    if (array != null) {
                        break Label_0261;
                    }
                    n10 = 3;
                }
                if (n6 >= n10) {
                    final float field_74278_d2 = Class94.getTimer().field_74278_d;
                    n2 = n4 - n5;
                }
            }
            n12 = (shouldslow = (this.shouldslow ? 1 : 0));
        }
        final double n13;
        Label_0305: {
            if (array == null) {
                if (shouldslow == 0) {
                    final boolean b4 = (n12 = (this.lastCheck.isDelayComplete(500L) ? 1 : 0)) != 0;
                    if (array != null) {
                        break Label_0305;
                    }
                    if (b4) {
                        final boolean b5 = (n12 = (this.collided ? 1 : 0)) != 0;
                        if (array != null) {
                            break Label_0305;
                        }
                        if (!b5) {
                            return Math.max(n13, this.shouldslow ? n2 : (defaultSpeed() + 0.028 * this.getSpeedEffect()));
                        }
                    }
                }
                n13 = 0.2;
                if (array != null) {
                    return Math.max(n13, this.shouldslow ? n2 : (defaultSpeed() + 0.028 * this.getSpeedEffect()));
                }
                n2 = n13;
                n12 = n;
            }
        }
        if (n12 == 0) {
            n2 = 0.0;
        }
        return Math.max(n13, this.shouldslow ? n2 : (defaultSpeed() + 0.028 * this.getSpeedEffect()));
    }
    
    private void onMove(final EventMove eventMove) {
        final int[] b = Class139.b();
        double field_70123_F;
        final int n = (int)(field_70123_F = (this.mc.field_71439_g.field_70123_F ? 1 : 0));
        if (b == null) {
            if (n != 0) {
                this.collided = true;
            }
            final boolean collided;
            field_70123_F = ((collided = this.collided) ? 1 : 0);
        }
        Class222 class222 = null;
        Class222 class223 = null;
        Label_0080: {
            if (b == null) {
                if (n != 0) {
                    Class94.getTimer();
                    this.stage = -1;
                }
                class222 = this;
                class223 = this;
                if (b != null) {
                    break Label_0080;
                }
                field_70123_F = dcmpl(this.stair, 0.0);
            }
            if (field_70123_F > 0) {
                this.stair -= 0.25;
            }
            class222 = this;
            class223 = this;
        }
        final double less = class223.less;
        final double less2 = this.less;
        if (b == null && less2 <= 1.0) {}
        class222.less = less - less2;
        boolean b2;
        boolean state;
        float n8;
        int n7;
        int n6;
        int n5;
        int n4;
        int n3;
        final int n2 = n3 = (n4 = (n5 = (n6 = (n7 = (int)(n8 = ((state = (b2 = dcmpg(this.less, 0.0))) ? 1 : 0))))));
        final int n9;
        if (b == null) {
            if (n2 < 0) {
                this.less = 0.0;
            }
            n9 = (n6 = (n7 = (int)(n8 = ((state = (b2 = this.isInLiquid())) ? 1 : 0))));
        }
        final int n19;
        Label_0919: {
            if (b == null) {
                Label_0515: {
                    if (n2 == 0) {
                        final int[] b3 = Class139.b();
                        final int n10 = n3 = (n4 = (n5 = (n6 = (n7 = (int)(n8 = ((state = (b2 = this.mc.field_71441_e.func_72945_a((Entity)this.mc.field_71439_g, this.mc.field_71439_g.func_174813_aQ().func_72317_d(0.0, -0.01, 0.0)).isEmpty())) ? 1 : 0))))));
                        if (b3 == null) {
                            n6 = (n7 = (int)((n10 == 0) ? (n8 = ((state = (b2 = true)) ? 1 : 0)) : (n8 = ((state = (b2 = false)) ? 1 : 0))));
                        }
                        if (b != null) {
                            break Label_0919;
                        }
                        if (n10 != 0) {
                            final int[] b4 = Class139.b();
                            final int n11 = n3 = (n4 = (n5 = (n6 = (n7 = (int)(n8 = ((state = (b2 = fcmpl(this.mc.field_71439_g.field_70701_bs, 0.0f))) ? 1 : 0))))));
                            Label_0270: {
                                if (b4 == null) {
                                    if (n11 == 0) {
                                        final int n12 = n3 = (n4 = (n5 = (n6 = (n7 = (int)(n8 = ((state = (b2 = fcmpl(this.mc.field_71439_g.field_70702_br, 0.0f))) ? 1 : 0))))));
                                        if (b4 != null) {
                                            break Label_0270;
                                        }
                                        if (n12 == 0) {
                                            n6 = (n7 = (int)(n8 = ((state = (b2 = false)) ? 1 : 0)));
                                            break Label_0270;
                                        }
                                    }
                                    n6 = (n7 = (int)(n8 = ((state = (b2 = true)) ? 1 : 0)));
                                }
                            }
                            if (b != null) {
                                break Label_0919;
                            }
                            if (n11 != 0) {
                                this.collided = this.mc.field_71439_g.field_70123_F;
                                Class222 class224 = this;
                                if (b == null) {
                                    if (this.stage < 0) {
                                        final int n13 = n3 = (n4 = (n5 = (n6 = (n7 = (int)(n8 = ((state = (b2 = this.collided)) ? 1 : 0))))));
                                        if (b != null) {
                                            break Label_0919;
                                        }
                                        if (n13 == 0) {
                                            break Label_0515;
                                        }
                                    }
                                    class224 = this;
                                }
                                class224.stage = 0;
                                final double n14 = 0.4086666;
                                final int[] b5 = Class139.b();
                                int func_70644_a;
                                final boolean b6 = (func_70644_a = (this.mc.field_71439_g.func_70644_a(Potion.field_76430_j) ? 1 : 0)) != 0;
                                if (b5 == null) {
                                    func_70644_a = (b6 ? (this.mc.field_71439_g.func_70660_b(Potion.field_76430_j).func_76458_c() + 1) : 0);
                                }
                                final double n15 = n14 + func_70644_a * 0.1;
                                final double n16 = dcmpl(this.stair, 0.0);
                                Label_0485: {
                                    Class222 class225 = null;
                                    Label_0481: {
                                        if (b == null) {
                                            if (n16 == 0) {
                                                this.mc.field_71439_g.func_70664_aZ();
                                                final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
                                                final double n17 = n15;
                                                field_71439_g.field_70181_x = n17;
                                                eventMove.y = n17;
                                            }
                                            ++this.less;
                                            class225 = this;
                                            if (b != null) {
                                                break Label_0481;
                                            }
                                            final double n18 = dcmpl(this.less, 1.0);
                                        }
                                        if (n16 > 0) {
                                            class225 = this;
                                            if (b != null) {
                                                break Label_0481;
                                            }
                                            if (!this.lessSlow) {
                                                this.lessSlow = true;
                                                if (b == null) {
                                                    break Label_0485;
                                                }
                                            }
                                        }
                                        class225 = this;
                                    }
                                    class225.lessSlow = false;
                                }
                                n19 = (n4 = (n5 = (n6 = (n7 = (int)(n8 = ((state = (b2 = dcmpl(this.less, 1.12))) ? 1 : 0))))));
                                if (b != null) {
                                    break Label_0919;
                                }
                                if (n19 > 0) {
                                    this.less = 1.12;
                                }
                            }
                        }
                    }
                }
                final int stage = this.stage;
                double n20 = defaultSpeed() + 0.028 * this.getSpeedEffect() + this.getSpeedEffect() / 15.0;
                final double n21 = 0.4145 + this.getSpeedEffect() / 12.5;
                final double n22 = 0.4045 + this.getSpeedEffect() / 12.5;
                final int[] b7 = Class139.b();
                final double n23 = stage / 500.0 * 3.0;
                final int[] array = b7;
                int n26;
                int n25;
                final int n24 = n25 = (n26 = stage);
                int n31 = 0;
                int shouldslow = 0;
                Label_0808: {
                    Label_0804: {
                        if (array == null) {
                            if (n24 == 0) {
                                boolean b9;
                                final boolean b8 = b9 = this.timer.isDelayComplete(300L);
                                if (array == null) {
                                    if (b8) {
                                        this.timer.lastMs = System.currentTimeMillis();
                                    }
                                    final boolean delayComplete;
                                    b9 = (delayComplete = this.lastCheck.isDelayComplete(500L));
                                }
                                Label_0692: {
                                    Class222 class227 = null;
                                    Label_0688: {
                                        if (array == null) {
                                            if (!b8) {
                                                Class222 class226 = this;
                                                if (array == null) {
                                                    if (this.shouldslow) {
                                                        break Label_0692;
                                                    }
                                                    class226 = this;
                                                }
                                                class226.shouldslow = true;
                                                if (array == null) {
                                                    break Label_0692;
                                                }
                                            }
                                            class227 = this;
                                            if (array != null) {
                                                break Label_0688;
                                            }
                                            b9 = this.shouldslow;
                                        }
                                        if (!b9) {
                                            break Label_0692;
                                        }
                                        class227 = this;
                                    }
                                    class227.shouldslow = false;
                                }
                                n20 = 0.64 + (this.getSpeedEffect() + 0.028 * this.getSpeedEffect()) * 0.134;
                                if (array == null) {
                                    break Label_0804;
                                }
                            }
                            final int n27;
                            n25 = (n27 = (n26 = stage));
                        }
                        int n29;
                        final int n28 = n29 = 1;
                        if (array == null) {
                            if (n24 == n28) {
                                n20 = n21;
                                if (array == null) {
                                    break Label_0804;
                                }
                            }
                            n26 = (n25 = stage);
                            final int n30;
                            n29 = (n30 = 2);
                        }
                        if (array == null) {
                            if (n25 == n28) {
                                final float field_74278_d = Class94.getTimer().field_74278_d;
                                n20 = n22;
                                if (array == null) {
                                    break Label_0804;
                                }
                            }
                            shouldslow = (n26 = (n31 = stage));
                            if (array != null) {
                                break Label_0808;
                            }
                            n29 = 3;
                        }
                        if (n26 >= n29) {
                            final float field_74278_d2 = Class94.getTimer().field_74278_d;
                            n20 = n22 - n23;
                        }
                    }
                    n31 = (shouldslow = (this.shouldslow ? 1 : 0));
                }
                final double n32;
                Label_0864: {
                    Label_0858: {
                        if (array == null) {
                            if (shouldslow == 0) {
                                final boolean b10 = (n31 = (this.lastCheck.isDelayComplete(500L) ? 1 : 0)) != 0;
                                if (array != null) {
                                    break Label_0858;
                                }
                                if (b10) {
                                    final boolean b11 = (n31 = (this.collided ? 1 : 0)) != 0;
                                    if (array != null) {
                                        break Label_0858;
                                    }
                                    if (!b11) {
                                        break Label_0864;
                                    }
                                }
                            }
                            n32 = 0.2;
                            if (array != null) {
                                break Label_0864;
                            }
                            n20 = n32;
                            n31 = stage;
                        }
                    }
                    if (n31 == 0) {
                        n20 = 0.0;
                    }
                }
                this.speed = Math.max(n32, this.shouldslow ? n20 : (defaultSpeed() + 0.028 * this.getSpeedEffect())) + 0.0331;
                this.speed *= 0.91;
                n6 = (n7 = (int)(n8 = ((state = (b2 = dcmpl(this.stair, 0.0))) ? 1 : 0)));
            }
        }
        if (b == null) {
            if (n19 > 0) {
                this.speed *= 0.7 - this.getSpeedEffect() * 0.1;
            }
            n6 = (n7 = (int)(n8 = ((state = (b2 = (this.stage != 0))) ? 1 : 0)));
        }
        if (b == null) {
            if (n9 < 0) {
                this.speed = defaultSpeed();
            }
            n6 = (n5 = (n7 = (int)(n8 = ((state = (b2 = this.lessSlow)) ? 1 : 0))));
        }
        if (b == null) {
            if (n9 != 0) {
                this.speed *= 0.96;
            }
            n7 = (n6 = (int)(n8 = ((state = (b2 = this.lessSlow)) ? 1 : 0)));
        }
        if (b == null) {
            if (n6 != 0) {
                this.speed *= 0.95;
            }
            n8 = (n7 = ((state = (b2 = this.isInLiquid())) ? 1 : 0));
        }
        if (b == null) {
            if (n7 != 0) {
                this.speed = 0.12;
            }
            state = ((n8 = ((b2 = fcmpl(this.mc.field_71439_g.field_70701_bs, 0.0f)) ? 1 : 0)) != 0.0f);
        }
        Label_1092: {
            if (b == null) {
                if (n8 == 0) {
                    final boolean b12 = state = (b2 = fcmpl(this.mc.field_71439_g.field_70702_br, 0.0f));
                    if (b != null) {
                        break Label_1092;
                    }
                    if (!b12) {
                        return;
                    }
                }
                b2 = (state = Class4.getModule("Scaffold").state);
            }
        }
        Label_1478: {
            Label_1110: {
                if (b == null) {
                    if (!state) {
                        break Label_1110;
                    }
                    b2 = Scaffold.mode.isCurrentMode("HypixelGlobal");
                }
                if (b2) {
                    break Label_1478;
                }
            }
            final double speed = this.speed;
            final int[] b13 = Class139.b();
            double n33 = this.mc.field_71439_g.field_71158_b.field_78900_b;
            final int[] array2 = b13;
            double n34 = this.mc.field_71439_g.field_71158_b.field_78902_a;
            float field_70177_z = this.mc.field_71439_g.field_70177_z;
            double n39;
            double n38;
            int n37;
            final double n36;
            final int n35 = (int)(n36 = (n37 = (int)(n38 = (n39 = dcmpl(n33, 0.0)))));
            final double n40;
            final double n41;
            Label_1210: {
                if (array2 == null) {
                    if (n35 == 0) {
                        n40 = (n37 = (int)(n38 = (n39 = dcmpl(n34, 0.0))));
                        if (array2 != null) {
                            break Label_1210;
                        }
                        if (n40 == 0) {
                            eventMove.x = 0.0;
                            eventMove.z = 0.0;
                            if (array2 == null) {
                                break Label_1478;
                            }
                        }
                    }
                    n41 = (n39 = dcmpl(n33, 0.0));
                }
            }
            Label_1372: {
                if (array2 == null) {
                    if (n35 == 0) {
                        break Label_1372;
                    }
                    n39 = dcmpl(n34, 0.0);
                }
                Label_1326: {
                    Label_1319: {
                        if (array2 == null) {
                            if (n40 > 0) {
                                final float n42 = field_70177_z;
                                final double n43 = dcmpl(n33, 0.0);
                                if (array2 == null && n43 <= 0) {}
                                field_70177_z = n42 + (float)n43;
                                if (array2 == null) {
                                    break Label_1319;
                                }
                            }
                            n39 = dcmpg(n34, 0.0);
                        }
                        if (array2 != null) {
                            break Label_1326;
                        }
                        if (n41 < 0) {
                            final float n44 = field_70177_z;
                            final double n45 = dcmpl(n33, 0.0);
                            if (array2 == null && n45 <= 0) {}
                            field_70177_z = n44 + (float)n45;
                        }
                    }
                    n34 = 0.0;
                    n39 = (n38 = dcmpl(n33, 0.0));
                }
                final double n46;
                Label_1370: {
                    if (array2 == null) {
                        if (n41 > 0) {
                            n33 = 1.0;
                            if (array2 == null) {
                                break Label_1372;
                            }
                        }
                        n46 = n33;
                        if (array2 != null) {
                            break Label_1370;
                        }
                        n39 = dcmpg(n46, 0.0);
                    }
                    if (n39 >= 0) {
                        break Label_1372;
                    }
                }
                n33 = n46;
            }
            final EntityPlayerSP field_71439_g2 = this.mc.field_71439_g;
            final double n47 = n33 * speed * Math.cos(Math.toRadians(field_70177_z + 88.0)) + n34 * speed * Math.sin(Math.toRadians(field_70177_z + 87.9000015258789));
            field_71439_g2.field_70159_w = n47;
            eventMove.x = n47;
            final EntityPlayerSP field_71439_g3 = this.mc.field_71439_g;
            final double n48 = n33 * speed * Math.sin(Math.toRadians(field_70177_z + 88.0)) - n34 * speed * Math.cos(Math.toRadians(field_70177_z + 87.9000015258789));
            field_71439_g3.field_70179_y = n48;
            eventMove.z = n48;
        }
        ++this.stage;
    }
    
    private void setMotion(final EventMove eventMove, final double n) {
        final int[] b = Class139.b();
        double n2 = this.mc.field_71439_g.field_71158_b.field_78900_b;
        final int[] array = b;
        double n3 = this.mc.field_71439_g.field_71158_b.field_78902_a;
        float field_70177_z = this.mc.field_71439_g.field_70177_z;
        double n8;
        double n7;
        int n6;
        final double n5;
        final int n4 = (int)(n5 = (n6 = (int)(n7 = (n8 = dcmpl(n2, 0.0)))));
        final double n9;
        final double n10;
        Label_0092: {
            if (array == null) {
                if (n4 == 0) {
                    n9 = (n6 = (int)(n7 = (n8 = dcmpl(n3, 0.0))));
                    if (array != null) {
                        break Label_0092;
                    }
                    if (n9 == 0) {
                        eventMove.x = 0.0;
                        eventMove.z = 0.0;
                        if (array == null) {
                            return;
                        }
                    }
                }
                n10 = (n8 = dcmpl(n2, 0.0));
            }
        }
        Label_0267: {
            if (array == null) {
                if (n4 == 0) {
                    break Label_0267;
                }
                n8 = dcmpl(n3, 0.0);
            }
            Label_0218: {
                Label_0211: {
                    if (array == null) {
                        if (n9 > 0) {
                            final float n11 = field_70177_z;
                            final double n12 = dcmpl(n2, 0.0);
                            if (array == null && n12 <= 0) {}
                            field_70177_z = n11 + (float)n12;
                            if (array == null) {
                                break Label_0211;
                            }
                        }
                        n8 = dcmpg(n3, 0.0);
                    }
                    if (array != null) {
                        break Label_0218;
                    }
                    if (n10 < 0) {
                        final float n13 = field_70177_z;
                        final double n14 = dcmpl(n2, 0.0);
                        if (array == null && n14 <= 0) {}
                        field_70177_z = n13 + (float)n14;
                    }
                }
                n3 = 0.0;
                n8 = (n7 = dcmpl(n2, 0.0));
            }
            final double n15;
            Label_0265: {
                if (array == null) {
                    if (n10 > 0) {
                        n2 = 1.0;
                        if (array == null) {
                            break Label_0267;
                        }
                    }
                    n15 = n2;
                    if (array != null) {
                        break Label_0265;
                    }
                    n8 = dcmpg(n15, 0.0);
                }
                if (n8 >= 0) {
                    break Label_0267;
                }
            }
            n2 = n15;
        }
        final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
        final double n16 = n2 * n * Math.cos(Math.toRadians(field_70177_z + 88.0)) + n3 * n * Math.sin(Math.toRadians(field_70177_z + 87.9000015258789));
        field_71439_g.field_70159_w = n16;
        eventMove.x = n16;
        final EntityPlayerSP field_71439_g2 = this.mc.field_71439_g;
        final double n17 = n2 * n * Math.sin(Math.toRadians(field_70177_z + 88.0)) - n3 * n * Math.cos(Math.toRadians(field_70177_z + 87.9000015258789));
        field_71439_g2.field_70179_y = n17;
        eventMove.z = n17;
    }
    
    private boolean isMoving2() {
        final int[] b = Class139.b();
        final float n = fcmpl(this.mc.field_71439_g.field_70701_bs, 0.0f);
        if (b == null) {
            if (n == 0) {
                final float n2 = fcmpl(this.mc.field_71439_g.field_70702_br, 0.0f);
                if (b == null) {
                    if (n2 == 0) {
                        return false;
                    }
                }
            }
        }
        return n != 0.0f;
    }
    
    private boolean isOnGround$13336d() {
        final int[] b = Class139.b();
        final boolean empty = this.mc.field_71441_e.func_72945_a((Entity)this.mc.field_71439_g, this.mc.field_71439_g.func_174813_aQ().func_72317_d(0.0, -0.01, 0.0)).isEmpty();
        return (b == null && !empty) || empty;
    }
    
    private int getJumpEffect() {
        final int[] b = Class139.b();
        final boolean func_70644_a = this.mc.field_71439_g.func_70644_a(Potion.field_76430_j);
        if (b == null && func_70644_a) {
            return this.mc.field_71439_g.func_70660_b(Potion.field_76430_j).func_76458_c() + 1;
        }
        return func_70644_a ? 1 : 0;
    }
    
    private int getSpeedEffect() {
        final int[] b = Class139.b();
        final boolean func_70644_a = this.mc.field_71439_g.func_70644_a(Potion.field_76424_c);
        if (b == null && func_70644_a) {
            return this.mc.field_71439_g.func_70660_b(Potion.field_76424_c).func_76458_c() + 1;
        }
        return func_70644_a ? 1 : 0;
    }
    
    private boolean isInLiquid() {
        final int[] b = Class139.b();
        final boolean func_70090_H = this.mc.field_71439_g.func_70090_H();
        if (b == null && func_70090_H) {
            return true;
        }
        boolean b2 = func_70090_H;
        final int n = (int)this.mc.field_71439_g.func_174813_aQ().field_72338_b;
        int i = MathHelper.func_76128_c(this.mc.field_71439_g.func_174813_aQ().field_72340_a);
    Label_0217_Outer:
        while (i < MathHelper.func_76128_c(this.mc.field_71439_g.func_174813_aQ().field_72336_d) + 1) {
            final int func_76128_c;
            final int n2 = func_76128_c = MathHelper.func_76128_c(this.mc.field_71439_g.func_174813_aQ().field_72339_c);
            if (b == null) {
                int j = n2;
                while (true) {
                    while (j < MathHelper.func_76128_c(this.mc.field_71439_g.func_174813_aQ().field_72334_f) + 1) {
                        final Block func_177230_c = this.mc.field_71441_e.func_180495_p(new BlockPos(i, n, j)).func_177230_c();
                        if (b == null) {
                            if (b == null) {
                                if (func_177230_c != null) {
                                    final Block block = func_177230_c;
                                    if (b != null || block.func_149688_o() != Material.field_151579_a) {
                                        final boolean b3 = block instanceof BlockLiquid;
                                        if (b == null && !b3) {
                                            return false;
                                        }
                                        b2 = b3;
                                    }
                                }
                                ++j;
                            }
                            if (b != null) {
                                break;
                            }
                            continue Label_0217_Outer;
                        }
                        else {
                            if (b != null) {
                                break Label_0217_Outer;
                            }
                            continue Label_0217_Outer;
                        }
                    }
                    ++i;
                    continue;
                }
            }
            return func_76128_c != 0;
        }
        int func_76128_c = b2 ? 1 : 0;
        return func_76128_c != 0;
    }
    
    private void onEnable() {
        this.lessSlow = false;
        defaultSpeed();
        this.less = 0.0;
        this.stage = 2;
        this.stage = 1;
        this.stage = 2;
        Class94.getTimer();
        this.lessSlow = this.mc.field_71439_g.field_71071_by.field_70459_e;
    }
    
    private static double defaultSpeed() {
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
    
    private static void onDisable() {
        Class94.getTimer();
    }
    
    static {
        llIIIIlIlIlI();
        Class169.a(7220640917413238890L, 3877540079910663956L, MethodHandles.lookup().lookupClass()).a(161141128035306L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class222.lIIIIlllIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class222.lIIIIlllIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(133879647626222L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class222.lIIIIlllIIl[2]).length();
        int char1 = 24;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class222.lIIIIlllIIl[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
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
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x239D;
        if (Class222.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class222.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class222.lIIIIlllIIl[4]);
                    array[1] = SecretKeyFactory.getInstance(Class222.lIIIIlllIIl[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class222.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class222.lIIIIlllIIl[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class222.c[n3] = a(((Cipher)array[0]).doFinal(Class222.b[n3].getBytes(Class222.lIIIIlllIIl[7])));
        }
        return Class222.c[n3];
    }
    
    private static Object a$dd29b59(final MutableCallSite mutableCallSite, final Object[] array) {
        final String a = a((int)array[0], (long)array[1]);
        mutableCallSite.setTarget(MethodHandles.dropArguments(MethodHandles.constant(String.class, a), 0, Integer.TYPE, Long.TYPE));
        return a;
    }
    
    private static CallSite a(final MethodHandles.Lookup p0, final String p1, final MethodType p2) {
        // 
        // This method could not be decompiled.
        // 
        // Could not show original bytecode, likely due to the same error.
        // 
        // The error that occurred was:
        // 
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class222.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
        //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:65)
        //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
        //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
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
        // Caused by: java.lang.ClassCastException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void llIIIIlIlIlI() {
        (lIIIIlllIIl = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class222.lIIIIlllIIl[1] = "DES";
        Class222.lIIIIlllIIl[2] = "\u000e\nîV\u0005\u007f'\u00194³\u008a[\u00843³¯^\u00961Eªóÿ$\u0018FÌ®õ*\u000bðÜL\u0082\u000bÎç\u009aë¯òx±ÝE4`ù";
        Class222.lIIIIlllIIl[3] = "ISO-8859-1";
        Class222.lIIIIlllIIl[4] = "DES/CBC/PKCS5Padding";
        Class222.lIIIIlllIIl[5] = "DES";
        Class222.lIIIIlllIIl[6] = "你是不是跟我说一句话要经过大脑半天的思考才敢发出来难道你所谓的速度就是错字连篇词不达意是不是然后你绝处逢生可以脱离我的攻击了好吗你这样的废材早可以滚出网完全没必要虚张声势自以为聪明的造谣你早已成仙的神爹你还要继续发扬你那厚颜无耻的精神吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u2006 \u2009";
        Class222.lIIIIlllIIl[7] = "ISO-8859-1";
        Class222.lIIIIlllIIl[8] = "你是不是跟我说一句话要经过大脑半天的思考才敢发出来难道你所谓的速度就是错字连篇词不达意是不是然后你绝处逢生可以脱离我的攻击了好吗你这样的废材早可以滚出网完全没必要虚张声势自以为聪明的造谣你早已成仙的神爹你还要继续发扬你那厚颜无耻的精神吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u2006 \u2009";
        Class222.lIIIIlllIIl[9] = " : ";
        Class222.lIIIIlllIIl[10] = " : ";
    }
    
    private static String llIIIIlIIlII(String s, final String s2) {
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
    
    private static String llIIIIlIIlIl(final String s, final String s2) {
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
    
    private static String llIIIIlIlIIl(final String s, final String s2) {
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
    
    private static boolean llIIIIllllll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean llIIIlIIlIll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean llIIIlIIIIll(final int n) {
        return n < 0;
    }
    
    private static boolean llIIIIlllIIl(final int n) {
        return n > 0;
    }
    
    private static int llIIIIllIlll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int llIIIIlllIll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int llIIIlIIIIlI$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int llIIIlIIIIII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int llIIIlIIIIIl$25399e8(final double n) {
        return dcmpg(n, 0.0);
    }
    
    private static int llIIIlIIIllI$25399e8(final double n) {
        return dcmpl(n, 0.0);
    }
    
    private static int llIIIlIIIlll$25399e8(final double n) {
        return dcmpg(n, 0.0);
    }
    
    private static int llIIIlIIlIII$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
}
