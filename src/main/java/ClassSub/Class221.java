package ClassSub;

import java.lang.invoke.*;

public final class Class221
{
    private static Class79 GL;
    private static Class341 LSR;
    private static final long a;
    
    public Class221() {
        super();
    }
    
    public static final void draw(final Class129 class129) {
        final int[] b = Class139.b();
        final Class71 lastBind = Class154.getLastBind();
        Class154.bindNone();
        final float[] points = class129.getPoints();
        final int[] array = b;
        Class221.LSR.start();
        int i = 0;
        while (true) {
            while (i < points.length) {
                Class221.LSR.vertex(points[i], points[i + 1]);
                i += 2;
                if (array != null) {
                    final Class71 class130 = lastBind;
                    if (array == null && class130 == null) {
                        Class154.bindNone();
                        if (array != null) {
                            goto Label_0107;
                        }
                    }
                    else {
                        class130.bind();
                    }
                    return;
                }
                if (array != null) {
                    break;
                }
            }
            if (class129.closed()) {
                Class221.LSR.vertex(points[0], points[1]);
            }
            Class221.LSR.end();
            continue;
        }
    }
    
    public static final void draw(final Class129 class129, final Class356 class130) {
        final float[] points = class129.getPoints();
        final int[] b = Class139.b();
        final Class71 lastBind = Class154.getLastBind();
        Class154.bindNone();
        final int[] array = b;
        class129.getCenter();
        Class221.GL.glBegin(3);
        int i = 0;
        while (true) {
            while (i < points.length) {
                class130.colorAt$14309a69().bind();
                final Class176 offsetAt$14311289 = class130.getOffsetAt$14311289();
                Class221.GL.glVertex2f(points[i] + offsetAt$14311289.x, points[i + 1] + offsetAt$14311289.y);
                i += 2;
                if (array != null) {
                    final Class71 class131 = lastBind;
                    if (array == null && class131 == null) {
                        Class154.bindNone();
                        if (array != null) {
                            goto Label_0174;
                        }
                    }
                    else {
                        class131.bind();
                    }
                    return;
                }
                if (array != null) {
                    break;
                }
            }
            if (class129.closed()) {
                class130.colorAt$14309a69().bind();
                final Class176 offsetAt$14311290 = class130.getOffsetAt$14311289();
                Class221.GL.glVertex2f(points[0] + offsetAt$14311290.x, points[1] + offsetAt$14311290.y);
            }
            Class221.GL.glEnd();
            continue;
        }
    }
    
    private static boolean validFill(final Class129 class129) {
        final int[] b = Class139.b();
        final Class124 triangles = class129.getTriangles();
        if (b == null) {
            if (triangles == null) {
                return false;
            }
            class129.getTriangles();
        }
        int triangleCount;
        final int n = triangleCount = triangles.getTriangleCount();
        if (b == null) {
            if (n == 0) {
                return false;
            }
            triangleCount = (true ? 1 : 0);
        }
        return triangleCount != 0;
    }
    
    public static final void fill(final Class129 class129) {
        final int[] b = Class139.b();
        if (!validFill(class129)) {
            return;
        }
        final Class71 lastBind = Class154.getLastBind();
        Class154.bindNone();
        fill(class129, new Class17());
        final Class71 class130 = lastBind;
        if (b == null && class130 == null) {
            Class154.bindNone();
            if (b != null) {
                goto Label_0045;
            }
        }
        else {
            class130.bind();
        }
    }
    
    private static final void fill(final Class129 class129, final Class180 class130) {
        final Class124 triangles = class129.getTriangles();
        final int[] b = Class139.b();
        Class221.GL.glBegin(4);
        final int[] array = b;
        int i = 0;
    Label_0135_Outer:
        while (i < triangles.getTriangleCount()) {
            if (array == null) {
                int j = 0;
                while (true) {
                    while (j < 3) {
                        final float[] trianglePoint = triangles.getTrianglePoint(i, j);
                        final float[] preRenderPoint = class130.preRenderPoint(class129, trianglePoint[0], trianglePoint[1]);
                        if (array == null) {
                            Label_0125: {
                                Label_0109: {
                                    if (array == null) {
                                        if (preRenderPoint != null) {
                                            break Label_0109;
                                        }
                                        Class221.GL.glVertex2f(trianglePoint[0], trianglePoint[1]);
                                    }
                                    if (array == null) {
                                        break Label_0125;
                                    }
                                }
                                Class221.GL.glVertex2f(preRenderPoint[0], preRenderPoint[1]);
                            }
                            ++j;
                            if (array != null) {
                                break;
                            }
                            continue Label_0135_Outer;
                        }
                        else {
                            if (array != null) {
                                break Label_0135_Outer;
                            }
                            continue Label_0135_Outer;
                        }
                    }
                    ++i;
                    continue;
                }
            }
            return;
        }
        Class221.GL.glEnd();
    }
    
    private static void texture(final Class129 class129, final Class85 class130) {
        texture(class129, class130, 0.01f, 0.01f);
    }
    
    private static void textureFit(final Class129 class129, final Class85 class130) {
        textureFit(class129, class130, 1.0f, 1.0f);
    }
    
    public static final void texture(final Class129 class129, final Class85 class130, final float n, final float n2) {
        final int[] b = Class139.b();
        if (!validFill(class129)) {
            return;
        }
        final Class71 lastBind = Class154.getLastBind();
        class130.texture.bind();
        fill(class129, new Class251(n, n2, class130));
        class129.getPoints();
        final Class71 class131 = lastBind;
        if (b == null && class131 == null) {
            Class154.bindNone();
            if (b != null) {
                goto Label_0064;
            }
        }
        else {
            class131.bind();
        }
    }
    
    public static final void textureFit(final Class129 class129, final Class85 class130, final float n, final float n2) {
        final int[] b = Class139.b();
        Class129 class131 = class129;
        if (b == null) {
            if (!validFill(class129)) {
                return;
            }
            class131 = class129;
        }
        class131.getPoints();
        final Class71 lastBind = Class154.getLastBind();
        class130.texture.bind();
        class129.getX();
        class129.getY();
        class129.getMaxX();
        class129.getMaxY();
        fill(class129, new Class123(n, n2, class130));
        final Class71 class132 = lastBind;
        if (b == null && class132 == null) {
            Class154.bindNone();
            if (b != null) {
                goto Label_0089;
            }
        }
        else {
            class132.bind();
        }
    }
    
    public static final void fill(final Class129 class129, final Class356 class130) {
        final int[] b = Class139.b();
        if (!validFill(class129)) {
            return;
        }
        final Class71 lastBind = Class154.getLastBind();
        Class154.bindNone();
        class129.getCenter();
        fill(class129, new Class234(class130));
        final Class71 class131 = lastBind;
        if (b == null && class131 == null) {
            Class154.bindNone();
            if (b != null) {
                goto Label_0051;
            }
        }
        else {
            class131.bind();
        }
    }
    
    public static final void texture$41be2be8(final Class129 class129, final Class85 class130, final Class356 class131) {
        final int[] b = Class139.b();
        if (!validFill(class129)) {
            return;
        }
        final Class71 lastBind = Class154.getLastBind();
        class130.texture.bind();
        class129.getCenter();
        fill(class129, new Class99(class131, class130));
        final Class71 class132 = lastBind;
        if (b == null && class132 == null) {
            Class154.bindNone();
            if (b != null) {
                goto Label_0060;
            }
        }
        else {
            class132.bind();
        }
    }
    
    private static void texture(final Class129 class129, final Class85 class130, final Class304 class131) {
        final Class71 lastBind = Class154.getLastBind();
        class130.texture.bind();
        final int[] b = Class139.b();
        class129.getCenter();
        final int[] array = b;
        fill(class129, new Class34(class131));
        final Class71 class132 = lastBind;
        if (array == null && class132 == null) {
            Class154.bindNone();
            if (array != null) {
                goto Label_0049;
            }
        }
        else {
            class132.bind();
        }
    }
    
    static Class79 access$000() {
        return Class221.GL;
    }
    
    static {
        Class169.a(2500092197179008030L, 237668286354111471L, MethodHandles.lookup().lookupClass()).a(224998586868190L);
        Class221.GL = Class110.get();
        Class221.LSR = Class110.getLineStripRenderer();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
