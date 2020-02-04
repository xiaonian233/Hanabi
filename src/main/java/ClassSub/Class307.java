package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Class307 extends Class297
{
    private static final long b;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIlIIIIlIl;
    
    public Class307() {
        super();
    }
    
    @Override
    public final boolean isLoginSuccessfully(final String s, final String s2) {
        return Class138.doGet(String.valueOf(new StringBuilder("http://hanabi.alphaantileak.cn:893/debug/StaffMenu/IRCLoginFUCKYOU.php?user=").append(s).append("&pass=").append(s2))).contains("true");
    }
    
    @Override
    public final String getPrefix(final String s) {
        return Class138.doGet(String.valueOf(new StringBuilder("http://hanabi.alphaantileak.cn:893/debug/StaffMenu/getprefix.php?user=").append(s)));
    }
    
    static {
        lIIlIIIIIIIl();
        Class169.a(-8058217180880642043L, 166630412778025400L, MethodHandles.lookup().lookupClass()).a(194262917398664L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class307.lIlIIIIlIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class307.lIlIIIIlIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(32337478412239L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class307.lIlIIIIlIl[2]).length();
        int n4 = 112;
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
                    final String intern = b(instance.doFinal(s3.getBytes(Class307.lIlIIIIlIl[4]))).intern();
                    switch (n7) {
                        default: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class307.lIlIIIIlIl[3]).length();
                            n4 = 16;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x72B8;
        if (Class307.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class307.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class307.lIlIIIIlIl[5]);
                    array[1] = SecretKeyFactory.getInstance(Class307.lIlIIIIlIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class307.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class307.lIlIIIIlIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class307.e[n3] = b(((Cipher)array[0]).doFinal(Class307.d[n3].getBytes(Class307.lIlIIIIlIl[8])));
        }
        return Class307.e[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class307.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIlIIIIIIIl() {
        (lIlIIIIlIl = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class307.lIlIIIIlIl[1] = "DES";
        Class307.lIlIIIIlIl[2] = "\u0001\u0003\u0083_\n±z\u0083\núý\u0000Ø:Îßü¾§TàóBÂH«w,p\u008cc\u000fÛaS÷\u009b\u0001\u001dt\f½\u0014\u0005\u0081àe\u0080\u0089\u009f«¡û\u0006ÙýÛÉÁ\u0018ò£µü¿»ßÅ½`Ïs½^``(â}\u009c,K\u0089¨\u0016}ù\u0011Á I}\u0004vóCHô\"Û\u009b-|aj.Ê)à\u0003^±\u0010\u009f¸\u009c\u008e\u00adë5ââ\u0093\u0005¦\u0007Êãä\u0080Ù{`pëûgrAØ\u0096\u009c2üd\u001b\bÓ#\u008f\u0000\u0018õm¦°\u0084\u0012Ã¼'â2Òü:b\u008e.\rWt\u0017À$«Uã2c=Î\u0000nÓHâ.ôé\u0011Ü¶Òrª\núÇ4}¦peÖè¿\u0096U²ÐÆT½D·`}j`gÝr@\u001bqµÝ \u0003£æ\u0002$ð\nq7\u0011\u0085\u0007q³)Í«C\u0086Ò\u0099Ú¦\u0000\u0088ràÈ+";
        Class307.lIlIIIIlIl[3] = "]1cîòª\u0006ãôæã\u0083\u0087$ÐN\u0010\u0091ò:\u0084.\u0094S\u0019\u009eµ&\u0011ÂL«\u0087";
        Class307.lIlIIIIlIl[4] = "ISO-8859-1";
        Class307.lIlIIIIlIl[5] = "DES/CBC/PKCS5Padding";
        Class307.lIlIIIIlIl[6] = "DES";
        Class307.lIlIIIIlIl[7] = "你神爹我都不想和你说话了我平平常常的打字速度就能把你攻击的一塌糊涂那请你先想想后果对于我的攻击你无法抵挡你挺起腰杆好好努力不要灰心再过两年挑战爹爹我不想为你么这样无聊之辈浪费我的文采NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u2002\u2003\u2008";
        Class307.lIlIIIIlIl[8] = "ISO-8859-1";
        Class307.lIlIIIIlIl[9] = "你神爹我都不想和你说话了我平平常常的打字速度就能把你攻击的一塌糊涂那请你先想想后果对于我的攻击你无法抵挡你挺起腰杆好好努力不要灰心再过两年挑战爹爹我不想为你么这样无聊之辈浪费我的文采NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u2002\u2003\u2008";
        Class307.lIlIIIIlIl[10] = " : ";
        Class307.lIlIIIIlIl[11] = " : ";
    }
    
    private static String lllIlIlllIl(String s, final String s2) {
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
    
    private static String lllIlIllllI(final String s, final String s2) {
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
    
    private static String lllIllIIIII(final String s, final String s2) {
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
}
