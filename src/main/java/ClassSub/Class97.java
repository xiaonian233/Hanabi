package ClassSub;

import java.lang.invoke.*;

public final class Class97
{
    public float yaw;
    public float pitch;
    private static final long a;
    
    public Class97(final float yaw, final float pitch) {
        super();
        this.yaw = yaw;
        this.pitch = pitch;
    }
    
    public Class97() {
        this(0.0f, 0.0f);
    }
    
    private float getYaw() {
        return this.yaw;
    }
    
    private float getPitch() {
        return this.pitch;
    }
    
    private void setYaw(final float yaw) {
        this.yaw = yaw;
    }
    
    private void setPitch(final float pitch) {
        this.pitch = pitch;
    }
    
    public final Class97 constrantAngle() {
        this.yaw %= 360.0f;
        final int[] b = Class139.b();
        this.pitch %= 360.0f;
        final int[] array = b;
    Label_0137_Outer:
        while (true) {
        Label_0137:
            while (true) {
                while (this.yaw <= -180.0f) {
                    this.yaw += 360.0f;
                    if (array != null) {
                        while (this.yaw > 180.0f) {
                            this.yaw -= 360.0f;
                            if (array != null) {
                                return this;
                            }
                            if (array != null) {
                                break;
                            }
                        }
                        while (this.pitch > 180.0f) {
                            final Class97 class97 = this;
                            if (array != null) {
                                return class97;
                            }
                            this.pitch -= 360.0f;
                            if (array != null) {
                                break;
                            }
                        }
                        return this;
                    }
                    if (array != null) {
                        break;
                    }
                }
                while (this.pitch <= -180.0f) {
                    this.pitch += 360.0f;
                    if (array != null) {
                        continue Label_0137;
                    }
                    if (array != null) {
                        break;
                    }
                }
                break;
            }
            continue Label_0137_Outer;
        }
    }
    
    static {
        Class169.a(4879860638813618576L, 7067128494772005115L, MethodHandles.lookup().lookupClass()).a(187233435256022L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean llIllIllII(final int n) {
        return n <= 0;
    }
    
    private static boolean llIllIllll(final int n) {
        return n > 0;
    }
    
    private static int llIllIlIlI$2548a28(final float n) {
        return fcmpl(n, 180.0f);
    }
    
    private static int llIllIlIIl$2548a28(final float n) {
        return fcmpg(n, -180.0f);
    }
}
