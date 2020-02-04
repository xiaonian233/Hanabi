package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.*;

@Mixin({ S02PacketChat.class })
public final class MixinS02PacketChat implements IS02PacketChat
{
    @Shadow
    private IChatComponent field_148919_a;
    
    public MixinS02PacketChat() {
        super();
    }
    
    @Override
    public final void setIChatComponent$79d82e49() {
    }
}
