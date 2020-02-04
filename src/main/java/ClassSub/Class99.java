package ClassSub;

final class Class99 implements Class180
{
    private Class356 val$fill;
    private float[] val$center;
    private float val$scaleX;
    private float val$scaleY;
    private Class85 val$image;
    
    Class99(final Class356 val$fill, final Class85 val$image) {
        this.val$fill = val$fill;
        this.val$scaleX = 0.01f;
        this.val$scaleY = 0.01f;
        this.val$image = val$image;
        super();
    }
    
    @Override
    public final float[] preRenderPoint(final Class129 class129, float n, float n2) {
        this.val$fill.colorAt$14309a69().bind();
        final Class176 offsetAt$14311289 = this.val$fill.getOffsetAt$14311289();
        n += offsetAt$14311289.x;
        n2 += offsetAt$14311289.y;
        Class221.access$000().glTexCoord2f(this.val$image.getTextureOffsetX() + this.val$image.getTextureWidth() * (n * this.val$scaleX), this.val$image.getTextureOffsetY() + this.val$image.getTextureHeight() * (n2 * this.val$scaleY));
        return new float[] { offsetAt$14311289.x + n, offsetAt$14311289.y + n2 };
    }
}
