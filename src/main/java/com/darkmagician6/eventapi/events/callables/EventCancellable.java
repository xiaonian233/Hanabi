package com.darkmagician6.eventapi.events.callables;

import com.darkmagician6.eventapi.events.*;

public abstract class EventCancellable implements Cancellable, Event
{
    private boolean cancelled;
    
    public EventCancellable() {
        super();
    }
    
    @Override
    public boolean isCancelled() {
        return this.cancelled;
    }
    
    @Override
    public void setCancelled$1385ff() {
        this.cancelled = true;
    }
}
