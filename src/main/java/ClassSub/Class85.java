package ClassSub;

import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public class Class85 implements Class299
{
    private static int TOP_LEFT;
    private static int TOP_RIGHT;
    private static int BOTTOM_RIGHT;
    private static int BOTTOM_LEFT;
    private static Class79 GL;
    private static Class85 inUse;
    private static int FILTER_LINEAR;
    private static int FILTER_NEAREST;
    Class71 texture;
    private int width;
    private int height;
    private float textureWidth;
    float textureHeight;
    private float textureOffsetX;
    float textureOffsetY;
    private float angle;
    private float alpha;
    private String ref;
    private boolean inited;
    byte[] pixelData;
    private boolean destroyed;
    private float centerX;
    private float centerY;
    private String name;
    private Class286[] corners;
    int filter;
    private boolean flipped;
    private Class286 transparent;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map e;
    private static final String[] llIIllIIIII;
    
    protected Class85(final Class85 class85) {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        this.width = class85.getWidth();
        this.height = class85.getHeight();
        this.texture = class85.texture;
        this.textureWidth = class85.textureWidth;
        this.textureHeight = class85.textureHeight;
        this.ref = class85.ref;
        this.textureOffsetX = class85.textureOffsetX;
        this.textureOffsetY = class85.textureOffsetY;
        this.centerX = this.width / 2;
        this.centerY = this.height / 2;
        this.inited = true;
    }
    
    protected Class85() {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
    }
    
    private Class85(final Class71 texture) {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        this.texture = texture;
        this.ref = texture.toString();
        final int[] b = Class139.b();
        final Class79 gl = Class85.GL;
        if (b == null) {
            if (gl.canTextureMirrorClamp()) {
                Class85.GL.glTexParameteri(3553, 10242, 34627);
                Class85.GL.glTexParameteri(3553, 10243, 34627);
                if (b == null) {
                    return;
                }
            }
            Class85.GL.glTexParameteri(3553, 10242, 10496);
            final Class79 gl2 = Class85.GL;
        }
        gl.glTexParameteri(3553, 10243, 10496);
    }
    
    public Class85(final String s) throws Class119 {
        this(s, (byte)0);
    }
    
    private Class85(final String s, final Class286 class286) throws Class119 {
        this(s, 1, class286);
    }
    
    private Class85(final String s, final byte b) throws Class119 {
        this(s, '\0');
    }
    
    private Class85(final String s, final char c) throws Class119 {
        this(s, 1, null);
    }
    
    public Class85(final String ref, final int n, final Class286 class286) throws Class119 {
        final int[] b = Class139.b();
        super();
        this.alpha = 1.0f;
        this.inited = false;
        final int[] array = b;
        this.filter = 9729;
        int filter = n;
        if (array == null) {
            if (n == 1) {
                filter = 9729;
            }
            else {
                filter = 9728;
            }
        }
        this.filter = filter;
        this.ref = ref;
        int[] array2 = null;
        try {
            if (class286 != null) {
                (array2 = new int[3])[0] = (int)(class286.r * 255.0f);
                array2[1] = (int)(class286.g * 255.0f);
                array2[2] = (int)(class286.b * 255.0f);
            }
            this.texture = Class294.get().getTexture(Class5.getResourceAsStream(ref), ref, false, this.filter, array2);
        }
        catch (IOException ex2) {
            final IOException ex = ex2;
            Class355.error(ex2);
            throw new Class119(String.valueOf(new StringBuilder("Failed to load image from: ").append(ref)), ex);
        }
    }
    
    private void setFilter(final int n) {
        final int[] b = Class139.b();
        int filter = n;
        if (b == null) {
            if (n == 1) {
                filter = 9729;
            }
            else {
                filter = 9728;
            }
        }
        this.filter = filter;
        this.texture.bind();
        Class85.GL.glTexParameteri(3553, 10241, this.filter);
        Class85.GL.glTexParameteri(3553, 10240, this.filter);
    }
    
    public Class85(final int n, final int n2) throws Class119 {
        this(n, n2, (byte)0);
    }
    
    private Class85(final int n, final int n2, final byte b) throws Class119 {
        final int[] b2 = Class139.b();
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        final int[] array = b2;
        this.ref = super.toString();
        int filter = 2;
        if (array == null) {
            filter = 9728;
        }
        this.filter = filter;
        try {
            this.texture = Class294.get().createTexture(n, n2, this.filter);
            this.init();
        }
        catch (IOException ex) {
            Class355.error(ex);
            throw new Class119(String.valueOf(new StringBuilder("Failed to create empty image ").append(n).append(Class85.llIIllIIIII[0]).append(n2)));
        }
    }
    
    public Class85(final InputStream inputStream, final String s) throws Class119 {
        this(inputStream, s, (byte)0);
    }
    
    private Class85(final InputStream inputStream, final String s, byte ref) throws Class119 {
        super();
        this.alpha = 1.0f;
        this.inited = false;
        this.filter = 9729;
        ref = (byte)s;
        Class139.b();
        this.filter = 1;
        this.ref = (String)ref;
        try {
            this.texture = Class294.get().getTexture(inputStream, (String)ref, false, this.filter, null);
        }
        catch (IOException ex2) {
            final IOException ex = ex2;
            Class355.error(ex2);
            throw new Class119(String.valueOf(new StringBuilder("Failed to load image from: ").append((String)ref)), ex);
        }
    }
    
    Class85(final Class235 class235) {
        this(class235, 1);
        Class154.bindNone();
    }
    
    Class85(final Class235 class235, final int n) {
        this((Class78)class235, n);
        Class154.bindNone();
    }
    
    private Class85(final Class78 class78) {
        this(class78, 1);
    }
    
    private Class85(final Class78 class78, final int n) {
        super();
        this.alpha = 1.0f;
        final int[] b = Class139.b();
        this.inited = false;
        final int[] array = b;
        this.filter = 9729;
        int filter = n;
        final int[] array2 = array;
        try {
            if (array2 == null) {
                if (n == 1) {
                    filter = 9729;
                }
                else {
                    filter = 9728;
                }
            }
            this.filter = filter;
            this.texture = Class294.get().getTexture(class78, this.filter);
            this.ref = this.texture.toString();
        }
        catch (IOException ex) {
            Class355.error(ex);
        }
    }
    
    private int getFilter() {
        return this.filter;
    }
    
    private String getResourceReference() {
        return this.ref;
    }
    
    private void setImageColor(final float n, final float n2, final float n3, final float n4) {
        this.setColor(0, n, n2, n3, n4);
        this.setColor(1, n, n2, n3, n4);
        this.setColor(3, n, n2, n3, n4);
        this.setColor(2, n, n2, n3, n4);
    }
    
    private void setImageColor(final float n, final float n2, final float n3) {
        this.setColor(0, n, n2, n3);
        this.setColor(1, n, n2, n3);
        this.setColor(3, n, n2, n3);
        this.setColor(2, n, n2, n3);
    }
    
    private void setColor(final int n, final float r, final float g, final float b, final float a) {
        final int[] b2 = Class139.b();
        final Class286[] corners = this.corners;
        if (b2 == null) {
            if (corners == null) {
                this.corners = new Class286[] { new Class286(1.0f, 1.0f, 1.0f, 1.0f), new Class286(1.0f, 1.0f, 1.0f, 1.0f), new Class286(1.0f, 1.0f, 1.0f, 1.0f), new Class286(1.0f, 1.0f, 1.0f, 1.0f) };
            }
            this.corners[n].r = r;
            this.corners[n].g = g;
            this.corners[n].b = b;
            final Class286[] corners2 = this.corners;
        }
        corners[n].a = a;
    }
    
    private void setColor(final int n, final float r, final float g, final float b) {
        final int[] b2 = Class139.b();
        final Class286[] corners = this.corners;
        if (b2 == null) {
            if (corners == null) {
                this.corners = new Class286[] { new Class286(1.0f, 1.0f, 1.0f, 1.0f), new Class286(1.0f, 1.0f, 1.0f, 1.0f), new Class286(1.0f, 1.0f, 1.0f, 1.0f), new Class286(1.0f, 1.0f, 1.0f, 1.0f) };
            }
            this.corners[n].r = r;
            this.corners[n].g = g;
            final Class286[] corners2 = this.corners;
        }
        corners[n].b = b;
    }
    
    private static void clampTexture() {
        final int[] b = Class139.b();
        final Class79 gl = Class85.GL;
        if (b == null) {
            if (gl.canTextureMirrorClamp()) {
                Class85.GL.glTexParameteri(3553, 10242, 34627);
                Class85.GL.glTexParameteri(3553, 10243, 34627);
                if (b == null) {
                    return;
                }
            }
            Class85.GL.glTexParameteri(3553, 10242, 10496);
            final Class79 gl2 = Class85.GL;
        }
        gl.glTexParameteri(3553, 10243, 10496);
    }
    
    private void setName(final String name) {
        this.name = name;
    }
    
    private String getName() {
        return this.name;
    }
    
    private Class55 getGraphics() throws Class119 {
        return Class260.getGraphicsForImage(this);
    }
    
    private void load$6e1ab635(final InputStream inputStream, final String ref, final boolean b, final int n) throws Class119 {
        final int[] b2 = Class139.b();
        int filter = n;
        if (b2 == null) {
            if (n == 1) {
                filter = 9729;
            }
            else {
                filter = 9728;
            }
        }
        this.filter = filter;
        this.ref = ref;
        try {
            this.texture = Class294.get().getTexture(inputStream, ref, b, this.filter, null);
        }
        catch (IOException ex2) {
            final IOException ex = ex2;
            Class355.error(ex2);
            throw new Class119(String.valueOf(new StringBuilder("Failed to load image from: ").append(ref)), ex);
        }
    }
    
    public final void bind() {
        this.texture.bind();
    }
    
    private void reinit() {
        this.inited = false;
        this.init();
    }
    
    protected final void init() {
        final int[] b = Class139.b();
        Class85 class85 = this;
        Class85 class86 = this;
        if (b == null) {
            if (this.inited) {
                return;
            }
            this.inited = true;
            class85 = this;
            class86 = this;
        }
        if (b == null) {
            if (class86.texture != null) {
                this.width = this.texture.getImageWidth();
                this.height = this.texture.getImageHeight();
                this.textureOffsetX = 0.0f;
                this.textureOffsetY = 0.0f;
                this.textureWidth = this.texture.getWidth();
                this.textureHeight = this.texture.getHeight();
            }
            this.initImpl();
            this.centerX = this.width / 2;
            class85 = this;
        }
        class85.centerY = this.height / 2;
    }
    
    protected void initImpl() {
    }
    
    private void draw() {
        this.draw(0.0f, 0.0f);
    }
    
    private void drawCentered(final float n, final float n2) {
        this.draw(n - this.getWidth() / 2, n2 - this.getHeight() / 2);
    }
    
    @Override
    public final void draw(final float n, final float n2) {
        this.init();
        this.draw(n, n2, this.width, this.height);
    }
    
    public final void draw$51bfc3f3(final Class286 class286) {
        this.init();
        this.draw(0.0f, 0.0f, this.width, this.height, class286);
    }
    
    public final void drawEmbedded(final float n, final float n2, final float n3, final float n4) {
        final int[] b = Class139.b();
        this.init();
        final int[] array = b;
        final Class286[] corners = this.corners;
        if (array == null) {
            if (corners == null) {
                Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY);
                Class85.GL.glVertex3f(n, n2, 0.0f);
                Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY + this.textureHeight);
                Class85.GL.glVertex3f(n, n2 + n4, 0.0f);
                Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY + this.textureHeight);
                Class85.GL.glVertex3f(n + n3, n2 + n4, 0.0f);
                Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY);
                Class85.GL.glVertex3f(n + n3, n2, 0.0f);
                if (array == null) {
                    return;
                }
            }
            this.corners[0].bind();
            Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY);
            Class85.GL.glVertex3f(n, n2, 0.0f);
            this.corners[3].bind();
            Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY + this.textureHeight);
            Class85.GL.glVertex3f(n, n2 + n4, 0.0f);
            this.corners[2].bind();
            Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY + this.textureHeight);
            Class85.GL.glVertex3f(n + n3, n2 + n4, 0.0f);
            final Class286[] corners2 = this.corners;
        }
        corners[1].bind();
        Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY);
        Class85.GL.glVertex3f(n + n3, n2, 0.0f);
    }
    
    public final float getTextureOffsetX() {
        this.init();
        return this.textureOffsetX;
    }
    
    public final float getTextureOffsetY() {
        this.init();
        return this.textureOffsetY;
    }
    
    public final float getTextureWidth() {
        this.init();
        return this.textureWidth;
    }
    
    public final float getTextureHeight() {
        this.init();
        return this.textureHeight;
    }
    
    private void draw(final float n, final float n2, final float n3) {
        this.init();
        this.draw(n, n2, this.width * n3, this.height * n3, Class286.white);
    }
    
    private void draw(final float n, final float n2, final float n3, final Class286 class286) {
        this.init();
        this.draw(n, n2, this.width * n3, this.height * n3, class286);
    }
    
    private void draw(final float n, final float n2, final float n3, final float n4) {
        this.init();
        this.draw(n, n2, n3, n4, Class286.white);
    }
    
    private void drawSheared(final float n, float n2, float n3, float n4) {
        final float n5 = n2;
        final float n6 = n3;
        final float n7 = n4;
        Class286 white = Class286.white;
        final float n8 = n7;
        n4 = n6;
        n3 = n5;
        n2 = n;
        final int[] b = Class139.b();
        if (this.alpha != 1.0f) {
            Class286 class287;
            Class286 class286 = class287 = white;
            if (b == null) {
                class287 = (white = (class286 = new Class286(white)));
            }
            class286.a = class287.a * this.alpha;
        }
        final Class286 class288 = white;
        if (b != null || class288 != null) {
            class288.bind();
        }
        this.texture.bind();
        Class85.GL.glTranslatef(n2, n3, 0.0f);
        final float n9 = fcmpl(this.angle, 0.0f);
        if (b == null) {
            if (n9 != 0) {
                Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
                Class85.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
                Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
            }
            Class85.GL.glBegin(7);
            this.init();
            Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY);
            Class85.GL.glVertex3f(0.0f, 0.0f, 0.0f);
            Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY + this.textureHeight);
            Class85.GL.glVertex3f(n4, this.height, 0.0f);
            Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY + this.textureHeight);
            Class85.GL.glVertex3f(this.width + n4, this.height + n8, 0.0f);
            Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY);
            Class85.GL.glVertex3f(this.width, n8, 0.0f);
            Class85.GL.glEnd();
            if (b != null) {
                return;
            }
            final float n10 = fcmpl(this.angle, 0.0f);
        }
        if (n9 != 0) {
            Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class85.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class85.GL.glTranslatef(-n2, -n3, 0.0f);
    }
    
    private void drawSheared(final float n, final float n2, final float n3, final float n4, Class286 white) {
        final int[] b = Class139.b();
        if (this.alpha != 1.0f) {
            Class286 class287;
            final Class286 class286 = class287 = white;
            if (b == null) {
                if (class286 == null) {
                    white = Class286.white;
                }
                class287 = (white = new Class286(white));
            }
            class287.a = class286.a * this.alpha;
        }
        final Class286 class288 = white;
        if (b != null || class288 != null) {
            class288.bind();
        }
        this.texture.bind();
        Class85.GL.glTranslatef(n, n2, 0.0f);
        final float n5 = fcmpl(this.angle, 0.0f);
        if (b == null) {
            if (n5 != 0) {
                Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
                Class85.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
                Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
            }
            Class85.GL.glBegin(7);
            this.init();
            Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY);
            Class85.GL.glVertex3f(0.0f, 0.0f, 0.0f);
            Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY + this.textureHeight);
            Class85.GL.glVertex3f(n3, this.height, 0.0f);
            Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY + this.textureHeight);
            Class85.GL.glVertex3f(this.width + n3, this.height + n4, 0.0f);
            Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY);
            Class85.GL.glVertex3f(this.width, n4, 0.0f);
            Class85.GL.glEnd();
            if (b != null) {
                return;
            }
            final float n6 = fcmpl(this.angle, 0.0f);
        }
        if (n5 != 0) {
            Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class85.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class85.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    public final void draw(final float n, final float n2, final float n3, final float n4, Class286 white) {
        final int[] b = Class139.b();
        if (this.alpha != 1.0f) {
            Class286 class287;
            final Class286 class286 = class287 = white;
            if (b == null) {
                if (class286 == null) {
                    white = Class286.white;
                }
                class287 = (white = new Class286(white));
            }
            class287.a = class286.a * this.alpha;
        }
        final Class286 class288 = white;
        if (b != null || class288 != null) {
            class288.bind();
        }
        this.texture.bind();
        Class85.GL.glTranslatef(n, n2, 0.0f);
        final float n5 = fcmpl(this.angle, 0.0f);
        if (b == null) {
            if (n5 != 0) {
                Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
                Class85.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
                Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
            }
            Class85.GL.glBegin(7);
            this.drawEmbedded(0.0f, 0.0f, n3, n4);
            Class85.GL.glEnd();
            if (b != null) {
                return;
            }
            final float n6 = fcmpl(this.angle, 0.0f);
        }
        if (n5 != 0) {
            Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class85.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class85.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    private void drawFlash(final float n, final float n2, final float n3, final float n4) {
        this.drawFlash(n, n2, n3, n4, Class286.white);
    }
    
    private void setCenterOfRotation(final float centerX, final float centerY) {
        this.centerX = centerX;
        this.centerY = centerY;
    }
    
    private float getCenterOfRotationX() {
        this.init();
        return this.centerX;
    }
    
    private float getCenterOfRotationY() {
        this.init();
        return this.centerY;
    }
    
    public final void drawFlash(final float n, final float n2, final float n3, final float n4, final Class286 class286) {
        this.init();
        final int[] b = Class139.b();
        class286.bind();
        final int[] array = b;
        this.texture.bind();
        float n8;
        int n7;
        float n6;
        final int n5 = (int)(n6 = (n7 = (int)(n8 = (Class85.GL.canSecondaryColor() ? 1 : 0))));
        if (array == null) {
            if (n5 != 0) {
                Class85.GL.glEnable(33880);
                Class85.GL.glSecondaryColor3ubEXT((byte)(class286.r * 255.0f), (byte)(class286.g * 255.0f), (byte)(class286.b * 255.0f));
            }
            Class85.GL.glTexEnvi(8960, 8704, 8448);
            Class85.GL.glTranslatef(n, n2, 0.0f);
            n7 = (int)(n6 = (n8 = fcmpl(this.angle, 0.0f)));
        }
        if (array == null) {
            if (n6 != 0) {
                Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
                Class85.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
                Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
            }
            Class85.GL.glBegin(7);
            this.drawEmbedded(0.0f, 0.0f, n3, n4);
            Class85.GL.glEnd();
            n8 = (n7 = fcmpl(this.angle, 0.0f));
        }
        final Class79 gl;
        Label_0302: {
            if (array == null) {
                if (n7 != 0) {
                    Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
                    Class85.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
                    Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
                }
                Class85.GL.glTranslatef(-n, -n2, 0.0f);
                gl = Class85.GL;
                if (array != null) {
                    break Label_0302;
                }
                n8 = (gl.canSecondaryColor() ? 1 : 0);
            }
            if (n8 == 0) {
                return;
            }
            final Class79 gl2 = Class85.GL;
        }
        gl.glDisable(33880);
    }
    
    private void drawFlash(float n, final float n2) {
        this.drawFlash(n, n2, this.getWidth(), n = this.getHeight(), Class286.white);
    }
    
    private void setRotation(final float n) {
        this.angle = n % 360.0f;
    }
    
    private float getRotation() {
        return this.angle;
    }
    
    private float getAlpha() {
        return this.alpha;
    }
    
    private void setAlpha(final float alpha) {
        this.alpha = alpha;
    }
    
    private void rotate(final float n) {
        this.angle += n;
        this.angle %= 360.0f;
    }
    
    public final Class85 getSubImage(final int n, final int n2, final int width, final int height) {
        this.init();
        final float textureOffsetX = n / this.width * this.textureWidth + this.textureOffsetX;
        final float textureOffsetY = n2 / this.height * this.textureHeight + this.textureOffsetY;
        final float textureWidth = width / this.width * this.textureWidth;
        final float textureHeight = height / this.height * this.textureHeight;
        final Class85 class85;
        (class85 = new Class85()).inited = true;
        class85.texture = this.texture;
        class85.textureOffsetX = textureOffsetX;
        class85.textureOffsetY = textureOffsetY;
        class85.textureWidth = textureWidth;
        class85.textureHeight = textureHeight;
        class85.width = width;
        class85.height = height;
        class85.ref = this.ref;
        class85.centerX = width / 2;
        class85.centerY = height / 2;
        return class85;
    }
    
    private void draw(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        this.draw(n, n2, n + this.width, n2 + this.height, n3, n4, n5, n6);
    }
    
    public final void draw(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        this.draw(n, n2, n3, n4, n5, n6, n7, n8, Class286.white);
    }
    
    public final void draw(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8, Class286 white) {
        final int[] b = Class139.b();
        this.init();
        final int[] array = b;
        float n10;
        final float n9 = n10 = fcmpl(this.alpha, 1.0f);
        if (array == null) {
            if (n9 != 0) {
                Class286 class287;
                final Class286 class286 = class287 = white;
                if (array == null) {
                    if (class286 == null) {
                        white = Class286.white;
                    }
                    class287 = (white = new Class286(white));
                }
                class287.a = class286.a * this.alpha;
            }
            white.bind();
            this.texture.bind();
            Class85.GL.glTranslatef(n, n2, 0.0f);
            final int n11;
            n10 = (n11 = fcmpl(this.angle, 0.0f));
        }
        if (array == null) {
            if (n9 != 0) {
                Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
                Class85.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
                Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
            }
            Class85.GL.glBegin(7);
            this.drawEmbedded$b83c98b(n3 - n, n4 - n2, n5, n6, n7, n8);
            Class85.GL.glEnd();
            if (array != null) {
                return;
            }
            n10 = fcmpl(this.angle, 0.0f);
        }
        if (n10 != 0) {
            Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class85.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class85.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    private void drawEmbedded$b83c98b(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        this.drawEmbedded$36c95833$b83c98b(n, n2, n3, n4, n5, n6);
    }
    
    private void drawEmbedded$36c95833$b83c98b(final float n, final float n2, float n3, float n4, float n5, float n6) {
        final int[] b = Class139.b();
        final Class286 class286 = null;
        if (b != null) {
            class286.bind();
        }
        n5 -= n3;
        n6 -= n4;
        n3 = n3 / this.width * this.textureWidth + this.textureOffsetX;
        n4 = n4 / this.height * this.textureHeight + this.textureOffsetY;
        n5 = n5 / this.width * this.textureWidth;
        n6 = n6 / this.height * this.textureHeight;
        Class85.GL.glTexCoord2f(n3, n4);
        Class85.GL.glVertex3f(0.0f, 0.0f, 0.0f);
        Class85.GL.glTexCoord2f(n3, n4 + n6);
        Class85.GL.glVertex3f(0.0f, n2 + 0.0f, 0.0f);
        Class85.GL.glTexCoord2f(n3 + n5, n4 + n6);
        Class85.GL.glVertex3f(n + 0.0f, n2 + 0.0f, 0.0f);
        Class85.GL.glTexCoord2f(n3 + n5, n4);
        Class85.GL.glVertex3f(n + 0.0f, 0.0f, 0.0f);
    }
    
    private void drawWarped(final float n, final float n2, final float n3, final float n4, final float n5, final float n6, final float n7, final float n8) {
        Class286.white.bind();
        this.texture.bind();
        final int[] b = Class139.b();
        Class85.GL.glTranslatef(n, n2, 0.0f);
        final int[] array = b;
        final float n9 = fcmpl(this.angle, 0.0f);
        if (array == null) {
            if (n9 != 0) {
                Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
                Class85.GL.glRotatef(this.angle, 0.0f, 0.0f, 1.0f);
                Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
            }
            Class85.GL.glBegin(7);
            this.init();
            Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY);
            Class85.GL.glVertex3f(0.0f, 0.0f, 0.0f);
            Class85.GL.glTexCoord2f(this.textureOffsetX, this.textureOffsetY + this.textureHeight);
            Class85.GL.glVertex3f(n3 - n, n4 - n2, 0.0f);
            Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY + this.textureHeight);
            Class85.GL.glVertex3f(n5 - n, n6 - n2, 0.0f);
            Class85.GL.glTexCoord2f(this.textureOffsetX + this.textureWidth, this.textureOffsetY);
            Class85.GL.glVertex3f(n7 - n, n8 - n2, 0.0f);
            Class85.GL.glEnd();
            if (array != null) {
                return;
            }
            final float n10 = fcmpl(this.angle, 0.0f);
        }
        if (n9 != 0) {
            Class85.GL.glTranslatef(this.centerX, this.centerY, 0.0f);
            Class85.GL.glRotatef(-this.angle, 0.0f, 0.0f, 1.0f);
            Class85.GL.glTranslatef(-this.centerX, -this.centerY, 0.0f);
        }
        Class85.GL.glTranslatef(-n, -n2, 0.0f);
    }
    
    public final int getWidth() {
        this.init();
        return this.width;
    }
    
    public final int getHeight() {
        this.init();
        return this.height;
    }
    
    private Class85 copy() {
        this.init();
        return this.getSubImage(0, 0, this.width, this.height);
    }
    
    private Class85 getScaledCopy(final float n) {
        this.init();
        final int n2 = (int)(this.width * n);
        final int height = (int)(this.height * n);
        final int width = n2;
        this.init();
        final Class85 copy;
        (copy = this.copy()).width = width;
        copy.height = height;
        copy.centerX = width / 2;
        copy.centerY = height / 2;
        return copy;
    }
    
    private Class85 getScaledCopy(final int width, final int height) {
        this.init();
        final Class85 copy;
        (copy = this.copy()).width = width;
        copy.height = height;
        copy.centerX = width / 2;
        copy.centerY = height / 2;
        return copy;
    }
    
    private void ensureInverted() {
        final int[] b = Class139.b();
        Class85 class85 = this;
        if (b == null) {
            if (this.textureHeight <= 0.0f) {
                return;
            }
            this.textureOffsetY += this.textureHeight;
            class85 = this;
        }
        class85.textureHeight = -this.textureHeight;
    }
    
    private Class85 getFlippedCopy(final boolean b, final boolean b2) {
        final int[] b3 = Class139.b();
        this.init();
        final Class85 copy = this.copy();
        final int[] array = b3;
        boolean b4 = b;
        if (array == null) {
            if (b) {
                copy.textureOffsetX = this.textureOffsetX + this.textureWidth;
                copy.textureWidth = -this.textureWidth;
            }
            b4 = b2;
        }
        if (b4) {
            copy.textureOffsetY = this.textureOffsetY + this.textureHeight;
            copy.textureHeight = -this.textureHeight;
        }
        return copy;
    }
    
    public void endUse() {
        if (Class139.b() == null) {
            if (Class85.inUse != this) {
                throw new RuntimeException("The sprite sheet is not currently in use");
            }
            Class85.inUse = null;
            Class85.GL.glEnd();
        }
    }
    
    public void startUse() {
        final int[] b = Class139.b();
        final Class85 inUse = Class85.inUse;
        if (b == null) {
            if (inUse != null) {
                throw new RuntimeException("Attempt to start use of a sprite sheet before ending use with another - see endUse()");
            }
            (Class85.inUse = this).init();
            Class286.white.bind();
        }
        inUse.texture.bind();
        Class85.GL.glBegin(7);
    }
    
    @Override
    public String toString() {
        this.init();
        return String.valueOf(new StringBuilder("[Image ").append(this.ref).append(Class85.llIIllIIIII[1]).append(this.width).append(Class85.llIIllIIIII[2]).append(this.height).append("  ").append(this.textureOffsetX).append(Class85.llIIllIIIII[3]).append(this.textureOffsetY).append(Class85.llIIllIIIII[4]).append(this.textureWidth).append(Class85.llIIllIIIII[5]).append(this.textureHeight).append(Class85.llIIllIIIII[6]));
    }
    
    private Class71 getTexture() {
        return this.texture;
    }
    
    public void setTexture(final Class71 texture) {
        this.texture = texture;
        this.inited = false;
        this.init();
    }
    
    private static int translate(final byte b) {
        final int[] b2 = Class139.b();
        byte b3 = b;
        if (b2 == null) {
            if (b < 0) {
                return b + 256;
            }
            b3 = b;
        }
        return b3;
    }
    
    private Class286 getColor(int n, int n2) {
        final int[] b = Class139.b();
        Class85 class85 = this;
        if (b == null) {
            if (this.pixelData == null) {
                this.pixelData = this.texture.getTextureData();
            }
            class85 = this;
        }
        final int n3 = (int)(class85.textureOffsetX * this.texture.getTextureWidth());
        final int n4 = (int)(this.textureOffsetY * this.texture.getTextureHeight());
        final float n5 = fcmpg(this.textureWidth, 0.0f);
        if (b == null && n5 < 0) {
            n = n3 - n;
            if (b != null) {
                goto Label_0094;
            }
        }
        else {
            n = (int)n5;
        }
        final float n6 = fcmpg(this.textureHeight, 0.0f);
        if (b == null && n6 < 0) {
            n2 = n4 - n2;
            if (b != null) {
                goto Label_0129;
            }
        }
        else {
            n2 = (int)n6;
        }
        final int n7 = n + n2 * this.texture.getTextureWidth();
        final int hasAlpha = this.texture.hasAlpha() ? 1 : 0;
        if (b == null && hasAlpha == 0) {}
        n = n7 * hasAlpha;
        if (this.texture.hasAlpha()) {
            return new Class286(translate(this.pixelData[n]), translate(this.pixelData[n + 1]), translate(this.pixelData[n + 2]), translate(this.pixelData[n + 3]));
        }
        return new Class286(translate(this.pixelData[n]), translate(this.pixelData[n + 1]), translate(this.pixelData[n + 2]));
    }
    
    private boolean isDestroyed() {
        return this.destroyed;
    }
    
    public final void destroy() throws Class119 {
        final int[] b = Class139.b();
        Class85 class85 = this;
        if (b == null) {
            if (this.destroyed) {
                return;
            }
            this.destroyed = true;
            this.texture.release();
            class85 = this;
        }
        Class260.releaseGraphicsForImage(class85);
    }
    
    private void flushPixelData() {
        this.pixelData = null;
    }
    
    static {
        lIIIllIIlllII();
        Class169.a(3263710848645098703L, 6613021680803994094L, MethodHandles.lookup().lookupClass()).a(141602662595313L);
        e = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class85.llIIllIIIII[7]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class85.llIIllIIIII[8]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(44829947180466L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[7];
        int n2 = 0;
        String s;
        int n3 = (s = Class85.llIIllIIIII[9]).length();
        int n4 = 56;
        int n5 = -1;
    Label_0152:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class85.llIIllIIIII[11]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class85.llIIllIIIII[10]).length();
                            n4 = 48;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0152;
                        }
                    }
                    ++n5;
                    final String s4 = s;
                    final int n8 = n5;
                    s3 = s4.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        c = c2;
        d = new String[7];
        Class85.GL = Class110.get();
    }
    
    private static Exception a(final Exception ex) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x57EA;
        if (Class85.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class85.e.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class85.llIIllIIIII[12]);
                    array[1] = SecretKeyFactory.getInstance(Class85.llIIllIIIII[13]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class85.e.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class85.llIIllIIIII[14], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class85.d[n3] = a(((Cipher)array[0]).doFinal(Class85.c[n3].getBytes(Class85.llIIllIIIII[15])));
        }
        return Class85.d[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class85.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIllIIlllII() {
        (llIIllIIIII = new String[19])[0] = "x";
        Class85.llIIllIIIII[1] = " ";
        Class85.llIIllIIIII[2] = "x";
        Class85.llIIllIIIII[3] = ",";
        Class85.llIIllIIIII[4] = ",";
        Class85.llIIllIIIII[5] = ",";
        Class85.llIIllIIIII[6] = "]";
        Class85.llIIllIIIII[7] = "DES/CBC/PKCS5Padding";
        Class85.llIIllIIIII[8] = "DES";
        Class85.llIIllIIIII[9] = "I9.9¢\u0014\u001c\u001dîÛ\u0096=hF?ÜÙ(â·Ïk¡æG\u0094Ý\u0012®\t ¯Úwg\u0000K{¢3é\u0004\u0001!\u0019_;°Ä\u0094¯\u001d\u009dè&M8pè\u008fÚ\u0003º\u001a¯y\"Ò\u0015w©ÆÀ#ÊR7\u001dÌ}ñ\u00adºP\u001b'l*ñÇýß\t\u0094\u0003g-Ï!ÃT|]?â\b\u0010ãx2dkü\u0088!XÙÇÔóæý$\u0094\u008c§ËÇg°\u0016\u0091L\u001d/_\rëÒ\u009a«h\u000enp³\u0006y\u0097^¼H)K\u009aío\u007f0\u009e\u009eê´2\u0003åüèÊ\u0014N\u0081`§\u0012E±æf¥è\u0089+\u0017\u0085Hºn\u008a»î*ØD\u001bèøïD\u0017/ã\u0003»k\u001d\u009b~4 có\u00adÝ \u009a\u0096\u0088ëv\u009d[«¢ç¼\u00adÀ\røõ4N\u001d=u5M\u001c\u001br²\u0093_ÐÊ\u0004á\u0084\u0095\u0010µ\u0005Ñs[ß:\u0086\u001aKUO¤\"fÏ\u0010Ê\u0001H tH\u001fò\u0005\u0004o£0ærº";
        Class85.llIIllIIIII[10] = "Ø\u000b´.!¼®\u0087é\u0099R\u0097\u008f\u009d\u0018B}4&·ö\u001e\u00938t¾`guî¢$\u001d8I$_ª1j\u0086°þ\u0016\f\u0087õDP\u0094\u001d\u0087¿Ã?EÛ×\u0019\u0086Sä:¤Z'\u001cÖ\u0097\u0012§Ç\u0098\u00ad°üÝ,&0í½µNR¿£ñg0åO\u0007ì¿ðï¬1Ûç\u0082\u0091¼ýô±\u0083IoæyG°\u0019â³Ùæ¨#ÒC\u0096ÖÃ7ô<";
        Class85.llIIllIIIII[11] = "ISO-8859-1";
        Class85.llIIllIIIII[12] = "DES/CBC/PKCS5Padding";
        Class85.llIIllIIIII[13] = "DES";
        Class85.llIIllIIIII[14] = "窝囊废东西你怎么苟延残喘了你因为这样你就可以叱诧风云了吗我知道无论用多么华丽的你活到现在你都不知道是怎么活的是不是你就是一个废物你懂吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u2008\u200c ";
        Class85.llIIllIIIII[15] = "ISO-8859-1";
        Class85.llIIllIIIII[16] = "窝囊废东西你怎么苟延残喘了你因为这样你就可以叱诧风云了吗我知道无论用多么华丽的你活到现在你都不知道是怎么活的是不是你就是一个废物你懂吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u2008\u200c ";
        Class85.llIIllIIIII[17] = " : ";
        Class85.llIIllIIIII[18] = " : ";
    }
    
    private static String lIIIllIIllIII(String s, final String s2) {
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
    
    private static String lIIIllIIlIlll(final String s, final String s2) {
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
    
    private static String lIIIllIIlIllI(final String s, final String s2) {
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
    
    private static boolean lIIIllIlIllll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIIllIllIIIl(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIllIlIlllI(final int n) {
        return n > 0;
    }
    
    private static int lIIIllIlIIllI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIllIlIIlll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIllIlIlIII$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIIIllIlIlIlI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIllIlIllII$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIIIllIlIllIl$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIIIllIllIIlI$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
}
