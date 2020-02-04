package cn.Hanabi.modules.Movement;

import cn.Hanabi.value.*;
import java.util.concurrent.*;
import net.minecraft.network.play.client.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.network.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.client.entity.*;
import net.minecraft.world.*;
import net.minecraft.entity.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class FakeLag extends Mod
{
    private Value<Double> lagValue;
    private CopyOnWriteArrayList<C03PacketPlayer> packetList;
    private Class220 lagHelper;
    private C03PacketPlayer lastPacket;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIllIIIlll;
    
    public FakeLag() {
        super("FakeLag", Category.MOVEMENT);
        this.lagValue = new Value<Double>("FakeLag_Delay", 3000.0, 300.0, 5000.0);
        this.packetList = new CopyOnWriteArrayList<C03PacketPlayer>();
        this.lagHelper = new Class220();
    }
    
    @EventTarget
    private void onPacket(final EventPacket eventPacket) {
        final int[] b = Class139.b();
        final Packet packet = eventPacket.packet;
        final int[] array = b;
        final Packet packet2 = packet;
        if (array != null || packet2 instanceof C03PacketPlayer) {
            final C03PacketPlayer c03PacketPlayer = (C03PacketPlayer)packet2;
            final boolean contains = this.packetList.contains(c03PacketPlayer);
            if (array == null) {
                if (contains) {
                    this.packetList.remove(c03PacketPlayer);
                    if (array == null) {
                        return;
                    }
                }
                this.packetList.add(c03PacketPlayer);
            }
            eventPacket.setCancelled$1385ff();
        }
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        if (this.lagHelper.isDelayComplete(this.lagValue.value)) {
            final Entity func_73045_a = FakeLag.mc.field_71441_e.func_73045_a(-1);
            if (b == null) {
                if (func_73045_a != null) {
                    FakeLag.mc.field_71441_e.func_73028_b(-1);
                }
            }
        Label_0241_Outer:
            while (true) {
                while (true) {
                    for (final C03PacketPlayer lastPacket : this.packetList) {
                        FakeLag.mc.field_71439_g.field_71174_a.func_147297_a((Packet)lastPacket);
                        this.lastPacket = lastPacket;
                        if (b != null) {
                            final FakeLag fakeLag = this;
                            fakeLag.lagHelper.lastMs = System.currentTimeMillis();
                            return;
                        }
                        if (b != null) {
                            break;
                        }
                    }
                    final FakeLag fakeLag = this;
                    if (b != null) {
                        continue;
                    }
                    break;
                }
                if (this.lastPacket != null && FakeLag.mc.field_71474_y.field_74320_O != 0) {
                    final EntityOtherPlayerMP entityOtherPlayerMP;
                    (entityOtherPlayerMP = new EntityOtherPlayerMP((World)FakeLag.mc.field_71441_e, FakeLag.mc.field_71439_g.func_146103_bH())).func_70080_a(this.lastPacket.func_149464_c(), this.lastPacket.func_149467_d(), this.lastPacket.func_149472_e(), this.lastPacket.func_149462_g(), this.lastPacket.func_149470_h());
                    entityOtherPlayerMP.field_71071_by = FakeLag.mc.field_71439_g.field_71071_by;
                    entityOtherPlayerMP.field_71069_bz = FakeLag.mc.field_71439_g.field_71069_bz;
                    entityOtherPlayerMP.field_70759_as = FakeLag.mc.field_71439_g.field_70759_as;
                    FakeLag.mc.field_71441_e.func_73027_a(-1, (Entity)entityOtherPlayerMP);
                }
                continue Label_0241_Outer;
            }
        }
    }
    
    static {
        lIIIIIlIIIlI();
        Class169.a(1723415359811937506L, 6759399633295464748L, MethodHandles.lookup().lookupClass()).a(248926269079133L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(FakeLag.lIllIIIlll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(FakeLag.lIllIIIlll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(101567465068717L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = FakeLag.lIllIIIlll[2]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            c2[n2++] = b(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(FakeLag.lIllIIIlll[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        c = c2;
        d = new String[2];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x42AD;
        if (FakeLag.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = FakeLag.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(FakeLag.lIllIIIlll[4]);
                    array[1] = SecretKeyFactory.getInstance(FakeLag.lIllIIIlll[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    FakeLag.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(FakeLag.lIllIIIlll[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            FakeLag.d[n3] = b(((Cipher)array[0]).doFinal(FakeLag.c[n3].getBytes(FakeLag.lIllIIIlll[7])));
        }
        return FakeLag.d[n3];
    }
    
    private static void lIIIIIlIIIlI() {
        (lIllIIIlll = new String[11])[0] = "DES/CBC/PKCS5Padding";
        FakeLag.lIllIIIlll[1] = "DES";
        FakeLag.lIllIIIlll[2] = "\u000bÊö\u0001F2¯ò$2Lº}ÝþC \u000eÖå\u0097\u008d\u0097;m$\u0005´\u0088!õ(\u0004©!>m\u0002\u009eä\u009f¦úýç\u001d\u0096\u0091)";
        FakeLag.lIllIIIlll[3] = "ISO-8859-1";
        FakeLag.lIllIIIlll[4] = "DES/CBC/PKCS5Padding";
        FakeLag.lIllIIIlll[5] = "DES";
        FakeLag.lIllIIIlll[6] = "无情的我会给你手下留情吗你老爸让你上了黑客还可能是小日本的内阁是不是你开始不是风风火火的速度吗现在我开始对你肆无忌惮的尽情随意殴打你残疾垃圾狗族废材爹爹我不想埋汰你们了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u2009\u2002\u200e";
        FakeLag.lIllIIIlll[7] = "ISO-8859-1";
        FakeLag.lIllIIIlll[8] = "无情的我会给你手下留情吗你老爸让你上了黑客还可能是小日本的内阁是不是你开始不是风风火火的速度吗现在我开始对你肆无忌惮的尽情随意殴打你残疾垃圾狗族废材爹爹我不想埋汰你们了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u2009\u2002\u200e";
        FakeLag.lIllIIIlll[9] = " : ";
        FakeLag.lIllIIIlll[10] = " : ";
    }
    
    private static String lIIIIIIllllI(final String s, final String s2) {
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
    
    private static String lIIIIIIlllll(String s, final String s2) {
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
    
    private static String lIIIIIlIIIII(final String s, final String s2) {
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
}
