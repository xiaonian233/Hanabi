package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class166 extends Class257
{
    private static String PACKET_ID;
    public final String message;
    private static final long a;
    private static final String[] c;
    private static final String[] d;
    private static final Map e;
    private static final String[] lIIlIlIlIIl;
    
    private Class166(final String message) {
        final String value = String.valueOf(new StringBuilder("SERVERCHAT::").append(message));
        final int recieve$299aaa4 = Class309.RECIEVE$299aaa4;
        super(value);
        this.message = message;
    }
    
    public Class166(final String s, final byte b) {
        this(s.split("::")[1]);
    }
    
    static {
        llIlIlIlIllI();
        Class169.a(1990698310364450357L, 3438109933968600082L, MethodHandles.lookup().lookupClass()).a(266772618125754L);
        e = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class166.lIIlIlIlIIl[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class166.lIIlIlIlIIl[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(34814231689317L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = Class166.lIIlIlIlIIl[3]).length();
        int n4 = 32;
        int n5 = -1;
    Label_0151:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class166.lIIlIlIlIIl[5]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0151;
                            }
                            n3 = (s = Class166.lIIlIlIlIIl[4]).length();
                            n4 = 16;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0151;
                        }
                    }
                    ++n5;
                    final String s4 = s;
                    final int n8 = n5;
                    s3 = s4.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        c = c2;
        d = new String[4];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x23A2;
        if (Class166.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class166.e.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class166.lIIlIlIlIIl[6]);
                    array[1] = SecretKeyFactory.getInstance(Class166.lIIlIlIlIIl[7]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class166.e.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class166.lIIlIlIlIIl[8], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class166.d[n3] = a(((Cipher)array[0]).doFinal(Class166.c[n3].getBytes(Class166.lIIlIlIlIIl[9])));
        }
        return Class166.d[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class166.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llIlIlIlIllI() {
        (lIIlIlIlIIl = new String[13])[0] = "]";
        Class166.lIIlIlIlIIl[1] = "DES/CBC/PKCS5Padding";
        Class166.lIIlIlIlIIl[2] = "DES";
        Class166.lIIlIlIlIIl[3] = "õ\u0080\u008e\u00adDÕ.\u0095ÓZóI\u001e'\"éX\u008d©uºß\u000fÈ\nî\u0080Axi\\\u0094 º,\u009f\u009bX\u0087À\u008aÉØ«ÐL\\%8À\u000e\u0085X®ô\u000e\u0091\r¶\"µ>¨Ë¤";
        Class166.lIIlIlIlIIl[4] = "ý\u0013\u0003§\u0017)('x0\u008eïý\u008fä\u0094\u0018vÓÁéøJ\u0082ò°pÉ+s|Q\u0007M±Û£\u008dMxó";
        Class166.lIIlIlIlIIl[5] = "ISO-8859-1";
        Class166.lIIlIlIlIIl[6] = "DES/CBC/PKCS5Padding";
        Class166.lIIlIlIlIIl[7] = "DES";
        Class166.lIIlIlIlIIl[8] = "你可以回去多修炼几年再跟我抗衡小蜗牛我看你也就是一个蜗牛速度了你能面对我了吗攻击你登峰造极的爸爸我啊你看看你气急败坏的敲打键盘告诉我你倍受打击你为什么总是生活在黑暗中NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a \u200c ";
        Class166.lIIlIlIlIIl[9] = "ISO-8859-1";
        Class166.lIIlIlIlIIl[10] = "你可以回去多修炼几年再跟我抗衡小蜗牛我看你也就是一个蜗牛速度了你能面对我了吗攻击你登峰造极的爸爸我啊你看看你气急败坏的敲打键盘告诉我你倍受打击你为什么总是生活在黑暗中NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a \u200c ";
        Class166.lIIlIlIlIIl[11] = " : ";
        Class166.lIIlIlIlIIl[12] = " : ";
    }
    
    private static String llIlIlIlIIIl(final String s, final String s2) {
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
    
    private static String llIlIlIlIIll(String s, final String s2) {
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
    
    private static String llIlIlIlIlII(final String s, final String s2) {
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
