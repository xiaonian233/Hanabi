package cn.Hanabi.injection.mixins;

import net.minecraft.client.renderer.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ BlockModelRenderer.class })
public abstract class MixinBlockModelRenderer
{
    public MixinBlockModelRenderer() {
        super();
    }
    
    @Shadow
    public abstract boolean func_178258_b$4d4b8fe6();
    
    @Shadow
    public abstract boolean func_178265_a$4d4b8fe6();
}
