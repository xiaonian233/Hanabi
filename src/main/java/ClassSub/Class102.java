package ClassSub;

import java.time.format.*;
import cn.Hanabi.value.*;
import java.text.*;
import cn.Hanabi.modules.*;
import java.util.function.*;
import com.darkmagician6.eventapi.*;
import java.awt.*;
import org.lwjgl.opengl.*;
import cn.Hanabi.events.*;
import cn.Hanabi.modules.Render.*;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.player.*;
import net.minecraft.client.*;
import cn.Hanabi.modules.Player.*;
import cn.Hanabi.modules.World.*;
import net.minecraft.client.entity.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.potion.*;
import net.minecraft.client.resources.*;
import net.minecraft.client.renderer.*;
import net.minecraft.util.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class102 extends Mod
{
    private static final DateTimeFormatter dateFormat;
    private static final DateTimeFormatter timeFormat;
    private Value<Boolean> arraylist;
    private Value<Boolean> logo;
    public Value<Boolean> hotbar;
    private Value<Boolean> potion;
    private Value<Boolean> noti;
    private Value<Boolean> posDisplay;
    private SimpleDateFormat f;
    private SimpleDateFormat f2;
    private float animationY2;
    private Map<Potion, Double> timerMap;
    private int x;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map j;
    private static final String[] lIlIIlllIlI;
    
    public Class102() {
        super("HUD", Category.RENDER, false, true, 0);
        this.arraylist = new Value<Boolean>("HUD_ArrayList", Boolean.TRUE);
        this.logo = new Value<Boolean>("HUD_Logo", Boolean.TRUE);
        this.hotbar = new Value<Boolean>("HUD_Hotbar", Boolean.TRUE);
        this.potion = new Value<Boolean>("HUD_Potion", Boolean.TRUE);
        this.noti = new Value<Boolean>("HUD_Notification", Boolean.TRUE);
        this.posDisplay = new Value<Boolean>("HUD_Postion", Boolean.TRUE);
        this.f = new SimpleDateFormat("HH:mm");
        final int[] b = Class139.b();
        this.f2 = new SimpleDateFormat("YYYY/MM/dd");
        this.timerMap = new HashMap<Potion, Double>();
        final int[] array = b;
        this.setState(true);
        final HashMap<Category, ArrayList<Mod>> hashMap = new HashMap<Category, ArrayList<Mod>>();
        final Class139 instance = Class139.INSTANCE;
        while (true) {
            for (final Mod mod : Class4.getModules()) {
                final HashMap<Category, ArrayList<Mod>> hashMap2 = hashMap;
                if (array != null) {
                    hashMap2.entrySet().stream().sorted(Comparator.comparingInt((ToIntFunction<? super Object>)Class102::lambda$new$0)).forEach((Consumer<? super Object>)Class102::lambda$new$2);
                    return;
                }
                final boolean containsKey = hashMap2.containsKey(mod.category);
                if (array == null) {
                    if (!containsKey) {
                        hashMap.put(mod.category, new ArrayList<Mod>());
                    }
                    hashMap.get(mod.category).add(mod);
                }
                if (array != null) {
                    break;
                }
            }
            continue;
        }
    }
    
    @EventTarget
    private static void onReload$3a33106() {
        new Class83((Class102)Class4.getModule("HUD")).start();
    }
    
    public static int rainbow$134621() {
        return Color.getHSBColor((float)(Math.ceil(System.currentTimeMillis() / 20.0) % 360.0 / 360.0), 0.8f, 0.7f).getRGB();
    }
    
    private static void drawRoundedRect(float n, float n2, float n3, float n4, final int n5, final int n6) {
        enableGL2D();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        drawVLine(n *= 2.0f, (n2 *= 2.0f) + 1.0f, (n4 *= 2.0f) - 2.0f, n5);
        drawVLine((n3 *= 2.0f) - 1.0f, n2 + 1.0f, n4 - 2.0f, n5);
        drawHLine(n + 2.0f, n3 - 3.0f, n2, n5);
        drawHLine(n + 2.0f, n3 - 3.0f, n4 - 1.0f, n5);
        drawHLine(n + 1.0f, n + 1.0f, n2 + 1.0f, n5);
        drawHLine(n3 - 2.0f, n3 - 2.0f, n2 + 1.0f, n5);
        drawHLine(n3 - 2.0f, n3 - 2.0f, n4 - 2.0f, n5);
        drawHLine(n + 1.0f, n + 1.0f, n4 - 2.0f, n5);
        Class69.drawRect(n + 1.0f, n2 + 1.0f, n3 - 1.0f, n4 - 1.0f, n6);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        disableGL2D();
    }
    
    private static void color(final int n) {
        GL11.glColor4f((n >> 16 & 0xFF) / 255.0f, (n >> 8 & 0xFF) / 255.0f, (n & 0xFF) / 255.0f, (n >> 24 & 0xFF) / 255.0f);
    }
    
    private static void enableGL2D() {
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
    }
    
    private static void disableGL2D() {
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    @EventTarget
    private void render2D(final EventRender2D eventRender2D) {
        final ScaledResolution scaledResolution = new ScaledResolution(Class102.mc);
        final int[] b = Class139.b();
        final float n = scaledResolution.func_78326_a();
        final int[] array = b;
        final float n2 = scaledResolution.func_78328_b();
        boolean b4;
        boolean b3;
        int n6;
        boolean b2;
        int n5;
        int n4;
        final int n3 = n4 = (n5 = ((b2 = ((n6 = ((b3 = (b4 = this.potion.value)) ? 1 : 0)) != 0)) ? 1 : 0));
        if (array == null) {
            if (n3 != 0) {
                this.renderPotionStatus((int)n, (int)n2);
            }
            final boolean b5;
            n4 = ((b5 = ((n5 = ((b2 = ((n6 = ((b3 = (b4 = this.arraylist.value)) ? 1 : 0)) != 0)) ? 1 : 0)) != 0)) ? 1 : 0);
        }
        if (array == null) {
            if (n3 != 0) {
                renderArray(scaledResolution);
            }
            n5 = (n4 = ((b2 = ((n6 = ((b3 = (b4 = this.noti.value)) ? 1 : 0)) != 0)) ? 1 : 0));
        }
        if (array == null) {
            if (n4 != 0) {
                final Class23 instance = Class23.INSTANCE;
                Class23.drawNotifications();
            }
            n5 = (n6 = ((b3 = (b4 = this.logo.value)) ? 1 : 0));
        }
        final boolean b6;
        Label_0211: {
            if (array == null) {
                Label_0198: {
                    if (n5 != 0) {
                        final boolean state = Class4.getModule("TabGUI").state;
                        if (array == null) {
                            if (state) {
                                b6 = ((n6 = ((b3 = (b4 = (((TabGUI)Class4.getModule("TabGUI")).screen != 0))) ? 1 : 0)) != 0);
                                if (array != null) {
                                    break Label_0211;
                                }
                                if ((b6 ? 1 : 0) != -1) {
                                    break Label_0198;
                                }
                            }
                            Class139.INSTANCE.fontManager.icon130.func_175063_a(HanabiFonts.ICON_HANABI_LOGO, 2.0f, 2.0f, new Color(47, 116, 253).getRGB());
                        }
                    }
                }
                n6 = ((b2 = (b3 = (b4 = this.posDisplay.value))) ? 1 : 0);
            }
        }
        if (array == null) {
            Boolean b7 = null;
            Label_0354: {
                if (b6) {
                    final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(b7 = (Boolean)Class102.mc.field_71439_g);
                    if (array != null) {
                        break Label_0354;
                    }
                    if (entityPlayerSP != null) {
                        final BlockPos func_180425_c = Class102.mc.field_71439_g.func_180425_c();
                        final String value = String.valueOf(new StringBuilder("X:").append(func_180425_c.func_177958_n()).append("    Y:").append(func_180425_c.func_177956_o()).append("    Z:").append(func_180425_c.func_177952_p()));
                        final UnicodeFontRenderer wqy18 = Class139.INSTANCE.fontManager.wqy18;
                        final String s = value;
                        final float n7 = scaledResolution.func_78326_a() / 2;
                        final int n8 = 5;
                        final int field_82826_b;
                        if (BossStatus.field_82827_c != null) {
                            field_82826_b = BossStatus.field_82826_b;
                            if (array == null && field_82826_b <= 0) {}
                        }
                        wqy18.drawCenteredString(s, n7, n8 + field_82826_b, -1);
                    }
                }
                b7 = this.hotbar.value;
            }
            b3 = ((n6 = ((b4 = b7) ? 1 : 0)) != 0);
        }
        if (array == null) {
            if (n6 == 0) {
                return;
            }
            b4 = (b3 = (Class102.mc.func_175606_aa() instanceof EntityPlayer));
        }
        if (array == null) {
            if (!b3) {
                return;
            }
            b4 = Class102.mc.field_71474_y.field_74319_N;
        }
        if (!b4) {
            final UnicodeFontRenderer wqy19 = Class139.INSTANCE.fontManager.wqy18;
            Class69.drawRect(0.0f, n2 - 20.0f, n, n2, Class23.reAlpha(Class22.BLACK.c, 0.5f));
            final ServerData func_147104_D = Class102.mc.func_147104_D();
            long field_78844_e = 0L;
            long n9 = 0L;
            Label_0458: {
                if (array == null) {
                    if (func_147104_D == null) {
                        n9 = (field_78844_e = -1L);
                        break Label_0458;
                    }
                    Class102.mc.func_147104_D();
                }
                n9 = (field_78844_e = func_147104_D.field_78844_e);
            }
            final long n10 = field_78844_e;
            long n12;
            final long n11 = n12 = lcmp(n9, 100L);
            Label_0554: {
                if (array == null) {
                    if (n11 <= 0) {
                        n12 = new Color(3110141).getRGB();
                        break Label_0554;
                    }
                    final int n13;
                    n12 = (n13 = lcmp(n10, 250L));
                }
                if (array == null) {
                    if (n11 <= 0) {
                        n12 = new Color(Class22.ORANGE.c).darker().getRGB();
                    }
                    else {
                        n12 = new Color(Class22.RED.c).getRGB();
                    }
                }
            }
            Class69.drawFilledCircle$40982bc8(n2 - 10.5f, (int)n12);
            final UnicodeFontRenderer unicodeFontRenderer = wqy19;
            final StringBuilder sb = new StringBuilder("PING:");
            final long n14 = n10;
            unicodeFontRenderer.drawString(String.valueOf(sb.append((array == null && n14 <= 0L) ? "N/A" : n14).append("ms     FPS:").append(Minecraft.func_175610_ah())), 16.0f, n2 - 16.0f, -1);
            final Date date = new Date();
            this.f2.format(date);
            this.f.format(date);
            final String value2 = String.valueOf(new StringBuilder("Hanabi Build 2.2 IRCFix - ").append(Class102.username));
            Class139.INSTANCE.fontManager.wqy18.func_78276_b(value2, scaledResolution.func_78326_a() - wqy19.func_78256_a(value2) - 5, scaledResolution.func_78328_b() - 16, -1);
            Label_0855: {
                Label_0783: {
                    if (array == null) {
                        if (Class102.mc.field_71439_g.field_71071_by.field_70461_c != 0) {
                            break Label_0783;
                        }
                        Class69.drawRect(n / 2.0f - 91.0f, n2 - 20.0f, n / 2.0f + 90.0f - 160.0f, n2, Class23.reAlpha(Class22.WHITE.c, 0.5f));
                    }
                    if (array == null) {
                        break Label_0855;
                    }
                }
                Class69.drawRect(n / 2.0f - 91.0f + Class102.mc.field_71439_g.field_71071_by.field_70461_c * 20, n2 - 20.0f, n / 2.0f + 90.0f - 20 * (8 - Class102.mc.field_71439_g.field_71071_by.field_70461_c), n2, Class23.reAlpha(Class22.WHITE.c, 0.5f));
            }
            RenderHelper.func_74520_c();
            int i = 0;
            while (true) {
                while (i < 9) {
                    customRenderHotbarItem(i, (int)(n / 2.0f - 90.0f + i * 20 + 2.0f), (int)(n2 - 16.0f - 2.0f), eventRender2D.partialTicks, (EntityPlayer)Class102.mc.field_71439_g);
                    ++i;
                    if (array != null) {
                        Label_0969: {
                            if (Class4.getModule("StaffAnalyzer").state) {
                                final Class38 ui = StaffAnalyzer.ui;
                                if (array == null) {
                                    if (ui == null) {
                                        break Label_0969;
                                    }
                                    final Class38 ui2 = StaffAnalyzer.ui;
                                }
                                ui.draw();
                            }
                        }
                        final int[] b8 = Class139.b();
                        final ScaledResolution scaledResolution2 = new ScaledResolution(Class102.mc);
                        final int[] array2 = b8;
                        final int func_78326_a = scaledResolution2.func_78326_a();
                        int n16;
                        final int n15 = n16 = (Class4.getModule("Scaffold").state ? 1 : 0);
                        Label_1696: {
                            if (array2 == null) {
                                if (n15 != 0) {
                                    final int reAlpha = Class23.reAlpha(Class22.WHITE.c, 0.8f);
                                    final String field_82827_c = BossStatus.field_82827_c;
                                    Label_1284: {
                                        if (array2 == null) {
                                            Label_1113: {
                                                if (field_82827_c != null) {
                                                    float field_82826_b2;
                                                    final int n17 = (int)(field_82826_b2 = BossStatus.field_82826_b);
                                                    if (array2 == null) {
                                                        if (n17 <= 0) {
                                                            break Label_1113;
                                                        }
                                                        field_82826_b2 = fcmpg(Class102.mc.field_71439_g.func_110143_aJ(), 6.0f);
                                                    }
                                                    if (field_82826_b2 <= 0) {
                                                        this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 50.0, Math.max(10.0f, Math.abs(this.animationY2 - 50.0f) * 25.0f) * 0.3);
                                                        if (array2 == null) {
                                                            break Label_1284;
                                                        }
                                                    }
                                                }
                                            }
                                            final String field_82827_c2 = BossStatus.field_82827_c;
                                        }
                                        float field_82826_b3 = 0.0f;
                                        Label_1192: {
                                            if (field_82827_c != null) {
                                                final int n18 = (int)(field_82826_b3 = BossStatus.field_82826_b);
                                                if (array2 != null) {
                                                    break Label_1192;
                                                }
                                                if (n18 > 0) {
                                                    this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 20.0, Math.max(10.0f, Math.abs(this.animationY2 - 20.0f) * 25.0f) * 0.3);
                                                    if (array2 == null) {
                                                        break Label_1284;
                                                    }
                                                }
                                            }
                                            field_82826_b3 = fcmpg(Class102.mc.field_71439_g.func_110143_aJ(), 6.0f);
                                        }
                                        if (field_82826_b3 <= 0) {
                                            this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 30.0, Math.max(10.0f, Math.abs(this.animationY2 - 30.0f) * 25.0f) * 0.3);
                                            if (array2 == null) {
                                                break Label_1284;
                                            }
                                        }
                                        this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 2.0, Math.max(10.0f, Math.abs(this.animationY2 - 2.0f) * 25.0f) * 0.3);
                                    }
                                    final int n19 = func_78326_a / 2 - 90;
                                    Label_1496: {
                                        if (array2 == null) {
                                            final float n20 = n19;
                                            final float animationY2 = this.animationY2;
                                            final float n21 = func_78326_a / 2 + 90;
                                            final float n22 = this.animationY2 + 20.0f;
                                            final int n23 = reAlpha;
                                            drawRoundedRect2(n20, animationY2, n21, n22, n23, n23);
                                            if (Scaffold.currentlyHolding != null) {
                                                GL11.glPushMatrix();
                                                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                                                final Minecraft mc = Class102.mc;
                                                if (array2 == null) {
                                                    if (mc.field_71441_e != null) {
                                                        RenderHelper.func_74520_c();
                                                    }
                                                    GlStateManager.func_179094_E();
                                                    GlStateManager.func_179118_c();
                                                    GlStateManager.func_179086_m(256);
                                                    Class102.mc.func_175599_af().field_77023_b = -150.0f;
                                                    Class102.mc.func_175599_af().func_180450_b(Scaffold.currentlyHolding, func_78326_a / 2 - 90 + 2, (int)(this.animationY2 + 2.0f));
                                                    final Minecraft mc2 = Class102.mc;
                                                }
                                                mc.func_175599_af().field_77023_b = 0.0f;
                                                GlStateManager.func_179084_k();
                                                GlStateManager.func_179139_a(0.5, 0.5, 0.5);
                                                GlStateManager.func_179097_i();
                                                GlStateManager.func_179140_f();
                                                GlStateManager.func_179126_j();
                                                GlStateManager.func_179152_a(2.0f, 2.0f, 2.0f);
                                                GlStateManager.func_179141_d();
                                                GlStateManager.func_179121_F();
                                                GL11.glPopMatrix();
                                                if (array2 == null) {
                                                    break Label_1496;
                                                }
                                            }
                                            Class139.INSTANCE.fontManager.icon30.drawString(Class102.lIlIIlllIlI[1], func_78326_a / 2 - 88, this.animationY2 + 2.5f, Class22.GREY.c);
                                        }
                                    }
                                    Class139.INSTANCE.fontManager.usans18.drawCenteredString(String.valueOf(new StringBuilder().append(getBlockCount()).append(" blocks left")), func_78326_a / 2 - 2, this.animationY2 + 5.5f, Class22.GREY.c);
                                    if (array2 == null) {
                                        break Label_1696;
                                    }
                                }
                                this.animationY2 += 65.0f;
                                n16 = Class23.reAlpha(Class22.WHITE.c, 0.8f);
                            }
                            final int n24 = n16;
                            this.animationY2 = (float)Class69.getAnimationState(this.animationY2, -25.0, Math.max(10.0f, Math.abs(this.animationY2 + 25.0f) * 15.0f) * 0.3);
                            this.animationY2 -= 65.0f;
                            final float n25 = func_78326_a / 2 - 90;
                            final float animationY3 = this.animationY2;
                            final float n26 = func_78326_a / 2 + 90;
                            final float n27 = this.animationY2 + 20.0f;
                            final int n28 = n24;
                            drawRoundedRect2(n25, animationY3, n26, n27, n28, n28);
                            Class139.INSTANCE.fontManager.usans18.drawCenteredString("Scaffold Disabled", func_78326_a / 2 - 2, this.animationY2 + 5.5f, Class22.GREY.c);
                        }
                        if (BossStatus.field_82827_c != null && BossStatus.field_82826_b > 0) {
                            this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 20.0, Math.max(10.0f, Math.abs(this.animationY2 - 20.0f) * 25.0f) * 0.3);
                            if (array2 == null) {
                                return;
                            }
                        }
                        this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 2.0, Math.max(10.0f, Math.abs(this.animationY2 - 2.0f) * 25.0f) * 0.3);
                        return;
                    }
                    if (array != null) {
                        break;
                    }
                }
                GlStateManager.func_179084_k();
                GlStateManager.func_179124_c(1.0f, 1.0f, 1.0f);
                RenderHelper.func_74518_a();
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                continue;
            }
        }
    }
    
    private void renderScaffold() {
        final int[] b = Class139.b();
        final ScaledResolution scaledResolution = new ScaledResolution(Class102.mc);
        final int[] array = b;
        final int func_78326_a = scaledResolution.func_78326_a();
        int n;
        final boolean b2 = (n = (Class4.getModule("Scaffold").state ? 1 : 0)) != 0;
        Label_0721: {
            if (array == null) {
                if (b2) {
                    final int reAlpha = Class23.reAlpha(Class22.WHITE.c, 0.8f);
                    final String field_82827_c = BossStatus.field_82827_c;
                    Label_0312: {
                        if (array == null) {
                            Label_0141: {
                                if (field_82827_c != null) {
                                    float field_82826_b;
                                    final int n2 = (int)(field_82826_b = BossStatus.field_82826_b);
                                    if (array == null) {
                                        if (n2 <= 0) {
                                            break Label_0141;
                                        }
                                        field_82826_b = fcmpg(Class102.mc.field_71439_g.func_110143_aJ(), 6.0f);
                                    }
                                    if (field_82826_b <= 0) {
                                        this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 50.0, Math.max(10.0f, Math.abs(this.animationY2 - 50.0f) * 25.0f) * 0.3);
                                        if (array == null) {
                                            break Label_0312;
                                        }
                                    }
                                }
                            }
                            final String field_82827_c2 = BossStatus.field_82827_c;
                        }
                        float field_82826_b2 = 0.0f;
                        Label_0220: {
                            if (field_82827_c != null) {
                                final int n3 = (int)(field_82826_b2 = BossStatus.field_82826_b);
                                if (array != null) {
                                    break Label_0220;
                                }
                                if (n3 > 0) {
                                    this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 20.0, Math.max(10.0f, Math.abs(this.animationY2 - 20.0f) * 25.0f) * 0.3);
                                    if (array == null) {
                                        break Label_0312;
                                    }
                                }
                            }
                            field_82826_b2 = fcmpg(Class102.mc.field_71439_g.func_110143_aJ(), 6.0f);
                        }
                        if (field_82826_b2 <= 0) {
                            this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 30.0, Math.max(10.0f, Math.abs(this.animationY2 - 30.0f) * 25.0f) * 0.3);
                            if (array == null) {
                                break Label_0312;
                            }
                        }
                        this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 2.0, Math.max(10.0f, Math.abs(this.animationY2 - 2.0f) * 25.0f) * 0.3);
                    }
                    final int n4 = func_78326_a / 2 - 90;
                    Label_0523: {
                        if (array == null) {
                            final float n5 = n4;
                            final float animationY2 = this.animationY2;
                            final float n6 = func_78326_a / 2 + 90;
                            final float n7 = this.animationY2 + 20.0f;
                            final int n8 = reAlpha;
                            drawRoundedRect2(n5, animationY2, n6, n7, n8, n8);
                            if (Scaffold.currentlyHolding != null) {
                                GL11.glPushMatrix();
                                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                                final Minecraft mc = Class102.mc;
                                if (array == null) {
                                    if (mc.field_71441_e != null) {
                                        RenderHelper.func_74520_c();
                                    }
                                    GlStateManager.func_179094_E();
                                    GlStateManager.func_179118_c();
                                    GlStateManager.func_179086_m(256);
                                    Class102.mc.func_175599_af().field_77023_b = -150.0f;
                                    Class102.mc.func_175599_af().func_180450_b(Scaffold.currentlyHolding, func_78326_a / 2 - 90 + 2, (int)(this.animationY2 + 2.0f));
                                    final Minecraft mc2 = Class102.mc;
                                }
                                mc.func_175599_af().field_77023_b = 0.0f;
                                GlStateManager.func_179084_k();
                                GlStateManager.func_179139_a(0.5, 0.5, 0.5);
                                GlStateManager.func_179097_i();
                                GlStateManager.func_179140_f();
                                GlStateManager.func_179126_j();
                                GlStateManager.func_179152_a(2.0f, 2.0f, 2.0f);
                                GlStateManager.func_179141_d();
                                GlStateManager.func_179121_F();
                                GL11.glPopMatrix();
                                if (array == null) {
                                    break Label_0523;
                                }
                            }
                            Class139.INSTANCE.fontManager.icon30.drawString(Class102.lIlIIlllIlI[1], func_78326_a / 2 - 88, this.animationY2 + 2.5f, Class22.GREY.c);
                        }
                    }
                    Class139.INSTANCE.fontManager.usans18.drawCenteredString(String.valueOf(new StringBuilder().append(getBlockCount()).append(" blocks left")), func_78326_a / 2 - 2, this.animationY2 + 5.5f, Class22.GREY.c);
                    if (array == null) {
                        break Label_0721;
                    }
                }
                this.animationY2 += 65.0f;
                n = Class23.reAlpha(Class22.WHITE.c, 0.8f);
            }
            final int n9 = n;
            this.animationY2 = (float)Class69.getAnimationState(this.animationY2, -25.0, Math.max(10.0f, Math.abs(this.animationY2 + 25.0f) * 15.0f) * 0.3);
            this.animationY2 -= 65.0f;
            final float n10 = func_78326_a / 2 - 90;
            final float animationY3 = this.animationY2;
            final float n11 = func_78326_a / 2 + 90;
            final float n12 = this.animationY2 + 20.0f;
            final int n13 = n9;
            drawRoundedRect2(n10, animationY3, n11, n12, n13, n13);
            Class139.INSTANCE.fontManager.usans18.drawCenteredString("Scaffold Disabled", func_78326_a / 2 - 2, this.animationY2 + 5.5f, Class22.GREY.c);
        }
        if (BossStatus.field_82827_c != null && BossStatus.field_82826_b > 0) {
            this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 20.0, Math.max(10.0f, Math.abs(this.animationY2 - 20.0f) * 25.0f) * 0.3);
            if (array == null) {
                return;
            }
        }
        this.animationY2 = (float)Class69.getAnimationState(this.animationY2, 2.0, Math.max(10.0f, Math.abs(this.animationY2 - 2.0f) * 25.0f) * 0.3);
    }
    
    private static void drawRoundedRect2(float n, float n2, float n3, float n4, final int n5, final int n6) {
        enableGL2D();
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        drawVLine(n *= 2.0f, (n2 *= 2.0f) + 1.0f, (n4 *= 2.0f) - 2.0f, n5);
        drawVLine((n3 *= 2.0f) - 1.0f, n2 + 1.0f, n4 - 2.0f, n5);
        drawHLine(n + 2.0f, n3 - 3.0f, n2, n5);
        drawHLine(n + 2.0f, n3 - 3.0f, n4 - 1.0f, n5);
        drawHLine(n + 1.0f, n + 1.0f, n2 + 1.0f, n5);
        drawHLine(n3 - 2.0f, n3 - 2.0f, n2 + 1.0f, n5);
        drawHLine(n3 - 2.0f, n3 - 2.0f, n4 - 2.0f, n5);
        drawHLine(n + 1.0f, n + 1.0f, n4 - 2.0f, n5);
        Class69.drawRect(n + 1.0f, n2 + 1.0f, n3 - 1.0f, n4 - 1.0f, n6);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        disableGL2D();
    }
    
    private static void drawHLine(float n, float n2, final float n3, final int n4) {
        final int[] b = Class139.b();
        final float n5 = n2;
        float n6 = n;
        if (b == null) {
            if (n5 < n) {
                final float n7 = n;
                n = n2;
                n2 = n7;
            }
            n6 = n3;
        }
        Class69.drawRect(n5, n6, n2 + 1.0f, n3 + 1.0f, n4);
    }
    
    private static void drawVLine(final float n, float n2, float n3, final int n4) {
        final int[] b = Class139.b();
        final float n5 = n3;
        float n6 = n2;
        if (b == null) {
            if (n5 < n2) {
                final float n7 = n2;
                n2 = n3;
                n3 = n7;
            }
            n6 = n2 + 1.0f;
        }
        Class69.drawRect(n5, n6, n + 1.0f, n3, n4);
    }
    
    private static int getBlockCount() {
        final int[] b = Class139.b();
        int n = 0;
        int i = 36;
        final int[] array = b;
        while (i < 45) {
            final Slot func_75139_a = Class102.mc.field_71439_g.field_71069_bz.func_75139_a(i);
            Label_0151: {
                Label_0148: {
                    if (array == null) {
                        final int func_75216_d;
                        final boolean b2 = (func_75216_d = (func_75139_a.func_75216_d() ? 1 : 0)) != 0;
                        if (array != null) {
                            return func_75216_d;
                        }
                        if (!b2) {
                            break Label_0148;
                        }
                        Class102.mc.field_71439_g.field_71069_bz.func_75139_a(i);
                    }
                    final ItemStack func_75211_c;
                    final Item func_77973_b = (func_75211_c = func_75139_a.func_75211_c()).func_77973_b();
                    if (array != null) {
                        break Label_0151;
                    }
                    if (func_75211_c.func_77973_b() instanceof ItemBlock) {
                        final int[] b3 = Class139.b();
                        Object o;
                        final ItemBlock itemBlock = (ItemBlock)(o = func_77973_b);
                        int contains = 0;
                        final int n2;
                        Label_0134: {
                            if (b3 == null) {
                                if (!(itemBlock instanceof ItemBlock)) {
                                    final boolean b4;
                                    contains = ((b4 = false) ? 1 : 0);
                                    break Label_0134;
                                }
                                o = func_77973_b;
                            }
                            n2 = (contains = (Scaffold.blacklistedBlocks.contains(((ItemBlock)o).func_179223_d()) ? 1 : 0));
                            if (b3 == null) {
                                final boolean b4;
                                contains = ((b4 = (n2 == 0)) ? 1 : 0);
                            }
                        }
                        if (array == null) {
                            if (n2 == 0) {
                                break Label_0148;
                            }
                            contains = n + func_75211_c.field_77994_a;
                        }
                        n = contains;
                    }
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
        return n;
    }
    
    private static boolean isValid(final Item item) {
        final int[] b = Class139.b();
        Item item2 = item;
        if (b == null) {
            if (!(item instanceof ItemBlock)) {
                return false;
            }
            item2 = item;
        }
        final boolean contains = Scaffold.blacklistedBlocks.contains(((ItemBlock)item2).func_179223_d());
        return (b != null || !contains) && contains;
    }
    
    public static void customRenderHotbarItem(final int n, final int n2, final int n3, float n4, final EntityPlayer entityPlayer) {
        final int[] b = Class139.b();
        GlStateManager.func_179084_k();
        final int[] array = b;
        ItemStack itemStack3;
        final ItemStack itemStack2;
        final ItemStack itemStack = itemStack2 = (itemStack3 = entityPlayer.field_71071_by.field_70462_a[n]);
        if (array == null) {
            if (itemStack == null) {
                return;
            }
            itemStack3 = itemStack2;
        }
        final float n5 = fcmpl(n4 = itemStack3.field_77992_b - n4, 0.0f);
        final RenderItem func_175599_af;
        Label_0150: {
            if (array == null) {
                if (n5 > 0) {
                    GlStateManager.func_179094_E();
                    final float n6 = 1.0f + n4 / 5.0f;
                    GlStateManager.func_179109_b((float)(n2 + 8), (float)(n3 + 12), 0.0f);
                    GlStateManager.func_179152_a(1.0f / n6, (n6 + 1.0f) / 2.0f, 1.0f);
                    GlStateManager.func_179109_b((float)(-(n2 + 8)), (float)(-(n3 + 12)), 0.0f);
                }
                func_175599_af = Class102.mc.func_175599_af();
                if (array != null) {
                    break Label_0150;
                }
                func_175599_af.func_180450_b(itemStack2, n2, n3);
                final float n7 = fcmpl(n4, 0.0f);
            }
            if (n5 > 0) {
                GlStateManager.func_179121_F();
            }
            Class102.mc.func_175599_af();
        }
        func_175599_af.func_175030_a((FontRenderer)Class139.INSTANCE.fontManager.comfortaa16, itemStack2, n2 - 1, n3);
    }
    
    private static void renderArray(final ScaledResolution scaledResolution) {
        final int[] b = Class139.b();
        final ArrayList<Mod> list = new ArrayList<Mod>(Class4.getEnabledModListHUD());
        float posY = 3.0f;
        final UnicodeFontRenderer raleway17 = Class139.INSTANCE.fontManager.raleway17;
        final Iterator<Mod> iterator = list.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final Mod mod;
            (mod = iterator.next()).onRenderArray();
            final Mod mod2 = mod;
            if (array == null) {
                if (!mod2.state) {
                    final Mod mod3 = mod;
                    if (array == null) {
                        if (mod3.posX == 0.0f && array == null) {
                            continue;
                        }
                    }
                }
            }
            final String name = mod2.getName();
            final String displayName = mod.displayName;
            final float posX = mod.posX;
            final Mod mod4 = mod;
            mod4.lastY = mod4.posY;
            mod.posY = posY;
            Class69.drawRect(scaledResolution.func_78326_a() - posX - 7.0f, posY + mod.posYRend - 3.5f, scaledResolution.func_78326_a(), posY + mod.posYRend + 10.5f, Class23.reAlpha(Class22.BLACK.c, 0.55f));
            Class69.drawRect(scaledResolution.func_78326_a() - posX - 7.0f, posY + mod.posYRend - 3.5f, scaledResolution.func_78326_a() - posX - 5.0f, posY + mod.posYRend + 10.5f, new Color(47, 116, 253).getRGB());
            raleway17.drawString(name, scaledResolution.func_78326_a() - posX - 2.0f, posY + mod.posYRend - 1.5f, new Color(47, 116, 253).getRGB());
            if (array == null) {
                if (displayName != null) {
                    raleway17.drawString(displayName, scaledResolution.func_78326_a() - posX + raleway17.func_78256_a(name), posY + mod.posYRend - 1.5f, new Color(159, 159, 159).getRGB());
                }
                posY += 14.0f;
            }
            if (array != null) {
                break;
            }
        }
    }
    
    private void renderPotionStatus(final int n, final int n2) {
        this.x = 0;
        final int[] b = Class139.b();
        final Iterator iterator = Class102.mc.field_71439_g.func_70651_bq().iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final PotionEffect potionEffect = iterator.next();
            final Potion potion;
            String s = I18n.func_135052_a((potion = Potion.field_76425_a[potionEffect.func_76456_a()]).func_76393_a(), new Object[0]);
            final PotionEffect potionEffect2 = potionEffect;
            int int1;
            int int2;
            try {
                int1 = Integer.parseInt(Potion.func_76389_a(potionEffect2).split(Class102.lIlIIlllIlI[2])[0]);
                int2 = Integer.parseInt(Potion.func_76389_a(potionEffect).split(Class102.lIlIIlllIlI[3])[1]);
            }
            catch (Exception ex) {
                int1 = 0;
                int2 = 0;
            }
            final double n3 = int1 * 60 + int2;
            double containsKey;
            final boolean b2 = (containsKey = (this.timerMap.containsKey(potion) ? 1 : 0)) != 0.0;
            final double n5;
            Label_0252: {
                Label_0246: {
                    if (array == null) {
                        if (!b2) {
                            this.timerMap.put(potion, n3);
                        }
                        final Double n4 = this.timerMap.get(potion);
                        if (array != null) {
                            break Label_0246;
                        }
                        containsKey = dcmpl((double)n4, 0.0);
                    }
                    if (containsKey != 0) {
                        n5 = dcmpl(n3, (double)this.timerMap.get(potion));
                        if (array != null) {
                            break Label_0252;
                        }
                        if (n5 <= 0) {
                            break Label_0246;
                        }
                    }
                    this.timerMap.replace(potion, n3);
                }
                potionEffect.func_76458_c();
            }
            if (array == null) {
                Label_0336: {
                    switch (n5) {
                        case 1: {
                            s = String.valueOf(new StringBuilder().append(s).append(" II"));
                            if (array != null) {
                                break Label_0336;
                            }
                            break;
                        }
                        case 2: {
                            s = String.valueOf(new StringBuilder().append(s).append(" III"));
                            if (array != null) {
                                break Label_0336;
                            }
                            break;
                        }
                        case 3: {
                            s = String.valueOf(new StringBuilder().append(s).append(" IV"));
                            break;
                        }
                    }
                }
                final Class22 white = Class22.WHITE;
            }
            int n8;
            final int n7;
            final int n6 = n7 = (n8 = potionEffect.func_76459_b());
            int n11;
            final int n10;
            final int n9 = n10 = (n11 = 600);
            final int n12;
            final int n13;
            final int func_76459_b;
            final int n14;
            Label_0410: {
                if (array == null) {
                    if (n6 < n9) {
                        n12 = (n8 = potionEffect.func_76459_b());
                        n13 = (n11 = 300);
                        if (array != null) {
                            break Label_0410;
                        }
                        if (lllIlllllIIl(n12, n13)) {
                            final Class22 yellow = Class22.YELLOW;
                            if (array == null) {
                                goto Label_0446;
                            }
                        }
                    }
                    func_76459_b = potionEffect.func_76459_b();
                    n14 = 300;
                }
            }
            if (array == null) {
                if (n6 < n9) {
                    final Class22 red = Class22.RED;
                    if (array == null) {
                        goto Label_0446;
                    }
                }
                potionEffect.func_76459_b();
            }
            if (array == null && lllIlllllIIl(n12, n13)) {
                final Class22 white2 = Class22.WHITE;
                goto Label_0446;
            }
            final int n15 = (int)((func_76459_b - n14) * 1.33f);
            final int n16 = (int)((n2 - 52 - Class102.mc.field_71466_p.field_78288_b + this.x + 5) * 1.33f);
            final float n17 = n - 120;
            final float n18 = n2 - 60 + this.x;
            final float n19 = n - 10;
            final float n20 = n2 - 30 + this.x;
            final Class23 instance = Class23.INSTANCE;
            Class69.drawRect(n17, n18, n19, n20, Class23.reAlpha(Class22.BLACK.c, 0.41f));
            int func_76400_d;
            final int n21 = func_76400_d = (potion.func_76400_d() ? 1 : 0);
            if (array == null) {
                if (n21 != 0) {
                    GlStateManager.func_179094_E();
                    GL11.glDisable(2929);
                    GL11.glEnable(3042);
                    GL11.glDepthMask(false);
                    OpenGlHelper.func_148821_a(770, 771, 1, 0);
                    GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                    final int func_76392_e = potion.func_76392_e();
                    Class102.mc.func_110434_K().func_110577_a(new ResourceLocation("textures/gui/container/inventory.png"));
                    GlStateManager.func_179139_a(0.75, 0.75, 0.75);
                    Class102.mc.field_71456_v.func_73729_b(n15 - 138, n16 + 8, 0 + func_76392_e % 8 * 18, 198 + func_76392_e / 8 * 18, 18, 18);
                    GL11.glDepthMask(true);
                    GL11.glDisable(3042);
                    GL11.glEnable(2929);
                    GlStateManager.func_179121_F();
                }
                func_76400_d = n2 - Class102.mc.field_71466_p.field_78288_b + this.x - 38;
            }
            final int n22 = func_76400_d;
            Class139.INSTANCE.fontManager.wqy18.drawString(s.replaceAll("§.", Class102.lIlIIlllIlI[4]), n - 91.0f, n22 - Class102.mc.field_71466_p.field_78288_b + 1, new Color(47, 116, 253).getRGB());
            Class139.INSTANCE.fontManager.comfortaa16.drawString(Potion.func_76389_a(potionEffect).replaceAll("§.", Class102.lIlIIlllIlI[5]), n - 91.0f, n22 + 4, Class23.reAlpha(-1, 0.8f));
            this.x -= 35;
            if (array != null) {
                break;
            }
        }
    }
    
    private static void lambda$new$2(final Map.Entry entry) {
        final int[] b = Class139.b();
        final Class242 class242 = new Class242(entry.getKey().toString());
        final int[] array = b;
        for (final Mod mod : (List)entry.getValue()) {
            class242.subTabs.add((Class306<T>)new Class306<Object>(mod.getName(), Class102::lambda$null$1, mod));
            if (array != null) {
                break;
            }
        }
    }
    
    private static void lambda$null$1(final Class306 class306) {
        final int[] b = Class139.b();
        final Mod mod = (Mod)class306.object;
        final boolean state = ((Mod)class306.object).state;
        if (b == null && state) {}
        mod.setState(state);
    }
    
    private static int lambda$new$0(final Map.Entry entry) {
        return entry.getKey().toString().hashCode();
    }
    
    static {
        lllIlIIIllIl();
        Class169.a(6303403806133809697L, 8814085850371893152L, MethodHandles.lookup().lookupClass()).a(201092137711350L);
        j = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class102.lIlIIlllIlI[6]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class102.lIlIIlllIlI[7]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(100522554534122L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[31];
        int n2 = 0;
        final String s = "õ_n¸ÒU\u008dînÒo\u0011óº·§kí×8\u00817¸Å\u0010k\u0012^\u0006\u0010\u0017C\u008aA\u0002®Ü\u0089\u0018\u001f¢\u0010\u008f~ÂÿÞ¿\u001dâ?Í\u0015îÆÞq\u0002\u0010ÍóÔK\u0018Ï¸øÂ`v\u0085[\u000bü9 \u0088\u0004ÔBØ|\u007fÏ1ì\u0017hÆAyV\u0004D<«â¯\u001fÌUs¾\f¥\u001ee\" \u0014y\f3úxÓ²ÙG\u000eó\f=\u0095¬Ütâ\u0002?ÄõVú\u0095`9\u008a_<t\u0010Ä\u0083ÝÄØ?ë\u0090ð¼\u0012g8#\u0086\u007f\u0018\u0010×´;\u00ad~\u001et\u0098\u0093ÕªÂ½Ù\u0083ÑÖhäz°\u0081 \u0010\u009a\nA:g\u0092òî´\"bù\u0083ÕÕ\u0004 XþG-×Ç8^t\u0006\u0095\u0017½Dñ±ãû¨èbGQÞ¦\u0081¡Þ»\u0013a7\u0018\u008d½\u0016ýAkÑè\u0015\u0015ÓG¾O³\u001cB\u008d[É\u001f¬\t\u0083HÈ$àiï*\u00ad@sì[_0\u0010\u0016\u0007²\u0099\u0013¾#\u0016BGe\u0015\u0016ýúÄ\u0099\u001f¨c7ëQ(¦¼Ñ\u0000î_¡\u008af\u000f\u008fea/È\u0015Q _z'?\u0099\u0017öÙ#b\u0091\u0004\u0099ÂÑö\u0010×è3¡(h^4\u009e·M+©\u001d\u0099X\u0018ï\u009d\u001a\u0086íM\u0003Ï\u0000\u0003\u0006\u001bÄ+\u0091â\u0019\r>\"\u0005w\u0097e\u0010]K \u00058\r×1t\"\u001b\u001f\u009e\fà;\u0010Eý'Ï\u00825ó\u008e\u0015ì£\u000e¤ºô_ \u0085 q/@\u000eÎ\u0092I\u0005Ö\u0084\u0087\u00867\u008bC\f\bELñpÆÄëÆò*Á\u009cA\u0018ã=\u008b~mÛITj´ò§\u0086\u0082\u0095\u0011m\u001eolØ\u0080Fè0tW4º¿¸\u0002¬Èî°a\u0093\u009dÊ¥ùr\u0001\u0003cvoó1ÙOÁ\u0094\u0091-V³\u0004)Úþ\u0090rÒõô½D¼\u0012j¢(\u0019¹ê\u009a\u0012ggÇ\\J\u009a£Ì°3S\u0095[\u008d\u000bH\u0096ÃÇU\u0007\u000b©lz#;3zß\u008e[KÊ%\u0010ê\u0006Óß\u0096t¹²Æö½[\u0011\u008e\u008dÄ\u0010\u008a-\u0007\bË\u001d\n\u0001\u0015Ú×\u008a\u0001)\u00035 \u001aÓ\u0095åÿo]ù\u0019TZ¥\\rkå\u0011uX¢ÆìØ\u0086\u001e1ü¯Ù@H@\u0010AYÑãVÀ~¨\b|\u000fA\u009e>¹-\u0010çÚðQ:Ø\u0088Í+ ê+²\u0087/\u009b\u0010\u0090\u0017o{\u00adßÁ\n;\u0003¤Î#\u001cA\u0083\u0010`DA\u008b\u00959-Ð\u0004Î\u0015Î\u0000I\u0084\u0001(\u0007pf\u001a\u008dÌEGÈ\u0014lá Q¯Ø\\\u0092\u0090Á\u0082\u009a0<\u0088À6.I\u009a\u008c¾^r\u0086þcê\t9\u00108´sçS±$\u008a(&Ùl¡õ»®";
        String s2 = "õ_n¸ÒU\u008dînÒo\u0011óº·§kí×8\u00817¸Å\u0010k\u0012^\u0006\u0010\u0017C\u008aA\u0002®Ü\u0089\u0018\u001f¢\u0010\u008f~ÂÿÞ¿\u001dâ?Í\u0015îÆÞq\u0002\u0010ÍóÔK\u0018Ï¸øÂ`v\u0085[\u000bü9 \u0088\u0004ÔBØ|\u007fÏ1ì\u0017hÆAyV\u0004D<«â¯\u001fÌUs¾\f¥\u001ee\" \u0014y\f3úxÓ²ÙG\u000eó\f=\u0095¬Ütâ\u0002?ÄõVú\u0095`9\u008a_<t\u0010Ä\u0083ÝÄØ?ë\u0090ð¼\u0012g8#\u0086\u007f\u0018\u0010×´;\u00ad~\u001et\u0098\u0093ÕªÂ½Ù\u0083ÑÖhäz°\u0081 \u0010\u009a\nA:g\u0092òî´\"bù\u0083ÕÕ\u0004 XþG-×Ç8^t\u0006\u0095\u0017½Dñ±ãû¨èbGQÞ¦\u0081¡Þ»\u0013a7\u0018\u008d½\u0016ýAkÑè\u0015\u0015ÓG¾O³\u001cB\u008d[É\u001f¬\t\u0083HÈ$àiï*\u00ad@sì[_0\u0010\u0016\u0007²\u0099\u0013¾#\u0016BGe\u0015\u0016ýúÄ\u0099\u001f¨c7ëQ(¦¼Ñ\u0000î_¡\u008af\u000f\u008fea/È\u0015Q _z'?\u0099\u0017öÙ#b\u0091\u0004\u0099ÂÑö\u0010×è3¡(h^4\u009e·M+©\u001d\u0099X\u0018ï\u009d\u001a\u0086íM\u0003Ï\u0000\u0003\u0006\u001bÄ+\u0091â\u0019\r>\"\u0005w\u0097e\u0010]K \u00058\r×1t\"\u001b\u001f\u009e\fà;\u0010Eý'Ï\u00825ó\u008e\u0015ì£\u000e¤ºô_ \u0085 q/@\u000eÎ\u0092I\u0005Ö\u0084\u0087\u00867\u008bC\f\bELñpÆÄëÆò*Á\u009cA\u0018ã=\u008b~mÛITj´ò§\u0086\u0082\u0095\u0011m\u001eolØ\u0080Fè0tW4º¿¸\u0002¬Èî°a\u0093\u009dÊ¥ùr\u0001\u0003cvoó1ÙOÁ\u0094\u0091-V³\u0004)Úþ\u0090rÒõô½D¼\u0012j¢(\u0019¹ê\u009a\u0012ggÇ\\J\u009a£Ì°3S\u0095[\u008d\u000bH\u0096ÃÇU\u0007\u000b©lz#;3zß\u008e[KÊ%\u0010ê\u0006Óß\u0096t¹²Æö½[\u0011\u008e\u008dÄ\u0010\u008a-\u0007\bË\u001d\n\u0001\u0015Ú×\u008a\u0001)\u00035 \u001aÓ\u0095åÿo]ù\u0019TZ¥\\rkå\u0011uX¢ÆìØ\u0086\u001e1ü¯Ù@H@\u0010AYÑãVÀ~¨\b|\u000fA\u009e>¹-\u0010çÚðQ:Ø\u0088Í+ ê+²\u0087/\u009b\u0010\u0090\u0017o{\u00adßÁ\n;\u0003¤Î#\u001cA\u0083\u0010`DA\u008b\u00959-Ð\u0004Î\u0015Î\u0000I\u0084\u0001(\u0007pf\u001a\u008dÌEGÈ\u0014lá Q¯Ø\\\u0092\u0090Á\u0082\u009a0<\u0088À6.I\u009a\u008c¾^r\u0086þcê\t9\u00108´sçS±$\u008a(&Ùl¡õ»®";
        int n3 = s.length();
        int n4 = 24;
        int n5 = -1;
    Label_0149:
        while (true) {
            while (true) {
                ++n5;
                final String s3 = s2;
                final int n6 = n5;
                String s4 = s3.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s4.getBytes(Class102.lIlIIlllIlI[9]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                continue Label_0149;
                            }
                            n3 = (s2 = Class102.lIlIIlllIlI[8]).length();
                            n4 = 24;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                break;
                            }
                            break Label_0149;
                        }
                    }
                    ++n5;
                    final String s5 = s2;
                    final int n8 = n5;
                    s4 = s5.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        c = c2;
        d = new String[31];
        DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter.ofPattern("HH:mm:ss");
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x634A;
        if (Class102.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class102.j.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class102.lIlIIlllIlI[10]);
                    array[1] = SecretKeyFactory.getInstance(Class102.lIlIIlllIlI[11]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class102.j.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class102.lIlIIlllIlI[12], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class102.d[n3] = b(((Cipher)array[0]).doFinal(Class102.c[n3].getBytes(Class102.lIlIIlllIlI[13])));
        }
        return Class102.d[n3];
    }
    
    private static void lllIlIIIllIl() {
        (lIlIIlllIlI = new String[17])[0] = "";
        Class102.lIlIIlllIlI[1] = "c";
        Class102.lIlIIlllIlI[2] = ":";
        Class102.lIlIIlllIlI[3] = ":";
        Class102.lIlIIlllIlI[4] = "";
        Class102.lIlIIlllIlI[5] = "";
        Class102.lIlIIlllIlI[6] = "DES/CBC/PKCS5Padding";
        Class102.lIlIIlllIlI[7] = "DES";
        Class102.lIlIIlllIlI[8] = "X?T«äÐ×÷T}\u0098t¹¨\u001bL9\u0016¸è\u008b}\\s\u0018\u009e\u0085Ó\u000fÝô\u0014r\u0006Ê´QÆ\u0006[¡Aj»!\u0003ÉàQ";
        Class102.lIlIIlllIlI[9] = "ISO-8859-1";
        Class102.lIlIIlllIlI[10] = "DES/CBC/PKCS5Padding";
        Class102.lIlIIlllIlI[11] = "DES";
        Class102.lIlIIlllIlI[12] = "你是不是想气急败坏的冲到现实来找我呢你们这样只会复制到脑里面装不进你在说下看看其实我还想说就你这样不成材的东西就算打回受精卵重也超越不了我 一会装的好像我的语言对你无关痛痒好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u2009\u200f\u200f";
        Class102.lIlIIlllIlI[13] = "ISO-8859-1";
        Class102.lIlIIlllIlI[14] = "你是不是想气急败坏的冲到现实来找我呢你们这样只会复制到脑里面装不进你在说下看看其实我还想说就你这样不成材的东西就算打回受精卵重也超越不了我 一会装的好像我的语言对你无关痛痒好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u2009\u200f\u200f";
        Class102.lIlIIlllIlI[15] = " : ";
        Class102.lIlIIlllIlI[16] = " : ";
    }
    
    private static String lllIlIIIlIIl(String s, final String s2) {
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
    
    private static String lllIlIIIIlll(final String s, final String s2) {
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
    
    private static String lllIlIIIlIII(final String s, final String s2) {
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
    
    private static boolean lllIlllllIIl(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lllIlllIlIlI(final int n) {
        return n < 0;
    }
    
    private static boolean lllIlllIIIll(final int n) {
        return n <= 0;
    }
    
    private static boolean lllIlllIIIlI(final int n) {
        return n > 0;
    }
    
    private static int lllIlllIIIII(final long n, final long n2) {
        return lcmp(n, n2);
    }
    
    private static int lllIlllIIlIl$2548a28(final float n) {
        return fcmpg(n, 6.0f);
    }
    
    private static int lllIlllIlIIl(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lllIlllIlIll(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lllIllllIIII$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lllIllllIlIl$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lllIlllllIII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
}
