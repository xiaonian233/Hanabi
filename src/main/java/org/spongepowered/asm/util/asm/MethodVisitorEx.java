package org.spongepowered.asm.util.asm;

import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.util.*;

public final class MethodVisitorEx extends MethodVisitor
{
    public MethodVisitorEx(final MethodVisitor methodVisitor) {
        super(methodVisitor);
    }
    
    public final void visitConstant(final byte b) {
        if (b > -2 && b < 6) {
            this.visitInsn(Bytecode.CONSTANTS_INT[b + 1]);
            return;
        }
        this.visitIntInsn(16, b);
    }
    
    private static boolean lllIllIIlllI$255f299(final int n) {
        return n > -2;
    }
}
