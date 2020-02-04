package org.spongepowered.asm.mixin.injection.struct;

import org.spongepowered.asm.util.*;
import org.spongepowered.asm.mixin.injection.callback.*;
import org.spongepowered.asm.mixin.transformer.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.lib.tree.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class Target implements Comparable<Target>, Iterable<AbstractInsnNode>
{
    public final ClassNode classNode;
    public final MethodNode method;
    public final InsnList insns;
    public final boolean isStatic;
    public final boolean isCtor;
    public final Type[] arguments;
    public final Type returnType;
    private final int maxStack;
    public final int maxLocals;
    public final InjectionNodes injectionNodes;
    private String callbackInfoClass;
    private String callbackDescriptor;
    private int[] argIndices;
    public List<Integer> argMapVars;
    private LabelNode start;
    private LabelNode end;
    private static final String[] lIllIllIlll;
    
    public Target(final ClassNode classNode, final MethodNode method) {
        super();
        this.injectionNodes = new InjectionNodes();
        this.classNode = classNode;
        this.method = method;
        this.insns = method.instructions;
        this.isStatic = Bytecode.methodIsStatic(method);
        this.isCtor = method.name.equals(Target.lIllIllIlll[0]);
        this.arguments = Type.getArgumentTypes(method.desc);
        this.returnType = Type.getReturnType(method.desc);
        this.maxStack = method.maxStack;
        this.maxLocals = method.maxLocals;
    }
    
    public final InjectionNodes.InjectionNode addInjectionNode(final AbstractInsnNode abstractInsnNode) {
        return this.injectionNodes.add(abstractInsnNode);
    }
    
    private InjectionNodes.InjectionNode getInjectionNode(final AbstractInsnNode abstractInsnNode) {
        return this.injectionNodes.get(abstractInsnNode);
    }
    
    private int getMaxLocals() {
        return this.maxLocals;
    }
    
    private int getMaxStack() {
        return this.maxStack;
    }
    
    private int getCurrentMaxLocals() {
        return this.method.maxLocals;
    }
    
    private int getCurrentMaxStack() {
        return this.method.maxStack;
    }
    
    private int allocateLocal() {
        return this.allocateLocals(1);
    }
    
    public final int allocateLocals(final int n) {
        final int maxLocals = this.method.maxLocals;
        final MethodNode method = this.method;
        method.maxLocals += n;
        return maxLocals;
    }
    
    public final void addToLocals(final int n) {
        this.setMaxLocals(this.maxLocals + n);
    }
    
    private void setMaxLocals(final int maxLocals) {
        if (llllllIlIlIl(maxLocals, this.method.maxLocals)) {
            this.method.maxLocals = maxLocals;
        }
    }
    
    public final void addToStack(final int n) {
        this.setMaxStack(this.maxStack + n);
    }
    
    private void setMaxStack(final int maxStack) {
        if (llllllIlIlIl(maxStack, this.method.maxStack)) {
            this.method.maxStack = maxStack;
        }
    }
    
    private int[] generateArgMap(final Type[] array, int i) {
        if (this.argMapVars == null) {
            this.argMapVars = new ArrayList<Integer>();
        }
        final int[] array2 = new int[array.length];
        int n = 0;
        while (i < array.length) {
            final int size = array[i].getSize();
            array2[i] = this.allocateArgMapLocal(n, size);
            n += size;
            ++i;
        }
        return array2;
    }
    
    public final int allocateArgMapLocal(final int n, final int n2) {
        if (n >= this.argMapVars.size()) {
            final int allocateLocals = this.allocateLocals(n2);
            for (int i = 0; i < n2; ++i) {
                this.argMapVars.add(allocateLocals + i);
            }
            return allocateLocals;
        }
        final int intValue = this.argMapVars.get(n);
        if (!llllllIlIlIl(n2, 1) || !llllllIlIlIl(n + n2, this.argMapVars.size())) {
            return intValue;
        }
        final int allocateLocals2;
        if ((allocateLocals2 = this.allocateLocals(1)) == intValue + 1) {
            this.argMapVars.add(allocateLocals2);
            return intValue;
        }
        this.argMapVars.set(n, allocateLocals2);
        this.argMapVars.add(this.allocateLocals(1));
        return allocateLocals2;
    }
    
    public final int[] getArgIndices() {
        if (this.argIndices == null) {
            int n = this.isStatic ? 0 : 1;
            final int[] argIndices = new int[this.arguments.length];
            for (int i = 0; i < this.arguments.length; ++i) {
                argIndices[i] = n;
                n += this.arguments[i].getSize();
            }
            this.argIndices = argIndices;
        }
        return this.argIndices;
    }
    
    private int[] calcArgIndices(int n) {
        final int[] array = new int[this.arguments.length];
        for (int i = 0; i < this.arguments.length; ++i) {
            array[i] = n;
            n += this.arguments[i].getSize();
        }
        return array;
    }
    
    public final String getCallbackInfoClass() {
        if (this.callbackInfoClass == null) {
            this.callbackInfoClass = CallbackInfo.getCallInfoClassName(this.returnType);
        }
        return this.callbackInfoClass;
    }
    
    public final String getSimpleCallbackDescriptor() {
        return String.format(Target.lIllIllIlll[1], this.getCallbackInfoClass());
    }
    
    private String getCallbackDescriptor$4b0a4075(final Type[] array) {
        return this.getCallbackDescriptor$1d625c21(false, array, 0, 32767);
    }
    
    public final String getCallbackDescriptor$1d625c21(final boolean b, final Type[] array, int n, int n2) {
        if (this.callbackDescriptor == null) {
            this.callbackDescriptor = String.format(Target.lIllIllIlll[2], this.method.desc.substring(1, this.method.desc.indexOf(41)), this.getCallbackInfoClass());
        }
        if (!b || array == null) {
            return this.callbackDescriptor;
        }
        final StringBuilder sb = new StringBuilder(this.callbackDescriptor.substring(0, this.callbackDescriptor.indexOf(41)));
        while (n < array.length && n2 > 0) {
            if (array[n] != null) {
                sb.append(array[n].getDescriptor());
                --n2;
            }
            ++n;
        }
        return String.valueOf(sb.append(Target.lIllIllIlll[3]));
    }
    
    @Override
    public final String toString() {
        return String.format(Target.lIllIllIlll[4], this.classNode.name, this.method.name, this.method.desc);
    }
    
    private int compareTo(final Target target) {
        if (target == null) {
            return Integer.MAX_VALUE;
        }
        return this.toString().compareTo(target.toString());
    }
    
    public final int indexOf(final InjectionNodes.InjectionNode injectionNode) {
        return this.insns.indexOf(injectionNode.currentTarget);
    }
    
    public final int indexOf(final AbstractInsnNode abstractInsnNode) {
        return this.insns.indexOf(abstractInsnNode);
    }
    
    private AbstractInsnNode get(final int n) {
        return this.insns.get(n);
    }
    
    @Override
    public final Iterator<AbstractInsnNode> iterator() {
        return this.insns.iterator();
    }
    
    public final MethodInsnNode findInitNodeFor(final TypeInsnNode typeInsnNode) {
        final ListIterator<AbstractInsnNode> iterator = this.insns.iterator(this.indexOf(typeInsnNode));
        while (iterator.hasNext()) {
            final AbstractInsnNode abstractInsnNode;
            if ((abstractInsnNode = iterator.next()) instanceof MethodInsnNode && abstractInsnNode.getOpcode() == 183) {
                final MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
                if (Target.lIllIllIlll[5].equals(methodInsnNode.name) && methodInsnNode.owner.equals(typeInsnNode.desc)) {
                    return methodInsnNode;
                }
                continue;
            }
        }
        return null;
    }
    
    private MethodInsnNode findSuperInitNode() {
        if (!this.isCtor) {
            return null;
        }
        return Bytecode.findSuperInit(this.method, ClassInfo.forName(this.classNode.name).superName);
    }
    
    public final void insertBefore(final InjectionNodes.InjectionNode injectionNode, final InsnList list) {
        this.insns.insertBefore(injectionNode.currentTarget, list);
    }
    
    private void insertBefore(final AbstractInsnNode abstractInsnNode, final InsnList list) {
        this.insns.insertBefore(abstractInsnNode, list);
    }
    
    private void replaceNode(final AbstractInsnNode abstractInsnNode, final AbstractInsnNode abstractInsnNode2) {
        this.insns.insertBefore(abstractInsnNode, abstractInsnNode2);
        this.insns.remove(abstractInsnNode);
        this.injectionNodes.replace(abstractInsnNode, abstractInsnNode2);
    }
    
    public final void replaceNode(final AbstractInsnNode abstractInsnNode, final AbstractInsnNode abstractInsnNode2, final InsnList list) {
        this.insns.insertBefore(abstractInsnNode, list);
        this.insns.remove(abstractInsnNode);
        this.injectionNodes.replace(abstractInsnNode, abstractInsnNode2);
    }
    
    public final void wrapNode(final AbstractInsnNode abstractInsnNode, final AbstractInsnNode abstractInsnNode2, final InsnList list, final InsnList list2) {
        this.insns.insertBefore(abstractInsnNode, list);
        this.insns.insert(abstractInsnNode, list2);
        this.injectionNodes.replace(abstractInsnNode, abstractInsnNode2);
    }
    
    private void replaceNode(final AbstractInsnNode abstractInsnNode, final InsnList list) {
        this.insns.insertBefore(abstractInsnNode, list);
        this.removeNode(abstractInsnNode);
    }
    
    public final void removeNode(final AbstractInsnNode abstractInsnNode) {
        this.insns.remove(abstractInsnNode);
        this.injectionNodes.remove(abstractInsnNode);
    }
    
    public final void addLocalVariable(final int n, final String s, String s2) {
        if (this.start == null) {
            this.start = new LabelNode(new Label());
            this.end = new LabelNode(new Label());
            this.insns.insert(this.start);
            this.insns.add(this.end);
        }
        final String s3 = s2;
        final LabelNode start = this.start;
        final LabelNode end = this.end;
        final LabelNode labelNode = start;
        final String s4 = s3;
        s2 = s;
        if (this.method.localVariables == null) {
            this.method.localVariables = new ArrayList<LocalVariableNode>();
        }
        this.method.localVariables.add(new LocalVariableNode(s2, s4, null, labelNode, end, n));
    }
    
    private void addLocalVariable(final int n, final String s, final String s2, final LabelNode labelNode, final LabelNode labelNode2) {
        if (this.method.localVariables == null) {
            this.method.localVariables = new ArrayList<LocalVariableNode>();
        }
        this.method.localVariables.add(new LocalVariableNode(s, s2, null, labelNode, labelNode2, n));
    }
    
    @Override
    public final /* bridge */ int compareTo(final Object o) {
        final Target target = (Target)o;
        if (target == null) {
            return Integer.MAX_VALUE;
        }
        return this.toString().compareTo(target.toString());
    }
    
    static {
        llllllIlIlII();
    }
    
    private static void llllllIlIlII() {
        (lIllIllIlll = new String[6])[0] = "<init>";
        Target.lIllIllIlll[1] = "(L%s;)V";
        Target.lIllIllIlll[2] = "(%sL%s;)V";
        Target.lIllIllIlll[3] = ")V";
        Target.lIllIllIlll[4] = "%s::%s%s";
        Target.lIllIllIlll[5] = "<init>";
    }
    
    private static String llllllIlIIll(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("DES")).init(2, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), 8), "DES"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String llllllIlIIIl(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("Blowfish")).init(2, new SecretKeySpec(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), "Blowfish"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static boolean llllllIllIII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean llllllIlIlIl(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean llllllIllIll(final int n) {
        return n > 0;
    }
}
