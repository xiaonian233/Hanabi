package cn.Hanabi.modules.World;

import cn.Hanabi.modules.*;
import net.minecraft.block.*;
import net.minecraft.util.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.client.*;
import net.minecraft.item.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class NoObsidian extends Mod
{
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llIlIIlIl;
    
    public NoObsidian() {
        super("NoObsidian", Category.WORLD);
        this.setState(true);
    }
    
    @EventTarget
    private static void OnUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        final BlockPos blockPos = new BlockPos(new Vec3(NoObsidian.mc.field_71439_g.field_70165_t, NoObsidian.mc.field_71439_g.field_70163_u + 3.0, NoObsidian.mc.field_71439_g.field_70161_v));
        final int[] array = b;
        final Block func_177230_c = NoObsidian.mc.field_71441_e.func_180495_p(blockPos).func_177230_c();
        final Block func_177230_c2 = NoObsidian.mc.field_71441_e.func_180495_p(new BlockPos(new Vec3(NoObsidian.mc.field_71439_g.field_70165_t, NoObsidian.mc.field_71439_g.field_70163_u + 2.0, NoObsidian.mc.field_71439_g.field_70161_v))).func_177230_c();
        Block func_177230_c3;
        Block block2;
        final Block block = block2 = (func_177230_c3 = NoObsidian.mc.field_71441_e.func_180495_p(new BlockPos(new Vec3(NoObsidian.mc.field_71439_g.field_70165_t, NoObsidian.mc.field_71439_g.field_70163_u + 1.0, NoObsidian.mc.field_71439_g.field_70161_v))).func_177230_c());
        Block block4;
        Block func_149729_e;
        final Block block3 = func_149729_e = (block4 = Block.func_149729_e(49));
        if (array == null) {
            if (lIIlIlIIlII(block, block3)) {
                bestTool(NoObsidian.mc.field_71476_x.func_178782_a().func_177958_n(), NoObsidian.mc.field_71476_x.func_178782_a().func_177956_o(), NoObsidian.mc.field_71476_x.func_178782_a().func_177952_p());
                NoObsidian.mc.field_71442_b.func_180512_c(new BlockPos(new Vec3(NoObsidian.mc.field_71439_g.field_70165_t, NoObsidian.mc.field_71439_g.field_70163_u - 1.0, NoObsidian.mc.field_71439_g.field_70161_v)), EnumFacing.UP);
            }
            final Block block5;
            block2 = (block5 = (func_177230_c3 = func_177230_c2));
            final Block block6;
            func_149729_e = (block6 = (block4 = Block.func_149729_e(61)));
        }
        if (array == null) {
            if (lIIlIlIIlII(block, block3)) {
                bestTool(NoObsidian.mc.field_71476_x.func_178782_a().func_177958_n(), NoObsidian.mc.field_71476_x.func_178782_a().func_177956_o(), NoObsidian.mc.field_71476_x.func_178782_a().func_177952_p());
                NoObsidian.mc.field_71442_b.func_180512_c(new BlockPos(new Vec3(NoObsidian.mc.field_71439_g.field_70165_t, NoObsidian.mc.field_71439_g.field_70163_u - 1.0, NoObsidian.mc.field_71439_g.field_70161_v)), EnumFacing.UP);
            }
            func_177230_c3 = (block2 = func_177230_c);
            block4 = (func_149729_e = Block.func_149729_e(12));
        }
        Label_0445: {
            if (array == null) {
                if (block2 == func_149729_e) {
                    break Label_0445;
                }
                func_177230_c3 = func_177230_c;
                block4 = Block.func_149729_e(13);
            }
            if (!lIIlIlIIlII(func_177230_c3, block4)) {
                return;
            }
        }
        bestTool(NoObsidian.mc.field_71476_x.func_178782_a().func_177958_n(), NoObsidian.mc.field_71476_x.func_178782_a().func_177956_o(), NoObsidian.mc.field_71476_x.func_178782_a().func_177952_p());
        final BlockPos blockPos2 = new BlockPos(new Vec3(NoObsidian.mc.field_71439_g.field_70165_t, NoObsidian.mc.field_71439_g.field_70163_u + 3.0, NoObsidian.mc.field_71439_g.field_70161_v));
        Class333.tellPlayer("Sand On your Head. Care for it :D");
        NoObsidian.mc.field_71442_b.func_180512_c(blockPos2, EnumFacing.UP);
    }
    
    private static void bestTool(int n2, int func_149682_b, int field_70461_c) {
        func_149682_b = Block.func_149682_b(NoObsidian.mc.field_71441_e.func_180495_p(new BlockPos(n, func_149682_b, field_70461_c)).func_177230_c());
        final int[] b = Class139.b();
        field_70461_c = 0;
        n2 = (int)(Object)b;
        float func_150997_a = -1.0f;
        int i = 36;
    Label_0172:
        while (true) {
            while (i < 45) {
                final Minecraft mc = NoObsidian.mc;
                try {
                    final ItemStack func_75211_c;
                    final float n6;
                    float n5;
                    float n4;
                    final int n3 = (int)(n4 = (n5 = (n6 = (((func_75211_c = mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c()).func_77973_b() instanceof ItemTool) ? 1 : 0))));
                    if (n2 != null) {
                        break Label_0172;
                    }
                    Label_0157: {
                        Label_0126: {
                            if (n2 == null) {
                                if (n3 == 0) {
                                    final int n7 = (int)(n4 = (n5 = ((func_75211_c.func_77973_b() instanceof ItemSword) ? 1 : 0)));
                                    if (n2 != null) {
                                        break Label_0126;
                                    }
                                    if (n7 == 0) {
                                        final int n8 = (int)(n4 = (n5 = ((func_75211_c.func_77973_b() instanceof ItemShears) ? 1 : 0)));
                                        if (n2 != null) {
                                            break Label_0126;
                                        }
                                        if (n8 == 0) {
                                            break Label_0157;
                                        }
                                    }
                                }
                                n5 = (n4 = fcmpl(func_75211_c.func_150997_a(Block.func_149729_e(func_149682_b)), func_150997_a));
                            }
                        }
                        if (n2 == null) {
                            if (n4 <= 0) {
                                break Label_0157;
                            }
                            n5 = i - 36;
                        }
                        field_70461_c = (int)n5;
                        func_150997_a = func_75211_c.func_150997_a(Block.func_149729_e(func_149682_b));
                    }
                }
                catch (Exception ex) {}
                ++i;
                if (n2 != null) {
                    break;
                }
                continue;
                float n6 = 0.0f;
                if (n6 != 0) {
                    NoObsidian.mc.field_71439_g.field_71071_by.field_70461_c = field_70461_c;
                    NoObsidian.mc.field_71442_b.func_78765_e();
                }
                return;
            }
            float n6 = fcmpl(func_150997_a, -1.0f);
            continue Label_0172;
        }
    }
    
    static {
        lIIlIlIIIlI();
        Class169.a(4918981171577647167L, 3537283229208335644L, MethodHandles.lookup().lookupClass()).a(41915411556060L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(NoObsidian.llIlIIlIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(NoObsidian.llIlIIlIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(28715388985476L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = NoObsidian.llIlIIlIl[2]).length();
        int char1 = 24;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            c2[n2++] = b(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(NoObsidian.llIlIIlIl[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        c = c2;
        d = new String[2];
    }
    
    private static Exception a(final Exception ex) {
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x6972;
        if (NoObsidian.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = NoObsidian.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(NoObsidian.llIlIIlIl[4]);
                    array[1] = SecretKeyFactory.getInstance(NoObsidian.llIlIIlIl[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    NoObsidian.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(NoObsidian.llIlIIlIl[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            NoObsidian.d[n3] = b(((Cipher)array[0]).doFinal(NoObsidian.c[n3].getBytes(NoObsidian.llIlIIlIl[7])));
        }
        return NoObsidian.d[n3];
    }
    
    private static void lIIlIlIIIlI() {
        (llIlIIlIl = new String[11])[0] = "DES/CBC/PKCS5Padding";
        NoObsidian.llIlIIlIl[1] = "DES";
        NoObsidian.llIlIIlIl[2] = "\u007f\u001av0ãøtZÌ£%Ô·ô&=\u0095UpÀ6\u0006ì×@È\u0015.\u001e\u0012Gµ\r%îØ\u008bk\u0094Åï\u008c<¶\u000e\u0018\u0018ø«w\u0088\b\u0012\fÃKÔSÛ8È¨§Fa³\u0086¶Å\u009cºH\u000f~\u0019Iæã\u008fw¥É´t²q\u0085\u001e\u001a";
        NoObsidian.llIlIIlIl[3] = "ISO-8859-1";
        NoObsidian.llIlIIlIl[4] = "DES/CBC/PKCS5Padding";
        NoObsidian.llIlIIlIl[5] = "DES";
        NoObsidian.llIlIIlIl[6] = "别再用你那三言两语支离破碎的词语来攻击我好吗你不要妄自菲薄说三道四你这样的措辞只会让我对你更加恶心你明白可能我的语言对你来说已经无关紧要我怎么也忍不住揍你的冲动你开始像疯狗一样的对我穷追不放你丧失人性了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u2009\u2006\u2002";
        NoObsidian.llIlIIlIl[7] = "ISO-8859-1";
        NoObsidian.llIlIIlIl[8] = "别再用你那三言两语支离破碎的词语来攻击我好吗你不要妄自菲薄说三道四你这样的措辞只会让我对你更加恶心你明白可能我的语言对你来说已经无关紧要我怎么也忍不住揍你的冲动你开始像疯狗一样的对我穷追不放你丧失人性了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u2009\u2006\u2002";
        NoObsidian.llIlIIlIl[9] = " : ";
        NoObsidian.llIlIIlIl[10] = " : ";
    }
    
    private static String lIIlIIlIlII(final String s, final String s2) {
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
    
    private static String lIIlIlIIIIl(final String s, final String s2) {
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
    
    private static String lIIlIIlllll(String s, final String s2) {
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
    
    private static boolean lIIlIlIIlIl(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIlIlIIlII(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIlIlIlIlI(final int n) {
        return n > 0;
    }
    
    private static int lIIlIlIIllI(final float n, final float n2) {
        return fcmpl(n, n2);
    }
}
