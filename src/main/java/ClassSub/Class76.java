package ClassSub;

import java.nio.*;
import java.io.*;
import org.lwjgl.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class76 implements Class296
{
    private int width;
    private int height;
    private int texHeight;
    private int texWidth;
    private Class340 decoder;
    private int bitDepth;
    private ByteBuffer scratch;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lllIIIIlIl;
    
    public Class76() {
        super();
    }
    
    @Override
    public final int getDepth() {
        return this.bitDepth;
    }
    
    @Override
    public final ByteBuffer getImageBufferData() {
        return this.scratch;
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
    public final ByteBuffer loadImage(final InputStream inputStream) throws IOException {
        return this.loadImage(inputStream, false, null);
    }
    
    @Override
    public final ByteBuffer loadImage(final InputStream inputStream, final boolean b, final int[] array) throws IOException {
        return this.loadImage(inputStream, b, false, array);
    }
    
    @Override
    public final ByteBuffer loadImage(final InputStream inputStream, final boolean b, final boolean b2, final int[] array) throws IOException {
        final int[] b3;
        if ((b3 = Class139.b()) != null || array != null) {
            throw new IOException("Transparent color not support in custom PNG Decoder");
        }
        final Class340 class341;
        final Class340 class340 = class341 = new Class340(inputStream);
        final int[] b4 = Class139.b();
        int n3;
        final int n2;
        final int n = n2 = (n3 = class341.colorType);
        final int n4;
        final int colorType;
        if (b4 == null) {
            if (Class340.lIIlIlIllIll(n, 6)) {
                n4 = (n3 = class341.colorType);
                if (b4 == null) {
                    if (Class340.lIIlIlIllIll(n4, 2)) {
                        colorType = class341.colorType;
                        if (b4 == null) {
                            if (colorType == 3) {}
                        }
                    }
                }
            }
        }
        if (b3 == null) {
            if (n == 0) {
                throw new IOException("Only RGB formatted images are supported by the PNGLoader");
            }
            this.width = class340.width;
            this.height = class340.height;
            this.texWidth = get2Fold(this.width);
            this.texHeight = get2Fold(this.height);
            class340.hasAlpha();
        }
        if (b3 == null && n4 == 0) {}
        final int n5 = colorType;
        int hasAlpha;
        final boolean b5 = (hasAlpha = (class340.hasAlpha() ? 1 : 0)) != 0;
        if (b3 == null) {
            if (b5) {
                hasAlpha = 32;
            }
            else {
                hasAlpha = 24;
            }
        }
        this.bitDepth = hasAlpha;
        class340.decode(this.scratch = BufferUtils.createByteBuffer(this.texWidth * this.texHeight * n5), this.texWidth * n5, (n5 == 4) ? Class340.RGBA : Class340.RGB);
        final int height = this.height;
        final int n6 = this.texHeight - 1;
        int n9 = 0;
        final int width;
        int n13 = 0;
        Label_0573: {
            if (b3 == null) {
                Label_0407: {
                    Label_0403: {
                        if (height < n6) {
                            final int n7 = (this.texHeight - 1) * (this.texWidth * n5);
                            final int n8 = (this.height - 1) * (this.texWidth * n5);
                            int i = 0;
                        Label_0399_Outer:
                            while (i < this.texWidth) {
                                final int n11;
                                final int n10;
                                n9 = (n10 = (n11 = 0));
                                if (b3 == null) {
                                    int j = n9;
                                    while (true) {
                                        while (j < n5) {
                                            this.scratch.put(n7 + i + j, this.scratch.get(i + j));
                                            this.scratch.put(n8 + this.texWidth * n5 + i + j, this.scratch.get(n8 + i + j));
                                            ++j;
                                            if (b3 == null) {
                                                if (b3 != null) {
                                                    break;
                                                }
                                                continue Label_0399_Outer;
                                            }
                                            else {
                                                if (b3 != null) {
                                                    break Label_0403;
                                                }
                                                continue Label_0399_Outer;
                                            }
                                        }
                                        ++i;
                                        continue;
                                    }
                                }
                                break Label_0407;
                            }
                        }
                    }
                    width = this.width;
                }
                if (b3 != null) {
                    break Label_0573;
                }
                final int n12 = this.texWidth - 1;
            }
            Label_0569: {
                if (height < n6) {
                    int k = 0;
                Label_0565_Outer:
                    while (k < this.texHeight) {
                        final int n11;
                        n13 = (n11 = 0);
                        if (b3 == null) {
                            int l = n13;
                            while (true) {
                                while (l < n5) {
                                    this.scratch.put((k + 1) * (this.texWidth * n5) - n5 + l, this.scratch.get(k * (this.texWidth * n5) + l));
                                    this.scratch.put(k * (this.texWidth * n5) + this.width * n5 + l, this.scratch.get(k * (this.texWidth * n5) + (this.width - 1) * n5 + l));
                                    ++l;
                                    if (b3 == null) {
                                        if (b3 != null) {
                                            break;
                                        }
                                        continue Label_0565_Outer;
                                    }
                                    else {
                                        if (b3 != null) {
                                            break Label_0569;
                                        }
                                        continue Label_0565_Outer;
                                    }
                                }
                                ++k;
                                continue;
                            }
                        }
                        break Label_0573;
                    }
                }
            }
            class340.hasAlpha();
        }
        Label_0804: {
            if (b3 != null || n9 == 0) {
                if (b3 == null) {
                    if (n13 == 0) {
                        break Label_0804;
                    }
                    final int n11 = this.texWidth * this.texHeight * 4;
                }
                final ByteBuffer byteBuffer = BufferUtils.createByteBuffer(width);
                int n14 = 0;
                while (true) {
                    do {
                        Label_0608: {
                            final int texWidth = this.texWidth;
                        }
                        int n15 = 0;
                        int height2 = 0;
                        Label_0614:
                        while (n15 < height2) {
                            if (b3 == null) {
                                int n16 = 0;
                                while (n16 < this.texHeight) {
                                    final int n17 = n16 * 3 + n14 * this.texHeight * 3;
                                    final int n18 = n16 * 4 + n14 * this.texHeight * 4;
                                    byteBuffer.put(n18, this.scratch.get(n17));
                                    byteBuffer.put(n18 + 1, this.scratch.get(n17 + 1));
                                    byteBuffer.put(n18 + 2, this.scratch.get(n17 + 2));
                                    Label_0778: {
                                        if (b3 == null) {
                                            n15 = n14;
                                            height2 = this.height;
                                            if (b3 != null) {
                                                continue Label_0614;
                                            }
                                            if (n15 < height2 && n16 < this.width) {
                                                byteBuffer.put(n18 + 3, (byte)(-1));
                                                if (b3 == null) {
                                                    break Label_0778;
                                                }
                                            }
                                            byteBuffer.put(n18 + 3, (byte)0);
                                        }
                                    }
                                    ++n16;
                                    if (b3 != null) {
                                        break;
                                    }
                                }
                                ++n14;
                                continue Label_0608;
                            }
                            this.scratch = byteBuffer;
                            break Label_0804;
                        }
                        break;
                    } while (b3 == null);
                    this.bitDepth = 32;
                    continue;
                }
            }
        }
        this.scratch.position(0);
        return this.scratch;
    }
    
    private static int toInt(final byte b) {
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
    public final void configureEdging(final boolean b) {
    }
    
    @Override
    public final int getWidth() {
        return this.width;
    }
    
    @Override
    public final int getHeight() {
        return this.height;
    }
    
    static {
        lIlIIIIlIIII();
        Class169.a(3157314083555492827L, 3752488753084756284L, MethodHandles.lookup().lookupClass()).a(248002021662172L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class76.lllIIIIlIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class76.lllIIIIlIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(42624857365055L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class76.lllIIIIlIl[2]).length();
        int char1 = 104;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class76.lllIIIIlIl[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x4AB7;
        if (Class76.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class76.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class76.lllIIIIlIl[4]);
                    array[1] = SecretKeyFactory.getInstance(Class76.lllIIIIlIl[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class76.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class76.lllIIIIlIl[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class76.c[n3] = a(((Cipher)array[0]).doFinal(Class76.b[n3].getBytes(Class76.lllIIIIlIl[7])));
        }
        return Class76.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class76.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIlIIIIlIIII() {
        (lllIIIIlIl = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class76.lllIIIIlIl[1] = "DES";
        Class76.lllIIIIlIl[2] = "H\u008eþÇ&#Ût\bÑwQÐ\u0095\u000e,\u0095Á§>+²\f\bøáÃª#¹&I\u0001a\u0095/¸\u0014Æ\u00adE\u0090N\"?P¼þÝ\u000f¶s]\u0016ì\u0099õaà\u0098L\u000baKt\"µdvÔ.¯Ü\u009e£\u0005HzsUó\u009au¾©IEÎvù«\tÎ\u0017BO|ãS<Ü\u009bÞ\u0081XÇm\u0017¹H'í«4-\u0019\u0096ôÛé$\u0006\u001bÞ\u0014V\u0012ò±Ní\u0018d\u0016ò¼\u00020\u0019¶\u00856\u0099ó®Ñ:Å\u0080íYCg\u000bÚtÝXU62)ø\rÄ\u0094ÅÛ\u0014½\f§\r\u0081ð¨mTd\u0093ü\u0082Ú£\u0091\u0015G\u0006\u0011Px@Ý";
        Class76.lllIIIIlIl[3] = "ISO-8859-1";
        Class76.lllIIIIlIl[4] = "DES/CBC/PKCS5Padding";
        Class76.lllIIIIlIl[5] = "DES";
        Class76.lllIIIIlIl[6] = "因为你早就被人揍的麻木了是不你可以否认你没有文化的事实那么请你拿出实力我一直都是你的爹呢我说孩子你这样下去我可不喜欢你了啊可以滚开你企图用你拖拉机的速度和你狗刨式的方式来激起你爹爹我的小宇宙NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u2002\u200a\u200a";
        Class76.lllIIIIlIl[7] = "ISO-8859-1";
        Class76.lllIIIIlIl[8] = "因为你早就被人揍的麻木了是不你可以否认你没有文化的事实那么请你拿出实力我一直都是你的爹呢我说孩子你这样下去我可不喜欢你了啊可以滚开你企图用你拖拉机的速度和你狗刨式的方式来激起你爹爹我的小宇宙NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u2002\u200a\u200a";
        Class76.lllIIIIlIl[9] = " : ";
        Class76.lllIIIIlIl[10] = " : ";
    }
    
    private static String lIlIIIIIlIIl(final String s, final String s2) {
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
    
    private static String lIlIIIIIllll(String s, final String s2) {
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
    
    private static String lIlIIIIIllII(final String s, final String s2) {
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
    
    private static boolean lIlIIIlIIlIl(final int n) {
        return n < 0;
    }
}
