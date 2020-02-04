package ClassSub;

import java.util.*;
import java.lang.reflect.*;
import java.lang.invoke.*;

public final class Class231 implements Class124
{
    private static final double EPSILON = 1.0E-5;
    private Class240 contour;
    private Class240 holes;
    private Class240 nextFreePointBag;
    private Class328 nextFreePoint;
    private List triangles;
    private static final long a;
    
    public Class231() {
        super();
        this.triangles = new ArrayList();
        this.contour = this.getPointBag();
    }
    
    @Override
    public final void addPolyPoint(final float n, final float n2) {
        final Class176 class176 = new Class176(n, n2);
        final int[] b = Class139.b();
        Class231 class177 = this;
        if (b == null) {
            if (this.holes == null) {
                this.contour.add(this.getPoint(class176));
                if (b == null) {
                    return;
                }
            }
            class177 = this;
        }
        this.holes.add(class177.getPoint(class176));
    }
    
    private void reset() {
        final int[] b = Class139.b();
        while (this.holes != null) {
            this.holes = this.freePointBag(this.holes);
            if (b != null) {
                return;
            }
            if (b != null) {
                break;
            }
        }
        this.contour.clear();
        this.holes = null;
    }
    
    @Override
    public final void startHole() {
        final Class240 pointBag;
        (pointBag = this.getPointBag()).next = this.holes;
        this.holes = pointBag;
    }
    
    private void addPoint(final Class176 class176) {
        final int[] b = Class139.b();
        Class231 class177 = this;
        if (b == null) {
            if (this.holes == null) {
                this.contour.add(this.getPoint(class176));
                if (b == null) {
                    return;
                }
            }
            class177 = this;
        }
        this.holes.add(class177.getPoint(class176));
    }
    
    private Class176[] triangulate(Class176[] array) {
        this.contour.computeAngles();
        final int[] b = Class139.b();
        Class240 class240 = this.holes;
        final int[] array2 = b;
    Label_0328_Outer:
        while (true) {
        Label_0328:
            while (true) {
                while (class240 != null) {
                    class240.computeAngles();
                    class240 = class240.next;
                    if (array2 == null) {
                        if (array2 != null) {
                            break;
                        }
                        continue Label_0328_Outer;
                    }
                    else {
                        final Class240 contour = this.contour;
                        final Class240 holes;
                        final int n = (holes.countPoints() - 2) * 3 + 1;
                        final int n2 = 0;
                        if (array2 == null && n2 < n) {
                            array = (Class176[])Array.newInstance(array.getClass().getComponentType(), n);
                            goto Label_0367;
                        }
                        int n3 = n2;
                        do {
                            Class328 class241;
                            if ((class241 = this.contour.first) == null) {
                                if (array2 != null) {
                                    goto Label_0415;
                                }
                                if (array2 == null) {
                                    break;
                                }
                            }
                            final Class328 next = class241.next;
                            if (array2 == null && (lIlllIIllII(next, class241.prev) && array2 == null)) {
                                break;
                            }
                            while (true) {
                                Label_0572: {
                                    final Class328 class245;
                                    final Class328 class246;
                                    Label_0566: {
                                        Label_0551: {
                                            if (next.angle <= 0.0) {
                                                break Label_0551;
                                            }
                                            final Class328 first = class241.prev;
                                            final Class328 class242 = class241.next;
                                            final Class328 next2;
                                            final Class328 class243 = next2 = class242.next;
                                            final Class328 first2;
                                            final Class328 class244 = first2 = first;
                                            if (array2 != null || class243 != class244) {
                                                if (array2 != null) {
                                                    break Label_0566;
                                                }
                                                if (!class243.isInfront(class244)) {
                                                    break Label_0551;
                                                }
                                                class245 = class242;
                                                class246 = first;
                                                if (array2 != null) {
                                                    break Label_0566;
                                                }
                                                if (!class245.isInfront(class246)) {
                                                    break Label_0551;
                                                }
                                            }
                                            if (!this.contour.doesIntersectSegment(first.pt, class242.pt)) {
                                                array[n3++] = class241.pt;
                                                array[n3++] = class242.pt;
                                                array[n3++] = first.pt;
                                                if (array2 == null) {
                                                    break Label_0572;
                                                }
                                            }
                                        }
                                        class241 = class241.next;
                                        Class328 first2 = this.contour.first;
                                    }
                                    if (!lIlllIIllII(class245, class246)) {
                                        goto Label_0415;
                                    }
                                }
                                final Class328 first = class241.prev;
                                final Class328 class242 = class241.next;
                                this.contour.first = first;
                                class241.unlink();
                                final Class328 nextFreePoint = class241;
                                nextFreePoint.next = this.nextFreePoint;
                                this.nextFreePoint = nextFreePoint;
                                class242.computeAngle();
                                first.computeAngle();
                                if (array2 == null) {
                                    continue Label_0328_Outer;
                                }
                                continue;
                            }
                        } while (array2 == null);
                        array[n3] = null;
                        this.contour.clear();
                        return array;
                    }
                }
                while (this.holes != null) {
                    final Class240 holes = this.holes;
                    if (array2 != null) {
                        continue Label_0328;
                    }
                    Class328 class247 = holes.first;
                Block_16:
                    while (true) {
                        Class328 next3 = class247;
                        while (true) {
                            while (true) {
                                Label_0304: {
                                    if (next3.angle <= 0.0) {
                                        Class328 prev = this.contour.first;
                                        Class328 class248 = null;
                                        Class328 class249 = null;
                                        do {
                                            Label_0260: {
                                                if (next3.isInfront(prev)) {
                                                    class248 = prev;
                                                    class249 = next3;
                                                    if (array2 != null) {
                                                        continue Label_0328_Outer;
                                                    }
                                                    if (class248.isInfront(class249)) {
                                                        final Class240 contour2 = this.contour;
                                                        if (array2 == null) {
                                                            if (contour2.doesIntersectSegment(next3.pt, prev.pt)) {
                                                                break Label_0260;
                                                            }
                                                            final Class240 holes2 = this.holes;
                                                        }
                                                        Class240 next4 = contour2;
                                                        while (!next4.doesIntersectSegment(next3.pt, prev.pt) || array2 != null) {
                                                            if ((next4 = next4.next) == null) {
                                                                final Class328 point = this.getPoint(prev.pt);
                                                                prev.insertAfter(point);
                                                                final Class328 point2 = this.getPoint(next3.pt);
                                                                next3.insertBefore(point2);
                                                                prev.next = next3;
                                                                next3.prev = prev;
                                                                point2.next = point;
                                                                point.prev = point2;
                                                                prev.computeAngle();
                                                                next3.computeAngle();
                                                                point.computeAngle();
                                                                point2.computeAngle();
                                                                this.holes.first = null;
                                                                if (array2 != null || array2 != null) {
                                                                    break;
                                                                }
                                                                break Label_0304;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            prev = prev.next;
                                            final Class328 first3 = this.contour.first;
                                        } while (!lIlllIIllII(class248, class249));
                                    }
                                    final Class328 class250 = next3 = (class247 = next3.next);
                                    if (array2 != null) {
                                        break;
                                    }
                                    if (!lIlllIIllII(class250, this.holes.first)) {
                                        continue Label_0328_Outer;
                                    }
                                }
                                this.holes = this.freePointBag(this.holes);
                                if (array2 == null) {
                                    break Block_16;
                                }
                                continue;
                            }
                        }
                    }
                    if (array2 != null) {
                        break;
                    }
                }
                break;
            }
            continue Label_0328_Outer;
        }
    }
    
    private Class240 getPointBag() {
        final int[] b = Class139.b();
        final Class240 nextFreePointBag = this.nextFreePointBag;
        final int[] array = b;
        final Class240 class240 = nextFreePointBag;
        if (array == null) {
            if (class240 != null) {
                this.nextFreePointBag = nextFreePointBag.next;
                nextFreePointBag.next = null;
                return nextFreePointBag;
            }
            final Class240 class241 = new Class240(this);
        }
        return class240;
    }
    
    private Class240 freePointBag(final Class240 nextFreePointBag) {
        final Class240 next = nextFreePointBag.next;
        nextFreePointBag.clear();
        nextFreePointBag.next = this.nextFreePointBag;
        this.nextFreePointBag = nextFreePointBag;
        return next;
    }
    
    private Class328 getPoint(final Class176 pt) {
        final int[] b = Class139.b();
        final Class328 nextFreePoint = this.nextFreePoint;
        final int[] array = b;
        final Class328 class328 = nextFreePoint;
        if (array == null) {
            if (class328 != null) {
                this.nextFreePoint = nextFreePoint.next;
                nextFreePoint.next = null;
                nextFreePoint.prev = null;
                nextFreePoint.pt = pt;
                return nextFreePoint;
            }
            final Class328 class329 = new Class328(pt);
        }
        return class328;
    }
    
    private void freePoint(final Class328 nextFreePoint) {
        nextFreePoint.next = this.nextFreePoint;
        this.nextFreePoint = nextFreePoint;
    }
    
    private void freePoints(final Class328 nextFreePoint) {
        nextFreePoint.prev.next = this.nextFreePoint;
        nextFreePoint.prev = null;
        this.nextFreePoint = nextFreePoint;
    }
    
    @Override
    public final boolean triangulate() {
        final int[] b = Class139.b();
        Class176[] array = new Class176[0];
        this.contour.computeAngles();
        final int[] b2 = Class139.b();
        Class240 class240 = this.holes;
        final int[] array2 = b2;
    Label_0356_Outer:
        while (true) {
        Label_0356:
            while (true) {
                while (class240 != null) {
                    class240.computeAngles();
                    class240 = class240.next;
                    if (array2 == null) {
                        if (array2 != null) {
                            break;
                        }
                        continue Label_0356_Outer;
                    }
                    else {
                        final Class240 contour = this.contour;
                        final Class240 holes;
                        final int n = (holes.countPoints() - 2) * 3 + 1;
                        final int n2 = 0;
                        if (array2 == null && n2 < n) {
                            array = (Class176[])Array.newInstance(array.getClass().getComponentType(), n);
                            goto Label_0395;
                        }
                        int n3 = n2;
                        do {
                            Class328 class241;
                            if ((class241 = this.contour.first) == null) {
                                if (array2 != null) {
                                    goto Label_0443;
                                }
                                if (array2 == null) {
                                    break;
                                }
                            }
                            final Class328 next = class241.next;
                            if (array2 == null && (lIlllIIllII(next, class241.prev) && array2 == null)) {
                                break;
                            }
                            while (true) {
                                Label_0606: {
                                    final Class328 class245;
                                    final Class328 class246;
                                    Label_0600: {
                                        Label_0585: {
                                            if (next.angle <= 0.0) {
                                                break Label_0585;
                                            }
                                            final Class328 first = class241.prev;
                                            final Class328 class242 = class241.next;
                                            final Class328 next2;
                                            final Class328 class243 = next2 = class242.next;
                                            final Class328 first2;
                                            final Class328 class244 = first2 = first;
                                            if (array2 != null || class243 != class244) {
                                                if (array2 != null) {
                                                    break Label_0600;
                                                }
                                                if (!class243.isInfront(class244)) {
                                                    break Label_0585;
                                                }
                                                class245 = class242;
                                                class246 = first;
                                                if (array2 != null) {
                                                    break Label_0600;
                                                }
                                                if (!class245.isInfront(class246)) {
                                                    break Label_0585;
                                                }
                                            }
                                            if (!this.contour.doesIntersectSegment(first.pt, class242.pt)) {
                                                array[n3++] = class241.pt;
                                                array[n3++] = class242.pt;
                                                array[n3++] = first.pt;
                                                if (array2 == null) {
                                                    break Label_0606;
                                                }
                                            }
                                        }
                                        class241 = class241.next;
                                        Class328 first2 = this.contour.first;
                                    }
                                    if (!lIlllIIllII(class245, class246)) {
                                        goto Label_0443;
                                    }
                                }
                                final Class328 first = class241.prev;
                                final Class328 class242 = class241.next;
                                this.contour.first = first;
                                class241.unlink();
                                final Class328 nextFreePoint = class241;
                                nextFreePoint.next = this.nextFreePoint;
                                this.nextFreePoint = nextFreePoint;
                                class242.computeAngle();
                                first.computeAngle();
                                if (array2 == null) {
                                    continue Label_0356_Outer;
                                }
                                continue;
                            }
                        } while (array2 == null);
                        array[n3] = null;
                        this.contour.clear();
                        final int[] array3 = b;
                        int n4 = 0;
                        while (n4 < array.length && (array[n4] != null || array3 != null)) {
                            this.triangles.add(array[n4]);
                            ++n4;
                            if (array3 != null) {
                                break;
                            }
                        }
                        return true;
                    }
                }
                while (this.holes != null) {
                    final Class240 holes = this.holes;
                    if (array2 != null) {
                        continue Label_0356;
                    }
                    Class328 class247 = holes.first;
                Block_16:
                    while (true) {
                        Class328 next3 = class247;
                        while (true) {
                            while (true) {
                                Label_0332: {
                                    if (next3.angle <= 0.0) {
                                        Class328 prev = this.contour.first;
                                        Class328 class248 = null;
                                        Class328 class249 = null;
                                        do {
                                            Label_0286: {
                                                if (next3.isInfront(prev)) {
                                                    class248 = prev;
                                                    class249 = next3;
                                                    if (array2 != null) {
                                                        continue Label_0356_Outer;
                                                    }
                                                    if (class248.isInfront(class249)) {
                                                        final Class240 contour2 = this.contour;
                                                        if (array2 == null) {
                                                            if (contour2.doesIntersectSegment(next3.pt, prev.pt)) {
                                                                break Label_0286;
                                                            }
                                                            final Class240 holes2 = this.holes;
                                                        }
                                                        Class240 next4 = contour2;
                                                        while (!next4.doesIntersectSegment(next3.pt, prev.pt) || array2 != null) {
                                                            if ((next4 = next4.next) == null) {
                                                                final Class328 point = this.getPoint(prev.pt);
                                                                prev.insertAfter(point);
                                                                final Class328 point2 = this.getPoint(next3.pt);
                                                                next3.insertBefore(point2);
                                                                prev.next = next3;
                                                                next3.prev = prev;
                                                                point2.next = point;
                                                                point.prev = point2;
                                                                prev.computeAngle();
                                                                next3.computeAngle();
                                                                point.computeAngle();
                                                                point2.computeAngle();
                                                                this.holes.first = null;
                                                                if (array2 != null || array2 != null) {
                                                                    break;
                                                                }
                                                                break Label_0332;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            prev = prev.next;
                                            final Class328 first3 = this.contour.first;
                                        } while (!lIlllIIllII(class248, class249));
                                    }
                                    final Class328 class250 = next3 = (class247 = next3.next);
                                    if (array2 != null) {
                                        break;
                                    }
                                    if (!lIlllIIllII(class250, this.holes.first)) {
                                        continue Label_0356_Outer;
                                    }
                                }
                                this.holes = this.freePointBag(this.holes);
                                if (array2 == null) {
                                    break Block_16;
                                }
                                continue;
                            }
                        }
                    }
                    if (array2 != null) {
                        break;
                    }
                }
                break;
            }
            continue Label_0356_Outer;
        }
    }
    
    @Override
    public final int getTriangleCount() {
        return this.triangles.size() / 3;
    }
    
    @Override
    public final float[] getTrianglePoint(final int n, final int n2) {
        final Class176 class176 = this.triangles.get(n * 3 + n2);
        return new float[] { class176.x, class176.y };
    }
    
    static void access$000(final Class231 class231, final Class328 nextFreePoint) {
        nextFreePoint.prev.next = class231.nextFreePoint;
        nextFreePoint.prev = null;
        class231.nextFreePoint = nextFreePoint;
    }
    
    static {
        Class169.a(1301865187133123367L, 6340159319716301574L, MethodHandles.lookup().lookupClass()).a(53397715489131L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIlllIIllll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIlllIIllII(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIlllIIlIIl(final int n) {
        return n <= 0;
    }
    
    private static boolean lIlllIIlllI(final int n) {
        return n > 0;
    }
    
    private static int lIlllIIlIII$25399e8(final double n) {
        return dcmpl(n, 0.0);
    }
    
    private static int lIlllIIIlll$25399e8(final double n) {
        return dcmpg(n, 0.0);
    }
}
