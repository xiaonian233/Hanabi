package ClassSub;

import java.util.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import cn.Hanabi.events.*;
import net.minecraft.block.*;
import com.darkmagician6.eventapi.*;
import java.util.function.*;
import java.lang.invoke.*;

public final class Class315
{
    public static ArrayList<BlockPos> list;
    private static final long a;
    
    public Class315() {
        super();
    }
    
    private static void update() {
        Minecraft.func_71410_x().field_71438_f.func_72712_a();
        Class315.list.clear();
    }
    
    @EventTarget
    private static void onRenderBlock(final EventRenderBlock eventRenderBlock) {
        final int[] b = Class139.b();
        final BlockPos blockPos = new BlockPos(eventRenderBlock.x, eventRenderBlock.y, eventRenderBlock.z);
        final int[] array = b;
        final boolean contains = Class315.list.contains(blockPos);
        if (array == null) {
            if (contains) {
                return;
            }
            final boolean b2 = eventRenderBlock.block instanceof BlockBed;
        }
        if (array == null) {
            if (contains) {
                Class315.list.add(blockPos);
            }
        }
    }
    
    @EventTarget
    private static void onUpdate$3d4b95ff() {
        Class315.list.removeIf(Class315::lambda$onUpdate$0);
    }
    
    private static boolean lambda$onUpdate$0(final BlockPos blockPos) {
        final int[] b = Class139.b();
        final boolean b2 = Minecraft.func_71410_x().field_71441_e.func_180495_p(blockPos).func_177230_c() instanceof BlockBed;
        return (b != null || !b2) && b2;
    }
    
    static {
        Class169.a(5866628144149260139L, 3937763154435162478L, MethodHandles.lookup().lookupClass()).a(47702723003205L);
        Class315.list = new ArrayList<BlockPos>();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
