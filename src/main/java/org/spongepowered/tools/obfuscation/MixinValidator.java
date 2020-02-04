package org.spongepowered.tools.obfuscation;

import javax.annotation.processing.*;
import org.spongepowered.tools.obfuscation.interfaces.*;
import javax.lang.model.element.*;
import javax.tools.*;
import javax.lang.model.type.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import java.util.*;

public abstract class MixinValidator implements IMixinValidator
{
    protected final ProcessingEnvironment processingEnv;
    private Messager messager;
    protected final IOptionProvider options;
    private ValidationPass pass;
    
    public MixinValidator(final IMixinAnnotationProcessor mixinAnnotationProcessor, final ValidationPass pass) {
        super();
        this.processingEnv = mixinAnnotationProcessor.getProcessingEnvironment();
        this.messager = mixinAnnotationProcessor;
        this.options = mixinAnnotationProcessor;
        this.pass = pass;
    }
    
    @Override
    public final boolean validate$66d15f7e(final ValidationPass validationPass, final TypeElement typeElement, final Collection<TypeHandle> collection) {
        return validationPass != this.pass || this.validate$47e13afc(typeElement, collection);
    }
    
    protected abstract boolean validate$47e13afc(final TypeElement p0, final Collection<TypeHandle> p1);
    
    private void note(final String s, final Element element) {
        this.messager.printMessage(Diagnostic.Kind.NOTE, s, element);
    }
    
    private void warning(final String s, final Element element) {
        this.messager.printMessage(Diagnostic.Kind.WARNING, s, element);
    }
    
    protected final void error(final String s, final Element element) {
        this.messager.printMessage(Diagnostic.Kind.ERROR, s, element);
    }
    
    protected final Collection<TypeMirror> getMixinsTargeting(final TypeMirror typeMirror) {
        final AnnotatedMixins mixinsForEnvironment = AnnotatedMixins.getMixinsForEnvironment(this.processingEnv);
        final TypeElement typeElement = (TypeElement)((DeclaredType)typeMirror).asElement();
        final AnnotatedMixins annotatedMixins = mixinsForEnvironment;
        final ArrayList<TypeMirror> list = new ArrayList<TypeMirror>();
        final Iterator<TypeReference> iterator = annotatedMixins.targets.getMixinsTargeting(typeElement).iterator();
        while (iterator.hasNext()) {
            final TypeHandle handle;
            if ((handle = iterator.next().getHandle(annotatedMixins.processingEnv)) != null) {
                list.add(handle.getType());
            }
        }
        return list;
    }
    
    private static boolean lIIllIIIllIlI(final Object o, final Object o2) {
        return o != o2;
    }
}
