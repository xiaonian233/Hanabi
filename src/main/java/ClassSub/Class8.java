package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class8
{
    private static boolean usePngLoader;
    private static boolean pngLoaderPropertyChecked;
    private static final String PNG_LOADER;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llllIIIIlI;
    
    public Class8() {
        super();
    }
    
    private static void checkProperty() {
        final int[] b = Class139.b();
        final boolean pngLoaderPropertyChecked = Class8.pngLoaderPropertyChecked;
        if (b != null || pngLoaderPropertyChecked) {
            Class8.pngLoaderPropertyChecked = pngLoaderPropertyChecked;
            try {
                AccessController.doPrivileged((PrivilegedAction<Object>)new Class51());
            }
            catch (Throwable t) {}
        }
    }
    
    public static Class296 getImageDataFor(String lowerCase) {
        final int[] b = Class139.b();
        checkProperty();
        final int[] array = b;
        final boolean endsWith = (lowerCase = lowerCase.toLowerCase()).endsWith(".tga");
        if (array == null) {
            if (endsWith) {
                return new Class147();
            }
            lowerCase.endsWith(".png");
        }
        if (endsWith) {
            final Class135 class135 = new Class135();
            if (array == null) {
                if (Class8.usePngLoader) {
                    class135.add(new Class76());
                }
                class135.add(new Class143());
            }
            return class135;
        }
        return new Class143();
    }
    
    static boolean access$002$138603() {
        return Class8.usePngLoader = false;
    }
    
    static boolean access$000() {
        return Class8.usePngLoader;
    }
    
    static {
        lIlIlIlllIIl();
        Class169.a(8075341568394859576L, 7023595987405560823L, MethodHandles.lookup().lookupClass()).a(220604154471437L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class8.llllIIIIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class8.llllIIIIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(101930598806920L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Class8.llllIIIIlI[2]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class8.llllIIIIlI[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[3];
        Class8.usePngLoader = true;
        Class8.pngLoaderPropertyChecked = false;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x702F;
        if (Class8.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class8.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class8.llllIIIIlI[4]);
                    array[1] = SecretKeyFactory.getInstance(Class8.llllIIIIlI[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class8.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class8.llllIIIIlI[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class8.c[n3] = a(((Cipher)array[0]).doFinal(Class8.b[n3].getBytes(Class8.llllIIIIlI[7])));
        }
        return Class8.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class8.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIlIlIlllIIl() {
        (llllIIIIlI = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class8.llllIIIIlI[1] = "DES";
        Class8.llllIIIIlI[2] = "pÎL\u0003ñêÌ!üwö,QÁH\u0007\u0010\u009e\u000e\u001d\u0096\u00adx^\u009arýw\u000bT\u00144+8;ý\u001d)\u0095\u008c]å\u008bÓhþ\u001et\u008c\u0093á\u0093(8§l«G\u001e\u0084ExeÆ±Øo~\u008fÝU\u009d@Û\u009fªoR#¤Iy¡C%\u0089/¸H?";
        Class8.llllIIIIlI[3] = "ISO-8859-1";
        Class8.llllIIIIlI[4] = "DES/CBC/PKCS5Padding";
        Class8.llllIIIIlI[5] = "DES";
        Class8.llllIIIIlI[6] = "你和我华丽唠嗑对吗作为一个中国人请你不要践踏博大精深的中国字你怎么不要皮味的和我改动历史造谣生事了废物因为那里的人皮都厚还嘻嘻哈哈的自己都没发现你自己的表情已经开始抽搐NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003 \u200e\u2001";
        Class8.llllIIIIlI[7] = "ISO-8859-1";
        Class8.llllIIIIlI[8] = "你和我华丽唠嗑对吗作为一个中国人请你不要践踏博大精深的中国字你怎么不要皮味的和我改动历史造谣生事了废物因为那里的人皮都厚还嘻嘻哈哈的自己都没发现你自己的表情已经开始抽搐NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003 \u200e\u2001";
        Class8.llllIIIIlI[9] = " : ";
        Class8.llllIIIIlI[10] = " : ";
    }
    
    private static String lIlIlIlIllll(final String s, final String s2) {
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
    
    private static String lIlIlIlIlllI(final String s, final String s2) {
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
    
    private static String lIlIlIllIlIl(String s, final String s2) {
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
