package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.*;
import cn.Hanabi.modules.Combat.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import com.darkmagician6.eventapi.*;
import net.minecraftforge.fml.common.*;
import java.util.function.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.entity.ai.attributes.*;
import org.apache.commons.lang3.*;
import net.minecraft.potion.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class ChestStealer extends Mod
{
    public static boolean isChest;
    private Value<Double> delay;
    private Value<Boolean> onlychest;
    private Value<Boolean> trash;
    private Class220 time;
    private int[] itemHelmet;
    private int[] itemChestplate;
    private int[] itemLeggings;
    private int[] itemBoots;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIIIIllIlI;
    
    public ChestStealer() {
        super("ChestStealer", Category.PLAYER);
        this.delay = new Value<Double>("ChestStealer_Delay", 30.0, 0.0, 1000.0, 10.0);
        this.onlychest = new Value<Boolean>("ChestStealer_NoGameMenu", Boolean.FALSE);
        this.trash = new Value<Boolean>("ChestStealer_PickTrash", Boolean.FALSE);
        this.time = new Class220();
        this.itemHelmet = new int[] { 298, 302, 306, 310, 314 };
        this.itemChestplate = new int[] { 299, 303, 307, 311, 315 };
        this.itemLeggings = new int[] { 300, 304, 308, 312, 316 };
        this.itemBoots = new int[] { 301, 305, 309, 313, 317 };
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        this.setDisplayName(String.valueOf(new StringBuilder("Delay:").append(this.delay.value)));
        final int[] array = b;
        final boolean isChest = ChestStealer.isChest;
        Label_0057: {
            if (array == null) {
                if (isChest) {
                    break Label_0057;
                }
                this.onlychest.value;
            }
            if (isChest) {
                return;
            }
        }
        Container container2;
        final Container container = container2 = Minecraft.func_71410_x().field_71439_g.field_71070_bA;
        if (array == null) {
            if (container == null) {
                return;
            }
            final Container field_71070_bA;
            container2 = (field_71070_bA = Minecraft.func_71410_x().field_71439_g.field_71070_bA);
        }
        if (array == null) {
            if (!(container instanceof ContainerChest)) {
                return;
            }
            container2 = Minecraft.func_71410_x().field_71439_g.field_71070_bA;
        }
        final ContainerChest containerChest = (ContainerChest)container2;
        int chestEmpty;
        final int n = chestEmpty = (this.isChestEmpty(containerChest) ? 1 : 0);
        if (array == null) {
            if (n != 0) {
                ChestStealer.mc.field_71439_g.func_71053_j();
                AutoSword.publicItemTimer.lastMs = System.currentTimeMillis() - 800L;
            }
            chestEmpty = 0;
        }
        int i = chestEmpty;
        while (i < containerChest.func_85151_d().func_70302_i_()) {
            Label_0303: {
                if (containerChest.func_85151_d().func_70301_a(i) != null) {
                    final boolean delayComplete;
                    final boolean b2 = delayComplete = this.time.isDelayComplete((long)(Object)this.delay.value + new Random().nextInt(100));
                    if (array == null) {
                        if (!b2) {
                            break Label_0303;
                        }
                        this.itemIsUseful(containerChest, i);
                    }
                    final int booleanValue;
                    Label_0253: {
                        if (array == null) {
                            if (!b2) {
                                booleanValue = (((boolean)this.trash.value) ? 1 : 0);
                                if (array != null) {
                                    break Label_0253;
                                }
                                if (booleanValue == 0) {
                                    break Label_0303;
                                }
                            }
                            new Random().nextInt(100);
                        }
                    }
                    if (booleanValue <= 80 || array != null) {
                        Minecraft.func_71410_x().field_71442_b.func_78753_a(containerChest.field_75152_c, i, 0, 1, (EntityPlayer)Minecraft.func_71410_x().field_71439_g);
                        this.time.lastMs = System.currentTimeMillis();
                    }
                }
            }
            ++i;
            if (array != null) {
                break;
            }
        }
    }
    
    private boolean isChestEmpty(final ContainerChest containerChest) {
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        Label_0112: {
            while (i < containerChest.func_85151_d().func_70302_i_()) {
                if (array != null) {
                    break Label_0112;
                }
                Label_0071: {
                    if (containerChest.func_85151_d().func_70301_a(i) != null) {
                        final boolean itemIsUseful = this.itemIsUseful(containerChest, i);
                        if (array == null) {
                            if (!itemIsUseful) {
                                final boolean booleanValue = this.trash.value;
                                if (array == null) {
                                    if (!booleanValue) {
                                        break Label_0071;
                                    }
                                }
                            }
                        }
                        return itemIsUseful;
                    }
                }
                ++i;
                if (array != null) {
                    break;
                }
            }
            final Class263 aes_UTILS = Class139.AES_UTILS;
            final String hwid_VERIFY = Class139.HWID_VERIFY;
            try {
                final boolean contains = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
                if (array == null) {
                    if (contains) {
                        return true;
                    }
                    FMLCommonHandler.instance().exitJava(0, true);
                }
                Class258.sleep = contains;
            }
            catch (Exception ex) {
                FMLCommonHandler.instance().exitJava(0, true);
                Class258.sleep = true;
            }
        }
        return true;
    }
    
    private static boolean isPotionNegative(final ItemStack itemStack) {
        return ((ItemPotion)itemStack.func_77973_b()).func_77832_l(itemStack).stream().map(ChestStealer::lambda$isPotionNegative$0).anyMatch(Potion::func_76398_f);
    }
    
    private boolean itemIsUseful(final ContainerChest containerChest, final int n) {
        final ItemStack func_70301_a = containerChest.func_85151_d().func_70301_a(n);
        final int[] b = Class139.b();
        final Item func_77973_b = func_70301_a.func_77973_b();
        final int[] array = b;
        boolean b6;
        boolean b5;
        boolean b4;
        final boolean b3;
        final boolean b2 = b3 = (b4 = (b5 = (b6 = (func_77973_b instanceof ItemFood))));
        if (array == null) {
            if (b2) {
                return true;
            }
            final boolean b7 = func_77973_b instanceof ItemPotion;
        }
        final boolean b8;
        Label_0065: {
            if (array == null) {
                if (b2) {
                    b8 = (b4 = (b5 = (b6 = isPotionNegative(func_70301_a))));
                    if (array != null) {
                        break Label_0065;
                    }
                    if (!b8) {
                        return true;
                    }
                }
                b6 = (func_77973_b instanceof ItemSword);
            }
        }
        final boolean b9;
        Label_0091: {
            if (array == null) {
                if (b8) {
                    b9 = (b5 = (b6 = isBestSword(containerChest, func_70301_a)));
                    if (array != null) {
                        break Label_0091;
                    }
                    if (b9) {
                        return true;
                    }
                }
                b6 = (func_77973_b instanceof ItemArmor);
            }
        }
        final boolean b10;
        Label_0118: {
            if (array == null) {
                if (b9) {
                    b10 = (b6 = this.isBestArmor(containerChest, func_70301_a));
                    if (array != null) {
                        break Label_0118;
                    }
                    if (b10) {
                        return true;
                    }
                }
                b5 = (func_77973_b instanceof ItemBlock);
            }
        }
        final boolean contains;
        if (array == null) {
            if (b10) {
                contains = Class26.blacklistedBlocks.contains(Block.func_149634_a(func_77973_b));
                if (array == null) {
                    if (!contains) {
                        return true;
                    }
                }
            }
        }
        return contains;
    }
    
    private static float getSwordDamage(final ItemStack itemStack) {
        final int[] b = Class139.b();
        float n = 0.0f;
        final int[] array = b;
        AttributeModifier attributeModifier;
        final Optional<AttributeModifier> optional = (Optional<AttributeModifier>)(attributeModifier = (AttributeModifier)itemStack.func_111283_C().values().stream().findFirst());
        if (array == null) {
            if (!optional.isPresent()) {
                return n + EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
            }
            attributeModifier = optional.get();
        }
        n = (float)attributeModifier.func_111164_d();
        return n + EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
    }
    
    private static boolean isBestSword(final ContainerChest containerChest, final ItemStack itemStack) {
        final int[] b = Class139.b();
        final float swordDamage = getSwordDamage(itemStack);
        float n = 0.0f;
        final int[] array = b;
        int i = 0;
        while (true) {
            while (i < 45) {
                final int func_75216_d;
                final int n2 = func_75216_d = (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d() ? 1 : 0);
                if (array == null) {
                    Label_0092: {
                        if (n2 != 0) {
                            final float swordDamage2 = getSwordDamage(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c());
                            if (array != null) {
                                break Label_0092;
                            }
                            if (swordDamage2 >= n) {
                                n = swordDamage2;
                            }
                        }
                        ++i;
                    }
                    if (array != null) {
                        break;
                    }
                    continue;
                }
                else {
                    int j = func_75216_d;
                    while (j < containerChest.func_85151_d().func_70302_i_()) {
                        if (array != null) {
                            return false;
                        }
                        Label_0172: {
                            if (containerChest.func_85151_d().func_70301_a(j) != null) {
                                final float swordDamage3 = getSwordDamage(containerChest.func_85151_d().func_70301_a(j));
                                if (array != null) {
                                    break Label_0172;
                                }
                                if (swordDamage3 >= n) {
                                    n = swordDamage3;
                                }
                            }
                            ++j;
                        }
                        if (array != null) {
                            break;
                        }
                    }
                    final float n3 = fcmpl(swordDamage, n);
                    if (array == null && n3 != 0) {
                        return false;
                    }
                    return n3 != 0.0f;
                }
            }
            int func_75216_d = 0;
            continue;
        }
    }
    
    private boolean isBestArmor(final ContainerChest containerChest, final ItemStack itemStack) {
        final int[] b = Class139.b();
        final float n = ((ItemArmor)itemStack.func_77973_b()).field_77879_b;
        final int[] array = b;
        float n2 = 0.0f;
        float n7;
        float n6;
        int n5;
        int n4;
        final int n3 = n4 = (n5 = (int)(n6 = (n7 = (ArrayUtils.contains(this.itemHelmet, Item.func_150891_b(itemStack.func_77973_b())) ? 1 : 0))));
        Label_1129: {
        Label_1007:
            while (true) {
                int j = 0;
                ItemStack func_70301_a = null;
                Label_1036: {
                    if (array == null) {
                        Label_0296: {
                            if (n3 != 0) {
                                int i = 0;
                                while (true) {
                                    while (i < 45) {
                                        final int func_75216_d;
                                        int field_77879_b;
                                        final int n8 = field_77879_b = (func_75216_d = (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75216_d() ? 1 : 0));
                                        if (array != null) {
                                            j = func_75216_d;
                                            while (j < containerChest.func_85151_d().func_70302_i_()) {
                                                func_70301_a = containerChest.func_85151_d().func_70301_a(j);
                                                if (array != null) {
                                                    break Label_1036;
                                                }
                                                Label_0292: {
                                                    Label_0289: {
                                                        if (func_70301_a != null) {
                                                            int n10;
                                                            final int n9 = n10 = (ArrayUtils.contains(this.itemHelmet, Item.func_150891_b(containerChest.func_85151_d().func_70301_a(j).func_77973_b())) ? 1 : 0);
                                                            if (array == null) {
                                                                if (n9 == 0) {
                                                                    break Label_0289;
                                                                }
                                                                n10 = ((ItemArmor)containerChest.func_85151_d().func_70301_a(j).func_77973_b()).field_77879_b;
                                                            }
                                                            final float n11 = n10;
                                                            if (array != null) {
                                                                break Label_0292;
                                                            }
                                                            if (n11 > n2) {
                                                                n2 = n11;
                                                            }
                                                        }
                                                    }
                                                    ++j;
                                                }
                                                if (array != null) {
                                                    break;
                                                }
                                            }
                                            break Label_0296;
                                        }
                                        Label_0172: {
                                            Label_0169: {
                                                if (array == null) {
                                                    if (n8 == 0) {
                                                        break Label_0169;
                                                    }
                                                    final boolean contains;
                                                    field_77879_b = ((contains = ArrayUtils.contains(this.itemHelmet, Item.func_150891_b(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b()))) ? 1 : 0);
                                                }
                                                if (array == null) {
                                                    if (n8 == 0) {
                                                        break Label_0169;
                                                    }
                                                    field_77879_b = ((ItemArmor)ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c().func_77973_b()).field_77879_b;
                                                }
                                                final float n12 = field_77879_b;
                                                if (array != null) {
                                                    break Label_0172;
                                                }
                                                if (n12 > n2) {
                                                    n2 = n12;
                                                }
                                            }
                                            ++i;
                                        }
                                        if (array != null) {
                                            break;
                                        }
                                    }
                                    int func_75216_d = 0;
                                    continue;
                                }
                            }
                        }
                        final int n13;
                        n4 = (n13 = (n5 = (int)(n6 = (n7 = (ArrayUtils.contains(this.itemChestplate, Item.func_150891_b(itemStack.func_77973_b())) ? 1 : 0)))));
                    }
                    if (array == null) {
                        Label_0572: {
                            if (n3 != 0) {
                                int k = 0;
                                while (true) {
                                    while (k < 45) {
                                        final int func_75216_d2;
                                        int field_77879_b2;
                                        final int n14 = field_77879_b2 = (func_75216_d2 = (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(k).func_75216_d() ? 1 : 0));
                                        if (array != null) {
                                            j = func_75216_d2;
                                            while (j < containerChest.func_85151_d().func_70302_i_()) {
                                                final ItemStack func_70301_a2 = containerChest.func_85151_d().func_70301_a(j);
                                                if (array != null) {
                                                    break Label_1036;
                                                }
                                                Label_0568: {
                                                    Label_0565: {
                                                        if (func_70301_a2 != null) {
                                                            int n16;
                                                            final int n15 = n16 = (ArrayUtils.contains(this.itemChestplate, Item.func_150891_b(containerChest.func_85151_d().func_70301_a(j).func_77973_b())) ? 1 : 0);
                                                            if (array == null) {
                                                                if (n15 == 0) {
                                                                    break Label_0565;
                                                                }
                                                                n16 = ((ItemArmor)containerChest.func_85151_d().func_70301_a(j).func_77973_b()).field_77879_b;
                                                            }
                                                            final float n17 = n16;
                                                            if (array != null) {
                                                                break Label_0568;
                                                            }
                                                            if (n17 > n2) {
                                                                n2 = n17;
                                                            }
                                                        }
                                                    }
                                                    ++j;
                                                }
                                                if (array != null) {
                                                    break;
                                                }
                                            }
                                            break Label_0572;
                                        }
                                        Label_0448: {
                                            Label_0445: {
                                                if (array == null) {
                                                    if (n14 == 0) {
                                                        break Label_0445;
                                                    }
                                                    final boolean contains2;
                                                    field_77879_b2 = ((contains2 = ArrayUtils.contains(this.itemChestplate, Item.func_150891_b(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(k).func_75211_c().func_77973_b()))) ? 1 : 0);
                                                }
                                                if (array == null) {
                                                    if (n14 == 0) {
                                                        break Label_0445;
                                                    }
                                                    field_77879_b2 = ((ItemArmor)ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(k).func_75211_c().func_77973_b()).field_77879_b;
                                                }
                                                final float n18 = field_77879_b2;
                                                if (array != null) {
                                                    break Label_0448;
                                                }
                                                if (n18 > n2) {
                                                    n2 = n18;
                                                }
                                            }
                                            ++k;
                                        }
                                        if (array != null) {
                                            break;
                                        }
                                    }
                                    int func_75216_d2 = 0;
                                    continue;
                                }
                            }
                        }
                        n5 = (n4 = (int)(n6 = (n7 = (ArrayUtils.contains(this.itemLeggings, Item.func_150891_b(itemStack.func_77973_b())) ? 1 : 0))));
                    }
                    if (array == null) {
                        Label_0848: {
                            if (n4 != 0) {
                                int l = 0;
                                while (true) {
                                    while (l < 45) {
                                        final int func_75216_d3;
                                        int field_77879_b3;
                                        final int n19 = field_77879_b3 = (func_75216_d3 = (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(l).func_75216_d() ? 1 : 0));
                                        if (array != null) {
                                            j = func_75216_d3;
                                            while (j < containerChest.func_85151_d().func_70302_i_()) {
                                                final ItemStack func_70301_a3 = containerChest.func_85151_d().func_70301_a(j);
                                                if (array != null) {
                                                    break Label_1036;
                                                }
                                                Label_0844: {
                                                    Label_0841: {
                                                        if (func_70301_a3 != null) {
                                                            int n21;
                                                            final int n20 = n21 = (ArrayUtils.contains(this.itemLeggings, Item.func_150891_b(containerChest.func_85151_d().func_70301_a(j).func_77973_b())) ? 1 : 0);
                                                            if (array == null) {
                                                                if (n20 == 0) {
                                                                    break Label_0841;
                                                                }
                                                                n21 = ((ItemArmor)containerChest.func_85151_d().func_70301_a(j).func_77973_b()).field_77879_b;
                                                            }
                                                            final float n22 = n21;
                                                            if (array != null) {
                                                                break Label_0844;
                                                            }
                                                            if (n22 > n2) {
                                                                n2 = n22;
                                                            }
                                                        }
                                                    }
                                                    ++j;
                                                }
                                                if (array != null) {
                                                    break;
                                                }
                                            }
                                            break Label_0848;
                                        }
                                        Label_0724: {
                                            Label_0721: {
                                                if (array == null) {
                                                    if (n19 == 0) {
                                                        break Label_0721;
                                                    }
                                                    final boolean contains3;
                                                    field_77879_b3 = ((contains3 = ArrayUtils.contains(this.itemLeggings, Item.func_150891_b(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(l).func_75211_c().func_77973_b()))) ? 1 : 0);
                                                }
                                                if (array == null) {
                                                    if (n19 == 0) {
                                                        break Label_0721;
                                                    }
                                                    field_77879_b3 = ((ItemArmor)ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(l).func_75211_c().func_77973_b()).field_77879_b;
                                                }
                                                final float n23 = field_77879_b3;
                                                if (array != null) {
                                                    break Label_0724;
                                                }
                                                if (n23 > n2) {
                                                    n2 = n23;
                                                }
                                            }
                                            ++l;
                                        }
                                        if (array != null) {
                                            break;
                                        }
                                    }
                                    int func_75216_d3 = 0;
                                    continue;
                                }
                            }
                        }
                        n6 = (n5 = (int)(n7 = (ArrayUtils.contains(this.itemBoots, Item.func_150891_b(itemStack.func_77973_b())) ? 1 : 0)));
                    }
                    if (array != null) {
                        break Label_1129;
                    }
                    if (n5 != 0) {
                        int n24 = 0;
                        while (true) {
                            while (n24 < 45) {
                                final int func_75216_d4;
                                int field_77879_b4;
                                final int n25 = field_77879_b4 = (func_75216_d4 = (ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(n24).func_75216_d() ? 1 : 0));
                                if (array != null) {
                                    j = func_75216_d4;
                                    break Label_1007;
                                }
                                Label_1000: {
                                    Label_0997: {
                                        if (array == null) {
                                            if (n25 == 0) {
                                                break Label_0997;
                                            }
                                            final boolean contains4;
                                            field_77879_b4 = ((contains4 = ArrayUtils.contains(this.itemBoots, Item.func_150891_b(ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(n24).func_75211_c().func_77973_b()))) ? 1 : 0);
                                        }
                                        if (array == null) {
                                            if (n25 == 0) {
                                                break Label_0997;
                                            }
                                            field_77879_b4 = ((ItemArmor)ChestStealer.mc.field_71439_g.field_71069_bz.func_75139_a(n24).func_75211_c().func_77973_b()).field_77879_b;
                                        }
                                        final float n26 = field_77879_b4;
                                        if (array != null) {
                                            break Label_1000;
                                        }
                                        if (n26 > n2) {
                                            n2 = n26;
                                        }
                                    }
                                    ++n24;
                                }
                                if (array != null) {
                                    break;
                                }
                            }
                            int func_75216_d4 = 0;
                            continue;
                        }
                    }
                    break Label_1007;
                    if (j >= containerChest.func_85151_d().func_70302_i_()) {
                        break Label_1007;
                    }
                    if (array != null) {
                        return false;
                    }
                    containerChest.func_85151_d().func_70301_a(j);
                }
                Label_1120: {
                    Label_1117: {
                        if (func_70301_a != null) {
                            int n28;
                            final int n27 = n28 = (ArrayUtils.contains(this.itemBoots, Item.func_150891_b(containerChest.func_85151_d().func_70301_a(j).func_77973_b())) ? 1 : 0);
                            if (array == null) {
                                if (n27 == 0) {
                                    break Label_1117;
                                }
                                n28 = ((ItemArmor)containerChest.func_85151_d().func_70301_a(j).func_77973_b()).field_77879_b;
                            }
                            final float n29 = n28;
                            if (array != null) {
                                break Label_1120;
                            }
                            if (n29 > n2) {
                                n2 = n29;
                            }
                        }
                    }
                    ++j;
                }
                if (array == null) {
                    continue Label_1007;
                }
                break;
            }
            n7 = (n6 = fcmpl(n, n2));
        }
        if (array == null) {
            if (n6 != 0) {
                return false;
            }
            n7 = (true ? 1 : 0);
        }
        return n7 != 0.0f;
    }
    
    private static boolean isContain(final int[] array, final int n) {
        return ArrayUtils.contains(array, n);
    }
    
    private static Potion lambda$isPotionNegative$0(final PotionEffect potionEffect) {
        return Potion.field_76425_a[potionEffect.func_76456_a()];
    }
    
    static {
        llIIIIlllII();
        Class169.a(8338340245139690468L, 5044658577514988470L, MethodHandles.lookup().lookupClass()).a(216424111932686L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(ChestStealer.lIIIIllIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(ChestStealer.lIIIIllIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(80107202596059L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = ChestStealer.lIIIIllIlI[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(ChestStealer.lIIIIllIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = ChestStealer.lIIIIllIlI[3]).length();
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
        d = new String[5];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x3B10;
        if (ChestStealer.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = ChestStealer.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(ChestStealer.lIIIIllIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(ChestStealer.lIIIIllIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    ChestStealer.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(ChestStealer.lIIIIllIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            ChestStealer.d[n3] = b(((Cipher)array[0]).doFinal(ChestStealer.c[n3].getBytes(ChestStealer.lIIIIllIlI[8])));
        }
        return ChestStealer.d[n3];
    }
    
    private static void llIIIIlllII() {
        (lIIIIllIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        ChestStealer.lIIIIllIlI[1] = "DES";
        ChestStealer.lIIIIllIlI[2] = "_¥áÔóI¿\u0083K¦\u0099Ý8\u0090=g((æ76\u000675\u0000\u001a'[\u008a\u009frÈT\"\u009a\u008d\u000e\u0000261\u0085\u0002cz5\u0001\u0093\u009b\t3ßÔ\nýw¬(\u008c&\u0080F\u000eø\u009bÎ\u0001/Ûkdq¬\u0000\u0019\f}y3ú\u0089ªÆÄ¹EºT'\u0018\u0096q$òr²í#";
        ChestStealer.lIIIIllIlI[3] = "g\u00adË(µ\u008f\u008bÒÔ\u0012>\u0013},\u0002\u001c\u008bfIî//`\\[ÃÒZi\u0086Eä\u0082P\u0084³n\u000büD ãH¼\u0014u\"¿\u001cä\f3Éä&z\u0006Ó!7Ïkí\r\u007fi³*Xühs¸";
        ChestStealer.lIIIIllIlI[4] = "ISO-8859-1";
        ChestStealer.lIIIIllIlI[5] = "DES/CBC/PKCS5Padding";
        ChestStealer.lIIIIllIlI[6] = "DES";
        ChestStealer.lIIIIllIlI[7] = "装不进什么优美词语的健忘的脑子的一群亡命匪徒的废柴拿什么和我打你是不是知道你自己要输给你登峰造极的爸爸我了啊你以后不要见到我就一副闻风丧胆的表情你因为你会扣几个字就可以天下无敌了吗别那么天真了好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u200a\u200f\u200d";
        ChestStealer.lIIIIllIlI[8] = "ISO-8859-1";
        ChestStealer.lIIIIllIlI[9] = "装不进什么优美词语的健忘的脑子的一群亡命匪徒的废柴拿什么和我打你是不是知道你自己要输给你登峰造极的爸爸我了啊你以后不要见到我就一副闻风丧胆的表情你因为你会扣几个字就可以天下无敌了吗别那么天真了好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u200a\u200f\u200d";
        ChestStealer.lIIIIllIlI[10] = " : ";
        ChestStealer.lIIIIllIlI[11] = " : ";
    }
    
    private static String llIIIIlIlIl(final String s, final String s2) {
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
    
    private static String llIIIIlIlII(String s, final String s2) {
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
    
    private static String llIIIIllIIl(final String s, final String s2) {
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
    
    private static boolean llIIlIIlllI$255f299(final int n) {
        return n > 80;
    }
    
    private static boolean llIIlIlIIII(final int n) {
        return n >= 0;
    }
    
    private static boolean llIIlIlIIlI(final int n) {
        return n > 0;
    }
    
    private static int llIIlIIllll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int llIIlIlIIIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
}
