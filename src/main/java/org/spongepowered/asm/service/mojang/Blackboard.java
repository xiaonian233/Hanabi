package org.spongepowered.asm.service.mojang;

import org.spongepowered.asm.service.*;
import net.minecraft.launchwrapper.*;

public final class Blackboard implements IGlobalPropertyService
{
    public Blackboard() {
        super();
    }
    
    @Override
    public final <T> T getProperty(final String s) {
        return Launch.blackboard.get(s);
    }
    
    @Override
    public final void setProperty(final String s, final Object o) {
        Launch.blackboard.put(s, o);
    }
    
    @Override
    public final <T> T getProperty(final String s, final T t) {
        final T value;
        if ((value = Launch.blackboard.get(s)) != null) {
            return value;
        }
        return t;
    }
    
    @Override
    public final String getPropertyString(final String s, final String s2) {
        final Object value;
        if ((value = Launch.blackboard.get(s)) != null) {
            return value.toString();
        }
        return s2;
    }
}
