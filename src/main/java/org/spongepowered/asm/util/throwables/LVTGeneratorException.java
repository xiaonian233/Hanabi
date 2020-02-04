package org.spongepowered.asm.util.throwables;

import org.spongepowered.asm.mixin.throwables.*;

public final class LVTGeneratorException extends MixinException
{
    private static final long serialVersionUID = 1L;
    
    public LVTGeneratorException(final String s) {
        super(s);
    }
    
    private LVTGeneratorException(final String s, final Throwable t) {
        super(s, t);
    }
}
