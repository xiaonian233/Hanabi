package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.modules.Combat.*;
import org.lwjgl.opengl.*;
import java.awt.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.entity.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class ESP extends Mod
{
    private Value<String> mode;
    private Value<Boolean> invisible;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIllIIlIIl;
    
    public ESP() {
        super("ESP", Category.RENDER);
        this.mode = new Value<String>("ESP", "Mode", 0);
        this.invisible = new Value<Boolean>("ESP_Invisible", Boolean.FALSE);
        this.mode.addValue("Box");
        this.mode.addValue("2D");
    }
    
    @EventTarget
    private void onRender$1f20be12() {
        final int[] b = Class139.b();
        final boolean currentMode = this.mode.isCurrentMode("Box");
        ESP esp = null;
        Label_0411: {
            Label_0401: {
                if (b == null) {
                    if (currentMode) {
                        this.setDisplayName("Box");
                        for (EntityPlayer next : ESP.mc.field_71441_e.field_72996_f) {
                            final EntityPlayer entityPlayer = next;
                            Label_0384: {
                                if (b == null) {
                                    final boolean b2 = entityPlayer instanceof EntityPlayer;
                                    if (b != null) {
                                        break Label_0401;
                                    }
                                    if (!b2) {
                                        break Label_0384;
                                    }
                                    next = entityPlayer;
                                }
                                EntityPlayer entityPlayer4;
                                final EntityPlayer entityPlayer3;
                                final EntityPlayer entityPlayer2 = entityPlayer3 = (entityPlayer4 = next);
                                if (b == null) {
                                    if (entityPlayer2 == ESP.mc.field_71439_g) {
                                        break Label_0384;
                                    }
                                    entityPlayer4 = entityPlayer3;
                                }
                                if (!entityPlayer4.field_70128_L) {
                                    final EntityPlayer entityPlayer5 = entityPlayer3;
                                    final int[] b3 = Class139.b();
                                    final boolean func_82150_aj;
                                    final boolean b4 = func_82150_aj = ((Entity)entityPlayer5).func_82150_aj();
                                    Label_0189: {
                                        final boolean booleanValue;
                                        Label_0158: {
                                            if (b3 == null) {
                                                if (b4) {
                                                    booleanValue = this.invisible.value;
                                                    if (b3 != null) {
                                                        break Label_0158;
                                                    }
                                                    if (!booleanValue) {
                                                        break Label_0189;
                                                    }
                                                }
                                                KillAura.targets.contains(entityPlayer5);
                                            }
                                        }
                                        Label_0192: {
                                            if (b3 == null) {
                                                if (!b4) {
                                                    break Label_0192;
                                                }
                                                ((KillAura)Class4.getModule("Killaura")).esp.value;
                                            }
                                            if (booleanValue) {
                                                break Label_0189;
                                            }
                                        }
                                        ESP.mc.func_175598_ae();
                                        final double n = ((Entity)entityPlayer5).field_70142_S + (((Entity)entityPlayer5).field_70165_t - ((Entity)entityPlayer5).field_70142_S) * Class94.getTimer().field_74281_c;
                                        ESP.mc.func_175598_ae();
                                        final double n2 = n;
                                        ESP.mc.func_175598_ae();
                                        final double n3 = ((Entity)entityPlayer5).field_70137_T + (((Entity)entityPlayer5).field_70163_u - ((Entity)entityPlayer5).field_70137_T) * Class94.getTimer().field_74281_c;
                                        ESP.mc.func_175598_ae();
                                        final double n4 = n3;
                                        ESP.mc.func_175598_ae();
                                        final double n5 = ((Entity)entityPlayer5).field_70136_U + (((Entity)entityPlayer5).field_70161_v - ((Entity)entityPlayer5).field_70136_U) * Class94.getTimer().field_74281_c;
                                        ESP.mc.func_175598_ae();
                                        Class69.drawEntityESP(n2, n4, n5, ((Entity)entityPlayer5).func_174813_aQ().field_72336_d - ((Entity)entityPlayer5).func_174813_aQ().field_72340_a - 0.1, ((Entity)entityPlayer5).func_174813_aQ().field_72337_e - ((Entity)entityPlayer5).func_174813_aQ().field_72338_b + 0.25, 1.0f, 1.0f, 1.0f, 0.2f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f);
                                    }
                                }
                            }
                            if (b != null) {
                                break;
                            }
                        }
                    }
                    esp = this;
                    if (b != null) {
                        break Label_0411;
                    }
                    this.mode.isCurrentMode("2D");
                }
            }
            if (!currentMode) {
                return;
            }
            this.setDisplayName("2D");
            esp = this;
        }
        final ESP esp2 = esp;
        final int[] b5 = Class139.b();
        final Iterator iterator2 = ESP.mc.field_71441_e.field_73010_i.iterator();
        while (iterator2.hasNext()) {
            final EntityPlayer entityPlayer6;
            boolean b8;
            boolean b7;
            final boolean b6 = b7 = (b8 = (entityPlayer6 = iterator2.next()).func_82150_aj());
            final boolean b9;
            Label_0490: {
                if (b5 == null) {
                    if (b6) {
                        b9 = (b8 = esp2.invisible.value);
                        if (b5 != null) {
                            break Label_0490;
                        }
                        if (!b9) {
                            return;
                        }
                    }
                    KillAura.targets.contains(entityPlayer6);
                }
            }
            final int booleanValue2;
            Label_0593: {
                if (b5 == null) {
                    if (b6) {
                        booleanValue2 = (((boolean)((KillAura)Class4.getModule("Killaura")).esp.value) ? 1 : 0);
                        if (b5 != null) {
                            break Label_0593;
                        }
                        if (booleanValue2 != 0) {
                            return;
                        }
                    }
                    final EntityPlayer entityPlayer7 = entityPlayer6;
                    final int[] b10 = Class139.b();
                    EntityPlayer entityPlayer9;
                    final EntityPlayer entityPlayer8 = entityPlayer9 = entityPlayer7;
                    if (b10 == null) {
                        if (entityPlayer8 == ESP.mc.field_71439_g) {
                            break Label_0593;
                        }
                        final EntityPlayer entityPlayer10;
                        entityPlayer9 = (entityPlayer10 = entityPlayer7);
                    }
                    if (b10 == null) {
                        if (((EntityLivingBase)entityPlayer8).func_110143_aJ() <= 0.0f) {
                            break Label_0593;
                        }
                        entityPlayer9 = entityPlayer7;
                    }
                    b7 = (entityPlayer9 instanceof EntityPlayer);
                }
            }
            Label_0952: {
                if (b5 == null) {
                    if (!b9) {
                        break Label_0952;
                    }
                    GL11.glPushMatrix();
                    GL11.glEnable(3042);
                    GL11.glDisable(2929);
                    GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                    GlStateManager.func_179147_l();
                    GL11.glBlendFunc(770, 771);
                }
                GL11.glDisable(booleanValue2);
                final float field_74281_c = Class94.getTimer().field_74281_c;
                ESP.mc.func_175598_ae();
                final double n6 = entityPlayer6.field_70142_S + (entityPlayer6.field_70165_t - entityPlayer6.field_70142_S) * field_74281_c;
                ESP.mc.func_175598_ae();
                final double n7 = n6;
                ESP.mc.func_175598_ae();
                final double n8 = entityPlayer6.field_70137_T + (entityPlayer6.field_70163_u - entityPlayer6.field_70137_T) * field_74281_c;
                ESP.mc.func_175598_ae();
                final double n9 = n8;
                ESP.mc.func_175598_ae();
                final double n10 = entityPlayer6.field_70136_U + (entityPlayer6.field_70161_v - entityPlayer6.field_70136_U) * field_74281_c;
                ESP.mc.func_175598_ae();
                final double n11 = n10;
                Math.min(ESP.mc.field_71439_g.func_70032_d((Entity)entityPlayer6) * 0.15f, 0.15f);
                final float n12 = (float)n7;
                final float field_70131_O = entityPlayer6.field_70131_O;
                final EntityPlayer entityPlayer11 = entityPlayer6;
                if (b5 != null || entityPlayer11.func_70631_g_()) {
                    final float field_70131_O2 = entityPlayer11.field_70131_O;
                }
                final float n13 = (float)n11;
                final float n14 = n12;
                final float n15 = (float)n9 + entityPlayer6.field_70131_O + 0.5f;
                final EntityPlayer entityPlayer12 = entityPlayer6;
                GlStateManager.func_179109_b(n14, n15 - ((b5 == null && !entityPlayer12.func_70631_g_()) ? 0.0f : (entityPlayer12.field_70131_O / 2.0f)), n13);
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                GlStateManager.func_179114_b(-ESP.mc.func_175598_ae().field_78735_i, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-0.0175f, -0.0175f, -0.0175f);
                Tessellator.func_178181_a().func_178180_c();
                entityPlayer6.func_110143_aJ();
                new Color(0, 0, 0);
                Class69.drawRect(-30.0f, 15.0f, 30.0f, 140.0f, Class23.reAlpha(new Color(255, 255, 255).getRGB(), 0.2f));
                GL11.glEnable(3553);
                GL11.glEnable(2929);
                GlStateManager.func_179084_k();
                GL11.glDisable(3042);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glNormal3f(1.0f, 1.0f, 1.0f);
                GL11.glPopMatrix();
            }
            if (b5 != null) {
                break;
            }
        }
    }
    
    private static boolean isValid(final EntityLivingBase entityLivingBase) {
        final int[] b = Class139.b();
        EntityLivingBase entityLivingBase2 = entityLivingBase;
        EntityLivingBase entityLivingBase3 = entityLivingBase;
        if (b == null) {
            if (entityLivingBase == ESP.mc.field_71439_g) {
                return false;
            }
            entityLivingBase2 = entityLivingBase;
            entityLivingBase3 = entityLivingBase;
        }
        if (b == null) {
            if (entityLivingBase3.func_110143_aJ() <= 0.0f) {
                return false;
            }
            entityLivingBase2 = entityLivingBase;
        }
        return entityLivingBase2 instanceof EntityPlayer;
    }
    
    private void renderBox$661547d3(final Entity entity) {
        final int[] b = Class139.b();
        final boolean func_82150_aj;
        final boolean b2 = func_82150_aj = entity.func_82150_aj();
        final boolean booleanValue;
        Label_0042: {
            if (b == null) {
                if (b2) {
                    booleanValue = this.invisible.value;
                    if (b != null) {
                        break Label_0042;
                    }
                    if (!booleanValue) {
                        return;
                    }
                }
                KillAura.targets.contains(entity);
            }
        }
        Label_0073: {
            if (b == null) {
                if (!b2) {
                    break Label_0073;
                }
                ((KillAura)Class4.getModule("Killaura")).esp.value;
            }
            if (booleanValue) {
                return;
            }
        }
        ESP.mc.func_175598_ae();
        final double n = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * Class94.getTimer().field_74281_c;
        ESP.mc.func_175598_ae();
        final double n2 = n;
        ESP.mc.func_175598_ae();
        final double n3 = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * Class94.getTimer().field_74281_c;
        ESP.mc.func_175598_ae();
        final double n4 = n3;
        ESP.mc.func_175598_ae();
        final double n5 = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * Class94.getTimer().field_74281_c;
        ESP.mc.func_175598_ae();
        Class69.drawEntityESP(n2, n4, n5, entity.func_174813_aQ().field_72336_d - entity.func_174813_aQ().field_72340_a - 0.1, entity.func_174813_aQ().field_72337_e - entity.func_174813_aQ().field_72338_b + 0.25, 1.0f, 1.0f, 1.0f, 0.2f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f);
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
    
    private void doOther2DESP() {
        final int[] b = Class139.b();
        final Iterator iterator = ESP.mc.field_71441_e.field_73010_i.iterator();
        while (iterator.hasNext()) {
            final EntityPlayer entityPlayer;
            boolean b4;
            boolean b3;
            final boolean b2 = b3 = (b4 = (entityPlayer = iterator.next()).func_82150_aj());
            final boolean b5;
            Label_0076: {
                if (b == null) {
                    if (b2) {
                        b5 = (b4 = this.invisible.value);
                        if (b != null) {
                            break Label_0076;
                        }
                        if (!b5) {
                            return;
                        }
                    }
                    KillAura.targets.contains(entityPlayer);
                }
            }
            final int booleanValue;
            Label_0179: {
                if (b == null) {
                    if (b2) {
                        booleanValue = (((boolean)((KillAura)Class4.getModule("Killaura")).esp.value) ? 1 : 0);
                        if (b != null) {
                            break Label_0179;
                        }
                        if (booleanValue != 0) {
                            return;
                        }
                    }
                    final EntityPlayer entityPlayer2 = entityPlayer;
                    final int[] b6 = Class139.b();
                    EntityPlayer entityPlayer4;
                    final EntityPlayer entityPlayer3 = entityPlayer4 = entityPlayer2;
                    if (b6 == null) {
                        if (entityPlayer3 == ESP.mc.field_71439_g) {
                            break Label_0179;
                        }
                        final EntityPlayer entityPlayer5;
                        entityPlayer4 = (entityPlayer5 = entityPlayer2);
                    }
                    if (b6 == null) {
                        if (((EntityLivingBase)entityPlayer3).func_110143_aJ() <= 0.0f) {
                            break Label_0179;
                        }
                        entityPlayer4 = entityPlayer2;
                    }
                    b3 = (entityPlayer4 instanceof EntityPlayer);
                }
            }
            Label_0538: {
                if (b == null) {
                    if (!b5) {
                        break Label_0538;
                    }
                    GL11.glPushMatrix();
                    GL11.glEnable(3042);
                    GL11.glDisable(2929);
                    GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                    GlStateManager.func_179147_l();
                    GL11.glBlendFunc(770, 771);
                }
                GL11.glDisable(booleanValue);
                final float field_74281_c = Class94.getTimer().field_74281_c;
                ESP.mc.func_175598_ae();
                final double n = entityPlayer.field_70142_S + (entityPlayer.field_70165_t - entityPlayer.field_70142_S) * field_74281_c;
                ESP.mc.func_175598_ae();
                final double n2 = n;
                ESP.mc.func_175598_ae();
                final double n3 = entityPlayer.field_70137_T + (entityPlayer.field_70163_u - entityPlayer.field_70137_T) * field_74281_c;
                ESP.mc.func_175598_ae();
                final double n4 = n3;
                ESP.mc.func_175598_ae();
                final double n5 = entityPlayer.field_70136_U + (entityPlayer.field_70161_v - entityPlayer.field_70136_U) * field_74281_c;
                ESP.mc.func_175598_ae();
                final double n6 = n5;
                Math.min(ESP.mc.field_71439_g.func_70032_d((Entity)entityPlayer) * 0.15f, 0.15f);
                final float n7 = (float)n2;
                final float field_70131_O = entityPlayer.field_70131_O;
                final EntityPlayer entityPlayer6 = entityPlayer;
                if (b != null || entityPlayer6.func_70631_g_()) {
                    final float field_70131_O2 = entityPlayer6.field_70131_O;
                }
                final float n8 = (float)n6;
                final float n9 = n7;
                final float n10 = (float)n4 + entityPlayer.field_70131_O + 0.5f;
                final EntityPlayer entityPlayer7 = entityPlayer;
                GlStateManager.func_179109_b(n9, n10 - ((b == null && !entityPlayer7.func_70631_g_()) ? 0.0f : (entityPlayer7.field_70131_O / 2.0f)), n8);
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                GlStateManager.func_179114_b(-ESP.mc.func_175598_ae().field_78735_i, 0.0f, 1.0f, 0.0f);
                GL11.glScalef(-0.0175f, -0.0175f, -0.0175f);
                Tessellator.func_178181_a().func_178180_c();
                entityPlayer.func_110143_aJ();
                new Color(0, 0, 0);
                Class69.drawRect(-30.0f, 15.0f, 30.0f, 140.0f, Class23.reAlpha(new Color(255, 255, 255).getRGB(), 0.2f));
                GL11.glEnable(3553);
                GL11.glEnable(2929);
                GlStateManager.func_179084_k();
                GL11.glDisable(3042);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                GL11.glNormal3f(1.0f, 1.0f, 1.0f);
                GL11.glPopMatrix();
            }
            if (b != null) {
                break;
            }
        }
    }
    
    private static void drawBorderedRect(final float n, final float n2, final float n3, final float n4, final float n5, final int n6, final int n7) {
        final float n8 = (n7 >> 24 & 0xFF) / 255.0f;
        final float n9 = (n7 >> 16 & 0xFF) / 255.0f;
        final float n10 = (n7 >> 8 & 0xFF) / 255.0f;
        final float n11 = (n7 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(n9, n10, n11, n8);
        GL11.glBegin(7);
        GL11.glVertex2d((double)n3, (double)n2);
        GL11.glVertex2d((double)n, (double)n2);
        GL11.glVertex2d((double)n, (double)n4);
        GL11.glVertex2d((double)n3, (double)n4);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        final float n12 = (n6 >> 24 & 0xFF) / 255.0f;
        final float n13 = (n6 >> 16 & 0xFF) / 255.0f;
        final float n14 = (n6 >> 8 & 0xFF) / 255.0f;
        final float n15 = (n6 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(n13, n14, n15, n12);
        GL11.glLineWidth(n5);
        GL11.glBegin(1);
        GL11.glVertex2d((double)n, (double)n2);
        GL11.glVertex2d((double)n, (double)n4);
        GL11.glVertex2d((double)n3, (double)n4);
        GL11.glVertex2d((double)n3, (double)n2);
        GL11.glVertex2d((double)n, (double)n2);
        GL11.glVertex2d((double)n3, (double)n2);
        GL11.glVertex2d((double)n, (double)n4);
        GL11.glVertex2d((double)n3, (double)n4);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    private static void drawRect(final float n, final float n2, final float n3, final float n4, final int n5) {
        final float n6 = (n5 >> 24 & 0xFF) / 255.0f;
        final float n7 = (n5 >> 16 & 0xFF) / 255.0f;
        final float n8 = (n5 >> 8 & 0xFF) / 255.0f;
        final float n9 = (n5 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(n7, n8, n9, n6);
        GL11.glBegin(7);
        GL11.glVertex2d((double)n3, (double)n2);
        GL11.glVertex2d((double)n, (double)n2);
        GL11.glVertex2d((double)n, (double)n4);
        GL11.glVertex2d((double)n3, (double)n4);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    static {
        lIIIIIlIIllI();
        Class169.a(-1133419440926618036L, 1906772377556315004L, MethodHandles.lookup().lookupClass()).a(211159609096166L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(ESP.lIllIIlIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(ESP.lIllIIlIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(109564886768240L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[10];
        int n2 = 0;
        String s;
        int n3 = (s = ESP.lIllIIlIIl[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(ESP.lIllIIlIIl[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = ESP.lIllIIlIIl[3]).length();
                            n4 = 32;
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
        d = new String[10];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x3AAE;
        if (ESP.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = ESP.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(ESP.lIllIIlIIl[5]);
                    array[1] = SecretKeyFactory.getInstance(ESP.lIllIIlIIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    ESP.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(ESP.lIllIIlIIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            ESP.d[n3] = b(((Cipher)array[0]).doFinal(ESP.c[n3].getBytes(ESP.lIllIIlIIl[8])));
        }
        return ESP.d[n3];
    }
    
    private static void lIIIIIlIIllI() {
        (lIllIIlIIl = new String[12])[0] = "DES/CBC/PKCS5Padding";
        ESP.lIllIIlIIl[1] = "DES";
        ESP.lIllIIlIIl[2] = "p§\u0005\u001c\u001aq,\u001e(\u009b\u0096ÿ\u008c\fjî\u0018B\u009fx(ÊÛHâÐ\u0006Zd\b8¨\u0004IÈ\u0095\r\u0015\u008f,A\u0010\u0083´c¾ Ô¸wÂk/\"\u0002º«i\u0010\u007f\u00ad\u001d\u0097ç\t\u0007V`\u0017·\u009fîþa\u0013\u0010Ü/Åw´ ÌêQEÜ.U¤Dr\u0010\"[ãÊ²\u0003\u0093´0°(\u0089|úEº\u0010\u0010Ë\u0019R0h|Öè\u0096æ%Cíç1 Q¸&¹QÀ\u0012±¾K¤ñ´ ê(!80å\u0001\u0087ÏS¡b¬ÅOµ`Q";
        ESP.lIllIIlIIl[3] = "\u009bÀìâ0ÎYù\b¦®\u001cÑ\\O´Vë×¾ë\u001ci^.\u0007\u0096¡S\u00137\u000e\u0010U\u0017óvo\u0007¸\u000f²\u0099Ek\u0095\u0017w.";
        ESP.lIllIIlIIl[4] = "ISO-8859-1";
        ESP.lIllIIlIIl[5] = "DES/CBC/PKCS5Padding";
        ESP.lIllIIlIIl[6] = "DES";
        ESP.lIllIIlIIl[7] = "你总是自称自己牛逼哄哄不可一世是吧你这样的残废不堪一击的废物你那些所谓的词汇低俗不堪对你亲爹我来说没有丝毫的心情涟漪呵呵你是不是想用你断断续续的言语证明你的无知只是我脚下的一对凌土你知道不我看看你这个喝着经血长大的孩子还能复制出来NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u200d\u2009\u2001";
        ESP.lIllIIlIIl[8] = "ISO-8859-1";
        ESP.lIllIIlIIl[9] = "你总是自称自己牛逼哄哄不可一世是吧你这样的残废不堪一击的废物你那些所谓的词汇低俗不堪对你亲爹我来说没有丝毫的心情涟漪呵呵你是不是想用你断断续续的言语证明你的无知只是我脚下的一对凌土你知道不我看看你这个喝着经血长大的孩子还能复制出来NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u200d\u2009\u2001";
        ESP.lIllIIlIIl[10] = " : ";
        ESP.lIllIIlIIl[11] = " : ";
    }
    
    private static String lIIIIIlIIIll(final String s, final String s2) {
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
    
    private static String lIIIIIlIIlIl(final String s, final String s2) {
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
    
    private static String lIIIIIlIIlII(String s, final String s2) {
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
    
    private static boolean lIIIIIllIlIl(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIIIIlllIIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIIIIlllllI(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIIIIlllIlI(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIIIIllllIl(final int n) {
        return n > 0;
    }
    
    private static int lIIIIIlllIII$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
    
    private static int lIIIIIllllII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
}
