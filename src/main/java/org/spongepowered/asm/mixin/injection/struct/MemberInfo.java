package org.spongepowered.asm.mixin.injection.struct;

import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.obfuscation.mapping.*;
import org.spongepowered.asm.mixin.throwables.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.refmap.*;
import com.google.common.base.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class MemberInfo
{
    public final String owner;
    public final String name;
    public final String desc;
    public final boolean matchAll;
    private final boolean forceField;
    private final String unparsed;
    public static final String[] lllIIIIl;
    
    private MemberInfo(final String s, final boolean b) {
        this(s, null, null, b);
    }
    
    private MemberInfo(final String s, final String s2, final boolean b) {
        this(s, s2, null, b);
    }
    
    public MemberInfo(final String s, final String s2) {
        this(s, null, s2, false);
    }
    
    public MemberInfo(final String s, final String s2, final String s3, final boolean b) {
        this(s, s2, s3, b, null);
    }
    
    private MemberInfo(final String name, final String owner, final String desc, final boolean matchAll, final String unparsed) {
        super();
        if (owner != null && owner.contains(MemberInfo.lllIIIIl[0])) {
            throw new IllegalArgumentException(MemberInfo.lllIIIIl[1]);
        }
        this.owner = owner;
        this.name = name;
        this.desc = desc;
        this.matchAll = matchAll;
        this.forceField = false;
        this.unparsed = unparsed;
    }
    
    public MemberInfo(final AbstractInsnNode abstractInsnNode) {
        super();
        this.matchAll = false;
        this.forceField = false;
        this.unparsed = null;
        if (abstractInsnNode instanceof MethodInsnNode) {
            final MethodInsnNode methodInsnNode = (MethodInsnNode)abstractInsnNode;
            this.owner = methodInsnNode.owner;
            this.name = methodInsnNode.name;
            this.desc = methodInsnNode.desc;
            return;
        }
        if (abstractInsnNode instanceof FieldInsnNode) {
            final FieldInsnNode fieldInsnNode = (FieldInsnNode)abstractInsnNode;
            this.owner = fieldInsnNode.owner;
            this.name = fieldInsnNode.name;
            this.desc = fieldInsnNode.desc;
            return;
        }
        throw new IllegalArgumentException(MemberInfo.lllIIIIl[2]);
    }
    
    public MemberInfo(final IMapping<?> mapping) {
        super();
        this.owner = mapping.getOwner();
        this.name = mapping.getSimpleName();
        this.desc = mapping.getDesc();
        this.matchAll = false;
        this.forceField = (mapping.getType() == IMapping.Type.FIELD);
        this.unparsed = null;
    }
    
    public MemberInfo(final MemberInfo memberInfo, final MappingMethod mappingMethod) {
        super();
        this.owner = mappingMethod.owner;
        this.name = mappingMethod.name;
        this.desc = mappingMethod.desc;
        this.matchAll = memberInfo.matchAll;
        this.forceField = false;
        this.unparsed = null;
    }
    
    private MemberInfo(final MemberInfo memberInfo, final String owner) {
        super();
        this.owner = owner;
        this.name = memberInfo.name;
        this.desc = memberInfo.desc;
        this.matchAll = memberInfo.matchAll;
        this.forceField = memberInfo.forceField;
        this.unparsed = null;
    }
    
    @Override
    public final String toString() {
        final String s;
        return String.valueOf(new StringBuilder().append((this.owner != null) ? String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[3]).append(this.owner).append(MemberInfo.lllIIIIl[4])) : MemberInfo.lllIIIIl[5]).append((this.name != null) ? this.name : MemberInfo.lllIIIIl[6]).append(this.matchAll ? MemberInfo.lllIIIIl[7] : MemberInfo.lllIIIIl[8]).append((s = ((this.desc != null) ? this.desc : MemberInfo.lllIIIIl[9])).startsWith(MemberInfo.lllIIIIl[10]) ? MemberInfo.lllIIIIl[11] : ((this.desc != null) ? MemberInfo.lllIIIIl[12] : MemberInfo.lllIIIIl[13])).append(s));
    }
    
    @Deprecated
    private String toSrg() {
        if (!this.isFullyQualified()) {
            throw new MixinException(MemberInfo.lllIIIIl[14]);
        }
        if (this.desc.startsWith(MemberInfo.lllIIIIl[15])) {
            return String.valueOf(new StringBuilder().append(this.owner).append(MemberInfo.lllIIIIl[16]).append(this.name).append(MemberInfo.lllIIIIl[17]).append(this.desc));
        }
        return String.valueOf(new StringBuilder().append(this.owner).append(MemberInfo.lllIIIIl[18]).append(this.name));
    }
    
    private String toDescriptor() {
        if (this.desc == null) {
            return MemberInfo.lllIIIIl[19];
        }
        final SignaturePrinter signaturePrinter;
        (signaturePrinter = new SignaturePrinter(this)).fullyQualified = true;
        return signaturePrinter.toDescriptor();
    }
    
    public final String toCtorType() {
        if (this.unparsed == null) {
            return null;
        }
        final String returnType;
        if ((returnType = this.getReturnType()) != null) {
            return returnType;
        }
        if (this.owner != null) {
            return this.owner;
        }
        if (this.name != null && this.desc == null) {
            return this.name;
        }
        if (this.desc != null) {
            return this.desc;
        }
        return this.unparsed;
    }
    
    public final String toCtorDesc() {
        if (this.desc != null && this.desc.startsWith(MemberInfo.lllIIIIl[20]) && this.desc.indexOf(41) >= 0) {
            return String.valueOf(new StringBuilder().append(this.desc.substring(0, this.desc.indexOf(41) + 1)).append(MemberInfo.lllIIIIl[21]));
        }
        return null;
    }
    
    private String getReturnType() {
        if (this.desc == null || this.desc.indexOf(41) == -1 || this.desc.indexOf(40) != 0) {
            return null;
        }
        final String substring;
        if ((substring = this.desc.substring(this.desc.indexOf(41) + 1)).startsWith(MemberInfo.lllIIIIl[22]) && substring.endsWith(MemberInfo.lllIIIIl[23])) {
            return substring.substring(1, substring.length() - 1);
        }
        return substring;
    }
    
    public final IMapping<?> asMapping() {
        if (this.isField()) {
            return this.asFieldMapping();
        }
        return this.asMethodMapping();
    }
    
    public final MappingMethod asMethodMapping() {
        if (!this.isFullyQualified()) {
            throw new MixinException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[24]).append(this).append(MemberInfo.lllIIIIl[25])));
        }
        if (this.isField()) {
            throw new MixinException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[26]).append(this).append(MemberInfo.lllIIIIl[27])));
        }
        return new MappingMethod(this.owner, this.name, this.desc);
    }
    
    public final MappingField asFieldMapping() {
        if (!this.isField()) {
            throw new MixinException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[28]).append(this).append(MemberInfo.lllIIIIl[29])));
        }
        return new MappingField(this.owner, this.name, this.desc);
    }
    
    public final boolean isFullyQualified() {
        return this.owner != null && this.name != null && this.desc != null;
    }
    
    public final boolean isField() {
        return this.forceField || (this.desc != null && !this.desc.startsWith(MemberInfo.lllIIIIl[30]));
    }
    
    public final boolean isConstructor() {
        return MemberInfo.lllIIIIl[31].equals(this.name);
    }
    
    public final boolean isClassInitialiser() {
        return MemberInfo.lllIIIIl[32].equals(this.name);
    }
    
    private boolean isInitialiser() {
        return this.isConstructor() || this.isClassInitialiser();
    }
    
    public final MemberInfo validate() throws InvalidMemberDescriptorException {
        if (this.owner != null) {
            if (!this.owner.matches(MemberInfo.lllIIIIl[33])) {
                throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[34]).append(this.owner)));
            }
            if (this.unparsed != null && this.unparsed.lastIndexOf(46) > 0 && this.owner.startsWith(MemberInfo.lllIIIIl[35])) {
                throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[36]).append(this.owner).append(MemberInfo.lllIIIIl[37]).append(this.owner).append(MemberInfo.lllIIIIl[38])));
            }
        }
        if (this.name != null && !this.name.matches(MemberInfo.lllIIIIl[39])) {
            throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[40]).append(this.name)));
        }
        if (this.desc != null) {
            if (!this.desc.matches(MemberInfo.lllIIIIl[41])) {
                throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[42]).append(this.desc)));
            }
            if (this.isField()) {
                if (!this.desc.equals(Type.getType(this.desc).getDescriptor())) {
                    throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[43]).append(this.desc)));
                }
            }
            else {
                try {
                    Type.getArgumentTypes(this.desc);
                }
                catch (Exception ex) {
                    throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[44]).append(this.desc)));
                }
                final String substring;
                final String s = substring = this.desc.substring(this.desc.indexOf(41) + 1);
                try {
                    if (!substring.equals(Type.getType(s).getDescriptor())) {
                        throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[45]).append(substring).append(MemberInfo.lllIIIIl[46]).append(this.desc)));
                    }
                }
                catch (Exception ex2) {
                    throw new InvalidMemberDescriptorException(String.valueOf(new StringBuilder().append(MemberInfo.lllIIIIl[47]).append(substring).append(MemberInfo.lllIIIIl[48]).append(this.desc)));
                }
            }
        }
        return this;
    }
    
    private boolean matches(final String s, final String s2, final String s3) {
        return this.matches$78a4d1d4(s, s2, s3);
    }
    
    public final boolean matches$78a4d1d4(final String s, final String s2, final String s3) {
        return (this.desc == null || s3 == null || this.desc.equals(s3)) && (this.name == null || s2 == null || this.name.equals(s2)) && (this.owner == null || s == null || this.owner.equals(s));
    }
    
    private boolean matches(final String s, final String s2) {
        return this.matches(s, s2, 0);
    }
    
    public final boolean matches(final String s, final String s2, final int n) {
        return (this.name == null || this.name.equals(s)) && (this.desc == null || (s2 != null && s2.equals(this.desc))) && (n == 0 || this.matchAll);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (o == null || o.getClass() != MemberInfo.class) {
            return false;
        }
        final MemberInfo memberInfo = (MemberInfo)o;
        return this.matchAll == memberInfo.matchAll && this.forceField == memberInfo.forceField && Objects.equal((Object)this.owner, (Object)memberInfo.owner) && Objects.equal((Object)this.name, (Object)memberInfo.name) && Objects.equal((Object)this.desc, (Object)memberInfo.desc);
    }
    
    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[] { this.matchAll, this.owner, this.name, this.desc });
    }
    
    public final MemberInfo move(final String s) {
        if ((s == null && this.owner == null) || (s != null && s.equals(this.owner))) {
            return this;
        }
        return new MemberInfo(this, s);
    }
    
    public final MemberInfo transform$4a531138() {
        if (this.desc == null) {
            return this;
        }
        return new MemberInfo(this.name, this.owner, null, this.matchAll);
    }
    
    private MemberInfo remapUsing$69c9af1b(final MappingMethod mappingMethod) {
        return new MemberInfo(this, mappingMethod);
    }
    
    private static MemberInfo parseAndValidate(final String s) throws InvalidMemberDescriptorException {
        return parse(s, null, null).validate();
    }
    
    public static MemberInfo parseAndValidate(final String s, final IMixinContext mixinContext) throws InvalidMemberDescriptorException {
        return parse(s, mixinContext.getReferenceMapper(), mixinContext.getClassRef()).validate();
    }
    
    public static MemberInfo parse(final String s) {
        return parse(s, null, null);
    }
    
    public static MemberInfo parse(final String s, final IMixinContext mixinContext) {
        return parse(s, mixinContext.getReferenceMapper(), mixinContext.getClassRef());
    }
    
    private static MemberInfo parse(final String s, final IReferenceMapper referenceMapper, final String s2) {
        String s3 = null;
        String s4 = null;
        String s5 = Strings.nullToEmpty(s).replaceAll(MemberInfo.lllIIIIl[49], MemberInfo.lllIIIIl[50]);
        if (referenceMapper != null) {
            s5 = referenceMapper.remap(s2, s5);
        }
        final int lastIndex = s5.lastIndexOf(46);
        final int index = s5.indexOf(59);
        if (lastIndex >= 0) {
            s4 = s5.substring(0, lastIndex).replace('.', '/');
            s5 = s5.substring(lastIndex + 1);
        }
        else if (index >= 0 && s5.startsWith(MemberInfo.lllIIIIl[51])) {
            s4 = s5.substring(1, index).replace('.', '/');
            s5 = s5.substring(index + 1);
        }
        final int index2 = s5.indexOf(40);
        final int index3 = s5.indexOf(58);
        if (index2 >= 0) {
            s3 = s5.substring(index2);
            s5 = s5.substring(0, index2);
        }
        else if (index3 >= 0) {
            s3 = s5.substring(index3 + 1);
            s5 = s5.substring(0, index3);
        }
        if ((s5.indexOf(47) >= 0 || s5.indexOf(46) >= 0) && s4 == null) {
            s4 = s5;
            s5 = MemberInfo.lllIIIIl[52];
        }
        final boolean endsWith;
        if (endsWith = s5.endsWith(MemberInfo.lllIIIIl[53])) {
            s5 = s5.substring(0, s5.length() - 1);
        }
        if (s5.isEmpty()) {
            s5 = null;
        }
        return new MemberInfo(s5, s4, s3, endsWith, s);
    }
    
    public static MemberInfo fromMapping(final IMapping<?> mapping) {
        return new MemberInfo(mapping);
    }
    
    static {
        lIlIIllIlI();
    }
    
    private static void lIlIIllIlI() {
        (lllIIIIl = new String[54])[0] = ".";
        MemberInfo.lllIIIIl[1] = "Attempt to instance a MemberInfo with an invalid owner format";
        MemberInfo.lllIIIIl[2] = "insn must be an instance of MethodInsnNode or FieldInsnNode";
        MemberInfo.lllIIIIl[3] = "L";
        MemberInfo.lllIIIIl[4] = ";";
        MemberInfo.lllIIIIl[5] = "";
        MemberInfo.lllIIIIl[6] = "";
        MemberInfo.lllIIIIl[7] = "*";
        MemberInfo.lllIIIIl[8] = "";
        MemberInfo.lllIIIIl[9] = "";
        MemberInfo.lllIIIIl[10] = "(";
        MemberInfo.lllIIIIl[11] = "";
        MemberInfo.lllIIIIl[12] = ":";
        MemberInfo.lllIIIIl[13] = "";
        MemberInfo.lllIIIIl[14] = "Cannot convert unqualified reference to SRG mapping";
        MemberInfo.lllIIIIl[15] = "(";
        MemberInfo.lllIIIIl[16] = "/";
        MemberInfo.lllIIIIl[17] = " ";
        MemberInfo.lllIIIIl[18] = "/";
        MemberInfo.lllIIIIl[19] = "";
        MemberInfo.lllIIIIl[20] = "(";
        MemberInfo.lllIIIIl[21] = "V";
        MemberInfo.lllIIIIl[22] = "L";
        MemberInfo.lllIIIIl[23] = ";";
        MemberInfo.lllIIIIl[24] = "Cannot convert unqualified reference ";
        MemberInfo.lllIIIIl[25] = " to MethodMapping";
        MemberInfo.lllIIIIl[26] = "Cannot convert a non-method reference ";
        MemberInfo.lllIIIIl[27] = " to MethodMapping";
        MemberInfo.lllIIIIl[28] = "Cannot convert non-field reference ";
        MemberInfo.lllIIIIl[29] = " to FieldMapping";
        MemberInfo.lllIIIIl[30] = "(";
        MemberInfo.lllIIIIl[31] = "<init>";
        MemberInfo.lllIIIIl[32] = "<clinit>";
        MemberInfo.lllIIIIl[33] = "(?i)^[\\w\\p{Sc}/]+$";
        MemberInfo.lllIIIIl[34] = "Invalid owner: ";
        MemberInfo.lllIIIIl[35] = "L";
        MemberInfo.lllIIIIl[36] = "Malformed owner: ";
        MemberInfo.lllIIIIl[37] = " If you are seeing this message unexpectedly and the owner appears to be correct, replace the owner descriptor with formal type L";
        MemberInfo.lllIIIIl[38] = "; to suppress this error";
        MemberInfo.lllIIIIl[39] = "(?i)^<?[\\w\\p{Sc}]+>?$";
        MemberInfo.lllIIIIl[40] = "Invalid name: ";
        MemberInfo.lllIIIIl[41] = "^(\\([\\w\\p{Sc}\\[/;]*\\))?\\[*[\\w\\p{Sc}/;]+$";
        MemberInfo.lllIIIIl[42] = "Invalid descriptor: ";
        MemberInfo.lllIIIIl[43] = "Invalid field type in descriptor: ";
        MemberInfo.lllIIIIl[44] = "Invalid descriptor: ";
        MemberInfo.lllIIIIl[45] = "Invalid return type \"";
        MemberInfo.lllIIIIl[46] = "\" in descriptor: ";
        MemberInfo.lllIIIIl[47] = "Invalid return type \"";
        MemberInfo.lllIIIIl[48] = "\" in descriptor: ";
        MemberInfo.lllIIIIl[49] = "\\s";
        MemberInfo.lllIIIIl[50] = "";
        MemberInfo.lllIIIIl[51] = "L";
        MemberInfo.lllIIIIl[52] = "";
        MemberInfo.lllIIIIl[53] = "*";
    }
    
    private static String lIlIIIlIII(final String s, final String s2) {
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
    
    private static String lIlIIIlIIl(final String s, final String s2) {
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
    
    private static String lIlIIIllII(String s, final String s2) {
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
    
    private static boolean lIllIlIIlI$255f299(final int n) {
        return n < 0;
    }
    
    private static boolean lIllIIllIl$255f299(final int n) {
        return n >= 0;
    }
    
    private static boolean lIllIlIIII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIllIIlIlI(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIllIIllll(final int n) {
        return n > 0;
    }
    
    private static boolean lIllIIlllI$255f299(final int n) {
        return n != -1;
    }
}
