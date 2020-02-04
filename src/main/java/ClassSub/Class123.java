package ClassSub;

final class Class123 implements Class180
{
    private float val$scaleX;
    private float val$scaleY;
    private Class85 val$image;
    
    Class123(final float val$scaleX, final float val$scaleY, final Class85 val$image) {
        this.val$scaleX = val$scaleX;
        this.val$scaleY = val$scaleY;
        this.val$image = val$image;
        super();
    }
    
    @Override
    public final float[] preRenderPoint(final Class129 class129, float n, float n2) {
        n -= class129.getMinX();
        n2 -= class129.getMinY();
        n /= class129.getMaxX() - class129.getMinX();
        n2 /= class129.getMaxY() - class129.getMinY();
        final float n3 = n * this.val$scaleX;
        n = n2 * this.val$scaleY;
        final float n4 = this.val$image.getTextureOffsetX() + this.val$image.getTextureWidth() * n3;
        n = this.val$image.getTextureOffsetY() + this.val$image.getTextureHeight() * n;
        Class221.access$000().glTexCoord2f(n4, n);
        return null;
    }
}
