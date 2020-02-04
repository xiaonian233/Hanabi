package org.spongepowered.asm.mixin.throwables;

public final class MixinPrepareError extends Error
{
    private static final long serialVersionUID = 1L;
    
    private MixinPrepareError(final String s) {
        super(s);
    }
    
    private MixinPrepareError(final Throwable t) {
        super(t);
    }
    
    private MixinPrepareError(final String s, final Throwable t) {
        super(s, t);
    }
}
