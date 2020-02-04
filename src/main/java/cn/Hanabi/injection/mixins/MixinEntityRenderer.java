package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.*;
import net.minecraft.entity.*;
import net.minecraft.client.shader.*;
import net.minecraft.client.resources.*;
import org.apache.logging.log4j.*;
import net.minecraft.client.renderer.*;
import java.io.*;
import com.google.gson.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.lwjgl.opengl.*;
import org.spongepowered.asm.mixin.injection.*;
import ClassSub.*;
import cn.Hanabi.modules.Combat.*;
import com.google.common.base.*;
import net.minecraft.client.multiplayer.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

@Mixin({ EntityRenderer.class })
public abstract class MixinEntityRenderer implements IEntityRenderer
{
    @Shadow
    private Minecraft field_78531_r;
    @Shadow
    private Entity field_78528_u;
    @Shadow
    private int field_147713_ae;
    @Shadow
    private boolean field_175083_ad;
    @Shadow
    private ShaderGroup field_147707_d;
    @Shadow
    private IResourceManager field_147711_ac;
    @Shadow
    private static Logger field_147710_q;
    @Shadow
    private static int field_147708_e;
    private static final String[] lIlIIIIl;
    
    public MixinEntityRenderer() {
        super();
    }
    
    @Shadow
    protected abstract void func_78479_a$2549578();
    
    @Override
    public final void runSetupCameraTransform$2549578() {
    }
    
    @Override
    public final void loadShader2(final ResourceLocation resourceLocation) {
        if (OpenGlHelper.func_148822_b()) {
            final Minecraft minecraft = null;
            try {
                (this.field_147707_d = new ShaderGroup(minecraft.func_110434_K(), (IResourceManager)null, null.func_147110_a(), resourceLocation)).func_148026_a(null.field_71443_c, null.field_71440_d);
            }
            catch (IOException ex) {
                null.warn(String.valueOf(new StringBuilder().append(MixinEntityRenderer.lIlIIIIl[0]).append(resourceLocation)), (Throwable)ex);
            }
            catch (JsonSyntaxException ex2) {
                null.warn(String.valueOf(new StringBuilder().append(MixinEntityRenderer.lIlIIIIl[1]).append(resourceLocation)), (Throwable)ex2);
            }
        }
    }
    
    @Inject(method = { "renderWorldPass" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/GlStateManager;disableFog()V", shift = At.Shift.AFTER) })
    private static void eventRender3D$c5244(final int n, final float n2, final long n3) {
        EventManager.call(new EventRender(n, n2, n3));
        GL11.glColor3f(1.0f, 1.0f, 1.0f);
    }
    
    @Overwrite
    private void func_78473_a(final float n) {
        final Entity func_175606_aa;
        if ((func_175606_aa = null.func_175606_aa()) != null && null.field_71441_e != null) {
            null.field_71424_I.func_76320_a(MixinEntityRenderer.lIlIIIIl[2]);
            double n2 = Class4.getModule(MixinEntityRenderer.lIlIIIIl[3]).state ? Reach.getReach() : null.field_71442_b.func_78757_d();
            func_175606_aa.func_174822_a(Class4.getModule(MixinEntityRenderer.lIlIIIIl[4]).state ? Reach.getReach() : n2, n);
            double n3 = n2;
            final Vec3 func_174824_e = func_175606_aa.func_174824_e(n);
            boolean b = false;
            if (null.field_71442_b.func_78749_i()) {
                n2 = 6.0;
                n3 = 6.0;
            }
            else if (n2 > 3.0) {
                b = true;
            }
            if (null.field_71476_x != null) {
                n3 = null.field_71476_x.field_72307_f.func_72438_d(func_174824_e);
            }
            if (Class4.getModule(MixinEntityRenderer.lIlIIIIl[5]).state) {
                n3 = Reach.getReach();
                final MovingObjectPosition func_174822_a;
                if ((func_174822_a = func_175606_aa.func_174822_a(n3, n)) != null) {
                    n3 = func_174822_a.field_72307_f.func_72438_d(func_174824_e);
                }
            }
            final Vec3 func_70676_i = func_175606_aa.func_70676_i(n);
            final Vec3 func_72441_c = func_174824_e.func_72441_c(func_70676_i.field_72450_a * n2, func_70676_i.field_72448_b * n2, func_70676_i.field_72449_c * n2);
            this.field_78528_u = null;
            Vec3 vec3 = null;
            final WorldClient field_71441_e = null.field_71441_e;
            final Entity entity = func_175606_aa;
            final List func_175674_a = field_71441_e.func_175674_a(entity, entity.func_174813_aQ().func_72321_a(func_70676_i.field_72450_a * n2, func_70676_i.field_72448_b * n2, func_70676_i.field_72449_c * n2).func_72314_b(1.0, 1.0, 1.0), Predicates.and(EntitySelectors.field_180132_d, entity -> entity.func_70067_L()));
            double n4 = n3;
            for (int i = 0; i < func_175674_a.size(); ++i) {
                final Entity field_78528_u;
                final float func_70111_Y = (field_78528_u = func_175674_a.get(i)).func_70111_Y();
                final AxisAlignedBB func_72314_b;
                final MovingObjectPosition func_72327_a = (func_72314_b = field_78528_u.func_174813_aQ().func_72314_b((double)func_70111_Y, (double)func_70111_Y, (double)func_70111_Y)).func_72327_a(func_174824_e, func_72441_c);
                if (func_72314_b.func_72318_a(func_174824_e)) {
                    if (n4 >= 0.0) {
                        this.field_78528_u = field_78528_u;
                        vec3 = ((func_72327_a == null) ? func_174824_e : func_72327_a.field_72307_f);
                        n4 = 0.0;
                    }
                }
                else {
                    final double func_72438_d;
                    if (func_72327_a != null && ((func_72438_d = func_174824_e.func_72438_d(func_72327_a.field_72307_f)) < n4 || n4 == 0.0)) {
                        if (field_78528_u == func_175606_aa.field_70154_o) {
                            if (n4 == 0.0) {
                                this.field_78528_u = field_78528_u;
                                vec3 = func_72327_a.field_72307_f;
                            }
                        }
                        else {
                            this.field_78528_u = field_78528_u;
                            vec3 = func_72327_a.field_72307_f;
                            n4 = func_72438_d;
                        }
                    }
                }
            }
            if (this.field_78528_u != null && b && func_174824_e.func_72438_d(vec3) > (Class4.getModule(MixinEntityRenderer.lIlIIIIl[6]).state ? Reach.getReach() : 3.0)) {
                this.field_78528_u = null;
                new MovingObjectPosition(MovingObjectPosition.MovingObjectType.MISS, vec3, (EnumFacing)null, new BlockPos(vec3));
            }
            if (this.field_78528_u != null && (n4 < n3 || null.field_71476_x == null)) {
                new MovingObjectPosition(this.field_78528_u, vec3);
            }
            null.field_71424_I.func_76319_b();
        }
    }
    
    private static /* synthetic */ boolean lambda$getMouseOver$0(final Entity entity) {
        return entity.func_70067_L();
    }
    
    static {
        llIlIIlIl();
    }
    
    private static void llIlIIlIl() {
        (lIlIIIIl = new String[7])[0] = "Failed to load shader: ";
        MixinEntityRenderer.lIlIIIIl[1] = "Failed to load shader: ";
        MixinEntityRenderer.lIlIIIIl[2] = "pick";
        MixinEntityRenderer.lIlIIIIl[3] = "Reach";
        MixinEntityRenderer.lIlIIIIl[4] = "Reach";
        MixinEntityRenderer.lIlIIIIl[5] = "Reach";
        MixinEntityRenderer.lIlIIIIl[6] = "Reach";
    }
    
    private static String llIlIIIlI(final String s, final String s2) {
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
    
    private static String llIlIIIll(final String s, final String s2) {
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
    
    private static boolean llIllIIIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean llIlIllIl(final int n) {
        return n >= 0;
    }
    
    private static boolean llIlIlIll(final int n) {
        return n > 0;
    }
    
    private static int llIlIlIII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int llIlIlIIl(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
