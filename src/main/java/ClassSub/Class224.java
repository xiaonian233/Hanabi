package ClassSub;

import cn.Hanabi.command.*;
import org.jetbrains.annotations.*;
import java.io.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class224 extends Command
{
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIIlllIIIlI;
    
    public Class224() {
        super("irc", new String[] { Class224.lIIlllIIIlI[0] });
    }
    
    @Override
    public final void run(String value, @NotNull final String[] array) {
        final int[] b = Class139.b();
        if (array.length <= 0) {
            throw new Class109(String.valueOf(new StringBuilder("Usage: .").append(value).append(" message")));
        }
        value = Class224.lIIlllIIIlI[1];
        int i = 0;
        while (i < array.length) {
            value = String.valueOf(new StringBuilder().append(value).append(array[i]).append(Class224.lIIlllIIIlI[2]));
            ++i;
            if (b != null) {
                goto Label_0165;
            }
            if (b != null) {
                break;
            }
        }
        final String s = "IRC";
        if (b == null && Class4.getModule(s).state) {
            final Class297 type = Class206.type;
            final String username = Class206.username;
            try {
                new Class190(Class20.getIRCUserByNameAndType(type, username), value).sendPacketToServer(new PrintWriter(new OutputStreamWriter(Class206.socket.socket.getOutputStream(), "GBK"), true));
                return;
            }
            catch (IOException ex) {
                ex.printStackTrace();
                if (b == null) {
                    return;
                }
            }
            goto Label_0165;
        }
        Class23.sendClientMessage(s, Class153.ERROR);
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
    
    static {
        llIlllIlIIII();
        Class169.a(-4863757140912061612L, 2358687074804384271L, MethodHandles.lookup().lookupClass()).a(109547132767572L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class224.lIIlllIIIlI[3]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class224.lIIlllIIIlI[4]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(91504795491403L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[6];
        int n2 = 0;
        String s;
        int n3 = (s = Class224.lIIlllIIIlI[5]).length();
        int n4 = 80;
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class224.lIIlllIIIlI[7]))).intern();
                    switch (n7) {
                        default: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class224.lIIlllIIIlI[6]).length();
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
        d = d2;
        e = new String[6];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x8B6;
        if (Class224.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class224.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class224.lIIlllIIIlI[8]);
                    array[1] = SecretKeyFactory.getInstance(Class224.lIIlllIIIlI[9]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class224.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class224.lIIlllIIIlI[10], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class224.e[n3] = a(((Cipher)array[0]).doFinal(Class224.d[n3].getBytes(Class224.lIIlllIIIlI[11])));
        }
        return Class224.e[n3];
    }
    
    private static void llIlllIlIIII() {
        (lIIlllIIIlI = new String[15])[0] = "i";
        Class224.lIIlllIIIlI[1] = "";
        Class224.lIIlllIIIlI[2] = " ";
        Class224.lIIlllIIIlI[3] = "DES/CBC/PKCS5Padding";
        Class224.lIIlllIIIlI[4] = "DES";
        Class224.lIIlllIIIlI[5] = "G¥Ì¯\u0001x#\u0006\u0083þ¡AIÍ\u0005\u000f×ö¤[p\u001dþbÔDùqWµ%ûLËqáN\u0093\u0001\u001büú\u001a¿W\u008b^ÿ\u0081Òé1øÆ\u009føÓÏ{Q¶ªÝ\u008d\u0010ó]\u0005ÿÎ\u0084\fè\u0003\u0000ssYµ\u0002 ð\u0098o\f°æ\u009frÞ\u0095\u0085\u000b\u0093\u000fMâ¦Ö`\u000eB\u00984Xäç\u0005a:lêh\u0010yðÁ\u0010\"B\u009f¨\u0090t\u0003;%\u009elú ãúS/©w\u001eáé-@fúXß\u007fð¶b\u008c%\u009d1Hh®ßR2*øò";
        Class224.lIIlllIIIlI[6] = "hÑ¨³oÛRÂ\u001a õ'\u008b`¤\u0004\u0010\u0087þpR#\u00ad½^¡£Öø¿\u0002M¥";
        Class224.lIIlllIIIlI[7] = "ISO-8859-1";
        Class224.lIIlllIIIlI[8] = "DES/CBC/PKCS5Padding";
        Class224.lIIlllIIIlI[9] = "DES";
        Class224.lIIlllIIIlI[10] = "在你跟我絮絮叨叨的同时我不想再和残废人墨迹了你懂吗怎么妄自菲薄的零零散散的组合这么垃圾的词汇孩子你不要惹是生非爹爹我打得你低三下四了啊你因为这样你就可以纵横网络了吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003\u2008\u200d\u200c";
        Class224.lIIlllIIIlI[11] = "ISO-8859-1";
        Class224.lIIlllIIIlI[12] = "在你跟我絮絮叨叨的同时我不想再和残废人墨迹了你懂吗怎么妄自菲薄的零零散散的组合这么垃圾的词汇孩子你不要惹是生非爹爹我打得你低三下四了啊你因为这样你就可以纵横网络了吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003\u2008\u200d\u200c";
        Class224.lIIlllIIIlI[13] = " : ";
        Class224.lIIlllIIIlI[14] = " : ";
    }
    
    private static String llIlllIIlIII(final String s, final String s2) {
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
    
    private static String llIlllIIIllI(final String s, final String s2) {
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
    
    private static String llIlllIIIlll(String s, final String s2) {
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
