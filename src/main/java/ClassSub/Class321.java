package ClassSub;

import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class321 extends Class257
{
    private static String PACKET_ID;
    private Class297 client;
    public final Class20 user;
    private String inGamename;
    private boolean isClientFriend;
    private static final long a;
    private static final String[] c;
    private static final String[] d;
    private static final Map e;
    private static final String[] lllllIIIll;
    
    private Class321(final Class20 user, final String inGamename, final boolean isClientFriend) {
        final String value = String.valueOf(new StringBuilder("ONLINEUSER::").append(Class297.getClientName()).append("::").append(user.username).append("::").append(inGamename).append("::").append(isClientFriend));
        final int recieve$299aaa4 = Class309.RECIEVE$299aaa4;
        super(value);
        this.user = user;
        this.inGamename = inGamename;
        this.isClientFriend = isClientFriend;
    }
    
    public Class321(final String s) {
        Class225.getTypeByName(s.split("::")[1]);
        this(Class20.getIRCUserByNameAndType(Class225.getTypeByName(s.split("::")[1]), s.split("::")[2]), s.split("::")[3], s.split("::")[4].equals("true"));
        this.user.inGamename = this.inGamename;
        this.user.isClientFriend = this.isClientFriend;
    }
    
    static {
        lIllIIlIlllI();
        Class169.a(-2478187761593659824L, 7048059886943814520L, MethodHandles.lookup().lookupClass()).a(194683228393465L);
        e = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class321.lllllIIIll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class321.lllllIIIll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(31322083173889L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class321.lllllIIIll[2]).length();
        int n4 = 32;
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class321.lllllIIIll[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class321.lllllIIIll[3]).length();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5810;
        if (Class321.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class321.e.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class321.lllllIIIll[5]);
                    array[1] = SecretKeyFactory.getInstance(Class321.lllllIIIll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class321.e.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class321.lllllIIIll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class321.d[n3] = a(((Cipher)array[0]).doFinal(Class321.c[n3].getBytes(Class321.lllllIIIll[8])));
        }
        return Class321.d[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class321.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIllIIlIlllI() {
        (lllllIIIll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class321.lllllIIIll[1] = "DES";
        Class321.lllllIIIll[2] = "\u0092>F)©\u0089¶à\u0089´Ó×½\u0004ùú6Ò\u0004´kÔãÑáo\u0005\u001c\u008d¾ïb\u0010ª\u009e\u001b\u001dÉg\u0082UZ\u0005i\u009f\u0092¹ê\u0014\u0010?PjR/:½\u0089,Zyß_ÈÂ\\";
        Class321.lllllIIIll[3] = "8e¼3>Î\u008a:=rõ\u0012\u0088\u008d\u008d\u0088\u0018¯'%k-@|\u0093l²·à(YþwñC\u0003Û<w\u0013\u0006";
        Class321.lllllIIIll[4] = "ISO-8859-1";
        Class321.lllllIIIll[5] = "DES/CBC/PKCS5Padding";
        Class321.lllllIIIll[6] = "DES";
        Class321.lllllIIIll[7] = "你这样的残疾人早已被我殴打的身心俱伤还在这里不知死活的抗争着怎么这么幼稚用那些无关痛痒一笑而过的话你们还真是死皮赖脸的不要皮味你都要抓耳挠腮的思考大半天会什么以彼之道还施彼身NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u2003\u200f\u2009";
        Class321.lllllIIIll[8] = "ISO-8859-1";
        Class321.lllllIIIll[9] = "你这样的残疾人早已被我殴打的身心俱伤还在这里不知死活的抗争着怎么这么幼稚用那些无关痛痒一笑而过的话你们还真是死皮赖脸的不要皮味你都要抓耳挠腮的思考大半天会什么以彼之道还施彼身NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u2003\u200f\u2009";
        Class321.lllllIIIll[10] = " : ";
        Class321.lllllIIIll[11] = " : ";
    }
    
    private static String lIllIIlIlIll(final String s, final String s2) {
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
    
    private static String lIllIIlIllIl(String s, final String s2) {
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
    
    private static String lIllIIlIllII(final String s, final String s2) {
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
