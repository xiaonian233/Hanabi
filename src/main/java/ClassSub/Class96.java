package ClassSub;

import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import net.minecraft.client.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Class96
{
    private static ArrayList<Class349> Files;
    private static File directory;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIIIlIIlll;
    
    public Class96() {
        final long n = Class96.a ^ 0x682CBBBD672EL;
        super();
        final long n2 = Class96.a ^ 0x591BA5D059C6L;
        final int[] array = invokedynamic(U:(JJ)[I, -6982491457521902809L, n2);
        final File directory = Class96.directory;
        try {
            Label_0116: {
                PrintStream out = null;
                int n3 = 0;
                long n4 = 0L;
                Label_0077: {
                    boolean b2 = false;
                    Label_0058: {
                        boolean b;
                        try {
                            b = (b2 = directory.exists());
                            if (array != null) {
                                break Label_0077;
                            }
                            if (!b) {
                                break Label_0058;
                            }
                            break Label_0116;
                        }
                        catch (Exception ex) {
                            throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex, -6974950131455051330L, n2);
                        }
                        try {
                            if (b) {
                                break Label_0116;
                            }
                            b2 = Class96.directory.mkdir();
                        }
                        catch (Exception ex2) {
                            throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex2, -6974950131455051330L, n2);
                        }
                    }
                    try {
                        if (!b2) {
                            break Label_0116;
                        }
                        out = System.out;
                        n3 = 4206;
                        n4 = (0x7528044848D4D6F5L ^ n2);
                        final String s = invokedynamic(z:(IJ)Ljava/lang/String;, n3, n4);
                        out.println(s);
                        final int[] array2 = array;
                        if (array2 != null) {
                            break Label_0116;
                        }
                        break Label_0116;
                    }
                    catch (Exception ex3) {
                        throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex3, -6974950131455051330L, n2);
                    }
                }
                try {
                    final String s = invokedynamic(z:(IJ)Ljava/lang/String;, n3, n4);
                    out.println(s);
                    final int[] array2 = array;
                    if (array2 != null) {
                        System.out.println(invokedynamic(z:(IJ)Ljava/lang/String;, 23149, 0x185FE6122D809CF7L ^ n2));
                    }
                }
                catch (Exception ex4) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex4, -6974950131455051330L, n2);
                }
            }
        }
        catch (Exception ex5) {
            throw new RuntimeException();
        }
        Class96.Files.add(new Class316(invokedynamic(z:(IJ)Ljava/lang/String;, 26803, 0x4479947D45F690C2L ^ n)));
    }
    
    public static void loadFiles() {
        final int[] array = invokedynamic(U:(JJ)[I, 4596274156087065591L, Class96.a ^ 0x52E62D05F916L);
        final Iterator<Class349> iterator = Class96.Files.iterator();
        final int[] array2 = array;
        while (iterator.hasNext()) {
            Class349 class350;
            final Class349 class349 = class350 = iterator.next();
            final int[] array3 = array2;
            try {
                if (array3 == null) {
                    if (!Class349.access$000(class349) && array2 == null) {
                        continue;
                    }
                    class350 = class349;
                }
                class350.loadFile();
                continue;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                if (array2 == null) {
                    continue;
                }
            }
            break;
        }
    }
    
    public static void saveFiles() {
        final int[] array = invokedynamic(U:(JJ)[I, 1230992816322680107L, Class96.a ^ 0x3169C71DD7CAL);
        final Iterator<Class349> iterator = Class96.Files.iterator();
        final int[] array2 = array;
        while (iterator.hasNext()) {
            final Class349 class349 = iterator.next();
            try {
                class349.saveFile();
                continue;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                if (array2 == null) {
                    continue;
                }
            }
            break;
        }
    }
    
    public static Class349 getFile(final Class<? extends Class349> p0) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ldc2_w          36533144396571
        //     6: lxor           
        //     7: lstore_1       
        //     8: ldc2_w          -1890301134896274950
        //    11: lload_1        
        //    12: invokedynamic   BootstrapMethod #1, U:(JJ)[I
        //    17: getstatic       ClassSub/Class96.Files:Ljava/util/ArrayList;
        //    20: invokevirtual   java/util/ArrayList.iterator:()Ljava/util/Iterator;
        //    23: astore          4
        //    25: astore_3       
        //    26: aload           4
        //    28: invokeinterface java/util/Iterator.hasNext:()Z
        //    33: ifeq            94
        //    36: aload           4
        //    38: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    43: checkcast       LClassSub/Class349;
        //    46: dup            
        //    47: astore          5
        //    49: aload_3        
        //    50: ifnonnull       93
        //    53: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //    56: aload_0        
        //    57: if_acmpeq       64
        //    60: iconst_1       
        //    61: goto            65
        //    64: iconst_0       
        //    65: ifeq            91
        //    68: goto            26
        //    71: ldc2_w          -1878414534599326877
        //    74: lload_1        
        //    75: invokedynamic   BootstrapMethod #1, U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;
        //    80: athrow         
        //    81: ldc2_w          -1878414534599326877
        //    84: lload_1        
        //    85: invokedynamic   BootstrapMethod #1, U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;
        //    90: athrow         
        //    91: aload           5
        //    93: areturn        
        //    94: aconst_null    
        //    95: areturn        
        //    Signature:
        //  (Ljava/lang/Class<+LClassSub/Class349;>;)LClassSub/Class349;
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  50     68     71     81     Ljava/lang/RuntimeException;
        //  53     81     81     91     Ljava/lang/RuntimeException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0064:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void makeDirectories() {
        final long n = Class96.a ^ 0x591BA5D059C6L;
        final int[] array = invokedynamic(U:(JJ)[I, -6982491457521902809L, n);
        final File directory = Class96.directory;
        try {
            Label_0101: {
                PrintStream out = null;
                int n2 = 0;
                long n3 = 0L;
                Label_0063: {
                    boolean b2 = false;
                    Label_0044: {
                        boolean b;
                        try {
                            b = (b2 = directory.exists());
                            if (array != null) {
                                break Label_0063;
                            }
                            if (!b) {
                                break Label_0044;
                            }
                            return;
                        }
                        catch (Exception ex) {
                            throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex, -6974950131455051330L, n);
                        }
                        try {
                            if (b) {
                                return;
                            }
                            b2 = Class96.directory.mkdir();
                        }
                        catch (Exception ex2) {
                            throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex2, -6974950131455051330L, n);
                        }
                    }
                    try {
                        if (!b2) {
                            break Label_0101;
                        }
                        out = System.out;
                        n2 = 4206;
                        n3 = (0x7528044848D4D6F5L ^ n);
                        final String s = invokedynamic(z:(IJ)Ljava/lang/String;, n2, n3);
                        out.println(s);
                        final int[] array2 = array;
                        if (array2 != null) {
                            break Label_0101;
                        }
                        return;
                    }
                    catch (Exception ex3) {
                        throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex3, -6974950131455051330L, n);
                    }
                }
                try {
                    final String s = invokedynamic(z:(IJ)Ljava/lang/String;, n2, n3);
                    out.println(s);
                    final int[] array2 = array;
                    if (array2 != null) {
                        System.out.println(invokedynamic(z:(IJ)Ljava/lang/String;, 23149, 0x185FE6122D809CF7L ^ n));
                    }
                }
                catch (Exception ex4) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex4, -6974950131455051330L, n);
                }
            }
        }
        catch (Exception ex5) {
            throw new RuntimeException();
        }
    }
    
    static File access$100() {
        return Class96.directory;
    }
    
    static {
        lIIIlIIIIIlll();
        final long n = (a = Class169.a(4828449334874438972L, 3670298872891617228L, MethodHandles.lookup().lookupClass()).a(189335999710966L)) ^ 0x4813FDD9FD4EL;
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class96.llIIIlIIlll[0]);
        final int n2 = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class96.llIIIlIIlll[1]);
        final byte[] array = new byte[8];
        array[0] = (byte)(n >>> 56);
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(n << i * 8 >>> 56);
        }
        instance.init(n2, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[4];
        int n3 = 0;
        String s;
        int n4 = (s = Class96.llIIIlIIlll[2]).length();
        int n5 = 16;
        int n6 = -1;
    Label_0164:
        while (true) {
            while (true) {
                ++n6;
                final String s2 = s;
                final int n7 = n6;
                String s3 = s2.substring(n7, n7 + n5);
                int n8 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class96.llIIIlIIlll[4]))).intern();
                    switch (n8) {
                        default: {
                            b2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                continue Label_0164;
                            }
                            n4 = (s = Class96.llIIIlIIlll[3]).length();
                            n5 = 56;
                            n6 = -1;
                            break;
                        }
                        case 0: {
                            b2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                break;
                            }
                            break Label_0164;
                        }
                    }
                    ++n6;
                    final String s4 = s;
                    final int n9 = n6;
                    s3 = s4.substring(n9, n9 + n5);
                    n8 = 0;
                }
            }
            break;
        }
        b = b2;
        c = new String[4];
        Class96.Files = new ArrayList<Class349>();
        Class96.directory = new File(String.valueOf(new StringBuilder().append(String.valueOf(Minecraft.func_71410_x().field_71412_D.toString())).append(Class96.llIIIlIIlll[5]).append(invokedynamic(z:(IJ)Ljava/lang/String;, 7373, 0x28096661FAB1FEDDL ^ n))));
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x59E9;
        if (Class96.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class96.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class96.llIIIlIIlll[6]);
                    array[1] = SecretKeyFactory.getInstance(Class96.llIIIlIIlll[7]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class96.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class96.llIIIlIIlll[8], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class96.c[n3] = a(((Cipher)array[0]).doFinal(Class96.b[n3].getBytes(Class96.llIIIlIIlll[9])));
        }
        return Class96.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class96.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIlIIIIIlll() {
        (llIIIlIIlll = new String[13])[0] = "DES/CBC/PKCS5Padding";
        Class96.llIIIlIIlll[1] = "DES";
        Class96.llIIIlIIlll[2] = "\u0012NÔa3Î\u001d¡pjCS+\u0080ÎJ\u0010R)E\u008f[\u008bW\u0083\u0087{ÂÎ\u0084F\u001aL";
        Class96.llIIIlIIlll[3] = "N\b<W\u0002!é-¶É\u00864?h¸CÀL5\u0017\u0094G\u0013\u001c\u0012ØÀJy+ôP\u0091BW¥¸uqÖs\u0083Ý*õ\u00060ÉÂu6úï\u000e\u0087\u0090(\u0014Lõ®ÍvÜâ\u0000\u008fuB\u0013\\0ìæ\f¦Eù\u009axÙâ\u00177T\u0016\u008cF}\u0087s\u0085aÀÉýþ";
        Class96.llIIIlIIlll[4] = "ISO-8859-1";
        Class96.llIIIlIIlll[5] = "\\";
        Class96.llIIIlIIlll[6] = "DES/CBC/PKCS5Padding";
        Class96.llIIIlIIlll[7] = "DES";
        Class96.llIIIlIIlll[8] = "你真的无药可救了你知道吗你是不是想用你婆婆妈妈的词汇击败你老老实实的爹爹我啊我这就是在打击你你嫉妒我速度牛逼了呀呵呵拿着三年前的词汇胡拼乱凑天下无敌了是吗如果你回答我是NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u200c\u2001\u2001";
        Class96.llIIIlIIlll[9] = "ISO-8859-1";
        Class96.llIIIlIIlll[10] = "你真的无药可救了你知道吗你是不是想用你婆婆妈妈的词汇击败你老老实实的爹爹我啊我这就是在打击你你嫉妒我速度牛逼了呀呵呵拿着三年前的词汇胡拼乱凑天下无敌了是吗如果你回答我是NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u200c\u2001\u2001";
        Class96.llIIIlIIlll[11] = " : ";
        Class96.llIIIlIIlll[12] = " : ";
    }
    
    private static String lIIIIllllIlIl(String s, final String s2) {
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
    
    private static String lIIIIllllIllI(final String s, final String s2) {
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
    
    private static String lIIIIllllIlll(final String s, final String s2) {
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
    
    private static boolean lIIIlIIIlIlIl(final Object o, final Object o2) {
        return o != o2;
    }
}
