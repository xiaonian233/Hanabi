package ClassSub;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import java.awt.*;
import cn.Hanabi.utils.fontmanager.*;
import org.lwjgl.opengl.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class338
{
    public static int x;
    public static int y;
    public static int windowWidth;
    public static int windowHeight;
    public static int wheelStateMod;
    public static int wheelStateValue;
    public int tX;
    public int tY;
    public int dragX;
    public int dragY;
    private static double wheelSmoothMod;
    private static double wheelSmoothValue;
    public static boolean isDraging;
    public boolean clickNotDraging;
    public Category category;
    public List<Class68> mods;
    public static Map<Value, Class339> booleanValueMap;
    private static Map<Value, Class194> doubleValueMap;
    public static Map<Value, Class70> modeValueMap;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIllIlll;
    
    public Class338(final Category category) {
        super();
        this.clickNotDraging = false;
        this.mods = new ArrayList<Class68>();
        this.category = category;
        Class338.x = -1;
        Class338.y = -1;
    }
    
    public final void createModUI() {
        this.mods.clear();
        final int[] b = Class139.b();
        final Iterator<Mod> iterator = Class4.getModList().iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final Mod mod;
            if ((mod = iterator.next()).category == this.category) {
                this.mods.add(new Class68(mod));
            }
            if (array != null) {
                break;
            }
        }
    }
    
    private void draw(final int tx, final int ty) {
        final int[] b = Class139.b();
        final ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
        final int[] array = b;
        Class338.windowWidth = (int)(scaledResolution.func_78326_a() * 0.5);
        Class338.windowHeight = (int)(scaledResolution.func_78328_b() * 0.6);
        int n2;
        int x;
        final int n = x = (n2 = Class338.windowWidth);
        int n5;
        int n4;
        final int n3 = n4 = (n5 = 370);
        if (array == null) {
            if (n < n3) {
                Class338.windowWidth = 370;
            }
            final int n6;
            x = (n6 = (n2 = Class338.windowHeight));
            final int n7;
            n4 = (n7 = (n5 = 240));
        }
        if (array == null) {
            if (n < n3) {
                Class338.windowHeight = 240;
            }
            x = Class338.x;
            n4 = -1;
        }
        Label_0144: {
            final int y;
            final int n8;
            Label_0140: {
                if (array == null) {
                    if (x != n4) {
                        y = Class338.y;
                        n8 = -1;
                        if (array != null) {
                            break Label_0140;
                        }
                        if (y != n8) {
                            break Label_0144;
                        }
                    }
                    Class338.x = scaledResolution.func_78326_a() / 2 - Class338.windowWidth / 2;
                    n2 = scaledResolution.func_78328_b() / 2;
                    n5 = Class338.windowHeight / 2;
                }
            }
            Class338.y = y - n8;
        }
        final int[] b2 = Class139.b();
        final ScaledResolution scaledResolution2 = new ScaledResolution(Minecraft.func_71410_x());
        final int[] array2 = b2;
        final boolean buttonDown = Mouse.isButtonDown(0);
        Label_0529: {
            Class338 class338 = null;
            Label_0525: {
                Label_0517: {
                    if (array2 == null && buttonDown) {
                        final boolean hover;
                        final boolean b3 = hover = isHover(Class338.x + Class338.windowWidth - 17, Class338.y, 10, 10, tx, ty);
                        if (array2 == null) {
                            if (b3) {
                                Minecraft.func_71410_x().func_147108_a((GuiScreen)null);
                                break Label_0529;
                            }
                            isHover(Class338.x, Class338.y, Class338.windowWidth, 15, tx, ty);
                        }
                        Label_0266: {
                            Label_0260: {
                                final boolean isDraging;
                                if (array2 == null) {
                                    if (!b3) {
                                        isDraging = Class338.isDraging;
                                        if (array2 == null) {
                                            if (!isDraging) {
                                                break Label_0260;
                                            }
                                        }
                                    }
                                }
                                Class338.isDraging = isDraging;
                                if (array2 == null) {
                                    break Label_0266;
                                }
                            }
                            this.clickNotDraging = true;
                        }
                        final boolean isDraging2 = Class338.isDraging;
                        if (array2 == null) {
                            if (!isDraging2) {
                                break Label_0517;
                            }
                            class338 = this;
                            if (array2 != null) {
                                break Label_0525;
                            }
                            final boolean clickNotDraging = this.clickNotDraging;
                        }
                        if (!isDraging2) {
                            this.dragX = tx - this.tX;
                            this.dragY = ty - this.tY;
                            double x2;
                            final double n9 = x2 = dcmpg((double)Class338.x, scaledResolution2.func_78326_a() * 0.155);
                            Label_0420: {
                                if (array2 == null) {
                                    if (n9 < 0) {
                                        Class338.x = (int)(scaledResolution2.func_78326_a() * 0.155) + 1;
                                        if (array2 == null) {
                                            break Label_0420;
                                        }
                                    }
                                    final int x3;
                                    x2 = (x3 = Class338.x);
                                }
                                final int n10 = scaledResolution2.func_78326_a() - Class338.windowWidth;
                                if (array2 == null) {
                                    if (lIIIIlllll((int)n9, n10)) {
                                        Class338.x = scaledResolution2.func_78326_a() - Class338.windowWidth - 1;
                                        if (array2 == null) {
                                            break Label_0420;
                                        }
                                    }
                                    x2 = Class338.x;
                                    final int dragX = this.dragX;
                                }
                                Class338.x = (int)(x2 + n10);
                            }
                            int n12;
                            final int n11 = n12 = Class338.y;
                            if (array2 == null) {
                                if (n11 < 0) {
                                    Class338.y = 1;
                                    if (array2 == null) {
                                        break Label_0517;
                                    }
                                }
                                final int y2;
                                n12 = (y2 = Class338.y);
                            }
                            final int n13 = scaledResolution2.func_78328_b() - Class338.windowHeight;
                            if (array2 == null) {
                                if (lIIIIlllll(n11, n13)) {
                                    Class338.y = scaledResolution2.func_78328_b() - Class338.windowHeight - 1;
                                    if (array2 == null) {
                                        break Label_0517;
                                    }
                                }
                                n12 = Class338.y;
                                final int dragY = this.dragY;
                            }
                            Class338.y = n12 + n13;
                            if (array2 != null) {
                                goto Label_0507;
                            }
                        }
                    }
                    else {
                        Class338.isDraging = buttonDown;
                        this.clickNotDraging = false;
                    }
                }
                this.tX = tx;
                class338 = this;
            }
            class338.tY = ty;
        }
        final int[] b4 = Class139.b();
        final int dWheel = Mouse.getDWheel();
        final int[] array3 = b4;
        int n16;
        int n15;
        final int n14 = n15 = (n16 = (isHover(Class338.x + 10, Class338.y + 25, 100, Class338.windowHeight - 35, tx, ty) ? 1 : 0));
        Label_0823: {
            if (array3 == null) {
                if (n14 != 0) {
                    int wheelStateMod;
                    int n18;
                    final int n17 = n18 = (wheelStateMod = dWheel);
                    if (array3 == null) {
                        if (n17 > 0) {
                            final int wheelStateMod2 = Class338.wheelStateMod;
                            if (array3 == null) {
                                if (wheelStateMod2 >= 0) {
                                    break Label_0823;
                                }
                                final int n19 = Class338.wheelStateMod + 1;
                            }
                            Class338.wheelStateMod = wheelStateMod2;
                            if (array3 == null) {
                                break Label_0823;
                            }
                        }
                        final int n20;
                        n18 = (n20 = (wheelStateMod = dWheel));
                    }
                    if (array3 == null) {
                        if (n17 >= 0) {
                            break Label_0823;
                        }
                        wheelStateMod = (n18 = Class338.wheelStateMod * 30);
                    }
                    final int n21 = this.mods.size() * -30;
                    if (array3 == null) {
                        if (!lIIIIlllll(n18, n21)) {
                            break Label_0823;
                        }
                        wheelStateMod = Class338.wheelStateMod;
                    }
                    Class338.wheelStateMod = wheelStateMod - n21;
                    if (array3 == null) {
                        break Label_0823;
                    }
                }
                final int n22;
                n15 = (n22 = (n16 = (isHover(Class338.x + 110, Class338.y + 25, Class338.windowWidth, Class338.windowHeight - 35, tx, ty) ? 1 : 0)));
            }
            if (array3 == null) {
                if (n14 == 0) {
                    break Label_0823;
                }
                n16 = (n15 = dWheel);
            }
            if (array3 == null) {
                if (n15 > 0) {
                    final int wheelStateValue = Class338.wheelStateValue;
                    if (array3 == null) {
                        if (wheelStateValue >= 0) {
                            break Label_0823;
                        }
                        final int n23 = Class338.wheelStateValue + 1;
                    }
                    Class338.wheelStateValue = wheelStateValue;
                    if (array3 == null) {
                        break Label_0823;
                    }
                }
                n16 = dWheel;
            }
            if (n16 < 0 && Class68.selectedMod != null) {
                final int n24 = Class338.wheelStateValue * 50;
                final int n25 = Class68.selectedMod.valueSize * -40;
                if (array3 == null) {
                    if (!lIIIIlllll(n24, n25)) {
                        break Label_0823;
                    }
                    final int wheelStateValue2 = Class338.wheelStateValue;
                }
                Class338.wheelStateValue = n24 - n25;
            }
        }
        final int[] b5 = Class139.b();
        int n27;
        final int n26 = n27 = (Class3.theme.isCurrentMode("Light") ? 1 : 0);
        if (b5 == null) {
            if (n26 != 0) {
                n27 = -921615;
            }
            else {
                n27 = new Color(27, 27, 27).getRGB();
            }
        }
        final int n28 = n27;
        int n30;
        final int n29 = n30 = (Class3.theme.isCurrentMode("Light") ? 1 : 0);
        if (b5 == null) {
            if (n29 != 0) {
                n30 = Class22.RED.c;
            }
            else {
                n30 = new Color(47, 116, 253).getRGB();
            }
        }
        final int n31 = n30;
        int n32;
        final boolean b6 = (n32 = (Class3.theme.isCurrentMode("Light") ? 1 : 0)) != 0;
        Label_1025: {
            if (b5 == null) {
                if (!b6) {
                    Class69.drawRoundedRect(Class338.x - 0.5f, Class338.y - 0.5f, Class338.x + Class338.windowWidth + 0.5f, Class338.y + Class338.windowHeight + 0.5f, 6.0f, new Color(16, 76, 182).getRGB());
                    if (b5 == null) {
                        break Label_1025;
                    }
                }
                n32 = Class338.x;
            }
            Class69.drawRoundedRect(n32 - 1.0f, Class338.y - 1.0f, Class338.x + Class338.windowWidth + 1.0f, Class338.y + Class338.windowHeight + 1.0f, 6.0f, n28);
        }
        Class69.drawRoundedRect(Class338.x, Class338.y, Class338.x + Class338.windowWidth, Class338.y + Class338.windowHeight, 6.0f, n28);
        final float n33 = Class338.x + 2;
        final float n34 = Class338.y + 14;
        final float n35 = Class338.x + Class338.windowWidth - 2;
        final float n36 = Class338.y + Class338.windowHeight - 2;
        final float n37 = 6.0f;
        final int currentMode = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (b5 == null) {
            if (currentMode != 0) {
                new Color(Class22.GREY.c).brighter().brighter().getRGB();
            }
            else {
                new Color(13, 13, 13).getRGB();
            }
        }
        Class69.drawRoundedRect(n33, n34, n35, n36, n37, currentMode);
        Class69.circle(Class338.x + Class338.windowWidth - 10, Class338.y + 8, 2.5f, n31);
        final UnicodeFontRenderer raleway16 = Class139.INSTANCE.fontManager.raleway16;
        final String string = this.category.toString();
        final int n38 = Class338.x + 8;
        final int n39 = Class338.y + 3;
        final int currentMode2 = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (b5 == null) {
            if (currentMode2 != 0) {
                final int c = Class22.BLACK.c;
            }
            else {
                new Color(167, 167, 167).getRGB();
            }
        }
        raleway16.func_78276_b(string, n38, n39, currentMode2);
        this.drawModList();
        this.drawValueList$255f295(tx);
    }
    
    final void drawValueList$255f295(final int isDraging) {
        final int[] b = Class139.b();
        final Mod selectedMod = Class68.selectedMod;
        if (b == null) {
            if (selectedMod == null) {
                return;
            }
            final Mod selectedMod2 = Class68.selectedMod;
        }
        final Mod mod = selectedMod;
        final UnicodeFontRenderer usans18 = Class139.INSTANCE.fontManager.usans18;
        final String name = mod.getName();
        final int n = Class338.x + 120;
        final int n2 = Class338.y + 30;
        final int currentMode = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (b == null) {
            if (currentMode != 0) {
                final int c = Class22.BLACK.c;
            }
            else {
                new Color(167, 167, 167).getRGB();
            }
        }
        usans18.func_78276_b(name, n, n2, currentMode);
        final Class339 modButton = mod.modButton;
        if (b == null) {
            if (modButton == null) {
                mod.modButton = new Class80(this, mod.getName(), mod.state, mod);
            }
            mod.modButton.draw(Class338.x + Class338.windowWidth - 35, Class338.y + 36);
            final Class339 modButton2 = mod.modButton;
        }
        modButton.state = mod.state;
        Class69.drawRect(Class338.x + 115, Class338.y + 45, Class338.x + Class338.windowWidth - 15, Class338.y + 45.3f, new Color(40, 40, 40).getRGB());
        final ArrayList<Value> list = new ArrayList<Value>();
        final ArrayList<Value> list2 = new ArrayList<Value>();
        final ArrayList<Value> list3 = new ArrayList<Value>();
        list.clear();
        list2.clear();
        list3.clear();
        mod.valueSize = 0;
        final Iterator<Value> iterator = Value.list.iterator();
        while (true) {
            while (iterator.hasNext()) {
                final Value value;
                final int equals;
                boolean b3;
                int isValueMode;
                final boolean b2 = (isValueMode = ((b3 = ((equals = ((value = iterator.next()).name.split(Class338.lIllIlll[0])[0].equals(mod.getName()) ? 1 : 0)) != 0)) ? 1 : 0)) != 0;
                if (b == null) {
                    Label_0399: {
                        if (b == null) {
                            if (!b2) {
                                break Label_0399;
                            }
                            final Mod mod2 = mod;
                            ++mod2.valueSize;
                            final boolean b4;
                            isValueMode = ((b4 = (b3 = value.isValueDouble)) ? 1 : 0);
                        }
                        if (b == null) {
                            if (b2) {
                                list3.add(value);
                            }
                            b3 = ((isValueMode = (value.isValueMode ? 1 : 0)) != 0);
                        }
                        if (b == null) {
                            if (isValueMode != 0) {
                                list2.add(value);
                            }
                            b3 = value.isValueBoolean;
                        }
                        if (b == null) {
                            if (b3) {
                                list.add(value);
                            }
                        }
                    }
                    if (b != null) {
                        break;
                    }
                    continue;
                }
                else {
                    int n3 = equals + 60;
                    final Iterator<Object> iterator2 = list.iterator();
                    int valueSize = 0;
                Label_1952:
                    while (true) {
                        while (iterator2.hasNext()) {
                            final Value value2;
                            final String s = (value2 = iterator2.next()).name.split(Class338.lIllIlll[1])[0];
                            final String s2 = value2.name.split(Class338.lIllIlll[2])[1];
                            final UnicodeFontRenderer usans19 = Class139.INSTANCE.fontManager.usans16;
                            final String s3 = s2;
                            final int n4 = Class338.x + 120;
                            final int n5 = n3;
                            int n7;
                            final int currentMode2;
                            final int n6 = currentMode2 = (n7 = (Class3.theme.isCurrentMode("Light") ? 1 : 0));
                            if (b != null) {
                                if (b == null) {
                                    if (currentMode2 != 0) {
                                        n7 = new Color(Class22.BLACK.c).brighter().brighter().getRGB();
                                    }
                                    else {
                                        n7 = new Color(167, 167, 167).getRGB();
                                    }
                                }
                                usans19.func_78276_b(s3, n4, n5, n7);
                                goto Label_2004;
                            }
                            if (b == null) {
                                if (n6 != 0) {
                                    final int c2 = Class22.BLACK.c;
                                }
                                else {
                                    new Color(167, 167, 167).getRGB();
                                }
                            }
                            usans19.func_78276_b(s3, n4, n5, n6);
                            final Map<Value, Class339> booleanValueMap = Class338.booleanValueMap;
                            final Value value3 = value2;
                            Class339 class339 = null;
                            Label_0672: {
                                if (b == null) {
                                    if (!booleanValueMap.containsKey(value3)) {
                                        class339 = new Class350(s, (boolean)value2.value, value2);
                                        Class338.booleanValueMap.put(value2, class339);
                                        break Label_0672;
                                    }
                                    final Map<Value, Class339> booleanValueMap2 = Class338.booleanValueMap;
                                }
                                class339 = booleanValueMap.get(value3);
                            }
                            class339.draw(Class338.x + Class338.windowWidth - 35, n3 + 5.5f);
                            n3 += 30;
                            if (b != null) {
                                break;
                            }
                        }
                        final Iterator<Object> iterator3 = list3.iterator();
                        while (iterator3.hasNext()) {
                            final Value value4;
                            final String s4 = (value4 = iterator3.next()).name.split(Class338.lIllIlll[3])[1];
                            final UnicodeFontRenderer usans20 = Class139.INSTANCE.fontManager.usans16;
                            final String s5 = s4;
                            final int n8 = Class338.x + 120;
                            final int n9 = n3;
                            final int n7;
                            final int currentMode2;
                            final int n10 = currentMode2 = (n7 = (Class3.theme.isCurrentMode("Light") ? 1 : 0));
                            if (b != null) {
                                continue Label_1952;
                            }
                            if (b == null) {
                                if (n10 != 0) {
                                    final int c3 = Class22.BLACK.c;
                                }
                                else {
                                    new Color(167, 167, 167).getRGB();
                                }
                            }
                            usans20.func_78276_b(s5, n8, n9, n10);
                            final Map<Value, Class194> doubleValueMap = Class338.doubleValueMap;
                            final Value value5 = value4;
                            Class194 class340 = null;
                            Label_0875: {
                                if (b == null) {
                                    if (!doubleValueMap.containsKey(value5)) {
                                        class340 = new Class194(value4);
                                        Class338.doubleValueMap.put(value4, class340);
                                        break Label_0875;
                                    }
                                    final Map<Value, Class194> doubleValueMap2 = Class338.doubleValueMap;
                                }
                                class340 = doubleValueMap.get(value5);
                            }
                            final Class194 class341 = class340;
                            final float n11 = Class338.x + Class338.windowWidth;
                            final float n12 = n3;
                            final float x = n11;
                            final Class194 class342 = class341;
                            final int[] b5 = Class139.b();
                            class342.x = x;
                            final int[] array = b5;
                            final UnicodeFontRenderer comfortaa16 = Class139.INSTANCE.fontManager.comfortaa16;
                            final double n13 = (class342.value.value - class342.value.getValueMin()) / (class342.value.getValueMax() - class342.value.getValueMin());
                            final UnicodeFontRenderer unicodeFontRenderer = comfortaa16;
                            final String s6 = class342.value.name.split(Class194.llIllIllIll[0])[1];
                            final float n14 = x + 120.0f;
                            final float n15 = n12;
                            final Color color = new Color(212, 212, 212);
                            int n17 = 0;
                            Label_1141: {
                                if (array == null) {
                                    unicodeFontRenderer.drawString(s6, n14, n15, color.getRGB());
                                    String.valueOf(new StringBuilder().append(class342.value.value).append(Class194.llIllIllIll[1]));
                                    final float n16 = x - 165.0f - comfortaa16.func_78256_a(String.valueOf(new StringBuilder().append(class342.value.value).append(Class194.llIllIllIll[2])));
                                    if (Class3.theme.isCurrentMode("Light")) {
                                        n17 = Class22.GREY.c;
                                        break Label_1141;
                                    }
                                    final Color color2 = new Color(212, 212, 212);
                                }
                                n17 = color.getRGB();
                            }
                            unicodeFontRenderer.drawString(s6, n14, n15, n17);
                            final Class194 class343 = class342;
                            if (array != null || (class343.ani == 0.0 || Class338.isDraging)) {
                                class343.ani = (float)(x - 15.0f - (140.0 - n13 * 140.0));
                            }
                            final Class194 class344 = class342;
                            class344.ani = Class69.getAnimationState(class344.ani, (float)(x - 15.0f - (140.0 - n13 * 140.0)), 600.0);
                            final float n18 = x - 155.0f;
                            final float n19 = n12 + 3.0f;
                            final float n20 = x - 15.0f;
                            final float n21 = n12 + 6.0f;
                            final float n22 = 1.0f;
                            final int currentMode3 = Class3.theme.isCurrentMode("Light") ? 1 : 0;
                            if (array == null) {
                                if (currentMode3 != 0) {
                                    final int c4 = Class22.GREY.c;
                                }
                                else {
                                    new Color(27, 27, 27).getRGB();
                                }
                            }
                            Class69.drawRoundedRect(n18, n19, n20, n21, n22, currentMode3);
                            final float n23 = x - 155.0f;
                            final float n24 = n12 + 3.0f;
                            final float n25 = (float)class342.ani;
                            final float n26 = n12 + 6.0f;
                            final float n27 = 1.0f;
                            final int currentMode4 = Class3.theme.isCurrentMode("Light") ? 1 : 0;
                            if (array == null) {
                                if (currentMode4 != 0) {
                                    new Color(-14848033).brighter().getRGB();
                                }
                                else {
                                    new Color(16, 72, 182).getRGB();
                                }
                            }
                            Class69.drawRoundedRect(n23, n24, n25, n26, n27, currentMode4);
                            final float n28 = (float)class342.ani;
                            final float n29 = n12 + 4.5f;
                            final float n30 = 3.0f;
                            final int currentMode5 = Class3.theme.isCurrentMode("Light") ? 1 : 0;
                            if (array == null) {
                                if (currentMode5 != 0) {
                                    new Color(-14848033).brighter().getRGB();
                                }
                                else {
                                    new Color(29, 111, 223).getRGB();
                                }
                            }
                            Class69.circle(n28, n29, n30, currentMode5);
                            final Class194 class345 = class340;
                            final int[] b6 = Class139.b();
                            new ScaledResolution(Minecraft.func_71410_x());
                            final int[] array2 = b6;
                            Label_1676: {
                                if (b6 == null) {
                                    if (Mouse.isButtonDown(0)) {
                                        class345.isDraging = (isDraging != 0);
                                        if (array2 != null) {
                                            class345.clickNotDraging = true;
                                        }
                                        final Class194 class346 = class345;
                                        if (array2 != null) {
                                            break Label_1676;
                                        }
                                        if (!class346.isDraging) {
                                            break Label_1676;
                                        }
                                        final Class194 class347 = class345;
                                        if (array2 != null) {
                                            break Label_1676;
                                        }
                                        if (class347.clickNotDraging) {
                                            break Label_1676;
                                        }
                                        double n32;
                                        final double n31 = dcmpg(n32 = (isDraging - class345.x + 155.0f) / 140.0f, 0.0);
                                        final double n33;
                                        double doubleValue = 0.0;
                                        Label_1617: {
                                            if (array2 == null) {
                                                if (n31 < 0) {
                                                    n32 = 0.0;
                                                }
                                                n33 = n32;
                                                doubleValue = 1.0;
                                                if (array2 != null) {
                                                    break Label_1617;
                                                }
                                                final double n34 = dcmpl(n33, 1.0);
                                            }
                                            if (n31 > 0) {
                                                n32 = 1.0;
                                            }
                                            final double n35 = (class345.value.getValueMax() - class345.value.getValueMin()) * n32;
                                            doubleValue = class345.value.getValueMin();
                                        }
                                        class345.value.value = Math.round((n33 + doubleValue) * (1.0 / class345.value.step)) / (1.0 / class345.value.step);
                                        if (array2 == null) {
                                            break Label_1676;
                                        }
                                    }
                                    class345.isDraging = false;
                                }
                                class345.clickNotDraging = false;
                            }
                            n3 += 30;
                            if (b != null) {
                                break;
                            }
                        }
                        for (final Value value7 : list2) {
                            final Value value6 = value7;
                            final Mod[] b7 = Value.b();
                            final Value value8 = value7;
                            final String s7 = (b7 == null && value8.isValueMode) ? value7.modeTitle : value8.name.split(Value.llIIIIIIIlI[3])[1];
                            final UnicodeFontRenderer usans21 = Class139.INSTANCE.fontManager.usans16;
                            final String s8 = s7;
                            final int n36 = Class338.x + 120;
                            final int n37 = n3;
                            final int n7;
                            final int currentMode2;
                            final int n38 = currentMode2 = (n7 = (Class3.theme.isCurrentMode("Light") ? 1 : 0));
                            if (b != null) {
                                continue Label_1952;
                            }
                            if (b == null) {
                                if (n38 != 0) {
                                    final int c5 = Class22.BLACK.c;
                                }
                                else {
                                    new Color(167, 167, 167).getRGB();
                                }
                            }
                            usans21.func_78276_b(s8, n36, n37, n38);
                            final Map<Value, Class70> modeValueMap = Class338.modeValueMap;
                            final Value value9 = value6;
                            Class70 class348 = null;
                            Label_1889: {
                                if (b == null) {
                                    if (!modeValueMap.containsKey(value9)) {
                                        class348 = new Class70(value6);
                                        Class338.modeValueMap.put(value6, class348);
                                        break Label_1889;
                                    }
                                    final Map<Value, Class70> modeValueMap2 = Class338.modeValueMap;
                                }
                                class348 = modeValueMap.get(value9);
                            }
                            class348.draw$3b4dfe4b(Class338.x + Class338.windowWidth, n3);
                            n3 += 30;
                            if (b != null) {
                                break;
                            }
                        }
                        valueSize = mod.valueSize;
                        if (b == null && valueSize == 0) {
                            final UnicodeFontRenderer usans22 = Class139.INSTANCE.fontManager.usans16;
                            final int n39 = Class338.x + 120;
                            final int n40 = Class338.y + 60;
                            final int currentMode2;
                            final int n7 = currentMode2 = (Class3.theme.isCurrentMode("Light") ? 1 : 0);
                            continue Label_1952;
                        }
                        break;
                    }
                    GL11.glDisable(valueSize);
                    GL11.glPopMatrix();
                    return;
                }
            }
            GL11.glPushMatrix();
            GL11.glEnable(3089);
            Class69.doGlScissor(Class338.x + 110, Class338.y + 45, Class338.windowWidth, Class338.windowHeight - 55);
            Class338.wheelSmoothValue = Class69.getAnimationState(Class338.wheelSmoothValue, Class338.wheelStateValue * 30, 400.0);
            int equals = (int)(Class338.y + Class338.wheelSmoothValue);
            continue;
        }
    }
    
    final void drawModList() {
        GL11.glPushMatrix();
        GL11.glEnable(3089);
        final int[] b = Class139.b();
        Class69.doGlScissor(Class338.x + 10, Class338.y + 25, 100, Class338.windowHeight - 35);
        final int[] array = b;
        Class338.wheelSmoothMod = Class69.getAnimationState(Class338.wheelSmoothMod, Class338.wheelStateMod * 30, 400.0);
        int n = (int)(Class338.y + Class338.wheelSmoothMod) + 25;
        for (final Class68 class68 : this.mods) {
            final int n2 = Class338.x + 10;
            final int n3 = n;
            final int n4 = n2;
            final Class68 class69 = class68;
            final int[] b2 = Class139.b();
            int selected;
            final boolean b3 = (selected = (class69.selected ? 1 : 0)) != 0;
            Label_0180: {
                if (b2 == null) {
                    if (!b3) {
                        break Label_0180;
                    }
                    Class68.selectedMod = class69.mod;
                    selected = n4;
                }
                final float n5 = selected;
                final float n6 = n3;
                final float n7 = n4 + 100;
                final float n8 = n3 + 25;
                final float n9 = 6.0f;
                final int currentMode = Class3.theme.isCurrentMode("Light") ? 1 : 0;
                if (b2 == null && currentMode == 0) {}
                Class69.drawRoundedRect(n5, n6, n7, n8, n9, currentMode);
            }
            final UnicodeFontRenderer usans16 = Class139.INSTANCE.fontManager.usans16;
            final String name = class69.mod.getName();
            final float n10 = n4 + 5;
            final float n11 = n3 + 12.5f - usans16.field_78288_b / 2;
            final int currentMode2 = Class3.theme.isCurrentMode("Light") ? 1 : 0;
            if (b2 == null) {
                if (currentMode2 != 0) {
                    final int c = Class22.BLACK.c;
                }
                else {
                    new Color(167, 167, 167).getRGB();
                }
            }
            usans16.drawString(name, n10, n11, currentMode2);
            final Class339 button = class69.button;
            if (b2 == null) {
                if (button == null) {
                    final Class68 class70 = class69;
                    final Class68 class71 = class69;
                    class70.button = new Class93(class71, class71.mod.getName(), class69.mod.state);
                }
                class69.button.draw(n4 + 85, n3 + 12.5f);
                final Class339 button2 = class69.button;
            }
            button.state = class69.mod.state;
            n += 35;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GL11.glDisable(3089);
        GL11.glPopMatrix();
    }
    
    private void drawBackground() {
        final int[] b = Class139.b();
        int n2;
        final int n = n2 = (Class3.theme.isCurrentMode("Light") ? 1 : 0);
        if (b == null) {
            if (n != 0) {
                n2 = -921615;
            }
            else {
                n2 = new Color(27, 27, 27).getRGB();
            }
        }
        final int n3 = n2;
        int n5;
        final int n4 = n5 = (Class3.theme.isCurrentMode("Light") ? 1 : 0);
        if (b == null) {
            if (n4 != 0) {
                n5 = Class22.RED.c;
            }
            else {
                n5 = new Color(47, 116, 253).getRGB();
            }
        }
        final int n6 = n5;
        int n7;
        final boolean b2 = (n7 = (Class3.theme.isCurrentMode("Light") ? 1 : 0)) != 0;
        Label_0196: {
            if (b == null) {
                if (!b2) {
                    Class69.drawRoundedRect(Class338.x - 0.5f, Class338.y - 0.5f, Class338.x + Class338.windowWidth + 0.5f, Class338.y + Class338.windowHeight + 0.5f, 6.0f, new Color(16, 76, 182).getRGB());
                    if (b == null) {
                        break Label_0196;
                    }
                }
                n7 = Class338.x;
            }
            Class69.drawRoundedRect(n7 - 1.0f, Class338.y - 1.0f, Class338.x + Class338.windowWidth + 1.0f, Class338.y + Class338.windowHeight + 1.0f, 6.0f, n3);
        }
        Class69.drawRoundedRect(Class338.x, Class338.y, Class338.x + Class338.windowWidth, Class338.y + Class338.windowHeight, 6.0f, n3);
        final float n8 = Class338.x + 2;
        final float n9 = Class338.y + 14;
        final float n10 = Class338.x + Class338.windowWidth - 2;
        final float n11 = Class338.y + Class338.windowHeight - 2;
        final float n12 = 6.0f;
        final int currentMode = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (b == null) {
            if (currentMode != 0) {
                new Color(Class22.GREY.c).brighter().brighter().getRGB();
            }
            else {
                new Color(13, 13, 13).getRGB();
            }
        }
        Class69.drawRoundedRect(n8, n9, n10, n11, n12, currentMode);
        Class69.circle(Class338.x + Class338.windowWidth - 10, Class338.y + 8, 2.5f, n6);
        final UnicodeFontRenderer raleway16 = Class139.INSTANCE.fontManager.raleway16;
        final String string = this.category.toString();
        final int n13 = Class338.x + 8;
        final int n14 = Class338.y + 3;
        final int currentMode2 = Class3.theme.isCurrentMode("Light") ? 1 : 0;
        if (b == null) {
            if (currentMode2 != 0) {
                final int c = Class22.BLACK.c;
            }
            else {
                new Color(167, 167, 167).getRGB();
            }
        }
        raleway16.func_78276_b(string, n13, n14, currentMode2);
    }
    
    private void processWheel(final int n, final int n2) {
        final int[] b = Class139.b();
        final int dWheel = Mouse.getDWheel();
        final int[] array = b;
        int n5;
        int n4;
        final int n3 = n4 = (n5 = (isHover(Class338.x + 10, Class338.y + 25, 100, Class338.windowHeight - 35, n, n2) ? 1 : 0));
        if (array == null) {
            if (n3 != 0) {
                int wheelStateMod;
                int n7;
                final int n6 = n7 = (wheelStateMod = dWheel);
                if (array == null) {
                    if (n6 > 0) {
                        final int wheelStateMod2 = Class338.wheelStateMod;
                        if (array == null) {
                            if (wheelStateMod2 >= 0) {
                                return;
                            }
                            final int n8 = Class338.wheelStateMod + 1;
                        }
                        Class338.wheelStateMod = wheelStateMod2;
                        if (array == null) {
                            return;
                        }
                    }
                    final int n9;
                    n7 = (n9 = (wheelStateMod = dWheel));
                }
                if (array == null) {
                    if (n6 >= 0) {
                        return;
                    }
                    wheelStateMod = (n7 = Class338.wheelStateMod * 30);
                }
                final int n10 = this.mods.size() * -30;
                if (array == null) {
                    if (!lIIIIlllll(n7, n10)) {
                        return;
                    }
                    wheelStateMod = Class338.wheelStateMod;
                }
                Class338.wheelStateMod = wheelStateMod - n10;
                if (array == null) {
                    return;
                }
            }
            final int n11;
            n4 = (n11 = (n5 = (isHover(Class338.x + 110, Class338.y + 25, Class338.windowWidth, Class338.windowHeight - 35, n, n2) ? 1 : 0)));
        }
        if (array == null) {
            if (n3 == 0) {
                return;
            }
            n5 = (n4 = dWheel);
        }
        if (array == null) {
            if (n4 > 0) {
                final int wheelStateValue = Class338.wheelStateValue;
                if (array == null) {
                    if (wheelStateValue >= 0) {
                        return;
                    }
                    final int n12 = Class338.wheelStateValue + 1;
                }
                Class338.wheelStateValue = wheelStateValue;
                if (array == null) {
                    return;
                }
            }
            n5 = dWheel;
        }
        if (n5 < 0 && Class68.selectedMod != null) {
            final int n13 = Class338.wheelStateValue * 50;
            final int n14 = Class68.selectedMod.valueSize * -40;
            if (array == null) {
                if (!lIIIIlllll(n13, n14)) {
                    return;
                }
                final int wheelStateValue2 = Class338.wheelStateValue;
            }
            Class338.wheelStateValue = n13 - n14;
        }
    }
    
    private void processDrag(final int tx, final int ty) {
        final int[] b = Class139.b();
        final ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
        final int[] array = b;
        final boolean buttonDown = Mouse.isButtonDown(0);
        Class338 class338 = null;
        Label_0348: {
            Label_0342: {
                if (array == null && buttonDown) {
                    final boolean hover;
                    final boolean b2 = hover = isHover(Class338.x + Class338.windowWidth - 17, Class338.y, 10, 10, tx, ty);
                    if (array == null) {
                        if (b2) {
                            Minecraft.func_71410_x().func_147108_a((GuiScreen)null);
                            return;
                        }
                        isHover(Class338.x, Class338.y, Class338.windowWidth, 15, tx, ty);
                    }
                    Label_0110: {
                        Label_0105: {
                            final boolean isDraging;
                            if (array == null) {
                                if (!b2) {
                                    isDraging = Class338.isDraging;
                                    if (array == null) {
                                        if (!isDraging) {
                                            break Label_0105;
                                        }
                                    }
                                }
                            }
                            Class338.isDraging = isDraging;
                            if (array == null) {
                                break Label_0110;
                            }
                        }
                        this.clickNotDraging = true;
                    }
                    final boolean isDraging2 = Class338.isDraging;
                    if (array == null) {
                        if (!isDraging2) {
                            break Label_0342;
                        }
                        class338 = this;
                        if (array != null) {
                            break Label_0348;
                        }
                        final boolean clickNotDraging = this.clickNotDraging;
                    }
                    if (!isDraging2) {
                        this.dragX = tx - this.tX;
                        this.dragY = ty - this.tY;
                        double x;
                        final double n = x = dcmpg((double)Class338.x, scaledResolution.func_78326_a() * 0.155);
                        Label_0252: {
                            if (array == null) {
                                if (n < 0) {
                                    Class338.x = (int)(scaledResolution.func_78326_a() * 0.155) + 1;
                                    if (array == null) {
                                        break Label_0252;
                                    }
                                }
                                final int x2;
                                x = (x2 = Class338.x);
                            }
                            final int n2 = scaledResolution.func_78326_a() - Class338.windowWidth;
                            if (array == null) {
                                if (lIIIIlllll((int)n, n2)) {
                                    Class338.x = scaledResolution.func_78326_a() - Class338.windowWidth - 1;
                                    if (array == null) {
                                        break Label_0252;
                                    }
                                }
                                x = Class338.x;
                                final int dragX = this.dragX;
                            }
                            Class338.x = (int)(x + n2);
                        }
                        int n4;
                        final int n3 = n4 = Class338.y;
                        if (array == null) {
                            if (n3 < 0) {
                                Class338.y = 1;
                                if (array == null) {
                                    break Label_0342;
                                }
                            }
                            final int y;
                            n4 = (y = Class338.y);
                        }
                        final int n5 = scaledResolution.func_78328_b() - Class338.windowHeight;
                        if (array == null) {
                            if (lIIIIlllll(n3, n5)) {
                                Class338.y = scaledResolution.func_78328_b() - Class338.windowHeight - 1;
                                if (array == null) {
                                    break Label_0342;
                                }
                            }
                            n4 = Class338.y;
                            final int dragY = this.dragY;
                        }
                        Class338.y = n4 + n5;
                        if (array != null) {
                            goto Label_0333;
                        }
                    }
                }
                else {
                    Class338.isDraging = buttonDown;
                    this.clickNotDraging = false;
                }
            }
            this.tX = tx;
            class338 = this;
        }
        class338.tY = ty;
    }
    
    public static boolean isHover(final int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        final int[] b = Class139.b();
        int n7 = n5;
        int n8 = n5;
        int n9 = n5;
        int n10 = n;
        int n11 = n;
        int n12 = n;
        if (b == null) {
            if (!lIIIlIIlII(n5, n)) {
                return false;
            }
            n7 = n5;
            n8 = n5;
            n9 = n5;
            n11 = (n12 = (n10 = n + n3));
        }
        if (b == null) {
            if (!lIIIlIIlIl(n9, n12)) {
                return false;
            }
            n7 = n6;
            n8 = n6;
            n10 = n2;
            n11 = n2;
        }
        if (b == null) {
            if (!lIIIlIIlII(n8, n11)) {
                return false;
            }
            final int n13 = n6;
            n7 = n6;
            if (b != null) {
                return n13 != 0;
            }
            n10 = n2 + n4;
        }
        if (!lIIIlIIlIl(n7, n10)) {
            return false;
        }
        final int n13 = true ? 1 : 0;
        return n13 != 0;
    }
    
    private void onMouseClick(final int n, final int n2) {
        final int[] b = Class139.b();
        Object o = this.mods.iterator();
        final int[] array = b;
        while (true) {
        Label_0132_Outer:
            while (((Iterator)o).hasNext()) {
                final Class68 class68 = ((Iterator<Class68>)o).next();
                boolean b3;
                final boolean b2 = b3 = isHover(Class338.x + 10, Class338.y + 25, 100, Class338.windowHeight - 35, n, n2);
                if (array != null) {
                    while (true) {
                        if (b3) {
                            ((Class339)((Iterator<Class68>)o).next()).isPressed$255f295();
                            if (array != null) {
                                return;
                            }
                            if (array == null) {
                                b3 = ((Iterator)o).hasNext();
                                continue;
                            }
                        }
                        break;
                    }
                    final Mod selectedMod = Class68.selectedMod;
                    if (array == null) {
                        if (selectedMod == null) {
                            return;
                        }
                        final Mod selectedMod2 = Class68.selectedMod;
                    }
                    final Class339 modButton = selectedMod.modButton;
                    if (array == null) {
                        if (modButton == null) {
                            return;
                        }
                        final Class339 modButton2 = Class68.selectedMod.modButton;
                    }
                    modButton.isPressed$255f295();
                    return;
                }
                Label_0136: {
                    if (array == null) {
                        if (!b2) {
                            break Label_0136;
                        }
                        Class68.isPressed$255f299();
                    }
                    if (b2) {
                        final Iterator<Class68> iterator = this.mods.iterator();
                        while (true) {
                            while (iterator.hasNext()) {
                                iterator.next().selected = false;
                                if (array == null) {
                                    if (array != null) {
                                        break;
                                    }
                                    continue Label_0132_Outer;
                                }
                                else {
                                    if (array != null) {
                                        break Label_0136;
                                    }
                                    break Label_0132_Outer;
                                }
                            }
                            class68.selected = true;
                            Class338.wheelStateValue = 0;
                            continue;
                        }
                    }
                }
                if (array != null) {
                    break;
                }
            }
            o = Class338.booleanValueMap.values().iterator();
            continue;
        }
    }
    
    static {
        lIIIIIllll();
        Class169.a(6242025582787365673L, 1998416765408355317L, MethodHandles.lookup().lookupClass()).a(165356729609147L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class338.lIllIlll[4]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class338.lIllIlll[5]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(70000706480256L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Class338.lIllIlll[6]).length();
        int char1 = 40;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class338.lIllIlll[7]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[3];
        Class338.isDraging = false;
        Class338.booleanValueMap = new HashMap<Value, Class339>();
        Class338.doubleValueMap = new HashMap<Value, Class194>();
        Class338.modeValueMap = new HashMap<Value, Class70>();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5046;
        if (Class338.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class338.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class338.lIllIlll[8]);
                    array[1] = SecretKeyFactory.getInstance(Class338.lIllIlll[9]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class338.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class338.lIllIlll[10], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class338.c[n3] = a(((Cipher)array[0]).doFinal(Class338.b[n3].getBytes(Class338.lIllIlll[11])));
        }
        return Class338.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class338.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIIIllll() {
        (lIllIlll = new String[15])[0] = "_";
        Class338.lIllIlll[1] = "_";
        Class338.lIllIlll[2] = "_";
        Class338.lIllIlll[3] = "_";
        Class338.lIllIlll[4] = "DES/CBC/PKCS5Padding";
        Class338.lIllIlll[5] = "DES";
        Class338.lIllIlll[6] = "¸ý/f\u0003A\u0089Ä¡{±BÇ4Ýàz¨¥e¹SãT¤ñ\u001d0Z÷îÄø,\u009f\u0097\u0003Û+\u00ad\u0010\u008e\u0095h-\u0095\u0081\u009d\u0007E\u0092dSþHòå\u0010i?\u0017\u009b\u000e\u0017\u0093\u001aP<ºL\u0099ZÙ\r";
        Class338.lIllIlll[7] = "ISO-8859-1";
        Class338.lIllIlll[8] = "DES/CBC/PKCS5Padding";
        Class338.lIllIlll[9] = "DES";
        Class338.lIllIlll[10] = "怎么开始嘻嘻哈哈现在杀了我似的对我充满仇恨你这些惨白无力的反抗被我反驳的所剩无几是吗狗急跳墙鸡飞狗叫一样的企图掩饰事实的真想我说孩子你不要再幼稚只会造谣的狗你认为你能称霸这键盘界吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u200f\u200d\u2001";
        Class338.lIllIlll[11] = "ISO-8859-1";
        Class338.lIllIlll[12] = "怎么开始嘻嘻哈哈现在杀了我似的对我充满仇恨你这些惨白无力的反抗被我反驳的所剩无几是吗狗急跳墙鸡飞狗叫一样的企图掩饰事实的真想我说孩子你不要再幼稚只会造谣的狗你认为你能称霸这键盘界吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u200f\u200d\u2001";
        Class338.lIllIlll[13] = " : ";
        Class338.lIllIlll[14] = " : ";
    }
    
    private static String lIIIIIIIll(final String s, final String s2) {
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
    
    private static String lIIIIIIIlI(final String s, final String s2) {
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
    
    private static String lIIIIIlIII(String s, final String s2) {
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
    
    private static boolean lIIIlIIlII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIIlIIlIl(final int n, final int n2) {
        return n <= n2;
    }
    
    static boolean lIIIIlllll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIIIlIIll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIIIllllI(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIIlllIl(final int n) {
        return n > 0;
    }
    
    private static boolean lIIIIllIII(final int n, final int n2) {
        return n != n2;
    }
    
    private static int lIIIlIIIIl(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
