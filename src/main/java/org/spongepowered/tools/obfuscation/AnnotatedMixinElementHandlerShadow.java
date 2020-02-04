package org.spongepowered.tools.obfuscation;

import org.spongepowered.asm.obfuscation.mapping.*;
import javax.tools.*;
import javax.annotation.processing.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import org.spongepowered.tools.obfuscation.interfaces.*;
import javax.lang.model.element.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;

final class AnnotatedMixinElementHandlerShadow extends AnnotatedMixinElementHandler
{
    private static final String[] lIlIIlIlIll;
    
    AnnotatedMixinElementHandlerShadow(final IMixinAnnotationProcessor mixinAnnotationProcessor, final AnnotatedMixin annotatedMixin) {
        super(mixinAnnotationProcessor, annotatedMixin);
    }
    
    public final void registerShadow(final AnnotatedElementShadow<?, ?> annotatedElementShadow) {
        this.validateTarget(annotatedElementShadow.getElement(), annotatedElementShadow.getAnnotation(), annotatedElementShadow.name, AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[0]);
        if (!annotatedElementShadow.shouldRemap) {
            return;
        }
        for (final TypeHandle typeHandle : this.mixin.targets) {
            final ObfuscationData<IMapping<?>> obfEntry;
            if ((obfEntry = this.obf.getDataProvider().getObfEntry((IMapping<IMapping<?>>)annotatedElementShadow.getMapping(typeHandle, annotatedElementShadow.name.toString(), annotatedElementShadow.desc))).isEmpty()) {
                final String s = this.mixin.isMultiTarget() ? String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[1]).append(typeHandle)) : AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[2];
                if (typeHandle.isSimulated()) {
                    annotatedElementShadow.printMessage(this.ap, Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[3]).append(s).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[4]).append(annotatedElementShadow)));
                }
                else {
                    annotatedElementShadow.printMessage(this.ap, Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[5]).append(s).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[6]).append(annotatedElementShadow)));
                }
            }
            else {
                for (final ObfuscationType obfuscationType : obfEntry) {
                    final ObfuscationData<IMapping<?>> obfuscationData = obfEntry;
                    final ObfuscationType obfuscationType2 = obfuscationType;
                    try {
                        annotatedElementShadow.addMapping(obfuscationType, obfuscationData.get(obfuscationType2));
                    }
                    catch (Mappings.MappingConflictException ex) {
                        annotatedElementShadow.printMessage(this.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[7]).append(annotatedElementShadow).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[8]).append(ex.newMapping.getSimpleName()).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[9]).append(typeHandle).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[10]).append(ex.oldMapping.getSimpleName())));
                    }
                }
            }
        }
    }
    
    private void registerShadowForTarget(final AnnotatedElementShadow<?, ?> annotatedElementShadow, final TypeHandle typeHandle) {
        final ObfuscationData<IMapping<?>> obfEntry;
        if (!(obfEntry = this.obf.getDataProvider().getObfEntry((IMapping<IMapping<?>>)annotatedElementShadow.getMapping(typeHandle, annotatedElementShadow.name.toString(), annotatedElementShadow.desc))).isEmpty()) {
            for (final ObfuscationType obfuscationType : obfEntry) {
                final ObfuscationData<IMapping<?>> obfuscationData = obfEntry;
                final ObfuscationType obfuscationType2 = obfuscationType;
                try {
                    annotatedElementShadow.addMapping(obfuscationType, obfuscationData.get(obfuscationType2));
                }
                catch (Mappings.MappingConflictException ex) {
                    annotatedElementShadow.printMessage(this.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[7]).append(annotatedElementShadow).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[8]).append(ex.newMapping.getSimpleName()).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[9]).append(typeHandle).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[10]).append(ex.oldMapping.getSimpleName())));
                }
            }
            return;
        }
        final String s = this.mixin.isMultiTarget() ? String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[1]).append(typeHandle)) : AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[2];
        if (typeHandle.isSimulated()) {
            annotatedElementShadow.printMessage(this.ap, Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[3]).append(s).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[4]).append(annotatedElementShadow)));
            return;
        }
        annotatedElementShadow.printMessage(this.ap, Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[5]).append(s).append(AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[6]).append(annotatedElementShadow)));
    }
    
    static {
        lllIIllIIlIl();
    }
    
    private static void lllIIllIIlIl() {
        (lIlIIlIlIll = new String[11])[0] = "@Shadow";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[1] = " in target ";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[2] = "";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[3] = "Unable to locate obfuscation mapping";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[4] = " for @Shadow ";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[5] = "Unable to locate obfuscation mapping";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[6] = " for @Shadow ";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[7] = "Mapping conflict for @Shadow ";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[8] = ": ";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[9] = " for target ";
        AnnotatedMixinElementHandlerShadow.lIlIIlIlIll[10] = " conflicts with existing mapping ";
    }
    
    private static String lllIIllIIlII(final String s, final String s2) {
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
    
    private static String lllIIllIIIll(String s, final String s2) {
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
    
    private static String lllIIllIIIIl(final String s, final String s2) {
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
