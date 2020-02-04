package org.spongepowered.asm.mixin.gen;

import org.spongepowered.asm.mixin.struct.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.mixin.transformer.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.gen.throwables.*;
import org.spongepowered.asm.mixin.refmap.*;
import com.google.common.base.*;
import org.spongepowered.asm.mixin.*;
import org.apache.logging.log4j.*;
import java.util.regex.*;
import org.spongepowered.asm.util.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import com.google.common.collect.*;

public class AccessorInfo extends SpecialMethodInfo
{
    private static Pattern PATTERN_ACCESSOR;
    Type[] argTypes;
    Type returnType;
    private AccessorType type;
    final Type targetFieldType;
    private MemberInfo target;
    FieldNode targetField;
    protected MethodNode targetMethod;
    private static final String[] lIlllIlllIl;
    
    private AccessorInfo(final MixinTargetContext mixinTargetContext, final MethodNode methodNode) {
        this(mixinTargetContext, methodNode, Accessor.class);
    }
    
    protected AccessorInfo(final MixinTargetContext mixinTargetContext, final MethodNode methodNode, final Class<? extends Annotation> clazz) {
        super(mixinTargetContext, methodNode, Annotations.getVisible(methodNode, clazz));
        this.argTypes = Type.getArgumentTypes(methodNode.desc);
        this.returnType = Type.getReturnType(methodNode.desc);
        this.type = this.initType();
        this.targetFieldType = this.initTargetFieldType();
        this.target = this.initTarget();
    }
    
    protected AccessorType initType() {
        if (this.returnType.equals(Type.VOID_TYPE)) {
            return AccessorType.FIELD_SETTER;
        }
        return AccessorType.FIELD_GETTER;
    }
    
    protected Type initTargetFieldType() {
        switch (AccessorInfo$1.$SwitchMap$org$spongepowered$asm$mixin$gen$AccessorInfo$AccessorType[this.type.ordinal()]) {
            case 1: {
                if (this.argTypes.length > 0) {
                    throw new InvalidAccessorException(this.mixin, String.valueOf(new StringBuilder().append(this).append(AccessorInfo.lIlllIlllIl[0]).append(this.argTypes.length)));
                }
                return this.returnType;
            }
            case 2: {
                if (this.argTypes.length != 1) {
                    throw new InvalidAccessorException(this.mixin, String.valueOf(new StringBuilder().append(this).append(AccessorInfo.lIlllIlllIl[1]).append(this.argTypes.length)));
                }
                return this.argTypes[0];
            }
            default: {
                throw new InvalidAccessorException(this.mixin, String.valueOf(new StringBuilder().append(AccessorInfo.lIlllIlllIl[2]).append(this.type).append(AccessorInfo.lIlllIlllIl[3]).append(this)));
            }
        }
    }
    
    protected MemberInfo initTarget() {
        final MemberInfo memberInfo = new MemberInfo(this.getTargetName(), this.targetFieldType.getDescriptor());
        this.annotation.visit(AccessorInfo.lIlllIlllIl[4], memberInfo.toString());
        return memberInfo;
    }
    
    protected final String getTargetName() {
        final String s;
        if (!Strings.isNullOrEmpty(s = Annotations.getValue(this.annotation))) {
            return MemberInfo.parse(s, this.mixin).name;
        }
        final String inflectTarget;
        if ((inflectTarget = this.inflectTarget()) == null) {
            throw new InvalidAccessorException(this.mixin, String.valueOf(new StringBuilder().append(AccessorInfo.lIlllIlllIl[5]).append(this).append(AccessorInfo.lIlllIlllIl[6])));
        }
        return inflectTarget;
    }
    
    private String inflectTarget() {
        return inflectTarget(this.method.name, this.type, this.toString(), this.mixin, this.mixin.getEnvironment().getOption(MixinEnvironment.Option.DEBUG_VERBOSE));
    }
    
    public static String inflectTarget(String s, final AccessorType accessorType, final String s2, final IMixinContext mixinContext, final boolean b) {
        final Matcher matcher;
        if ((matcher = AccessorInfo.PATTERN_ACCESSOR.matcher(s)).matches()) {
            final String group = matcher.group(1);
            final String group2 = matcher.group(3);
            s = matcher.group(4);
            final String s3 = AccessorInfo.lIlllIlllIl[7];
            final Object[] array = new Object[2];
            final int n = 0;
            final String s4 = group2;
            final String s5 = s;
            final boolean b2 = !s5.toUpperCase().equals(s5);
            final String s6 = s4;
            array[n] = (b2 ? s6.toLowerCase() : s6);
            array[1] = s;
            s = String.format(s3, array);
            if (!accessorType.isExpectedPrefix(group) && b) {
                LogManager.getLogger(AccessorInfo.lIlllIlllIl[8]).warn(AccessorInfo.lIlllIlllIl[9], new Object[] { s2, group, accessorType.expectedPrefixes.toString() });
            }
            return MemberInfo.parse(s, mixinContext).name;
        }
        return null;
    }
    
    private MemberInfo getTarget() {
        return this.target;
    }
    
    private Type getTargetFieldType() {
        return this.targetFieldType;
    }
    
    private FieldNode getTargetField() {
        return this.targetField;
    }
    
    public final MethodNode getTargetMethod() {
        return this.targetMethod;
    }
    
    private Type getReturnType() {
        return this.returnType;
    }
    
    private Type[] getArgTypes() {
        return this.argTypes;
    }
    
    @Override
    public String toString() {
        return String.format(AccessorInfo.lIlllIlllIl[10], this.mixin.toString(), Bytecode.getSimpleName(this.annotation), this.type.toString(), this.method.name, this.method.desc);
    }
    
    public void locate() {
        this.targetField = this.findTarget(this.classNode.fields);
    }
    
    public final MethodNode generate() {
        final MethodNode generate = this.type.getGenerator(this).generate();
        Bytecode.mergeAnnotations(this.method, generate);
        return generate;
    }
    
    private FieldNode findTargetField() {
        return this.findTarget(this.classNode.fields);
    }
    
    protected final <TNode> TNode findTarget(final List<TNode> list) {
        TNode tNode = null;
        final ArrayList<TNode> list2 = new ArrayList<TNode>();
        final Iterator<TNode> iterator = list.iterator();
        while (iterator.hasNext()) {
            final FieldNode next;
            final TNode tNode2;
            String s2;
            final String s = ((tNode2 = (TNode)(next = (FieldNode)iterator.next())) instanceof MethodNode) ? (s2 = ((MethodNode)tNode2).desc) : ((tNode2 instanceof FieldNode) ? (s2 = ((FieldNode)tNode2).desc) : (s2 = null));
            final String s3 = s2;
            if (s != null && s3.equals(this.target.desc)) {
                final FieldNode fieldNode;
                String s5;
                final String s4 = ((fieldNode = next) instanceof MethodNode) ? (s5 = ((MethodNode)fieldNode).name) : ((fieldNode instanceof FieldNode) ? (s5 = fieldNode.name) : (s5 = null));
                final String s6 = s5;
                if (s4 == null) {
                    continue;
                }
                if (s6.equals(this.target.name)) {
                    tNode = (TNode)next;
                }
                if (!s6.equalsIgnoreCase(this.target.name)) {
                    continue;
                }
                list2.add((TNode)next);
            }
        }
        if (tNode != null) {
            if (list2.size() > 1) {
                LogManager.getLogger(AccessorInfo.lIlllIlllIl[11]).debug(AccessorInfo.lIlllIlllIl[12], new Object[] { this, this.target });
            }
            return tNode;
        }
        if (list2.size() == 1) {
            return (TNode)list2.get(0);
        }
        throw new InvalidAccessorException(this, String.valueOf(new StringBuilder().append((list2.size() == 0) ? AccessorInfo.lIlllIlllIl[13] : AccessorInfo.lIlllIlllIl[14]).append(AccessorInfo.lIlllIlllIl[15]).append(this.target).append(AccessorInfo.lIlllIlllIl[16]).append(this.classNode.name).append(AccessorInfo.lIlllIlllIl[17]).append(this)));
    }
    
    private static <TNode> String getNodeDesc(final TNode tNode) {
        if (tNode instanceof MethodNode) {
            return ((MethodNode)tNode).desc;
        }
        if (tNode instanceof FieldNode) {
            return ((FieldNode)tNode).desc;
        }
        return null;
    }
    
    private static <TNode> String getNodeName(final TNode tNode) {
        if (tNode instanceof MethodNode) {
            return ((MethodNode)tNode).name;
        }
        if (tNode instanceof FieldNode) {
            return ((FieldNode)tNode).name;
        }
        return null;
    }
    
    public static AccessorInfo of(final MixinTargetContext mixinTargetContext, final MethodNode methodNode, final Class<? extends Annotation> clazz) {
        if (lIIIIlIllIlII(clazz, Accessor.class)) {
            return new AccessorInfo(mixinTargetContext, methodNode);
        }
        if (lIIIIlIllIlII(clazz, Invoker.class)) {
            return new InvokerInfo(mixinTargetContext, methodNode);
        }
        throw new InvalidAccessorException(mixinTargetContext, String.valueOf(new StringBuilder().append(AccessorInfo.lIlllIlllIl[18]).append(clazz.getName())));
    }
    
    private static String toLowerCase(final String s, final boolean b) {
        if (b) {
            return s.toLowerCase();
        }
        return s;
    }
    
    private static boolean isUpperCase(final String s) {
        return s.toUpperCase().equals(s);
    }
    
    static {
        lIIIIIIllIIll();
        AccessorInfo.PATTERN_ACCESSOR = Pattern.compile(AccessorInfo.lIlllIlllIl[19]);
    }
    
    private static void lIIIIIIllIIll() {
        (lIlllIlllIl = new String[20])[0] = " must take exactly 0 arguments, found ";
        AccessorInfo.lIlllIlllIl[1] = " must take exactly 1 argument, found ";
        AccessorInfo.lIlllIlllIl[2] = "Computed unsupported accessor type ";
        AccessorInfo.lIlllIlllIl[3] = " for ";
        AccessorInfo.lIlllIlllIl[4] = "target";
        AccessorInfo.lIlllIlllIl[5] = "Failed to inflect target name for ";
        AccessorInfo.lIlllIlllIl[6] = ", supported prefixes: [get, set, is]";
        AccessorInfo.lIlllIlllIl[7] = "%s%s";
        AccessorInfo.lIlllIlllIl[8] = "mixin";
        AccessorInfo.lIlllIlllIl[9] = "Unexpected prefix for {}, found [{}] expecting {}";
        AccessorInfo.lIlllIlllIl[10] = "%s->@%s[%s]::%s%s";
        AccessorInfo.lIlllIlllIl[11] = "mixin";
        AccessorInfo.lIlllIlllIl[12] = "{} found an exact match for {} but other candidates were found!";
        AccessorInfo.lIlllIlllIl[13] = "No";
        AccessorInfo.lIlllIlllIl[14] = "Multiple";
        AccessorInfo.lIlllIlllIl[15] = " candidates were found matching ";
        AccessorInfo.lIlllIlllIl[16] = " in ";
        AccessorInfo.lIlllIlllIl[17] = " for ";
        AccessorInfo.lIlllIlllIl[18] = "Could not parse accessor for unknown type ";
        AccessorInfo.lIlllIlllIl[19] = "^(get|set|is|invoke|call)(([A-Z])(.*?))(_\\$md.*)?$";
    }
    
    private static String lIIIIIIllIIII(final String s, final String s2) {
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
    
    private static String lIIIIIIllIIIl(String s, final String s2) {
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
    
    private static String lIIIIIIllIIlI(final String s, final String s2) {
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
    
    private static boolean lIIIIlIllIIlI$255f299(final int n) {
        return n > 1;
    }
    
    private static boolean lIIIIlIllIlII(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIIIlIlIllII(final int n) {
        return n > 0;
    }
    
    private static boolean lIIIIlIlIlllI$255f299(final int n) {
        return n != 1;
    }
}
