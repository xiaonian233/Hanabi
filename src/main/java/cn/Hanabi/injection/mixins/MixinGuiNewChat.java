package cn.Hanabi.injection.mixins;

import org.spongepowered.asm.mixin.*;
import net.minecraft.client.gui.*;
import net.minecraft.util.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.spongepowered.asm.mixin.injection.*;

@Mixin({ GuiNewChat.class })
public final class MixinGuiNewChat
{
    public MixinGuiNewChat() {
        super();
    }
    
    @Inject(method = { "printChatMessageWithOptionalDeletion" }, at = { @At("HEAD") }, cancellable = true)
    private static void eventchat$4264182(final IChatComponent chatComponent, final CallbackInfo callbackInfo) {
        final EventChat eventChat;
        EventManager.call(eventChat = new EventChat(chatComponent.func_150260_c()));
        if (eventChat.cancelled) {
            callbackInfo.cancel();
        }
    }
}
