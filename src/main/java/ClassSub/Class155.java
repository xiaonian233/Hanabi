package ClassSub;

import org.lwjgl.*;
import org.lwjgl.opengl.*;
import java.nio.*;
import java.lang.invoke.*;

public final class Class155 extends Class7
{
    private static final int TOLERANCE;
    private static int NONE;
    private static int MAX_VERTS;
    private int currentType;
    private float[] color;
    private float[] tex;
    private int vertIndex;
    private float[] verts;
    private float[] cols;
    private float[] texs;
    private FloatBuffer vertices;
    private FloatBuffer colors;
    private FloatBuffer textures;
    private int listMode;
    private static final long a;
    
    public Class155() {
        super();
        this.currentType = -1;
        this.color = new float[] { 1.0f, 1.0f, 1.0f, 1.0f };
        this.tex = new float[] { 0.0f, 0.0f };
        this.verts = new float[15000];
        this.cols = new float[20000];
        this.texs = new float[15000];
        this.vertices = BufferUtils.createFloatBuffer(15000);
        this.colors = BufferUtils.createFloatBuffer(20000);
        this.textures = BufferUtils.createFloatBuffer(10000);
        this.listMode = 0;
    }
    
    @Override
    public final void initDisplay(final int n, final int n2) {
        super.initDisplay(n, n2);
        this.vertIndex = 0;
        GL11.glEnableClientState(32884);
        GL11.glEnableClientState(32888);
        GL11.glEnableClientState(32886);
    }
    
    private void startBuffer() {
        this.vertIndex = 0;
    }
    
    private void flushBuffer() {
        final int[] b = Class139.b();
        int n2;
        int vertIndex;
        final int n = vertIndex = (n2 = this.vertIndex);
        if (b == null) {
            if (n == 0) {
                return;
            }
            final int n3;
            vertIndex = (n3 = (n2 = this.currentType));
        }
        int n5;
        final int n4 = n5 = -1;
        if (b == null) {
            if (n == n4) {
                return;
            }
            n2 = (vertIndex = this.vertIndex);
            final int n6;
            n5 = (n6 = 20);
        }
        if (b == null) {
            if (vertIndex < n4) {
                GL11.glBegin(this.currentType);
                int i = 0;
                while (i < this.vertIndex) {
                    GL11.glColor4f(this.cols[i * 4], this.cols[i * 4 + 1], this.cols[i * 4 + 2], this.cols[i * 4 + 3]);
                    GL11.glTexCoord2f(this.texs[i * 2], this.texs[i * 2 + 1]);
                    GL11.glVertex3f(this.verts[i * 3], this.verts[i * 3 + 1], this.verts[i * 3 + 2]);
                    ++i;
                    if (b != null) {
                        return;
                    }
                    if (b != null) {
                        break;
                    }
                }
                GL11.glEnd();
                this.currentType = -1;
                return;
            }
            this.vertices.clear();
            this.colors.clear();
            this.textures.clear();
            this.vertices.put(this.verts, 0, this.vertIndex * 3);
            this.colors.put(this.cols, 0, this.vertIndex * 4);
            this.textures.put(this.texs, 0, this.vertIndex * 2);
            this.vertices.flip();
            this.colors.flip();
            this.textures.flip();
            GL11.glVertexPointer(3, 0, this.vertices);
            GL11.glColorPointer(4, 0, this.colors);
            GL11.glTexCoordPointer(2, 0, this.textures);
            n2 = this.currentType;
            n5 = 0;
        }
        GL11.glDrawArrays(n2, n5, this.vertIndex);
        this.currentType = -1;
    }
    
    private void applyBuffer() {
        final int[] b = Class139.b();
        final int listMode = this.listMode;
        Class155 class155 = null;
        Label_0045: {
            if (b == null) {
                if (listMode > 0) {
                    return;
                }
                class155 = this;
                if (b != null) {
                    break Label_0045;
                }
                final int vertIndex = this.vertIndex;
            }
            if (listMode != 0) {
                this.flushBuffer();
                this.vertIndex = 0;
            }
            class155 = this;
        }
        class155.glColor4f(this.color[0], this.color[1], this.color[2], this.color[3]);
    }
    
    @Override
    public final void flush() {
        super.flush();
        this.applyBuffer();
    }
    
    @Override
    public final void glBegin(final int currentType) {
        final int[] b = Class139.b();
        final int listMode = this.listMode;
        Class155 class155 = null;
        Label_0054: {
            if (b == null) {
                if (listMode > 0) {
                    super.glBegin(currentType);
                    return;
                }
                class155 = this;
                if (b != null) {
                    break Label_0054;
                }
                final int currentType2 = this.currentType;
            }
            if (listMode == currentType) {
                return;
            }
            this.applyBuffer();
            class155 = this;
        }
        class155.currentType = currentType;
    }
    
    @Override
    public final void glColor4f(final float n, final float n2, final float n3, float n4) {
        n4 *= this.alphaScale;
        final int[] b = Class139.b();
        this.color[0] = n;
        final int[] array = b;
        this.color[1] = n2;
        this.color[2] = n3;
        this.color[3] = n4;
        Class155 class155 = this;
        if (array == null) {
            if (this.listMode <= 0) {
                return;
            }
            class155 = this;
        }
        class155.glColor4f(n, n2, n3, n4);
    }
    
    @Override
    public final void glEnd() {
        final int[] b = Class139.b();
        Class155 class155 = this;
        if (b == null) {
            if (this.listMode <= 0) {
                return;
            }
            class155 = this;
        }
        class155.glEnd();
    }
    
    @Override
    public final void glTexCoord2f(final float n, final float n2) {
        final int[] b = Class139.b();
        Class155 class155 = this;
        if (b == null) {
            if (this.listMode > 0) {
                super.glTexCoord2f(n, n2);
                return;
            }
            this.tex[0] = n;
            class155 = this;
        }
        class155.tex[1] = n2;
    }
    
    @Override
    public final void glVertex2f(final float n, final float n2) {
        final int[] b = Class139.b();
        Class155 class155 = this;
        if (b == null) {
            if (this.listMode > 0) {
                super.glVertex2f(n, n2);
                return;
            }
            class155 = this;
        }
        class155.glVertex3f(n, n2, 0.0f);
    }
    
    @Override
    public final void glVertex3f(final float n, final float n2, final float n3) {
        final int[] b = Class139.b();
        int n6;
        final int n5;
        final int n4 = n5 = (n6 = this.listMode);
        if (b == null) {
            if (n4 > 0) {
                super.glVertex3f(n, n2, n3);
                return;
            }
            this.verts[this.vertIndex * 3] = n;
            this.verts[this.vertIndex * 3 + 1] = n2;
            this.verts[this.vertIndex * 3 + 2] = n3;
            this.cols[this.vertIndex * 4] = this.color[0];
            this.cols[this.vertIndex * 4 + 1] = this.color[1];
            this.cols[this.vertIndex * 4 + 2] = this.color[2];
            this.cols[this.vertIndex * 4 + 3] = this.color[3];
            this.texs[this.vertIndex * 2] = this.tex[0];
            this.texs[this.vertIndex * 2 + 1] = this.tex[1];
            ++this.vertIndex;
            final int vertIndex = this.vertIndex;
        }
        final int n8;
        final int n9;
        if (b == null) {
            if (n4 <= 4950) {
                return;
            }
            final int vertIndex2 = this.vertIndex;
            final int currentType = this.currentType;
            final int n7 = vertIndex2;
            final int[] b2 = Class139.b();
            n8 = (n6 = currentType);
            if (b2 == null) {
                switch (n8) {
                    case 7: {
                        n9 = n7 % 4;
                        if (b2 == null && n9 != 0) {
                            break;
                        }
                        break;
                    }
                    case 4: {
                        final int n10 = n7 % 3;
                        if (b2 == null && n10 != 0) {
                            break;
                        }
                        break;
                    }
                    case 6913: {
                        final int n11 = n7 % 2;
                        if (b2 == null && n11 != 0) {
                            break;
                        }
                        break;
                    }
                }
            }
        }
        if (b == null) {
            if (n8 == 0) {
                return;
            }
            n6 = this.currentType;
        }
        final int currentType2 = n9;
        this.applyBuffer();
        this.currentType = currentType2;
    }
    
    private static boolean isSplittable(final int n, final int n2) {
        final int[] b = Class139.b();
        boolean b2 = n2 != 0;
        if (b == null) {
            switch (n2) {
                case 7: {
                    int n4;
                    final int n3 = n4 = n % 4;
                    if (b == null) {
                        if (n3 != 0) {
                            return false;
                        }
                        n4 = (true ? 1 : 0);
                    }
                    return n4 != 0;
                }
                case 4: {
                    int n6;
                    final int n5 = n6 = n % 3;
                    if (b == null) {
                        if (n5 != 0) {
                            return false;
                        }
                        n6 = (true ? 1 : 0);
                    }
                    return n6 != 0;
                }
                case 6913: {
                    int n8;
                    final int n7 = n8 = n % 2;
                    if (b == null) {
                        if (n7 != 0) {
                            return false;
                        }
                        n8 = (true ? 1 : 0);
                    }
                    return n8 != 0;
                }
                default: {
                    b2 = false;
                    break;
                }
            }
        }
        return b2;
    }
    
    @Override
    public final void glBindTexture(final int n, final int n2) {
        this.applyBuffer();
        super.glBindTexture(n, n2);
    }
    
    @Override
    public final void glBlendFunc(final int n, final int n2) {
        this.applyBuffer();
        super.glBlendFunc(n, n2);
    }
    
    @Override
    public final void glCallList(final int n) {
        this.applyBuffer();
        super.glCallList(n);
    }
    
    @Override
    public final void glClear(final int n) {
        this.applyBuffer();
        super.glClear(n);
    }
    
    @Override
    public final void glClipPlane(final int n, final DoubleBuffer doubleBuffer) {
        this.applyBuffer();
        super.glClipPlane(n, doubleBuffer);
    }
    
    @Override
    public final void glColorMask(final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        this.applyBuffer();
        super.glColorMask(b, b2, b3, b4);
    }
    
    @Override
    public final void glDisable(final int n) {
        this.applyBuffer();
        super.glDisable(n);
    }
    
    @Override
    public final void glEnable(final int n) {
        this.applyBuffer();
        super.glEnable(n);
    }
    
    @Override
    public final void glLineWidth(final float n) {
        this.applyBuffer();
        super.glLineWidth(n);
    }
    
    @Override
    public final void glPointSize(final float n) {
        this.applyBuffer();
        super.glPointSize(n);
    }
    
    @Override
    public final void glPopMatrix() {
        this.applyBuffer();
        super.glPopMatrix();
    }
    
    @Override
    public final void glPushMatrix() {
        this.applyBuffer();
        super.glPushMatrix();
    }
    
    @Override
    public final void glRotatef(final float n, final float n2, final float n3, final float n4) {
        this.applyBuffer();
        super.glRotatef(n, n2, n3, n4);
    }
    
    @Override
    public final void glScalef(final float n, final float n2, final float n3) {
        this.applyBuffer();
        super.glScalef(n, n2, n3);
    }
    
    @Override
    public final void glScissor(final int n, final int n2, final int n3, final int n4) {
        this.applyBuffer();
        super.glScissor(n, n2, n3, n4);
    }
    
    @Override
    public final void glTexEnvi(final int n, final int n2, final int n3) {
        this.applyBuffer();
        super.glTexEnvi(n, n2, n3);
    }
    
    @Override
    public final void glTranslatef(final float n, final float n2, final float n3) {
        this.applyBuffer();
        super.glTranslatef(n, n2, n3);
    }
    
    @Override
    public final void glEndList() {
        --this.listMode;
        super.glEndList();
    }
    
    @Override
    public final void glNewList(final int n, final int n2) {
        ++this.listMode;
        super.glNewList(n, n2);
    }
    
    @Override
    public final float[] getCurrentColor() {
        return this.color;
    }
    
    @Override
    public final void glLoadMatrix(final FloatBuffer floatBuffer) {
        this.flushBuffer();
        super.glLoadMatrix(floatBuffer);
    }
    
    static {
        Class169.a(1178996851398084266L, 6163501299649666222L, MethodHandles.lookup().lookupClass()).a(173097765804203L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean lIlIlIIIIlII$255f299(final int n) {
        return n > 4950;
    }
    
    private static boolean lIlIlIIIIIIl(final int n) {
        return n > 0;
    }
    
    private static boolean lIlIlIIIIIll(final int n, final int n2) {
        return n != n2;
    }
}
