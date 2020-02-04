package org.spongepowered.asm.mixin.injection.struct;

import org.spongepowered.asm.mixin.throwables.*;

public final class InvalidMemberDescriptorException extends MixinException
{
    private static final long serialVersionUID = 1L;
    
    public InvalidMemberDescriptorException(final String s) {
        super(s);
    }
    
    private InvalidMemberDescriptorException(final Throwable t) {
        super(t);
    }
    
    private InvalidMemberDescriptorException(final String s, final Throwable t) {
        super(s, t);
    }
}
