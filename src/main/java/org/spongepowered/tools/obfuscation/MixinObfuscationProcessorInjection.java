package org.spongepowered.tools.obfuscation;

import javax.annotation.processing.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import javax.lang.model.element.*;
import javax.tools.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

@SupportedAnnotationTypes({ "org.spongepowered.asm.mixin.injection.Inject", "org.spongepowered.asm.mixin.injection.ModifyArg", "org.spongepowered.asm.mixin.injection.ModifyArgs", "org.spongepowered.asm.mixin.injection.Redirect", "org.spongepowered.asm.mixin.injection.At" })
public final class MixinObfuscationProcessorInjection extends MixinObfuscationProcessor
{
    private static final String[] llIlIllIl;
    
    public MixinObfuscationProcessorInjection() {
        super();
    }
    
    @Override
    public final boolean process(final Set<? extends TypeElement> set, final RoundEnvironment roundEnvironment) {
        if (roundEnvironment.processingOver()) {
            this.postProcess(roundEnvironment);
            return true;
        }
        this.processMixins(roundEnvironment);
        this.processInjectors(roundEnvironment, Inject.class);
        this.processInjectors(roundEnvironment, ModifyArg.class);
        this.processInjectors(roundEnvironment, ModifyArgs.class);
        this.processInjectors(roundEnvironment, Redirect.class);
        this.processInjectors(roundEnvironment, ModifyVariable.class);
        this.processInjectors(roundEnvironment, ModifyConstant.class);
        this.postProcess(roundEnvironment);
        return true;
    }
    
    @Override
    protected final void postProcess(final RoundEnvironment roundEnvironment) {
        super.postProcess(roundEnvironment);
        try {
            this.mixins.writeReferences();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private void processInjectors(final RoundEnvironment roundEnvironment, final Class<? extends Annotation> clazz) {
        final Iterator<? extends Element> iterator = roundEnvironment.getElementsAnnotatedWith(clazz).iterator();
        while (iterator.hasNext()) {
            final ExecutableElement executableElement;
            final Element enclosingElement;
            if (!((enclosingElement = (executableElement = (ExecutableElement)iterator.next()).getEnclosingElement()) instanceof TypeElement)) {
                throw new IllegalStateException(String.valueOf(new StringBuilder().append(MixinObfuscationProcessorInjection.llIlIllIl[0]).append(clazz.getSimpleName()).append(MixinObfuscationProcessorInjection.llIlIllIl[1]).append(TypeUtils.getElementType(enclosingElement))));
            }
            final AnnotationHandle of = AnnotationHandle.of(executableElement, clazz);
            if (lIIllIIIlII(executableElement.getKind(), ElementKind.METHOD)) {
                this.mixins.registerInjector((TypeElement)enclosingElement, executableElement, of);
            }
            else {
                this.mixins.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(MixinObfuscationProcessorInjection.llIlIllIl[2]).append(clazz.getSimpleName()).append(MixinObfuscationProcessorInjection.llIlIllIl[3]).append(executableElement.toString())));
            }
        }
    }
    
    static {
        lIIlIllllII();
    }
    
    private static void lIIlIllllII() {
        (llIlIllIl = new String[4])[0] = "@";
        MixinObfuscationProcessorInjection.llIlIllIl[1] = " element has unexpected parent with type ";
        MixinObfuscationProcessorInjection.llIlIllIl[2] = "Found an @";
        MixinObfuscationProcessorInjection.llIlIllIl[3] = " annotation on an element which is not a method: ";
    }
    
    private static String lIIlIllIlll(String s, final String s2) {
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
    
    private static String lIIlIllIllI(final String s, final String s2) {
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
    
    private static String lIIlIlllIII(final String s, final String s2) {
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
    
    private static boolean lIIllIIIlII(final Object o, final Object o2) {
        return o == o2;
    }
}
