package ClassSub;

import java.io.*;
import java.lang.invoke.*;

public abstract class Class129 implements Serializable
{
    protected float[] points;
    protected float[] center;
    protected float x;
    protected float y;
    protected float maxX;
    protected float maxY;
    protected float minX;
    protected float minY;
    protected float boundingCircleRadius;
    protected boolean pointsDirty;
    private transient Class124 tris;
    private boolean trianglesDirty;
    private static final long c;
    
    public Class129() {
        super();
        this.pointsDirty = true;
    }
    
    private void setLocation(final float x, final float y) {
        this.setX(x);
        this.setY(y);
    }
    
    public abstract Class129 transform(final Class24 p0);
    
    protected abstract void createPoints();
    
    public float getX() {
        return this.x;
    }
    
    public void setX(final float x) {
        final int[] b = Class139.b();
        float n = x;
        final float x2 = this.x;
        if (b == null) {
            if (x == x2) {
                return;
            }
            n = x;
            final float x3 = this.x;
        }
        final float n2 = n - x2;
        this.x = x;
        Class129 class129 = this;
        Label_0055: {
            Label_0052: {
                if (b == null) {
                    if (this.points != null) {
                        class129 = this;
                        if (b != null) {
                            break Label_0052;
                        }
                        if (this.center != null) {
                            break Label_0055;
                        }
                    }
                    class129 = this;
                }
            }
            class129.checkPoints();
        }
        int i = 0;
        while (true) {
            while (i < this.points.length / 2) {
                final float[] points = this.points;
                final int n3 = i * 2;
                points[n3] += n2;
                ++i;
                if (b != null) {
                    this.trianglesDirty = true;
                    return;
                }
                if (b != null) {
                    break;
                }
            }
            final float[] center = this.center;
            final int n4 = 0;
            center[n4] += n2;
            this.maxX += n2;
            this.minX += n2;
            continue;
        }
    }
    
    public void setY(final float y) {
        final int[] b = Class139.b();
        float n = y;
        final float y2 = this.y;
        if (b == null) {
            if (y == y2) {
                return;
            }
            n = y;
            final float y3 = this.y;
        }
        final float n2 = n - y2;
        this.y = y;
        Class129 class129 = this;
        Label_0055: {
            Label_0052: {
                if (b == null) {
                    if (this.points != null) {
                        class129 = this;
                        if (b != null) {
                            break Label_0052;
                        }
                        if (this.center != null) {
                            break Label_0055;
                        }
                    }
                    class129 = this;
                }
            }
            class129.checkPoints();
        }
        int i = 0;
        while (true) {
            while (i < this.points.length / 2) {
                final float[] points = this.points;
                final int n3 = i * 2 + 1;
                points[n3] += n2;
                ++i;
                if (b != null) {
                    this.trianglesDirty = true;
                    return;
                }
                if (b != null) {
                    break;
                }
            }
            final float[] center = this.center;
            final int n4 = 1;
            center[n4] += n2;
            this.maxY += n2;
            this.minY += n2;
            continue;
        }
    }
    
    public float getY() {
        return this.y;
    }
    
    private void setLocation(final Class176 class176) {
        this.setX(class176.x);
        this.setY(class176.y);
    }
    
    public float getCenterX() {
        this.checkPoints();
        return this.center[0];
    }
    
    private void setCenterX(float n) {
        final int[] b = Class139.b();
        Class129 class129 = this;
        Label_0030: {
            Label_0027: {
                if (b == null) {
                    if (this.points != null) {
                        class129 = this;
                        if (b != null) {
                            break Label_0027;
                        }
                        if (this.center != null) {
                            break Label_0030;
                        }
                    }
                    class129 = this;
                }
            }
            class129.checkPoints();
        }
        n -= this.getCenterX();
        this.setX(this.x + n);
    }
    
    public float getCenterY() {
        this.checkPoints();
        return this.center[1];
    }
    
    private void setCenterY(float n) {
        final int[] b = Class139.b();
        Class129 class129 = this;
        Label_0030: {
            Label_0027: {
                if (b == null) {
                    if (this.points != null) {
                        class129 = this;
                        if (b != null) {
                            break Label_0027;
                        }
                        if (this.center != null) {
                            break Label_0030;
                        }
                    }
                    class129 = this;
                }
            }
            class129.checkPoints();
        }
        n -= this.getCenterY();
        this.setY(this.y + n);
    }
    
    public final float getMaxX() {
        this.checkPoints();
        return this.maxX;
    }
    
    public final float getMaxY() {
        this.checkPoints();
        return this.maxY;
    }
    
    public final float getMinX() {
        this.checkPoints();
        return this.minX;
    }
    
    public final float getMinY() {
        this.checkPoints();
        return this.minY;
    }
    
    private float getBoundingCircleRadius() {
        this.checkPoints();
        return this.boundingCircleRadius;
    }
    
    public final float[] getCenter() {
        this.checkPoints();
        return this.center;
    }
    
    public final float[] getPoints() {
        this.checkPoints();
        return this.points;
    }
    
    public final int getPointCount() {
        this.checkPoints();
        return this.points.length / 2;
    }
    
    public final float[] getPoint(final int n) {
        this.checkPoints();
        final float[] array;
        (array = new float[2])[0] = this.points[n * 2];
        array[1] = this.points[n * 2 + 1];
        return array;
    }
    
    private float[] getNormal(final int n) {
        final int[] b = Class139.b();
        final float[] point = this.getPoint(n);
        final int[] array = b;
        final int n2 = n - 1;
        if (array == null) {
            final int n3 = (n2 < 0) ? this.getPointCount() : n;
        }
        final float[] point2 = this.getPoint(n2 - 1);
        final int n4 = n + 1;
        final int pointCount = this.getPointCount();
        final float[] point3 = this.getPoint((array == null && lIIIIIIIlllII(n4, pointCount)) ? 0 : (n4 + pointCount));
        final float[] normal = getNormal(point2, point);
        final float[] normal2 = getNormal(point, point3);
        int n5 = n;
        int n6 = n;
        Label_0111: {
            if (array == null) {
                if (n == 0) {
                    final int n7 = n6 = (n5 = (this.closed() ? 1 : 0));
                    if (array != null) {
                        break Label_0111;
                    }
                    if (n7 == 0) {
                        return normal2;
                    }
                }
                n5 = n;
                n6 = n;
            }
        }
        Label_0134: {
            if (array == null) {
                if (n6 != this.getPointCount() - 1) {
                    break Label_0134;
                }
                n5 = (this.closed() ? 1 : 0);
            }
            if (n5 == 0) {
                return normal;
            }
        }
        final float n8 = (normal[0] + normal2[0]) / 2.0f;
        final float n9 = (normal[1] + normal2[1]) / 2.0f;
        final float n10 = n8;
        final float n11 = n10 * n10;
        final float n12 = n9;
        final float n13 = (float)Math.sqrt(n11 + n12 * n12);
        return new float[] { n8 / n13, n9 / n13 };
    }
    
    private boolean contains(final Class129 class129) {
        final int[] b = Class139.b();
        int intersects;
        final int n = intersects = (class129.intersects(this) ? 1 : 0);
        if (b == null) {
            if (n != 0) {
                return false;
            }
            intersects = 0;
        }
        int i = intersects;
        boolean contains = false;
        while (i < class129.getPointCount()) {
            final float[] point = class129.getPoint(i);
            if (b == null) {
                contains = this.contains(point[0], point[1]);
                if (b != null) {
                    return contains;
                }
                if (!contains) {
                    return false;
                }
                ++i;
            }
            if (b != null) {
                break;
            }
        }
        return contains;
    }
    
    private static float[] getNormal(final float[] array, final float[] array2) {
        final float n = array[0] - array2[0];
        final float n2 = array[1] - array2[1];
        final float n3 = n;
        final float n4 = n3 * n3;
        final float n5 = n2;
        final float n6 = (float)Math.sqrt(n4 + n5 * n5);
        return new float[] { -(n2 / n6), n / n6 };
    }
    
    private boolean includes(final float n, final float n2) {
        final int[] b = Class139.b();
        Class129 class129 = this;
        if (b == null) {
            if (this.points.length == 0) {
                return false;
            }
            class129 = this;
        }
        class129.checkPoints();
        final Class351 class130 = new Class351(0.0f, 0.0f, 0.0f, 0.0f);
        final Class176 class131 = new Class176(n, n2);
        int i = 0;
        while (i < this.points.length) {
            final boolean b2;
            boolean equals;
            int n4;
            final int n3 = n4 = ((equals = (b2 = (i + 2 != 0))) ? 1 : 0);
            if (b != null) {
                return b2;
            }
            Label_0160: {
                if (b == null) {
                    if (lIIIIIIIlllII(n3, this.points.length)) {
                        n4 = 0;
                    }
                    class130.set(this.points[i], this.points[i + 1], this.points[n4], this.points[n4 + 1]);
                    if (b != null) {
                        break Label_0160;
                    }
                    final Class351 class132 = class130;
                    final Class176 class133 = class131;
                    final Class351 class134 = class132;
                    class132.getClosestPoint(class133, class134.closest);
                    equals = class133.equals(class134.closest);
                }
                if (equals) {
                    return true;
                }
                i += 2;
            }
            if (b != null) {
                break;
            }
        }
        return false;
    }
    
    public final int indexOf(final float n, final float n2) {
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        while (i < this.points.length) {
            final int n5;
            float n4;
            final int n3 = (int)(n4 = (n5 = fcmpl(this.points[i], n)));
            if (array != null) {
                return n5;
            }
            Label_0061: {
                if (array == null) {
                    if (n3 != 0) {
                        break Label_0061;
                    }
                    final int n6;
                    n4 = (n6 = fcmpl(this.points[i + 1], n2));
                }
                if (array == null) {
                    if (n3 != 0) {
                        break Label_0061;
                    }
                    n4 = i / 2;
                }
                return (int)n4;
            }
            i += 2;
            if (array != null) {
                break;
            }
        }
        return -1;
    }
    
    public boolean contains(final float n, final float n2) {
        final int[] b = Class139.b();
        this.checkPoints();
        final int[] array = b;
        int length;
        final int n3 = length = this.points.length;
        if (array == null) {
            if (n3 == 0) {
                return false;
            }
            length = 0;
        }
        int n4 = length;
        final int length2 = this.points.length;
        float n5 = this.points[length2 - 2];
        float n6 = this.points[length2 - 1];
        int i = 0;
        while (i < length2) {
            final float n7 = this.points[i];
            final float n8 = this.points[i + 1];
            final float n9 = n7;
            float n12 = 0.0f;
            float n13 = 0.0f;
            float n14 = 0.0f;
            float n15 = 0.0f;
            Label_0145: {
                if (array == null) {
                    final float n11;
                    final float n10 = n11 = fcmpl(n9, n5);
                    if (array != null) {
                        return n11 != 0.0f;
                    }
                    if (n10 > 0) {
                        n12 = n5;
                        n13 = n7;
                        n14 = n6;
                        n15 = n8;
                        if (array == null) {
                            break Label_0145;
                        }
                    }
                }
                n12 = n9;
                n13 = n5;
                n14 = n8;
                n15 = n6;
            }
            final float n16 = fcmpg(n7, n);
            if (array == null && n16 >= 0) {}
            final float n17 = fcmpg(n, n5);
            if (array == null && n17 > 0) {}
            float n18 = 0.0f;
            Label_0260: {
                if (n16 == n17) {
                    n18 = n2;
                    if (array != null) {
                        break Label_0260;
                    }
                    if ((n2 - n14) * (n13 - n12) < (n15 - n14) * (n - n12)) {
                        final int n19 = n4;
                        if (array == null && n19) {}
                        n4 = n19;
                    }
                }
                n5 = n7;
                n18 = n8;
            }
            n6 = n18;
            i += 2;
            if (array != null) {
                break;
            }
        }
        float n11 = n4;
        return n11 != 0.0f;
    }
    
    public boolean intersects(final Class129 class129) {
        final int[] b = Class139.b();
        this.checkPoints();
        final int[] array = b;
        int n = 0;
        final float[] points = this.getPoints();
        final float[] points2 = class129.getPoints();
        int length = points.length;
        int length2 = points2.length;
        int closed;
        final int n2 = closed = (this.closed() ? 1 : 0);
        if (array == null) {
            if (n2 == 0) {
                length -= 2;
            }
            final boolean closed2;
            closed = ((closed2 = class129.closed()) ? 1 : 0);
        }
        if (array == null) {
            if (n2 == 0) {
                length2 -= 2;
            }
            closed = 0;
        }
        int n3 = closed;
        do {
            int i = 0;
            Label_0062: {
                i = n3;
            }
            int length3 = 0;
            Label_0065:
            while (i < length3) {
                final boolean b2;
                int n6;
                int n5;
                final int n4 = n5 = (n6 = ((b2 = (n3 + 2 != 0)) ? 1 : 0));
                if (array != null) {
                    return b2;
                }
                if (array == null) {
                    if (lIIIIIIIlllII(n4, points.length)) {
                        n5 = 0;
                    }
                    n6 = 0;
                }
                int j = n6;
                while (j < length2) {
                    int n9;
                    int n8;
                    final int n7 = n8 = (i = (n9 = j + 2));
                    Label_0133: {
                        if (array == null) {
                            length3 = points2.length;
                            if (array != null) {
                                continue Label_0065;
                            }
                            if (!lIIIIIIIlllII(n7, length3)) {
                                break Label_0133;
                            }
                            n9 = 0;
                        }
                        n8 = n9;
                    }
                    final double n10 = ((points[n5] - points[n3]) * (points2[j + 1] - points[n3 + 1]) - (points[n5 + 1] - points[n3 + 1]) * (points2[j] - points[n3])) / ((points[n5 + 1] - points[n3 + 1]) * (points2[n8] - points2[j]) - (points[n5] - points[n3]) * (points2[n8 + 1] - points2[j + 1]));
                    final double n11 = ((points2[n8] - points2[j]) * (points2[j + 1] - points[n3 + 1]) - (points2[n8 + 1] - points2[j + 1]) * (points2[j] - points[n3])) / ((points[n5 + 1] - points[n3 + 1]) * (points2[n8] - points2[j]) - (points[n5] - points[n3]) * (points2[n8 + 1] - points2[j + 1]));
                    if (array == null) {
                        Label_0439: {
                            if (n10 >= 0.0) {
                                double n14;
                                double n13;
                                final double n12 = n13 = (n14 = dcmpg(n10, 1.0));
                                if (array == null) {
                                    if (n12 > 0) {
                                        break Label_0439;
                                    }
                                    final double n15;
                                    n13 = (n15 = (n14 = dcmpl(n11, 0.0)));
                                }
                                if (array == null) {
                                    if (n12 < 0) {
                                        break Label_0439;
                                    }
                                    n14 = (n13 = dcmpg(n11, 1.0));
                                }
                                if (array == null) {
                                    if (n13 > 0) {
                                        break Label_0439;
                                    }
                                    n14 = 1;
                                }
                                n = (int)n14;
                                if (array == null) {
                                    break;
                                }
                            }
                        }
                        j += 2;
                    }
                    if (array != null) {
                        break;
                    }
                }
                if (n == 0 || array != null) {
                    n3 += 2;
                    continue Label_0062;
                }
                break;
            }
            break;
        } while (array == null);
        return n != 0;
    }
    
    public final boolean hasVertex(final float n, final float n2) {
        final int[] b = Class139.b();
        final int length = this.points.length;
        if (b == null) {
            if (length == 0) {
                return false;
            }
            this.checkPoints();
        }
        int i = length;
        while (i < this.points.length) {
            final boolean b3;
            float n3;
            final boolean b2 = (n3 = ((b3 = fcmpl(this.points[i], n)) ? 1 : 0)) != 0.0f;
            if (b != null) {
                return b3;
            }
            Label_0075: {
                if (b == null) {
                    if (b2) {
                        break Label_0075;
                    }
                    final int n4;
                    n3 = (n4 = fcmpl(this.points[i + 1], n2));
                }
                if (b == null) {
                    if (b2) {
                        break Label_0075;
                    }
                    n3 = 1;
                }
                return n3 != 0.0f;
            }
            i += 2;
            if (b != null) {
                break;
            }
        }
        return false;
    }
    
    protected void findCenter() {
        final int[] b = Class139.b();
        this.center = new float[] { 0.0f, 0.0f };
        final int[] array = b;
        final int length = this.points.length;
        int i = 0;
        while (i < length) {
            final float[] center = this.center;
            final int n = 0;
            center[n] += this.points[i];
            final float[] center2 = this.center;
            final int n2 = 1;
            center2[n2] += this.points[i + 1];
            i += 2;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        final float[] center3 = this.center;
        final int n3 = 0;
        center3[n3] /= length / 2;
        final float[] center4 = this.center;
        final int n4 = 1;
        center4[n4] /= length / 2;
    }
    
    protected void calculateRadius() {
        final int[] b = Class139.b();
        this.boundingCircleRadius = 0.0f;
        int i = 0;
        final int[] array = b;
        while (true) {
            while (i < this.points.length) {
                final float n = (this.points[i] - this.center[0]) * (this.points[i] - this.center[0]) + (this.points[i + 1] - this.center[1]) * (this.points[i + 1] - this.center[1]);
                final Class129 class129 = this;
                final float boundingCircleRadius2;
                final float boundingCircleRadius = boundingCircleRadius2 = this.boundingCircleRadius;
                if (array != null) {
                    class129.boundingCircleRadius = boundingCircleRadius2;
                    return;
                }
                if (array == null) {
                    if (boundingCircleRadius > n) {
                        final float boundingCircleRadius3 = this.boundingCircleRadius;
                    }
                }
                this.boundingCircleRadius = boundingCircleRadius;
                i += 2;
                if (array != null) {
                    break;
                }
            }
            final Class129 class129 = this;
            float boundingCircleRadius2 = (float)Math.sqrt(this.boundingCircleRadius);
            continue;
        }
    }
    
    private void calculateTriangles() {
        final int[] b = Class139.b();
        final int trianglesDirty = this.trianglesDirty ? 1 : 0;
        Class129 class129 = null;
        Label_0111: {
            if (b == null) {
                Class129 class130 = null;
                Label_0028: {
                    if (trianglesDirty == 0) {
                        class129 = this;
                        class130 = this;
                        if (b != null) {
                            break Label_0028;
                        }
                        if (this.tris != null) {
                            return;
                        }
                    }
                    class129 = this;
                    class130 = this;
                }
                if (b != null) {
                    break Label_0111;
                }
                final int length = class130.points.length;
            }
            if (lIIIIIIIlllII(trianglesDirty, 6)) {
                this.tris = new Class11();
                int i = 0;
                while (i < this.points.length) {
                    this.tris.addPolyPoint(this.points[i], this.points[i + 1]);
                    i += 2;
                    if (b != null) {
                        return;
                    }
                    if (b != null) {
                        break;
                    }
                }
                this.tris.triangulate();
            }
            class129 = this;
        }
        class129.trianglesDirty = false;
    }
    
    private void increaseTriangulation() {
        this.checkPoints();
        this.calculateTriangles();
        this.tris = new Class164(this.tris);
    }
    
    public final Class124 getTriangles() {
        this.checkPoints();
        this.calculateTriangles();
        return this.tris;
    }
    
    protected final void checkPoints() {
        final int[] b = Class139.b();
        final int pointsDirty = this.pointsDirty ? 1 : 0;
        Class129 class129 = null;
        Label_0202: {
            if (b == null) {
                if (pointsDirty == 0) {
                    return;
                }
                this.createPoints();
                this.findCenter();
                this.calculateRadius();
                class129 = this;
                if (b != null) {
                    break Label_0202;
                }
                final int length = this.points.length;
            }
            Label_0201: {
                if (pointsDirty > 0) {
                    this.maxX = this.points[0];
                    this.maxY = this.points[1];
                    this.minX = this.points[0];
                    this.minY = this.points[1];
                    int i = 0;
                    while (i < this.points.length / 2) {
                        this.maxX = Math.max(this.points[i * 2], this.maxX);
                        this.maxY = Math.max(this.points[i * 2 + 1], this.maxY);
                        this.minX = Math.min(this.points[i * 2], this.minX);
                        this.minY = Math.min(this.points[i * 2 + 1], this.minY);
                        ++i;
                        if (b != null) {
                            break Label_0201;
                        }
                        if (b != null) {
                            break;
                        }
                    }
                }
                this.pointsDirty = false;
            }
            class129 = this;
        }
        class129.trianglesDirty = true;
    }
    
    private void preCache() {
        this.checkPoints();
        this.getTriangles();
    }
    
    public boolean closed() {
        return true;
    }
    
    private Class129 prune() {
        final int[] b = Class139.b();
        final Class140 class140 = new Class140();
        final int[] array = b;
        int i = 0;
        while (i < this.getPointCount()) {
            final int n = i + 1;
            final int pointCount = this.getPointCount();
            final int n2 = (array == null && lIIIIIIIlllII(n, pointCount)) ? 0 : (n + pointCount);
            final int n3 = i - 1;
            if (array == null) {
                final int n4 = (n3 < 0) ? this.getPointCount() : i;
            }
            final int n5 = n3 - 1;
            final float n6 = this.getPoint(i)[0] - this.getPoint(n5)[0];
            final float n7 = this.getPoint(i)[1] - this.getPoint(n5)[1];
            final float n8 = this.getPoint(n2)[0] - this.getPoint(i)[0];
            final float n9 = this.getPoint(n2)[1] - this.getPoint(i)[1];
            final float n10 = n6;
            final float n11 = n10 * n10;
            final float n12 = n7;
            final float n13 = (float)Math.sqrt(n11 + n12 * n12);
            final float n14 = n8;
            final float n15 = n14 * n14;
            final float n16 = n9;
            final float n17 = (float)Math.sqrt(n15 + n16 * n16);
            final float n18 = n6 / n13;
            final float n19 = n7 / n13;
            final float n20 = n8 / n17;
            final float n21 = n9 / n17;
            final float n22 = fcmpl(n18, n20);
            Label_0248: {
                Label_0230: {
                    if (array == null) {
                        if (n22 != 0) {
                            break Label_0230;
                        }
                        final float n23 = fcmpl(n19, n21);
                    }
                    if (n22 == 0) {
                        break Label_0248;
                    }
                }
                class140.addPoint(this.getPoint(i)[0], this.getPoint(i)[1]);
            }
            ++i;
            if (array != null) {
                break;
            }
        }
        return class140;
    }
    
    private Class129[] subtract(final Class129 class129) {
        final Class111 class130 = new Class111();
        final Class129 transform = this.transform(new Class24());
        final int[] b = Class139.b();
        final Class129 transform2 = class129.transform(new Class24());
        int n = 0;
        int i = 0;
        final int[] array = b;
        while (true) {
            while (i < transform.getPointCount()) {
                int contains;
                int intersects;
                final int n3;
                final int n2 = n3 = (intersects = (contains = (transform2.contains(transform.getPoint(i)[0], transform.getPoint(i)[1]) ? 1 : 0)));
                if (array != null) {
                    if (array == null) {
                        if (n3 == transform.getPointCount()) {
                            return new Class129[0];
                        }
                        contains = (intersects = (transform.intersects(transform2) ? 1 : 0));
                    }
                    if (array == null) {
                        if (intersects == 0) {
                            return new Class129[] { transform };
                        }
                        i = 0;
                        contains = 0;
                    }
                    int j = contains;
                    while (true) {
                        while (j < transform2.getPointCount()) {
                            final int contains2;
                            final int n4 = contains2 = (transform.contains(transform2.getPoint(j)[0], transform2.getPoint(j)[1]) ? 1 : 0);
                            if (array != null) {
                                int k = contains2;
                                while (true) {
                                    while (k < transform.getPointCount()) {
                                        int contains3;
                                        final int n6;
                                        final int n5 = n6 = (contains3 = (transform2.contains(transform.getPoint(k)[0], transform.getPoint(k)[1]) ? 1 : 0));
                                        if (array != null) {
                                            if (array == null) {
                                                if (n6 > 0) {
                                                    return class130.combine(transform, transform2, true);
                                                }
                                                contains3 = 1;
                                            }
                                            final Class129[] array2 = new Class129[contains3];
                                            array2[0] = transform;
                                            return array2;
                                        }
                                        Label_0291: {
                                            if (array == null) {
                                                if (n5 == 0) {
                                                    break Label_0291;
                                                }
                                                class130.onPath(transform2, transform.getPoint(k)[0], transform.getPoint(k)[1]);
                                            }
                                            if (n5 == 0) {
                                                ++i;
                                            }
                                        }
                                        ++k;
                                        if (array != null) {
                                            break;
                                        }
                                    }
                                    int n6;
                                    int contains3 = n6 = i;
                                    continue;
                                }
                            }
                            Label_0211: {
                                if (array == null) {
                                    if (n4 == 0) {
                                        break Label_0211;
                                    }
                                    class130.onPath(transform, transform2.getPoint(j)[0], transform2.getPoint(j)[1]);
                                }
                                if (n4 == 0) {
                                    ++i;
                                }
                            }
                            ++j;
                            if (array != null) {
                                break;
                            }
                        }
                        int contains2 = 0;
                        continue;
                    }
                }
                if (n2 != 0) {
                    ++n;
                }
                ++i;
                if (array != null) {
                    break;
                }
            }
            int contains;
            int n3;
            int intersects = n3 = (contains = n);
            continue;
        }
    }
    
    private Class129[] union(final Class129 class129) {
        final Class111 class130 = new Class111();
        final int[] b = Class139.b();
        final Class129 transform = this.transform(new Class24());
        final Class129 transform2 = class129.transform(new Class24());
        final int[] array = b;
        final int intersects = transform.intersects(transform2) ? 1 : 0;
        if (array == null && intersects == 0) {
            return new Class129[] { transform, transform2 };
        }
        int n = intersects;
        int n2 = 0;
        int i = 0;
        while (true) {
            while (i < transform.getPointCount()) {
                final int contains;
                final int n3 = contains = (transform2.contains(transform.getPoint(i)[0], transform.getPoint(i)[1]) ? 1 : 0);
                if (array != null) {
                    int j = contains;
                    while (true) {
                        while (j < transform2.getPointCount()) {
                            int contains2;
                            int n7;
                            final int n6;
                            int n5;
                            final int n4 = n5 = (n6 = (n7 = (contains2 = (transform.contains(transform2.getPoint(j)[0], transform2.getPoint(j)[1]) ? 1 : 0))));
                            if (array != null) {
                                if (array == null) {
                                    if (n6 != 0) {
                                        return class130.combine(transform, transform2, false);
                                    }
                                    contains2 = (n7 = n2);
                                }
                                if (array == null) {
                                    if (n7 >= 2) {
                                        return class130.combine(transform, transform2, false);
                                    }
                                    contains2 = 2;
                                }
                                final Class129[] array2 = new Class129[contains2];
                                array2[0] = transform;
                                array2[1] = transform2;
                                return array2;
                            }
                            Label_0270: {
                                if (array == null) {
                                    if (n4 == 0) {
                                        break Label_0270;
                                    }
                                    final boolean hasVertex;
                                    n5 = ((hasVertex = transform.hasVertex(transform2.getPoint(j)[0], transform2.getPoint(j)[1])) ? 1 : 0);
                                }
                                if (array == null) {
                                    if (n4 != 0) {
                                        break Label_0270;
                                    }
                                    n5 = 1;
                                }
                                n = n5;
                                if (array == null) {
                                    break;
                                }
                            }
                            ++j;
                            if (array != null) {
                                break;
                            }
                        }
                        int contains2;
                        int n6;
                        int n7 = n6 = (contains2 = n);
                        continue;
                    }
                }
                Label_0175: {
                    if (array == null) {
                        if (n3 != 0) {
                            final boolean hasVertex2 = transform2.hasVertex(transform.getPoint(i)[0], transform.getPoint(i)[1]);
                            if (array != null) {
                                break Label_0175;
                            }
                            if (!hasVertex2) {
                                n = 1;
                                if (array == null) {
                                    break;
                                }
                            }
                        }
                        transform2.hasVertex(transform.getPoint(i)[0], transform.getPoint(i)[1]);
                    }
                }
                if (n3 != 0) {
                    ++n2;
                }
                ++i;
                if (array != null) {
                    break;
                }
            }
            int contains = 0;
            continue;
        }
    }
    
    public float getWidth() {
        return this.maxX - this.minX;
    }
    
    public float getHeight() {
        return this.maxY - this.minY;
    }
    
    static {
        Class169.a(1704995514704258401L, 1882465376780939398L, MethodHandles.lookup().lookupClass()).a(93779973886288L);
    }
    
    private static RuntimeException b(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIIIIIIIlllII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIIIIIlIIlll(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIIIIIIllIll(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIIIIlIIlII(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIIIIIlIIIll(final int n) {
        return n > 0;
    }
    
    private static int lIIIIIIIlIlII(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIIIIIllIIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIIIIIlllll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIIIIlIIIII(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIIIIlIIIIl(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIIIIIIlIIIlI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIIIIIIlIIlIl$25399e8(final double n) {
        return dcmpl(n, 0.0);
    }
    
    private static int lIIIIIIlIIllI$25399e8(final double n) {
        return dcmpg(n, 1.0);
    }
    
    private static int lIIIIIIlIlIII(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIIIIlIlIIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIIIIlIlIlI$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIIIIIIlIlIll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
}
