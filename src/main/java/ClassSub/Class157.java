package ClassSub;

import java.lang.invoke.*;

public final class Class157
{
    public float opacity;
    public long lastMS;
    private static final long a;
    
    public Class157() {
        super();
        this.opacity = 0.0f;
        this.lastMS = System.currentTimeMillis();
    }
    
    private void interpolate(final float n) {
        final long currentTimeMillis;
        final long n2 = (currentTimeMillis = System.currentTimeMillis()) - this.lastMS;
        this.lastMS = currentTimeMillis;
        this.opacity = calculateCompensation(n, this.opacity, n2, 20);
    }
    
    private void interp$2549578() {
        final long currentTimeMillis;
        final long n = (currentTimeMillis = System.currentTimeMillis()) - this.lastMS;
        this.lastMS = currentTimeMillis;
        this.opacity = calculateCompensation(255.0f, this.opacity, n, 1);
    }
    
    private float getOpacity() {
        return (int)this.opacity;
    }
    
    private void setOpacity$133aeb() {
        this.opacity = 0.0f;
    }
    
    public static float calculateCompensation(final float n, float n2, long n3, final int n4) {
        final int[] b = Class139.b();
        final float n5 = n2 - n;
        final int[] array = b;
        float n7;
        final long n6 = (long)(n7 = lcmp(n3, 1L));
        if (array == null) {
            if (n6 < 0) {
                n3 = 1L;
            }
            final float n8;
            n7 = (n8 = fcmpl(n5, (float)n4));
        }
        final float n12;
        Label_0239: {
            if (array == null) {
                if (n6 > 0) {
                    final double n9 = dcmpg((double)(n4 * n3 / 16L), 0.25);
                    final float n11;
                    final float n10 = n2 = (n11 = (float)(n2 - ((array == null && n9 < 0) ? 0.5 : ((long)n9 * n3 / 16L))));
                    if (array != null) {
                        return n11;
                    }
                    if (n10 >= n) {
                        return n2;
                    }
                    n2 = n;
                    if (array == null) {
                        return n2;
                    }
                }
                n12 = n5;
                if (array != null) {
                    break Label_0239;
                }
                n7 = fcmpg(n12, (float)(-n4));
            }
            if (n7 < 0) {
                final double n13 = dcmpg((double)(n4 * n3 / 16L), 0.25);
                final float n11;
                final float n14 = n2 = (n11 = (float)(n2 + ((array == null && n13 < 0) ? 0.5 : ((long)n13 * n3 / 16L))));
                if (array != null) {
                    return n11;
                }
                if (n14 <= n) {
                    return n2;
                }
                n2 = n;
                if (array == null) {
                    return n2;
                }
            }
        }
        n2 = n12;
        return n2;
    }
    
    static {
        Class169.a(7426824610500063781L, 1121363583440269594L, MethodHandles.lookup().lookupClass()).a(263617879881372L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lllllIIIIlIl(final int n) {
        return n < 0;
    }
    
    private static boolean lllllIIIIllI(final int n) {
        return n > 0;
    }
    
    private static int lllllIIIIIII$2566aa8(final long n) {
        return lcmp(n, 1L);
    }
    
    private static int lllllIIIIIIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lllllIIIIIll(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lllllIIIIIlI$25399e8(final double n) {
        return dcmpg(n, 0.25);
    }
}
