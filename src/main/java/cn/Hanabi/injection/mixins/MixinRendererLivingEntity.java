package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.renderer.entity.*;
import net.minecraft.client.model.*;
import org.apache.logging.log4j.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import ClassSub.*;
import net.minecraft.entity.player.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.util.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import net.minecraft.entity.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

@Mixin({ RendererLivingEntity.class })
public abstract class MixinRendererLivingEntity<T extends EntityLivingBase> extends MixinRender implements IRendererLivingEntity
{
    @Shadow
    private boolean field_177098_i;
    @Shadow
    private ModelBase field_77045_g;
    @Shadow
    @Final
    private static Logger field_147923_a;
    private static final String[] llIIIIlIII;
    
    public MixinRendererLivingEntity() {
        super();
    }
    
    @Inject(method = { "renderName(Lnet/minecraft/entity/EntityLivingBase;DDD)V" }, at = { @At("HEAD") }, cancellable = true)
    private static void onChat$11864d99(final EntityLivingBase entityLivingBase, final CallbackInfo callbackInfo) {
        if (Class4.getModule(MixinRendererLivingEntity.llIIIIlIII[0]).state && entityLivingBase instanceof EntityPlayer) {
            callbackInfo.cancel();
        }
    }
    
    @Shadow
    protected abstract float func_77034_a$483d241b();
    
    @Shadow
    protected abstract float func_77040_d$1bae0699();
    
    @Shadow
    protected abstract void func_77039_a$17c926d9();
    
    @Shadow
    protected abstract void func_77043_a$17ac0797();
    
    @Shadow
    protected abstract float func_77044_a$1bae0699();
    
    @Shadow
    protected abstract void func_77041_b$1bae06a9();
    
    @Shadow
    protected abstract boolean func_177088_c$17e1a005();
    
    @Shadow
    protected abstract void func_180565_e();
    
    @Shadow
    protected abstract void func_77036_a$454b32b7();
    
    @Shadow
    protected abstract void func_177093_a$641b8be9();
    
    @Shadow
    protected abstract boolean func_177090_c$1bae06ad();
    
    @Shadow
    protected abstract void func_177091_f();
    
    @Override
    public final void doRenderModel$790b0af() {
    }
    
    @Override
    public final void doRenderLayers$157b028f() {
    }
    
    @Overwrite
    private void func_76986_a$4a0ddc99(final T t, final float n) {
        GlStateManager.func_179094_E();
        GlStateManager.func_179129_p();
        t.func_70115_ae();
        t.func_70631_g_();
        try {
            final float field_70760_ar = t.field_70760_ar;
            final float field_70761_aq = t.field_70761_aq;
            float func_77034_a$483d241b = this.func_77034_a$483d241b();
            final float field_70758_at = t.field_70758_at;
            final float field_70759_as = t.field_70759_as;
            final float func_77034_a$483d241b2;
            float n2 = (func_77034_a$483d241b2 = this.func_77034_a$483d241b()) - func_77034_a$483d241b;
            if (null.field_78093_q && t.field_70154_o instanceof EntityLivingBase) {
                final EntityLivingBase entityLivingBase = (EntityLivingBase)t.field_70154_o;
                final float field_70760_ar2 = entityLivingBase.field_70760_ar;
                final float field_70761_aq2 = entityLivingBase.field_70761_aq;
                float func_76142_g;
                if ((func_76142_g = MathHelper.func_76142_g(n2 = func_77034_a$483d241b2 - this.func_77034_a$483d241b())) < -85.0f) {
                    func_76142_g = -85.0f;
                }
                if (func_76142_g >= 85.0f) {
                    func_76142_g = 85.0f;
                }
                func_77034_a$483d241b = func_77034_a$483d241b2 - func_76142_g;
                final float n3 = func_76142_g;
                if (n3 * n3 > 2500.0f) {
                    func_77034_a$483d241b += func_76142_g * 0.2f;
                }
            }
            final float n4 = t.field_70127_C + (t.field_70125_A - t.field_70127_C) * n;
            final float func_77044_a$1bae0699 = this.func_77044_a$1bae0699();
            GlStateManager.func_179091_B();
            GlStateManager.func_179152_a(-1.0f, -1.0f, 1.0f);
            GlStateManager.func_179109_b(0.0f, -1.5078125f, 0.0f);
            float n5 = t.field_70722_aY + (t.field_70721_aZ - t.field_70722_aY) * n;
            float n6 = t.field_70754_ba - t.field_70721_aZ * (1.0f - n);
            if (t instanceof EntityPlayer) {
                final EventRenderLivingEntity eventRenderLivingEntity;
                EventManager.call(eventRenderLivingEntity = new EventRenderLivingEntity(t, n6, n5, func_77044_a$1bae0699, n2, n4, func_77034_a$483d241b));
                if (eventRenderLivingEntity.cancelled) {
                    return;
                }
            }
            if (t.func_70631_g_()) {
                n6 *= 3.0f;
            }
            if (n5 > 1.0f) {
                n5 = 1.0f;
            }
            GlStateManager.func_179141_d();
            null.func_78086_a((EntityLivingBase)t, n6, n5, n);
            null.func_78087_a(n6, n5, func_77044_a$1bae0699, n2, n4, 0.0625f, (Entity)t);
            GlStateManager.func_179132_a(true);
            if (t instanceof EntityPlayer) {
                ((EntityPlayer)t).func_175149_v();
            }
            GlStateManager.func_179101_C();
        }
        catch (Exception ex) {
            null.error(MixinRendererLivingEntity.llIIIIlIII[1], (Throwable)ex);
        }
        GlStateManager.func_179138_g(OpenGlHelper.field_77476_b);
        GlStateManager.func_179098_w();
        GlStateManager.func_179138_g(OpenGlHelper.field_77478_a);
        GlStateManager.func_179089_o();
        GlStateManager.func_179121_F();
        EventManager.call(new EventRenderLivingEntity(t));
    }
    
    static {
        lIIIllIlIIII();
    }
    
    private static void lIIIllIlIIII() {
        (llIIIIlIII = new String[2])[0] = "Nametags";
        MixinRendererLivingEntity.llIIIIlIII[1] = "Couldn't render entity";
    }
    
    private static String lIIIllIIllIl(final String s, final String s2) {
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
    
    private static String lIIIllIIlIll(final String s, final String s2) {
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
    
    private static boolean lIIIllIlllIl(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIIllIlllII(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIllIllllI(final int n) {
        return n > 0;
    }
    
    private static int lIIIllIllIll(final float n, final float n2) {
        return fcmpl(n, n2);
    }
    
    private static int lIIIllIllIlI$2548a28(final float n) {
        return fcmpg(n, -85.0f);
    }
}
