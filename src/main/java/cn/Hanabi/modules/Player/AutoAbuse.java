package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import java.io.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class AutoAbuse extends Mod
{
    public static String prefix;
    private Class220 delay;
    private double state;
    private Value<Double> spammerdelay;
    private int num;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIIllIlI;
    
    public AutoAbuse() {
        super("AutoAbuse", Category.PLAYER);
        this.delay = new Class220();
        this.state = 0.0;
        this.spammerdelay = new Value<Double>("AutoAbuse_Delay", 2000.0, 500.0, 10000.0, 100.0);
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        this.setDisplayName(String.valueOf(new StringBuilder("Delay:").append((double)this.spammerdelay.value).append(" Times:").append(this.num)));
        final int[] array = b;
        try {
            Class248.loadText();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        final Class220 delay = this.delay;
        if (array == null) {
            if (!delay.isDelayComplete((long)(Object)this.spammerdelay.value)) {
                return;
            }
            ++this.state;
            ++this.num;
            AutoAbuse.mc.field_71439_g.func_71165_d(String.valueOf(new StringBuilder("[Hanabi]").append(Class203.getAbuse())));
            final Class220 delay2 = this.delay;
        }
        delay.lastMs = System.currentTimeMillis();
    }
    
    @Override
    public final void onDisable() {
        this.num = 0;
        this.state = 0.0;
        super.onDisable();
    }
    
    static {
        llIIllIIl();
        Class169.a(-6761474812376321799L, 6093605879693395141L, MethodHandles.lookup().lookupClass()).a(213074769255490L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(AutoAbuse.lIIllIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(AutoAbuse.lIIllIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(4925034695720L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = AutoAbuse.lIIllIlI[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(AutoAbuse.lIIllIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = AutoAbuse.lIIllIlI[3]).length();
                            n4 = 32;
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
        AutoAbuse.prefix = "[Hanabi]";
    }
    
    private static IOException a(final IOException ex) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x3809;
        if (AutoAbuse.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = AutoAbuse.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(AutoAbuse.lIIllIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(AutoAbuse.lIIllIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    AutoAbuse.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(AutoAbuse.lIIllIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            AutoAbuse.d[n3] = b(((Cipher)array[0]).doFinal(AutoAbuse.c[n3].getBytes(AutoAbuse.lIIllIlI[8])));
        }
        return AutoAbuse.d[n3];
    }
    
    private static void llIIllIIl() {
        (lIIllIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        AutoAbuse.lIIllIlI[1] = "DES";
        AutoAbuse.lIIllIlI[2] = "íÞËæpQ\u0007ñR\u0013½\u0081§ç\u0004'\u0083]\u008bù4\u0094ª\u0096Áørv\u000b4\u008bV\u0018\u0098\t\u009bä¨ø¦¨Qm¸¼Ü\u0005ö³ÆìÐÈ}v\u0084=\u0010Ö,ß\u0002¤ZO\u0088{Ò<(¬G-Â";
        AutoAbuse.lIIllIlI[3] = "ëy\u001dª5ÖxS\tð¸iÙl7n% \u0098\u001b¢\tW\u0019\u0015\u0098þ8o®\u0016®\u0010Ñ¹\u0081$,~·rÎJ¶\u001c\u0095âb\u0099";
        AutoAbuse.lIIllIlI[4] = "ISO-8859-1";
        AutoAbuse.lIIllIlI[5] = "DES/CBC/PKCS5Padding";
        AutoAbuse.lIIllIlI[6] = "DES";
        AutoAbuse.lIIllIlI[7] = "你不配合我也没辙你一直以为怎么开始嘻嘻哈哈现在杀了我似的对我充满仇恨因为我在你眼里的形象太巨大了你让我看不起你啊扣字很快了不起了死不要脸的复制粘贴就以为天下无敌了是不是你这个摆弄是非的东西NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200d \u200b ";
        AutoAbuse.lIIllIlI[8] = "ISO-8859-1";
        AutoAbuse.lIIllIlI[9] = "你不配合我也没辙你一直以为怎么开始嘻嘻哈哈现在杀了我似的对我充满仇恨因为我在你眼里的形象太巨大了你让我看不起你啊扣字很快了不起了死不要脸的复制粘贴就以为天下无敌了是不是你这个摆弄是非的东西NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200d \u200b ";
        AutoAbuse.lIIllIlI[10] = " : ";
        AutoAbuse.lIIllIlI[11] = " : ";
    }
    
    private static String llIIlIlIl(String s, final String s2) {
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
    
    private static String llIIlIlII(final String s, final String s2) {
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
    
    private static String llIIlIllI(final String s, final String s2) {
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
