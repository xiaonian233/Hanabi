package ClassSub;

import org.apache.http.client.config.*;
import org.apache.http.message.*;
import org.apache.http.client.entity.*;
import org.apache.http.*;
import org.apache.http.util.*;
import org.apache.http.client.*;
import java.io.*;
import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class138
{
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] llIlIIIlll;
    
    public Class138() {
        super();
    }
    
    public static String doGet(final String l) {
        return Class132.hookHttpClient(l);
    }
    
    private static String doPost(String s, final Map<String, Object> map) {
        final int[] b = Class139.b();
        CloseableHttpResponse execute = null;
        String string = Class138.llIlIIIlll[1];
        final CloseableHttpClient default1 = HttpClients.createDefault();
        final int[] array = b;
        ((HttpPost)(s = (String)new HttpPost(s))).setHeader("User-Agent", "Mozilla/5.0 AppIeWebKit");
        ((HttpPost)s).setConfig(RequestConfig.custom().setConnectTimeout(35000).setConnectionRequestTimeout(35000).setSocketTimeout(60000).build());
        if (map != null && map.size() > 0) {
            final ArrayList<BasicNameValuePair> list = new ArrayList<BasicNameValuePair>();
            Label_0192: {
                for (final Map.Entry<String, Object> entry : map.entrySet()) {
                    list.add(new BasicNameValuePair((String)entry.getKey(), entry.getValue().toString()));
                    if (array != null) {
                        break Label_0192;
                    }
                    if (array != null) {
                        break;
                    }
                }
                final String s2 = s;
                final ArrayList<BasicNameValuePair> list2 = list;
                try {
                    ((HttpPost)s2).setEntity((HttpEntity)new UrlEncodedFormEntity((List)list2, "UTF-8"));
                }
                catch (UnsupportedEncodingException ex) {
                    ex.printStackTrace();
                }
            }
        }
        final CloseableHttpClient closeableHttpClient = default1;
        final String s3 = s;
        try {
            string = EntityUtils.toString((execute = closeableHttpClient.execute((HttpUriRequest)s3)).getEntity());
        }
        catch (ClientProtocolException ex2) {
            ex2.printStackTrace();
        }
        catch (IOException ex3) {
            ex3.printStackTrace();
        }
        finally {
            if (array == null && execute != null) {
                final CloseableHttpResponse closeableHttpResponse = execute;
                try {
                    closeableHttpResponse.close();
                }
                catch (IOException ex4) {
                    ex4.printStackTrace();
                }
            }
            if (default1 != null) {
                final CloseableHttpClient closeableHttpClient2 = default1;
                try {
                    closeableHttpClient2.close();
                }
                catch (IOException ex5) {
                    ex5.printStackTrace();
                }
            }
        }
        return string;
    }
    
    static {
        lIIllIIIIllI();
        Class169.a(8047636680774988255L, 5742777746060519661L, MethodHandles.lookup().lookupClass()).a(266009325967704L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class138.llIlIIIlll[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class138.llIlIIIlll[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(110971747339779L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class138.llIlIIIlll[4]).length();
        int n4 = 40;
        int n5 = -1;
    Label_0152:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class138.llIlIIIlll[6]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class138.llIlIIIlll[5]).length();
                            n4 = 32;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0152;
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
        c = new String[5];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x6764;
        if (Class138.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class138.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class138.llIlIIIlll[7]);
                    array[1] = SecretKeyFactory.getInstance(Class138.llIlIIIlll[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class138.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class138.llIlIIIlll[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class138.c[n3] = a(((Cipher)array[0]).doFinal(Class138.b[n3].getBytes(Class138.llIlIIIlll[10])));
        }
        return Class138.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class138.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIllIIIIllI() {
        (llIlIIIlll = new String[14])[0] = "";
        Class138.llIlIIIlll[1] = "";
        Class138.llIlIIIlll[2] = "DES/CBC/PKCS5Padding";
        Class138.llIlIIIlll[3] = "DES";
        Class138.llIlIIIlll[4] = "ãÌ±Ó·\u0088£ª¬$y\u0095ÒGïÞ¤\u009c¦ôu\u000fc\u0084Ëk\u0000\u001eq¸9QÈ\u0094/!!I\u009a4\u0018®\u0092\u0096p)\u0099pÙ\u009c×\u008a¬Âó¿à¦\u000bÿ\u001aÎjÅ¼\u0010\u0096³\u008ecÆ\u008cm@º\u0014hP\u0088\u0018Ê{";
        Class138.llIlIIIlll[5] = "\u0019\u0017@B»é\u0082Uè*\u009e\u00108\u000b\n\r\u0080ÂO^êÒÓYÞ¼\u0002\u000bQê§Y(³;\r7Ú0\\3\u008d\u0086UØ*÷É\u0082ÙH/rÏ\u009b¾\u0017\u008b_C\u007fI&6\u0092ó8÷X7½>¹";
        Class138.llIlIIIlll[6] = "ISO-8859-1";
        Class138.llIlIIIlll[7] = "DES/CBC/PKCS5Padding";
        Class138.llIlIIIlll[8] = "DES";
        Class138.llIlIIIlll[9] = "怎么怎么怎么你这么自以为是因为你早已经被人揍的麻木了是不是你认为你的语言华丽为什么没能激怒好不好啊用你三三两两的言语攻击我是不是开始提高你的速度了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u2008\u200b\u2004";
        Class138.llIlIIIlll[10] = "ISO-8859-1";
        Class138.llIlIIIlll[11] = "怎么怎么怎么你这么自以为是因为你早已经被人揍的麻木了是不是你认为你的语言华丽为什么没能激怒好不好啊用你三三两两的言语攻击我是不是开始提高你的速度了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a\u2008\u200b\u2004";
        Class138.llIlIIIlll[12] = " : ";
        Class138.llIlIIIlll[13] = " : ";
    }
    
    private static String lIIllIIIIlIl(String s, final String s2) {
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
    
    private static String lIIllIIIIlII(final String s, final String s2) {
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
    
    private static String lIIllIIIIIll(final String s, final String s2) {
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
    
    private static boolean lIIllIIIlIll$2838e5b1(final Object o) {
        return o != null;
    }
    
    private static boolean lIIllIIIllII(final int n) {
        return n > 0;
    }
}
