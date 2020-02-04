package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.*;

public final class ParameterNode
{
    public String name;
    public int access;
    
    public ParameterNode(final String name, final int access) {
        super();
        this.name = name;
        this.access = access;
    }
    
    private void accept(final MethodVisitor methodVisitor) {
        methodVisitor.visitParameter(this.name, this.access);
    }
}
