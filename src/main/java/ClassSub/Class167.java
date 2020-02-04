package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class167 extends Class297
{
    private static final long b;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIllllIlIIl;
    
    public Class167() {
        super();
    }
    
    @Override
    public final boolean isLoginSuccessfully(final String s, final String s2) {
        return Class138.doGet(String.valueOf(new StringBuilder("http://hanabi.alphaantileak.cn:893/hanabi/FUCKYOU/IRCLoginFUCKYOU.php?user=").append(s).append("&pass=").append(s2))).contains("true");
    }
    
    @Override
    public final String getPrefix(final String s) {
        return Class138.doGet(String.valueOf(new StringBuilder("http://hanabi.alphaantileak.cn:893/hanabi/FUCKYOU/getprefix.php?user=").append(s)));
    }
    
    static {
        lIIIIIlIIIIlI();
        Class169.a(-2793828859909679401L, 280816834355072694L, MethodHandles.lookup().lookupClass()).a(264352031446794L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class167.lIllllIlIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class167.lIllllIlIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(74511482332147L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class167.lIllllIlIIl[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(Class167.lIllllIlIIl[4]))).intern();
                    switch (n7) {
                        default: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class167.lIllllIlIIl[3]).length();
                            n4 = 128;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            d2[n2++] = intern;
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
        d = d2;
        e = new String[5];
    }
    
    private static String b(final byte[] array) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1646;
        if (Class167.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class167.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class167.lIllllIlIIl[5]);
                    array[1] = SecretKeyFactory.getInstance(Class167.lIllllIlIIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class167.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class167.lIllllIlIIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class167.e[n3] = b(((Cipher)array[0]).doFinal(Class167.d[n3].getBytes(Class167.lIllllIlIIl[8])));
        }
        return Class167.e[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class167.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIIIlIIIIlI() {
        (lIllllIlIIl = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class167.lIllllIlIIl[1] = "DES";
        Class167.lIllllIlIIl[2] = "\u0091\rÃÅ\u00adOuª\u0011®c`û\u0095·1\u0010\u000fÕc¿B>I\u0001¦?\u00ad¯Èv<\u008f\u0010ÕÄ½\u0000Ñ2`£m¤I\u0090öé\u0094C";
        Class167.lIllllIlIIl[3] = "\böH\u0085ÛdÙ\u000eëýÀÒÈ×8\f¡¥\u0090\u0019r\u0089\f\u0083\u0005Ézå\u0088>u\u0013¬ã\u007f á*À:Õ>³´Ë\u0015\u0013à\u008b\u00adr=ç±É³ÒDTõ!÷\bn-ÁÖ ¬>sjR\u00135ñMÇE\u000e\u008f\u0010Ä¹`ø:\nÖ|\u009eºD\u000eã`iÝ%\u0082Ø\u0018\u001a\u0085Éø§\u0015þy÷¦u\u0003iqþÇ\u000e¤\u0099\u0096µ¸\u001fò§\u001dh÷\róÌ÷Â¼|\u0085ýÛ/t;\u0087ý3ÝÀÁ@ÿÍÿ9L\u009bLÙà\u0016ïþ\u0019%b=µÈH\u0014\u008fZ^È\u0080>s\u0092GN5\u008e££\f\u0083¬\u0004\u008cn\u008eO4P\u0083\u0093Pß\u0014\fm×\u0013N7OÓýª@\u009cérË\u0013rð(uÏ\u009b<\u009e\u008f\u0096A¨ºécQéI";
        Class167.lIllllIlIIl[4] = "ISO-8859-1";
        Class167.lIllllIlIIl[5] = "DES/CBC/PKCS5Padding";
        Class167.lIllllIlIIl[6] = "DES";
        Class167.lIllllIlIIl[7] = "看看你现在的样子面目狰狞想忤逆你亲爹是吗现在你有没有恼羞成怒告诉我可以吗你这个废物你现在是不是内心在哭泣你就在这里自我娱乐吧我对你这样的废人不需要什么华华丽丽的辞藻可是你的语言是千篇一律的你知道吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u2004\u2003\u2005";
        Class167.lIllllIlIIl[8] = "ISO-8859-1";
        Class167.lIllllIlIIl[9] = "看看你现在的样子面目狰狞想忤逆你亲爹是吗现在你有没有恼羞成怒告诉我可以吗你这个废物你现在是不是内心在哭泣你就在这里自我娱乐吧我对你这样的废人不需要什么华华丽丽的辞藻可是你的语言是千篇一律的你知道吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u2004\u2003\u2005";
        Class167.lIllllIlIIl[10] = " : ";
        Class167.lIllllIlIIl[11] = " : ";
    }
    
    private static String lIIIIIIlllIII(final String s, final String s2) {
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
    
    private static String lIIIIIIlllIIl(final String s, final String s2) {
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
    
    private static String lIIIIIIllllIl(String s, final String s2) {
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
