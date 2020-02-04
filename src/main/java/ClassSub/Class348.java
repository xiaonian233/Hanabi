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

public final class Class348 extends Thread
{
    public Socket socket;
    public PrintWriter writer;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIIIlIlIIl;
    
    public Class348() {
        super();
    }
    
    @Override
    public final void run() {
        final int[] b = Class139.b();
        new Class185(this).start();
        final int[] array = b;
        while (true) {
            try {
                Class206.processMessage(new BufferedReader(new InputStreamReader(this.socket.getInputStream(), "GBK")).readLine());
            }
            catch (Exception ex) {
                final Class290 heartBeatTimer = Class206.heartBeatTimer;
                if (array == null) {
                    if (heartBeatTimer.lastMs <= 5000L) {
                        continue;
                    }
                    final Class290 heartBeatTimer2 = Class206.heartBeatTimer;
                }
                heartBeatTimer.lastMs = 0L;
                Class206.output(String.valueOf(new StringBuilder("接收消息时出现错误！").append(ex.getMessage())));
                ex.printStackTrace();
            }
        }
    }
    
    private static String getSocketMessage(final Socket socket) throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream(), "GBK")).readLine();
    }
    
    static {
        llIIIIIllIII();
        Class169.a(4639580350179431235L, 7950035539928313306L, MethodHandles.lookup().lookupClass()).a(87740632137112L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class348.lIIIIlIlIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class348.lIIIIlIlIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(116684257399787L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class348.lIIIIlIlIIl[2]).length();
        int char1 = 56;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class348.lIIIIlIlIIl[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
    }
    
    private static Exception a(final Exception ex) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x57DD;
        if (Class348.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class348.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class348.lIIIIlIlIIl[4]);
                    array[1] = SecretKeyFactory.getInstance(Class348.lIIIIlIlIIl[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class348.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class348.lIIIIlIlIIl[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class348.c[n3] = a(((Cipher)array[0]).doFinal(Class348.b[n3].getBytes(Class348.lIIIIlIlIIl[7])));
        }
        return Class348.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class348.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llIIIIIllIII() {
        (lIIIIlIlIIl = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class348.lIIIIlIlIIl[1] = "DES";
        Class348.lIIIIlIlIIl[2] = "©ÚÔlTÝÑ\u0003ûF|\u0095kofÓ\u009fÄ^f\u0010\u0014mæe/.Ôêí\u001f¡Àà\u0005Ï?6ü\u000e\u00849L\u0017\u0085ºÞ\u0001\tæ®X\u0003Dß5\u0010IV\fUæhå¯\u0012a\u0085sIðl&";
        Class348.lIIIIlIlIIl[3] = "ISO-8859-1";
        Class348.lIIIIlIlIIl[4] = "DES/CBC/PKCS5Padding";
        Class348.lIIIIlIlIIl[5] = "DES";
        Class348.lIIIIlIlIIl[6] = "而是你太没用知道不知道叽叽喳喳琳琅满目婆婆妈妈你以为你爹爹我会为此心情有一丝丝浮动是吗你看看你苟延残喘的啊小子我感觉你都没速度了呀是不是畏惧你登峰造极的爸爸我了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u2008\u2001\u2001";
        Class348.lIIIIlIlIIl[7] = "ISO-8859-1";
        Class348.lIIIIlIlIIl[8] = "而是你太没用知道不知道叽叽喳喳琳琅满目婆婆妈妈你以为你爹爹我会为此心情有一丝丝浮动是吗你看看你苟延残喘的啊小子我感觉你都没速度了呀是不是畏惧你登峰造极的爸爸我了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u2008\u2001\u2001";
        Class348.lIIIIlIlIIl[9] = " : ";
        Class348.lIIIIlIlIIl[10] = " : ";
    }
    
    private static String llIIIIIIlIlI(final String s, final String s2) {
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
    
    private static String llIIIIIIlIll(final String s, final String s2) {
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
    
    private static boolean llIIIIlIIIII(final int n) {
        return n > 0;
    }
    
    private static int llIIIIIllllI$2566aa8(final long n) {
        return lcmp(n, 5000L);
    }
}
