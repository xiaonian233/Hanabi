package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class229 extends Class297
{
    private static final long b;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIIlIIIIl;
    
    public Class229() {
        super();
    }
    
    @Override
    public final boolean isLoginSuccessfully(final String s, final String s2) {
        return Class138.doGet(String.valueOf(new StringBuilder("http://hanabi.alphaantileak.cn:893/azureware/FUCKYOU/IRCLoginFUCKYOU.php?user=").append(s).append("&pass=").append(s2))).contains("true");
    }
    
    @Override
    public final String getPrefix(final String s) {
        return Class138.doGet(String.valueOf(new StringBuilder("http://hanabi.alphaantileak.cn:893/azureware/FUCKYOU/getprefix.php?user=").append(s)));
    }
    
    static {
        llIIlIIlIl();
        Class169.a(-6677027406946764189L, 3415394395774297011L, MethodHandles.lookup().lookupClass()).a(5731361175609L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class229.lIIlIIIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class229.lIIlIIIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(137469717793267L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class229.lIIlIIIIl[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(Class229.lIIlIIIIl[4]))).intern();
                    switch (n7) {
                        default: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class229.lIIlIIIIl[3]).length();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7C97;
        if (Class229.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class229.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class229.lIIlIIIIl[5]);
                    array[1] = SecretKeyFactory.getInstance(Class229.lIIlIIIIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class229.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class229.lIIlIIIIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class229.e[n3] = b(((Cipher)array[0]).doFinal(Class229.d[n3].getBytes(Class229.lIIlIIIIl[8])));
        }
        return Class229.e[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class229.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llIIlIIlIl() {
        (lIIlIIIIl = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class229.lIIlIIIIl[1] = "DES";
        Class229.lIIlIIIIl[2] = "b\t¢\u008eE¾\u0084\u0098\u0096\u000b~5N\u0095\u0010$\u0080Ö\u0003ô\u008d\u0007\f¨j kY\u0098N\u0013\u0001ô§\tí\u0015\u0083Ù'\u0088\\\u0088,9e\u0095\u0096±\u0087ð\u001cºg¾ð¨\u0016!7¾g\u001eè·\u008eÖ+ÁBÍ]\u0006¡aIÞÛ\u009a>àÌÇ¸\u0001c\u0000sxnÄ[X7Cm\u001e\u0017V² _ënå\u0000\u0014\u0003epVæ\u0015!\u0017`·ÖÐ¯±Ól¾;\u0090i\u001a\u009ci¢\u0087²¡k\u0086õS'aÐõÛ\u0080¹xb\u000b\u0080xZÎA§!ÝOeG;\u0006Ö\fcy\u00048\u0010Á7¥\u008dèá\u009aØÞ½\u0001^ð\u0003\u0096Ø t\u0091-\näV\u0086P?KO=Î3ÂJêÜE\u0014½\u0013\u0092\u0084/-\u0012(\u000eÚ\u0084Ë¿¾TÌçMÛií²¸ã\r±*@·R\u008c&v·ú0\u0011\u008fz]\u0090eõÚ}P<\u0096A¿\u0095e\u008c\u009aË\u0085w\u0007\\1u";
        Class229.lIIlIIIIl[3] = "$X[|!d<õk=«js\u0094\u0000¤ ã\u001cªh\ng/\u009avoø\u001f\u007fÜ2Ü\u0082£àÂ¦ú\u009e®zgØSüW\u009fÌ";
        Class229.lIIlIIIIl[4] = "ISO-8859-1";
        Class229.lIIlIIIIl[5] = "DES/CBC/PKCS5Padding";
        Class229.lIIlIIIIl[6] = "DES";
        Class229.lIIlIIIIl[7] = "还真是个井底之蛙你只能撕破你第2层脸皮来求我绕了你你可以否认你没有文化的事实那么请你拿出实力说实话我不太喜欢和游击队员还有滚刀选手对话而兴奋就必定导致你最后会跪倒在我面前知道吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e \u200f\u200b";
        Class229.lIIlIIIIl[8] = "ISO-8859-1";
        Class229.lIIlIIIIl[9] = "还真是个井底之蛙你只能撕破你第2层脸皮来求我绕了你你可以否认你没有文化的事实那么请你拿出实力说实话我不太喜欢和游击队员还有滚刀选手对话而兴奋就必定导致你最后会跪倒在我面前知道吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e \u200f\u200b";
        Class229.lIIlIIIIl[10] = " : ";
        Class229.lIIlIIIIl[11] = " : ";
    }
    
    private static String llIIIlllll(final String s, final String s2) {
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
    
    private static String llIIIllllI(String s, final String s2) {
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
    
    private static String llIIlIIlII(final String s, final String s2) {
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
