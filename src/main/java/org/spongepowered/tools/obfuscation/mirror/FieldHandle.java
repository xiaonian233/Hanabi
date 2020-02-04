package org.spongepowered.tools.obfuscation.mirror;

import org.spongepowered.asm.obfuscation.mapping.common.*;
import javax.lang.model.element.*;
import com.google.common.base.*;
import org.spongepowered.asm.obfuscation.mapping.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class FieldHandle extends MemberHandle<MappingField>
{
    private final VariableElement element;
    private final boolean rawType;
    private static final String[] llIIllll;
    
    public FieldHandle(final TypeElement typeElement, final VariableElement variableElement) {
        this(TypeUtils.getInternalName(typeElement), variableElement);
    }
    
    private FieldHandle(final String s, final VariableElement variableElement) {
        this(s, variableElement, false);
    }
    
    public FieldHandle(final TypeElement typeElement, final VariableElement variableElement, final byte b) {
        this(TypeUtils.getInternalName(typeElement), variableElement, true);
    }
    
    private FieldHandle(final String s, final VariableElement variableElement, final boolean b) {
        this(s, variableElement, b, TypeUtils.getName(variableElement), TypeUtils.getInternalName(variableElement));
    }
    
    public FieldHandle(final String s, final String s2, final String s3) {
        this(s, null, false, s2, s3);
    }
    
    private FieldHandle(final String s, final VariableElement element, final boolean rawType, final String s2, final String s3) {
        super(s, s2, s3);
        this.element = element;
        this.rawType = rawType;
    }
    
    private boolean isImaginary() {
        return this.element == null;
    }
    
    private VariableElement getElement() {
        return this.element;
    }
    
    @Override
    public final Visibility getVisibility() {
        return TypeUtils.getVisibility(this.element);
    }
    
    private boolean isRawType() {
        return this.rawType;
    }
    
    @Override
    public final MappingField asMapping(final boolean b) {
        return new MappingField(b ? this.getOwner() : null, super.name, this.getDesc());
    }
    
    @Override
    public final String toString() {
        return String.format(FieldHandle.llIIllll[3], (this.getOwner() != null) ? String.valueOf(new StringBuilder().append(FieldHandle.llIIllll[0]).append(this.getOwner()).append(FieldHandle.llIIllll[1])) : FieldHandle.llIIllll[2], Strings.nullToEmpty(super.name), Strings.nullToEmpty(this.getDesc()));
    }
    
    @Override
    public final /* bridge */ IMapping asMapping(final boolean b) {
        return this.asMapping(b);
    }
    
    static {
        lIIlIllIll();
    }
    
    private static void lIIlIllIll() {
        (llIIllll = new String[4])[0] = "L";
        FieldHandle.llIIllll[1] = ";";
        FieldHandle.llIIllll[2] = "";
        FieldHandle.llIIllll[3] = "%s%s:%s";
    }
    
    private static String lIIlIllIlI(final String s, final String s2) {
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
    
    private static String lIIlIlIIll(final String s, final String s2) {
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
