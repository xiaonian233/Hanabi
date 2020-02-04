package org.spongepowered.tools.obfuscation;

import javax.annotation.processing.*;
import java.lang.annotation.*;
import javax.tools.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import javax.lang.model.element.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.asm.mixin.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

@SupportedAnnotationTypes({ "org.spongepowered.asm.mixin.Mixin", "org.spongepowered.asm.mixin.Shadow", "org.spongepowered.asm.mixin.Overwrite", "org.spongepowered.asm.mixin.gen.Accessor", "org.spongepowered.asm.mixin.Implements" })
public final class MixinObfuscationProcessorTargets extends MixinObfuscationProcessor
{
    private static final String[] llIIIlIIlI;
    
    public MixinObfuscationProcessorTargets() {
        super();
    }
    
    @Override
    public final boolean process(final Set<? extends TypeElement> set, final RoundEnvironment roundEnvironment) {
        if (roundEnvironment.processingOver()) {
            this.postProcess(roundEnvironment);
            return true;
        }
        this.processMixins(roundEnvironment);
        final Iterator<? extends Element> iterator = roundEnvironment.getElementsAnnotatedWith(Shadow.class).iterator();
        while (iterator.hasNext()) {
            final ExecutableElement executableElement;
            final Element enclosingElement;
            if (!((enclosingElement = (executableElement = (ExecutableElement)iterator.next()).getEnclosingElement()) instanceof TypeElement)) {
                this.mixins.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(MixinObfuscationProcessorTargets.llIIIlIIlI[0]).append(TypeUtils.getElementType(enclosingElement))), executableElement);
            }
            else {
                final AnnotationHandle of = AnnotationHandle.of(executableElement, Shadow.class);
                if (lIIIllllIllI(executableElement.getKind(), ElementKind.FIELD)) {
                    this.mixins.registerShadow((TypeElement)enclosingElement, (VariableElement)executableElement, of);
                }
                else if (lIIIllllIllI(executableElement.getKind(), ElementKind.METHOD)) {
                    this.mixins.registerShadow((TypeElement)enclosingElement, executableElement, of);
                }
                else {
                    this.mixins.printMessage(Diagnostic.Kind.ERROR, MixinObfuscationProcessorTargets.llIIIlIIlI[1], executableElement);
                }
            }
        }
        this.processOverwrites(roundEnvironment);
        this.processAccessors(roundEnvironment);
        this.processInvokers(roundEnvironment);
        this.processImplements(roundEnvironment);
        this.postProcess(roundEnvironment);
        return true;
    }
    
    @Override
    protected final void postProcess(final RoundEnvironment roundEnvironment) {
        super.postProcess(roundEnvironment);
        try {
            this.mixins.writeReferences();
            this.mixins.writeMappings();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void processShadows(final RoundEnvironment roundEnvironment) {
        final Iterator<? extends Element> iterator = roundEnvironment.getElementsAnnotatedWith(Shadow.class).iterator();
        while (iterator.hasNext()) {
            final ExecutableElement executableElement;
            final Element enclosingElement;
            if (!((enclosingElement = (executableElement = (ExecutableElement)iterator.next()).getEnclosingElement()) instanceof TypeElement)) {
                this.mixins.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(MixinObfuscationProcessorTargets.llIIIlIIlI[0]).append(TypeUtils.getElementType(enclosingElement))), executableElement);
            }
            else {
                final AnnotationHandle of = AnnotationHandle.of(executableElement, Shadow.class);
                if (lIIIllllIllI(executableElement.getKind(), ElementKind.FIELD)) {
                    this.mixins.registerShadow((TypeElement)enclosingElement, (VariableElement)executableElement, of);
                }
                else if (lIIIllllIllI(executableElement.getKind(), ElementKind.METHOD)) {
                    this.mixins.registerShadow((TypeElement)enclosingElement, executableElement, of);
                }
                else {
                    this.mixins.printMessage(Diagnostic.Kind.ERROR, MixinObfuscationProcessorTargets.llIIIlIIlI[1], executableElement);
                }
            }
        }
    }
    
    private void processOverwrites(final RoundEnvironment roundEnvironment) {
        final Iterator<? extends Element> iterator = roundEnvironment.getElementsAnnotatedWith(Overwrite.class).iterator();
        while (iterator.hasNext()) {
            final ExecutableElement executableElement;
            final Element enclosingElement;
            if (!((enclosingElement = (executableElement = (ExecutableElement)iterator.next()).getEnclosingElement()) instanceof TypeElement)) {
                this.mixins.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(MixinObfuscationProcessorTargets.llIIIlIIlI[2]).append(TypeUtils.getElementType(enclosingElement))), executableElement);
            }
            else if (lIIIllllIllI(executableElement.getKind(), ElementKind.METHOD)) {
                final AnnotatedMixins mixins = this.mixins;
                final TypeElement typeElement = (TypeElement)enclosingElement;
                final ExecutableElement executableElement2 = executableElement;
                final TypeElement typeElement2 = typeElement;
                final AnnotatedMixins annotatedMixins = mixins;
                final AnnotatedMixin mixin;
                if ((mixin = mixins.getMixin(typeElement2)) == null) {
                    annotatedMixins.printMessage(Diagnostic.Kind.ERROR, AnnotatedMixins.lIIllIlIlI[15], executableElement2);
                }
                else {
                    final AnnotationHandle of = AnnotationHandle.of(executableElement2, Overwrite.class);
                    final AnnotatedMixin annotatedMixin = mixin;
                    final ExecutableElement executableElement3 = executableElement2;
                    final AnnotationHandle annotationHandle = of;
                    final boolean shouldRemap = AnnotatedMixins.shouldRemap(mixin, of);
                    final AnnotationHandle annotationHandle2 = annotationHandle;
                    final ExecutableElement executableElement4 = executableElement3;
                    final AnnotatedMixin annotatedMixin2 = annotatedMixin;
                    annotatedMixin.methods.remove(executableElement4);
                    annotatedMixin2.overwrites.registerOverwrite(new AnnotatedMixinElementHandlerOverwrite.AnnotatedElementOverwrite(executableElement4, annotationHandle2, shouldRemap));
                }
            }
            else {
                this.mixins.printMessage(Diagnostic.Kind.ERROR, MixinObfuscationProcessorTargets.llIIIlIIlI[3], executableElement);
            }
        }
    }
    
    private void processAccessors(final RoundEnvironment roundEnvironment) {
        final Iterator<? extends Element> iterator = roundEnvironment.getElementsAnnotatedWith(Accessor.class).iterator();
        while (iterator.hasNext()) {
            final ExecutableElement executableElement;
            final Element enclosingElement;
            if (!((enclosingElement = (executableElement = (ExecutableElement)iterator.next()).getEnclosingElement()) instanceof TypeElement)) {
                this.mixins.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(MixinObfuscationProcessorTargets.llIIIlIIlI[4]).append(TypeUtils.getElementType(enclosingElement))), executableElement);
            }
            else if (lIIIllllIllI(executableElement.getKind(), ElementKind.METHOD)) {
                final AnnotatedMixins mixins = this.mixins;
                final TypeElement typeElement = (TypeElement)enclosingElement;
                final ExecutableElement executableElement2 = executableElement;
                final TypeElement typeElement2 = typeElement;
                final AnnotatedMixins annotatedMixins = mixins;
                final AnnotatedMixin mixin;
                if ((mixin = mixins.getMixin(typeElement2)) == null) {
                    annotatedMixins.printMessage(Diagnostic.Kind.ERROR, AnnotatedMixins.lIIllIlIlI[13], executableElement2);
                }
                else {
                    final AnnotationHandle of = AnnotationHandle.of(executableElement2, Accessor.class);
                    final AnnotatedMixin annotatedMixin = mixin;
                    final ExecutableElement executableElement3 = executableElement2;
                    final AnnotationHandle annotationHandle = of;
                    final boolean shouldRemap = AnnotatedMixins.shouldRemap(mixin, of);
                    final AnnotationHandle annotationHandle2 = annotationHandle;
                    final ExecutableElement executableElement4 = executableElement3;
                    final AnnotatedMixin annotatedMixin2 = annotatedMixin;
                    annotatedMixin.methods.remove(executableElement4);
                    annotatedMixin2.accessors.registerAccessor(new AnnotatedMixinElementHandlerAccessor.AnnotatedElementAccessor(executableElement4, annotationHandle2, shouldRemap));
                }
            }
            else {
                this.mixins.printMessage(Diagnostic.Kind.ERROR, MixinObfuscationProcessorTargets.llIIIlIIlI[5], executableElement);
            }
        }
    }
    
    private void processInvokers(final RoundEnvironment roundEnvironment) {
        final Iterator<? extends Element> iterator = roundEnvironment.getElementsAnnotatedWith(Invoker.class).iterator();
        while (iterator.hasNext()) {
            final ExecutableElement executableElement;
            final Element enclosingElement;
            if (!((enclosingElement = (executableElement = (ExecutableElement)iterator.next()).getEnclosingElement()) instanceof TypeElement)) {
                this.mixins.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(MixinObfuscationProcessorTargets.llIIIlIIlI[6]).append(TypeUtils.getElementType(enclosingElement))), executableElement);
            }
            else if (lIIIllllIllI(executableElement.getKind(), ElementKind.METHOD)) {
                final AnnotatedMixins mixins = this.mixins;
                final TypeElement typeElement = (TypeElement)enclosingElement;
                final ExecutableElement executableElement2 = executableElement;
                final TypeElement typeElement2 = typeElement;
                final AnnotatedMixins annotatedMixins = mixins;
                final AnnotatedMixin mixin;
                if ((mixin = mixins.getMixin(typeElement2)) == null) {
                    annotatedMixins.printMessage(Diagnostic.Kind.ERROR, AnnotatedMixins.lIIllIlIlI[14], executableElement2);
                }
                else {
                    final AnnotationHandle of = AnnotationHandle.of(executableElement2, Invoker.class);
                    final AnnotatedMixin annotatedMixin = mixin;
                    final ExecutableElement executableElement3 = executableElement2;
                    final AnnotationHandle annotationHandle = of;
                    final boolean shouldRemap = AnnotatedMixins.shouldRemap(mixin, of);
                    final AnnotationHandle annotationHandle2 = annotationHandle;
                    final ExecutableElement executableElement4 = executableElement3;
                    final AnnotatedMixin annotatedMixin2 = annotatedMixin;
                    annotatedMixin.methods.remove(executableElement4);
                    annotatedMixin2.accessors.registerAccessor(new AnnotatedMixinElementHandlerAccessor.AnnotatedElementInvoker(executableElement4, annotationHandle2, shouldRemap));
                }
            }
            else {
                this.mixins.printMessage(Diagnostic.Kind.ERROR, MixinObfuscationProcessorTargets.llIIIlIIlI[7], executableElement);
            }
        }
    }
    
    private void processImplements(final RoundEnvironment roundEnvironment) {
        final Iterator<? extends Element> iterator = roundEnvironment.getElementsAnnotatedWith(Implements.class).iterator();
        while (iterator.hasNext()) {
            final Element element;
            if ((element = (Element)iterator.next()).getKind() == ElementKind.CLASS || lIIIllllIllI(element.getKind(), ElementKind.INTERFACE)) {
                final AnnotationHandle of = AnnotationHandle.of(element, Implements.class);
                final AnnotatedMixins mixins = this.mixins;
                final TypeElement typeElement = (TypeElement)element;
                final AnnotationHandle annotationHandle = of;
                final TypeElement typeElement2 = typeElement;
                final AnnotatedMixins annotatedMixins = mixins;
                final AnnotatedMixin mixin;
                if ((mixin = mixins.getMixin(typeElement2)) == null) {
                    annotatedMixins.printMessage(Diagnostic.Kind.ERROR, AnnotatedMixins.lIIllIlIlI[20]);
                }
                else {
                    mixin.softImplements.process(annotationHandle);
                }
            }
            else {
                this.mixins.printMessage(Diagnostic.Kind.ERROR, MixinObfuscationProcessorTargets.llIIIlIIlI[8], element);
            }
        }
    }
    
    static {
        lIIIllllIIIl();
    }
    
    private static void lIIIllllIIIl() {
        (llIIIlIIlI = new String[9])[0] = "Unexpected parent with type ";
        MixinObfuscationProcessorTargets.llIIIlIIlI[1] = "Element is not a method or field";
        MixinObfuscationProcessorTargets.llIIIlIIlI[2] = "Unexpected parent with type ";
        MixinObfuscationProcessorTargets.llIIIlIIlI[3] = "Element is not a method";
        MixinObfuscationProcessorTargets.llIIIlIIlI[4] = "Unexpected parent with type ";
        MixinObfuscationProcessorTargets.llIIIlIIlI[5] = "Element is not a method";
        MixinObfuscationProcessorTargets.llIIIlIIlI[6] = "Unexpected parent with type ";
        MixinObfuscationProcessorTargets.llIIIlIIlI[7] = "Element is not a method";
        MixinObfuscationProcessorTargets.llIIIlIIlI[8] = "Found an @Implements annotation on an element which is not a class or interface";
    }
    
    private static String lIIIllllIIII(String s, final String s2) {
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
    
    private static String lIIIlllIlllI(final String s, final String s2) {
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
    
    private static String lIIIlllIllll(final String s, final String s2) {
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
    
    private static boolean lIIIllllIlll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIIllllIllI(final Object o, final Object o2) {
        return o == o2;
    }
}
