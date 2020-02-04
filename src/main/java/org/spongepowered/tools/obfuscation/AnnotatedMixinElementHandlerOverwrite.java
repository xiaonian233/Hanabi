package org.spongepowered.tools.obfuscation;

import org.spongepowered.tools.obfuscation.interfaces.*;
import javax.lang.model.element.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import javax.tools.*;
import javax.annotation.processing.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

final class AnnotatedMixinElementHandlerOverwrite extends AnnotatedMixinElementHandler
{
    private static final String[] llIllllIIll;
    
    AnnotatedMixinElementHandlerOverwrite(final IMixinAnnotationProcessor mixinAnnotationProcessor, final AnnotatedMixin annotatedMixin) {
        super(mixinAnnotationProcessor, annotatedMixin);
    }
    
    public final void registerMerge(final ExecutableElement executableElement) {
        this.validateTargetMethod(executableElement, null, new AliasedElementName(executableElement, AnnotationHandle.MISSING), AnnotatedMixinElementHandlerOverwrite.llIllllIIll[0], true, true);
    }
    
    public final void registerOverwrite(final AnnotatedElementOverwrite annotatedElementOverwrite) {
        this.validateTargetMethod(annotatedElementOverwrite.getElement(), annotatedElementOverwrite.getAnnotation(), new AliasedElementName(((AnnotatedElement<Element>)annotatedElementOverwrite).getElement(), annotatedElementOverwrite.getAnnotation()), AnnotatedMixinElementHandlerOverwrite.llIllllIIll[1], true, false);
        this.checkConstraints(annotatedElementOverwrite.getElement(), annotatedElementOverwrite.getAnnotation());
        if (annotatedElementOverwrite.shouldRemap) {
            final Iterator<TypeHandle> iterator = this.mixin.targets.iterator();
            while (iterator.hasNext()) {
                if (!this.registerOverwriteForTarget(annotatedElementOverwrite, iterator.next())) {
                    return;
                }
            }
        }
        if (!AnnotatedMixinElementHandlerOverwrite.llIllllIIll[2].equalsIgnoreCase(this.ap.getOption(AnnotatedMixinElementHandlerOverwrite.llIllllIIll[3]))) {
            final Diagnostic.Kind kind = AnnotatedMixinElementHandlerOverwrite.llIllllIIll[4].equalsIgnoreCase(this.ap.getOption(AnnotatedMixinElementHandlerOverwrite.llIllllIIll[5])) ? Diagnostic.Kind.ERROR : Diagnostic.Kind.WARNING;
            final String javadoc;
            if ((javadoc = this.ap.getJavadocProvider().getJavadoc(((AnnotatedElement<Element>)annotatedElementOverwrite).getElement())) == null) {
                this.ap.printMessage(kind, AnnotatedMixinElementHandlerOverwrite.llIllllIIll[6], ((AnnotatedElement<Element>)annotatedElementOverwrite).getElement());
                return;
            }
            if (!javadoc.toLowerCase().contains(AnnotatedMixinElementHandlerOverwrite.llIllllIIll[7])) {
                this.ap.printMessage(kind, AnnotatedMixinElementHandlerOverwrite.llIllllIIll[8], ((AnnotatedElement<Element>)annotatedElementOverwrite).getElement());
            }
            if (!javadoc.toLowerCase().contains(AnnotatedMixinElementHandlerOverwrite.llIllllIIll[9])) {
                this.ap.printMessage(kind, AnnotatedMixinElementHandlerOverwrite.llIllllIIll[10], ((AnnotatedElement<Element>)annotatedElementOverwrite).getElement());
            }
        }
    }
    
    private boolean registerOverwriteForTarget(final AnnotatedElementOverwrite annotatedElementOverwrite, final TypeHandle typeHandle) {
        final ObfuscationData<MappingMethod> obfMethod;
        if ((obfMethod = this.obf.getDataProvider().getObfMethod(typeHandle.getMappingMethod(annotatedElementOverwrite.getSimpleName(), ((AnnotatedElement)annotatedElementOverwrite).desc))).isEmpty()) {
            Diagnostic.Kind kind = Diagnostic.Kind.ERROR;
            try {
                if (annotatedElementOverwrite.getElement().getClass().getMethod(AnnotatedMixinElementHandlerOverwrite.llIllllIIll[11], (Class<?>[])new Class[0]).invoke(((AnnotatedElement<Object>)annotatedElementOverwrite).getElement(), new Object[0])) {
                    kind = Diagnostic.Kind.WARNING;
                }
            }
            catch (Exception ex2) {}
            this.ap.printMessage(kind, AnnotatedMixinElementHandlerOverwrite.llIllllIIll[12], ((AnnotatedElement<Element>)annotatedElementOverwrite).getElement());
            return false;
        }
        try {
            this.addMethodMappings(annotatedElementOverwrite.getSimpleName(), ((AnnotatedElement)annotatedElementOverwrite).desc, obfMethod);
            return true;
        }
        catch (Mappings.MappingConflictException ex) {
            annotatedElementOverwrite.printMessage(this.ap, Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerOverwrite.llIllllIIll[13]).append(ex.newMapping.getSimpleName()).append(AnnotatedMixinElementHandlerOverwrite.llIllllIIll[14]).append(typeHandle).append(AnnotatedMixinElementHandlerOverwrite.llIllllIIll[15]).append(ex.oldMapping.getSimpleName())));
            return false;
        }
    }
    
    static {
        lIIllIlIlllII();
    }
    
    private static void lIIllIlIlllII() {
        (llIllllIIll = new String[16])[0] = "overwrite";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[1] = "@Overwrite";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[2] = "true";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[3] = "disableOverwriteChecker";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[4] = "error";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[5] = "overwriteErrorLevel";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[6] = "@Overwrite is missing javadoc comment";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[7] = "@author";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[8] = "@Overwrite is missing an @author tag";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[9] = "@reason";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[10] = "@Overwrite is missing an @reason tag";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[11] = "isStatic";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[12] = "No obfuscation mapping for @Overwrite method";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[13] = "Mapping conflict for @Overwrite method: ";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[14] = " for target ";
        AnnotatedMixinElementHandlerOverwrite.llIllllIIll[15] = " conflicts with existing mapping ";
    }
    
    private static String lIIllIlIllIlI(String s, final String s2) {
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
    
    private static String lIIllIlIlIllI(final String s, final String s2) {
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
    
    private static String lIIllIlIllIII(final String s, final String s2) {
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
