package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.*;

public class TypeAnnotationNode extends AnnotationNode
{
    public int typeRef;
    public TypePath typePath;
    
    public TypeAnnotationNode(final int n, final TypePath typePath, final String s) {
        this(n, typePath, s, (byte)0);
        if (this.getClass() != TypeAnnotationNode.class) {
            throw new IllegalStateException();
        }
    }
    
    public TypeAnnotationNode(final int typeRef, final TypePath typePath, final String s, final byte b) {
        super(s, (byte)0);
        this.typeRef = typeRef;
        this.typePath = typePath;
    }
    
    private static boolean lIlIIIIllll(final Object o, final Object o2) {
        return o != o2;
    }
}
