package cn.Hanabi.injection.mixins;

import net.minecraft.client.gui.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ Gui.class })
public abstract class MixinGui
{
    @Shadow
    protected float field_73735_i;
    
    public MixinGui() {
        super();
    }
}
