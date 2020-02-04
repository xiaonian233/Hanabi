package ClassSub;

import java.io.*;
import java.lang.invoke.*;

public final class Class240 implements Serializable
{
    protected Class328 first;
    protected Class240 next;
    private Class231 this$0;
    private static final long a;
    
    protected Class240(final Class231 this$0) {
        this.this$0 = this$0;
        super();
    }
    
    public final void clear() {
        final int[] b = Class139.b();
        Class240 class240 = this;
        if (b == null) {
            if (this.first == null) {
                return;
            }
            Class231.access$000(this.this$0, this.first);
            class240 = this;
        }
        class240.first = null;
    }
    
    public final void add(final Class328 prev) {
        final int[] b = Class139.b();
        final Class328 first = this.first;
        if (b == null) {
            if (first != null) {
                this.first.insertBefore(prev);
                if (b == null) {
                    return;
                }
            }
            this.first = prev;
            prev.next = prev;
        }
        first.prev = prev;
    }
    
    public final void computeAngles() {
        final int[] b = Class139.b();
        final Class328 first = this.first;
        if (b == null) {
            if (first == null) {
                return;
            }
            final Class328 first2 = this.first;
        }
        Class328 next = first;
    Block_4:
        while (true) {
            next.computeAngle();
            while (lIIlIlIIllll(next = next.next, this.first)) {
                if (b == null) {
                    break Block_4;
                }
            }
        }
    }
    
    public final boolean doesIntersectSegment(final Class176 class176, final Class176 class177) {
        final int[] b = Class139.b();
        final double n = class177.x - class176.x;
        final int[] array = b;
        final double n2 = class177.y - class176.y;
        Class328 first = this.first;
        double n12;
        while (true) {
            final Class328 next = first.next;
            final Class328 class178;
            final Class328 class180;
            Label_0323: {
                if (lIIlIlIlIIlI(first.pt, class176)) {
                    final Class328 class179;
                    class178 = (class179 = next);
                    if (array == null && array == null) {
                        if (lIIlIlIlIIlI(class178.pt, class176)) {
                            class180 = first;
                            if (array == null) {
                                if (lIIlIlIlIIlI(class180.pt, class177)) {
                                    final Class328 class181 = next;
                                    if (array == null) {
                                        if (lIIlIlIlIIlI(class181.pt, class177)) {
                                            final double n3 = next.pt.x - first.pt.x;
                                            final Class328 class182 = next;
                                            if (array == null) {
                                                final double n4 = class182.pt.y - first.pt.y;
                                                final double n5;
                                                if (Math.abs(n5 = n * n4 - n2 * n3) > 1.0E-5) {
                                                    final double n6 = first.pt.x - class176.x;
                                                    final Class328 class183 = first;
                                                    if (array == null) {
                                                        final double n7 = class183.pt.y - class176.y;
                                                        final double n8 = (n4 * n6 - n3 * n7) / n5;
                                                        final double n9 = (n2 * n6 - n * n7) / n5;
                                                        if (n8 >= 0.0) {
                                                            double n11;
                                                            final double n10 = n11 = (n12 = dcmpg(n8, 1.0));
                                                            if (array == null) {
                                                                if (n10 > 0) {
                                                                    break Label_0323;
                                                                }
                                                                final double n13;
                                                                n11 = (n13 = (n12 = dcmpl(n9, 0.0)));
                                                            }
                                                            if (array == null) {
                                                                if (n10 < 0) {
                                                                    break Label_0323;
                                                                }
                                                                n12 = (n11 = dcmpg(n9, 1.0));
                                                            }
                                                            if (array != null) {
                                                                break;
                                                            }
                                                            if (n11 <= 0) {
                                                                n12 = 1;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (array == null && lIIlIlIIllll(class178, this.first)) {
                return false;
            }
            first = class180;
        }
        return n12 != 0.0;
    }
    
    public final int countPoints() {
        final int[] b = Class139.b();
        if (this.first == null) {
            return 0;
        }
        int n = 0;
        Class328 class328 = this.first;
    Block_3:
        while (true) {
            ++n;
            while (lIIlIlIIllll(class328 = class328.next, this.first)) {
                if (b == null) {
                    break Block_3;
                }
            }
        }
        return n;
    }
    
    private boolean contains(final Class176 class176) {
        final int[] b = Class139.b();
        final Class328 first = this.first;
        if (b == null) {
            if (first == null) {
                return false;
            }
            final Class328 prev = this.first.prev;
        }
        boolean equals;
        final boolean b2 = equals = first.pt.equals(class176);
        if (b == null) {
            if (b2) {
                return true;
            }
            final boolean equals2;
            equals = (equals2 = this.first.pt.equals(class176));
        }
        if (b == null) {
            if (b2) {
                return true;
            }
            equals = false;
        }
        return equals;
    }
    
    static {
        Class169.a(2469406226039138392L, 4214718924998489443L, MethodHandles.lookup().lookupClass()).a(197351769082321L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIIlIlIlIIlI(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIlIlIIllll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIlIlIlIlII(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIlIlIlIlIl(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIlIlIlIIll(final int n) {
        return n > 0;
    }
    
    private static int lIIlIlIlIIII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIIlIlIlIIIl$25399e8(final double n) {
        return dcmpg(n, 1.0);
    }
}
