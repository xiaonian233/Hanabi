package ClassSub;

import java.awt.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.lang.invoke.*;
import java.util.*;

public final class Class300
{
    private static Map<Integer, Boolean> glCapMap;
    private static final long a;
    
    public Class300() {
        super();
    }
    
    public static void setColor(final Color color) {
        GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
    }
    
    public static void setGLCap(final int n, final boolean b) {
        final int[] b2 = Class139.b();
        Class300.glCapMap.put(n, GL11.glGetBoolean(n));
        final int[] array = b2;
        int n2 = b ? 1 : 0;
        if (array == null) {
            if (b) {
                GL11.glEnable(n);
                if (array == null) {
                    return;
                }
            }
            n2 = n;
        }
        GL11.glDisable(n2);
    }
    
    private static void revertGLCap(final int n) {
        final int[] b = Class139.b();
        final Boolean b2 = Class300.glCapMap.get(n);
        final int[] array = b;
        final Boolean b3 = b2;
        if (array != null || b3 != null) {
            final int booleanValue = ((boolean)b3) ? 1 : 0;
            if (array == null && booleanValue != 0) {
                GL11.glEnable(n);
                if (array != null) {
                    goto Label_0047;
                }
            }
            else {
                GL11.glDisable(booleanValue);
            }
        }
    }
    
    private static void glEnable(final int n) {
        setGLCap(n, true);
    }
    
    private static void glDisable(final int n) {
        setGLCap(n, false);
    }
    
    public static void revertAllCaps() {
        final int[] b = Class139.b();
        final Iterator<Integer> iterator = Class300.glCapMap.keySet().iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final int intValue = iterator.next();
            final int[] b2 = Class139.b();
            final Boolean b3 = Class300.glCapMap.get(intValue);
            final int[] array2 = b2;
            final Boolean b4 = b3;
            if (array2 != null || b4 != null) {
                final int booleanValue = ((boolean)b4) ? 1 : 0;
                if (array2 == null && booleanValue != 0) {
                    GL11.glEnable(intValue);
                    if (array2 != null) {
                        goto Label_0090;
                    }
                }
                else {
                    GL11.glDisable(booleanValue);
                }
            }
            if (array != null) {
                break;
            }
        }
    }
    
    private static void setColor(int n) {
        final int n2 = n & 0xFF;
        final int n3 = n >> 8 & 0xFF;
        final int n4 = n >> 16 & 0xFF;
        n = (n >> 24 & 0xFF);
        GL11.glColor4b((byte)n2, (byte)n3, (byte)n4, (byte)n);
    }
    
    public static int toRGBA(final Color color) {
        return color.getRed() | color.getGreen() << 8 | color.getBlue() << 16 | color.getAlpha() << 24;
    }
    
    public static void drawRect(final int n, int n2, int n3, int n4, int n5, final int n6) {
        final int[] b = Class139.b();
        int n8;
        final int n7 = n8 = n2;
        int n10;
        final int n9 = n10 = n4;
        if (b == null) {
            if (n7 < n9) {
                final int n11 = n2;
                n2 = n4;
                n4 = n11;
            }
            final int n12;
            n8 = (n12 = n3);
            final int n13;
            n10 = (n13 = n5);
        }
        if (b == null) {
            if (n7 < n9) {
                final int n14 = n3;
                n3 = n5;
                n5 = n14;
            }
            n8 = n6 >> 24;
            n10 = 255;
        }
        final float n15 = (n8 & n10) / 255.0f;
        final float n16 = (n6 >> 16 & 0xFF) / 255.0f;
        final float n17 = (n6 >> 8 & 0xFF) / 255.0f;
        final float n18 = (n6 & 0xFF) / 255.0f;
        final Tessellator func_178181_a;
        final WorldRenderer func_178180_c = (func_178181_a = Tessellator.func_178181_a()).func_178180_c();
        GlStateManager.func_179147_l();
        GlStateManager.func_179090_x();
        GlStateManager.func_179120_a(770, 771, 1, 0);
        GlStateManager.func_179131_c(n16, n17, n18, n15);
        func_178180_c.func_181668_a(n, DefaultVertexFormats.field_181705_e);
        func_178180_c.func_181662_b((double)n2, (double)n5, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n4, (double)n5, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n4, (double)n3, 0.0).func_181675_d();
        func_178180_c.func_181662_b((double)n2, (double)n3, 0.0).func_181675_d();
        func_178181_a.func_78381_a();
        GlStateManager.func_179098_w();
        GlStateManager.func_179084_k();
    }
    
    static {
        Class169.a(226989032112849929L, 5176383953070152701L, MethodHandles.lookup().lookupClass()).a(94637738816624L);
        Class300.glCapMap = new HashMap<Integer, Boolean>();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
