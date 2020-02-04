package ClassSub;

import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class205
{
    private static Minecraft mc;
    private static final long a;
    private static final String b;
    private static final String[] lIIlIlIlIlI;
    
    public Class205() {
        super();
    }
    
    private static Entity getEntity(final double n) {
        final int[] b = Class139.b();
        Object entity$294721f4$3fdbdd16;
        final Object[] array = (Object[])(entity$294721f4$3fdbdd16 = getEntity$294721f4$3fdbdd16(n));
        if (b == null) {
            if (array == null) {
                return null;
            }
            entity$294721f4$3fdbdd16 = getEntity$294721f4$3fdbdd16(n)[0];
        }
        return (Entity)entity$294721f4$3fdbdd16;
    }
    
    private static Object[] getEntity$294721f4$3fdbdd16(final double n) {
        final int[] b = Class139.b();
        final Entity func_175606_aa = Class205.mc.func_175606_aa();
        final int[] array = b;
        Object o = null;
        if (func_175606_aa != null) {
            final Minecraft mc = Class205.mc;
            if (array == null) {
                if (mc.field_71441_e == null) {
                    return null;
                }
                final Minecraft mc2 = Class205.mc;
            }
            mc.field_71424_I.func_76320_a("pick");
            final Vec3 func_174824_e = func_175606_aa.func_174824_e(0.0f);
            final Vec3 func_70676_i = func_175606_aa.func_70676_i(0.0f);
            final Vec3 func_72441_c = func_174824_e.func_72441_c(func_70676_i.field_72450_a * n, func_70676_i.field_72448_b * n, func_70676_i.field_72449_c * n);
            Object o2 = null;
            final WorldClient field_71441_e = Class205.mc.field_71441_e;
            final Entity entity = func_175606_aa;
            final List func_72839_b = field_71441_e.func_72839_b(entity, entity.func_174813_aQ().func_72321_a(func_70676_i.field_72450_a * n, func_70676_i.field_72448_b * n, func_70676_i.field_72449_c * n).func_72314_b(1.0, 1.0, 1.0));
            double n2 = n;
            int i = 0;
            while (true) {
                while (i < func_72839_b.size()) {
                    final Entity entity2 = func_72839_b.get(i);
                    if (array == null) {
                        int func_70067_L;
                        final int n3 = func_70067_L = (entity2.func_70067_L() ? 1 : 0);
                        if (array == null) {
                            Label_0412: {
                                if (n3 != 0) {
                                    final float func_70111_Y = entity2.func_70111_Y();
                                    final AxisAlignedBB func_72314_b = entity2.func_174813_aQ().func_72314_b((double)func_70111_Y, (double)func_70111_Y, (double)func_70111_Y);
                                    final double n4 = 0.0;
                                    final AxisAlignedBB func_72314_b2;
                                    final MovingObjectPosition func_72327_a = (func_72314_b2 = func_72314_b.func_72314_b(n4, n4, 0.0)).func_72327_a(func_174824_e, func_72441_c);
                                    double func_72318_a;
                                    final int n5 = (int)(func_72318_a = (func_72314_b2.func_72318_a(func_174824_e) ? 1 : 0));
                                    Label_0295: {
                                        if (array == null) {
                                            if (n5 == 0) {
                                                break Label_0295;
                                            }
                                            final int n6;
                                            func_72318_a = (n6 = dcmpg(0.0, n2));
                                        }
                                        Label_0263: {
                                            if (array == null) {
                                                if (n5 < 0) {
                                                    break Label_0263;
                                                }
                                                func_72318_a = dcmpl(n2, 0.0);
                                            }
                                            if (func_72318_a != 0) {
                                                break Label_0412;
                                            }
                                        }
                                        o = entity2;
                                        final MovingObjectPosition movingObjectPosition = func_72327_a;
                                        o2 = ((array == null && movingObjectPosition == null) ? func_174824_e : movingObjectPosition.field_72307_f);
                                        n2 = 0.0;
                                        if (array == null) {
                                            break Label_0412;
                                        }
                                    }
                                    if (func_72327_a != null) {
                                        final double func_72438_d;
                                        final double n7 = dcmpg(func_72438_d = func_174824_e.func_72438_d(func_72327_a.field_72307_f), n2);
                                        if (array == null) {
                                            if (n7 >= 0) {
                                                final double n8 = dcmpl(n2, 0.0);
                                                if (array == null) {
                                                    if (n8 != 0) {
                                                        break Label_0412;
                                                    }
                                                }
                                            }
                                        }
                                        final int n9 = (int)n7;
                                        final Entity entity3 = entity2;
                                        if (array == null && entity3 == func_175606_aa.field_70154_o) {
                                            final int n10 = n9;
                                            if (array == null) {
                                                if (n10 != 0) {
                                                    goto Label_0397;
                                                }
                                                final double n11 = dcmpl(n2, 0.0);
                                            }
                                            if (n10 == 0) {
                                                o = entity2;
                                                o2 = func_72327_a.field_72307_f;
                                                if (array != null) {
                                                    goto Label_0397;
                                                }
                                            }
                                        }
                                        else {
                                            o = entity3;
                                            o2 = func_72327_a.field_72307_f;
                                            n2 = func_72438_d;
                                        }
                                    }
                                }
                            }
                            ++i;
                        }
                        else {
                            final Object o3;
                            Label_0476: {
                                Label_0465: {
                                    if (array == null) {
                                        if (n3 >= 0) {
                                            break Label_0465;
                                        }
                                        o3 = o;
                                        if (array != null) {
                                            break Label_0476;
                                        }
                                        func_70067_L = ((o3 instanceof EntityLivingBase) ? 1 : 0);
                                    }
                                    if (func_70067_L == 0) {
                                        final Object o4 = o;
                                        if (array != null) {
                                            break Label_0476;
                                        }
                                        if (!(o4 instanceof EntityItemFrame)) {
                                            o = null;
                                        }
                                    }
                                }
                                Class205.mc.field_71424_I.func_76319_b();
                            }
                            if (o3 != null && o2 != null) {
                                return new Object[] { o, o2 };
                            }
                            return null;
                        }
                    }
                    if (array != null) {
                        break;
                    }
                }
                final int n12;
                int func_70067_L = n12 = dcmpg(n2, n);
                continue;
            }
        }
        return null;
    }
    
    static {
        llIlIlIllIII();
        Class169.a(579035899397898601L, 2860942081974594766L, MethodHandles.lookup().lookupClass()).a(179817562833290L);
        final Cipher instance = Cipher.getInstance(Class205.lIIlIlIlIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class205.lIIlIlIlIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(90111347473302L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class205.lIIlIlIlIlI[2].getBytes(Class205.lIIlIlIlIlI[3]))).intern();
        Class205.mc = Minecraft.func_71410_x();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static String a(final byte[] array) {
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
    
    private static void llIlIlIllIII() {
        (lIIlIlIlIlI = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class205.lIIlIlIlIlI[1] = "DES";
        Class205.lIIlIlIlIlI[2] = "\u001c\u0083K\ríà^i";
        Class205.lIIlIlIlIlI[3] = "ISO-8859-1";
    }
    
    private static String llIlIlIlIlIl(final String s, final String s2) {
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
    
    private static String llIlIlIlIlll(final String s, final String s2) {
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
    
    private static boolean llIlIllIIlIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean llIlIllIIIll(final int n) {
        return n >= 0;
    }
    
    private static boolean llIlIllIIllI(final int n) {
        return n < 0;
    }
    
    private static int llIlIlIlllll$25399e8(final double n) {
        return dcmpl(n, 0.0);
    }
    
    private static int llIlIlIllllI(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
