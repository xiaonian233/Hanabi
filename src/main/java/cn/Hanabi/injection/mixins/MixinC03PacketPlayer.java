package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.network.play.client.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ C03PacketPlayer.class })
public final class MixinC03PacketPlayer implements IC03PacketPlayer
{
    @Shadow
    private boolean field_149474_g;
    @Shadow
    private double field_149477_b;
    @Shadow
    private float field_149476_e;
    @Shadow
    private float field_149473_f;
    @Shadow
    private boolean field_149481_i;
    
    public MixinC03PacketPlayer() {
        super();
    }
    
    @Override
    public final boolean isOnGround() {
        return this.field_149474_g;
    }
    
    @Override
    public final void setOnGround(final boolean field_149474_g) {
        this.field_149474_g = field_149474_g;
    }
    
    @Override
    public final void setPosY$133369() {
    }
    
    @Override
    public final void setYaw(final float field_149476_e) {
        this.field_149476_e = field_149476_e;
    }
    
    @Override
    public final float getYaw() {
        return this.field_149476_e;
    }
    
    @Override
    public final void setPitch(final float field_149473_f) {
        this.field_149473_f = field_149473_f;
    }
    
    @Override
    public final float getPitch() {
        return this.field_149473_f;
    }
    
    @Override
    public final void setRotate$1385ff() {
        this.field_149481_i = true;
    }
    
    @Override
    public final boolean getRotate() {
        return this.field_149481_i;
    }
}
