package cn.Hanabi.injection.mixins;

import net.minecraftforge.fml.relauncher.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.*;
import net.minecraft.client.gui.*;
import com.google.common.base.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import com.google.common.collect.*;
import net.minecraft.client.*;
import net.minecraft.util.*;
import ClassSub.*;
import net.minecraft.scoreboard.*;
import java.util.*;

@SideOnly(Side.CLIENT)
@Mixin({ GuiIngame.class })
public final class MixinGuiIngame
{
    private static final String[] lIIIlIllIIl;
    
    public MixinGuiIngame() {
        super();
    }
    
    @Inject(method = { "renderTooltip" }, at = { @At("HEAD") }, cancellable = true)
    private static void renderTooltip$9842210(final float n, final CallbackInfo callbackInfo) {
        EventManager.call(new EventRender2D(n));
        GlStateManager.func_179124_c(1.0f, 1.0f, 1.0f);
        if (Class4.getModule(MixinGuiIngame.lIIIlIllIIl[0]).state && ((Class102)Class4.getModule(MixinGuiIngame.lIIIlIllIIl[1])).hotbar.value) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "renderScoreboard" }, at = { @At("HEAD") }, cancellable = true)
    private static void customBoard(final ScoreObjective scoreObjective, final ScaledResolution scaledResolution, final CallbackInfo callbackInfo) {
        if (Class139.INSTANCE.sbm == null) {
            final Scoreboard func_96682_a;
            final Collection func_96534_i;
            final ArrayList arrayList;
            ArrayList arrayList2;
            if ((arrayList = Lists.newArrayList(Iterables.filter((Iterable)(func_96534_i = (func_96682_a = scoreObjective.func_96682_a()).func_96534_i(scoreObjective)), (Predicate)new Predicate<Score>() {
                private /* synthetic */ MixinGuiIngame this$0;
                private static final String[] llIllIllIlI;
                
                MixinGuiIngame$1() {
                    super();
                }
                
                private static boolean apply(final Score score) {
                    return score.func_96653_e() != null && !score.func_96653_e().startsWith(MixinGuiIngame$1.llIllIllIlI[0]);
                }
                
                public final /* bridge */ boolean apply(final Object o) {
                    final Score score;
                    return (score = (Score)o).func_96653_e() != null && !score.func_96653_e().startsWith(MixinGuiIngame$1.llIllIllIlI[0]);
                }
                
                static {
                    lIIlIlllllIlI();
                }
                
                private static void lIIlIlllllIlI() {
                    (llIllIllIlI = new String[] { null })[0] = "#";
                }
                
                private static String lIIlIllllIlll(final String s, final String s2) {
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
            }))).size() > 15) {
                arrayList2 = Lists.newArrayList(Iterables.skip((Iterable)arrayList, func_96534_i.size() - 15));
            }
            else {
                arrayList2 = arrayList;
            }
            int n = Minecraft.func_71410_x().field_71466_p.func_78256_a(scoreObjective.func_96678_d());
            for (final Score score : arrayList2) {
                n = Math.max(n, Minecraft.func_71410_x().field_71466_p.func_78256_a(String.valueOf(new StringBuilder().append(ScorePlayerTeam.func_96667_a((Team)func_96682_a.func_96509_i(score.func_96653_e()), score.func_96653_e())).append(MixinGuiIngame.lIIIlIllIIl[2]).append(EnumChatFormatting.RED).append(score.func_96652_c()))));
            }
            Class139.INSTANCE.sbm = new Class25(scaledResolution.func_78326_a() - n - 4, scaledResolution.func_78328_b() / 2 + arrayList2.size() * Minecraft.func_71410_x().field_71466_p.field_78288_b / 3);
        }
        if (Class139.INSTANCE.sbm != null) {
            Class139.INSTANCE.sbm.passValue();
        }
        callbackInfo.cancel();
    }
    
    static {
        llIIlIllIIII();
    }
    
    private static void llIIlIllIIII() {
        (lIIIlIllIIl = new String[3])[0] = "HUD";
        MixinGuiIngame.lIIIlIllIIl[1] = "HUD";
        MixinGuiIngame.lIIIlIllIIl[2] = ": ";
    }
    
    private static String llIIlIlIlIll(final String s, final String s2) {
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
    
    private static String llIIlIlIllll(final String s, final String s2) {
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
    
    private static boolean llIIlIllIlll$255f299(final int n) {
        return n > 15;
    }
}
