package ClassSub;

import java.util.*;
import java.security.*;
import java.math.*;
import java.lang.invoke.*;

public final class Class344
{
    private static final Random rng;
    private static final long a;
    
    public Class344() {
        super();
    }
    
    private static boolean isInteger(final String s) {
        try {
            Integer.parseInt(s);
        }
        catch (NumberFormatException ex) {
            return false;
        }
        catch (NullPointerException ex2) {
            return false;
        }
        return true;
    }
    
    private static Double clamp(final double n, final double n2, final double n3) {
        final int[] b = Class139.b();
        final double n4 = dcmpg(n, n2);
        if (b == null) {
            if (n4 < 0) {
                return n2;
            }
            final double n5 = n;
            if (b != null) {
                return n5;
            }
            final double n6 = dcmpl(n, n3);
        }
        if (n4 > 0) {
            return n3;
        }
        return n;
    }
    
    private static Double getDifference(double n, double n2) {
        final int[] b = Class139.b();
        final double n3 = n;
        double n4 = n2;
        if (b == null) {
            if (n3 > n2) {
                final double n5 = n;
                n = n2;
                n2 = n5;
            }
            n4 = n;
        }
        return n3 - n4;
    }
    
    private static float randomSeed(long n) {
        n += System.currentTimeMillis();
        return 0.4f + new Random(n).nextInt(80000000) / 1.0E9f + 1.45E-9f;
    }
    
    private static float secRanFloat(final float n, final float n2) {
        return new SecureRandom().nextFloat() * (n2 - n) + n;
    }
    
    private static int randInt(final int n, final int n2) {
        return new SecureRandom().nextInt() * (n2 - n) + n;
    }
    
    private static double secRanDouble(final double n, final double n2) {
        return new SecureRandom().nextDouble() * (n2 - n) + n;
    }
    
    private static float getAngleDifference(float n, float n2) {
        final int[] b = Class139.b();
        n2 = Math.abs(n2 - n) % 360.0f;
        final int[] array = b;
        float n4;
        final float n3 = n4 = n2;
        float n5 = 180.0f;
        if (array == null) {
            n = n3;
            if (n3 <= 180.0f) {
                return n;
            }
            n4 = 360.0f;
            n5 = n;
        }
        return n4 - n5;
    }
    
    private static double getMiddle(final double n, final double n2) {
        return (n + n2) / 2.0;
    }
    
    private static float getMiddle(final float n, final float n2) {
        return (n + n2) / 2.0f;
    }
    
    private static double getMiddleint(final double n, final double n2) {
        return (n + n2) / 2.0;
    }
    
    private static int getRandom(final int n, final int n2) {
        return n + Class344.rng.nextInt(n2 - n + 1);
    }
    
    private static double getRandom(final double n, final double n2) {
        return n + Class344.rng.nextInt((int)(n2 - n + 1.0));
    }
    
    private static double getRandomInRange(final double n, final double n2) {
        final Random random = new Random();
        final double n3 = n2 - n;
        final int[] b = Class139.b();
        double n4 = random.nextDouble() * n3;
        final int[] array = b;
        final double n5 = n4;
        double n6 = n2;
        if (array == null) {
            if (n5 > n2) {
                n4 = n2;
            }
            n6 = n;
        }
        double n8;
        double n7 = n8 = n5 + n6;
        if (array == null) {
            if (n7 > n2) {
                n7 = n2;
            }
            n8 = n7;
        }
        return n8;
    }
    
    public static float getRandomInRange$2548a25() {
        return new Random().nextFloat() * 0.6999999f + 1.1f;
    }
    
    private static int getRandomInRange(final int n, final int n2) {
        return new Random().nextInt(n2 - n + 1) + n;
    }
    
    private static double round(final double n, final int n2) {
        if (n2 < 0) {
            throw new IllegalArgumentException();
        }
        return new BigDecimal(n).setScale(n2, RoundingMode.HALF_UP).doubleValue();
    }
    
    static {
        Class169.a(399272208169106011L, 1389527446454809426L, MethodHandles.lookup().lookupClass()).a(163782576357950L);
        rng = new Random();
    }
    
    private static NumberFormatException a(final NumberFormatException ex) {
        return ex;
    }
    
    private static boolean lIlIIIIIll(final int n) {
        return n < 0;
    }
    
    private static boolean lIlIIIIlII(final int n) {
        return n > 0;
    }
    
    private static int lIlIIIIIIl(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIIIIIII(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIlIIIIlIl(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIIIIllI$2548a28(final float n) {
        return fcmpl(n, 180.0f);
    }
    
    private static int lIlIIIIlll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
}
