package org.spongepowered.asm.mixin.injection.modify;

import org.spongepowered.asm.mixin.injection.code.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.throwables.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.lib.tree.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import org.spongepowered.asm.mixin.refmap.*;

public final class ModifyVariableInjector extends Injector
{
    private final LocalVariableDiscriminator discriminator;
    private static final String[] llIllIllII;
    
    public ModifyVariableInjector(final InjectionInfo injectionInfo, final LocalVariableDiscriminator discriminator) {
        super(injectionInfo);
        this.discriminator = discriminator;
    }
    
    public final boolean findTargetNodes(final MethodNode methodNode, final InjectionPoint injectionPoint, final InsnList list, final Collection<AbstractInsnNode> collection) {
        if (injectionPoint instanceof ContextualInjectionPoint) {
            return ((ContextualInjectionPoint)injectionPoint).find(this.info.getContext().getTargetMethod(methodNode), collection);
        }
        return injectionPoint.find(methodNode.desc, list, collection);
    }
    
    @Override
    public final void sanityCheck(final Target target, final List<InjectionPoint> list) {
        super.sanityCheck(target, list);
        if (target.isStatic != this.isStatic) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(ModifyVariableInjector.llIllIllII[0]).append(this)));
        }
        final int ordinal;
        if ((ordinal = this.discriminator.ordinal) < -1) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(ModifyVariableInjector.llIllIllII[1]).append(ordinal).append(ModifyVariableInjector.llIllIllII[2]).append(this)));
        }
        if (this.discriminator.index == 0 && !this.isStatic) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(ModifyVariableInjector.llIllIllII[3]).append(this)));
        }
    }
    
    public final void inject(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        if (injectionNode.isReplaced()) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(ModifyVariableInjector.llIllIllII[4]).append(this).append(ModifyVariableInjector.llIllIllII[5])));
        }
        final Context context = new Context(this.returnType, this.discriminator.argsOnly, target, injectionNode.currentTarget);
        if (this.discriminator.print) {
            final Context context2 = context;
            new SignaturePrinter(this.methodNode.name, this.returnType, this.methodArgs, new String[] { ModifyVariableInjector.llIllIllII[10] }).setModifiers(this.methodNode);
            new PrettyPrinter().kvWidth(20).kv(ModifyVariableInjector.llIllIllII[11], (Object)this.classNode.name.replace('/', '.')).kv(ModifyVariableInjector.llIllIllII[12], (Object)context2.target.method.name).kv(ModifyVariableInjector.llIllIllII[13], (Object)this.methodNode.name).kv(ModifyVariableInjector.llIllIllII[14], (Object)SignaturePrinter.getTypeName$1388108(this.returnType)).kv(ModifyVariableInjector.llIllIllII[15], ModifyVariableInjector.llIllIllII[16], context2.node.getClass().getSimpleName(), Bytecode.getOpcodeName(context2.node.getOpcode())).hr('*').kv(ModifyVariableInjector.llIllIllII[17], (Object)(this.discriminator.isImplicit(context2) ? ModifyVariableInjector.llIllIllII[18] : ModifyVariableInjector.llIllIllII[19])).kv(ModifyVariableInjector.llIllIllII[20], (this.discriminator.ordinal < 0) ? ModifyVariableInjector.llIllIllII[21] : this.discriminator.ordinal).kv(ModifyVariableInjector.llIllIllII[22], (this.discriminator.index < context2.baseArgIndex) ? ModifyVariableInjector.llIllIllII[23] : this.discriminator.index).kv(ModifyVariableInjector.llIllIllII[24], this.discriminator.hasNames() ? this.discriminator.names : ModifyVariableInjector.llIllIllII[25]).kv(ModifyVariableInjector.llIllIllII[26], this.discriminator.argsOnly).hr('*').add(context2).print(System.err);
        }
        final String descriptor;
        if (!(descriptor = Bytecode.getDescriptor(new Type[] { this.returnType }, this.returnType)).equals(this.methodNode.desc)) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(ModifyVariableInjector.llIllIllII[6]).append(this).append(ModifyVariableInjector.llIllIllII[7]).append(descriptor).append(ModifyVariableInjector.llIllIllII[8]).append(this.methodNode.desc)));
        }
        final LocalVariableDiscriminator discriminator = this.discriminator;
        final Context context3 = context;
        try {
            final int local;
            if ((local = discriminator.findLocal(context3)) >= 0) {
                final Context context4 = context;
                if (!this.isStatic) {
                    context4.insns.add(new VarInsnNode(25, 0));
                }
                context4.insns.add(new VarInsnNode(this.returnType.getOpcode(21), local));
                this.invokeHandler(context4.insns);
                context4.insns.add(new VarInsnNode(this.returnType.getOpcode(54), local));
            }
        }
        catch (InvalidImplicitDiscriminatorException ex) {
            if (this.discriminator.print) {
                this.info.addCallbackInvocation$1bc9beba();
                return;
            }
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(ModifyVariableInjector.llIllIllII[9]).append(this)), ex);
        }
        target.insns.insertBefore(context.node, context.insns);
        target.addToStack(this.isStatic ? 1 : 2);
    }
    
    private void printLocals(final Context context) {
        new SignaturePrinter(this.methodNode.name, this.returnType, this.methodArgs, new String[] { ModifyVariableInjector.llIllIllII[10] }).setModifiers(this.methodNode);
        new PrettyPrinter().kvWidth(20).kv(ModifyVariableInjector.llIllIllII[11], (Object)this.classNode.name.replace('/', '.')).kv(ModifyVariableInjector.llIllIllII[12], (Object)context.target.method.name).kv(ModifyVariableInjector.llIllIllII[13], (Object)this.methodNode.name).kv(ModifyVariableInjector.llIllIllII[14], (Object)SignaturePrinter.getTypeName$1388108(this.returnType)).kv(ModifyVariableInjector.llIllIllII[15], ModifyVariableInjector.llIllIllII[16], context.node.getClass().getSimpleName(), Bytecode.getOpcodeName(context.node.getOpcode())).hr('*').kv(ModifyVariableInjector.llIllIllII[17], (Object)(this.discriminator.isImplicit(context) ? ModifyVariableInjector.llIllIllII[18] : ModifyVariableInjector.llIllIllII[19])).kv(ModifyVariableInjector.llIllIllII[20], (this.discriminator.ordinal < 0) ? ModifyVariableInjector.llIllIllII[21] : this.discriminator.ordinal).kv(ModifyVariableInjector.llIllIllII[22], (this.discriminator.index < context.baseArgIndex) ? ModifyVariableInjector.llIllIllII[23] : this.discriminator.index).kv(ModifyVariableInjector.llIllIllII[24], this.discriminator.hasNames() ? this.discriminator.names : ModifyVariableInjector.llIllIllII[25]).kv(ModifyVariableInjector.llIllIllII[26], this.discriminator.argsOnly).hr('*').add(context).print(System.err);
    }
    
    private void inject(final Context context, final int n) {
        if (!this.isStatic) {
            context.insns.add(new VarInsnNode(25, 0));
        }
        context.insns.add(new VarInsnNode(this.returnType.getOpcode(21), n));
        this.invokeHandler(context.insns);
        context.insns.add(new VarInsnNode(this.returnType.getOpcode(54), n));
    }
    
    static {
        lIIlllIlIllI();
    }
    
    private static void lIIlllIlIllI() {
        (llIllIllII = new String[27])[0] = "'static' of variable modifier method does not match target in ";
        ModifyVariableInjector.llIllIllII[1] = "Invalid ordinal ";
        ModifyVariableInjector.llIllIllII[2] = " specified in ";
        ModifyVariableInjector.llIllIllII[3] = "Invalid index 0 specified in non-static variable modifier ";
        ModifyVariableInjector.llIllIllII[4] = "Variable modifier target for ";
        ModifyVariableInjector.llIllIllII[5] = " was removed by another injector";
        ModifyVariableInjector.llIllIllII[6] = "Variable modifier ";
        ModifyVariableInjector.llIllIllII[7] = " has an invalid signature, expected ";
        ModifyVariableInjector.llIllIllII[8] = " but found ";
        ModifyVariableInjector.llIllIllII[9] = "Implicit variable modifier injection failed in ";
        ModifyVariableInjector.llIllIllII[10] = "var";
        ModifyVariableInjector.llIllIllII[11] = "Target Class";
        ModifyVariableInjector.llIllIllII[12] = "Target Method";
        ModifyVariableInjector.llIllIllII[13] = "Callback Name";
        ModifyVariableInjector.llIllIllII[14] = "Capture Type";
        ModifyVariableInjector.llIllIllII[15] = "Instruction";
        ModifyVariableInjector.llIllIllII[16] = "%s %s";
        ModifyVariableInjector.llIllIllII[17] = "Match mode";
        ModifyVariableInjector.llIllIllII[18] = "IMPLICIT (match single)";
        ModifyVariableInjector.llIllIllII[19] = "EXPLICIT (match by criteria)";
        ModifyVariableInjector.llIllIllII[20] = "Match ordinal";
        ModifyVariableInjector.llIllIllII[21] = "any";
        ModifyVariableInjector.llIllIllII[22] = "Match index";
        ModifyVariableInjector.llIllIllII[23] = "any";
        ModifyVariableInjector.llIllIllII[24] = "Match name(s)";
        ModifyVariableInjector.llIllIllII[25] = "any";
        ModifyVariableInjector.llIllIllII[26] = "Args only";
    }
    
    private static String lIIlllIlIIll(final String s, final String s2) {
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
    
    private static String lIIlllIlIIIl(final String s, final String s2) {
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
    
    private static String lIIlllIlIlIl(String s, final String s2) {
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
    
    private static boolean lIlIIIIIIlll$255f299(final int n) {
        return n >= 0;
    }
    
    private static boolean lIlIIIIIlIII(final int n) {
        return n < 0;
    }
    
    private static boolean lIlIIIIIIlII(final int n, final int n2) {
        return n != n2;
    }
}
