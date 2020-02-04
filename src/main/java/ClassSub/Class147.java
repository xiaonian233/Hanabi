package ClassSub;

import java.io.*;
import java.nio.*;
import org.lwjgl.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Class147 implements Class296
{
    private int texWidth;
    private int texHeight;
    private int width;
    private int height;
    private short pixelDepth;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lllIIlIIlI;
    
    public Class147() {
        super();
    }
    
    private static short flipEndian(final short n) {
        final int n2 = n & 0xFFFF;
        return (short)(n2 << 8 | (n2 & 0xFF00) >>> 8);
    }
    
    @Override
    public final int getDepth() {
        return this.pixelDepth;
    }
    
    @Override
    public final int getWidth() {
        return this.width;
    }
    
    @Override
    public final int getHeight() {
        return this.height;
    }
    
    @Override
    public final int getTexWidth() {
        return this.texWidth;
    }
    
    @Override
    public final int getTexHeight() {
        return this.texHeight;
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
    public final ByteBuffer loadImage(final InputStream inputStream, boolean n, boolean n2, final int[] array) throws IOException {
        final int[] b = Class139.b();
        if (array != null) {
            n2 = (true ? 1 : 0);
        }
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 100000);
        final DataInputStream dataInputStream;
        final short n3 = (short)(dataInputStream = new DataInputStream(bufferedInputStream)).read();
        dataInputStream.read();
        final short n4 = (short)dataInputStream.read();
        dataInputStream.readShort();
        dataInputStream.readShort();
        dataInputStream.read();
        dataInputStream.readShort();
        dataInputStream.readShort();
        final short n5 = n4;
        final short n6 = 2;
        short n7 = 0;
        Label_0189: {
            if (b == null) {
                if (lIlIIlIlIIIl(n5, n6)) {
                    throw new IOException("Slick only supports uncompressed RGB(A) TGA images");
                }
                this.width = flipEndian(dataInputStream.readShort());
                this.height = flipEndian(dataInputStream.readShort());
                this.pixelDepth = (short)dataInputStream.read();
                final short pixelDepth;
                n7 = (pixelDepth = this.pixelDepth);
                if (b != null) {
                    break Label_0189;
                }
            }
            if (n5 == n6) {
                n2 = (false ? 1 : 0);
            }
            this.texWidth = get2Fold(this.width);
            this.texHeight = get2Fold(this.height);
            n7 = (short)dataInputStream.read();
        }
        final short n8 = (short)(n7 & 0x20);
        if (b == null && n8 == 0) {
            final boolean b2 = n != 0;
            if (b == null && b2) {}
            n = (b2 ? 1 : 0);
            goto Label_0215;
        }
        if (n8 > 0) {
            bufferedInputStream.skip(n3);
        }
        int pixelDepth2;
        final short n9 = (short)(pixelDepth2 = this.pixelDepth);
        final int n10 = 32;
        byte[] array2 = null;
        Label_0331: {
            if (b == null) {
                Label_0263: {
                    if (lIlIIlIlIIIl(n9, n10)) {
                        int n12;
                        final int n11 = n12 = n2;
                        if (b == null) {
                            if (n11 != 0) {
                                break Label_0263;
                            }
                            final short pixelDepth3;
                            n12 = (pixelDepth3 = this.pixelDepth);
                        }
                        final int n13 = 24;
                        if (b == null) {
                            if (n11 != n13) {
                                throw new RuntimeException("Only 24 and 32 bit TGAs are supported");
                            }
                            n12 = this.texWidth * this.texHeight;
                        }
                        array2 = new byte[n12 * n13];
                        break Label_0331;
                    }
                }
                this.pixelDepth = 32;
                pixelDepth2 = this.texWidth * this.texHeight;
            }
            array2 = new byte[pixelDepth2 * n10];
        }
        final short pixelDepth4 = this.pixelDepth;
        final short n14 = 24;
        int n16 = 0;
        Label_1144: {
            Label_1041: {
                int pixelDepth5 = 0;
                short n20 = 0;
                Label_0612: {
                    if (b == null) {
                        if (pixelDepth4 == n14) {
                            final int n15 = n;
                            if (b == null && n15 != 0) {
                                int i = this.height - 1;
                            Label_0470_Outer:
                                while (i >= 0) {
                                    n16 = 0;
                                    if (b == null) {
                                        int j = n16;
                                        while (true) {
                                            while (j < this.width) {
                                                final byte byte1 = dataInputStream.readByte();
                                                final byte byte2 = dataInputStream.readByte();
                                                final byte byte3 = dataInputStream.readByte();
                                                final int n17 = (j + i * this.texWidth) * 3;
                                                array2[n17] = byte3;
                                                array2[n17 + 1] = byte2;
                                                array2[n17 + 2] = byte1;
                                                ++j;
                                                if (b == null) {
                                                    if (b != null) {
                                                        break;
                                                    }
                                                    continue Label_0470_Outer;
                                                }
                                                else {
                                                    if (b != null) {
                                                        break Label_0470_Outer;
                                                    }
                                                    continue Label_0470_Outer;
                                                }
                                            }
                                            --i;
                                            continue;
                                        }
                                    }
                                    break Label_1144;
                                }
                                if (b != null) {
                                    goto Label_0480;
                                }
                                break Label_1041;
                            }
                            else {
                                int k = n15;
                            Label_0587_Outer:
                                while (k < this.height) {
                                    final int n18 = 0;
                                    if (b == null) {
                                        int l = n18;
                                        while (true) {
                                            while (l < this.width) {
                                                final byte byte4 = dataInputStream.readByte();
                                                final byte byte5 = dataInputStream.readByte();
                                                final byte byte6 = dataInputStream.readByte();
                                                final int n19 = (l + k * this.texWidth) * 3;
                                                array2[n19] = byte6;
                                                array2[n19 + 1] = byte5;
                                                array2[n19 + 2] = byte4;
                                                ++l;
                                                if (b == null) {
                                                    if (b != null) {
                                                        break;
                                                    }
                                                    continue Label_0587_Outer;
                                                }
                                                else {
                                                    if (b != null) {
                                                        break Label_0587_Outer;
                                                    }
                                                    continue Label_0587_Outer;
                                                }
                                            }
                                            ++k;
                                            continue;
                                        }
                                    }
                                    break Label_1144;
                                }
                                if (b == null) {
                                    break Label_1041;
                                }
                            }
                        }
                        final short n21;
                        n20 = (n21 = (short)(pixelDepth5 = this.pixelDepth));
                        if (b != null) {
                            break Label_0612;
                        }
                    }
                    if (pixelDepth4 != n14) {
                        break Label_1041;
                    }
                    pixelDepth5 = (n20 = (short)n);
                }
                if (b == null) {
                    if (n20 != 0) {
                        int n22 = this.height - 1;
                        do {
                            int n23 = 0;
                        Label_0630:
                            while (n23 >= 0) {
                                final int n24 = 0;
                                if (b != null) {
                                    break Label_1144;
                                }
                                int n25 = n24;
                                while (n25 < this.width) {
                                    final byte byte7 = dataInputStream.readByte();
                                    final byte byte8 = dataInputStream.readByte();
                                    final byte byte9 = dataInputStream.readByte();
                                    byte byte10;
                                    n23 = (byte10 = (byte)n2);
                                    if (b != null) {
                                        continue Label_0630;
                                    }
                                    byte b3 = 0;
                                    Label_0706: {
                                        if (b == null) {
                                            if (n23 != 0) {
                                                b3 = -1;
                                                if (b == null) {
                                                    break Label_0706;
                                                }
                                            }
                                            byte10 = dataInputStream.readByte();
                                        }
                                        b3 = byte10;
                                    }
                                    final int n26 = (n25 + n22 * this.texWidth) * 4;
                                    array2[n26] = byte9;
                                    array2[n26 + 1] = byte8;
                                    array2[n26 + 2] = byte7;
                                    array2[n26 + 3] = b3;
                                    if (b == null) {
                                        if (b3 == 0) {
                                            array2[n26 + 2] = 0;
                                            array2[n26] = (array2[n26 + 1] = 0);
                                        }
                                        ++n25;
                                    }
                                    if (b != null) {
                                        break;
                                    }
                                }
                                --n22;
                            }
                            break;
                        } while (b == null);
                        if (b == null) {
                            break Label_1041;
                        }
                    }
                    pixelDepth5 = 0;
                }
                int n27 = pixelDepth5;
                do {
                    int n28 = 0;
                Label_0814:
                    while (n28 < this.height) {
                        final int n29 = 0;
                        if (b != null) {
                            break Label_1144;
                        }
                        int n30 = n29;
                        while (n30 < this.width) {
                            final byte byte11 = dataInputStream.readByte();
                            final byte byte12 = dataInputStream.readByte();
                            final byte byte13 = dataInputStream.readByte();
                            byte byte14;
                            n28 = (byte14 = (byte)n2);
                            if (b != null) {
                                continue Label_0814;
                            }
                            byte b4 = 0;
                            Label_0886: {
                                if (b == null) {
                                    if (n28 != 0) {
                                        b4 = -1;
                                        if (b == null) {
                                            break Label_0886;
                                        }
                                    }
                                    byte14 = dataInputStream.readByte();
                                }
                                b4 = byte14;
                            }
                            final int n31 = (n30 + n27 * this.texWidth) * 4;
                            Label_0998: {
                                if (b == null) {
                                    if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                                        array2[n31] = byte13;
                                        array2[n31 + 1] = byte12;
                                        array2[n31 + 2] = byte11;
                                        array2[n31 + 3] = b4;
                                        if (b == null) {
                                            break Label_0998;
                                        }
                                    }
                                    array2[n31] = byte13;
                                    array2[n31 + 1] = byte12;
                                    array2[n31 + 2] = byte11;
                                }
                                array2[n31 + 3] = b4;
                            }
                            if (b4 == 0) {
                                array2[n31 + 2] = 0;
                                array2[n31] = (array2[n31 + 1] = 0);
                            }
                            ++n30;
                            if (b != null) {
                                break;
                            }
                        }
                        ++n27;
                    }
                    break;
                } while (b == null);
            }
            inputStream.close();
            if (array != null) {
                int n32 = 0;
                do {
                    int n33 = 0;
                    Label_1053: {
                        n33 = n32;
                    }
                    final int length = array2.length;
                    int n34 = 0;
                    Label_1058:
                    while (n33 < n34) {
                        int n35 = 1;
                        final int n36 = 0;
                        if (b == null) {
                            int n37 = n36;
                            while (n37 < 3) {
                                byte b6;
                                final byte b5 = (byte)(n33 = (b6 = array2[n32 + n37]));
                                Label_1111: {
                                    if (b == null) {
                                        n34 = array[n37];
                                        if (b != null) {
                                            continue Label_1058;
                                        }
                                        if (!lIlIIlIlIIIl(b5, n34)) {
                                            break Label_1111;
                                        }
                                        b6 = 0;
                                    }
                                    n35 = b6;
                                }
                                ++n37;
                                if (b != null) {
                                    break;
                                }
                            }
                            if (n35 != 0) {
                                array2[n32 + 3] = 0;
                            }
                            n32 += 4;
                            continue Label_1053;
                        }
                        break Label_1144;
                    }
                    break;
                } while (b == null);
            }
            final int length2 = array2.length;
        }
        final ByteBuffer byteBuffer;
        (byteBuffer = BufferUtils.createByteBuffer(n16)).put(array2);
        final short n38 = (short)(this.pixelDepth / 8);
        final int height = this.height;
        final int n39 = this.texHeight - 1;
        Label_1444: {
            int n43 = 0;
            Label_1306: {
                if (b == null) {
                    if (height < n39) {
                        final int n40 = (this.texHeight - 1) * (this.texWidth * n38);
                        final int n41 = (this.height - 1) * (this.texWidth * n38);
                        int n42 = 0;
                        while (n42 < this.texWidth * n38) {
                            byteBuffer.put(n40 + n42, byteBuffer.get(n42));
                            byteBuffer.put(n41 + this.texWidth * n38 + n42, byteBuffer.get(this.texWidth * n38 + n42));
                            ++n42;
                            if (b != null) {
                                return byteBuffer;
                            }
                            if (b != null) {
                                break;
                            }
                        }
                    }
                    final int width;
                    n43 = (width = this.width);
                    if (b != null) {
                        break Label_1306;
                    }
                    final int n44 = this.texWidth - 1;
                }
                if (height >= n39) {
                    break Label_1444;
                }
                n43 = 0;
            }
            int n45 = n43;
        Label_1439_Outer:
            while (n45 < this.texHeight) {
                if (b == null) {
                    short n46 = 0;
                    while (true) {
                        while (n46 < n38) {
                            byteBuffer.put((n45 + 1) * (this.texWidth * n38) - n38 + n46, byteBuffer.get(n45 * (this.texWidth * n38) + n46));
                            byteBuffer.put(n45 * (this.texWidth * n38) + this.width * n38 + n46, byteBuffer.get(n45 * (this.texWidth * n38) + (this.width - 1) * n38 + n46));
                            ++n46;
                            if (b == null) {
                                if (b != null) {
                                    break;
                                }
                                continue Label_1439_Outer;
                            }
                            else {
                                if (b != null) {
                                    break Label_1444;
                                }
                                continue Label_1439_Outer;
                            }
                        }
                        ++n45;
                        continue;
                    }
                }
                return byteBuffer;
            }
        }
        byteBuffer.flip();
        return byteBuffer;
    }
    
    private static int get2Fold(final int n) {
        final int[] b = Class139.b();
        int i = 2;
        final int[] array = b;
        int n2 = 0;
        while (i < n) {
            n2 = i * 2;
            if (array != null) {
                return n2;
            }
            i = n2;
            if (array != null) {
                break;
            }
        }
        return n2;
    }
    
    @Override
    public final ByteBuffer getImageBufferData() {
        throw new RuntimeException("TGAImageData doesn't store it's image.");
    }
    
    @Override
    public final void configureEdging(final boolean b) {
    }
    
    static {
        lIlIIlIIlllI();
        Class169.a(5252279556195406061L, 3617716350766597233L, MethodHandles.lookup().lookupClass()).a(166338050394554L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class147.lllIIlIIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class147.lllIIlIIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(63778617519687L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Class147.lllIIlIIlI[2]).length();
        int char1 = 88;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class147.lllIIlIIlI[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[3];
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
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0xA58;
        if (Class147.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class147.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class147.lllIIlIIlI[4]);
                    array[1] = SecretKeyFactory.getInstance(Class147.lllIIlIIlI[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class147.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class147.lllIIlIIlI[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class147.c[n3] = a(((Cipher)array[0]).doFinal(Class147.b[n3].getBytes(Class147.lllIIlIIlI[7])));
        }
        return Class147.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class147.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIlIIlIIlllI() {
        (lllIIlIIlI = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class147.lllIIlIIlI[1] = "DES";
        Class147.lllIIlIIlI[2] = "a\u009e\u001d\u0092O1$ÌV&ËÜe\u0095'ðÄ\r¸qê\u0099Ñ}RÜ]\u0087@s¶Ëè0ßRÝ\u0080Õ\u0099ÉW®\u0092\u0083é¢\u008btQ\u001d\u001d\u0000r\fí^\f×\u0017\u0083 2ËÕ\u008d±»«\u009e©²*\u0016ïÒ\u0005\u009dÉ\u0088\u008aÃ\u0080ð_¯ý¨@ÁßgP\u001dDÕ\u0018«,qó\u0019ó\u0086\u001aÕ\u0089þ\\²`ì+8ò\u009a2õ\u00ad×ûý¤\u0019pX¯C_g=¾+\få'\u0014¨)þ\u0019\u0089\nØ@~í \u0080Ð\u001aî=8@?û\\@ \rÍÒiûá4\u0003\u0097Hµ\u0088ÞZ\u0014Ó\"£èdBõÚÕ\u0082ÙIµ\u000b¬06Êv÷²\nÈ\u009fUó$YN\u008d²C}»Ê";
        Class147.lllIIlIIlI[3] = "ISO-8859-1";
        Class147.lllIIlIIlI[4] = "DES/CBC/PKCS5Padding";
        Class147.lllIIlIIlI[5] = "DES";
        Class147.lllIIlIIlI[6] = "对于我的估计你无法抵挡你只能乱敲键盘告诉我对你对话使我感到了一种莫名的耻辱你自己看看你现在的语言是否还有逻辑自己告诉你亲爹地我稳坐如山我看你沾沾自喜的样子你是不是以为你可以胜利啊为什么我速度这么快啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u200c\u2009\u2006";
        Class147.lllIIlIIlI[7] = "ISO-8859-1";
        Class147.lllIIlIIlI[8] = "对于我的估计你无法抵挡你只能乱敲键盘告诉我对你对话使我感到了一种莫名的耻辱你自己看看你现在的语言是否还有逻辑自己告诉你亲爹地我稳坐如山我看你沾沾自喜的样子你是不是以为你可以胜利啊为什么我速度这么快啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u200c\u2009\u2006";
        Class147.lllIIlIIlI[9] = " : ";
        Class147.lllIIlIIlI[10] = " : ";
    }
    
    private static String lIlIIIlllllI(String s, final String s2) {
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
    
    private static String lIlIIIllllll(final String s, final String s2) {
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
    
    private static String lIlIIIllllIl(final String s, final String s2) {
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
    
    private static boolean lIlIIlIllIlI(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIlIIlIllIII(final int n) {
        return n >= 0;
    }
    
    private static boolean lIlIIlIlIlII(final int n) {
        return n > 0;
    }
    
    private static boolean lIlIIlIlIIIl(final int n, final int n2) {
        return n != n2;
    }
}
