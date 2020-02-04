package cn.Hanabi.events;

import com.darkmagician6.eventapi.events.*;

public final class EventKey implements Event
{
    public int key;
    
    public EventKey(final int key) {
        super();
        this.key = key;
    }
    
    private int getKey() {
        return this.key;
    }
}
