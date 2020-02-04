package cn.Hanabi.injection.mixins;

import net.minecraftforge.fml.relauncher.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.client.gui.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.spongepowered.asm.mixin.injection.*;

@SideOnly(Side.CLIENT)
@Mixin({ GuiSpectator.class })
public final class MixinGuiSpectator
{
    public MixinGuiSpectator() {
        super();
    }
    
    @Inject(method = { "renderTooltip" }, at = { @At("RETURN") })
    private static void renderTooltip$9842210(final float n) {
        EventManager.call(new EventRender2D(n));
    }
}
