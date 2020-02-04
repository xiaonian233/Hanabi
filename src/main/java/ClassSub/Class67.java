package ClassSub;

final class Class67
{
    public Class85 image;
    public int duration;
    public int x;
    public int y;
    private Class187 this$0;
    
    public Class67(final Class85 image, final int duration) {
        super();
        this.x = -1;
        this.y = -1;
        this.image = image;
        this.duration = duration;
    }
    
    public Class67(final Class187 class187, final int duration, final int x, final int y) {
        super();
        this.x = -1;
        this.y = -1;
        this.image = Class187.access$000(class187).getSubImage(x, y);
        this.duration = duration;
        this.x = x;
        this.y = y;
    }
}
