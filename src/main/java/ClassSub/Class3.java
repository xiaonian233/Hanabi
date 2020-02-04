package ClassSub;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class3 extends Mod
{
    public static final Class261 clickGui;
    private ScaledResolution sr;
    public static Value<String> theme;
    private int lastWidth;
    private static Class261 hanabi;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIIlIlll;
    
    public Class3() {
        super("ClickGUI", Category.RENDER, true, true, 54);
        this.lastWidth = 0;
        Class3.theme.addValue("Dark");
        Class3.theme.addValue("Light");
        this.setState(false);
    }
    
    @Override
    public final void onEnable() {
        final int[] b;
        if ((b = Class139.b()) == null) {
            if (Class3.mc.field_71439_g == null) {
                return;
            }
            this.sr = new ScaledResolution(Minecraft.func_71410_x());
        }
        final Class261 hanabi = Class3.hanabi;
        final Minecraft mc;
        Label_0114: {
            final int lastWidth;
            Label_0102: {
                Label_0089: {
                    if (b == null) {
                        if (hanabi != null) {
                            lastWidth = this.lastWidth;
                            if (b != null) {
                                break Label_0102;
                            }
                            if (lastWidth == this.sr.func_78326_a()) {
                                break Label_0089;
                            }
                        }
                        this.lastWidth = this.sr.func_78326_a();
                        final Class261 class261 = new Class261();
                    }
                    Class3.hanabi = hanabi;
                }
                mc = Class3.mc;
                if (b != null) {
                    break Label_0114;
                }
                final boolean b2 = mc.field_71462_r instanceof Class261;
            }
            if (lastWidth != 0) {
                this.setState(false);
                return;
            }
            final Minecraft mc2 = Class3.mc;
        }
        mc.func_147108_a((GuiScreen)Class3.hanabi);
        this.setState(false);
    }
    
    static {
        llIIIIllI();
        Class169.a(7536174695155785420L, 2754625594994648181L, MethodHandles.lookup().lookupClass()).a(261877727264148L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class3.lIIlIlll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class3.lIIlIlll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(26117114296320L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class3.lIIlIlll[2]).length();
        int n4 = 16;
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
                    final String intern = b(instance.doFinal(s3.getBytes(Class3.lIIlIlll[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Class3.lIIlIlll[3]).length();
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
        clickGui = new Class261();
        Class3.theme = new Value<String>("ClickGUI", "Theme", 0);
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x26B8;
        if (Class3.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class3.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class3.lIIlIlll[5]);
                    array[1] = SecretKeyFactory.getInstance(Class3.lIIlIlll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class3.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class3.lIIlIlll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class3.d[n3] = b(((Cipher)array[0]).doFinal(Class3.c[n3].getBytes(Class3.lIIlIlll[8])));
        }
        return Class3.d[n3];
    }
    
    private static void llIIIIllI() {
        (lIIlIlll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class3.lIIlIlll[1] = "DES";
        Class3.lIIlIlll[2] = "ÒH!b¥Ä¼\u0092T=RC¥\u0011Ïj Hö'Çé\u0094õ#ýüÐ7å\u0016¬ðh\u009d[\u008b\u000b]ø\u001c-Ëà\u0003C¯´Î\u0010\u008cNH\u007f.\u0014|µ7\u0096JÞÌ¿|ú";
        Class3.lIIlIlll[3] = "\u0017\u001a\fÙþm\u0013@p\u008f°\u00020\u001bÚºÚIÔki¹ñCØ&'\u0087?løR\u0010\u0084\u0089á\u0094\u0082m\u0019\u0091öuµtkg+\u0016";
        Class3.lIIlIlll[4] = "ISO-8859-1";
        Class3.lIIlIlll[5] = "DES/CBC/PKCS5Padding";
        Class3.lIIlIlll[6] = "DES";
        Class3.lIIlIlll[7] = "孩子不要怄气现实不得不接受你这样的窝囊废注定不适合我一个档次你为什么有时候最基本的词汇也忘的一干二净呢你不觉得太没杀伤力了吗你现在所有的话都是胡言乱语躲躲闪闪气急败坏我自己所谓的那华丽的语言呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u2003\u200e\u2004";
        Class3.lIIlIlll[8] = "ISO-8859-1";
        Class3.lIIlIlll[9] = "孩子不要怄气现实不得不接受你这样的窝囊废注定不适合我一个档次你为什么有时候最基本的词汇也忘的一干二净呢你不觉得太没杀伤力了吗你现在所有的话都是胡言乱语躲躲闪闪气急败坏我自己所谓的那华丽的语言呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u2003\u200e\u2004";
        Class3.lIIlIlll[10] = " : ";
        Class3.lIIlIlll[11] = " : ";
    }
    
    private static String llIIIIIll(String s, final String s2) {
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
    
    private static String llIIIIlII(final String s, final String s2) {
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
    
    private static String llIIIIlIl(final String s, final String s2) {
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
    
    private static boolean lIIlIlIlll(final int n, final int n2) {
        return n != n2;
    }
}
