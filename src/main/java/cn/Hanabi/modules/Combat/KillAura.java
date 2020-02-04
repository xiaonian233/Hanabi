package cn.Hanabi.modules.Combat;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import net.minecraft.client.renderer.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.entity.*;
import javax.vecmath.*;
import java.util.function.*;
import net.minecraft.client.entity.*;
import net.minecraft.item.*;
import net.minecraft.network.*;
import net.minecraft.util.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import net.minecraft.network.play.client.*;
import net.minecraft.entity.player.*;
import cn.Hanabi.events.*;
import net.minecraft.network.play.server.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import cn.Hanabi.modules.World.*;
import net.minecraftforge.fml.common.*;
import cn.Hanabi.modules.Player.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class KillAura extends Mod
{
    private static Value<Boolean> autoBlock;
    private Value<Double> hurttime;
    private Value<Double> mistake;
    private static Value<Double> reach;
    private Value<Double> blockReach;
    private Value<Double> cps;
    private Value<Double> turn;
    private Value<String> rotMode;
    private static Value<Double> switchsize;
    private Value<Double> switchDelay;
    private Value<Double> yawDiff;
    private Value<Boolean> attackPlayers;
    private Value<Boolean> attackAnimals;
    private Value<Boolean> attackMobs;
    private Value<Boolean> throughblock;
    private Value<Boolean> rotations;
    private Value<Boolean> autodisable;
    private Value<Boolean> invisible;
    private Value<Boolean> targetHUD;
    public Value<Boolean> esp;
    private Value<Boolean> aac;
    private Value<String> priority;
    private Value<String> blockMode;
    private static boolean isBlocking;
    public static ArrayList<EntityLivingBase> targets;
    private Random random;
    private static ArrayList<EntityLivingBase> attacked;
    private boolean needBlock;
    private boolean needUnBlock;
    private int index;
    public static EntityLivingBase target;
    private static EntityLivingBase needHitBot;
    private Class220 switchTimer;
    private Class220 attacktimer;
    private Class84 angleUtility;
    private AxisAlignedBB axisAlignedBB;
    private float shouldAddYaw;
    private float[] lastRotation;
    private float rotationYawHead;
    private float[] lastRotations;
    private int attackSpeed;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lllIllllI;
    
    public KillAura() {
        super("KillAura", Category.COMBAT);
        this.hurttime = new Value<Double>("KillAura_HurtTime", 10.0, 1.0, 10.0, 1.0);
        this.mistake = new Value<Double>("KillAura_Mistakes", 0.0, 0.0, 20.0, 1.0);
        this.blockReach = new Value<Double>("KillAura_BlockRange", 0.5, 0.0, 3.0, 0.1);
        this.cps = new Value<Double>("KillAura_CPS", 10.0, 1.0, 20.0, 1.0);
        this.turn = new Value<Double>("KillAura_TurnHeadSpeed", 15.0, 5.0, 120.0, 1.0);
        this.rotMode = new Value<String>("KillAura", "RotationMode", 0);
        this.switchDelay = new Value<Double>("KillAura_SwitchDelay", 50.0, 0.0, 2000.0, 10.0);
        this.yawDiff = new Value<Double>("KillAura_YawDifference", 15.0, 5.0, 90.0, 1.0);
        this.attackPlayers = new Value<Boolean>("KillAura_Players", Boolean.TRUE);
        this.attackAnimals = new Value<Boolean>("KillAura_Animals", Boolean.FALSE);
        this.attackMobs = new Value<Boolean>("KillAura_Mobs", Boolean.FALSE);
        this.throughblock = new Value<Boolean>("KillAura_ThroughBlock", Boolean.TRUE);
        this.rotations = new Value<Boolean>("KillAura_HeadRotations", Boolean.TRUE);
        this.autodisable = new Value<Boolean>("KillAura_AutoDisable", Boolean.TRUE);
        this.invisible = new Value<Boolean>("KillAura_Invisibles", Boolean.FALSE);
        this.targetHUD = new Value<Boolean>("KillAura_ShowTarget", Boolean.TRUE);
        this.esp = new Value<Boolean>("KillAura_ESP", Boolean.TRUE);
        this.aac = new Value<Boolean>("KillAura_AAC", Boolean.FALSE);
        this.priority = new Value<String>("KillAura", "Priority", 1);
        this.blockMode = new Value<String>("KillAura", "BlockMode", 0);
        this.random = new Random();
        this.switchTimer = new Class220();
        this.attacktimer = new Class220();
        this.angleUtility = new Class84();
        this.lastRotation = new float[] { 0.0f, 0.0f };
        this.priority.addValue("Angle");
        this.priority.addValue("Range");
        this.priority.addValue("Fov");
        this.rotMode.addValue("Simple");
        this.rotMode.addValue("Smooth");
        this.rotMode.addValue("Instant");
        this.blockMode.addValue("NCP");
        this.blockMode.addValue("HypixelCN");
        KillAura.attacked = new ArrayList<EntityLivingBase>();
    }
    
    @EventTarget
    private void onReload$3a33106() {
        final int[] b = Class139.b();
        KillAura killAura = this;
        if (b == null) {
            if (!this.autodisable.value) {
                return;
            }
            killAura = this;
        }
        killAura.setState(false);
    }
    
    @EventTarget
    private void targetHud$26896c00() {
        final int[] b = Class139.b();
        if (this.targetHUD.value) {
            final ScaledResolution scaledResolution = new ScaledResolution(KillAura.mc);
            if (b == null) {
                if (KillAura.target == null) {
                    return;
                }
                GL11.glColor4f(1.0f, 1.0f, 1.0f, 1.0f);
            }
            final UnicodeFontRenderer wqy18 = Class139.INSTANCE.fontManager.wqy18;
            wqy18.func_175063_a(KillAura.target.func_70005_c_(), scaledResolution.func_78326_a() / 2.0f - wqy18.func_78256_a(KillAura.target.func_70005_c_()) / 2.0f, scaledResolution.func_78328_b() / 2.0f - 33.0f, 16777215);
            RenderHelper.func_74520_c();
            KillAura.mc.func_110434_K().func_110577_a(new ResourceLocation("textures/gui/icons.png"));
            GL11.glDisable(2929);
            GL11.glEnable(3042);
            GL11.glDepthMask(false);
            OpenGlHelper.func_148821_a(770, 771, 1, 0);
            int n = 0;
            while (true) {
                while (n < KillAura.target.func_110138_aP() / 2.0f) {
                    KillAura.mc.field_71456_v.func_175174_a(scaledResolution.func_78326_a() / 2 - KillAura.target.func_110138_aP() / 2.0f * 10.0f / 2.0f + n * 10, (float)(scaledResolution.func_78328_b() / 2 - 20), 16, 0, 9, 9);
                    ++n;
                    if (b != null) {
                        while (true) {
                            while (n < KillAura.target.func_110143_aJ() / 2.0f) {
                                KillAura.mc.field_71456_v.func_175174_a(scaledResolution.func_78326_a() / 2 - KillAura.target.func_110138_aP() / 2.0f * 10.0f / 2.0f + n * 10, (float)(scaledResolution.func_78328_b() / 2 - 20), 52, 0, 9, 9);
                                ++n;
                                if (b != null) {
                                    RenderHelper.func_74518_a();
                                    return;
                                }
                                if (b != null) {
                                    break;
                                }
                            }
                            GL11.glDepthMask(true);
                            GL11.glDisable(3042);
                            GL11.glEnable(2929);
                            GlStateManager.func_179084_k();
                            GlStateManager.func_179124_c(1.0f, 1.0f, 1.0f);
                            continue;
                        }
                    }
                    if (b != null) {
                        break;
                    }
                }
                n = 0;
                continue;
            }
        }
    }
    
    @EventTarget
    private void onRender$1f20be12() {
        final int[] b = Class139.b();
        Boolean b2;
        final EntityLivingBase entityLivingBase = (EntityLivingBase)(b2 = (Boolean)KillAura.target);
        if (b == null) {
            if (entityLivingBase == null) {
                return;
            }
            b2 = this.esp.value;
        }
        if (b2) {
            for (final EntityLivingBase entityLivingBase2 : KillAura.targets) {
                KillAura.mc.func_175598_ae();
                final double n = entityLivingBase2.field_70142_S + (entityLivingBase2.field_70165_t - entityLivingBase2.field_70142_S) * Class94.getTimer().field_74281_c;
                KillAura.mc.func_175598_ae();
                final double n2 = n;
                KillAura.mc.func_175598_ae();
                final double n3 = entityLivingBase2.field_70137_T + (entityLivingBase2.field_70163_u - entityLivingBase2.field_70137_T) * Class94.getTimer().field_74281_c;
                KillAura.mc.func_175598_ae();
                final double n4 = n3;
                KillAura.mc.func_175598_ae();
                final double n5 = entityLivingBase2.field_70136_U + (entityLivingBase2.field_70161_v - entityLivingBase2.field_70136_U) * Class94.getTimer().field_74281_c;
                KillAura.mc.func_175598_ae();
                Class69.drawEntityESP(n2, n4, n5, entityLivingBase2.func_174813_aQ().field_72336_d - entityLivingBase2.func_174813_aQ().field_72340_a, entityLivingBase2.func_174813_aQ().field_72337_e - entityLivingBase2.func_174813_aQ().field_72338_b + 0.25, lIlIlllIIlI$255f299(entityLivingBase2.field_70737_aN) ? 1.0f : 0.0f, lIlIlllIIlI$255f299(entityLivingBase2.field_70737_aN) ? 0.0f : 1.0f, 0.0f, 0.2f, lIlIlllIIlI$255f299(entityLivingBase2.field_70737_aN) ? 1.0f : 0.0f, lIlIlllIIlI$255f299(entityLivingBase2.field_70737_aN) ? 0.0f : 1.0f, 0.0f, 1.0f, 2.0f);
                if (b != null) {
                    break;
                }
            }
        }
    }
    
    private static double getRandomDoubleInRange$25399e3() {
        final int[] b = Class139.b();
        double n = 0.2;
        double n2 = 0.25;
        if (b == null) {
            n = new Random().nextDouble() * 0.04999999999999999;
            n2 = 0.2;
        }
        return n + n2;
    }
    
    @EventTarget
    private void onPre(final EventPreMotion eventPreMotion) {
        final int[] b = Class139.b();
        this.rotationYawHead = KillAura.mc.field_71439_g.field_70759_as;
        final int[] array = b;
        KillAura.needHitBot = null;
        final ArrayList<EntityLivingBase> targets = KillAura.targets;
        if (array == null) {
            Label_0059: {
                if (!targets.isEmpty()) {
                    KillAura killAura = this;
                    if (array == null) {
                        if (!lIlIlllIlll(this.index, KillAura.targets.size())) {
                            break Label_0059;
                        }
                        killAura = this;
                    }
                    killAura.index = 0;
                }
            }
            final ArrayList<EntityLivingBase> targets2 = KillAura.targets;
        }
        while (true) {
        Label_0382:
            while (true) {
                for (final EntityLivingBase entityLivingBase : targets) {
                    double validEntity;
                    final int n = (int)(validEntity = (this.isValidEntity((Entity)entityLivingBase) ? 1 : 0));
                    if (array != null) {
                        EntityLivingBase entityLivingBase2 = null;
                        EntityPlayerSP target = null;
                        Label_0480: {
                            Label_0477: {
                                if (array == null) {
                                    if (n == 0) {
                                        KillAura.target = null;
                                        this.attackSpeed = 0;
                                        if (array == null) {
                                            break Label_0477;
                                        }
                                    }
                                    KillAura.target = KillAura.targets.get(this.index);
                                    this.axisAlignedBB = null;
                                    final EntityPlayerSP entityPlayerSP = target = (EntityPlayerSP)(entityLivingBase2 = (EntityLivingBase)KillAura.mc.field_71439_g);
                                    if (array != null) {
                                        break Label_0480;
                                    }
                                    validEntity = dcmpl((double)entityPlayerSP.func_70032_d((Entity)KillAura.target), (double)KillAura.reach.value);
                                }
                                if (validEntity > 0) {
                                    KillAura.target = KillAura.targets.get(0);
                                }
                            }
                            entityLivingBase2 = (EntityLivingBase)(target = (EntityPlayerSP)KillAura.target);
                        }
                        if (array == null) {
                            if (target == null) {
                                this.lastRotation[0] = KillAura.mc.field_71439_g.field_70177_z;
                                KillAura.targets.clear();
                                final ItemStack func_70694_bm = KillAura.mc.field_71439_g.func_70694_bm();
                                if (array == null) {
                                    if (func_70694_bm == null) {
                                        return;
                                    }
                                    KillAura.mc.field_71439_g.func_70694_bm();
                                }
                                boolean isBlocking;
                                final boolean b2 = isBlocking = (func_70694_bm.func_77973_b() instanceof ItemSword);
                                if (array == null) {
                                    if (!b2) {
                                        return;
                                    }
                                    final boolean booleanValue;
                                    isBlocking = (booleanValue = KillAura.autoBlock.value);
                                }
                                if (array == null) {
                                    if (!b2) {
                                        return;
                                    }
                                    isBlocking = KillAura.isBlocking;
                                }
                                if (isBlocking) {
                                    this.unBlock(true);
                                }
                                return;
                            }
                            entityLivingBase2 = KillAura.target;
                        }
                        final int field_70737_aN = entityLivingBase2.field_70737_aN;
                        KillAura killAura2 = null;
                        Label_0559: {
                            Label_0558: {
                                if (array == null) {
                                    if (field_70737_aN != 10) {
                                        break Label_0558;
                                    }
                                    killAura2 = this;
                                    if (array != null) {
                                        break Label_0559;
                                    }
                                    this.switchTimer.isDelayComplete(this.switchDelay.value);
                                }
                                if (field_70737_aN != 0 && lIlIlllIIlI$255f299(KillAura.targets.size())) {
                                    this.switchTimer.lastMs = System.currentTimeMillis();
                                    ++this.index;
                                }
                            }
                            killAura2 = this;
                        }
                        Math.abs(Math.abs(MathHelper.func_76142_g(killAura2.rotationYawHead)) - Math.abs(MathHelper.func_76142_g(Class252.getRotations((Entity)KillAura.target)[0])));
                        final boolean booleanValue2 = this.rotations.value;
                        Object o = null;
                        Boolean target3 = null;
                        Label_1993: {
                            Label_1990: {
                                KillAura killAura3 = null;
                                Label_1923: {
                                    Label_1922: {
                                        final Boolean b9;
                                        Label_1845: {
                                            Label_1836: {
                                                if (array == null) {
                                                    Label_1823: {
                                                        if (booleanValue2) {
                                                            boolean b4;
                                                            boolean currentMode;
                                                            final boolean b3 = currentMode = (b4 = this.rotMode.isCurrentMode("Simple"));
                                                            if (array == null) {
                                                                if (b3) {
                                                                    final boolean b5 = b4 = this.aac.value;
                                                                    if (array == null) {
                                                                        if (!b5) {
                                                                            final EntityLivingBase target2 = KillAura.target;
                                                                            final float[] lastRotations = this.lastRotations;
                                                                            final boolean booleanValue3 = this.aac.value;
                                                                            final int intValue = (int)(Object)this.turn.value;
                                                                            final boolean b6 = booleanValue3;
                                                                            final float[] array2 = lastRotations;
                                                                            final EntityLivingBase entityLivingBase3 = target2;
                                                                            final Class303 class303 = new Class303(b6, intValue);
                                                                            final Class97 smoothAngle;
                                                                            final float[] array3 = { KillAura.mc.field_71439_g.field_70177_z + MathHelper.func_76142_g((smoothAngle = class303.smoothAngle(class303.calculateAngle(new Vector3d(entityLivingBase3.field_70165_t, entityLivingBase3.field_70163_u + entityLivingBase3.func_70047_e(), entityLivingBase3.field_70161_v), new Vector3d(KillAura.mc.field_71439_g.field_70165_t, KillAura.mc.field_71439_g.field_70163_u + KillAura.mc.field_71439_g.func_70047_e(), KillAura.mc.field_71439_g.field_70161_v)), new Class97(array2[0], array2[1]))).yaw - KillAura.mc.field_71439_g.field_70177_z), smoothAngle.pitch };
                                                                            this.lastRotations = new float[] { array3[0], array3[1] };
                                                                            eventPreMotion.yaw = array3[0];
                                                                            eventPreMotion.pitch = array3[1];
                                                                            this.rotationYawHead = eventPreMotion.yaw;
                                                                        }
                                                                        this.aac.value;
                                                                    }
                                                                    if (array != null) {
                                                                        break Label_1836;
                                                                    }
                                                                    if (!b5) {
                                                                        break Label_1823;
                                                                    }
                                                                    final AxisAlignedBB axisAlignedBB = this.axisAlignedBB;
                                                                    if (array == null) {
                                                                        if (axisAlignedBB == null) {
                                                                            this.axisAlignedBB = new AxisAlignedBB(KillAura.target.field_70165_t, KillAura.target.field_70163_u, KillAura.target.field_70161_v, KillAura.target.field_70165_t + 1.0, KillAura.target.field_70163_u + 1.0, KillAura.target.field_70161_v + 1.0);
                                                                        }
                                                                        this.axisAlignedBB = this.axisAlignedBB.func_72317_d((KillAura.target.field_70165_t - KillAura.target.field_70169_q) * getRandomDoubleInRange$25399e3(), (KillAura.target.field_70163_u - KillAura.target.field_70167_r) * getRandomDoubleInRange$25399e3(), (KillAura.target.field_70161_v - KillAura.target.field_70166_s) * getRandomDoubleInRange$25399e3());
                                                                        final AxisAlignedBB axisAlignedBB2 = this.axisAlignedBB;
                                                                    }
                                                                    final boolean b7 = false;
                                                                    if (array != null) {
                                                                        if (array == null && b7) {}
                                                                    }
                                                                    final float[] l = Class89.l(new float[] { Class89.ll1[0], Class89.ll1[1] }, Class89.l$4950b7a1(Class89.l(axisAlignedBB, b7)), (float)(Math.random() * (this.turn.value / 3.0 * 1.2 - this.turn.value / 3.0 * 0.8) + this.turn.value / 3.0 * 0.8));
                                                                    Label_1218: {
                                                                        if (array == null) {
                                                                            if (Class4.getModule("Scaffold").state) {
                                                                                break Label_1218;
                                                                            }
                                                                            eventPreMotion.yaw = l[0];
                                                                            this.rotationYawHead = eventPreMotion.yaw;
                                                                        }
                                                                        eventPreMotion.pitch = l[1];
                                                                    }
                                                                    if (array == null) {
                                                                        break Label_1823;
                                                                    }
                                                                }
                                                                final boolean b8;
                                                                currentMode = (b8 = (b4 = this.rotMode.isCurrentMode("Smooth")));
                                                            }
                                                            if (array == null) {
                                                                if (b3) {
                                                                    final double abs = Math.abs(KillAura.target.field_70163_u - KillAura.mc.field_71439_g.field_70163_u);
                                                                    double field_70163_u = 1.8;
                                                                    double abs2 = 0.0;
                                                                    Label_1345: {
                                                                        if (array == null) {
                                                                            if (abs > 1.8) {
                                                                                abs2 = Math.abs(KillAura.target.field_70163_u - KillAura.mc.field_71439_g.field_70163_u) / Math.abs(KillAura.target.field_70163_u - KillAura.mc.field_71439_g.field_70163_u) / 2.0;
                                                                                break Label_1345;
                                                                            }
                                                                            final double field_70163_u2 = KillAura.target.field_70163_u;
                                                                            field_70163_u = KillAura.mc.field_71439_g.field_70163_u;
                                                                        }
                                                                        abs2 = Math.abs(abs - field_70163_u);
                                                                    }
                                                                    final Class120 smoothAngle2 = this.angleUtility.smoothAngle(this.angleUtility.calculateAngle(new Class92<Double>(KillAura.target.func_174813_aQ().field_72340_a + (KillAura.target.func_174813_aQ().field_72336_d - KillAura.target.func_174813_aQ().field_72340_a) / 2.0, ((KillAura.target instanceof EntityPig || KillAura.target instanceof EntitySpider) ? (KillAura.target.func_174813_aQ().field_72338_b - KillAura.target.func_70047_e() * 1.2) : KillAura.target.field_70163_u) - abs2, KillAura.target.func_174813_aQ().field_72339_c + (KillAura.target.func_174813_aQ().field_72334_f - KillAura.target.func_174813_aQ().field_72339_c) / 2.0), new Class92<Double>(KillAura.mc.field_71439_g.func_174813_aQ().field_72340_a + (KillAura.mc.field_71439_g.func_174813_aQ().field_72336_d - KillAura.mc.field_71439_g.func_174813_aQ().field_72340_a) / 2.0, KillAura.mc.field_71439_g.field_70163_u, KillAura.mc.field_71439_g.func_174813_aQ().field_72339_c + (KillAura.mc.field_71439_g.func_174813_aQ().field_72334_f - KillAura.mc.field_71439_g.func_174813_aQ().field_72339_c) / 2.0)), new Class120(Float.valueOf(this.lastRotation[0]), Float.valueOf(this.lastRotation[1])), (float)(Object)this.turn.value * 8.0f, (float)(Object)this.turn.value * 7.5f);
                                                                    new Random();
                                                                    eventPreMotion.yaw = smoothAngle2.getYaw() + randomNumber(-2, 2);
                                                                    eventPreMotion.pitch = smoothAngle2.getPitch() + randomNumber(-3, 3);
                                                                    this.lastRotation[0] = eventPreMotion.yaw;
                                                                    this.lastRotation[1] = eventPreMotion.pitch;
                                                                    this.rotationYawHead = eventPreMotion.yaw;
                                                                    if (array == null) {
                                                                        break Label_1823;
                                                                    }
                                                                }
                                                                currentMode = this.rotMode.isCurrentMode("Instant");
                                                            }
                                                            if (array != null) {
                                                                break Label_1836;
                                                            }
                                                            if (currentMode) {
                                                                final float[] rotations = Class252.getRotations((Entity)KillAura.target);
                                                                new Random();
                                                                eventPreMotion.yaw = rotations[0] + randomNumber(-4, 4);
                                                                eventPreMotion.pitch = rotations[1] + randomNumber(-6, 6);
                                                                this.rotationYawHead = eventPreMotion.yaw;
                                                            }
                                                        }
                                                    }
                                                    b9 = (target3 = (Boolean)(o = KillAura.mc.field_71439_g));
                                                    if (array != null) {
                                                        break Label_1845;
                                                    }
                                                    ((EntityPlayerSP)b9).func_70632_aY();
                                                }
                                            }
                                            if (booleanValue2) {
                                                break Label_1922;
                                            }
                                            final EntityPlayerSP entityPlayerSP2;
                                            target3 = (Boolean)(entityPlayerSP2 = (EntityPlayerSP)(o = KillAura.mc.field_71439_g));
                                        }
                                        if (array != null) {
                                            break Label_1993;
                                        }
                                        if (((EntityPlayerSP)b9).func_70694_bm() == null) {
                                            break Label_1990;
                                        }
                                        final Boolean b10 = target3 = (Boolean)(o = KillAura.mc.field_71439_g);
                                        if (array != null) {
                                            break Label_1993;
                                        }
                                        if (!(((EntityPlayerSP)b10).func_70694_bm().func_77973_b() instanceof ItemSword)) {
                                            break Label_1990;
                                        }
                                        boolean b12;
                                        final boolean b11 = b12 = KillAura.autoBlock.value;
                                        if (array == null) {
                                            if (!b11) {
                                                break Label_1990;
                                            }
                                            final boolean isBlocking2;
                                            b12 = (isBlocking2 = KillAura.isBlocking);
                                        }
                                        if (array == null) {
                                            if (!b11) {
                                                break Label_1990;
                                            }
                                            killAura3 = this;
                                            if (array != null) {
                                                break Label_1923;
                                            }
                                            b12 = this.blockMode.isCurrentMode("NCP");
                                        }
                                        if (!b12) {
                                            break Label_1990;
                                        }
                                    }
                                    killAura3 = this;
                                }
                                int n3;
                                int func_71052_bv;
                                final int n2 = func_71052_bv = (n3 = (KillAura.mc.field_71439_g.func_70632_aY() ? 1 : 0));
                                Label_1987: {
                                    Label_1986: {
                                        if (array == null) {
                                            if (n2 != 0) {
                                                break Label_1986;
                                            }
                                            final boolean b13;
                                            func_71052_bv = ((b13 = ((n3 = (((boolean)KillAura.autoBlock.value) ? 1 : 0)) != 0)) ? 1 : 0);
                                        }
                                        if (array == null) {
                                            if (n2 != 0) {
                                                break Label_1986;
                                            }
                                            n3 = (func_71052_bv = KillAura.mc.field_71439_g.func_71052_bv());
                                        }
                                        if (array == null) {
                                            if (func_71052_bv <= 0) {
                                                break Label_1986;
                                            }
                                            n3 = 1;
                                        }
                                        break Label_1987;
                                    }
                                    n3 = 0;
                                }
                                killAura3.unBlock(n3 != 0);
                            }
                            o = (target3 = (Boolean)KillAura.target);
                        }
                        KillAura killAura4 = null;
                        Label_2021: {
                            if (array == null) {
                                if (target3 == null) {
                                    return;
                                }
                                killAura4 = this;
                                if (array != null) {
                                    break Label_2021;
                                }
                                o = this.aac.value;
                            }
                            if (!(boolean)o) {
                                return;
                            }
                            killAura4 = this;
                        }
                        killAura4.doAttack();
                        return;
                    }
                    if (array == null) {
                        if (n != 0 && array == null) {
                            continue;
                        }
                        KillAura.targets.remove(entityLivingBase);
                    }
                    if (array != null) {
                        break;
                    }
                }
                final int[] b14 = Class139.b();
                final int intValue2 = (int)(Object)KillAura.switchsize.value;
                final int[] array4;
                Label_0170: {
                    Label_0164: {
                        if ((array4 = b14) == null) {
                            if (!lIlIlllIIlI$255f299(intValue2)) {
                                break Label_0164;
                            }
                            this.setDisplayName("Switch");
                        }
                        if (array4 == null) {
                            break Label_0170;
                        }
                    }
                    this.setDisplayName("Single");
                }
                final Iterator iterator2 = KillAura.mc.field_71441_e.field_72996_f.iterator();
                while (iterator2.hasNext()) {
                    final Entity entity;
                    boolean b16;
                    boolean currentMode2;
                    final boolean b15;
                    final int n4 = (b15 = (currentMode2 = (b16 = ((entity = iterator2.next()) instanceof EntityLivingBase)))) ? 1 : 0;
                    if (array4 != null) {
                        if (array4 == null) {
                            if (b15) {
                                KillAura.targets.sort(KillAura::lambda$getTarget$0);
                            }
                            b16 = (currentMode2 = this.priority.isCurrentMode("Fov"));
                        }
                        if (array4 == null) {
                            if (currentMode2) {
                                KillAura.targets.sort(Comparator.comparingDouble((ToDoubleFunction<? super EntityLivingBase>)KillAura::lambda$getTarget$1));
                            }
                            b16 = this.priority.isCurrentMode("Angle");
                        }
                        if (b16) {
                            KillAura.targets.sort(KillAura::lambda$getTarget$2);
                        }
                        final int size;
                        final double validEntity = size = KillAura.targets.size();
                        continue Label_0382;
                    }
                    Label_0276: {
                        if (array4 == null) {
                            if (n4 != 0) {
                                final EntityLivingBase entityLivingBase4;
                                final boolean validEntity2 = this.isValidEntity((Entity)(entityLivingBase4 = (EntityLivingBase)entity));
                                if (array4 != null) {
                                    break Label_0276;
                                }
                                if (validEntity2) {
                                    final boolean contains = KillAura.targets.contains(entityLivingBase4);
                                    if (array4 != null) {
                                        break Label_0276;
                                    }
                                    if (!contains) {
                                        KillAura.targets.add(entityLivingBase4);
                                    }
                                }
                            }
                            KillAura.targets.size();
                        }
                    }
                    if ((lIlIlllIlll(n4, intValue2) && array4 == null) || array4 != null) {
                        break;
                    }
                }
                break;
            }
            boolean b16;
            boolean b15;
            boolean currentMode2 = b15 = (b16 = this.priority.isCurrentMode("Range"));
            continue;
        }
    }
    
    private void doBlock$1385ff() {
        final EntityPlayerSP field_71439_g = KillAura.mc.field_71439_g;
        KillAura.mc.field_71439_g.func_70694_bm().func_77988_m();
        KillAura.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C08PacketPlayerBlockPlacement(this.blockMode.isCurrentMode("NCP") ? new BlockPos(-1, -1, -1) : BlockPos.field_177992_a, 255, KillAura.mc.field_71439_g.func_70694_bm(), 0.0f, 0.0f, 0.0f));
        KillAura.isBlocking = true;
    }
    
    private void unBlock(final boolean b) {
        if (b) {
            final EntityPlayerSP field_71439_g = KillAura.mc.field_71439_g;
        }
        KillAura.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C07PacketPlayerDigging(C07PacketPlayerDigging$Action.RELEASE_USE_ITEM, this.blockMode.isCurrentMode("NCP") ? new BlockPos(-1, -1, -1) : BlockPos.field_177992_a, EnumFacing.DOWN));
        KillAura.isBlocking = false;
    }
    
    private static float[] getEntityRotations(final EntityLivingBase entityLivingBase, final float[] array, final boolean b, final int n) {
        final Class303 class303 = new Class303(b, n);
        final Class97 smoothAngle;
        return new float[] { KillAura.mc.field_71439_g.field_70177_z + MathHelper.func_76142_g((smoothAngle = class303.smoothAngle(class303.calculateAngle(new Vector3d(entityLivingBase.field_70165_t, entityLivingBase.field_70163_u + entityLivingBase.func_70047_e(), entityLivingBase.field_70161_v), new Vector3d(KillAura.mc.field_71439_g.field_70165_t, KillAura.mc.field_71439_g.field_70163_u + KillAura.mc.field_71439_g.func_70047_e(), KillAura.mc.field_71439_g.field_70161_v)), new Class97(array[0], array[1]))).yaw - KillAura.mc.field_71439_g.field_70177_z), smoothAngle.pitch };
    }
    
    private static int randomNumber(final int n, final int n2) {
        return (int)(Math.random() * (n - n2)) + n2;
    }
    
    private void doAttack() {
        final int[] b = Class139.b();
        final int intValue = (int)(Object)this.cps.value;
        final int[] array = b;
        final boolean delayComplete = this.attacktimer.isDelayComplete(1000 / intValue + this.random.nextInt(50) - 30 - 20 + this.random.nextInt(50));
        if (array != null || delayComplete) {
            int n = delayComplete ? 1 : 0;
            double state;
            double n3;
            final double n2 = n3 = (state = dcmpg((double)KillAura.mc.field_71439_g.func_70032_d((Entity)KillAura.target), (double)KillAura.reach.value));
            if (array == null) {
                if (n2 <= 0) {
                    final int n4;
                    n3 = (n4 = (int)(state = 1));
                }
                else {
                    final int n4;
                    n3 = (n4 = (int)(state = 0));
                }
            }
            final int n5 = (int)n2;
            int booleanValue = 0;
            Label_0416: {
                Label_0415: {
                    Label_0347: {
                        final EntityPlayerSP field_71439_g;
                        Label_0296: {
                            final double n7;
                            Label_0287: {
                                if (array == null) {
                                    if (n3 != 0) {
                                        this.attacktimer.lastMs = System.currentTimeMillis();
                                        final double n6 = dcmpl((double)KillAura.target.field_70737_aN, (double)this.hurttime.value);
                                        KillAura killAura = null;
                                        Label_0200: {
                                            if (array == null && n6 <= 0) {
                                                killAura = this;
                                                if (array != null) {
                                                    break Label_0200;
                                                }
                                                if (this.random.nextInt(100) < (int)(Object)this.mistake.value) {
                                                    goto Label_0197;
                                                }
                                            }
                                            else {
                                                n = (int)n6;
                                            }
                                            killAura = this;
                                        }
                                        n7 = dcmpl((double)Math.abs(Math.abs(MathHelper.func_76142_g(killAura.rotationYawHead)) - Math.abs(MathHelper.func_76142_g(Class252.getRotations((Entity)KillAura.target)[0]))), (double)this.yawDiff.value);
                                        if (array != null) {
                                            break Label_0287;
                                        }
                                        if (n7 > 0) {
                                            final boolean b2 = (state = (Class4.getModule("Scaffold").state ? 1 : 0)) != 0.0;
                                            if (array != null) {
                                                break Label_0287;
                                            }
                                            if (!b2) {
                                                n = 1;
                                            }
                                        }
                                    }
                                    field_71439_g = KillAura.mc.field_71439_g;
                                    if (array != null) {
                                        break Label_0296;
                                    }
                                    field_71439_g.func_70632_aY();
                                }
                            }
                            if (n7 != 0) {
                                break Label_0347;
                            }
                            final EntityPlayerSP field_71439_g2 = KillAura.mc.field_71439_g;
                        }
                        final ItemStack func_70694_bm = field_71439_g.func_70694_bm();
                        if (array == null) {
                            if (func_70694_bm == null) {
                                break Label_0415;
                            }
                            KillAura.mc.field_71439_g.func_70694_bm();
                        }
                        final boolean b3 = (booleanValue = ((func_70694_bm.func_77973_b() instanceof ItemSword) ? 1 : 0)) != 0;
                        if (array != null) {
                            break Label_0416;
                        }
                        if (!b3) {
                            break Label_0415;
                        }
                        final boolean b4 = (booleanValue = (((boolean)KillAura.autoBlock.value) ? 1 : 0)) != 0;
                        if (array != null) {
                            break Label_0416;
                        }
                        if (!b4) {
                            break Label_0415;
                        }
                    }
                    int n9;
                    int func_71052_bv;
                    final int n8 = func_71052_bv = (n9 = (KillAura.mc.field_71439_g.func_70632_aY() ? 1 : 0));
                    Label_0412: {
                        Label_0411: {
                            if (array == null) {
                                if (n8 != 0) {
                                    break Label_0411;
                                }
                                final boolean b5;
                                func_71052_bv = ((b5 = ((n9 = (((boolean)KillAura.autoBlock.value) ? 1 : 0)) != 0)) ? 1 : 0);
                            }
                            if (array == null) {
                                if (n8 != 0) {
                                    break Label_0411;
                                }
                                n9 = (func_71052_bv = KillAura.mc.field_71439_g.func_71052_bv());
                            }
                            if (array == null) {
                                if (func_71052_bv <= 0) {
                                    break Label_0411;
                                }
                                n9 = 1;
                            }
                            break Label_0412;
                        }
                        n9 = 0;
                    }
                    this.unBlock(n9 != 0);
                }
                booleanValue = n5;
            }
            if (booleanValue != 0) {
                this.attack(n != 0);
            }
        }
    }
    
    @EventTarget
    private void onPost$457908ce() {
        final int[] b = Class139.b();
        final EntityLivingBase target = KillAura.target;
        if (b == null) {
            Label_0038: {
                if (target != null) {
                    KillAura killAura = this;
                    if (b == null) {
                        if (this.aac.value) {
                            break Label_0038;
                        }
                        killAura = this;
                    }
                    killAura.doAttack();
                }
            }
            final EntityLivingBase target2 = KillAura.target;
        }
        if (target != null) {
            final EntityPlayerSP field_71439_g = KillAura.mc.field_71439_g;
            final boolean booleanValue;
            Label_0120: {
                Label_0117: {
                    final boolean b2;
                    Label_0110: {
                        if (b == null) {
                            if (field_71439_g.func_70694_bm() != null) {
                                final boolean isBlocking;
                                b2 = (isBlocking = (KillAura.mc.field_71439_g.func_70694_bm().func_77973_b() instanceof ItemSword));
                                if (b != null) {
                                    break Label_0110;
                                }
                                if (b2) {
                                    booleanValue = KillAura.autoBlock.value;
                                    if (b != null) {
                                        break Label_0120;
                                    }
                                    if (booleanValue) {
                                        break Label_0117;
                                    }
                                }
                            }
                            final EntityPlayerSP field_71439_g2 = KillAura.mc.field_71439_g;
                        }
                        field_71439_g.func_70632_aY();
                    }
                    if (b != null) {
                        break Label_0120;
                    }
                    if (!b2) {
                        return;
                    }
                }
                boolean isBlocking = KillAura.isBlocking;
            }
            if (!booleanValue) {
                final EntityPlayerSP field_71439_g3 = KillAura.mc.field_71439_g;
                KillAura.mc.field_71439_g.func_70694_bm().func_77988_m();
                KillAura.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C08PacketPlayerBlockPlacement(this.blockMode.isCurrentMode("NCP") ? new BlockPos(-1, -1, -1) : BlockPos.field_177992_a, 255, KillAura.mc.field_71439_g.func_70694_bm(), 0.0f, 0.0f, 0.0f));
                KillAura.isBlocking = true;
            }
        }
    }
    
    @EventTarget
    private static void onBlockPacket$1d2175e0() {
    }
    
    private void attack(final boolean b) {
        Label_0694: {
            final int[] b2;
            if ((b2 = Class139.b()) != null || !b) {
                final ArrayList list = new ArrayList<EntityLivingBase>();
                while (true) {
                    while (true) {
                        for (final Entity entity : KillAura.mc.field_71441_e.field_72996_f) {
                            final float abs = Math.abs(Math.abs(MathHelper.func_76142_g(this.rotationYawHead)) - Math.abs(MathHelper.func_76142_g(Class252.getRotations(entity)[0])));
                            final int size;
                            double func_82150_aj;
                            double n2;
                            final int n = (int)(n2 = (func_82150_aj = (size = ((entity instanceof EntityZombie) ? 1 : 0))));
                            if (b2 == null) {
                                Label_0237: {
                                    if (b2 == null) {
                                        if (n == 0) {
                                            break Label_0237;
                                        }
                                        final int n3;
                                        n2 = (n3 = (int)(func_82150_aj = (entity.func_82150_aj() ? 1 : 0)));
                                    }
                                    if (b2 == null) {
                                        if (n == 0) {
                                            break Label_0237;
                                        }
                                        func_82150_aj = (n2 = dcmpg((double)abs, (double)this.yawDiff.value));
                                    }
                                    Entity field_71439_g = null;
                                    Label_0215: {
                                        Label_0202: {
                                            if (b2 == null) {
                                                if (n2 >= 0) {
                                                    final float n4 = (float)(func_82150_aj = fcmpg(KillAura.mc.field_71439_g.func_70032_d((Entity)KillAura.target), 1.0f));
                                                    if (b2 != null) {
                                                        break Label_0202;
                                                    }
                                                    if (n4 >= 0) {
                                                        break Label_0237;
                                                    }
                                                }
                                                final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(field_71439_g = (Entity)KillAura.mc.field_71439_g);
                                                if (b2 != null) {
                                                    break Label_0215;
                                                }
                                                func_82150_aj = dcmpg((double)entityPlayerSP.func_70032_d(entity), (double)KillAura.reach.value);
                                            }
                                        }
                                        if (func_82150_aj >= 0) {
                                            break Label_0237;
                                        }
                                        field_71439_g = entity;
                                    }
                                    if (lIllIIlllIl(field_71439_g, KillAura.mc.field_71439_g)) {
                                        list.add((EntityLivingBase)entity);
                                    }
                                }
                                if (b2 != null) {
                                    break;
                                }
                                continue;
                            }
                            else {
                                if (size == 0) {
                                    list.add(KillAura.target);
                                }
                                final Object value = list.get(this.random.nextInt(list.size()));
                                KillAura.needHitBot = (EntityLivingBase)value;
                                EventManager.call(new EventAttack((Entity)KillAura.target));
                                final Class220 timer = ((Criticals)Class4.getModule("Criticals")).timer;
                                final EntityPlayerSP field_71439_g2 = KillAura.mc.field_71439_g;
                                Label_0606: {
                                    if (b2 == null) {
                                        final Class220 class220;
                                        Label_0585: {
                                            Label_0572: {
                                                if (field_71439_g2.field_70122_E) {
                                                    final boolean state = Class4.getModule("Fly").state;
                                                    if (b2 == null) {
                                                        if (state) {
                                                            break Label_0572;
                                                        }
                                                        final EntityPlayerSP field_71439_g3 = KillAura.mc.field_71439_g;
                                                        if (b2 != null) {
                                                            break Label_0606;
                                                        }
                                                        final boolean field_70124_G = field_71439_g3.field_70124_G;
                                                    }
                                                    if (state) {
                                                        final EntityPlayerSP field_71439_g4 = KillAura.mc.field_71439_g;
                                                        if (b2 != null) {
                                                            break Label_0606;
                                                        }
                                                        if (!field_71439_g4.func_70090_H()) {
                                                            int n6;
                                                            final int n5 = n6 = (Criticals.modes.isCurrentMode("HypixelPacket") ? 1 : 0);
                                                            if (b2 == null) {
                                                                if (n5 == 0) {
                                                                    break Label_0572;
                                                                }
                                                                final int field_70172_ad;
                                                                n6 = (field_70172_ad = KillAura.target.field_70172_ad);
                                                            }
                                                            if (b2 == null) {
                                                                if (!lIllIIllllI$255f299(n5)) {
                                                                    break Label_0572;
                                                                }
                                                                class220 = timer;
                                                                if (b2 != null) {
                                                                    break Label_0585;
                                                                }
                                                                n6 = (class220.isDelayComplete(300L) ? 1 : 0);
                                                            }
                                                            if (n6 != 0 && Class4.getModule("Criticals").state) {
                                                                timer.lastMs = System.currentTimeMillis();
                                                                KillAura.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(KillAura.mc.field_71439_g.field_70165_t, KillAura.mc.field_71439_g.field_70163_u + 0.052 * this.angleUtility.randomFloat(1.08f, 1.1f), KillAura.mc.field_71439_g.field_70161_v, false));
                                                                KillAura.mc.field_71439_g.field_71174_a.func_147298_b().func_179290_a((Packet)new C03PacketPlayer$C04PacketPlayerPosition(KillAura.mc.field_71439_g.field_70165_t, KillAura.mc.field_71439_g.field_70163_u + 0.0125 * this.angleUtility.randomFloat(1.01f, 1.07f), KillAura.mc.field_71439_g.field_70161_v, false));
                                                                this.attackSpeed = 0;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            ++this.attackSpeed;
                                            final Class220 publicItemTimer = AutoSword.publicItemTimer;
                                        }
                                        class220.lastMs = System.currentTimeMillis();
                                        KillAura.mc.field_71439_g.func_71038_i();
                                        final EntityPlayerSP field_71439_g5 = KillAura.mc.field_71439_g;
                                    }
                                }
                                field_71439_g2.field_71174_a.func_147297_a((Packet)new C02PacketUseEntity((Entity)(this.aac.value ? KillAura.needHitBot : KillAura.target), C02PacketUseEntity$Action.ATTACK));
                                if (b2 == null) {
                                    if (!KillAura.attacked.contains(KillAura.target)) {
                                        final boolean b3 = KillAura.target instanceof EntityPlayer;
                                        if (b2 == null) {
                                            if (b3) {
                                                KillAura.attacked.add(KillAura.target);
                                            }
                                        }
                                    }
                                    KillAura.needHitBot = null;
                                }
                                if (b2 != null) {
                                    break Label_0694;
                                }
                                return;
                            }
                        }
                        Object value;
                        final EntityLivingBase entityLivingBase = (EntityLivingBase)(value = list);
                        if (b2 == null) {
                            final int size = ((ArrayList)entityLivingBase).size();
                            continue;
                        }
                        break;
                    }
                    continue;
                }
            }
        }
        KillAura.mc.field_71439_g.func_71038_i();
    }
    
    private void getTarget$3a3d1cb1() {
        final int[] b = Class139.b();
        final int intValue = (int)(Object)KillAura.switchsize.value;
        final int[] array = b;
        Label_0044: {
            Label_0038: {
                if (b == null) {
                    if (!lIlIlllIIlI$255f299(intValue)) {
                        break Label_0038;
                    }
                    this.setDisplayName("Switch");
                }
                if (array == null) {
                    break Label_0044;
                }
            }
            this.setDisplayName("Single");
        }
        final Iterator iterator = KillAura.mc.field_71441_e.field_72996_f.iterator();
        while (true) {
            while (iterator.hasNext()) {
                final Entity entity;
                boolean b3;
                boolean currentMode;
                final boolean b2;
                final int n = (b2 = (currentMode = (b3 = ((entity = iterator.next()) instanceof EntityLivingBase)))) ? 1 : 0;
                if (array != null) {
                    if (array == null) {
                        if (b2) {
                            KillAura.targets.sort(KillAura::lambda$getTarget$0);
                        }
                        b3 = (currentMode = this.priority.isCurrentMode("Fov"));
                    }
                    if (array == null) {
                        if (currentMode) {
                            KillAura.targets.sort(Comparator.comparingDouble((ToDoubleFunction<? super EntityLivingBase>)KillAura::lambda$getTarget$1));
                        }
                        b3 = this.priority.isCurrentMode("Angle");
                    }
                    if (b3) {
                        KillAura.targets.sort(KillAura::lambda$getTarget$2);
                    }
                    return;
                }
                Label_0143: {
                    if (array == null) {
                        if (n != 0) {
                            final EntityLivingBase entityLivingBase;
                            final boolean validEntity = this.isValidEntity((Entity)(entityLivingBase = (EntityLivingBase)entity));
                            if (array != null) {
                                break Label_0143;
                            }
                            if (validEntity) {
                                final boolean contains = KillAura.targets.contains(entityLivingBase);
                                if (array != null) {
                                    break Label_0143;
                                }
                                if (!contains) {
                                    KillAura.targets.add(entityLivingBase);
                                }
                            }
                        }
                        KillAura.targets.size();
                    }
                }
                if ((lIlIlllIlll(n, intValue) && array == null) || array != null) {
                    break;
                }
            }
            boolean b3;
            boolean b2;
            boolean currentMode = b2 = (b3 = this.priority.isCurrentMode("Range"));
            continue;
        }
    }
    
    @EventTarget
    private static void onPacket(final EventPacket eventPacket) {
        final int[] b = Class139.b();
        final Packet packet = eventPacket.packet;
        if (b != null || packet instanceof S08PacketPlayerPosLook) {
            final float field_70177_z = KillAura.mc.field_71439_g.field_70177_z;
            final float field_70125_A = KillAura.mc.field_71439_g.field_70125_A;
        }
    }
    
    private boolean isValidEntity(final Entity entity) {
        final int[] b = Class139.b();
        Entity entity2 = entity;
        if (b == null) {
            if (entity == null) {
                return false;
            }
            entity2 = entity;
        }
        double n;
        final boolean b2 = (n = ((entity2 instanceof EntityLivingBase) ? 1 : 0)) != 0.0;
        if (b != null) {
            return n != 0.0;
        }
        if (b2) {
            final boolean field_70128_L;
            final boolean b3 = field_70128_L = entity.field_70128_L;
            if (b == null) {
                Label_0058: {
                    if (!b3) {
                        float n3;
                        final double n2 = n3 = (float)(n = fcmpg(((EntityLivingBase)entity).func_110143_aJ(), 0.0f));
                        if (b == null) {
                            if (n2 <= 0) {
                                break Label_0058;
                            }
                            n = (n3 = dcmpg((double)KillAura.mc.field_71439_g.func_70032_d(entity), KillAura.reach.value + this.blockReach.value));
                        }
                        if (b != null) {
                            return n != 0.0;
                        }
                        if (n3 >= 0 || !lIllIIlllIl(entity, KillAura.mc.field_71439_g)) {
                            return false;
                        }
                        final boolean b4 = (n = (KillAura.mc.field_71439_g.field_70128_L ? 1 : 0)) != 0.0;
                        if (b != null) {
                            return n != 0.0;
                        }
                        if (b4) {
                            return false;
                        }
                        final boolean b5 = (n = ((entity instanceof EntityArmorStand) ? 1 : 0)) != 0.0;
                        if (b != null) {
                            return n != 0.0;
                        }
                        if (b5) {
                            return false;
                        }
                        final boolean b6 = (n = ((entity instanceof EntitySnowman) ? 1 : 0)) != 0.0;
                        if (b != null) {
                            return n != 0.0;
                        }
                        if (b6) {
                            return false;
                        }
                        boolean booleanValue;
                        final boolean b8;
                        final boolean b7 = b8 = (booleanValue = ((n = ((entity instanceof EntityPlayer) ? 1 : 0)) != 0.0));
                        final double n4;
                        Label_0667: {
                            if (b == null) {
                                if (b7) {
                                    n4 = ((booleanValue = ((n = (((boolean)this.attackPlayers.value) ? 1 : 0)) != 0.0)) ? 1 : 0);
                                    if (b != null) {
                                        break Label_0667;
                                    }
                                    if (n4 != 0.0) {
                                        boolean b9;
                                        boolean onSameTeam;
                                        int n7;
                                        int n6;
                                        final int n5 = n6 = (n7 = ((onSameTeam = (b9 = (entity.field_70173_aa != 0))) ? 1 : 0));
                                        if (b == null) {
                                            if (n5 < 30) {
                                                return false;
                                            }
                                            final boolean b10;
                                            n6 = ((b10 = ((n7 = ((onSameTeam = (b9 = KillAura.mc.field_71439_g.func_70685_l(entity))) ? 1 : 0)) != 0)) ? 1 : 0);
                                        }
                                        Label_0608: {
                                            if (b == null) {
                                                if (n5 == 0) {
                                                    final int n8 = n6 = (n7 = ((onSameTeam = (b9 = this.throughblock.value)) ? 1 : 0));
                                                    if (b != null) {
                                                        break Label_0608;
                                                    }
                                                    if (n8 == 0) {
                                                        return false;
                                                    }
                                                }
                                                n7 = (n6 = ((onSameTeam = (b9 = entity.func_82150_aj())) ? 1 : 0));
                                            }
                                        }
                                        Label_0641: {
                                            if (b == null) {
                                                if (n6 != 0) {
                                                    final boolean b11 = (n7 = ((onSameTeam = (b9 = this.invisible.value)) ? 1 : 0)) != 0;
                                                    if (b != null) {
                                                        break Label_0641;
                                                    }
                                                    if (!b11) {
                                                        return false;
                                                    }
                                                }
                                                onSameTeam = ((n7 = ((b9 = AntiBot.isBot(entity)) ? 1 : 0)) != 0);
                                            }
                                        }
                                        if (b == null) {
                                            if (n7 != 0) {
                                                return false;
                                            }
                                            b9 = (onSameTeam = Teams.isOnSameTeam(entity));
                                        }
                                        if (b == null) {
                                            if (onSameTeam) {
                                                return false;
                                            }
                                            b9 = true;
                                        }
                                        return b9;
                                    }
                                }
                                n = ((entity instanceof EntityMob) ? 1 : 0);
                            }
                        }
                        final boolean b12;
                        Label_0713: {
                            if (b == null) {
                                if (b7) {
                                    b12 = ((n = (((boolean)this.attackMobs.value) ? 1 : 0)) != 0.0);
                                    if (b != null) {
                                        break Label_0713;
                                    }
                                    if (b12) {
                                        final boolean bot = AntiBot.isBot(entity);
                                        return (b != null || !bot) && bot;
                                    }
                                }
                                n = ((entity instanceof EntityAnimal) ? 1 : 0);
                            }
                        }
                        if (b == null) {
                            if (n4 == 0.0) {
                                final boolean b13 = (n = ((entity instanceof EntityVillager) ? 1 : 0)) != 0.0;
                                if (b != null) {
                                    return n != 0.0;
                                }
                                if (!b13) {
                                    return false;
                                }
                            }
                            n = ((booleanValue = this.attackAnimals.value) ? 1 : 0);
                        }
                        if (b != null) {
                            return n != 0.0;
                        }
                        if (b12) {
                            final boolean bot2 = AntiBot.isBot(entity);
                            return (b != null || !bot2) && bot2;
                        }
                        return false;
                    }
                }
                final boolean state = Class4.getModule("AutoL").state;
            }
            final boolean contains;
            if (b == null) {
                if (b3) {
                    contains = KillAura.attacked.contains(entity);
                    if (b == null) {
                        if (contains) {
                            KillAura.attacked.remove(entity);
                            final String sb = AutoL.getSB();
                            final boolean booleanValue2;
                            final boolean b14 = booleanValue2 = AutoL.wdr.value;
                            Label_0204: {
                                if (b != null) {
                                    break Label_0204;
                                }
                                final boolean contains2;
                                if (b14) {
                                    contains2 = AutoL.wdred.contains(KillAura.target.func_70005_c_());
                                    if (b != null) {
                                        break Label_0204;
                                    }
                                    if (!contains2) {
                                        AutoL.wdred.add(KillAura.target.func_70005_c_());
                                        KillAura.mc.field_71439_g.func_71165_d(String.valueOf(new StringBuilder("/wdr ").append(KillAura.target.func_70005_c_()).append(" ka fly reach nokb jesus ac")));
                                    }
                                }
                                final Class263 aes_UTILS = Class139.AES_UTILS;
                                final String hwid_VERIFY = Class139.HWID_VERIFY;
                                try {
                                    aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
                                    Label_0223: {
                                        if (b == null) {
                                            if (b14) {
                                                break Label_0223;
                                            }
                                            FMLCommonHandler.instance().exitJava(0, true);
                                        }
                                        Class258.sleep = contains2;
                                    }
                                }
                                catch (Exception ex) {
                                    FMLCommonHandler.instance().exitJava(0, true);
                                    Class258.sleep = true;
                                }
                            }
                            if (AutoL.mode.isCurrentMode("Chinese")) {
                                final EntityPlayerSP field_71439_g = KillAura.mc.field_71439_g;
                                final StringBuilder append = new StringBuilder().append(AutoAbuse.prefix).append(entity.func_70005_c_());
                                final String s = " L";
                                if (b == null) {
                                    append.append(s);
                                    if (AutoL.abuse.value) {
                                        String.valueOf(new StringBuilder().append(KillAura.lllIllllI[0]).append(sb));
                                    }
                                    else {
                                        final String s2 = KillAura.lllIllllI[1];
                                    }
                                }
                                field_71439_g.func_71165_d(String.valueOf(append.append(s).append(AutoL.ad.value ? " Buy Hanabi at mcheika.com" : KillAura.lllIllllI[2])));
                                if (b == null) {
                                    return contains;
                                }
                            }
                            KillAura.mc.field_71439_g.func_71165_d(String.valueOf(new StringBuilder().append(entity.func_70005_c_()).append(KillAura.lllIllllI[3]).append(Class203.getAbuseGlobal())));
                        }
                    }
                }
            }
            return contains;
        }
        n = 0;
        return n != 0.0;
    }
    
    @Override
    public final void onEnable() {
        final int[] b = Class139.b();
        KillAura.attacked = new ArrayList<EntityLivingBase>();
        final int[] array = b;
        this.axisAlignedBB = null;
        if (array == null) {
            if (KillAura.mc.field_71439_g != null) {
                this.lastRotation[0] = KillAura.mc.field_71439_g.field_70177_z;
                this.lastRotations = new float[] { KillAura.mc.field_71439_g.field_70177_z, KillAura.mc.field_71439_g.field_70125_A };
            }
            this.index = 0;
            super.onEnable();
        }
    }
    
    @Override
    public final void onDisable() {
        final int[] b = Class139.b();
        KillAura killAura = this;
        Label_0037: {
            if (b == null) {
                this.axisAlignedBB = null;
                if (KillAura.mc.field_71439_g == null) {
                    break Label_0037;
                }
                killAura = this;
            }
            killAura.lastRotation[0] = KillAura.mc.field_71439_g.field_70177_z;
        }
        final Class263 aes_UTILS = Class139.AES_UTILS;
        final String hwid_VERIFY = Class139.HWID_VERIFY;
        try {
            final boolean contains = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
            Label_0071: {
                if (b == null) {
                    if (contains) {
                        break Label_0071;
                    }
                    FMLCommonHandler.instance().exitJava(0, true);
                }
                Class258.sleep = contains;
            }
        }
        catch (Exception ex) {
            FMLCommonHandler.instance().exitJava(0, true);
            Class258.sleep = true;
        }
        KillAura.targets.clear();
        KillAura.target = null;
        this.unBlock(true);
        super.onDisable();
    }
    
    private static int lambda$getTarget$2(final EntityLivingBase entityLivingBase, final EntityLivingBase entityLivingBase2) {
        return (int)(KillAura.mc.field_71439_g.field_70177_z - Class252.getRotations((Entity)entityLivingBase)[0] - (KillAura.mc.field_71439_g.field_70177_z - Class252.getRotations((Entity)entityLivingBase2)[0]));
    }
    
    private static double lambda$getTarget$1(final EntityLivingBase entityLivingBase) {
        return Class252.getDistanceBetweenAngles(KillAura.mc.field_71439_g.field_70125_A, Class252.getRotations((Entity)entityLivingBase)[0]);
    }
    
    private static int lambda$getTarget$0(final EntityLivingBase entityLivingBase, final EntityLivingBase entityLivingBase2) {
        return (int)(entityLivingBase.func_70032_d((Entity)KillAura.mc.field_71439_g) - entityLivingBase2.func_70032_d((Entity)KillAura.mc.field_71439_g));
    }
    
    static {
        lIlIllIlIII();
        Class169.a(-8465342876650921607L, 750454092753406240L, MethodHandles.lookup().lookupClass()).a(80046749250753L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(KillAura.lllIllllI[4]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(KillAura.lllIllllI[5]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(65435633508742L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[55];
        int n2 = 0;
        final String s = "ÐÖÍÛ],§ðDÛ\u0097Àe\u0010ìº3]J!1s\u0018'\u001dg\u000b}¼Ï*çÓÐÊZÐ¦)d\u0010\u008f¯du=\u0091K]\b^É´Û\u0015Öº ·H\u0081\u008d\u0005\u0017¹ÖÜ¡\n\tLÒ þ^\u0096\u0081\u0092é\u0010Ø\\¤Ö^O\u008e)go(9\u0017¥ÚÓ\u009c\u0019i8\u0000r.å\u0000(]¬\u0085wê'ã\u0083qÉ\u000bò/8\"\u0082ßRLnÙN\u007fÂ\u000b8lKÝ¦ÙD\u0001ê¦mð\u0094[\u0003\u008d\u0098ÀÆüfØæ\u001a8ð¯¿\u001f¤eeÇ\u008eYÒtÒîÒú¦Ø\u0095\u0007¨qçÙùd¢\u0015\u001f\u0007¦á ¢5\u00adÂ)Ë¶L¯¤e\u0088\n\u008bª¿_\u0015¼â\r\u0015>¥\u008e|oØ^5±ï(V\u0081<Xò»æ\u008b\u001b\u0017ò\u0089¾Ä\u0092É\u0006,¤íqcÀ\u0096\u009aÓ°4*µ²òl´HÇ³I\u009a\u008f\u0010I¬xâ\u001c«\u0082\u000bxÎ\u0004¤ã£\u001a\u008a0\u0010v\u007f\u0017\u008f\u001c,.\u0096«\u0010<å£ÅàÀ4e\u008f\u000fÁ\u000f\n-Dy1°ÎüïjOï£e\n>Â\b\u0005\u0093¼±õ©# >\u0095\u0017 ÐC½(2n\u0091_*ù\u008fpÛ\u0004,z\f)o7ú\u0011W1Z\u0007ÜÍ(Þ»Ç*\u001a%fþø=ÆØ[\u0006Ù\u0000Øþ\r{FJ\u0087|x\u0083µùö¼H\t£\u0018\u008f×¯\n\u008em0\u000b'\u009b\u000bÅ`\u008a¡ÛxµÏÛøÅ\nÓÇÒÇÁ}\u0002°xõs¼É¤\u009aÇ\u0015¹wa\u0099qx*\u009aô\u009c\u008bê*\u009b]\u0010º®DÞáSïö×\u001d\u0000Ãëÿf\u001b(\u0087,7§òs1 ,dËÒ\u0084\u008bÙY5ê»ÍA¬Á\u007fà\"a=M¹ÿÖ±Åÿ¦R\u0007s¤ àï´\u001d\u0094\u0006}\u0015¢8>zðÙhak\u008e-ò\u0012ØþR\fI\u00adKB¿'¥\u0010ïï8) ©7^G\u0098}\u008bÐ¡\u0096\u009b\u0010B\u0019\u008c\u00119a\u008bOm\u0093;\u001d=\u0003ø\u0084 ì¡|ñäüåR5èØ\u001c¨\u0004\u009c\u0005å\u0014ôúÈ¤`ßWD\u0018ÞpIÉþ Øïö\u008eo\u0018\u0094bÉüýn$r]µ´pr\u008b\\¹\u0007ª\u0086¿×è\u0080ëºç \u001d²áz+µÿi|©á:æc@çÖ¥v°¼\u0097¤VpBL\u0004\u009d\u00ad\u008bF\u0010D©õx*\u0003\u0099ïT\u0018{hK¯¼l /Vª \nl°÷½ópÐ\u0000 ü\u0019*(\b\u0093\u008e>·\u001b¢\bù>Oj?»\u0010©ê\u0096ßz\u0002\u0082YÆ5Â\u008a\u0093\u009c\u0016å\u0010(#Õ,\r\u0094ÀöÝYñáRA(P\u0010\u000e3Ø\u0084a\u009c\r\u0092\u0092\f\u0099çbùd\u001b Z\u0011Bè\u0096FÆª\u008aF³\u0012ë\u0092ââUÐê^\u0094³MbêéS$GrQE\u0010\u001fYÑÛµÜ\u0011©ùE\u0018Rü\u0090\u0012½\u0018Ù£å¦\u007fÊ\u009fæ|iÂu\\\u0081ä»¿M~\u009b\u000b\u0082ä»\u0018÷^\u0088Cè\u000f-.ÆÜ\u009eØ;b\u001dáÂÔªû\u0012Ð+Â(^¥×b§Úl\u0096\u001d£à\u000fÃß6\u0083-q\u001bÌhù-c\u0091ÿjw{T\u0081Ã°N.ö\u000f÷v\u0099\u0010ÜyÔ\u001dr&Úè.\u0016¨~\u008e-\u000e\u0004\u0010Ì&2^4\u0091¨Z\u001dî\u00941z\u0017\u001bÓ\u0018'¤ºþ\u001aB³ñ¥\u0005Íó\u0087\u008f5¶\u001f$þ¾ò¸/¤ \u0017ë\nÉ,\u0016g\u001fv\u0084©9\u0006\u00adF3qÃ\u0095\u008a¸JÐÎ\u0090§!ª\u009b:S>\u0018\r!\u0086|-M\u0099LÌô:¬=<\u008d/LL\u008b\u008a³\u0099Ýç(a\u00admÂy\u0090\"ãÁÆº\u0082\u000f¥\u0096éÖ\u0012<\u0016;u¤:\u0000×$\u0098r;Beã\t¼Äd0\u0006¸\u0018\u0019{\u0098\u008c\u0019F\u001b~ÏË\u009b«B,\u0084¸@z0ô$\u0014¯\u0017\u0010ê²\u0098\u0019Ì¤ß:-ä£\u0015\u0015\u0084R\u001a(\u00ad\u008b \u008f\u0087q´\u008aË\u009aþH\u0001MÝý)ìÞü×¤\u0010\u001e4\u0018Úö£|âX»\f>8\u0092ÁTÅ\u0010ßp`µ½â\u007f\u0088«\u0085°\u0007¶Î\u0014Y(H\u0006\u0000À¦ë\u0010\u0090ûJ× \u008d£Tíx)\u00915ë&d\u0086u\u008c<ÿÅ¬±\u0006A\u001c£\u001eù1\u0007·('AH\u0006\u0081Ã;Ó\u001fÖ\u009dä>R<Î||òÅc|½.f\u0088Ó-£úùÐ´\u0089O³1YPF\u0010ÀÀ¶î©!I\u0080s,@å\b8©\\\u0010\u008dÌt\u0098¼1 .ö\\ÊÒ]÷\u009d¡ \u0017Jý\u0000\u0004\tj\u009b\u0004\r8÷;T\u0015ý:Ì\u0015\u007f×ò·q¼!)ò=éÜÜ\u0010X\u0011.ì9¦\u00ad\u008b`iu¶7£D\u0084\u0010\u0092©=%\u001bÖ\u0014Ã\u0010\u0004(£!Êí¯(üá2·1\u00adµ»þ\\Q8kN¬\u008fÿõÍAÌ°\u0006Í3\u0097p9\u0004-\u0093\u009f\u001f\u0000\u0005]\u0019ð-[\u0010cì¹2#c\u001e(\u0093\u009bQl°ªe\u0007\u0010ÿÁUØ\u0016>@\u0080Â¤\u0098O\nÙ¹Y(´³ióBøcPù@A|\u009e8¤\u0086 ¿sÞøÊÍs¤ÇÉÔ\u008a\rèÄ\u0006\u0094°¯\\RE³\u0010ke-¾d\u000bi\u001aöQ>\u008d1\u0007Òò(bÿs-á\u009aD\u0016\u008d´\u009a\u0087å\u0007/|Ì\u0097tèw4V \u0095\u0004Y5Î]î\n\u0014Ê\u0086p&TèÛ";
        String s2 = "ÐÖÍÛ],§ðDÛ\u0097Àe\u0010ìº3]J!1s\u0018'\u001dg\u000b}¼Ï*çÓÐÊZÐ¦)d\u0010\u008f¯du=\u0091K]\b^É´Û\u0015Öº ·H\u0081\u008d\u0005\u0017¹ÖÜ¡\n\tLÒ þ^\u0096\u0081\u0092é\u0010Ø\\¤Ö^O\u008e)go(9\u0017¥ÚÓ\u009c\u0019i8\u0000r.å\u0000(]¬\u0085wê'ã\u0083qÉ\u000bò/8\"\u0082ßRLnÙN\u007fÂ\u000b8lKÝ¦ÙD\u0001ê¦mð\u0094[\u0003\u008d\u0098ÀÆüfØæ\u001a8ð¯¿\u001f¤eeÇ\u008eYÒtÒîÒú¦Ø\u0095\u0007¨qçÙùd¢\u0015\u001f\u0007¦á ¢5\u00adÂ)Ë¶L¯¤e\u0088\n\u008bª¿_\u0015¼â\r\u0015>¥\u008e|oØ^5±ï(V\u0081<Xò»æ\u008b\u001b\u0017ò\u0089¾Ä\u0092É\u0006,¤íqcÀ\u0096\u009aÓ°4*µ²òl´HÇ³I\u009a\u008f\u0010I¬xâ\u001c«\u0082\u000bxÎ\u0004¤ã£\u001a\u008a0\u0010v\u007f\u0017\u008f\u001c,.\u0096«\u0010<å£ÅàÀ4e\u008f\u000fÁ\u000f\n-Dy1°ÎüïjOï£e\n>Â\b\u0005\u0093¼±õ©# >\u0095\u0017 ÐC½(2n\u0091_*ù\u008fpÛ\u0004,z\f)o7ú\u0011W1Z\u0007ÜÍ(Þ»Ç*\u001a%fþø=ÆØ[\u0006Ù\u0000Øþ\r{FJ\u0087|x\u0083µùö¼H\t£\u0018\u008f×¯\n\u008em0\u000b'\u009b\u000bÅ`\u008a¡ÛxµÏÛøÅ\nÓÇÒÇÁ}\u0002°xõs¼É¤\u009aÇ\u0015¹wa\u0099qx*\u009aô\u009c\u008bê*\u009b]\u0010º®DÞáSïö×\u001d\u0000Ãëÿf\u001b(\u0087,7§òs1 ,dËÒ\u0084\u008bÙY5ê»ÍA¬Á\u007fà\"a=M¹ÿÖ±Åÿ¦R\u0007s¤ àï´\u001d\u0094\u0006}\u0015¢8>zðÙhak\u008e-ò\u0012ØþR\fI\u00adKB¿'¥\u0010ïï8) ©7^G\u0098}\u008bÐ¡\u0096\u009b\u0010B\u0019\u008c\u00119a\u008bOm\u0093;\u001d=\u0003ø\u0084 ì¡|ñäüåR5èØ\u001c¨\u0004\u009c\u0005å\u0014ôúÈ¤`ßWD\u0018ÞpIÉþ Øïö\u008eo\u0018\u0094bÉüýn$r]µ´pr\u008b\\¹\u0007ª\u0086¿×è\u0080ëºç \u001d²áz+µÿi|©á:æc@çÖ¥v°¼\u0097¤VpBL\u0004\u009d\u00ad\u008bF\u0010D©õx*\u0003\u0099ïT\u0018{hK¯¼l /Vª \nl°÷½ópÐ\u0000 ü\u0019*(\b\u0093\u008e>·\u001b¢\bù>Oj?»\u0010©ê\u0096ßz\u0002\u0082YÆ5Â\u008a\u0093\u009c\u0016å\u0010(#Õ,\r\u0094ÀöÝYñáRA(P\u0010\u000e3Ø\u0084a\u009c\r\u0092\u0092\f\u0099çbùd\u001b Z\u0011Bè\u0096FÆª\u008aF³\u0012ë\u0092ââUÐê^\u0094³MbêéS$GrQE\u0010\u001fYÑÛµÜ\u0011©ùE\u0018Rü\u0090\u0012½\u0018Ù£å¦\u007fÊ\u009fæ|iÂu\\\u0081ä»¿M~\u009b\u000b\u0082ä»\u0018÷^\u0088Cè\u000f-.ÆÜ\u009eØ;b\u001dáÂÔªû\u0012Ð+Â(^¥×b§Úl\u0096\u001d£à\u000fÃß6\u0083-q\u001bÌhù-c\u0091ÿjw{T\u0081Ã°N.ö\u000f÷v\u0099\u0010ÜyÔ\u001dr&Úè.\u0016¨~\u008e-\u000e\u0004\u0010Ì&2^4\u0091¨Z\u001dî\u00941z\u0017\u001bÓ\u0018'¤ºþ\u001aB³ñ¥\u0005Íó\u0087\u008f5¶\u001f$þ¾ò¸/¤ \u0017ë\nÉ,\u0016g\u001fv\u0084©9\u0006\u00adF3qÃ\u0095\u008a¸JÐÎ\u0090§!ª\u009b:S>\u0018\r!\u0086|-M\u0099LÌô:¬=<\u008d/LL\u008b\u008a³\u0099Ýç(a\u00admÂy\u0090\"ãÁÆº\u0082\u000f¥\u0096éÖ\u0012<\u0016;u¤:\u0000×$\u0098r;Beã\t¼Äd0\u0006¸\u0018\u0019{\u0098\u008c\u0019F\u001b~ÏË\u009b«B,\u0084¸@z0ô$\u0014¯\u0017\u0010ê²\u0098\u0019Ì¤ß:-ä£\u0015\u0015\u0084R\u001a(\u00ad\u008b \u008f\u0087q´\u008aË\u009aþH\u0001MÝý)ìÞü×¤\u0010\u001e4\u0018Úö£|âX»\f>8\u0092ÁTÅ\u0010ßp`µ½â\u007f\u0088«\u0085°\u0007¶Î\u0014Y(H\u0006\u0000À¦ë\u0010\u0090ûJ× \u008d£Tíx)\u00915ë&d\u0086u\u008c<ÿÅ¬±\u0006A\u001c£\u001eù1\u0007·('AH\u0006\u0081Ã;Ó\u001fÖ\u009dä>R<Î||òÅc|½.f\u0088Ó-£úùÐ´\u0089O³1YPF\u0010ÀÀ¶î©!I\u0080s,@å\b8©\\\u0010\u008dÌt\u0098¼1 .ö\\ÊÒ]÷\u009d¡ \u0017Jý\u0000\u0004\tj\u009b\u0004\r8÷;T\u0015ý:Ì\u0015\u007f×ò·q¼!)ò=éÜÜ\u0010X\u0011.ì9¦\u00ad\u008b`iu¶7£D\u0084\u0010\u0092©=%\u001bÖ\u0014Ã\u0010\u0004(£!Êí¯(üá2·1\u00adµ»þ\\Q8kN¬\u008fÿõÍAÌ°\u0006Í3\u0097p9\u0004-\u0093\u009f\u001f\u0000\u0005]\u0019ð-[\u0010cì¹2#c\u001e(\u0093\u009bQl°ªe\u0007\u0010ÿÁUØ\u0016>@\u0080Â¤\u0098O\nÙ¹Y(´³ióBøcPù@A|\u009e8¤\u0086 ¿sÞøÊÍs¤ÇÉÔ\u008a\rèÄ\u0006\u0094°¯\\RE³\u0010ke-¾d\u000bi\u001aöQ>\u008d1\u0007Òò(bÿs-á\u009aD\u0016\u008d´\u009a\u0087å\u0007/|Ì\u0097tèw4V \u0095\u0004Y5Î]î\n\u0014Ê\u0086p&TèÛ";
        int n3 = s.length();
        int n4 = 40;
        int n5 = -1;
    Label_0149:
        while (true) {
            while (true) {
                ++n5;
                final String s3 = s2;
                final int n6 = n5;
                String s4 = s3.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s4.getBytes(KillAura.lllIllllI[7]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                continue Label_0149;
                            }
                            n3 = (s2 = KillAura.lllIllllI[6]).length();
                            n4 = 56;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                break;
                            }
                            break Label_0149;
                        }
                    }
                    ++n5;
                    final String s5 = s2;
                    final int n8 = n5;
                    s4 = s5.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        c = c2;
        d = new String[55];
        KillAura.autoBlock = new Value<Boolean>("KillAura_AutoBlock", Boolean.TRUE);
        KillAura.reach = new Value<Double>("KillAura_Range", 4.2, 3.0, 6.0, 0.1);
        KillAura.switchsize = new Value<Double>("KillAura_MaxTargets", 1.0, 1.0, 5.0, 1.0);
        KillAura.isBlocking = false;
        KillAura.targets = new ArrayList<EntityLivingBase>();
        KillAura.attacked = new ArrayList<EntityLivingBase>();
        KillAura.target = null;
        KillAura.needHitBot = null;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x141C;
        if (KillAura.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = KillAura.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(KillAura.lllIllllI[8]);
                    array[1] = SecretKeyFactory.getInstance(KillAura.lllIllllI[9]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    KillAura.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(KillAura.lllIllllI[10], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            KillAura.d[n3] = b(((Cipher)array[0]).doFinal(KillAura.c[n3].getBytes(KillAura.lllIllllI[11])));
        }
        return KillAura.d[n3];
    }
    
    private static void lIlIllIlIII() {
        (lllIllllI = new String[15])[0] = " ";
        KillAura.lllIllllI[1] = "";
        KillAura.lllIllllI[2] = "";
        KillAura.lllIllllI[3] = " ";
        KillAura.lllIllllI[4] = "DES/CBC/PKCS5Padding";
        KillAura.lllIllllI[5] = "DES";
        KillAura.lllIllllI[6] = "+\u0081OÇ\"ÕY\\\u00ad½âÀ:Iæ\u0088\tßà\u008bìÄ·\u0080kjó<¡Á\u0096\u0013\u0019¨ÒkW\u000eÇÖ'Ú&\u0092\u009eÖqE\u0003V2f¯X\u0095ç(ÀÄÇ\b\fZkËX]\u009eÁu¿Í\u008fÛ\u0015D}?x\u009d\u001d\u0006ÉOGr¦\u00178g]¢\u009e¿T«ñ";
        KillAura.lllIllllI[7] = "ISO-8859-1";
        KillAura.lllIllllI[8] = "DES/CBC/PKCS5Padding";
        KillAura.lllIllllI[9] = "DES";
        KillAura.lllIllllI[10] = "你为什么总是这么傻你快去非洲吗你是不是无与伦比的窝囊废啊你还想赢吗而兴奋就必定导致你最后会跪倒在我面前知道吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2001 \u200d\u2003";
        KillAura.lllIllllI[11] = "ISO-8859-1";
        KillAura.lllIllllI[12] = "你为什么总是这么傻你快去非洲吗你是不是无与伦比的窝囊废啊你还想赢吗而兴奋就必定导致你最后会跪倒在我面前知道吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2001 \u200d\u2003";
        KillAura.lllIllllI[13] = " : ";
        KillAura.lllIllllI[14] = " : ";
    }
    
    private static String lIlIllIIllI(final String s, final String s2) {
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
    
    private static String lIlIllIIlll(String s, final String s2) {
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
    
    private static String lIlIlIlllIl(final String s, final String s2) {
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
    
    private static boolean lIlIlllIlll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIllIIllllI$255f299(final int n) {
        return n <= 10;
    }
    
    private static boolean lIlIlllIIlI$255f299(final int n) {
        return n > 1;
    }
    
    private static boolean lIllIIlllIl(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIlIlllIlIl(final int n) {
        return n >= 0;
    }
    
    private static boolean lIlIlllIIII(final int n) {
        return n < 0;
    }
    
    private static boolean lIllIIIIIII(final int n) {
        return n <= 0;
    }
    
    private static boolean lIlIllllIII(final int n) {
        return n > 0;
    }
    
    private static int lIlIllIlllI(final float n, final float n2) {
        return fcmpg(n, n2);
    }
    
    private static int lIlIlllIlII(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIlllIllI(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIlllllll(final double n, final double n2) {
        return dcmpl(n, n2);
    }
    
    private static int lIlIlllllIl(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIllIIllIII$2548a28(final float n) {
        return fcmpg(n, 1.0f);
    }
    
    private static int lIllIIlIlll(final double n, final double n2) {
        return dcmpg(n, n2);
    }
    
    private static int lIllIIlllll$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
    
    private static int lIllIlIIIII(final double n, final double n2) {
        return dcmpg(n, n2);
    }
}
