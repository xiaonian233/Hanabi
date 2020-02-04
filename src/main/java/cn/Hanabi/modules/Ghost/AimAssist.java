package cn.Hanabi.modules.Ghost;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.modules.Player.*;
import net.minecraft.entity.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.item.*;
import net.minecraft.client.entity.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class AimAssist extends Mod
{
    private Value<Double> rotateSpeed;
    private Value<Double> range;
    private Value<Double> fov;
    private Value<Boolean> onlyPlayers;
    private Value<Boolean> clickAim;
    private Value<Boolean> weapon;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIlIIIllll;
    
    public AimAssist() {
        super("AimAssist", Category.GHOST);
        this.rotateSpeed = new Value<Double>("AimAssist_RotateSpeed", 35.0, 1.0, 75.0, 1.0);
        this.range = new Value<Double>("AimAssist_Range", 3.8, 3.0, 10.0, 0.1);
        this.fov = new Value<Double>("AimAssist_Fov", 360.0, 1.0, 360.0, 1.0);
        this.onlyPlayers = new Value<Boolean>("AimAssist_PlayersOnly", Boolean.TRUE);
        this.clickAim = new Value<Boolean>("AimAssist_ClickAim", Boolean.TRUE);
        this.weapon = new Value<Boolean>("AimAssist_Weapon", Boolean.FALSE);
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        Boolean b2;
        final WorldClient worldClient = (WorldClient)(b2 = (Boolean)AimAssist.mc.field_71441_e);
        if (b == null) {
            if (worldClient == null) {
                return;
            }
            b2 = this.weapon.value;
        }
        final boolean booleanValue = b2;
        AimAssist aimAssist = null;
        Label_0119: {
            Label_0094: {
                if (b == null) {
                    if (booleanValue) {
                        final ItemStack func_71045_bC = AimAssist.mc.field_71439_g.func_71045_bC();
                        if (b == null) {
                            if (func_71045_bC == null) {
                                return;
                            }
                            AimAssist.mc.field_71439_g.func_71045_bC();
                        }
                        final boolean b3 = func_71045_bC.func_77973_b() instanceof ItemSword;
                        if (b != null) {
                            break Label_0094;
                        }
                        if (!b3) {
                            return;
                        }
                    }
                    aimAssist = this;
                    if (b != null) {
                        break Label_0119;
                    }
                    this.clickAim.value;
                }
            }
            if (booleanValue && !((IKeyBinding)AimAssist.mc.field_71474_y.field_74312_F).getPress()) {
                return;
            }
            aimAssist = this;
        }
        final AimAssist aimAssist2 = aimAssist;
        Object o = null;
        final int[] b4 = Class139.b();
        final Iterator iterator = AimAssist.mc.field_71441_e.field_72996_f.iterator();
        final int[] array = b4;
        while (iterator.hasNext()) {
            final EntityPlayer next;
            final boolean b6;
            final boolean b5 = b6 = ((next = iterator.next()) instanceof EntityPlayer);
            Label_0543: {
                final boolean booleanValue2;
                Label_0359: {
                    if (array == null) {
                        if (b5) {
                            booleanValue2 = aimAssist2.onlyPlayers.value;
                            if (array != null) {
                                break Label_0359;
                            }
                            if (booleanValue2) {
                                EntityPlayer entityPlayer3;
                                final EntityPlayer entityPlayer2;
                                final EntityPlayer entityPlayer = entityPlayer2 = (entityPlayer3 = next);
                                Label_0350: {
                                    if (array == null) {
                                        if (!llllIIlIlll(entityPlayer, AimAssist.mc.field_71439_g)) {
                                            break Label_0350;
                                        }
                                        entityPlayer3 = entityPlayer2;
                                    }
                                    boolean b7;
                                    boolean func_70685_l;
                                    int n4;
                                    int n3;
                                    int n2;
                                    final int n = n2 = (n3 = (n4 = ((func_70685_l = (b7 = entityPlayer3.func_70089_S())) ? 1 : 0)));
                                    if (array == null) {
                                        if (n == 0) {
                                            break Label_0350;
                                        }
                                        final int n5;
                                        n2 = (n5 = (n3 = (n4 = ((func_70685_l = (b7 = entityPlayer2.func_82150_aj())) ? 1 : 0))));
                                    }
                                    if (array == null) {
                                        if (n != 0) {
                                            break Label_0350;
                                        }
                                        n3 = (n2 = (n4 = ((func_70685_l = (b7 = dcmpg((double)AimAssist.mc.field_71439_g.func_70032_d((Entity)entityPlayer2), (double)aimAssist2.range.value))) ? 1 : 0)));
                                    }
                                    if (array == null) {
                                        if (n2 >= 0) {
                                            break Label_0350;
                                        }
                                        n4 = (n3 = ((func_70685_l = (b7 = AntiBot.isBot((Entity)entityPlayer2))) ? 1 : 0));
                                    }
                                    if (array == null) {
                                        if (n3 != 0) {
                                            break Label_0350;
                                        }
                                        func_70685_l = ((n4 = ((b7 = Teams.isOnSameTeam((Entity)entityPlayer2)) ? 1 : 0)) != 0);
                                    }
                                    if (array == null) {
                                        if (n4 != 0) {
                                            break Label_0350;
                                        }
                                        b7 = (func_70685_l = AimAssist.mc.field_71439_g.func_70685_l((Entity)entityPlayer2));
                                    }
                                    if (array == null) {
                                        if (!func_70685_l) {
                                            break Label_0350;
                                        }
                                        b7 = inFov((EntityLivingBase)entityPlayer2, (int)(Object)aimAssist2.fov.value);
                                    }
                                    if (b7) {
                                        o = entityPlayer2;
                                    }
                                }
                                if (array == null) {
                                    break Label_0543;
                                }
                            }
                        }
                        final boolean b8 = next instanceof EntityLivingBase;
                    }
                }
                Object o2 = null;
                Label_0388: {
                    if (array == null) {
                        if (!b5) {
                            break Label_0543;
                        }
                        final Boolean b9 = (Boolean)(o2 = aimAssist2.onlyPlayers.value);
                        if (array != null) {
                            break Label_0388;
                        }
                        b9;
                    }
                    if (booleanValue2) {
                        break Label_0543;
                    }
                    o2 = next;
                }
                EntityLivingBase entityLivingBase3;
                final EntityLivingBase entityLivingBase2;
                final EntityLivingBase entityLivingBase = entityLivingBase2 = (entityLivingBase3 = (EntityLivingBase)o2);
                if (array == null) {
                    if (!llllIIlIlll(entityLivingBase, AimAssist.mc.field_71439_g)) {
                        break Label_0543;
                    }
                    entityLivingBase3 = entityLivingBase2;
                }
                boolean b10;
                boolean func_70685_l2;
                int n9;
                int n8;
                int n7;
                final int n6 = n7 = (n8 = (n9 = ((func_70685_l2 = (b10 = entityLivingBase3.func_70089_S())) ? 1 : 0)));
                if (array == null) {
                    if (n6 == 0) {
                        break Label_0543;
                    }
                    final int n10;
                    n7 = (n10 = (n8 = (n9 = ((func_70685_l2 = (b10 = entityLivingBase2.func_82150_aj())) ? 1 : 0))));
                }
                if (array == null) {
                    if (n6 != 0) {
                        break Label_0543;
                    }
                    n8 = (n7 = (n9 = ((func_70685_l2 = (b10 = dcmpg((double)AimAssist.mc.field_71439_g.func_70032_d((Entity)entityLivingBase2), (double)aimAssist2.range.value))) ? 1 : 0)));
                }
                if (array == null) {
                    if (n7 >= 0) {
                        break Label_0543;
                    }
                    n9 = (n8 = ((func_70685_l2 = (b10 = AntiBot.isBot((Entity)entityLivingBase2))) ? 1 : 0));
                }
                if (array == null) {
                    if (n8 != 0) {
                        break Label_0543;
                    }
                    func_70685_l2 = ((n9 = ((b10 = Teams.isOnSameTeam((Entity)entityLivingBase2)) ? 1 : 0)) != 0);
                }
                if (array == null) {
                    if (n9 != 0) {
                        break Label_0543;
                    }
                    b10 = (func_70685_l2 = AimAssist.mc.field_71439_g.func_70685_l((Entity)entityLivingBase2));
                }
                if (array == null) {
                    if (!func_70685_l2) {
                        break Label_0543;
                    }
                    b10 = inFov(entityLivingBase2, (int)(Object)aimAssist2.fov.value);
                }
                if (b10) {
                    o = entityLivingBase2;
                }
            }
            if (array != null) {
                break;
            }
        }
        final EntityLivingBase entityLivingBase4;
        if ((entityLivingBase4 = (EntityLivingBase)o) != null) {
            final double n12;
            final double n11 = n12 = dcmpl(fov(entityLivingBase4), 1.0);
            final double n13;
            Label_0604: {
                if (b == null) {
                    if (n11 <= 0) {
                        n13 = dcmpg(fov(entityLivingBase4), -1.0);
                        if (b != null) {
                            break Label_0604;
                        }
                        if (n13 >= 0) {
                            return;
                        }
                    }
                    final double n14 = dcmpl(fov(entityLivingBase4), 0.0);
                }
            }
            if (b == null && n11 <= 0) {}
            final int n15 = (int)n13;
            final EntityPlayerSP field_71439_g = AimAssist.mc.field_71439_g;
            field_71439_g.field_70177_z += (float)((n15 != 0) ? (-(Math.abs(fov(entityLivingBase4)) / (int)(Object)this.rotateSpeed.value)) : (Math.abs(fov(entityLivingBase4)) / (int)(Object)this.rotateSpeed.value));
        }
    }
    
    private static double fov(final EntityLivingBase entityLivingBase) {
        return ((AimAssist.mc.field_71439_g.field_70177_z - faceTarget(entityLivingBase)) % 360.0 + 540.0) % 360.0 - 180.0;
    }
    
    private EntityLivingBase getNearestTarget() {
        Object o = null;
        final int[] b = Class139.b();
        final Iterator iterator = AimAssist.mc.field_71441_e.field_72996_f.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final EntityPlayer next;
            final boolean b3;
            final boolean b2 = b3 = ((next = iterator.next()) instanceof EntityPlayer);
            Label_0417: {
                final boolean booleanValue;
                Label_0234: {
                    if (array == null) {
                        if (b2) {
                            booleanValue = this.onlyPlayers.value;
                            if (array != null) {
                                break Label_0234;
                            }
                            if (booleanValue) {
                                EntityPlayer entityPlayer3;
                                final EntityPlayer entityPlayer2;
                                final EntityPlayer entityPlayer = entityPlayer2 = (entityPlayer3 = next);
                                Label_0225: {
                                    if (array == null) {
                                        if (!llllIIlIlll(entityPlayer, AimAssist.mc.field_71439_g)) {
                                            break Label_0225;
                                        }
                                        entityPlayer3 = entityPlayer2;
                                    }
                                    boolean b4;
                                    boolean func_70685_l;
                                    int n4;
                                    int n3;
                                    int n2;
                                    final int n = n2 = (n3 = (n4 = ((func_70685_l = (b4 = entityPlayer3.func_70089_S())) ? 1 : 0)));
                                    if (array == null) {
                                        if (n == 0) {
                                            break Label_0225;
                                        }
                                        final int n5;
                                        n2 = (n5 = (n3 = (n4 = ((func_70685_l = (b4 = entityPlayer2.func_82150_aj())) ? 1 : 0))));
                                    }
                                    if (array == null) {
                                        if (n != 0) {
                                            break Label_0225;
                                        }
                                        n3 = (n2 = (n4 = ((func_70685_l = (b4 = dcmpg((double)AimAssist.mc.field_71439_g.func_70032_d((Entity)entityPlayer2), (double)this.range.value))) ? 1 : 0)));
                                    }
                                    if (array == null) {
                                        if (n2 >= 0) {
                                            break Label_0225;
                                        }
                                        n4 = (n3 = ((func_70685_l = (b4 = AntiBot.isBot((Entity)entityPlayer2))) ? 1 : 0));
                                    }
                                    if (array == null) {
                                        if (n3 != 0) {
                                            break Label_0225;
                                        }
                                        func_70685_l = ((n4 = ((b4 = Teams.isOnSameTeam((Entity)entityPlayer2)) ? 1 : 0)) != 0);
                                    }
                                    if (array == null) {
                                        if (n4 != 0) {
                                            break Label_0225;
                                        }
                                        b4 = (func_70685_l = AimAssist.mc.field_71439_g.func_70685_l((Entity)entityPlayer2));
                                    }
                                    if (array == null) {
                                        if (!func_70685_l) {
                                            break Label_0225;
                                        }
                                        b4 = inFov((EntityLivingBase)entityPlayer2, (int)(Object)this.fov.value);
                                    }
                                    if (b4) {
                                        o = entityPlayer2;
                                    }
                                }
                                if (array == null) {
                                    break Label_0417;
                                }
                            }
                        }
                        final boolean b5 = next instanceof EntityLivingBase;
                    }
                }
                EntityLivingBase entityLivingBase = null;
                Label_0263: {
                    if (array == null) {
                        if (!b2) {
                            break Label_0417;
                        }
                        final Boolean b6 = (Boolean)(entityLivingBase = (EntityLivingBase)this.onlyPlayers.value);
                        if (array != null) {
                            break Label_0263;
                        }
                        b6;
                    }
                    if (booleanValue) {
                        break Label_0417;
                    }
                    entityLivingBase = (EntityLivingBase)next;
                }
                EntityLivingBase entityLivingBase4;
                final EntityLivingBase entityLivingBase3;
                final EntityLivingBase entityLivingBase2 = entityLivingBase3 = (entityLivingBase4 = entityLivingBase);
                if (array == null) {
                    if (!llllIIlIlll(entityLivingBase2, AimAssist.mc.field_71439_g)) {
                        break Label_0417;
                    }
                    entityLivingBase4 = entityLivingBase3;
                }
                boolean b7;
                boolean func_70685_l2;
                int n9;
                int n8;
                int n7;
                final int n6 = n7 = (n8 = (n9 = ((func_70685_l2 = (b7 = entityLivingBase4.func_70089_S())) ? 1 : 0)));
                if (array == null) {
                    if (n6 == 0) {
                        break Label_0417;
                    }
                    final int n10;
                    n7 = (n10 = (n8 = (n9 = ((func_70685_l2 = (b7 = entityLivingBase3.func_82150_aj())) ? 1 : 0))));
                }
                if (array == null) {
                    if (n6 != 0) {
                        break Label_0417;
                    }
                    n8 = (n7 = (n9 = ((func_70685_l2 = (b7 = dcmpg((double)AimAssist.mc.field_71439_g.func_70032_d((Entity)entityLivingBase3), (double)this.range.value))) ? 1 : 0)));
                }
                if (array == null) {
                    if (n7 >= 0) {
                        break Label_0417;
                    }
                    n9 = (n8 = ((func_70685_l2 = (b7 = AntiBot.isBot((Entity)entityLivingBase3))) ? 1 : 0));
                }
                if (array == null) {
                    if (n8 != 0) {
                        break Label_0417;
                    }
                    func_70685_l2 = ((n9 = ((b7 = Teams.isOnSameTeam((Entity)entityLivingBase3)) ? 1 : 0)) != 0);
                }
                if (array == null) {
                    if (n9 != 0) {
                        break Label_0417;
                    }
                    b7 = (func_70685_l2 = AimAssist.mc.field_71439_g.func_70685_l((Entity)entityLivingBase3));
                }
                if (array == null) {
                    if (!func_70685_l2) {
                        break Label_0417;
                    }
                    b7 = inFov(entityLivingBase3, (int)(Object)this.fov.value);
                }
                if (b7) {
                    o = entityLivingBase3;
                }
            }
            if (array != null) {
                break;
            }
        }
        return (EntityLivingBase)o;
    }
    
    private static boolean inFov(final EntityLivingBase entityLivingBase, float n) {
        final int[] b = Class139.b();
        n *= 0.5;
        final double n2 = ((AimAssist.mc.field_71439_g.field_70177_z - faceTarget(entityLivingBase)) % 360.0 + 540.0) % 360.0 - 180.0;
        final int[] array = b;
        double n5;
        double n4;
        final double n3 = n4 = (n5 = dcmpl(n2, 0.0));
        final double n6;
        if (array == null) {
            if (n3 > 0) {
                n6 = dcmpg(n2, (double)n);
                if (array != null) {
                    return n6 != 0.0;
                }
                if (n6 < 0) {
                    return n6 != 0.0;
                }
            }
            final double n7;
            n4 = (n7 = (n5 = dcmpg((double)(-n), n2)));
        }
        if (array == null) {
            if (n3 >= 0) {
                return false;
            }
            n4 = dcmpg(n2, 0.0);
        }
        if (array != null) {
            return n6 != 0.0;
        }
        if (n4 < 0) {
            return n6 != 0.0;
        }
        return false;
    }
    
    private static float faceTarget(final EntityLivingBase entityLivingBase) {
        final double n = entityLivingBase.field_70165_t - AimAssist.mc.field_71439_g.field_70165_t;
        final double n2 = entityLivingBase.field_70163_u - AimAssist.mc.field_71439_g.field_70163_u;
        final double n3 = entityLivingBase.field_70161_v - AimAssist.mc.field_71439_g.field_70161_v;
        final double n4 = -(Math.atan2(n, n3) * 57.29577951308232);
        final double n5 = n2;
        final double n6 = n;
        final double n7 = n6 * n6;
        final double n8 = n2;
        final double n9 = n7 + n8 * n8;
        final double n10 = n3;
        Math.asin(n5 / Math.sqrt(n9 + n10 * n10));
        return (float)n4;
    }
    
    static {
        llllIIIIIIl();
        Class169.a(4977903124831870675L, 7377182378891487551L, MethodHandles.lookup().lookupClass()).a(93328284492060L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(AimAssist.lIlIIIllll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(AimAssist.lIlIIIllll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(38153727071679L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[7];
        int n2 = 0;
        String s;
        int n3 = (s = AimAssist.lIlIIIllll[2]).length();
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
                    final String intern = b(instance.doFinal(s3.getBytes(AimAssist.lIlIIIllll[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = AimAssist.lIlIIIllll[3]).length();
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
        d = new String[7];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x66F8;
        if (AimAssist.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = AimAssist.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(AimAssist.lIlIIIllll[5]);
                    array[1] = SecretKeyFactory.getInstance(AimAssist.lIlIIIllll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    AimAssist.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(AimAssist.lIlIIIllll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            AimAssist.d[n3] = b(((Cipher)array[0]).doFinal(AimAssist.c[n3].getBytes(AimAssist.lIlIIIllll[8])));
        }
        return AimAssist.d[n3];
    }
    
    private static void llllIIIIIIl() {
        (lIlIIIllll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        AimAssist.lIlIIIllll[1] = "DES";
        AimAssist.lIlIIIllll[2] = "þo¤\u0083--\u0088\u0005Ï¯\u0091nG\u00077bÂÔ~=;*cßâb\u0088_\u0086ýÞ8(öëæv$×õ\u0087¡\u009dG{Õ¿jÜ\u0080]\u0086üF\u008e¨¦ê«#þnu%\u009fê¹AÈhÅu|(\u0007\u009a¬\u0000ÚÒj\u009f\u0097\u001d}õß\bÿC\r\u0098ª\u001a\u0005\u009fäW\u0089À¸»J4Ð6ç\u0010+Püó^7\u0018n¹iG*x>\u0085NQ\t\u009fx|ï9Kã6wB!ë\u0007\u0018FTûÛ~ñ;ÇÃl±úä{ù9zpÍ]ì\u008fæ>";
        AimAssist.lIlIIIllll[3] = "N\u0092\u0084Úý\u0005k¶1ôc³æ£\u0097P\u009dÒ\f/\u009d³9iÁÛä%f¹M°U\u0006\u0002ã6\u001aÆÕ(îÊ\u0095Ê\u007fWbµôqE:\u000f\u008bç#Zm\u0088\rxèðJÜ\u0003yoî3Q\u00016m\u000b8cV\u0088É";
        AimAssist.lIlIIIllll[4] = "ISO-8859-1";
        AimAssist.lIlIIIllll[5] = "DES/CBC/PKCS5Padding";
        AimAssist.lIlIIIllll[6] = "DES";
        AimAssist.lIlIIIllll[7] = "你觉得你还有什么呢你们这些所谓的大手自称登峰造极的本事是的我一直都是你的爹呢对于我的估计你无法抵挡你只能乱敲键盘告诉我难道你所谓的速度就是错字连篇词不达意是不是NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u200d\u2001\u200c";
        AimAssist.lIlIIIllll[8] = "ISO-8859-1";
        AimAssist.lIlIIIllll[9] = "你觉得你还有什么呢你们这些所谓的大手自称登峰造极的本事是的我一直都是你的爹呢对于我的估计你无法抵挡你只能乱敲键盘告诉我难道你所谓的速度就是错字连篇词不达意是不是NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u200d\u2001\u200c";
        AimAssist.lIlIIIllll[10] = " : ";
        AimAssist.lIlIIIllll[11] = " : ";
    }
    
    private static String lllIlllllII(String s, final String s2) {
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
    
    private static String lllIlllllIl(final String s, final String s2) {
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
    
    private static String lllIllllIll(final String s, final String s2) {
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
    
    private static boolean llllIIlIlll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean llllIIlllll(final int n) {
        return n >= 0;
    }
    
    private static boolean llllIIlIlII(final int n) {
        return n < 0;
    }
    
    private static boolean llllIIlIIll(final int n) {
        return n <= 0;
    }
    
    private static boolean llllIIlIlIl(final int n) {
        return n > 0;
    }
    
    private static int llllIIIllIl(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int llllIIIlllI$25399e8(final double n) {
        return dcmpg(n, -1.0);
    }
    
    private static int llllIIlIllI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int llllIIllIll$25399e8(final double n) {
        return dcmpl(n, 0.0);
    }
    
    private static int llllIIlllII(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
