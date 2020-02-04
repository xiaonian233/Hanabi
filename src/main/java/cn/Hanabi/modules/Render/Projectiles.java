package cn.Hanabi.modules.Render;

import cn.Hanabi.modules.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.entity.*;
import net.minecraft.client.entity.*;
import net.minecraft.item.*;
import net.minecraft.client.renderer.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Projectiles extends Mod
{
    private EntityLivingBase entity;
    private MovingObjectPosition blockCollision;
    private MovingObjectPosition entityCollision;
    private static AxisAlignedBB aim;
    private static final long b;
    private static final String c;
    private static final String[] lIIlIlIIII;
    
    public Projectiles() {
        super("Projectiles", Category.RENDER);
    }
    
    @EventTarget
    private void onRender$1f20be12() {
        final int[] b = Class139.b();
        EntityPlayerSP field_71439_g;
        final EntityPlayerSP entityPlayerSP = field_71439_g = Projectiles.mc.field_71439_g;
        if (b == null) {
            if (entityPlayerSP.field_71071_by.func_70448_g() == null) {
                return;
            }
            final EntityPlayerSP field_71439_g2;
            field_71439_g = (field_71439_g2 = Projectiles.mc.field_71439_g);
        }
        final EntityPlayerSP entityPlayerSP2 = entityPlayerSP;
        final ItemStack func_70448_g = field_71439_g.field_71071_by.func_70448_g();
        int func_150891_b;
        int n4;
        int n3;
        final int n2;
        final int n = n2 = (n3 = (n4 = (func_150891_b = Item.func_150891_b(Projectiles.mc.field_71439_g.func_70694_bm().func_77973_b()))));
        int n7;
        int n6;
        final int n5 = n6 = (n7 = 261);
        Label_0103: {
            if (b == null) {
                if (!llIllIIIllI(n, n5)) {
                    break Label_0103;
                }
                n4 = (n3 = (func_150891_b = n2));
                final int n8;
                n6 = (n8 = (n7 = 368));
            }
            if (b == null) {
                if (!llIllIIIllI(n3, n5)) {
                    break Label_0103;
                }
                func_150891_b = (n4 = n2);
                n7 = (n6 = 332);
            }
            if (b == null) {
                if (!llIllIIIllI(n4, n6)) {
                    break Label_0103;
                }
                func_150891_b = n2;
                n7 = 344;
            }
            if (func_150891_b != n7) {
                return;
            }
        }
        double n9 = entityPlayerSP2.field_70142_S + (entityPlayerSP2.field_70165_t - entityPlayerSP2.field_70142_S) * Class94.getTimer().field_74281_c - Math.cos(Math.toRadians(entityPlayerSP2.field_70177_z)) * 0.1599999964237213;
        double n10 = entityPlayerSP2.field_70137_T + (entityPlayerSP2.field_70163_u - entityPlayerSP2.field_70137_T) * Class94.getTimer().field_74281_c + entityPlayerSP2.func_70047_e() - 0.1;
        double n11 = entityPlayerSP2.field_70136_U + (entityPlayerSP2.field_70161_v - entityPlayerSP2.field_70136_U) * Class94.getTimer().field_74281_c - Math.sin(Math.toRadians(entityPlayerSP2.field_70177_z)) * 0.1599999964237213;
        final double n12 = (func_70448_g.func_77973_b() instanceof ItemBow) ? 1.0 : 0.4000000059604645;
        final double radians = Math.toRadians(entityPlayerSP2.field_70177_z);
        final double radians2 = Math.toRadians(entityPlayerSP2.field_70125_A);
        final double n13 = -Math.sin(radians) * Math.cos(radians2) * n12;
        final double n14 = -Math.sin(radians2) * n12;
        final double n15 = Math.cos(radians) * Math.cos(radians2) * n12;
        final double n16 = n13;
        final double n17 = n16 * n16;
        final double n18 = n14;
        final double n19 = n17 + n18 * n18;
        final double n20 = n15;
        final double sqrt = Math.sqrt(n19 + n20 * n20);
        double n21 = n13 / sqrt;
        double n22 = n14 / sqrt;
        double n23 = n15 / sqrt;
        Label_0462: {
            if (b == null) {
                if (func_70448_g.func_77973_b() instanceof ItemBow) {
                    final float n24 = (72000 - entityPlayerSP2.func_71052_bv()) / 20.0f;
                    float n26;
                    float n25 = n26 = (n24 * n24 + n24 * 2.0f) / 3.0f;
                    float n27 = 1.0f;
                    if (b == null) {
                        if (n25 > 1.0f) {
                            n25 = 1.0f;
                        }
                        n26 = n25;
                        n27 = 3.0f;
                    }
                    final float n28 = n26 * n27;
                    n21 *= n28;
                    n22 *= n28;
                    n23 *= n28;
                    if (b == null) {
                        break Label_0462;
                    }
                }
                n21 *= 1.5;
                n22 *= 1.5;
            }
            n23 *= 1.5;
        }
        GL11.glPushMatrix();
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glEnable(2848);
        GL11.glLineWidth(2.0f);
        final double n29 = (func_70448_g.func_77973_b() instanceof ItemBow) ? 0.05 : 0.03;
        GL11.glColor4f(0.0f, 1.0f, 0.2f, 0.5f);
        GL11.glBegin(3);
        int n30 = 0;
        while (true) {
            do {
                int i = 0;
            Label_0540:
                while (i < 2000) {
                    final double n31 = n9;
                    Projectiles.mc.func_175598_ae();
                    final double n32 = n10;
                    Projectiles.mc.func_175598_ae();
                    final double n33 = n11;
                    Projectiles.mc.func_175598_ae();
                    GL11.glVertex3d(n31, n32, n33);
                    n9 += n21 * 0.1;
                    n10 += n22 * 0.1;
                    n11 += n23 * 0.1;
                    n21 *= 0.999;
                    final double n34 = n22 * 0.999;
                    n23 *= 0.999;
                    n22 = n34 - n29 * 0.1;
                    final Vec3 vec3 = new Vec3(entityPlayerSP2.field_70165_t, entityPlayerSP2.field_70163_u + entityPlayerSP2.func_70047_e(), entityPlayerSP2.field_70161_v);
                    this.blockCollision = Projectiles.mc.field_71441_e.func_72933_a(vec3, new Vec3(n9, n10, n11));
                    if (b != null) {
                        final double n35 = n9;
                        Projectiles.mc.func_175598_ae();
                        final double n36 = n35;
                        final double n37 = n10;
                        Projectiles.mc.func_175598_ae();
                        final double n38 = n37;
                        final double n39 = n11;
                        Projectiles.mc.func_175598_ae();
                        final double n40 = n39;
                        GL11.glPushMatrix();
                        GL11.glTranslated(n36 - 0.5, n38 - 0.5, n40 - 0.5);
                        Label_1086: {
                            Label_1034: {
                                if (b == null) {
                                    switch (this.blockCollision.field_178784_b.func_176745_a()) {
                                        case 2:
                                        case 3: {
                                            GlStateManager.func_179114_b(90.0f, 1.0f, 0.0f, 0.0f);
                                            Projectiles.aim = new AxisAlignedBB(0.0, 0.5, -1.0, 1.0, 0.45, 0.0);
                                            break;
                                        }
                                        case 4:
                                        case 5: {
                                            break Label_1034;
                                        }
                                    }
                                }
                                if (b == null) {
                                    break Label_1086;
                                }
                            }
                            GlStateManager.func_179114_b(90.0f, 0.0f, 0.0f, 1.0f);
                            Projectiles.aim = new AxisAlignedBB(0.0, -0.5, 0.0, 1.0, -0.45, 1.0);
                            if (b == null) {
                                break Label_1086;
                            }
                            Projectiles.aim = new AxisAlignedBB(0.0, 0.5, 0.0, 1.0, 0.45, 1.0);
                        }
                        final AxisAlignedBB aim = Projectiles.aim;
                        GL11.glBegin(7);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72338_b, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72338_b, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72338_b, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72338_b, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72337_e, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72337_e, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72337_e, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72337_e, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72338_b, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72337_e, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72337_e, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72338_b, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72338_b, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72337_e, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72337_e, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72338_b, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72338_b, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72338_b, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72336_d, aim.field_72337_e, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72337_e, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72338_b, aim.field_72339_c);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72338_b, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72337_e, aim.field_72334_f);
                        GL11.glVertex3d(aim.field_72340_a, aim.field_72337_e, aim.field_72339_c);
                        GL11.glEnd();
                        final AxisAlignedBB aim2 = Projectiles.aim;
                        final Tessellator func_178181_a;
                        final WorldRenderer func_178180_c;
                        (func_178180_c = (func_178181_a = Tessellator.func_178181_a()).func_178180_c()).func_181668_a(3, DefaultVertexFormats.field_181705_e);
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72338_b, aim2.field_72339_c).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72336_d, aim2.field_72338_b, aim2.field_72339_c).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72336_d, aim2.field_72338_b, aim2.field_72334_f).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72338_b, aim2.field_72334_f).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72338_b, aim2.field_72339_c).func_181675_d();
                        func_178181_a.func_78381_a();
                        func_178180_c.func_181668_a(3, DefaultVertexFormats.field_181705_e);
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72337_e, aim2.field_72339_c).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72336_d, aim2.field_72337_e, aim2.field_72339_c).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72336_d, aim2.field_72337_e, aim2.field_72334_f).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72337_e, aim2.field_72334_f).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72337_e, aim2.field_72339_c).func_181675_d();
                        func_178181_a.func_78381_a();
                        func_178180_c.func_181668_a(1, DefaultVertexFormats.field_181705_e);
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72338_b, aim2.field_72339_c).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72337_e, aim2.field_72339_c).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72336_d, aim2.field_72338_b, aim2.field_72339_c).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72336_d, aim2.field_72337_e, aim2.field_72339_c).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72336_d, aim2.field_72338_b, aim2.field_72334_f).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72336_d, aim2.field_72337_e, aim2.field_72334_f).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72338_b, aim2.field_72334_f).func_181675_d();
                        func_178180_c.func_181662_b(aim2.field_72340_a, aim2.field_72337_e, aim2.field_72334_f).func_181675_d();
                        func_178181_a.func_78381_a();
                        GL11.glPopMatrix();
                        GL11.glDisable(3042);
                        GL11.glEnable(3553);
                        GL11.glEnable(2929);
                        GL11.glDepthMask(true);
                        GL11.glDisable(2848);
                        GL11.glPopMatrix();
                        return;
                    }
                    final Iterator iterator = Projectiles.mc.field_71441_e.func_72910_y().iterator();
                    while (iterator.hasNext()) {
                        final EntityLivingBase entityLivingBase;
                        boolean b2;
                        i = ((b2 = ((entityLivingBase = (EntityLivingBase)iterator.next()) instanceof EntityLivingBase)) ? 1 : 0);
                        if (b != null) {
                            continue Label_0540;
                        }
                        Label_0875: {
                            if (b == null) {
                                if (i == 0) {
                                    break Label_0875;
                                }
                                b2 = (entityLivingBase instanceof EntityPlayerSP);
                            }
                            if (!b2) {
                                this.entity = entityLivingBase;
                                this.entityCollision = this.entity.func_174813_aQ().func_72314_b(0.3, 0.3, 0.3).func_72327_a(vec3, new Vec3(n9, n10, n11));
                                MovingObjectPosition movingObjectPosition2;
                                final MovingObjectPosition movingObjectPosition = movingObjectPosition2 = this.entityCollision;
                                if (b == null) {
                                    if (movingObjectPosition != null) {
                                        this.blockCollision = this.entityCollision;
                                    }
                                    final MovingObjectPosition entityCollision;
                                    movingObjectPosition2 = (entityCollision = this.entityCollision);
                                }
                                Projectiles projectiles = null;
                                Label_0868: {
                                    if (b == null) {
                                        if (movingObjectPosition != null) {
                                            GL11.glColor4f(1.0f, 0.0f, 0.2f, 0.5f);
                                        }
                                        projectiles = this;
                                        if (b != null) {
                                            break Label_0868;
                                        }
                                        movingObjectPosition2 = this.entityCollision;
                                    }
                                    if (movingObjectPosition2 == null) {
                                        break Label_0875;
                                    }
                                    projectiles = this;
                                }
                                projectiles.blockCollision = this.entityCollision;
                            }
                        }
                        if (b != null) {
                            break;
                        }
                    }
                    if (this.blockCollision != null && b == null) {
                        break;
                    }
                    ++n30;
                }
                break;
            } while (b == null);
            GL11.glEnd();
            continue;
        }
    }
    
    private static void drawBox(final AxisAlignedBB axisAlignedBB) {
        GL11.glBegin(7);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        GL11.glVertex3d(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        GL11.glEnd();
    }
    
    private static void func_181561_a(final AxisAlignedBB axisAlignedBB) {
        final Tessellator func_178181_a;
        final WorldRenderer func_178180_c;
        (func_178180_c = (func_178181_a = Tessellator.func_178181_a()).func_178180_c()).func_181668_a(3, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(3, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(1, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178181_a.func_78381_a();
    }
    
    static {
        llIllIIIIlI();
        Class169.a(-760177663051782793L, 5937166490418068502L, MethodHandles.lookup().lookupClass()).a(32162410302429L);
        final Cipher instance = Cipher.getInstance(Projectiles.lIIlIlIIII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Projectiles.lIIlIlIIII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(21301813458891L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(Projectiles.lIIlIlIIII[2].getBytes(Projectiles.lIIlIlIIII[3]))).intern();
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
    
    private static void llIllIIIIlI() {
        (lIIlIlIIII = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Projectiles.lIIlIlIIII[1] = "DES";
        Projectiles.lIIlIlIIII[2] = "lð\u008f\u0099À\u008ch&ÃuB¬ô\u0098Gb";
        Projectiles.lIIlIlIIII[3] = "ISO-8859-1";
    }
    
    private static String llIlIllllll(final String s, final String s2) {
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
    
    private static String llIlIlllllI(final String s, final String s2) {
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
    
    private static boolean llIllIIlIIl(final int n) {
        return n > 0;
    }
    
    private static boolean llIllIIIllI(final int n, final int n2) {
        return n != n2;
    }
    
    private static int llIllIIIIll$2548a28(final float n) {
        return fcmpl(n, 1.0f);
    }
}
