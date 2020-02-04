package org.spongepowered.asm.mixin.injection.points;

import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import java.util.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.lib.tree.*;

@AtCode("INVOKE_ASSIGN")
public class AfterInvoke extends BeforeInvoke
{
    private AfterInvoke(final InjectionPointData injectionPointData) {
        super(injectionPointData);
    }
    
    @Override
    protected final boolean addInsn(final InsnList list, final Collection<AbstractInsnNode> collection, AbstractInsnNode abstractInsnNode) {
        if (Type.getReturnType(((MethodInsnNode)abstractInsnNode).desc) == Type.VOID_TYPE) {
            return false;
        }
        if ((abstractInsnNode = InjectionPoint.nextNode(list, abstractInsnNode)) instanceof VarInsnNode && abstractInsnNode.getOpcode() >= 54) {
            abstractInsnNode = InjectionPoint.nextNode(list, abstractInsnNode);
        }
        collection.add(abstractInsnNode);
        return true;
    }
    
    private static boolean lIlllllIIIII$255f299(final int n) {
        return n >= 54;
    }
    
    private static boolean lIllllIllllI(final Object o, final Object o2) {
        return o == o2;
    }
}
