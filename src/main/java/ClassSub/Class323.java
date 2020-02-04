package ClassSub;

import net.minecraft.util.*;
import java.io.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import org.lwjgl.input.*;
import net.minecraft.client.gui.*;
import java.awt.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Class323 extends GuiScreen
{
    private GuiButton login;
    private GuiButton remove;
    private GuiButton rename;
    private Class256 loginThread;
    private int offset;
    public Class159 selectedAlt;
    private String status;
    private ResourceLocation background;
    private GuiTextField seatchField;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llllIlIllI;
    
    public Class323() {
        super();
        new ResourceLocation("textures/mainmenubackground.png");
        this.selectedAlt = null;
        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.GRAY).append("Idle..."));
    }
    
    public final void func_146284_a(final GuiButton guiButton) {
        Label_0316: {
            final int[] b;
            Label_0304: {
                Label_0285: {
                    Label_0186: {
                        Label_0167: {
                            Label_0148: {
                                Label_0090: {
                                    if ((b = Class139.b()) == null) {
                                        switch (guiButton.field_146127_k) {
                                            case 1: {
                                                (this.loginThread = new Class256(this.selectedAlt)).start();
                                                final Class139 instance = Class139.INSTANCE;
                                                Class96.saveFiles();
                                                break;
                                            }
                                            case 2: {
                                                break Label_0090;
                                            }
                                            case 3: {
                                                break Label_0148;
                                            }
                                            case 4: {
                                                break Label_0167;
                                            }
                                            case 5: {
                                                break Label_0186;
                                            }
                                            case 6: {
                                                break Label_0285;
                                            }
                                            case 7: {
                                                break Label_0304;
                                            }
                                            case 8: {
                                                break Label_0316;
                                            }
                                        }
                                    }
                                    if (b == null) {
                                        return;
                                    }
                                }
                                Class323 class323 = this;
                                if (b == null) {
                                    if (this.loginThread != null) {
                                        this.loginThread = null;
                                    }
                                    Class312.registry.remove(this.selectedAlt);
                                    class323 = this;
                                }
                                class323.status = "§aRemoved.";
                                final Class139 instance2 = Class139.INSTANCE;
                                try {
                                    Class96.getFile(Class316.class).saveFile();
                                }
                                catch (Exception ex2) {}
                                this.selectedAlt = null;
                                if (b == null) {
                                    return;
                                }
                            }
                            this.field_146297_k.func_147108_a((GuiScreen)new Class115(this));
                            if (b == null) {
                                return;
                            }
                        }
                        this.field_146297_k.func_147108_a((GuiScreen)new Class65(this));
                        if (b == null) {
                            return;
                        }
                    }
                    final ArrayList<Class159> registry = Class312.registry;
                    final Random random = new Random();
                    if (b == null) {
                        if (registry.size() > 1) {
                            (this.loginThread = new Class256(registry.get(random.nextInt(Class312.registry.size())))).start();
                            if (b == null) {
                                return;
                            }
                        }
                        this.status = String.valueOf(new StringBuilder().append(EnumChatFormatting.RED).append("There's no any alts!"));
                    }
                    if (b == null) {
                        return;
                    }
                }
                this.field_146297_k.func_147108_a((GuiScreen)new Class75(this));
                if (b == null) {
                    return;
                }
            }
            this.field_146297_k.func_147108_a((GuiScreen)null);
            if (b == null) {
                return;
            }
        }
        Class312.registry.clear();
        final Class139 instance3 = Class139.INSTANCE;
        final Class<Class316> clazz = Class316.class;
        try {
            Class96.getFile(clazz).loadFile();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        this.status = "§bReloaded!";
    }
    
    public final void func_73863_a(final int n, final int n2, final float n3) {
        final int[] b = Class139.b();
        this.func_146276_q_();
        final int[] array = b;
        int n7;
        int n6;
        int n5;
        final int n4 = n5 = (n6 = (n7 = (Mouse.hasWheel() ? 1 : 0)));
        Label_0137: {
            if (array == null) {
                if (n4 == 0) {
                    break Label_0137;
                }
                final int n8;
                n5 = (n8 = (n6 = (n7 = Mouse.getDWheel())));
            }
            final int n9 = n4;
            if (array == null) {
                if (n5 < 0) {
                    this.offset += 26;
                    Class323 class323 = this;
                    if (array == null) {
                        if (this.offset >= 0) {
                            break Label_0137;
                        }
                        class323 = this;
                    }
                    class323.offset = 0;
                    if (array == null) {
                        break Label_0137;
                    }
                }
                n7 = (n6 = n9);
            }
            Class323 class324 = null;
            Label_0133: {
                if (array == null) {
                    if (n6 <= 0) {
                        break Label_0137;
                    }
                    this.offset -= 26;
                    class324 = this;
                    if (array != null) {
                        break Label_0133;
                    }
                    n7 = this.offset;
                }
                if (n7 >= 0) {
                    break Label_0137;
                }
                class324 = this;
            }
            class324.offset = 0;
        }
        final ScaledResolution scaledResolution;
        (scaledResolution = new ScaledResolution(this.field_146297_k)).func_78326_a();
        scaledResolution.func_78328_b();
        GlStateManager.func_179144_i(0);
        final float n10 = 0.0f;
        final float n11 = 0.0f;
        final float n12 = scaledResolution.func_78326_a();
        final float n13 = scaledResolution.func_78328_b();
        final int n14 = 0;
        Class69.drawRect(n10, n11, n12, n13, getColor(n14, n14, 0, 50));
        this.func_73731_b(this.field_146289_q, this.field_146297_k.func_110432_I().func_111285_a(), 10, 10, 14540253);
        this.func_73732_a(this.field_146289_q, String.valueOf(new StringBuilder("Account Manager - ").append(Class312.registry.size()).append(" alts")), this.field_146294_l / 2, 10, -1);
        final FontRenderer field_146289_q = this.field_146289_q;
        final Class256 loginThread = this.loginThread;
        String s = null;
        Label_0297: {
            if (array == null) {
                if (loginThread == null) {
                    s = this.status;
                    break Label_0297;
                }
                final Class256 loginThread2 = this.loginThread;
            }
            s = loginThread.status;
        }
        this.func_73732_a(field_146289_q, s, this.field_146294_l / 2, 20, -1);
        final float n15 = 50.0f;
        final float n16 = 33.0f;
        final float n17 = this.field_146294_l - 50;
        final float n18 = this.field_146295_m - 50;
        final int n19 = 225;
        final int color = getColor(n19, n19, 225, 50);
        final int n20 = 160;
        Class69.drawOutlinedRect$10266f0b(n15, n16, n17, n18, color, getColor(n20, n20, 160, 150));
        GL11.glPushMatrix();
        final float n21 = this.field_146294_l;
        final float n22 = this.field_146295_m - 50;
        final float n23 = n21;
        final ScaledResolution scaledResolution2;
        final int func_78325_e = (scaledResolution2 = new ScaledResolution(this.field_146297_k)).func_78325_e();
        GL11.glScissor((int)(0.0f * func_78325_e), (int)((scaledResolution2.func_78328_b() - n22) * func_78325_e), (int)(n23 * func_78325_e), (int)((n22 - 33.0f) * func_78325_e));
        GL11.glEnable(3089);
        int n24 = 38;
        while (true) {
            for (final Class159 class325 : this.getAlts()) {
                final int n25 = n24;
                final int[] b2 = Class139.b();
                int n27;
                int equals;
                final int n26 = equals = (n27 = n25 - this.offset);
                if (b2 == null) {
                    if (lIllIIIllIll(n26, this.field_146295_m - 50)) {
                        final int n28;
                        equals = (n28 = (n27 = 1));
                    }
                    else {
                        final int n28;
                        equals = (n28 = (n27 = 0));
                    }
                }
                if (array != null) {
                    GL11.glDisable(n27);
                    GL11.glPopMatrix();
                    super.func_73863_a(n, n2, n3);
                    Class323 class326 = this;
                    Label_1156: {
                        if (array == null) {
                            if (this.selectedAlt == null) {
                                this.login.field_146124_l = false;
                                this.remove.field_146124_l = false;
                                this.rename.field_146124_l = false;
                                if (array == null) {
                                    break Label_1156;
                                }
                            }
                            this.login.field_146124_l = true;
                            this.remove.field_146124_l = true;
                            class326 = this;
                        }
                        class326.rename.field_146124_l = true;
                    }
                    boolean b3;
                    int empty;
                    int n30;
                    final int n29 = n30 = (empty = ((b3 = Keyboard.isKeyDown(200)) ? 1 : 0));
                    Label_1213: {
                        Label_1209: {
                            if (array == null) {
                                if (n29 != 0) {
                                    this.offset -= 26;
                                    if (array == null) {
                                        break Label_1209;
                                    }
                                }
                                final boolean b4;
                                n30 = ((b4 = ((empty = ((b3 = Keyboard.isKeyDown(208)) ? 1 : 0)) != 0)) ? 1 : 0);
                            }
                            if (array != null) {
                                break Label_1213;
                            }
                            if (n29 != 0) {
                                this.offset += 26;
                            }
                        }
                        empty = (n30 = ((b3 = (this.offset != 0)) ? 1 : 0));
                    }
                    if (array == null) {
                        if (n30 < 0) {
                            this.offset = 0;
                        }
                        this.seatchField.func_146194_f();
                        b3 = ((empty = (this.seatchField.func_146179_b().isEmpty() ? 1 : 0)) != 0);
                    }
                    Class323 class327 = null;
                    Label_1275: {
                        if (array == null) {
                            if (empty == 0) {
                                return;
                            }
                            class327 = this;
                            if (array != null) {
                                break Label_1275;
                            }
                            b3 = this.seatchField.func_146206_l();
                        }
                        if (b3) {
                            return;
                        }
                        class327 = this;
                    }
                    class327.func_73731_b(this.field_146297_k.field_71466_p, "Search Alt", this.field_146294_l / 2 - 264, this.field_146295_m - 18, -1);
                    return;
                }
                Label_1071: {
                    String username = null;
                    Label_0578: {
                        final String mask;
                        Label_0576: {
                            if (array == null) {
                                if (n26 == 0) {
                                    break Label_1071;
                                }
                                mask = class325.mask;
                                if (array != null) {
                                    break Label_0576;
                                }
                                equals = (mask.equals(Class323.llllIlIllI[0]) ? 1 : 0);
                            }
                            if (equals != 0) {
                                username = class325.username;
                                if (array == null) {
                                    break Label_0578;
                                }
                            }
                            final String mask2 = class325.mask;
                        }
                        username = mask;
                    }
                    final String password = class325.password;
                    final String s2 = Class323.llllIlIllI[1];
                    String replaceAll = null;
                    Label_0630: {
                        if (array == null) {
                            if (password.equals(s2)) {
                                replaceAll = "§cCracked";
                                if (array == null) {
                                    break Label_0630;
                                }
                            }
                            final String password2 = class325.password;
                            final String s3 = Class323.llllIlIllI[2];
                        }
                        replaceAll = password.replaceAll(s2, Class323.llllIlIllI[3]);
                    }
                    Class323 class328 = null;
                    Label_1032: {
                        Label_1006: {
                            if (lIllIIIIlIll(class325, this.selectedAlt)) {
                                final boolean mouseOverAlt = this.isMouseOverAlt(n, n2, n24 - this.offset);
                                Label_0741: {
                                    if (array == null) {
                                        if (mouseOverAlt) {
                                            final boolean buttonDown = Mouse.isButtonDown(0);
                                            if (array != null) {
                                                break Label_0741;
                                            }
                                            if (buttonDown) {
                                                final float n31 = 52.0f;
                                                final float n32 = n24 - this.offset - 4;
                                                final float n33 = this.field_146294_l - 52;
                                                final float n34 = n24 - this.offset + 20;
                                                final int n35 = 145;
                                                Class69.drawOutlinedRect$10266f0b(n31, n32, n33, n34, getColor(n35, n35, 145, 50), -2142943931);
                                                if (array == null) {
                                                    break Label_1006;
                                                }
                                            }
                                        }
                                        this.isMouseOverAlt(n, n2, n24 - this.offset);
                                    }
                                }
                                if (mouseOverAlt) {
                                    final float n36 = 52.0f;
                                    final float n37 = n24 - this.offset - 4;
                                    final float n38 = this.field_146294_l - 52;
                                    final float n39 = n24 - this.offset + 20;
                                    final int n40 = 145;
                                    Class69.drawOutlinedRect$10266f0b(n36, n37, n38, n39, getColor(n40, n40, 145, 50), -2142088622);
                                    if (array == null) {
                                        break Label_1006;
                                    }
                                }
                                final float n41 = 52.0f;
                                final float n42 = n24 - this.offset - 4;
                                final float n43 = this.field_146294_l - 52;
                                final float n44 = n24 - this.offset + 20;
                                final int n45 = 145;
                                Class69.drawOutlinedRect$10266f0b(n41, n42, n43, n44, getColor(n45, n45, 145, 50), -2144259791);
                                if (array == null) {
                                    break Label_1006;
                                }
                            }
                            final boolean mouseOverAlt2 = this.isMouseOverAlt(n, n2, n24 - this.offset);
                            Label_0955: {
                                if (array == null) {
                                    if (mouseOverAlt2) {
                                        final boolean buttonDown2 = Mouse.isButtonDown(0);
                                        if (array != null) {
                                            break Label_0955;
                                        }
                                        if (buttonDown2) {
                                            final float n46 = 52.0f;
                                            final float n47 = n24 - this.offset - 4;
                                            final float n48 = this.field_146294_l - 52;
                                            final float n49 = n24 - this.offset + 20;
                                            final int n50 = 145;
                                            Class69.drawOutlinedRect$10266f0b(n46, n47, n48, n49, -getColor(n50, n50, 145, 50), -2146101995);
                                            if (array == null) {
                                                break Label_1006;
                                            }
                                        }
                                    }
                                    class328 = this;
                                    if (array != null) {
                                        break Label_1032;
                                    }
                                    this.isMouseOverAlt(n, n2, n24 - this.offset);
                                }
                            }
                            if (mouseOverAlt2) {
                                final float n51 = 52.0f;
                                final float n52 = n24 - this.offset - 4;
                                final float n53 = this.field_146294_l - 52;
                                final float n54 = n24 - this.offset + 20;
                                final int n55 = 145;
                                Class69.drawOutlinedRect$10266f0b(n51, n52, n53, n54, getColor(n55, n55, 145, 50), -2145180893);
                            }
                        }
                        this.func_73732_a(this.field_146289_q, username, this.field_146294_l / 2, n24 - this.offset, -1);
                        class328 = this;
                    }
                    final FontRenderer field_146289_q2 = this.field_146289_q;
                    final String s4 = replaceAll;
                    final int n56 = this.field_146294_l / 2;
                    final int n57 = n24 - this.offset + 10;
                    final int n58 = 110;
                    class328.func_73732_a(field_146289_q2, s4, n56, n57, getColor(n58, n58, 110, 255));
                    n24 += 26;
                }
                if (array != null) {
                    break;
                }
            }
            int n27 = 3089;
            continue;
        }
    }
    
    private static int getColor(final int n, final int n2, final int n3, final int n4) {
        return 0x0 | n4 << 24 | n << 16 | n2 << 8 | n3;
    }
    
    private static int getColor(final Color color) {
        return getColor(color.getRed(), color.getGreen(), color.getBlue(), color.getAlpha());
    }
    
    private static int getColor$134621() {
        final int n = 110;
        return getColor(n, n, 110, 255);
    }
    
    private static int getColor(final int n, final int n2) {
        return getColor(n, n, n, n2);
    }
    
    public final void func_73866_w_() {
        this.field_146292_n.add(this.login = new GuiButton(1, this.field_146294_l / 2 - 122, this.field_146295_m - 48, 100, 20, "Login"));
        this.field_146292_n.add(this.remove = new GuiButton(2, this.field_146294_l / 2 - 16, this.field_146295_m - 24, 100, 20, "Remove"));
        this.field_146292_n.add(new GuiButton(3, this.field_146294_l / 2 + 4 + 86, this.field_146295_m - 48, 100, 20, "Add"));
        this.field_146292_n.add(new GuiButton(4, this.field_146294_l / 2 - 16, this.field_146295_m - 48, 100, 20, "Direct Login"));
        this.field_146292_n.add(new GuiButton(5, this.field_146294_l / 2 - 122, this.field_146295_m - 24, 100, 20, "Random"));
        this.field_146292_n.add(this.rename = new GuiButton(6, this.field_146294_l / 2 + 90, this.field_146295_m - 24, 100, 20, "Edit"));
        this.field_146292_n.add(new GuiButton(7, this.field_146294_l / 2 - 190, this.field_146295_m - 24, 60, 20, "Back"));
        this.field_146292_n.add(new GuiButton(8, this.field_146294_l / 2 - 190, this.field_146295_m - 48, 60, 20, "Reload"));
        this.seatchField = new GuiTextField(99998, this.field_146297_k.field_71466_p, this.field_146294_l / 2 - 268, this.field_146295_m - 21, 68, 14);
        this.login.field_146124_l = false;
        this.remove.field_146124_l = false;
        this.rename.field_146124_l = false;
    }
    
    protected final void func_73869_a(final char c, final int n) {
        final int[] b = Class139.b();
        this.seatchField.func_146201_a(c, n);
        final int[] array = b;
        char func_146206_l = c;
        Class323 class323 = null;
        Label_0083: {
            Label_0082: {
                Label_0053: {
                    if (array == null) {
                        if (c != '\t') {
                            func_146206_l = c;
                            if (array != null) {
                                break Label_0053;
                            }
                            if (c != '\r') {
                                break Label_0082;
                            }
                        }
                        class323 = this;
                        if (array != null) {
                            break Label_0083;
                        }
                        func_146206_l = (char)(this.seatchField.func_146206_l() ? 1 : 0);
                    }
                }
                if (func_146206_l != '\0') {
                    final GuiTextField seatchField = this.seatchField;
                    final boolean func_146206_l2 = this.seatchField.func_146206_l();
                    if (array == null && func_146206_l2) {}
                    seatchField.func_146195_b(func_146206_l2);
                }
            }
            class323 = this;
        }
        try {
            class323.func_73869_a(c, n);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private boolean isAltInArea(final int n) {
        final int[] b = Class139.b();
        boolean b2;
        final int n2 = (b2 = (n - this.offset != 0)) ? 1 : 0;
        if (b == null) {
            if (!lIllIIIllIll(n2, this.field_146295_m - 50)) {
                return false;
            }
            b2 = true;
        }
        return b2;
    }
    
    private boolean isMouseOverAlt(final int n, final int n2, final int n3) {
        final int[] b = Class139.b();
        int n4 = n;
        int n5 = n;
        int n6 = n;
        int n9;
        int n8;
        final int n7 = n8 = (n9 = 52);
        if (b == null) {
            if (!lIllIIIlllII(n, n7)) {
                return false;
            }
            n4 = n2;
            n5 = n2;
            n6 = n2;
            final int n10;
            n8 = (n10 = (n9 = n3 - 4));
        }
        if (b == null) {
            if (!lIllIIIlllII(n6, n7)) {
                return false;
            }
            n4 = n;
            n5 = n;
            n9 = (n8 = this.field_146294_l - 52);
        }
        int n11 = 0;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        Label_0071: {
            if (b == null) {
                if (!lIllIIIllIll(n5, n8)) {
                    return false;
                }
                n11 = n2;
                n12 = n2;
                n13 = n2;
                n14 = n2;
                n4 = n2;
                if (b != null) {
                    break Label_0071;
                }
                n9 = n3 + 20;
            }
            if (!lIllIIIllIll(n4, n9)) {
                return false;
            }
            n11 = n;
            n12 = n;
            n13 = n;
            n14 = n;
        }
        if (b == null) {
            if (n14 < 0) {
                return false;
            }
            n11 = n2;
            n12 = n2;
            n13 = n2;
        }
        int n16;
        final int n15 = n16 = 33;
        if (b == null) {
            if (!lIllIIIlllII(n13, n15)) {
                return false;
            }
            n11 = n;
            n12 = n;
            final int field_146294_l;
            n16 = (field_146294_l = this.field_146294_l);
        }
        if (b == null) {
            if (!lIllIIIllIll(n12, n15)) {
                return false;
            }
            final boolean b2 = n2 != 0;
            n11 = n2;
            if (b != null) {
                return b2;
            }
            n16 = this.field_146295_m - 50;
        }
        if (!lIllIIIllIll(n11, n16)) {
            return false;
        }
        return true;
    }
    
    protected final void func_73864_a(final int n, final int n2, final int n3) {
        final int[] b = Class139.b();
        this.seatchField.func_146192_a(n, n2, n3);
        final int[] array = b;
        final int offset = this.offset;
        if (array == null) {
            if (offset < 0) {
                this.offset = 0;
            }
            final int n4 = 38 - this.offset;
        }
        int n5 = offset;
        while (true) {
            for (final Class159 selectedAlt : this.getAlts()) {
                if (array == null) {
                    final Class323 class323 = this;
                    final int n6 = n;
                    final int n7 = n2;
                    final int n8 = n5;
                    if (array == null) {
                        if (this.isMouseOverAlt(n, n2, n8)) {
                            if (lIllIIIIlIll(selectedAlt, this.selectedAlt)) {
                                this.func_146284_a(this.field_146292_n.get(0));
                                return;
                            }
                            this.selectedAlt = selectedAlt;
                        }
                        n5 += 26;
                    }
                    else {
                        try {
                            class323.func_73864_a(n6, n7, n8);
                            return;
                        }
                        catch (IOException ex) {
                            ex.printStackTrace();
                            return;
                        }
                    }
                }
                if (array != null) {
                    break;
                }
            }
            final Class323 class323 = this;
            final int n6 = n;
            final int n7 = n2;
            continue;
        }
    }
    
    private List<Class159> getAlts() {
        final int[] b = Class139.b();
        final ArrayList<Class159> list = new ArrayList<Class159>();
        final int[] array = b;
        for (final Class159 class159 : Class312.registry) {
            final boolean empty = this.seatchField.func_146179_b().isEmpty();
            Label_0120: {
                if (array == null) {
                    if (!empty) {
                        final boolean contains = class159.mask.toLowerCase().contains(this.seatchField.func_146179_b().toLowerCase());
                        if (array != null) {
                            break Label_0120;
                        }
                        if (!contains) {
                            final boolean contains2 = class159.username.toLowerCase().contains(this.seatchField.func_146179_b().toLowerCase());
                            if (array != null) {
                                break Label_0120;
                            }
                            if (!contains2) {
                                break Label_0120;
                            }
                        }
                    }
                    list.add(class159);
                }
            }
            if (array != null) {
                break;
            }
        }
        return list;
    }
    
    private void prepareScissorBox$4098370b(final float n, final float n2) {
        final ScaledResolution scaledResolution;
        final int func_78325_e = (scaledResolution = new ScaledResolution(this.field_146297_k)).func_78325_e();
        GL11.glScissor((int)(0.0f * func_78325_e), (int)((scaledResolution.func_78328_b() - n2) * func_78325_e), (int)(n * func_78325_e), (int)((n2 - 33.0f) * func_78325_e));
    }
    
    static {
        lIlIlllllllI();
        Class169.a(4910751591786756573L, 4747796522246880423L, MethodHandles.lookup().lookupClass()).a(41723653724863L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class323.llllIlIllI[4]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class323.llllIlIllI[5]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(51750522002627L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[17];
        int n2 = 0;
        String s;
        int n3 = (s = Class323.llllIlIllI[6]).length();
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class323.llllIlIllI[8]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class323.llllIlIllI[7]).length();
                            n4 = 16;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
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
        b = b2;
        c = new String[17];
    }
    
    private static Exception a(final Exception ex) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x100;
        if (Class323.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class323.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class323.llllIlIllI[9]);
                    array[1] = SecretKeyFactory.getInstance(Class323.llllIlIllI[10]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class323.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class323.llllIlIllI[11], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class323.c[n3] = a(((Cipher)array[0]).doFinal(Class323.b[n3].getBytes(Class323.llllIlIllI[12])));
        }
        return Class323.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class323.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIlIlllllllI() {
        (llllIlIllI = new String[16])[0] = "";
        Class323.llllIlIllI[1] = "";
        Class323.llllIlIllI[2] = ".";
        Class323.llllIlIllI[3] = "*";
        Class323.llllIlIllI[4] = "DES/CBC/PKCS5Padding";
        Class323.llllIlIllI[5] = "DES";
        Class323.llllIlIllI[6] = "è\u008d\u0080R}S78\u001b\u009d\u0014\u0004\u0004\u008708 HªP¥\u0084ÉÏþ\u0010\u001a\u0099·£tÿÝ¡§'A\u007f\u0019áR¨f¨\u0003\u000f´y%\u0010Cæb²\u000bsK\u001bx«\u0013µm«z\u000f Ïl\u0012+1Qí\u0013\u009e\u0004M¯L6÷Y\u0083ÁuF\u0007¢\u0082Bº}øoÖQf\b(¿ðä\u009e\u0086Mgh\b·&\f\rE\tÿ\u0082\u0013\u001c\u0016`EHéOVa\u009b2ÿá´Ôw\u00887Ðp\u00195\u0010ûã;®I3È'rr/>`Âòv\u0010\u00997Á\u008dé4ÏÇ*}\b3}\u0081\u008a\f\u00107\u0015¥\n,\u001bC(U\r\rÓ\u0093%¹x\u0010t\u00168N÷Ñ;#(Úß\u001dT½s6\u0010=\nW/ÙAO&Ã[Õ\u0002ÀxY\u0093 \u0011\u0096óÔ$Ûfå^å³\u0093\u0095\u001f'Â\noà\u009eûn\u00ad\r¾0b¶ç`Jë8é\u008aé\u0005?<\u0092\u0015¿?*Ë§°æQõùºu:Ü.ÜSeBM¾³ù7\u001aiöY×\u00ad\u0003ïÑ,.\u001dÌg\u009c},\u0011Ö¿À¶!W M\u0093\u0092\u0010~¢Ä¨;!ë\u0002ÀN¥´Ã\n\u0004BX5L@¿&º/è·`\u007f\u0010üÞìÎ²C£%w\fË¸\u0081×\u0089>(\u0083\u0092Ó½È`\u0086+Á\u0013D\u0017áåò¨×Å·\u000549Ãì\n~á\u008fKtß\u0099ôÚdÎÉÑ\u0011/";
        Class323.llllIlIllI[7] = "e¬\u0006Ô@9i»\u0093\u0080&5\u0095\u0001\u007f,\u0018øë\u0012xx\u0010I{àøÉ\\\u0002 ²: \u00021zZ\u00029g";
        Class323.llllIlIllI[8] = "ISO-8859-1";
        Class323.llllIlIllI[9] = "DES/CBC/PKCS5Padding";
        Class323.llllIlIllI[10] = "DES";
        Class323.llllIlIllI[11] = "爹爹我现在留你一个人在这语无伦次自我反省吧请不要那种威胁的语气跟我对话好吗我不希望我跟残疾人墨迹半天OK因为我已经厌恶了你还要说什么呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u200e\u200f\u200d";
        Class323.llllIlIllI[12] = "ISO-8859-1";
        Class323.llllIlIllI[13] = "爹爹我现在留你一个人在这语无伦次自我反省吧请不要那种威胁的语气跟我对话好吗我不希望我跟残疾人墨迹半天OK因为我已经厌恶了你还要说什么呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u200e\u200f\u200d";
        Class323.llllIlIllI[14] = " : ";
        Class323.llllIlIllI[15] = " : ";
    }
    
    private static String lIlIllllllIl(String s, final String s2) {
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
    
    private static String lIlIlllllIll(final String s, final String s2) {
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
    
    private static String lIlIllllllII(final String s, final String s2) {
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
    
    private static boolean lIllIIIlllII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIllIIIllIll(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lIllIIIIIlll$255f299(final int n) {
        return n > 1;
    }
    
    private static boolean lIllIIIIlIll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIllIIIlllIl(final int n) {
        return n >= 0;
    }
    
    private static boolean lIllIIIIlIIl(final int n) {
        return n < 0;
    }
    
    private static boolean lIllIIIIlIlI(final int n) {
        return n > 0;
    }
    
    private static boolean lIllIIIllIIl$255f299(final int n) {
        return n != 9;
    }
}
