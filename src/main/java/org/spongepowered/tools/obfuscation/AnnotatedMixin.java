package org.spongepowered.tools.obfuscation;

import javax.annotation.processing.*;
import org.spongepowered.tools.obfuscation.mapping.*;
import java.lang.annotation.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import org.spongepowered.tools.obfuscation.interfaces.*;
import javax.lang.model.type.*;
import javax.tools.*;
import javax.lang.model.element.*;
import org.spongepowered.tools.obfuscation.struct.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

final class AnnotatedMixin
{
    private final AnnotationHandle annotation;
    private final Messager messager;
    private final ITypeHandleProvider typeProvider;
    private final IObfuscationManager obf;
    final IMappingConsumer mappings;
    final TypeElement mixin;
    final List<ExecutableElement> methods;
    final TypeHandle handle;
    final List<TypeHandle> targets;
    private final TypeHandle primaryTarget;
    final String classRef;
    final boolean remap;
    private final boolean virtual;
    final AnnotatedMixinElementHandlerOverwrite overwrites;
    final AnnotatedMixinElementHandlerShadow shadows;
    private final AnnotatedMixinElementHandlerInjector injectors;
    final AnnotatedMixinElementHandlerAccessor accessors;
    final AnnotatedMixinElementHandlerSoftImplements softImplements;
    private boolean validated;
    private static final String[] lllIllIlI;
    
    public AnnotatedMixin(final IMixinAnnotationProcessor messager, final TypeElement mixin) {
        super();
        this.targets = new ArrayList<TypeHandle>();
        this.validated = false;
        this.typeProvider = messager.getTypeProvider();
        this.obf = messager.getObfuscationManager();
        this.mappings = this.obf.createMappingConsumer();
        this.messager = messager;
        this.mixin = mixin;
        this.handle = new TypeHandle(mixin);
        this.methods = new ArrayList<ExecutableElement>((Collection<? extends ExecutableElement>)this.handle.getEnclosedElements(ElementKind.METHOD));
        this.virtual = this.handle.getAnnotation(Pseudo.class).exists();
        this.annotation = this.handle.getAnnotation(Mixin.class);
        this.classRef = TypeUtils.getInternalName(mixin);
        this.primaryTarget = this.initTargets();
        this.remap = (this.annotation.getBoolean(AnnotatedMixin.lllIllIlI[0], true) && this.targets.size() > 0);
        this.overwrites = new AnnotatedMixinElementHandlerOverwrite(messager, this);
        this.shadows = new AnnotatedMixinElementHandlerShadow(messager, this);
        this.injectors = new AnnotatedMixinElementHandlerInjector(messager, this);
        this.accessors = new AnnotatedMixinElementHandlerAccessor(messager, this);
        this.softImplements = new AnnotatedMixinElementHandlerSoftImplements(messager, this);
    }
    
    final AnnotatedMixin runValidators(final IMixinValidator.ValidationPass validationPass, final Collection<IMixinValidator> collection) {
        final Iterator<IMixinValidator> iterator = collection.iterator();
        while (iterator.hasNext() && iterator.next().validate$66d15f7e(validationPass, this.mixin, this.targets)) {}
        if (lIlIlIIlIll(validationPass, IMixinValidator.ValidationPass.FINAL) && !this.validated) {
            this.validated = true;
            final Iterator<ExecutableElement> iterator2 = this.methods.iterator();
            while (iterator2.hasNext()) {
                this.overwrites.registerMerge(iterator2.next());
            }
        }
        return this;
    }
    
    private TypeHandle initTargets() {
        TypeHandle typeHandle = null;
        try {
            final Iterator<TypeMirror> iterator = this.annotation.getList(AnnotationHandle.lIIIlllIIl[3]).iterator();
            while (iterator.hasNext()) {
                final TypeHandle typeHandle2 = new TypeHandle((DeclaredType)iterator.next());
                if (!this.targets.contains(typeHandle2)) {
                    this.addTarget(typeHandle2);
                    if (typeHandle != null) {
                        continue;
                    }
                    typeHandle = typeHandle2;
                }
            }
        }
        catch (Exception ex) {
            this.printMessage$14cf243e(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixin.lllIllIlI[1]).append(ex.getClass().getName()).append(AnnotatedMixin.lllIllIlI[2]).append(ex.getMessage())));
        }
        try {
            for (final String s : this.annotation.getList(AnnotatedMixin.lllIllIlI[3])) {
                TypeHandle typeHandle3 = this.typeProvider.getTypeHandle(s);
                if (!this.targets.contains(typeHandle3)) {
                    if (this.virtual) {
                        typeHandle3 = this.typeProvider.getSimulatedHandle(s, this.mixin.asType());
                    }
                    else {
                        if (typeHandle3 == null) {
                            this.printMessage$14cf243e(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(AnnotatedMixin.lllIllIlI[4]).append(s).append(AnnotatedMixin.lllIllIlI[5])));
                            return null;
                        }
                        if (typeHandle3.isPublic()) {
                            this.printMessage$14cf243e(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixin.lllIllIlI[6]).append(s).append(AnnotatedMixin.lllIllIlI[7])));
                            return null;
                        }
                    }
                    final TypeHandle typeHandle4 = typeHandle3;
                    final String s2 = s;
                    final TypeHandle typeHandle5 = typeHandle4;
                    final ObfuscationData<String> obfClass;
                    if (!(obfClass = this.obf.getDataProvider().getObfClass(typeHandle5)).isEmpty()) {
                        this.obf.getReferenceManager().addClassMapping(this.classRef, s2, obfClass);
                    }
                    this.addTarget(typeHandle5);
                    if (typeHandle != null) {
                        continue;
                    }
                    typeHandle = typeHandle3;
                }
            }
        }
        catch (Exception ex2) {
            this.printMessage$14cf243e(Diagnostic.Kind.WARNING, String.valueOf(new StringBuilder().append(AnnotatedMixin.lllIllIlI[8]).append(ex2.getClass().getName()).append(AnnotatedMixin.lllIllIlI[9]).append(ex2.getMessage())));
        }
        if (typeHandle == null) {
            this.printMessage$14cf243e(Diagnostic.Kind.ERROR, AnnotatedMixin.lllIllIlI[10]);
        }
        return typeHandle;
    }
    
    private void printMessage$14cf243e(final Diagnostic.Kind kind, final CharSequence charSequence) {
        this.messager.printMessage(kind, charSequence, this.mixin, this.annotation.annotation);
    }
    
    private void addSoftTarget(final TypeHandle typeHandle, final String s) {
        final ObfuscationData<String> obfClass;
        if (!(obfClass = this.obf.getDataProvider().getObfClass(typeHandle)).isEmpty()) {
            this.obf.getReferenceManager().addClassMapping(this.classRef, s, obfClass);
        }
        this.addTarget(typeHandle);
    }
    
    private void addTarget(final TypeHandle typeHandle) {
        this.targets.add(typeHandle);
    }
    
    @Override
    public final String toString() {
        return this.mixin.getSimpleName().toString();
    }
    
    private AnnotationHandle getAnnotation() {
        return this.annotation;
    }
    
    private TypeElement getMixin() {
        return this.mixin;
    }
    
    private TypeHandle getHandle() {
        return this.handle;
    }
    
    private String getClassRef() {
        return this.classRef;
    }
    
    public final boolean isInterface() {
        return lIlIlIIlIll(this.mixin.getKind(), ElementKind.INTERFACE);
    }
    
    @Deprecated
    private TypeHandle getPrimaryTarget() {
        return this.primaryTarget;
    }
    
    private List<TypeHandle> getTargets() {
        return this.targets;
    }
    
    public final boolean isMultiTarget() {
        return this.targets.size() > 1;
    }
    
    private boolean remap() {
        return this.remap;
    }
    
    private IMappingConsumer getMappings() {
        return this.mappings;
    }
    
    private void runFinalValidation() {
        final Iterator<ExecutableElement> iterator = this.methods.iterator();
        while (iterator.hasNext()) {
            this.overwrites.registerMerge(iterator.next());
        }
    }
    
    private void registerOverwrite(final ExecutableElement executableElement, final AnnotationHandle annotationHandle, final boolean b) {
        this.methods.remove(executableElement);
        this.overwrites.registerOverwrite(new AnnotatedMixinElementHandlerOverwrite.AnnotatedElementOverwrite(executableElement, annotationHandle, b));
    }
    
    private void registerShadow(final VariableElement variableElement, final AnnotationHandle annotationHandle, final boolean b) {
        this.shadows.registerShadow(this.shadows.new AnnotatedElementShadowField(variableElement, annotationHandle, b));
    }
    
    private void registerShadow(final ExecutableElement executableElement, final AnnotationHandle annotationHandle, final boolean b) {
        this.methods.remove(executableElement);
        this.shadows.registerShadow(this.shadows.new AnnotatedElementShadowMethod(executableElement, annotationHandle, b));
    }
    
    public final void registerInjector(final ExecutableElement executableElement, final AnnotationHandle annotationHandle, final InjectorRemap injectorRemap) {
        this.methods.remove(executableElement);
        this.injectors.registerInjector(new AnnotatedMixinElementHandlerInjector.AnnotatedElementInjector(executableElement, annotationHandle, injectorRemap));
        final Iterator<AnnotationHandle> iterator = annotationHandle.getAnnotationList(AnnotatedMixin.lllIllIlI[11]).iterator();
        while (iterator.hasNext()) {
            this.registerInjectionPoint(executableElement, annotationHandle, iterator.next(), injectorRemap, AnnotatedMixin.lllIllIlI[12]);
        }
        final Iterator<AnnotationHandle> iterator2 = annotationHandle.getAnnotationList(AnnotatedMixin.lllIllIlI[13]).iterator();
        while (iterator2.hasNext()) {
            final AnnotationHandle annotationHandle2;
            final String s = (annotationHandle2 = iterator2.next()).getValue(AnnotatedMixin.lllIllIlI[14], AnnotatedMixin.lllIllIlI[15]);
            final AnnotationHandle annotation;
            if ((annotation = annotationHandle2.getAnnotation(AnnotatedMixin.lllIllIlI[16])) != null) {
                this.registerInjectionPoint(executableElement, annotationHandle, annotation, injectorRemap, String.valueOf(new StringBuilder().append(AnnotatedMixin.lllIllIlI[17]).append(s).append(AnnotatedMixin.lllIllIlI[18])));
            }
            final AnnotationHandle annotation2;
            if ((annotation2 = annotationHandle2.getAnnotation(AnnotatedMixin.lllIllIlI[19])) != null) {
                this.registerInjectionPoint(executableElement, annotationHandle, annotation2, injectorRemap, String.valueOf(new StringBuilder().append(AnnotatedMixin.lllIllIlI[20]).append(s).append(AnnotatedMixin.lllIllIlI[21])));
            }
        }
    }
    
    private void registerInjectionPoint(final ExecutableElement executableElement, final AnnotationHandle annotationHandle, final AnnotationHandle annotationHandle2, final InjectorRemap injectorRemap, final String s) {
        this.injectors.registerInjectionPoint(new AnnotatedMixinElementHandlerInjector.AnnotatedElementInjectionPoint(executableElement, annotationHandle, annotationHandle2, injectorRemap), s);
    }
    
    private void registerAccessor(final ExecutableElement executableElement, final AnnotationHandle annotationHandle, final boolean b) {
        this.methods.remove(executableElement);
        this.accessors.registerAccessor(new AnnotatedMixinElementHandlerAccessor.AnnotatedElementAccessor(executableElement, annotationHandle, b));
    }
    
    private void registerInvoker(final ExecutableElement executableElement, final AnnotationHandle annotationHandle, final boolean b) {
        this.methods.remove(executableElement);
        this.accessors.registerAccessor(new AnnotatedMixinElementHandlerAccessor.AnnotatedElementInvoker(executableElement, annotationHandle, b));
    }
    
    private void registerSoftImplements(final AnnotationHandle annotationHandle) {
        this.softImplements.process(annotationHandle);
    }
    
    static {
        lIlIlIIIlll();
    }
    
    private static void lIlIlIIIlll() {
        (lllIllIlI = new String[22])[0] = "remap";
        AnnotatedMixin.lllIllIlI[1] = "Error processing public targets: ";
        AnnotatedMixin.lllIllIlI[2] = ": ";
        AnnotatedMixin.lllIllIlI[3] = "targets";
        AnnotatedMixin.lllIllIlI[4] = "Mixin target ";
        AnnotatedMixin.lllIllIlI[5] = " could not be found";
        AnnotatedMixin.lllIllIlI[6] = "Mixin target ";
        AnnotatedMixin.lllIllIlI[7] = " is public and must be specified in value";
        AnnotatedMixin.lllIllIlI[8] = "Error processing private targets: ";
        AnnotatedMixin.lllIllIlI[9] = ": ";
        AnnotatedMixin.lllIllIlI[10] = "Mixin has no targets";
        AnnotatedMixin.lllIllIlI[11] = "at";
        AnnotatedMixin.lllIllIlI[12] = "@At(%s)";
        AnnotatedMixin.lllIllIlI[13] = "slice";
        AnnotatedMixin.lllIllIlI[14] = "id";
        AnnotatedMixin.lllIllIlI[15] = "";
        AnnotatedMixin.lllIllIlI[16] = "from";
        AnnotatedMixin.lllIllIlI[17] = "@Slice[";
        AnnotatedMixin.lllIllIlI[18] = "](from=@At(%s))";
        AnnotatedMixin.lllIllIlI[19] = "to";
        AnnotatedMixin.lllIllIlI[20] = "@Slice[";
        AnnotatedMixin.lllIllIlI[21] = "](to=@At(%s))";
    }
    
    private static String lIlIlIIIIll(final String s, final String s2) {
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
    
    private static String lIlIlIIIIlI(String s, final String s2) {
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
    
    private static String lIlIlIIIllI(final String s, final String s2) {
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
    
    private static boolean lIlIlIIllIl$255f299(final int n) {
        return n > 1;
    }
    
    private static boolean lIlIlIIlIll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIlIlIIlIIl(final int n) {
        return n > 0;
    }
}
