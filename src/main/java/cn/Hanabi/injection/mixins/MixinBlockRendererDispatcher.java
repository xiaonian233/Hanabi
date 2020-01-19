package cn.Hanabi.injection.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.block.state.*;
import net.minecraft.util.*;
import net.minecraft.world.*;
import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ BlockRendererDispatcher.class })
public class MixinBlockRendererDispatcher
{
    public MixinBlockRendererDispatcher() {
        super();
    }
    
    @Inject(method = { "renderBlock" }, at = { @At("HEAD") })
    public void eventUpdate(final IBlockState state, final BlockPos pos, final IBlockAccess blockAccess, final WorldRenderer worldRendererIn, final CallbackInfoReturnable info) {
        final EventRenderBlock event = new EventRenderBlock(pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), state.func_177230_c());
        EventManager.call((Event)event);
    }
}
