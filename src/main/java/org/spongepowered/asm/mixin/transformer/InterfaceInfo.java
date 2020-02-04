package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.transformer.throwables.*;
import org.spongepowered.asm.mixin.extensibility.*;
import org.spongepowered.asm.mixin.transformer.meta.*;
import org.spongepowered.asm.util.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.lib.tree.*;
import java.util.*;

public final class InterfaceInfo
{
    private final MixinInfo mixin;
    private final String prefix;
    final Type iface;
    private final boolean unique;
    private Set<String> methods;
    private static final String[] llIlIlllIIl;
    
    private InterfaceInfo(final MixinInfo mixin, final String prefix, final Type iface, final boolean unique) {
        super();
        if (prefix == null || prefix.length() < 2 || !prefix.endsWith(InterfaceInfo.llIlIlllIIl[0])) {
            throw new InvalidMixinException(mixin, String.format(InterfaceInfo.llIlIlllIIl[1], prefix, iface.toString()));
        }
        this.mixin = mixin;
        this.prefix = prefix;
        this.iface = iface;
        this.unique = unique;
    }
    
    private void initMethods() {
        this.methods = new HashSet<String>();
        this.readInterface(this.iface.getInternalName());
    }
    
    private void readInterface(final String s) {
        final ClassInfo forName;
        final Iterator<ClassInfo.Method> iterator = Collections.unmodifiableSet((Set<? extends ClassInfo.Method>)(forName = ClassInfo.forName(s)).methods).iterator();
        while (iterator.hasNext()) {
            this.methods.add(iterator.next().toString());
        }
        final Iterator<String> iterator2 = Collections.unmodifiableSet((Set<? extends String>)forName.interfaces).iterator();
        while (iterator2.hasNext()) {
            this.readInterface(iterator2.next());
        }
    }
    
    private String getPrefix() {
        return this.prefix;
    }
    
    private Type getIface() {
        return this.iface;
    }
    
    private String getName() {
        return this.iface.getClassName();
    }
    
    private String getInternalName() {
        return this.iface.getInternalName();
    }
    
    private boolean isUnique() {
        return this.unique;
    }
    
    public final boolean renameMethod(final MethodNode methodNode) {
        if (this.methods == null) {
            this.methods = new HashSet<String>();
            this.readInterface(this.iface.getInternalName());
        }
        if (!methodNode.name.startsWith(this.prefix)) {
            if (this.methods.contains(String.valueOf(new StringBuilder().append(methodNode.name).append(methodNode.desc)))) {
                this.decorateUniqueMethod(methodNode);
            }
            return false;
        }
        final String substring = methodNode.name.substring(this.prefix.length());
        if (!this.methods.contains(String.valueOf(new StringBuilder().append(substring).append(methodNode.desc)))) {
            throw new InvalidMixinException(this.mixin, String.format(InterfaceInfo.llIlIlllIIl[2], substring, this.getName()));
        }
        if ((methodNode.access & 0x1) == 0x0) {
            throw new InvalidMixinException(this.mixin, String.format(InterfaceInfo.llIlIlllIIl[3], substring, this.getName()));
        }
        Annotations.setVisible(methodNode, MixinRenamed.class, InterfaceInfo.llIlIlllIIl[4], methodNode.name, InterfaceInfo.llIlIlllIIl[5], Boolean.TRUE);
        this.decorateUniqueMethod(methodNode);
        methodNode.name = substring;
        return true;
    }
    
    private void decorateUniqueMethod(final MethodNode methodNode) {
        if (!this.unique) {
            return;
        }
        if (Annotations.getVisible(methodNode, Unique.class) == null) {
            Annotations.setVisible(methodNode, Unique.class, new Object[0]);
            this.mixin.info.findMethod(methodNode).setUnique(true);
        }
    }
    
    static InterfaceInfo fromAnnotation(final MixinInfo mixinInfo, final AnnotationNode annotationNode) {
        final String s = Annotations.getValue(annotationNode, InterfaceInfo.llIlIlllIIl[6]);
        final Type type = Annotations.getValue(annotationNode, InterfaceInfo.llIlIlllIIl[7]);
        final Boolean b = Annotations.getValue(annotationNode, InterfaceInfo.llIlIlllIIl[8]);
        if (s == null || type == null) {
            throw new InvalidMixinException(mixinInfo, String.format(InterfaceInfo.llIlIlllIIl[9], mixinInfo));
        }
        return new InterfaceInfo(mixinInfo, s, type, b != null && b);
    }
    
    @Override
    public final boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }
        final InterfaceInfo interfaceInfo = (InterfaceInfo)o;
        return this.mixin.equals(interfaceInfo.mixin) && this.prefix.equals(interfaceInfo.prefix) && this.iface.equals(interfaceInfo.iface);
    }
    
    @Override
    public final int hashCode() {
        return (this.mixin.hashCode() * 31 + this.prefix.hashCode()) * 31 + this.iface.hashCode();
    }
    
    static {
        lIIlIlIIlllIl();
    }
    
    private static void lIIlIlIIlllIl() {
        (llIlIlllIIl = new String[10])[0] = "$";
        InterfaceInfo.llIlIlllIIl[1] = "Prefix %s for iface %s is not valid";
        InterfaceInfo.llIlIlllIIl[2] = "%s does not exist in target interface %s";
        InterfaceInfo.llIlIlllIIl[3] = "%s cannot implement %s because it is not visible";
        InterfaceInfo.llIlIlllIIl[4] = "originalName";
        InterfaceInfo.llIlIlllIIl[5] = "isInterfaceMember";
        InterfaceInfo.llIlIlllIIl[6] = "prefix";
        InterfaceInfo.llIlIlllIIl[7] = "iface";
        InterfaceInfo.llIlIlllIIl[8] = "unique";
        InterfaceInfo.llIlIlllIIl[9] = "@Interface annotation on %s is missing a required parameter";
    }
    
    private static String lIIlIlIIlllII(final String s, final String s2) {
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
    
    private static String lIIlIlIIllIII(final String s, final String s2) {
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
    
    private static String lIIlIlIIllIll(String s, final String s2) {
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
    
    private static boolean lIIlIlIlIIIIl$255f299(final int n) {
        return n >= 2;
    }
    
    private static boolean lIIlIlIlIIlll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIlIlIlIIllI(final Object o, final Object o2) {
        return o == o2;
    }
}
