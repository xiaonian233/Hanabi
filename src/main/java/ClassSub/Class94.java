package ClassSub;

import net.minecraft.util.*;
import net.minecraft.client.*;
import java.nio.charset.*;
import java.io.*;
import javax.crypto.*;
import java.security.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Class94
{
    public static boolean canSendMotionPacket;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIlI;
    
    public Class94() {
        super();
    }
    
    public static Timer getTimer() {
        Minecraft.func_71410_x();
        return null;
    }
    
    public static String getHWID() {
        String z = null;
        try {
            final String encodeToString = Base64.getUrlEncoder().encodeToString(String.valueOf(new StringBuilder().append(System.getenv("PROCESSOR_IDENTIFIER")).append(System.getenv("COMPUTERNAME")).append(System.getProperty("user.name"))).getBytes());
            final MessageDigest instance;
            (instance = MessageDigest.getInstance("SHA-1")).update(encodeToString.getBytes(StandardCharsets.ISO_8859_1), 0, encodeToString.length());
            z = z(instance.digest());
        }
        catch (Exception ex) {}
        return z;
    }
    
    private static String g(String encodeToString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        encodeToString = Base64.getUrlEncoder().encodeToString(encodeToString.getBytes());
        final MessageDigest instance;
        (instance = MessageDigest.getInstance("SHA-1")).update(encodeToString.getBytes(StandardCharsets.ISO_8859_1), 0, encodeToString.length());
        return z(instance.digest());
    }
    
    private static String z(final byte[] array) {
        final int[] b = Class139.b();
        final StringBuilder sb = new StringBuilder();
        final int length = array.length;
        int i = 0;
        final int[] array2 = b;
        while (i < length) {
            final byte b2;
            int n = (b2 = array[i]) >>> 4 & 0xF;
            int n2 = 0;
            while (true) {
                while (true) {
                    Label_0101: {
                        if (n >= 0 && n <= 9) {
                            sb.append((char)(n + 48));
                            if (array2 == null) {
                                break Label_0101;
                            }
                        }
                        sb.append((char)(97 + (n - 5)));
                    }
                    n = (b2 & 0xF);
                    if (n2++ > 0) {
                        ++i;
                        if (array2 == null) {
                            break;
                        }
                        continue;
                    }
                    break;
                }
            }
            if (array2 != null) {
                break;
            }
        }
        return String.valueOf(sb).toUpperCase();
    }
    
    static {
        lIIIIll();
        Class169.a(6880494262802206417L, 977417955424091670L, MethodHandles.lookup().lookupClass()).a(7194924606736L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class94.lIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class94.lIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(70780974248739L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = Class94.lIlI[2]).length();
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class94.lIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class94.lIlI[3]).length();
                            n4 = 24;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
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
        b = b2;
        c = new String[4];
        Class94.canSendMotionPacket = true;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1CBE;
        if (Class94.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class94.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class94.lIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(Class94.lIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class94.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class94.lIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class94.c[n3] = a(((Cipher)array[0]).doFinal(Class94.b[n3].getBytes(Class94.lIlI[8])));
        }
        return Class94.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class94.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIIll() {
        (lIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class94.lIlI[1] = "DES";
        Class94.lIlI[2] = "\u0002&9°Àñh\u0093\t\u0084væd©\u000f\u000f\u0010èK\u009e»ç \u0017(ÙÂnD\u0010\u0088o©xX\u0089\u001e%\u0097\ft,\u0018\u0089\u0093à)\u0092\býJ0À7Ú?±Aê®\u008a§o\u0011\u001e";
        Class94.lIlI[3] = "ÖÓ\u0006\u0012ka\u0098ç{\\\u0019ÉÆÉ\u009cê\u0095\u0087\"WÀ,ì\u009d\u0010#\u0090aÖ\u008f\u0004\u009bò\u0019v$r¥¨A\b";
        Class94.lIlI[4] = "ISO-8859-1";
        Class94.lIlI[5] = "DES/CBC/PKCS5Padding";
        Class94.lIlI[6] = "DES";
        Class94.lIlI[7] = "耀武扬威予取予求半身不遂窝囊废是不是啊什么什么什么你这么垃圾为何现在支支吾吾躲躲闪闪的逃避你被打的事实继续找借口来逃避我吧你怎么还纹丝不动啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u200a\u2005\u200d";
        Class94.lIlI[8] = "ISO-8859-1";
        Class94.lIlI[9] = "耀武扬威予取予求半身不遂窝囊废是不是啊什么什么什么你这么垃圾为何现在支支吾吾躲躲闪闪的逃避你被打的事实继续找借口来逃避我吧你怎么还纹丝不动啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u200a\u2005\u200d";
        Class94.lIlI[10] = " : ";
        Class94.lIlI[11] = " : ";
    }
    
    private static String lIIIIIl(final String s, final String s2) {
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
    
    private static String lIlI(final String s, final String s2) {
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
    
    private static String lIIIIlI(String s, final String s2) {
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
    
    private static boolean lIIllIIII$255f299(final int n) {
        return n > 0;
    }
    
    private static boolean lIIlIlllI$255f299(final int n) {
        return n <= 9;
    }
    
    private static boolean lIIlIllIl(final int n) {
        return n >= 0;
    }
}
