package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.extensibility.*;
import org.spongepowered.asm.mixin.*;

public final class Config
{
    public final String name;
    public final MixinConfig config;
    
    public Config(final MixinConfig config) {
        super();
        this.name = config.name;
        this.config = config;
    }
    
    private String getName() {
        return this.name;
    }
    
    private MixinConfig get() {
        return this.config;
    }
    
    private boolean isVisited() {
        return this.config.visited;
    }
    
    private IMixinConfig getConfig() {
        return this.config;
    }
    
    private MixinEnvironment getEnvironment() {
        return this.config.env;
    }
    
    @Override
    public final String toString() {
        return this.config.toString();
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof Config && this.name.equals(((Config)o).name);
    }
    
    @Override
    public final int hashCode() {
        return this.name.hashCode();
    }
    
    @Deprecated
    private static Config create(final String s, final MixinEnvironment mixinEnvironment) {
        return MixinConfig.create(s, mixinEnvironment);
    }
    
    private static Config create(final String s) {
        return MixinConfig.create(s, MixinEnvironment.getDefaultEnvironment());
    }
}
