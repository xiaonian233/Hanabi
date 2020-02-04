package org.spongepowered.asm.launch;

public final class MixinInitialisationError extends Error
{
    private static final long serialVersionUID = 1L;
    
    public MixinInitialisationError() {
        super();
    }
    
    public MixinInitialisationError(final String s) {
        super(s);
    }
    
    private MixinInitialisationError(final Throwable t) {
        super(t);
    }
    
    private MixinInitialisationError(final String s, final Throwable t) {
        super(s, t);
    }
}
