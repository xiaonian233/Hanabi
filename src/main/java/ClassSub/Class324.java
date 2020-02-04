package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class324 extends Class257
{
    private static String PACKET_ID;
    private String inGamename;
    private boolean isClientFriend;
    private static final long a;
    private static final String[] c;
    private static final String[] d;
    private static final Map e;
    private static final String[] llIllIlIlll;
    
    public Class324(final String s, final String s2) {
        final String value = String.valueOf(new StringBuilder("INGAMENAME::").append(s).append("::").append(s2));
        final int send$299aaa4 = Class309.SEND$299aaa4;
        super(value);
        s2.equals("true");
    }
    
    private Class324(final String s) {
        this(s.split("::")[1], s.split("::")[2]);
    }
    
    static {
        lIIlIllllIIlI();
        Class169.a(-1051652812490987672L, 2109100918742341250L, MethodHandles.lookup().lookupClass()).a(4903596299234L);
        e = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class324.llIllIlIlll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class324.llIllIlIlll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(116423542322951L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class324.llIllIlIlll[2]).length();
        int n4 = 24;
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class324.llIllIlIlll[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class324.llIllIlIlll[3]).length();
                            n4 = 24;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7625;
        if (Class324.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class324.e.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class324.llIllIlIlll[5]);
                    array[1] = SecretKeyFactory.getInstance(Class324.llIllIlIlll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class324.e.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class324.llIllIlIlll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class324.d[n3] = a(((Cipher)array[0]).doFinal(Class324.c[n3].getBytes(Class324.llIllIlIlll[8])));
        }
        return Class324.d[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class324.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIlIllllIIlI() {
        (llIllIlIlll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class324.llIllIlIlll[1] = "DES";
        Class324.llIllIlIlll[2] = "\u001a\u000ftò\u009f!XüZáoj\u0001zePÇÍz\t@\u008aeÖ\u0010\u0099°\u0015ç»\u0088LK¼k´´º×C\u0087\u0010ã\u0081Ý#ö!\u0011Þ\u0007¾\u0089÷é/'X";
        Class324.llIllIlIlll[3] = "ËG\u001a0q¥É\u0019\u0005»\u000e\u00adù¥\u0095\u0010Z\u009dc®%\u0085s9\u0010Ïâ\u0010\u000f\u008avå¬4¸Å·\fµwÁ";
        Class324.llIllIlIlll[4] = "ISO-8859-1";
        Class324.llIllIlIlll[5] = "DES/CBC/PKCS5Padding";
        Class324.llIllIlIlll[6] = "DES";
        Class324.llIllIlIlll[7] = "你还能用语言反击我么干什么唧唧喳喳的啊没点实力还在我面前耀武扬威的你不嫌丢脸吗你看看你残缺不全的词汇上气不接下气的打字告诉我你没有苦苦硬撑因为那会非常的累NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u2001\u200c\u2005";
        Class324.llIllIlIlll[8] = "ISO-8859-1";
        Class324.llIllIlIlll[9] = "你还能用语言反击我么干什么唧唧喳喳的啊没点实力还在我面前耀武扬威的你不嫌丢脸吗你看看你残缺不全的词汇上气不接下气的打字告诉我你没有苦苦硬撑因为那会非常的累NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u2001\u200c\u2005";
        Class324.llIllIlIlll[10] = " : ";
        Class324.llIllIlIlll[11] = " : ";
    }
    
    private static String lIIlIllllIIII(String s, final String s2) {
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
    
    private static String lIIlIlllIlllI(final String s, final String s2) {
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
    
    private static String lIIlIlllIllll(final String s, final String s2) {
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
