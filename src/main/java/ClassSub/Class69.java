package ClassSub;

import java.awt.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import net.minecraft.entity.player.*;
import com.mojang.authlib.*;
import net.minecraft.client.network.*;
import net.minecraft.client.renderer.vertex.*;
import java.io.*;
import net.minecraft.util.*;
import cn.Hanabi.modules.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.shader.*;
import net.minecraft.client.renderer.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Class69
{
    public static float delta;
    private static final long a;
    private static final String b;
    private static final String[] lIIIIIIIIl;
    
    public Class69() {
        super();
    }
    
    private static double interpolate(final double n, final double n2) {
        return n2 + (n - n2) * Class94.getTimer().field_74281_c;
    }
    
    private static void pre() {
        GL11.glDisable(2929);
        GL11.glDisable(3553);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
    }
    
    private static void post() {
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glColor3d(1.0, 1.0, 1.0);
    }
    
    public static void drawArc$545f7cf2(float n, float n2, double n3, int n4, final int n5) {
        final int[] b = Class139.b();
        n3 *= 2.0;
        n *= 2.0f;
        n2 *= 2.0f;
        final float n6 = (n4 >> 24 & 0xFF) / 255.0f;
        final int[] array = b;
        final float n7 = (n4 >> 16 & 0xFF) / 255.0f;
        final float n8 = (n4 >> 8 & 0xFF) / 255.0f;
        final float n9 = (n4 & 0xFF) / 255.0f;
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glDepthMask(true);
        GL11.glEnable(2848);
        GL11.glHint(3154, 4354);
        GL11.glHint(3155, 4354);
        GL11.glScalef(0.5f, 0.5f, 0.5f);
        GL11.glLineWidth((float)n5);
        GL11.glEnable(2848);
        GL11.glColor4f(n7, n8, n9, n6);
        GL11.glBegin(3);
        n4 = 0;
        while (n4 <= 360.0) {
            GL11.glVertex2d(n + Math.sin(n4 * 3.141592653589793 / 180.0) * n3, n2 + Math.cos(n4 * 3.141592653589793 / 180.0) * n3);
            ++n4;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GL11.glEnd();
        GL11.glDisable(2848);
        GL11.glScalef(2.0f, 2.0f, 2.0f);
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glHint(3155, 4352);
    }
    
    private static int rainbow(final int n) {
        return Color.getHSBColor((float)(Math.ceil((System.currentTimeMillis() + n) / 20.0) % 360.0 / 360.0), 0.8f, 0.7f).brighter().getRGB();
    }
    
    private static Color rainbowEffect(final int n) {
        final Color color = new Color((int)Long.parseLong(Integer.toHexString(Color.HSBtoRGB((System.nanoTime() + n) / 2.0E10f % 1.0f, 1.0f, 1.0f)), 16));
        return new Color(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
    }
    
    private static void drawFullscreenImage(final ResourceLocation resourceLocation) {
        final ScaledResolution scaledResolution = new ScaledResolution(Minecraft.func_71410_x());
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        OpenGlHelper.func_148821_a(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        GL11.glDisable(3008);
        Minecraft.func_71410_x().func_110434_K().func_110577_a(resourceLocation);
        Gui.func_146110_a(0, 0, 0.0f, 0.0f, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), (float)scaledResolution.func_78326_a(), (float)scaledResolution.func_78328_b());
        GL11.glDepthMask(true);
        GL11.glEnable(2929);
        GL11.glEnable(3008);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
    }
    
    private static void drawPlayerHead(final String s, final int n, final int n2, final int n3, final int n4) {
        final int[] b = Class139.b();
        final Iterator iterator = Minecraft.func_71410_x().field_71441_e.field_73010_i.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final EntityPlayer entityPlayer = iterator.next();
            if (s.equalsIgnoreCase(entityPlayer.func_70005_c_())) {
                final NetworkPlayerInfo networkPlayerInfo = new NetworkPlayerInfo(new GameProfile(entityPlayer.func_110124_au(), entityPlayer.func_70005_c_()));
                new ScaledResolution(Minecraft.func_71410_x());
                GL11.glDisable(2929);
                GL11.glEnable(3042);
                GL11.glDepthMask(false);
                OpenGlHelper.func_148821_a(770, 771, 1, 0);
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                Minecraft.func_71410_x().func_110434_K().func_110577_a(networkPlayerInfo.func_178837_g());
                Gui.func_146110_a(n, n2, 0.0f, 0.0f, n3, n4, (float)n3, (float)n4);
                GL11.glDepthMask(true);
                GL11.glDisable(3042);
                GL11.glEnable(2929);
                if (array != null) {
                    break;
                }
                continue;
            }
        }
    }
    
    public static double getAnimationState(double n, final double n2, final double n3) {
        final int[] b = Class139.b();
        final float n4 = (float)(Class69.delta * n3);
        final int[] array = b;
        final double n5 = dcmpg(n, n2);
        final double n9;
        if (array == null) {
            if (n5 < 0) {
                double n7;
                final double n6 = n7 = n + n4;
                if (array == null) {
                    final double n8 = n6;
                    if (n6 < n2) {
                        n = n8;
                        if (array == null) {
                            return n;
                        }
                    }
                    n7 = n2;
                }
                n = n7;
                if (array == null) {
                    return n;
                }
            }
            n9 = n - n4;
            if (array != null) {
                return n9;
            }
            final double n10 = dcmpl(n9, n2);
        }
        if (n5 > 0) {
            n -= n4;
            if (array == null) {
                return n;
            }
        }
        n = n9;
        return n;
    }
    
    private static void drawLoadingCircle() {
        final float n = (float)(System.currentTimeMillis() * 0.1 % 400.0);
        final ScaledResolution scaledResolution;
        final float n2 = (scaledResolution = new ScaledResolution(Minecraft.func_71410_x())).func_78326_a() / 16.0f;
        drawCircle(scaledResolution.func_78326_a() / 2.0f, scaledResolution.func_78328_b() / 2.0f, n2, new Color(Class281.DARK_GREY.c), 5.0f, 0.0f, 1.0f);
        drawCircle(scaledResolution.func_78326_a() / 2.0f, scaledResolution.func_78328_b() / 2.0f, n2, new Color(Class281.BLUE.c), 7.0f, n, 0.5f);
    }
    
    private static void drawCircle(final int n, final int n2, final int n3, final Color color) {
        final int[] b = Class139.b();
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glShadeModel(7425);
        GL11.glBegin(2);
        int i = 0;
        while (i < 70) {
            final float n4 = (float)(n3 * Math.cos(i * 0.08975979010256552));
            final float n5 = (float)(n3 * Math.sin(i * 0.08975979010256552));
            GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
            GL11.glVertex2f(n + n4, n2 + n5);
            ++i;
            if (b != null) {
                return;
            }
            if (b != null) {
                break;
            }
        }
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
    
    private static void drawCircle(final float n, final float n2, final float n3, final Color color) {
        final int[] b = Class139.b();
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        final int[] array = b;
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glLineWidth(1.0f);
        GL11.glShadeModel(7425);
        GL11.glBegin(2);
        int i = 0;
        while (i < 70) {
            final float n4 = (float)(n3 * Math.cos(i * 0.08975979010256552));
            final float n5 = (float)(n3 * Math.sin(i * 0.08975979010256552));
            GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
            GL11.glVertex2f(n + n4, n2 + n5);
            ++i;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
    
    private static void drawCircle(final float n, final float n2, final float n3, final Color color, float n4, final float n5, final float n6) {
        final double n7 = n6 * 2.0f * 3.141592653589793 / 100.0;
        final int[] b = Class139.b();
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glLineWidth(n4);
        GL11.glShadeModel(7425);
        GL11.glBegin(2);
        int n8 = (int)n5;
        while (true) {
            while (n8 < n5 + 100.0f) {
                n4 = (float)(n3 * Math.cos(n8 * n7));
                final float n9 = (float)(n3 * Math.sin(n8 * n7));
                GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
                GL11.glVertex2f(n + n4, n2 + n9);
                ++n8;
                if (b != null) {
                    while (lIllllIIIll(n8, (int)n5)) {
                        n4 = (float)(n3 * Math.cos(n8 * n7));
                        final float n10 = (float)(n3 * Math.sin(n8 * n7));
                        GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
                        GL11.glVertex2f(n + n4, n2 + n10);
                        --n8;
                        if (b != null) {
                            return;
                        }
                        if (b != null) {
                            break;
                        }
                    }
                    GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
                    GL11.glEnd();
                    GL11.glEnable(3553);
                    GL11.glDisable(3042);
                    GL11.glDisable(2848);
                    GL11.glPopMatrix();
                    return;
                }
                if (b != null) {
                    break;
                }
            }
            n8 = (int)(n5 + 100.0f);
            continue;
        }
    }
    
    private static void drawFilledCircle(final int n, final int n2, final float n3, final Color color) {
        final int[] b = Class139.b();
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        final int[] array = b;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glBegin(6);
        int i = 0;
        while (i < 100) {
            final float n4 = (float)(n3 * Math.sin(i * 0.06283185307179587));
            final float n5 = (float)(n3 * Math.cos(i * 0.06283185307179587));
            GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
            GL11.glVertex2f(n + n4, n2 + n5);
            ++i;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
    
    private static void drawFilledCircle(final float n, final float n2, final float n3, final Color color) {
        GL11.glPushMatrix();
        final int[] b = Class139.b();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        final int[] array = b;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glBegin(6);
        int i = 0;
        while (i < 50) {
            final float n4 = (float)(n3 * Math.sin(i * 0.12566370614359174));
            final float n5 = (float)(n3 * Math.cos(i * 0.12566370614359174));
            GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
            GL11.glVertex2f(n + n4, n2 + n5);
            ++i;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
    
    private static void drawFilledCircle(final int n, final int n2, final float n3, final int n4) {
        final float n5 = (n4 >> 24 & 0xFF) / 255.0f;
        final int[] b = Class139.b();
        final float n6 = (n4 >> 16 & 0xFF) / 255.0f;
        final int[] array = b;
        final float n7 = (n4 >> 8 & 0xFF) / 255.0f;
        final float n8 = (n4 & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glBlendFunc(770, 771);
        GL11.glBegin(6);
        int i = 0;
        while (i < 50) {
            final float n9 = (float)(n3 * Math.sin(i * 0.12566370614359174));
            final float n10 = (float)(n3 * Math.cos(i * 0.12566370614359174));
            GL11.glColor4f(n6, n7, n8, n5);
            GL11.glVertex2f(n + n9, n2 + n10);
            ++i;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
    
    public static void drawFilledCircle$40982bc8(final float n, final int n2) {
        final float n3 = (n2 >> 24 & 0xFF) / 255.0f;
        final int[] b = Class139.b();
        final float n4 = (n2 >> 16 & 0xFF) / 255.0f;
        final float n5 = (n2 >> 8 & 0xFF) / 255.0f;
        final float n6 = (n2 & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        final int[] array = b;
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glBegin(6);
        int i = 0;
        while (i < 50) {
            final float n7 = (float)(3.0 * Math.sin(i * 0.12566370614359174));
            final float n8 = (float)(3.0 * Math.cos(i * 0.12566370614359174));
            GL11.glColor4f(n4, n5, n6, n3);
            GL11.glVertex2f(n7 + 10.0f, n + n8);
            ++i;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        GL11.glEnd();
        GL11.glEnable(3553);
        GL11.glDisable(3042);
        GL11.glDisable(2848);
        GL11.glPopMatrix();
    }
    
    private static void drawFilledCircle(final int n, final int n2, final float n3, final int n4, final int n5, final int n6, final int n7, final int n8) {
        final float n9 = (n4 >> 24 & 0xFF) / 255.0f;
        final int[] b = Class139.b();
        final float n10 = (n4 >> 16 & 0xFF) / 255.0f;
        final int[] array = b;
        final float n11 = (n4 >> 8 & 0xFF) / 255.0f;
        final float n12 = (n4 & 0xFF) / 255.0f;
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glBegin(6);
        int i = 0;
        while (true) {
            while (i < 50) {
                final float n13 = (float)(n3 * Math.sin(i * 0.12566370614359174));
                final float n14 = (float)(n3 * Math.cos(i * 0.12566370614359174));
                float n15 = n + n13;
                float n16 = n2 + n14;
                final float n21;
                final int n20;
                float n19;
                float n18;
                final int n17 = (int)(n18 = (n19 = (n20 = fcmpg(n15, n21 = n5))));
                if (array != null) {
                    GL11.glDisable(n20);
                    GL11.glPopMatrix();
                    return;
                }
                if (array == null) {
                    if (n17 < 0) {
                        n15 = n21;
                    }
                    final float n22;
                    n18 = (n22 = (n19 = fcmpl(n15, (float)n7)));
                }
                if (array == null) {
                    if (n17 > 0) {
                        n15 = n7;
                    }
                    n19 = (n18 = fcmpg(n16, (float)n6));
                }
                final float n23;
                final float n24;
                Label_0268: {
                    if (array == null) {
                        if (n18 < 0) {
                            n16 = n6;
                        }
                        n23 = n16;
                        n24 = n8;
                        if (array != null) {
                            break Label_0268;
                        }
                        n19 = fcmpl(n23, n24);
                    }
                    if (n19 > 0) {
                        n16 = n8;
                    }
                    GL11.glColor4f(n10, n11, n12, n9);
                }
                GL11.glVertex2f(n23, n24);
                ++i;
                if (array != null) {
                    break;
                }
            }
            GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
            GL11.glEnd();
            GL11.glEnable(3553);
            GL11.glDisable(3042);
            int n20 = 2848;
            continue;
        }
    }
    
    private static void drawLine(final float n, final float n2, final float n3, final float n4, final Color color) {
        final Tessellator func_178181_a;
        final WorldRenderer func_178180_c = (func_178181_a = Tessellator.func_178181_a()).func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_179120_a(770, 771, 1, 0);
        GL11.glEnable(2848);
        GL11.glLineWidth(1.0f);
        GlStateManager.func_179131_c(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
        func_178180_c.func_181668_a(1, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b((double)n, (double)n2, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n3, (double)n4, 0.0).func_181675_d();
        func_178181_a.func_78381_a();
        GL11.glDisable(2848);
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }
    
    private static String getShaderCode(final InputStreamReader inputStreamReader) {
        final int[] b = Class139.b();
        String value = Class69.lIIIIIIIIl[0];
        final int[] array = b;
        try {
            final BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                value = String.valueOf(new StringBuilder().append(String.valueOf(value)).append(line).append(Class69.lIIIIIIIIl[1]));
                if (array != null) {
                    return value.toString();
                }
                if (array != null) {
                    break;
                }
            }
            bufferedReader.close();
            return value.toString();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return value.toString();
    }
    
    public static void drawImage$664fe8f0(final ResourceLocation resourceLocation, final int n, final int n2) {
        drawImage$63accd50(resourceLocation, 0, 0, n, n2);
    }
    
    private static void drawImage(final ResourceLocation resourceLocation, final float n, final float n2, final float n3, final float n4) {
        drawImage$63accd50(resourceLocation, (int)n, (int)n2, (int)n3, (int)n4);
    }
    
    private static void drawImage$63accd50(final ResourceLocation resourceLocation, final int n, final int n2, final int n3, final int n4) {
        new ScaledResolution(Minecraft.func_71410_x());
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        OpenGlHelper.func_148821_a(770, 771, 1, 0);
        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
        Minecraft.func_71410_x().func_110434_K().func_110577_a(resourceLocation);
        Gui.func_146110_a(n, n2, 0.0f, 0.0f, n3, n4, (float)n3, (float)n4);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
    
    private static void drawOutlinedRect(final int n, final int n2, final int n3, final int n4, final int n5, final Color color, final Color color2) {
        drawRect(n, n2, n3, n4, color2.getRGB());
        drawRect(n, n2, n3, n2 + n5, color.getRGB());
        drawRect(n, n4 - n5, n3, n4, color.getRGB());
        drawRect(n, n2 + n5, n + n5, n4 - n5, color.getRGB());
        drawRect(n3 - n5, n2 + n5, n3, n4 - n5, color.getRGB());
    }
    
    public static void drawOutlinedRect$10266f0b(final float n, final float n2, final float n3, final float n4, final int n5, final int n6) {
        drawRect(n, n2, n3, n4, n6);
        drawRect(n, n2, n3, n2 + 1.0f, n5);
        drawRect(n, n4 - 1.0f, n3, n4, n5);
        drawRect(n, n2 + 1.0f, n + 1.0f, n4 - 1.0f, n5);
        drawRect(n3 - 1.0f, n2 + 1.0f, n3, n4 - 1.0f, n5);
    }
    
    private static void drawImage(final ResourceLocation resourceLocation, final int n, final int n2, final int n3, final int n4, final Color color) {
        new ScaledResolution(Minecraft.func_71410_x());
        GL11.glDisable(2929);
        GL11.glEnable(3042);
        GL11.glDepthMask(false);
        OpenGlHelper.func_148821_a(770, 771, 1, 0);
        GL11.glColor4f(color.getRed() / 255.0f, color.getBlue() / 255.0f, color.getRed() / 255.0f, 1.0f);
        Minecraft.func_71410_x().func_110434_K().func_110577_a(resourceLocation);
        Gui.func_146110_a(n, n2, 0.0f, 0.0f, n3, n4, (float)n3, (float)n4);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
    
    public static void doGlScissor(final int n, final int n2, final int n3, final int n4) {
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        final int[] b = Class139.b();
        int n5 = 1;
        final int[] array = b;
        int field_74335_Z;
        int n6 = field_74335_Z = func_71410_x.field_71474_y.field_74335_Z;
        int n7 = 0;
        int n8 = 0;
        Label_0118: {
            while (true) {
                Label_0038: {
                    if (array != null) {
                        break Label_0038;
                    }
                    if (n6 == 0) {
                        n6 = 1000;
                    }
                    field_74335_Z = n5;
                }
                if (field_74335_Z < n6) {
                    n7 = func_71410_x.field_71443_c / (n5 + 1);
                    n8 = 320;
                    if (array != null || array != null) {
                        break Label_0118;
                    }
                    if (lIllllIIllI(n7, n8)) {
                        final int n9 = func_71410_x.field_71440_d / (n5 + 1);
                        final int n10 = 240;
                        if (array != null) {
                            break Label_0118;
                        }
                        if (lIllllIIllI(n9, n10)) {
                            ++n5;
                            if (array == null) {
                                continue;
                            }
                        }
                    }
                }
                break;
            }
            final int n11 = func_71410_x.field_71440_d - (n2 + n4) * n5;
        }
        GL11.glScissor(n7, n8, n3 * n5, n4 * n5);
    }
    
    public static void drawRect(final float n, final float n2, final float n3, final float n4, final int n5) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        color(n5);
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
        GL11.glPopMatrix();
    }
    
    private static void color(final int n) {
        GL11.glColor4f((n >> 16 & 0xFF) / 255.0f, (n >> 8 & 0xFF) / 255.0f, (n & 0xFF) / 255.0f, (n >> 24 & 0xFF) / 255.0f);
    }
    
    private static int createShader(final String s, final int n) throws Exception {
        final int[] b = Class139.b();
        int n2 = 0;
        final int[] array = b;
        Label_0032: {
            try {
                int glCreateShaderObjectARB;
                final int n3 = n2 = (glCreateShaderObjectARB = ARBShaderObjects.glCreateShaderObjectARB(n));
                if (array == null) {
                    if (n3 != 0 && array == null) {
                        break Label_0032;
                    }
                    glCreateShaderObjectARB = 0;
                }
                return glCreateShaderObjectARB;
            }
            catch (Exception ex) {
                ARBShaderObjects.glDeleteObjectARB(n2);
                throw ex;
            }
        }
        ARBShaderObjects.glShaderSourceARB(n2, (CharSequence)s);
        ARBShaderObjects.glCompileShaderARB(n2);
        final int glGetObjectParameteriARB = ARBShaderObjects.glGetObjectParameteriARB(n2, 35713);
        if (array == null && glGetObjectParameteriARB == 0) {
            throw new RuntimeException("Error creating shader:");
        }
        return glGetObjectParameteriARB;
    }
    
    private static void drawCircle(final int n, final int n2, final float n3, final int n4) {
        final float n5 = (n4 >> 24 & 0xFF) / 255.0f;
        final int[] b = Class139.b();
        final float n6 = (n4 >> 16 & 0xFF) / 255.0f;
        final float n7 = (n4 >> 8 & 0xFF) / 255.0f;
        final float n8 = (n4 & 0xFF) / 255.0f;
        final int glIsEnabled = GL11.glIsEnabled(3042) ? 1 : 0;
        final int[] array = b;
        final int glIsEnabled2 = GL11.glIsEnabled(2848) ? 1 : 0;
        final boolean glIsEnabled3 = GL11.glIsEnabled(3553);
        int n11;
        int n10;
        final int n9 = n10 = (n11 = glIsEnabled);
        if (array == null) {
            if (n9 == 0) {
                GL11.glEnable(3042);
            }
            final int n12;
            n10 = (n12 = (n11 = glIsEnabled2));
        }
        if (array == null) {
            if (n9 == 0) {
                GL11.glEnable(2848);
            }
            n11 = (n10 = (glIsEnabled3 ? 1 : 0));
        }
        if (array == null) {
            if (n10 != 0) {
                GL11.glDisable(3553);
            }
            GL11.glBlendFunc(770, 771);
            GL11.glColor4f(n6, n7, n8, n5);
            GL11.glBegin(9);
            n11 = 0;
        }
        int i = n11;
        while (true) {
            while (i <= 360) {
                GL11.glVertex2d(n + Math.sin(i * 3.141526 / 180.0) * n3, n2 + Math.cos(i * 3.141526 / 180.0) * n3);
                ++i;
                if (array != null) {
                    int n15;
                    int n14;
                    final int n13 = n14 = (n15 = (glIsEnabled3 ? 1 : 0));
                    if (array == null) {
                        if (n13 != 0) {
                            GL11.glEnable(3553);
                        }
                        final int n16;
                        n14 = (n16 = (n15 = glIsEnabled2));
                    }
                    if (array == null) {
                        if (n13 == 0) {
                            GL11.glDisable(2848);
                        }
                        n15 = (n14 = glIsEnabled);
                    }
                    if (array == null) {
                        if (n14 != 0) {
                            return;
                        }
                        n15 = 3042;
                    }
                    GL11.glDisable(n15);
                    return;
                }
                if (array != null) {
                    break;
                }
            }
            GL11.glEnd();
            continue;
        }
    }
    
    private static void outlineOne() {
        GL11.glPushAttrib(1048575);
        GL11.glDisable(3008);
        GL11.glDisable(3553);
        GL11.glDisable(2896);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glLineWidth(4.0f);
        GL11.glEnable(2848);
        GL11.glEnable(2960);
        GL11.glClear(1024);
        GL11.glClearStencil(15);
        GL11.glStencilFunc(512, 1, 15);
        GL11.glStencilOp(7681, 7681, 7681);
        GL11.glPolygonMode(1032, 6913);
    }
    
    private static void outlineTwo() {
        GL11.glStencilFunc(512, 0, 15);
        GL11.glStencilOp(7681, 7681, 7681);
        GL11.glPolygonMode(1032, 6914);
    }
    
    private static void outlineThree() {
        GL11.glStencilFunc(514, 1, 15);
        GL11.glStencilOp(7680, 7680, 7680);
        GL11.glPolygonMode(1032, 6913);
    }
    
    private static void outlineFour() {
        GL11.glDepthMask(false);
        GL11.glDisable(2929);
        GL11.glEnable(10754);
        GL11.glPolygonOffset(1.0f, -2000000.0f);
        GL11.glColor4f(0.9529412f, 0.6117647f, 0.07058824f, 1.0f);
        OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, 240.0f, 240.0f);
    }
    
    private static void outlineFive() {
        GL11.glPolygonOffset(1.0f, 2000000.0f);
        GL11.glDisable(10754);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(2960);
        GL11.glDisable(2848);
        GL11.glHint(3154, 4352);
        GL11.glEnable(3042);
        GL11.glEnable(2896);
        GL11.glEnable(3553);
        GL11.glEnable(3008);
        GL11.glPopAttrib();
    }
    
    public static void drawOutlinedBoundingBox(final AxisAlignedBB axisAlignedBB) {
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
    
    public static void drawBoundingBox(final AxisAlignedBB axisAlignedBB) {
        final Tessellator func_178181_a;
        final WorldRenderer func_178180_c;
        (func_178180_c = (func_178181_a = Tessellator.func_178181_a()).func_178180_c()).func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        Class139.b();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f).func_181675_d();
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f).func_181675_d();
        func_178181_a.func_78381_a();
        if (Mod.b() == null) {
            Class139.b(new int[4]);
        }
    }
    
    private static void drawOutlinedBlockESP(final double n, final double n2, final double n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glLineWidth(n8);
        GL11.glColor4f(n4, n5, n6, n7);
        drawOutlinedBoundingBox(new AxisAlignedBB(n, n2, n3, n + 1.0, n2 + 1.0, n3 + 1.0));
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    private static void drawBlockESP(final double n, final double n2, final double n3, final float n4, final float n5, final float n6, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(2896);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4f(n4, n5, n6, n7);
        drawBoundingBox(new AxisAlignedBB(n, n2, n3, n + 1.0, n2 + 1.0, n3 + 1.0));
        GL11.glLineWidth(n12);
        GL11.glColor4f(n8, n9, n10, n11);
        drawOutlinedBoundingBox(new AxisAlignedBB(n, n2, n3, n + 1.0, n2 + 1.0, n3 + 1.0));
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2896);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static void drawSolidBlockESP$51f2a797(final double n, final double n2, final double n3, final float n4, final float n5, final float n6) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4f(n4, n5, n6, 0.2f);
        drawBoundingBox(new AxisAlignedBB(n, n2, n3, n + 1.0, n2 + 1.0, n3 + 1.0));
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    private static void drawOutlinedEntityESP(final double n, final double n2, final double n3, final double n4, final double n5, final float n6, final float n7, final float n8, final float n9) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4f(n6, n7, n8, n9);
        drawOutlinedBoundingBox(new AxisAlignedBB(n - n4, n2, n3 - n4, n + n4, n2 + n5, n3 + n4));
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    private static void drawSolidEntityESP(final double n, final double n2, final double n3, final double n4, final double n5, final float n6, final float n7, final float n8, final float n9) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4f(n6, n7, n8, n9);
        drawBoundingBox(new AxisAlignedBB(n - n4, n2, n3 - n4, n + n4, n2 + n5, n3 + n4));
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    public static void drawEntityESP(final double n, final double n2, final double n3, final double n4, final double n5, final float n6, final float n7, final float n8, final float n9, final float n10, final float n11, final float n12, final float n13, final float n14) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glDisable(3553);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDepthMask(false);
        GL11.glColor4f(n6, n7, n8, n9);
        drawBoundingBox(new AxisAlignedBB(n - n4, n2, n3 - n4, n + n4, n2 + n5, n3 + n4));
        GL11.glLineWidth(n14);
        GL11.glColor4f(n10, n11, n12, n13);
        drawOutlinedBoundingBox(new AxisAlignedBB(n - n4, n2, n3 - n4, n + n4, n2 + n5, n3 + n4));
        GL11.glDisable(2848);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDepthMask(true);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    private static void drawTracerLine(final double n, final double n2, final double n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        GL11.glPushMatrix();
        GL11.glEnable(3042);
        GL11.glEnable(2848);
        GL11.glDisable(2929);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(3042);
        GL11.glLineWidth(n8);
        GL11.glColor4f(n4, n5, n6, n7);
        GL11.glBegin(2);
        GL11.glVertex3d(0.0, 0.0 + Minecraft.func_71410_x().field_71439_g.func_70047_e(), 0.0);
        GL11.glVertex3d(n, n2, n3);
        GL11.glEnd();
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GL11.glEnable(2929);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glPopMatrix();
    }
    
    private static void drawFilledBox(final AxisAlignedBB axisAlignedBB) {
        final Tessellator func_178181_a;
        final WorldRenderer func_178180_c;
        (func_178180_c = (func_178181_a = Tessellator.func_178181_a()).func_178180_c()).func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c).func_181675_d();
        final int[] b = Class139.b();
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        final int[] array = b;
        func_178181_a.func_78381_a();
        func_178180_c.func_181668_a(7, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72340_a, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72339_c);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72337_e, axisAlignedBB.field_72334_f);
        func_178180_c.func_181662_b(axisAlignedBB.field_72336_d, axisAlignedBB.field_72338_b, axisAlignedBB.field_72334_f);
        func_178181_a.func_78381_a();
        if (array != null) {
            Mod.b(new Mod[4]);
        }
    }
    
    private static void checkSetupFBO() {
        final int[] b = Class139.b();
        final Framebuffer func_147110_a = Minecraft.func_71410_x().func_147110_a();
        final int[] array = b;
        final Framebuffer framebuffer = func_147110_a;
        if (array != null || framebuffer != null) {
            final int field_147624_h = framebuffer.field_147624_h;
            if (array == null) {
                if (!lIllllIIIll(field_147624_h, -1)) {
                    return;
                }
                EXTFramebufferObject.glDeleteRenderbuffersEXT(func_147110_a.field_147624_h);
                EXTFramebufferObject.glGenRenderbuffersEXT();
            }
            final int n = field_147624_h;
            EXTFramebufferObject.glBindRenderbufferEXT(36161, n);
            EXTFramebufferObject.glRenderbufferStorageEXT(36161, 34041, Minecraft.func_71410_x().field_71443_c, Minecraft.func_71410_x().field_71440_d);
            EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36128, 36161, n);
            EXTFramebufferObject.glFramebufferRenderbufferEXT(36160, 36096, 36161, n);
            func_147110_a.field_147624_h = -1;
        }
    }
    
    public static void drawRoundedRect(float n, float n2, float n3, float n4, final float n5, final int n6) {
        n += (float)(n5 / 2.0f + 0.5);
        n2 += (float)(n5 / 2.0f + 0.5);
        n3 -= (float)(n5 / 2.0f + 0.5);
        n4 -= (float)(n5 / 2.0f + 0.5);
        drawRect(n, n2, n3, n4, n6);
        arc$7b599d08(n3 - n5 / 2.0f, n2 + n5 / 2.0f, n5, n6);
        arc$7b599d08(n + n5 / 2.0f, n4 - n5 / 2.0f, n5, n6);
        arc$7b599d08(n + n5 / 2.0f, n2 + n5 / 2.0f, n5, n6);
        arc$7b599d08(n3 - n5 / 2.0f, n4 - n5 / 2.0f, n5, n6);
        drawRect(n - n5 / 2.0f - 0.5f, n2 + n5 / 2.0f, n3, n4 - n5 / 2.0f, n6);
        drawRect(n, n2 + n5 / 2.0f, n3 + n5 / 2.0f + 0.5f, n4 - n5 / 2.0f, n6);
        drawRect(n + n5 / 2.0f, n2 - n5 / 2.0f - 0.5f, n3 - n5 / 2.0f, n4 - n5 / 2.0f, n6);
        drawRect(n + n5 / 2.0f, n2, n3 - n5 / 2.0f, n4 + n5 / 2.0f + 0.5f, n6);
    }
    
    public static void circle(final float n, final float n2, final float n3, final int n4) {
        arc$7b599d08(n, n2, n3, n4);
    }
    
    private static void circle(float n, final float n2, final float n3, final Color color) {
        n = n;
        final int[] b = Class139.b();
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        final int[] array = b;
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.0f);
        Tessellator.func_178181_a().func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_179120_a(770, 771, 1, 0);
        GlStateManager.func_179131_c(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
        final float n4 = fcmpl((float)color.getAlpha(), 0.5f);
        if (array == null && n4 > 0) {
            GL11.glEnable(2848);
            GL11.glLineWidth(2.0f);
            GL11.glBegin(3);
            float n5 = 360.0f;
            while (true) {
                while (n5 >= 0.0f) {
                    GL11.glVertex2f(n + (float)Math.cos(n5 * 3.141592653589793 / 180.0) * (n3 * 1.001f), n2 + (float)Math.sin(n5 * 3.141592653589793 / 180.0) * (n3 * 1.001f));
                    n5 -= 4.0f;
                    if (array != null) {
                        GL11.glDisable(2848);
                        goto Label_0212;
                    }
                    if (array != null) {
                        break;
                    }
                }
                GL11.glEnd();
                continue;
            }
        }
        GL11.glBegin((int)n4);
        float n6 = 360.0f;
        while (n6 >= 0.0f) {
            GL11.glVertex2f(n + (float)Math.cos(n6 * 3.141592653589793 / 180.0) * n3, n2 + (float)Math.sin(n6 * 3.141592653589793 / 180.0) * n3);
            n6 -= 4.0f;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GL11.glEnd();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }
    
    private static void arc$7b599d08(final float n, final float n2, final float n3, final int n4) {
        arcEllipse$102511ee(n, n2, n3, n3, n4);
    }
    
    private static void arc$640388b5(float n, float n2, final float n3, final Color color) {
        final float n4 = n;
        n2 = n2;
        n = n4;
        final int[] b = Class139.b();
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        final int[] array = b;
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.0f);
        Tessellator.func_178181_a().func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_179120_a(770, 771, 1, 0);
        GlStateManager.func_179131_c(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
        final float n5 = fcmpl((float)color.getAlpha(), 0.5f);
        if (array == null && n5 > 0) {
            GL11.glEnable(2848);
            GL11.glLineWidth(2.0f);
            GL11.glBegin(3);
            float n6 = 360.0f;
            while (true) {
                while (n6 >= 0.0f) {
                    GL11.glVertex2f(n + (float)Math.cos(n6 * 3.141592653589793 / 180.0) * (n3 * 1.001f), n2 + (float)Math.sin(n6 * 3.141592653589793 / 180.0) * (n3 * 1.001f));
                    n6 -= 4.0f;
                    if (array != null) {
                        GL11.glDisable(2848);
                        goto Label_0214;
                    }
                    if (array != null) {
                        break;
                    }
                }
                GL11.glEnd();
                continue;
            }
        }
        GL11.glBegin((int)n5);
        float n7 = 360.0f;
        while (n7 >= 0.0f) {
            GL11.glVertex2f(n + (float)Math.cos(n7 * 3.141592653589793 / 180.0) * n3, n2 + (float)Math.sin(n7 * 3.141592653589793 / 180.0) * n3);
            n7 -= 4.0f;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GL11.glEnd();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }
    
    private static void arcEllipse$102511ee(final float n, final float n2, final float n3, final float n4, final int n5) {
        final int[] b = Class139.b();
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.0f);
        final int[] array = b;
        float n6 = fcmpl(0.0f, 360.0f);
        if (array == null) {
            n6 = (n5 >> 24 & 0xFF);
        }
        final float n7 = n6 / 255.0f;
        final float n8 = (n5 >> 16 & 0xFF) / 255.0f;
        final float n9 = (n5 >> 8 & 0xFF) / 255.0f;
        final float n10 = (n5 & 0xFF) / 255.0f;
        Tessellator.func_178181_a().func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_179120_a(770, 771, 1, 0);
        GlStateManager.func_179131_c(n8, n9, n10, n7);
        final float n11 = fcmpl(n7, 0.5f);
        if (array == null && n11 > 0) {
            GL11.glEnable(2848);
            GL11.glLineWidth(2.0f);
            GL11.glBegin(3);
            float n12 = 360.0f;
            while (true) {
                while (n12 >= 0.0f) {
                    GL11.glVertex2f(n + (float)Math.cos(n12 * 3.141592653589793 / 180.0) * (n3 * 1.001f), n2 + (float)Math.sin(n12 * 3.141592653589793 / 180.0) * (n4 * 1.001f));
                    n12 -= 4.0f;
                    if (array != null) {
                        GL11.glDisable(2848);
                        goto Label_0248;
                    }
                    if (array != null) {
                        break;
                    }
                }
                GL11.glEnd();
                continue;
            }
        }
        GL11.glBegin((int)n11);
        float n13 = 360.0f;
        while (n13 >= 0.0f) {
            GL11.glVertex2f(n + (float)Math.cos(n13 * 3.141592653589793 / 180.0) * n3, n2 + (float)Math.sin(n13 * 3.141592653589793 / 180.0) * n4);
            n13 -= 4.0f;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GL11.glEnd();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }
    
    private static void arcEllipse$6c41b101(final float n, final float n2, final float n3, final float n4, final Color color) {
        final int[] b = Class139.b();
        GlStateManager.func_179124_c(0.0f, 0.0f, 0.0f);
        final int[] array = b;
        GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.0f);
        Tessellator.func_178181_a().func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_179120_a(770, 771, 1, 0);
        GlStateManager.func_179131_c(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
        final float n5 = fcmpl((float)color.getAlpha(), 0.5f);
        if (array == null && n5 > 0) {
            GL11.glEnable(2848);
            GL11.glLineWidth(2.0f);
            GL11.glBegin(3);
            float n6 = 360.0f;
            while (true) {
                while (n6 >= 0.0f) {
                    GL11.glVertex2f(n + (float)Math.cos(n6 * 3.141592653589793 / 180.0) * (n3 * 1.001f), n2 + (float)Math.sin(n6 * 3.141592653589793 / 180.0) * (n4 * 1.001f));
                    n6 -= 4.0f;
                    if (array != null) {
                        GL11.glDisable(2848);
                        goto Label_0217;
                    }
                    if (array != null) {
                        break;
                    }
                }
                GL11.glEnd();
                continue;
            }
        }
        GL11.glBegin((int)n5);
        float n7 = 360.0f;
        while (n7 >= 0.0f) {
            GL11.glVertex2f(n + (float)Math.cos(n7 * 3.141592653589793 / 180.0) * n3, n2 + (float)Math.sin(n7 * 3.141592653589793 / 180.0) * n4);
            n7 -= 4.0f;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        GL11.glEnd();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }
    
    private static void startDrawing() {
        GL11.glEnable(3042);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glDisable(3553);
        GL11.glDisable(2929);
        final EntityRenderer field_71460_t = Minecraft.func_71410_x().field_71460_t;
        final float field_74281_c = Class94.getTimer().field_74281_c;
    }
    
    private static void stopDrawing() {
        GL11.glDisable(3042);
        GL11.glEnable(3553);
        GL11.glDisable(2848);
        GL11.glDisable(3042);
        GL11.glEnable(2929);
    }
    
    private static void drawBorderedRect(final float n, final float n2, final float n3, final float n4, final float n5, final int n6, final int n7) {
        drawRect(n, n2, n3, n4, n7);
        final float n8 = (n6 >> 24 & 0xFF) / 255.0f;
        final float n9 = (n6 >> 16 & 0xFF) / 255.0f;
        final float n10 = (n6 >> 8 & 0xFF) / 255.0f;
        final float n11 = (n6 & 0xFF) / 255.0f;
        GL11.glEnable(3042);
        GL11.glDisable(3553);
        GL11.glBlendFunc(770, 771);
        GL11.glEnable(2848);
        GL11.glPushMatrix();
        GL11.glColor4f(n9, n10, n11, n8);
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
    
    private static Color blend(final Color color, final Color color2, final double n) {
        final float n2 = (float)n;
        final float n3 = 1.0f - n2;
        final float[] array = new float[3];
        final float[] array2 = new float[3];
        color.getColorComponents(array);
        color2.getColorComponents(array2);
        return new Color(array[0] * n2 + array2[0] * n3, array[1] * n2 + array2[1] * n3, array[2] * n2 + array2[2] * n3);
    }
    
    static {
        lIlllIIIIlI();
        Class169.a(728099935875464919L, 3718518746766912012L, MethodHandles.lookup().lookupClass()).a(256846955260473L);
        final Cipher instance = Cipher.getInstance(Class69.lIIIIIIIIl[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class69.lIIIIIIIIl[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(91263587149453L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class69.lIIIIIIIIl[4].getBytes(Class69.lIIIIIIIIl[5]))).intern();
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
    
    private static void lIlllIIIIlI() {
        (lIIIIIIIIl = new String[6])[0] = "";
        Class69.lIIIIIIIIl[1] = "\n";
        Class69.lIIIIIIIIl[2] = "DES/CBC/PKCS5Padding";
        Class69.lIIIIIIIIl[3] = "DES";
        Class69.lIIIIIIIIl[4] = "Í~[;\u0003Æî+¾:TÄ<k\u001b\u008c\u009bAXÄÌ±ú\u000b";
        Class69.lIIIIIIIIl[5] = "ISO-8859-1";
    }
    
    private static String lIlllIIIIIl(String s, final String s2) {
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
    
    private static String lIlllIIIIII(final String s, final String s2) {
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
    
    private static String lIllIllllll(final String s, final String s2) {
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
    
    private static boolean lIllllIIllI(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIllllIIlll$255f299(final int n) {
        return n <= 360;
    }
    
    private static boolean lIllllIIIll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIlllllIIlI(final int n) {
        return n >= 0;
    }
    
    private static boolean lIlllIlllll(final int n) {
        return n < 0;
    }
    
    private static boolean lIlllIlIlll(final int n) {
        return n <= 0;
    }
    
    private static boolean lIllllIIIII(final int n) {
        return n > 0;
    }
    
    private static int lIlllIlIlII(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIlllIllllI(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlllIlllIl(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIllllIIIlI(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIllllIIlIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIllllIIlII(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIlllllIIIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIlllllIIll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
}
