package ClassSub;

import java.awt.*;
import org.jetbrains.annotations.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import java.util.*;
import java.lang.invoke.*;

public final class Class145<T>
{
    private static int OFFSET;
    @NotNull
    static Color BACKGROUND;
    @NotNull
    static Color BORDER;
    @NotNull
    static Color SELECTED;
    static Color FOREGROUND;
    @NotNull
    private List<Class242<T>> tabs;
    private int selectedTab;
    private int selectedSubTab;
    private static final long a;
    
    public Class145() {
        super();
        this.tabs = new ArrayList<Class242<T>>();
        this.selectedTab = 0;
        this.selectedSubTab = -1;
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
    
    private void addTab(final Class242<T> class242) {
        this.tabs.add(class242);
    }
    
    private void render(final int n, final int n2) {
        final int[] b = Class139.b();
        GL11.glTranslated((double)n, (double)n2, 0.0);
        final FontRenderer field_71466_p = Minecraft.func_71410_x().field_71466_p;
        final int[] array = b;
        final int n3 = (field_71466_p.field_78288_b + 3) * this.tabs.size();
        int n4 = 0;
        while (true) {
            for (final Class242<T> class242 : this.tabs) {
                final int func_78256_a;
                final int n5 = func_78256_a = field_71466_p.func_78256_a(class242.text);
                Label_0119: {
                    if (array == null) {
                        final int n6 = n4;
                        if (array != null) {
                            drawRect(func_78256_a, n6, 0, n4, n3, Class145.BACKGROUND.getRGB());
                            int n7 = 2;
                            int n8 = 0;
                            while (true) {
                                for (final Class242<T> class243 : this.tabs) {
                                    final int selectedTab;
                                    final int n9 = selectedTab = this.selectedTab;
                                    final int n11;
                                    final int n10 = n11 = n8;
                                    if (array != null) {
                                        drawRect(selectedTab, n11, 0, n4, n3, Class145.BORDER.getRGB());
                                        GL11.glTranslated((double)(-n), (double)(-n2), 0.0);
                                        return;
                                    }
                                    Label_0616: {
                                        if (array == null) {
                                            Label_0585: {
                                                if (n9 == n10) {
                                                    drawRect(7, 0, n7 - 2, n4, n7 + field_71466_p.field_78288_b + 3 - 2, Class145.SELECTED.getRGB());
                                                    final int selectedSubTab = this.selectedSubTab;
                                                    final int n12 = -1;
                                                    if (array != null) {
                                                        break Label_0616;
                                                    }
                                                    if (lIIIlIIlIIlIl(selectedSubTab, n12)) {
                                                        final Class242<T> class244 = class243;
                                                        final int n13 = n4;
                                                        final int n14 = n7 - 2;
                                                        final int selectedSubTab2 = this.selectedSubTab;
                                                        final int n15 = n14;
                                                        final int n16 = n13;
                                                        final Class242<T> class245 = class244;
                                                        GL11.glTranslated((double)n16, (double)n15, 0.0);
                                                        final FontRenderer field_71466_p2 = Minecraft.func_71410_x().field_71466_p;
                                                        final int[] b2 = Class139.b();
                                                        final int n17 = (field_71466_p2.field_78288_b + 3) * class245.subTabs.size();
                                                        int n18 = 0;
                                                        final Iterator<Class306<T>> iterator3 = class245.subTabs.iterator();
                                                        final int[] array2 = b2;
                                                        while (true) {
                                                            while (iterator3.hasNext()) {
                                                                final Class306<T> class246 = iterator3.next();
                                                                final int func_78256_a2;
                                                                final int n19 = func_78256_a2 = field_71466_p2.func_78256_a(class246.text);
                                                                Label_0395: {
                                                                    if (array2 == null) {
                                                                        final int n20 = n18;
                                                                        if (array2 != null) {
                                                                            drawRect(func_78256_a2, n20, 0, n18, n17, Class145.BORDER.getRGB());
                                                                            int n21 = 2;
                                                                            int n22 = 0;
                                                                            while (true) {
                                                                                for (final Class306<T> class247 : class245.subTabs) {
                                                                                    final int n24;
                                                                                    final int n23 = n24 = selectedSubTab2;
                                                                                    if (array2 != null) {
                                                                                        GL11.glTranslated((double)n24, (double)(-n15), 0.0);
                                                                                        break Label_0585;
                                                                                    }
                                                                                    final int n25 = n22;
                                                                                    if (array2 == null) {
                                                                                        if (n23 == n25) {
                                                                                            drawRect(7, 0, n21 - 2, n18, n21 + field_71466_p2.field_78288_b + 3 - 1, Class145.SELECTED.getRGB());
                                                                                        }
                                                                                        field_71466_p2.func_78276_b(class247.text, 2, n21, Class145.FOREGROUND.getRGB());
                                                                                        final int n26 = field_71466_p2.field_78288_b + 3;
                                                                                    }
                                                                                    n21 = n23 + n25;
                                                                                    ++n22;
                                                                                    if (array2 != null) {
                                                                                        break;
                                                                                    }
                                                                                }
                                                                                int n24 = -n16;
                                                                                continue;
                                                                            }
                                                                        }
                                                                        if (n19 <= n20) {
                                                                            break Label_0395;
                                                                        }
                                                                        field_71466_p2.func_78256_a(class246.text);
                                                                    }
                                                                    n18 = n19;
                                                                }
                                                                if (array2 != null) {
                                                                    break;
                                                                }
                                                            }
                                                            n18 += 4;
                                                            drawRect(7, 0, 0, n18, n17, Class145.BACKGROUND.getRGB());
                                                            GL11.glLineWidth(1.0f);
                                                            int func_78256_a2 = 2;
                                                            continue;
                                                        }
                                                    }
                                                }
                                            }
                                            field_71466_p.func_78276_b(class243.text, 2, n7, Class145.FOREGROUND.getRGB());
                                            final int n27 = field_71466_p.field_78288_b + 3;
                                        }
                                    }
                                    n7 = n9 + n10;
                                    ++n8;
                                    if (array != null) {
                                        break;
                                    }
                                }
                                GL11.glLineWidth(1.0f);
                                int selectedTab = 2;
                                int n11 = 0;
                                continue;
                            }
                        }
                        if (n5 <= n6) {
                            break Label_0119;
                        }
                        field_71466_p.func_78256_a(class242.text);
                    }
                    n4 = n5;
                }
                if (array != null) {
                    break;
                }
            }
            n4 += 4;
            int func_78256_a = 7;
            continue;
        }
    }
    
    private void handleKey(final int n) {
        final int[] b = Class139.b();
        int selectedSubTab = n;
        int n2 = n;
        int n3 = n;
        int n4 = n;
        int n5 = n;
        int n10;
        int n9;
        int n8;
        int n7;
        final int n6 = n7 = (n8 = (n9 = (n10 = 208)));
        if (b == null) {
            if (n == n6) {
                final int selectedSubTab2 = this.selectedSubTab;
                final int n11 = -1;
                Class145 class146 = null;
                Label_0117: {
                    if (b == null) {
                        if (selectedSubTab2 == n11) {
                            ++this.selectedTab;
                            Class145 class145 = this;
                            if (b == null) {
                                if (!lIIIlIIlIIllI(this.selectedTab, this.tabs.size())) {
                                    return;
                                }
                                class145 = this;
                            }
                            class145.selectedTab = 0;
                            if (b == null) {
                                return;
                            }
                        }
                        ++this.selectedSubTab;
                        class146 = this;
                        if (b != null) {
                            break Label_0117;
                        }
                        final int selectedSubTab3 = this.selectedSubTab;
                        this.tabs.get(this.selectedTab).subTabs.size();
                    }
                    if (!lIIIlIIlIIllI(selectedSubTab2, n11)) {
                        return;
                    }
                    class146 = this;
                }
                class146.selectedSubTab = 0;
                if (b == null) {
                    return;
                }
            }
            selectedSubTab = n;
            n2 = n;
            n3 = n;
            n4 = n;
            n5 = n;
            final int n12;
            n7 = (n12 = (n8 = (n9 = (n10 = 200))));
        }
        if (b == null) {
            if (n5 == n6) {
                final int selectedSubTab4 = this.selectedSubTab;
                Class145 class148 = null;
                Label_0225: {
                    if (b == null) {
                        if (selectedSubTab4 == -1) {
                            --this.selectedTab;
                            Class145 class147 = this;
                            if (b == null) {
                                if (this.selectedTab >= 0) {
                                    return;
                                }
                                class147 = this;
                            }
                            class147.selectedTab = this.tabs.size() - 1;
                            if (b == null) {
                                return;
                            }
                        }
                        --this.selectedSubTab;
                        class148 = this;
                        if (b != null) {
                            break Label_0225;
                        }
                        final int selectedSubTab5 = this.selectedSubTab;
                    }
                    if (selectedSubTab4 >= 0) {
                        return;
                    }
                    class148 = this;
                }
                class148.selectedSubTab = this.tabs.get(this.selectedTab).subTabs.size() - 1;
                if (b == null) {
                    return;
                }
            }
            selectedSubTab = n;
            n2 = n;
            n3 = n;
            n4 = n;
            n8 = (n7 = (n9 = (n10 = 203)));
        }
        if (b == null) {
            if (n4 == n7) {
                this.selectedSubTab = -1;
                if (b == null) {
                    return;
                }
            }
            n2 = (n3 = (selectedSubTab = this.selectedSubTab));
            n9 = (n8 = (n10 = -1));
        }
        Label_0324: {
            if (b == null) {
                Label_0321: {
                    if (n3 == n8) {
                        selectedSubTab = n;
                        n2 = n;
                        int n13 = n;
                        final int n14 = n9 = (n10 = 28);
                        Label_0312: {
                            if (b == null) {
                                if (!lIIIlIIlIIlIl(n, n14)) {
                                    break Label_0312;
                                }
                                selectedSubTab = n;
                                n2 = n;
                                n13 = n;
                                final int n15;
                                n9 = (n15 = (n10 = 205));
                            }
                            if (b != null) {
                                break Label_0324;
                            }
                            if (n13 != n14) {
                                break Label_0321;
                            }
                        }
                        this.selectedSubTab = 0;
                        if (b == null) {
                            return;
                        }
                    }
                }
                selectedSubTab = n;
                n2 = n;
                n10 = (n9 = 28);
            }
        }
        Label_0340: {
            if (b == null) {
                if (!lIIIlIIlIIlIl(n2, n9)) {
                    break Label_0340;
                }
                selectedSubTab = n;
                n10 = 205;
            }
            if (selectedSubTab != n10) {
                return;
            }
        }
        final Class306<T> class149 = this.tabs.get(this.selectedTab).subTabs.get(this.selectedSubTab);
        final int[] b2 = Class139.b();
        final Class127<T> listener = class149.listener;
        if (b2 == null) {
            if (listener == null) {
                return;
            }
            final Class127<T> listener2 = class149.listener;
        }
        listener.onClick(class149);
    }
    
    static {
        Class169.a(6385996809313882717L, 4132562687740837131L, MethodHandles.lookup().lookupClass()).a(17212961299652L);
        Class145.BACKGROUND = new Color(0, 0, 0, 175);
        Class145.BORDER = new Color(0, 0, 0, 255);
        Class145.SELECTED = new Color(38, 164, 78, 200);
        Class145.FOREGROUND = Color.white;
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIIIlIIlIIllI(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIIlIIlIIIlI(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIIlIIlIIlll(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIlIIlIIlIl(final int n, final int n2) {
        return n != n2;
    }
}
