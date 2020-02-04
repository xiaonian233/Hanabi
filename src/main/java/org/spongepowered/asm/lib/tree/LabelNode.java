package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.*;
import java.util.*;

public final class LabelNode extends AbstractInsnNode
{
    Label label;
    
    public LabelNode() {
        super(-1);
    }
    
    public LabelNode(final Label label) {
        super(-1);
        this.label = label;
    }
    
    public final int getType() {
        return 8;
    }
    
    public final Label getLabel() {
        if (this.label == null) {
            this.label = new Label();
        }
        return this.label;
    }
    
    public final void accept(final MethodVisitor methodVisitor) {
        methodVisitor.visitLabel(this.getLabel());
    }
    
    public final AbstractInsnNode clone(final Map<LabelNode, LabelNode> map) {
        return map.get(this);
    }
    
    private void resetLabel() {
        this.label = null;
    }
}
