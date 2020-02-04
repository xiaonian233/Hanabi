package org.spongepowered.asm.mixin.injection.throwables;

import org.spongepowered.asm.mixin.refmap.*;
import org.spongepowered.asm.mixin.injection.struct.*;

public final class InvalidInjectionPointException extends InvalidInjectionException
{
    private static final long serialVersionUID = 2L;
    
    public InvalidInjectionPointException(final IMixinContext mixinContext, final String s, final Object... array) {
        super(mixinContext, String.format(s, array));
    }
    
    private InvalidInjectionPointException(final InjectionInfo injectionInfo, final String s, final Object... array) {
        super(injectionInfo, String.format(s, array));
    }
    
    private InvalidInjectionPointException(final IMixinContext mixinContext, final Throwable t, final String s, final Object... array) {
        super(mixinContext, String.format(s, array), t);
    }
    
    private InvalidInjectionPointException(final InjectionInfo injectionInfo, final Throwable t, final String s, final Object... array) {
        super(injectionInfo, String.format(s, array), t);
    }
}
