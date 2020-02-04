package cn.Hanabi.events;

import com.darkmagician6.eventapi.events.callables.*;

public final class EventSafeWalk extends EventCancellable
{
    public boolean safe;
    
    public EventSafeWalk() {
        super();
        this.safe = false;
    }
    
    private void setSafe$1385ff() {
        this.safe = true;
    }
    
    private boolean getSafe() {
        return this.safe;
    }
}
