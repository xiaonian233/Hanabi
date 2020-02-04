package cn.Hanabi.modules.Player;

import cn.Hanabi.modules.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.entity.*;
import cn.Hanabi.events.*;
import net.minecraft.network.play.client.*;
import net.minecraft.world.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.util.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.client.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class AutoTools extends Mod
{
    private static final long b;
    private static final String c;
    private static final String[] llIlIIIlIll;
    
    public AutoTools() {
        super("AutoTools", Category.PLAYER);
    }
    
    private static Entity getItems(final double n) {
        final int[] b = Class139.b();
        Entity entity = null;
        double n2 = n;
        final Iterator iterator = AutoTools.mc.field_71441_e.field_72996_f.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final Entity entity2 = iterator.next();
            final Entity field_71439_g;
            final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(field_71439_g = (Entity)AutoTools.mc.field_71439_g);
            if (array != null) {
                return field_71439_g;
            }
            boolean field_70122_E;
            final boolean b2 = field_70122_E = entityPlayerSP.field_70122_E;
            Label_0124: {
                if (array == null) {
                    if (!b2) {
                        break Label_0124;
                    }
                    final boolean field_70124_G;
                    field_70122_E = (field_70124_G = AutoTools.mc.field_71439_g.field_70124_G);
                }
                if (array == null) {
                    if (!b2) {
                        break Label_0124;
                    }
                    field_70122_E = (entity2 instanceof EntityItem);
                }
                if (field_70122_E) {
                    double n4;
                    final double n3 = n4 = AutoTools.mc.field_71439_g.func_70032_d(entity2);
                    if (array == null) {
                        if (n3 > n2) {
                            break Label_0124;
                        }
                        n4 = n3;
                    }
                    n2 = n4;
                    entity = entity2;
                }
            }
            if (array != null) {
                break;
            }
        }
        return entity;
    }
    
    @EventTarget
    private static void onAttack(final EventPacket eventPacket) {
        final int[] b = Class139.b();
        boolean equals;
        boolean func_70113_ah;
        final boolean b2 = func_70113_ah = (equals = (eventPacket.packet instanceof C02PacketUseEntity));
        if (b == null) {
            if (!b2) {
                return;
            }
            final boolean b3;
            func_70113_ah = (b3 = (equals = ((C02PacketUseEntity)eventPacket.packet).func_149565_c().equals((Object)C02PacketUseEntity$Action.ATTACK)));
        }
        if (b == null) {
            if (!b2) {
                return;
            }
            equals = (func_70113_ah = AutoTools.mc.field_71439_g.func_70113_ah());
        }
        if (b == null) {
            if (!func_70113_ah) {
                equals = true;
            }
            else {
                equals = false;
            }
        }
        if (equals) {
            final Entity func_149564_a = ((C02PacketUseEntity)eventPacket.packet).func_149564_a((World)AutoTools.mc.field_71441_e);
            int field_70461_c = 0;
            float func_150931_i = -1.0f;
            final int[] b4 = Class139.b();
            int i = 36;
            final int[] array = b4;
            while (true) {
                while (i < 45) {
                    final EntityPlayerSP entityPlayerSP2;
                    Entity entity;
                    final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(entity = (Entity)(entityPlayerSP2 = AutoTools.mc.field_71439_g));
                    if (array != null) {
                        entityPlayerSP2.field_71071_by.field_70461_c = field_70461_c;
                        AutoTools.mc.field_71442_b.func_78765_e();
                        return;
                    }
                    Label_0227: {
                        Label_0224: {
                            if (array == null) {
                                if (entityPlayerSP.field_71069_bz.field_75151_b.toArray()[i] == null) {
                                    break Label_0224;
                                }
                                entity = func_149564_a;
                            }
                            if (entity != null) {
                                final ItemStack func_75211_c = AutoTools.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                                if (array != null) {
                                    break Label_0227;
                                }
                                if (func_75211_c != null) {
                                    final Item func_77973_b = func_75211_c.func_77973_b();
                                    if (array == null) {
                                        if (!(func_77973_b instanceof ItemSword)) {
                                            break Label_0224;
                                        }
                                        func_75211_c.func_77973_b();
                                    }
                                    final ItemSword itemSword = (ItemSword)func_77973_b;
                                    if (array != null) {
                                        break Label_0227;
                                    }
                                    if (itemSword.func_150931_i() > func_150931_i) {
                                        field_70461_c = i - 36;
                                        func_150931_i = itemSword.func_150931_i();
                                    }
                                }
                            }
                        }
                        ++i;
                    }
                    if (array != null) {
                        break;
                    }
                }
                if (func_150931_i > -1.0f) {
                    final EntityPlayerSP entityPlayerSP2 = AutoTools.mc.field_71439_g;
                    continue;
                }
                break;
            }
        }
    }
    
    @EventTarget
    private static void onClickBlock$457908ce() {
        final int[] b = Class139.b();
        boolean b3;
        boolean func_181040_m;
        final boolean b2 = func_181040_m = (b3 = AutoTools.mc.field_71439_g.func_70113_ah());
        if (b == null) {
            if (!b2) {
                final boolean b4;
                func_181040_m = (b4 = (b3 = true));
            }
            else {
                final boolean b4;
                func_181040_m = (b4 = (b3 = false));
            }
        }
        if (b == null) {
            if (!b2) {
                return;
            }
            b3 = (func_181040_m = AutoTools.mc.field_71442_b.func_181040_m());
        }
        if (b == null) {
            if (!func_181040_m) {
                return;
            }
            b3 = Objects.isNull(AutoTools.mc.field_71476_x.func_178782_a());
        }
        if (!b3) {
            final int func_177958_n = AutoTools.mc.field_71476_x.func_178782_a().func_177958_n();
            final int func_177956_o = AutoTools.mc.field_71476_x.func_178782_a().func_177956_o();
            final int func_177952_p = AutoTools.mc.field_71476_x.func_178782_a().func_177952_p();
            final int n = func_177956_o;
            final int n2 = func_177958_n;
            final int[] b5 = Class139.b();
            final int func_149682_b = Block.func_149682_b(AutoTools.mc.field_71441_e.func_180495_p(new BlockPos(n2, n, func_177952_p)).func_177230_c());
            final int[] array = b5;
            float field_70461_c = 0;
            float func_150997_a = -1.0f;
            int i = 36;
        Label_0274:
            while (true) {
                while (i < 45) {
                    final Minecraft mc = AutoTools.mc;
                    try {
                        final ItemStack func_75211_c;
                        final float n6;
                        float n5;
                        float n4;
                        final int n3 = (int)(n4 = (n5 = (n6 = (((func_75211_c = mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c()).func_77973_b() instanceof ItemTool) ? 1 : 0))));
                        if (array != null) {
                            break Label_0274;
                        }
                        Label_0259: {
                            Label_0228: {
                                if (array == null) {
                                    if (n3 == 0) {
                                        final int n7 = (int)(n4 = (n5 = ((func_75211_c.func_77973_b() instanceof ItemSword) ? 1 : 0)));
                                        if (array != null) {
                                            break Label_0228;
                                        }
                                        if (n7 == 0) {
                                            final int n8 = (int)(n4 = (n5 = ((func_75211_c.func_77973_b() instanceof ItemShears) ? 1 : 0)));
                                            if (array != null) {
                                                break Label_0228;
                                            }
                                            if (n8 == 0) {
                                                break Label_0259;
                                            }
                                        }
                                    }
                                    n5 = (n4 = fcmpl(func_75211_c.func_150997_a(Block.func_149729_e(func_149682_b)), func_150997_a));
                                }
                            }
                            if (array == null) {
                                if (n4 <= 0) {
                                    break Label_0259;
                                }
                                n5 = i - 36;
                            }
                            field_70461_c = n5;
                            func_150997_a = func_75211_c.func_150997_a(Block.func_149729_e(func_149682_b));
                        }
                    }
                    catch (Exception ex) {}
                    ++i;
                    if (array != null) {
                        break;
                    }
                    continue;
                    float n6 = 0.0f;
                    if (n6 != 0) {
                        AutoTools.mc.field_71439_g.field_71071_by.field_70461_c = (int)field_70461_c;
                        AutoTools.mc.field_71442_b.func_78765_e();
                    }
                    return;
                }
                float n6 = fcmpl(func_150997_a, -1.0f);
                continue Label_0274;
            }
        }
    }
    
    private static void bestSword(final Entity entity) {
        int field_70461_c = 0;
        float func_150931_i = -1.0f;
        final int[] b = Class139.b();
        int i = 36;
        final int[] array = b;
        while (true) {
            while (i < 45) {
                final EntityPlayerSP entityPlayerSP2;
                Object o;
                final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(o = (entityPlayerSP2 = AutoTools.mc.field_71439_g));
                if (array != null) {
                    entityPlayerSP2.field_71071_by.field_70461_c = field_70461_c;
                    AutoTools.mc.field_71442_b.func_78765_e();
                    return;
                }
                Label_0145: {
                    Label_0142: {
                        if (array == null) {
                            if (entityPlayerSP.field_71069_bz.field_75151_b.toArray()[i] == null) {
                                break Label_0142;
                            }
                            o = entity;
                        }
                        if (o != null) {
                            final ItemStack func_75211_c = AutoTools.mc.field_71439_g.field_71069_bz.func_75139_a(i).func_75211_c();
                            if (array != null) {
                                break Label_0145;
                            }
                            if (func_75211_c != null) {
                                final Item func_77973_b = func_75211_c.func_77973_b();
                                if (array == null) {
                                    if (!(func_77973_b instanceof ItemSword)) {
                                        break Label_0142;
                                    }
                                    func_75211_c.func_77973_b();
                                }
                                final ItemSword itemSword = (ItemSword)func_77973_b;
                                if (array != null) {
                                    break Label_0145;
                                }
                                if (itemSword.func_150931_i() > func_150931_i) {
                                    field_70461_c = i - 36;
                                    func_150931_i = itemSword.func_150931_i();
                                }
                            }
                        }
                    }
                    ++i;
                }
                if (array != null) {
                    break;
                }
            }
            if (func_150931_i > -1.0f) {
                final EntityPlayerSP entityPlayerSP2 = AutoTools.mc.field_71439_g;
                continue;
            }
            break;
        }
    }
    
    private static void bestTool(int n2, int func_149682_b, int field_70461_c) {
        final int[] b = Class139.b();
        func_149682_b = Block.func_149682_b(AutoTools.mc.field_71441_e.func_180495_p(new BlockPos(n, func_149682_b, field_70461_c)).func_177230_c());
        n2 = (int)(Object)b;
        field_70461_c = 0;
        float func_150997_a = -1.0f;
        int i = 36;
    Label_0172:
        while (true) {
            while (i < 45) {
                final Minecraft mc = AutoTools.mc;
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
                    AutoTools.mc.field_71439_g.field_71071_by.field_70461_c = field_70461_c;
                    AutoTools.mc.field_71442_b.func_78765_e();
                }
                return;
            }
            float n6 = fcmpl(func_150997_a, -1.0f);
            continue Label_0172;
        }
    }
    
    static {
        lIIlIIIlIlIIl();
        Class169.a(-4078952299642830122L, 7762489046964478025L, MethodHandles.lookup().lookupClass()).a(278167022187551L);
        final Cipher instance = Cipher.getInstance(AutoTools.llIlIIIlIll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(AutoTools.llIlIIIlIll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(90736985112601L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(AutoTools.llIlIIIlIll[2].getBytes(AutoTools.llIlIIIlIll[3]))).intern();
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
    
    private static void lIIlIIIlIlIIl() {
        (llIlIIIlIll = new String[4])[0] = "DES/CBC/PKCS5Padding";
        AutoTools.llIlIIIlIll[1] = "DES";
        AutoTools.llIlIIIlIll[2] = "á|~Éüß/Ö\u0010àXôzýñ\u0003";
        AutoTools.llIlIIIlIll[3] = "ISO-8859-1";
    }
    
    private static String lIIlIIIlIlIII(String s, final String s2) {
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
    
    private static String lIIlIIIlIIlll(final String s, final String s2) {
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
    
    private static boolean lIIlIIIlIllIl(final int n) {
        return n <= 0;
    }
    
    private static boolean lIIlIIIllIIll(final int n) {
        return n > 0;
    }
    
    private static int lIIlIIIlIlIlI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIIlIIIllIIIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIlIIIllIlIl(final float n, final float n2) {
        return fcmpl(n, n2);
    }
}
