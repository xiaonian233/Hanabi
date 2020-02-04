package cn.Hanabi.injection.mixins;

import net.minecraft.client.renderer.entity.*;
import org.spongepowered.asm.mixin.*;
import net.minecraft.entity.*;

@Mixin({ Render.class })
public abstract class MixinRender
{
    @Shadow
    private RenderManager field_76990_c;
    
    public MixinRender() {
        super();
    }
    
    @Shadow
    private static <T extends Entity> void func_76986_a$35d5a713() {
    }
}
