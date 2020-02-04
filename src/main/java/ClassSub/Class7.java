package ClassSub;

import java.nio.*;
import org.lwjgl.opengl.*;

public class Class7 implements Class79
{
    private int width;
    private int height;
    private float[] current;
    protected float alphaScale;
    
    public Class7() {
        super();
        this.current = new float[] { 1.0f, 1.0f, 1.0f, 1.0f };
        this.alphaScale = 1.0f;
    }
    
    @Override
    public void initDisplay(final int width, final int height) {
        this.width = width;
        this.height = height;
        GL11.glGetString(7939);
        GL11.glEnable(3553);
        GL11.glShadeModel(7425);
        GL11.glDisable(2929);
        GL11.glDisable(2896);
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glClearDepth(1.0);
        GL11.glEnable(3042);
        GL11.glBlendFunc(770, 771);
        GL11.glViewport(0, 0, width, height);
        GL11.glMatrixMode(5888);
    }
    
    @Override
    public final void enterOrtho(final int n, final int n2) {
        GL11.glMatrixMode(5889);
        GL11.glLoadIdentity();
        GL11.glOrtho(0.0, (double)this.width, (double)this.height, 0.0, 1.0, -1.0);
        GL11.glMatrixMode(5888);
        GL11.glTranslatef((float)((this.width - n) / 2), (float)((this.height - n2) / 2), 0.0f);
    }
    
    @Override
    public void glBegin(final int n) {
        GL11.glBegin(n);
    }
    
    @Override
    public void glBindTexture(final int n, final int n2) {
        GL11.glBindTexture(n, n2);
    }
    
    @Override
    public void glBlendFunc(final int n, final int n2) {
        GL11.glBlendFunc(n, n2);
    }
    
    @Override
    public void glCallList(final int n) {
        GL11.glCallList(n);
    }
    
    @Override
    public void glClear(final int n) {
        GL11.glClear(n);
    }
    
    @Override
    public final void glClearColor(final float n, final float n2, final float n3, final float n4) {
        GL11.glClearColor(n, n2, n3, n4);
    }
    
    @Override
    public void glClipPlane(final int n, final DoubleBuffer doubleBuffer) {
        GL11.glClipPlane(n, doubleBuffer);
    }
    
    @Override
    public void glColor4f(final float n, final float n2, final float n3, float n4) {
        n4 *= this.alphaScale;
        GL11.glColor4f(this.current[0] = n, this.current[1] = n2, this.current[2] = n3, this.current[3] = n4);
    }
    
    @Override
    public void glColorMask(final boolean b, final boolean b2, final boolean b3, final boolean b4) {
        GL11.glColorMask(b, b2, b3, b4);
    }
    
    @Override
    public final void glCopyTexImage2D$69c647f5(final int n, final int n2, final int n3, final int n4, final int n5) {
        GL11.glCopyTexImage2D(3553, 0, n, n2, n3, n4, n5, 0);
    }
    
    @Override
    public final void glDeleteTextures(final IntBuffer intBuffer) {
        GL11.glDeleteTextures(intBuffer);
    }
    
    @Override
    public void glDisable(final int n) {
        GL11.glDisable(n);
    }
    
    @Override
    public void glEnable(final int n) {
        GL11.glEnable(n);
    }
    
    @Override
    public void glEnd() {
        GL11.glEnd();
    }
    
    @Override
    public void glEndList() {
        GL11.glEndList();
    }
    
    @Override
    public final int glGenLists$134621() {
        return GL11.glGenLists(200);
    }
    
    @Override
    public final void glGetFloat(final int n, final FloatBuffer floatBuffer) {
        GL11.glGetFloat(n, floatBuffer);
    }
    
    @Override
    public final void glGetInteger$63f29576(final IntBuffer intBuffer) {
        GL11.glGetInteger(3379, intBuffer);
    }
    
    @Override
    public final void glGetTexImage$671776bc(final int n, final ByteBuffer byteBuffer) {
        GL11.glGetTexImage(3553, 0, n, 5121, byteBuffer);
    }
    
    @Override
    public void glLineWidth(final float n) {
        GL11.glLineWidth(n);
    }
    
    @Override
    public final void glLoadIdentity() {
        GL11.glLoadIdentity();
    }
    
    @Override
    public void glNewList(final int n, final int n2) {
        GL11.glNewList(n, n2);
    }
    
    @Override
    public void glPointSize(final float n) {
        GL11.glPointSize(n);
    }
    
    @Override
    public void glPopMatrix() {
        GL11.glPopMatrix();
    }
    
    @Override
    public void glPushMatrix() {
        GL11.glPushMatrix();
    }
    
    @Override
    public final void glReadPixels$54cc639c(final int n, final int n2, final int n3, final int n4, final ByteBuffer byteBuffer) {
        GL11.glReadPixels(n, n2, n3, n4, 6408, 5121, byteBuffer);
    }
    
    @Override
    public void glRotatef(final float n, final float n2, final float n3, final float n4) {
        GL11.glRotatef(n, n2, n3, n4);
    }
    
    @Override
    public void glScalef(final float n, final float n2, final float n3) {
        GL11.glScalef(n, n2, n3);
    }
    
    @Override
    public void glScissor(final int n, final int n2, final int n3, final int n4) {
        GL11.glScissor(n, n2, n3, n4);
    }
    
    @Override
    public void glTexCoord2f(final float n, final float n2) {
        GL11.glTexCoord2f(n, n2);
    }
    
    @Override
    public void glTexEnvi(final int n, final int n2, final int n3) {
        GL11.glTexEnvi(n, n2, n3);
    }
    
    @Override
    public void glTranslatef(final float n, final float n2, final float n3) {
        GL11.glTranslatef(n, n2, n3);
    }
    
    @Override
    public void glVertex2f(final float n, final float n2) {
        GL11.glVertex2f(n, n2);
    }
    
    @Override
    public void glVertex3f(final float n, final float n2, final float n3) {
        GL11.glVertex3f(n, n2, n3);
    }
    
    @Override
    public void flush() {
    }
    
    @Override
    public final void glTexParameteri(final int n, final int n2, final int n3) {
        GL11.glTexParameteri(n, n2, n3);
    }
    
    @Override
    public float[] getCurrentColor() {
        return this.current;
    }
    
    @Override
    public final void glDeleteLists(final int n, final int n2) {
        GL11.glDeleteLists(n, n2);
    }
    
    @Override
    public final void glClearDepth(final float n) {
        GL11.glClearDepth((double)n);
    }
    
    @Override
    public final void glDepthFunc(final int n) {
        GL11.glDepthFunc(n);
    }
    
    @Override
    public final void glDepthMask(final boolean b) {
        GL11.glDepthMask(b);
    }
    
    @Override
    public final void setGlobalAlphaScale(final float alphaScale) {
        this.alphaScale = alphaScale;
    }
    
    @Override
    public void glLoadMatrix(final FloatBuffer floatBuffer) {
        GL11.glLoadMatrix(floatBuffer);
    }
    
    @Override
    public final void glGenTextures(final IntBuffer intBuffer) {
        GL11.glGenTextures(intBuffer);
    }
    
    @Override
    public final void glGetError() {
        GL11.glGetError();
    }
    
    @Override
    public final void glTexImage2D$57066784(final int n, final int n2, final int n3, final int n4, final ByteBuffer byteBuffer) {
        GL11.glTexImage2D(3553, 0, n, n2, n3, 0, n4, 5121, byteBuffer);
    }
    
    @Override
    public final void glTexSubImage2D$57066784(final int n, final int n2, final int n3, final int n4, final ByteBuffer byteBuffer) {
        GL11.glTexSubImage2D(3553, 0, n, n2, n3, n4, 32993, 5121, byteBuffer);
    }
    
    @Override
    public final boolean canTextureMirrorClamp() {
        return GLContext.getCapabilities().GL_EXT_texture_mirror_clamp;
    }
    
    @Override
    public final boolean canSecondaryColor() {
        return GLContext.getCapabilities().GL_EXT_secondary_color;
    }
    
    @Override
    public final void glSecondaryColor3ubEXT(final byte b, final byte b2, final byte b3) {
        EXTSecondaryColor.glSecondaryColor3ubEXT(b, b2, b3);
    }
}
