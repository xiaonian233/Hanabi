package ClassSub;

import java.io.*;
import java.net.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

final class Class107 extends Thread
{
    private PrintStream ps;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIIIIIIlI;
    
    private Class107(final PrintStream ps) {
        super();
        this.ps = ps;
    }
    
    private static String getRandomString(final int n) {
        final int[] b = Class139.b();
        final String s = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        final int[] array = b;
        final Random random = new Random();
        final StringBuffer sb = new StringBuffer();
        int i = 0;
        while (i < n) {
            final StringBuffer append = sb.append(s.charAt(random.nextInt(62)));
            if (array != null) {
                return append.toString();
            }
            ++i;
            if (array != null) {
                break;
            }
        }
        final StringBuffer append = sb;
        return append.toString();
    }
    
    @Override
    public final void run() {
        Class258.active = false;
        while (true) {
            this.ps.println("AntiSkidderCrack Protecting");
            try {
                final URL url = new URL(new URI(new String(String.valueOf(new StringBuilder("https://hanabi.alphaantileak.cn:1337/").append(getRandomString(new Random().nextInt(9) + 1))))).toString());
            }
            catch (MalformedURLException | URISyntaxException ex2) {
                final Throwable t;
                t.printStackTrace();
            }
            final long n = 3000L;
            try {
                Thread.sleep(n);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    static {
        lIIIlIlllIII();
        Class169.a(1160742518924704209L, 3321067383189497956L, MethodHandles.lookup().lookupClass()).a(30604428253753L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class107.llIIIIIIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class107.llIIIIIIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(69647783783810L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Class107.llIIIIIIlI[2]).length();
        int char1 = 64;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class107.llIIIIIIlI[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[3];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5A3F;
        if (Class107.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class107.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class107.llIIIIIIlI[4]);
                    array[1] = SecretKeyFactory.getInstance(Class107.llIIIIIIlI[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class107.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class107.llIIIIIIlI[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class107.c[n3] = a(((Cipher)array[0]).doFinal(Class107.b[n3].getBytes(Class107.llIIIIIIlI[7])));
        }
        return Class107.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class107.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIlIlllIII() {
        (llIIIIIIlI = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class107.llIIIIIIlI[1] = "DES";
        Class107.llIIIIIIlI[2] = "] Sò\u008d°\f\u0003}÷Çg\u0013\u008d>#x´ç\u0019\u0087æ0l\u000em\u0083\u0093dÝS.7ýïÿ\u0010d\u00149´I¡Jp ~\u0084Z\u0015\u0092Ti\\¼W)y³r\rzTÙ0\u009cA\u001cMjpy\u0087z@ À\u008f>VÂ\u000bÆÒ±Õ7\u0099\u0006Õ)i\u008b\u0085\u001e\u0085º\u001b¸@\u009bëT\u0093ò\u0091Ã,F0{¼Q`Paêâ\u008a\fj¬\u0088\u0098]\u0002oL\u0091:ò+\u000eØÇXy8\u0082öPã0\u0004»)\u0090O$ßì5ìâ\u0016\u0002(NðÎ\r\u00ad3Z®\u0082¯:Ëk·@²\u0088ÄJ²zÉm\u0003Ù¢\u009fÜ®\u0082\u0092Xð\u0089Ü³`@\u0099yÞkp^»\u0010ÙÙ!%\u008c\u0090\u009c";
        Class107.llIIIIIIlI[3] = "ISO-8859-1";
        Class107.llIIIIIIlI[4] = "DES/CBC/PKCS5Padding";
        Class107.llIIIIIIlI[5] = "DES";
        Class107.llIIIIIIlI[6] = "你的飞扬跋扈不可一世被你苟且偷生的代替了啊你是不是不可一世的窝囊废啊知道不知道半身不遂耀武扬威予取予求窝囊废你现在是不是问天天不答问地地不应呢可能我的语言对你来说都无关紧要NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u200d \u200b";
        Class107.llIIIIIIlI[7] = "ISO-8859-1";
        Class107.llIIIIIIlI[8] = "你的飞扬跋扈不可一世被你苟且偷生的代替了啊你是不是不可一世的窝囊废啊知道不知道半身不遂耀武扬威予取予求窝囊废你现在是不是问天天不答问地地不应呢可能我的语言对你来说都无关紧要NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u200d \u200b";
        Class107.llIIIIIIlI[9] = " : ";
        Class107.llIIIIIIlI[10] = " : ";
    }
    
    private static String lIIIlIllIlll(final String s, final String s2) {
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
    
    private static String lIIIlIllIlIl(final String s, final String s2) {
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
    
    private static String lIIIlIllIllI(String s, final String s2) {
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
