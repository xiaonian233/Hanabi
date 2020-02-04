package ClassSub;

import java.io.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class305 extends Class154 implements Class210
{
    private InputStream in;
    private String resourceName;
    private boolean flipped;
    private int filter;
    private Class154 target;
    private int[] trans;
    private static final long a;
    private static final String c;
    private static final String[] lllIIllIl;
    
    public Class305(final InputStream in, final String resourceName, final boolean flipped, final int filter, final int[] trans) {
        super();
        this.in = in;
        this.resourceName = resourceName;
        this.flipped = flipped;
        this.filter = filter;
        this.trans = trans;
        final Class188 value;
        final Class188 class188 = value = Class188.get();
        ++class188.total;
        value.deferred.add(this);
    }
    
    @Override
    public final void load() throws IOException {
        final boolean deferred = Class294.get().deferred;
        Class294.get().deferred = false;
        this.target = Class294.get().getTexture(this.in, this.resourceName, this.flipped, this.filter, this.trans);
        Class294.get().deferred = deferred;
    }
    
    private void checkTarget() {
        final int[] b = Class139.b();
        Class305 class305 = this;
        if (b == null) {
            if (this.target != null) {
                return;
            }
            class305 = this;
        }
        try {
            final Class305 class306 = class305;
            final boolean deferred = Class294.get().deferred;
            Class294.get().deferred = false;
            class306.target = Class294.get().getTexture(class306.in, class306.resourceName, class306.flipped, class306.filter, class306.trans);
            Class294.get().deferred = deferred;
            final Class188 value = Class188.get();
            Class355.info(String.valueOf(new StringBuilder("Early loading of deferred resource due to req: ").append(super.getDescription())));
            final Class188 class307 = value;
            --class307.total;
            value.deferred.remove(this);
        }
        catch (IOException ex) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Attempt to use deferred texture before loading and resource not found: ").append(this.resourceName)));
        }
    }
    
    @Override
    public final void bind() {
        this.checkTarget();
        this.target.bind();
    }
    
    @Override
    public final float getHeight() {
        this.checkTarget();
        return this.target.getHeight();
    }
    
    @Override
    public final int getImageHeight() {
        this.checkTarget();
        return this.target.getImageHeight();
    }
    
    @Override
    public final int getImageWidth() {
        this.checkTarget();
        return this.target.getImageWidth();
    }
    
    @Override
    public final int getTextureHeight() {
        this.checkTarget();
        return this.target.getTextureHeight();
    }
    
    @Override
    public final int getTextureID() {
        this.checkTarget();
        return this.target.getTextureID();
    }
    
    @Override
    public final String getTextureRef() {
        this.checkTarget();
        return this.target.getTextureRef();
    }
    
    @Override
    public final int getTextureWidth() {
        this.checkTarget();
        return this.target.getTextureWidth();
    }
    
    @Override
    public final float getWidth() {
        this.checkTarget();
        return this.target.getWidth();
    }
    
    @Override
    public final void release() {
        this.checkTarget();
        this.target.release();
    }
    
    @Override
    public final void setAlpha(final boolean alpha) {
        this.checkTarget();
        this.target.setAlpha(alpha);
    }
    
    @Override
    public final void setHeight(final int height) {
        this.checkTarget();
        this.target.setHeight(height);
    }
    
    @Override
    public final void setTextureHeight(final int textureHeight) {
        this.checkTarget();
        this.target.setTextureHeight(textureHeight);
    }
    
    @Override
    public final void setTextureID(final int textureID) {
        this.checkTarget();
        this.target.setTextureID(textureID);
    }
    
    @Override
    public final void setTextureWidth(final int textureWidth) {
        this.checkTarget();
        this.target.setTextureWidth(textureWidth);
    }
    
    @Override
    public final void setWidth(final int width) {
        this.checkTarget();
        this.target.setWidth(width);
    }
    
    @Override
    public final byte[] getTextureData() {
        this.checkTarget();
        return this.target.getTextureData();
    }
    
    @Override
    public final String getDescription() {
        return this.resourceName;
    }
    
    @Override
    public final boolean hasAlpha() {
        this.checkTarget();
        return this.target.hasAlpha();
    }
    
    @Override
    public final void setTextureFilter(final int textureFilter) {
        this.checkTarget();
        this.target.setTextureFilter(textureFilter);
    }
    
    static {
        lIlIIIlIlll();
        Class169.a(-6442096419663577144L, 7313419381199235190L, MethodHandles.lookup().lookupClass()).a(35468257517703L);
        final Cipher instance = Cipher.getInstance(Class305.lllIIllIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class305.lllIIllIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(92231343564629L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class305.lllIIllIl[2].getBytes(Class305.lllIIllIl[3]))).intern();
    }
    
    private static IOException a(final IOException ex) {
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
    
    private static void lIlIIIlIlll() {
        (lllIIllIl = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class305.lllIIllIl[1] = "DES";
        Class305.lllIIllIl[2] = "Un¬in4µ\u000eV\u000f¡\u008anou\u0012¾Ç\fï]ÄðÍ 0jÔ½eèìj\u0088\u001f\u0089c;\u008a\u001d[\b´\u008cT\nF/Âz\n\u001fëF\u008c\t\u009eáo`\u001e¨f\u007f¢i;DÃ\u0019ý&";
        Class305.lllIIllIl[3] = "ISO-8859-1";
    }
    
    private static String lIlIIIlIllI(final String s, final String s2) {
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
    
    private static String lIlIIIlIIIl(final String s, final String s2) {
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
    
    private static String lIlIIIlIIII(String s, final String s2) {
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
}
