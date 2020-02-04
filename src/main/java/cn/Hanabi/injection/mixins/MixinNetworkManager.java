package cn.Hanabi.injection.mixins;

import cn.Hanabi.injection.interfaces.*;
import io.netty.channel.*;
import org.spongepowered.asm.mixin.*;
import java.util.*;
import net.minecraft.network.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.darkmagician6.eventapi.types.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import org.spongepowered.asm.mixin.injection.*;
import io.netty.util.concurrent.*;

@Mixin({ NetworkManager.class })
public abstract class MixinNetworkManager implements INetworkManager
{
    @Shadow
    private Channel field_150746_k;
    @Shadow
    private Queue field_150745_j;
    
    public MixinNetworkManager() {
        super();
    }
    
    @Inject(method = { "channelRead0" }, at = { @At(value = "INVOKE", target = "Lnet/minecraft/network/Packet;processPacket(Lnet/minecraft/network/INetHandler;)V", shift = At.Shift.BEFORE) }, cancellable = true)
    private static void packetReceived$7e29475e(final Packet packet, final CallbackInfo callbackInfo) {
        final EventPacket eventPacket;
        EventManager.call(eventPacket = new EventPacket(EventType.RECIEVE, packet));
        if (eventPacket.isCancelled()) {
            callbackInfo.cancel();
        }
    }
    
    @Inject(method = { "sendPacket(Lnet/minecraft/network/Packet;)V" }, at = { @At("HEAD") }, cancellable = true)
    private static void sendPacket(final Packet packet, final CallbackInfo callbackInfo) {
        final EventPacket eventPacket;
        EventManager.call(eventPacket = new EventPacket(EventType.SEND, packet));
        if (eventPacket.isCancelled()) {
            callbackInfo.cancel();
        }
    }
    
    @Override
    public final void sendPacketNoEvent$37e9f079() {
        null.add(new InboundHandlerTuplePacketListener());
    }
    
    @Shadow
    protected abstract void func_150732_b$3d6aa510();
    
    @Shadow
    protected abstract void func_150733_h();
}
