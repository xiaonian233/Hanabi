package cn.Hanabi.events;

import com.darkmagician6.eventapi.events.callables.*;
import cn.Hanabi.modules.*;
import java.lang.invoke.*;
import ClassSub.*;

public final class EventPreMotion extends EventCancellable
{
    public double x;
    public double y;
    public double z;
    public float yaw;
    public float pitch;
    public boolean onGround;
    public boolean cancel;
    private static final long a;
    
    public EventPreMotion(final double x, final double y, final double z, final float yaw, final float pitch, final boolean onGround) {
        EventPacket.b();
        super();
        this.x = x;
        this.y = y;
        this.z = z;
        this.yaw = yaw;
        this.pitch = pitch;
        this.onGround = onGround;
        if (Mod.b() == null) {
            EventPacket.b(new String[5]);
        }
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
    
    private float getYaw() {
        return this.yaw;
    }
    
    private void setYaw(final float yaw) {
        this.yaw = yaw;
    }
    
    private float getPitch() {
        return this.pitch;
    }
    
    private void setPitch(final float pitch) {
        this.pitch = pitch;
    }
    
    private boolean isOnGround() {
        return this.onGround;
    }
    
    private void setOnGround$1385ff() {
        this.onGround = false;
    }
    
    private boolean isCancel() {
        return this.cancel;
    }
    
    private void setCancel(final boolean cancel) {
        this.cancel = cancel;
    }
    
    @Override
    public final boolean isCancelled() {
        return this.cancel;
    }
    
    @Override
    public final void setCancelled$1385ff() {
        this.cancel = true;
    }
    
    static {
        Class169.a(4572112665413023269L, 2992699228977421245L, MethodHandles.lookup().lookupClass()).a(139792144191976L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
