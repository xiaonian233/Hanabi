package cn.Hanabi.modules.World;

import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import java.awt.*;
import net.minecraft.entity.player.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.entity.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.boss.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class HideAndSeek extends Mod
{
    private static List<EntityLivingBase> kids;
    private Class220 timer;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llIllIIIlII;
    
    public HideAndSeek() {
        super("HideAndSeek", Category.WORLD);
        this.timer = new Class220();
    }
    
    @Override
    public final void onEnable() {
        HideAndSeek.kids.clear();
    }
    
    @Override
    public final void onDisable() {
        HideAndSeek.kids.clear();
    }
    
    @EventTarget
    private void onChat(final EventChat eventChat) {
        if (eventChat.message.contains("躲猫猫")) {
            this.timer.lastMs = System.currentTimeMillis();
        }
    }
    
    @EventTarget
    private static void onRender$1f20be12() {
        final int[] b = Class139.b();
        final Iterator<EntityLivingBase> iterator = HideAndSeek.kids.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final EntityLivingBase entityLivingBase;
            if ((entityLivingBase = iterator.next()) == null) {
                return;
            }
            final Color color = new Color(Class22.DARKRED.c);
            HideAndSeek.mc.func_175598_ae();
            final double n = entityLivingBase.field_70142_S + (entityLivingBase.field_70165_t - entityLivingBase.field_70142_S) * Class94.getTimer().field_74281_c;
            HideAndSeek.mc.func_175598_ae();
            double n2 = n;
            HideAndSeek.mc.func_175598_ae();
            final double n3 = entityLivingBase.field_70137_T + (entityLivingBase.field_70163_u - entityLivingBase.field_70137_T) * Class94.getTimer().field_74281_c;
            HideAndSeek.mc.func_175598_ae();
            double n4 = n3;
            HideAndSeek.mc.func_175598_ae();
            final double n5 = entityLivingBase.field_70136_U + (entityLivingBase.field_70161_v - entityLivingBase.field_70136_U) * Class94.getTimer().field_74281_c;
            HideAndSeek.mc.func_175598_ae();
            double n6 = n5;
            final EntityLivingBase entityLivingBase2 = entityLivingBase;
            if (array == null && entityLivingBase2 instanceof EntityPlayer) {
                final double n7 = entityLivingBase.func_70093_af() ? 0.25 : 0.0;
                GL11.glPushMatrix();
                GL11.glEnable(3042);
                GL11.glBlendFunc(770, 771);
                GL11.glTranslated(0.0, -0.25 * (Math.abs(entityLivingBase.field_70125_A) / 90.0f), 0.0);
                GL11.glTranslated((n2 -= 0.275) + 0.275, (n4 += entityLivingBase.func_70047_e() - 0.225 - n7) + 0.275, (n6 -= 0.275) + 0.275);
                GL11.glRotated((double)(-entityLivingBase.field_70177_z % 360.0f), 0.0, 1.0, 0.0);
                GL11.glTranslated(-(n2 + 0.275), -(n4 + 0.275), -(n6 + 0.275));
                GL11.glTranslated(n2 + 0.275, n4 + 0.275, n6 + 0.275);
                GL11.glRotated((double)entityLivingBase.field_70125_A, 1.0, 0.0, 0.0);
                GL11.glTranslated(-(n2 + 0.275), -(n4 + 0.275), -(n6 + 0.275));
                GL11.glDisable(3553);
                GL11.glEnable(2848);
                GL11.glDisable(2929);
                GL11.glDepthMask(false);
                GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, 1.0f);
                GL11.glLineWidth(1.0f);
                Class69.drawOutlinedBoundingBox(new AxisAlignedBB(n2 - 0.0025, n4 - 0.0025, n6 - 0.0025, n2 + 0.55 + 0.0025, n4 + 0.55 + 0.0025, n6 + 0.55 + 0.0025));
                GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, 0.5f);
                Class69.drawBoundingBox(new AxisAlignedBB(n2 - 0.0025, n4 - 0.0025, n6 - 0.0025, n2 + 0.55 + 0.0025, n4 + 0.55 + 0.0025, n6 + 0.55 + 0.0025));
                GL11.glDisable(2848);
                GL11.glEnable(3553);
                GL11.glEnable(2929);
                GL11.glDepthMask(true);
                GL11.glDisable(3042);
                GL11.glPopMatrix();
                if (array != null) {
                    goto Label_0604;
                }
            }
            else {
                Class69.drawEntityESP(n2, n4, n6, entityLivingBase2.func_174813_aQ().field_72336_d - entityLivingBase.func_174813_aQ().field_72340_a, entityLivingBase.func_174813_aQ().field_72337_e - entityLivingBase.func_174813_aQ().field_72338_b + 0.25, 1.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.5f, 1.0f, 1.0f, 2.0f);
            }
            if (array != null) {
                break;
            }
        }
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        Iterator<EntityLivingBase> iterator = HideAndSeek.mc.field_71441_e.field_72996_f.iterator();
        final int[] array = b;
        while (true) {
            while (iterator.hasNext()) {
                final Entity entity;
                boolean hasNext;
                boolean b6;
                boolean contains;
                boolean b5;
                boolean b4;
                boolean b3;
                final boolean b2 = b3 = (b4 = (b5 = (contains = (b6 = (hasNext = ((entity = (Entity)iterator.next()) instanceof EntityLivingBase))))));
                if (array != null) {
                    while (true) {
                        if (hasNext) {
                            final EntityLivingBase entityLivingBase;
                            final boolean field_70128_L = (entityLivingBase = iterator.next()).field_70128_L;
                            Label_0315: {
                                if (array == null) {
                                    if (!field_70128_L) {
                                        final float n = fcmpg(entityLivingBase.func_110143_aJ(), 0.0f);
                                        if (array != null) {
                                            break Label_0315;
                                        }
                                        if (n >= 0) {
                                            break Label_0315;
                                        }
                                    }
                                    HideAndSeek.kids.remove(entityLivingBase);
                                }
                            }
                            if (array == null) {
                                hasNext = iterator.hasNext();
                                continue;
                            }
                        }
                        break;
                    }
                    return;
                }
                Label_0242: {
                    if (array == null) {
                        if (!b2) {
                            break Label_0242;
                        }
                        final boolean b7;
                        b3 = (b7 = (b4 = (b5 = (contains = (b6 = (entity instanceof EntityPlayer))))));
                    }
                    if (array == null) {
                        if (b2) {
                            break Label_0242;
                        }
                        b4 = (b3 = (b5 = (contains = (b6 = (entity instanceof EntityArmorStand)))));
                    }
                    if (array == null) {
                        if (b3) {
                            break Label_0242;
                        }
                        b5 = (b4 = (contains = (b6 = (entity instanceof EntityWither))));
                    }
                    if (array == null) {
                        if (b4) {
                            break Label_0242;
                        }
                        contains = (b5 = (b6 = HideAndSeek.kids.contains(entity)));
                    }
                    if (array == null) {
                        if (b5) {
                            break Label_0242;
                        }
                        b6 = (contains = entity.func_70005_c_().contains("§c§l"));
                    }
                    if (array == null) {
                        if (contains) {
                            break Label_0242;
                        }
                        b6 = this.timer.isDelayComplete(5000L);
                    }
                    if (b6) {
                        final double n3;
                        final double n2 = dcmpl(n3 = entity.field_70163_u - (int)entity.field_70163_u, 0.1);
                        if (array == null) {
                            if (n2 <= 0) {
                                break Label_0242;
                            }
                            String.valueOf(new StringBuilder().append(n3).append(HideAndSeek.llIllIIIlII[0])).length();
                        }
                        if (array == null) {
                            if (n2 <= 8) {
                                break Label_0242;
                            }
                            HideAndSeek.kids.add((EntityLivingBase)entity);
                        }
                        Class333.tellPlayer(String.valueOf(new StringBuilder("§b[Hanabi]§a检测到一个异常动物:").append(entity.func_70005_c_())));
                    }
                }
                if (array != null) {
                    break;
                }
            }
            iterator = HideAndSeek.kids.iterator();
            continue;
        }
    }
    
    static {
        lIIlIlIlllIIl();
        Class169.a(1883838209340719957L, 8228893550478178464L, MethodHandles.lookup().lookupClass()).a(266181339398956L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(HideAndSeek.llIllIIIlII[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(HideAndSeek.llIllIIIlII[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(89905624617630L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[4];
        int n2 = 0;
        String s;
        int n3 = (s = HideAndSeek.llIllIIIlII[3]).length();
        int n4 = 72;
        int n5 = -1;
    Label_0151:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s3.getBytes(HideAndSeek.llIllIIIlII[5]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0151;
                            }
                            n3 = (s = HideAndSeek.llIllIIIlII[4]).length();
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
                            break Label_0151;
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
        HideAndSeek.kids = new ArrayList<EntityLivingBase>();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x69EA;
        if (HideAndSeek.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = HideAndSeek.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(HideAndSeek.llIllIIIlII[6]);
                    array[1] = SecretKeyFactory.getInstance(HideAndSeek.llIllIIIlII[7]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    HideAndSeek.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(HideAndSeek.llIllIIIlII[8], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            HideAndSeek.d[n3] = b(((Cipher)array[0]).doFinal(HideAndSeek.c[n3].getBytes(HideAndSeek.llIllIIIlII[9])));
        }
        return HideAndSeek.d[n3];
    }
    
    private static void lIIlIlIlllIIl() {
        (llIllIIIlII = new String[13])[0] = "";
        HideAndSeek.llIllIIIlII[1] = "DES/CBC/PKCS5Padding";
        HideAndSeek.llIllIIIlII[2] = "DES";
        HideAndSeek.llIllIIIlII[3] = "\b&R@H\u0080\u0095ÓðÚ\u0011Ê5\r\u00823·LFK6<5 \\*\u0093\u009a\u0090Ì\u0091â\u007fªá\u0089w\u0086ñV\u0013\u0016\"ê\bÑ\t²ú\u0013Jº=ET+~oªÈu\u008c±lÝôô\u0081ò\u0002\u0094ª\u0010r×³©\u0097\u001cãÃuøï¡Ì\t\u0002<";
        HideAndSeek.llIllIIIlII[4] = "î\u0000Ýø¿»ø.á\u009abÃÎ\u007f\u008fNÜ´¨}\u0093ÕQ¨Ü\t\u0099ú¨Ê<\u0093\u0018\u0001\u009b*\u0007\u0096oã\u001cµñ\u0001WH¨&>ê\u0088Ö\r,Åf\u008d";
        HideAndSeek.llIllIIIlII[5] = "ISO-8859-1";
        HideAndSeek.llIllIIIlII[6] = "DES/CBC/PKCS5Padding";
        HideAndSeek.llIllIIIlII[7] = "DES";
        HideAndSeek.llIllIIIlII[8] = "我想看你是如何跟我对话的现在我开始对你肆无忌惮的尽情随意殴打你残疾请你停止你的苟延残喘你是不是开始肆无忌惮了啊你们这样只会复制到脑里面NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u200e\u2003\u200e";
        HideAndSeek.llIllIIIlII[9] = "ISO-8859-1";
        HideAndSeek.llIllIIIlII[10] = "我想看你是如何跟我对话的现在我开始对你肆无忌惮的尽情随意殴打你残疾请你停止你的苟延残喘你是不是开始肆无忌惮了啊你们这样只会复制到脑里面NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2006\u200e\u2003\u200e";
        HideAndSeek.llIllIIIlII[11] = " : ";
        HideAndSeek.llIllIIIlII[12] = " : ";
    }
    
    private static String lIIlIlIllIIlI(final String s, final String s2) {
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
    
    private static String lIIlIlIllIIIl(final String s, final String s2) {
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
    
    private static String lIIlIlIlllIII(String s, final String s2) {
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
    
    private static boolean lIIlIllIIIllI$255f299(final int n) {
        return n > 8;
    }
    
    private static boolean lIIlIllIIIlll(final int n) {
        return n < 0;
    }
    
    private static boolean lIIlIllIIIlIl(final int n) {
        return n > 0;
    }
    
    private static int lIIlIllIIIIll$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
    
    private static int lIIlIllIIIIlI$25399e8(final double n) {
        return dcmpl(n, 0.1);
    }
}
