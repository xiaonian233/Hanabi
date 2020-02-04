package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.mixin.transformer.ext.*;
import org.spongepowered.asm.mixin.struct.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.mixin.*;
import java.lang.annotation.*;
import org.spongepowered.asm.util.*;
import java.io.*;
import org.spongepowered.asm.lib.tree.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class TargetClassContext extends ClassContext implements ITargetClassContext
{
    private static final Logger logger;
    private final MixinEnvironment env;
    final Extensions extensions;
    final String sessionId;
    final String className;
    public final ClassNode classNode;
    private ClassInfo classInfo;
    final SourceMap sourceMap;
    private final ClassSignature signature;
    private final SortedSet<MixinInfo> mixins;
    private final Map<String, Target> targetMethods;
    private final Set<MethodNode> mixinMethods;
    private int nextUniqueMethodIndex;
    int nextUniqueFieldIndex;
    private boolean applied;
    boolean forceExport;
    static final String[] llllIIl;
    
    TargetClassContext(final MixinEnvironment env, final Extensions extensions, final String sessionId, final String className, final ClassNode classNode, final SortedSet<MixinInfo> mixins) {
        super();
        this.targetMethods = new HashMap<String, Target>();
        this.mixinMethods = new HashSet<MethodNode>();
        this.env = env;
        this.extensions = extensions;
        this.sessionId = sessionId;
        this.className = className;
        this.classNode = classNode;
        this.classInfo = ClassInfo.fromClassNode(classNode);
        this.signature = this.classInfo.signature.wake();
        this.mixins = mixins;
        (this.sourceMap = new SourceMap(classNode.sourceFile)).addFile(this.classNode);
    }
    
    @Override
    public final String toString() {
        return this.className;
    }
    
    private boolean isApplied() {
        return this.applied;
    }
    
    private boolean isExportForced() {
        return this.forceExport;
    }
    
    private Extensions getExtensions() {
        return this.extensions;
    }
    
    private String getSessionId() {
        return this.sessionId;
    }
    
    public final String getClassRef() {
        return this.classNode.name;
    }
    
    private String getClassName() {
        return this.className;
    }
    
    @Override
    public final ClassNode getClassNode() {
        return this.classNode;
    }
    
    private List<MethodNode> getMethods() {
        return this.classNode.methods;
    }
    
    private List<FieldNode> getFields() {
        return this.classNode.fields;
    }
    
    @Override
    public final ClassInfo getClassInfo() {
        return this.classInfo;
    }
    
    private SortedSet<MixinInfo> getMixins() {
        return this.mixins;
    }
    
    private SourceMap getSourceMap() {
        return this.sourceMap;
    }
    
    final void mergeSignature(final ClassSignature classSignature) {
        this.signature.merge(classSignature);
    }
    
    final void addMixinMethod(final MethodNode methodNode) {
        this.mixinMethods.add(methodNode);
    }
    
    final void methodMerged(final MethodNode methodNode) {
        if (!this.mixinMethods.remove(methodNode)) {
            TargetClassContext.logger.debug(TargetClassContext.llllIIl[0], new Object[] { methodNode.name, methodNode.desc, this });
        }
    }
    
    final MethodNode findMethod(final Deque<String> deque, final String s) {
        return this.findAliasedMethod(deque, s, true);
    }
    
    final MethodNode findAliasedMethod(final Deque<String> deque, final String s) {
        return this.findAliasedMethod(deque, s, false);
    }
    
    private MethodNode findAliasedMethod(Deque<String> deque, String s, boolean b) {
        String s2;
        while ((s2 = deque.poll()) != null) {
            final Iterator<MethodNode> iterator = this.classNode.methods.iterator();
            while (iterator.hasNext()) {
                final MethodNode methodNode;
                if ((methodNode = iterator.next()).name.equals(s2) && methodNode.desc.equals(s)) {
                    return methodNode;
                }
            }
            if (b) {
                final Iterator<MethodNode> iterator2 = this.mixinMethods.iterator();
                while (iterator2.hasNext()) {
                    final MethodNode methodNode2;
                    if ((methodNode2 = iterator2.next()).name.equals(s2) && methodNode2.desc.equals(s)) {
                        return methodNode2;
                    }
                }
            }
            final TargetClassContext targetClassContext = this;
            final Deque<String> deque2 = deque;
            final String s3 = s;
            b = false;
            s = s3;
            deque = deque2;
            this = targetClassContext;
        }
        return null;
    }
    
    final FieldNode findAliasedField(final Deque<String> deque, final String s) {
        String s2;
        while ((s2 = deque.poll()) != null) {
            final Iterator<FieldNode> iterator = this.classNode.fields.iterator();
            while (iterator.hasNext()) {
                final FieldNode fieldNode;
                if ((fieldNode = iterator.next()).name.equals(s2) && fieldNode.desc.equals(s)) {
                    return fieldNode;
                }
            }
        }
        return null;
    }
    
    final Target getTargetMethod(final MethodNode methodNode) {
        if (!this.classNode.methods.contains(methodNode)) {
            throw new IllegalArgumentException(TargetClassContext.llllIIl[1]);
        }
        final String value = String.valueOf(new StringBuilder().append(methodNode.name).append(methodNode.desc));
        Target target;
        if ((target = this.targetMethods.get(value)) == null) {
            target = new Target(this.classNode, methodNode);
            this.targetMethods.put(value, target);
        }
        return target;
    }
    
    final String getUniqueName(final MethodNode methodNode, final boolean b) {
        return String.format(b ? TargetClassContext.llllIIl[2] : TargetClassContext.llllIIl[3], this.sessionId.substring(30), methodNode.name, Integer.toHexString(this.nextUniqueMethodIndex++));
    }
    
    private String getUniqueName(final FieldNode fieldNode) {
        return String.format(TargetClassContext.llllIIl[4], this.sessionId.substring(30), fieldNode.name, Integer.toHexString(this.nextUniqueFieldIndex++));
    }
    
    final void applyMixins() {
        if (this.applied) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append(TargetClassContext.llllIIl[5]).append(this.className)));
        }
        this.applied = true;
        (this.classInfo.isInterface ? new MixinApplicatorInterface(this) : new MixinApplicatorStandard(this)).apply(this.mixins);
        this.classNode.signature = this.signature.toString();
        this.upgradeMethods();
        this.checkMerges();
    }
    
    private MixinApplicatorStandard createApplicator() {
        if (this.classInfo.isInterface) {
            return new MixinApplicatorInterface(this);
        }
        return new MixinApplicatorStandard(this);
    }
    
    private void applySignature() {
        this.classNode.signature = this.signature.toString();
    }
    
    private void checkMerges() {
        final Iterator<MethodNode> iterator = this.mixinMethods.iterator();
        while (iterator.hasNext()) {
            final MethodNode methodNode;
            if (!(methodNode = iterator.next()).name.startsWith(TargetClassContext.llllIIl[6])) {
                TargetClassContext.logger.debug(TargetClassContext.llllIIl[7], new Object[] { methodNode.name, methodNode.desc, this });
            }
        }
    }
    
    final void processDebugTasks() {
        if (!this.env.getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
            return;
        }
        final AnnotationNode visible;
        if ((visible = Annotations.getVisible(this.classNode, Debug.class)) != null) {
            this.forceExport = Boolean.TRUE.equals(Annotations.getValue(visible, TargetClassContext.llllIIl[8]));
            if (Boolean.TRUE.equals(Annotations.getValue(visible, TargetClassContext.llllIIl[9]))) {
                Bytecode.textify(this.classNode, System.err);
            }
        }
        final Iterator<MethodNode> iterator = this.classNode.methods.iterator();
        while (iterator.hasNext()) {
            final MethodNode methodNode;
            final AnnotationNode visible2;
            if ((visible2 = Annotations.getVisible(methodNode = iterator.next(), Debug.class)) != null && Boolean.TRUE.equals(Annotations.getValue(visible2, TargetClassContext.llllIIl[10]))) {
                Bytecode.textify(methodNode, System.err);
            }
        }
    }
    
    static {
        lIlIIIllI();
        logger = LogManager.getLogger(TargetClassContext.llllIIl[11]);
    }
    
    private static void lIlIIIllI() {
        (llllIIl = new String[12])[0] = "Unexpected: Merged unregistered method {}{} in {}";
        TargetClassContext.llllIIl[1] = "Invalid target method supplied to getTargetMethod()";
        TargetClassContext.llllIIl[2] = "%2$s_$md$%1$s$%3$s";
        TargetClassContext.llllIIl[3] = "md%s$%s$%s";
        TargetClassContext.llllIIl[4] = "fd%s$%s$%s";
        TargetClassContext.llllIIl[5] = "Mixins already applied to target class ";
        TargetClassContext.llllIIl[6] = "<";
        TargetClassContext.llllIIl[7] = "Unexpected: Registered method {}{} in {} was not merged";
        TargetClassContext.llllIIl[8] = "export";
        TargetClassContext.llllIIl[9] = "print";
        TargetClassContext.llllIIl[10] = "print";
        TargetClassContext.llllIIl[11] = "mixin";
    }
    
    private static String lIlIIIIIl(final String s, final String s2) {
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
    
    private static String lIlIIIIII(String s, final String s2) {
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
    
    private static String lIIllllll(final String s, final String s2) {
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
