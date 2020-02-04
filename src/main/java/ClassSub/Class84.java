package ClassSub;

import java.util.*;
import java.lang.invoke.*;

public final class Class84
{
    private float minYawSmoothing;
    private float maxYawSmoothing;
    private float minPitchSmoothing;
    private float maxPitchSmoothing;
    private Class92<Float> delta;
    private Class120 smoothedAngle;
    private final Random random;
    private float height;
    private static final long a;
    
    public Class84() {
        super();
        this.height = Class344.getRandomInRange$2548a25();
        this.minYawSmoothing = 110.0f;
        this.maxYawSmoothing = 120.0f;
        this.minPitchSmoothing = 30.0f;
        this.maxPitchSmoothing = 40.0f;
        this.random = new Random();
        this.delta = new Class92<Float>(0.0f, 0.0f, 0.0f);
        this.smoothedAngle = new Class120(Float.valueOf(0.0f), Float.valueOf(0.0f));
    }
    
    public final float randomFloat(final float n, final float n2) {
        return n + this.random.nextFloat() * (n2 - n);
    }
    
    public final Class120 calculateAngle(final Class92<Double> class92, final Class92<Double> class93) {
        final Class120 class94 = new Class120(Float.valueOf(0.0f), Float.valueOf(0.0f));
        final Class92<Float> delta = this.delta;
        final Float value = class92.x.floatValue() - class93.x.floatValue();
        final Class92<Float> class95 = delta;
        delta.x = value;
        final Class92<Float> class96 = class95;
        final Float value2 = class92.y.floatValue() + this.height - (class93.y.floatValue() + this.height);
        final Class92<Float> class97 = class96;
        class96.y = value2;
        class97.z = class92.z.floatValue() - class93.z.floatValue();
        final double hypot = Math.hypot(this.delta.x.doubleValue(), this.delta.z.doubleValue());
        final float n = (float)Math.atan2(this.delta.z.floatValue(), this.delta.x.floatValue());
        final float n2 = (float)Math.atan2(this.delta.y.floatValue(), hypot);
        final float n3 = n * 57.29578f - 90.0f;
        final float n4 = -(n2 * 57.29578f);
        final Class120 class98 = class94;
        final Float value3 = n3;
        final Class120 class99 = class98;
        class98.x = (T)value3;
        final Class120 class100 = class99;
        final Float value4 = n4;
        final Class120 class101 = class100;
        class100.y = (T)value4;
        return class101.constrantAngle();
    }
    
    private void setHeight(final float height) {
        this.height = height;
    }
    
    public final Class120 smoothAngle(final Class120 class120, final Class120 class121, final float n, final float n2) {
        final int[] b = Class139.b();
        final Class120 smoothedAngle = this.smoothedAngle;
        final float n3 = class121.getYaw() - class120.getYaw();
        final float abs = Math.abs(class121.getYaw() - class120.getYaw());
        float n4 = 5.0f;
        float n5 = 0.0f;
        Label_0109: {
            if (b == null) {
                if (abs <= 5.0f) {
                    n5 = 0.0f;
                    break Label_0109;
                }
                final float n6 = Math.abs(class121.getYaw() - class120.getYaw()) / Math.abs(class121.getYaw() - class120.getYaw()) * 2.0f;
                n4 = 2.0f;
            }
            n5 = abs / n4;
        }
        final Float value = n3 - n5;
        final Class120 class122 = smoothedAngle;
        smoothedAngle.x = (T)value;
        final Class120 class123 = class122;
        final Float value2 = class121.getPitch() - class120.getPitch();
        final Class120 class124 = class123;
        class123.y = (T)value2;
        final Class120 constrantAngle = class124.constrantAngle();
        final Float value3 = class121.getYaw() - this.smoothedAngle.getYaw() / n2 * this.randomFloat(this.minYawSmoothing, this.maxYawSmoothing);
        final Class120 class125 = constrantAngle;
        constrantAngle.x = (T)value3;
        final Class120 constrantAngle2 = class125.constrantAngle();
        final Float value4 = class121.getPitch() - this.smoothedAngle.getPitch() / n * this.randomFloat(this.minPitchSmoothing, this.maxPitchSmoothing);
        final Class120 class126 = constrantAngle2;
        constrantAngle2.y = (T)value4;
        return class126.constrantAngle();
    }
    
    static {
        Class169.a(346166623799942980L, 6493228397295125588L, MethodHandles.lookup().lookupClass()).a(274353598767718L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean llIIlIlIII(final int n) {
        return n > 0;
    }
    
    private static int llIIlIIllI$2548a28(final float n) {
        return fcmpl(n, 5.0f);
    }
}
