package ClassSub;

import java.lang.invoke.*;

public final class Class220
{
    public long lastMs;
    private static final long a;
    
    public Class220() {
        super();
        this.lastMs = 0L;
    }
    
    public final boolean isDelayComplete(final long n) {
        final int[] b = Class139.b();
        final long n2 = lcmp(System.currentTimeMillis() - this.lastMs, n);
        return (b != null || n2 > 0) && n2;
    }
    
    private static long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }
    
    private void reset() {
        this.lastMs = System.currentTimeMillis();
    }
    
    private long getLastMs() {
        return this.lastMs;
    }
    
    private void setLastMs$13462e() {
        this.lastMs = System.currentTimeMillis() - 800L;
    }
    
    public final boolean hasReached$1349f3() {
        final int[] b = Class139.b();
        final long n = lcmp(System.nanoTime() / 1000000L - this.lastMs, 5000L);
        return (b != null || n >= 0) && n;
    }
    
    public final boolean isDelayComplete(final float n) {
        final int[] b = Class139.b();
        final float n2 = fcmpl((float)(System.currentTimeMillis() - this.lastMs), n);
        return (b != null || n2 > 0) && n2;
    }
    
    public final boolean isDelayComplete(final Double n) {
        final int[] b = Class139.b();
        final double n2 = dcmpl((double)(System.currentTimeMillis() - this.lastMs), (double)n);
        return (b != null || n2 > 0) && n2;
    }
    
    static {
        Class169.a(8467986643363426163L, 8111889597833688798L, MethodHandles.lookup().lookupClass()).a(225576708458809L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean llIlllIIllIl(final int n) {
        return n >= 0;
    }
    
    private static boolean llIlllIIlIll(final int n) {
        return n > 0;
    }
    
    private static int llIlllIIlIIl(final long n, final long n2) {
        return lcmp(n, n2);
    }
    
    private static int llIlllIIllII(final long n, final long n2) {
        return lcmp(n, n2);
    }
    
    private static int llIlllIIlllI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int llIlllIIllll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
}
