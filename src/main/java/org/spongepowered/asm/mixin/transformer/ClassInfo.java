package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.util.perf.*;
import com.google.common.collect.*;
import org.spongepowered.asm.service.*;
import org.spongepowered.asm.lib.*;
import org.apache.logging.log4j.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import org.spongepowered.asm.util.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;
import org.spongepowered.asm.mixin.*;

public final class ClassInfo
{
    private static int INCLUDE_PRIVATE;
    private static int INCLUDE_STATIC;
    private static int INCLUDE_ALL;
    private static final Logger logger;
    private static final Profiler profiler;
    private static final String JAVA_LANG_OBJECT;
    private static final Map<String, ClassInfo> cache;
    private static final ClassInfo OBJECT;
    public final String name;
    public final String superName;
    private final String outerName;
    final boolean isProbablyStatic;
    final Set<String> interfaces;
    final Set<Method> methods;
    private final Set<Field> fields;
    final Set<MixinInfo> mixins;
    private final Map<ClassInfo, ClassInfo> correspondingTypes;
    private final MixinInfo mixin;
    private MethodMapper methodMapper;
    final boolean isMixin;
    public final boolean isInterface;
    public final int access;
    private ClassInfo superClass;
    private ClassInfo outerClass;
    ClassSignature signature;
    static final String[] llIlIIIlllI;
    
    private ClassInfo() {
        super();
        this.mixins = new HashSet<MixinInfo>();
        this.correspondingTypes = new HashMap<ClassInfo, ClassInfo>();
        this.name = ClassInfo.llIlIIIlllI[0];
        this.superName = null;
        this.outerName = null;
        this.isProbablyStatic = true;
        this.methods = (Set<Method>)ImmutableSet.of((Object)new Method(ClassInfo.llIlIIIlllI[1], ClassInfo.llIlIIIlllI[2]), (Object)new Method(ClassInfo.llIlIIIlllI[3], ClassInfo.llIlIIIlllI[4]), (Object)new Method(ClassInfo.llIlIIIlllI[5], ClassInfo.llIlIIIlllI[6]), (Object)new Method(ClassInfo.llIlIIIlllI[7], ClassInfo.llIlIIIlllI[8]), (Object)new Method(ClassInfo.llIlIIIlllI[9], ClassInfo.llIlIIIlllI[10]), (Object)new Method(ClassInfo.llIlIIIlllI[11], ClassInfo.llIlIIIlllI[12]), (Object[])new Method[] { new Method(ClassInfo.llIlIIIlllI[13], ClassInfo.llIlIIIlllI[14]), new Method(ClassInfo.llIlIIIlllI[15], ClassInfo.llIlIIIlllI[16]), new Method(ClassInfo.llIlIIIlllI[17], ClassInfo.llIlIIIlllI[18]), new Method(ClassInfo.llIlIIIlllI[19], ClassInfo.llIlIIIlllI[20]), new Method(ClassInfo.llIlIIIlllI[21], ClassInfo.llIlIIIlllI[22]) });
        this.fields = Collections.emptySet();
        this.isInterface = false;
        this.interfaces = Collections.emptySet();
        this.access = 1;
        this.isMixin = false;
        this.mixin = null;
        this.methodMapper = null;
    }
    
    private ClassInfo(final ClassNode classNode) {
        super();
        this.mixins = new HashSet<MixinInfo>();
        this.correspondingTypes = new HashMap<ClassInfo, ClassInfo>();
        final Profiler.Section begin = ClassInfo.profiler.begin(1, ClassInfo.llIlIIIlllI[23]);
        try {
            this.name = classNode.name;
            this.superName = ((classNode.superName != null) ? classNode.superName : ClassInfo.llIlIIIlllI[24]);
            this.methods = new HashSet<Method>();
            this.fields = new HashSet<Field>();
            this.isInterface = ((classNode.access & 0x200) != 0x0);
            this.interfaces = new HashSet<String>();
            this.access = classNode.access;
            this.isMixin = (classNode instanceof MixinInfo.MixinClassNode);
            this.mixin = (this.isMixin ? ((MixinInfo.MixinClassNode)classNode).this$0 : null);
            this.interfaces.addAll(classNode.interfaces);
            final Iterator<MethodNode> iterator = classNode.methods.iterator();
            while (iterator.hasNext()) {
                this.addMethod(iterator.next(), this.isMixin);
            }
            boolean isProbablyStatic = true;
            String outerName = classNode.outerClass;
            final Iterator<FieldNode> iterator2 = classNode.fields.iterator();
            while (iterator2.hasNext()) {
                final FieldNode fieldNode;
                if (((fieldNode = iterator2.next()).access & 0x1000) != 0x0 && fieldNode.name.startsWith(ClassInfo.llIlIIIlllI[25])) {
                    isProbablyStatic = false;
                    if (outerName == null && (outerName = fieldNode.desc) != null && outerName.startsWith(ClassInfo.llIlIIIlllI[26])) {
                        outerName = outerName.substring(1, outerName.length() - 1);
                    }
                }
                this.fields.add(new Field(fieldNode, this.isMixin));
            }
            this.isProbablyStatic = isProbablyStatic;
            this.outerName = outerName;
            MixinEnvironment.getCurrentEnvironment();
            this.methodMapper = new MethodMapper(this);
            this.signature = ClassSignature.ofLazy(classNode);
        }
        finally {
            begin.end();
        }
    }
    
    final void addInterface(final String s) {
        this.interfaces.add(s);
        this.signature.wake().rawInterfaces.add(s);
    }
    
    private void addMethod(final MethodNode methodNode) {
        this.addMethod(methodNode, true);
    }
    
    final void addMethod(final MethodNode methodNode, final boolean b) {
        if (!methodNode.name.startsWith(ClassInfo.llIlIIIlllI[27])) {
            this.methods.add(new Method(methodNode, b));
        }
    }
    
    private void addMixin(final MixinInfo mixinInfo) {
        if (this.isMixin) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(ClassInfo.llIlIIIlllI[28]).append(this.name).append(ClassInfo.llIlIIIlllI[29]).append(mixinInfo.className).append(ClassInfo.llIlIIIlllI[30])));
        }
        this.mixins.add(mixinInfo);
    }
    
    private Set<MixinInfo> getMixins() {
        return Collections.unmodifiableSet((Set<? extends MixinInfo>)this.mixins);
    }
    
    private boolean isMixin() {
        return this.isMixin;
    }
    
    public final boolean isPublic() {
        return (this.access & 0x1) != 0x0;
    }
    
    private boolean isAbstract() {
        return (this.access & 0x400) != 0x0;
    }
    
    private boolean isSynthetic() {
        return (this.access & 0x1000) != 0x0;
    }
    
    private boolean isProbablyStatic() {
        return this.isProbablyStatic;
    }
    
    private boolean isInner() {
        return this.outerName != null;
    }
    
    private boolean isInterface() {
        return this.isInterface;
    }
    
    private Set<String> getInterfaces() {
        return Collections.unmodifiableSet((Set<? extends String>)this.interfaces);
    }
    
    @Override
    public final String toString() {
        return this.name;
    }
    
    private MethodMapper getMethodMapper() {
        return this.methodMapper;
    }
    
    private int getAccess() {
        return this.access;
    }
    
    private String getName() {
        return this.name;
    }
    
    public final String getClassName() {
        return this.name.replace('/', '.');
    }
    
    private String getSuperName() {
        return this.superName;
    }
    
    public final ClassInfo getSuperClass() {
        if (this.superClass == null && this.superName != null) {
            this.superClass = forName(this.superName);
        }
        return this.superClass;
    }
    
    private String getOuterName() {
        return this.outerName;
    }
    
    private ClassInfo getOuterClass() {
        if (this.outerClass == null && this.outerName != null) {
            this.outerClass = forName(this.outerName);
        }
        return this.outerClass;
    }
    
    private ClassSignature getSignature() {
        return this.signature.wake();
    }
    
    final List<ClassInfo> getTargets() {
        if (this.mixin != null) {
            final ArrayList<Object> list;
            (list = (ArrayList<Object>)new ArrayList<ClassInfo>()).add(this);
            list.addAll(Collections.unmodifiableList((List<?>)this.mixin.targetClasses));
            return (List<ClassInfo>)list;
        }
        return (List<ClassInfo>)ImmutableList.of((Object)this);
    }
    
    private Set<Method> getMethods() {
        return Collections.unmodifiableSet((Set<? extends Method>)this.methods);
    }
    
    public final Set<Method> getInterfaceMethods(final boolean b) {
        final HashSet<Method> set = new HashSet<Method>();
        ClassInfo classInfo = this.addMethodsRecursive(set, b);
        if (!this.isInterface) {
            while (classInfo != null && lIIlIIllIllIl(classInfo, ClassInfo.OBJECT)) {
                classInfo = classInfo.addMethodsRecursive(set, b);
            }
        }
        final Iterator<Object> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (!iterator.next().isAbstract()) {
                iterator.remove();
            }
        }
        return (Set<Method>)Collections.unmodifiableSet((Set<?>)set);
    }
    
    private ClassInfo addMethodsRecursive(final Set<Method> set, final boolean b) {
        if (this.isInterface) {
            final Iterator<Method> iterator = this.methods.iterator();
            while (iterator.hasNext()) {
                final Method method;
                if (!(method = iterator.next()).isAbstract()) {
                    set.remove(method);
                }
                set.add(method);
            }
        }
        else if (!this.isMixin && b) {
            final Iterator<MixinInfo> iterator2 = this.mixins.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().info.addMethodsRecursive(set, b);
            }
        }
        final Iterator<String> iterator3 = this.interfaces.iterator();
        while (iterator3.hasNext()) {
            forName(iterator3.next()).addMethodsRecursive(set, b);
        }
        return this.getSuperClass();
    }
    
    private boolean hasSuperClass(final String s) {
        return this.hasSuperClass(s, Traversal.NONE);
    }
    
    public final boolean hasSuperClass(final String s, final Traversal traversal) {
        return ClassInfo.llIlIIIlllI[31].equals(s) || this.findSuperClass(s, traversal) != null;
    }
    
    public final boolean hasSuperClass(final ClassInfo classInfo) {
        return this.hasSuperClass(classInfo, Traversal.NONE, false);
    }
    
    private boolean hasSuperClass(final ClassInfo classInfo, final Traversal traversal) {
        return this.hasSuperClass(classInfo, traversal, false);
    }
    
    private boolean hasSuperClass(final ClassInfo classInfo, final Traversal traversal, final boolean b) {
        return lIIlIIlllIIII(ClassInfo.OBJECT, classInfo) || this.findSuperClass(classInfo.name, traversal, b) != null;
    }
    
    private ClassInfo findSuperClass(final String s) {
        return this.findSuperClass(s, Traversal.NONE);
    }
    
    private ClassInfo findSuperClass(final String s, final Traversal traversal) {
        return this.findSuperClass(s, traversal, false, new HashSet<String>());
    }
    
    private ClassInfo findSuperClass(final String s, final Traversal traversal, final boolean b) {
        if (ClassInfo.OBJECT.name.equals(s)) {
            return null;
        }
        return this.findSuperClass(s, traversal, b, new HashSet<String>());
    }
    
    private ClassInfo findSuperClass(final String s, final Traversal traversal, final boolean b, final Set<String> set) {
        final ClassInfo superClass;
        if ((superClass = this.getSuperClass()) != null) {
            for (final ClassInfo classInfo : superClass.getTargets()) {
                if (s.equals(classInfo.name)) {
                    return superClass;
                }
                final ClassInfo superClass2;
                if ((superClass2 = classInfo.findSuperClass(s, traversal.next, b, set)) != null) {
                    return superClass2;
                }
            }
        }
        final ClassInfo interface1;
        if (b && (interface1 = this.findInterface(s)) != null) {
            return interface1;
        }
        if (traversal.traverse) {
            final Iterator<MixinInfo> iterator2 = this.mixins.iterator();
            while (iterator2.hasNext()) {
                final MixinInfo mixinInfo;
                final String className = (mixinInfo = iterator2.next()).className;
                if (!set.contains(className)) {
                    set.add(className);
                    final ClassInfo info = mixinInfo.info;
                    if (s.equals(info.name)) {
                        return info;
                    }
                    final ClassInfo superClass3;
                    if ((superClass3 = info.findSuperClass(s, Traversal.ALL, b, set)) != null) {
                        return superClass3;
                    }
                    continue;
                }
            }
        }
        return null;
    }
    
    private ClassInfo findInterface(final String s) {
        final Iterator<String> iterator = Collections.unmodifiableSet((Set<? extends String>)this.interfaces).iterator();
        while (iterator.hasNext()) {
            final String s2;
            final ClassInfo forName = forName(s2 = iterator.next());
            if (s.equals(s2)) {
                return forName;
            }
            final ClassInfo interface1;
            if ((interface1 = forName.findInterface(s)) != null) {
                return interface1;
            }
        }
        return null;
    }
    
    final ClassInfo findCorrespondingType(final ClassInfo classInfo) {
        if (classInfo == null || !classInfo.isMixin || this.isMixin) {
            return null;
        }
        ClassInfo classInfo2;
        if ((classInfo2 = this.correspondingTypes.get(classInfo)) == null) {
            ClassInfo superClass = this;
        Label_0113:
            while (true) {
                while (superClass != null && lIIlIIllIllIl(superClass, ClassInfo.OBJECT)) {
                    final Iterator<MixinInfo> iterator = superClass.mixins.iterator();
                    while (iterator.hasNext()) {
                        if (iterator.next().info.equals(classInfo)) {
                            final ClassInfo classInfo3 = superClass;
                            break Label_0113;
                        }
                    }
                    superClass = superClass.getSuperClass();
                    continue;
                    ClassInfo classInfo3 = null;
                    classInfo2 = classInfo3;
                    this.correspondingTypes.put(classInfo, classInfo2);
                    return classInfo2;
                }
                final ClassInfo classInfo3 = null;
                continue Label_0113;
            }
        }
        return classInfo2;
    }
    
    private ClassInfo findSuperTypeForMixin(final ClassInfo classInfo) {
        for (ClassInfo superClass = this; superClass != null && lIIlIIllIllIl(superClass, ClassInfo.OBJECT); superClass = superClass.getSuperClass()) {
            final Iterator<MixinInfo> iterator = superClass.mixins.iterator();
            while (iterator.hasNext()) {
                if (iterator.next().info.equals(classInfo)) {
                    return superClass;
                }
            }
        }
        return null;
    }
    
    public final boolean hasMixinInHierarchy() {
        if (!this.isMixin) {
            return false;
        }
        for (ClassInfo classInfo = this.getSuperClass(); classInfo != null && lIIlIIllIllIl(classInfo, ClassInfo.OBJECT); classInfo = classInfo.getSuperClass()) {
            if (classInfo.isMixin) {
                return true;
            }
        }
        return false;
    }
    
    public final boolean hasMixinTargetInHierarchy() {
        if (this.isMixin) {
            return false;
        }
        for (ClassInfo classInfo = this.getSuperClass(); classInfo != null && lIIlIIllIllIl(classInfo, ClassInfo.OBJECT); classInfo = classInfo.getSuperClass()) {
            if (classInfo.mixins.size() > 0) {
                return true;
            }
        }
        return false;
    }
    
    public final Method findMethodInHierarchy(final MethodNode methodNode, final SearchType searchType) {
        return this.findMethodInHierarchy(methodNode.name, methodNode.desc, searchType, Traversal.NONE);
    }
    
    private Method findMethodInHierarchy(final MethodNode methodNode, final SearchType searchType, final int n) {
        return this.findMethodInHierarchy(methodNode.name, methodNode.desc, searchType, Traversal.NONE, n);
    }
    
    private Method findMethodInHierarchy(final MethodInsnNode methodInsnNode, final SearchType searchType) {
        return this.findMethodInHierarchy(methodInsnNode.name, methodInsnNode.desc, searchType, Traversal.NONE);
    }
    
    public final Method findMethodInHierarchy$6b294a8(final MethodInsnNode methodInsnNode, final SearchType searchType) {
        return this.findMethodInHierarchy(methodInsnNode.name, methodInsnNode.desc, searchType, Traversal.NONE, 2);
    }
    
    private Method findMethodInHierarchy(final String s, final String s2, final SearchType searchType) {
        return this.findMethodInHierarchy(s, s2, searchType, Traversal.NONE);
    }
    
    public final Method findMethodInHierarchy(final String s, final String s2, final SearchType searchType, final Traversal traversal) {
        return this.findMethodInHierarchy(s, s2, searchType, traversal, 0);
    }
    
    private Method findMethodInHierarchy(final String s, final String s2, final SearchType searchType, final Traversal traversal, final int n) {
        return this.findInHierarchy(s, s2, searchType, traversal, n, Member.Type.METHOD);
    }
    
    private Field findFieldInHierarchy(final FieldNode fieldNode, final SearchType searchType) {
        return this.findFieldInHierarchy(fieldNode.name, fieldNode.desc, searchType, Traversal.NONE);
    }
    
    private Field findFieldInHierarchy(final FieldNode fieldNode, final SearchType searchType, final int n) {
        return this.findFieldInHierarchy(fieldNode.name, fieldNode.desc, searchType, Traversal.NONE, n);
    }
    
    private Field findFieldInHierarchy(final FieldInsnNode fieldInsnNode, final SearchType searchType) {
        return this.findFieldInHierarchy(fieldInsnNode.name, fieldInsnNode.desc, searchType, Traversal.NONE);
    }
    
    private Field findFieldInHierarchy(final FieldInsnNode fieldInsnNode, final SearchType searchType, final int n) {
        return this.findFieldInHierarchy(fieldInsnNode.name, fieldInsnNode.desc, searchType, Traversal.NONE, n);
    }
    
    private Field findFieldInHierarchy(final String s, final String s2, final SearchType searchType) {
        return this.findFieldInHierarchy(s, s2, searchType, Traversal.NONE);
    }
    
    private Field findFieldInHierarchy(final String s, final String s2, final SearchType searchType, final Traversal traversal) {
        return this.findFieldInHierarchy(s, s2, searchType, traversal, 0);
    }
    
    private Field findFieldInHierarchy(final String s, final String s2, final SearchType searchType, final Traversal traversal, final int n) {
        return this.findInHierarchy(s, s2, searchType, traversal, n, Member.Type.FIELD);
    }
    
    private <M extends Member> M findInHierarchy(final String s, final String s2, final SearchType searchType, final Traversal traversal, final int n, final Member.Type type) {
        if (lIIlIIlllIIII(searchType, SearchType.ALL_CLASSES)) {
            final Member member;
            if ((member = this.findMember(s, s2, n, type)) != null) {
                return (M)member;
            }
            if (traversal.traverse) {
                final Iterator<MixinInfo> iterator = this.mixins.iterator();
                while (iterator.hasNext()) {
                    final Member member2;
                    if ((member2 = iterator.next().info.findMember(s, s2, n, type)) != null) {
                        return this.cloneMember(member2);
                    }
                }
            }
        }
        final ClassInfo superClass;
        if ((superClass = this.getSuperClass()) != null) {
            final Iterator<ClassInfo> iterator2 = superClass.getTargets().iterator();
            while (iterator2.hasNext()) {
                final Member inHierarchy;
                if ((inHierarchy = iterator2.next().findInHierarchy(s, s2, SearchType.ALL_CLASSES, traversal.next, n & 0xFFFFFFFD, type)) != null) {
                    return (M)inHierarchy;
                }
            }
        }
        if (lIIlIIlllIIII(type, Member.Type.METHOD) && (this.isInterface || MixinEnvironment.getCompatibilityLevel().supportsMethodsInInterfaces)) {
            final Iterator<String> iterator3 = this.interfaces.iterator();
            while (iterator3.hasNext()) {
                final String s3;
                final ClassInfo forName;
                if ((forName = forName(s3 = iterator3.next())) == null) {
                    ClassInfo.logger.debug(ClassInfo.llIlIIIlllI[32], new Object[] { s3, this.name });
                }
                else {
                    final Member inHierarchy2;
                    if ((inHierarchy2 = forName.findInHierarchy(s, s2, SearchType.ALL_CLASSES, traversal.next, n & 0xFFFFFFFD, type)) == null) {
                        continue;
                    }
                    if (this.isInterface) {
                        return (M)inHierarchy2;
                    }
                    return (M)new InterfaceMethod(inHierarchy2);
                }
            }
        }
        return null;
    }
    
    private <M extends Member> M cloneMember(final M m) {
        if (m instanceof Method) {
            return (M)new Method(m);
        }
        return (M)new Field(m);
    }
    
    public final Method findMethod(final MethodNode methodNode) {
        return this.findMethod(methodNode.name, methodNode.desc, methodNode.access);
    }
    
    public final Method findMethod$680e33ff(final MethodNode methodNode) {
        return this.findMethod(methodNode.name, methodNode.desc, 10);
    }
    
    private Method findMethod(final MethodInsnNode methodInsnNode) {
        return this.findMethod(methodInsnNode.name, methodInsnNode.desc, 0);
    }
    
    private Method findMethod(final MethodInsnNode methodInsnNode, final int n) {
        return this.findMethod(methodInsnNode.name, methodInsnNode.desc, n);
    }
    
    public final Method findMethod(final String s, final String s2, final int n) {
        return this.findMember(s, s2, n, Member.Type.METHOD);
    }
    
    private Field findField(final FieldNode fieldNode) {
        return this.findField(fieldNode.name, fieldNode.desc, fieldNode.access);
    }
    
    public final Field findField$5ef7dbb5(final FieldInsnNode fieldInsnNode) {
        return this.findField(fieldInsnNode.name, fieldInsnNode.desc, 2);
    }
    
    public final Field findField(final String s, final String s2, final int n) {
        return this.findMember(s, s2, n, Member.Type.FIELD);
    }
    
    private <M extends Member> M findMember(final String s, final String s2, final int n, final Member.Type type) {
        final Iterator<M> iterator = ((Set<M>)(lIIlIIlllIIII(type, Member.Type.METHOD) ? this.methods : this.fields)).iterator();
        while (iterator.hasNext()) {
            final Member member;
            if ((member = iterator.next()).equals(s, s2) && member.matchesFlags(n)) {
                return (M)member;
            }
        }
        return null;
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof ClassInfo && ((ClassInfo)o).name.equals(this.name);
    }
    
    @Override
    public final int hashCode() {
        return this.name.hashCode();
    }
    
    static ClassInfo fromClassNode(final ClassNode classNode) {
        ClassInfo classInfo;
        if ((classInfo = ClassInfo.cache.get(classNode.name)) == null) {
            classInfo = new ClassInfo(classNode);
            ClassInfo.cache.put(classNode.name, classInfo);
        }
        return classInfo;
    }
    
    public static ClassInfo forName(String replace) {
        replace = replace.replace('.', '/');
        ClassInfo classInfo;
        if ((classInfo = ClassInfo.cache.get(replace)) == null) {
            try {
                classInfo = new ClassInfo(MixinService.getService().getBytecodeProvider().getClassNode(replace));
            }
            catch (Exception ex) {
                ClassInfo.logger.catching(Level.TRACE, (Throwable)ex);
                ClassInfo.logger.warn(ClassInfo.llIlIIIlllI[33], new Object[] { replace, ex.getClass().getName(), ex.getMessage() });
            }
            ClassInfo.cache.put(replace, classInfo);
            ClassInfo.logger.trace(ClassInfo.llIlIIIlllI[34], new Object[] { replace });
        }
        return classInfo;
    }
    
    public static ClassInfo forType(Type elementType) {
        while (elementType.sort == 9) {
            elementType = elementType.getElementType();
        }
        if (elementType.sort < 9) {
            return null;
        }
        return forName(elementType.getClassName().replace('.', '/'));
    }
    
    public static ClassInfo getCommonSuperClass(final String s, final String s2) {
        if (s == null || s2 == null) {
            return ClassInfo.OBJECT;
        }
        return getCommonSuperClass(forName(s), forName(s2), false);
    }
    
    private static ClassInfo getCommonSuperClass(final Type type, final Type type2) {
        if (type == null || type2 == null || type.sort != 10 || lIIlIIlllIlII$255f299(type2.sort)) {
            return ClassInfo.OBJECT;
        }
        return getCommonSuperClass(forType(type), forType(type2), false);
    }
    
    private static ClassInfo getCommonSuperClass(final ClassInfo classInfo, final ClassInfo classInfo2) {
        return getCommonSuperClass(classInfo, classInfo2, false);
    }
    
    private static ClassInfo getCommonSuperClassOrInterface(final String s, final String s2) {
        if (s == null || s2 == null) {
            return ClassInfo.OBJECT;
        }
        return getCommonSuperClass(forName(s), forName(s2), true);
    }
    
    public static ClassInfo getCommonSuperClassOrInterface(final Type type, final Type type2) {
        if (type == null || type2 == null || type.sort != 10 || lIIlIIlllIlII$255f299(type2.sort)) {
            return ClassInfo.OBJECT;
        }
        return getCommonSuperClass(forType(type), forType(type2), true);
    }
    
    private static ClassInfo getCommonSuperClassOrInterface(final ClassInfo classInfo, final ClassInfo classInfo2) {
        return getCommonSuperClass(classInfo, classInfo2, true);
    }
    
    private static ClassInfo getCommonSuperClass(ClassInfo superClass, final ClassInfo classInfo, final boolean b) {
        if (superClass.hasSuperClass(classInfo, Traversal.NONE, b)) {
            return classInfo;
        }
        if (classInfo.hasSuperClass(superClass, Traversal.NONE, b)) {
            return superClass;
        }
        if (superClass.isInterface || classInfo.isInterface) {
            return ClassInfo.OBJECT;
        }
        while ((superClass = superClass.getSuperClass()) != null) {
            if (classInfo.hasSuperClass(superClass, Traversal.NONE, b)) {
                return superClass;
            }
        }
        return ClassInfo.OBJECT;
    }
    
    static {
        lIIlIIlIIIlII();
        logger = LogManager.getLogger(ClassInfo.llIlIIIlllI[36]);
        profiler = MixinEnvironment.getProfiler();
        cache = new HashMap<String, ClassInfo>();
        OBJECT = new ClassInfo();
        ClassInfo.cache.put(ClassInfo.llIlIIIlllI[37], ClassInfo.OBJECT);
    }
    
    private static void lIIlIIlIIIlII() {
        (llIlIIIlllI = new String[38])[0] = "java/lang/Object";
        ClassInfo.llIlIIIlllI[1] = "getClass";
        ClassInfo.llIlIIIlllI[2] = "()Ljava/lang/Class;";
        ClassInfo.llIlIIIlllI[3] = "hashCode";
        ClassInfo.llIlIIIlllI[4] = "()I";
        ClassInfo.llIlIIIlllI[5] = "equals";
        ClassInfo.llIlIIIlllI[6] = "(Ljava/lang/Object;)Z";
        ClassInfo.llIlIIIlllI[7] = "clone";
        ClassInfo.llIlIIIlllI[8] = "()Ljava/lang/Object;";
        ClassInfo.llIlIIIlllI[9] = "toString";
        ClassInfo.llIlIIIlllI[10] = "()Ljava/lang/String;";
        ClassInfo.llIlIIIlllI[11] = "notify";
        ClassInfo.llIlIIIlllI[12] = "()V";
        ClassInfo.llIlIIIlllI[13] = "notifyAll";
        ClassInfo.llIlIIIlllI[14] = "()V";
        ClassInfo.llIlIIIlllI[15] = "wait";
        ClassInfo.llIlIIIlllI[16] = "(J)V";
        ClassInfo.llIlIIIlllI[17] = "wait";
        ClassInfo.llIlIIIlllI[18] = "(JI)V";
        ClassInfo.llIlIIIlllI[19] = "wait";
        ClassInfo.llIlIIIlllI[20] = "()V";
        ClassInfo.llIlIIIlllI[21] = "finalize";
        ClassInfo.llIlIIIlllI[22] = "()V";
        ClassInfo.llIlIIIlllI[23] = "class.meta";
        ClassInfo.llIlIIIlllI[24] = "java/lang/Object";
        ClassInfo.llIlIIIlllI[25] = "this$";
        ClassInfo.llIlIIIlllI[26] = "L";
        ClassInfo.llIlIIIlllI[27] = "<";
        ClassInfo.llIlIIIlllI[28] = "Cannot add target ";
        ClassInfo.llIlIIIlllI[29] = " for ";
        ClassInfo.llIlIIIlllI[30] = " because the target is a mixin";
        ClassInfo.llIlIIIlllI[31] = "java/lang/Object";
        ClassInfo.llIlIIIlllI[32] = "Failed to resolve declared interface {} on {}";
        ClassInfo.llIlIIIlllI[33] = "Error loading class: {} ({}: {})";
        ClassInfo.llIlIIIlllI[34] = "Added class metadata for {} to metadata cache";
        ClassInfo.llIlIIIlllI[35] = "java/lang/Object";
        ClassInfo.llIlIIIlllI[36] = "mixin";
        ClassInfo.llIlIIIlllI[37] = "java/lang/Object";
    }
    
    private static String lIIlIIIllIlII(String s, final String s2) {
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
    
    private static String lIIlIIIllIllI(final String s, final String s2) {
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
    
    private static String lIIlIIIlIllll(final String s, final String s2) {
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
    
    private static boolean lIIlIIllIllIl(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIlIIlllIIII(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIlIIlllIIIl(final int n) {
        return n > 0;
    }
    
    private static boolean lIIlIIlllIlII$255f299(final int n) {
        return n != 10;
    }
}
