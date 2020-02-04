package org.spongepowered.asm.mixin.injection.points;

import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;

@AtCode("RETURN")
public class BeforeReturn extends InjectionPoint
{
    private final int ordinal;
    
    private BeforeReturn(final InjectionPointData injectionPointData) {
        super(injectionPointData);
        this.ordinal = injectionPointData.ordinal;
    }
    
    @Override
    public final boolean checkPriority(final int n, final int n2) {
        return true;
    }
    
    @Override
    public final boolean find(final String s, final InsnList list, final Collection<AbstractInsnNode> collection) {
        boolean b = false;
        final int opcode = Type.getReturnType(s).getOpcode(172);
        int n = 0;
        final ListIterator<AbstractInsnNode> iterator = list.iterator();
        while (iterator.hasNext()) {
            final AbstractInsnNode abstractInsnNode;
            if ((abstractInsnNode = iterator.next()) instanceof InsnNode && abstractInsnNode.getOpcode() == opcode) {
                if (this.ordinal == -1 || this.ordinal == n) {
                    collection.add(abstractInsnNode);
                    b = true;
                }
                ++n;
            }
        }
        return b;
    }
    
    private static boolean lIIlIIlIlIllI$255f299(final int n) {
        return n != -1;
    }
}
