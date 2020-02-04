package org.spongepowered.asm.mixin.transformer.ext.extensions;

import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.transformer.ext.*;
import org.spongepowered.asm.transformers.*;
import org.spongepowered.asm.lib.util.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.throwables.*;

public final class ExtensionCheckClass implements IExtension
{
    public ExtensionCheckClass() {
        super();
    }
    
    @Override
    public final boolean checkActive(final MixinEnvironment mixinEnvironment) {
        return mixinEnvironment.getOption(MixinEnvironment.Option.DEBUG_VERIFY);
    }
    
    @Override
    public final void preApply(final ITargetClassContext targetClassContext) {
    }
    
    @Override
    public final void postApply(final ITargetClassContext targetClassContext) {
        try {
            targetClassContext.getClassNode().accept(new CheckClassAdapter(new MixinClassWriter(2)));
        }
        catch (RuntimeException ex) {
            throw new ValidationFailedException(ex.getMessage(), ex);
        }
    }
    
    @Override
    public final void export(final MixinEnvironment mixinEnvironment, final String s, final boolean b, final byte[] array) {
    }
}
