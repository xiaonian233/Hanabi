package cn.Hanabi.command;

import org.jetbrains.annotations.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Checkuser extends Command
{
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] llIlIIIIII;
    
    public Checkuser() {
        super("checkuser", new String[0]);
    }
    
    @Override
    public final void run(final String s, @NotNull final String[] array) {
        final int[] b = Class139.b();
        final Iterator<Class20> iterator = Class20.userList.iterator();
        final int[] array2 = b;
        while (iterator.hasNext()) {
            final Class20 class20 = iterator.next();
            Class333.tellPlayer(String.valueOf(new StringBuilder("[LOCAL-USER]用户名:").append(class20.username).append(" 游戏名:").append(class20.inGamename).append(" 客户端").append(Class297.getClientName())));
            if (array2 != null) {
                break;
            }
        }
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
    
    static {
        lIIlIlllIlll();
        Class169.a(-8191385379517706784L, 1432819462025818719L, MethodHandles.lookup().lookupClass()).a(158669778012960L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Checkuser.llIlIIIIII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Checkuser.llIlIIIIII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(61652755130042L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = Checkuser.llIlIIIIII[2]).length();
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
                    final String intern = a(instance.doFinal(s3.getBytes(Checkuser.llIlIIIIII[4]))).intern();
                    switch (n7) {
                        default: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Checkuser.llIlIIIIII[3]).length();
                            n4 = 32;
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
        e = new String[4];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x50C4;
        if (Checkuser.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Checkuser.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Checkuser.llIlIIIIII[5]);
                    array[1] = SecretKeyFactory.getInstance(Checkuser.llIlIIIIII[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Checkuser.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Checkuser.llIlIIIIII[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Checkuser.e[n3] = a(((Cipher)array[0]).doFinal(Checkuser.d[n3].getBytes(Checkuser.llIlIIIIII[8])));
        }
        return Checkuser.e[n3];
    }
    
    private static void lIIlIlllIlll() {
        (llIlIIIIII = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Checkuser.llIlIIIIII[1] = "DES";
        Checkuser.llIlIIIIII[2] = "\u001e)\nsNÁº:'>\u009c\u001ed2Ö\u0088X\u0098DZ2ÎõwÞ\u0001\u001er»Â\u00adË :\u000ekÌîg?¤,\u0097Qù\u0005\u0014\u009cýL\u000bÝ\ncÇ°Ë\u0089ZÄ£!\u0083\"©";
        Checkuser.llIlIIIIII[3] = "ì\u0012Lâ>*\u0090-Ãrû\u0002ZwiÝ\u0083u¢\u0093$Ö+\u001dG4É\u000b$\f©û(ÛªÉgeÙ\u001b?âÓ\u0099L\u0010M¨°ðF4íU4ä¤9ùôÑM¼\u009dfÛ¯zîÝ\u0003\u009eF";
        Checkuser.llIlIIIIII[4] = "ISO-8859-1";
        Checkuser.llIlIIIIII[5] = "DES/CBC/PKCS5Padding";
        Checkuser.llIlIIIIII[6] = "DES";
        Checkuser.llIlIIIIII[7] = "你说我死皮赖脸是不是觉得夸大奇词了我可以说你是个废物吗你除了颠倒黑白还会什么自以为是的高傲自大只会被无情的殴打谢绝人世唧唧歪歪结结巴巴的说实话我不太喜欢和游击队员还有滚刀选手对话NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u200d\u200c\u2002";
        Checkuser.llIlIIIIII[8] = "ISO-8859-1";
        Checkuser.llIlIIIIII[9] = "你说我死皮赖脸是不是觉得夸大奇词了我可以说你是个废物吗你除了颠倒黑白还会什么自以为是的高傲自大只会被无情的殴打谢绝人世唧唧歪歪结结巴巴的说实话我不太喜欢和游击队员还有滚刀选手对话NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u200d\u200c\u2002";
        Checkuser.llIlIIIIII[10] = " : ";
        Checkuser.llIlIIIIII[11] = " : ";
    }
    
    private static String lIIlIlllIllI(final String s, final String s2) {
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
    
    private static String lIIlIlllIIll(String s, final String s2) {
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
    
    private static String lIIlIlllIlII(final String s, final String s2) {
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
