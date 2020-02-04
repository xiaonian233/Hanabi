package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class95 implements Class124
{
    private static final float EPSILON = 1.0E-10f;
    private Class74 poly;
    private Class74 tris;
    private boolean tried;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIIlIIIIII;
    
    public Class95() {
        super();
        this.poly = new Class74();
        this.tris = new Class74();
    }
    
    @Override
    public final void addPolyPoint(final float n, final float n2) {
        final int[] b = Class139.b();
        final Class122 class122 = new Class122(n, n2);
        final int[] array = b;
        final Class74 poly = this.poly;
        final Class122 class123 = class122;
        if (array == null) {
            if (poly.points.contains(class123)) {
                return;
            }
            final Class74 poly2 = this.poly;
        }
        poly.add(class123);
    }
    
    private int getPolyPointCount() {
        return this.poly.points.size();
    }
    
    private float[] getPolyPoint(final int n) {
        return new float[] { Class122.access$000(this.poly.get(n)), Class122.access$100(this.poly.get(n)) };
    }
    
    @Override
    public final boolean triangulate() {
        this.tried = true;
        final Class74 poly = this.poly;
        final Class74 tris = this.tris;
        final Class74 class74 = poly;
        final int[] b = Class139.b();
        tris.points.clear();
        final int[] array = b;
        int size;
        final int n2;
        final int n = n2 = (size = class74.points.size());
        if (array == null) {
            if (n < 3) {
                return false;
            }
            size = n2;
        }
        final int[] array2 = new int[size];
        final Class74 class75 = class74;
        final int[] b2 = Class139.b();
        final int size2 = class75.points.size();
        final int[] array3 = b2;
        float n3 = 0.0f;
        int n4 = size2 - 1;
        int i = 0;
        while (true) {
            while (i < size2) {
                final Class122 value = class75.get(n4);
                final Class122 value2 = class75.get(i);
                final float n5 = n3 + (value.x * value2.y - value2.x * value.y);
                if (array3 != null) {
                    final float n6 = fcmpg(0.0f, n5);
                    int j = 0;
                    Label_0247: {
                        if (array == null && n6 < 0) {
                            j = 0;
                            while (j < n2) {
                                final int[] array4 = array2;
                                final int n7 = j;
                                array4[n7] = n7;
                                ++j;
                                if (array != null) {
                                    break Label_0247;
                                }
                                if (array != null) {
                                    break;
                                }
                            }
                            if (array != null) {
                                goto Label_0210;
                            }
                        }
                        else {
                            j = (int)n6;
                            while (j < n2) {
                                array2[j] = n2 - 1 - j;
                                ++j;
                                if (array != null) {
                                    break Label_0247;
                                }
                                if (array != null) {
                                    break;
                                }
                            }
                        }
                        j = n2;
                    }
                    int n8 = j * 2;
                    int n9 = j - 1;
                    while (j > 2) {
                        int n11;
                        final int n10 = n11 = 0;
                        if (array != null) {
                            return n10 != 0;
                        }
                        if (array == null) {
                            if (n8-- <= 0) {
                                return false;
                            }
                            n11 = n9;
                        }
                        int n12 = n11;
                        int n14;
                        final int n13 = n14 = j;
                        int n16;
                        final int n15 = n16 = n12;
                        if (array == null) {
                            if (lIIllIIIIlIIl(n13, n15)) {
                                n12 = 0;
                            }
                            n9 = n12 + 1;
                            final int n17;
                            n14 = (n17 = j);
                            final int n18;
                            n16 = (n18 = n9);
                        }
                        if (array == null) {
                            if (lIIllIIIIlIIl(n13, n15)) {
                                n9 = 0;
                            }
                            n14 = n9;
                            n16 = 1;
                        }
                        int n19 = n14 + n16;
                        int n21;
                        final int n20 = n21 = j;
                        Label_0873: {
                            if (array == null) {
                                if (lIIllIIIIlIIl(n20, n19)) {
                                    n19 = 0;
                                }
                                final Class74 class76 = class74;
                                final int n22 = n12;
                                final int n23 = n9;
                                final int n24 = n19;
                                final int n25 = j;
                                final int[] array5 = array2;
                                final int n26 = n25;
                                final int n27 = n24;
                                final int n28 = n23;
                                final int n29 = n22;
                                final Class74 class77 = class76;
                                final float x = class76.get(array5[n29]).x;
                                final float y = class77.get(array5[n29]).y;
                                final int[] b3 = Class139.b();
                                final float x2 = class77.get(array5[n28]).x;
                                final float y2 = class77.get(array5[n28]).y;
                                final int[] array6 = b3;
                                final float x3 = class77.get(array5[n27]).x;
                                final float y3 = class77.get(array5[n27]).y;
                                final float n30 = fcmpl(1.0E-10f, (x2 - x) * (y3 - y) - (y2 - y) * (x3 - x));
                                if (array6 == null && n30 > 0) {
                                    final int n31;
                                    n21 = (n31 = 0);
                                }
                                else {
                                    int k = (int)n30;
                                    while (k < n26) {
                                        int n31;
                                        int n33;
                                        final int n32 = n33 = (n31 = (n21 = k));
                                        if (array6 != null) {
                                            break Label_0873;
                                        }
                                        int n35;
                                        final int n34 = n35 = n29;
                                        Label_0867: {
                                            Label_0864: {
                                                if (array6 == null) {
                                                    if (!lIIllIIIIIIIl(n32, n34)) {
                                                        break Label_0864;
                                                    }
                                                    final int n36;
                                                    n33 = (n36 = k);
                                                    final int n37;
                                                    n35 = (n37 = n28);
                                                }
                                                if (array6 == null) {
                                                    if (!lIIllIIIIIIIl(n32, n34)) {
                                                        break Label_0864;
                                                    }
                                                    n33 = k;
                                                    n35 = n27;
                                                }
                                                if (n33 != n35 || array6 != null) {
                                                    final float x4 = class77.get(array5[k]).x;
                                                    final float y4 = class77.get(array5[k]).y;
                                                    if (array6 != null) {
                                                        break Label_0867;
                                                    }
                                                    final float n38 = x;
                                                    final float n39 = y;
                                                    final float n40 = x2;
                                                    final float n41 = y2;
                                                    final float n42 = x3;
                                                    final float n43 = y3;
                                                    final float n44 = x4;
                                                    final float n45 = y4;
                                                    final float n46 = n44;
                                                    final float n47 = n43;
                                                    final float n48 = n42;
                                                    final float n49 = n41;
                                                    final float n50 = n40;
                                                    final float n51 = n39;
                                                    final float n52 = n38;
                                                    final float n53 = n48 - n50;
                                                    final int[] b4 = Class139.b();
                                                    final float n54 = n47 - n49;
                                                    final float n55 = n52 - n48;
                                                    final float n56 = n51 - n47;
                                                    final int[] array7 = b4;
                                                    final float n57 = n50 - n52;
                                                    final float n58 = n49 - n51;
                                                    final float n59 = n46 - n52;
                                                    final float n60 = n45 - n51;
                                                    final float n61 = n46 - n50;
                                                    final float n62 = n45 - n49;
                                                    final float n63 = n46 - n48;
                                                    final float n64 = n45 - n47;
                                                    final float n65 = n53 * n62 - n54 * n61;
                                                    final float n66 = n57 * n60 - n58 * n59;
                                                    final float n67 = n55 * n64 - n56 * n63;
                                                    float n70;
                                                    float n69;
                                                    final float n68 = n69 = (n70 = fcmpl(n65, 0.0f));
                                                    Label_0857: {
                                                        Label_0856: {
                                                            if (array7 == null) {
                                                                if (n68 < 0) {
                                                                    break Label_0856;
                                                                }
                                                                final float n71;
                                                                n69 = (n71 = (n70 = fcmpl(n67, 0.0f)));
                                                            }
                                                            if (array7 == null) {
                                                                if (n68 < 0) {
                                                                    break Label_0856;
                                                                }
                                                                n70 = (n69 = fcmpl(n66, 0.0f));
                                                            }
                                                            if (array7 == null) {
                                                                if (n69 < 0) {
                                                                    break Label_0856;
                                                                }
                                                                n70 = 1;
                                                            }
                                                            break Label_0857;
                                                        }
                                                        n70 = 0;
                                                    }
                                                    if (n70 != 0) {
                                                        n21 = (n31 = 0);
                                                        break Label_0873;
                                                    }
                                                }
                                            }
                                            ++k;
                                        }
                                        if (array6 != null) {
                                            break;
                                        }
                                    }
                                    int n31;
                                    n21 = (n31 = 1);
                                }
                            }
                        }
                        Label_0982: {
                            if (array == null) {
                                if (n20 == 0) {
                                    break Label_0982;
                                }
                                n21 = array2[n12];
                            }
                            final int n72 = n21;
                            final int n73 = array2[n9];
                            final int n74 = array2[n19];
                            tris.add(class74.get(n72));
                            tris.add(class74.get(n73));
                            tris.add(class74.get(n74));
                            int n75 = n9;
                            int l = n9 + 1;
                            while (true) {
                                while (l < j) {
                                    array2[n75] = array2[l];
                                    ++n75;
                                    ++l;
                                    if (array != null) {
                                        n8 = j * 2;
                                        break Label_0982;
                                    }
                                    if (array != null) {
                                        break;
                                    }
                                }
                                --j;
                                continue;
                            }
                        }
                        if (array != null) {
                            break;
                        }
                    }
                    final int n10 = true ? 1 : 0;
                    return n10 != 0;
                }
                n3 = n5;
                n4 = i++;
                if (array3 != null) {
                    break;
                }
            }
            continue;
        }
    }
    
    @Override
    public final int getTriangleCount() {
        final int[] b = Class139.b();
        int tried;
        final boolean b2 = (tried = (this.tried ? 1 : 0)) != 0;
        if (b == null) {
            if (!b2) {
                throw new RuntimeException("Call triangulate() before accessing triangles");
            }
            tried = this.tris.points.size() / 3;
        }
        return tried;
    }
    
    @Override
    public final float[] getTrianglePoint(final int n, final int n2) {
        final int[] b = Class139.b();
        Class95 class95 = this;
        if (b == null) {
            if (!this.tried) {
                throw new RuntimeException("Call triangulate() before accessing triangles");
            }
            class95 = this;
        }
        return class95.tris.get(n * 3 + n2).array;
    }
    
    private static float area(final Class74 class74) {
        final int[] b = Class139.b();
        final int size = class74.points.size();
        final int[] array = b;
        float n = 0.0f;
        int n2 = size - 1;
        int i = 0;
        float n3 = 0.0f;
        while (i < size) {
            final Class122 value = class74.get(n2);
            final Class122 value2 = class74.get(i);
            n3 = n + (value.x * value2.y - value2.x * value.y);
            if (array != null) {
                return n3;
            }
            n = n3;
            n2 = i++;
            if (array != null) {
                break;
            }
        }
        return n3;
    }
    
    private static boolean insideTriangle(float n, float n2, float n3, float n4, float n5, float n6, final float n7, final float n8) {
        final float n9 = n5 - n3;
        final int[] b = Class139.b();
        final float n10 = n6 - n4;
        final float n11 = n - n5;
        final float n12 = n2 - n6;
        final int[] array = b;
        final float n13 = n3 - n;
        final float n14 = n4 - n2;
        n = n7 - n;
        n2 = n8 - n2;
        n3 = n7 - n3;
        n4 = n8 - n4;
        n5 = n7 - n5;
        n6 = n8 - n6;
        n3 = n9 * n4 - n10 * n3;
        n = n13 * n2 - n14 * n;
        n2 = n11 * n6 - n12 * n5;
        float n17;
        int n16;
        final float n15 = n16 = (int)(n17 = fcmpl(n3, 0.0f));
        if (array == null) {
            if (n15 < 0) {
                return false;
            }
            final float n18;
            n16 = (int)(n18 = (n17 = fcmpl(n2, 0.0f)));
        }
        if (array == null) {
            if (n15 < 0) {
                return false;
            }
            n17 = (n16 = fcmpl(n, 0.0f));
        }
        if (array == null) {
            if (n16 < 0) {
                return false;
            }
            n17 = 1;
        }
        return n17 != 0.0f;
    }
    
    private static boolean snip(final Class74 class74, final int n, final int n2, final int n3, final int n4, final int[] array) {
        final float x = class74.get(array[n]).x;
        final float y = class74.get(array[n]).y;
        final int[] b = Class139.b();
        final float x2 = class74.get(array[n2]).x;
        final float y2 = class74.get(array[n2]).y;
        final int[] array2 = b;
        final float x3 = class74.get(array[n3]).x;
        final float y3 = class74.get(array[n3]).y;
        final float n5 = fcmpl(1.0E-10f, (x2 - x) * (y3 - y) - (y2 - y) * (x3 - x));
        if (array2 == null && n5 > 0) {
            return false;
        }
        int i = (int)n5;
        while (i < n4) {
            final boolean b2;
            int n7;
            final int n6 = n7 = ((b2 = (i != 0)) ? 1 : 0);
            if (array2 != null) {
                return b2;
            }
            int n8 = n;
            int n9 = n;
            Label_0427: {
                Label_0424: {
                    if (array2 == null) {
                        if (!lIIllIIIIIIIl(n6, n)) {
                            break Label_0424;
                        }
                        final int n10;
                        n7 = (n10 = i);
                        n8 = n2;
                        n9 = n2;
                    }
                    if (array2 == null) {
                        if (!lIIllIIIIIIIl(n6, n9)) {
                            break Label_0424;
                        }
                        n7 = i;
                        n8 = n3;
                    }
                    if (n7 != n8 || array2 != null) {
                        final float x4 = class74.get(array[i]).x;
                        final float y4 = class74.get(array[i]).y;
                        if (array2 != null) {
                            break Label_0427;
                        }
                        final float n11 = x4;
                        final float n12 = y4;
                        final float n13 = n11;
                        final float n14 = x3 - x2;
                        final int[] b3 = Class139.b();
                        final float n15 = y3 - y2;
                        final float n16 = x - x3;
                        final float n17 = y - y3;
                        final int[] array3 = b3;
                        final float n18 = x2 - x;
                        final float n19 = y2 - y;
                        final float n20 = n13 - x;
                        final float n21 = n12 - y;
                        final float n22 = n13 - x2;
                        final float n23 = n12 - y2;
                        final float n24 = n13 - x3;
                        final float n25 = n12 - y3;
                        final float n26 = n14 * n23 - n15 * n22;
                        final float n27 = n18 * n21 - n19 * n20;
                        final float n28 = n16 * n25 - n17 * n24;
                        float n31;
                        float n30;
                        final float n29 = n30 = (n31 = fcmpl(n26, 0.0f));
                        Label_0419: {
                            Label_0418: {
                                if (array3 == null) {
                                    if (n29 < 0) {
                                        break Label_0418;
                                    }
                                    final float n32;
                                    n30 = (n32 = (n31 = fcmpl(n28, 0.0f)));
                                }
                                if (array3 == null) {
                                    if (n29 < 0) {
                                        break Label_0418;
                                    }
                                    n31 = (n30 = fcmpl(n27, 0.0f));
                                }
                                if (array3 == null) {
                                    if (n30 < 0) {
                                        break Label_0418;
                                    }
                                    n31 = 1;
                                }
                                break Label_0419;
                            }
                            n31 = 0;
                        }
                        if (n31 != 0) {
                            return false;
                        }
                    }
                }
                ++i;
            }
            if (array2 != null) {
                break;
            }
        }
        return true;
    }
    
    private static boolean process(final Class74 class74, final Class74 class75) {
        final int[] b = Class139.b();
        class75.points.clear();
        final int[] array = b;
        int size;
        final int n2;
        final int n = n2 = (size = class74.points.size());
        if (array == null) {
            if (n < 3) {
                return false;
            }
            size = n2;
        }
        final int[] array2 = new int[size];
        final int[] b2 = Class139.b();
        final int size2 = class74.points.size();
        final int[] array3 = b2;
        float n3 = 0.0f;
        int n4 = size2 - 1;
        int i = 0;
        while (true) {
            while (i < size2) {
                final Class122 value = class74.get(n4);
                final Class122 value2 = class74.get(i);
                final float n5 = n3 + (value.x * value2.y - value2.x * value.y);
                if (array3 != null) {
                    final float n6 = fcmpg(0.0f, n5);
                    int j = 0;
                    Label_0226: {
                        if (array == null && n6 < 0) {
                            j = 0;
                            while (j < n2) {
                                final int[] array4 = array2;
                                final int n7 = j;
                                array4[n7] = n7;
                                ++j;
                                if (array != null) {
                                    break Label_0226;
                                }
                                if (array != null) {
                                    break;
                                }
                            }
                            if (array != null) {
                                goto Label_0192;
                            }
                        }
                        else {
                            j = (int)n6;
                            while (j < n2) {
                                array2[j] = n2 - 1 - j;
                                ++j;
                                if (array != null) {
                                    break Label_0226;
                                }
                                if (array != null) {
                                    break;
                                }
                            }
                        }
                        j = n2;
                    }
                    int n8 = j - 1;
                    while (j > 2) {
                        final boolean b3 = false;
                        if (array != null) {
                            return b3;
                        }
                        if (array == null) {
                            return false;
                        }
                        int n10;
                        int n9 = n10 = j;
                        int n12;
                        int n11 = n12 = 0;
                        if (array == null) {
                            n8 = 1;
                            n9 = (n10 = j);
                            n11 = (n12 = 1);
                        }
                        if (array == null) {
                            if (lIIllIIIIlIIl(n10, n12)) {
                                n8 = 0;
                            }
                            n9 = n8;
                            n11 = 1;
                        }
                        int n13 = n9 + n11;
                        int n15;
                        final int n14 = n15 = j;
                        Label_0794: {
                            if (array == null) {
                                if (lIIllIIIIlIIl(n14, n13)) {
                                    n13 = 0;
                                }
                                final int n16 = n8;
                                final int n17 = n13;
                                final int n18 = j;
                                final int[] array5 = array2;
                                final int n19 = n18;
                                final int n20 = n17;
                                final int n21 = n16;
                                final float x = class74.get(array5[0]).x;
                                final float y = class74.get(array5[0]).y;
                                final int[] b4 = Class139.b();
                                final float x2 = class74.get(array5[n21]).x;
                                final float y2 = class74.get(array5[n21]).y;
                                final int[] array6 = b4;
                                final float x3 = class74.get(array5[n20]).x;
                                final float y3 = class74.get(array5[n20]).y;
                                final float n22 = fcmpl(1.0E-10f, (x2 - x) * (y3 - y) - (y2 - y) * (x3 - x));
                                if (array6 == null && n22 > 0) {
                                    final int n23;
                                    n15 = (n23 = 0);
                                }
                                else {
                                    int k = (int)n22;
                                    while (k < n19) {
                                        int n23;
                                        int n25;
                                        final int n24 = n25 = (n23 = (n15 = k));
                                        if (array6 != null) {
                                            break Label_0794;
                                        }
                                        int n27;
                                        final int n26 = n27 = 0;
                                        Label_0789: {
                                            Label_0786: {
                                                if (array6 == null) {
                                                    if (!lIIllIIIIIIIl(n24, n26)) {
                                                        break Label_0786;
                                                    }
                                                    final int n28;
                                                    n25 = (n28 = k);
                                                    final int n29;
                                                    n27 = (n29 = n21);
                                                }
                                                if (array6 == null) {
                                                    if (!lIIllIIIIIIIl(n24, n26)) {
                                                        break Label_0786;
                                                    }
                                                    n25 = k;
                                                    n27 = n20;
                                                }
                                                if (n25 != n27 || array6 != null) {
                                                    final float x4 = class74.get(array5[k]).x;
                                                    final float y4 = class74.get(array5[k]).y;
                                                    if (array6 != null) {
                                                        break Label_0789;
                                                    }
                                                    final float n30 = x;
                                                    final float n31 = y;
                                                    final float n32 = x2;
                                                    final float n33 = y2;
                                                    final float n34 = x3;
                                                    final float n35 = y3;
                                                    final float n36 = x4;
                                                    final float n37 = y4;
                                                    final float n38 = n36;
                                                    final float n39 = n35;
                                                    final float n40 = n34;
                                                    final float n41 = n33;
                                                    final float n42 = n32;
                                                    final float n43 = n31;
                                                    final float n44 = n30;
                                                    final float n45 = n40 - n42;
                                                    final int[] b5 = Class139.b();
                                                    final float n46 = n39 - n41;
                                                    final float n47 = n44 - n40;
                                                    final float n48 = n43 - n39;
                                                    final int[] array7 = b5;
                                                    final float n49 = n42 - n44;
                                                    final float n50 = n41 - n43;
                                                    final float n51 = n38 - n44;
                                                    final float n52 = n37 - n43;
                                                    final float n53 = n38 - n42;
                                                    final float n54 = n37 - n41;
                                                    final float n55 = n38 - n40;
                                                    final float n56 = n37 - n39;
                                                    final float n57 = n45 * n54 - n46 * n53;
                                                    final float n58 = n49 * n52 - n50 * n51;
                                                    final float n59 = n47 * n56 - n48 * n55;
                                                    float n62;
                                                    float n61;
                                                    final float n60 = n61 = (n62 = fcmpl(n57, 0.0f));
                                                    Label_0779: {
                                                        Label_0778: {
                                                            if (array7 == null) {
                                                                if (n60 < 0) {
                                                                    break Label_0778;
                                                                }
                                                                final float n63;
                                                                n61 = (n63 = (n62 = fcmpl(n59, 0.0f)));
                                                            }
                                                            if (array7 == null) {
                                                                if (n60 < 0) {
                                                                    break Label_0778;
                                                                }
                                                                n62 = (n61 = fcmpl(n58, 0.0f));
                                                            }
                                                            if (array7 == null) {
                                                                if (n61 < 0) {
                                                                    break Label_0778;
                                                                }
                                                                n62 = 1;
                                                            }
                                                            break Label_0779;
                                                        }
                                                        n62 = 0;
                                                    }
                                                    if (n62 != 0) {
                                                        n15 = (n23 = 0);
                                                        break Label_0794;
                                                    }
                                                }
                                            }
                                            ++k;
                                        }
                                        if (array6 != null) {
                                            break;
                                        }
                                    }
                                    int n23;
                                    n15 = (n23 = 1);
                                }
                            }
                        }
                        Label_0891: {
                            if (array == null) {
                                if (n14 == 0) {
                                    break Label_0891;
                                }
                                n15 = array2[0];
                            }
                            final int n64 = n15;
                            final int n65 = array2[n8];
                            final int n66 = array2[n13];
                            class75.add(class74.get(n64));
                            class75.add(class74.get(n65));
                            class75.add(class74.get(n66));
                            int n67 = n8;
                            int l = n8 + 1;
                            while (l < j) {
                                array2[n67] = array2[l];
                                ++n67;
                                ++l;
                                if (array != null) {
                                    break Label_0891;
                                }
                                if (array != null) {
                                    break;
                                }
                            }
                            --j;
                        }
                        if (array != null) {
                            break;
                        }
                    }
                    return true;
                }
                n3 = n5;
                n4 = i++;
                if (array3 != null) {
                    break;
                }
            }
            continue;
        }
    }
    
    @Override
    public final void startHole() {
    }
    
    static {
        lIIIlIlIIlIII();
        Class169.a(3463174585134597644L, 3868018241064931841L, MethodHandles.lookup().lookupClass()).a(137681437503902L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class95.llIIlIIIIII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class95.llIIlIIIIII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(41163608352604L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class95.llIIlIIIIII[2]).length();
        int char1 = 80;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class95.llIIlIIIIII[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static String a(final byte[] array) {
        int n = 0;
        final int length;
        final char[] array2 = new char[length = array.length];
        for (int i = 0; i < length; ++i) {
            final int n2;
            if ((n2 = (0xFF & array[i])) < 192) {
                array2[n++] = (char)n2;
            }
            else if (n2 < 224) {
                array2[n++] = (char)((char)((char)(n2 & 0x1F) << 6) | (char)(array[++i] & 0x3F));
            }
            else if (i < length - 2) {
                array2[n++] = (char)((char)((char)((char)(n2 & 0xF) << 12) | (char)(array[++i] & 0x3F) << 6) | (char)(array[++i] & 0x3F));
            }
        }
        return new String(array2, 0, n);
    }
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x251E;
        if (Class95.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class95.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class95.llIIlIIIIII[4]);
                    array[1] = SecretKeyFactory.getInstance(Class95.llIIlIIIIII[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class95.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class95.llIIlIIIIII[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class95.c[n3] = a(((Cipher)array[0]).doFinal(Class95.b[n3].getBytes(Class95.llIIlIIIIII[7])));
        }
        return Class95.c[n3];
    }
    
    private static Object a$dd29b59(final MutableCallSite mutableCallSite, final Object[] array) {
        final String a = a((int)array[0], (long)array[1]);
        mutableCallSite.setTarget(MethodHandles.dropArguments(MethodHandles.constant(String.class, a), 0, Integer.TYPE, Long.TYPE));
        return a;
    }
    
    private static CallSite a(final MethodHandles.Lookup p0, final String p1, final MethodType p2) {
        // 
        // This method could not be decompiled.
        // 
        // Could not show original bytecode, likely due to the same error.
        // 
        // The error that occurred was:
        // 
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class95.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
        //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:65)
        //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
        //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // Caused by: java.lang.ClassCastException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void lIIIlIlIIlIII() {
        (llIIlIIIIII = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class95.llIIlIIIIII[1] = "DES";
        Class95.llIIlIIIIII[2] = "I\u0012\u001b?]é³ËßKút\u001aªS*nKðâú\u0007¸abõýy\u0003\u0099mêëÝ-¤0:B\u001b{CX²åÀ\u008ct\u008c»\u0099Ðd\u009få\u0084\u009cµoø\u0092È$\u009d\u0094dÎ\u001e\u0004ã§tºU\u000buÊ\u007fÑ}P{Y\u0017R&  q9ÏM§B\u0088=£\u0012ié¢\u007f\bÊ\u0081H³R>\u0004Â×÷\u0018è¿¶²áµ5\u0086H¼)'ÑÄ§Z$¦d¿þÊÚ\u0081Ý·Ù;\u0087\u0086Îâ\u000fÓ<V_Á·Õý%\u0014¡\u0093\u0092û";
        Class95.llIIlIIIIII[3] = "ISO-8859-1";
        Class95.llIIlIIIIII[4] = "DES/CBC/PKCS5Padding";
        Class95.llIIlIIIIII[5] = "DES";
        Class95.llIIlIIIIII[6] = "我和你就好像是如来佛和孙悟空不要义无返顾地的说要跟我作战了好吗我怎么也忍不住揍你的冲动有本事拿出你的词汇让我心服口服不要自欺欺人继续找借口来逃避我吧NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003\u200d\u200c\u2001";
        Class95.llIIlIIIIII[7] = "ISO-8859-1";
        Class95.llIIlIIIIII[8] = "我和你就好像是如来佛和孙悟空不要义无返顾地的说要跟我作战了好吗我怎么也忍不住揍你的冲动有本事拿出你的词汇让我心服口服不要自欺欺人继续找借口来逃避我吧NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003\u200d\u200c\u2001";
        Class95.llIIlIIIIII[9] = " : ";
        Class95.llIIlIIIIII[10] = " : ";
    }
    
    private static String lIIIlIlIIIIIl(String s, final String s2) {
        s = new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        final StringBuilder sb = new StringBuilder();
        final char[] charArray = s2.toCharArray();
        int n = 0;
        char[] charArray2;
        for (int length = (charArray2 = s.toCharArray()).length, i = 0; i < length; ++i) {
            sb.append((char)(charArray2[i] ^ charArray[n % charArray.length]));
            ++n;
        }
        return String.valueOf(sb);
    }
    
    private static String lIIIlIIlllIII(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("Blowfish")).init(2, new SecretKeySpec(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), "Blowfish"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String lIIIlIIlllIIl(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("DES")).init(2, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), 8), "DES"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static boolean lIIllIIIIlIII$255f299(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIllIIIIlIIl(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lIIllIIIIIlll$255f299(final int n) {
        return n > 2;
    }
    
    private static boolean lIIIlIlIllIlI(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIllIIIIIllI(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIlIlIlllII(final int n) {
        return n > 0;
    }
    
    private static boolean lIIllIIIIIIIl(final int n, final int n2) {
        return n != n2;
    }
    
    private static int lIIIlIlIllIIl$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIIIlIlIllIll$2548a28(final float n) {
        return fcmpl(1.0E-10f, n);
    }
    
    private static int lIIllIIIIIlII$2548a28(final float n) {
        return fcmpg(0.0f, n);
    }
}
