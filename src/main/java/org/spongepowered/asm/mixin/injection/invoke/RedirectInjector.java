package org.spongepowered.asm.mixin.injection.invoke;

import java.lang.annotation.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.mixin.injection.code.*;
import org.spongepowered.asm.mixin.injection.throwables.*;
import org.spongepowered.asm.mixin.injection.points.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.mixin.*;
import com.google.common.primitives.*;
import org.spongepowered.asm.lib.tree.*;
import com.google.common.base.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import com.google.common.collect.*;

public class RedirectInjector extends InvokeInjector
{
    private static final String KEY_NOMINATORS;
    private static final String KEY_FUZZ;
    private static final String KEY_OPCODE;
    private Meta meta;
    private Map<BeforeNew, ConstructorRedirectData> ctorRedirectors;
    private static final String[] lIIlIlIlll;
    
    public RedirectInjector(final InjectionInfo injectionInfo) {
        this(injectionInfo, RedirectInjector.lIIlIlIlll[0]);
    }
    
    protected RedirectInjector(final InjectionInfo injectionInfo, final String s) {
        super(injectionInfo, s);
        this.ctorRedirectors = new HashMap<BeforeNew, ConstructorRedirectData>();
        this.meta = new Meta(injectionInfo.getContext().getPriority(), Annotations.getVisible(this.methodNode, Final.class) != null, this.info.toString());
    }
    
    @Override
    protected final void checkTarget(final Target target) {
    }
    
    public final void addTargetNode(final Target target, final List<InjectionNodes.InjectionNode> list, final AbstractInsnNode abstractInsnNode, final Set<InjectionPoint> set) {
        final InjectionNodes.InjectionNode value = target.injectionNodes.get(abstractInsnNode);
        Object o = null;
        int fuzzFactor = 8;
        int arrOpcode = 0;
        final Meta meta;
        if (value != null && (meta = value.getDecoration(RedirectInjector.lIIlIlIlll[1])) != null && lllIIIIIlll(meta.this$0, this)) {
            if (lllIIIIlIII(meta.priority, this.meta.priority)) {
                Injector.logger.warn(RedirectInjector.lIIlIlIlll[2], new Object[] { this.annotationType, this.info, this.meta.priority, meta.name, meta.priority });
                return;
            }
            if (meta.isFinal) {
                throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[3], this.annotationType, this, meta.name));
            }
        }
        final Iterator<InjectionPoint> iterator = set.iterator();
        while (iterator.hasNext()) {
            final InjectionPoint injectionPoint;
            if ((injectionPoint = iterator.next()) instanceof BeforeNew) {
                final BeforeNew beforeNew = (BeforeNew)injectionPoint;
                ConstructorRedirectData constructorRedirectData;
                if ((constructorRedirectData = this.ctorRedirectors.get(beforeNew)) == null) {
                    constructorRedirectData = new ConstructorRedirectData();
                    this.ctorRedirectors.put(beforeNew, constructorRedirectData);
                }
                ((ConstructorRedirectData)(o = constructorRedirectData)).wildcard = (((BeforeNew)injectionPoint).desc == null);
            }
            else {
                if (!(injectionPoint instanceof BeforeFieldAccess)) {
                    continue;
                }
                final BeforeFieldAccess beforeFieldAccess;
                fuzzFactor = (beforeFieldAccess = (BeforeFieldAccess)injectionPoint).fuzzFactor;
                arrOpcode = beforeFieldAccess.arrOpcode;
            }
        }
        final InjectionNodes.InjectionNode addInjectionNode;
        (addInjectionNode = target.addInjectionNode(abstractInsnNode)).decorate(RedirectInjector.lIIlIlIlll[4], this.meta);
        addInjectionNode.decorate(RedirectInjector.lIIlIlIlll[5], set);
        if (abstractInsnNode instanceof TypeInsnNode && abstractInsnNode.getOpcode() == 187) {
            addInjectionNode.decorate(RedirectInjector.lIIlIlIlll[6], o);
        }
        else {
            addInjectionNode.decorate(RedirectInjector.lIIlIlIlll[7], fuzzFactor);
            addInjectionNode.decorate(RedirectInjector.lIIlIlIlll[8], arrOpcode);
        }
        list.add(addInjectionNode);
    }
    
    private ConstructorRedirectData getCtorRedirect(final BeforeNew beforeNew) {
        ConstructorRedirectData constructorRedirectData;
        if ((constructorRedirectData = this.ctorRedirectors.get(beforeNew)) == null) {
            constructorRedirectData = new ConstructorRedirectData();
            this.ctorRedirectors.put(beforeNew, constructorRedirectData);
        }
        return constructorRedirectData;
    }
    
    @Override
    public void inject(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        if (!this.preInject(injectionNode)) {
            return;
        }
        if (injectionNode.isReplaced()) {
            throw new UnsupportedOperationException(String.valueOf(new StringBuilder().append(RedirectInjector.lIIlIlIlll[9]).append(this.info)));
        }
        if (injectionNode.currentTarget instanceof MethodInsnNode) {
            this.checkTargetForNode(target, injectionNode);
            this.injectAtInvoke(target, injectionNode);
            return;
        }
        if (injectionNode.currentTarget instanceof FieldInsnNode) {
            this.checkTargetForNode(target, injectionNode);
            final FieldInsnNode fieldInsnNode;
            final int opcode = (fieldInsnNode = (FieldInsnNode)injectionNode.currentTarget).getOpcode();
            final Type type = Type.getType(String.valueOf(new StringBuilder().append(RedirectInjector.lIIlIlIlll[23]).append(fieldInsnNode.owner).append(RedirectInjector.lIIlIlIlll[24])));
            final Type type2;
            final int n = ((type2 = Type.getType(fieldInsnNode.desc)).sort == 9) ? type2.getDimensions() : 0;
            final int n2;
            if ((n2 = ((this.returnType.sort == 9) ? this.returnType.getDimensions() : 0)) > n) {
                throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(RedirectInjector.lIIlIlIlll[25]).append(this)));
            }
            if (n2 != 0 || n <= 0) {
                this.injectAtScalarField(target, fieldInsnNode, opcode, type, type2);
                return;
            }
            final int intValue = injectionNode.getDecoration(RedirectInjector.lIIlIlIlll[26]);
            final int intValue2 = injectionNode.getDecoration(RedirectInjector.lIIlIlIlll[27]);
            final FieldInsnNode fieldInsnNode2 = fieldInsnNode;
            final int n3 = opcode;
            final Type type3 = type2;
            final int n4 = intValue;
            int opcode2 = intValue2;
            final int n5 = n4;
            final Type type4 = type3;
            final int n6 = n3;
            final FieldInsnNode fieldInsnNode3 = fieldInsnNode2;
            final Type elementType = type4.getElementType();
            if (lllIIIlIIII(n6, 178) && lllIIIlIIII(n6, 180)) {
                throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[28], Bytecode.getOpcodeName(n6), this.info));
            }
            if (this.returnType.sort != 0) {
                if (lllIIIlIIII(opcode2, 190)) {
                    opcode2 = elementType.getOpcode(46);
                }
                final AbstractInsnNode arrayNode = BeforeFieldAccess.findArrayNode(target.insns, fieldInsnNode3, opcode2, n5);
                final FieldInsnNode fieldInsnNode4 = fieldInsnNode3;
                final AbstractInsnNode abstractInsnNode = arrayNode;
                final Type type5 = type4;
                final AbstractInsnNode abstractInsnNode2 = abstractInsnNode;
                final FieldInsnNode fieldInsnNode5 = fieldInsnNode4;
                final AbstractInsnNode abstractInsnNode3 = abstractInsnNode2;
                final Type returnType = this.returnType;
                final Type type6 = type5;
                final Type type7 = returnType;
                final AbstractInsnNode abstractInsnNode4 = abstractInsnNode3;
                this.injectArrayRedirect(target, fieldInsnNode5, abstractInsnNode2, this.checkDescriptor((abstractInsnNode3 != null && abstractInsnNode4.getOpcode() == 190) ? Bytecode.generateDescriptor(Type.INT_TYPE, (Object[])getArrayArgs(type6, 0, new Type[0])) : Bytecode.generateDescriptor(type7, (Object[])getArrayArgs(type6, 1, new Type[0])), target, RedirectInjector.lIIlIlIlll[29]), RedirectInjector.lIIlIlIlll[30]);
                return;
            }
            final AbstractInsnNode arrayNode2 = BeforeFieldAccess.findArrayNode(target.insns, fieldInsnNode3, elementType.getOpcode(79), n5);
            final FieldInsnNode fieldInsnNode6 = fieldInsnNode3;
            final AbstractInsnNode abstractInsnNode5 = arrayNode2;
            final Type type8 = type4;
            this.injectArrayRedirect(target, fieldInsnNode6, abstractInsnNode5, this.checkDescriptor(Bytecode.generateDescriptor(null, (Object[])getArrayArgs(type8, 1, type8.getElementType())), target, RedirectInjector.lIIlIlIlll[31]), RedirectInjector.lIIlIlIlll[32]);
        }
        else {
            if (!(injectionNode.currentTarget instanceof TypeInsnNode) || injectionNode.currentTarget.getOpcode() != 187) {
                throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[11], this.annotationType, target, this));
            }
            if (!this.isStatic && target.isStatic) {
                throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[10], this));
            }
            final ConstructorRedirectData constructorRedirectData;
            if ((constructorRedirectData = injectionNode.getDecoration(RedirectInjector.lIIlIlIlll[41])) == null) {
                throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[42], this.annotationType));
            }
            final TypeInsnNode typeInsnNode = (TypeInsnNode)injectionNode.currentTarget;
            final AbstractInsnNode value = target.insns.get(target.indexOf(typeInsnNode) + 1);
            final MethodInsnNode initNode;
            if ((initNode = target.findInitNodeFor(typeInsnNode)) != null) {
                final boolean b = value.getOpcode() == 89;
                final String replace = initNode.desc.replace(RedirectInjector.lIIlIlIlll[44], String.valueOf(new StringBuilder().append(RedirectInjector.lIIlIlIlll[45]).append(typeInsnNode.desc).append(RedirectInjector.lIIlIlIlll[46])));
                final String s = RedirectInjector.lIIlIlIlll[47];
                boolean checkDescriptor;
                try {
                    checkDescriptor = this.checkDescriptor(replace, target, s);
                }
                catch (InvalidInjectionException ex) {
                    if (!constructorRedirectData.wildcard) {
                        throw ex;
                    }
                    return;
                }
                if (b) {
                    target.removeNode(value);
                }
                if (this.isStatic) {
                    target.removeNode(typeInsnNode);
                }
                else {
                    final TypeInsnNode typeInsnNode2 = typeInsnNode;
                    final VarInsnNode varInsnNode = new VarInsnNode(25, 0);
                    final TypeInsnNode typeInsnNode3 = typeInsnNode2;
                    target.insns.insertBefore(typeInsnNode3, varInsnNode);
                    target.insns.remove(typeInsnNode3);
                    target.injectionNodes.replace(typeInsnNode3, varInsnNode);
                }
                final InsnList list = new InsnList();
                if (checkDescriptor) {
                    InvokeInjector.pushArgs(target.arguments, list, target.getArgIndices(), 0, target.arguments.length);
                    target.addToStack(Bytecode.getArgsSize(target.arguments));
                }
                this.invokeHandler(list);
                if (b) {
                    final LabelNode labelNode = new LabelNode();
                    list.add(new InsnNode(89));
                    list.add(new JumpInsnNode(199, labelNode));
                    Injector.throwException(list, RedirectInjector.lIIlIlIlll[48], String.format(RedirectInjector.lIIlIlIlll[49], this.annotationType, this, typeInsnNode.desc.replace('/', '.')));
                    list.add(labelNode);
                    target.addToStack(1);
                }
                else {
                    list.add(new InsnNode(87));
                }
                final MethodInsnNode methodInsnNode = initNode;
                final InsnList list2 = list;
                final MethodInsnNode methodInsnNode2 = methodInsnNode;
                target.insns.insertBefore(methodInsnNode2, list2);
                target.removeNode(methodInsnNode2);
                final ConstructorRedirectData constructorRedirectData2 = constructorRedirectData;
                ++constructorRedirectData2.injected;
                return;
            }
            if (!constructorRedirectData.wildcard) {
                throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[43], this.annotationType, target));
            }
        }
    }
    
    protected final boolean preInject(final InjectionNodes.InjectionNode injectionNode) {
        final Meta meta;
        if (lllIIIIIlll((meta = injectionNode.getDecoration(RedirectInjector.lIIlIlIlll[12])).this$0, this)) {
            Injector.logger.warn(RedirectInjector.lIIlIlIlll[13], new Object[] { this.annotationType, this.info, this.meta.priority, meta.name, meta.priority });
            return false;
        }
        return true;
    }
    
    @Override
    public final void postInject(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        super.postInject(target, injectionNode);
        final ConstructorRedirectData constructorRedirectData;
        if (injectionNode.originalTarget instanceof TypeInsnNode && injectionNode.originalTarget.getOpcode() == 187 && (constructorRedirectData = injectionNode.getDecoration(RedirectInjector.lIIlIlIlll[14])).wildcard && constructorRedirectData.injected == 0) {
            throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[15], this.annotationType, target));
        }
    }
    
    @Override
    protected final void injectAtInvoke(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        final RedirectedInvoke redirectedInvoke2;
        final RedirectedInvoke redirectedInvoke = redirectedInvoke2 = new RedirectedInvoke(target, (MethodInsnNode)injectionNode.currentTarget);
        int n = this.methodArgs.length;
        final String format = String.format(RedirectInjector.lIIlIlIlll[16], this.annotationType, this);
        if (!redirectedInvoke2.returnType.equals(this.returnType)) {
            throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[17], format, this.returnType, redirectedInvoke2.returnType));
        }
        for (int i = 0; i < n; ++i) {
            if (lllIIIIlIII(i, this.methodArgs.length)) {
                throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[18], format, n, this.methodArgs.length));
            }
            final Type type = this.methodArgs[i];
            Type type2;
            if (i < redirectedInvoke2.locals.length) {
                type2 = redirectedInvoke2.locals[i];
            }
            else {
                redirectedInvoke2.captureTargetArgs = true;
                n = Math.max(n, redirectedInvoke2.locals.length + redirectedInvoke2.target.arguments.length);
                final int n2;
                if (lllIIIIlIII(n2 = i - redirectedInvoke2.locals.length, redirectedInvoke2.target.arguments.length)) {
                    throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[19], format, type, i));
                }
                type2 = redirectedInvoke2.target.arguments[n2];
            }
            final AnnotationNode invisibleParameter = Annotations.getInvisibleParameter(this.methodNode, Coerce.class, i);
            if (type.equals(type2)) {
                if (invisibleParameter != null && this.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
                    Injector.logger.warn(RedirectInjector.lIIlIlIlll[20], new Object[] { format, i, type2, type });
                }
            }
            else {
                final boolean canCoerce = Injector.canCoerce(type, type2);
                if (invisibleParameter == null) {
                    throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[21], format, type, i, type2));
                }
                if (!canCoerce) {
                    throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[22], format, type2, i, type));
                }
            }
        }
        final InsnList list = new InsnList();
        int n3 = Bytecode.getArgsSize(redirectedInvoke.locals) + 1;
        int n4 = 1;
        int[] array = InvokeInjector.storeArgs(target, redirectedInvoke.locals, list, 0);
        if (redirectedInvoke.captureTargetArgs) {
            final int argsSize = Bytecode.getArgsSize(target.arguments);
            n3 += argsSize;
            n4 = argsSize + 1;
            array = Ints.concat(new int[][] { array, target.getArgIndices() });
        }
        target.replaceNode(redirectedInvoke.node, this.invokeHandlerWithArgs(this.methodArgs, list, array), list);
        target.addToLocals(n3);
        target.addToStack(n4);
    }
    
    private void validateParams(final RedirectedInvoke redirectedInvoke) {
        int n = this.methodArgs.length;
        final String format = String.format(RedirectInjector.lIIlIlIlll[16], this.annotationType, this);
        if (!redirectedInvoke.returnType.equals(this.returnType)) {
            throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[17], format, this.returnType, redirectedInvoke.returnType));
        }
        for (int i = 0; i < n; ++i) {
            if (lllIIIIlIII(i, this.methodArgs.length)) {
                throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[18], format, n, this.methodArgs.length));
            }
            final Type type = this.methodArgs[i];
            Type type2;
            if (i < redirectedInvoke.locals.length) {
                type2 = redirectedInvoke.locals[i];
            }
            else {
                redirectedInvoke.captureTargetArgs = true;
                n = Math.max(n, redirectedInvoke.locals.length + redirectedInvoke.target.arguments.length);
                final int n2;
                if (lllIIIIlIII(n2 = i - redirectedInvoke.locals.length, redirectedInvoke.target.arguments.length)) {
                    throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[19], format, type, i));
                }
                type2 = redirectedInvoke.target.arguments[n2];
            }
            final AnnotationNode invisibleParameter = Annotations.getInvisibleParameter(this.methodNode, Coerce.class, i);
            if (type.equals(type2)) {
                if (invisibleParameter != null && this.info.getContext().getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
                    Injector.logger.warn(RedirectInjector.lIIlIlIlll[20], new Object[] { format, i, type2, type });
                }
            }
            else {
                final boolean canCoerce = Injector.canCoerce(type, type2);
                if (invisibleParameter == null) {
                    throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[21], format, type, i, type2));
                }
                if (!canCoerce) {
                    throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[22], format, type2, i, type));
                }
            }
        }
    }
    
    private void injectAtFieldAccess(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        final FieldInsnNode fieldInsnNode;
        final int opcode = (fieldInsnNode = (FieldInsnNode)injectionNode.currentTarget).getOpcode();
        final Type type = Type.getType(String.valueOf(new StringBuilder().append(RedirectInjector.lIIlIlIlll[23]).append(fieldInsnNode.owner).append(RedirectInjector.lIIlIlIlll[24])));
        final Type type2;
        final int n = ((type2 = Type.getType(fieldInsnNode.desc)).sort == 9) ? type2.getDimensions() : 0;
        final int n2;
        if ((n2 = ((this.returnType.sort == 9) ? this.returnType.getDimensions() : 0)) > n) {
            throw new InvalidInjectionException(this.info, String.valueOf(new StringBuilder().append(RedirectInjector.lIIlIlIlll[25]).append(this)));
        }
        if (n2 != 0 || n <= 0) {
            this.injectAtScalarField(target, fieldInsnNode, opcode, type, type2);
            return;
        }
        final int intValue = injectionNode.getDecoration(RedirectInjector.lIIlIlIlll[26]);
        final int intValue2 = injectionNode.getDecoration(RedirectInjector.lIIlIlIlll[27]);
        final FieldInsnNode fieldInsnNode2 = fieldInsnNode;
        final int n3 = opcode;
        final Type type3 = type2;
        final int n4 = intValue;
        int opcode2 = intValue2;
        final int n5 = n4;
        final Type type4 = type3;
        final int n6 = n3;
        final FieldInsnNode fieldInsnNode3 = fieldInsnNode2;
        final Type elementType = type4.getElementType();
        if (lllIIIlIIII(n6, 178) && lllIIIlIIII(n6, 180)) {
            throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[28], Bytecode.getOpcodeName(n6), this.info));
        }
        if (this.returnType.sort != 0) {
            if (lllIIIlIIII(opcode2, 190)) {
                opcode2 = elementType.getOpcode(46);
            }
            final AbstractInsnNode arrayNode = BeforeFieldAccess.findArrayNode(target.insns, fieldInsnNode3, opcode2, n5);
            final FieldInsnNode fieldInsnNode4 = fieldInsnNode3;
            final AbstractInsnNode abstractInsnNode = arrayNode;
            final Type type5 = type4;
            final AbstractInsnNode abstractInsnNode2 = abstractInsnNode;
            final FieldInsnNode fieldInsnNode5 = fieldInsnNode4;
            final AbstractInsnNode abstractInsnNode3 = abstractInsnNode2;
            final Type returnType = this.returnType;
            final Type type6 = type5;
            final Type type7 = returnType;
            final AbstractInsnNode abstractInsnNode4 = abstractInsnNode3;
            this.injectArrayRedirect(target, fieldInsnNode5, abstractInsnNode2, this.checkDescriptor((abstractInsnNode3 != null && abstractInsnNode4.getOpcode() == 190) ? Bytecode.generateDescriptor(Type.INT_TYPE, (Object[])getArrayArgs(type6, 0, new Type[0])) : Bytecode.generateDescriptor(type7, (Object[])getArrayArgs(type6, 1, new Type[0])), target, RedirectInjector.lIIlIlIlll[29]), RedirectInjector.lIIlIlIlll[30]);
            return;
        }
        final AbstractInsnNode arrayNode2 = BeforeFieldAccess.findArrayNode(target.insns, fieldInsnNode3, elementType.getOpcode(79), n5);
        final FieldInsnNode fieldInsnNode6 = fieldInsnNode3;
        final AbstractInsnNode abstractInsnNode5 = arrayNode2;
        final Type type8 = type4;
        this.injectArrayRedirect(target, fieldInsnNode6, abstractInsnNode5, this.checkDescriptor(Bytecode.generateDescriptor(null, (Object[])getArrayArgs(type8, 1, type8.getElementType())), target, RedirectInjector.lIIlIlIlll[31]), RedirectInjector.lIIlIlIlll[32]);
    }
    
    private void injectAtArrayField$6ee49170(final Target target, final FieldInsnNode fieldInsnNode, final int n, final Type type, int n2, int opcode) {
        final Type elementType = type.getElementType();
        if (lllIIIlIIII(n, 178) && lllIIIlIIII(n, 180)) {
            throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[28], Bytecode.getOpcodeName(n), this.info));
        }
        if (this.returnType.sort != 0) {
            if (lllIIIlIIII(opcode, 190)) {
                opcode = elementType.getOpcode(46);
            }
            final AbstractInsnNode arrayNode;
            final AbstractInsnNode abstractInsnNode = arrayNode = BeforeFieldAccess.findArrayNode(target.insns, fieldInsnNode, opcode, n2);
            final Type returnType = this.returnType;
            final AbstractInsnNode abstractInsnNode2 = arrayNode;
            n2 = (this.checkDescriptor((arrayNode != null && abstractInsnNode2.getOpcode() == 190) ? Bytecode.generateDescriptor(Type.INT_TYPE, (Object[])getArrayArgs(type, 0, new Type[0])) : Bytecode.generateDescriptor(returnType, (Object[])getArrayArgs(type, 1, new Type[0])), target, RedirectInjector.lIIlIlIlll[29]) ? 1 : 0);
            this.injectArrayRedirect(target, fieldInsnNode, abstractInsnNode, n2 != 0, RedirectInjector.lIIlIlIlll[30]);
            return;
        }
        final AbstractInsnNode arrayNode2 = BeforeFieldAccess.findArrayNode(target.insns, fieldInsnNode, elementType.getOpcode(79), n2);
        n2 = (this.checkDescriptor(Bytecode.generateDescriptor(null, (Object[])getArrayArgs(type, 1, type.getElementType())), target, RedirectInjector.lIIlIlIlll[31]) ? 1 : 0);
        this.injectArrayRedirect(target, fieldInsnNode, arrayNode2, n2 != 0, RedirectInjector.lIIlIlIlll[32]);
    }
    
    private void injectAtGetArray$4740a739(final Target target, final FieldInsnNode fieldInsnNode, final AbstractInsnNode abstractInsnNode, final Type type) {
        final Type returnType = this.returnType;
        this.injectArrayRedirect(target, fieldInsnNode, abstractInsnNode, this.checkDescriptor((abstractInsnNode != null && abstractInsnNode.getOpcode() == 190) ? Bytecode.generateDescriptor(Type.INT_TYPE, (Object[])getArrayArgs(type, 0, new Type[0])) : Bytecode.generateDescriptor(returnType, (Object[])getArrayArgs(type, 1, new Type[0])), target, RedirectInjector.lIIlIlIlll[29]), RedirectInjector.lIIlIlIlll[30]);
    }
    
    private void injectAtSetArray$4740a739(final Target target, final FieldInsnNode fieldInsnNode, final AbstractInsnNode abstractInsnNode, final Type type) {
        this.injectArrayRedirect(target, fieldInsnNode, abstractInsnNode, this.checkDescriptor(Bytecode.generateDescriptor(null, (Object[])getArrayArgs(type, 1, type.getElementType())), target, RedirectInjector.lIIlIlIlll[31]), RedirectInjector.lIIlIlIlll[32]);
    }
    
    private void injectArrayRedirect(final Target target, final FieldInsnNode fieldInsnNode, final AbstractInsnNode abstractInsnNode, final boolean b, final String s) {
        if (abstractInsnNode == null) {
            throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[34], this.annotationType, this, s, target, RedirectInjector.lIIlIlIlll[33]));
        }
        if (!this.isStatic) {
            target.insns.insertBefore(fieldInsnNode, new VarInsnNode(25, 0));
            target.addToStack(1);
        }
        final InsnList list = new InsnList();
        if (b) {
            InvokeInjector.pushArgs(target.arguments, list, target.getArgIndices(), 0, target.arguments.length);
            target.addToStack(Bytecode.getArgsSize(target.arguments));
        }
        target.replaceNode(abstractInsnNode, this.invokeHandler(list), list);
    }
    
    private void injectAtScalarField(final Target target, final FieldInsnNode fieldInsnNode, final int n, final Type type, final Type type2) {
        final InsnList list = new InsnList();
        AbstractInsnNode abstractInsnNode;
        if (!lllIIIlIIII(n, 178) || n == 180) {
            final InsnList list2 = list;
            final boolean b = n == 178;
            final InsnList list3 = list2;
            final boolean checkDescriptor = this.checkDescriptor(b ? Bytecode.generateDescriptor(type2, new Object[0]) : Bytecode.generateDescriptor(type2, type), target, RedirectInjector.lIIlIlIlll[36]);
            if (!this.isStatic) {
                list3.add(new VarInsnNode(25, 0));
                if (!b) {
                    list3.add(new InsnNode(95));
                }
            }
            if (checkDescriptor) {
                InvokeInjector.pushArgs(target.arguments, list3, target.getArgIndices(), 0, target.arguments.length);
                target.addToStack(Bytecode.getArgsSize(target.arguments));
            }
            target.addToStack(this.isStatic ? 0 : 1);
            abstractInsnNode = this.invokeHandler(list3);
        }
        else {
            if (lllIIIlIIII(n, 179) && n != 181) {
                throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[35], Bytecode.getOpcodeName(n), this.info));
            }
            final InsnList list4 = list;
            final boolean b2 = n == 179;
            final InsnList list5 = list4;
            final boolean checkDescriptor2 = this.checkDescriptor(b2 ? Bytecode.generateDescriptor(null, type2) : Bytecode.generateDescriptor(null, type, type2), target, RedirectInjector.lIIlIlIlll[37]);
            if (!this.isStatic) {
                if (b2) {
                    list5.add(new VarInsnNode(25, 0));
                    list5.add(new InsnNode(95));
                }
                else {
                    final int allocateLocals = target.allocateLocals(type2.getSize());
                    list5.add(new VarInsnNode(type2.getOpcode(54), allocateLocals));
                    list5.add(new VarInsnNode(25, 0));
                    list5.add(new InsnNode(95));
                    list5.add(new VarInsnNode(type2.getOpcode(21), allocateLocals));
                }
            }
            if (checkDescriptor2) {
                InvokeInjector.pushArgs(target.arguments, list5, target.getArgIndices(), 0, target.arguments.length);
                target.addToStack(Bytecode.getArgsSize(target.arguments));
            }
            target.addToStack((!this.isStatic && !b2) ? 1 : 0);
            abstractInsnNode = this.invokeHandler(list5);
        }
        target.replaceNode(fieldInsnNode, abstractInsnNode, list);
    }
    
    private AbstractInsnNode injectAtGetField$1b24e501(final InsnList list, final Target target, final boolean b, final Type type, final Type type2) {
        final boolean checkDescriptor = this.checkDescriptor(b ? Bytecode.generateDescriptor(type2, new Object[0]) : Bytecode.generateDescriptor(type2, type), target, RedirectInjector.lIIlIlIlll[36]);
        if (!this.isStatic) {
            list.add(new VarInsnNode(25, 0));
            if (!b) {
                list.add(new InsnNode(95));
            }
        }
        if (checkDescriptor) {
            InvokeInjector.pushArgs(target.arguments, list, target.getArgIndices(), 0, target.arguments.length);
            target.addToStack(Bytecode.getArgsSize(target.arguments));
        }
        target.addToStack(this.isStatic ? 0 : 1);
        return this.invokeHandler(list);
    }
    
    private AbstractInsnNode injectAtPutField$1b24e501(final InsnList list, final Target target, final boolean b, final Type type, final Type type2) {
        final boolean checkDescriptor = this.checkDescriptor(b ? Bytecode.generateDescriptor(null, type2) : Bytecode.generateDescriptor(null, type, type2), target, RedirectInjector.lIIlIlIlll[37]);
        if (!this.isStatic) {
            if (b) {
                list.add(new VarInsnNode(25, 0));
                list.add(new InsnNode(95));
            }
            else {
                final int allocateLocals = target.allocateLocals(type2.getSize());
                list.add(new VarInsnNode(type2.getOpcode(54), allocateLocals));
                list.add(new VarInsnNode(25, 0));
                list.add(new InsnNode(95));
                list.add(new VarInsnNode(type2.getOpcode(21), allocateLocals));
            }
        }
        if (checkDescriptor) {
            InvokeInjector.pushArgs(target.arguments, list, target.getArgIndices(), 0, target.arguments.length);
            target.addToStack(Bytecode.getArgsSize(target.arguments));
        }
        target.addToStack((!this.isStatic && !b) ? 1 : 0);
        return this.invokeHandler(list);
    }
    
    protected final boolean checkDescriptor(final String s, final Target target, final String s2) {
        if (this.methodNode.desc.equals(s)) {
            return false;
        }
        final int index = s.indexOf(41);
        if (this.methodNode.desc.equals(String.format(RedirectInjector.lIIlIlIlll[38], s.substring(0, index), Joiner.on(RedirectInjector.lIIlIlIlll[39]).join((Object[])target.arguments), s.substring(index)))) {
            return true;
        }
        throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[40], this.annotationType, s2, this, s, this.methodNode.desc));
    }
    
    private void injectAtConstructor(final Target target, final InjectionNodes.InjectionNode injectionNode) {
        final ConstructorRedirectData constructorRedirectData;
        if ((constructorRedirectData = injectionNode.getDecoration(RedirectInjector.lIIlIlIlll[41])) == null) {
            throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[42], this.annotationType));
        }
        final TypeInsnNode typeInsnNode = (TypeInsnNode)injectionNode.currentTarget;
        final AbstractInsnNode value = target.insns.get(target.indexOf(typeInsnNode) + 1);
        final MethodInsnNode initNode;
        if ((initNode = target.findInitNodeFor(typeInsnNode)) != null) {
            final boolean b = value.getOpcode() == 89;
            final String replace = initNode.desc.replace(RedirectInjector.lIIlIlIlll[44], String.valueOf(new StringBuilder().append(RedirectInjector.lIIlIlIlll[45]).append(typeInsnNode.desc).append(RedirectInjector.lIIlIlIlll[46])));
            final String s = RedirectInjector.lIIlIlIlll[47];
            boolean checkDescriptor;
            try {
                checkDescriptor = this.checkDescriptor(replace, target, s);
            }
            catch (InvalidInjectionException ex) {
                if (!constructorRedirectData.wildcard) {
                    throw ex;
                }
                return;
            }
            if (b) {
                target.removeNode(value);
            }
            if (this.isStatic) {
                target.removeNode(typeInsnNode);
            }
            else {
                final TypeInsnNode typeInsnNode2 = typeInsnNode;
                final VarInsnNode varInsnNode = new VarInsnNode(25, 0);
                final TypeInsnNode typeInsnNode3 = typeInsnNode2;
                target.insns.insertBefore(typeInsnNode3, varInsnNode);
                target.insns.remove(typeInsnNode3);
                target.injectionNodes.replace(typeInsnNode3, varInsnNode);
            }
            final InsnList list = new InsnList();
            if (checkDescriptor) {
                InvokeInjector.pushArgs(target.arguments, list, target.getArgIndices(), 0, target.arguments.length);
                target.addToStack(Bytecode.getArgsSize(target.arguments));
            }
            this.invokeHandler(list);
            if (b) {
                final LabelNode labelNode = new LabelNode();
                list.add(new InsnNode(89));
                list.add(new JumpInsnNode(199, labelNode));
                Injector.throwException(list, RedirectInjector.lIIlIlIlll[48], String.format(RedirectInjector.lIIlIlIlll[49], this.annotationType, this, typeInsnNode.desc.replace('/', '.')));
                list.add(labelNode);
                target.addToStack(1);
            }
            else {
                list.add(new InsnNode(87));
            }
            final MethodInsnNode methodInsnNode = initNode;
            final InsnList list2 = list;
            final MethodInsnNode methodInsnNode2 = methodInsnNode;
            target.insns.insertBefore(methodInsnNode2, list2);
            target.removeNode(methodInsnNode2);
            final ConstructorRedirectData constructorRedirectData2 = constructorRedirectData;
            ++constructorRedirectData2.injected;
            return;
        }
        if (!constructorRedirectData.wildcard) {
            throw new InvalidInjectionException(this.info, String.format(RedirectInjector.lIIlIlIlll[43], this.annotationType, target));
        }
    }
    
    private static String getGetArrayHandlerDescriptor(final AbstractInsnNode abstractInsnNode, final Type type, final Type type2) {
        if (abstractInsnNode != null && abstractInsnNode.getOpcode() == 190) {
            return Bytecode.generateDescriptor(Type.INT_TYPE, (Object[])getArrayArgs(type2, 0, new Type[0]));
        }
        return Bytecode.generateDescriptor(type, (Object[])getArrayArgs(type2, 1, new Type[0]));
    }
    
    private static Type[] getArrayArgs(final Type type, int n, final Type... array) {
        final Type[] array2 = new Type[(n += type.getDimensions()) + array.length];
        for (int i = 0; i < array2.length; ++i) {
            final Type[] array3 = array2;
            final int n2 = i;
            array3[n2] = ((n2 == 0) ? type : ((i < n) ? Type.INT_TYPE : array[n - i]));
        }
        return array2;
    }
    
    static {
        llIllllIllI();
    }
    
    private static void llIllllIllI() {
        (lIIlIlIlll = new String[53])[0] = "@Redirect";
        RedirectInjector.lIIlIlIlll[1] = "redirector";
        RedirectInjector.lIIlIlIlll[2] = "{} conflict. Skipping {} with priority {}, already redirected by {} with priority {}";
        RedirectInjector.lIIlIlIlll[3] = "%s conflict: %s failed because target was already remapped by %s";
        RedirectInjector.lIIlIlIlll[4] = "redirector";
        RedirectInjector.lIIlIlIlll[5] = "nominators";
        RedirectInjector.lIIlIlIlll[6] = "ctor";
        RedirectInjector.lIIlIlIlll[7] = "fuzz";
        RedirectInjector.lIIlIlIlll[8] = "opcode";
        RedirectInjector.lIIlIlIlll[9] = "Redirector target failure for ";
        RedirectInjector.lIIlIlIlll[10] = "non-static callback method %s has a static target which is not supported";
        RedirectInjector.lIIlIlIlll[11] = "%s annotation on is targetting an invalid insn in %s in %s";
        RedirectInjector.lIIlIlIlll[12] = "redirector";
        RedirectInjector.lIIlIlIlll[13] = "{} conflict. Skipping {} with priority {}, already redirected by {} with priority {}";
        RedirectInjector.lIIlIlIlll[14] = "ctor";
        RedirectInjector.lIIlIlIlll[15] = "%s ctor invocation was not found in %s";
        RedirectInjector.lIIlIlIlll[16] = "%s handler method %s";
        RedirectInjector.lIIlIlIlll[17] = "%s has an invalid signature. Expected return type %s found %s";
        RedirectInjector.lIIlIlIlll[18] = "%s has an invalid signature. Not enough arguments found for capture of target method args, expected %d but found %d";
        RedirectInjector.lIIlIlIlll[19] = "%s has an invalid signature. Found unexpected additional target argument with type %s at index %d";
        RedirectInjector.lIIlIlIlll[20] = "Redundant @Coerce on {} argument {}, {} is identical to {}";
        RedirectInjector.lIIlIlIlll[21] = "%s has an invalid signature. Found unexpected argument type %s at index %d, expected %s";
        RedirectInjector.lIIlIlIlll[22] = "%s has an invalid signature. Cannot @Coerce argument type %s at index %d to %s";
        RedirectInjector.lIIlIlIlll[23] = "L";
        RedirectInjector.lIIlIlIlll[24] = ";";
        RedirectInjector.lIIlIlIlll[25] = "Dimensionality of handler method is greater than target array on ";
        RedirectInjector.lIIlIlIlll[26] = "fuzz";
        RedirectInjector.lIIlIlIlll[27] = "opcode";
        RedirectInjector.lIIlIlIlll[28] = "Unspported opcode %s for array access %s";
        RedirectInjector.lIIlIlIlll[29] = "array getter";
        RedirectInjector.lIIlIlIlll[30] = "array getter";
        RedirectInjector.lIIlIlIlll[31] = "array setter";
        RedirectInjector.lIIlIlIlll[32] = "array setter";
        RedirectInjector.lIIlIlIlll[33] = "";
        RedirectInjector.lIIlIlIlll[34] = "Array element %s on %s could not locate a matching %s instruction in %s. %s";
        RedirectInjector.lIIlIlIlll[35] = "Unspported opcode %s for %s";
        RedirectInjector.lIIlIlIlll[36] = "getter";
        RedirectInjector.lIIlIlIlll[37] = "setter";
        RedirectInjector.lIIlIlIlll[38] = "%s%s%s";
        RedirectInjector.lIIlIlIlll[39] = "";
        RedirectInjector.lIIlIlIlll[40] = "%s method %s %s has an invalid signature. Expected %s but found %s";
        RedirectInjector.lIIlIlIlll[41] = "ctor";
        RedirectInjector.lIIlIlIlll[42] = "%s ctor redirector has no metadata, the injector failed a preprocessing phase";
        RedirectInjector.lIIlIlIlll[43] = "%s ctor invocation was not found in %s";
        RedirectInjector.lIIlIlIlll[44] = ")V";
        RedirectInjector.lIIlIlIlll[45] = ")L";
        RedirectInjector.lIIlIlIlll[46] = ";";
        RedirectInjector.lIIlIlIlll[47] = "constructor";
        RedirectInjector.lIIlIlIlll[48] = "java/lang/NullPointerException";
        RedirectInjector.lIIlIlIlll[49] = "%s constructor handler %s returned null for %s";
        RedirectInjector.lIIlIlIlll[50] = "nominators";
        RedirectInjector.lIIlIlIlll[51] = "fuzz";
        RedirectInjector.lIIlIlIlll[52] = "opcode";
    }
    
    private static String llIlllIIlll(String s, final String s2) {
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
    
    private static String llIlllIlIlI(final String s, final String s2) {
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
    
    private static String llIlllIlIII(final String s, final String s2) {
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
    
    private static boolean lllIIIIlIII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lllIIIIlllI(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lllIIIIIlll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lllIIIIllll(final int n) {
        return n > 0;
    }
    
    private static boolean lllIIIlIIII(final int n, final int n2) {
        return n != n2;
    }
}
