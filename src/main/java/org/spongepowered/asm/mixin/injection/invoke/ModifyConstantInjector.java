package org.spongepowered.asm.mixin.injection.invoke;

import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.mixin.injection.throwables.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.invoke.util.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.mixin.injection.code.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class ModifyConstantInjector extends RedirectInjector
{
    private static final int OPCODE_OFFSET;
    private static final String[] lIIIlllIll;
    
    public ModifyConstantInjector(final InjectionInfo injectionInfo) {
        super(injectionInfo, ModifyConstantInjector.lIIIlllIll[0]);
    }
    
    @Override
    public final void inject(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        if (!this.preInject(injectionNode)) {
            return;
        }
        if (injectionNode.isReplaced()) {
            throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(ModifyConstantInjector.lIIIlllIll[1]).append(this.info)));
        }
        final AbstractInsnNode currentTarget;
        if ((currentTarget = injectionNode.currentTarget) instanceof JumpInsnNode) {
            this.checkTargetModifiers(target, false);
            final JumpInsnNode jumpInsnNode = (JumpInsnNode)currentTarget;
            final int opcode;
            if ((opcode = jumpInsnNode.getOpcode()) < 155 || opcode > 158) {
                throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(this.annotationType).append(ModifyConstantInjector.lIIIlllIll[4]).append(Bytecode.getOpcodeName(opcode)).append(ModifyConstantInjector.lIIIlllIll[5]).append(target).append(ModifyConstantInjector.lIIIlllIll[6]).append(this)));
            }
            final InsnList list;
            (list = new InsnList()).add(new InsnNode(3));
            final Type type = Type.getType(ModifyConstantInjector.lIIIlllIll[7]);
            final InsnList list2 = list;
            final AbstractInsnNode invokeConstantHandler = this.invokeConstantHandler(type, target, list2, list2);
            list.add(new JumpInsnNode(opcode + 6, jumpInsnNode.label));
            target.replaceNode(jumpInsnNode, invokeConstantHandler, list);
            target.addToStack(1);
        }
        else {
            if (Bytecode.isConstant(currentTarget)) {
                this.checkTargetModifiers(target, false);
                final JumpInsnNode jumpInsnNode2 = (JumpInsnNode)currentTarget;
                final Type constantType;
                if ((constantType = Bytecode.getConstantType(jumpInsnNode2)).sort <= 5 && this.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
                    final JumpInsnNode jumpInsnNode3 = jumpInsnNode2;
                    final Type type2 = constantType;
                    final JumpInsnNode jumpInsnNode4 = jumpInsnNode3;
                    new InsnFinder();
                    final AbstractInsnNode popInsn;
                    if ((popInsn = InsnFinder.findPopInsn(target, jumpInsnNode4)) != null) {
                        if (popInsn instanceof FieldInsnNode) {
                            final FieldInsnNode fieldInsnNode;
                            final Type type3 = Type.getType((fieldInsnNode = (FieldInsnNode)popInsn).desc);
                            this.checkNarrowing$31905770(target, type2, type3, target.indexOf(popInsn), String.format(ModifyConstantInjector.lIIIlllIll[9], Bytecode.getOpcodeName(popInsn), SignaturePrinter.getTypeName$1388108(type3), fieldInsnNode.owner.replace('/', '.'), fieldInsnNode.name));
                        }
                        else if (popInsn.getOpcode() == 172) {
                            this.checkNarrowing$31905770(target, type2, target.returnType, target.indexOf(popInsn), String.valueOf(new StringBuilder().append(ModifyConstantInjector.lIIIlllIll[10]).append(SignaturePrinter.getTypeName$1388108(target.returnType))));
                        }
                        else if (popInsn.getOpcode() == 54) {
                            final int var = ((VarInsnNode)popInsn).var;
                            final LocalVariableNode localVariable;
                            if ((localVariable = Locals.getLocalVariableAt(target.classNode, target.method, popInsn, var)) != null && localVariable.desc != null) {
                                final String s = (localVariable.name != null) ? localVariable.name : ModifyConstantInjector.lIIIlllIll[11];
                                final Type type4 = Type.getType(localVariable.desc);
                                this.checkNarrowing$31905770(target, type2, type4, target.indexOf(popInsn), String.format(ModifyConstantInjector.lIIIlllIll[12], var, SignaturePrinter.getTypeName$1388108(type4), s));
                            }
                        }
                    }
                }
                final InsnList list3 = new InsnList();
                final InsnList list4 = new InsnList();
                target.wrapNode(jumpInsnNode2, this.invokeConstantHandler(constantType, target, list3, list4), list3, list4);
                return;
            }
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(this.annotationType).append(ModifyConstantInjector.lIIIlllIll[2]).append(target).append(ModifyConstantInjector.lIIIlllIll[3]).append(this)));
        }
    }
    
    private void injectExpandedConstantModifier(final Target target, final JumpInsnNode jumpInsnNode) {
        final int opcode;
        if ((opcode = jumpInsnNode.getOpcode()) < 155 || opcode > 158) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(this.annotationType).append(ModifyConstantInjector.lIIIlllIll[4]).append(Bytecode.getOpcodeName(opcode)).append(ModifyConstantInjector.lIIIlllIll[5]).append(target).append(ModifyConstantInjector.lIIIlllIll[6]).append(this)));
        }
        final InsnList list;
        (list = new InsnList()).add(new InsnNode(3));
        final Type type = Type.getType(ModifyConstantInjector.lIIIlllIll[7]);
        final InsnList list2 = list;
        final AbstractInsnNode invokeConstantHandler = this.invokeConstantHandler(type, target, list2, list2);
        list.add(new JumpInsnNode(opcode + 6, jumpInsnNode.label));
        target.replaceNode(jumpInsnNode, invokeConstantHandler, list);
        target.addToStack(1);
    }
    
    private void injectConstantModifier(final Target target, final AbstractInsnNode abstractInsnNode) {
        final Type constantType;
        if ((constantType = Bytecode.getConstantType(abstractInsnNode)).sort <= 5 && this.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
            final Type type = constantType;
            new InsnFinder();
            final AbstractInsnNode popInsn;
            if ((popInsn = InsnFinder.findPopInsn(target, abstractInsnNode)) != null) {
                if (popInsn instanceof FieldInsnNode) {
                    final FieldInsnNode fieldInsnNode;
                    final Type type2 = Type.getType((fieldInsnNode = (FieldInsnNode)popInsn).desc);
                    this.checkNarrowing$31905770(target, type, type2, target.indexOf(popInsn), String.format(ModifyConstantInjector.lIIIlllIll[9], Bytecode.getOpcodeName(popInsn), SignaturePrinter.getTypeName$1388108(type2), fieldInsnNode.owner.replace('/', '.'), fieldInsnNode.name));
                }
                else if (popInsn.getOpcode() == 172) {
                    this.checkNarrowing$31905770(target, type, target.returnType, target.indexOf(popInsn), String.valueOf(new StringBuilder().append(ModifyConstantInjector.lIIIlllIll[10]).append(SignaturePrinter.getTypeName$1388108(target.returnType))));
                }
                else if (popInsn.getOpcode() == 54) {
                    final int var = ((VarInsnNode)popInsn).var;
                    final LocalVariableNode localVariable;
                    if ((localVariable = Locals.getLocalVariableAt(target.classNode, target.method, popInsn, var)) != null && localVariable.desc != null) {
                        final String s = (localVariable.name != null) ? localVariable.name : ModifyConstantInjector.lIIIlllIll[11];
                        final Type type3 = Type.getType(localVariable.desc);
                        this.checkNarrowing$31905770(target, type, type3, target.indexOf(popInsn), String.format(ModifyConstantInjector.lIIIlllIll[12], var, SignaturePrinter.getTypeName$1388108(type3), s));
                    }
                }
            }
        }
        final InsnList list = new InsnList();
        final InsnList list2 = new InsnList();
        target.wrapNode(abstractInsnNode, this.invokeConstantHandler(constantType, target, list, list2), list, list2);
    }
    
    private AbstractInsnNode invokeConstantHandler(final Type type, final Target target, final InsnList list, final InsnList list2) {
        final boolean checkDescriptor = this.checkDescriptor(Bytecode.generateDescriptor(type, type), target, ModifyConstantInjector.lIIIlllIll[8]);
        if (!this.isStatic) {
            list.insert(new VarInsnNode(25, 0));
            target.addToStack(1);
        }
        if (checkDescriptor) {
            InvokeInjector.pushArgs(target.arguments, list2, target.getArgIndices(), 0, target.arguments.length);
            target.addToStack(Bytecode.getArgsSize(target.arguments));
        }
        return this.invokeHandler(list2);
    }
    
    private void checkNarrowing(final Target target, AbstractInsnNode popInsn, final Type type) {
        new InsnFinder();
        if ((popInsn = InsnFinder.findPopInsn(target, popInsn)) == null) {
            return;
        }
        if (popInsn instanceof FieldInsnNode) {
            final FieldInsnNode fieldInsnNode;
            final Type type2 = Type.getType((fieldInsnNode = (FieldInsnNode)popInsn).desc);
            this.checkNarrowing$31905770(target, type, type2, target.indexOf(popInsn), String.format(ModifyConstantInjector.lIIIlllIll[9], Bytecode.getOpcodeName(popInsn), SignaturePrinter.getTypeName$1388108(type2), fieldInsnNode.owner.replace('/', '.'), fieldInsnNode.name));
            return;
        }
        if (popInsn.getOpcode() == 172) {
            this.checkNarrowing$31905770(target, type, target.returnType, target.indexOf(popInsn), String.valueOf(new StringBuilder().append(ModifyConstantInjector.lIIIlllIll[10]).append(SignaturePrinter.getTypeName$1388108(target.returnType))));
            return;
        }
        if (popInsn.getOpcode() == 54) {
            final int var = ((VarInsnNode)popInsn).var;
            final LocalVariableNode localVariable;
            if ((localVariable = Locals.getLocalVariableAt(target.classNode, target.method, popInsn, var)) != null && localVariable.desc != null) {
                final String s = (localVariable.name != null) ? localVariable.name : ModifyConstantInjector.lIIIlllIll[11];
                final Type type3 = Type.getType(localVariable.desc);
                this.checkNarrowing$31905770(target, type, type3, target.indexOf(popInsn), String.format(ModifyConstantInjector.lIIIlllIll[12], var, SignaturePrinter.getTypeName$1388108(type3), s));
            }
        }
    }
    
    private void checkNarrowing$31905770(final Target target, final Type type, final Type type2, final int n, final String s) {
        final int sort;
        if ((sort = type2.sort) < type.sort) {
            Injector.logger.log((sort == 1) ? Level.ERROR : Level.WARN, ModifyConstantInjector.lIIIlllIll[15], new Object[] { SignaturePrinter.getTypeName$1388108(type), SignaturePrinter.getTypeName$1388108(type2), this.info, target, n, s, (sort == 1) ? ModifyConstantInjector.lIIIlllIll[13] : ModifyConstantInjector.lIIIlllIll[14] });
        }
    }
    
    static {
        llIlIIlIlII();
    }
    
    private static void llIlIIlIlII() {
        (lIIIlllIll = new String[16])[0] = "@ModifyConstant";
        ModifyConstantInjector.lIIIlllIll[1] = "Target failure for ";
        ModifyConstantInjector.lIIIlllIll[2] = " annotation is targetting an invalid insn in ";
        ModifyConstantInjector.lIIIlllIll[3] = " in ";
        ModifyConstantInjector.lIIIlllIll[4] = " annotation selected an invalid opcode ";
        ModifyConstantInjector.lIIIlllIll[5] = " in ";
        ModifyConstantInjector.lIIIlllIll[6] = " in ";
        ModifyConstantInjector.lIIIlllIll[7] = "I";
        ModifyConstantInjector.lIIIlllIll[8] = "getter";
        ModifyConstantInjector.lIIIlllIll[9] = "%s %s %s.%s";
        ModifyConstantInjector.lIIIlllIll[10] = "RETURN ";
        ModifyConstantInjector.lIIIlllIll[11] = "unnamed";
        ModifyConstantInjector.lIIIlllIll[12] = "ISTORE[var=%d] %s %s";
        ModifyConstantInjector.lIIIlllIll[13] = ". Implicit conversion to <boolean> can cause nondeterministic (JVM-specific) behaviour!";
        ModifyConstantInjector.lIIIlllIll[14] = "";
        ModifyConstantInjector.lIIIlllIll[15] = "Narrowing conversion of <{}> to <{}> in {} target {} at opcode {} ({}){}";
    }
    
    private static String llIlIIIlllI(final String s, final String s2) {
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
    
    private static String llIlIIIllII(final String s, final String s2) {
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
    
    private static String llIlIIIllIl(String s, final String s2) {
        s = new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        final StringBuilder sb = new StringBuilder();
        final char[] charArray = s2.toCharArray();
        int n = 0;
        char[] charArray2;
        for (int length = (charArray2 = s.toCharArray()).length, i = 0; i < length; ++i) {
            sb.append((char)(charArray2[i] ^ charArray[n % charArray.length]));
            ++n;
        }
        return String.valueOf(sb);
    }
    
    private static boolean llIlIIllIIl$255f299(final int n) {
        return n >= 155;
    }
    
    private static boolean llIlIIllIll$255f299(final int n) {
        return n <= 5;
    }
    
    private static boolean llIlIIllIlI$255f299(final int n) {
        return n > 158;
    }
}
