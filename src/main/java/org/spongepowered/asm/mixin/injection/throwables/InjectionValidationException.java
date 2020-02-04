package org.spongepowered.asm.mixin.injection.throwables;

import org.spongepowered.asm.mixin.injection.struct.*;

public final class InjectionValidationException extends Exception
{
    private static final long serialVersionUID = 1L;
    public final InjectorGroupInfo group;
    
    public InjectionValidationException(final InjectorGroupInfo group, final String s) {
        super(s);
        this.group = group;
    }
    
    private InjectorGroupInfo getGroup() {
        return this.group;
    }
}
