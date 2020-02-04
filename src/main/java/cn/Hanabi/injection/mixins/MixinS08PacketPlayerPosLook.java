package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.network.play.server.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ S08PacketPlayerPosLook.class })
public final class MixinS08PacketPlayerPosLook implements IS08PacketPlayerPosLook
{
    @Shadow
    private float field_148936_d;
    @Shadow
    private float field_148937_e;
    
    public MixinS08PacketPlayerPosLook() {
        super();
    }
    
    @Override
    public final void setYaw$133aeb() {
    }
    
    @Override
    public final void setPitch$133aeb() {
    }
}
