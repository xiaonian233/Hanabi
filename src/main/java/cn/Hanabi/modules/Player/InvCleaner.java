package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Combat.*;
import net.minecraft.inventory.*;
import net.minecraft.entity.player.*;
import com.darkmagician6.eventapi.*;
import java.util.function.*;
import java.util.stream.*;
import net.minecraft.entity.ai.attributes.*;
import net.minecraft.entity.*;
import net.minecraft.enchantment.*;
import net.minecraft.util.*;
import net.minecraft.item.*;
import com.google.common.collect.*;
import net.minecraft.potion.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class InvCleaner extends Mod
{
    private Value<Boolean> autoclose;
    private static Class220 timer;
    private Set<Integer> blacklistedItemIDs;
    private ItemStack[] bestArmorSet;
    private ItemStack bestSword;
    private ItemStack bestPickAxe;
    private ItemStack bestBow;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llIIlIllIlI;
    
    public InvCleaner() {
        super("InvCleaner", Category.PLAYER);
        this.autoclose = new Value<Boolean>("InvCleaner_AutoToggle", Boolean.FALSE);
        this.blacklistedItemIDs = new HashSet<Integer>();
        new Class220();
    }
    
    @EventTarget
    private void onUpdate$3a3d1cb1() {
        final int[] b = Class139.b();
        int n3;
        int n2;
        final int n = n2 = (n3 = (AutoSword.publicItemTimer.isDelayComplete(300L) ? 1 : 0));
        if (b == null) {
            if (n == 0) {
                return;
            }
            n3 = (n2 = InvCleaner.mc.field_71439_g.field_70173_aa % 2);
        }
        if (b == null) {
            if (n2 != 0) {
                return;
            }
            n3 = (new Random().nextBoolean() ? 1 : 0);
        }
        if (n3 != 0) {
            AutoSword.publicItemTimer.lastMs = System.currentTimeMillis();
            this.bestArmorSet = getBestArmorSet();
            this.bestSword = getBestItem((Class<? extends Item>)ItemSword.class, Comparator.comparingDouble((ToDoubleFunction<? super Object>)this::getSwordDamage));
            this.bestPickAxe = getBestItem((Class<? extends Item>)ItemPickaxe.class, Comparator.comparingDouble((ToDoubleFunction<? super Object>)this::getMiningSpeed));
            this.bestBow = getBestItem((Class<? extends Item>)ItemBow.class, Comparator.comparingDouble((ToDoubleFunction<? super Object>)this::getBowPower));
            final Optional first;
            final boolean present = (first = InvCleaner.mc.field_71439_g.field_71069_bz.field_75151_b.stream().filter(Slot::func_75216_d).filter(InvCleaner::lambda$onUpdate$0).filter(InvCleaner::lambda$onUpdate$1).filter(this::lambda$onUpdate$2).findFirst()).isPresent();
            InvCleaner invCleaner = null;
            Label_0254: {
                if (b == null) {
                    if (present) {
                        InvCleaner.mc.field_71442_b.func_78753_a(0, first.get().field_75222_d, 1, 4, (EntityPlayer)InvCleaner.mc.field_71439_g);
                        if (b == null) {
                            return;
                        }
                    }
                    invCleaner = this;
                    if (b != null) {
                        break Label_0254;
                    }
                    this.autoclose.value;
                }
                if (!present) {
                    return;
                }
                invCleaner = this;
            }
            invCleaner.set(false);
        }
    }
    
    private static void dropItem(final int n) {
        InvCleaner.mc.field_71442_b.func_78753_a(0, n, 1, 4, (EntityPlayer)InvCleaner.mc.field_71439_g);
    }
    
    private boolean isItemBlackListed(final ItemStack itemStack) {
        final int[] b = Class139.b();
        final Item func_77973_b = itemStack.func_77973_b();
        final int[] array = b;
        final boolean contains = this.blacklistedItemIDs.contains(Item.func_150891_b(func_77973_b));
        if (array == null) {
            if (!contains) {
                boolean b4;
                boolean b3;
                final boolean b2 = b3 = (b4 = (func_77973_b instanceof ItemBow));
                if (array == null) {
                    if (b2) {
                        final boolean equals = this.bestBow.equals(itemStack);
                        if (array != null) {
                            return contains;
                        }
                        if (!equals) {
                            return contains;
                        }
                    }
                    final boolean b5;
                    b3 = (b5 = (b4 = (func_77973_b instanceof ItemTool)));
                }
                if (array == null) {
                    if (b2) {
                        final boolean equals2 = this.bestPickAxe.equals(itemStack);
                        if (array != null) {
                            return contains;
                        }
                        if (!equals2) {
                            return contains;
                        }
                    }
                    b3 = (func_77973_b instanceof ItemFishingRod);
                }
                if (array == null) {
                    if (!b3) {
                        final boolean b6 = func_77973_b instanceof ItemGlassBottle;
                        if (array == null) {
                            if (!b6) {
                                final boolean b7 = func_77973_b instanceof ItemBucket;
                                if (array == null) {
                                    if (!b7) {
                                        final boolean b8 = func_77973_b instanceof ItemEgg;
                                        if (array == null) {
                                            if (!b8) {
                                                final boolean b9 = func_77973_b instanceof ItemSnowball;
                                                if (array == null) {
                                                    if (!b9) {
                                                        boolean anyMatch;
                                                        boolean b11;
                                                        final boolean b10 = b11 = (anyMatch = (b4 = (func_77973_b instanceof ItemSword)));
                                                        if (array == null) {
                                                            if (b10) {
                                                                final boolean equals3 = this.bestSword.equals(itemStack);
                                                                if (array != null) {
                                                                    return contains;
                                                                }
                                                                if (!equals3) {
                                                                    return contains;
                                                                }
                                                            }
                                                            final boolean b12;
                                                            b11 = (b12 = (anyMatch = (b4 = (func_77973_b instanceof ItemArmor))));
                                                        }
                                                        if (array == null) {
                                                            if (b10) {
                                                                final boolean equals4 = this.bestArmorSet[((ItemArmor)func_77973_b).field_77881_a].equals(itemStack);
                                                                if (array != null) {
                                                                    return contains;
                                                                }
                                                                if (!equals4) {
                                                                    return contains;
                                                                }
                                                            }
                                                            anyMatch = (b11 = (b4 = (func_77973_b instanceof ItemPotion)));
                                                        }
                                                        if (array == null) {
                                                            if (!b11) {
                                                                return false;
                                                            }
                                                            anyMatch = ((ItemPotion)itemStack.func_77973_b()).func_77832_l(itemStack).stream().map(InvCleaner::lambda$isPotionNegative$5).anyMatch(Potion::func_76398_f);
                                                        }
                                                        if (array != null) {
                                                            return contains;
                                                        }
                                                        if (anyMatch) {
                                                            return contains;
                                                        }
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return contains;
    }
    
    private static ItemStack getBestItem(final Class<? extends Item> clazz, final Comparator comparator) {
        return (ItemStack)InvCleaner.mc.field_71439_g.field_71069_bz.field_75151_b.stream().map(Slot::func_75211_c).filter(Objects::nonNull).filter(InvCleaner::lambda$getBestItem$3).max(comparator).orElse(null);
    }
    
    private static ItemStack[] getBestArmorSet() {
        final int[] b = Class139.b();
        final ItemStack[] array = new ItemStack[4];
        final int[] array2 = b;
        final Iterator<ItemStack> iterator = (Iterator<ItemStack>)((List)InvCleaner.mc.field_71439_g.field_71069_bz.field_75151_b.stream().filter(Slot::func_75216_d).map(Slot::func_75211_c).filter(InvCleaner::lambda$getBestArmorSet$4).collect(Collectors.toList())).iterator();
        ItemStack[] array3 = null;
        while (iterator.hasNext()) {
            final ItemStack itemStack;
            final ItemArmor itemArmor = (ItemArmor)(itemStack = iterator.next()).func_77973_b();
            array3 = array;
            if (array2 != null) {
                return array3;
            }
            final ItemStack itemStack2;
            if ((itemStack2 = array3[itemArmor.field_77881_a]) == null || getArmorDamageReduction(itemStack) > getArmorDamageReduction(itemStack2)) {
                array[itemArmor.field_77881_a] = itemStack;
            }
            if (array2 != null) {
                break;
            }
        }
        return array3;
    }
    
    public final double getSwordDamage(final ItemStack itemStack) {
        final int[] b = Class139.b();
        double func_111164_d = 0.0;
        final Optional<AttributeModifier> first = itemStack.func_111283_C().values().stream().findFirst();
        if (b == null) {
            if (first.isPresent()) {
                func_111164_d = first.get().func_111164_d();
            }
            func_111164_d += EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
        }
        return func_111164_d;
    }
    
    public final double getBowPower(final ItemStack itemStack) {
        double func_111164_d = 0.0;
        final int[] b = Class139.b();
        final Optional<AttributeModifier> first = itemStack.func_111283_C().values().stream().findFirst();
        if (b == null) {
            if (first.isPresent()) {
                func_111164_d = first.get().func_111164_d();
            }
            func_111164_d += EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
        }
        return func_111164_d;
    }
    
    public final double getMiningSpeed(final ItemStack itemStack) {
        double func_111164_d = 0.0;
        final int[] b = Class139.b();
        final Optional<AttributeModifier> first = itemStack.func_111283_C().values().stream().findFirst();
        if (b == null) {
            if (first.isPresent()) {
                func_111164_d = first.get().func_111164_d();
            }
            func_111164_d += EnchantmentHelper.func_152377_a(itemStack, EnumCreatureAttribute.UNDEFINED);
        }
        return func_111164_d;
    }
    
    private static double getArmorDamageReduction(final ItemStack itemStack) {
        return ((ItemArmor)itemStack.func_77973_b()).field_77879_b + EnchantmentHelper.func_77508_a(new ItemStack[] { itemStack }, DamageSource.func_76365_a((EntityPlayer)InvCleaner.mc.field_71439_g));
    }
    
    private static boolean isPotionNegative(final ItemStack itemStack) {
        return ((ItemPotion)itemStack.func_77973_b()).func_77832_l(itemStack).stream().map(InvCleaner::lambda$isPotionNegative$5).anyMatch(Potion::func_76398_f);
    }
    
    private static boolean stackIsUseful(final int n) {
        final ItemStack func_75211_c = InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c();
        final int[] b = Class139.b();
        int n2 = 0;
        final int[] array = b;
        final boolean b3;
        final boolean b2 = b3 = (func_75211_c.func_77973_b() instanceof ItemSword);
        int n15 = 0;
        int func_150891_b = 0;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        int n19 = 0;
        int n20 = 0;
        int n21 = 0;
        int n22 = 0;
        int n23 = 0;
        int n24 = 0;
        int n25 = 0;
        int n26 = 0;
        int n39 = 0;
        int n38 = 0;
        int n37 = 0;
        int n36 = 0;
        int n35 = 0;
        int n34 = 0;
        int n33 = 0;
        int n32 = 0;
        int n31 = 0;
        int n30 = 0;
        int n29 = 0;
        int n28 = 0;
        int n27 = 0;
        Label_1224: {
        Label_1215:
            while (true) {
                int i = 0;
                int n7 = 0;
                int n10 = 0;
                Label_0979: {
                    int n5 = 0;
                    Label_0973: {
                        Label_0972: {
                            final int n4;
                            Label_0263: {
                                Label_0256: {
                                    final int n3;
                                    if (array == null) {
                                        if (!b2) {
                                            n3 = ((func_75211_c.func_77973_b() instanceof ItemPickaxe) ? 1 : 0);
                                            if (array == null) {
                                                if (n3 == 0) {
                                                    n4 = (n5 = ((func_75211_c.func_77973_b() instanceof ItemAxe) ? 1 : 0));
                                                    if (array != null) {
                                                        break Label_0263;
                                                    }
                                                    if (n4 == 0) {
                                                        break Label_0256;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                    i = n3;
                                    while (i < 45) {
                                        final int n6 = n7 = i;
                                        Label_0248: {
                                            Label_0245: {
                                                final Slot func_75139_a;
                                                Label_0131: {
                                                    if (array == null) {
                                                        if (array != null) {
                                                            break Label_0979;
                                                        }
                                                        if (n6 == n && array == null) {
                                                            break Label_0245;
                                                        }
                                                        func_75139_a = InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                                                        if (array != null) {
                                                            break Label_0131;
                                                        }
                                                        func_75139_a.func_75216_d();
                                                    }
                                                    if (n6 == 0) {
                                                        break Label_0245;
                                                    }
                                                    InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                                                }
                                                final ItemStack func_75211_c2;
                                                ItemStack itemStack3;
                                                final ItemStack itemStack2;
                                                final ItemStack itemStack = itemStack2 = (itemStack3 = (func_75211_c2 = func_75139_a.func_75211_c()));
                                                final ItemStack itemStack4;
                                                Label_0189: {
                                                    if (array == null) {
                                                        if (itemStack != null) {
                                                            itemStack4 = itemStack2;
                                                            if (array != null) {
                                                                break Label_0189;
                                                            }
                                                            if (itemStack4.func_77973_b() instanceof ItemSword) {
                                                                break Label_0189;
                                                            }
                                                        }
                                                        itemStack3 = itemStack2;
                                                    }
                                                    if (array == null) {
                                                        if (!(itemStack3.func_77973_b() instanceof ItemAxe)) {
                                                            final ItemStack itemStack5 = itemStack2;
                                                            if (array == null) {
                                                                if (!(itemStack5.func_77973_b() instanceof ItemPickaxe)) {
                                                                    break Label_0245;
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                                final float n8 = getItemDamage(itemStack4) + EnchantmentHelper.func_152377_a(func_75211_c, EnumCreatureAttribute.UNDEFINED);
                                                final float n9 = getItemDamage(itemStack2) + EnchantmentHelper.func_152377_a(itemStack2, EnumCreatureAttribute.UNDEFINED);
                                                if (array != null) {
                                                    break Label_0248;
                                                }
                                                if (n9 > n8) {
                                                    n2 = 1;
                                                    if (array == null) {
                                                        break;
                                                    }
                                                }
                                            }
                                            ++i;
                                        }
                                        if (array != null) {
                                            break;
                                        }
                                    }
                                    if (array == null) {
                                        break Label_0972;
                                    }
                                }
                                final boolean b4;
                                n5 = ((b4 = (func_75211_c.func_77973_b() instanceof ItemArmor)) ? 1 : 0);
                            }
                            if (array != null) {
                                break Label_0973;
                            }
                            if (n4 != 0) {
                                i = 0;
                                while (i < 45) {
                                    n7 = n;
                                    boolean func_75216_d = n != 0;
                                    Label_0968: {
                                        Label_0965: {
                                            final Slot func_75139_a2;
                                            Label_0336: {
                                                if (array == null) {
                                                    n10 = i;
                                                    if (array != null) {
                                                        break Label_0979;
                                                    }
                                                    if (n == n10 && array == null) {
                                                        break Label_0965;
                                                    }
                                                    func_75139_a2 = InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                                                    if (array != null) {
                                                        break Label_0336;
                                                    }
                                                    func_75216_d = func_75139_a2.func_75216_d();
                                                }
                                                if (!func_75216_d) {
                                                    break Label_0965;
                                                }
                                                InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                                            }
                                            final ItemStack func_75211_c3 = func_75139_a2.func_75211_c();
                                            if (array != null) {
                                                break Label_0968;
                                            }
                                            if (func_75211_c3 != null) {
                                                final int n11 = (func_75211_c3.func_77973_b() instanceof ItemArmor) ? 1 : 0;
                                                if (array != null || n11 != 0) {
                                                    final Integer[] array2 = new Integer[n11];
                                                    array2[0] = 298;
                                                    array2[1] = 314;
                                                    array2[2] = 302;
                                                    array2[3] = 306;
                                                    array2[4] = 310;
                                                    final List<Integer> list = Arrays.asList(array2);
                                                    final List<Integer> list2 = Arrays.asList(299, 315, 303, 307, 311);
                                                    final List<Integer> list3 = Arrays.asList(300, 316, 304, 308, 312);
                                                    final List<Integer> list4 = Arrays.asList(301, 317, 305, 309, 313);
                                                    boolean b10;
                                                    boolean b9;
                                                    boolean b8;
                                                    boolean b7;
                                                    final boolean b6;
                                                    final boolean b5 = b6 = (b7 = (b8 = (b9 = (b10 = list.contains(Item.func_150891_b(func_75211_c3.func_77973_b()))))));
                                                    final boolean b11;
                                                    final int contains;
                                                    Label_0692: {
                                                        if (array == null) {
                                                            if (b5) {
                                                                b11 = (b7 = (b8 = (b9 = (b10 = list.contains(Item.func_150891_b(func_75211_c.func_77973_b()))))));
                                                                if (array != null) {
                                                                    break Label_0692;
                                                                }
                                                                if (b11) {
                                                                    int index;
                                                                    final int n12 = index = list.indexOf(Item.func_150891_b(func_75211_c.func_77973_b()));
                                                                    if (array == null) {
                                                                        if (n12 >= list.indexOf(Item.func_150891_b(func_75211_c3.func_77973_b()))) {
                                                                            break Label_0965;
                                                                        }
                                                                        index = 1;
                                                                    }
                                                                    n2 = index;
                                                                    if (array == null) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            contains = (list2.contains(Item.func_150891_b(func_75211_c3.func_77973_b())) ? 1 : 0);
                                                        }
                                                    }
                                                    final boolean b12;
                                                    Label_0789: {
                                                        if (array == null) {
                                                            if (b5) {
                                                                b12 = (b8 = (b9 = (b10 = list2.contains(Item.func_150891_b(func_75211_c.func_77973_b())))));
                                                                if (array != null) {
                                                                    break Label_0789;
                                                                }
                                                                if (b12) {
                                                                    int index2;
                                                                    final int n13 = index2 = list2.indexOf(Item.func_150891_b(func_75211_c.func_77973_b()));
                                                                    if (array == null) {
                                                                        if (n13 >= list2.indexOf(Item.func_150891_b(func_75211_c3.func_77973_b()))) {
                                                                            break Label_0965;
                                                                        }
                                                                        index2 = 1;
                                                                    }
                                                                    n2 = index2;
                                                                    if (array == null) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            list3.contains(Item.func_150891_b(func_75211_c3.func_77973_b()));
                                                        }
                                                    }
                                                    final boolean b13;
                                                    Label_0886: {
                                                        if (array == null) {
                                                            if (b11) {
                                                                b13 = (b9 = (b10 = list3.contains(Item.func_150891_b(func_75211_c.func_77973_b()))));
                                                                if (array != null) {
                                                                    break Label_0886;
                                                                }
                                                                if (b13) {
                                                                    int index3;
                                                                    final int n14 = index3 = list3.indexOf(Item.func_150891_b(func_75211_c.func_77973_b()));
                                                                    if (array == null) {
                                                                        if (n14 >= list3.indexOf(Item.func_150891_b(func_75211_c3.func_77973_b()))) {
                                                                            break Label_0965;
                                                                        }
                                                                        index3 = 1;
                                                                    }
                                                                    n2 = index3;
                                                                    if (array == null) {
                                                                        break;
                                                                    }
                                                                }
                                                            }
                                                            list4.contains(Item.func_150891_b(func_75211_c3.func_77973_b()));
                                                        }
                                                    }
                                                    if (array == null) {
                                                        if (!b12) {
                                                            break Label_0965;
                                                        }
                                                        list4.contains(Item.func_150891_b(func_75211_c.func_77973_b()));
                                                    }
                                                    if (array == null) {
                                                        if (!b13) {
                                                            break Label_0965;
                                                        }
                                                        list4.indexOf(Item.func_150891_b(func_75211_c.func_77973_b()));
                                                    }
                                                    if (array != null || contains < list4.indexOf(Item.func_150891_b(func_75211_c3.func_77973_b()))) {
                                                        n2 = contains;
                                                        if (array == null) {
                                                            break;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        ++i;
                                    }
                                    if (array != null) {
                                        break;
                                    }
                                }
                            }
                        }
                        n5 = 0;
                    }
                    i = n5;
                    n7 = i;
                }
                if (n7 < n10) {
                    n15 = n;
                    func_150891_b = n;
                    n16 = n;
                    n17 = n;
                    n18 = n;
                    n19 = n;
                    n20 = n;
                    n21 = n;
                    n22 = n;
                    n23 = n;
                    n24 = n;
                    n25 = n;
                    n26 = n;
                    boolean func_75216_d2 = n != 0;
                    Label_1211: {
                        Label_1208: {
                            final Slot func_75139_a3;
                            Label_1038: {
                                if (array == null) {
                                    n27 = (n28 = (n29 = (n30 = (n31 = (n32 = (n33 = (n34 = (n35 = (n36 = (n37 = (n38 = (n39 = i))))))))))));
                                    if (array != null) {
                                        break Label_1224;
                                    }
                                    if (n == n27 && array == null) {
                                        break Label_1208;
                                    }
                                    func_75139_a3 = InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                                    if (array != null) {
                                        break Label_1038;
                                    }
                                    func_75216_d2 = func_75139_a3.func_75216_d();
                                }
                                if (!func_75216_d2) {
                                    break Label_1208;
                                }
                                InvCleaner.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                            }
                            final ItemStack func_75211_c4 = func_75139_a3.func_75211_c();
                            if (array != null) {
                                break Label_1211;
                            }
                            if (func_75211_c4 != null) {
                                final Item func_77973_b = func_75211_c4.func_77973_b();
                                Label_1179: {
                                    if (array == null) {
                                        if (!(func_77973_b instanceof ItemSword)) {
                                            final Item func_77973_b2 = func_75211_c4.func_77973_b();
                                            if (array != null) {
                                                break Label_1179;
                                            }
                                            if (!(func_77973_b2 instanceof ItemAxe)) {
                                                final Item func_77973_b3 = func_75211_c4.func_77973_b();
                                                if (array != null) {
                                                    break Label_1179;
                                                }
                                                if (!(func_77973_b3 instanceof ItemBow)) {
                                                    final Item func_77973_b4 = func_75211_c4.func_77973_b();
                                                    if (array != null) {
                                                        break Label_1179;
                                                    }
                                                    if (!(func_77973_b4 instanceof ItemFishingRod)) {
                                                        final Item func_77973_b5 = func_75211_c4.func_77973_b();
                                                        if (array != null) {
                                                            break Label_1179;
                                                        }
                                                        if (!(func_77973_b5 instanceof ItemArmor)) {
                                                            final Item func_77973_b6 = func_75211_c4.func_77973_b();
                                                            if (array != null) {
                                                                break Label_1179;
                                                            }
                                                            if (!(func_77973_b6 instanceof ItemAxe)) {
                                                                final Item func_77973_b7 = func_75211_c4.func_77973_b();
                                                                if (array != null) {
                                                                    break Label_1179;
                                                                }
                                                                if (!(func_77973_b7 instanceof ItemPickaxe)) {
                                                                    final Item func_77973_b8 = func_75211_c4.func_77973_b();
                                                                    if (array != null) {
                                                                        break Label_1179;
                                                                    }
                                                                    if (Item.func_150891_b(func_77973_b8) != 346) {
                                                                        break Label_1208;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                        func_75211_c4.func_77973_b();
                                    }
                                }
                                if (array != null) {
                                    break Label_1211;
                                }
                                if (Item.func_150891_b(func_75211_c.func_77973_b()) == Item.func_150891_b(func_75211_c4.func_77973_b())) {
                                    n2 = 1;
                                    if (array == null) {
                                        break Label_1215;
                                    }
                                }
                            }
                        }
                        ++i;
                    }
                    if (array == null) {
                        continue;
                    }
                }
                break;
            }
            n25 = (n26 = (n24 = (n23 = (n22 = (n21 = (n20 = (n19 = (n18 = (n17 = (n16 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b())))))))))))));
            final int n40;
            n28 = (n40 = (n29 = (n30 = (n31 = (n32 = (n33 = (n34 = (n35 = (n36 = (n37 = (n38 = (n39 = 367))))))))))));
        }
        if (array == null) {
            if (n26 == n27) {
                return false;
            }
            n24 = (n25 = (n23 = (n22 = (n21 = (n20 = (n19 = (n18 = (n17 = (n16 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b()))))))))))));
            n29 = (n28 = (n30 = (n31 = (n32 = (n33 = (n34 = (n35 = (n36 = (n37 = (n38 = (n39 = 30)))))))))));
        }
        if (array == null) {
            if (n25 == n28) {
                return true;
            }
            n23 = (n24 = (n22 = (n21 = (n20 = (n19 = (n18 = (n17 = (n16 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b())))))))))));
            n30 = (n29 = (n31 = (n32 = (n33 = (n34 = (n35 = (n36 = (n37 = (n38 = (n39 = 259))))))))));
        }
        if (array == null) {
            if (n24 == n29) {
                return true;
            }
            n22 = (n23 = (n21 = (n20 = (n19 = (n18 = (n17 = (n16 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b()))))))))));
            n31 = (n30 = (n32 = (n33 = (n34 = (n35 = (n36 = (n37 = (n38 = (n39 = 262)))))))));
        }
        if (array == null) {
            if (n23 == n30) {
                return true;
            }
            n21 = (n22 = (n20 = (n19 = (n18 = (n17 = (n16 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b())))))))));
            n32 = (n31 = (n33 = (n34 = (n35 = (n36 = (n37 = (n38 = (n39 = 264))))))));
        }
        if (array == null) {
            if (n22 == n31) {
                return true;
            }
            n20 = (n21 = (n19 = (n18 = (n17 = (n16 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b()))))))));
            n33 = (n32 = (n34 = (n35 = (n36 = (n37 = (n38 = (n39 = 265)))))));
        }
        if (array == null) {
            if (n21 == n32) {
                return true;
            }
            n19 = (n20 = (n18 = (n17 = (n16 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b())))))));
            n34 = (n33 = (n35 = (n36 = (n37 = (n38 = (n39 = 346))))));
        }
        if (array == null) {
            if (n20 == n33) {
                return true;
            }
            n18 = (n19 = (n17 = (n16 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b()))))));
            n35 = (n34 = (n36 = (n37 = (n38 = (n39 = 384)))));
        }
        if (array == null) {
            if (n19 == n34) {
                return true;
            }
            n17 = (n18 = (n16 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b())))));
            n36 = (n35 = (n37 = (n38 = (n39 = 345))));
        }
        if (array == null) {
            if (n18 == n35) {
                return true;
            }
            n16 = (n17 = (func_150891_b = (n15 = Item.func_150891_b(func_75211_c.func_77973_b()))));
            n37 = (n36 = (n38 = (n39 = 296)));
        }
        if (array == null) {
            if (n17 == n36) {
                return true;
            }
            func_150891_b = (n16 = (n15 = Item.func_150891_b(func_75211_c.func_77973_b())));
            n38 = (n37 = (n39 = 336));
        }
        if (array == null) {
            if (n16 == n37) {
                return true;
            }
            n15 = (func_150891_b = Item.func_150891_b(func_75211_c.func_77973_b()));
            n39 = (n38 = 266);
        }
        boolean b22 = false;
        boolean b21 = false;
        boolean b20 = false;
        boolean b19 = false;
        boolean b18 = false;
        boolean b17 = false;
        boolean b16 = false;
        int n44 = 0;
        boolean b15 = false;
        int n43 = 0;
        boolean b14 = false;
        int n42 = 0;
        int n41 = 0;
        Label_1453: {
            if (array == null) {
                if (func_150891_b == n38) {
                    return true;
                }
                n41 = (n15 = (n42 = ((b14 = ((n43 = ((b15 = ((n44 = ((b16 = (b17 = (b18 = (b19 = (b20 = (b21 = (b22 = (Item.func_150891_b(func_75211_c.func_77973_b()) != 0)))))))) ? 1 : 0)) != 0)) ? 1 : 0)) != 0)) ? 1 : 0)));
                if (array != null) {
                    break Label_1453;
                }
                n39 = 280;
            }
            if (n15 == n39) {
                return true;
            }
            n42 = (n41 = ((b14 = ((n43 = ((b15 = ((n44 = ((b16 = (b17 = (b18 = (b19 = (b20 = (b21 = (b22 = func_75211_c.func_82837_s()))))))) ? 1 : 0)) != 0)) ? 1 : 0)) != 0)) ? 1 : 0));
        }
        if (array == null) {
            if (n41 != 0) {
                return true;
            }
            b14 = ((n42 = (n43 = ((b15 = ((n44 = ((b16 = (b17 = (b18 = (b19 = (b20 = (b21 = (b22 = (n2 != 0)))))))) ? 1 : 0)) != 0)) ? 1 : 0))) != 0);
        }
        if (array == null) {
            if (n42 != 0) {
                return false;
            }
            n43 = ((b14 = (b15 = ((n44 = ((b16 = (b17 = (b18 = (b19 = (b20 = (b21 = (b22 = (func_75211_c.func_77973_b() instanceof ItemArmor)))))))) ? 1 : 0)) != 0))) ? 1 : 0);
        }
        if (array == null) {
            if (b14) {
                return true;
            }
            b15 = ((n43 = (n44 = ((b16 = (b17 = (b18 = (b19 = (b20 = (b21 = (b22 = (func_75211_c.func_77973_b() instanceof ItemAxe)))))))) ? 1 : 0))) != 0);
        }
        if (array == null) {
            if (n43 != 0) {
                return true;
            }
            n44 = ((b15 = (b16 = (b17 = (b18 = (b19 = (b20 = (b21 = (b22 = (func_75211_c.func_77973_b() instanceof ItemBow))))))))) ? 1 : 0);
        }
        if (array == null) {
            if (b15) {
                return true;
            }
            b16 = ((n44 = ((b17 = (b18 = (b19 = (b20 = (b21 = (b22 = (func_75211_c.func_77973_b() instanceof ItemSword))))))) ? 1 : 0)) != 0);
        }
        if (array == null) {
            if (n44 != 0) {
                return true;
            }
            b17 = (b16 = (b18 = (b19 = (b20 = (b21 = (b22 = (func_75211_c.func_77973_b() instanceof ItemPotion)))))));
        }
        if (array == null) {
            if (b16) {
                return true;
            }
            b18 = (b17 = (b19 = (b20 = (b21 = (b22 = (func_75211_c.func_77973_b() instanceof ItemFlintAndSteel))))));
        }
        if (array == null) {
            if (b17) {
                return true;
            }
            b19 = (b18 = (b20 = (b21 = (b22 = (func_75211_c.func_77973_b() instanceof ItemEnderPearl)))));
        }
        if (array == null) {
            if (b18) {
                return true;
            }
            b20 = (b19 = (b21 = (b22 = (func_75211_c.func_77973_b() instanceof ItemBlock))));
        }
        if (array == null) {
            if (b19) {
                return true;
            }
            b21 = (b20 = (b22 = (func_75211_c.func_77973_b() instanceof ItemFood)));
        }
        if (array == null) {
            if (b20) {
                return true;
            }
            b22 = (b21 = (func_75211_c.func_77973_b() instanceof ItemPickaxe));
        }
        if (array == null) {
            if (b21) {
                return true;
            }
            b22 = false;
        }
        return b22;
    }
    
    private static float getItemDamage(final ItemStack itemStack) {
        final int[] b = Class139.b();
        final Multimap func_111283_C = itemStack.func_111283_C();
        final int[] array = b;
        final Multimap multimap = func_111283_C;
        if (array != null || multimap.isEmpty()) {
            Object o;
            final Iterator iterator = (Iterator)(o = multimap.entries().iterator());
            if (array == null) {
                if (!iterator.hasNext()) {
                    return 1.0f;
                }
                o = iterator.next();
            }
            final AttributeModifier attributeModifier3;
            final AttributeModifier attributeModifier2;
            final AttributeModifier attributeModifier = attributeModifier2 = (attributeModifier3 = ((Map.Entry<K, AttributeModifier>)o).getValue());
            double func_111164_d = 0.0;
            Label_0114: {
                final AttributeModifier attributeModifier4;
                if (array == null) {
                    if (lIIIllIIlIIlI(attributeModifier.func_111169_c(), 1)) {
                        attributeModifier4 = attributeModifier2;
                        if (array == null) {
                            if (lIIIllIIlIIlI(attributeModifier4.func_111169_c(), 2)) {
                                func_111164_d = attributeModifier2.func_111164_d();
                                if (array == null) {
                                    break Label_0114;
                                }
                            }
                        }
                    }
                }
                func_111164_d = attributeModifier4.func_111164_d() * 100.0;
            }
            if (attributeModifier2.func_111164_d() > 1.0) {
                return 1.0f + (float)func_111164_d;
            }
            return 1.0f;
        }
        return 1.0f;
    }
    
    private static Potion lambda$isPotionNegative$5(final PotionEffect potionEffect) {
        return Potion.field_76425_a[potionEffect.func_76456_a()];
    }
    
    private static boolean lambda$getBestArmorSet$4(final ItemStack itemStack) {
        return itemStack.func_77973_b() instanceof ItemArmor;
    }
    
    private static boolean lambda$getBestItem$3(final Class clazz, final ItemStack itemStack) {
        return itemStack.func_77973_b().getClass().equals(clazz);
    }
    
    private boolean lambda$onUpdate$2(final Slot slot) {
        final ItemStack func_75211_c = slot.func_75211_c();
        final int[] b = Class139.b();
        final Item func_77973_b = func_75211_c.func_77973_b();
        final int[] array = b;
        final boolean contains = this.blacklistedItemIDs.contains(Item.func_150891_b(func_77973_b));
        if (array == null) {
            if (!contains) {
                boolean b4;
                boolean b3;
                final boolean b2 = b3 = (b4 = (func_77973_b instanceof ItemBow));
                if (array == null) {
                    if (b2) {
                        final boolean equals = this.bestBow.equals(func_75211_c);
                        if (array != null) {
                            return contains;
                        }
                        if (!equals) {
                            return contains;
                        }
                    }
                    final boolean b5;
                    b3 = (b5 = (b4 = (func_77973_b instanceof ItemTool)));
                }
                if (array == null) {
                    if (b2) {
                        final boolean equals2 = this.bestPickAxe.equals(func_75211_c);
                        if (array != null) {
                            return contains;
                        }
                        if (!equals2) {
                            return contains;
                        }
                    }
                    b3 = (func_77973_b instanceof ItemFishingRod);
                }
                if (array == null) {
                    if (!b3) {
                        final boolean b6 = func_77973_b instanceof ItemGlassBottle;
                        if (array == null) {
                            if (!b6) {
                                final boolean b7 = func_77973_b instanceof ItemBucket;
                                if (array == null) {
                                    if (!b7) {
                                        final boolean b8 = func_77973_b instanceof ItemEgg;
                                        if (array == null) {
                                            if (!b8) {
                                                final boolean b9 = func_77973_b instanceof ItemSnowball;
                                                if (array == null) {
                                                    if (!b9) {
                                                        boolean anyMatch;
                                                        boolean b11;
                                                        final boolean b10 = b11 = (anyMatch = (b4 = (func_77973_b instanceof ItemSword)));
                                                        if (array == null) {
                                                            if (b10) {
                                                                final boolean equals3 = this.bestSword.equals(func_75211_c);
                                                                if (array != null) {
                                                                    return contains;
                                                                }
                                                                if (!equals3) {
                                                                    return contains;
                                                                }
                                                            }
                                                            final boolean b12;
                                                            b11 = (b12 = (anyMatch = (b4 = (func_77973_b instanceof ItemArmor))));
                                                        }
                                                        if (array == null) {
                                                            if (b10) {
                                                                final boolean equals4 = this.bestArmorSet[((ItemArmor)func_77973_b).field_77881_a].equals(func_75211_c);
                                                                if (array != null) {
                                                                    return contains;
                                                                }
                                                                if (!equals4) {
                                                                    return contains;
                                                                }
                                                            }
                                                            anyMatch = (b11 = (b4 = (func_77973_b instanceof ItemPotion)));
                                                        }
                                                        if (array == null) {
                                                            if (!b11) {
                                                                return false;
                                                            }
                                                            final ItemStack itemStack = func_75211_c;
                                                            anyMatch = ((ItemPotion)itemStack.func_77973_b()).func_77832_l(itemStack).stream().map(InvCleaner::lambda$isPotionNegative$5).anyMatch(Potion::func_76398_f);
                                                        }
                                                        if (array != null) {
                                                            return contains;
                                                        }
                                                        if (anyMatch) {
                                                            return contains;
                                                        }
                                                        return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return contains;
    }
    
    private static boolean lambda$onUpdate$1(final Slot slot) {
        final int[] b = Class139.b();
        final boolean equals = slot.func_75211_c().equals(InvCleaner.mc.field_71439_g.func_70694_bm());
        return (b != null || !equals) && equals;
    }
    
    private static boolean lambda$onUpdate$0(final Slot slot) {
        return Arrays.stream(InvCleaner.mc.field_71439_g.field_71071_by.field_70460_b).noneMatch(slot.func_75211_c()::equals);
    }
    
    static {
        lIIIllIIIIIIl();
        Class169.a(458944202874157108L, 6099431664462133963L, MethodHandles.lookup().lookupClass()).a(245729898165858L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(InvCleaner.llIIlIllIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(InvCleaner.llIIlIllIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(75512875563322L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = InvCleaner.llIIlIllIlI[2]).length();
        int char1 = 24;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            c2[n2++] = b(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(InvCleaner.llIIlIllIlI[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        c = c2;
        d = new String[2];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x233;
        if (InvCleaner.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = InvCleaner.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(InvCleaner.llIIlIllIlI[4]);
                    array[1] = SecretKeyFactory.getInstance(InvCleaner.llIIlIllIlI[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    InvCleaner.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(InvCleaner.llIIlIllIlI[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            InvCleaner.d[n3] = b(((Cipher)array[0]).doFinal(InvCleaner.c[n3].getBytes(InvCleaner.llIIlIllIlI[7])));
        }
        return InvCleaner.d[n3];
    }
    
    private static void lIIIllIIIIIIl() {
        (llIIlIllIlI = new String[11])[0] = "DES/CBC/PKCS5Padding";
        InvCleaner.llIIlIllIlI[1] = "DES";
        InvCleaner.llIIlIllIlI[2] = "\n\u0005Õ·Åæ\u0093]K)\u007f\u0013Â\u0098¿%àµã,ê¨\u009c¤(\u008cÒ}\u0010Ïq`¨*\u0004T\u0005¸©\u0097j\u00adqC\u00130\u008fÌ|\u0094Í¼\u007fîûã*ÒzüÍ¼\u008f¦è";
        InvCleaner.llIIlIllIlI[3] = "ISO-8859-1";
        InvCleaner.llIIlIllIlI[4] = "DES/CBC/PKCS5Padding";
        InvCleaner.llIIlIllIlI[5] = "DES";
        InvCleaner.llIIlIllIlI[6] = "爹地现在心平气和的告诉你你就是一个死猫烂狗你别用你那无力的语言继续给我抓痒了好吗我可不爱和你华丽唠嗑呢所谓的大手滚开我的视线然后你绝处逢生可以脱离我的攻击了好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2001\u2002\u2009\u2001";
        InvCleaner.llIIlIllIlI[7] = "ISO-8859-1";
        InvCleaner.llIIlIllIlI[8] = "爹地现在心平气和的告诉你你就是一个死猫烂狗你别用你那无力的语言继续给我抓痒了好吗我可不爱和你华丽唠嗑呢所谓的大手滚开我的视线然后你绝处逢生可以脱离我的攻击了好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2001\u2002\u2009\u2001";
        InvCleaner.llIIlIllIlI[9] = " : ";
        InvCleaner.llIIlIllIlI[10] = " : ";
    }
    
    private static String lIIIlIlllllII(final String s, final String s2) {
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
    
    private static String lIIIllIIIIIII(final String s, final String s2) {
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
    
    private static String lIIIlIlllllll(String s, final String s2) {
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
    
    private static boolean lIIIllIIIllIl(final int n) {
        return n > 0;
    }
    
    private static boolean lIIIllIIlIIlI(final int n, final int n2) {
        return n != n2;
    }
    
    private static int lIIIllIIIllII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIIllIIIlllI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIllIIlIIIl$25399e8(final double n) {
        return dcmpl(n, 1.0);
    }
}
