package ClassSub;

import cn.Hanabi.modules.*;
import org.jetbrains.annotations.*;
import cn.Hanabi.value.*;
import net.minecraft.client.gui.*;
import java.lang.invoke.*;
import java.util.*;
import java.nio.charset.*;

public final class Class158
{
    private Class249 panel;
    Mod module;
    boolean isExtended;
    @NotNull
    List<Class230<?>> settings;
    private static final long a;
    private static final String[] llIllIlI;
    
    public Class158(final Mod module) {
        final int[] b = Class139.b();
        super();
        this.isExtended = false;
        this.settings = new ArrayList<Class230<?>>();
        final int[] array = b;
        this.module = module;
        final ArrayList<Object> list = new ArrayList<Object>();
        Iterator<Value> iterator = Value.list.iterator();
        while (true) {
            while (iterator.hasNext()) {
                final Value value;
                final boolean contains = (value = iterator.next()).name.split(Class158.llIllIlI[0])[0].contains(module.getName());
                if (array != null) {
                    while (true) {
                        if (contains) {
                            final Value value2;
                            boolean b3;
                            final boolean b2 = b3 = (value2 = iterator.next()).isValueBoolean;
                            if (array == null) {
                                if (b2) {
                                    this.settings.add(new Class269(value2));
                                }
                                final boolean isValueMode;
                                b3 = (isValueMode = value2.isValueMode);
                            }
                            if (array == null) {
                                if (b2) {
                                    this.settings.add(new Class27(value2));
                                }
                                b3 = value2.isValueDouble;
                            }
                            Label_0271: {
                                if (array == null) {
                                    if (!b3) {
                                        final boolean isValueFloat = value2.isValueFloat;
                                        if (array != null) {
                                            break Label_0271;
                                        }
                                        if (!isValueFloat) {
                                            final boolean isValueInteger = value2.isValueInteger;
                                            if (array != null) {
                                                break Label_0271;
                                            }
                                            if (!isValueInteger) {
                                                final boolean isValueLong = value2.isValueLong;
                                                if (array != null) {
                                                    break Label_0271;
                                                }
                                                if (!isValueLong) {
                                                    break Label_0271;
                                                }
                                            }
                                        }
                                    }
                                    this.settings.add(new Class228(value2));
                                }
                            }
                            if (array == null) {
                                iterator.hasNext();
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                if (array == null) {
                    if (contains) {
                        list.add(value);
                    }
                }
                if (array != null) {
                    break;
                }
            }
            iterator = list.iterator();
            continue;
        }
    }
    
    private void click() {
        final int[] b = Class139.b();
        final Mod module = this.module;
        final boolean state = this.module.state;
        if (b == null && state) {}
        module.setState(state, true);
    }
    
    private Mod getModule() {
        return this.module;
    }
    
    public static boolean isHover$6046c8d9(final int n, final int n2, final int n3, final int n4, final int n5) {
        final int[] b = Class139.b();
        int n6 = n4;
        int n7 = n4;
        int n8 = n4;
        int n9 = n;
        int n10 = n;
        int n11 = n;
        if (b == null) {
            if (!lIIllllllI(n4, n)) {
                return false;
            }
            n6 = n4;
            n7 = n4;
            n8 = n4;
            n10 = (n11 = (n9 = n + n3));
        }
        if (b == null) {
            if (!lIIlllllll(n8, n11)) {
                return false;
            }
            n6 = n5;
            n7 = n5;
            n9 = n2;
            n10 = n2;
        }
        if (b == null) {
            if (!lIIllllllI(n7, n10)) {
                return false;
            }
            final int n12 = n5;
            n6 = n5;
            if (b != null) {
                return n12 != 0;
            }
            n9 = n2 + 20;
        }
        if (!lIIlllllll(n6, n9)) {
            return false;
        }
        final int n12 = true ? 1 : 0;
        return n12 != 0;
    }
    
    private int renderExtended(final int x, final int n) {
        final int[] b = Class139.b();
        int y = n + 1;
        int max = 0;
        final int[] array = b;
        int isExtended;
        final boolean b2 = (isExtended = (this.isExtended ? 1 : 0)) != 0;
        if (array == null) {
            Label_0164: {
                if (b2) {
                    final Iterator<Class230<?>> iterator = this.settings.iterator();
                    while (true) {
                        while (iterator.hasNext()) {
                            final Class230<?> class230;
                            (class230 = iterator.next()).update();
                            class230.setX(x);
                            class230.setY(y);
                            y += class230.getHeight() + 2;
                            max = Math.max(class230.getWidth(), max);
                            if (array != null) {
                                final Iterator<Class230<?>> iterator2 = this.settings.iterator();
                                while (iterator2.hasNext()) {
                                    iterator2.next().draw();
                                    if (array != null) {
                                        break;
                                    }
                                }
                                break Label_0164;
                            }
                            if (array != null) {
                                break;
                            }
                        }
                        ++y;
                        Gui.func_73734_a(x, n, max + x, y, Class144.PANEL_MAIN_COLOR.getRGB());
                        continue;
                    }
                }
            }
            isExtended = y;
        }
        return isExtended;
    }
    
    private boolean isExtended() {
        return this.isExtended;
    }
    
    private void setExtended(final boolean isExtended) {
        this.isExtended = isExtended;
    }
    
    public final boolean onMouseClick(final int n, final int n2, final int n3) {
        boolean b = false;
        final int[] b2 = Class139.b();
        final Iterator<Class230<?>> iterator = this.settings.iterator();
        final int[] array = b2;
        while (iterator.hasNext()) {
            final Class230<?> class230 = iterator.next();
            final boolean isExtended;
            boolean b4;
            final boolean b3 = b4 = (isExtended = this.isExtended);
            if (array != null) {
                return isExtended;
            }
            Label_0077: {
                if (array == null) {
                    if (!b3) {
                        break Label_0077;
                    }
                    final boolean onMouseClick;
                    b4 = (onMouseClick = class230.onMouseClick(n, n2, n3));
                }
                if (array == null) {
                    if (!b3) {
                        break Label_0077;
                    }
                    b4 = true;
                }
                b = b4;
            }
            if (array != null) {
                break;
            }
        }
        return b;
    }
    
    static {
        lIIllllIII();
        Class169.a(1935616898220967968L, 8486855744723686623L, MethodHandles.lookup().lookupClass()).a(33617014802411L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static void lIIllllIII() {
        (llIllIlI = new String[] { null })[0] = "_";
    }
    
    private static String lIIlllIlll(String s, final String s2) {
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
    
    private static boolean lIIllllllI(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIlllllll(final int n, final int n2) {
        return n <= n2;
    }
}
