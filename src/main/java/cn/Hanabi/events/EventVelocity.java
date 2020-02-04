package cn.Hanabi.events;

import com.darkmagician6.eventapi.events.callables.*;

public final class EventVelocity extends EventCancellable
{
    private double x;
    private double y;
    private double z;
    
    private EventVelocity(final double x, final double y, final double z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    private double getX() {
        return this.x;
    }
    
    private void setX(final double x) {
        this.x = x;
    }
    
    private double getY() {
        return this.y;
    }
    
    private void setY(final double y) {
        this.y = y;
    }
    
    private double getZ() {
        return this.z;
    }
    
    private void setZ(final double z) {
        this.z = z;
    }
}
