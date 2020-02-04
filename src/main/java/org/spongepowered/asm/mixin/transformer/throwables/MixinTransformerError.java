package org.spongepowered.asm.mixin.transformer.throwables;

public final class MixinTransformerError extends Error
{
    private static final long serialVersionUID = 1L;
    
    public MixinTransformerError(final String s) {
        super(s);
    }
    
    private MixinTransformerError(final Throwable t) {
        super(t);
    }
    
    public MixinTransformerError(final String s, final Throwable t) {
        super(s, t);
    }
}
