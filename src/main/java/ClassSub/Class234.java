package ClassSub;

final class Class234 implements Class180
{
    private Class356 val$fill;
    
    Class234(final Class356 val$fill) {
        this.val$fill = val$fill;
        super();
    }
    
    @Override
    public final float[] preRenderPoint(final Class129 class129, final float n, final float n2) {
        this.val$fill.colorAt$14309a69().bind();
        final Class176 offsetAt$14311289 = this.val$fill.getOffsetAt$14311289();
        return new float[] { offsetAt$14311289.x + n, offsetAt$14311289.y + n2 };
    }
}
