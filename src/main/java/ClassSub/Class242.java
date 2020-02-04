package ClassSub;

import org.jetbrains.annotations.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import java.util.*;
import java.lang.invoke.*;

public final class Class242<T>
{
    @NotNull
    List<Class306<T>> subTabs;
    String text;
    private static final long a;
    
    public Class242(final String text) {
        super();
        this.subTabs = new ArrayList<Class306<T>>();
        this.text = text;
    }
    
    private void addSubTab(final Class306<T> class306) {
        this.subTabs.add(class306);
    }
    
    @NotNull
    private List<Class306<T>> getSubTabs() {
        return this.subTabs;
    }
    
    private void renderSubTabs(final int n, final int n2, final int n3) {
        GL11.glTranslated((double)n, (double)n2, 0.0);
        final FontRenderer field_71466_p = Minecraft.func_71410_x().field_71466_p;
        final int[] b = Class139.b();
        final int n4 = (field_71466_p.field_78288_b + 3) * this.subTabs.size();
        int n5 = 0;
        final Iterator<Class306<T>> iterator = this.subTabs.iterator();
        final int[] array = b;
        while (true) {
            while (iterator.hasNext()) {
                final Class306<T> class306 = iterator.next();
                final int func_78256_a;
                final int n6 = func_78256_a = field_71466_p.func_78256_a(class306.text);
                Label_0122: {
                    if (array == null) {
                        final int n7 = n5;
                        if (array != null) {
                            Class145.drawRect(func_78256_a, n7, 0, n5, n4, Class145.BORDER.getRGB());
                            int n8 = 2;
                            int n9 = 0;
                            while (true) {
                                for (final Class306<T> class307 : this.subTabs) {
                                    final int n10 = n3;
                                    int n11 = n3;
                                    if (array != null) {
                                        GL11.glTranslated((double)n10, (double)(-n2), 0.0);
                                        return;
                                    }
                                    final int n12 = n9;
                                    if (array == null) {
                                        if (n3 == n12) {
                                            Class145.drawRect(7, 0, n8 - 2, n5, n8 + field_71466_p.field_78288_b + 3 - 1, Class145.SELECTED.getRGB());
                                        }
                                        field_71466_p.func_78276_b(class307.text, 2, n8, Class145.FOREGROUND.getRGB());
                                        n11 = n8;
                                        final int n13 = field_71466_p.field_78288_b + 3;
                                    }
                                    n8 = n11 + n12;
                                    ++n9;
                                    if (array != null) {
                                        break;
                                    }
                                }
                                final int n10 = -n;
                                continue;
                            }
                        }
                        if (n6 <= n7) {
                            break Label_0122;
                        }
                        field_71466_p.func_78256_a(class306.text);
                    }
                    n5 = n6;
                }
                if (array != null) {
                    break;
                }
            }
            n5 += 4;
            Class145.drawRect(7, 0, 0, n5, n4, Class145.BACKGROUND.getRGB());
            GL11.glLineWidth(1.0f);
            int func_78256_a = 2;
            continue;
        }
    }
    
    private String getText() {
        return this.text;
    }
    
    private void setText(final String text) {
        this.text = text;
    }
    
    static {
        Class169.a(724451533684554618L, 3941137183580925423L, MethodHandles.lookup().lookupClass()).a(126165607489040L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lllIIlIlIIll(final int n, final int n2) {
        return n > n2;
    }
}
