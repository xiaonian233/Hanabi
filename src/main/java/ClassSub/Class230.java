package ClassSub;

import net.minecraft.client.gui.*;

public abstract class Class230<T>
{
    protected int width;
    protected int height;
    protected int x;
    protected int y;
    private boolean shown;
    protected T value;
    protected FontRenderer fontRenderer;
    
    public Class230(final int width, final int height, final T value) {
        super();
        this.shown = false;
        this.fontRenderer = Class139.INSTANCE.fontManager.comfortaa16;
        this.width = width;
        this.height = height;
        this.x = 0;
        this.y = 0;
        this.value = value;
    }
    
    public abstract void draw();
    
    public abstract boolean onMouseClick(final int p0, final int p1, final int p2);
    
    private boolean isShown() {
        return this.shown;
    }
    
    private void setShown(final boolean shown) {
        this.shown = shown;
    }
    
    public final int getWidth() {
        return this.width;
    }
    
    private void setWidth(final int width) {
        this.width = width;
    }
    
    public final int getHeight() {
        return this.height;
    }
    
    private void setHeight(final int height) {
        this.height = height;
    }
    
    public final int getX() {
        return this.x;
    }
    
    public final void setX(final int x) {
        this.x = x;
    }
    
    public final int getY() {
        return this.y;
    }
    
    public final void setY(final int y) {
        this.y = y;
    }
    
    public final T getValue() {
        return this.value;
    }
    
    private void setValue(final T value) {
        this.value = value;
    }
    
    public abstract void update();
}
