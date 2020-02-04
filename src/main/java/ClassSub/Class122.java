package ClassSub;

import java.lang.invoke.*;

final class Class122
{
    float x;
    float y;
    float[] array;
    private Class95 this$0;
    private static final long a;
    
    public Class122(final float x, final float y) {
        super();
        this.x = x;
        this.y = y;
        this.array = new float[] { x, y };
    }
    
    private float getX() {
        return this.x;
    }
    
    private float getY() {
        return this.y;
    }
    
    private float[] toArray() {
        return this.array;
    }
    
    @Override
    public final int hashCode() {
        return (int)(this.x * this.y * 31.0f);
    }
    
    @Override
    public final boolean equals(final Object o) {
        final int[] b = Class139.b();
        final boolean b2 = o instanceof Class122;
        if (b == null && b2) {
            final Class122 class122;
            float n2;
            final float n = n2 = fcmpl((class122 = (Class122)o).x, this.x);
            if (b == null) {
                if (n != 0) {
                    return false;
                }
                final int n3;
                n2 = (n3 = fcmpl(class122.y, this.y));
            }
            if (b == null) {
                if (n != 0) {
                    return false;
                }
                n2 = 1;
            }
            return n2 != 0.0f;
        }
        return b2;
    }
    
    static float access$000(final Class122 class122) {
        return class122.x;
    }
    
    static float access$100(final Class122 class122) {
        return class122.y;
    }
    
    static {
        Class169.a(5011589652483892639L, 3610718052533673560L, MethodHandles.lookup().lookupClass()).a(190427103858039L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static int lIIlIlIllll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
}
