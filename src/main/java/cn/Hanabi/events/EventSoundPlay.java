package cn.Hanabi.events;

import com.darkmagician6.eventapi.events.*;
import net.minecraft.entity.*;

public final class EventSoundPlay implements Event
{
    private Entity entity;
    private String name;
    public boolean cancel;
    
    public EventSoundPlay(final Entity entity, final String name) {
        super();
        this.entity = entity;
        this.name = name;
    }
    
    private Entity getEntity() {
        return this.entity;
    }
    
    private String getName() {
        return this.name;
    }
    
    private void setCancelled(final boolean cancel) {
        this.cancel = cancel;
    }
}
