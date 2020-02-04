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

public final class Class185 extends Thread
{
    private Class348 mSocket;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIllIllll;
    
    public Class185(final Class348 mSocket) {
        super();
        this.mSocket = mSocket;
        this.connect();
    }
    
    @Override
    public final void run() {
        while (true) {
            final long n = 1000L;
            try {
                Thread.sleep(n);
                final Class290 heartBeatTimer = Class206.heartBeatTimer;
                final int[] b = Class139.b();
                final long n2 = lcmp(System.currentTimeMillis() - heartBeatTimer.lastMs, 8000L);
                if (b == null && n2 <= 0) {}
                if (n2 == 0) {
                    continue;
                }
                this.mSocket.socket.sendUrgentData(255);
            }
            catch (Exception ex) {
                Class206.output("客户端断开连接，尝试重连中...");
                this.connect();
            }
        }
    }
    
    private void connect() {
        try {
            this.mSocket.socket = new Socket("127.0.0.99", 7577);
            this.mSocket.writer = new PrintWriter(this.mSocket.socket.getOutputStream(), true);
            Class206.loginPacket.sendPacketToServer(this.mSocket.writer);
            Class206.output("连接IRC服务器成功！");
        }
        catch (Exception ex) {
            Class206.output("连接IRC服务器失败...");
            ex.printStackTrace();
        }
    }
    
    static {
        lIIllllIIlll();
        Class169.a(1006732187872939721L, 956412237664849934L, MethodHandles.lookup().lookupClass()).a(243524941950577L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class185.llIllIllll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class185.llIllIllll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(95130131422547L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = Class185.llIllIllll[2]).length();
        int n4 = 80;
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class185.llIllIllll[4]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class185.llIllIllll[3]).length();
                            n4 = 56;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1905;
        if (Class185.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class185.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class185.llIllIllll[5]);
                    array[1] = SecretKeyFactory.getInstance(Class185.llIllIllll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class185.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class185.llIllIllll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class185.c[n3] = a(((Cipher)array[0]).doFinal(Class185.b[n3].getBytes(Class185.llIllIllll[8])));
        }
        return Class185.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class185.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIllllIIlll() {
        (llIllIllll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class185.llIllIllll[1] = "DES";
        Class185.llIllIllll[2] = "à%mV¬\u008a\u0089!(8x°écgüÅA¦úèú\u009bå\u009fÚünO\u0090ïû\u0014\u001eµTbUyÇã3Ñ\u000fééÓë\u0007Õî\u009fÝ° \u009bf\u0016ü\u0098$°qÝ¹ÛËxéÔQÎ=Úg\u0081\u0011¡\u0087\u0098 ,ã\u0007¹\u001a\u009d+\u0018ÂJ1Ë\u0091\f¹`£\u0001\u0095ò-ççüç\u0006Vì $2<";
        Class185.llIllIllll[3] = "@ù©<ÁÄ\u0007³·\u0007y:NÂX>ï:\u0084V\u001aeÿ-5E\u0091\u0015\u00adU\u0089p\u009bR\u0081\u000f«È·ó\u0094¨ó\u009e^\u009a\u001fýw\u0014Çý$Î\u0096N0m'\u0084 ÅÁlãS´u\r½PÎÕU³)+\u008f^øÜ\b'\u001bB\t\u00ad\u00966\u009aC<>ÑÍ\u0003«\u0082âP\u0096i\u0003ZÃ";
        Class185.llIllIllll[4] = "ISO-8859-1";
        Class185.llIllIllll[5] = "DES/CBC/PKCS5Padding";
        Class185.llIllIllll[6] = "DES";
        Class185.llIllIllll[7] = "那些词只能让我更加的兴奋你以为你爹爹我会为此心情有一丝丝浮动是吗你看看你苟延残喘的啊你回去抱着你妈痛哭好吗你反击我只是因为你的本能是不是请你不要那么风趣幽默好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2006 \u200c";
        Class185.llIllIllll[8] = "ISO-8859-1";
        Class185.llIllIllll[9] = "那些词只能让我更加的兴奋你以为你爹爹我会为此心情有一丝丝浮动是吗你看看你苟延残喘的啊你回去抱着你妈痛哭好吗你反击我只是因为你的本能是不是请你不要那么风趣幽默好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2006 \u200c";
        Class185.llIllIllll[10] = " : ";
        Class185.llIllIllll[11] = " : ";
    }
    
    private static String lIIllllIIlII(final String s, final String s2) {
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
    
    private static String lIIlllIllIll(String s, final String s2) {
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
    
    private static String lIIlllIllllI(final String s, final String s2) {
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
