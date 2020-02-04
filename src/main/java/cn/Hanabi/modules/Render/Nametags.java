package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.modules.Player.*;
import org.lwjgl.opengl.*;
import java.awt.*;
import net.minecraft.item.*;
import net.minecraft.client.gui.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.client.renderer.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Nametags extends Mod
{
    private Value<Boolean> invisible;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIlIllllIII;
    
    public Nametags() {
        super("Nametags", Category.RENDER);
        this.invisible = new Value<Boolean>("Nametags_Invisible", Boolean.FALSE);
    }
    
    @EventTarget
    private void onRender$1f20be12() {
        final int[] b = Class139.b();
        final Iterator iterator = Nametags.mc.field_71441_e.field_73010_i.iterator();
        final int[] array = b;
    Label_0978_Outer:
        while (iterator.hasNext()) {
            EntityPlayer entityPlayer3;
            final EntityPlayer entityPlayer2;
            final EntityPlayer entityPlayer = entityPlayer2 = (entityPlayer3 = iterator.next());
            Label_1113: {
                if (array == null) {
                    if (entityPlayer == Nametags.mc.field_71439_g) {
                        break Label_1113;
                    }
                    entityPlayer3 = entityPlayer2;
                }
                final double n = entityPlayer3.field_70142_S + (entityPlayer2.field_70165_t - entityPlayer2.field_70142_S) * Class94.getTimer().field_74281_c;
                Nametags.mc.func_175598_ae();
                final double n2 = n;
                final double n3 = entityPlayer2.field_70137_T + (entityPlayer2.field_70163_u - entityPlayer2.field_70137_T) * Class94.getTimer().field_74281_c;
                Nametags.mc.func_175598_ae();
                final double n4 = n3;
                final double n5 = entityPlayer2.field_70136_U + (entityPlayer2.field_70161_v - entityPlayer2.field_70136_U) * Class94.getTimer().field_74281_c;
                Nametags.mc.func_175598_ae();
                final double n6 = n5;
                final EntityPlayer entityPlayer4 = entityPlayer2;
                entityPlayer4.func_70005_c_();
                final double n7 = n2;
                final double n8 = n4;
                final double n9 = n6;
                final double n10 = n8;
                final double n11 = n7;
                final EntityPlayer entityPlayer5 = entityPlayer4;
                final int[] b2 = Class139.b();
                final boolean func_82150_aj = entityPlayer5.func_82150_aj();
                Label_0209: {
                    if (b2 == null) {
                        if (!func_82150_aj) {
                            break Label_0209;
                        }
                        this.invisible.value;
                    }
                    if (!func_82150_aj) {
                        break Label_1113;
                    }
                }
                final FontRenderer field_71466_p = Nametags.mc.field_71466_p;
                float n13;
                float n12 = n13 = Nametags.mc.field_71439_g.func_70032_d((Entity)entityPlayer5) / 6.0f;
                Label_0255: {
                    if (b2 == null) {
                        if (n12 >= 0.8f) {
                            break Label_0255;
                        }
                        n13 = 0.8f;
                    }
                    n12 = n13;
                }
                final double n14 = n10 + (entityPlayer5.func_70093_af() ? 0.5 : 0.7);
                final float n15 = n12 * 2.0f / 100.0f;
                final String func_150260_c = entityPlayer5.func_145748_c_().func_150260_c();
                String s = Nametags.lIlIllllIII[0];
                Label_0332: {
                    Label_0325: {
                        if (b2 == null) {
                            if (!AntiBot.isBot((Entity)entityPlayer5)) {
                                break Label_0325;
                            }
                            s = "§9[BOT]";
                        }
                        if (b2 == null) {
                            break Label_0332;
                        }
                    }
                    s = Nametags.lIlIllllIII[1];
                }
                String s2 = Nametags.lIlIllllIII[2];
                Label_0370: {
                    Label_0362: {
                        if (b2 == null) {
                            if (!Teams.isOnSameTeam((Entity)entityPlayer5)) {
                                break Label_0362;
                            }
                            s2 = "§b[TEAM]";
                        }
                        if (b2 == null) {
                            break Label_0370;
                        }
                    }
                    s2 = Nametags.lIlIllllIII[3];
                }
                Teams.isClientFriend((Entity)entityPlayer5);
                final String s3 = Nametags.lIlIllllIII[4];
                final String value = String.valueOf(new StringBuilder().append(s2).append(s));
                if (b2 == null) {
                    if (value.equals(Nametags.lIlIllllIII[5])) {
                        s2 = "§a";
                    }
                    String.valueOf(new StringBuilder().append(s2).append(s).append(func_150260_c).append(s3));
                }
                final String s4 = value;
                final String value2 = String.valueOf(new StringBuilder("§7HP:").append((int)entityPlayer5.func_110143_aJ()));
                GL11.glPushMatrix();
                GL11.glTranslatef((float)n11, (float)n14 + 1.4f, (float)n9);
                GL11.glNormal3f(0.0f, 1.0f, 0.0f);
                GL11.glRotatef(-Nametags.mc.func_175598_ae().field_78735_i, 0.0f, 1.0f, 0.0f);
                GL11.glRotatef(Nametags.mc.func_175598_ae().field_78732_j, 1.0f, 0.0f, 0.0f);
                GL11.glScalef(-n15, -n15, n15);
                Class300.setGLCap(2896, false);
                Class300.setGLCap(2929, false);
                final int n16 = Nametags.mc.field_71466_p.func_78256_a(s4) / 2;
                Class300.setGLCap(3042, true);
                GL11.glBlendFunc(770, 771);
                drawBorderedRectNameTag$10266f0b(-n16 - 2, -(Nametags.mc.field_71466_p.field_78288_b + 9), n16 + 2, Class23.reAlpha(Color.BLACK.getRGB(), 0.3f), Class23.reAlpha(Color.BLACK.getRGB(), 0.3f));
                GL11.glColor3f(1.0f, 1.0f, 1.0f);
                field_71466_p.func_78276_b(s4, -n16, -(Nametags.mc.field_71466_p.field_78288_b + 8), -1);
                field_71466_p.func_78276_b(value2, -Nametags.mc.field_71466_p.func_78256_a(value2) / 2, -(Nametags.mc.field_71466_p.field_78288_b - 2), -1);
                int rgb = new Color(188, 0, 0).getRGB();
                final float func_110143_aJ = entityPlayer5.func_110143_aJ();
                float func_110139_bj = 20.0f;
                if (b2 == null) {
                    if (func_110143_aJ > 20.0f) {
                        rgb = -65292;
                    }
                    entityPlayer5.func_110143_aJ();
                    func_110139_bj = entityPlayer5.func_110139_bj();
                }
                Class69.drawRect(n16 + (float)Math.ceil(func_110143_aJ + func_110139_bj) / (entityPlayer5.func_110138_aP() + entityPlayer5.func_110139_bj()) * n16 * 2.0f - n16 * 2 + 2.0f, 2.0f, -n16 - 2, 0.9f, rgb);
                GL11.glPushMatrix();
                int n17 = 0;
                final ItemStack[] field_70460_b;
                final int length = (field_70460_b = entityPlayer5.field_71071_by.field_70460_b).length;
                int i = 0;
                while (true) {
                    while (true) {
                        while (i < length) {
                            final ItemStack itemStack = field_70460_b[i];
                            if (b2 == null) {
                                final ItemStack itemStack2 = itemStack;
                                if (b2 != null) {
                                    if (itemStack2 != null) {
                                        n17 -= 8;
                                        final ItemStack func_77946_l = entityPlayer5.func_70694_bm().func_77946_l();
                                        if (b2 == null) {
                                            Label_0964: {
                                                if (func_77946_l.func_77962_s()) {
                                                    final ItemStack itemStack3 = func_77946_l;
                                                    Label_0960: {
                                                        if (b2 == null) {
                                                            if (!(itemStack3.func_77973_b() instanceof ItemTool)) {
                                                                final ItemStack itemStack4 = func_77946_l;
                                                                if (b2 != null) {
                                                                    break Label_0960;
                                                                }
                                                                if (!(itemStack4.func_77973_b() instanceof ItemArmor)) {
                                                                    break Label_0964;
                                                                }
                                                            }
                                                            final ItemStack itemStack5 = func_77946_l;
                                                        }
                                                    }
                                                    itemStack3.field_77994_a = 1;
                                                }
                                            }
                                            renderItemStack$42a030b7(func_77946_l, n17);
                                        }
                                        n17 += 20;
                                    }
                                    final EntityPlayer entityPlayer6;
                                    final ItemStack[] field_70460_b2;
                                    final int length2 = (field_70460_b2 = entityPlayer6.field_71071_by.field_70460_b).length;
                                    int j = 0;
                                    while (j < length2) {
                                        final ItemStack itemStack6 = field_70460_b2[j];
                                        if (b2 != null) {
                                            break Label_1113;
                                        }
                                        if (b2 == null) {
                                            if (itemStack6 != null) {
                                                final ItemStack func_77946_l2 = itemStack6.func_77946_l();
                                                if (b2 == null) {
                                                    Label_1080: {
                                                        if (func_77946_l2.func_77962_s()) {
                                                            final ItemStack itemStack7 = func_77946_l2;
                                                            if (b2 == null) {
                                                                if (!(itemStack7.func_77973_b() instanceof ItemTool)) {
                                                                    final ItemStack itemStack8 = func_77946_l2;
                                                                    if (b2 == null) {
                                                                        if (!(itemStack8.func_77973_b() instanceof ItemArmor)) {
                                                                            break Label_1080;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            itemStack7.field_77994_a = 1;
                                                        }
                                                    }
                                                    renderItemStack$42a030b7(func_77946_l2, n17);
                                                }
                                                n17 += 20;
                                            }
                                            ++j;
                                        }
                                        if (b2 != null) {
                                            break;
                                        }
                                    }
                                    GL11.glPopMatrix();
                                    Class300.revertAllCaps();
                                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                                    GL11.glPopMatrix();
                                    break Label_1113;
                                }
                                if (itemStack2 != null) {
                                    n17 -= 11;
                                }
                                ++i;
                            }
                            if (b2 != null) {
                                break;
                            }
                        }
                        final EntityPlayer entityPlayer6 = entityPlayer5;
                        if (b2 == null) {
                            entityPlayer6.func_70694_bm();
                            continue Label_0978_Outer;
                        }
                        break;
                    }
                    continue;
                }
            }
            if (array != null) {
                break;
            }
        }
    }
    
    private void renderNameTag$10d2cfaa(final EntityPlayer entityPlayer, final double n, double n2, final double n3) {
        final int[] b = Class139.b();
        final boolean func_82150_aj = entityPlayer.func_82150_aj();
        Label_0034: {
            if (b == null) {
                if (!func_82150_aj) {
                    break Label_0034;
                }
                this.invisible.value;
            }
            if (!func_82150_aj) {
                return;
            }
        }
        final FontRenderer field_71466_p = Nametags.mc.field_71466_p;
        float n5;
        float n4 = n5 = Nametags.mc.field_71439_g.func_70032_d((Entity)entityPlayer) / 6.0f;
        Label_0081: {
            if (b == null) {
                if (n4 >= 0.8f) {
                    break Label_0081;
                }
                n5 = 0.8f;
            }
            n4 = n5;
        }
        n2 += (entityPlayer.func_70093_af() ? 0.5 : 0.7);
        final float n6 = n4 * 2.0f / 100.0f;
        final String func_150260_c = entityPlayer.func_145748_c_().func_150260_c();
        String s = Nametags.lIlIllllIII[0];
        Label_0157: {
            Label_0150: {
                if (b == null) {
                    if (!AntiBot.isBot((Entity)entityPlayer)) {
                        break Label_0150;
                    }
                    s = "§9[BOT]";
                }
                if (b == null) {
                    break Label_0157;
                }
            }
            s = Nametags.lIlIllllIII[1];
        }
        String s2 = Nametags.lIlIllllIII[2];
        Label_0194: {
            Label_0186: {
                if (b == null) {
                    if (!Teams.isOnSameTeam((Entity)entityPlayer)) {
                        break Label_0186;
                    }
                    s2 = "§b[TEAM]";
                }
                if (b == null) {
                    break Label_0194;
                }
            }
            s2 = Nametags.lIlIllllIII[3];
        }
        Teams.isClientFriend((Entity)entityPlayer);
        final String s3 = Nametags.lIlIllllIII[4];
        final String value = String.valueOf(new StringBuilder().append(s2).append(s));
        if (b == null) {
            if (value.equals(Nametags.lIlIllllIII[5])) {
                s2 = "§a";
            }
            String.valueOf(new StringBuilder().append(s2).append(s).append(func_150260_c).append(s3));
        }
        final String s4 = value;
        final String value2 = String.valueOf(new StringBuilder("§7HP:").append((int)entityPlayer.func_110143_aJ()));
        GL11.glPushMatrix();
        GL11.glTranslatef((float)n, (float)n2 + 1.4f, (float)n3);
        GL11.glNormal3f(0.0f, 1.0f, 0.0f);
        GL11.glRotatef(-Nametags.mc.func_175598_ae().field_78735_i, 0.0f, 1.0f, 0.0f);
        GL11.glRotatef(Nametags.mc.func_175598_ae().field_78732_j, 1.0f, 0.0f, 0.0f);
        GL11.glScalef(-n6, -n6, n6);
        Class300.setGLCap(2896, false);
        Class300.setGLCap(2929, false);
        final int n7 = Nametags.mc.field_71466_p.func_78256_a(s4) / 2;
        Class300.setGLCap(3042, true);
        GL11.glBlendFunc(770, 771);
        drawBorderedRectNameTag$10266f0b(-n7 - 2, -(Nametags.mc.field_71466_p.field_78288_b + 9), n7 + 2, Class23.reAlpha(Color.BLACK.getRGB(), 0.3f), Class23.reAlpha(Color.BLACK.getRGB(), 0.3f));
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
        field_71466_p.func_78276_b(s4, -n7, -(Nametags.mc.field_71466_p.field_78288_b + 8), -1);
        field_71466_p.func_78276_b(value2, -Nametags.mc.field_71466_p.func_78256_a(value2) / 2, -(Nametags.mc.field_71466_p.field_78288_b - 2), -1);
        int rgb = new Color(188, 0, 0).getRGB();
        final float func_110143_aJ = entityPlayer.func_110143_aJ();
        float func_110139_bj = 20.0f;
        if (b == null) {
            if (func_110143_aJ > 20.0f) {
                rgb = -65292;
            }
            entityPlayer.func_110143_aJ();
            func_110139_bj = entityPlayer.func_110139_bj();
        }
        Class69.drawRect(n7 + (float)Math.ceil(func_110143_aJ + func_110139_bj) / (entityPlayer.func_110138_aP() + entityPlayer.func_110139_bj()) * n7 * 2.0f - n7 * 2 + 2.0f, 2.0f, -n7 - 2, 0.9f, rgb);
        GL11.glPushMatrix();
        int n8 = 0;
        final ItemStack[] field_70460_b;
        final int length = (field_70460_b = entityPlayer.field_71071_by.field_70460_b).length;
        int i = 0;
        while (true) {
            while (true) {
                while (i < length) {
                    final ItemStack itemStack = field_70460_b[i];
                    if (b == null) {
                        final ItemStack itemStack2 = itemStack;
                        if (b != null) {
                            if (itemStack2 != null) {
                                n8 -= 8;
                                final ItemStack func_77946_l = entityPlayer.func_70694_bm().func_77946_l();
                                if (b == null) {
                                    Label_0766: {
                                        if (func_77946_l.func_77962_s()) {
                                            final ItemStack itemStack3 = func_77946_l;
                                            Label_0762: {
                                                if (b == null) {
                                                    if (!(itemStack3.func_77973_b() instanceof ItemTool)) {
                                                        final ItemStack itemStack4 = func_77946_l;
                                                        if (b != null) {
                                                            break Label_0762;
                                                        }
                                                        if (!(itemStack4.func_77973_b() instanceof ItemArmor)) {
                                                            break Label_0766;
                                                        }
                                                    }
                                                    final ItemStack itemStack5 = func_77946_l;
                                                }
                                            }
                                            itemStack3.field_77994_a = 1;
                                        }
                                    }
                                    renderItemStack$42a030b7(func_77946_l, n8);
                                }
                                n8 += 20;
                            }
                            final EntityPlayer entityPlayer2 = entityPlayer;
                            final ItemStack[] field_70460_b2;
                            final int length2 = (field_70460_b2 = entityPlayer2.field_71071_by.field_70460_b).length;
                            int j = 0;
                            while (j < length2) {
                                final ItemStack itemStack6 = field_70460_b2[j];
                                if (b != null) {
                                    return;
                                }
                                if (b == null) {
                                    if (itemStack6 != null) {
                                        final ItemStack func_77946_l2 = itemStack6.func_77946_l();
                                        if (b == null) {
                                            Label_0872: {
                                                if (func_77946_l2.func_77962_s()) {
                                                    final ItemStack itemStack7 = func_77946_l2;
                                                    if (b == null) {
                                                        if (!(itemStack7.func_77973_b() instanceof ItemTool)) {
                                                            final ItemStack itemStack8 = func_77946_l2;
                                                            if (b == null) {
                                                                if (!(itemStack8.func_77973_b() instanceof ItemArmor)) {
                                                                    break Label_0872;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    itemStack7.field_77994_a = 1;
                                                }
                                            }
                                            renderItemStack$42a030b7(func_77946_l2, n8);
                                        }
                                        n8 += 20;
                                    }
                                    ++j;
                                }
                                if (b != null) {
                                    break;
                                }
                            }
                            GL11.glPopMatrix();
                            Class300.revertAllCaps();
                            GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                            GL11.glPopMatrix();
                            return;
                        }
                        if (itemStack2 != null) {
                            n8 -= 11;
                        }
                        ++i;
                    }
                    if (b != null) {
                        break;
                    }
                }
                final EntityPlayer entityPlayer2 = entityPlayer;
                if (b == null) {
                    entityPlayer.func_70694_bm();
                    continue;
                }
                break;
            }
            continue;
        }
    }
    
    private static void renderItemStack$42a030b7(final ItemStack itemStack, final int n) {
        GL11.glPushMatrix();
        GL11.glDepthMask(true);
        GlStateManager.func_179086_m(256);
        RenderHelper.func_74519_b();
        Nametags.mc.func_175599_af().field_77023_b = -150.0f;
        GlStateManager.func_179140_f();
        GlStateManager.func_179097_i();
        GlStateManager.func_179084_k();
        GlStateManager.func_179145_e();
        GlStateManager.func_179126_j();
        GlStateManager.func_179140_f();
        GlStateManager.func_179097_i();
        GlStateManager.func_179090_x();
        GlStateManager.func_179118_c();
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179141_d();
        GlStateManager.func_179098_w();
        GlStateManager.func_179145_e();
        GlStateManager.func_179126_j();
        Nametags.mc.func_175599_af().func_180450_b(itemStack, n, -35);
        Nametags.mc.func_175599_af().func_175030_a(Nametags.mc.field_71466_p, itemStack, n, -35);
        Nametags.mc.func_175599_af().field_77023_b = 0.0f;
        RenderHelper.func_74518_a();
        GlStateManager.func_179129_p();
        GlStateManager.func_179141_d();
        GlStateManager.func_179084_k();
        GlStateManager.func_179140_f();
        GlStateManager.func_179139_a(0.5, 0.5, 0.5);
        GlStateManager.func_179097_i();
        GlStateManager.func_179126_j();
        GlStateManager.func_179152_a(2.0f, 2.0f, 2.0f);
        GL11.glPopMatrix();
    }
    
    private static void whatTheFuckOpenGLThisFixesItemGlint() {
        GlStateManager.func_179140_f();
        GlStateManager.func_179097_i();
        GlStateManager.func_179084_k();
        GlStateManager.func_179145_e();
        GlStateManager.func_179126_j();
        GlStateManager.func_179140_f();
        GlStateManager.func_179097_i();
        GlStateManager.func_179090_x();
        GlStateManager.func_179118_c();
        GlStateManager.func_179084_k();
        GlStateManager.func_179147_l();
        GlStateManager.func_179141_d();
        GlStateManager.func_179098_w();
        GlStateManager.func_179145_e();
        GlStateManager.func_179126_j();
    }
    
    private static void drawBorderedRectNameTag$10266f0b(final float n, final float n2, final float n3, final int n4, final int n5) {
        Class69.drawRect(n, n2, n3, 2.0f, n5);
        final float n6 = (n4 >> 24 & 0xFF) / 255.0f;
        final float n7 = (n4 >> 16 & 0xFF) / 255.0f;
        final float n8 = (n4 >> 8 & 0xFF) / 255.0f;
        final float n9 = (n4 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(n7, n8, n9, n6);
        GL11.glLineWidth(1.0f);
        GL11.glBegin(1);
        GL11.glVertex2d((double)n, (double)n2);
        GL11.glVertex2d((double)n, 2.0);
        GL11.glVertex2d((double)n3, 2.0);
        GL11.glVertex2d((double)n3, (double)n2);
        GL11.glVertex2d((double)n, (double)n2);
        GL11.glVertex2d((double)n3, (double)n2);
        GL11.glVertex2d((double)n, 2.0);
        GL11.glVertex2d((double)n3, 2.0);
        GL11.glEnd();
        GL11.glPopMatrix();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
    }
    
    static {
        llllIlIlllII();
        Class169.a(-3256812080731765026L, 1520379720639097395L, MethodHandles.lookup().lookupClass()).a(276189425709483L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Nametags.lIlIllllIII[6]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Nametags.lIlIllllIII[7]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(114991396266352L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[7];
        int n2 = 0;
        String s;
        int n3 = (s = Nametags.lIlIllllIII[8]).length();
        int n4 = 16;
        int n5 = -1;
    Label_0152:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s3.getBytes(Nametags.lIlIllllIII[10]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Nametags.lIlIllllIII[9]).length();
                            n4 = 40;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0152;
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
        d = new String[7];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x4704;
        if (Nametags.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Nametags.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Nametags.lIlIllllIII[11]);
                    array[1] = SecretKeyFactory.getInstance(Nametags.lIlIllllIII[12]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Nametags.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Nametags.lIlIllllIII[13], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Nametags.d[n3] = b(((Cipher)array[0]).doFinal(Nametags.c[n3].getBytes(Nametags.lIlIllllIII[14])));
        }
        return Nametags.d[n3];
    }
    
    private static void llllIlIlllII() {
        (lIlIllllIII = new String[18])[0] = "";
        Nametags.lIlIllllIII[1] = "";
        Nametags.lIlIllllIII[2] = "";
        Nametags.lIlIllllIII[3] = "";
        Nametags.lIlIllllIII[4] = "";
        Nametags.lIlIllllIII[5] = "";
        Nametags.lIlIllllIII[6] = "DES/CBC/PKCS5Padding";
        Nametags.lIlIllllIII[7] = "DES";
        Nametags.lIlIllllIII[8] = "\u0016Âà>\u0081]e\"üý¥w×h\u0006\u0002\u0010o\u0092@è\u0093\u0005îò\n\u0007mÉ\u0095ôÈT \u0091ä@eÝ>ãz°j7ñEBZ?]âäîM*S±æ¸0Ø\u001dj~¾ ÉÔïRcOú!\u0003SF\u0002ÒeÊ§\u0081\u000fr«®cº¹\u008aïlÉfrkm ÖþPß\u0006Z*ÅòÑUi\u0017É\n\u0091~\n*\u0005MH²ö\u008e!Í\u0016vCç\u0080";
        Nametags.lIlIllllIII[9] = "\u0016Uh\u0098\u00ad}É°k?%u\u008b®ÎÖbsÒeÛ\"\u009f8âá¦è×©Ì¯è(eV\u0001\u0087\u0007\u0001 ·JûlS\u009aÔ]-ÊâU¬Æ¯Êf\u000f\u001dOk_ýNò5B3\u0098¿\u009d\u009f";
        Nametags.lIlIllllIII[10] = "ISO-8859-1";
        Nametags.lIlIllllIII[11] = "DES/CBC/PKCS5Padding";
        Nametags.lIlIllllIII[12] = "DES";
        Nametags.lIlIllllIII[13] = "看着你现在的词语逻辑混乱不堪你不觉得害臊吗自以为天塌不败的速度其实你根本不敢回击我的是吗你那些低俗的语言让你爹爹我埋汰千百次了呵呵草你妈的行不行啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f \u2001\u2003";
        Nametags.lIlIllllIII[14] = "ISO-8859-1";
        Nametags.lIlIllllIII[15] = "看着你现在的词语逻辑混乱不堪你不觉得害臊吗自以为天塌不败的速度其实你根本不敢回击我的是吗你那些低俗的语言让你爹爹我埋汰千百次了呵呵草你妈的行不行啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f \u2001\u2003";
        Nametags.lIlIllllIII[16] = " : ";
        Nametags.lIlIllllIII[17] = " : ";
    }
    
    private static String llllIlIlIlII(String s, final String s2) {
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
    
    private static String llllIlIlIllI(final String s, final String s2) {
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
    
    private static String llllIlIlIlIl(final String s, final String s2) {
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
    
    private static boolean llllIllIlIIl(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean llllIllIllll(final int n) {
        return n < 0;
    }
    
    private static boolean llllIlllIIII(final int n) {
        return n > 0;
    }
    
    private static int llllIllIllIl$2548a28(final float n) {
        return fcmpl(n, 20.0f);
    }
    
    private static int llllIllIllII$2548a28(final float n) {
        return fcmpg(n, 0.8f);
    }
}
