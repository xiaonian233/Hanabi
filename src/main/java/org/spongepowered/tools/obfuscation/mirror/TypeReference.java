package org.spongepowered.tools.obfuscation.mirror;

import java.io.*;
import javax.annotation.processing.*;
import javax.lang.model.element.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class TypeReference implements Serializable, Comparable<TypeReference>
{
    private static final long serialVersionUID = 1L;
    private final String name;
    private transient TypeHandle handle;
    private static final String[] llIIlllIIll;
    
    public TypeReference(final TypeHandle handle) {
        super();
        this.name = handle.name;
        this.handle = handle;
    }
    
    public TypeReference(final String name) {
        super();
        this.name = name;
    }
    
    private String getName() {
        return this.name;
    }
    
    private String getClassName() {
        return this.name.replace('/', '.');
    }
    
    public final TypeHandle getHandle(final ProcessingEnvironment processingEnvironment) {
        if (this.handle == null) {
            final TypeElement typeElement = processingEnvironment.getElementUtils().getTypeElement(this.name.replace('/', '.'));
            try {
                this.handle = new TypeHandle(typeElement);
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return this.handle;
    }
    
    @Override
    public final String toString() {
        return String.format(TypeReference.llIIlllIIll[0], this.name);
    }
    
    private int compareTo(final TypeReference typeReference) {
        if (typeReference == null) {
            return -1;
        }
        return this.name.compareTo(typeReference.name);
    }
    
    @Override
    public final boolean equals(final Object o) {
        return o instanceof TypeReference && this.compareTo((TypeReference)o) == 0;
    }
    
    @Override
    public final int hashCode() {
        return this.name.hashCode();
    }
    
    @Override
    public final /* bridge */ int compareTo(final Object o) {
        return this.compareTo((TypeReference)o);
    }
    
    static {
        lIIIllllIlllI();
    }
    
    private static void lIIIllllIlllI() {
        (llIIlllIIll = new String[] { null })[0] = "TypeReference[%s]";
    }
    
    private static String lIIIllllIllII(final String s, final String s2) {
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
}
