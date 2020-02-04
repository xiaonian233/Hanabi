package org.spongepowered.asm.mixin.transformer;

import com.google.common.collect.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.transformer.meta.*;
import org.spongepowered.asm.mixin.struct.*;
import org.spongepowered.asm.mixin.extensibility.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.mixin.transformer.throwables.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.mixin.transformer.ext.*;
import org.spongepowered.asm.mixin.refmap.*;
import org.spongepowered.asm.mixin.injection.throwables.*;
import org.apache.logging.log4j.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.lib.tree.*;

public final class MixinTargetContext extends ClassContext implements IMixinContext
{
    private static final Logger logger;
    public final MixinInfo mixin;
    final ClassNode classNode;
    public final TargetClassContext targetClass;
    private final String sessionId;
    final ClassInfo targetClassInfo;
    final BiMap<String, String> innerClasses;
    final List<MethodNode> shadowMethods;
    final Map<FieldNode, ClassInfo.Field> shadowFields;
    final List<MethodNode> mergedMethods;
    public final InjectorGroupInfo.Map injectorGroups;
    final List<InjectionInfo> injectors;
    private final List<AccessorInfo> accessors;
    final boolean inheritsFromMixin;
    private final boolean detachedSuper;
    private final SourceMap.File stratum;
    int minRequiredClassVersion;
    static final String[] llIIlIlllIl;
    
    MixinTargetContext(final MixinInfo mixin, final ClassNode classNode, final TargetClassContext targetClass) {
        super();
        this.innerClasses = (BiMap<String, String>)HashBiMap.create();
        this.shadowMethods = new ArrayList<MethodNode>();
        this.shadowFields = new LinkedHashMap<FieldNode, ClassInfo.Field>();
        this.mergedMethods = new ArrayList<MethodNode>();
        this.injectorGroups = new InjectorGroupInfo.Map();
        this.injectors = new ArrayList<InjectionInfo>();
        this.accessors = new ArrayList<AccessorInfo>();
        this.minRequiredClassVersion = MixinEnvironment.CompatibilityLevel.JAVA_6.classVersion;
        this.mixin = mixin;
        this.classNode = classNode;
        this.targetClass = targetClass;
        this.targetClassInfo = ClassInfo.forName(this.targetClass.getClassRef());
        this.stratum = targetClass.sourceMap.addFile(this.classNode);
        this.inheritsFromMixin = (mixin.info.hasMixinInHierarchy() || this.targetClassInfo.hasMixinTargetInHierarchy());
        this.detachedSuper = !this.classNode.superName.equals(this.targetClass.classNode.superName);
        this.sessionId = targetClass.sessionId;
        this.requireVersion(classNode.version);
        final InnerClassGenerator innerClassGenerator = targetClass.extensions.getGenerator(InnerClassGenerator.class);
        for (final String s : Collections.unmodifiableSet((Set<? extends String>)this.mixin.getState().innerClasses)) {
            final BiMap<String, String> innerClasses = this.innerClasses;
            final String s2 = s;
            final InnerClassGenerator innerClassGenerator2 = innerClassGenerator;
            final MixinInfo mixin2 = this.mixin;
            final String s3 = s;
            final MixinInfo mixinInfo = mixin2;
            final InnerClassGenerator innerClassGenerator3 = innerClassGenerator2;
            final String format = String.format(InnerClassGenerator.llIIIllll[0], s3, this);
            String format2;
            if ((format2 = innerClassGenerator3.innerClassNames.get(format)) == null) {
                final String s4 = s3;
                String substring;
                if ((substring = s4.substring(s4.lastIndexOf(36) + 1)).matches(InnerClassGenerator.llIIIllll[3])) {
                    substring = InnerClassGenerator.llIIIllll[4];
                }
                format2 = String.format(InnerClassGenerator.llIIIllll[5], this.targetClass.getClassRef(), substring, UUID.randomUUID().toString().replace(InnerClassGenerator.llIIIllll[6], InnerClassGenerator.llIIIllll[7]));
                innerClassGenerator3.innerClassNames.put(format, format2);
                innerClassGenerator3.innerClasses.put(format2, new InnerClassGenerator.InnerClassInfo(format2, s3, mixinInfo, this));
                InnerClassGenerator.logger.debug(InnerClassGenerator.llIIIllll[1], new Object[] { s3, mixinInfo.info.name, this.targetClass.getClassRef(), format2 });
            }
            innerClasses.put((Object)s2, (Object)format2);
        }
    }
    
    private void addShadowMethod(final MethodNode methodNode) {
        this.shadowMethods.add(methodNode);
    }
    
    private void addShadowField(final FieldNode fieldNode, final ClassInfo.Field field) {
        this.shadowFields.put(fieldNode, field);
    }
    
    final void addAccessorMethod(final MethodNode methodNode, final Class<? extends Annotation> clazz) {
        this.accessors.add(AccessorInfo.of(this, methodNode, clazz));
    }
    
    final void addMixinMethod(final MethodNode methodNode) {
        Annotations.setVisible(methodNode, MixinMerged.class, MixinTargetContext.llIIlIlllIl[0], this.mixin.className);
        this.targetClass.addMixinMethod(methodNode);
    }
    
    final void methodMerged(final MethodNode methodNode) {
        this.mergedMethods.add(methodNode);
        this.targetClassInfo.addMethod(methodNode, true);
        this.targetClass.methodMerged(methodNode);
        Annotations.setVisible(methodNode, MixinMerged.class, MixinTargetContext.llIIlIlllIl[1], this.mixin.className, MixinTargetContext.llIIlIlllIl[2], this.mixin.priority, MixinTargetContext.llIIlIlllIl[3], this.sessionId);
    }
    
    @Override
    public final String toString() {
        return this.mixin.toString();
    }
    
    public final MixinEnvironment getEnvironment() {
        return this.mixin.parent.env;
    }
    
    @Override
    public final boolean getOption(final MixinEnvironment.Option option) {
        return this.getEnvironment().getOption(option);
    }
    
    public final ClassNode getClassNode() {
        return this.classNode;
    }
    
    @Override
    public final String getClassName() {
        return this.mixin.className;
    }
    
    @Override
    public final String getClassRef() {
        return this.mixin.info.name;
    }
    
    private TargetClassContext getTarget() {
        return this.targetClass;
    }
    
    @Override
    public final String getTargetClassRef() {
        return this.targetClass.getClassRef();
    }
    
    private ClassNode getTargetClassNode() {
        return this.targetClass.classNode;
    }
    
    private ClassInfo getTargetClassInfo() {
        return this.targetClassInfo;
    }
    
    protected final ClassInfo getClassInfo() {
        return this.mixin.info;
    }
    
    public final ClassSignature getSignature() {
        return this.mixin.info.signature.wake();
    }
    
    private SourceMap.File getStratum() {
        return this.stratum;
    }
    
    private int getMinRequiredClassVersion() {
        return this.minRequiredClassVersion;
    }
    
    private static int getDefaultRequiredInjections() {
        return 0;
    }
    
    private String getDefaultInjectorGroup() {
        final String defaultGroup;
        if ((defaultGroup = this.mixin.parent.injectorOptions.defaultGroup) != null && !defaultGroup.isEmpty()) {
            return defaultGroup;
        }
        return MixinConfig.lIlIIIlIIl[23];
    }
    
    private static int getMaxShiftByValue() {
        return MixinConfig.getMaxShiftByValue();
    }
    
    private InjectorGroupInfo.Map getInjectorGroups() {
        return this.injectorGroups;
    }
    
    private static boolean requireOverwriteAnnotations() {
        return false;
    }
    
    private ClassInfo findRealType(final ClassInfo classInfo) {
        if (classInfo == this.mixin.info) {
            return this.targetClassInfo;
        }
        final ClassInfo correspondingType;
        if ((correspondingType = this.targetClassInfo.findCorrespondingType(classInfo)) == null) {
            throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[4]).append(classInfo).append(MixinTargetContext.llIIlIlllIl[5]).append(this.targetClassInfo)));
        }
        return correspondingType;
    }
    
    public final void transformMethod(final MethodNode methodNode) {
        final ClassInfo.Method methodInHierarchy;
        if (Annotations.getInvisible(methodNode, SoftOverride.class) != null && ((methodInHierarchy = this.targetClassInfo.findMethodInHierarchy(methodNode.name, methodNode.desc, ClassInfo.SearchType.SUPER_CLASSES_ONLY, ClassInfo.Traversal.SUPER)) == null || !methodInHierarchy.isInjected())) {
            throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[6]).append(methodNode.name).append(methodNode.desc).append(MixinTargetContext.llIIlIlllIl[7]).append(this.targetClass.className)));
        }
        this.transformDescriptor(methodNode);
        this.transformLVT(methodNode);
        this.stratum.applyOffset(methodNode);
        AbstractInsnNode abstractInsnNode = null;
        final ListIterator<AbstractInsnNode> iterator = methodNode.instructions.iterator();
        while (iterator.hasNext()) {
            final AbstractInsnNode abstractInsnNode2;
            if ((abstractInsnNode2 = iterator.next()) instanceof MethodInsnNode) {
                this.transformMethodRef$549c1f25(methodNode, new MemberRef.Method((MethodInsnNode)abstractInsnNode2));
            }
            else if (abstractInsnNode2 instanceof FieldInsnNode) {
                this.transformFieldRef(methodNode, iterator, new MemberRef.Field((FieldInsnNode)abstractInsnNode2));
                this.checkFinal$182f9ec3(methodNode, (FieldInsnNode)abstractInsnNode2);
            }
            else if (abstractInsnNode2 instanceof TypeInsnNode) {
                final ListIterator<AbstractInsnNode> listIterator = iterator;
                final TypeInsnNode typeInsnNode = (TypeInsnNode)abstractInsnNode2;
                final VarInsnNode varInsnNode = (VarInsnNode)abstractInsnNode;
                final TypeInsnNode typeInsnNode2 = typeInsnNode;
                final ListIterator<AbstractInsnNode> listIterator2 = listIterator;
                if (typeInsnNode2.getOpcode() == 192 && typeInsnNode2.desc.equals(this.targetClass.getClassRef()) && varInsnNode.getOpcode() == 25 && varInsnNode.var == 0) {
                    listIterator2.remove();
                }
                else {
                    if (typeInsnNode2.desc.equals(this.mixin.info.name)) {
                        typeInsnNode2.desc = this.targetClass.getClassRef();
                    }
                    else {
                        final String desc;
                        if ((desc = (String)this.innerClasses.get((Object)typeInsnNode2.desc)) != null) {
                            typeInsnNode2.desc = desc;
                        }
                    }
                    this.transformDescriptor(typeInsnNode2);
                }
            }
            else if (abstractInsnNode2 instanceof LdcInsnNode) {
                final ListIterator<AbstractInsnNode> listIterator3 = iterator;
                final LdcInsnNode ldcInsnNode = (LdcInsnNode)abstractInsnNode2;
                ldcInsnNode.cst = this.transformConstant(methodNode, listIterator3, ldcInsnNode.cst);
            }
            else if (abstractInsnNode2 instanceof InvokeDynamicInsnNode) {
                this.transformInvokeDynamicNode(methodNode, iterator, (InvokeDynamicInsnNode)abstractInsnNode2);
            }
            abstractInsnNode = abstractInsnNode2;
        }
    }
    
    private void validateMethod(final MethodNode methodNode) {
        final ClassInfo.Method methodInHierarchy;
        if (Annotations.getInvisible(methodNode, SoftOverride.class) != null && ((methodInHierarchy = this.targetClassInfo.findMethodInHierarchy(methodNode.name, methodNode.desc, ClassInfo.SearchType.SUPER_CLASSES_ONLY, ClassInfo.Traversal.SUPER)) == null || !methodInHierarchy.isInjected())) {
            throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[6]).append(methodNode.name).append(methodNode.desc).append(MixinTargetContext.llIIlIlllIl[7]).append(this.targetClass.className)));
        }
    }
    
    private void transformLVT(final MethodNode methodNode) {
        if (methodNode.localVariables == null) {
            return;
        }
        final Iterator<LocalVariableNode> iterator = methodNode.localVariables.iterator();
        while (iterator.hasNext()) {
            final LocalVariableNode localVariableNode;
            if ((localVariableNode = iterator.next()) != null && localVariableNode.desc != null) {
                localVariableNode.desc = this.transformSingleDescriptor(Type.getType(localVariableNode.desc));
            }
        }
    }
    
    private void transformMethodRef$549c1f25(final MethodNode methodNode, final MemberRef memberRef) {
        this.transformDescriptor(memberRef);
        if (memberRef.getOwner().equals(this.mixin.info.name)) {
            memberRef.setOwner(this.targetClass.getClassRef());
            final ClassInfo.Method method;
            if ((method = this.mixin.info.findMethod(memberRef.getName(), memberRef.getDesc(), 10)) != null && method.isRenamed() && method.getOriginalName().equals(memberRef.getName()) && method.isSynthetic()) {
                memberRef.setName(method.getName());
            }
            this.upgradeMethodRef$50845c34(memberRef, method);
            return;
        }
        if (this.innerClasses.containsKey((Object)memberRef.getOwner())) {
            memberRef.setOwner((String)this.innerClasses.get((Object)memberRef.getOwner()));
            memberRef.setDesc(this.transformMethodDescriptor(memberRef.getDesc()));
            return;
        }
        if (this.detachedSuper || this.inheritsFromMixin) {
            if (memberRef.getOpcode() == 183) {
                this.updateStaticBinding(methodNode, memberRef);
                return;
            }
            if (memberRef.getOpcode() == 182 && ClassInfo.forName(memberRef.getOwner()).isMixin) {
                this.updateDynamicBinding(methodNode, memberRef);
            }
        }
    }
    
    private void transformFieldRef(final MethodNode methodNode, final Iterator<AbstractInsnNode> iterator, final MemberRef memberRef) {
        if (MixinTargetContext.llIIlIlllIl[8].equals(memberRef.getName())) {
            if (!(memberRef instanceof MemberRef.Field)) {
                throw new InvalidMixinException(this.mixin, MixinTargetContext.llIIlIlllIl[9]);
            }
            this.processImaginarySuper(methodNode, ((MemberRef.Field)memberRef).insn);
            iterator.remove();
        }
        this.transformDescriptor(memberRef);
        if (memberRef.getOwner().equals(this.mixin.info.name)) {
            memberRef.setOwner(this.targetClass.getClassRef());
            final ClassInfo.Field field;
            if ((field = this.mixin.info.findField(memberRef.getName(), memberRef.getDesc(), 10)) != null && field.isRenamed() && field.getOriginalName().equals(memberRef.getName()) && field.isStatic()) {
                memberRef.setName(field.getName());
            }
            return;
        }
        final ClassInfo forName;
        if ((forName = ClassInfo.forName(memberRef.getOwner())).isMixin) {
            final ClassInfo correspondingType = this.targetClassInfo.findCorrespondingType(forName);
            memberRef.setOwner((correspondingType != null) ? correspondingType.name : this.targetClass.getClassRef());
        }
    }
    
    private void checkFinal$182f9ec3(final MethodNode methodNode, final FieldInsnNode fieldInsnNode) {
        if (!fieldInsnNode.owner.equals(this.targetClass.getClassRef())) {
            return;
        }
        final int opcode;
        if (!lIIIllIlllIll$255f299(opcode = fieldInsnNode.getOpcode()) || opcode == 178) {
            return;
        }
        final Iterator<Map.Entry<FieldNode, ClassInfo.Field>> iterator = this.shadowFields.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<FieldNode, ClassInfo.Field> entry;
            final FieldNode fieldNode;
            if ((fieldNode = (entry = iterator.next()).getKey()).desc.equals(fieldInsnNode.desc) && fieldNode.name.equals(fieldInsnNode.name)) {
                final ClassInfo.Field field;
                if ((field = entry.getValue()).isDecoratedFinal()) {
                    if (field.isDecoratedMutable()) {
                        if (this.mixin.parent.env.getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
                            MixinTargetContext.logger.warn(MixinTargetContext.llIIlIlllIl[10], new Object[] { field, this.mixin, methodNode.name });
                        }
                    }
                    else {
                        if (MixinTargetContext.llIIlIlllIl[11].equals(methodNode.name) || MixinTargetContext.llIIlIlllIl[12].equals(methodNode.name)) {
                            MixinTargetContext.logger.warn(MixinTargetContext.llIIlIlllIl[13], new Object[] { field, this.mixin });
                            return;
                        }
                        MixinTargetContext.logger.error(MixinTargetContext.llIIlIlllIl[14], new Object[] { field, this.mixin, methodNode.name });
                        if (this.mixin.parent.env.getOption(MixinEnvironment.Option.DEBUG_VERIFY)) {
                            throw new InvalidMixinException(this.mixin, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[15]).append(field).append(MixinTargetContext.llIIlIlllIl[16]).append(this.mixin).append(MixinTargetContext.llIIlIlllIl[17]).append(methodNode.name)));
                        }
                    }
                }
            }
        }
    }
    
    private void transformTypeNode$3e01d2ff(final Iterator<AbstractInsnNode> iterator, final TypeInsnNode typeInsnNode, final AbstractInsnNode abstractInsnNode) {
        if (typeInsnNode.getOpcode() == 192 && typeInsnNode.desc.equals(this.targetClass.getClassRef()) && abstractInsnNode.getOpcode() == 25 && ((VarInsnNode)abstractInsnNode).var == 0) {
            iterator.remove();
            return;
        }
        if (typeInsnNode.desc.equals(this.mixin.info.name)) {
            typeInsnNode.desc = this.targetClass.getClassRef();
        }
        else {
            final String desc;
            if ((desc = (String)this.innerClasses.get((Object)typeInsnNode.desc)) != null) {
                typeInsnNode.desc = desc;
            }
        }
        this.transformDescriptor(typeInsnNode);
    }
    
    private void transformConstantNode(final MethodNode methodNode, final Iterator<AbstractInsnNode> iterator, final LdcInsnNode ldcInsnNode) {
        ldcInsnNode.cst = this.transformConstant(methodNode, iterator, ldcInsnNode.cst);
    }
    
    private void transformInvokeDynamicNode(final MethodNode methodNode, final Iterator<AbstractInsnNode> iterator, final InvokeDynamicInsnNode invokeDynamicInsnNode) {
        this.requireVersion(51);
        invokeDynamicInsnNode.desc = this.transformMethodDescriptor(invokeDynamicInsnNode.desc);
        invokeDynamicInsnNode.bsm = this.transformHandle(methodNode, iterator, invokeDynamicInsnNode.bsm);
        for (int i = 0; i < invokeDynamicInsnNode.bsmArgs.length; ++i) {
            invokeDynamicInsnNode.bsmArgs[i] = this.transformConstant(methodNode, iterator, invokeDynamicInsnNode.bsmArgs[i]);
        }
    }
    
    private Object transformConstant(final MethodNode methodNode, final Iterator<AbstractInsnNode> iterator, final Object o) {
        if (o instanceof Type) {
            final Type type = (Type)o;
            final String transformDescriptor = this.transformDescriptor(type);
            if (!type.toString().equals(transformDescriptor)) {
                return Type.getType(transformDescriptor);
            }
            return o;
        }
        else {
            if (o instanceof Handle) {
                return this.transformHandle(methodNode, iterator, (Handle)o);
            }
            return o;
        }
    }
    
    private Handle transformHandle(final MethodNode methodNode, final Iterator<AbstractInsnNode> iterator, final Handle handle) {
        final MemberRef.Handle handle2;
        if ((handle2 = new MemberRef.Handle(handle)).isField()) {
            this.transformFieldRef(methodNode, iterator, handle2);
        }
        else {
            this.transformMethodRef$549c1f25(methodNode, handle2);
        }
        return handle2.handle;
    }
    
    private void processImaginarySuper(final MethodNode methodNode, final FieldInsnNode fieldInsnNode) {
        if (lIIIllIlllIll$255f299(fieldInsnNode.getOpcode())) {
            if (MixinTargetContext.llIIlIlllIl[18].equals(methodNode.name)) {
                throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[19]).append(fieldInsnNode.name).append(MixinTargetContext.llIIlIlllIl[20])));
            }
            throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[21]).append(Bytecode.getOpcodeName(fieldInsnNode.getOpcode())).append(MixinTargetContext.llIIlIlllIl[22]).append(methodNode.name).append(methodNode.desc)));
        }
        else {
            if ((methodNode.access & 0x2) != 0x0 || (methodNode.access & 0x8) != 0x0) {
                throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[23]).append(methodNode.name).append(methodNode.desc).append(MixinTargetContext.llIIlIlllIl[24])));
            }
            if (Annotations.getInvisible(methodNode, SoftOverride.class) == null) {
                throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[25]).append(methodNode.name).append(methodNode.desc).append(MixinTargetContext.llIIlIlllIl[26])));
            }
            final ListIterator<AbstractInsnNode> iterator = methodNode.instructions.iterator(methodNode.instructions.indexOf(fieldInsnNode));
            while (iterator.hasNext()) {
                final AbstractInsnNode abstractInsnNode;
                final MethodInsnNode methodInsnNode;
                if ((abstractInsnNode = iterator.next()) instanceof MethodInsnNode && (methodInsnNode = (MethodInsnNode)abstractInsnNode).owner.equals(this.mixin.info.name) && methodInsnNode.name.equals(methodNode.name) && methodInsnNode.desc.equals(methodNode.desc)) {
                    methodInsnNode.setOpcode(183);
                    this.updateStaticBinding(methodNode, new MemberRef.Method(methodInsnNode));
                    return;
                }
            }
            throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[27]).append(methodNode.name).append(methodNode.desc)));
        }
    }
    
    private void updateStaticBinding(final MethodNode methodNode, final MemberRef memberRef) {
        this.updateBinding(methodNode, memberRef, ClassInfo.Traversal.SUPER);
    }
    
    private void updateDynamicBinding(final MethodNode methodNode, final MemberRef memberRef) {
        this.updateBinding(methodNode, memberRef, ClassInfo.Traversal.ALL);
    }
    
    private void updateBinding(final MethodNode methodNode, final MemberRef memberRef, final ClassInfo.Traversal traversal) {
        if (MixinTargetContext.llIIlIlllIl[28].equals(methodNode.name) || memberRef.getOwner().equals(this.targetClass.getClassRef()) || this.targetClass.getClassRef().startsWith(MixinTargetContext.llIIlIlllIl[29])) {
            return;
        }
        final ClassInfo.Method methodInHierarchy;
        if ((methodInHierarchy = this.targetClassInfo.findMethodInHierarchy(memberRef.getName(), memberRef.getDesc(), traversal.searchType, traversal)) != null) {
            if (methodInHierarchy.getOwner().isMixin) {
                throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[30]).append(memberRef).append(MixinTargetContext.llIIlIlllIl[31]).append(this).append(MixinTargetContext.llIIlIlllIl[32]).append(methodInHierarchy.getOwner()).append(MixinTargetContext.llIIlIlllIl[33])));
            }
            memberRef.setOwner(methodInHierarchy.getImplementor().name);
        }
        else if (ClassInfo.forName(memberRef.getOwner()).isMixin) {
            throw new MixinTransformerError(String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[34]).append(memberRef).append(MixinTargetContext.llIIlIlllIl[35]).append(this)));
        }
    }
    
    private void transformDescriptor(final FieldNode fieldNode) {
        if (!this.inheritsFromMixin && this.innerClasses.size() == 0) {
            return;
        }
        fieldNode.desc = this.transformSingleDescriptor(fieldNode.desc, false);
    }
    
    public final void transformDescriptor(final MethodNode methodNode) {
        if (!this.inheritsFromMixin && this.innerClasses.size() == 0) {
            return;
        }
        methodNode.desc = this.transformMethodDescriptor(methodNode.desc);
    }
    
    private void transformDescriptor(final MemberRef memberRef) {
        if (!this.inheritsFromMixin && this.innerClasses.size() == 0) {
            return;
        }
        if (memberRef.isField()) {
            memberRef.setDesc(this.transformSingleDescriptor(memberRef.getDesc(), false));
            return;
        }
        memberRef.setDesc(this.transformMethodDescriptor(memberRef.getDesc()));
    }
    
    private void transformDescriptor(final TypeInsnNode typeInsnNode) {
        if (!this.inheritsFromMixin && this.innerClasses.size() == 0) {
            return;
        }
        typeInsnNode.desc = this.transformSingleDescriptor(typeInsnNode.desc, true);
    }
    
    private String transformDescriptor(final Type type) {
        if (type.sort == 11) {
            return this.transformMethodDescriptor(type.getDescriptor());
        }
        return this.transformSingleDescriptor(type);
    }
    
    private String transformSingleDescriptor(final Type type) {
        if (type.sort < 9) {
            return type.toString();
        }
        return this.transformSingleDescriptor(type.toString(), false);
    }
    
    final String transformSingleDescriptor(final String s, boolean b) {
        String s2 = s;
        while (s2.startsWith(MixinTargetContext.llIIlIlllIl[36]) || s2.startsWith(MixinTargetContext.llIIlIlllIl[37])) {
            if (s2.startsWith(MixinTargetContext.llIIlIlllIl[38])) {
                s2 = s2.substring(1);
            }
            else {
                s2 = s2.substring(1, s2.indexOf(MixinTargetContext.llIIlIlllIl[39]));
                b = true;
            }
        }
        if (!b) {
            return s;
        }
        final String s3;
        if ((s3 = (String)this.innerClasses.get((Object)s2)) != null) {
            return s.replace(s2, s3);
        }
        if (this.innerClasses.inverse().containsKey((Object)s2)) {
            return s;
        }
        final ClassInfo forName;
        if (!(forName = ClassInfo.forName(s2)).isMixin) {
            return s;
        }
        return s.replace(s2, this.findRealType(forName).toString());
    }
    
    private String transformMethodDescriptor(final String s) {
        final StringBuilder sb;
        (sb = new StringBuilder()).append('(');
        Type[] argumentTypes;
        for (int length = (argumentTypes = Type.getArgumentTypes(s)).length, i = 0; i < length; ++i) {
            sb.append(this.transformSingleDescriptor(argumentTypes[i]));
        }
        return String.valueOf(sb.append(')').append(this.transformSingleDescriptor(Type.getReturnType(s))));
    }
    
    @Override
    public final Target getTargetMethod(final MethodNode methodNode) {
        return this.targetClass.getTargetMethod(methodNode);
    }
    
    final MethodNode findMethod(final MethodNode methodNode, final AnnotationNode annotationNode) {
        final LinkedList<Object> list;
        (list = new LinkedList<Object>()).add(methodNode.name);
        final List<? extends String> list2;
        if (annotationNode != null && (list2 = Annotations.getValue(annotationNode, MixinTargetContext.llIIlIlllIl[40])) != null) {
            list.addAll(list2);
        }
        return this.targetClass.findMethod((Deque<String>)list, methodNode.desc);
    }
    
    final MethodNode findRemappedMethod(final MethodNode methodNode) {
        final String mapMethodName;
        if ((mapMethodName = this.getEnvironment().remappers.mapMethodName(this.targetClass.getClassRef(), methodNode.name, methodNode.desc)).equals(methodNode.name)) {
            return null;
        }
        final LinkedList<String> list;
        (list = new LinkedList<String>()).add(mapMethodName);
        return this.targetClass.findAliasedMethod(list, methodNode.desc);
    }
    
    private FieldNode findField(final FieldNode fieldNode, final AnnotationNode annotationNode) {
        final LinkedList<Object> list;
        (list = new LinkedList<Object>()).add(fieldNode.name);
        final List<? extends String> list2;
        if (annotationNode != null && (list2 = Annotations.getValue(annotationNode, MixinTargetContext.llIIlIlllIl[41])) != null) {
            list.addAll(list2);
        }
        return this.targetClass.findAliasedField((Deque<String>)list, fieldNode.desc);
    }
    
    private FieldNode findRemappedField(final FieldNode fieldNode) {
        final String mapFieldName;
        if ((mapFieldName = this.getEnvironment().remappers.mapFieldName(this.targetClass.getClassRef(), fieldNode.name, fieldNode.desc)).equals(fieldNode.name)) {
            return null;
        }
        final LinkedList<String> list;
        (list = new LinkedList<String>()).add(mapFieldName);
        return this.targetClass.findAliasedField(list, fieldNode.desc);
    }
    
    private void requireVersion(final int n) {
        this.minRequiredClassVersion = Math.max(this.minRequiredClassVersion, n);
        if (n > MixinEnvironment.getCompatibilityLevel().classVersion) {
            throw new InvalidMixinException(this, String.valueOf(new StringBuilder().append(MixinTargetContext.llIIlIlllIl[42]).append(n)));
        }
    }
    
    @Override
    public final Extensions getExtensions() {
        return this.targetClass.extensions;
    }
    
    @Override
    public final IMixinInfo getMixin() {
        return this.mixin;
    }
    
    private MixinInfo getInfo() {
        return this.mixin;
    }
    
    @Override
    public final int getPriority() {
        return this.mixin.priority;
    }
    
    private Set<String> getInterfaces() {
        return this.mixin.getState().getInterfaces();
    }
    
    private Collection<MethodNode> getShadowMethods() {
        return this.shadowMethods;
    }
    
    private List<MethodNode> getMethods() {
        return this.classNode.methods;
    }
    
    public final Set<Map.Entry<FieldNode, ClassInfo.Field>> getShadowFields() {
        return this.shadowFields.entrySet();
    }
    
    private List<FieldNode> getFields() {
        return this.classNode.fields;
    }
    
    private Level getLoggingLevel() {
        return this.mixin.parent.getLoggingLevel();
    }
    
    private static boolean shouldSetSourceFile() {
        return false;
    }
    
    private String getSourceFile() {
        return this.classNode.sourceFile;
    }
    
    @Override
    public final IReferenceMapper getReferenceMapper() {
        return this.mixin.parent.getReferenceMapper();
    }
    
    private static void preApply$5d5ead09() {
    }
    
    private void postApply$5d5ead09(final String s) {
        final InjectorGroupInfo.Map injectorGroups = this.injectorGroups;
        try {
            injectorGroups.validateAll();
            this.mixin.parent.unhandledTargets.remove(s);
        }
        catch (InjectionValidationException ex) {
            throw new InjectionError(String.format(MixinTargetContext.llIIlIlllIl[43], ex.group, this.mixin, ex.getMessage()));
        }
    }
    
    public final String getUniqueName(final MethodNode methodNode, final boolean b) {
        return this.targetClass.getUniqueName(methodNode, b);
    }
    
    private String getUniqueName(final FieldNode fieldNode) {
        final TargetClassContext targetClass;
        return String.format(TargetClassContext.llllIIl[4], targetClass.sessionId.substring(30), fieldNode.name, Integer.toHexString((targetClass = this.targetClass).nextUniqueFieldIndex++));
    }
    
    private void prepareInjections() {
        this.injectors.clear();
        for (final MethodNode methodNode : this.mergedMethods) {
            final InjectionInfo parse;
            if ((parse = InjectionInfo.parse(this, methodNode)) != null) {
                if (parse.isValid()) {
                    parse.prepare();
                    this.injectors.add(parse);
                }
                methodNode.visibleAnnotations.remove(parse.getAnnotation());
            }
        }
    }
    
    private void applyInjections() {
        final Iterator<InjectionInfo> iterator = this.injectors.iterator();
        while (iterator.hasNext()) {
            iterator.next().inject();
        }
        final Iterator<InjectionInfo> iterator2 = this.injectors.iterator();
        while (iterator2.hasNext()) {
            iterator2.next().postInject();
        }
        this.injectors.clear();
    }
    
    public final List<MethodNode> generateAccessors() {
        final Iterator<AccessorInfo> iterator = this.accessors.iterator();
        while (iterator.hasNext()) {
            iterator.next().locate();
        }
        final ArrayList<MethodNode> list = new ArrayList<MethodNode>();
        final Iterator<AccessorInfo> iterator2 = this.accessors.iterator();
        while (iterator2.hasNext()) {
            final MethodNode generate = iterator2.next().generate();
            this.targetClass.addMixinMethod(generate);
            list.add(generate);
        }
        return list;
    }
    
    static {
        lIIIllIIllIll();
        logger = LogManager.getLogger(MixinTargetContext.llIIlIlllIl[44]);
    }
    
    private static void lIIIllIIllIll() {
        (llIIlIlllIl = new String[45])[0] = "mixin";
        MixinTargetContext.llIIlIlllIl[1] = "mixin";
        MixinTargetContext.llIIlIlllIl[2] = "priority";
        MixinTargetContext.llIIlIlllIl[3] = "sessionId";
        MixinTargetContext.llIIlIlllIl[4] = "Resolution error: unable to find corresponding type for ";
        MixinTargetContext.llIIlIlllIl[5] = " in hierarchy of ";
        MixinTargetContext.llIIlIlllIl[6] = "Mixin method ";
        MixinTargetContext.llIIlIlllIl[7] = " is tagged with @SoftOverride but no valid method was found in superclasses of ";
        MixinTargetContext.llIIlIlllIl[8] = "super$";
        MixinTargetContext.llIIlIlllIl[9] = "Cannot call imaginary super from method handle.";
        MixinTargetContext.llIIlIlllIl[10] = "Write access to @Mutable @Final field {} in {}::{}";
        MixinTargetContext.llIIlIlllIl[11] = "<init>";
        MixinTargetContext.llIIlIlllIl[12] = "<clinit>";
        MixinTargetContext.llIIlIlllIl[13] = "@Final field {} in {} should be final";
        MixinTargetContext.llIIlIlllIl[14] = "Write access detected to @Final field {} in {}::{}";
        MixinTargetContext.llIIlIlllIl[15] = "Write access detected to @Final field ";
        MixinTargetContext.llIIlIlllIl[16] = " in ";
        MixinTargetContext.llIIlIlllIl[17] = "::";
        MixinTargetContext.llIIlIlllIl[18] = "<init>";
        MixinTargetContext.llIIlIlllIl[19] = "Illegal imaginary super declaration: field ";
        MixinTargetContext.llIIlIlllIl[20] = " must not specify an initialiser";
        MixinTargetContext.llIIlIlllIl[21] = "Illegal imaginary super access: found ";
        MixinTargetContext.llIIlIlllIl[22] = " opcode in ";
        MixinTargetContext.llIIlIlllIl[23] = "Illegal imaginary super access: method ";
        MixinTargetContext.llIIlIlllIl[24] = " is private or static";
        MixinTargetContext.llIIlIlllIl[25] = "Illegal imaginary super access: method ";
        MixinTargetContext.llIIlIlllIl[26] = " is not decorated with @SoftOverride";
        MixinTargetContext.llIIlIlllIl[27] = "Illegal imaginary super access: could not find INVOKE for ";
        MixinTargetContext.llIIlIlllIl[28] = "<init>";
        MixinTargetContext.llIIlIlllIl[29] = "<";
        MixinTargetContext.llIIlIlllIl[30] = "Invalid ";
        MixinTargetContext.llIIlIlllIl[31] = " in ";
        MixinTargetContext.llIIlIlllIl[32] = " resolved ";
        MixinTargetContext.llIIlIlllIl[33] = " but is mixin.";
        MixinTargetContext.llIIlIlllIl[34] = "Error resolving ";
        MixinTargetContext.llIIlIlllIl[35] = " in ";
        MixinTargetContext.llIIlIlllIl[36] = "[";
        MixinTargetContext.llIIlIlllIl[37] = "L";
        MixinTargetContext.llIIlIlllIl[38] = "[";
        MixinTargetContext.llIIlIlllIl[39] = ";";
        MixinTargetContext.llIIlIlllIl[40] = "aliases";
        MixinTargetContext.llIIlIlllIl[41] = "aliases";
        MixinTargetContext.llIIlIlllIl[42] = "Unsupported mixin class version ";
        MixinTargetContext.llIIlIlllIl[43] = "Critical injection failure: Callback group %s in %s failed injection check: %s";
        MixinTargetContext.llIIlIlllIl[44] = "mixin";
    }
    
    private static String lIIIllIIlIlII(String s, final String s2) {
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
    
    private static String lIIIllIIlIIll(final String s, final String s2) {
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
    
    private static String lIIIllIIlIlIl(final String s, final String s2) {
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
    
    private static boolean lIIIllIllllIl(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIIllIllIlll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIIllIlllIll$255f299(final int n) {
        return n != 180;
    }
}
