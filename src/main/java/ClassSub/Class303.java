package ClassSub;

import java.util.*;
import javax.vecmath.*;
import java.lang.invoke.*;

public final class Class303
{
    private boolean aac;
    private float smooth;
    private Random random;
    private static final long a;
    
    public Class303(final boolean aac, final float smooth) {
        super();
        this.aac = aac;
        this.smooth = smooth;
        this.random = new Random();
    }
    
    public final Class97 calculateAngle(final Vector3d vector3d, final Vector3d vector3d2) {
        final int[] b = Class139.b();
        final Class97 class97 = new Class97();
        final int[] array = b;
        final double x = vector3d.x;
        Class303 class98 = this;
        float randomFloat = 0.0f;
        Label_0041: {
            if (array == null) {
                if (!this.aac) {
                    randomFloat = 0.0f;
                    break Label_0041;
                }
                class98 = this;
            }
            randomFloat = class98.randomFloat(-0.75f, 0.75f);
        }
        vector3d.x = x + (randomFloat - vector3d2.x);
        final double y = vector3d.y;
        Class303 class99 = this;
        float randomFloat2 = 0.0f;
        Label_0079: {
            if (array == null) {
                if (!this.aac) {
                    randomFloat2 = 0.0f;
                    break Label_0079;
                }
                class99 = this;
            }
            randomFloat2 = class99.randomFloat(-0.25f, 0.5f);
        }
        vector3d.y = y + (randomFloat2 - vector3d2.y);
        final double z = vector3d.z;
        Class303 class100 = this;
        float randomFloat3 = 0.0f;
        Label_0117: {
            if (array == null) {
                if (!this.aac) {
                    randomFloat3 = 0.0f;
                    break Label_0117;
                }
                class100 = this;
            }
            randomFloat3 = class100.randomFloat(-0.75f, 0.75f);
        }
        vector3d.z = z + (randomFloat3 - vector3d2.z);
        final double hypot = Math.hypot(vector3d.x, vector3d.z);
        class97.yaw = (float)(Math.atan2(vector3d.z, vector3d.x) * 57.29577951308232) - 90.0f;
        class97.pitch = -(float)(Math.atan2(vector3d.y, hypot) * 57.29577951308232);
        return class97.constrantAngle();
    }
    
    public final Class97 smoothAngle(Class97 constrantAngle, final Class97 class97) {
        final Class97 class98 = constrantAngle = new Class97(class97.yaw - constrantAngle.yaw, class97.pitch - constrantAngle.pitch).constrantAngle();
        class98.yaw = class97.yaw - constrantAngle.yaw / 100.0f * this.smooth;
        constrantAngle.pitch = class97.pitch - constrantAngle.pitch / 100.0f * this.smooth;
        return constrantAngle.constrantAngle();
    }
    
    private float randomFloat(final float n, final float n2) {
        return n + this.random.nextFloat() * (n2 - n);
    }
    
    static {
        Class169.a(1885694621334071587L, 8317254838889913966L, MethodHandles.lookup().lookupClass()).a(38652052401437L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
