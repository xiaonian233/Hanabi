package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.entity.*;
import net.minecraft.entity.player.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.client.gui.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.modules.Player.*;
import net.minecraft.enchantment.*;
import net.minecraft.item.*;
import java.awt.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.*;
import org.lwjgl.util.glu.*;
import org.lwjgl.opengl.*;
import java.nio.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Nametags_ extends Mod
{
    private static Map<EntityLivingBase, double[]> entityPositions;
    private Value<Boolean> invis;
    private Value<Boolean> armor;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llIIllIlI;
    
    public Nametags_() {
        super("Nametags", Category.RENDER);
        this.invis = new Value<Boolean>("Nametags_Invisible", Boolean.FALSE);
        this.armor = new Value<Boolean>("Nametags_Armor", Boolean.FALSE);
    }
    
    @EventTarget
    private void update$1f20be12() {
        try {
            Nametags_.entityPositions.clear();
            final int[] b = Class139.b();
            final float field_74281_c = Class94.getTimer().field_74281_c;
            final int[] array = b;
            for (Entity entity3 : Nametags_.mc.field_71441_e.field_72996_f) {
                final Entity entity2;
                final Entity entity = entity2 = entity3;
                Label_0382: {
                    if (array == null) {
                        if (!lIIlIIlIIII(entity, Nametags_.mc.field_71439_g)) {
                            break Label_0382;
                        }
                        entity3 = entity2;
                    }
                    final boolean b2 = entity3 instanceof EntityPlayer;
                    final Entity entity4;
                    Label_0118: {
                        if (array == null) {
                            if (!b2) {
                                break Label_0382;
                            }
                            entity4 = entity2;
                            if (array != null) {
                                break Label_0118;
                            }
                            entity4.func_82150_aj();
                        }
                        if (b2 && this.invis.value) {
                            break Label_0382;
                        }
                    }
                    final double n = entity4.field_70142_S + (entity2.field_70165_t - entity2.field_70142_S) * field_74281_c - Nametags_.mc.func_175598_ae().field_78730_l;
                    final double n2 = entity2.field_70137_T + (entity2.field_70163_u - entity2.field_70137_T) * field_74281_c - Nametags_.mc.func_175598_ae().field_78731_m;
                    final double n3 = entity2.field_70136_U + (entity2.field_70161_v - entity2.field_70136_U) * field_74281_c - Nametags_.mc.func_175598_ae().field_78728_n;
                    final double n4 = n2 + (entity2.field_70131_O + 0.2);
                    final double n5 = dcmpl(convertTo2D(n, n4, n3)[2], 0.0);
                    if (array == null) {
                        if (n5 < 0) {
                            break Label_0382;
                        }
                        final double[] convertTo2D = convertTo2D(n, n4, n3);
                        if (array != null) {
                            break Label_0382;
                        }
                        final double n6 = dcmpg(convertTo2D[2], 1.0);
                    }
                    if (n5 < 0) {
                        Nametags_.entityPositions.put((EntityLivingBase)entity2, new double[] { convertTo2D(n, n4, n3)[0], convertTo2D(n, n4, n3)[1], Math.abs(convertTo2D(n, n4 + 1.0, n3, entity2)[1] - convertTo2D(n, n4, n3, entity2)[1]), convertTo2D(n, n4, n3)[2] });
                    }
                }
                if (array != null) {
                    break;
                }
            }
        }
        catch (Exception ex) {}
    }
    
    @EventTarget
    private void onRender2D$26896c00() {
        GlStateManager.func_179094_E();
        final int[] b = Class139.b();
        final ScaledResolution scaledResolution = new ScaledResolution(Nametags_.mc);
        final Iterator<EntityLivingBase> iterator = Nametags_.entityPositions.keySet().iterator();
        final int[] array = b;
    Label_0032:
        while (iterator.hasNext()) {
            EntityLivingBase next = iterator.next();
            Label_1649: {
            Label_1646:
                while (true) {
                    final Entity entity = (Entity)next;
                    if (array == null) {
                        Object value;
                        final Entity entity2 = (Entity)(value = entity);
                        if (array == null) {
                            if (!lIIlIIlIIII(entity2, Nametags_.mc.field_71439_g)) {
                                break Label_1649;
                            }
                            value = this.invis.value;
                        }
                        final boolean booleanValue = (boolean)value;
                        Object value2 = null;
                        Label_0131: {
                            Label_0118: {
                                if (array == null) {
                                    if (!booleanValue) {
                                        final boolean func_82150_aj = entity.func_82150_aj();
                                        if (array != null) {
                                            break Label_0118;
                                        }
                                        if (func_82150_aj) {
                                            break Label_1649;
                                        }
                                    }
                                    GlStateManager.func_179094_E();
                                    final Entity entity3 = (Entity)(value2 = entity);
                                    if (array != null) {
                                        break Label_0131;
                                    }
                                    final boolean b2 = entity3 instanceof EntityPlayer;
                                }
                            }
                            if (!booleanValue) {
                                break;
                            }
                            value2 = Nametags_.entityPositions.get(entity);
                        }
                        final double[] array2 = (double[])value2;
                        Label_0183: {
                            if (array == null) {
                                if (array2[3] >= 0.0 && array2[3] < 1.0) {
                                    break Label_0183;
                                }
                                GlStateManager.func_179121_F();
                            }
                            if (array == null) {
                                continue Label_0032;
                            }
                        }
                        final UnicodeFontRenderer wqy18 = Class139.INSTANCE.fontManager.wqy18;
                        GlStateManager.func_179137_b(array2[0] / scaledResolution.func_78325_e(), array2[1] / scaledResolution.func_78325_e(), 0.0);
                        final float n = 1.0f * (Nametags_.mc.field_71474_y.field_74326_T ? 2.0f : 1.0f);
                        GlStateManager.func_179152_a(n, n, n);
                        GlStateManager.func_179137_b(0.0, -2.5, 0.0);
                        final String value3 = String.valueOf(new StringBuilder("Health: ").append(String.valueOf(Math.round(((EntityLivingBase)entity).func_110143_aJ() * 10.0f) / 10)));
                        String s = String.valueOf(new StringBuilder().append(AntiBot.isBot(entity) ? "§9[BOT]" : Nametags_.llIIllIlI[0]).append(Teams.isOnSameTeam(entity) ? "§b[TEAM]" : Nametags_.llIIllIlI[1]).append("§r").append(entity.func_145748_c_().func_150260_c()));
                        String s2 = Nametags_.llIIllIlI[2];
                        while (true) {
                            for (final String s3 : Class206.ignMap.keySet()) {
                                final String func_70005_c_ = entity.func_70005_c_();
                                Label_0460: {
                                    if (array == null) {
                                        final int n3;
                                        final int n2 = n3 = (func_70005_c_.equalsIgnoreCase(s3) ? 1 : 0);
                                        if (array == null) {
                                            if (n2 == 0) {
                                                break Label_0460;
                                            }
                                            String.valueOf(new StringBuilder("§e[").append(Class206.ignMap.get(s3)).append(Nametags_.llIIllIlI[3]));
                                        }
                                        else {
                                            final float n4 = n3;
                                            final float n5 = Class139.INSTANCE.fontManager.comfortaa12.func_78256_a(value3);
                                            final float n6 = n4;
                                            if (array == null && n6 <= n5) {}
                                            final float n7;
                                            Class69.drawRect(-(n7 = n6 + 8.0f) / 2.0f, -25.0f, n7 / 2.0f, 0.0f, Class22.getColor$255f288());
                                            scaledResolution.func_78328_b();
                                            scaledResolution.func_78326_a();
                                            wqy18.drawStringWithColor(s, -n7 / 2.0f + 4.0f, -22.0f, Class22.WHITE.c);
                                            Class139.INSTANCE.fontManager.comfortaa12.drawString(value3, -n7 / 2.0f + 4.0f, -10.0f, Class22.WHITE.c);
                                            final EntityLivingBase entityLivingBase;
                                            Class69.drawRect(-n7 / 2.0f, -1.0f, n7 / 2.0f - n7 / 2.0f * (1.0f - (float)Math.ceil((entityLivingBase = (EntityLivingBase)entity).func_110143_aJ() + entityLivingBase.func_110139_bj()) / (entityLivingBase.func_110138_aP() + entityLivingBase.func_110139_bj())) * 2.0f, 0.0f, Class22.RED.c);
                                            if (this.armor.value) {
                                                final ArrayList<ItemStack> list = new ArrayList<ItemStack>();
                                                int i = 0;
                                                while (i < 5) {
                                                    final ItemStack func_71124_b = ((EntityPlayer)entity).func_71124_b(i);
                                                    if (array == null) {
                                                        final Entity entity4 = (Entity)(next = (EntityLivingBase)func_71124_b);
                                                        if (array != null) {
                                                            continue Label_1649;
                                                        }
                                                        if (entity4 != null) {
                                                            list.add(func_71124_b);
                                                        }
                                                        ++i;
                                                    }
                                                    if (array != null) {
                                                        break;
                                                    }
                                                }
                                                int n8 = -(list.size() * 9);
                                                for (final ItemStack itemStack : list) {
                                                    RenderHelper.func_74520_c();
                                                    Nametags_.mc.func_175599_af().func_175042_a(itemStack, n8 + 6, -42);
                                                    Nametags_.mc.func_175599_af().func_175030_a(Nametags_.mc.field_71466_p, itemStack, n8, -42);
                                                    n8 += 3;
                                                    RenderHelper.func_74518_a();
                                                    final Entity entity5 = (Entity)(next = (EntityLivingBase)itemStack);
                                                    if (array != null) {
                                                        continue Label_1649;
                                                    }
                                                    if (entity5 != null) {
                                                        int n9 = 21;
                                                        final int func_77506_a = EnchantmentHelper.func_77506_a(Enchantment.field_180314_l.field_77352_x, itemStack);
                                                        final int func_77506_a2 = EnchantmentHelper.func_77506_a(Enchantment.field_77334_n.field_77352_x, itemStack);
                                                        final int func_77506_a3 = EnchantmentHelper.func_77506_a(Enchantment.field_180313_o.field_77352_x, itemStack);
                                                        boolean b3;
                                                        int n12;
                                                        int n11;
                                                        final int n10 = n11 = (n12 = ((b3 = (func_77506_a != 0)) ? 1 : 0));
                                                        if (array == null) {
                                                            if (n10 > 0) {
                                                                drawEnchantTag(String.valueOf(new StringBuilder("Sh").append(getColor(func_77506_a)).append(func_77506_a)), n8, 21);
                                                                n9 += 6;
                                                            }
                                                            final boolean b4;
                                                            n11 = ((b4 = ((n12 = ((b3 = (func_77506_a2 != 0)) ? 1 : 0)) != 0)) ? 1 : 0);
                                                        }
                                                        if (array == null) {
                                                            if (n10 > 0) {
                                                                drawEnchantTag(String.valueOf(new StringBuilder("Fir").append(getColor(func_77506_a2)).append(func_77506_a2)), n8, n9);
                                                                n9 += 6;
                                                            }
                                                            n12 = (n11 = ((b3 = (func_77506_a3 != 0)) ? 1 : 0));
                                                        }
                                                        Label_1545: {
                                                            if (array == null) {
                                                                if (n11 > 0) {
                                                                    drawEnchantTag(String.valueOf(new StringBuilder("Kb").append(getColor(func_77506_a3)).append(func_77506_a3)), n8, n9);
                                                                    if (array == null) {
                                                                        break Label_1545;
                                                                    }
                                                                }
                                                                b3 = ((n12 = ((itemStack.func_77973_b() instanceof ItemArmor) ? 1 : 0)) != 0);
                                                            }
                                                            final ItemStack itemStack2;
                                                            Label_1516: {
                                                                if (array == null) {
                                                                    if (n12 != 0) {
                                                                        final int func_77506_a4 = EnchantmentHelper.func_77506_a(Enchantment.field_180310_c.field_77352_x, itemStack);
                                                                        final int func_77506_a5 = EnchantmentHelper.func_77506_a(Enchantment.field_92091_k.field_77352_x, itemStack);
                                                                        final int func_77506_a6 = EnchantmentHelper.func_77506_a(Enchantment.field_77347_r.field_77352_x, itemStack);
                                                                        int n14;
                                                                        final int n13 = n14 = func_77506_a4;
                                                                        if (array == null) {
                                                                            if (n13 > 0) {
                                                                                drawEnchantTag(String.valueOf(new StringBuilder().append(Nametags_.llIIllIlI[5]).append(getColor(func_77506_a4)).append(func_77506_a4)), n8, n9);
                                                                                n9 += 6;
                                                                            }
                                                                            final int n15;
                                                                            n14 = (n15 = func_77506_a5);
                                                                        }
                                                                        if (array == null) {
                                                                            if (n13 > 0) {
                                                                                drawEnchantTag(String.valueOf(new StringBuilder("Th").append(getColor(func_77506_a5)).append(func_77506_a5)), n8, n9);
                                                                                n9 += 6;
                                                                            }
                                                                            n14 = func_77506_a6;
                                                                        }
                                                                        if (n14 > 0) {
                                                                            drawEnchantTag(String.valueOf(new StringBuilder("Unb").append(getColor(func_77506_a6)).append(func_77506_a6)), n8, n9);
                                                                        }
                                                                        if (array == null) {
                                                                            break Label_1545;
                                                                        }
                                                                    }
                                                                    itemStack2 = itemStack;
                                                                    if (array != null) {
                                                                        break Label_1516;
                                                                    }
                                                                    b3 = (itemStack2.func_77973_b() instanceof ItemBow);
                                                                }
                                                                if (b3) {
                                                                    final int func_77506_a7 = EnchantmentHelper.func_77506_a(Enchantment.field_77345_t.field_77352_x, itemStack);
                                                                    final int func_77506_a8 = EnchantmentHelper.func_77506_a(Enchantment.field_77344_u.field_77352_x, itemStack);
                                                                    final int func_77506_a9 = EnchantmentHelper.func_77506_a(Enchantment.field_77343_v.field_77352_x, itemStack);
                                                                    int n17;
                                                                    final int n16 = n17 = func_77506_a7;
                                                                    if (array == null) {
                                                                        if (n16 > 0) {
                                                                            drawEnchantTag(String.valueOf(new StringBuilder("Pow").append(getColor(func_77506_a7)).append(func_77506_a7)), n8, n9);
                                                                            n9 += 6;
                                                                        }
                                                                        final int n18;
                                                                        n17 = (n18 = func_77506_a8);
                                                                    }
                                                                    if (array == null) {
                                                                        if (n16 > 0) {
                                                                            drawEnchantTag(String.valueOf(new StringBuilder("Pun").append(getColor(func_77506_a8)).append(func_77506_a8)), n8, n9);
                                                                            n9 += 6;
                                                                        }
                                                                        n17 = func_77506_a9;
                                                                    }
                                                                    if (n17 > 0) {
                                                                        drawEnchantTag(String.valueOf(new StringBuilder("Fir").append(getColor(func_77506_a9)).append(func_77506_a9)), n8, n9);
                                                                    }
                                                                    if (array == null) {
                                                                        break Label_1545;
                                                                    }
                                                                }
                                                            }
                                                            if (itemStack2.func_77953_t() == EnumRarity.EPIC) {
                                                                drawEnchantTag("§6§lGod", n8 - 2, n9);
                                                            }
                                                        }
                                                        final int n19 = (int)Math.round(255.0 - itemStack.func_77952_i() * 255.0 / itemStack.func_77958_k());
                                                        new Color(255 - n19 << 16 | n19 << 8).brighter();
                                                        Label_1639: {
                                                            if (array == null) {
                                                                if (itemStack.func_77958_k() - itemStack.func_77952_i() <= 0) {
                                                                    break Label_1639;
                                                                }
                                                                GlStateManager.func_179094_E();
                                                                GlStateManager.func_179097_i();
                                                                GlStateManager.func_179126_j();
                                                            }
                                                            GlStateManager.func_179121_F();
                                                        }
                                                        n8 += 12;
                                                    }
                                                    if (array != null) {
                                                        break;
                                                    }
                                                }
                                                break Label_1646;
                                            }
                                            break Label_1646;
                                        }
                                    }
                                    s2 = func_70005_c_;
                                }
                                if (array != null) {
                                    break;
                                }
                            }
                            s = String.valueOf(new StringBuilder().append(s).append(s2));
                            int n3 = wqy18.func_78256_a(s.replaceAll("§.", Nametags_.llIIllIlI[4]));
                            continue;
                        }
                    }
                    return;
                }
                GlStateManager.func_179121_F();
            }
            if (array != null) {
                break;
            }
        }
        GlStateManager.func_179121_F();
    }
    
    private static void drawEnchantTag(final String s, int n, int n2) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179097_i();
        n *= (int)1.05;
        n2 -= 6;
        Class139.INSTANCE.fontManager.comfortaa10.drawStringWithColor(s, n + 9, -30 - n2, Class22.getColor$134621());
        GlStateManager.func_179126_j();
        GlStateManager.func_179121_F();
    }
    
    private static String getColor(final int n) {
        final int[] b = Class139.b();
        int n2 = n;
        int n3 = n;
        int n4 = n;
        int n5 = n;
        int n9;
        int n8;
        int n7;
        final int n6 = n7 = (n8 = (n9 = 1));
        if (b == null) {
            if (n == n6) {
                return "§f";
            }
            n2 = n;
            n3 = n;
            n4 = n;
            n5 = n;
            final int n10;
            n7 = (n10 = (n8 = (n9 = 2)));
        }
        if (b == null) {
            if (n5 == n6) {
                return "§a";
            }
            n2 = n;
            n3 = n;
            n4 = n;
            n8 = (n7 = (n9 = 3));
        }
        if (b == null) {
            if (n4 == n7) {
                return "§3";
            }
            n2 = n;
            n3 = n;
            n9 = (n8 = 4);
        }
        if (b == null) {
            if (n3 == n8) {
                return "§4";
            }
            n2 = n;
            n9 = 5;
        }
        if (n2 >= n9) {
            return "§6";
        }
        return "§f";
    }
    
    private static void scale() {
        final float n = 1.0f * (Nametags_.mc.field_71474_y.field_74326_T ? 2.0f : 1.0f);
        GlStateManager.func_179152_a(n, n, n);
    }
    
    private void updatePositions() {
        Nametags_.entityPositions.clear();
        final int[] b = Class139.b();
        final float field_74281_c = Class94.getTimer().field_74281_c;
        final int[] array = b;
        for (Entity entity3 : Nametags_.mc.field_71441_e.field_72996_f) {
            final Entity entity2;
            final Entity entity = entity2 = entity3;
            Label_0377: {
                if (array == null) {
                    if (!lIIlIIlIIII(entity, Nametags_.mc.field_71439_g)) {
                        break Label_0377;
                    }
                    entity3 = entity2;
                }
                final boolean b2 = entity3 instanceof EntityPlayer;
                final Entity entity4;
                Label_0113: {
                    if (array == null) {
                        if (!b2) {
                            break Label_0377;
                        }
                        entity4 = entity2;
                        if (array != null) {
                            break Label_0113;
                        }
                        entity4.func_82150_aj();
                    }
                    if (b2 && this.invis.value) {
                        break Label_0377;
                    }
                }
                final double n = entity4.field_70142_S + (entity2.field_70165_t - entity2.field_70142_S) * field_74281_c - Nametags_.mc.func_175598_ae().field_78730_l;
                final double n2 = entity2.field_70137_T + (entity2.field_70163_u - entity2.field_70137_T) * field_74281_c - Nametags_.mc.func_175598_ae().field_78731_m;
                final double n3 = entity2.field_70136_U + (entity2.field_70161_v - entity2.field_70136_U) * field_74281_c - Nametags_.mc.func_175598_ae().field_78728_n;
                final double n4 = n2 + (entity2.field_70131_O + 0.2);
                final double n5 = dcmpl(convertTo2D(n, n4, n3)[2], 0.0);
                if (array == null) {
                    if (n5 < 0) {
                        break Label_0377;
                    }
                    final double[] convertTo2D = convertTo2D(n, n4, n3);
                    if (array != null) {
                        break Label_0377;
                    }
                    final double n6 = dcmpg(convertTo2D[2], 1.0);
                }
                if (n5 < 0) {
                    Nametags_.entityPositions.put((EntityLivingBase)entity2, new double[] { convertTo2D(n, n4, n3)[0], convertTo2D(n, n4, n3)[1], Math.abs(convertTo2D(n, n4 + 1.0, n3, entity2)[1] - convertTo2D(n, n4, n3, entity2)[1]), convertTo2D(n, n4, n3)[2] });
                }
            }
            if (array != null) {
                break;
            }
        }
    }
    
    private static double[] convertTo2D(final double n, final double n2, final double n3, final Entity entity) {
        final float field_74281_c = Class94.getTimer().field_74281_c;
        final float field_70177_z = Nametags_.mc.field_71439_g.field_70177_z;
        final float field_70126_B = Nametags_.mc.field_71439_g.field_70126_B;
        final float[] rotationFromPosition = Class252.getRotationFromPosition(entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * field_74281_c, entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * field_74281_c, entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * field_74281_c - 1.6);
        final Entity func_175606_aa = Nametags_.mc.func_175606_aa();
        final Entity func_175606_aa2 = Nametags_.mc.func_175606_aa();
        final float n4 = rotationFromPosition[0];
        func_175606_aa2.field_70126_B = n4;
        func_175606_aa.field_70177_z = n4;
        final EntityRenderer field_71460_t = Minecraft.func_71410_x().field_71460_t;
        final double[] convertTo2D = convertTo2D(n, n2, n3);
        Nametags_.mc.func_175606_aa().field_70177_z = field_70177_z;
        Nametags_.mc.func_175606_aa().field_70126_B = field_70126_B;
        final EntityRenderer field_71460_t2 = Minecraft.func_71410_x().field_71460_t;
        return convertTo2D;
    }
    
    private static double[] convertTo2D(final double n, final double n2, final double n3) {
        final FloatBuffer floatBuffer = BufferUtils.createFloatBuffer(3);
        final IntBuffer intBuffer = BufferUtils.createIntBuffer(16);
        final FloatBuffer floatBuffer2 = BufferUtils.createFloatBuffer(16);
        final FloatBuffer floatBuffer3 = BufferUtils.createFloatBuffer(16);
        final int[] b = Class139.b();
        GL11.glGetFloat(2982, floatBuffer2);
        GL11.glGetFloat(2983, floatBuffer3);
        GL11.glGetInteger(2978, intBuffer);
        final int gluProject = GLU.gluProject((float)n, (float)n2, (float)n3, floatBuffer2, floatBuffer3, intBuffer, floatBuffer) ? 1 : 0;
        final int[] array = b;
        final int n4 = gluProject;
        if (array == null && n4 == 0) {
            return null;
        }
        final double[] array2 = new double[n4];
        array2[0] = floatBuffer.get(0);
        array2[1] = Display.getHeight() - floatBuffer.get(1);
        array2[2] = floatBuffer.get(2);
        return array2;
    }
    
    static {
        lIIlIIIlIII();
        Class169.a(-943821044621590904L, 9050189058478319021L, MethodHandles.lookup().lookupClass()).a(1589210182651L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Nametags_.llIIllIlI[6]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Nametags_.llIIllIlI[7]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(71563781942696L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[23];
        int n2 = 0;
        String s;
        int n3 = (s = Nametags_.llIIllIlI[8]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(Nametags_.llIIllIlI[10]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Nametags_.llIIllIlI[9]).length();
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
        d = new String[23];
        Nametags_.entityPositions = new HashMap<EntityLivingBase, double[]>();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x792D;
        if (Nametags_.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Nametags_.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Nametags_.llIIllIlI[11]);
                    array[1] = SecretKeyFactory.getInstance(Nametags_.llIIllIlI[12]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Nametags_.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Nametags_.llIIllIlI[13], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Nametags_.d[n3] = b(((Cipher)array[0]).doFinal(Nametags_.c[n3].getBytes(Nametags_.llIIllIlI[14])));
        }
        return Nametags_.d[n3];
    }
    
    private static void lIIlIIIlIII() {
        (llIIllIlI = new String[18])[0] = "";
        Nametags_.llIIllIlI[1] = "";
        Nametags_.llIIllIlI[2] = "";
        Nametags_.llIIllIlI[3] = "]";
        Nametags_.llIIllIlI[4] = "";
        Nametags_.llIIllIlI[5] = "P";
        Nametags_.llIIllIlI[6] = "DES/CBC/PKCS5Padding";
        Nametags_.llIIllIlI[7] = "DES";
        Nametags_.llIIllIlI[8] = "ÏGê9:ºÅ\u0014\u0089pXùÊ\u001e-\u000b\u0010t³í/}\u0006+\u0017Ý©äbù·Ù\u0014\u0010áLLÒô\u000e¨Q&ãñ\u008c\u0084L\u0012\u0097\u0018bXXÁ\u0083àd,»\u0004\u009cúÇ\u0093ä¦(k)xØ\u008b\\{\u0010\u0096\u001bà}\u0096¶¥ó$Áÿà\u001b_¯l\u0010APv%\nÒcT¼!ÅJ\u0082\u0012\u008e\u009b }\u0019\u000bøk§ßJír/M\u0011V@B\u0011»ß³(çQ\u008eþ+»\u000f6uxø\u0010\u0092¢ê]Ý1Q+\b\u0019÷z®%\u00187\u0010¶\u009eeí\u009a$íP ³MY\u008bë\u0092Y dyBEG\u0007Ê×vGÏ5Ã÷Ã-¯\u0003R¹¸\u001d¶ \u0017`\u0018\u0087ìIqH\u00187wSÏ\u008a\u008fvî÷\u007f#_]Ã¥\u009d\u0081L\u0003z2¿\u0014X\u0010-ïVöBµæõòÔÑ!¬½E\u0012 ·Ï=ó\u000f\"A\u0082Â¿\\óÐ\u008cßY\u001a\u001e/\u0007\u0095¡e?\u0019[\u00adePdG\u000b\u0010X#\u0006E±\u0090þp\u0001rÄOOlÈz(Út\u000ff¿\u001eTµ\u008b¤äq²³²Õ\u0084(6]îQÝ\u0095z\u0099±(Ï\u008ems\u009b\u0094\u0006\u009fzÃ¼¯ ç.b\u0000;w\u000b×ç\u0002H¿Þõ\u008c¤+ß\u0095\u0002+¬¤i\u0002Ìäb\u0086°\u0014\u008f\u0010\u009d=Î*\n$É}À\u0094ÄC´\u009a³+\u0010j10f\t\u001eØ¥Aæ¾2{\u000eøN\u0010WUz8\u008e³;À$çN¥¤\u0091|»\u0010\u009e6´\u000f\u0089$o\u0003Ï\u008c!J\u001e\u000ec\u0083\u0010í\u0094ÝO÷8\u0010nl\u0092Ð÷\u0014¡\u0003\u000b";
        Nametags_.llIIllIlI[9] = "ä²\u0092åDÚF\u000fpT,¹\u0095\u0006\u0012\u001d\u0010W\\ 2F=¯s\u0085I¸««î\u001c0";
        Nametags_.llIIllIlI[10] = "ISO-8859-1";
        Nametags_.llIIllIlI[11] = "DES/CBC/PKCS5Padding";
        Nametags_.llIIllIlI[12] = "DES";
        Nametags_.llIIllIlI[13] = "我就是说你是一个蜗牛杂了垃圾狗族废材爹爹我不想埋汰你们了因为我在你眼里的形象太巨大了还耀武扬威的啊你在你大哥我面前是永远抬不起头的你知道不NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u2009\u200e\u200a";
        Nametags_.llIIllIlI[14] = "ISO-8859-1";
        Nametags_.llIIllIlI[15] = "我就是说你是一个蜗牛杂了垃圾狗族废材爹爹我不想埋汰你们了因为我在你眼里的形象太巨大了还耀武扬威的啊你在你大哥我面前是永远抬不起头的你知道不NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u2009\u200e\u200a";
        Nametags_.llIIllIlI[16] = " : ";
        Nametags_.llIIllIlI[17] = " : ";
    }
    
    private static String lIIIllIIIlI(String s, final String s2) {
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
    
    private static String lIIIllIIIll(final String s, final String s2) {
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
    
    private static String lIIIllIIIII(final String s, final String s2) {
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
    
    private static boolean lIIlIIllIll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIlIIlIIII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIlIIllIIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIlIIlIIlI(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIlIIllllI(final int n) {
        return n < 0;
    }
    
    private static boolean lIIlIIlIllI(final int n) {
        return n > 0;
    }
    
    private static int lIIlIIIllIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIlIIIllII$25399e8(final double n) {
        return dcmpl(n, 1.0);
    }
    
    private static int lIIlIIIlIll$25399e8(final double n) {
        return dcmpg(n, 0.0);
    }
    
    private static int lIIlIIlllII$25399e8(final double n) {
        return dcmpl(n, 0.0);
    }
    
    private static int lIIlIIlllIl$25399e8(final double n) {
        return dcmpg(n, 1.0);
    }
}
