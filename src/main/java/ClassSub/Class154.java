package ClassSub;

import java.nio.*;
import org.lwjgl.*;
import java.lang.invoke.*;

public class Class154 implements Class71
{
    private static Class79 GL;
    private static Class71 lastBind;
    private int target;
    private int textureID;
    private int height;
    private int width;
    private int texWidth;
    private int texHeight;
    private float widthRatio;
    private float heightRatio;
    private boolean alpha;
    private String ref;
    String cacheName;
    private Class73 reloadData;
    private static final long b;
    
    public static Class71 getLastBind() {
        return Class154.lastBind;
    }
    
    protected Class154() {
        super();
    }
    
    public Class154(final String ref, final int textureID) {
        super();
        this.target = 3553;
        this.ref = ref;
        this.textureID = textureID;
        Class154.lastBind = this;
    }
    
    private void setCacheName(final String cacheName) {
        this.cacheName = cacheName;
    }
    
    @Override
    public boolean hasAlpha() {
        return this.alpha;
    }
    
    @Override
    public String getTextureRef() {
        return this.ref;
    }
    
    public void setAlpha(final boolean alpha) {
        this.alpha = alpha;
    }
    
    public static void bindNone() {
        Class154.lastBind = null;
        Class154.GL.glDisable(3553);
    }
    
    public static void unbind() {
        Class154.lastBind = null;
    }
    
    @Override
    public void bind() {
        if (Class139.b() == null) {
            if (Class154.lastBind == this) {
                return;
            }
            Class154.lastBind = this;
            Class154.GL.glEnable(3553);
        }
        Class154.GL.glBindTexture(this.target, this.textureID);
    }
    
    public void setHeight(final int height) {
        this.height = height;
        this.setHeight();
    }
    
    public void setWidth(final int width) {
        this.width = width;
        this.setWidth();
    }
    
    @Override
    public int getImageHeight() {
        return this.height;
    }
    
    @Override
    public int getImageWidth() {
        return this.width;
    }
    
    @Override
    public float getHeight() {
        return this.heightRatio;
    }
    
    @Override
    public float getWidth() {
        return this.widthRatio;
    }
    
    @Override
    public int getTextureHeight() {
        return this.texHeight;
    }
    
    @Override
    public int getTextureWidth() {
        return this.texWidth;
    }
    
    public void setTextureHeight(final int texHeight) {
        this.texHeight = texHeight;
        this.setHeight();
    }
    
    public void setTextureWidth(final int texWidth) {
        this.texWidth = texWidth;
        this.setWidth();
    }
    
    private void setHeight() {
        final int[] b = Class139.b();
        Class154 class154 = this;
        if (b == null) {
            if (this.texHeight == 0) {
                return;
            }
            class154 = this;
        }
        class154.heightRatio = this.height / this.texHeight;
    }
    
    private void setWidth() {
        final int[] b = Class139.b();
        Class154 class154 = this;
        if (b == null) {
            if (this.texWidth == 0) {
                return;
            }
            class154 = this;
        }
        class154.widthRatio = this.width / this.texWidth;
    }
    
    @Override
    public void release() {
        final ByteBuffer allocateDirect;
        (allocateDirect = ByteBuffer.allocateDirect(4)).order(ByteOrder.nativeOrder());
        final IntBuffer intBuffer = allocateDirect.asIntBuffer();
        final int[] b = Class139.b();
        intBuffer.put(this.textureID);
        intBuffer.flip();
        final int[] array = b;
        Class154.GL.glDeleteTextures(intBuffer);
        if (Class154.lastBind == this) {
            bindNone();
        }
        if (this.cacheName != null) {
            Class294.get().clear(this.cacheName);
            if (array == null) {
                return;
            }
        }
        Class294.get().clear(this.ref);
    }
    
    @Override
    public int getTextureID() {
        return this.textureID;
    }
    
    public void setTextureID(final int textureID) {
        this.textureID = textureID;
    }
    
    private static IntBuffer createIntBuffer$ba72910() {
        final ByteBuffer allocateDirect;
        (allocateDirect = ByteBuffer.allocateDirect(4)).order(ByteOrder.nativeOrder());
        return allocateDirect.asIntBuffer();
    }
    
    @Override
    public byte[] getTextureData() {
        final int[] b = Class139.b();
        final int hasAlpha = this.hasAlpha() ? 1 : 0;
        if (b == null && hasAlpha == 0) {}
        final ByteBuffer byteBuffer = BufferUtils.createByteBuffer(hasAlpha * this.texWidth * this.texHeight);
        this.bind();
        final Class79 gl = Class154.GL;
        final int hasAlpha2 = this.hasAlpha() ? 1 : 0;
        if (b == null && hasAlpha2 == 0) {}
        gl.glGetTexImage$671776bc(hasAlpha2, byteBuffer);
        final byte[] array = new byte[byteBuffer.limit()];
        byteBuffer.get(array);
        byteBuffer.clear();
        return array;
    }
    
    @Override
    public void setTextureFilter(final int n) {
        this.bind();
        Class154.GL.glTexParameteri(this.target, 10241, n);
        Class154.GL.glTexParameteri(this.target, 10240, n);
    }
    
    public final void setTextureData(final int n, final int n2, final int n3, final int n4, final ByteBuffer byteBuffer) {
        Class73.access$102(this.reloadData = new Class73(this, (byte)0), n);
        Class73.access$202$490a62bf(n2);
        Class73.access$302(this.reloadData, n3);
        Class73.access$402(this.reloadData, n4);
        Class73.access$502(this.reloadData, byteBuffer);
    }
    
    public final void reload() {
        final int[] b = Class139.b();
        Class154 class154 = this;
        if (b == null) {
            if (this.reloadData == null) {
                return;
            }
            class154 = this;
        }
        final Class73 reloadData = this.reloadData;
        Class355.error(String.valueOf(new StringBuilder("Reloading texture: ").append(reloadData.this$0.ref)));
        class154.textureID = Class294.get().reload$e1231c9(reloadData.this$0, reloadData.srcPixelFormat, reloadData.minFilter, reloadData.magFilter, reloadData.textureBuffer);
    }
    
    static String access$600(final Class154 class154) {
        return class154.ref;
    }
    
    static {
        Class169.a(8372955383196880139L, 5124903781944241412L, MethodHandles.lookup().lookupClass()).a(157682484699584L);
        Class154.GL = Class110.get();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static boolean llIIllIlIlII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean llIIllIlIllI(final Object o, final Object o2) {
        return o == o2;
    }
}
