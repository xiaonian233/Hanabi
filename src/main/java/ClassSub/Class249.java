package ClassSub;

import org.jetbrains.annotations.*;
import java.util.*;
import java.lang.invoke.*;

public final class Class249
{
    String panelName;
    int x;
    int y;
    int width;
    private int height;
    int dragX;
    int dragY;
    boolean drag;
    @NotNull
    List<Class158> buttons;
    private static final long a;
    
    public Class249(final String panelName, final int x) {
        super();
        this.buttons = new ArrayList<Class158>();
        this.panelName = panelName;
        this.x = x;
        this.y = 50;
        this.width = 100;
    }
    
    private String getPanelName() {
        return this.panelName;
    }
    
    private int getX() {
        return this.x;
    }
    
    private void setX(final int x) {
        this.x = x;
    }
    
    private int getY() {
        return this.y;
    }
    
    private void setY(final int y) {
        this.y = y;
    }
    
    private int getWidth() {
        return this.width;
    }
    
    private boolean isDrag() {
        return this.drag;
    }
    
    private void setDrag(final boolean drag) {
        this.drag = drag;
    }
    
    private int getDragX() {
        return this.dragX;
    }
    
    private void setDragX(final int dragX) {
        this.dragX = dragX;
    }
    
    private int getDragY() {
        return this.dragY;
    }
    
    private void setDragY(final int dragY) {
        this.dragY = dragY;
    }
    
    private boolean isHoverHead(final int n, final int n2) {
        final int[] b = Class139.b();
        int n3 = n;
        int n4 = n;
        int n5 = n;
        int x;
        int y;
        final int n6 = y = (x = this.x);
        if (b == null) {
            if (!lIllllIlIlIl(n, n6)) {
                return false;
            }
            n3 = n;
            n4 = n;
            n5 = n;
            final int n7;
            y = (n7 = (x = this.x + this.width));
        }
        if (b == null) {
            if (!lIllllIlIllI(n5, n6)) {
                return false;
            }
            n3 = n2;
            n4 = n2;
            x = (y = this.y);
        }
        if (b == null) {
            if (!lIllllIlIlIl(n4, y)) {
                return false;
            }
            final boolean b2 = n2 != 0;
            n3 = n2;
            if (b != null) {
                return b2;
            }
            x = this.y + 20;
        }
        if (!lIllllIlIllI(n3, x)) {
            return false;
        }
        return true;
    }
    
    private void addButton(final Class158 class158) {
        this.buttons.add(class158);
    }
    
    @NotNull
    private List<Class158> getButtons() {
        return this.buttons;
    }
    
    static {
        Class169.a(5237611258338206274L, 8142679460635380263L, MethodHandles.lookup().lookupClass()).a(227041950030043L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    static boolean lIllllIlIlIl(final int n, final int n2) {
        return n >= n2;
    }
    
    static boolean lIllllIlIllI(final int n, final int n2) {
        return n <= n2;
    }
}
