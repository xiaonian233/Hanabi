package ClassSub;

import java.util.*;
import java.lang.invoke.*;

public final class Class111
{
    private float EPSILON;
    private float EDGE_SCALE;
    private int MAX_POINTS;
    private Class213 listener;
    private static final long a;
    
    public Class111() {
        super();
        this.EPSILON = 1.0E-4f;
        this.EDGE_SCALE = 1.0f;
        this.MAX_POINTS = 10000;
    }
    
    private Class129[] subtract(Class129 transform, Class129 transform2) {
        transform = transform.transform(new Class24());
        final int[] b = Class139.b();
        transform2 = transform2.transform(new Class24());
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
                                                    return this.combine(transform, transform2, true);
                                                }
                                                contains3 = 1;
                                            }
                                            final Class129[] array2 = new Class129[contains3];
                                            array2[0] = transform;
                                            return array2;
                                        }
                                        Label_0269: {
                                            if (array == null) {
                                                if (n5 == 0) {
                                                    break Label_0269;
                                                }
                                                this.onPath(transform2, transform.getPoint(k)[0], transform.getPoint(k)[1]);
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
                            Label_0192: {
                                if (array == null) {
                                    if (n4 == 0) {
                                        break Label_0192;
                                    }
                                    this.onPath(transform, transform2.getPoint(j)[0], transform2.getPoint(j)[1]);
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
    
    final boolean onPath(final Class129 class129, final float n, final float n2) {
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        float n3 = 0.0f;
        while (i < class129.getPointCount() + 1) {
            final Class351 line = getLine(class129, rationalPoint(class129, i), rationalPoint(class129, i + 1));
            if (array == null) {
                n3 = fcmpg(line.distance(new Class176(n, n2)), this.EPSILON * 100.0f);
                if (array != null) {
                    return n3 != 0.0f;
                }
                if (n3 < 0) {
                    return true;
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
        return n3 != 0.0f;
    }
    
    private static void setListener$40622129() {
    }
    
    private Class129[] union(Class129 transform, Class129 transform2) {
        final int[] b = Class139.b();
        transform = transform.transform(new Class24());
        transform2 = transform2.transform(new Class24());
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
                                        return this.combine(transform, transform2, false);
                                    }
                                    contains2 = (n7 = n2);
                                }
                                if (array == null) {
                                    if (n7 >= 2) {
                                        return this.combine(transform, transform2, false);
                                    }
                                    contains2 = 2;
                                }
                                final Class129[] array2 = new Class129[contains2];
                                array2[0] = transform;
                                array2[1] = transform2;
                                return array2;
                            }
                            Label_0247: {
                                if (array == null) {
                                    if (n4 == 0) {
                                        break Label_0247;
                                    }
                                    final boolean hasVertex;
                                    n5 = ((hasVertex = transform.hasVertex(transform2.getPoint(j)[0], transform2.getPoint(j)[1])) ? 1 : 0);
                                }
                                if (array == null) {
                                    if (n4 != 0) {
                                        break Label_0247;
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
                Label_0157: {
                    if (array == null) {
                        if (n3 != 0) {
                            final boolean hasVertex2 = transform2.hasVertex(transform.getPoint(i)[0], transform.getPoint(i)[1]);
                            if (array != null) {
                                break Label_0157;
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
    
    final Class129[] combine(final Class129 class129, final Class129 class130, final boolean b) {
        final int[] b2 = Class139.b();
        int n = b ? 1 : 0;
        if (b2 == null) {
            if (b) {
                final ArrayList<Class129> list = new ArrayList<Class129>();
                final ArrayList<Class129> list2 = new ArrayList<Class129>();
                int i = 0;
                while (true) {
                    while (i < class129.getPointCount()) {
                        final float[] point = class129.getPoint(i);
                        Label_0105: {
                            if (b2 == null) {
                                final int contains;
                                final int n2 = contains = (class130.contains(point[0], point[1]) ? 1 : 0);
                                if (b2 != null) {
                                    int j = contains;
                                    while (j < class129.getPointCount()) {
                                        final float[] point2 = class129.getPoint(j);
                                        final Class176 class131 = new Class176(point2[0], point2[1]);
                                        Label_0248: {
                                            if (b2 == null) {
                                                final ArrayList<Class129> list4;
                                                final ArrayList<Class129> list3 = list4 = list2;
                                                if (b2 != null) {
                                                    return list4.toArray(new Class129[0]);
                                                }
                                                if (!list3.contains(class131)) {
                                                    final Class129 combineSingle = this.combineSingle(class129, class130, true, j);
                                                    list.add(combineSingle);
                                                    int k = 0;
                                                    while (k < combineSingle.getPointCount()) {
                                                        final float[] point3 = combineSingle.getPoint(k);
                                                        list2.add((Class129)new Class176(point3[0], point3[1]));
                                                        ++k;
                                                        if (b2 != null) {
                                                            break Label_0248;
                                                        }
                                                        if (b2 != null) {
                                                            break;
                                                        }
                                                    }
                                                }
                                                ++j;
                                            }
                                        }
                                        if (b2 != null) {
                                            break;
                                        }
                                    }
                                    ArrayList<Class129> list4 = list;
                                    return list4.toArray(new Class129[0]);
                                }
                                if (n2 != 0) {
                                    list2.add((Class129)new Class176(point[0], point[1]));
                                    if (b2 != null) {
                                        break Label_0105;
                                    }
                                }
                                ++i;
                            }
                        }
                        if (b2 != null) {
                            break;
                        }
                    }
                    int contains = 0;
                    continue;
                }
            }
            n = 0;
        }
        int l = n;
        while (true) {
            while (l < class129.getPointCount()) {
                final int contains2;
                final int n3 = contains2 = (class130.contains(class129.getPoint(l)[0], class129.getPoint(l)[1]) ? 1 : 0);
                if (b2 == null) {
                    Label_0352: {
                        if (b2 == null) {
                            if (n3 != 0) {
                                break Label_0352;
                            }
                            final Class129 combineSingle2 = class130;
                            if (b2 != null) {
                                return new Class129[] { combineSingle2 };
                            }
                            class130.hasVertex(class129.getPoint(l)[0], class129.getPoint(l)[1]);
                        }
                        if (n3 == 0) {
                            final Class129 combineSingle2 = this.combineSingle(class129, class130, false, l);
                            return new Class129[] { combineSingle2 };
                        }
                    }
                    ++l;
                    if (b2 != null) {
                        break;
                    }
                    continue;
                }
                final Class129[] array = new Class129[contains2];
                array[0] = class130;
                return array;
            }
            int contains2 = 1;
            continue;
        }
    }
    
    private Class129 combineSingle(final Class129 class129, final Class129 class130, final boolean b, final int n) {
        Class129 class131 = class129;
        final int[] b2 = Class139.b();
        Class129 class132 = class130;
        int n2 = n;
        final int[] array = b2;
        int n3 = 1;
        final Class140 class133 = new Class140();
        int n4 = 1;
        int n5 = 0;
        float n6 = class131.getPoint(n2)[0];
        float n7 = class131.getPoint(n2)[1];
        while (true) {
            Label_0138: {
                final int n8;
                Label_0109: {
                    if (class133.hasVertex(n6, n7)) {
                        n8 = n4;
                        if (array != null || array != null) {
                            break Label_0109;
                        }
                        if (n8 == 0 && class131 == class129) {
                            break;
                        }
                    }
                    n4 = 0;
                    ++n5;
                    if (array != null) {
                        break Label_0138;
                    }
                }
                if (n8 > this.MAX_POINTS && array == null) {
                    break;
                }
                class133.addPoint(n6, n7);
            }
            final Class129 class134 = class131;
            final float n9 = n6;
            final float n10 = n7;
            final int rationalPoint = rationalPoint(class131, n2 + n3);
            final float n11 = n10;
            final float n12 = n9;
            final float[] point = class134.getPoint(rationalPoint);
            final Class351 class135 = new Class351(n12, n11, point[0], point[1]);
            final Class129 class136 = class132;
            final Class351 class137 = class135;
            final Class129 class138 = class136;
            final int[] b3 = Class139.b();
            float n13 = Float.MAX_VALUE;
            Class108 class139 = null;
            int i = 0;
            final int[] array2 = b3;
            while (i < class138.getPointCount()) {
                final int rationalPoint2 = rationalPoint(class138, i + 1);
                final Class351 line = getLine(class138, i, rationalPoint2);
                final Class176 intersect = class137.intersect(line, true);
                Label_0407: {
                    if (array2 == null) {
                        Label_0404: {
                            if (intersect != null) {
                                final Class176 class140 = intersect;
                                final Class176 start = class137.start;
                                final Class176 class141 = class140;
                                final float n14 = start.x - class141.x;
                                final float n15 = start.y - class141.y;
                                final float n16 = n14;
                                final float n17 = n16 * n16;
                                final float n18 = n15;
                                final float n19 = (float)Math.sqrt(n17 + n18 * n18);
                                if (array2 != null) {
                                    break Label_0407;
                                }
                                if (n19 < n13) {
                                    final float n20 = n19;
                                    if (array2 == null) {
                                        if (n20 <= this.EPSILON) {
                                            break Label_0404;
                                        }
                                        (class139 = new Class108()).pt = intersect;
                                        class139.line = line;
                                        class139.p1 = i;
                                        class139.p2 = rationalPoint2;
                                    }
                                    n13 = n20;
                                }
                            }
                        }
                        ++i;
                    }
                }
                if (array2 != null) {
                    break;
                }
            }
            final Class108 class142 = class139;
            Label_0956: {
                if (array == null) {
                    if (class142 != null) {
                        final Class351 line2 = class142.line;
                        final Class176 pt;
                        n6 = (pt = class142.pt).x;
                        n7 = pt.y;
                        final int hasVertex = class132.hasVertex(n6, n7) ? 1 : 0;
                        Label_0521: {
                            if (array == null) {
                                if (hasVertex == 0) {
                                    break Label_0521;
                                }
                                n2 = class132.indexOf(pt.x, pt.y);
                            }
                            n3 = hasVertex;
                            n6 = pt.x;
                            n7 = pt.y;
                            final Class129 class143 = class131;
                            class131 = class132;
                            class132 = class143;
                            if (array == null) {
                                continue;
                            }
                        }
                        final Class351 class144 = line2;
                        final float n21 = (class144.end.x - class144.start.x) / line2.vec.length();
                        final Class351 class145 = line2;
                        final float n22 = (class145.end.y - class145.start.y) / line2.vec.length();
                        final float n23 = n21 * this.EDGE_SCALE;
                        final float n24 = n22 * this.EDGE_SCALE;
                        int n27;
                        int n26;
                        final int n25 = n26 = (n27 = (class131.contains(pt.x + n23, pt.y + n24) ? 1 : 0));
                        Label_0917: {
                            if (array == null) {
                                if (n25 != 0) {
                                    Label_0707: {
                                        if (b) {
                                            if (llIIlllIlII(class131, class130)) {
                                                n2 = class142.p2;
                                                n3 = -1;
                                                if (array == null) {
                                                    break Label_0707;
                                                }
                                            }
                                            n2 = class142.p1;
                                            n3 = 1;
                                            if (array == null) {
                                                break Label_0707;
                                            }
                                        }
                                        if (llIIlllIlII(class131, class129)) {
                                            n2 = class142.p2;
                                            n3 = -1;
                                            if (array == null) {
                                                break Label_0707;
                                            }
                                        }
                                        n2 = class142.p2;
                                        n3 = -1;
                                    }
                                    final Class129 class146 = class131;
                                    class131 = class132;
                                    class132 = class146;
                                    if (array == null) {
                                        break Label_0917;
                                    }
                                }
                                final int n28;
                                n26 = (n28 = (n27 = (class131.contains(pt.x - n23, pt.y - n24) ? 1 : 0)));
                            }
                            if (array == null) {
                                if (n25 != 0) {
                                    Label_0830: {
                                        if (b) {
                                            if (llIIlllIlII(class131, class129)) {
                                                n2 = class142.p2;
                                                n3 = -1;
                                                if (array == null) {
                                                    break Label_0830;
                                                }
                                            }
                                            n2 = class142.p1;
                                            n3 = 1;
                                            if (array == null) {
                                                break Label_0830;
                                            }
                                        }
                                        if (llIIlllIlII(class131, class130)) {
                                            n2 = class142.p1;
                                            n3 = 1;
                                            if (array == null) {
                                                break Label_0830;
                                            }
                                        }
                                        n2 = class142.p1;
                                        n3 = 1;
                                    }
                                    final Class129 class147 = class131;
                                    class131 = class132;
                                    class132 = class147;
                                    if (array == null) {
                                        break Label_0917;
                                    }
                                }
                                n27 = (b ? 1 : 0);
                                n26 = (b ? 1 : 0);
                            }
                            if (array == null) {
                                if (n26 != 0 && array == null) {
                                    break;
                                }
                                n2 = class142.p1;
                                n27 = 1;
                            }
                            n3 = n27;
                            final Class129 class148 = class131;
                            class131 = class132;
                            class132 = class148;
                            n2 = rationalPoint(class131, n2 + n3);
                            n6 = class131.getPoint(n2)[0];
                            n7 = class131.getPoint(n2)[1];
                        }
                        if (array == null) {
                            break Label_0956;
                        }
                    }
                    n2 = rationalPoint(class131, n2 + n3);
                    n6 = class131.getPoint(n2)[0];
                }
                n7 = class131.getPoint(n2)[1];
            }
            if (array != null) {
                break;
            }
        }
        final Class140 class149 = class133;
        if (array == null) {
            class149.addPoint(n6, n7);
        }
        return class149;
    }
    
    private Class108 intersect(final Class129 class129, final Class351 class130) {
        final int[] b = Class139.b();
        float n = Float.MAX_VALUE;
        Class108 class131 = null;
        int i = 0;
        final int[] array = b;
        while (i < class129.getPointCount()) {
            final int rationalPoint = rationalPoint(class129, i + 1);
            final Class351 line = getLine(class129, i, rationalPoint);
            final Class176 intersect = class130.intersect(line, true);
            Label_0198: {
                if (array == null) {
                    Label_0195: {
                        if (intersect != null) {
                            final Class176 class132 = intersect;
                            final Class176 start = class130.start;
                            final Class176 class133 = class132;
                            final float n2 = start.x - class133.x;
                            final float n3 = start.y - class133.y;
                            final float n4 = n2;
                            final float n5 = n4 * n4;
                            final float n6 = n3;
                            final float n7 = (float)Math.sqrt(n5 + n6 * n6);
                            if (array != null) {
                                break Label_0198;
                            }
                            if (n7 < n) {
                                final float n8 = n7;
                                if (array == null) {
                                    if (n8 <= this.EPSILON) {
                                        break Label_0195;
                                    }
                                    (class131 = new Class108()).pt = intersect;
                                    class131.line = line;
                                    class131.p1 = i;
                                    class131.p2 = rationalPoint;
                                }
                                n = n8;
                            }
                        }
                    }
                    ++i;
                }
            }
            if (array != null) {
                break;
            }
        }
        return class131;
    }
    
    private static int rationalPoint(final Class129 class129, int i) {
        final int[] b = Class139.b();
        int n = 0;
        while (i < 0) {
            i += class129.getPointCount();
            if (b != null) {
                return n;
            }
            if (b != null) {
                break;
            }
        }
        while (i >= class129.getPointCount()) {
            n = i - class129.getPointCount();
            if (b != null) {
                break;
            }
            i = n;
            if (b != null) {
                break;
            }
        }
        return n;
    }
    
    private static Class351 getLine(final Class129 class129, final int n, final int n2) {
        final float[] point = class129.getPoint(n);
        final float[] point2 = class129.getPoint(n2);
        return new Class351(point[0], point[1], point2[0], point2[1]);
    }
    
    private static Class351 getLine(final Class129 class129, final float n, final float n2, final int n3) {
        final float[] point = class129.getPoint(n3);
        return new Class351(n, n2, point[0], point[1]);
    }
    
    static {
        Class169.a(1915580277767303127L, 1008763818036512010L, MethodHandles.lookup().lookupClass()).a(214419610274007L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean llIIllllIII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean llIIlllIIll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean llIIlllIIlI(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean llIIlllIlII(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean llIIlllIIIl(final int n) {
        return n < 0;
    }
    
    private static boolean llIIlllIlll(final int n) {
        return n > 0;
    }
    
    private static int llIIllIllll(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int llIIlllIllI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int llIIlllIlIl(final float n, final float n2) {
        return fcmpg(n, n2);
    }
}
