package org.spongepowered.tools.obfuscation.struct;

import javax.tools.*;
import javax.lang.model.element.*;
import org.spongepowered.tools.obfuscation.mirror.*;
import javax.annotation.processing.*;

public final class Message
{
    public Diagnostic.Kind kind;
    public CharSequence msg;
    public final Element element;
    public final AnnotationMirror annotation;
    public final AnnotationValue value;
    
    private Message(final Diagnostic.Kind kind, final CharSequence charSequence) {
        this(kind, charSequence, null, (AnnotationMirror)null, null);
    }
    
    private Message(final Diagnostic.Kind kind, final CharSequence charSequence, final Element element) {
        this(kind, charSequence, element, (AnnotationMirror)null, null);
    }
    
    public Message(final Diagnostic.Kind kind, final CharSequence charSequence, final Element element, final AnnotationHandle annotationHandle) {
        this(kind, charSequence, element, annotationHandle.annotation, null);
    }
    
    private Message(final Diagnostic.Kind kind, final CharSequence charSequence, final Element element, final AnnotationMirror annotationMirror) {
        this(kind, charSequence, element, annotationMirror, null);
    }
    
    private Message(final Diagnostic.Kind kind, final CharSequence charSequence, final Element element, final AnnotationHandle annotationHandle, final AnnotationValue annotationValue) {
        this(kind, charSequence, element, annotationHandle.annotation, annotationValue);
    }
    
    private Message(final Diagnostic.Kind kind, final CharSequence msg, final Element element, final AnnotationMirror annotation, final AnnotationValue value) {
        super();
        this.kind = kind;
        this.msg = msg;
        this.element = element;
        this.annotation = annotation;
        this.value = value;
    }
    
    private Message sendTo(final Messager messager) {
        if (this.value != null) {
            messager.printMessage(this.kind, this.msg, this.element, this.annotation, this.value);
        }
        else if (this.annotation != null) {
            messager.printMessage(this.kind, this.msg, this.element, this.annotation);
        }
        else if (this.element != null) {
            messager.printMessage(this.kind, this.msg, this.element);
        }
        else {
            messager.printMessage(this.kind, this.msg);
        }
        return this;
    }
    
    private Diagnostic.Kind getKind() {
        return this.kind;
    }
    
    private Message setKind(final Diagnostic.Kind kind) {
        this.kind = kind;
        return this;
    }
    
    private CharSequence getMsg() {
        return this.msg;
    }
    
    private Message setMsg(final CharSequence msg) {
        this.msg = msg;
        return this;
    }
    
    private Element getElement() {
        return this.element;
    }
    
    private AnnotationMirror getAnnotation() {
        return this.annotation;
    }
    
    private AnnotationValue getValue() {
        return this.value;
    }
}
