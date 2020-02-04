package cn.Hanabi.events;

import com.darkmagician6.eventapi.events.*;
import net.minecraft.entity.*;
import cn.Hanabi.modules.*;
import java.lang.invoke.*;
import ClassSub.*;

public final class EventRenderLivingEntity implements Cancellable, Event
{
    public EntityLivingBase entity;
    public boolean pre;
    private float limbSwing;
    private float limbSwingAmount;
    private float ageInTicks;
    private float rotationYawHead;
    private float rotationPitch;
    private float chestRot;
    private float offset;
    public boolean cancelled;
    private static final long a;
    
    public EventRenderLivingEntity(final EntityLivingBase entity, final float limbSwing, final float limbSwingAmount, final float ageInTicks, final float rotationYawHead, final float rotationPitch, final float chestRot) {
        super();
        this.entity = entity;
        this.pre = true;
        final String[] b = EventPacket.b();
        this.limbSwing = limbSwing;
        this.limbSwingAmount = limbSwingAmount;
        this.ageInTicks = ageInTicks;
        this.rotationYawHead = rotationYawHead;
        this.rotationPitch = rotationPitch;
        this.chestRot = chestRot;
        final String[] array = b;
        this.offset = 0.0625f;
        this.cancelled = false;
        if (array == null) {
            Mod.b(new Mod[3]);
        }
    }
    
    public EventRenderLivingEntity(final EntityLivingBase entity) {
        super();
        this.entity = entity;
        this.pre = false;
    }
    
    private EntityLivingBase getEntity() {
        return this.entity;
    }
    
    private boolean isPre() {
        return this.pre;
    }
    
    private boolean isPost() {
        final String[] b = EventPacket.b();
        final boolean pre = this.pre;
        return (b == null || !pre) && pre;
    }
    
    private float getLimbSwing() {
        return this.limbSwing;
    }
    
    private void setLimbSwing(final float limbSwing) {
        this.limbSwing = limbSwing;
    }
    
    private float getLimbSwingAmount() {
        return this.limbSwingAmount;
    }
    
    private void setLimbSwingAmount(final float limbSwingAmount) {
        this.limbSwingAmount = limbSwingAmount;
    }
    
    private float getAgeInTicks() {
        return this.ageInTicks;
    }
    
    private void setAgeInTicks(final float ageInTicks) {
        this.ageInTicks = ageInTicks;
    }
    
    private float getRotationYawHead() {
        return this.rotationYawHead;
    }
    
    private void setRotationYawHead(final float rotationYawHead) {
        this.rotationYawHead = rotationYawHead;
    }
    
    private float getRotationPitch() {
        return this.rotationPitch;
    }
    
    private void setRotationPitch(final float rotationPitch) {
        this.rotationPitch = rotationPitch;
    }
    
    private float getOffset() {
        return this.offset;
    }
    
    private void setOffset(final float offset) {
        this.offset = offset;
    }
    
    private float getRotationChest() {
        return this.chestRot;
    }
    
    private void setRotationChest(final float chestRot) {
        this.chestRot = chestRot;
    }
    
    @Override
    public final boolean isCancelled() {
        return this.cancelled;
    }
    
    @Override
    public final void setCancelled$1385ff() {
        this.cancelled = true;
    }
    
    static {
        Class169.a(5500323147757305711L, 377800683421244478L, MethodHandles.lookup().lookupClass()).a(268494885746735L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
