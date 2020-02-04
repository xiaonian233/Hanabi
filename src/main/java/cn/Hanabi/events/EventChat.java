package cn.Hanabi.events;

import com.darkmagician6.eventapi.events.*;

public final class EventChat implements Event
{
    public String message;
    public boolean cancelled;
    
    public EventChat(final String message) {
        super();
        this.message = message;
    }
    
    private String getMessage() {
        return this.message;
    }
    
    private void setCancelled$1385ff() {
        this.cancelled = true;
    }
}
