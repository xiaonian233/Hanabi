package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.transformers.*;
import org.spongepowered.asm.util.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.mixin.transformer.throwables.*;
import org.spongepowered.asm.lib.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;

final class MixinPostProcessor extends TreeTransformer implements MixinConfig.IListener
{
    final Set<String> syntheticInnerClasses;
    private final Map<String, MixinInfo> accessorMixins;
    final Set<String> loadable;
    private static final String[] lIlIIIllIII;
    
    MixinPostProcessor() {
        super();
        this.syntheticInnerClasses = new HashSet<String>();
        this.accessorMixins = new HashMap<String, MixinInfo>();
        this.loadable = new HashSet<String>();
    }
    
    @Override
    public final void onInit(final MixinInfo mixinInfo) {
        final Iterator<String> iterator = Collections.unmodifiableSet((Set<? extends String>)mixinInfo.getState().getSyntheticInnerClasses()).iterator();
        while (iterator.hasNext()) {
            this.syntheticInnerClasses.add(iterator.next().replace('/', '.'));
        }
    }
    
    @Override
    public final void onPrepare(final MixinInfo mixinInfo) {
        final String className = mixinInfo.className;
        if (mixinInfo.type.isLoadable()) {
            this.registerLoadable(className);
        }
        if (mixinInfo.type instanceof MixinInfo.SubType.Accessor) {
            this.registerLoadable(mixinInfo.className);
            this.accessorMixins.put(mixinInfo.className, mixinInfo);
        }
    }
    
    private void registerSyntheticInner(final String s) {
        this.syntheticInnerClasses.add(s);
    }
    
    private void registerLoadable(final String s) {
        this.loadable.add(s);
    }
    
    private void registerAccessor(final MixinInfo mixinInfo) {
        this.registerLoadable(mixinInfo.className);
        this.accessorMixins.put(mixinInfo.className, mixinInfo);
    }
    
    private boolean canTransform(final String s) {
        return this.syntheticInnerClasses.contains(s) || this.loadable.contains(s);
    }
    
    @Override
    public final String getName() {
        return this.getClass().getName();
    }
    
    @Override
    public final boolean isDelegationExcluded() {
        return true;
    }
    
    @Override
    public final byte[] transformClassBytes(final String s, final String s2, final byte[] array) {
        if (this.syntheticInnerClasses.contains(s2)) {
            final ClassReader classReader = new ClassReader(array);
            final MixinClassWriter mixinClassWriter = new MixinClassWriter(classReader, 0);
            classReader.accept(new ClassVisitor(mixinClassWriter) {
                private /* synthetic */ MixinPostProcessor this$0;
                
                MixinPostProcessor$1(final ClassVisitor classVisitor) {
                    super(classVisitor);
                }
                
                @Override
                public final void visit(final int n, final int n2, final String s, final String s2, final String s3, final String[] array) {
                    super.visit(n, n2 | 0x1, s, s2, s3, array);
                }
                
                @Override
                public final FieldVisitor visitField(int n, final String s, final String s2, final String s3, final Object o) {
                    if ((n & 0x6) == 0x0) {
                        n |= 0x1;
                    }
                    return super.visitField(n, s, s2, s3, o);
                }
                
                @Override
                public final MethodVisitor visitMethod(int n, final String s, final String s2, final String s3, final String[] array) {
                    if ((n & 0x6) == 0x0) {
                        n |= 0x1;
                    }
                    return super.visitMethod(n, s, s2, s3, array);
                }
            }, 8);
            return mixinClassWriter.toByteArray();
        }
        if (this.accessorMixins.containsKey(s2)) {
            final MixinInfo mixinInfo = this.accessorMixins.get(s2);
            if (MixinEnvironment.getCompatibilityLevel().isAtLeast(MixinEnvironment.CompatibilityLevel.JAVA_8)) {
                boolean b = false;
                final MixinInfo.MixinClassNode classNode = mixinInfo.getClassNode(0);
                final ClassInfo classInfo = Collections.unmodifiableList((List<? extends ClassInfo>)mixinInfo.targetClasses).get(0);
                final Iterator<MixinInfo.MixinMethodNode> iterator = classNode.mixinMethods.iterator();
                while (iterator.hasNext()) {
                    final MixinInfo.MixinMethodNode mixinMethodNode;
                    if (Bytecode.hasFlag(mixinMethodNode = iterator.next(), 8)) {
                        final AnnotationNode visible = Annotations.getVisible(mixinMethodNode, Accessor.class);
                        final AnnotationNode visible2 = Annotations.getVisible(mixinMethodNode, Invoker.class);
                        if (visible == null && visible2 == null) {
                            continue;
                        }
                        final MixinInfo mixinInfo2 = mixinInfo;
                        final MixinInfo.MixinMethodNode mixinMethodNode2 = mixinMethodNode;
                        final ClassInfo classInfo2 = classInfo;
                        final MixinInfo.MixinMethodNode mixinMethodNode3 = mixinMethodNode2;
                        final MixinInfo mixinInfo3 = mixinInfo2;
                        final ClassInfo.Method method$680e33ff;
                        if (!(method$680e33ff = mixinInfo2.info.findMethod$680e33ff(mixinMethodNode3)).isRenamed()) {
                            throw new MixinTransformerError(String.valueOf(new StringBuilder().append(MixinPostProcessor.lIlIIIllIII[0]).append(mixinInfo3).append(MixinPostProcessor.lIlIIIllIII[1]).append(classInfo2).append(MixinPostProcessor.lIlIIIllIII[2])));
                        }
                        final ClassInfo.Method method = method$680e33ff;
                        final MixinInfo.MixinMethodNode mixinMethodNode4 = mixinMethodNode;
                        final ClassInfo classInfo3 = classInfo;
                        final ClassInfo.Method method2 = method;
                        final ClassInfo classInfo4 = classInfo3;
                        final MixinInfo.MixinMethodNode mixinMethodNode5 = mixinMethodNode4;
                        mixinMethodNode4.instructions.removeAll$1385ff();
                        final Type[] argumentTypes = Type.getArgumentTypes(mixinMethodNode5.desc);
                        final Type returnType = Type.getReturnType(mixinMethodNode5.desc);
                        Bytecode.loadArgs(argumentTypes, mixinMethodNode5.instructions, 0);
                        mixinMethodNode5.instructions.add(new MethodInsnNode(184, classInfo4.name, method2.getName(), mixinMethodNode5.desc, false));
                        mixinMethodNode5.instructions.add(new InsnNode(returnType.getOpcode(172)));
                        mixinMethodNode5.maxStack = Bytecode.getFirstNonArgLocalIndex(argumentTypes, false);
                        mixinMethodNode5.maxLocals = 0;
                        b = true;
                    }
                }
                if (b) {
                    return this.writeClass(classNode);
                }
            }
            return array;
        }
        return array;
    }
    
    private static byte[] processSyntheticInner(final byte[] array) {
        final ClassReader classReader = new ClassReader(array);
        final MixinClassWriter mixinClassWriter = new MixinClassWriter(classReader, 0);
        classReader.accept(new ClassVisitor(mixinClassWriter) {
            private /* synthetic */ MixinPostProcessor this$0;
            
            MixinPostProcessor$1(final ClassVisitor classVisitor) {
                super(classVisitor);
            }
            
            @Override
            public final void visit(final int n, final int n2, final String s, final String s2, final String s3, final String[] array) {
                super.visit(n, n2 | 0x1, s, s2, s3, array);
            }
            
            @Override
            public final FieldVisitor visitField(int n, final String s, final String s2, final String s3, final Object o) {
                if ((n & 0x6) == 0x0) {
                    n |= 0x1;
                }
                return super.visitField(n, s, s2, s3, o);
            }
            
            @Override
            public final MethodVisitor visitMethod(int n, final String s, final String s2, final String s3, final String[] array) {
                if ((n & 0x6) == 0x0) {
                    n |= 0x1;
                }
                return super.visitMethod(n, s, s2, s3, array);
            }
        }, 8);
        return mixinClassWriter.toByteArray();
    }
    
    private byte[] processAccessor(final byte[] array, final MixinInfo mixinInfo) {
        if (!MixinEnvironment.getCompatibilityLevel().isAtLeast(MixinEnvironment.CompatibilityLevel.JAVA_8)) {
            return array;
        }
        boolean b = false;
        final MixinInfo.MixinClassNode classNode = mixinInfo.getClassNode(0);
        final ClassInfo classInfo = Collections.unmodifiableList((List<? extends ClassInfo>)mixinInfo.targetClasses).get(0);
        final Iterator<MixinInfo.MixinMethodNode> iterator = classNode.mixinMethods.iterator();
        while (iterator.hasNext()) {
            final MixinInfo.MixinMethodNode mixinMethodNode;
            if (Bytecode.hasFlag(mixinMethodNode = iterator.next(), 8)) {
                final AnnotationNode visible = Annotations.getVisible(mixinMethodNode, Accessor.class);
                final AnnotationNode visible2 = Annotations.getVisible(mixinMethodNode, Invoker.class);
                if (visible == null && visible2 == null) {
                    continue;
                }
                final MixinInfo.MixinMethodNode mixinMethodNode2 = mixinMethodNode;
                final ClassInfo classInfo2 = classInfo;
                final ClassInfo.Method method$680e33ff;
                if (!(method$680e33ff = mixinInfo.info.findMethod$680e33ff(mixinMethodNode2)).isRenamed()) {
                    throw new MixinTransformerError(String.valueOf(new StringBuilder().append(MixinPostProcessor.lIlIIIllIII[0]).append(mixinInfo).append(MixinPostProcessor.lIlIIIllIII[1]).append(classInfo2).append(MixinPostProcessor.lIlIIIllIII[2])));
                }
                final ClassInfo.Method method = method$680e33ff;
                final MixinInfo.MixinMethodNode mixinMethodNode3 = mixinMethodNode;
                final ClassInfo classInfo3 = classInfo;
                final ClassInfo.Method method2 = method;
                final ClassInfo classInfo4 = classInfo3;
                final MixinInfo.MixinMethodNode mixinMethodNode4 = mixinMethodNode3;
                mixinMethodNode3.instructions.removeAll$1385ff();
                final Type[] argumentTypes = Type.getArgumentTypes(mixinMethodNode4.desc);
                final Type returnType = Type.getReturnType(mixinMethodNode4.desc);
                Bytecode.loadArgs(argumentTypes, mixinMethodNode4.instructions, 0);
                mixinMethodNode4.instructions.add(new MethodInsnNode(184, classInfo4.name, method2.getName(), mixinMethodNode4.desc, false));
                mixinMethodNode4.instructions.add(new InsnNode(returnType.getOpcode(172)));
                mixinMethodNode4.maxStack = Bytecode.getFirstNonArgLocalIndex(argumentTypes, false);
                mixinMethodNode4.maxLocals = 0;
                b = true;
            }
        }
        if (b) {
            return this.writeClass(classNode);
        }
        return array;
    }
    
    private static ClassInfo.Method getAccessorMethod(final MixinInfo mixinInfo, final MethodNode methodNode, final ClassInfo classInfo) throws MixinTransformerError {
        final ClassInfo.Method method$680e33ff;
        if (!(method$680e33ff = mixinInfo.info.findMethod$680e33ff(methodNode)).isRenamed()) {
            throw new MixinTransformerError(String.valueOf(new StringBuilder().append(MixinPostProcessor.lIlIIIllIII[0]).append(mixinInfo).append(MixinPostProcessor.lIlIIIllIII[1]).append(classInfo).append(MixinPostProcessor.lIlIIIllIII[2])));
        }
        return method$680e33ff;
    }
    
    private static void createProxy(final MethodNode methodNode, final ClassInfo classInfo, final ClassInfo.Method method) {
        methodNode.instructions.removeAll$1385ff();
        final Type[] argumentTypes = Type.getArgumentTypes(methodNode.desc);
        final Type returnType = Type.getReturnType(methodNode.desc);
        Bytecode.loadArgs(argumentTypes, methodNode.instructions, 0);
        methodNode.instructions.add(new MethodInsnNode(184, classInfo.name, method.getName(), methodNode.desc, false));
        methodNode.instructions.add(new InsnNode(returnType.getOpcode(172)));
        methodNode.maxStack = Bytecode.getFirstNonArgLocalIndex(argumentTypes, false);
        methodNode.maxLocals = 0;
    }
    
    static {
        lllIIIllIllI();
    }
    
    private static void lllIIIllIllI() {
        (lIlIIIllIII = new String[3])[0] = "Unexpected state: ";
        MixinPostProcessor.lIlIIIllIII[1] = " loaded before ";
        MixinPostProcessor.lIlIIIllIII[2] = " was conformed";
    }
    
    private static String lllIIIlIllll(final String s, final String s2) {
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
    
    private static String lllIIIllIlIl(final String s, final String s2) {
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
