package ClassSub;

import java.lang.invoke.*;

public final class Class164 implements Class124
{
    private float[][] triangles;
    private static final long a;
    
    public Class164(final Class124 class124) {
        final int[] b = Class139.b();
        super();
        final int[] array = b;
        this.triangles = new float[class124.getTriangleCount() * 6 * 3][2];
        int n = 0;
        int n2 = 0;
        do {
            int i = 0;
            Label_0035: {
                i = n2;
            }
            int triangleCount = class124.getTriangleCount();
            Label_0043:
            while (i < triangleCount) {
                float n3 = 0.0f;
                float n4 = 0.0f;
                int j = 0;
                while (true) {
                Label_0317_Outer:
                    while (j < 3) {
                        final float[] trianglePoint = class124.getTrianglePoint(n2, j);
                        n3 += trianglePoint[0];
                        n4 += trianglePoint[1];
                        ++j;
                        if (array != null) {
                            int k = 0;
                            while (true) {
                                while (k < 3) {
                                    int n7;
                                    int n6;
                                    int n5 = n6 = (n7 = k + 1);
                                    Label_0154: {
                                        if (array == null) {
                                            int n8 = 2;
                                            if (array != null) {
                                                while (true) {
                                                    if (n7 < n8) {
                                                        int n10;
                                                        int n9 = i = (n10 = k + 1);
                                                        Label_0351: {
                                                            if (array == null) {
                                                                triangleCount = 2;
                                                                if (array != null) {
                                                                    continue Label_0043;
                                                                }
                                                                if (!lllIlllIlII$255f299(n9)) {
                                                                    break Label_0351;
                                                                }
                                                                n10 = 0;
                                                            }
                                                            n9 = n10;
                                                        }
                                                        final float[] trianglePoint2 = class124.getTrianglePoint(n2, k);
                                                        final float[] trianglePoint3;
                                                        final float[] array2 = trianglePoint3 = class124.getTrianglePoint(n2, n9);
                                                        array2[0] = (trianglePoint2[0] + trianglePoint3[0]) / 2.0f;
                                                        trianglePoint3[1] = (trianglePoint2[1] + trianglePoint3[1]) / 2.0f;
                                                        this.triangles[n * 3][0] = n3;
                                                        this.triangles[n * 3][1] = n4;
                                                        this.triangles[n * 3 + 1][0] = trianglePoint2[0];
                                                        this.triangles[n * 3 + 1][1] = trianglePoint2[1];
                                                        this.triangles[n * 3 + 2][0] = trianglePoint3[0];
                                                        this.triangles[n * 3 + 2][1] = trianglePoint3[1];
                                                        ++n;
                                                        ++k;
                                                        if (array == null) {
                                                            n7 = k;
                                                            n8 = 3;
                                                            continue Label_0317_Outer;
                                                        }
                                                    }
                                                    break;
                                                }
                                                ++n2;
                                                continue Label_0035;
                                            }
                                            if (!lllIlllIlII$255f299(n5)) {
                                                break Label_0154;
                                            }
                                            n6 = 0;
                                        }
                                        n5 = n6;
                                    }
                                    final float[] trianglePoint4 = class124.getTrianglePoint(n2, k);
                                    final float[] trianglePoint5 = class124.getTrianglePoint(n2, n5);
                                    trianglePoint4[0] = (trianglePoint4[0] + trianglePoint5[0]) / 2.0f;
                                    trianglePoint4[1] = (trianglePoint4[1] + trianglePoint5[1]) / 2.0f;
                                    this.triangles[n * 3][0] = n3;
                                    this.triangles[n * 3][1] = n4;
                                    this.triangles[n * 3 + 1][0] = trianglePoint4[0];
                                    this.triangles[n * 3 + 1][1] = trianglePoint4[1];
                                    this.triangles[n * 3 + 2][0] = trianglePoint5[0];
                                    this.triangles[n * 3 + 2][1] = trianglePoint5[1];
                                    ++n;
                                    ++k;
                                    if (array != null) {
                                        break;
                                    }
                                }
                                k = 0;
                                continue;
                            }
                        }
                        if (array != null) {
                            break;
                        }
                    }
                    n3 /= 3.0f;
                    n4 /= 3.0f;
                    continue;
                }
            }
            break;
        } while (array == null);
    }
    
    @Override
    public final void addPolyPoint(final float n, final float n2) {
    }
    
    @Override
    public final int getTriangleCount() {
        return this.triangles.length / 3;
    }
    
    @Override
    public final float[] getTrianglePoint(final int n, final int n2) {
        final float[] array = this.triangles[n * 3 + n2];
        return new float[] { array[0], array[1] };
    }
    
    @Override
    public final void startHole() {
    }
    
    @Override
    public final boolean triangulate() {
        return true;
    }
    
    static {
        Class169.a(1421650754703739694L, 3087198240705141372L, MethodHandles.lookup().lookupClass()).a(267772966939790L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lllIlllIlII$255f299(final int n) {
        return n > 2;
    }
}
