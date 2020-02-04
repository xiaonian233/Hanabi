package org.spongepowered.asm.mixin.injection.code;

import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.throwables.*;
import org.spongepowered.asm.mixin.refmap.*;
import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.mixin.transformer.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public abstract class Injector
{
    public static final Logger logger;
    protected InjectionInfo info;
    protected final ClassNode classNode;
    protected final MethodNode methodNode;
    protected final Type[] methodArgs;
    protected final Type returnType;
    protected final boolean isStatic;
    private static final String[] lIllIllIlI;
    
    public Injector(final InjectionInfo info) {
        this(info.getClassNode(), info.getMethod());
        this.info = info;
    }
    
    private Injector(final ClassNode classNode, final MethodNode methodNode) {
        super();
        this.classNode = classNode;
        this.methodNode = methodNode;
        this.methodArgs = Type.getArgumentTypes(this.methodNode.desc);
        this.returnType = Type.getReturnType(this.methodNode.desc);
        this.isStatic = Bytecode.methodIsStatic(this.methodNode);
    }
    
    @Override
    public String toString() {
        return String.format(Injector.lIllIllIlI[0], this.classNode.name, this.methodNode.name);
    }
    
    public final List<InjectionNodes.InjectionNode> find(final InjectorTarget injectorTarget, final List<InjectionPoint> list) {
        this.sanityCheck(injectorTarget.target, list);
        final ArrayList<InjectionNodes.InjectionNode> list2 = new ArrayList<InjectionNodes.InjectionNode>();
        for (final TargetNode targetNode : this.findTargetNodes(injectorTarget, list)) {
            this.addTargetNode(injectorTarget.target, list2, targetNode.insn, targetNode.nominators);
        }
        return list2;
    }
    
    protected void addTargetNode(final Target target, final List<InjectionNodes.InjectionNode> list, final AbstractInsnNode abstractInsnNode, final Set<InjectionPoint> set) {
        list.add(target.addInjectionNode(abstractInsnNode));
    }
    
    public final void inject(final Target target, final List<InjectionNodes.InjectionNode> list) {
        final Iterator<InjectionNodes.InjectionNode> iterator = list.iterator();
        while (iterator.hasNext()) {
            final InjectionNodes.InjectionNode injectionNode;
            if ((injectionNode = iterator.next()).currentTarget == null) {
                if (!this.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
                    continue;
                }
                Injector.logger.warn(Injector.lIllIllIlI[1], new Object[] { this.info, target });
            }
            else {
                this.inject(target, injectionNode);
            }
        }
        final Iterator<InjectionNodes.InjectionNode> iterator2 = list.iterator();
        while (iterator2.hasNext()) {
            this.postInject(target, iterator2.next());
        }
    }
    
    private Collection<TargetNode> findTargetNodes(final InjectorTarget injectorTarget, final List<InjectionPoint> list) {
        final IMixinContext context = this.info.getContext();
        final MethodNode method = injectorTarget.target.method;
        final TreeMap<Object, Object> treeMap = new TreeMap<Object, Object>();
        final ArrayList<AbstractInsnNode> list2 = new ArrayList<AbstractInsnNode>(32);
        for (final InjectionPoint injectionPoint : list) {
            list2.clear();
            if (injectorTarget.mergedBy != null && !context.getClassName().equals(injectorTarget.mergedBy) && !injectionPoint.checkPriority(injectorTarget.mergedPriority, context.getPriority())) {
                throw new InvalidInjectionException(this.info, String.format(Injector.lIllIllIlI[2], injectionPoint, this, context.getPriority(), injectorTarget, injectorTarget.mergedBy, injectorTarget.mergedPriority));
            }
            final MethodNode methodNode = method;
            final InjectionPoint injectionPoint2 = injectionPoint;
            final String slice = injectionPoint.slice;
            ReadOnlyInsnList slice2;
            if ((slice2 = injectorTarget.cache.get(slice)) == null) {
                final MethodSlice slice3;
                if ((slice3 = injectorTarget.context.getSlice(slice)) != null) {
                    slice2 = slice3.getSlice(injectorTarget.target.method);
                }
                else {
                    slice2 = new ReadOnlyInsnList(injectorTarget.target.method.instructions);
                }
                injectorTarget.cache.put(slice, slice2);
            }
            if (!this.findTargetNodes(methodNode, injectionPoint2, slice2, list2)) {
                continue;
            }
            for (final AbstractInsnNode abstractInsnNode : list2) {
                final Integer value = method.instructions.indexOf(abstractInsnNode);
                TargetNode targetNode;
                if ((targetNode = treeMap.get(value)) == null) {
                    targetNode = new TargetNode(abstractInsnNode);
                    treeMap.put(value, targetNode);
                }
                targetNode.nominators.add(injectionPoint);
            }
        }
        return treeMap.values();
    }
    
    protected boolean findTargetNodes(final MethodNode methodNode, final InjectionPoint injectionPoint, final InsnList list, final Collection<AbstractInsnNode> collection) {
        return injectionPoint.find(methodNode.desc, list, collection);
    }
    
    public void sanityCheck(final Target target, final List<InjectionPoint> list) {
        if (lIIIIllIIlIl(target.classNode, this.classNode)) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(Injector.lIllIllIlI[3]).append(this)));
        }
    }
    
    protected abstract void inject(final Target p0, final InjectionNodes.InjectionNode p1);
    
    public void postInject(final Target target, final InjectionNodes.InjectionNode injectionNode) {
    }
    
    protected final AbstractInsnNode invokeHandler(final InsnList list) {
        return this.invokeHandler(list, this.methodNode);
    }
    
    protected final AbstractInsnNode invokeHandler(final InsnList list, final MethodNode methodNode) {
        final boolean b = (methodNode.access & 0x2) != 0x0;
        final MethodInsnNode methodInsnNode = new MethodInsnNode(this.isStatic ? 184 : (b ? 183 : 182), this.classNode.name, methodNode.name, methodNode.desc, false);
        list.add(methodInsnNode);
        this.info.addCallbackInvocation$1bc9beba();
        return methodInsnNode;
    }
    
    protected static void throwException(final InsnList list, final String s, final String s2) {
        list.add(new TypeInsnNode(187, s));
        list.add(new InsnNode(89));
        list.add(new LdcInsnNode(s2));
        list.add(new MethodInsnNode(183, s, Injector.lIllIllIlI[4], Injector.lIllIllIlI[5], false));
        list.add(new InsnNode(191));
    }
    
    public static boolean canCoerce(final Type type, final Type type2) {
        if (type.sort == 10 && type2.sort == 10) {
            final ClassInfo forType = ClassInfo.forType(type);
            final ClassInfo forType2 = ClassInfo.forType(type2);
            final ClassInfo classInfo = forType;
            return forType != null && forType2 != null && (!lIIIIllIIlIl(forType2, classInfo) || forType2.hasSuperClass(classInfo));
        }
        final String descriptor = type.getDescriptor();
        final String descriptor2 = type2.getDescriptor();
        final String s = descriptor;
        if (descriptor.length() > 1 || lIIIIllIlIII(descriptor2.length(), 1)) {
            return false;
        }
        final char char1 = s.charAt(0);
        final char char2 = descriptor2.charAt(0);
        final char c = char1;
        return char2 == 'I' && lIIIIllIlIII(Injector.lIllIllIlI[6].indexOf(c), -1);
    }
    
    private static boolean canCoerce(final String s, final String s2) {
        if (s.length() > 1 || lIIIIllIlIII(s2.length(), 1)) {
            return false;
        }
        final char char1 = s.charAt(0);
        final char char2 = s2.charAt(0);
        final char c = char1;
        return char2 == 'I' && lIIIIllIlIII(Injector.lIllIllIlI[6].indexOf(c), -1);
    }
    
    private static boolean canCoerce(final char c, final char c2) {
        return c2 == 'I' && lIIIIllIlIII(Injector.lIllIllIlI[6].indexOf(c), -1);
    }
    
    private static boolean canCoerce(final ClassInfo classInfo, final ClassInfo classInfo2) {
        return classInfo != null && classInfo2 != null && (!lIIIIllIIlIl(classInfo2, classInfo) || classInfo2.hasSuperClass(classInfo));
    }
    
    static {
        lIIIIlIllllI();
        logger = LogManager.getLogger(Injector.lIllIllIlI[7]);
    }
    
    private static void lIIIIlIllllI() {
        (lIllIllIlI = new String[8])[0] = "%s::%s";
        Injector.lIllIllIlI[1] = "Target node for {} was removed by a previous injector in {}";
        Injector.lIllIllIlI[2] = "%s on %s with priority %d cannot inject into %s merged by %s with priority %d";
        Injector.lIllIllIlI[3] = "Target class does not match injector class in ";
        Injector.lIllIllIlI[4] = "<init>";
        Injector.lIllIllIlI[5] = "(Ljava/lang/String;)V";
        Injector.lIllIllIlI[6] = "IBSCZ";
        Injector.lIllIllIlI[7] = "mixin";
    }
    
    private static String lIIIIlIlllII(final String s, final String s2) {
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
    
    private static String lIIIIlIllIll(final String s, final String s2) {
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
    
    private static String lIIIIlIlllIl(String s, final String s2) {
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
    
    private static boolean lIIIIllIIlll$255f299(final int n) {
        return n <= 1;
    }
    
    private static boolean lIIIIllIlIII(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIIIllIIlIl(final Object o, final Object o2) {
        return o != o2;
    }
}
