package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import java.awt.*;
import cn.Hanabi.events.*;
import net.minecraft.client.*;
import net.minecraft.client.renderer.entity.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Chams extends Mod
{
    private Class157 hue;
    private Value<Boolean> rainbow;
    private Value<Boolean> flat;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIIlIIllII;
    
    public Chams() {
        super("Chams", Category.RENDER);
        this.hue = new Class157();
        this.rainbow = new Value<Boolean>("Chams_Rainbow", Boolean.FALSE);
        this.flat = new Value<Boolean>("Chams_Flat", Boolean.FALSE);
    }
    
    @EventTarget
    private void onRender3D$1f20be12() {
        final int[] b = Class139.b();
        final Class157 hue = this.hue;
        final long currentTimeMillis;
        final long n = (currentTimeMillis = System.currentTimeMillis()) - hue.lastMS;
        hue.lastMS = currentTimeMillis;
        hue.opacity = Class157.calculateCompensation(255.0f, hue.opacity, n, 1);
        final int[] array = b;
        final Class157 hue2 = this.hue;
        if (array == null) {
            if ((int)hue2.opacity < 255.0f) {
                return;
            }
            final Class157 hue3 = this.hue;
        }
        hue2.opacity = 0.0f;
    }
    
    @EventTarget(1)
    private void onRenderEntity(final EventRenderLivingEntity eventRenderLivingEntity) {
        final int[] b = Class139.b();
        final int booleanValue = ((boolean)this.rainbow.value) ? 1 : 0;
        final int[] array = b;
        boolean b5;
        boolean b4;
        final boolean b3;
        final boolean b2 = b3 = (b4 = (b5 = (eventRenderLivingEntity.entity instanceof EntityPlayer)));
        final boolean b6;
        final int n7;
        Label_0382: {
            if (array == null) {
                Label_0381: {
                    if (b2) {
                        EventRenderLivingEntity eventRenderLivingEntity2 = eventRenderLivingEntity;
                        if (array == null) {
                            if (eventRenderLivingEntity.entity == Chams.mc.field_71439_g) {
                                break Label_0381;
                            }
                            eventRenderLivingEntity2 = eventRenderLivingEntity;
                        }
                        b6 = (b4 = (b5 = eventRenderLivingEntity2.pre));
                        if (array != null) {
                            break Label_0382;
                        }
                        if (b6) {
                            final int n = booleanValue;
                            if (array == null && n != 0) {
                                eventRenderLivingEntity.cancelled = true;
                                final Minecraft mc = Chams.mc;
                                try {
                                    final Render func_78713_a;
                                    if ((func_78713_a = mc.func_175598_ae().func_78713_a((Entity)eventRenderLivingEntity.entity)) != null && Chams.mc.func_175598_ae().field_78724_e != null) {
                                        final boolean b7 = func_78713_a instanceof RendererLivingEntity;
                                        Chams chams = null;
                                        Label_0173: {
                                            if (array == null) {
                                                if (!b7) {
                                                    return;
                                                }
                                                GL11.glPushMatrix();
                                                GL11.glDisable(2929);
                                                GL11.glBlendFunc(770, 771);
                                                GL11.glDisable(3553);
                                                GL11.glEnable(3042);
                                                chams = this;
                                                if (array != null) {
                                                    break Label_0173;
                                                }
                                                this.flat.value;
                                            }
                                            if (b7) {
                                                GlStateManager.func_179140_f();
                                            }
                                            chams = this;
                                        }
                                        final Color hsbColor;
                                        glColor$406c8828((hsbColor = Color.getHSBColor((int)chams.hue.opacity / 255.0f, 0.8f, 1.0f)).getRed(), hsbColor.getGreen(), hsbColor.getBlue());
                                        GL11.glEnable(2929);
                                        float n3;
                                        final float n2 = fcmpl(n3 = 255.0f - (int)this.hue.opacity, 255.0f);
                                        final float n4;
                                        float n5 = 0.0f;
                                        Label_0282: {
                                            if (array == null) {
                                                if (n2 > 0) {
                                                    n3 = 1.0f;
                                                }
                                                n4 = n3;
                                                n5 = 0.0f;
                                                if (array != null) {
                                                    break Label_0282;
                                                }
                                                final float n6 = fcmpg(n4, 0.0f);
                                            }
                                            if (n2 < 0) {
                                                n3 = 255.0f;
                                            }
                                            n5 = 0.8f;
                                        }
                                        final Color hsbColor2;
                                        glColor$406c8828((hsbColor2 = Color.getHSBColor(n4, n5, 1.0f)).getRed(), hsbColor2.getGreen(), hsbColor2.getBlue());
                                        GL11.glEnable(3553);
                                        GL11.glDisable(3042);
                                        GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
                                        if (array == null) {
                                            if (this.flat.value) {
                                                GlStateManager.func_179145_e();
                                            }
                                            GL11.glPopMatrix();
                                            final float field_74281_c = Class94.getTimer().field_74281_c;
                                        }
                                        GL11.glPopMatrix();
                                    }
                                    return;
                                }
                                catch (Exception ex) {
                                    ex.printStackTrace();
                                    if (array == null) {
                                        return;
                                    }
                                }
                                goto Label_0366;
                            }
                            GL11.glEnable(n);
                            GL11.glPolygonOffset(1.0f, -1100000.0f);
                            if (array == null) {
                                return;
                            }
                        }
                    }
                }
                n7 = booleanValue;
            }
        }
        if (array == null) {
            if (b2) {
                return;
            }
            b5 = (eventRenderLivingEntity.entity instanceof EntityPlayer);
        }
        final boolean b9;
        if (array == null) {
            if (!b6) {
                return;
            }
            final String[] b8 = EventPacket.b();
            b9 = (b5 = eventRenderLivingEntity.pre);
            if (b8 != null && b9) {}
        }
        if (array != null || b9) {
            GL11.glDisable(n7);
            GL11.glPolygonOffset(1.0f, 1100000.0f);
        }
    }
    
    private static void glColor$406c8828(final int n, final int n2, final int n3) {
        GL11.glColor4f(0.003921569f * n, 0.003921569f * n2, 0.003921569f * n3, 1.0f);
    }
    
    static {
        llIlIllllIl();
        Class169.a(2273477176622548523L, 7820538568754624566L, MethodHandles.lookup().lookupClass()).a(238697457066100L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Chams.lIIlIIllII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Chams.lIIlIIllII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(54162880147174L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Chams.lIIlIIllII[2]).length();
        int char1 = 24;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            c2[n2++] = b(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Chams.lIIlIIllII[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        c = c2;
        d = new String[3];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x3E14;
        if (Chams.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Chams.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Chams.lIIlIIllII[4]);
                    array[1] = SecretKeyFactory.getInstance(Chams.lIIlIIllII[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Chams.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Chams.lIIlIIllII[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Chams.d[n3] = b(((Cipher)array[0]).doFinal(Chams.c[n3].getBytes(Chams.lIIlIIllII[7])));
        }
        return Chams.d[n3];
    }
    
    private static void llIlIllllIl() {
        (lIIlIIllII = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Chams.lIIlIIllII[1] = "DES";
        Chams.lIIlIIllII[2] = "Ê(y\u0015OR1V¾c\u008fû\u0084\\/\u0083Í\u0004\u0016\u0004\u000b±Üd A\u00862ÔT\u0089B³\u008cÑ\b\n¤c«=\u0013)¤?O\u0002\u0013ùÙ\u009dNv\u0083ÊòK\u0010^'+1)ÕM\u008cñA~îçÐ\t¿";
        Chams.lIIlIIllII[3] = "ISO-8859-1";
        Chams.lIIlIIllII[4] = "DES/CBC/PKCS5Padding";
        Chams.lIIlIIllII[5] = "DES";
        Chams.lIIlIIllII[6] = "我也只能无奈了我不想跟个残废人墨迹半天因为你是大家的焦点我很欣赏你的个性用你华丽的言语攻击我啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u200b\u2001\u200d";
        Chams.lIIlIIllII[7] = "ISO-8859-1";
        Chams.lIIlIIllII[8] = "我也只能无奈了我不想跟个残废人墨迹半天因为你是大家的焦点我很欣赏你的个性用你华丽的言语攻击我啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u200b\u2001\u200d";
        Chams.lIIlIIllII[9] = " : ";
        Chams.lIIlIIllII[10] = " : ";
    }
    
    private static String llIlIlllIIl(final String s, final String s2) {
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
    
    private static String llIlIlllIlI(final String s, final String s2) {
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
    
    private static String llIlIlllIII(String s, final String s2) {
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
    
    private static boolean llIlllIIIII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean llIllIlllII(final int n) {
        return n >= 0;
    }
    
    private static boolean llIlllIIIll(final int n) {
        return n < 0;
    }
    
    private static boolean llIlllIIIlI(final int n) {
        return n > 0;
    }
    
    private static int llIllIllIlI$2548a28(final float n) {
        return fcmpl(n, 255.0f);
    }
    
    private static int llIllIlllIl$2548a28(final float n) {
        return fcmpl(n, 255.0f);
    }
    
    private static int llIllIllllI$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
}
