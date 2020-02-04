package ClassSub;

public final class Class209 extends Class129
{
    private Class209(final float x, final float y) {
        super();
        this.x = x;
        this.y = y;
        this.checkPoints();
    }
    
    @Override
    public final Class129 transform(final Class24 class24) {
        class24.transform$3b3ff12(this.points, new float[this.points.length], this.points.length / 2);
        return new Class209(this.points[0], this.points[1]);
    }
    
    @Override
    protected final void createPoints() {
        (this.points = new float[2])[0] = this.getX();
        this.points[1] = this.getY();
        this.maxX = this.x;
        this.maxY = this.y;
        this.minX = this.x;
        this.minY = this.y;
        this.findCenter();
        this.boundingCircleRadius = 0.0f;
    }
    
    @Override
    protected final void findCenter() {
        (this.center = new float[2])[0] = this.points[0];
        this.center[1] = this.points[1];
    }
    
    @Override
    protected final void calculateRadius() {
        this.boundingCircleRadius = 0.0f;
    }
}
