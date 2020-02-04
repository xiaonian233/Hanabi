package com.darkmagician6.eventapi.events;

public abstract class EventStoppable implements Event
{
    public boolean stopped;
    
    protected EventStoppable() {
        super();
    }
    
    private void stop() {
        this.stopped = true;
    }
    
    private boolean isStopped() {
        return this.stopped;
    }
}
