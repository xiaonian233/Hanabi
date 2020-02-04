package cn.Hanabi.modules.World;

import net.minecraft.util.*;
import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.block.*;
import cn.Hanabi.events.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class AntiFall extends Mod
{
    private BlockPos lastGroundPos;
    private Class220 timer;
    private Class220 timer2;
    private Class220 spacetimer;
    private Value<Double> falldistance;
    private Value<Boolean> onlyvoid;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lllllllII;
    
    public AntiFall() {
        super("AntiFall", Category.WORLD);
        this.timer = new Class220();
        new Class220();
        this.spacetimer = new Class220();
        this.falldistance = new Value<Double>("AntiFall_FallDistance", 10.0, 5.0, 30.0, 0.1);
        this.onlyvoid = new Value<Boolean>("AntiFall_OnlyVoid", Boolean.TRUE);
    }
    
    @EventTarget
    private void onKey(final EventKey eventKey) {
        if (eventKey.key == 57) {
            this.spacetimer.lastMs = System.currentTimeMillis();
        }
    }
    
    private static boolean isBlockUnder() {
        final int[] b = Class139.b();
        int i = (int)(AntiFall.mc.field_71439_g.field_70163_u - 1.0);
        final int[] array = b;
        while (i > 0) {
            final boolean b3;
            final boolean b2 = b3 = (AntiFall.mc.field_71441_e.func_180495_p(new BlockPos(AntiFall.mc.field_71439_g.field_70165_t, (double)i, AntiFall.mc.field_71439_g.field_70161_v)).func_177230_c() instanceof BlockAir);
            if (array != null) {
                return b3;
            }
            if (array != null || (!b2 || array != null)) {
                return b2;
            }
            --i;
            if (array != null) {
                break;
            }
        }
        return false;
    }
    
    @EventTarget
    private void onUpdate(final EventPreMotion eventPreMotion) {
        final int[] b = Class139.b();
        boolean b2 = true;
        final int[] array = b;
        boolean b3;
        boolean delayComplete;
        int n2;
        final int n = n2 = ((delayComplete = (b3 = dcmpl((double)AntiFall.mc.field_71439_g.field_70143_R, (double)this.falldistance.value))) ? 1 : 0);
        Label_0195: {
            if (array == null) {
                Label_0186: {
                    if (n > 0) {
                        final boolean booleanValue = this.onlyvoid.value;
                        if (array == null && booleanValue) {
                            final int[] b4 = Class139.b();
                            int i = (int)(AntiFall.mc.field_71439_g.field_70163_u - 1.0);
                            final int[] array2 = b4;
                            while (true) {
                                while (i > 0) {
                                    final boolean b5;
                                    final int n3 = (b5 = ((n2 = ((delayComplete = (b3 = (AntiFall.mc.field_71441_e.func_180495_p(new BlockPos(AntiFall.mc.field_71439_g.field_70165_t, (double)i, AntiFall.mc.field_71439_g.field_70161_v)).func_177230_c() instanceof BlockAir))) ? 1 : 0)) != 0)) ? 1 : 0;
                                    if (array2 == null) {
                                        if (array2 == null) {
                                            if (n3 == 0 || array2 != null) {
                                                n2 = ((delayComplete = (b3 = true)) ? 1 : 0);
                                            }
                                            else {
                                                --i;
                                                if (array2 != null) {
                                                    break;
                                                }
                                                continue;
                                            }
                                        }
                                    }
                                    if (array != null) {
                                        break Label_0195;
                                    }
                                    if (n3 == 0) {
                                        goto Label_0184;
                                    }
                                    break Label_0186;
                                }
                                n2 = ((delayComplete = (b3 = false)) ? 1 : 0);
                                continue;
                            }
                        }
                        b2 = booleanValue;
                    }
                }
                boolean b5;
                n2 = ((b5 = (delayComplete = (b3 = AntiFall.mc.field_71439_g.field_70122_E))) ? 1 : 0);
            }
        }
        Label_0243: {
            if (array == null) {
                if (n != 0) {
                    final boolean b6 = (n2 = ((delayComplete = (b3 = this.timer.isDelayComplete(1000L))) ? 1 : 0)) != 0;
                    if (array != null) {
                        break Label_0243;
                    }
                    if (b6) {
                        this.lastGroundPos = AntiFall.mc.field_71439_g.func_180425_c();
                        this.timer.lastMs = System.currentTimeMillis();
                    }
                }
                delayComplete = ((n2 = ((b3 = b2) ? 1 : 0)) != 0);
            }
        }
        if (array == null) {
            if (n2 != 0) {
                return;
            }
            b3 = (delayComplete = this.spacetimer.isDelayComplete(800L));
        }
        if (array == null) {
            if (!delayComplete) {
                return;
            }
            b3 = Class4.getModule("Fly").state;
        }
        if (!b3) {
            eventPreMotion.x = this.lastGroundPos.func_177958_n();
            eventPreMotion.y = this.lastGroundPos.func_177956_o();
            eventPreMotion.z = this.lastGroundPos.func_177952_p();
        }
    }
    
    static {
        lIllIllIllI();
        Class169.a(1690386468145796525L, 737462210101381672L, MethodHandles.lookup().lookupClass()).a(264415273924914L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(AntiFall.lllllllII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(AntiFall.lllllllII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(33370587274937L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = AntiFall.lllllllII[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(AntiFall.lllllllII[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = AntiFall.lllllllII[3]).length();
                            n4 = 40;
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
        d = new String[4];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x68AD;
        if (AntiFall.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = AntiFall.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(AntiFall.lllllllII[5]);
                    array[1] = SecretKeyFactory.getInstance(AntiFall.lllllllII[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    AntiFall.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(AntiFall.lllllllII[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            AntiFall.d[n3] = b(((Cipher)array[0]).doFinal(AntiFall.c[n3].getBytes(AntiFall.lllllllII[8])));
        }
        return AntiFall.d[n3];
    }
    
    private static void lIllIllIllI() {
        (lllllllII = new String[12])[0] = "DES/CBC/PKCS5Padding";
        AntiFall.lllllllII[1] = "DES";
        AntiFall.lllllllII[2] = "YÑzlµJ6\u0088É\u0084:íiÙq\u0001\u0018\u001a³ ï¹±3\u0081\u0081N\u009d2ã\u008c\u009dU ¥P\u0083[T\u0091Ë";
        AntiFall.lllllllII[3] = "r\u009cMfwO©:\u001dewP9ÙîSf)\u008dd0!\u000bÏêg\u0019ìÈ®kòµ\u0089\u00ad\u0090\f-Ö\u009b(×\u000f\u0082¤g_ü\u0011í^×\u0089j¯Ñ@Wíg\u009a\u001bH\u001dÎºhÃ\u0006PJ²F\u000b\rI\u00862Þ\u0084U";
        AntiFall.lllllllII[4] = "ISO-8859-1";
        AntiFall.lllllllII[5] = "DES/CBC/PKCS5Padding";
        AntiFall.lllllllII[6] = "DES";
        AntiFall.lllllllII[7] = "还继续在我这丢脸吗不要义无返顾地的说要跟我作战了好吗不是你大哥我夸你怎么什么都不懂啊我看了你那错落有秩的词NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u2009\u2008\u2005";
        AntiFall.lllllllII[8] = "ISO-8859-1";
        AntiFall.lllllllII[9] = "还继续在我这丢脸吗不要义无返顾地的说要跟我作战了好吗不是你大哥我夸你怎么什么都不懂啊我看了你那错落有秩的词NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u2009\u2008\u2005";
        AntiFall.lllllllII[10] = " : ";
        AntiFall.lllllllII[11] = " : ";
    }
    
    private static String lIllIllIIll(final String s, final String s2) {
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
    
    private static String lIllIllIlIl(String s, final String s2) {
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
    
    private static String lIllIllIlII(final String s, final String s2) {
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
    
    private static boolean lIllIlllIII(final int n) {
        return n > 0;
    }
    
    private static int lIllIllllII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
}
