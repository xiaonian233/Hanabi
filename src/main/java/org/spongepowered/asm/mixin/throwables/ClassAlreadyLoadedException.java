package org.spongepowered.asm.mixin.throwables;

public final class ClassAlreadyLoadedException extends MixinException
{
    private static final long serialVersionUID = 1L;
    
    public ClassAlreadyLoadedException(final String s) {
        super(s);
    }
    
    private ClassAlreadyLoadedException(final Throwable t) {
        super(t);
    }
    
    private ClassAlreadyLoadedException(final String s, final Throwable t) {
        super(s, t);
    }
}
