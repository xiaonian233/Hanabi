package ClassSub;

public class Class63 implements Class247
{
    private Class12 GL;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class63() {
        super();
        this.GL = Class83.get();
    }
    
    @Override
    public void end() {
        this.GL.glEnd();
    }
    
    @Override
    public void setAntiAlias(final boolean b) {
        if (b) {
            this.GL.glEnable(2848);
        }
        else {
            this.GL.glDisable(2848);
        }
    }
    
    @Override
    public void setWidth(final float n) {
        this.GL.glLineWidth(n);
    }
    
    @Override
    public void start() {
        this.GL.glBegin(3);
    }
    
    @Override
    public void vertex(final float n, final float n2) {
        this.GL.glVertex2f(n, n2);
    }
    
    @Override
    public void color(final float n, final float n2, final float n3, final float n4) {
        this.GL.glColor4f(n, n2, n3, n4);
    }
    
    @Override
    public void setLineCaps(final boolean b) {
    }
    
    @Override
    public boolean applyGLLineFixes() {
        return true;
    }
}
