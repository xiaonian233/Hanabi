package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.renderer.entity.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ RenderManager.class })
public final class MixinRenderManager implements IRenderManager
{
    @Shadow
    private double field_78725_b;
    @Shadow
    private double field_78726_c;
    @Shadow
    private double field_78723_d;
    
    public MixinRenderManager() {
        super();
    }
    
    @Override
    public final double getRenderPosX() {
        return 0.0;
    }
    
    @Override
    public final double getRenderPosY() {
        return 0.0;
    }
    
    @Override
    public final double getRenderPosZ() {
        return 0.0;
    }
}
