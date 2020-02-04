package org.spongepowered.tools.obfuscation.validation;

import org.spongepowered.tools.obfuscation.*;
import org.spongepowered.tools.obfuscation.interfaces.*;
import javax.lang.model.element.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.gen.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import javax.lang.model.type.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class TargetValidator extends MixinValidator
{
    private static final String[] llIlllllIlI;
    
    public TargetValidator(final IMixinAnnotationProcessor mixinAnnotationProcessor) {
        super(mixinAnnotationProcessor, IMixinValidator.ValidationPass.LATE);
    }
    
    public final boolean validate$47e13afc(final TypeElement typeElement, final Collection<TypeHandle> collection) {
        if (TargetValidator.llIlllllIlI[0].equalsIgnoreCase(this.options.getOption(TargetValidator.llIlllllIlI[1]))) {
            return true;
        }
        if (lIIllIlllllll(typeElement.getKind(), ElementKind.INTERFACE)) {
            boolean b = false;
            final Iterator<? extends Element> iterator = typeElement.getEnclosedElements().iterator();
            while (iterator.hasNext()) {
                final Element element;
                if (lIIllIlllllll((element = (Element)iterator.next()).getKind(), ElementKind.METHOD)) {
                    final boolean exists = AnnotationHandle.of(element, Accessor.class).exists();
                    final boolean exists2 = AnnotationHandle.of(element, Invoker.class).exists();
                    b |= (!exists && !exists2);
                }
            }
            if (b) {
                final Iterator<TypeHandle> iterator2 = collection.iterator();
                while (iterator2.hasNext()) {
                    final TypeHandle typeHandle;
                    final TypeElement element2;
                    if ((element2 = (typeHandle = iterator2.next()).element) != null && element2.getKind() != ElementKind.INTERFACE) {
                        this.error(String.valueOf(new StringBuilder().append(TargetValidator.llIlllllIlI[2]).append(typeHandle).append(TargetValidator.llIlllllIlI[3]).append(typeElement).append(TargetValidator.llIlllllIlI[4])), typeElement);
                    }
                }
            }
        }
        else {
            this.validateClassMixin(typeElement, collection);
        }
        return true;
    }
    
    private void validateInterfaceMixin(final TypeElement typeElement, final Collection<TypeHandle> collection) {
        boolean b = false;
        final Iterator<? extends Element> iterator = typeElement.getEnclosedElements().iterator();
        while (iterator.hasNext()) {
            final Element element;
            if (lIIllIlllllll((element = (Element)iterator.next()).getKind(), ElementKind.METHOD)) {
                final boolean exists = AnnotationHandle.of(element, Accessor.class).exists();
                final boolean exists2 = AnnotationHandle.of(element, Invoker.class).exists();
                b |= (!exists && !exists2);
            }
        }
        if (!b) {
            return;
        }
        final Iterator<TypeHandle> iterator2 = collection.iterator();
        while (iterator2.hasNext()) {
            final TypeHandle typeHandle;
            final TypeElement element2;
            if ((element2 = (typeHandle = iterator2.next()).element) != null && element2.getKind() != ElementKind.INTERFACE) {
                this.error(String.valueOf(new StringBuilder().append(TargetValidator.llIlllllIlI[2]).append(typeHandle).append(TargetValidator.llIlllllIlI[3]).append(typeElement).append(TargetValidator.llIlllllIlI[4])), typeElement);
            }
        }
    }
    
    private void validateClassMixin(final TypeElement typeElement, final Collection<TypeHandle> collection) {
        final TypeMirror superclass = typeElement.getSuperclass();
        final Iterator<TypeHandle> iterator = collection.iterator();
        while (iterator.hasNext()) {
            final TypeMirror type;
            if ((type = iterator.next().getType()) != null) {
                final TypeMirror typeMirror = type;
                final TypeMirror typeMirror2 = superclass;
                final TypeMirror typeMirror3 = typeMirror;
                if (TypeUtils.isAssignable(this.processingEnv, typeMirror3, typeMirror2) || this.validateSuperClassRecursive(typeMirror3, typeMirror2)) {
                    continue;
                }
                this.error(String.valueOf(new StringBuilder().append(TargetValidator.llIlllllIlI[5]).append(superclass).append(TargetValidator.llIlllllIlI[6]).append(typeElement).append(TargetValidator.llIlllllIlI[7]).append(type)), typeElement);
            }
        }
    }
    
    private boolean validateSuperClass(final TypeMirror typeMirror, final TypeMirror typeMirror2) {
        return TypeUtils.isAssignable(this.processingEnv, typeMirror, typeMirror2) || this.validateSuperClassRecursive(typeMirror, typeMirror2);
    }
    
    private boolean validateSuperClassRecursive(TypeMirror superclass, final TypeMirror typeMirror) {
        while (superclass instanceof DeclaredType) {
            if (TypeUtils.isAssignable(this.processingEnv, superclass, typeMirror)) {
                return true;
            }
            if (lIIllIlllllll((superclass = ((TypeElement)((DeclaredType)superclass).asElement()).getSuperclass()).getKind(), TypeKind.NONE)) {
                return false;
            }
            if (this.checkMixinsFor(superclass, typeMirror)) {
                return true;
            }
        }
        return false;
    }
    
    private boolean checkMixinsFor(final TypeMirror typeMirror, final TypeMirror typeMirror2) {
        final Iterator<TypeMirror> iterator = this.getMixinsTargeting(typeMirror).iterator();
        while (iterator.hasNext()) {
            if (TypeUtils.isAssignable(this.processingEnv, iterator.next(), typeMirror2)) {
                return true;
            }
        }
        return false;
    }
    
    static {
        lIIllIllllIII();
    }
    
    private static void lIIllIllllIII() {
        (llIlllllIlI = new String[8])[0] = "true";
        TargetValidator.llIlllllIlI[1] = "disableTargetValidator";
        TargetValidator.llIlllllIlI[2] = "Targetted type '";
        TargetValidator.llIlllllIlI[3] = " of ";
        TargetValidator.llIlllllIlI[4] = " is not an interface";
        TargetValidator.llIlllllIlI[5] = "Superclass ";
        TargetValidator.llIlllllIlI[6] = " of ";
        TargetValidator.llIlllllIlI[7] = " was not found in the hierarchy of target class ";
    }
    
    private static String lIIllIlllIllI(String s, final String s2) {
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
    
    private static String lIIllIlllIIll(final String s, final String s2) {
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
    
    private static String lIIllIlllIlll(final String s, final String s2) {
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
    
    private static boolean lIIlllIIIIIlI(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIllIlllllll(final Object o, final Object o2) {
        return o == o2;
    }
}
