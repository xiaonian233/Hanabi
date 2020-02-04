package org.spongepowered.asm.mixin.throwables;

public final class MixinApplyError extends Error
{
    private static final long serialVersionUID = 1L;
    
    public MixinApplyError(final String s) {
        super(s);
    }
    
    private MixinApplyError(final Throwable t) {
        super(t);
    }
    
    public MixinApplyError(final String s, final Throwable t) {
        super(s, t);
    }
}
