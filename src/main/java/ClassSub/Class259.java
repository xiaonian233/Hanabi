package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.events.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.entity.*;
import net.minecraft.util.*;
import net.minecraft.block.material.*;
import net.minecraft.block.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class259
{
    public Minecraft mc;
    public Class220 lastFall;
    public int stage;
    public int aacCount;
    public double speed;
    private static final long a;
    private static final String b;
    private static final String[] llllIl;
    
    public Class259() {
        super();
        this.mc = Minecraft.func_71410_x();
        this.lastFall = new Class220();
        this.stage = 0;
    }
    
    private void onMove(final EventMove eventMove) {
        final int[] b = Class139.b();
        float n4;
        int n3;
        int n2;
        final int n = n2 = (n3 = (int)(n4 = (Class4.getModule("Scaffold").state ? 1 : 0)));
        if (b == null) {
            if (n != 0) {
                final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
                if (b == null) {
                    if (!field_71439_g.field_70122_E) {
                        return;
                    }
                    final EntityPlayerSP field_71439_g2 = this.mc.field_71439_g;
                }
                field_71439_g.func_70664_aZ();
                eventMove.y = this.mc.field_71439_g.field_70181_x;
                return;
            }
            final int n5;
            n2 = (n5 = (n3 = (int)(n4 = dcmpl((double)this.mc.field_71439_g.field_70143_R, 1.2))));
        }
        if (b == null) {
            if (n > 0) {
                this.lastFall.lastMs = System.currentTimeMillis();
            }
            n3 = (n2 = (int)(n4 = (this.isInLiquid() ? 1 : 0)));
        }
        Label_1410: {
            if (b == null) {
                Label_0241: {
                    if (n2 == 0) {
                        final int n6 = n3 = (int)(n4 = (this.mc.field_71439_g.field_70124_G ? 1 : 0));
                        if (b != null) {
                            break Label_1410;
                        }
                        if (n6 != 0) {
                            final int n7 = n3 = (int)(n4 = (Class33.isOnGround(0.01) ? 1 : 0));
                            if (b != null) {
                                break Label_1410;
                            }
                            if (n7 != 0) {
                                final float n8 = n3 = (int)(n4 = fcmpl(this.mc.field_71439_g.field_70701_bs, 0.0f));
                                if (b == null) {
                                    if (n8 == 0) {
                                        final float n9 = n3 = (int)(n4 = fcmpl(this.mc.field_71439_g.field_70702_br, 0.0f));
                                        if (b != null) {
                                            break Label_1410;
                                        }
                                        if (n9 == 0) {
                                            break Label_0241;
                                        }
                                    }
                                    this.stage = 0;
                                    this.mc.field_71439_g.func_70664_aZ();
                                    final EntityPlayerSP field_71439_g3 = this.mc.field_71439_g;
                                    final double n10 = 0.41999998688698 + Class33.getJumpEffect();
                                    field_71439_g3.field_70181_x = n10;
                                    eventMove.y = n10;
                                    final int n11;
                                    n3 = (n11 = (int)(n4 = this.aacCount));
                                }
                                if (b != null) {
                                    break Label_1410;
                                }
                                if (n8 < 4) {
                                    ++this.aacCount;
                                }
                            }
                        }
                    }
                }
                final int stage = this.stage;
                final int aacCount = this.aacCount;
                final int n12 = stage;
                final int[] b2 = Class139.b();
                double speed = 0.29;
                final int[] array = b2;
                final double n13 = 0.0286 - n12 / 1000.0;
                int n27;
                int n26;
                int n25;
                int n24;
                int n23;
                int n22;
                int n21;
                int n20;
                int n19;
                int n18;
                int n17;
                int n16;
                int n15;
                final int n14 = n15 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = n12))))))))))));
                float field_70123_F = 0.0f;
                int n47 = 0;
                Label_1338: {
                    Label_1326: {
                        if (array == null) {
                            if (n14 == 0) {
                                speed = 0.497;
                                final int n28 = aacCount;
                                final int n29 = 2;
                                if (array == null && lIIIIIII(n28, n29)) {
                                    speed = 0.6039;
                                    goto Label_0314;
                                }
                                if (lIIIIIII(n28, n29)) {
                                    speed += 0.046;
                                }
                                final Block blockUnderPlayer$345a1aee;
                                final boolean b3 = (blockUnderPlayer$345a1aee = Class33.getBlockUnderPlayer$345a1aee((EntityPlayer)this.mc.field_71439_g)) instanceof BlockIce;
                                Label_0369: {
                                    Label_0364: {
                                        if (array == null) {
                                            if (b3) {
                                                break Label_0364;
                                            }
                                            final boolean b4 = blockUnderPlayer$345a1aee instanceof BlockPackedIce;
                                        }
                                        if (!b3) {
                                            break Label_0369;
                                        }
                                    }
                                    speed = 0.59;
                                }
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            final int n30;
                            n15 = (n30 = (n16 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = n12)))))))))))));
                        }
                        int n44;
                        int n43;
                        int n42;
                        int n41;
                        int n40;
                        int n39;
                        int n38;
                        int n37;
                        int n36;
                        int n35;
                        int n34;
                        int n33;
                        int n32;
                        final int n31 = n32 = (n33 = (n34 = (n35 = (n36 = (n37 = (n38 = (n39 = (n40 = (n41 = (n42 = (n43 = (n44 = 1))))))))))));
                        if (array == null) {
                            if (n14 == n31) {
                                speed = 0.3031;
                                final int n45 = aacCount;
                                final int n46 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n45, n46)) {
                                        speed = 0.36729999999999996;
                                    }
                                    final int n48;
                                    n47 = (n48 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n45, n46)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n16 = (n15 = (n17 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = n12))))))))))));
                            n33 = (n32 = (n34 = (n35 = (n36 = (n37 = (n38 = (n39 = (n40 = (n41 = (n42 = (n43 = (n44 = 2))))))))))));
                        }
                        if (array == null) {
                            if (n15 == n32) {
                                speed = 0.302;
                                final int n49 = aacCount;
                                final int n50 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n49, n50)) {
                                        speed = 0.3649;
                                    }
                                    final int n51;
                                    n47 = (n51 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n49, n50)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n17 = (n16 = (n18 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = n12)))))))))));
                            n34 = (n33 = (n35 = (n36 = (n37 = (n38 = (n39 = (n40 = (n41 = (n42 = (n43 = (n44 = 3)))))))))));
                        }
                        if (array == null) {
                            if (n16 == n33) {
                                speed = 0.3019;
                                final int n52 = aacCount;
                                final int n53 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n52, n53)) {
                                        speed = 0.3626;
                                    }
                                    final int n54;
                                    n47 = (n54 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n52, n53)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n18 = (n17 = (n19 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = n12))))))))));
                            n35 = (n34 = (n36 = (n37 = (n38 = (n39 = (n40 = (n41 = (n42 = (n43 = (n44 = 4))))))))));
                        }
                        if (array == null) {
                            if (n17 == n34) {
                                speed = 0.3019;
                                final int n55 = aacCount;
                                final int n56 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n55, n56)) {
                                        speed = 0.3603;
                                    }
                                    final int n57;
                                    n47 = (n57 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n55, n56)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n19 = (n18 = (n20 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = n12)))))))));
                            n36 = (n35 = (n37 = (n38 = (n39 = (n40 = (n41 = (n42 = (n43 = (n44 = 5)))))))));
                        }
                        if (array == null) {
                            if (n18 == n35) {
                                speed = 0.3019;
                                final int n58 = aacCount;
                                final int n59 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n58, n59)) {
                                        speed = 0.358;
                                    }
                                    final int n60;
                                    n47 = (n60 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n58, n59)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n20 = (n19 = (n21 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = n12))))))));
                            n37 = (n36 = (n38 = (n39 = (n40 = (n41 = (n42 = (n43 = (n44 = 6))))))));
                        }
                        if (array == null) {
                            if (n19 == n36) {
                                speed = 0.3019;
                                final int n61 = aacCount;
                                final int n62 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n61, n62)) {
                                        speed = 0.3558;
                                    }
                                    final int n63;
                                    n47 = (n63 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n61, n62)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n21 = (n20 = (n22 = (n23 = (n24 = (n25 = (n26 = (n27 = n12)))))));
                            n38 = (n37 = (n39 = (n40 = (n41 = (n42 = (n43 = (n44 = 7)))))));
                        }
                        if (array == null) {
                            if (n20 == n37) {
                                speed = 0.3019;
                                final int n64 = aacCount;
                                final int n65 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n64, n65)) {
                                        speed = 0.3536;
                                    }
                                    final int n66;
                                    n47 = (n66 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n64, n65)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n22 = (n21 = (n23 = (n24 = (n25 = (n26 = (n27 = n12))))));
                            n39 = (n38 = (n40 = (n41 = (n42 = (n43 = (n44 = 8))))));
                        }
                        if (array == null) {
                            if (n21 == n38) {
                                speed = 0.3019;
                                int onGround;
                                final int n67 = onGround = (Class33.isOnGround(0.05) ? 1 : 0);
                                if (array == null) {
                                    if (n67 != 0) {
                                        speed = 0.2999;
                                    }
                                    final int n68;
                                    onGround = (n68 = aacCount);
                                }
                                final int n69 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n67, n69)) {
                                        speed += 0.0496;
                                    }
                                    n47 = (onGround = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(onGround, n69)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n23 = (n22 = (n24 = (n25 = (n26 = (n27 = n12)))));
                            n40 = (n39 = (n41 = (n42 = (n43 = (n44 = 9)))));
                        }
                        if (array == null) {
                            if (n22 == n39) {
                                speed = 0.3019;
                                final int n70 = aacCount;
                                final int n71 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n70, n71)) {
                                        speed = 0.3494;
                                    }
                                    final int n72;
                                    n47 = (n72 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n70, n71)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n24 = (n23 = (n25 = (n26 = (n27 = n12))));
                            n41 = (n40 = (n42 = (n43 = (n44 = 10))));
                        }
                        if (array == null) {
                            if (n23 == n40) {
                                speed = 0.3019;
                                final int n73 = aacCount;
                                final int n74 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n73, n74)) {
                                        speed = 0.3474;
                                    }
                                    final int n75;
                                    n47 = (n75 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n73, n74)) {
                                    break Label_1326;
                                }
                                speed += n13;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n25 = (n24 = (n26 = (n27 = n12)));
                            n42 = (n41 = (n43 = (n44 = 11)));
                        }
                        if (array == null) {
                            if (n24 == n41) {
                                speed = 0.3;
                                final int n76 = aacCount;
                                final int n77 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n76, n77)) {
                                        speed = 0.345;
                                    }
                                    final int n78;
                                    n47 = (n78 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n76, n77)) {
                                    break Label_1326;
                                }
                                speed += 0.018;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n26 = (n25 = (n27 = n12));
                            n43 = (n42 = (n44 = 12));
                        }
                        if (array == null) {
                            if (n25 == n42) {
                                speed = 0.301;
                                int n80;
                                final int n79 = n80 = aacCount;
                                int n82;
                                int n81 = n82 = 2;
                                if (array == null) {
                                    if (n79 <= 2) {
                                        this.aacCount = 0;
                                    }
                                    final int n83;
                                    n80 = (n83 = aacCount);
                                    n81 = (n82 = 2);
                                }
                                if (array == null) {
                                    if (lIIIIIII(n79, n82)) {
                                        speed = 0.34299999999999997;
                                    }
                                    n47 = (n80 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                    n81 = 3;
                                }
                                if (!lIIIIIII(n80, n81)) {
                                    break Label_1326;
                                }
                                speed += n13 + 0.001;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n27 = (n26 = n12);
                            n44 = (n43 = 13);
                        }
                        if (array == null) {
                            if (n26 == n43) {
                                speed = 0.298;
                                final int n84 = aacCount;
                                final int n85 = 2;
                                if (array == null) {
                                    if (lIIIIIII(n84, n85)) {
                                        speed = 0.33999999999999997;
                                    }
                                    final int n86;
                                    n47 = (n86 = (int)(field_70123_F = aacCount));
                                    if (array != null) {
                                        break Label_1338;
                                    }
                                }
                                if (!lIIIIIII(n84, n85)) {
                                    break Label_1326;
                                }
                                speed += n13 + 0.001;
                                if (array == null) {
                                    break Label_1326;
                                }
                            }
                            n47 = (n27 = (int)(field_70123_F = n12));
                            if (array != null) {
                                break Label_1338;
                            }
                            n44 = 14;
                        }
                        if (n27 == n44) {
                            speed = 0.297;
                            final int n87 = aacCount;
                            final int n88 = 2;
                            if (array == null) {
                                if (lIIIIIII(n87, n88)) {
                                    speed = 0.33899999999999997;
                                }
                                final int n89;
                                n47 = (n89 = (int)(field_70123_F = aacCount));
                                if (array != null) {
                                    break Label_1338;
                                }
                            }
                            if (lIIIIIII(n87, n88)) {
                                speed += n13 + 0.001;
                            }
                        }
                    }
                    field_70123_F = (n47 = fcmpg(this.mc.field_71439_g.field_70701_bs, 0.0f));
                }
                Label_1393: {
                    Class259 class259 = null;
                    Label_1389: {
                        if (array == null) {
                            if (n47 <= 0) {
                                speed -= 0.06;
                            }
                            class259 = this;
                            if (array != null) {
                                break Label_1389;
                            }
                            field_70123_F = (this.mc.field_71439_g.field_70123_F ? 1 : 0);
                        }
                        if (field_70123_F == 0) {
                            break Label_1393;
                        }
                        speed -= 0.1;
                        class259 = this;
                    }
                    class259.aacCount = 0;
                }
                this.speed = speed;
                n4 = (n3 = fcmpl(this.mc.field_71439_g.field_70701_bs, 0.0f));
            }
        }
        Class259 class261 = null;
        Class259 class262 = null;
        Label_1513: {
            final float n90;
            Label_1490: {
                Label_1474: {
                    Class259 class260 = null;
                    Label_1455: {
                        if (b == null) {
                            if (n3 == 0) {
                                n90 = fcmpl(this.mc.field_71439_g.field_70702_br, 0.0f);
                                if (b != null) {
                                    break Label_1490;
                                }
                                if (n90 == 0) {
                                    break Label_1474;
                                }
                            }
                            class260 = this;
                            if (b != null) {
                                break Label_1455;
                            }
                            n4 = (this.isInLiquid() ? 1 : 0);
                        }
                        if (n4 != 0) {
                            this.speed = 0.075;
                        }
                        class260 = this;
                    }
                    ((IEntityPlayerSP)class260.mc.field_71439_g).setMoveSpeed(eventMove, this.speed);
                }
                class261 = this;
                class262 = this;
                if (b != null) {
                    break Label_1513;
                }
                final float n91 = fcmpl(this.mc.field_71439_g.field_70701_bs, 0.0f);
            }
            if (n90 == 0) {
                class261 = this;
                class262 = this;
                if (b != null) {
                    break Label_1513;
                }
                if (this.mc.field_71439_g.field_70702_br == 0.0f) {
                    return;
                }
            }
            class261 = this;
            class262 = this;
        }
        class261.stage = class262.stage + 1;
    }
    
    private void onDisable() {
        this.aacCount = 0;
    }
    
    public final boolean isInLiquid() {
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
    
    private double getAACSpeed(final int n, final int n2) {
        final int[] b = Class139.b();
        double n3 = 0.29;
        final int[] array = b;
        final double n4 = 0.0286 - n / 1000.0;
        int n5 = n;
        int n6 = n;
        int n7 = n;
        int n8 = n;
        int n9 = n;
        int n10 = n;
        int n11 = n;
        int n12 = n;
        int n13 = n;
        int n14 = n;
        int n15 = n;
        int n16 = n;
        int n17 = n;
        int n18 = n;
        float field_70123_F = 0.0f;
        int n37 = 0;
        Label_0973: {
            Label_0961: {
                if (array == null) {
                    if (n == 0) {
                        n3 = 0.497;
                        int n19 = n2;
                        final int n20 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n20)) {
                                n3 = 0.6039;
                            }
                            n19 = n2;
                        }
                        if (lIIIIIII(n19, n20)) {
                            n3 += 0.046;
                        }
                        final Block blockUnderPlayer$345a1aee;
                        final boolean b2 = (blockUnderPlayer$345a1aee = Class33.getBlockUnderPlayer$345a1aee((EntityPlayer)this.mc.field_71439_g)) instanceof BlockIce;
                        Label_0105: {
                            Label_0100: {
                                if (array == null) {
                                    if (b2) {
                                        break Label_0100;
                                    }
                                    final boolean b3 = blockUnderPlayer$345a1aee instanceof BlockPackedIce;
                                }
                                if (!b2) {
                                    break Label_0105;
                                }
                            }
                            n3 = 0.59;
                        }
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n10 = n;
                    n11 = n;
                    n12 = n;
                    n13 = n;
                    n14 = n;
                    n15 = n;
                    n16 = n;
                    n17 = n;
                    n18 = n;
                }
                int n34;
                int n33;
                int n32;
                int n31;
                int n30;
                int n29;
                int n28;
                int n27;
                int n26;
                int n25;
                int n24;
                int n23;
                int n22;
                final int n21 = n22 = (n23 = (n24 = (n25 = (n26 = (n27 = (n28 = (n29 = (n30 = (n31 = (n32 = (n33 = (n34 = 1))))))))))));
                if (array == null) {
                    if (n18 == n21) {
                        n3 = 0.3031;
                        int n35 = n2;
                        final int n36 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n36)) {
                                n3 = 0.36729999999999996;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n35 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n35, n36)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n10 = n;
                    n11 = n;
                    n12 = n;
                    n13 = n;
                    n14 = n;
                    n15 = n;
                    n16 = n;
                    n17 = n;
                    n23 = (n22 = (n24 = (n25 = (n26 = (n27 = (n28 = (n29 = (n30 = (n31 = (n32 = (n33 = (n34 = 2))))))))))));
                }
                if (array == null) {
                    if (n17 == n22) {
                        n3 = 0.302;
                        int n38 = n2;
                        final int n39 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n39)) {
                                n3 = 0.3649;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n38 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n38, n39)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n10 = n;
                    n11 = n;
                    n12 = n;
                    n13 = n;
                    n14 = n;
                    n15 = n;
                    n16 = n;
                    n24 = (n23 = (n25 = (n26 = (n27 = (n28 = (n29 = (n30 = (n31 = (n32 = (n33 = (n34 = 3)))))))))));
                }
                if (array == null) {
                    if (n16 == n23) {
                        n3 = 0.3019;
                        int n40 = n2;
                        final int n41 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n41)) {
                                n3 = 0.3626;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n40 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n40, n41)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n10 = n;
                    n11 = n;
                    n12 = n;
                    n13 = n;
                    n14 = n;
                    n15 = n;
                    n25 = (n24 = (n26 = (n27 = (n28 = (n29 = (n30 = (n31 = (n32 = (n33 = (n34 = 4))))))))));
                }
                if (array == null) {
                    if (n15 == n24) {
                        n3 = 0.3019;
                        int n42 = n2;
                        final int n43 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n43)) {
                                n3 = 0.3603;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n42 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n42, n43)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n10 = n;
                    n11 = n;
                    n12 = n;
                    n13 = n;
                    n14 = n;
                    n26 = (n25 = (n27 = (n28 = (n29 = (n30 = (n31 = (n32 = (n33 = (n34 = 5)))))))));
                }
                if (array == null) {
                    if (n14 == n25) {
                        n3 = 0.3019;
                        int n44 = n2;
                        final int n45 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n45)) {
                                n3 = 0.358;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n44 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n44, n45)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n10 = n;
                    n11 = n;
                    n12 = n;
                    n13 = n;
                    n27 = (n26 = (n28 = (n29 = (n30 = (n31 = (n32 = (n33 = (n34 = 6))))))));
                }
                if (array == null) {
                    if (n13 == n26) {
                        n3 = 0.3019;
                        int n46 = n2;
                        final int n47 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n47)) {
                                n3 = 0.3558;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n46 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n46, n47)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n10 = n;
                    n11 = n;
                    n12 = n;
                    n28 = (n27 = (n29 = (n30 = (n31 = (n32 = (n33 = (n34 = 7)))))));
                }
                if (array == null) {
                    if (n12 == n27) {
                        n3 = 0.3019;
                        int n48 = n2;
                        final int n49 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n49)) {
                                n3 = 0.3536;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n48 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n48, n49)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n10 = n;
                    n11 = n;
                    n29 = (n28 = (n30 = (n31 = (n32 = (n33 = (n34 = 8))))));
                }
                if (array == null) {
                    if (n11 == n28) {
                        n3 = 0.3019;
                        int onGround;
                        final int n50 = onGround = (Class33.isOnGround(0.05) ? 1 : 0);
                        if (array == null) {
                            if (n50 != 0) {
                                n3 = 0.2999;
                            }
                            onGround = n2;
                        }
                        final int n51 = 2;
                        if (array == null) {
                            if (lIIIIIII(n50, n51)) {
                                n3 += 0.0496;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            onGround = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(onGround, n51)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n10 = n;
                    n30 = (n29 = (n31 = (n32 = (n33 = (n34 = 9)))));
                }
                if (array == null) {
                    if (n10 == n29) {
                        n3 = 0.3019;
                        int n52 = n2;
                        final int n53 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n53)) {
                                n3 = 0.3494;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n52 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n52, n53)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n9 = n;
                    n31 = (n30 = (n32 = (n33 = (n34 = 10))));
                }
                if (array == null) {
                    if (n9 == n30) {
                        n3 = 0.3019;
                        int n54 = n2;
                        final int n55 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n55)) {
                                n3 = 0.3474;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n54 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n54, n55)) {
                            break Label_0961;
                        }
                        n3 += n4;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n8 = n;
                    n32 = (n31 = (n33 = (n34 = 11)));
                }
                if (array == null) {
                    if (n8 == n31) {
                        n3 = 0.3;
                        int n56 = n2;
                        final int n57 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n57)) {
                                n3 = 0.345;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n56 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n56, n57)) {
                            break Label_0961;
                        }
                        n3 += 0.018;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n7 = n;
                    n33 = (n32 = (n34 = 12));
                }
                if (array == null) {
                    if (n7 == n32) {
                        n3 = 0.301;
                        int n58 = n2;
                        int n59 = n2;
                        int n61;
                        int n60 = n61 = 2;
                        if (array == null) {
                            if (n2 <= 2) {
                                this.aacCount = 0;
                            }
                            n58 = n2;
                            n59 = n2;
                            n60 = (n61 = 2);
                        }
                        if (array == null) {
                            if (lIIIIIII(n59, n61)) {
                                n3 = 0.34299999999999997;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n58 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                            n60 = 3;
                        }
                        if (!lIIIIIII(n58, n60)) {
                            break Label_0961;
                        }
                        n3 += n4 + 0.001;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    n5 = n;
                    n6 = n;
                    n34 = (n33 = 13);
                }
                if (array == null) {
                    if (n6 == n33) {
                        n3 = 0.298;
                        int n62 = n2;
                        final int n63 = 2;
                        if (array == null) {
                            if (lIIIIIII(n2, n63)) {
                                n3 = 0.33999999999999997;
                            }
                            field_70123_F = n2;
                            n37 = n2;
                            n62 = n2;
                            if (array != null) {
                                break Label_0973;
                            }
                        }
                        if (!lIIIIIII(n62, n63)) {
                            break Label_0961;
                        }
                        n3 += n4 + 0.001;
                        if (array == null) {
                            break Label_0961;
                        }
                    }
                    field_70123_F = n;
                    n37 = n;
                    n5 = n;
                    if (array != null) {
                        break Label_0973;
                    }
                    n34 = 14;
                }
                if (n5 == n34) {
                    n3 = 0.297;
                    int n64 = n2;
                    final int n65 = 2;
                    if (array == null) {
                        if (lIIIIIII(n2, n65)) {
                            n3 = 0.33899999999999997;
                        }
                        field_70123_F = n2;
                        n37 = n2;
                        n64 = n2;
                        if (array != null) {
                            break Label_0973;
                        }
                    }
                    if (lIIIIIII(n64, n65)) {
                        n3 += n4 + 0.001;
                    }
                }
            }
            field_70123_F = (n37 = fcmpg(this.mc.field_71439_g.field_70701_bs, 0.0f));
        }
        Class259 class259 = null;
        Label_1022: {
            if (array == null) {
                if (n37 <= 0) {
                    n3 -= 0.06;
                }
                class259 = this;
                if (array != null) {
                    break Label_1022;
                }
                field_70123_F = (this.mc.field_71439_g.field_70123_F ? 1 : 0);
            }
            if (field_70123_F == 0) {
                return n3;
            }
            n3 -= 0.1;
            class259 = this;
        }
        class259.aacCount = 0;
        return n3;
    }
    
    static {
        lllIlIl();
        Class169.a(7830015311509055032L, 4524142703051230314L, MethodHandles.lookup().lookupClass()).a(135306840531014L);
        final Cipher instance = Cipher.getInstance(Class259.llllIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class259.llllIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(38496921760213L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class259.llllIl[2].getBytes(Class259.llllIl[3]))).intern();
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
    
    private static void lllIlIl() {
        (llllIl = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class259.llllIl[1] = "DES";
        Class259.llllIl[2] = "]\u0092\u0013\u008eU\u008fE`/§\u0095\u0091\u0085\bG4";
        Class259.llllIl[3] = "ISO-8859-1";
    }
    
    private static String lllIIIl(final String s, final String s2) {
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
    
    private static String lllIlII(final String s, final String s2) {
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
    
    public static boolean lIIIIIII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIIIIlI$255f299(final int n) {
        return n <= 2;
    }
    
    private static boolean llllllI(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIIIIll(final int n) {
        return n <= 0;
    }
    
    private static boolean llllIlI(final int n) {
        return n > 0;
    }
    
    private static int lllIlll$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lllIllI$25399e8(final double n) {
        return dcmpl(n, 1.2);
    }
    
    private static int lllllll$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
}
