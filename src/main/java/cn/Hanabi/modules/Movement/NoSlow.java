package cn.Hanabi.modules.Movement;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Combat.*;
import net.minecraft.util.*;
import net.minecraft.network.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.network.play.client.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public class NoSlow extends Mod
{
    private Value<String> mode;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIIllllIIIl;
    
    public NoSlow() {
        super("NoSlow", Category.MOVEMENT);
        (this.mode = new Value<String>("NoSlow", "Mode", 0)).addValue("Vanilla");
        this.mode.addValue("NCP");
        this.mode.addValue("AAC");
    }
    
    @EventTarget
    private void onPre$3a3d1cb1() {
        final int[] b = Class139.b();
        final boolean func_71039_bw;
        final boolean b2 = func_71039_bw = NoSlow.mc.field_71439_g.func_71039_bw();
        final boolean moving;
        Label_0164: {
            if (b == null) {
                Label_0155: {
                    if (b2) {
                        moving = Class333.isMoving();
                        if (b != null) {
                            break Label_0164;
                        }
                        if (moving) {
                            final boolean onGround = Class33.isOnGround(0.42);
                            if (b != null) {
                                break Label_0164;
                            }
                            if (onGround && KillAura.target == null) {
                                final boolean currentMode = this.mode.isCurrentMode("AAC");
                                if (b == null) {
                                    if (!currentMode) {
                                        final boolean currentMode2 = this.mode.isCurrentMode("NCP");
                                        if (b != null) {
                                            break Label_0164;
                                        }
                                        if (!currentMode2) {
                                            break Label_0155;
                                        }
                                    }
                                    this.mode.isCurrentMode("AAC");
                                }
                                if (currentMode) {
                                    Class94.getTimer();
                                }
                                final double field_70165_t = NoSlow.mc.field_71439_g.field_70165_t;
                                final double field_70163_u = NoSlow.mc.field_71439_g.field_70163_u;
                                final double field_70161_v = NoSlow.mc.field_71439_g.field_70161_v;
                                NoSlow.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging$Action.RELEASE_USE_ITEM, BlockPos.field_177992_a, EnumFacing.DOWN));
                            }
                        }
                    }
                }
                NoSlow.mc.field_71439_g.func_71039_bw();
            }
        }
        if (b == null) {
            if (b2) {
                return;
            }
            this.mode.isCurrentMode("AAC");
        }
        if (moving) {
            Class94.getTimer();
        }
    }
    
    @EventTarget
    private void onPost$457908ce() {
        final int[] b = Class139.b();
        boolean b3;
        final boolean b2 = b3 = NoSlow.mc.field_71439_g.func_71039_bw();
        if (b == null) {
            if (!b2) {
                return;
            }
            final boolean moving;
            b3 = (moving = Class333.isMoving());
        }
        if (b == null) {
            if (!b2) {
                return;
            }
            b3 = Class33.isOnGround(0.42);
        }
        if (b3 && KillAura.target == null) {
            final boolean currentMode = this.mode.isCurrentMode("AAC");
            Label_0073: {
                if (b == null) {
                    if (currentMode) {
                        break Label_0073;
                    }
                    this.mode.isCurrentMode("NCP");
                }
                if (!currentMode) {
                    return;
                }
            }
            final double field_70165_t = NoSlow.mc.field_71439_g.field_70165_t;
            final double field_70163_u = NoSlow.mc.field_71439_g.field_70163_u;
            final double field_70161_v = NoSlow.mc.field_71439_g.field_70161_v;
            NoSlow.mc.field_71439_g.field_71174_a.func_147297_a((Packet)new C08PacketPlayerBlockPlacement(NoSlow.mc.field_71439_g.field_71071_by.func_70448_g()));
        }
    }
    
    static {
        llIllllIlllI();
        Class169.a(1459712499927132044L, 2570820857682014050L, MethodHandles.lookup().lookupClass()).a(45969409572078L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(NoSlow.lIIllllIIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(NoSlow.lIIllllIIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(134162436559894L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[8];
        int n2 = 0;
        String s;
        int n3 = (s = NoSlow.lIIllllIIIl[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(NoSlow.lIIllllIIIl[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = NoSlow.lIIllllIIIl[3]).length();
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
        d = new String[8];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x34D9;
        if (NoSlow.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = NoSlow.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(NoSlow.lIIllllIIIl[5]);
                    array[1] = SecretKeyFactory.getInstance(NoSlow.lIIllllIIIl[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    NoSlow.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(NoSlow.lIIllllIIIl[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            NoSlow.d[n3] = b(((Cipher)array[0]).doFinal(NoSlow.c[n3].getBytes(NoSlow.lIIllllIIIl[8])));
        }
        return NoSlow.d[n3];
    }
    
    private static void llIllllIlllI() {
        (lIIllllIIIl = new String[12])[0] = "DES/CBC/PKCS5Padding";
        NoSlow.lIIllllIIIl[1] = "DES";
        NoSlow.lIIllllIIIl[2] = "M\u009f°ï¤%¡¿!óB^F6<«\u0010xg\u001e\u0091\u0001-\u008d\u0090\n¤OL?!\u0015|\u0010ãúDõ¦|\u008cüýõv´\u0093À &\u0010°3®\u008fø>Ëßxhoz\u0001ÿ¢/\u0010Yo®\u008fÝÙ\u000bXÝ\u0018íÇ*¶\u0085Z\u0010§óülúãÊÉ?íî\u0096¯ü\u008eõ";
        NoSlow.lIIllllIIIl[3] = "-\u0099@±æ\u0082åþ×\u0007o\u008a/\u008f\u0086\u0082\u0010\u0085y\u008b\u001fN\u001aA£¹cMÄ\u007fÏd>";
        NoSlow.lIIllllIIIl[4] = "ISO-8859-1";
        NoSlow.lIIllllIIIl[5] = "DES/CBC/PKCS5Padding";
        NoSlow.lIIllllIIIl[6] = "DES";
        NoSlow.lIIllllIIIl[7] = "你还不快滚蛋吗为何现在支支吾吾躲躲闪闪的逃避你被打的事实如果你真的回答我是你是不是在想怎么回答我你说话好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a \u2003\u200b";
        NoSlow.lIIllllIIIl[8] = "ISO-8859-1";
        NoSlow.lIIllllIIIl[9] = "你还不快滚蛋吗为何现在支支吾吾躲躲闪闪的逃避你被打的事实如果你真的回答我是你是不是在想怎么回答我你说话好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200a \u2003\u200b";
        NoSlow.lIIllllIIIl[10] = " : ";
        NoSlow.lIIllllIIIl[11] = " : ";
    }
    
    private static String llIllllIlIll(String s, final String s2) {
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
    
    private static String llIllllIllIl(final String s, final String s2) {
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
    
    private static String llIllllIllII(final String s, final String s2) {
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
