package org.spongepowered.asm.lib.commons;

import org.spongepowered.asm.lib.signature.*;
import java.util.*;

public final class SignatureRemapper extends SignatureVisitor
{
    private final SignatureVisitor v;
    private final Remapper remapper;
    private Stack<String> classNames;
    
    public SignatureRemapper(final SignatureVisitor signatureVisitor, final Remapper remapper) {
        this(signatureVisitor, remapper, (byte)0);
    }
    
    private SignatureRemapper(final SignatureVisitor v, final Remapper remapper, final byte b) {
        super();
        this.classNames = new Stack<String>();
        this.v = v;
        this.remapper = remapper;
    }
    
    public final void visitClassType(final String s) {
        this.classNames.push(s);
        this.v.visitClassType(this.remapper.mapType(s));
    }
    
    public final void visitInnerClassType(String s) {
        final String s2 = this.classNames.pop();
        s = String.valueOf(new StringBuilder().append(s2).append('$').append(s));
        this.classNames.push(s);
        final String value = String.valueOf(new StringBuilder().append(this.remapper.mapType(s2)).append('$'));
        this.v.visitInnerClassType(s.substring((s = this.remapper.mapType(s)).startsWith(value) ? value.length() : (s.lastIndexOf(36) + 1)));
    }
    
    public final void visitFormalTypeParameter(final String s) {
        this.v.visitFormalTypeParameter(s);
    }
    
    public final void visitTypeVariable(final String s) {
        this.v.visitTypeVariable(s);
    }
    
    public final SignatureVisitor visitArrayType() {
        this.v.visitArrayType();
        return this;
    }
    
    public final void visitBaseType(final char c) {
        this.v.visitBaseType(c);
    }
    
    public final SignatureVisitor visitClassBound() {
        this.v.visitClassBound();
        return this;
    }
    
    public final SignatureVisitor visitExceptionType() {
        this.v.visitExceptionType();
        return this;
    }
    
    public final SignatureVisitor visitInterface() {
        this.v.visitInterface();
        return this;
    }
    
    public final SignatureVisitor visitInterfaceBound() {
        this.v.visitInterfaceBound();
        return this;
    }
    
    public final SignatureVisitor visitParameterType() {
        this.v.visitParameterType();
        return this;
    }
    
    public final SignatureVisitor visitReturnType() {
        this.v.visitReturnType();
        return this;
    }
    
    public final SignatureVisitor visitSuperclass() {
        this.v.visitSuperclass();
        return this;
    }
    
    public final void visitTypeArgument() {
        this.v.visitTypeArgument();
    }
    
    public final SignatureVisitor visitTypeArgument(final char c) {
        this.v.visitTypeArgument(c);
        return this;
    }
    
    public final void visitEnd() {
        this.v.visitEnd();
        this.classNames.pop();
    }
}
