package ClassSub;

import java.nio.*;
import java.io.*;
import java.util.zip.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class340
{
    private static Class238 ALPHA;
    private static Class238 LUMINANCE;
    private static Class238 LUMINANCE_ALPHA;
    public static Class238 RGB;
    public static Class238 RGBA;
    private static Class238 BGRA;
    private static Class238 ABGR;
    private static final byte[] SIGNATURE;
    private static final int IHDR;
    private static final int PLTE;
    private static final int tRNS;
    private static final int IDAT;
    private static final int IEND;
    private static final byte COLOR_GREYSCALE;
    private static final byte COLOR_TRUECOLOR;
    private static final byte COLOR_INDEXED;
    private static final byte COLOR_GREYALPHA;
    private static final byte COLOR_TRUEALPHA;
    private final InputStream input;
    private final CRC32 crc;
    private final byte[] buffer;
    private int chunkLength;
    private int chunkType;
    private int chunkRemaining;
    int width;
    int height;
    private int bitdepth;
    int colorType;
    private int bytesPerPixel;
    private byte[] palette;
    private byte[] paletteA;
    private byte[] transPixel;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIIllIlll;
    
    public Class340(final InputStream input) throws IOException {
        super();
        final int[] b = Class139.b();
        this.input = input;
        final int[] array = b;
        this.crc = new CRC32();
        this.readFully(this.buffer = new byte[4096], 0, 8);
        Class340 class340 = this;
        if (array == null) {
            if (!checkSignature(this.buffer)) {
                throw new IOException("Not a valid PNG file");
            }
            this.openChunk(1229472850);
            final int[] b2 = Class139.b();
            this.checkChunkLength(13);
            final int[] array2 = b2;
            this.readChunk$1cf967b1(this.buffer, 13);
            this.width = readInt(this.buffer, 0);
            this.height = readInt(this.buffer, 4);
            this.bitdepth = (this.buffer[8] & 0xFF);
            this.colorType = (this.buffer[9] & 0xFF);
            final int colorType = this.colorType;
            Label_0527: {
                Label_0411: {
                    Label_0358: {
                        Label_0305: {
                            Label_0252: {
                                Class340 class341 = null;
                                Label_0244: {
                                    if (array2 == null) {
                                        switch (colorType) {
                                            case 0: {
                                                class341 = this;
                                                if (array2 == null) {
                                                    final int bitdepth = this.bitdepth;
                                                    break;
                                                }
                                                break Label_0244;
                                            }
                                            case 4: {
                                                break Label_0252;
                                            }
                                            case 2: {
                                                break Label_0305;
                                            }
                                            case 6: {
                                                break Label_0358;
                                            }
                                            case 3: {
                                                break Label_0411;
                                            }
                                            default: {
                                                throw new IOException(String.valueOf(new StringBuilder("unsupported color format: ").append(this.colorType)));
                                            }
                                        }
                                    }
                                    if (lIIlIlIllIll(colorType, 8)) {
                                        throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                                    }
                                    class341 = this;
                                }
                                class341.bytesPerPixel = 1;
                                if (array2 == null) {
                                    break Label_0527;
                                }
                            }
                            Class340 class342 = this;
                            if (array2 == null) {
                                if (lIIlIlIllIll(this.bitdepth, 8)) {
                                    throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                                }
                                class342 = this;
                            }
                            class342.bytesPerPixel = 2;
                            if (array2 == null) {
                                break Label_0527;
                            }
                        }
                        Class340 class343 = this;
                        if (array2 == null) {
                            if (lIIlIlIllIll(this.bitdepth, 8)) {
                                throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                            }
                            class343 = this;
                        }
                        class343.bytesPerPixel = 3;
                        if (array2 == null) {
                            break Label_0527;
                        }
                    }
                    Class340 class344 = this;
                    if (array2 == null) {
                        if (lIIlIlIllIll(this.bitdepth, 8)) {
                            throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                        }
                        class344 = this;
                    }
                    class344.bytesPerPixel = 4;
                    if (array2 == null) {
                        break Label_0527;
                    }
                }
                Class340 class345 = this;
                if (array2 == null) {
                    switch (this.bitdepth) {
                        case 1:
                        case 2:
                        case 4:
                        case 8: {
                            class345 = this;
                            break;
                        }
                        default: {
                            throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                        }
                    }
                }
                class345.bytesPerPixel = 1;
                if (array2 == null) {
                    break Label_0527;
                }
                throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
            }
            byte b4;
            final byte b3 = b4 = this.buffer[10];
            if (array2 == null) {
                if (b3 != 0) {
                    throw new IOException("unsupported compression method");
                }
                final byte b5;
                b4 = (b5 = this.buffer[11]);
            }
            if (array2 == null) {
                if (b3 != 0) {
                    throw new IOException("unsupported filtering method");
                }
                b4 = this.buffer[12];
            }
            if (b4 != 0) {
                throw new IOException("unsupported interlace method");
            }
            class340 = this;
        }
        class340.closeChunk();
    Label_0911:
        do {
            this.openChunk();
            Label_0745: {
                switch (this.chunkType) {
                    case 1229209940: {
                        if (array != null) {
                            break Label_0745;
                        }
                        break Label_0911;
                    }
                    case 1347179589: {
                        final int[] b6 = Class139.b();
                        final int n = this.chunkLength / 3;
                        final int[] array3 = b6;
                        int chunkLength;
                        final int n2 = chunkLength = n;
                        int n4;
                        int n3 = n4 = 1;
                        if (array3 == null) {
                            if (n2 <= 0) {
                                throw new IOException("PLTE chunk has wrong length");
                            }
                            final int n5;
                            chunkLength = (n5 = n);
                            n3 = (n4 = 256);
                        }
                        if (array3 == null) {
                            if (!lIIlIllIIIII(n2, n4)) {
                                throw new IOException("PLTE chunk has wrong length");
                            }
                            chunkLength = this.chunkLength;
                            n3 = 3;
                        }
                        final int n6 = chunkLength % n3;
                        if (array3 == null) {
                            if (n6 != 0) {
                                throw new IOException("PLTE chunk has wrong length");
                            }
                            this.readChunk$1cf967b1(this.palette = new byte[n * 3], this.palette.length);
                        }
                        if (array != null) {
                            break Label_0745;
                        }
                        break;
                    }
                    case 1951551059: {
                        final int[] b7 = Class139.b();
                        final int colorType2 = this.colorType;
                        Label_0846: {
                            Label_0817: {
                                if (b7 == null) {
                                    switch (colorType2) {
                                        case 0: {
                                            this.checkChunkLength(2);
                                            this.readChunk$1cf967b1(this.transPixel = new byte[2], 2);
                                            break;
                                        }
                                        case 2: {
                                            break Label_0817;
                                        }
                                        case 3: {
                                            break Label_0846;
                                        }
                                    }
                                }
                                if (b7 == null) {
                                    break;
                                }
                            }
                            this.checkChunkLength(6);
                            this.readChunk$1cf967b1(this.transPixel = new byte[6], 6);
                            if (b7 == null) {
                                break;
                            }
                        }
                        final byte[] palette = this.palette;
                        if (b7 == null) {
                            if (palette == null) {
                                throw new IOException("tRNS chunk without PLTE chunk");
                            }
                            this.paletteA = new byte[this.palette.length / 3];
                            final byte[] paletteA = this.paletteA;
                        }
                        Arrays.fill(palette, (byte)(-1));
                        this.readChunk$1cf967b1(this.paletteA, this.paletteA.length);
                        break;
                    }
                }
            }
            this.closeChunk();
        } while (array == null);
        Class340 class346 = this;
        if (array == null) {
            if (this.colorType != 3) {
                return;
            }
            class346 = this;
        }
        if (class346.palette == null) {
            throw new IOException("Missing PLTE chunk");
        }
    }
    
    private int getHeight() {
        return this.height;
    }
    
    private int getWidth() {
        return this.width;
    }
    
    public final boolean hasAlpha() {
        final int[] b = Class139.b();
        int colorType;
        final int n = colorType = this.colorType;
        if (b == null) {
            Label_0038: {
                if (lIIlIlIllIll(n, 6)) {
                    final byte[] paletteA = this.paletteA;
                    if (b == null) {
                        if (paletteA != null) {
                            break Label_0038;
                        }
                        final byte[] transPixel = this.transPixel;
                    }
                    if (paletteA == null) {
                        return false;
                    }
                }
            }
            colorType = (true ? 1 : 0);
        }
        return colorType != 0;
    }
    
    private boolean isRGB() {
        final int[] b = Class139.b();
        final int colorType = this.colorType;
        if (b == null) {
            if (lIIlIlIllIll(colorType, 6)) {
                final int colorType2 = this.colorType;
                if (b == null) {
                    if (lIIlIlIllIll(colorType2, 2)) {
                        final int colorType3 = this.colorType;
                        if (b == null) {
                            if (colorType3 != 3) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return colorType != 0;
    }
    
    private Class238 decideTextureFormat(final Class238 class238) {
        final int[] b = Class139.b();
        switch (this.colorType) {
            case 2: {
                Class238 class239 = class238;
                if (b == null) {
                    Label_0108: {
                        if (lIIlIlIlllII(class238, Class340.ABGR)) {
                            class239 = class238;
                            if (b != null) {
                                return class239;
                            }
                            if (lIIlIlIlllII(class238, Class340.RGBA)) {
                                class239 = class238;
                                if (b != null) {
                                    return class239;
                                }
                                if (lIIlIlIlllII(class238, Class340.BGRA)) {
                                    Class238 rgb = class238;
                                    if (b == null) {
                                        if (lIIlIlIlllIl(class238, Class340.RGB)) {
                                            break Label_0108;
                                        }
                                        rgb = Class340.RGB;
                                    }
                                    return rgb;
                                }
                            }
                        }
                    }
                    class239 = class238;
                }
                return class239;
            }
            case 6: {
                Class238 class240 = class238;
                if (b == null) {
                    Label_0170: {
                        if (lIIlIlIlllII(class238, Class340.ABGR)) {
                            class240 = class238;
                            if (b != null) {
                                return class240;
                            }
                            if (lIIlIlIlllII(class238, Class340.RGBA)) {
                                class240 = class238;
                                if (b != null) {
                                    return class240;
                                }
                                if (lIIlIlIlllII(class238, Class340.BGRA)) {
                                    Class238 rgba = class238;
                                    if (b == null) {
                                        if (lIIlIlIlllIl(class238, Class340.RGB)) {
                                            break Label_0170;
                                        }
                                        rgba = Class340.RGBA;
                                    }
                                    return rgba;
                                }
                            }
                        }
                    }
                    class240 = class238;
                }
                return class240;
            }
            case 0: {
                Class238 class241 = class238;
                if (b == null) {
                    Label_0204: {
                        if (lIIlIlIlllII(class238, Class340.LUMINANCE)) {
                            Class238 luminance = class238;
                            if (b == null) {
                                if (lIIlIlIlllIl(class238, Class340.ALPHA)) {
                                    break Label_0204;
                                }
                                luminance = Class340.LUMINANCE;
                            }
                            return luminance;
                        }
                    }
                    class241 = class238;
                }
                return class241;
            }
            case 4: {
                return Class340.LUMINANCE_ALPHA;
            }
            case 3: {
                Class238 class242 = class238;
                if (b == null) {
                    Label_0256: {
                        if (lIIlIlIlllII(class238, Class340.ABGR)) {
                            class242 = class238;
                            if (b != null) {
                                return class242;
                            }
                            if (lIIlIlIlllII(class238, Class340.RGBA)) {
                                Class238 rgba2 = class238;
                                if (b == null) {
                                    if (lIIlIlIlllIl(class238, Class340.BGRA)) {
                                        break Label_0256;
                                    }
                                    rgba2 = Class340.RGBA;
                                }
                                return rgba2;
                            }
                        }
                    }
                    class242 = class238;
                }
                return class242;
            }
            default: {
                throw new UnsupportedOperationException("Not yet implemented");
            }
        }
    }
    
    public final void decode(final ByteBuffer byteBuffer, final int n, final Class238 class238) throws IOException {
        final int position = byteBuffer.position();
        final int n2;
        byte[] array = new byte[(n2 = (this.width * this.bitdepth + 7) / 8 * this.bytesPerPixel) + 1];
        final int[] b = Class139.b();
        byte[] array2 = new byte[n2 + 1];
        final int[] array3 = b;
        final int bitdepth = this.bitdepth;
        final int n3 = 8;
        byte[] array4 = null;
        Label_0074: {
            if (array3 == null) {
                if (bitdepth >= n3) {
                    array4 = null;
                    break Label_0074;
                }
                final int width = this.width;
            }
            array4 = new byte[bitdepth + n3];
        }
        byte[] array5 = array4;
        final Inflater inflater = new Inflater();
        int n4 = 0;
        while (true) {
            final int n5 = n4;
            try {
                if (n5 < this.height) {
                    this.readChunkUnzip(inflater, array, 0, array.length);
                    final byte[] array6 = array;
                    final byte[] array7 = array2;
                    final byte[] array8 = array6;
                    final int[] b2 = Class139.b();
                    Label_0248: {
                        Label_0207: {
                            switch (array8[0]) {
                                case 0: {
                                    if (b2 != null) {
                                        break Label_0207;
                                    }
                                    break Label_0248;
                                }
                                case 1: {
                                    this.unfilterSub(array8);
                                    if (b2 != null) {
                                        break Label_0207;
                                    }
                                    break Label_0248;
                                }
                                case 2: {
                                    unfilterUp(array8, array7);
                                    if (b2 != null) {
                                        break Label_0207;
                                    }
                                    break Label_0248;
                                }
                                case 3: {
                                    this.unfilterAverage(array8, array7);
                                    if (b2 != null) {
                                        break Label_0207;
                                    }
                                    break Label_0248;
                                }
                                case 4: {
                                    this.unfilterPaeth(array8, array7);
                                    if (b2 != null) {
                                        break;
                                    }
                                    break Label_0248;
                                }
                            }
                        }
                        throw new IOException(String.valueOf(new StringBuilder("invalide filter type in scanline: ").append(array8[0])));
                    }
                    byteBuffer.position(position + n4 * n);
                    if (array3 == null) {
                        switch (this.colorType) {
                            case 2: {
                                Class238 class239 = class238;
                                Class238 class240 = class238;
                                Class238 class241 = class238;
                                Class238 class243;
                                Class238 bgra;
                                final Class238 class242 = bgra = (class243 = Class340.ABGR);
                                if (array3 == null) {
                                    if (lIIlIlIlllIl(class238, class242)) {
                                        this.copyRGBtoABGR(byteBuffer, array);
                                        if (array3 == null) {
                                            break;
                                        }
                                    }
                                    class239 = class238;
                                    class240 = class238;
                                    class241 = class238;
                                    final Class238 class244;
                                    bgra = (class244 = (class243 = Class340.RGBA));
                                }
                                if (array3 == null) {
                                    if (lIIlIlIlllIl(class241, class242)) {
                                        this.copyRGBtoRGBA(byteBuffer, array);
                                        if (array3 == null) {
                                            break;
                                        }
                                    }
                                    class239 = class238;
                                    class240 = class238;
                                    class243 = (bgra = Class340.BGRA);
                                }
                                if (array3 == null) {
                                    if (lIIlIlIlllIl(class240, bgra)) {
                                        this.copyRGBtoBGRA(byteBuffer, array);
                                        if (array3 == null) {
                                            break;
                                        }
                                    }
                                    class239 = class238;
                                    class243 = Class340.RGB;
                                }
                                if (lIIlIlIlllIl(class239, class243)) {
                                    copy(byteBuffer, array);
                                    if (array3 == null) {
                                        break;
                                    }
                                }
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }
                            case 6: {
                                Class238 class245 = class238;
                                Class238 class246 = class238;
                                Class238 class247 = class238;
                                Class238 class249;
                                Class238 bgra2;
                                final Class238 class248 = bgra2 = (class249 = Class340.ABGR);
                                if (array3 == null) {
                                    if (lIIlIlIlllIl(class238, class248)) {
                                        copyRGBAtoABGR(byteBuffer, array);
                                        if (array3 == null) {
                                            break;
                                        }
                                    }
                                    class245 = class238;
                                    class246 = class238;
                                    class247 = class238;
                                    final Class238 class250;
                                    bgra2 = (class250 = (class249 = Class340.RGBA));
                                }
                                if (array3 == null) {
                                    if (lIIlIlIlllIl(class247, class248)) {
                                        copy(byteBuffer, array);
                                        if (array3 == null) {
                                            break;
                                        }
                                    }
                                    class245 = class238;
                                    class246 = class238;
                                    class249 = (bgra2 = Class340.BGRA);
                                }
                                if (array3 == null) {
                                    if (lIIlIlIlllIl(class246, bgra2)) {
                                        copyRGBAtoBGRA(byteBuffer, array);
                                        if (array3 == null) {
                                            break;
                                        }
                                    }
                                    class245 = class238;
                                    class249 = Class340.RGB;
                                }
                                if (lIIlIlIlllIl(class245, class249)) {
                                    copyRGBAtoRGB(byteBuffer, array);
                                    if (array3 == null) {
                                        break;
                                    }
                                }
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }
                            case 0: {
                                Class238 class251 = class238;
                                final Class238 luminance = Class340.LUMINANCE;
                                Label_0558: {
                                    if (array3 == null) {
                                        if (!lIIlIlIlllII(class238, luminance)) {
                                            break Label_0558;
                                        }
                                        class251 = class238;
                                        final Class238 alpha = Class340.ALPHA;
                                    }
                                    if (!lIIlIlIlllIl(class251, luminance)) {
                                        throw new UnsupportedOperationException("Unsupported format for this image");
                                    }
                                }
                                copy(byteBuffer, array);
                                if (array3 == null) {
                                    break;
                                }
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }
                            case 4: {
                                if (lIIlIlIlllIl(class238, Class340.LUMINANCE_ALPHA)) {
                                    copy(byteBuffer, array);
                                    if (array3 == null) {
                                        break;
                                    }
                                }
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }
                            case 3: {
                                Label_0715: {
                                    Label_0693: {
                                        switch (this.bitdepth) {
                                            case 8: {
                                                array5 = array;
                                                if (array3 != null) {
                                                    break Label_0693;
                                                }
                                                break Label_0715;
                                            }
                                            case 4: {
                                                expand4(array, array5);
                                                if (array3 != null) {
                                                    break Label_0693;
                                                }
                                                break Label_0715;
                                            }
                                            case 2: {
                                                expand2(array, array5);
                                                if (array3 != null) {
                                                    break Label_0693;
                                                }
                                                break Label_0715;
                                            }
                                            case 1: {
                                                expand1(array, array5);
                                                if (array3 != null) {
                                                    break;
                                                }
                                                break Label_0715;
                                            }
                                        }
                                    }
                                    throw new UnsupportedOperationException("Unsupported bitdepth for this image");
                                }
                                Class238 class252 = class238;
                                Class238 class253 = class238;
                                Class238 class255;
                                final Class238 class254 = class255 = Class340.ABGR;
                                if (array3 == null) {
                                    if (lIIlIlIlllIl(class238, class254)) {
                                        this.copyPALtoABGR(byteBuffer, array5);
                                        if (array3 == null) {
                                            break;
                                        }
                                    }
                                    class252 = class238;
                                    class253 = class238;
                                    final Class238 rgba;
                                    class255 = (rgba = Class340.RGBA);
                                }
                                if (array3 == null) {
                                    if (lIIlIlIlllIl(class253, class254)) {
                                        this.copyPALtoRGBA(byteBuffer, array5);
                                        if (array3 == null) {
                                            break;
                                        }
                                    }
                                    class252 = class238;
                                    class255 = Class340.BGRA;
                                }
                                if (lIIlIlIlllIl(class252, class255)) {
                                    this.copyPALtoBGRA(byteBuffer, array5);
                                    if (array3 == null) {
                                        break;
                                    }
                                }
                                throw new UnsupportedOperationException("Unsupported format for this image");
                            }
                            default: {
                                throw new UnsupportedOperationException("Not yet implemented");
                            }
                        }
                        final byte[] array9 = array;
                        array = array2;
                        array2 = array9;
                        ++n4;
                        if (array3 == null) {
                            continue;
                        }
                    }
                }
            }
            finally {
                inflater.end();
            }
        }
    }
    
    private static void copy(final ByteBuffer byteBuffer, final byte[] array) {
        byteBuffer.put(array, 1, array.length - 1);
    }
    
    private void copyRGBtoABGR(final ByteBuffer byteBuffer, final byte[] array) {
        final int[] b = Class139.b();
        final byte[] transPixel = this.transPixel;
        Label_0154: {
            if (b == null) {
                if (transPixel == null) {
                    break Label_0154;
                }
                final byte[] transPixel2 = this.transPixel;
            }
            final byte b2 = transPixel[1];
            final byte b3 = this.transPixel[3];
            final byte b4 = this.transPixel[5];
            int i = 1;
            while (i < array.length) {
                final byte b5 = array[i];
                final byte b6 = array[i + 1];
                final byte b7 = array[i + 2];
                byte b8 = -1;
                if (b != null) {
                    return;
                }
                if (b == null) {
                    Label_0121: {
                        if (b5 == b2) {
                            final byte b9 = b6;
                            final byte b10 = b3;
                            byte b11 = 0;
                            Label_0119: {
                                if (b == null) {
                                    if (b9 != b10) {
                                        break Label_0121;
                                    }
                                    final byte b12;
                                    b11 = (b12 = b7);
                                    if (b != null) {
                                        break Label_0119;
                                    }
                                }
                                if (b9 != b10) {
                                    break Label_0121;
                                }
                                b11 = 0;
                            }
                            b8 = b11;
                        }
                    }
                    byteBuffer.put(b8).put(b7).put(b6).put(b5);
                    i += 3;
                }
                if (b != null) {
                    break;
                }
            }
            if (b == null) {
                return;
            }
        }
        int j = 1;
        while (j < array.length) {
            byteBuffer.put((byte)(-1)).put(array[j + 2]).put(array[j + 1]).put(array[j]);
            j += 3;
            if (b != null) {
                break;
            }
        }
    }
    
    private void copyRGBtoRGBA(final ByteBuffer byteBuffer, final byte[] array) {
        final int[] b = Class139.b();
        final byte[] transPixel = this.transPixel;
        Label_0154: {
            if (b == null) {
                if (transPixel == null) {
                    break Label_0154;
                }
                final byte[] transPixel2 = this.transPixel;
            }
            final byte b2 = transPixel[1];
            final byte b3 = this.transPixel[3];
            final byte b4 = this.transPixel[5];
            int i = 1;
            while (i < array.length) {
                final byte b5 = array[i];
                final byte b6 = array[i + 1];
                final byte b7 = array[i + 2];
                byte b8 = -1;
                if (b != null) {
                    return;
                }
                if (b == null) {
                    Label_0121: {
                        if (b5 == b2) {
                            final byte b9 = b6;
                            final byte b10 = b3;
                            byte b11 = 0;
                            Label_0119: {
                                if (b == null) {
                                    if (b9 != b10) {
                                        break Label_0121;
                                    }
                                    final byte b12;
                                    b11 = (b12 = b7);
                                    if (b != null) {
                                        break Label_0119;
                                    }
                                }
                                if (b9 != b10) {
                                    break Label_0121;
                                }
                                b11 = 0;
                            }
                            b8 = b11;
                        }
                    }
                    byteBuffer.put(b5).put(b6).put(b7).put(b8);
                    i += 3;
                }
                if (b != null) {
                    break;
                }
            }
            if (b == null) {
                return;
            }
        }
        int j = 1;
        while (j < array.length) {
            byteBuffer.put(array[j]).put(array[j + 1]).put(array[j + 2]).put((byte)(-1));
            j += 3;
            if (b != null) {
                break;
            }
        }
    }
    
    private void copyRGBtoBGRA(final ByteBuffer byteBuffer, final byte[] array) {
        final int[] b = Class139.b();
        final byte[] transPixel = this.transPixel;
        Label_0154: {
            if (b == null) {
                if (transPixel == null) {
                    break Label_0154;
                }
                final byte[] transPixel2 = this.transPixel;
            }
            final byte b2 = transPixel[1];
            final byte b3 = this.transPixel[3];
            final byte b4 = this.transPixel[5];
            int i = 1;
            while (i < array.length) {
                final byte b5 = array[i];
                final byte b6 = array[i + 1];
                final byte b7 = array[i + 2];
                byte b8 = -1;
                if (b != null) {
                    return;
                }
                if (b == null) {
                    Label_0121: {
                        if (b5 == b2) {
                            final byte b9 = b6;
                            final byte b10 = b3;
                            byte b11 = 0;
                            Label_0119: {
                                if (b == null) {
                                    if (b9 != b10) {
                                        break Label_0121;
                                    }
                                    final byte b12;
                                    b11 = (b12 = b7);
                                    if (b != null) {
                                        break Label_0119;
                                    }
                                }
                                if (b9 != b10) {
                                    break Label_0121;
                                }
                                b11 = 0;
                            }
                            b8 = b11;
                        }
                    }
                    byteBuffer.put(b7).put(b6).put(b5).put(b8);
                    i += 3;
                }
                if (b != null) {
                    break;
                }
            }
            if (b == null) {
                return;
            }
        }
        int j = 1;
        while (j < array.length) {
            byteBuffer.put(array[j + 2]).put(array[j + 1]).put(array[j]).put((byte)(-1));
            j += 3;
            if (b != null) {
                break;
            }
        }
    }
    
    private static void copyRGBAtoABGR(final ByteBuffer byteBuffer, final byte[] array) {
        final int[] b = Class139.b();
        int i = 1;
        final int[] array2 = b;
        while (i < array.length) {
            byteBuffer.put(array[i + 3]).put(array[i + 2]).put(array[i + 1]).put(array[i]);
            i += 4;
            if (array2 != null) {
                break;
            }
        }
    }
    
    private static void copyRGBAtoBGRA(final ByteBuffer byteBuffer, final byte[] array) {
        final int[] b = Class139.b();
        int i = 1;
        final int[] array2 = b;
        while (i < array.length) {
            byteBuffer.put(array[i + 2]).put(array[i + 1]).put(array[i]).put(array[i + 3]);
            i += 4;
            if (array2 != null) {
                break;
            }
        }
    }
    
    private static void copyRGBAtoRGB(final ByteBuffer byteBuffer, final byte[] array) {
        final int[] b = Class139.b();
        int i = 1;
        final int[] array2 = b;
        while (i < array.length) {
            byteBuffer.put(array[i]).put(array[i + 1]).put(array[i + 2]);
            i += 4;
            if (array2 != null) {
                break;
            }
        }
    }
    
    private void copyPALtoABGR(final ByteBuffer byteBuffer, final byte[] array) {
        final int[] b = Class139.b();
        if (this.paletteA != null) {
            int i = 1;
            while (i < array.length) {
                final int n = array[i] & 0xFF;
                byteBuffer.put(this.paletteA[n]).put(this.palette[n * 3 + 2]).put(this.palette[n * 3 + 1]).put(this.palette[n * 3]);
                ++i;
                if (b != null) {
                    return;
                }
                if (b != null) {
                    break;
                }
            }
            if (b == null) {
                return;
            }
        }
        int j = 1;
        while (j < array.length) {
            final int n2 = array[j] & 0xFF;
            byteBuffer.put((byte)(-1)).put(this.palette[n2 * 3 + 2]).put(this.palette[n2 * 3 + 1]).put(this.palette[n2 * 3]);
            ++j;
            if (b != null) {
                break;
            }
        }
    }
    
    private void copyPALtoRGBA(final ByteBuffer byteBuffer, final byte[] array) {
        final int[] b = Class139.b();
        if (this.paletteA != null) {
            int i = 1;
            while (i < array.length) {
                final int n = array[i] & 0xFF;
                byteBuffer.put(this.palette[n * 3]).put(this.palette[n * 3 + 1]).put(this.palette[n * 3 + 2]).put(this.paletteA[n]);
                ++i;
                if (b != null) {
                    return;
                }
                if (b != null) {
                    break;
                }
            }
            if (b == null) {
                return;
            }
        }
        int j = 1;
        while (j < array.length) {
            final int n2 = array[j] & 0xFF;
            byteBuffer.put(this.palette[n2 * 3]).put(this.palette[n2 * 3 + 1]).put(this.palette[n2 * 3 + 2]).put((byte)(-1));
            ++j;
            if (b != null) {
                break;
            }
        }
    }
    
    private void copyPALtoBGRA(final ByteBuffer byteBuffer, final byte[] array) {
        final int[] b = Class139.b();
        if (this.paletteA != null) {
            int i = 1;
            while (i < array.length) {
                final int n = array[i] & 0xFF;
                byteBuffer.put(this.palette[n * 3 + 2]).put(this.palette[n * 3 + 1]).put(this.palette[n * 3]).put(this.paletteA[n]);
                ++i;
                if (b != null) {
                    return;
                }
                if (b != null) {
                    break;
                }
            }
            if (b == null) {
                return;
            }
        }
        int j = 1;
        while (j < array.length) {
            final int n2 = array[j] & 0xFF;
            byteBuffer.put(this.palette[n2 * 3 + 2]).put(this.palette[n2 * 3 + 1]).put(this.palette[n2 * 3]).put((byte)(-1));
            ++j;
            if (b != null) {
                break;
            }
        }
    }
    
    private static void expand4(final byte[] array, final byte[] array2) {
        int i = 1;
        final int[] b = Class139.b();
        final int length = array2.length;
        final int[] array3 = b;
        while (i < length) {
            final int n = array[1 + (i >> 1)] & 0xFF;
            if (array3 == null) {
                switch (length - i) {
                    default: {
                        array2[i + 1] = (byte)(n & 0xF);
                    }
                    case 1: {
                        array2[i] = (byte)(n >> 4);
                        i += 2;
                        break;
                    }
                }
            }
            if (array3 != null) {
                break;
            }
        }
    }
    
    private static void expand2(final byte[] array, final byte[] array2) {
        final int[] b = Class139.b();
        int i = 1;
        final int length = array2.length;
        final int[] array3 = b;
        while (i < length) {
            final int n = array[1 + (i >> 2)] & 0xFF;
            if (array3 == null) {
                switch (length - i) {
                    default: {
                        array2[i + 3] = (byte)(n & 0x3);
                    }
                    case 3: {
                        array2[i + 2] = (byte)(n >> 2 & 0x3);
                    }
                    case 2: {
                        array2[i + 1] = (byte)(n >> 4 & 0x3);
                    }
                    case 1: {
                        array2[i] = (byte)(n >> 6);
                        i += 4;
                        break;
                    }
                }
            }
            if (array3 != null) {
                break;
            }
        }
    }
    
    private static void expand1(final byte[] array, final byte[] array2) {
        final int[] b = Class139.b();
        int i = 1;
        final int[] array3 = b;
        final int length = array2.length;
        while (i < length) {
            final int n = array[1 + (i >> 3)] & 0xFF;
            if (array3 == null) {
                switch (length - i) {
                    default: {
                        array2[i + 7] = (byte)(n & 0x1);
                    }
                    case 7: {
                        array2[i + 6] = (byte)(n >> 1 & 0x1);
                    }
                    case 6: {
                        array2[i + 5] = (byte)(n >> 2 & 0x1);
                    }
                    case 5: {
                        array2[i + 4] = (byte)(n >> 3 & 0x1);
                    }
                    case 4: {
                        array2[i + 3] = (byte)(n >> 4 & 0x1);
                    }
                    case 3: {
                        array2[i + 2] = (byte)(n >> 5 & 0x1);
                    }
                    case 2: {
                        array2[i + 1] = (byte)(n >> 6 & 0x1);
                    }
                    case 1: {
                        array2[i] = (byte)(n >> 7);
                        i += 8;
                        break;
                    }
                }
            }
            if (array3 != null) {
                break;
            }
        }
    }
    
    private void unfilter(final byte[] array, final byte[] array2) throws IOException {
        final int[] b = Class139.b();
        Label_0072: {
            switch (array[0]) {
                case 0: {
                    if (b != null) {
                        break Label_0072;
                    }
                    return;
                }
                case 1: {
                    this.unfilterSub(array);
                    if (b != null) {
                        break Label_0072;
                    }
                    return;
                }
                case 2: {
                    unfilterUp(array, array2);
                    if (b != null) {
                        break Label_0072;
                    }
                    return;
                }
                case 3: {
                    this.unfilterAverage(array, array2);
                    if (b != null) {
                        break Label_0072;
                    }
                    return;
                }
                case 4: {
                    this.unfilterPaeth(array, array2);
                    if (b != null) {
                        break;
                    }
                    return;
                }
            }
        }
        throw new IOException(String.valueOf(new StringBuilder("invalide filter type in scanline: ").append(array[0])));
    }
    
    private void unfilterSub(final byte[] array) {
        final int[] b = Class139.b();
        final int bytesPerPixel = this.bytesPerPixel;
        final int[] array2 = b;
        int i = bytesPerPixel + 1;
        while (i < array.length) {
            final int n = i;
            array[n] += array[i - bytesPerPixel];
            ++i;
            if (array2 != null) {
                break;
            }
        }
    }
    
    private static void unfilterUp(final byte[] array, final byte[] array2) {
        final int[] b = Class139.b();
        int i = 1;
        final int[] array3 = b;
        while (i < array.length) {
            final int n = i;
            array[n] += array2[i];
            ++i;
            if (array3 != null) {
                break;
            }
        }
    }
    
    private void unfilterAverage(final byte[] array, final byte[] array2) {
        final int[] b = Class139.b();
        final int bytesPerPixel = this.bytesPerPixel;
        final int[] array3 = b;
        int i = 1;
        while (true) {
            while (lIIlIllIIIII(i, bytesPerPixel)) {
                final byte[] array4 = array;
                if (array3 != null) {
                    while (i < array4.length) {
                        final int n = i;
                        array[n] += (byte)((array2[i] & 0xFF) + (array[i - bytesPerPixel] & 0xFF) >>> 1);
                        ++i;
                        if (array3 != null) {
                            break;
                        }
                    }
                    return;
                }
                final int n2 = i;
                array[n2] += (byte)((array2[i] & 0xFF) >>> 1);
                ++i;
                if (array3 != null) {
                    break;
                }
            }
            final byte[] array4 = array;
            continue;
        }
    }
    
    private void unfilterPaeth(final byte[] array, final byte[] array2) {
        final int bytesPerPixel = this.bytesPerPixel;
        final int[] b = Class139.b();
        int i = 1;
        final int[] array3 = b;
        while (true) {
            while (lIIlIllIIIII(i, bytesPerPixel)) {
                final byte[] array4 = array;
                if (array3 != null) {
                    while (i < array4.length) {
                        final int n = array[i - bytesPerPixel] & 0xFF;
                        final int n2 = array2[i] & 0xFF;
                        int n3 = array2[i - bytesPerPixel] & 0xFF;
                        final int n12;
                        int n11;
                        int n10;
                        int n9;
                        int n8;
                        int n7;
                        int n6;
                        int n5;
                        final int n4 = n5 = (n6 = (n7 = (n8 = (n9 = (n10 = (n11 = (n12 = n + n2 - n3) - n))))));
                        if (array3 == null) {
                            if (n4 < 0) {
                                n5 = -n5;
                            }
                            n7 = (n6 = (n8 = (n9 = (n10 = (n11 = n12 - n2)))));
                        }
                        int n13 = n6;
                        if (array3 == null) {
                            if (n7 < 0) {
                                n13 = -n13;
                            }
                            n9 = (n8 = (n10 = (n11 = n12 - n3)));
                        }
                        int n14 = n8;
                        if (array3 == null) {
                            if (n9 < 0) {
                                n14 = -n14;
                            }
                            n10 = n5;
                        }
                        final int n15 = n13;
                        Label_0237: {
                            int n18 = 0;
                            Label_0235: {
                                final int n16;
                                Label_0227: {
                                    if (array3 == null) {
                                        if (lIIlIllIIIII(n10, n15)) {
                                            n16 = n5;
                                            final int n17 = n14;
                                            if (array3 != null) {
                                                break Label_0227;
                                            }
                                            if (lIIlIllIIIII(n16, n17)) {
                                                n3 = n;
                                                if (array3 == null) {
                                                    break Label_0237;
                                                }
                                            }
                                        }
                                        n18 = (n11 = n13);
                                        if (array3 != null) {
                                            break Label_0235;
                                        }
                                    }
                                }
                                if (!lIIlIllIIIII(n16, n15)) {
                                    break Label_0237;
                                }
                                n18 = n2;
                            }
                            n3 = n18;
                        }
                        final int n19 = i;
                        array[n19] += (byte)n3;
                        ++i;
                        if (array3 != null) {
                            break;
                        }
                    }
                    return;
                }
                final int n20 = i;
                array[n20] += array2[i];
                ++i;
                if (array3 != null) {
                    break;
                }
            }
            final byte[] array4 = array;
            continue;
        }
    }
    
    private void readIHDR() throws IOException {
        final int[] b = Class139.b();
        this.checkChunkLength(13);
        final int[] array = b;
        this.readChunk$1cf967b1(this.buffer, 13);
        this.width = readInt(this.buffer, 0);
        this.height = readInt(this.buffer, 4);
        this.bitdepth = (this.buffer[8] & 0xFF);
        this.colorType = (this.buffer[9] & 0xFF);
        final int colorType = this.colorType;
        Label_0451: {
            Label_0335: {
                Label_0282: {
                    Label_0229: {
                        Label_0176: {
                            Class340 class340 = null;
                            Label_0168: {
                                if (array == null) {
                                    switch (colorType) {
                                        case 0: {
                                            class340 = this;
                                            if (array == null) {
                                                final int bitdepth = this.bitdepth;
                                                break;
                                            }
                                            break Label_0168;
                                        }
                                        case 4: {
                                            break Label_0176;
                                        }
                                        case 2: {
                                            break Label_0229;
                                        }
                                        case 6: {
                                            break Label_0282;
                                        }
                                        case 3: {
                                            break Label_0335;
                                        }
                                        default: {
                                            throw new IOException(String.valueOf(new StringBuilder("unsupported color format: ").append(this.colorType)));
                                        }
                                    }
                                }
                                if (lIIlIlIllIll(colorType, 8)) {
                                    throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                                }
                                class340 = this;
                            }
                            class340.bytesPerPixel = 1;
                            if (array == null) {
                                break Label_0451;
                            }
                        }
                        Class340 class341 = this;
                        if (array == null) {
                            if (lIIlIlIllIll(this.bitdepth, 8)) {
                                throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                            }
                            class341 = this;
                        }
                        class341.bytesPerPixel = 2;
                        if (array == null) {
                            break Label_0451;
                        }
                    }
                    Class340 class342 = this;
                    if (array == null) {
                        if (lIIlIlIllIll(this.bitdepth, 8)) {
                            throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                        }
                        class342 = this;
                    }
                    class342.bytesPerPixel = 3;
                    if (array == null) {
                        break Label_0451;
                    }
                }
                Class340 class343 = this;
                if (array == null) {
                    if (lIIlIlIllIll(this.bitdepth, 8)) {
                        throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                    }
                    class343 = this;
                }
                class343.bytesPerPixel = 4;
                if (array == null) {
                    break Label_0451;
                }
            }
            Class340 class344 = this;
            if (array == null) {
                switch (this.bitdepth) {
                    case 1:
                    case 2:
                    case 4:
                    case 8: {
                        class344 = this;
                        break;
                    }
                    default: {
                        throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
                    }
                }
            }
            class344.bytesPerPixel = 1;
            if (array == null) {
                break Label_0451;
            }
            throw new IOException(String.valueOf(new StringBuilder("Unsupported bit depth: ").append(this.bitdepth)));
        }
        byte b3;
        final byte b2 = b3 = this.buffer[10];
        if (array == null) {
            if (b2 != 0) {
                throw new IOException("unsupported compression method");
            }
            final byte b4;
            b3 = (b4 = this.buffer[11]);
        }
        if (array == null) {
            if (b2 != 0) {
                throw new IOException("unsupported filtering method");
            }
            b3 = this.buffer[12];
        }
        if (b3 != 0) {
            throw new IOException("unsupported interlace method");
        }
    }
    
    private void readPLTE() throws IOException {
        final int[] b = Class139.b();
        final int n = this.chunkLength / 3;
        final int[] array = b;
        int chunkLength;
        final int n2 = chunkLength = n;
        int n4;
        int n3 = n4 = 1;
        if (array == null) {
            if (n2 <= 0) {
                throw new IOException("PLTE chunk has wrong length");
            }
            final int n5;
            chunkLength = (n5 = n);
            n3 = (n4 = 256);
        }
        if (array == null) {
            if (!lIIlIllIIIII(n2, n4)) {
                throw new IOException("PLTE chunk has wrong length");
            }
            chunkLength = this.chunkLength;
            n3 = 3;
        }
        final int n6 = chunkLength % n3;
        if (array == null) {
            if (n6 != 0) {
                throw new IOException("PLTE chunk has wrong length");
            }
            this.readChunk$1cf967b1(this.palette = new byte[n * 3], this.palette.length);
        }
    }
    
    private void readtRNS() throws IOException {
        final int[] b = Class139.b();
        final int colorType = this.colorType;
        Label_0102: {
            Label_0073: {
                if (b == null) {
                    switch (colorType) {
                        case 0: {
                            this.checkChunkLength(2);
                            this.readChunk$1cf967b1(this.transPixel = new byte[2], 2);
                            break;
                        }
                        case 2: {
                            break Label_0073;
                        }
                        case 3: {
                            break Label_0102;
                        }
                    }
                }
                if (b == null) {
                    return;
                }
            }
            this.checkChunkLength(6);
            this.readChunk$1cf967b1(this.transPixel = new byte[6], 6);
            if (b == null) {
                return;
            }
        }
        final byte[] palette = this.palette;
        if (b == null) {
            if (palette == null) {
                throw new IOException("tRNS chunk without PLTE chunk");
            }
            this.paletteA = new byte[this.palette.length / 3];
            final byte[] paletteA = this.paletteA;
        }
        Arrays.fill(palette, (byte)(-1));
        this.readChunk$1cf967b1(this.paletteA, this.paletteA.length);
    }
    
    private void closeChunk() throws IOException {
        final int[] b = Class139.b();
        final int chunkRemaining = this.chunkRemaining;
        Label_0090: {
            if (b == null) {
                if (chunkRemaining > 0) {
                    this.skip(this.chunkRemaining + 4);
                    if (b == null) {
                        break Label_0090;
                    }
                }
                this.readFully(this.buffer, 0, 4);
                readInt(this.buffer, 0);
            }
            final int n = chunkRemaining;
            final int n2 = (int)this.crc.getValue();
            if (b != null) {
                return;
            }
            if (lIIlIlIllIll(n2, n)) {
                throw new IOException("Invalid CRC");
            }
        }
        this.chunkRemaining = 0;
        this.chunkLength = 0;
        this.chunkType = 0;
    }
    
    private void openChunk() throws IOException {
        this.readFully(this.buffer, 0, 8);
        this.chunkLength = readInt(this.buffer, 0);
        this.chunkType = readInt(this.buffer, 4);
        this.chunkRemaining = this.chunkLength;
        this.crc.reset();
        this.crc.update(this.buffer, 4, 4);
    }
    
    private void openChunk(final int n) throws IOException {
        this.openChunk();
        if (lIIlIlIllIll(this.chunkType, n)) {
            throw new IOException(String.valueOf(new StringBuilder("Expected chunk: ").append(Integer.toHexString(n))));
        }
    }
    
    private void checkChunkLength(final int n) throws IOException {
        if (lIIlIlIllIll(this.chunkLength, n)) {
            throw new IOException("Chunk has wrong size");
        }
    }
    
    private int readChunk$1cf967b1(final byte[] array, int chunkRemaining) throws IOException {
        final int[] b = Class139.b();
        final int n = chunkRemaining;
        if (b == null) {
            if (lIIlIllIIllI(n, this.chunkRemaining)) {
                chunkRemaining = this.chunkRemaining;
            }
            this.readFully(array, 0, chunkRemaining);
            this.crc.update(array, 0, chunkRemaining);
            this.chunkRemaining -= chunkRemaining;
        }
        return n;
    }
    
    private void refillInflater(final Inflater inflater) throws IOException {
        final int[] b = Class139.b();
        while (true) {
            while (this.chunkRemaining == 0) {
                this.closeChunk();
                final Class340 class340 = this;
                if (b != null) {
                    inflater.setInput(this.buffer, 0, class340.readChunk$1cf967b1(this.buffer, 4096));
                    return;
                }
                this.openChunk(1229209940);
                if (b != null) {
                    break;
                }
            }
            final Class340 class340 = this;
            continue;
        }
    }
    
    private void readChunkUnzip(final Inflater inflater, final byte[] array, int n, int n2) throws IOException {
        final int[] b = Class139.b();
    Label_0047_Outer:
        while (true) {
            final int n3 = n;
            final int n4 = n2;
            try {
                while (true) {
                    Label_0106: {
                        final int inflate;
                        if ((inflate = inflater.inflate(array, n3, n4)) > 0) {
                            n += inflate;
                            n2 -= inflate;
                            break Label_0106;
                        }
                        final boolean finished = inflater.finished();
                        Label_0051: {
                            if (b != null) {
                                break Label_0051;
                            }
                            if (finished) {
                                throw new EOFException();
                            }
                            inflater.needsInput();
                        }
                        if (finished) {
                            this.refillInflater(inflater);
                            if (b == null) {
                                break Label_0106;
                            }
                        }
                        throw new IOException(String.valueOf(new StringBuilder("Can't inflate ").append(n2).append(" bytes")));
                    }
                    if (n2 > 0) {
                        continue Label_0047_Outer;
                    }
                    if (b == null) {
                        return;
                    }
                    continue;
                }
            }
            catch (DataFormatException ex) {
                throw (IOException)new IOException("inflate error").initCause(ex);
            }
        }
    }
    
    private void readFully(final byte[] array, int n, int n2) throws IOException {
        int read;
        while ((read = this.input.read(array, n, n2)) >= 0) {
            n += read;
            if ((n2 -= read) <= 0) {
                return;
            }
        }
        throw new EOFException();
    }
    
    private static int readInt(final byte[] array, final int n) {
        return array[n] << 24 | (array[n + 1] & 0xFF) << 16 | (array[n + 2] & 0xFF) << 8 | (array[n + 3] & 0xFF);
    }
    
    private void skip(long n) throws IOException {
        final int[] b = Class139.b();
        while (n > 0L) {
            long skip;
            final long n2 = skip = this.input.skip(n);
            long n3 = 0L;
            if (b == null) {
                if (n2 < 0L) {
                    throw new EOFException();
                }
                skip = n;
                n3 = n2;
            }
            n = skip - n3;
            if (b != null) {
                break;
            }
        }
    }
    
    private static boolean checkSignature(final byte[] array) {
        final int[] b = Class139.b();
        int i = 0;
        final int[] array2 = b;
        while (i < 8) {
            final byte b3;
            final byte b2 = b3 = array[i];
            if (array2 != null) {
                return b3 != 0;
            }
            if (array2 != null || lIIlIlIllIll(b2, Class340.SIGNATURE[i])) {
                return b2 != 0;
            }
            ++i;
            if (array2 != null) {
                break;
            }
        }
        byte b3 = (byte)(true ? 1 : 0);
        return b3 != 0;
    }
    
    static {
        lIIlIlIIlIII();
        Class169.a(3773865185053208530L, 632199940147162256L, MethodHandles.lookup().lookupClass()).a(192576311033011L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class340.llIIllIlll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class340.llIIllIlll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(90684353046786L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[22];
        int n2 = 0;
        final String s = "\u0095n©tGtÌí\u0011þ\u0083.£\u001dsn$?N'\u0096\u001c\u0019ß8¶\u0098|\u008bÎ¶\u0091[üqÍ\u0004\u0090ñ±õ³Ð;zBG'\u009dç7\u0005r\u0092\u007fú}ö·ì\u0097:DÐ\u0083\u009dÍ\u0019¹Ë\u0015\u009f\u0004ôÇPµCrÇ\u0012(ã¬\u009fvÖ\u0015¡ô'r\u0003$Ð~4MÆ\u000fsÃ\u009c5\u0005\u001cE°ÔµHÌR4\u0002ô\u0082êbm\u0010\u0094 ¾ú9\u0091h³¤\u0010\u0018\u0082Ï\u0016Ó\u0010\f ò«å\u0082³$\f\teÌÜy{\u000bx \u0018²@ùf¿T\u0089×ôÚ\u008e¦\u00149Ô\n^]\u0099ü\u0089ËÛ1\u0010è÷\b-M»¶C-iPÏ\u0002¿Ho VWK\u001e\u000f»yWB3\u000f3\u0018\u0004?\u001bÈI® â\u0085\u009b¬Q \u0088U\u0012\f6\u0097(]à\u0093\u0097k\u0089\u000b\u0080'\u0004ÎI9Ö°l«¤\u009c\b\u001cÈønõÕ§`ìr+d\rpâ1$ÿð\u0011@J·\u0081\u000e\u0001\u001djN\u001e\u008dé\u0094\u0001ÀCÉë\n\u000b!F0î\u0003Þ\u008a\u0001hoz>KäÍ\u0015\u0018Ë\u0092\u009bW^_d®\u0095£\t®v\u0004Þ5ë\u009f?Q{ax\u0087ÅÔ\u008dn8\u000ePß,ñÐhÅÄ\u001a~sC¾»^IFÔ\u0010eîÆ-#V\u0087\u0002|¶*\u001d'ýèÆõ{ì9êÛ\u001e\u008dªëkQë }HòÔL38+°¾,\u008f\u000b\u0016AÏ·\f\fú¶Ì\u0012Ñ¥\u0011\\H@Ó\u0005ZcìJÛ9\u001dx\u009bQ\r\u0010º!¶K\u009fÖÒ\u0097ü.ç¶5¼´ûfâ-Ò8\u000eÍû\u0084\"\b¼\fÛÈ\u008c \u001dä\u001e\u0081\u007fATQóé\u0097\u0003\fË\u0084$PÙ\u0006p)få\u000fßp\\\u0099ä5\u0005Q úüþÚ.\r!ÄDÎ¶(\u001c\u0014êá_G½\u0090sÝ\u0097Îü³ÏÝÐ\u008d«ú}\u001eJm¶m,@\u0013®\u0096\u0081qs\u0093Rq´³\u00ad@û\u0095A¬\u0015Ä×¼#×íiã9À®,ÿ\u008bÚ«Ä ©\tîH\u0085V{µ\r®`å½0\u000f\u009f»(Ý\u0098ÏÓü\u0098Òu\u008a\u000f$¿:\u009d0â\u0097eH±\u0083A¶0Ìðòx\u0010\u0082xî6\u0017[É\u0094ztY\u0095Ìú.\u001e9á\u0099£\u001aÝCnQ\u0007\u00ad\u008b\u0087}Ö\u001dà\u0004Ò\u0018i¬zK\u007fNX0\u0089ég\u0099b\u008a{\u0089Úñ«¬\u0085\u009cµ êfËÔ\u0014£,b\u0094 !ôá+¥9·üØÊ\u0083\u000e^§\u0098\u0016Uj4\u000b\u001f[@z\u0081E>\t.î¯p^wç\u001aù\u0018ëÓ\u0096ª\u0016\u0089xí\u009f\u0095\u0099¯\u0005O\u0013g1¤«>´\u0090\u0081\u0090Üé@ººFk\u0095m\u009bTôÇ8û©$¤7·ÌÇ¤ç\u00128$ÄÜï\u0005F'E\u001fH\t2ñ\u009c6Þ6&\u009cÇÄÒé\\åÖ¼_±\u0011\u00ad\fè\u0090\u009dßgï\u0012î:b\u001cå¶\u008cò\u0090MNÁnb\u0099\"\u001c(a&ñÈ\u001dCÝ¬ÊàµL-¾]¹\u0014\u008a\\ì\u0083\u0006d<2üY4Ê\u0019è]\u008aùª\u0005ïÚ+\t(\u0090#ÊâèKµÖ©\u0082ær³Ô:IåÍ©n\u001d\u0081Úz\u0084Óä\u0084ßFE3z\u0002àu³$\u0016-";
        String s2 = "\u0095n©tGtÌí\u0011þ\u0083.£\u001dsn$?N'\u0096\u001c\u0019ß8¶\u0098|\u008bÎ¶\u0091[üqÍ\u0004\u0090ñ±õ³Ð;zBG'\u009dç7\u0005r\u0092\u007fú}ö·ì\u0097:DÐ\u0083\u009dÍ\u0019¹Ë\u0015\u009f\u0004ôÇPµCrÇ\u0012(ã¬\u009fvÖ\u0015¡ô'r\u0003$Ð~4MÆ\u000fsÃ\u009c5\u0005\u001cE°ÔµHÌR4\u0002ô\u0082êbm\u0010\u0094 ¾ú9\u0091h³¤\u0010\u0018\u0082Ï\u0016Ó\u0010\f ò«å\u0082³$\f\teÌÜy{\u000bx \u0018²@ùf¿T\u0089×ôÚ\u008e¦\u00149Ô\n^]\u0099ü\u0089ËÛ1\u0010è÷\b-M»¶C-iPÏ\u0002¿Ho VWK\u001e\u000f»yWB3\u000f3\u0018\u0004?\u001bÈI® â\u0085\u009b¬Q \u0088U\u0012\f6\u0097(]à\u0093\u0097k\u0089\u000b\u0080'\u0004ÎI9Ö°l«¤\u009c\b\u001cÈønõÕ§`ìr+d\rpâ1$ÿð\u0011@J·\u0081\u000e\u0001\u001djN\u001e\u008dé\u0094\u0001ÀCÉë\n\u000b!F0î\u0003Þ\u008a\u0001hoz>KäÍ\u0015\u0018Ë\u0092\u009bW^_d®\u0095£\t®v\u0004Þ5ë\u009f?Q{ax\u0087ÅÔ\u008dn8\u000ePß,ñÐhÅÄ\u001a~sC¾»^IFÔ\u0010eîÆ-#V\u0087\u0002|¶*\u001d'ýèÆõ{ì9êÛ\u001e\u008dªëkQë }HòÔL38+°¾,\u008f\u000b\u0016AÏ·\f\fú¶Ì\u0012Ñ¥\u0011\\H@Ó\u0005ZcìJÛ9\u001dx\u009bQ\r\u0010º!¶K\u009fÖÒ\u0097ü.ç¶5¼´ûfâ-Ò8\u000eÍû\u0084\"\b¼\fÛÈ\u008c \u001dä\u001e\u0081\u007fATQóé\u0097\u0003\fË\u0084$PÙ\u0006p)få\u000fßp\\\u0099ä5\u0005Q úüþÚ.\r!ÄDÎ¶(\u001c\u0014êá_G½\u0090sÝ\u0097Îü³ÏÝÐ\u008d«ú}\u001eJm¶m,@\u0013®\u0096\u0081qs\u0093Rq´³\u00ad@û\u0095A¬\u0015Ä×¼#×íiã9À®,ÿ\u008bÚ«Ä ©\tîH\u0085V{µ\r®`å½0\u000f\u009f»(Ý\u0098ÏÓü\u0098Òu\u008a\u000f$¿:\u009d0â\u0097eH±\u0083A¶0Ìðòx\u0010\u0082xî6\u0017[É\u0094ztY\u0095Ìú.\u001e9á\u0099£\u001aÝCnQ\u0007\u00ad\u008b\u0087}Ö\u001dà\u0004Ò\u0018i¬zK\u007fNX0\u0089ég\u0099b\u008a{\u0089Úñ«¬\u0085\u009cµ êfËÔ\u0014£,b\u0094 !ôá+¥9·üØÊ\u0083\u000e^§\u0098\u0016Uj4\u000b\u001f[@z\u0081E>\t.î¯p^wç\u001aù\u0018ëÓ\u0096ª\u0016\u0089xí\u009f\u0095\u0099¯\u0005O\u0013g1¤«>´\u0090\u0081\u0090Üé@ººFk\u0095m\u009bTôÇ8û©$¤7·ÌÇ¤ç\u00128$ÄÜï\u0005F'E\u001fH\t2ñ\u009c6Þ6&\u009cÇÄÒé\\åÖ¼_±\u0011\u00ad\fè\u0090\u009dßgï\u0012î:b\u001cå¶\u008cò\u0090MNÁnb\u0099\"\u001c(a&ñÈ\u001dCÝ¬ÊàµL-¾]¹\u0014\u008a\\ì\u0083\u0006d<2üY4Ê\u0019è]\u008aùª\u0005ïÚ+\t(\u0090#ÊâèKµÖ©\u0082ær³Ô:IåÍ©n\u001d\u0081Úz\u0084Óä\u0084ßFE3z\u0002àu³$\u0016-";
        int n3 = s.length();
        int n4 = 24;
        int n5 = -1;
    Label_0147:
        while (true) {
            while (true) {
                ++n5;
                final String s3 = s2;
                final int n6 = n5;
                String s4 = s3.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s4.getBytes(Class340.llIIllIlll[3]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                continue Label_0147;
                            }
                            n3 = (s2 = Class340.llIIllIlll[2]).length();
                            n4 = 40;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                break;
                            }
                            break Label_0147;
                        }
                    }
                    ++n5;
                    final String s5 = s2;
                    final int n8 = n5;
                    s4 = s5.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        b = b2;
        c = new String[22];
        Class340.ALPHA = new Class238(1, true, (byte)0);
        Class340.LUMINANCE = new Class238(1, false, (byte)0);
        Class340.LUMINANCE_ALPHA = new Class238(2, true, (byte)0);
        Class340.RGB = new Class238(3, false, (byte)0);
        Class340.RGBA = new Class238(4, true, (byte)0);
        Class340.BGRA = new Class238(4, true, (byte)0);
        Class340.ABGR = new Class238(4, true, (byte)0);
        SIGNATURE = new byte[] { -119, 80, 78, 71, 13, 10, 26, 10 };
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x345;
        if (Class340.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class340.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class340.llIIllIlll[4]);
                    array[1] = SecretKeyFactory.getInstance(Class340.llIIllIlll[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class340.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class340.llIIllIlll[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class340.c[n3] = a(((Cipher)array[0]).doFinal(Class340.b[n3].getBytes(Class340.llIIllIlll[7])));
        }
        return Class340.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class340.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIlIlIIlIII() {
        (llIIllIlll = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class340.llIIllIlll[1] = "DES";
        Class340.llIIllIlll[2] = "¿(ÊÍÿ¶\u0001ªñ\u0017Æ\u001c\"¿ìi\u008aÓúW0\u0096(\u0006:/½¡ËuÒä=kS¼\u009b9^Å(ÂF1Ü\u0099§Õl\u007fÖw@\u001d0\u000eåó\u0003Â\u0013\u0005Z\u0010ÿ\u0085Þ\u007f\u009c!Ü\u0086³\u000f\u0007Õ5â\u0001ò>";
        Class340.llIIllIlll[3] = "ISO-8859-1";
        Class340.llIIllIlll[4] = "DES/CBC/PKCS5Padding";
        Class340.llIIllIlll[5] = "DES";
        Class340.llIIllIlll[6] = "你是不是要来求我停止了呢垃圾狗篮子呢你干什么啊只会造谣的狗我不是什么所谓的大手你挺起腰杆好好努力不要灰心再过两年挑战爹爹NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u2004\u200d\u2004";
        Class340.llIIllIlll[7] = "ISO-8859-1";
        Class340.llIIllIlll[8] = "你是不是要来求我停止了呢垃圾狗篮子呢你干什么啊只会造谣的狗我不是什么所谓的大手你挺起腰杆好好努力不要灰心再过两年挑战爹爹NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u2004\u200d\u2004";
        Class340.llIIllIlll[9] = " : ";
        Class340.llIIllIlll[10] = " : ";
    }
    
    private static String lIIlIIlllIlI(final String s, final String s2) {
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
    
    private static String lIIlIIllllIl(final String s, final String s2) {
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
    
    private static String lIIlIIlllIIl(String s, final String s2) {
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
    
    private static boolean lIIlIllIIlII$255f299(final int n) {
        return n > 0;
    }
    
    private static boolean lIIlIllIIIII(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lIIlIllIIllI(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIlIlIlllII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIlIlIlllIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIlIllIIIIl(final int n) {
        return n < 0;
    }
    
    private static boolean lIIlIllIIlll(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIlIllIIlIl(final int n) {
        return n > 0;
    }
    
    static boolean lIIlIlIllIll(final int n, final int n2) {
        return n != n2;
    }
    
    private static int lIIlIllIlIII$2566aa8(final long n) {
        return lcmp(n, 0L);
    }
}
