package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.*;

public final class LocalVariableNode
{
    public String name;
    public String desc;
    private String signature;
    public LabelNode start;
    public LabelNode end;
    public int index;
    
    public LocalVariableNode(final String name, final String desc, final String signature, final LabelNode start, final LabelNode end, final int index) {
        super();
        this.name = name;
        this.desc = desc;
        this.signature = signature;
        this.start = start;
        this.end = end;
        this.index = index;
    }
    
    public final void accept(final MethodVisitor methodVisitor) {
        methodVisitor.visitLocalVariable(this.name, this.desc, this.signature, this.start.getLabel(), this.end.getLabel(), this.index);
    }
}
