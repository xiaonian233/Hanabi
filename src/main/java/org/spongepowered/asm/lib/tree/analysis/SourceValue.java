package org.spongepowered.asm.lib.tree.analysis;

import java.util.*;
import org.spongepowered.asm.lib.tree.*;

public final class SourceValue implements Value
{
    public final int size;
    public final Set<AbstractInsnNode> insns;
    
    public SourceValue(final int n) {
        this(n, SmallSet.emptySet());
    }
    
    public SourceValue(final int size, final AbstractInsnNode abstractInsnNode) {
        super();
        this.size = size;
        this.insns = new SmallSet<AbstractInsnNode>(abstractInsnNode, null);
    }
    
    public SourceValue(final int size, final Set<AbstractInsnNode> insns) {
        super();
        this.size = size;
        this.insns = insns;
    }
    
    public final int getSize() {
        return this.size;
    }
    
    public final boolean equals(final Object o) {
        if (!(o instanceof SourceValue)) {
            return false;
        }
        final SourceValue sourceValue = (SourceValue)o;
        return this.size == sourceValue.size && this.insns.equals(sourceValue.insns);
    }
    
    public final int hashCode() {
        return this.insns.hashCode();
    }
}
