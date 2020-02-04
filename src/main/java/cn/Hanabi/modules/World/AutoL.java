package cn.Hanabi.modules.World;

import cn.Hanabi.value.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class AutoL extends Mod
{
    private static Class220 LTimer;
    public static Value<Boolean> ad;
    public static Value<Boolean> wdr;
    public static Value<Boolean> abuse;
    public static List<String> wdred;
    private static List<EntityPlayer> power;
    public static Value<String> mode;
    private static Class313 baizhijun;
    private static Class313 fanyangxiao;
    private static Class313 lilejie;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llllIll;
    
    public AutoL() {
        super("AutoL", Category.WORLD);
        AutoL.mode.addValue("Chinese");
        AutoL.mode.addValue("English");
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        Label_0029: {
            final int[] b;
            if ((b = Class139.b()) == null) {
                if (!AutoL.mode.isCurrentMode("Chinese")) {
                    break Label_0029;
                }
                this.setDisplayName("Chinese");
            }
            if (b == null) {
                return;
            }
        }
        this.setDisplayName("English");
    }
    
    public static String getSB() {
        final int[] b = Class139.b();
        final int nextInt = new Random().nextInt(3);
        final int[] array = b;
        int n2;
        final int n = n2 = nextInt;
        if (array == null) {
            if (n == 0) {
                return AutoL.baizhijun.getSB();
            }
            final int n3;
            n2 = (n3 = nextInt);
        }
        int n5;
        final int n4 = n5 = 1;
        if (array == null) {
            if (n == n4) {
                return AutoL.fanyangxiao.getSB();
            }
            n2 = nextInt;
            n5 = 2;
        }
        if (n2 == n5) {
            return AutoL.lilejie.getSB();
        }
        return AutoL.baizhijun.getSB();
    }
    
    static {
        lIlIIlIll();
        Class169.a(-3028806684360105499L, 5173354253660538243L, MethodHandles.lookup().lookupClass()).a(23902830048922L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(AutoL.llllIll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(AutoL.llllIll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(60467446433533L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[22];
        int n2 = 0;
        final String s = "T\u0019\u008a'ÿÈ\u0096\u0080:i?\u001c¬ß¬?1áe5×ÂXß`\u0091\u0089\u00adßÿàè  '5Ë¨ú>\\¥GoT$à\\hn\u001c£*WçZDþË\u007f^V_\u000e! öMT\b\u0013¿îÛâ\u0088b\u0004\u001d\u0014\u0093×\u0092\u0010ÉZ\u0013\u0093î£±\u0084ÊAðtLõ\u0010ÎFð§¡?\u000f\u008cû*g\u0015Øo\u0015²(\u0016\u0086fUåRþêÙG5\u009a¬ÿWîê\u0013â\u0085)rÃVDÿ\u0099Ó\f\u0085Ù-\u008fûüþ\u0093ËÇg »\u008dÛKÎ\u0091ÿEsK%\u0019E\u000fGt\bÅ%\u0003ÐÆz[É\u0015F\u0092y§¸\u0089 -,û\u0092\u00067e$Ò\\\u0093¸\u009dkú]©³±\u009d©\u008c\u0083\u0096¹\u0095\u00adWä§Ù\u0007 \u0081ÜÆXÅ½ÝH^Á²\u0097öûô\u001dÅ\u008f¥e\u0092¶®Z¶·Y b;TÌ Ìù²\u0082ñ D\u0098Ëý5>Z\u000e\u0013\u0006Ay8\u0097 ¡'û(¨ã\u0094ãÝ\u009c&\u0010íËU\u0004§\u0081\u0091b·\u0084oàpä)ø\u0018\u0085\u0086ÓÓ\u0089\\è\u0010iS\u008d\r¹\u0089È92Ê\f¾\u001eL´å\u0018±3µ:\u00894¥0(´+Ê¢\u001e=9aO;qÏ¹eG\u0018g¹\u001fÒR\u008bR\u0018×\u0004\u0081¡\u008f\u0094ó*g\u0097þ\u009fû\u007f1V \u0092\u0012xðþ\u008f\u0081ÐÒ\u009a\tàqüÞ©\u008a½ßîÀG»Ð\b\u009a}?\u0085\u00101\u0003\u0010U\u0097\u0086\n-\u009fã#\u0007*\u0003ó?\u000eöù EÎG\u0002\\X\u00ad\u0088\u0097\u008d*6/\u008cZ\u0014@F\u001e\u008dUFWhÃÚ¡\u009aöô\u0011ï $Á°N1\u008e-r\u001dê9çm\u0002RÉäVÓfsx7wÞ\u0082Rfý\u0088)\u0089\u0010½ã\u0083t£ÑÚ\u0082\t\bb¤ÿõyì\u0018u¿\u0098¥;Ö\u0005%%¯4\u001bh®Q1JÒ\ryÐZò±\u0010Ô²B\u0091ûj £\u0082\tÕl¡îr\u0083";
        String s2 = "T\u0019\u008a'ÿÈ\u0096\u0080:i?\u001c¬ß¬?1áe5×ÂXß`\u0091\u0089\u00adßÿàè  '5Ë¨ú>\\¥GoT$à\\hn\u001c£*WçZDþË\u007f^V_\u000e! öMT\b\u0013¿îÛâ\u0088b\u0004\u001d\u0014\u0093×\u0092\u0010ÉZ\u0013\u0093î£±\u0084ÊAðtLõ\u0010ÎFð§¡?\u000f\u008cû*g\u0015Øo\u0015²(\u0016\u0086fUåRþêÙG5\u009a¬ÿWîê\u0013â\u0085)rÃVDÿ\u0099Ó\f\u0085Ù-\u008fûüþ\u0093ËÇg »\u008dÛKÎ\u0091ÿEsK%\u0019E\u000fGt\bÅ%\u0003ÐÆz[É\u0015F\u0092y§¸\u0089 -,û\u0092\u00067e$Ò\\\u0093¸\u009dkú]©³±\u009d©\u008c\u0083\u0096¹\u0095\u00adWä§Ù\u0007 \u0081ÜÆXÅ½ÝH^Á²\u0097öûô\u001dÅ\u008f¥e\u0092¶®Z¶·Y b;TÌ Ìù²\u0082ñ D\u0098Ëý5>Z\u000e\u0013\u0006Ay8\u0097 ¡'û(¨ã\u0094ãÝ\u009c&\u0010íËU\u0004§\u0081\u0091b·\u0084oàpä)ø\u0018\u0085\u0086ÓÓ\u0089\\è\u0010iS\u008d\r¹\u0089È92Ê\f¾\u001eL´å\u0018±3µ:\u00894¥0(´+Ê¢\u001e=9aO;qÏ¹eG\u0018g¹\u001fÒR\u008bR\u0018×\u0004\u0081¡\u008f\u0094ó*g\u0097þ\u009fû\u007f1V \u0092\u0012xðþ\u008f\u0081ÐÒ\u009a\tàqüÞ©\u008a½ßîÀG»Ð\b\u009a}?\u0085\u00101\u0003\u0010U\u0097\u0086\n-\u009fã#\u0007*\u0003ó?\u000eöù EÎG\u0002\\X\u00ad\u0088\u0097\u008d*6/\u008cZ\u0014@F\u001e\u008dUFWhÃÚ¡\u009aöô\u0011ï $Á°N1\u008e-r\u001dê9çm\u0002RÉäVÓfsx7wÞ\u0082Rfý\u0088)\u0089\u0010½ã\u0083t£ÑÚ\u0082\t\bb¤ÿõyì\u0018u¿\u0098¥;Ö\u0005%%¯4\u001bh®Q1JÒ\ryÐZò±\u0010Ô²B\u0091ûj £\u0082\tÕl¡îr\u0083";
        int n3 = s.length();
        int n4 = 32;
        int n5 = -1;
    Label_0147:
        while (true) {
            while (true) {
                ++n5;
                final String s3 = s2;
                final int n6 = n5;
                String s4 = s3.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s4.getBytes(AutoL.llllIll[3]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                continue Label_0147;
                            }
                            n3 = (s2 = AutoL.llllIll[2]).length();
                            n4 = 32;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                break;
                            }
                            break Label_0147;
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
        c = c2;
        d = new String[22];
        new Class220();
        AutoL.ad = new Value<Boolean>("AutoL_AD", Boolean.TRUE);
        AutoL.wdr = new Value<Boolean>("AutoL_WatchdogReport", Boolean.TRUE);
        AutoL.abuse = new Value<Boolean>("AutoL_Abuse", Boolean.FALSE);
        AutoL.wdred = new ArrayList<String>();
        new ArrayList();
        AutoL.mode = new Value<String>("AutoL", "AbuseMode", 1);
        AutoL.baizhijun = new Class313("李佳乐", "13795649783", "陈高影", "山东");
        AutoL.fanyangxiao = new Class313("陈高影李+-乐", "15953638524", "没有爸妈", "山东");
        AutoL.lilejie = new Class313("李+乐", "13546806422", "陈高影", "山东");
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static String b(final byte[] array) {
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
    
    private static String b(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x18C8;
        if (AutoL.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = AutoL.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(AutoL.llllIll[4]);
                    array[1] = SecretKeyFactory.getInstance(AutoL.llllIll[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    AutoL.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(AutoL.llllIll[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            AutoL.d[n3] = b(((Cipher)array[0]).doFinal(AutoL.c[n3].getBytes(AutoL.llllIll[7])));
        }
        return AutoL.d[n3];
    }
    
    private static void lIlIIlIll() {
        (llllIll = new String[11])[0] = "DES/CBC/PKCS5Padding";
        AutoL.llllIll[1] = "DES";
        AutoL.llllIll[2] = "\u0010²¼\u001eð\u009dÃ;@ô \u0018\t\u0085\u009dÓ\"tÛ\u0098-´Ñ\u0089²ëÈ'¦¦¾ð\u0010Ó$ô*©^kó\u0086\u0001¦\u0095FÛÉ+";
        AutoL.llllIll[3] = "ISO-8859-1";
        AutoL.llllIll[4] = "DES/CBC/PKCS5Padding";
        AutoL.llllIll[5] = "DES";
        AutoL.llllIll[6] = "还耀武扬威的啊你到底有多少本事能反抗我的攻击不要在那里说什么我装B你是不是在想怎么回答我你的心是否正在狂速的跳动NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u200b\u200e\u2006";
        AutoL.llllIll[7] = "ISO-8859-1";
        AutoL.llllIll[8] = "还耀武扬威的啊你到底有多少本事能反抗我的攻击不要在那里说什么我装B你是不是在想怎么回答我你的心是否正在狂速的跳动NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u200b\u200e\u2006";
        AutoL.llllIll[9] = " : ";
        AutoL.llllIll[10] = " : ";
    }
    
    private static String lIlIIIlll(final String s, final String s2) {
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
    
    private static String lIlIIIlII(String s, final String s2) {
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
    
    private static String lIlIIIlIl(final String s, final String s2) {
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
