package ClassSub;

import java.lang.invoke.*;

public final class Class103 implements Class341
{
    private Class79 GL;
    private static final long a;
    
    public Class103() {
        super();
        this.GL = Class110.get();
    }
    
    @Override
    public final void end() {
        this.GL.glEnd();
    }
    
    @Override
    public final void setAntiAlias(final boolean b) {
        Label_0027: {
            final int[] b2;
            if ((b2 = Class139.b()) == null) {
                if (!b) {
                    break Label_0027;
                }
                this.GL.glEnable(2848);
            }
            if (b2 == null) {
                return;
            }
        }
        this.GL.glDisable(2848);
    }
    
    @Override
    public final void setWidth(final float n) {
        this.GL.glLineWidth(n);
    }
    
    @Override
    public final void start() {
        this.GL.glBegin(3);
    }
    
    @Override
    public final void vertex(final float n, final float n2) {
        this.GL.glVertex2f(n, n2);
    }
    
    @Override
    public final void color(final float n, final float n2, final float n3, final float n4) {
        this.GL.glColor4f(n, n2, n3, n4);
    }
    
    @Override
    public final void setLineCaps(final boolean b) {
    }
    
    @Override
    public final boolean applyGLLineFixes() {
        return true;
    }
    
    static {
        Class169.a(5706392283102991042L, 4154326632692087424L, MethodHandles.lookup().lookupClass()).a(272643466084819L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
