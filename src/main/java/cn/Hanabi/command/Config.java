package cn.Hanabi.command;

import org.jetbrains.annotations.*;
import net.minecraft.client.*;
import java.io.*;
import java.net.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Config extends Command
{
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIIllIIIll;
    
    public Config() {
        super("config", new String[0]);
    }
    
    @Override
    public final void run(String b, @NotNull final String[] array) {
        b = (String)(Object)Class139.b();
        final int length = array.length;
        Label_0359: {
            final String value;
            Label_0349: {
                if (b == null) {
                    if (length != 1) {
                        break Label_0359;
                    }
                    value = get(String.valueOf(new StringBuilder("http://hanabi.alphaantileak.cn:893/hanabi/config/").append(array[0].toLowerCase()).append("/values.txt")));
                    if (b != null) {
                        break Label_0349;
                    }
                    value.equals(Config.lIIllIIIll[0]);
                }
                if (length == 0) {
                    final String value2 = get(String.valueOf(new StringBuilder("http://hanabi.alphaantileak.cn:893/hanabi/config/").append(array[0].toLowerCase()).append("/values.txt")));
                    final int[] b2 = Class139.b();
                    final String value3 = String.valueOf(new StringBuilder().append(Minecraft.func_71410_x().field_71412_D.getAbsolutePath()).append("/Hanabi"));
                    final int[] array2 = b2;
                    final File file2;
                    final File file = file2 = new File(String.valueOf(new StringBuilder().append(value3).append("/values.txt")));
                    try {
                        final boolean exists = file.exists();
                        if (array2 == null) {
                            if (!exists) {
                                file2.createNewFile();
                            }
                        }
                        final PrintWriter printWriter;
                        (printWriter = new PrintWriter(file2)).print(value2);
                        printWriter.close();
                    }
                    catch (Exception ex) {
                        ex.printStackTrace();
                    }
                    final String value4 = get(String.valueOf(new StringBuilder("http://hanabi.alphaantileak.cn:893/hanabi/config/").append(array[0].toLowerCase()).append("/mods.txt")));
                    final int[] b3 = Class139.b();
                    final String value5 = String.valueOf(new StringBuilder().append(Minecraft.func_71410_x().field_71412_D.getAbsolutePath()).append("/Hanabi"));
                    final int[] array3 = b3;
                    final File file4;
                    final File file3 = file4 = new File(String.valueOf(new StringBuilder().append(value5).append("/mods.txt")));
                    try {
                        final boolean exists2 = file3.exists();
                        if (array3 == null) {
                            if (!exists2) {
                                file4.createNewFile();
                            }
                        }
                        final PrintWriter printWriter2;
                        (printWriter2 = new PrintWriter(file4)).print(value4);
                        printWriter2.close();
                    }
                    catch (Exception ex2) {
                        ex2.printStackTrace();
                    }
                    Class139.INSTANCE.fileManager.load();
                    if (b == null) {
                        return;
                    }
                }
            }
            Class23.sendClientMessage(value, Class153.INFO);
            if (b == null) {
                return;
            }
        }
        Class23.sendClientMessage(".config [server]", Class153.INFO);
    }
    
    private static void writeValue(final String s) {
        final int[] b = Class139.b();
        final String value = String.valueOf(new StringBuilder().append(Minecraft.func_71410_x().field_71412_D.getAbsolutePath()).append("/Hanabi"));
        final int[] array = b;
        final File file2;
        final File file = file2 = new File(String.valueOf(new StringBuilder().append(value).append("/values.txt")));
        try {
            final boolean exists = file.exists();
            if (array == null) {
                if (!exists) {
                    file2.createNewFile();
                }
            }
            final PrintWriter printWriter;
            (printWriter = new PrintWriter(file2)).print(s);
            printWriter.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void writeMods(final String s) {
        final int[] b = Class139.b();
        final String value = String.valueOf(new StringBuilder().append(Minecraft.func_71410_x().field_71412_D.getAbsolutePath()).append("/Hanabi"));
        final int[] array = b;
        final File file2;
        final File file = file2 = new File(String.valueOf(new StringBuilder().append(value).append("/mods.txt")));
        try {
            final boolean exists = file.exists();
            if (array == null) {
                if (!exists) {
                    file2.createNewFile();
                }
            }
            final PrintWriter printWriter;
            (printWriter = new PrintWriter(file2)).print(s);
            printWriter.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static String get(final String s) {
        final int[] b = Class139.b();
        String value = Config.lIIllIIIll[1];
        BufferedReader bufferedReader = null;
        final int[] array = b;
        try {
            final URLConnection openConnection;
            (openConnection = new URL(s).openConnection()).setDoOutput(true);
            openConnection.setReadTimeout(99781);
            openConnection.setRequestProperty("accept", "*/*");
            openConnection.setRequestProperty("connection", "Keep-Alive");
            openConnection.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            openConnection.connect();
            final Iterator<String> iterator = openConnection.getHeaderFields().keySet().iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (array != null) {
                    break;
                }
            }
            bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                value = String.valueOf(new StringBuilder().append(value).append(line).append(Config.lIIllIIIll[2]));
                if (array == null) {
                    if (array != null) {
                        break;
                    }
                    continue;
                }
            }
        }
        catch (Exception ex) {}
        finally {
            final BufferedReader bufferedReader2 = bufferedReader;
            final int[] array2 = array;
            try {
                if (array2 != null || bufferedReader2 != null) {
                    bufferedReader2.close();
                }
            }
            catch (Exception ex2) {}
        }
        return value;
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
    
    static {
        lllIIIlIlIl();
        Class169.a(6385433895116150750L, 7887631763979625303L, MethodHandles.lookup().lookupClass()).a(71578611383478L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Config.lIIllIIIll[3]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Config.lIIllIIIll[4]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(126833821796812L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[17];
        int n2 = 0;
        final String s = "$}µÉ\u0018\u0091ÿx»ã¸¥ni\u00066X:\u0001\u009a\u001ag´\rÎÌZ\u0011;*öÞXÙî«Nq2Ú\u00154q\u0010t\u008e\u007fþV\u0007ÉsÀ`O\u0087\u0090]w\u0010Ó#ÚØ¶\"§\u0012ÂbÝ8b:JÕ\u001as0Ä\u0094Ö\u009bþ\u001f_\\r\u000bÊ \u0018i\u0093\u001cA\u0013(\u008f\u000bÔ%%uO\u0010\u0018®mTy)F9ÉË~\u0084\u0099©ª40ð7ô_0TJ\u00000O~Éºz\u0083'B\u0010ñÃÑKÞþë\u00adOíþR!Gx\u00ad\u0085ZYI\u0005\u001foé:NIh½N\u0018÷)J¿\u0013\u0089þpíÍÙ¹ÑéV=\u009fb\u000b¥yªÚ\bX¿hr_Âiv\u00928\u0018\t>\u001b=7t\u0005³ÚlÓ\u0014®ü×\u0000\u0005ÔKVÐ:\b\"þ×+ç(L¨ÇÚÁ\rùÛ\fCz\u0011n\u009a·\u0015¬ÉÐ\u001eáj@Q)t\u0086ÑÁæ~\u0002%dÃ\u0083\u000bdATý?D&#Ç'óÚ DmÒXAz¥\fç/\b£þ\u0085\u0099Rõ\u001bOC\u0093ð\f!¹&æ2±àÉÙ0Áe]±ø`¥\u0091løPåÞ\u008fÀ\u009a\u0018\u0092rH¢\u000e\u0017-Ã-&\u0001K\u000f¾\u0007æ-ÀÞOr\tÈ2ÿ°´\u0099cÔÖ \u0006\n\u0001\u009f²qfµ¯¨\u0086ï»Äì\u000e\u0094S\u0001/\u0012é«®\u0006~zj?yº\u001c\u0018\u0002\u0080ªþÖ;YÝî×\u0093ð\u0004\b¹`§/\f\u00ad-ga9 \u008ebÓ\u001bÁ\u0017\u000b]p<Ð3\u009c\u00076ßmú°ç\u008b\u0084®Ùú\u0081\u0091À\u0086 g\\ R\u008aCd\u009bð(Þ\u0099äHrþ\u0013ÃÝ;Ø!\u001a&\r¬êv\u0095\u001a©_\u009dm>XyÐ¶kïò1Ç\u0080*xç\u0084Î\u001d>\u007f>Zõ`\u00941b²ôô{3\u0013\u0081\u0080õÅF\u009a¹sH/\u001e¦è\u0094j:¿b\u001ciN\u0007ßÏ\u0004\u000fTo\u009eàjsu\u001d¿\"É\u0097O\u0013 þÚ!tô\u0093¯Ð¶\u0099\u0088¨i\u0095yKú \"E<\u0090\u001a`XâïùJ\u0015L\u001cD´\u0007\t%ãì\u0082ay\u0089¦\u0010\u0012½Ú\u0000¨\u0010\u0099ûWó\u0094r/\u009cxÑIuÓz\u0098\u001b";
        String s2 = "$}µÉ\u0018\u0091ÿx»ã¸¥ni\u00066X:\u0001\u009a\u001ag´\rÎÌZ\u0011;*öÞXÙî«Nq2Ú\u00154q\u0010t\u008e\u007fþV\u0007ÉsÀ`O\u0087\u0090]w\u0010Ó#ÚØ¶\"§\u0012ÂbÝ8b:JÕ\u001as0Ä\u0094Ö\u009bþ\u001f_\\r\u000bÊ \u0018i\u0093\u001cA\u0013(\u008f\u000bÔ%%uO\u0010\u0018®mTy)F9ÉË~\u0084\u0099©ª40ð7ô_0TJ\u00000O~Éºz\u0083'B\u0010ñÃÑKÞþë\u00adOíþR!Gx\u00ad\u0085ZYI\u0005\u001foé:NIh½N\u0018÷)J¿\u0013\u0089þpíÍÙ¹ÑéV=\u009fb\u000b¥yªÚ\bX¿hr_Âiv\u00928\u0018\t>\u001b=7t\u0005³ÚlÓ\u0014®ü×\u0000\u0005ÔKVÐ:\b\"þ×+ç(L¨ÇÚÁ\rùÛ\fCz\u0011n\u009a·\u0015¬ÉÐ\u001eáj@Q)t\u0086ÑÁæ~\u0002%dÃ\u0083\u000bdATý?D&#Ç'óÚ DmÒXAz¥\fç/\b£þ\u0085\u0099Rõ\u001bOC\u0093ð\f!¹&æ2±àÉÙ0Áe]±ø`¥\u0091løPåÞ\u008fÀ\u009a\u0018\u0092rH¢\u000e\u0017-Ã-&\u0001K\u000f¾\u0007æ-ÀÞOr\tÈ2ÿ°´\u0099cÔÖ \u0006\n\u0001\u009f²qfµ¯¨\u0086ï»Äì\u000e\u0094S\u0001/\u0012é«®\u0006~zj?yº\u001c\u0018\u0002\u0080ªþÖ;YÝî×\u0093ð\u0004\b¹`§/\f\u00ad-ga9 \u008ebÓ\u001bÁ\u0017\u000b]p<Ð3\u009c\u00076ßmú°ç\u008b\u0084®Ùú\u0081\u0091À\u0086 g\\ R\u008aCd\u009bð(Þ\u0099äHrþ\u0013ÃÝ;Ø!\u001a&\r¬êv\u0095\u001a©_\u009dm>XyÐ¶kïò1Ç\u0080*xç\u0084Î\u001d>\u007f>Zõ`\u00941b²ôô{3\u0013\u0081\u0080õÅF\u009a¹sH/\u001e¦è\u0094j:¿b\u001ciN\u0007ßÏ\u0004\u000fTo\u009eàjsu\u001d¿\"É\u0097O\u0013 þÚ!tô\u0093¯Ð¶\u0099\u0088¨i\u0095yKú \"E<\u0090\u001a`XâïùJ\u0015L\u001cD´\u0007\t%ãì\u0082ay\u0089¦\u0010\u0012½Ú\u0000¨\u0010\u0099ûWó\u0094r/\u009cxÑIuÓz\u0098\u001b";
        int n3 = s.length();
        int n4 = 16;
        int n5 = -1;
    Label_0149:
        while (true) {
            while (true) {
                ++n5;
                final String s3 = s2;
                final int n6 = n5;
                String s4 = s3.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s4.getBytes(Config.lIIllIIIll[6]))).intern();
                    switch (n7) {
                        default: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                continue Label_0149;
                            }
                            n3 = (s2 = Config.lIIllIIIll[5]).length();
                            n4 = 16;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                break;
                            }
                            break Label_0149;
                        }
                    }
                    ++n5;
                    final String s5 = s2;
                    final int n8 = n5;
                    s4 = s5.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        d = d2;
        e = new String[17];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7C6E;
        if (Config.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Config.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Config.lIIllIIIll[7]);
                    array[1] = SecretKeyFactory.getInstance(Config.lIIllIIIll[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Config.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Config.lIIllIIIll[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Config.e[n3] = a(((Cipher)array[0]).doFinal(Config.d[n3].getBytes(Config.lIIllIIIll[10])));
        }
        return Config.e[n3];
    }
    
    private static void lllIIIlIlIl() {
        (lIIllIIIll = new String[14])[0] = "";
        Config.lIIllIIIll[1] = "";
        Config.lIIllIIIll[2] = "\n";
        Config.lIIllIIIll[3] = "DES/CBC/PKCS5Padding";
        Config.lIIllIIIll[4] = "DES";
        Config.lIIllIIIll[5] = "1UìÈ\u00838>´êÔu\u0096\u007fs!4\u0010ñÃ\u0017'ª,\u000eHÏö\f\u000bûW\u0080f";
        Config.lIIllIIIll[6] = "ISO-8859-1";
        Config.lIIllIIIll[7] = "DES/CBC/PKCS5Padding";
        Config.lIIllIIIll[8] = "DES";
        Config.lIIllIIIll[9] = "从地球到太阳都有我的光在火星看到我你肯定是继续躲你紧张吗追求速度的过程中你没了文化中国文字被你糟蹋那请问你是什么选手呢心跳加快畏惧你爹爹了是不是你这个不肖子孙啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u2006\u2006\u200d";
        Config.lIIllIIIll[10] = "ISO-8859-1";
        Config.lIIllIIIll[11] = "从地球到太阳都有我的光在火星看到我你肯定是继续躲你紧张吗追求速度的过程中你没了文化中国文字被你糟蹋那请问你是什么选手呢心跳加快畏惧你爹爹了是不是你这个不肖子孙啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u2006\u2006\u200d";
        Config.lIIllIIIll[12] = " : ";
        Config.lIIllIIIll[13] = " : ";
    }
    
    private static String lllIIIlIIlI(String s, final String s2) {
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
    
    private static String lllIIIlIlII(final String s, final String s2) {
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
    
    private static String lllIIIlIIll(final String s, final String s2) {
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
