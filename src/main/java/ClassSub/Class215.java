package ClassSub;

import java.net.*;
import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class215
{
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lllllIlIl;
    
    public Class215() {
        super();
    }
    
    private static String getSocketMessage(final Socket socket) {
        try {
            return new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK")).readLine();
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String getInputStreamMessage(final InputStream inputStream) {
        try {
            return new BufferedReader(new InputStreamReader(inputStream, "GBK")).readLine();
        }
        catch (Exception ex) {
            Class14.LOGGER.log(ex.getMessage());
            return null;
        }
    }
    
    static {
        lIllIlIIIlI();
        Class169.a(8074880449301957443L, 228120708925522298L, MethodHandles.lookup().lookupClass()).a(275821283238169L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class215.lllllIlIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class215.lllllIlIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(100066197549524L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class215.lllllIlIl[2]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class215.lllllIlIl[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7FDC;
        if (Class215.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class215.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class215.lllllIlIl[4]);
                    array[1] = SecretKeyFactory.getInstance(Class215.lllllIlIl[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class215.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class215.lllllIlIl[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class215.c[n3] = a(((Cipher)array[0]).doFinal(Class215.b[n3].getBytes(Class215.lllllIlIl[7])));
        }
        return Class215.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class215.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIllIlIIIlI() {
        (lllllIlIl = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class215.lllllIlIl[1] = "DES";
        Class215.lllllIlIl[2] = "\u0016\týu\u0086\u001eîEK_\u009dÀ¥¨!\u0007\u0010)\u0090TI:m\u0099¥Þµ\u009eMwÕ\u009eû";
        Class215.lllllIlIl[3] = "ISO-8859-1";
        Class215.lllllIlIl[4] = "DES/CBC/PKCS5Padding";
        Class215.lllllIlIl[5] = "DES";
        Class215.lllllIlIl[6] = "因为你早就被人揍的麻木了是不可是你的语言是千篇一律的你知道吗你一五一十的告诉你爸爸我啊是要证明你的文才是不是呢麻烦你看看你这样的窝囊废除了自吹自捧剩下了还有恬不知耻是不是NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2004\u2008\u2006\u2008";
        Class215.lllllIlIl[7] = "ISO-8859-1";
        Class215.lllllIlIl[8] = "因为你早就被人揍的麻木了是不可是你的语言是千篇一律的你知道吗你一五一十的告诉你爸爸我啊是要证明你的文才是不是呢麻烦你看看你这样的窝囊废除了自吹自捧剩下了还有恬不知耻是不是NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2004\u2008\u2006\u2008";
        Class215.lllllIlIl[9] = " : ";
        Class215.lllllIlIl[10] = " : ";
    }
    
    private static String lIllIIlllII(final String s, final String s2) {
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
    
    private static String lIllIIllIll(String s, final String s2) {
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
    
    private static String lIllIIllIIl(final String s, final String s2) {
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
