package org.spongepowered.asm.mixin.injection.modify;

import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;
import org.spongepowered.asm.util.*;

public final class LocalVariableDiscriminator
{
    final boolean argsOnly;
    final int ordinal;
    final int index;
    final Set<String> names;
    final boolean print;
    private static final String[] llIIIllIIlI;
    
    private LocalVariableDiscriminator(final boolean argsOnly, final int ordinal, final int index, final Set<String> set, final boolean print) {
        super();
        this.argsOnly = argsOnly;
        this.ordinal = ordinal;
        this.index = index;
        this.names = Collections.unmodifiableSet((Set<? extends String>)set);
        this.print = print;
    }
    
    private boolean isArgsOnly() {
        return this.argsOnly;
    }
    
    private int getOrdinal() {
        return this.ordinal;
    }
    
    private int getIndex() {
        return this.index;
    }
    
    private Set<String> getNames() {
        return this.names;
    }
    
    public final boolean hasNames() {
        return !this.names.isEmpty();
    }
    
    private boolean printLVT() {
        return this.print;
    }
    
    protected final boolean isImplicit(final Context context) {
        return this.ordinal < 0 && this.index < context.baseArgIndex && this.names.isEmpty();
    }
    
    public final int findLocal(final Type type, final boolean b, final Target target, final AbstractInsnNode abstractInsnNode) {
        try {
            return this.findLocal(new Context(type, b, target, abstractInsnNode));
        }
        catch (InvalidImplicitDiscriminatorException ex) {
            return -2;
        }
    }
    
    public final int findLocal(final Context context) {
        if (!this.isImplicit(context)) {
            return this.findExplicitLocal(context);
        }
        int n = 0;
        int n2 = 0;
        for (int i = context.baseArgIndex; i < context.locals.length; ++i) {
            final Context.Local local;
            if ((local = context.locals[i]) != null && local.type.equals(context.returnType)) {
                ++n2;
                n = i;
            }
        }
        if (n2 == 1) {
            return n;
        }
        throw new InvalidImplicitDiscriminatorException(String.valueOf(new StringBuilder().append(LocalVariableDiscriminator.llIIIllIIlI[0]).append(n2).append(LocalVariableDiscriminator.llIIIllIIlI[1])));
    }
    
    private static int findImplicitLocal(final Context context) {
        int n = 0;
        int n2 = 0;
        for (int i = context.baseArgIndex; i < context.locals.length; ++i) {
            final Context.Local local;
            if ((local = context.locals[i]) != null && local.type.equals(context.returnType)) {
                ++n2;
                n = i;
            }
        }
        if (n2 == 1) {
            return n;
        }
        throw new InvalidImplicitDiscriminatorException(String.valueOf(new StringBuilder().append(LocalVariableDiscriminator.llIIIllIIlI[0]).append(n2).append(LocalVariableDiscriminator.llIIIllIIlI[1])));
    }
    
    private int findExplicitLocal(final Context context) {
        for (int i = context.baseArgIndex; i < context.locals.length; ++i) {
            final Context.Local local;
            if ((local = context.locals[i]) != null && local.type.equals(context.returnType)) {
                if (this.ordinal >= 0) {
                    if (this.ordinal == local.ord) {
                        return i;
                    }
                }
                else if (this.index >= context.baseArgIndex) {
                    if (this.index == i) {
                        return i;
                    }
                }
                else if (this.names.contains(local.name)) {
                    return i;
                }
            }
        }
        return -1;
    }
    
    public static LocalVariableDiscriminator parse(final AnnotationNode annotationNode) {
        final boolean booleanValue = Annotations.getValue(annotationNode, LocalVariableDiscriminator.llIIIllIIlI[2], Boolean.FALSE);
        final int intValue = Annotations.getValue(annotationNode, LocalVariableDiscriminator.llIIIllIIlI[3], Integer.valueOf(-1));
        final int intValue2 = Annotations.getValue(annotationNode, LocalVariableDiscriminator.llIIIllIIlI[4], Integer.valueOf(-1));
        final boolean booleanValue2 = Annotations.getValue(annotationNode, LocalVariableDiscriminator.llIIIllIIlI[5], Boolean.FALSE);
        final HashSet<Object> set = new HashSet<Object>();
        final List<? extends String> list;
        if ((list = Annotations.getValue(annotationNode, LocalVariableDiscriminator.llIIIllIIlI[6], (List<? extends String>)null)) != null) {
            set.addAll(list);
        }
        return new LocalVariableDiscriminator(booleanValue, intValue, intValue2, (Set<String>)set, booleanValue2);
    }
    
    static {
        lIIIlIIlIIIII();
    }
    
    private static void lIIIlIIlIIIII() {
        (llIIIllIIlI = new String[7])[0] = "Found ";
        LocalVariableDiscriminator.llIIIllIIlI[1] = " candidate variables but exactly 1 is required.";
        LocalVariableDiscriminator.llIIIllIIlI[2] = "argsOnly";
        LocalVariableDiscriminator.llIIIllIIlI[3] = "ordinal";
        LocalVariableDiscriminator.llIIIllIIlI[4] = "index";
        LocalVariableDiscriminator.llIIIllIIlI[5] = "print";
        LocalVariableDiscriminator.llIIIllIIlI[6] = "name";
    }
    
    private static String lIIIlIIIlIlll(final String s, final String s2) {
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
    
    private static String lIIIlIIIlllII(String s, final String s2) {
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
    
    private static String lIIIlIIIllIII(final String s, final String s2) {
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
    
    private static boolean lIIIlIIlIllll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIIlIIlIlllI$255f299(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIIlIIlIlIIl(final int n) {
        return n < 0;
    }
}
