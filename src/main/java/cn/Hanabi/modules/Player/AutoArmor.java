package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Combat.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import net.minecraft.client.gui.inventory.*;
import net.minecraftforge.fml.common.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.item.*;
import net.minecraft.entity.player.*;
import net.minecraft.inventory.*;
import net.minecraft.enchantment.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.util.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;

public final class AutoArmor extends Mod
{
    private Class220 timeHelper;
    private Class220 timer;
    private Class220 droptimer;
    private Value<Boolean> openInv;
    private Value<Double> delay;
    private Value inventoryKeepTimeVal;
    private Value insant;
    private ArrayList openList;
    private ArrayList closeList;
    private static boolean complete;
    private static boolean openedInventory;
    private int[] itemHelmet;
    private int[] itemChestplate;
    private int[] itemLeggings;
    private int[] itemBoots;
    private HashMap<ItemStack, Long> armorContains;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llllIII;
    
    public AutoArmor() {
        super("AutoArmor", Category.PLAYER);
        this.timeHelper = new Class220();
        this.timer = new Class220();
        this.droptimer = new Class220();
        this.openInv = new Value<Boolean>("AutoArmor_SortInInv", Boolean.TRUE);
        this.delay = new Value<Double>("AutoArmor_Delay", 60.0, 0.0, 1000.0, 10.0);
        new Value("AutoArmor_TimeInInv", 1000.0, 0.0, 10000.0, 100.0);
        this.insant = new Value("AutoArmor_Insant", (T)Boolean.FALSE);
        new ArrayList();
        this.closeList = new ArrayList();
        this.itemHelmet = new int[] { 298, 302, 306, 310, 314 };
        this.itemChestplate = new int[] { 299, 303, 307, 311, 315 };
        this.itemLeggings = new int[] { 300, 304, 308, 312, 316 };
        this.armorContains = new HashMap<ItemStack, Long>();
        this.itemBoots = new int[] { 301, 305, 309, 313, 317 };
    }
    
    @EventTarget
    private void onEvent$3d4b95ff() {
        final int[] b;
        if ((b = Class139.b()) == null) {
            if (!AutoSword.publicItemTimer.isDelayComplete(300L)) {
                return;
            }
            this.setDisplayName(String.valueOf(new StringBuilder("Delay:").append(this.delay.value)));
        }
        final Minecraft mc = AutoArmor.mc;
        if (b == null) {
            if (mc.field_71439_g == null) {
                AutoArmor.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0DPacketCloseWindow(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c));
                return;
            }
            final Minecraft mc2 = AutoArmor.mc;
        }
        Object o;
        final GuiScreen guiScreen = (GuiScreen)(o = mc.field_71462_r);
        boolean booleanValue = false;
        final boolean b2;
        Label_0180: {
            if (b == null) {
                if (guiScreen != null) {
                    final boolean booleanValue2;
                    b2 = (booleanValue = (booleanValue2 = (AutoArmor.mc.field_71462_r instanceof GuiInventory)));
                    if (b != null) {
                        break Label_0180;
                    }
                    if (!b2) {
                        final boolean openedInventory = AutoArmor.openedInventory;
                        if (b == null) {
                            if (!openedInventory) {
                                return;
                            }
                            AutoArmor.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0DPacketCloseWindow(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c));
                        }
                        AutoArmor.openedInventory = openedInventory;
                        return;
                    }
                }
                o = this.openInv.value;
            }
            boolean booleanValue2;
            final boolean b3;
            booleanValue = (b3 = (booleanValue2 = (boolean)o));
        }
        Label_0236: {
            if (b == null) {
                Boolean b4 = null;
                Label_0223: {
                    if (b2) {
                        final GuiScreen guiScreen2 = (GuiScreen)(b4 = (Boolean)AutoArmor.mc.field_71462_r);
                        if (b != null) {
                            break Label_0223;
                        }
                        if (guiScreen2 != null) {
                            final boolean b5 = AutoArmor.mc.field_71462_r instanceof GuiInventory;
                            if (b != null) {
                                break Label_0236;
                            }
                            if (b5) {
                                break Label_0236;
                            }
                        }
                    }
                    b4 = this.openInv.value;
                }
                booleanValue = b4;
            }
            if (b == null) {
                if (!booleanValue) {}
            }
        }
        boolean b6 = true;
        while (true) {
        Label_0560_Outer:
            for (final String s : Arrays.asList("helmet", "leggings", "chestplate", "boots")) {
                b6 = false;
                final String s2 = s;
                final int[] b7 = Class139.b();
                final String s3 = s2;
                final int hashCode;
                final int n = hashCode = s3.hashCode();
                final int equals;
                if (b7 == null) {
                    Label_0446: {
                        switch (n) {
                            case -1220934547: {
                                equals = (s3.equals("helmet") ? 1 : 0);
                                if (b7 != null) {
                                    break;
                                }
                                if (equals != 0 && b7 != null) {
                                    break Label_0446;
                                }
                                break;
                            }
                            case 93922241: {
                                final boolean equals2 = s3.equals("boots");
                                if (b7 != null) {
                                    break;
                                }
                                if (equals2 && b7 != null) {
                                    break Label_0446;
                                }
                                break;
                            }
                            case 1069952181: {
                                final boolean equals3 = s3.equals("chestplate");
                                if (b7 != null) {
                                    break;
                                }
                                if (equals3 && b7 != null) {
                                    break Label_0446;
                                }
                                break;
                            }
                            case 1735676010: {
                                final boolean equals4 = s3.equals("leggings");
                                if (b7 != null) {
                                    break;
                                }
                                if (equals4) {
                                    break;
                                }
                                break;
                            }
                        }
                    }
                }
                if (b7 == null) {
                    Label_0522: {
                        switch (n) {
                            case 0: {
                                if (b7 != null) {
                                    break Label_0522;
                                }
                                break;
                            }
                            case 1: {
                                if (b7 != null) {
                                    break Label_0522;
                                }
                                break;
                            }
                            case 2: {
                                if (b7 != null) {
                                    break;
                                }
                                break;
                            }
                        }
                    }
                }
                final int n2 = equals;
                int bestInInventory = this.getBestInInventory(s);
                int n3 = 1;
                boolean openedInventory2;
                final boolean b10;
                boolean b9;
                boolean b8;
                final int n6;
                final int n5;
                int n4 = n5 = (n6 = ((b8 = (b9 = (b10 = (openedInventory2 = (bestInInventory != 0))))) ? 1 : 0));
                if (b != null) {
                    if (b == null) {
                        if (!b10) {
                            return;
                        }
                        AutoSword.publicItemTimer.lastMs = System.currentTimeMillis();
                        AutoArmor.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C0DPacketCloseWindow(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c));
                        openedInventory2 = false;
                    }
                    AutoArmor.openedInventory = openedInventory2;
                    return;
                }
            Label_0560:
                while (true) {
                    Label_0625: {
                        if (b != null) {
                            break Label_0625;
                        }
                        final int n7;
                        if (lllIIlllI$255f299(n7)) {
                            final int valence = getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c());
                            if (b == null && !lllIIllll(valence, getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n2).func_75211_c()))) {}
                            n3 = valence;
                        }
                        n4 = ((b8 = (b9 = (n3 != 0))) ? 1 : 0);
                    }
                    final int n8;
                    final boolean b11;
                    if (b == null) {
                        if (n4 != 0) {
                            n8 = ((b8 = (b9 = (bestInInventory != 0))) ? 1 : 0);
                            if (b == null) {
                                if (lllIIlllI$255f299(n8)) {
                                    b11 = (b9 = this.armorContains.containsKey(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c()));
                                    if (b == null) {
                                        if (!b11) {
                                            this.armorContains.put(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c(), System.currentTimeMillis());
                                        }
                                    }
                                }
                            }
                        }
                    }
                    if (b != null || n8 != 0) {
                        AutoArmor autoArmor = null;
                        Label_1102: {
                            final int valence2;
                            Label_0824: {
                                if (b == null) {
                                    if (lllIIlllI$255f299(b11 ? 1 : 0)) {
                                        final boolean b12 = b9 = AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n2).func_75216_d();
                                        if (b != null) {
                                            break Label_0824;
                                        }
                                        if (b12) {
                                            valence2 = getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c());
                                            if (b != null) {
                                                break Label_0824;
                                            }
                                            if (valence2 < getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n2).func_75211_c())) {
                                                bestInInventory = -1;
                                            }
                                        }
                                    }
                                    autoArmor = this;
                                    if (b != null) {
                                        break Label_1102;
                                    }
                                    this.timer.isDelayComplete((long)(Object)this.delay.value);
                                }
                            }
                            Label_1101: {
                                if (valence2 != 0) {
                                    final int n9 = bestInInventory;
                                    if (b == null) {
                                        if (!lllIIlllI$255f299(n9)) {
                                            break Label_1101;
                                        }
                                        autoArmor = this;
                                        if (b != null) {
                                            break Label_1102;
                                        }
                                        this.armorContains.containsKey(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c());
                                    }
                                    if (n9 != 0 && System.currentTimeMillis() - this.armorContains.get(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c()) >= 200L) {
                                        final int n10 = n2;
                                        final int n11 = bestInInventory;
                                        final int n12 = n10;
                                        Label_1066: {
                                            final int[] b13;
                                            if ((b13 = Class139.b()) == null) {
                                                if (lllIIlllI$255f299(n12)) {
                                                    if (b13 != null) {
                                                        break Label_1066;
                                                    }
                                                    if (AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n12).func_75211_c() != null) {
                                                        final int n13 = n12;
                                                        AutoArmor.mc.field_71439_g.field_71069_bz.func_75144_a(n13, 0, 4, (EntityPlayer)AutoArmor.mc.field_71439_g);
                                                        AutoArmor.mc.field_71442_b.func_78753_a(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c, n13, 1, 4, (EntityPlayer)AutoArmor.mc.field_71439_g);
                                                    }
                                                }
                                                AutoArmor.mc.field_71442_b.func_78753_a(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c, n11, 1, 1, (EntityPlayer)AutoArmor.mc.field_71439_g);
                                            }
                                        }
                                        this.armorContains.remove(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(bestInInventory).func_75211_c());
                                        this.timer.lastMs = System.currentTimeMillis();
                                    }
                                }
                            }
                            autoArmor = this;
                        }
                        for (final int intValue : autoArmor.findArmor(s)) {
                            int n14 = 0;
                            boolean delayComplete;
                            boolean contains;
                            int n15;
                            boolean b14;
                            final int n7 = (b14 = ((n15 = ((contains = (delayComplete = (n2 != 0))) ? 1 : 0)) != 0)) ? 1 : 0;
                            if (b == null) {
                                if (b != null) {
                                    continue Label_0560;
                                }
                                if (lllIIlllI$255f299(n7)) {
                                    int valence3;
                                    final int n16 = valence3 = getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n2).func_75211_c());
                                    if (b == null) {
                                        if (n16 >= getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(intValue).func_75211_c())) {
                                            valence3 = 1;
                                        }
                                        else {
                                            valence3 = 0;
                                        }
                                    }
                                    n14 = valence3;
                                }
                                n15 = ((b14 = (contains = (delayComplete = (n14 != 0)))) ? 1 : 0);
                            }
                            Label_1312: {
                                if (b == null) {
                                    if (!b14) {
                                        break Label_1312;
                                    }
                                    b6 = false;
                                    contains = ((n15 = ((delayComplete = this.droptimer.isDelayComplete(300L)) ? 1 : 0)) != 0);
                                }
                                Label_1267: {
                                    if (b != null) {
                                        break Label_1267;
                                    }
                                    if (n15 == 0 && b == null) {
                                        continue Label_0560_Outer;
                                    }
                                    final Class263 aes_UTILS = Class139.AES_UTILS;
                                    final String hwid_VERIFY = Class139.HWID_VERIFY;
                                    try {
                                        delayComplete = (contains = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID()));
                                        Label_1286: {
                                            if (b == null) {
                                                if (contains) {
                                                    break Label_1286;
                                                }
                                                FMLCommonHandler.instance().exitJava(0, true);
                                                delayComplete = true;
                                            }
                                            Class258.sleep = delayComplete;
                                        }
                                    }
                                    catch (Exception ex) {
                                        FMLCommonHandler.instance().exitJava(0, true);
                                        Class258.sleep = true;
                                    }
                                }
                                this.droptimer.lastMs = System.currentTimeMillis();
                            }
                            if (b != null) {
                                break;
                            }
                        }
                    }
                    break;
                }
                if (b != null) {
                    break;
                }
            }
            boolean b10;
            boolean openedInventory2 = b10 = b6;
            continue;
        }
    }
    
    private void changeArmor() {
        final int[] b = Class139.b();
        final String[] array = { "boots", "leggings", "chestplate", "helmet" };
        final int[] array2 = b;
        int i = 0;
        while (i < 4) {
            final boolean booleanValue;
            final int n = (booleanValue = (boolean)this.insant.value) ? 1 : 0;
            Label_0358: {
                final int delayComplete;
                Label_0094: {
                    if (array2 == null) {
                        if (n == 0) {
                            delayComplete = (this.timeHelper.isDelayComplete((long)(Object)this.delay.value) ? 1 : 0);
                            if (array2 != null) {
                                break Label_0094;
                            }
                            if (delayComplete == 0) {
                                break Label_0358;
                            }
                        }
                        this.getBestInInventory(array[i]);
                    }
                }
                final int n2 = n;
                if (array2 == null && lllIIlllI$255f299(delayComplete)) {
                    if (array2 == null && AutoArmor.mc.field_71439_g.field_71071_by.field_70460_b[i] == null) {
                        AutoArmor.mc.field_71442_b.func_78753_a(0, n2, 0, 1, (EntityPlayer)AutoArmor.mc.field_71439_g);
                        this.timeHelper.lastMs = System.currentTimeMillis();
                        if (array2 == null) {
                            break Label_0358;
                        }
                    }
                    final int[] b2 = Class139.b();
                    final ItemStack func_75211_c = AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n2).func_75211_c();
                    Object func_77973_b = null;
                    Label_0217: {
                        if (b2 == null) {
                            if (func_75211_c == null) {
                                func_77973_b = null;
                                break Label_0217;
                            }
                            AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n2).func_75211_c();
                        }
                        func_77973_b = func_75211_c.func_77973_b();
                    }
                    final ItemArmor itemArmor = (ItemArmor)func_77973_b;
                    final Item func_77973_b2 = AutoArmor.mc.field_71439_g.field_71071_by.field_70460_b[i].func_77973_b();
                    Label_0353: {
                        if (array2 == null) {
                            final int[] b3 = Class139.b();
                            boolean b5;
                            final boolean b4 = b5 = (itemArmor instanceof ItemArmor);
                            final int field_77879_b;
                            if (b3 == null) {
                                if (b4) {
                                    final boolean b6 = b5 = (func_77973_b2 instanceof ItemArmor);
                                    if (b3 == null) {
                                        if (b6) {
                                            final ItemArmor itemArmor2 = itemArmor;
                                            final ItemArmor itemArmor3 = (ItemArmor)func_77973_b2;
                                            field_77879_b = itemArmor2.field_77879_b;
                                            if (b3 == null && !lllIIllll(field_77879_b, itemArmor3.field_77879_b)) {}
                                        }
                                    }
                                }
                            }
                            if (field_77879_b == 0) {
                                break Label_0353;
                            }
                            AutoArmor.mc.field_71442_b.func_78753_a(0, 8 - i, 0, 1, (EntityPlayer)AutoArmor.mc.field_71439_g);
                        }
                        this.timeHelper.lastMs = System.currentTimeMillis();
                    }
                }
            }
            ++i;
            if (array2 != null) {
                break;
            }
        }
    }
    
    private int getBestArmor(final String s) {
        return this.getBestInInventory(s);
    }
    
    private static boolean isBetter(final Item item, final Item item2) {
        final int[] b = Class139.b();
        final boolean b2 = item instanceof ItemArmor;
        if (b == null) {
            if (b2) {
                final boolean b3 = item2 instanceof ItemArmor;
                if (b == null) {
                    if (b3) {
                        final ItemArmor itemArmor = (ItemArmor)item;
                        final ItemArmor itemArmor2 = (ItemArmor)item2;
                        int field_77879_b;
                        final int n = field_77879_b = itemArmor.field_77879_b;
                        if (b == null) {
                            if (!lllIIllll(n, itemArmor2.field_77879_b)) {
                                return false;
                            }
                            field_77879_b = (true ? 1 : 0);
                        }
                        return field_77879_b != 0;
                    }
                }
            }
        }
        return b2;
    }
    
    private static Item getInventoryItem(final int n) {
        final int[] b = Class139.b();
        final ItemStack func_75211_c = AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c();
        if (b == null) {
            if (func_75211_c == null) {
                return null;
            }
            AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c();
        }
        return func_75211_c.func_77973_b();
    }
    
    private void clearLists() {
        final int[] b = Class139.b();
        final Iterator<ItemStack> iterator = (Iterator<ItemStack>)this.closeList.iterator();
        final int[] array = b;
    Label_0132:
        while (iterator.hasNext()) {
            final ItemStack itemStack = iterator.next();
            final InventoryPlayer field_71071_by = AutoArmor.mc.field_71439_g.field_71071_by;
            int i = 0;
            while (true) {
                while (i < 45) {
                    final ItemStack func_75211_c = AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                    if (array == null) {
                        final ItemStack itemStack2 = func_75211_c;
                        if (array == null) {
                            if (itemStack2 != null) {
                                final ItemStack itemStack3 = itemStack;
                                if (array == null && itemStack3 != func_75211_c) {}
                            }
                            ++i;
                        }
                        else {
                            if (itemStack2 == null) {
                                this.closeList.remove(itemStack);
                            }
                            if (array != null) {
                                break Label_0132;
                            }
                            continue Label_0132;
                        }
                    }
                    if (array != null) {
                        break;
                    }
                }
                continue;
            }
        }
    }
    
    private static void putOnItem(int n, final int n2) {
        final int[] b;
        if ((b = Class139.b()) == null) {
            if (lllIIlllI$255f299(n)) {
                if (b != null) {
                    return;
                }
                if (AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c() != null) {
                    AutoArmor.mc.field_71439_g.field_71069_bz.func_75144_a(n, 0, 4, (EntityPlayer)AutoArmor.mc.field_71439_g);
                    AutoArmor.mc.field_71442_b.func_78753_a(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c, n, 1, 4, (EntityPlayer)AutoArmor.mc.field_71439_g);
                }
            }
            n = n2;
            AutoArmor.mc.field_71442_b.func_78753_a(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c, n, 1, 1, (EntityPlayer)AutoArmor.mc.field_71439_g);
        }
    }
    
    private static void dropOldArmor(final int n) {
        AutoArmor.mc.field_71439_g.field_71069_bz.func_75144_a(n, 0, 4, (EntityPlayer)AutoArmor.mc.field_71439_g);
        AutoArmor.mc.field_71442_b.func_78753_a(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c, n, 1, 4, (EntityPlayer)AutoArmor.mc.field_71439_g);
    }
    
    private static void inventoryAction(final int n) {
        AutoArmor.mc.field_71442_b.func_78753_a(AutoArmor.mc.field_71439_g.field_71069_bz.field_75152_c, n, 1, 1, (EntityPlayer)AutoArmor.mc.field_71439_g);
    }
    
    private static List<String> getArmors() {
        return Arrays.asList("helmet", "leggings", "chestplate", "boots");
    }
    
    private int[] getIdsByName(final String s) {
        final int[] b = Class139.b();
        final int hashCode;
        final int n = hashCode = s.hashCode();
        final int equals;
        if (b == null) {
            Label_0118: {
                switch (n) {
                    case -1220934547: {
                        equals = (s.equals("helmet") ? 1 : 0);
                        if (b != null) {
                            break;
                        }
                        if (equals != 0 && b != null) {
                            break Label_0118;
                        }
                        break;
                    }
                    case 93922241: {
                        final boolean equals2 = s.equals("boots");
                        if (b != null) {
                            break;
                        }
                        if (equals2 && b != null) {
                            break Label_0118;
                        }
                        break;
                    }
                    case 1069952181: {
                        final boolean equals3 = s.equals("chestplate");
                        if (b != null) {
                            break;
                        }
                        if (equals3 && b != null) {
                            break Label_0118;
                        }
                        break;
                    }
                    case 1735676010: {
                        final boolean equals4 = s.equals("leggings");
                        if (b != null) {
                            break;
                        }
                        if (equals4) {
                            break;
                        }
                        break;
                    }
                }
            }
        }
        if (b == null) {
            switch (n) {
                case 0: {
                    return this.itemHelmet;
                }
                case 1: {
                    return this.itemBoots;
                }
                case 2: {
                    return this.itemChestplate;
                }
                case 3: {
                    return this.itemLeggings;
                }
            }
        }
        return new int[equals];
    }
    
    private List<Integer> findArmor(final String s) {
        final int[] b = Class139.b();
        final int[] b2 = Class139.b();
        final int hashCode;
        final int n = hashCode = s.hashCode();
        final int equals;
        if (b2 == null) {
            Label_0129: {
                switch (n) {
                    case -1220934547: {
                        equals = (s.equals("helmet") ? 1 : 0);
                        if (b2 != null) {
                            break;
                        }
                        if (equals != 0 && b2 != null) {
                            break Label_0129;
                        }
                        break;
                    }
                    case 93922241: {
                        final boolean equals2 = s.equals("boots");
                        if (b2 != null) {
                            break;
                        }
                        if (equals2 && b2 != null) {
                            break Label_0129;
                        }
                        break;
                    }
                    case 1069952181: {
                        final boolean equals3 = s.equals("chestplate");
                        if (b2 != null) {
                            break;
                        }
                        if (equals3 && b2 != null) {
                            break Label_0129;
                        }
                        break;
                    }
                    case 1735676010: {
                        final boolean equals4 = s.equals("leggings");
                        if (b2 != null) {
                            break;
                        }
                        if (equals4) {
                            break;
                        }
                        break;
                    }
                }
            }
        }
        int[] array = null;
        Label_0215: {
            if (b2 == null) {
                switch (n) {
                    case 0: {
                        array = this.itemHelmet;
                        break Label_0215;
                    }
                    case 1: {
                        array = this.itemBoots;
                        break Label_0215;
                    }
                    case 2: {
                        array = this.itemChestplate;
                        break Label_0215;
                    }
                    case 3: {
                        array = this.itemLeggings;
                        break Label_0215;
                    }
                }
            }
            array = new int[equals];
        }
        final int[] array2 = array;
        final ArrayList<Integer> list = new ArrayList<Integer>();
        final int[] array3 = b;
        int n2 = 9;
    Label_0350:
        do {
            AutoArmor.mc.field_71439_g.field_71069_bz.func_75138_a().size();
            int i = 0;
            int n3 = 0;
        Label_0248:
            while (i < n3) {
                final ItemStack func_75211_c = AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n2).func_75211_c();
                if (array3 == null) {
                    if (func_75211_c != null) {
                        final int func_150891_b = Item.func_150891_b(func_75211_c.func_77973_b());
                        final int[] array4;
                        final int length = (array4 = array2).length;
                        int j = 0;
                        while (j < length) {
                            final int n4 = array4[j];
                            if (array3 == null) {
                                i = func_150891_b;
                                n3 = n4;
                                if (array3 != null) {
                                    continue Label_0248;
                                }
                                if (i == n3) {
                                    list.add(n2);
                                }
                                ++j;
                            }
                            if (array3 != null) {
                                break;
                            }
                        }
                    }
                    ++n2;
                    continue Label_0350;
                }
                continue Label_0350;
            }
            break;
        } while (array3 == null);
        return list;
    }
    
    private int getBestInInventory(final String s) {
        final int[] b = Class139.b();
        int n = -1;
        final int[] array = b;
        int n2 = 0;
        for (final int intValue : this.findArmor(s)) {
            if (array == null) {
                n2 = n;
                if (array != null) {
                    return n2;
                }
                if (n2 == -1) {
                    n = intValue;
                }
            }
            final Slot func_75139_a = AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(intValue);
            Label_0167: {
                if (array == null) {
                    if (func_75139_a == null) {
                        break Label_0167;
                    }
                    AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(intValue);
                }
                int n4;
                final int n3 = n4 = ((func_75139_a.func_75211_c().func_77973_b() instanceof ItemArmor) ? 1 : 0);
                if (array == null) {
                    if (n3 == 0 && array == null) {
                        continue;
                    }
                    final int valence;
                    n4 = (valence = getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(intValue).func_75211_c()));
                }
                if (array == null) {
                    if (lllIllIIl(n3, getValence(AutoArmor.mc.field_71439_g.field_71069_bz.func_75139_a(n).func_75211_c())) && array == null) {
                        continue;
                    }
                    n4 = intValue;
                }
                n = n4;
            }
            if (array != null) {
                break;
            }
        }
        return n2;
    }
    
    private static int getSlotByName(final String s) {
        final int[] b = Class139.b();
        int n = -1;
        final int[] array = b;
        int n2 = -1;
        int n4;
        final int n3 = n4 = s.hashCode();
        Label_0135: {
            if (array == null) {
                Label_0118: {
                    switch (n3) {
                        case -1220934547: {
                            final boolean b2;
                            final int n5 = (b2 = ((n4 = (s.equals("helmet") ? 1 : 0)) != 0)) ? 1 : 0;
                            if (array != null) {
                                break Label_0135;
                            }
                            if (n5 == 0) {
                                break;
                            }
                            n2 = (false ? 1 : 0);
                            if (array != null) {
                                break Label_0118;
                            }
                            break;
                        }
                        case 93922241: {
                            final boolean b2;
                            final int n6 = (b2 = ((n4 = (s.equals("boots") ? 1 : 0)) != 0)) ? 1 : 0;
                            if (array != null) {
                                break Label_0135;
                            }
                            if (n6 == 0) {
                                break;
                            }
                            n2 = (true ? 1 : 0);
                            if (array != null) {
                                break Label_0118;
                            }
                            break;
                        }
                        case 1069952181: {
                            final boolean b2;
                            final int n7 = (b2 = ((n4 = (s.equals("chestplate") ? 1 : 0)) != 0)) ? 1 : 0;
                            if (array != null) {
                                break Label_0135;
                            }
                            if (n7 == 0) {
                                break;
                            }
                            n2 = 2;
                            if (array != null) {
                                break Label_0118;
                            }
                            break;
                        }
                        case 1735676010: {
                            final boolean b2;
                            final int n8 = (b2 = ((n4 = (s.equals("leggings") ? 1 : 0)) != 0)) ? 1 : 0;
                            if (array != null) {
                                break Label_0135;
                            }
                            if (n8 != 0) {
                                n2 = 3;
                                break;
                            }
                            break;
                        }
                    }
                }
                boolean b2;
                n4 = ((b2 = (n2 != 0)) ? 1 : 0);
            }
        }
        if (array == null) {
            Label_0189: {
                switch (n3) {
                    case 0: {
                        n = 5;
                        if (array != null) {
                            break Label_0189;
                        }
                        break;
                    }
                    case 1: {
                        n = 8;
                        if (array != null) {
                            break Label_0189;
                        }
                        break;
                    }
                    case 2: {
                        n = 6;
                        if (array != null) {
                            break Label_0189;
                        }
                        break;
                    }
                    case 3: {
                        n = 7;
                        break;
                    }
                }
            }
            n4 = n;
        }
        return n4;
    }
    
    private static double getProtectionValue(final ItemStack itemStack) {
        final int[] b = Class139.b();
        int field_77879_b;
        final boolean b2 = (field_77879_b = ((itemStack.func_77973_b() instanceof ItemArmor) ? 1 : 0)) != 0;
        if (b == null) {
            if (!b2) {
                return 0.0;
            }
            field_77879_b = ((ItemArmor)itemStack.func_77973_b()).field_77879_b;
        }
        return field_77879_b + (100 - ((ItemArmor)itemStack.func_77973_b()).field_77879_b * 4) * EnchantmentHelper.func_77506_a(Enchantment.field_180310_c.field_77352_x, itemStack) * 4 * 0.0075 + EnchantmentHelper.func_77506_a(Enchantment.field_77329_d.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_180309_e.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_77327_f.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_180308_g.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_180317_h.field_77352_x, itemStack) + EnchantmentHelper.func_77506_a(Enchantment.field_180308_g.field_77352_x, itemStack);
    }
    
    private static int getValence(final ItemStack itemStack) {
        final int[] b = Class139.b();
        int n = 0;
        final int[] array = b;
        ItemStack itemStack2 = itemStack;
        ItemStack itemStack3 = itemStack;
        ItemStack itemStack4 = itemStack;
        if (array == null) {
            if (itemStack == null) {
                return 0;
            }
            itemStack2 = itemStack;
            itemStack3 = itemStack;
            itemStack4 = itemStack;
        }
        if (array == null) {
            if (itemStack4.func_77973_b() instanceof ItemArmor) {
                n = 0 + ((ItemArmor)itemStack.func_77973_b()).field_77879_b;
            }
            itemStack2 = itemStack;
            itemStack3 = itemStack;
        }
        if (array == null) {
            if (itemStack3 == null) {
                return n + (int)getProtectionValue(itemStack) + (itemStack.func_77958_k() - itemStack.func_77952_i());
            }
            itemStack2 = itemStack;
        }
        int func_77942_o;
        final boolean b2 = (func_77942_o = (itemStack2.func_77942_o() ? 1 : 0)) != 0;
        if (array != null) {
            return func_77942_o;
        }
        if (b2) {
            n = n + (int)itemStack.func_77986_q().func_150305_b(0).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(1).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(2).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(3).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(4).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(5).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(6).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(7).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(8).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(9).func_74769_h("lvl") + (int)itemStack.func_77986_q().func_150305_b(34).func_74769_h("lvl");
        }
        func_77942_o = n + (int)getProtectionValue(itemStack) + (itemStack.func_77958_k() - itemStack.func_77952_i());
        return func_77942_o;
    }
    
    static {
        lIlIIIIlI();
        Class169.a(-2771028169249610668L, 3750890321595262091L, MethodHandles.lookup().lookupClass()).a(228954819063234L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(AutoArmor.llllIII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(AutoArmor.llllIII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(78449918434913L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[16];
        int n2 = 0;
        String s;
        int n3 = (s = AutoArmor.llllIII[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(AutoArmor.llllIII[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = AutoArmor.llllIII[3]).length();
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
        d = new String[16];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5ACB;
        if (AutoArmor.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = AutoArmor.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(AutoArmor.llllIII[5]);
                    array[1] = SecretKeyFactory.getInstance(AutoArmor.llllIII[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    AutoArmor.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(AutoArmor.llllIII[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            AutoArmor.d[n3] = b(((Cipher)array[0]).doFinal(AutoArmor.c[n3].getBytes(AutoArmor.llllIII[8])));
        }
        return AutoArmor.d[n3];
    }
    
    private static void lIlIIIIlI() {
        (llllIII = new String[12])[0] = "DES/CBC/PKCS5Padding";
        AutoArmor.llllIII[1] = "DES";
        AutoArmor.llllIII[2] = "C\u001d«µ\u007f®ÎGûn£.mÂ\u0017¸\u0010¦Ú¸Ø½äì&òáó+\u0083ÐÑ2\u00182´íÖ\u0096>O\u008c\u0002\u0088î½pV¿\u0083¥Ù%\fnú\u001c%\u0010æ- \u0091\r?3\u001a>>·®Ð\u0097\u008fl(Ú\u0019\u008bq\u0010þ\u0087º\u0094Zl \u0007Ïýújx\u008e³\u0091ËZÏÇ\u001dïIÛl\r¨\u0089æy9\u008a4\u001cû\u0010,K°ò §µív}ï\u001béÆ<Í(\u001dÔ+Ùãÿ\u000eeùó¬( \u008d]ðnÜ\u0013Ñ\u009fà\u0081»³ßN~R86[£\u0015\u009c®\u001bm\u0081ü \u001f\u000bA\u0016âéU\u001b¾lÅÿ|\u009cö|/,ñA\u009bj¨ñ»å\u008c;~+\u0098N\u0010ÛÆ|\u0090Ñi4ü¯<ä\u009d\u000fÏÕ\u0091 M×ÒäÂ² Æ\u0004¤\u0084g¨\u008c\u0016£\u0083KçÇ\u0012\u009bÂpqÅ%tÖî\"º\u0018\u008cfz*¸6\u001fÇhkZ\u008b3ê\u001a\u0017¼óµÌa#X\u00ad \u0005\u000b\u0015\bûËY¼àË\u008d\u0006\u0087ÀGå¹\u0017ØÔ¡.ÉæN\\2\u000b/\u009f\u0012í\u0018\u0099[\u001eâ þ\"?ê+H\f\u0080N¸\u000b \u009b+¢&\u0007b±\u0010\u0002\u0084,BÕ\u001d\u001dº\fåû\u0084E\u0099\u009a\u0088";
        AutoArmor.llllIII[3] = "sÊa\u009edíiA~²67í<çp<£\u009b\u007f\u0088\u009f¡\u001f.CÆaQ\u0019\u0092¨Blð*\u0090%:X\u0010»^a]´\u001fâÎI\u0005Èã\u0080ê?¥";
        AutoArmor.llllIII[4] = "ISO-8859-1";
        AutoArmor.llllIII[5] = "DES/CBC/PKCS5Padding";
        AutoArmor.llllIII[6] = "DES";
        AutoArmor.llllIII[7] = "请你按下ALT+F4关掉窗口开始逃避我好吗你干什么啊是不是气势凶凶了啊我指着你脑袋瓜子羞辱你了你认为就你这点词汇能把我打倒在这小小的网络世界中吗你难道不是疯疯癫癫的你还要逞能什么呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u2005\u2004\u200b";
        AutoArmor.llllIII[8] = "ISO-8859-1";
        AutoArmor.llllIII[9] = "请你按下ALT+F4关掉窗口开始逃避我好吗你干什么啊是不是气势凶凶了啊我指着你脑袋瓜子羞辱你了你认为就你这点词汇能把我打倒在这小小的网络世界中吗你难道不是疯疯癫癫的你还要逞能什么呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u2005\u2004\u200b";
        AutoArmor.llllIII[10] = " : ";
        AutoArmor.llllIII[11] = " : ";
    }
    
    private static String lIIllllII(String s, final String s2) {
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
    
    private static String lIIlllllI(final String s, final String s2) {
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
    
    private static String lIIllllIl(final String s, final String s2) {
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
    
    private static boolean lllIlIlIl(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lllIllIIl(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lllIIllll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lllIlIlll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lllIlIIIl(final int n) {
        return n >= 0;
    }
    
    private static boolean lllIIlllI$255f299(final int n) {
        return n != -1;
    }
    
    private static int lllIIlIIl$2566aa8(final long n) {
        return lcmp(n, 200L);
    }
}
