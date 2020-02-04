package cn.Hanabi.modules.World;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.network.play.client.*;
import net.minecraft.network.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Regen extends Mod
{
    private Value packet;
    private Class220 delay;
    private Value<Double> regendelay;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llIlIIIlIlI;
    
    public Regen() {
        super("Regen", Category.WORLD);
        this.packet = new Value("Regen_Packets", (T)10.0, (T)1.0, (T)1000.0, 1.0);
        this.delay = new Class220();
        this.regendelay = new Value<Double>("Regen_Delay", 500.0, 0.0, 10000.0, 100.0);
    }
    
    @EventTarget
    private void onMotion$3a3d1cb1() {
        final int[] b = Class139.b();
        float delayComplete;
        final int n = (int)(delayComplete = (this.delay.isDelayComplete((int)(Object)this.regendelay.value) ? 1 : 0));
        if (b == null) {
            if (n == 0) {
                return;
            }
            final boolean state;
            delayComplete = ((state = Class4.getModule("Fly").state) ? 1 : 0);
        }
        Label_0311: {
            Label_0307: {
                if (b == null) {
                    if (n != 0) {
                        break Label_0311;
                    }
                    if (b != null) {
                        break Label_0307;
                    }
                    delayComplete = fcmpl(Regen.mc.field_71439_g.field_70143_R, 2.0f);
                }
                if (delayComplete <= 0) {
                    Label_0297: {
                        if (b == null) {
                            if (Regen.mc.field_71439_g.func_110143_aJ() < Regen.mc.field_71439_g.func_110138_aP()) {
                                if (b != null) {
                                    break Label_0297;
                                }
                                if (Regen.mc.field_71439_g.func_71024_bL().func_75116_a() >= 19) {
                                    if (b == null) {
                                        if (Regen.mc.field_71439_g.field_70122_E) {
                                            int n2 = 0;
                                            while (n2 < (double)this.packet.value) {
                                                Regen regen = this;
                                                Label_0270: {
                                                    if (b == null) {
                                                        if (b != null) {
                                                            return;
                                                        }
                                                        if (Regen.mc.field_71439_g.field_70122_E) {
                                                            Regen.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C03PacketPlayer());
                                                            this.setDisplayName(String.valueOf(new StringBuilder("Health:").append(Regen.mc.field_71439_g.func_110143_aJ())));
                                                            this.delay.lastMs = System.currentTimeMillis();
                                                            if (b == null) {
                                                                break Label_0270;
                                                            }
                                                        }
                                                        regen = this;
                                                    }
                                                    regen.setDisplayName("OtherNoGround");
                                                }
                                                ++n2;
                                                if (b != null) {
                                                    break;
                                                }
                                            }
                                            if (b == null) {
                                                return;
                                            }
                                        }
                                        this.setDisplayName("NoGround");
                                    }
                                    if (b == null) {
                                        return;
                                    }
                                }
                            }
                            this.setDisplayName("MaxHealth");
                        }
                    }
                    if (b == null) {
                        return;
                    }
                }
                this.setDisplayName("Falling");
            }
            if (b == null) {
                return;
            }
        }
        this.setDisplayName("Flying");
    }
    
    static {
        lIIlIIIlIIllI();
        Class169.a(3833317833312417010L, 1012192212064277370L, MethodHandles.lookup().lookupClass()).a(262854687168886L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Regen.llIlIIIlIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Regen.llIlIIIlIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(44050610622824L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[10];
        int n2 = 0;
        String s;
        int n3 = (s = Regen.llIlIIIlIlI[2]).length();
        int n4 = 24;
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
                    final String intern = b(instance.doFinal(s3.getBytes(Regen.llIlIIIlIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Regen.llIlIIIlIlI[3]).length();
                            n4 = 16;
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
        d = new String[10];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x936;
        if (Regen.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Regen.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Regen.llIlIIIlIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(Regen.llIlIIIlIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Regen.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Regen.llIlIIIlIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Regen.d[n3] = b(((Cipher)array[0]).doFinal(Regen.c[n3].getBytes(Regen.llIlIIIlIlI[8])));
        }
        return Regen.d[n3];
    }
    
    private static void lIIlIIIlIIllI() {
        (llIlIIIlIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Regen.llIlIIIlIlI[1] = "DES";
        Regen.llIlIIIlIlI[2] = "\u000f\u009f2¹¨!ÛÀb8ó\u001a'fÇ_\u0003\u0003\"äý\u0096\u0018\u0087\u0010sxÙâä\\ÐÒväó[{ªÝn \u0010\u0099[\u009b\u0088Í >\u0001`ÑO`ñè0\u008f\u0088U$&\u0096ì\r´å`\u0002\u008e\u0099\u001eh\u0010ä\u00ad#UÍÈËt\u0013« 8(]§\u009a\u00186à\u009bsÃR!/sýÔ.ã¾¬âG\u0004×\"ä\u0099½\u008f\u0018}ÎMlÓÜ;é¢p²<º\u000f\u0093\\+/¡\u0096¦\u00180â Ñ\u0084\u0085\u0004rU\u0086\u0016\u008d½\u007f\u0096ÞÞ\u0097ýmpÌPS\u0015)£:Q\u001f\u0093\u0081Þ\u0098ô\u0010 Ê\u0091Ån0*áÞ³vï&Ìúß";
        Regen.llIlIIIlIlI[3] = "®\t\u001d5×V \u009f\"Âtr:ÿ§\u0089\u0010·_\u0082ð\u009aøæÇ\u0084ì*\u009cÔ3#î";
        Regen.llIlIIIlIlI[4] = "ISO-8859-1";
        Regen.llIlIIIlIlI[5] = "DES/CBC/PKCS5Padding";
        Regen.llIlIIIlIlI[6] = "DES";
        Regen.llIlIIIlIlI[7] = "别拿你那无关痛痒的小语言刺激我了用你华丽的言语攻击我啊你没有发现你所说的一切都是一堆废话吗你觉得你还有什么呢你为什么总是这么傻NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u2002\u200d\u200f";
        Regen.llIlIIIlIlI[8] = "ISO-8859-1";
        Regen.llIlIIIlIlI[9] = "别拿你那无关痛痒的小语言刺激我了用你华丽的言语攻击我啊你没有发现你所说的一切都是一堆废话吗你觉得你还有什么呢你为什么总是这么傻NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u2002\u200d\u200f";
        Regen.llIlIIIlIlI[10] = " : ";
        Regen.llIlIIIlIlI[11] = " : ";
    }
    
    private static String lIIlIIIlIIlII(final String s, final String s2) {
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
    
    private static String lIIlIIIlIIIll(final String s, final String s2) {
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
    
    private static String lIIlIIIlIIIIl(String s, final String s2) {
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
    
    private static boolean lIIlIIlIIIIIl$255f299(final int n) {
        return n >= 19;
    }
    
    private static boolean lIIlIIlIIIIII(final int n) {
        return n < 0;
    }
    
    private static boolean lIIlIIIlllllI(final int n) {
        return n <= 0;
    }
    
    private static int lIIlIIIlllIII$2548a28(final float n) {
        return fcmpl(n, 2.0f);
    }
    
    private static int lIIlIIIlllIIl(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIIlIIIlllIlI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
