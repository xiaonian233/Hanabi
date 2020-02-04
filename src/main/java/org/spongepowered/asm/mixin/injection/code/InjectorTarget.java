package org.spongepowered.asm.mixin.injection.code;

import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.mixin.transformer.meta.*;
import org.spongepowered.asm.util.*;
import java.lang.annotation.*;
import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.mixin.injection.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class InjectorTarget
{
    final ISliceContext context;
    public final Map<String, ReadOnlyInsnList> cache;
    final Target target;
    final String mergedBy;
    final int mergedPriority;
    private static final String[] lIIIllllI;
    
    public InjectorTarget(final ISliceContext context, final Target target) {
        super();
        this.cache = new HashMap<String, ReadOnlyInsnList>();
        this.context = context;
        this.target = target;
        final AnnotationNode visible = Annotations.getVisible(target.method, MixinMerged.class);
        this.mergedBy = (String)Annotations.getValue(visible, InjectorTarget.lIIIllllI[0]);
        this.mergedPriority = Annotations.getValue(visible, InjectorTarget.lIIIllllI[1], Integer.valueOf(1000));
    }
    
    @Override
    public final String toString() {
        return this.target.toString();
    }
    
    private Target getTarget() {
        return this.target;
    }
    
    private MethodNode getMethod() {
        return this.target.method;
    }
    
    private boolean isMerged() {
        return this.mergedBy != null;
    }
    
    private String getMergedBy() {
        return this.mergedBy;
    }
    
    private int getMergedPriority() {
        return this.mergedPriority;
    }
    
    private InsnList getSlice(final String s) {
        ReadOnlyInsnList slice;
        if ((slice = this.cache.get(s)) == null) {
            final MethodSlice slice2;
            if ((slice2 = this.context.getSlice(s)) != null) {
                slice = slice2.getSlice(this.target.method);
            }
            else {
                slice = new ReadOnlyInsnList(this.target.method.instructions);
            }
            this.cache.put(s, slice);
        }
        return slice;
    }
    
    private InsnList getSlice(final InjectionPoint injectionPoint) {
        final String slice = injectionPoint.slice;
        ReadOnlyInsnList slice2;
        if ((slice2 = this.cache.get(slice)) == null) {
            final MethodSlice slice3;
            if ((slice3 = this.context.getSlice(slice)) != null) {
                slice2 = slice3.getSlice(this.target.method);
            }
            else {
                slice2 = new ReadOnlyInsnList(this.target.method.instructions);
            }
            this.cache.put(slice, slice2);
        }
        return slice2;
    }
    
    private void dispose() {
        final Iterator<ReadOnlyInsnList> iterator = this.cache.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().insnList = null;
        }
        this.cache.clear();
    }
    
    static {
        llIIIlIllI();
    }
    
    private static void llIIIlIllI() {
        (lIIIllllI = new String[2])[0] = "mixin";
        InjectorTarget.lIIIllllI[1] = "priority";
    }
    
    private static String llIIIlIIll(final String s, final String s2) {
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
