package ClassSub;

import java.nio.*;

public interface Class79
{
    public static final int GL_TEXTURE_2D;
    public static final int GL_RGBA;
    public static final int GL_RGB;
    public static final int GL_UNSIGNED_BYTE;
    public static final int GL_LINEAR;
    public static final int GL_NEAREST;
    public static final int GL_TEXTURE_MIN_FILTER;
    public static final int GL_TEXTURE_MAG_FILTER;
    public static final int GL_POINT_SMOOTH;
    public static final int GL_POLYGON_SMOOTH;
    public static final int GL_LINE_SMOOTH;
    public static final int GL_SCISSOR_TEST;
    public static final int GL_MODULATE;
    public static final int GL_TEXTURE_ENV;
    public static final int GL_TEXTURE_ENV_MODE;
    public static final int GL_QUADS;
    public static final int GL_POINTS;
    public static final int GL_LINES;
    public static final int GL_LINE_STRIP;
    public static final int GL_TRIANGLES;
    public static final int GL_TRIANGLE_FAN;
    public static final int GL_SRC_ALPHA;
    public static final int GL_ONE;
    public static final int GL_ONE_MINUS_DST_ALPHA;
    public static final int GL_DST_ALPHA;
    public static final int GL_ONE_MINUS_SRC_ALPHA;
    public static final int GL_COMPILE;
    public static final int GL_MAX_TEXTURE_SIZE;
    public static final int GL_COLOR_BUFFER_BIT;
    public static final int GL_DEPTH_BUFFER_BIT;
    public static final int GL_BLEND;
    public static final int GL_COLOR_CLEAR_VALUE;
    public static final int GL_LINE_WIDTH;
    public static final int GL_CLIP_PLANE0;
    public static final int GL_CLIP_PLANE1;
    public static final int GL_CLIP_PLANE2;
    public static final int GL_CLIP_PLANE3;
    public static final int GL_COMPILE_AND_EXECUTE;
    public static final int GL_RGBA8;
    public static final int GL_RGBA16;
    public static final int GL_BGRA;
    public static final int GL_MIRROR_CLAMP_TO_EDGE_EXT;
    public static final int GL_TEXTURE_WRAP_S;
    public static final int GL_TEXTURE_WRAP_T;
    public static final int GL_CLAMP;
    public static final int GL_COLOR_SUM_EXT;
    public static final int GL_ALWAYS;
    public static final int GL_DEPTH_TEST;
    public static final int GL_NOTEQUAL;
    public static final int GL_EQUAL;
    public static final int GL_SRC_COLOR;
    public static final int GL_ONE_MINUS_SRC_COLOR;
    public static final int GL_MODELVIEW_MATRIX;
    
    void flush();
    
    void initDisplay(final int p0, final int p1);
    
    void enterOrtho(final int p0, final int p1);
    
    void glClearColor(final float p0, final float p1, final float p2, final float p3);
    
    void glClipPlane(final int p0, final DoubleBuffer p1);
    
    void glScissor(final int p0, final int p1, final int p2, final int p3);
    
    void glLineWidth(final float p0);
    
    void glClear(final int p0);
    
    void glColorMask(final boolean p0, final boolean p1, final boolean p2, final boolean p3);
    
    void glLoadIdentity();
    
    void glGetInteger$63f29576(final IntBuffer p0);
    
    void glGetFloat(final int p0, final FloatBuffer p1);
    
    void glEnable(final int p0);
    
    void glDisable(final int p0);
    
    void glBindTexture(final int p0, final int p1);
    
    void glGetTexImage$671776bc(final int p0, final ByteBuffer p1);
    
    void glDeleteTextures(final IntBuffer p0);
    
    void glColor4f(final float p0, final float p1, final float p2, final float p3);
    
    void glTexCoord2f(final float p0, final float p1);
    
    void glVertex3f(final float p0, final float p1, final float p2);
    
    void glVertex2f(final float p0, final float p1);
    
    void glRotatef(final float p0, final float p1, final float p2, final float p3);
    
    void glTranslatef(final float p0, final float p1, final float p2);
    
    void glBegin(final int p0);
    
    void glEnd();
    
    void glTexEnvi(final int p0, final int p1, final int p2);
    
    void glPointSize(final float p0);
    
    void glScalef(final float p0, final float p1, final float p2);
    
    void glPushMatrix();
    
    void glPopMatrix();
    
    void glBlendFunc(final int p0, final int p1);
    
    int glGenLists$134621();
    
    void glNewList(final int p0, final int p1);
    
    void glEndList();
    
    void glCallList(final int p0);
    
    void glCopyTexImage2D$69c647f5(final int p0, final int p1, final int p2, final int p3, final int p4);
    
    void glReadPixels$54cc639c(final int p0, final int p1, final int p2, final int p3, final ByteBuffer p4);
    
    void glTexParameteri(final int p0, final int p1, final int p2);
    
    float[] getCurrentColor();
    
    void glDeleteLists(final int p0, final int p1);
    
    void glDepthMask(final boolean p0);
    
    void glClearDepth(final float p0);
    
    void glDepthFunc(final int p0);
    
    void setGlobalAlphaScale(final float p0);
    
    void glLoadMatrix(final FloatBuffer p0);
    
    void glGenTextures(final IntBuffer p0);
    
    void glGetError();
    
    void glTexImage2D$57066784(final int p0, final int p1, final int p2, final int p3, final ByteBuffer p4);
    
    void glTexSubImage2D$57066784(final int p0, final int p1, final int p2, final int p3, final ByteBuffer p4);
    
    boolean canTextureMirrorClamp();
    
    boolean canSecondaryColor();
    
    void glSecondaryColor3ubEXT(final byte p0, final byte p1, final byte p2);
}
