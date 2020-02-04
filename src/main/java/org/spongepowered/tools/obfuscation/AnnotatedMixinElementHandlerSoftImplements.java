package org.spongepowered.tools.obfuscation;

import org.spongepowered.tools.obfuscation.interfaces.*;
import javax.tools.*;
import org.spongepowered.asm.mixin.*;
import javax.lang.model.type.*;
import javax.lang.model.element.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class AnnotatedMixinElementHandlerSoftImplements extends AnnotatedMixinElementHandler
{
    private static final String[] lIlIIIIlllI;
    
    AnnotatedMixinElementHandlerSoftImplements(final IMixinAnnotationProcessor mixinAnnotationProcessor, final AnnotatedMixin annotatedMixin) {
        super(mixinAnnotationProcessor, annotatedMixin);
    }
    
    public final void process(AnnotationHandle iterator) {
        if (!this.mixin.remap) {
            return;
        }
        final List<AnnotationHandle> annotationList;
        if ((annotationList = iterator.getAnnotationList(AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[0])).size() <= 0) {
            this.ap.printMessage(Diagnostic.Kind.WARNING, AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[1], this.mixin.mixin, iterator.annotation);
            return;
        }
        iterator = (AnnotationHandle)annotationList.iterator();
        while (((Iterator)iterator).hasNext()) {
            final AnnotationHandle annotationHandle;
            final Interface.Remap remap;
            if ((remap = (annotationHandle = ((Iterator<AnnotationHandle>)iterator).next()).getValue(AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[2], Interface.Remap.ALL)) != Interface.Remap.NONE) {
                final AnnotationHandle annotationHandle2 = annotationHandle;
                final String[] lIlIIIIlllI = AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI;
                final int n = 3;
                try {
                    this.processSoftImplements(remap, new TypeHandle(annotationHandle2.getValue(lIlIIIIlllI[n], (DeclaredType)null)), annotationHandle.getValue(AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[4], (String)null));
                }
                catch (Exception ex) {
                    this.ap.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[5]).append(ex.getClass().getName()).append(AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[6]).append(ex.getMessage())), this.mixin.mixin, annotationHandle.annotation);
                }
            }
        }
    }
    
    private void processSoftImplements(final Interface.Remap remap, final TypeHandle typeHandle, final String s) {
        final Iterator<ExecutableElement> iterator = typeHandle.getEnclosedElements(ElementKind.METHOD).iterator();
        while (iterator.hasNext()) {
            this.processMethod(remap, typeHandle, s, iterator.next());
        }
        final Iterator<TypeHandle> iterator2 = typeHandle.getInterfaces().iterator();
        while (iterator2.hasNext()) {
            this.processSoftImplements(remap, iterator2.next(), s);
        }
    }
    
    private void processMethod(final Interface.Remap remap, final TypeHandle typeHandle, final String s, final ExecutableElement executableElement) {
        final String string = executableElement.getSimpleName().toString();
        final String javaSignature = TypeUtils.getJavaSignature(executableElement);
        final String descriptor = TypeUtils.getDescriptor(executableElement);
        final MethodHandle method;
        if (lllIIIIlllll(remap, Interface.Remap.ONLY_PREFIXED) && (method = this.mixin.handle.findMethod(string, javaSignature, true)) != null) {
            this.addInterfaceMethodMapping(remap, typeHandle, null, method, string, descriptor);
        }
        final MethodHandle method2;
        if (s != null && (method2 = this.mixin.handle.findMethod(String.valueOf(new StringBuilder().append(s).append(string)), javaSignature, true)) != null) {
            this.addInterfaceMethodMapping(remap, typeHandle, s, method2, string, descriptor);
        }
    }
    
    private void addInterfaceMethodMapping(final Interface.Remap remap, final TypeHandle typeHandle, final String s, final MethodHandle methodHandle, final String s2, final String s3) {
        final ObfuscationData<MappingMethod> obfMethod;
        if ((obfMethod = this.obf.getDataProvider().getObfMethod(new MappingMethod(typeHandle.name, s2, s3))).isEmpty()) {
            if (remap.forceRemap) {
                this.ap.printMessage(Diagnostic.Kind.ERROR, AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[7], methodHandle.element);
            }
            return;
        }
        this.addMethodMappings(methodHandle.name, s3, applyPrefix(obfMethod, s));
    }
    
    private static ObfuscationData<MappingMethod> applyPrefix(final ObfuscationData<MappingMethod> obfuscationData, final String s) {
        if (s == null) {
            return obfuscationData;
        }
        final ObfuscationData<MappingMethod> obfuscationData2 = new ObfuscationData<MappingMethod>();
        for (final ObfuscationType obfuscationType : obfuscationData) {
            obfuscationData2.put(obfuscationType, obfuscationData.get(obfuscationType).addPrefix(s));
        }
        return obfuscationData2;
    }
    
    static {
        lllIIIIllIlI();
    }
    
    private static void lllIIIIllIlI() {
        (lIlIIIIlllI = new String[8])[0] = "value";
        AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[1] = "Empty @Implements annotation";
        AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[2] = "remap";
        AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[3] = "iface";
        AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[4] = "prefix";
        AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[5] = "Unexpected error: ";
        AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[6] = ": ";
        AnnotatedMixinElementHandlerSoftImplements.lIlIIIIlllI[7] = "No obfuscation mapping for soft-implementing method";
    }
    
    private static String lllIIIIllIII(final String s, final String s2) {
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
    
    private static String lllIIIIllIIl(String s, final String s2) {
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
    
    private static String lllIIIIlIlIl(final String s, final String s2) {
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
    
    private static boolean lllIIIIlllll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lllIIIIllllI(final Object o, final Object o2) {
        return o == o2;
    }
}
