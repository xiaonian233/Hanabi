package ClassSub;

import java.net.*;
import javax.crypto.*;
import java.security.spec.*;
import java.io.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public class Class5
{
    private static ArrayList locations;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llllIlIIll;
    
    public Class5() {
        super();
    }
    
    private static void addResourceLocation(final Class247 class247) {
        Class5.locations.add(class247);
    }
    
    private static void removeResourceLocation(final Class247 class247) {
        Class5.locations.remove(class247);
    }
    
    private static void removeAllResourceLocations() {
        Class5.locations.clear();
    }
    
    public static InputStream getResourceAsStream(final String s) {
        final int[] b = Class139.b();
        InputStream resourceAsStream = null;
        final int[] array = b;
        int i = 0;
        InputStream inputStream = null;
        Label_0059: {
            while (i < Class5.locations.size()) {
                resourceAsStream = ((Class247)Class5.locations.get(i)).getResourceAsStream(s);
                if (array == null) {
                    inputStream = resourceAsStream;
                    if (array != null || (inputStream != null && array == null)) {
                        break Label_0059;
                    }
                    ++i;
                }
                if (array != null) {
                    goto Label_0058;
                }
            }
            goto Label_0058;
        }
        if (inputStream == null) {
            throw new RuntimeException(String.valueOf(new StringBuilder("Resource not found: ").append(s)));
        }
        return new BufferedInputStream(resourceAsStream);
    }
    
    private static boolean resourceExists(final String s) {
        final int[] b = Class139.b();
        int i = 0;
        final int[] array = b;
        while (i < Class5.locations.size()) {
            final URL resource = Class5.locations.get(i).getResource(s);
            if (array == null) {
                if (resource != null) {
                    return true;
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
        return false;
    }
    
    private static URL getResource(final String s) {
        final int[] b = Class139.b();
        URL resource = null;
        int i = 0;
        final int[] array = b;
        while (true) {
            while (i < Class5.locations.size()) {
                resource = ((Class247)Class5.locations.get(i)).getResource(s);
                if (array == null) {
                    URL url2;
                    final URL url = url2 = resource;
                    if (array != null) {
                        if (array == null) {
                            if (url == null) {
                                throw new RuntimeException(String.valueOf(new StringBuilder("Resource not found: ").append(s)));
                            }
                            url2 = resource;
                        }
                        return url2;
                    }
                    if (url != null && array == null) {
                        break;
                    }
                    ++i;
                }
                if (array != null) {
                    break;
                }
            }
            final URL url3;
            URL url2 = url3 = resource;
            continue;
        }
    }
    
    static {
        lIlIllllIIIl();
        Class169.a(4203534099612132492L, 1543941082352275172L, MethodHandles.lookup().lookupClass()).a(199738225338170L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class5.llllIlIIll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class5.llllIlIIll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(34782683857456L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class5.llllIlIIll[2]).length();
        int char1 = 40;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class5.llllIlIIll[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
        (Class5.locations = new ArrayList()).add(new Class82());
        Class5.locations.add(new Class36(new File(Class5.llllIlIIll[4])));
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5326;
        if (Class5.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class5.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class5.llllIlIIll[5]);
                    array[1] = SecretKeyFactory.getInstance(Class5.llllIlIIll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class5.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class5.llllIlIIll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class5.c[n3] = a(((Cipher)array[0]).doFinal(Class5.b[n3].getBytes(Class5.llllIlIIll[8])));
        }
        return Class5.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class5.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIlIllllIIIl() {
        (llllIlIIll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class5.llllIlIIll[1] = "DES";
        Class5.llllIlIIll[2] = "Â2L,zí«@NiÇP!bRá{\u000e\u0017u\u001dpS+4&Rü\u0097ÛÑ\u0004JQ¹kç¶\u0007ç(_\u0012,ÞßãÓ\u0091¼YÂG\u0088åÏ+a´\u0015Ëñ×ÉVðIZ:\u0090d\u00882`\u000eþ\u000f²\u0006uQ";
        Class5.llllIlIIll[3] = "ISO-8859-1";
        Class5.llllIlIIll[4] = ".";
        Class5.llllIlIIll[5] = "DES/CBC/PKCS5Padding";
        Class5.llllIlIIll[6] = "DES";
        Class5.llllIlIIll[7] = "自己是不是已经感觉无能为力了啊神话已经终结你不要怀疑爹地的能力对于你这样的虚张声势的东西我可以随便殴打落魄的离开这个舞台吧你那破烂程序能打出象样的华丽唠嗑吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2001\u200a\u200e\u2003";
        Class5.llllIlIIll[8] = "ISO-8859-1";
        Class5.llllIlIIll[9] = "自己是不是已经感觉无能为力了啊神话已经终结你不要怀疑爹地的能力对于你这样的虚张声势的东西我可以随便殴打落魄的离开这个舞台吧你那破烂程序能打出象样的华丽唠嗑吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2001\u200a\u200e\u2003";
        Class5.llllIlIIll[10] = " : ";
        Class5.llllIlIIll[11] = " : ";
    }
    
    private static String lIlIlllIIlll(final String s, final String s2) {
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
    
    private static String lIlIlllIIllI(final String s, final String s2) {
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
    
    private static String lIlIlllIllll(String s, final String s2) {
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
