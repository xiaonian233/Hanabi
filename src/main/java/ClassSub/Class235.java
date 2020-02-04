package ClassSub;

import org.lwjgl.*;
import java.nio.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class235 implements Class172
{
    private int width;
    private int height;
    private int texWidth;
    private int texHeight;
    private byte[] rawData;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIlIllll;
    
    private Class235(final int width, final int height) {
        super();
        this.width = width;
        this.height = height;
        this.texWidth = get2Fold(width);
        this.texHeight = get2Fold(height);
        this.rawData = new byte[this.texWidth * this.texHeight * 4];
    }
    
    private byte[] getRGBA() {
        return this.rawData;
    }
    
    @Override
    public final int getDepth() {
        return 32;
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
    public final ByteBuffer getImageBufferData() {
        final ByteBuffer byteBuffer;
        (byteBuffer = BufferUtils.createByteBuffer(this.rawData.length)).put(this.rawData);
        byteBuffer.flip();
        return byteBuffer;
    }
    
    private void setRGBA(int n, final int n2, final int n3, final int n4, final int n5, final int n6) {
        final int[] b = Class139.b();
        int n10;
        int n9;
        int n8;
        final int n7 = n8 = (n9 = (n10 = n));
        if (b == null) {
            if (n7 < 0) {
                throw new RuntimeException(String.valueOf(new StringBuilder("Specified location: ").append(n).append(Class235.lIIlIllll[0]).append(n2).append(" outside of image")));
            }
            final int n11;
            n8 = (n11 = (n9 = (n10 = n)));
        }
        if (b == null) {
            if (n7 >= this.width) {
                throw new RuntimeException(String.valueOf(new StringBuilder("Specified location: ").append(n).append(Class235.lIIlIllll[0]).append(n2).append(" outside of image")));
            }
            n10 = n2;
            n9 = n2;
            n8 = n2;
        }
        if (b == null) {
            if (n8 < 0) {
                throw new RuntimeException(String.valueOf(new StringBuilder("Specified location: ").append(n).append(Class235.lIIlIllll[0]).append(n2).append(" outside of image")));
            }
            n10 = n2;
            n9 = n2;
        }
        final int height = this.height;
        if (b == null) {
            if (n9 >= height) {
                throw new RuntimeException(String.valueOf(new StringBuilder("Specified location: ").append(n).append(Class235.lIIlIllll[0]).append(n2).append(" outside of image")));
            }
            n10 = n + n2 * this.texWidth;
        }
        n = n10 * height;
        if (b == null) {
            if (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN) {
                this.rawData[n] = (byte)n5;
                this.rawData[n + 1] = (byte)n4;
                this.rawData[n + 2] = (byte)n3;
                this.rawData[n + 3] = (byte)n6;
                if (b == null) {
                    return;
                }
            }
            this.rawData[n] = (byte)n3;
            this.rawData[n + 1] = (byte)n4;
            this.rawData[n + 2] = (byte)n5;
        }
        this.rawData[n + 3] = (byte)n6;
    }
    
    private Class85 getImage() {
        return new Class85(this);
    }
    
    private Class85 getImage(final int n) {
        return new Class85(this, n);
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
    
    static {
        llIlIIlIlI();
        Class169.a(587575399760751234L, 6490629271768714310L, MethodHandles.lookup().lookupClass()).a(49940657366351L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class235.lIIlIllll[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class235.lIIlIllll[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(123962787100470L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class235.lIIlIllll[3]).length();
        int char1 = 40;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class235.lIIlIllll[4]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
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
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5030;
        if (Class235.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class235.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class235.lIIlIllll[5]);
                    array[1] = SecretKeyFactory.getInstance(Class235.lIIlIllll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class235.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class235.lIIlIllll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class235.c[n3] = a(((Cipher)array[0]).doFinal(Class235.b[n3].getBytes(Class235.lIIlIllll[8])));
        }
        return Class235.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class235.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llIlIIlIlI() {
        (lIIlIllll = new String[12])[0] = ",";
        Class235.lIIlIllll[1] = "DES/CBC/PKCS5Padding";
        Class235.lIIlIllll[2] = "DES";
        Class235.lIIlIllll[3] = "Þ\u001e¹Ê\u0005ª^Õ\u009fU\u0088\u001a?ÿ\u0005^ùkÞÜò\u0083çô\u0015\u0017ÕWhü½½`Û\u001ccHÕ\u0018\u009c(ÿn\bfD\u0016 q¨ìÏ´n¿Ö\u0011\u008aú\tÓ¥fîÐÚìbÀ4o<þ\u0003Í\u0015ò_\u009cø\u0099";
        Class235.lIIlIllll[4] = "ISO-8859-1";
        Class235.lIIlIllll[5] = "DES/CBC/PKCS5Padding";
        Class235.lIIlIllll[6] = "DES";
        Class235.lIIlIllll[7] = "因为你装的实在是太假了你还想赢吗你用低俗的语言和我高尚的品格进行着你自己不可战胜的精神的较量继续在你爹我的空间里面复制粘贴带着你的废物滚出妖域的视线可以么NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008 \u200f\u200e";
        Class235.lIIlIllll[8] = "ISO-8859-1";
        Class235.lIIlIllll[9] = "因为你装的实在是太假了你还想赢吗你用低俗的语言和我高尚的品格进行着你自己不可战胜的精神的较量继续在你爹我的空间里面复制粘贴带着你的废物滚出妖域的视线可以么NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008 \u200f\u200e";
        Class235.lIIlIllll[10] = " : ";
        Class235.lIIlIllll[11] = " : ";
    }
    
    private static String llIlIIlIII(final String s, final String s2) {
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
    
    private static String llIlIIlIIl(final String s, final String s2) {
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
    
    private static String llIlIIIlll(String s, final String s2) {
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
    
    private static boolean lIIIIIIIllI(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIIIIIIlll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIIIIIIlII(final int n) {
        return n >= 0;
    }
}
