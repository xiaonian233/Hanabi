package ClassSub;

import java.io.*;
import javax.imageio.*;
import java.awt.*;
import java.nio.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.awt.color.*;
import java.awt.image.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class143 implements Class296
{
    private static final ColorModel glAlphaColorModel;
    private static final ColorModel glColorModel;
    private int depth;
    private int height;
    private int width;
    private int texWidth;
    private int texHeight;
    private boolean edging;
    private static final long a;
    private static final String b;
    private static final String[] lIllIIlll;
    
    public Class143() {
        super();
        this.edging = true;
    }
    
    @Override
    public final int getDepth() {
        return 0;
    }
    
    @Override
    public final int getHeight() {
        return this.height;
    }
    
    @Override
    public final int getTexHeight() {
        return this.texHeight;
    }
    
    @Override
    public final int getTexWidth() {
        return this.texWidth;
    }
    
    @Override
    public final int getWidth() {
        return this.width;
    }
    
    @Override
    public final ByteBuffer loadImage(final InputStream inputStream) throws IOException {
        return this.loadImage(inputStream, true, null);
    }
    
    @Override
    public final ByteBuffer loadImage(final InputStream inputStream, final boolean b, final int[] array) throws IOException {
        return this.loadImage(inputStream, b, false, array);
    }
    
    @Override
    public final ByteBuffer loadImage(final InputStream inputStream, final boolean b, boolean n, final int[] array) throws IOException {
        if (array != null) {
            n = (true ? 1 : 0);
        }
        final BufferedImage read = ImageIO.read(inputStream);
        final int n2 = n;
        final BufferedImage bufferedImage = read;
        final int[] b2 = Class139.b();
        int i = 2;
        int j = 2;
        final int[] array2 = b2;
    Label_0118:
        while (true) {
            while (i < bufferedImage.getWidth()) {
                i *= 2;
                if (array2 == null) {
                    if (array2 != null) {
                        break;
                    }
                    continue;
                }
                else {
                    int hasAlpha;
                    final int n4;
                    final int n3 = n4 = (hasAlpha = (bufferedImage.getColorModel().hasAlpha() ? 1 : 0));
                    final int n5;
                    Label_0144: {
                        if (array2 == null) {
                            if (n3 == 0) {
                                n5 = (hasAlpha = n2);
                                if (array2 != null) {
                                    break Label_0144;
                                }
                                if (n5 == 0) {
                                    hasAlpha = 0;
                                    break Label_0144;
                                }
                            }
                            hasAlpha = 1;
                        }
                    }
                    final int n6 = n3;
                    BufferedImage bufferedImage2 = null;
                    Label_0234: {
                        if (array2 == null) {
                            if (n5 != 0) {
                                bufferedImage2 = new BufferedImage(Class143.glAlphaColorModel, Raster.createInterleavedRaster(0, i, j, 4, null), false, new Hashtable<Object, Object>());
                                if (array2 == null) {
                                    break Label_0234;
                                }
                            }
                            hasAlpha = 0;
                        }
                        bufferedImage2 = new BufferedImage(Class143.glColorModel, Raster.createInterleavedRaster(hasAlpha, i, j, 3, null), false, new Hashtable<Object, Object>());
                    }
                    final Graphics2D graphics2D = (Graphics2D)bufferedImage2.getGraphics();
                    final int n7 = n6;
                    if (array2 == null && n7 != 0) {
                        graphics2D.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f));
                        graphics2D.fillRect(0, 0, i, j);
                        goto Label_0281;
                    }
                    Label_0328: {
                        if (array2 == null) {
                            if (n7 != 0) {
                                graphics2D.scale(1.0, -1.0);
                                graphics2D.drawImage(bufferedImage, 0, -this.height, null);
                                if (array2 == null) {
                                    break Label_0328;
                                }
                            }
                            graphics2D.drawImage(bufferedImage, 0, 0, null);
                        }
                    }
                    int n9;
                    final int n8 = n9 = (this.edging ? 1 : 0);
                    Label_0439: {
                        if (array2 == null) {
                            if (n8 == 0) {
                                break Label_0439;
                            }
                            final int height;
                            n9 = (height = this.height);
                        }
                        final int n10 = j - 1;
                        Object o = null;
                        Label_0423: {
                            if (array2 == null) {
                                if (n8 < n10) {
                                    copyArea$42b8b61a(bufferedImage2, 0, this.width, 1, 0, j - 1);
                                    copyArea$42b8b61a(bufferedImage2, this.height - 1, this.width, 1, 0, 1);
                                }
                                o = this;
                                if (array2 != null) {
                                    break Label_0423;
                                }
                                n9 = this.width;
                            }
                            if (n9 >= n10) {
                                break Label_0439;
                            }
                            copyArea$42b8b61a(bufferedImage2, 0, 1, this.height, i - 1, 0);
                            o = null;
                        }
                        copyArea$42b8b61a((BufferedImage)o, this.width - 1, 0, 1, this.height, 1);
                    }
                    final byte[] data = ((DataBufferByte)bufferedImage2.getRaster().getDataBuffer()).getData();
                    int n11 = 0;
                    Label_0588: {
                        Label_0586: {
                            if (array != null) {
                                int k = 0;
                            Label_0461:
                                while (k < data.length) {
                                    n11 = 0;
                                    if (array2 == null) {
                                        int l = n11;
                                        while (true) {
                                            while (l < 3) {
                                                final byte[] array3 = data;
                                                final int n12 = k + l;
                                                int n13 = 0;
                                                Label_0530: {
                                                    if (array2 == null) {
                                                        final byte b3 = array3[n12];
                                                        if (array2 == null) {
                                                            if (b3 < 0) {
                                                                n13 = 256 + data[k + l];
                                                                break Label_0530;
                                                            }
                                                        }
                                                        else {
                                                            if (b3 != 0) {
                                                                data[k + 3] = 0;
                                                            }
                                                            k += 4;
                                                            if (array2 != null) {
                                                                break Label_0586;
                                                            }
                                                            continue Label_0461;
                                                        }
                                                    }
                                                    n13 = array3[n12];
                                                }
                                                final int n14 = n13;
                                                if (array2 == null) {
                                                    if (n14 != array[l]) {}
                                                    ++l;
                                                }
                                                if (array2 != null) {
                                                    break;
                                                }
                                            }
                                            continue;
                                        }
                                    }
                                    break Label_0588;
                                }
                            }
                        }
                        final int length = data.length;
                    }
                    final ByteBuffer allocateDirect;
                    (allocateDirect = ByteBuffer.allocateDirect(n11)).order(ByteOrder.nativeOrder());
                    allocateDirect.put(data, 0, data.length);
                    allocateDirect.flip();
                    graphics2D.dispose();
                    return allocateDirect;
                }
            }
            while (j < bufferedImage.getHeight()) {
                j *= 2;
                if (array2 != null) {
                    continue Label_0118;
                }
                if (array2 != null) {
                    break;
                }
            }
            this.width = bufferedImage.getWidth();
            this.height = bufferedImage.getHeight();
            this.texHeight = j;
            this.texWidth = i;
            continue Label_0118;
        }
    }
    
    private ByteBuffer imageToByteBuffer(final BufferedImage bufferedImage, final boolean b, final boolean b2, final int[] array) {
        final int[] b3 = Class139.b();
        int i = 2;
        int j = 2;
        final int[] array2 = b3;
    Label_0093:
        while (true) {
            while (i < bufferedImage.getWidth()) {
                i *= 2;
                if (array2 == null) {
                    if (array2 != null) {
                        break;
                    }
                    continue;
                }
                else {
                    int hasAlpha;
                    int n2;
                    final int n = n2 = (hasAlpha = (bufferedImage.getColorModel().hasAlpha() ? 1 : 0));
                    Label_0118: {
                        if (array2 == null) {
                            if (n == 0) {
                                hasAlpha = (b2 ? 1 : 0);
                                n2 = (b2 ? 1 : 0);
                                if (array2 != null) {
                                    break Label_0118;
                                }
                                if (!b2) {
                                    final int n3;
                                    n2 = (n3 = (hasAlpha = 0));
                                    break Label_0118;
                                }
                            }
                            int n3;
                            n2 = (n3 = (hasAlpha = 1));
                        }
                    }
                    final int n4 = n;
                    BufferedImage bufferedImage2 = null;
                    Label_0202: {
                        if (array2 == null) {
                            if (n2 != 0) {
                                bufferedImage2 = new BufferedImage(Class143.glAlphaColorModel, Raster.createInterleavedRaster(0, i, j, 4, null), false, new Hashtable<Object, Object>());
                                if (array2 == null) {
                                    break Label_0202;
                                }
                            }
                            hasAlpha = 0;
                        }
                        bufferedImage2 = new BufferedImage(Class143.glColorModel, Raster.createInterleavedRaster(hasAlpha, i, j, 3, null), false, new Hashtable<Object, Object>());
                    }
                    final Graphics2D graphics2D = (Graphics2D)bufferedImage2.getGraphics();
                    final int n5 = n4;
                    if (array2 == null && n5 != 0) {
                        graphics2D.setColor(new Color(0.0f, 0.0f, 0.0f, 0.0f));
                        graphics2D.fillRect(0, 0, i, j);
                        goto Label_0248;
                    }
                    Label_0295: {
                        if (array2 == null) {
                            if (n5 != 0) {
                                graphics2D.scale(1.0, -1.0);
                                graphics2D.drawImage(bufferedImage, 0, -this.height, null);
                                if (array2 == null) {
                                    break Label_0295;
                                }
                            }
                            graphics2D.drawImage(bufferedImage, 0, 0, null);
                        }
                    }
                    int n7;
                    final int n6 = n7 = (this.edging ? 1 : 0);
                    Label_0403: {
                        if (array2 == null) {
                            if (n6 == 0) {
                                break Label_0403;
                            }
                            final int height;
                            n7 = (height = this.height);
                        }
                        final int n8 = j - 1;
                        Object o = null;
                        Label_0387: {
                            if (array2 == null) {
                                if (n6 < n8) {
                                    copyArea$42b8b61a(bufferedImage2, 0, this.width, 1, 0, j - 1);
                                    copyArea$42b8b61a(bufferedImage2, this.height - 1, this.width, 1, 0, 1);
                                }
                                o = this;
                                if (array2 != null) {
                                    break Label_0387;
                                }
                                n7 = this.width;
                            }
                            if (n7 >= n8) {
                                break Label_0403;
                            }
                            copyArea$42b8b61a(bufferedImage2, 0, 1, this.height, i - 1, 0);
                            o = null;
                        }
                        copyArea$42b8b61a((BufferedImage)o, this.width - 1, 0, 1, this.height, 1);
                    }
                    final byte[] data = ((DataBufferByte)bufferedImage2.getRaster().getDataBuffer()).getData();
                    int n9 = 0;
                    Label_0548: {
                        Label_0546: {
                            if (array != null) {
                                int k = 0;
                            Label_0424:
                                while (k < data.length) {
                                    n9 = 0;
                                    if (array2 == null) {
                                        int l = n9;
                                        while (true) {
                                            while (l < 3) {
                                                final byte[] array3 = data;
                                                final int n10 = k + l;
                                                int n11 = 0;
                                                Label_0492: {
                                                    if (array2 == null) {
                                                        final byte b4 = array3[n10];
                                                        if (array2 == null) {
                                                            if (b4 < 0) {
                                                                n11 = 256 + data[k + l];
                                                                break Label_0492;
                                                            }
                                                        }
                                                        else {
                                                            if (b4 != 0) {
                                                                data[k + 3] = 0;
                                                            }
                                                            k += 4;
                                                            if (array2 != null) {
                                                                break Label_0546;
                                                            }
                                                            continue Label_0424;
                                                        }
                                                    }
                                                    n11 = array3[n10];
                                                }
                                                final int n12 = n11;
                                                if (array2 == null) {
                                                    if (n12 != array[l]) {}
                                                    ++l;
                                                }
                                                if (array2 != null) {
                                                    break;
                                                }
                                            }
                                            continue;
                                        }
                                    }
                                    break Label_0548;
                                }
                            }
                        }
                        final int length = data.length;
                    }
                    final ByteBuffer allocateDirect;
                    (allocateDirect = ByteBuffer.allocateDirect(n9)).order(ByteOrder.nativeOrder());
                    allocateDirect.put(data, 0, data.length);
                    allocateDirect.flip();
                    graphics2D.dispose();
                    return allocateDirect;
                }
            }
            while (j < bufferedImage.getHeight()) {
                j *= 2;
                if (array2 != null) {
                    continue Label_0093;
                }
                if (array2 != null) {
                    break;
                }
            }
            this.width = bufferedImage.getWidth();
            this.height = bufferedImage.getHeight();
            this.texHeight = j;
            this.texWidth = i;
            continue Label_0093;
        }
    }
    
    @Override
    public final ByteBuffer getImageBufferData() {
        throw new RuntimeException("ImageIOImageData doesn't store it's image.");
    }
    
    private static void copyArea$42b8b61a(final BufferedImage bufferedImage, final int n, final int n2, final int n3, final int n4, final int n5) {
        ((Graphics2D)bufferedImage.getGraphics()).drawImage(bufferedImage.getSubimage(0, n, n2, n3), n4, n + n5, null);
    }
    
    @Override
    public final void configureEdging(final boolean edging) {
        this.edging = edging;
    }
    
    static {
        llllIIlllI();
        Class169.a(1631327893068533705L, 6398285213292943641L, MethodHandles.lookup().lookupClass()).a(67295333594443L);
        final Cipher instance = Cipher.getInstance(Class143.lIllIIlll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class143.lIllIIlll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(98771439832055L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class143.lIllIIlll[2].getBytes(Class143.lIllIIlll[3]))).intern();
        glAlphaColorModel = new ComponentColorModel(ColorSpace.getInstance(1000), new int[] { 8, 8, 8, 8 }, true, false, 3, 0);
        glColorModel = new ComponentColorModel(ColorSpace.getInstance(1000), new int[] { 8, 8, 8, 0 }, false, false, 1, 0);
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
    
    private static void llllIIlllI() {
        (lIllIIlll = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class143.lIllIIlll[1] = "DES";
        Class143.lIllIIlll[2] = "\u009f+iú¶/j\u000f§\u0004¤l\u0011.\u0081_½iýVöe\u001ed\u00185\u001aøý)8¡ÿ\bÚ\u008d\u009b¦ü¼öã\u008e\u0001÷K\u0080\u0094";
        Class143.lIllIIlll[3] = "ISO-8859-1";
    }
    
    private static String llllIIIIlI(final String s, final String s2) {
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
    
    private static String llllIIlIll(final String s, final String s2) {
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
    
    private static String llllIIlIlI(String s, final String s2) {
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
    
    private static boolean lllllIIIll(final int n) {
        return n < 0;
    }
    
    private static boolean lllllIIlII(final int n, final int n2) {
        return n != n2;
    }
}
