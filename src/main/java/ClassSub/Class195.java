package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class195 extends Class257
{
    private static String PACKET_ID;
    private String targetClient;
    private static final long a;
    private static final String[] c;
    private static final String[] d;
    private static final Map e;
    private static final String[] lIlllIllIII;
    
    public Class195(final String s) {
        final int[] b = Class139.b();
        final String value = String.valueOf(new StringBuilder("WHOIS::").append(s.startsWith("WHOIS::") ? s.split("::")[1] : s));
        final int send$299aaa4 = Class309.SEND$299aaa4;
        super(value);
        String s2 = s;
        final String s3 = "WHOIS::";
        if (b == null) {
            if (!s.startsWith(s3)) {
                return;
            }
            s2 = s;
        }
        s2.split(s3);
    }
    
    static {
        lIIIIIIlIllll();
        Class169.a(-4325670232228419610L, 8420890689496157315L, MethodHandles.lookup().lookupClass()).a(206442576719062L);
        e = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class195.lIlllIllIII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class195.lIlllIllIII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(51541008360741L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class195.lIlllIllIII[2]).length();
        int n4 = 16;
        int n5 = -1;
    Label_0150:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class195.lIlllIllIII[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class195.lIlllIllIII[3]).length();
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
                            break Label_0150;
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
        d = new String[5];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x39D1;
        if (Class195.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class195.e.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class195.lIlllIllIII[5]);
                    array[1] = SecretKeyFactory.getInstance(Class195.lIlllIllIII[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class195.e.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class195.lIlllIllIII[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class195.d[n3] = a(((Cipher)array[0]).doFinal(Class195.c[n3].getBytes(Class195.lIlllIllIII[8])));
        }
        return Class195.d[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class195.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIIIIlIllll() {
        (lIlllIllIII = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class195.lIlllIllIII[1] = "DES";
        Class195.lIlllIllIII[2] = "\b½:¯+\u0011êÙáã\u0085&;çvö\u0010\u008e\u0098\u008a°«\u008eôÕÞH´\u0017G\u001e\u009aÛ\u0010°;\u0083wÂ\u008dþÒ\fi|Ì§\u0014\u0088§";
        Class195.lIlllIllIII[3] = "çÍD\u0097\u008eîÁ\u000e\u008cþ\u0081aÆE\u0001\u0010\u0010\u007f/[ç'\"ð±Z\u001cìdV®¯n";
        Class195.lIlllIllIII[4] = "ISO-8859-1";
        Class195.lIlllIllIII[5] = "DES/CBC/PKCS5Padding";
        Class195.lIlllIllIII[6] = "DES";
        Class195.lIlllIllIII[7] = "你不觉得太没杀伤力了吗我知道无论用多么华丽的你还在为你仅存的一点点尊严奋死反抗自不量力你这样的残疾人早已被我殴打的身心俱伤还在这里不知死活的抗争着你还给我反驳啥了呢蜗牛NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200d\u2008\u200b ";
        Class195.lIlllIllIII[8] = "ISO-8859-1";
        Class195.lIlllIllIII[9] = "你不觉得太没杀伤力了吗我知道无论用多么华丽的你还在为你仅存的一点点尊严奋死反抗自不量力你这样的残疾人早已被我殴打的身心俱伤还在这里不知死活的抗争着你还给我反驳啥了呢蜗牛NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200d\u2008\u200b ";
        Class195.lIlllIllIII[10] = " : ";
        Class195.lIlllIllIII[11] = " : ";
    }
    
    private static String lIIIIIIlIlllI(String s, final String s2) {
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
    
    private static String lIIIIIIlIllIl(final String s, final String s2) {
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
    
    private static String lIIIIIIlIllII(final String s, final String s2) {
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
