package org.spongepowered.asm.mixin.transformer.throwables;

import org.spongepowered.asm.mixin.throwables.*;
import org.spongepowered.asm.mixin.extensibility.*;

public final class MixinReloadException extends MixinException
{
    private static final long serialVersionUID = 2L;
    public final IMixinInfo mixinInfo;
    
    public MixinReloadException(final IMixinInfo mixinInfo, final String s) {
        super(s);
        this.mixinInfo = mixinInfo;
    }
    
    private IMixinInfo getMixinInfo() {
        return this.mixinInfo;
    }
}
