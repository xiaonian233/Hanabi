package org.spongepowered.asm.mixin.injection.points;

import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;

@AtCode("JUMP")
public class JumpInsnPoint extends InjectionPoint
{
    private final int opCode;
    private final int ordinal;
    
    private JumpInsnPoint(final InjectionPointData injectionPointData) {
        super();
        this.opCode = injectionPointData.getOpcode$487101af(153, 154, 155, 156, 157, 158, 159, 160, 161, 162, 163, 164, 165, 166, 167, 168, 198, 199, -1);
        this.ordinal = injectionPointData.ordinal;
    }
    
    @Override
    public final boolean find(final String s, final InsnList list, final Collection<AbstractInsnNode> collection) {
        boolean b = false;
        int n = 0;
        final ListIterator<AbstractInsnNode> iterator = list.iterator();
        while (iterator.hasNext()) {
            final AbstractInsnNode abstractInsnNode;
            if ((abstractInsnNode = iterator.next()) instanceof JumpInsnNode && (!llllIllIll$255f299(this.opCode) || abstractInsnNode.getOpcode() == this.opCode)) {
                if (!llllIllIll$255f299(this.ordinal) || this.ordinal == n) {
                    collection.add(abstractInsnNode);
                    b = true;
                }
                ++n;
            }
        }
        return b;
    }
    
    private static boolean llllIllIll$255f299(final int n) {
        return n != -1;
    }
}
