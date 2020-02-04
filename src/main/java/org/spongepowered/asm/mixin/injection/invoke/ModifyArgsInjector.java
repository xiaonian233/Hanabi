package org.spongepowered.asm.mixin.injection.invoke;

import org.spongepowered.asm.mixin.injection.invoke.arg.*;
import org.spongepowered.asm.mixin.transformer.ext.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.injection.throwables.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.lib.tree.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class ModifyArgsInjector extends InvokeInjector
{
    private final ArgsClassGenerator argsClassGenerator;
    private static final String[] llIlIlllIlI;
    
    public ModifyArgsInjector(final InjectionInfo injectionInfo) {
        super(injectionInfo, ModifyArgsInjector.llIlIlllIlI[0]);
        this.argsClassGenerator = injectionInfo.getContext().getExtensions().getGenerator(ArgsClassGenerator.class);
    }
    
    @Override
    protected final void checkTarget(final Target target) {
        this.checkTargetModifiers(target, false);
    }
    
    @Override
    public final void inject(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        this.checkTargetForNode(target, injectionNode);
        super.inject(target, injectionNode);
    }
    
    @Override
    protected final void injectAtInvoke(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        final MethodInsnNode methodInsnNode;
        final Type[] argumentTypes;
        if ((argumentTypes = Type.getArgumentTypes((methodInsnNode = (MethodInsnNode)injectionNode.currentTarget).desc)).length == 0) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(ModifyArgsInjector.llIlIlllIlI[1]).append(this).append(ModifyArgsInjector.llIlIlllIlI[2]).append(methodInsnNode.name).append(methodInsnNode.desc).append(ModifyArgsInjector.llIlIlllIlI[3])));
        }
        final ArgsClassGenerator argsClassGenerator = this.argsClassGenerator;
        final String desc = methodInsnNode.desc;
        final ArgsClassGenerator argsClassGenerator2 = argsClassGenerator;
        final String changeDescriptorReturnType = Bytecode.changeDescriptorReturnType(desc, ArgsClassGenerator.lIllIIIlllI[0]);
        String format;
        if ((format = (String)argsClassGenerator2.classNames.get((Object)changeDescriptorReturnType)) == null) {
            format = String.format(ArgsClassGenerator.lIllIIIlllI[1], ArgsClassGenerator.lIllIIIlllI[2], argsClassGenerator2.nextIndex++);
            argsClassGenerator2.classNames.put((Object)changeDescriptorReturnType, (Object)format);
        }
        final String replace = format.replace('.', '/');
        final String format2 = String.format(ModifyArgsInjector.llIlIlllIlI[4], ArgsClassGenerator.ARGS_REF);
        boolean b;
        if (!this.methodNode.desc.equals(format2)) {
            final String format3 = String.format(ModifyArgsInjector.llIlIlllIlI[6], ArgsClassGenerator.ARGS_REF, Bytecode.changeDescriptorReturnType(target.method.desc, ModifyArgsInjector.llIlIlllIlI[5]).substring(1));
            if (!this.methodNode.desc.equals(format3)) {
                throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(ModifyArgsInjector.llIlIlllIlI[7]).append(this).append(ModifyArgsInjector.llIlIlllIlI[8]).append(this.methodNode.desc).append(ModifyArgsInjector.llIlIlllIlI[9]).append(format2).append(ModifyArgsInjector.llIlIlllIlI[10]).append(format3)));
            }
            b = true;
        }
        else {
            b = false;
        }
        final boolean b2 = b;
        final InsnList list = new InsnList();
        target.addToStack(1);
        final InsnList list2 = list;
        final String s = replace;
        final MethodInsnNode methodInsnNode2 = methodInsnNode;
        final String s2 = s;
        final InsnList list3 = list2;
        list3.add(new MethodInsnNode(184, s2, ModifyArgsInjector.llIlIlllIlI[13], Bytecode.changeDescriptorReturnType(methodInsnNode2.desc, String.valueOf(new StringBuilder().append(ModifyArgsInjector.llIlIlllIlI[11]).append(s2).append(ModifyArgsInjector.llIlIlllIlI[12]))), false));
        list3.add(new InsnNode(89));
        if (!this.isStatic) {
            list3.add(new VarInsnNode(25, 0));
            list3.add(new InsnNode(95));
        }
        if (b2) {
            target.addToStack(Bytecode.getArgsSize(target.arguments));
            Bytecode.loadArgs(target.arguments, list, target.isStatic ? 0 : 1);
        }
        this.invokeHandler(list);
        unpackArgs(list, replace, argumentTypes);
        target.insns.insertBefore(methodInsnNode, list);
    }
    
    private boolean verifyTarget(final Target target) {
        final String format = String.format(ModifyArgsInjector.llIlIlllIlI[4], ArgsClassGenerator.ARGS_REF);
        if (this.methodNode.desc.equals(format)) {
            return false;
        }
        final String format2 = String.format(ModifyArgsInjector.llIlIlllIlI[6], ArgsClassGenerator.ARGS_REF, Bytecode.changeDescriptorReturnType(target.method.desc, ModifyArgsInjector.llIlIlllIlI[5]).substring(1));
        if (this.methodNode.desc.equals(format2)) {
            return true;
        }
        throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(ModifyArgsInjector.llIlIlllIlI[7]).append(this).append(ModifyArgsInjector.llIlIlllIlI[8]).append(this.methodNode.desc).append(ModifyArgsInjector.llIlIlllIlI[9]).append(format).append(ModifyArgsInjector.llIlIlllIlI[10]).append(format2)));
    }
    
    private void packArgs(final InsnList list, final String s, final MethodInsnNode methodInsnNode) {
        list.add(new MethodInsnNode(184, s, ModifyArgsInjector.llIlIlllIlI[13], Bytecode.changeDescriptorReturnType(methodInsnNode.desc, String.valueOf(new StringBuilder().append(ModifyArgsInjector.llIlIlllIlI[11]).append(s).append(ModifyArgsInjector.llIlIlllIlI[12]))), false));
        list.add(new InsnNode(89));
        if (!this.isStatic) {
            list.add(new VarInsnNode(25, 0));
            list.add(new InsnNode(95));
        }
    }
    
    private static void unpackArgs(final InsnList list, final String s, final Type[] array) {
        for (int i = 0; i < array.length; ++i) {
            if (i < array.length - 1) {
                list.add(new InsnNode(89));
            }
            list.add(new MethodInsnNode(182, s, String.valueOf(new StringBuilder().append(ModifyArgsInjector.llIlIlllIlI[14]).append(i)), String.valueOf(new StringBuilder().append(ModifyArgsInjector.llIlIlllIlI[15]).append(array[i].getDescriptor())), false));
            if (i < array.length - 1) {
                if (array[i].getSize() == 1) {
                    list.add(new InsnNode(95));
                }
                else {
                    list.add(new InsnNode(93));
                    list.add(new InsnNode(88));
                }
            }
        }
    }
    
    static {
        lIIlIlIlIlIIl();
    }
    
    private static void lIIlIlIlIlIIl() {
        (llIlIlllIlI = new String[16])[0] = "@ModifyArgs";
        ModifyArgsInjector.llIlIlllIlI[1] = "@ModifyArgs injector ";
        ModifyArgsInjector.llIlIlllIlI[2] = " targets a method invocation ";
        ModifyArgsInjector.llIlIlllIlI[3] = " with no arguments!";
        ModifyArgsInjector.llIlIlllIlI[4] = "(L%s;)V";
        ModifyArgsInjector.llIlIlllIlI[5] = "V";
        ModifyArgsInjector.llIlIlllIlI[6] = "(L%s;%s";
        ModifyArgsInjector.llIlIlllIlI[7] = "@ModifyArgs injector ";
        ModifyArgsInjector.llIlIlllIlI[8] = " has an invalid signature ";
        ModifyArgsInjector.llIlIlllIlI[9] = ", expected ";
        ModifyArgsInjector.llIlIlllIlI[10] = " or ";
        ModifyArgsInjector.llIlIlllIlI[11] = "L";
        ModifyArgsInjector.llIlIlllIlI[12] = ";";
        ModifyArgsInjector.llIlIlllIlI[13] = "of";
        ModifyArgsInjector.llIlIlllIlI[14] = "$";
        ModifyArgsInjector.llIlIlllIlI[15] = "()";
    }
    
    private static String lIIlIlIIllllI(String s, final String s2) {
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
    
    private static String lIIlIlIIlllll(final String s, final String s2) {
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
    
    private static String lIIlIlIlIIlII(final String s, final String s2) {
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
}
