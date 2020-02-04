package ClassSub;

import java.lang.invoke.*;

public final class Class243
{
    private static final long a;
    
    public Class243() {
        super();
    }
    
    private static double reduceSinAngle(double n) {
        final int[] b = Class139.b();
        final double n2 = dcmpl(Math.abs(n %= 6.283185307179586), 3.141592653589793);
        final double abs;
        if (b == null) {
            if (n2 > 0) {
                n -= 6.283185307179586;
            }
            abs = Math.abs(n);
            if (b != null) {
                return abs;
            }
            final double n3 = dcmpl(abs, 1.5707963267948966);
        }
        if (n2 > 0) {
            n = 3.141592653589793 - n;
        }
        return abs;
    }
    
    public static double sin(double n) {
        final int[] b = Class139.b();
        final double n2 = n;
        final int[] b2 = Class139.b();
        double n4;
        final double n3 = dcmpl(Math.abs(n4 = n2 % 6.283185307179586), 3.141592653589793);
        final double abs;
        Label_0074: {
            if (b2 == null) {
                if (n3 > 0) {
                    n4 -= 6.283185307179586;
                }
                abs = Math.abs(n4);
                if (b2 != null) {
                    break Label_0074;
                }
                final double n5 = dcmpl(abs, 1.5707963267948966);
            }
            if (n3 > 0) {
                n4 = 3.141592653589793 - n4;
            }
        }
        n = abs;
        final int[] array = b;
        final double abs2 = Math.abs(n);
        double n6 = 0.7853981633974483;
        if (array == null) {
            if (abs2 <= 0.7853981633974483) {
                return Math.sin(n);
            }
            n6 = n;
        }
        return Math.cos(abs2 - n6);
    }
    
    public static double cos(final double n) {
        return sin(n + 1.5707963267948966);
    }
    
    static {
        Class169.a(8457955082694741091L, 1840058718264253179L, MethodHandles.lookup().lookupClass()).a(126821462869151L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIIllIllI(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIllIlII(final int n) {
        return n > 0;
    }
    
    private static int lIIllIIlI(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIllIlIl$25399e8(final double n) {
        return dcmpg(n, 0.7853981633974483);
    }
}
