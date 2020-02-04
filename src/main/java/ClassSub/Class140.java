package ClassSub;

import java.util.*;
import java.lang.invoke.*;

public final class Class140 extends Class129
{
    private boolean allowDups;
    private boolean closed;
    private static final long a;
    
    public Class140(final float[] array) {
        super();
        final int[] b = Class139.b();
        this.allowDups = false;
        this.closed = true;
        final int length = array.length;
        this.points = new float[length];
        this.maxX = -1.4E-45f;
        this.maxY = -1.4E-45f;
        final int[] array2 = b;
        this.minX = Float.MAX_VALUE;
        this.minY = Float.MAX_VALUE;
        this.x = Float.MAX_VALUE;
        this.y = Float.MAX_VALUE;
        int i = 0;
        while (i < length) {
            this.points[i] = array[i];
            if (array2 != null) {
                return;
            }
            float n3;
            float n2;
            final int n = (int)(n2 = (n3 = i % 2));
            Label_0288: {
                if (array2 == null) {
                    if (n == 0) {
                        float n5;
                        final float n4 = n5 = fcmpl(array[i], this.maxX);
                        if (array2 == null) {
                            if (n4 > 0) {
                                this.maxX = array[i];
                            }
                            final int n6;
                            n5 = (n6 = fcmpg(array[i], this.minX));
                        }
                        if (array2 == null) {
                            if (n4 < 0) {
                                this.minX = array[i];
                            }
                            n5 = fcmpg(array[i], this.x);
                        }
                        if (n5 >= 0) {
                            break Label_0288;
                        }
                        this.x = array[i];
                        if (array2 == null) {
                            break Label_0288;
                        }
                    }
                    final float n7;
                    n2 = (n7 = (n3 = fcmpl(array[i], this.maxY)));
                }
                if (array2 == null) {
                    if (n > 0) {
                        this.maxY = array[i];
                    }
                    n3 = (n2 = fcmpg(array[i], this.minY));
                }
                if (array2 == null) {
                    if (n2 < 0) {
                        this.minY = array[i];
                    }
                    n3 = fcmpg(array[i], this.y);
                }
                if (n3 < 0) {
                    this.y = array[i];
                }
            }
            ++i;
            if (array2 != null) {
                break;
            }
        }
        this.findCenter();
        this.calculateRadius();
        this.pointsDirty = true;
    }
    
    public Class140() {
        super();
        this.allowDups = false;
        this.closed = true;
        this.points = new float[0];
        this.maxX = -1.4E-45f;
        this.maxY = -1.4E-45f;
        this.minX = Float.MAX_VALUE;
        this.minY = Float.MAX_VALUE;
    }
    
    private void setAllowDuplicatePoints(final boolean allowDups) {
        this.allowDups = allowDups;
    }
    
    public final void addPoint(final float n, final float n2) {
        final int[] b = Class139.b();
        final boolean hasVertex = this.hasVertex(n, n2);
        Label_0025: {
            if (b == null) {
                if (!hasVertex) {
                    break Label_0025;
                }
                final boolean allowDups = this.allowDups;
            }
            if (!hasVertex) {
                return;
            }
        }
        final ArrayList<Float> list = new ArrayList<Float>();
        int i = 0;
        while (true) {
            while (i < this.points.length) {
                list.add(new Float(this.points[i]));
                ++i;
                if (b == null) {
                    if (b != null) {
                        break;
                    }
                    continue;
                }
                else {
                    int j = 0;
                Label_0186_Outer:
                    while (true) {
                        int n6 = 0;
                        while (true) {
                            while (j < i) {
                                this.points[j] = list.get(j);
                                ++j;
                                if (b != null) {
                                    float n5;
                                    final int n4;
                                    float n3 = n4 = (int)(n5 = fcmpl(n2, this.maxY));
                                    if (b == null) {
                                        if (n6 > 0) {
                                            this.maxY = n2;
                                        }
                                        n5 = (n3 = fcmpg(n, this.minX));
                                    }
                                    if (b == null) {
                                        if (n3 < 0) {
                                            this.minX = n;
                                        }
                                        n5 = fcmpg(n2, this.minY);
                                    }
                                    if (n5 < 0) {
                                        this.minY = n2;
                                    }
                                    this.findCenter();
                                    this.calculateRadius();
                                    this.pointsDirty = true;
                                    return;
                                }
                                if (b != null) {
                                    break;
                                }
                            }
                            float n5;
                            float n3;
                            n6 = (int)(n3 = (n5 = fcmpl(n, this.maxX)));
                            if (b != null) {
                                continue;
                            }
                            break;
                        }
                        if (n6 > 0) {
                            this.maxX = n;
                        }
                        continue Label_0186_Outer;
                    }
                }
            }
            list.add(n);
            list.add(n2);
            i = list.size();
            this.points = new float[i];
            continue;
        }
    }
    
    @Override
    public final Class129 transform(final Class24 class24) {
        this.checkPoints();
        final Class140 class25 = new Class140();
        final float[] points = new float[this.points.length];
        class24.transform$3b3ff12(this.points, points, this.points.length / 2);
        class25.points = points;
        class25.findCenter();
        class25.closed = this.closed;
        return class25;
    }
    
    @Override
    public final void setX(final float x) {
        super.setX(x);
        this.pointsDirty = false;
    }
    
    @Override
    public final void setY(final float y) {
        super.setY(y);
        this.pointsDirty = false;
    }
    
    @Override
    protected final void createPoints() {
    }
    
    @Override
    public final boolean closed() {
        return this.closed;
    }
    
    private void setClosed(final boolean closed) {
        this.closed = closed;
    }
    
    private Class140 copy() {
        final float[] array = new float[this.points.length];
        System.arraycopy(this.points, 0, array, 0, array.length);
        return new Class140(array);
    }
    
    static {
        Class169.a(1668985539419453801L, 5436914868045062332L, MethodHandles.lookup().lookupClass()).a(28519122505462L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIIIlllIlll(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIlllIllI(final int n) {
        return n > 0;
    }
    
    private static int lIIIlllIIIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIlllIIlI(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIIIllllIIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIllllIlI(final float n, final float n2) {
        return fcmpg(n, n2);
    }
}
