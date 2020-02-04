package ClassSub;

import java.lang.invoke.*;

public final class Class120 extends Class81<Float>
{
    private static final long a;
    
    public Class120(final Float n, final Float n2) {
        super(n, n2);
    }
    
    private Class120 setYaw(final Float x) {
        super.x = x;
        return this;
    }
    
    private Class120 setPitch(final Float y) {
        super.y = y;
        return this;
    }
    
    public final Float getYaw() {
        return super.x.floatValue();
    }
    
    public final Float getPitch() {
        return super.y.floatValue();
    }
    
    public final Class120 constrantAngle() {
        super.x = this.getYaw() % 360.0f;
        final int[] b = Class139.b();
        super.y = this.getPitch() % 360.0f;
        final int[] array = b;
    Label_0176_Outer:
        while (true) {
        Label_0176:
            while (true) {
                while (this.getYaw() <= -180.0f) {
                    super.x = this.getYaw() + 360.0f;
                    if (array != null) {
                        while (this.getYaw() > 180.0f) {
                            super.x = this.getYaw() - 360.0f;
                            if (array != null) {
                                return this;
                            }
                            if (array != null) {
                                break;
                            }
                        }
                        while (this.getPitch() > 180.0f) {
                            super.y = this.getPitch() - 360.0f;
                            final Class120 class120 = this;
                            if (array != null) {
                                return class120;
                            }
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
                while (this.getPitch() <= -180.0f) {
                    super.y = this.getPitch() + 360.0f;
                    if (array != null) {
                        continue Label_0176;
                    }
                    if (array != null) {
                        break;
                    }
                }
                break;
            }
            continue Label_0176_Outer;
        }
    }
    
    static {
        Class169.a(6490885411414873961L, 5610874522136538924L, MethodHandles.lookup().lookupClass()).a(67714045973047L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIIllllIllII(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIllllIllll(final int n) {
        return n > 0;
    }
    
    private static int lIIllllIlIll$2548a28(final float n) {
        return fcmpl(n, 180.0f);
    }
    
    private static int lIIllllIlIlI$2548a28(final float n) {
        return fcmpg(n, -180.0f);
    }
}
