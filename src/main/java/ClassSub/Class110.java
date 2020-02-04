package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class110
{
    private static int IMMEDIATE_RENDERER;
    private static int VERTEX_ARRAY_RENDERER;
    private static int DEFAULT_LINE_STRIP_RENDERER;
    private static int QUAD_BASED_LINE_STRIP_RENDERER;
    private static Class79 renderer;
    private static Class341 lineStripRenderer;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lllllIlII;
    
    public Class110() {
        super();
    }
    
    private static void setRenderer(final int n) {
        if (Class139.b() == null) {
            switch (n) {
                case 1: {
                    Class110.renderer = new Class7();
                    break;
                }
                case 2: {
                    Class110.renderer = new Class155();
                }
                default: {
                    throw new RuntimeException(String.valueOf(new StringBuilder("Unknown renderer type: ").append(n)));
                }
            }
        }
    }
    
    private static void setLineStripRenderer(final int n) {
        if (Class139.b() == null) {
            switch (n) {
                case 3: {
                    Class110.lineStripRenderer = new Class103();
                    break;
                }
                case 4: {
                    Class110.lineStripRenderer = new Class59();
                }
                default: {
                    throw new RuntimeException(String.valueOf(new StringBuilder("Unknown line strip renderer type: ").append(n)));
                }
            }
        }
    }
    
    private static void setLineStripRenderer(final Class341 lineStripRenderer) {
        Class110.lineStripRenderer = lineStripRenderer;
    }
    
    private static void setRenderer(final Class79 renderer) {
        Class110.renderer = renderer;
    }
    
    public static Class79 get() {
        return Class110.renderer;
    }
    
    public static Class341 getLineStripRenderer() {
        return Class110.lineStripRenderer;
    }
    
    static {
        lIllIlIIIIl();
        Class169.a(3287480319731503514L, 6078643609573384480L, MethodHandles.lookup().lookupClass()).a(133667036470795L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class110.lllllIlII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class110.lllllIlII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(108898995093516L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class110.lllllIlII[2]).length();
        int char1 = 56;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class110.lllllIlII[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
        Class110.renderer = new Class7();
        Class110.lineStripRenderer = new Class103();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x4295;
        if (Class110.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class110.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class110.lllllIlII[4]);
                    array[1] = SecretKeyFactory.getInstance(Class110.lllllIlII[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class110.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class110.lllllIlII[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class110.c[n3] = a(((Cipher)array[0]).doFinal(Class110.b[n3].getBytes(Class110.lllllIlII[7])));
        }
        return Class110.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class110.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIllIlIIIIl() {
        (lllllIlII = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class110.lllllIlII[1] = "DES";
        Class110.lllllIlII[2] = "âH'.}\u008f\u0018¨/|ÚXwêC.d\u0014¿\u0098\r\u0082Ç®ç\u000fX1D\u0005f\u0013»H\u0082ãò\u0089u\u0004Óz,³\u008e@ï\u0001áÍ\u0097+L²Ý,(S\u0012\n)9Ó.§L£%\u0098ÍN\u0000Ô0±\u0095*a÷â®£\u0093\b¹l\u000e7f\u008b¬s\f\u0015¾\u00895";
        Class110.lllllIlII[3] = "ISO-8859-1";
        Class110.lllllIlII[4] = "DES/CBC/PKCS5Padding";
        Class110.lllllIlII[5] = "DES";
        Class110.lllllIlII[6] = "跟你扣字简直是侮辱了我请把你第2层脸皮撕下来好吗跟你这么说简直就是在侮辱我的键盘你赶紧滚啊还大言不惭的吹嘘啊哇哈哈你怎么唯唯诺诺的了啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u200a\u200d ";
        Class110.lllllIlII[7] = "ISO-8859-1";
        Class110.lllllIlII[8] = "跟你扣字简直是侮辱了我请把你第2层脸皮撕下来好吗跟你这么说简直就是在侮辱我的键盘你赶紧滚啊还大言不惭的吹嘘啊哇哈哈你怎么唯唯诺诺的了啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u200a\u200d ";
        Class110.lllllIlII[9] = " : ";
        Class110.lllllIlII[10] = " : ";
    }
    
    private static String lIllIIlIlIl(String s, final String s2) {
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
    
    private static String lIllIIllIlI(final String s, final String s2) {
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
    
    private static String lIllIIlIllI(final String s, final String s2) {
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
}
