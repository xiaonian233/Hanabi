package cn.Hanabi.events;

import com.darkmagician6.eventapi.events.callables.*;
import com.darkmagician6.eventapi.types.*;
import net.minecraft.network.*;
import net.minecraft.network.play.server.*;
import com.darkmagician6.eventapi.*;
import com.darkmagician6.eventapi.events.*;
import java.lang.invoke.*;
import ClassSub.*;

public final class EventPacket extends EventCancellable
{
    public final EventType eventType;
    public Packet packet;
    private static String[] a;
    private static final long b;
    
    public EventPacket(final EventType eventType, final Packet packet) {
        final String[] a = EventPacket.a;
        super();
        final String[] array = a;
        this.eventType = eventType;
        this.packet = packet;
        if (array != null) {
            if (this.packet instanceof S08PacketPlayerPosLook) {
                EventManager.call(new EventPullback());
            }
        }
    }
    
    private EventType getEventType() {
        return this.eventType;
    }
    
    private Packet getPacket() {
        return this.packet;
    }
    
    private void setPacket(final Packet packet) {
        this.packet = packet;
    }
    
    public static void b(final String[] a) {
        EventPacket.a = a;
    }
    
    public static String[] b() {
        return EventPacket.a;
    }
    
    static {
        Class169.a(2282616258748037934L, 265863450899753201L, MethodHandles.lookup().lookupClass()).a(10649819219934L);
        if (EventPacket.a == null) {
            EventPacket.a = new String[3];
        }
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
