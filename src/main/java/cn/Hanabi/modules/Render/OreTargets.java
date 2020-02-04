package cn.Hanabi.modules.Render;

import net.minecraft.client.*;
import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import java.util.function.*;
import java.util.stream.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.events.*;
import net.minecraft.init.*;
import net.minecraft.block.*;
import org.lwjgl.opengl.*;
import net.minecraft.util.*;
import net.minecraft.client.renderer.vertex.*;
import net.minecraft.client.renderer.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.util.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;

public final class OreTargets extends Mod
{
    private Minecraft mc;
    private static List<BlockPos> toRender;
    private Value<Boolean> dia;
    private Value<Boolean> gold;
    private Value<Boolean> iron;
    private Value<Boolean> lapis;
    private Value<Boolean> emerald;
    private Value<Boolean> coal;
    private Value<Boolean> redstone;
    private Value<Boolean> bypass;
    private Value<Double> depth;
    private Value<Boolean> radiusOn;
    private Value<Double> radius;
    private Value<Boolean> limitEnabled;
    private Value<Double> limit;
    private Value<Double> refresh_timer;
    private Value<Double> alpha;
    private Value<Double> width;
    private Class220 refresh;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llIIlIlIlI;
    
    public OreTargets() {
        super("OreTargets", Category.RENDER);
        this.mc = Minecraft.func_71410_x();
        this.dia = new Value<Boolean>("OreTargets_Diamond", Boolean.TRUE);
        this.gold = new Value<Boolean>("OreTargets_Gold", Boolean.TRUE);
        this.iron = new Value<Boolean>("OreTargets_Iron", Boolean.TRUE);
        this.lapis = new Value<Boolean>("OreTargets_Lapis", Boolean.TRUE);
        this.emerald = new Value<Boolean>("OreTargets_Emerald", Boolean.TRUE);
        this.coal = new Value<Boolean>("OreTargets_Coal", Boolean.TRUE);
        this.redstone = new Value<Boolean>("OreTargets_Redstone", Boolean.TRUE);
        this.bypass = new Value<Boolean>("OreTargets_TouchingAirOrLiquidTest", Boolean.TRUE);
        this.depth = new Value<Double>("OreTargets_TestDepth", 2.0, 1.0, 5.0, 1.0);
        this.radiusOn = new Value<Boolean>("OreTargets_DistanceLimitEnabled", Boolean.TRUE);
        this.radius = new Value<Double>("OreTargets_DistanceLimit", 10.0, 5.0, 100.0, 5.0);
        this.limitEnabled = new Value<Boolean>("OreTargets_RenderLimitEnabled", Boolean.TRUE);
        this.limit = new Value<Double>("OreTargets_RenderLimit", 10.0, 5.0, 100.0, 5.0);
        this.refresh_timer = new Value<Double>("OreTargets_RefreshListDelayMillis", 20.0, 0.0, 1000.0, 20.0);
        this.alpha = new Value<Double>("OreTargets_Alpha", 0.25, 0.0, 1.0, 0.05);
        this.width = new Value<Double>("OreTargets_LineWidth", 2.5, 1.0, 10.0, 0.5);
        this.refresh = new Class220();
    }

//看你妈就想抄这个？
}
