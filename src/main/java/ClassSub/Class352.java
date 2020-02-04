package ClassSub;

import org.lwjgl.input.*;
import org.lwjgl.*;
import java.io.*;
import java.nio.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class352
{
    private static Class352 single;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIlIIlllIll;
    
    private static Class352 get() {
        return Class352.single;
    }
    
    private Class352() {
        super();
    }
    
    private static Cursor getCursor(final String s, final int n, final int n2) throws IOException, LWJGLException {
        final int[] b = Class139.b();
        final Class296 imageData;
        (imageData = Class8.getImageDataFor(s)).configureEdging(false);
        final ByteBuffer loadImage = imageData.loadImage(Class5.getResourceAsStream(s), true, true, null);
        final int[] array = b;
        int i = 0;
        Label_0159: {
            while (i < loadImage.limit()) {
                final byte value = loadImage.get(i);
                final byte value2 = loadImage.get(i + 1);
                final byte value3 = loadImage.get(i + 2);
                final byte value4 = loadImage.get(i + 3);
                loadImage.put(i + 2, value);
                loadImage.put(i + 1, value2);
                loadImage.put(i, value3);
                loadImage.put(i + 3, value4);
                i += 4;
                if (array != null) {
                    break Label_0159;
                }
                if (array != null) {
                    break;
                }
            }
            final Class296 class296 = imageData;
            try {
                i = class296.getHeight() - n2 - 1;
                final int n3 = i;
                if (array != null || n3 < 0) {
                    i = n3;
                }
                return new Cursor(imageData.getTexWidth(), imageData.getTexHeight(), n, i, 1, loadImage.asIntBuffer(), (IntBuffer)null);
            }
            catch (Throwable t) {
                Class355.info("Chances are you cursor is too small for this platform");
                throw new LWJGLException(t);
            }
        }
    }
    
    private static Cursor getCursor(final ByteBuffer byteBuffer, final int n, final int n2, final int n3, final int n4) throws IOException, LWJGLException {
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        while (true) {
            while (i < byteBuffer.limit()) {
                final byte value = byteBuffer.get(i);
                final byte value2 = byteBuffer.get(i + 1);
                final byte value3 = byteBuffer.get(i + 2);
                final byte value4 = byteBuffer.get(i + 3);
                byteBuffer.put(i + 2, value);
                byteBuffer.put(i + 1, value2);
                byteBuffer.put(i, value3);
                byteBuffer.put(i + 3, value4);
                i += 4;
                if (array == null) {
                    if (array != null) {
                        break;
                    }
                    continue;
                }
                else {
                    final int n5 = i;
                    final int[] array2 = array;
                    try {
                        if (array2 != null || n5 < 0) {
                            i = n5;
                        }
                        return new Cursor(n3, n4, n, i, 1, byteBuffer.asIntBuffer(), (IntBuffer)null);
                    }
                    catch (Throwable t) {
                        Class355.info("Chances are you cursor is too small for this platform");
                        throw new LWJGLException(t);
                    }
                }
            }
            i = n4 - n2 - 1;
            continue;
        }
    }
    
    private static Cursor getCursor(final Class78 class78, final int n, final int n2) throws IOException, LWJGLException {
        final int[] b = Class139.b();
        final ByteBuffer imageBufferData = class78.getImageBufferData();
        int i = 0;
        final int[] array = b;
        Label_0140: {
            while (i < imageBufferData.limit()) {
                final byte value = imageBufferData.get(i);
                final byte value2 = imageBufferData.get(i + 1);
                final byte value3 = imageBufferData.get(i + 2);
                final byte value4 = imageBufferData.get(i + 3);
                imageBufferData.put(i + 2, value);
                imageBufferData.put(i + 1, value2);
                imageBufferData.put(i, value3);
                imageBufferData.put(i + 3, value4);
                i += 4;
                if (array != null) {
                    break Label_0140;
                }
                if (array != null) {
                    break;
                }
            }
            try {
                i = class78.getHeight() - n2 - 1;
                final int n3 = i;
                if (array != null || n3 < 0) {
                    i = n3;
                }
                return new Cursor(class78.getTexWidth(), class78.getTexHeight(), n, i, 1, imageBufferData.asIntBuffer(), (IntBuffer)null);
            }
            catch (Throwable t) {
                Class355.info("Chances are you cursor is too small for this platform");
                throw new LWJGLException(t);
            }
        }
    }
    
    private static Cursor getAnimatedCursor(final String s, final int n, final int n2, final int n3, final int n4, final int[] array) throws IOException, LWJGLException {
        final IntBuffer intBuffer = ByteBuffer.allocateDirect(array.length * 4).order(ByteOrder.nativeOrder()).asIntBuffer();
        final int[] b = Class139.b();
        int i = 0;
        final int[] array2 = b;
        while (i < array.length) {
            intBuffer.put(array[i]);
            ++i;
            if (array2 != null) {
                return new Cursor(n3, n4, n, n2, array.length, new Class147().loadImage(Class5.getResourceAsStream(s), false, null).asIntBuffer(), intBuffer);
            }
            if (array2 != null) {
                break;
            }
        }
        intBuffer.flip();
        return new Cursor(n3, n4, n, n2, array.length, new Class147().loadImage(Class5.getResourceAsStream(s), false, null).asIntBuffer(), intBuffer);
    }
    
    static {
        lllIlIIIlllI();
        Class169.a(8695563128984217835L, 4204442908141966414L, MethodHandles.lookup().lookupClass()).a(50692709633315L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class352.lIlIIlllIll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class352.lIlIIlllIll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(74121374006563L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class352.lIlIIlllIll[2]).length();
        int char1 = 88;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class352.lIlIIlllIll[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
        Class352.single = new Class352();
    }
    
    private static Throwable a(final Throwable t) {
        return t;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x3CD3;
        if (Class352.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class352.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class352.lIlIIlllIll[4]);
                    array[1] = SecretKeyFactory.getInstance(Class352.lIlIIlllIll[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class352.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class352.lIlIIlllIll[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class352.c[n3] = a(((Cipher)array[0]).doFinal(Class352.b[n3].getBytes(Class352.lIlIIlllIll[7])));
        }
        return Class352.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class352.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lllIlIIIlllI() {
        (lIlIIlllIll = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class352.lIlIIlllIll[1] = "DES";
        Class352.lIlIIlllIll[2] = "ÀxÖ*©\u0012ë\u0005\u0002Û\u0015úuÒ\u0012\u008b\u0010Þ4rm\u0093û^\u0000Ík0\u001fü\u0096\u0018\u0095{êÓ\u008eÖ©CvÛ\u0088çü\u0004N\u0085\\\u001eúVÿnNà÷ÊëW\\\u0005ýÌÞæY\u001b¼ç)ð-\u0087Å\u0084Mãï/Ä9XØ\u008d¾\u0003 XO±Ù\u0006Ûa\u008b\u0017\u00ad·&È¬x\u0090ù¢G\u0099³{.¨ØN\f\u0019\u0099\np-Ã³æ\u009cÉËÂ\u0012óx\u0089·oq\u001cÙD'/(ãÿ\u0083\u0017\u000byå\u0006OÁq\u0092öKø\u001b\u0013¬Â\u0084ívÜHcøx¾òæ¾\u0088\u0099\ff_@";
        Class352.lIlIIlllIll[3] = "ISO-8859-1";
        Class352.lIlIIlllIll[4] = "DES/CBC/PKCS5Padding";
        Class352.lIlIIlllIll[5] = "DES";
        Class352.lIlIIlllIll[6] = "大哥我随意践踏你的自尊和人格你还能用语言反击我么因为你早就被人揍的麻木了是不你只能撕破你第2层脸皮来求我绕了你我对你扣字的欲望你开始逃避我了你为什么要在我面前红红火火的NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u200b\u2004\u200f";
        Class352.lIlIIlllIll[7] = "ISO-8859-1";
        Class352.lIlIIlllIll[8] = "大哥我随意践踏你的自尊和人格你还能用语言反击我么因为你早就被人揍的麻木了是不你只能撕破你第2层脸皮来求我绕了你我对你扣字的欲望你开始逃避我了你为什么要在我面前红红火火的NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u200b\u2004\u200f";
        Class352.lIlIIlllIll[9] = " : ";
        Class352.lIlIIlllIll[10] = " : ";
    }
    
    private static String lllIlIIIllII(final String s, final String s2) {
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
    
    private static String lllIlIIIlIlI(String s, final String s2) {
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
    
    private static String lllIlIIIlIll(final String s, final String s2) {
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
    
    private static boolean lllIlIIlIIlI(final int n) {
        return n < 0;
    }
}
