package org.spongepowered.asm.mixin.extensibility;

public interface IEnvironmentTokenProvider
{
    public static final int DEFAULT_PRIORITY;
    
    int getPriority();
    
    Integer getToken$3de5502f();
}
