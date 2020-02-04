package org.spongepowered.asm.mixin.gen;

import org.spongepowered.asm.mixin.transformer.*;
import org.spongepowered.asm.lib.tree.*;
import java.lang.annotation.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.injection.struct.*;

public final class InvokerInfo extends AccessorInfo
{
    public InvokerInfo(final MixinTargetContext mixinTargetContext, final MethodNode methodNode) {
        super(mixinTargetContext, methodNode, Invoker.class);
    }
    
    @Override
    protected final AccessorType initType() {
        return AccessorType.METHOD_PROXY;
    }
    
    @Override
    protected final Type initTargetFieldType() {
        return null;
    }
    
    @Override
    protected final MemberInfo initTarget() {
        return new MemberInfo(this.getTargetName(), this.method.desc);
    }
    
    @Override
    public final void locate() {
        this.targetMethod = this.findTarget(this.classNode.methods);
    }
    
    private MethodNode findTargetMethod() {
        return this.findTarget(this.classNode.methods);
    }
}
