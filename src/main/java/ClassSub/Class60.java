package ClassSub;

import java.lang.invoke.*;

public final class Class60 extends Class129
{
    private Class176 p1;
    private Class176 c1;
    private Class176 c2;
    private Class176 p2;
    private int segments;
    private static final long a;
    
    public Class60(final Class176 class176, final Class176 class177, final Class176 class178, final Class176 class179) {
        this(class176, class177, class178, class179, (byte)0);
    }
    
    private Class60(final Class176 class176, final Class176 class177, final Class176 class178, final Class176 class179, final byte b) {
        super();
        this.p1 = new Class176(class176);
        this.c1 = new Class176(class177);
        this.c2 = new Class176(class178);
        this.p2 = new Class176(class179);
        this.segments = 20;
        this.pointsDirty = true;
    }
    
    public final Class176 pointAt(float n) {
        final float n3;
        final float n2 = n3 = 1.0f - n;
        final float n4 = n2 * n2 * n3;
        final float n5 = 3.0f * n3 * n3 * n;
        final float n6 = 3.0f * n3 * n * n;
        final float n7 = n;
        n *= n7 * n7;
        final float n8 = this.p1.x * n4 + this.c1.x * n5 + this.c2.x * n6 + this.p2.x * n;
        n = this.p1.y * n4 + this.c1.y * n5 + this.c2.y * n6 + this.p2.y * n;
        return new Class176(n8, n);
    }
    
    @Override
    protected final void createPoints() {
        final float n = 1.0f / this.segments;
        this.points = new float[(this.segments + 1) * 2];
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        while (i < this.segments + 1) {
            final Class176 point = this.pointAt(i * n);
            this.points[i * 2] = point.x;
            this.points[i * 2 + 1] = point.y;
            ++i;
            if (array != null) {
                break;
            }
        }
    }
    
    @Override
    public final Class129 transform(final Class24 class24) {
        final float[] array = new float[8];
        final float[] array2 = new float[8];
        array[0] = this.p1.x;
        array[1] = this.p1.y;
        array[2] = this.c1.x;
        array[3] = this.c1.y;
        array[4] = this.c2.x;
        array[5] = this.c2.y;
        array[6] = this.p2.x;
        array[7] = this.p2.y;
        class24.transform$3b3ff12(array, array2, 4);
        return new Class60(new Class176(array2[0], array2[1]), new Class176(array2[2], array2[3]), new Class176(array2[4], array2[5]), new Class176(array2[6], array2[7]));
    }
    
    @Override
    public final boolean closed() {
        return false;
    }
    
    static {
        Class169.a(482734316946556482L, 1559585434233240755L, MethodHandles.lookup().lookupClass()).a(212769583467437L);
    }
}
