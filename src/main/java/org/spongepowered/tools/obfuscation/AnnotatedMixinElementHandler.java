package org.spongepowered.tools.obfuscation;

import org.spongepowered.tools.obfuscation.interfaces.*;
import org.spongepowered.tools.obfuscation.mapping.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;
import javax.tools.*;
import org.spongepowered.asm.util.throwables.*;
import javax.lang.model.element.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.obfuscation.mapping.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import javax.annotation.processing.*;

abstract class AnnotatedMixinElementHandler
{
    protected final AnnotatedMixin mixin;
    protected final String classRef;
    protected final IMixinAnnotationProcessor ap;
    protected final IObfuscationManager obf;
    private IMappingConsumer mappings;
    private static final String[] lIllIlIlII;
    
    AnnotatedMixinElementHandler(final IMixinAnnotationProcessor ap, final AnnotatedMixin mixin) {
        super();
        this.ap = ap;
        this.mixin = mixin;
        this.classRef = mixin.classRef;
        this.obf = ap.getObfuscationManager();
    }
    
    private IMappingConsumer getMappings() {
        if (this.mappings == null) {
            final IMappingConsumer mappings;
            if ((mappings = this.mixin.mappings) instanceof Mappings) {
                final Mappings mappings2;
                if ((mappings2 = (Mappings)mappings).unique == null) {
                    mappings2.unique = new Mappings.UniqueMappings(mappings2);
                }
                this.mappings = mappings2.unique;
            }
            else {
                this.mappings = mappings;
            }
        }
        return this.mappings;
    }
    
    private void addFieldMappings(final String s, final String s2, final ObfuscationData<MappingField> obfuscationData) {
        for (final ObfuscationType obfuscationType : obfuscationData) {
            final MappingField mappingField = obfuscationData.get(obfuscationType);
            this.addFieldMapping(obfuscationType, s, mappingField.name, s2, mappingField.desc);
        }
    }
    
    protected final void addFieldMapping(final ObfuscationType obfuscationType, final ShadowElementName shadowElementName, final String s, final String s2) {
        this.addFieldMapping(obfuscationType, shadowElementName.name(), shadowElementName.obfuscated(), s, s2);
    }
    
    private void addFieldMapping(final ObfuscationType obfuscationType, final String s, final String s2, final String s3, final String s4) {
        this.getMappings().addFieldMapping(obfuscationType, new MappingField(this.classRef, s, s3), new MappingField(this.classRef, s2, s4));
    }
    
    protected final void addMethodMappings(final String s, final String s2, final ObfuscationData<MappingMethod> obfuscationData) {
        for (final ObfuscationType obfuscationType : obfuscationData) {
            final MappingMethod mappingMethod = obfuscationData.get(obfuscationType);
            this.addMethodMapping(obfuscationType, s, mappingMethod.name, s2, mappingMethod.desc);
        }
    }
    
    protected final void addMethodMapping(final ObfuscationType obfuscationType, final ShadowElementName shadowElementName, final String s, final String s2) {
        this.addMethodMapping(obfuscationType, shadowElementName.name(), shadowElementName.obfuscated(), s, s2);
    }
    
    private void addMethodMapping(final ObfuscationType obfuscationType, final String s, final String s2, final String s3, final String s4) {
        this.getMappings().addMethodMapping(obfuscationType, new MappingMethod(this.classRef, s, s3), new MappingMethod(this.classRef, s2, s4));
    }
    
    protected final void checkConstraints(final ExecutableElement executableElement, final AnnotationHandle annotationHandle) {
        final String s = AnnotatedMixinElementHandler.lIllIlIlII[0];
        try {
            final ConstraintParser.Constraint parse = ConstraintParser.parse(annotationHandle.getValue(s, (String)null));
            final IMixinAnnotationProcessor ap = this.ap;
            try {
                parse.check(ap.getTokenProvider());
            }
            catch (ConstraintViolationException ex) {
                this.ap.printMessage(Diagnostic.Kind.ERROR, ex.getMessage(), executableElement, annotationHandle.annotation);
            }
        }
        catch (InvalidConstraintException ex2) {
            this.ap.printMessage(Diagnostic.Kind.WARNING, ex2.getMessage(), executableElement, annotationHandle.annotation);
        }
    }
    
    protected final void validateTarget(final Element element, final AnnotationHandle annotationHandle, final AliasedElementName aliasedElementName, final String s) {
        if (element instanceof ExecutableElement) {
            this.validateTargetMethod((ExecutableElement)element, annotationHandle, aliasedElementName, s, false, false);
            return;
        }
        if (element instanceof VariableElement) {
            final VariableElement variableElement = (VariableElement)element;
            final String string = variableElement.asType().toString();
            final Iterator<TypeHandle> iterator = this.mixin.targets.iterator();
            while (iterator.hasNext()) {
                final TypeHandle typeHandle;
                if (!(typeHandle = iterator.next()).isImaginary()) {
                    final TypeHandle typeHandle2 = typeHandle;
                    final VariableElement variableElement2 = variableElement;
                    FieldHandle fieldHandle;
                    if ((fieldHandle = typeHandle2.findField(variableElement2.getSimpleName().toString(), TypeUtils.getTypeName(variableElement2.asType()), true)) != null) {
                        continue;
                    }
                    final Iterator<String> iterator2 = aliasedElementName.aliases.iterator();
                    while (iterator2.hasNext() && (fieldHandle = typeHandle.findField(iterator2.next(), string, true)) == null) {}
                    if (fieldHandle != null) {
                        continue;
                    }
                    this.ap.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandler.lIllIlIlII[9]).append(s).append(AnnotatedMixinElementHandler.lIllIlIlII[10]).append(typeHandle)), variableElement, annotationHandle.annotation);
                }
            }
        }
    }
    
    protected final void validateTargetMethod(final ExecutableElement executableElement, final AnnotationHandle annotationHandle, final AliasedElementName aliasedElementName, final String s, final boolean b, final boolean b2) {
        final String javaSignature = TypeUtils.getJavaSignature(executableElement);
        final Iterator<TypeHandle> iterator = this.mixin.targets.iterator();
        while (iterator.hasNext()) {
            final TypeHandle typeHandle;
            if (!(typeHandle = iterator.next()).isImaginary()) {
                MethodHandle methodHandle;
                if ((methodHandle = typeHandle.findMethod$fc6eec9(executableElement)) == null && aliasedElementName.hasPrefix()) {
                    methodHandle = typeHandle.findMethod(aliasedElementName.baseName(), javaSignature, true);
                }
                if (methodHandle == null && aliasedElementName.hasAliases()) {
                    final Iterator<String> iterator2 = aliasedElementName.aliases.iterator();
                    while (iterator2.hasNext() && (methodHandle = typeHandle.findMethod(iterator2.next(), javaSignature, true)) == null) {}
                }
                if (methodHandle != null) {
                    if (!b) {
                        continue;
                    }
                    final TypeHandle typeHandle2 = typeHandle;
                    final MethodHandle methodHandle2 = methodHandle;
                    final TypeHandle typeHandle3 = typeHandle2;
                    final Visibility visibility;
                    if ((visibility = TypeUtils.getVisibility(methodHandle2.element)) == null) {
                        continue;
                    }
                    final Visibility visibility2 = TypeUtils.getVisibility(executableElement);
                    final String value = String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandler.lIllIlIlII[3]).append(visibility).append(AnnotatedMixinElementHandler.lIllIlIlII[4]).append(typeHandle3));
                    if (lIIIIlIllIII(visibility.ordinal(), visibility2.ordinal())) {
                        this.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(visibility2).append(AnnotatedMixinElementHandler.lIllIlIlII[5]).append(s).append(AnnotatedMixinElementHandler.lIllIlIlII[6]).append(value)), executableElement, annotationHandle);
                    }
                    else {
                        if (visibility != Visibility.PRIVATE || !lIIIIlIllIII(visibility2.ordinal(), visibility.ordinal())) {
                            continue;
                        }
                        this.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(visibility2).append(AnnotatedMixinElementHandler.lIllIlIlII[7]).append(s).append(AnnotatedMixinElementHandler.lIllIlIlII[8]).append(value)), executableElement, annotationHandle);
                    }
                }
                else {
                    if (b2) {
                        continue;
                    }
                    this.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandler.lIllIlIlII[1]).append(s).append(AnnotatedMixinElementHandler.lIllIlIlII[2]).append(typeHandle)), executableElement, annotationHandle);
                }
            }
        }
    }
    
    private void validateMethodVisibility(final ExecutableElement executableElement, final AnnotationHandle annotationHandle, final String s, final TypeHandle typeHandle, final MethodHandle methodHandle) {
        final Visibility visibility;
        if ((visibility = TypeUtils.getVisibility(methodHandle.element)) == null) {
            return;
        }
        final Visibility visibility2 = TypeUtils.getVisibility(executableElement);
        final String value = String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandler.lIllIlIlII[3]).append(visibility).append(AnnotatedMixinElementHandler.lIllIlIlII[4]).append(typeHandle));
        if (lIIIIlIllIII(visibility.ordinal(), visibility2.ordinal())) {
            this.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(visibility2).append(AnnotatedMixinElementHandler.lIllIlIlII[5]).append(s).append(AnnotatedMixinElementHandler.lIllIlIlII[6]).append(value)), executableElement, annotationHandle);
            return;
        }
        if (visibility == Visibility.PRIVATE && lIIIIlIllIII(visibility2.ordinal(), visibility.ordinal())) {
            this.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(visibility2).append(AnnotatedMixinElementHandler.lIllIlIlII[7]).append(s).append(AnnotatedMixinElementHandler.lIllIlIlII[8]).append(value)), executableElement, annotationHandle);
        }
    }
    
    private void validateTargetField(final VariableElement variableElement, final AnnotationHandle annotationHandle, final AliasedElementName aliasedElementName, final String s) {
        final String string = variableElement.asType().toString();
        final Iterator<TypeHandle> iterator = this.mixin.targets.iterator();
        while (iterator.hasNext()) {
            final TypeHandle typeHandle;
            FieldHandle fieldHandle;
            if (!(typeHandle = iterator.next()).isImaginary() && (fieldHandle = typeHandle.findField$235c390c(variableElement)) == null) {
                final Iterator<String> iterator2 = aliasedElementName.aliases.iterator();
                while (iterator2.hasNext() && (fieldHandle = typeHandle.findField(iterator2.next(), string, true)) == null) {}
                if (fieldHandle != null) {
                    continue;
                }
                this.ap.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandler.lIllIlIlII[9]).append(s).append(AnnotatedMixinElementHandler.lIllIlIlII[10]).append(typeHandle)), variableElement, annotationHandle.annotation);
            }
        }
    }
    
    protected final void validateReferencedTarget(final ExecutableElement executableElement, final AnnotationHandle annotationHandle, final MemberInfo memberInfo, final String s) {
        String descriptor;
        if (memberInfo.desc == null) {
            descriptor = MemberInfo.lllIIIIl[19];
        }
        else {
            final SignaturePrinter signaturePrinter;
            (signaturePrinter = new SignaturePrinter(memberInfo)).fullyQualified = true;
            descriptor = signaturePrinter.toDescriptor();
        }
        final String s2 = descriptor;
        final Iterator<TypeHandle> iterator = this.mixin.targets.iterator();
        while (iterator.hasNext()) {
            final TypeHandle typeHandle;
            if (!(typeHandle = iterator.next()).isImaginary()) {
                if (typeHandle.findMethod(memberInfo.name, s2, true) != null) {
                    continue;
                }
                this.ap.printMessage(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandler.lIllIlIlII[11]).append(s).append(AnnotatedMixinElementHandler.lIllIlIlII[12]).append(typeHandle)), executableElement, annotationHandle.annotation);
            }
        }
    }
    
    private void printMessage(final Diagnostic.Kind kind, final String s, final Element element, final AnnotationHandle annotationHandle) {
        if (annotationHandle == null) {
            this.ap.printMessage(kind, s, element);
            return;
        }
        this.ap.printMessage(kind, s, element, annotationHandle.annotation);
    }
    
    protected static <T extends IMapping<T>> ObfuscationData<T> stripOwnerData(final ObfuscationData<T> obfuscationData) {
        final ObfuscationData<Object> obfuscationData2 = (ObfuscationData<Object>)new ObfuscationData<T>();
        for (final ObfuscationType obfuscationType : obfuscationData) {
            obfuscationData2.put(obfuscationType, obfuscationData.get(obfuscationType).move$9543ced());
        }
        return (ObfuscationData<T>)obfuscationData2;
    }
    
    protected static <T extends IMapping<T>> ObfuscationData<T> stripDescriptors(final ObfuscationData<T> obfuscationData) {
        final ObfuscationData<Object> obfuscationData2 = (ObfuscationData<Object>)new ObfuscationData<T>();
        for (final ObfuscationType obfuscationType : obfuscationData) {
            obfuscationData2.put(obfuscationType, obfuscationData.get(obfuscationType).transform$9543ced());
        }
        return (ObfuscationData<T>)obfuscationData2;
    }
    
    static {
        lIIIIlIlIIII();
    }
    
    private static void lIIIIlIlIIII() {
        (lIllIlIlII = new String[13])[0] = "constraints";
        AnnotatedMixinElementHandler.lIllIlIlII[1] = "Cannot find target for ";
        AnnotatedMixinElementHandler.lIllIlIlII[2] = " method in ";
        AnnotatedMixinElementHandler.lIllIlIlII[3] = "visibility of ";
        AnnotatedMixinElementHandler.lIllIlIlII[4] = " method in ";
        AnnotatedMixinElementHandler.lIllIlIlII[5] = " ";
        AnnotatedMixinElementHandler.lIllIlIlII[6] = " method cannot reduce ";
        AnnotatedMixinElementHandler.lIllIlIlII[7] = " ";
        AnnotatedMixinElementHandler.lIllIlIlII[8] = " method will upgrade ";
        AnnotatedMixinElementHandler.lIllIlIlII[9] = "Cannot find target for ";
        AnnotatedMixinElementHandler.lIllIlIlII[10] = " field in ";
        AnnotatedMixinElementHandler.lIllIlIlII[11] = "Cannot find target method for ";
        AnnotatedMixinElementHandler.lIllIlIlII[12] = " in ";
    }
    
    private static String lIIIIlIIllll(final String s, final String s2) {
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
    
    private static String lIIIIlIIlIIl(final String s, final String s2) {
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
    
    private static String lIIIIlIIlIll(String s, final String s2) {
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
    
    private static boolean lIIIIlIllIII(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIIIlIllIIl(final Object o, final Object o2) {
        return o == o2;
    }
}
