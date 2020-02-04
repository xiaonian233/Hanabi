package org.spongepowered.asm.lib.signature;

public abstract class SignatureVisitor
{
    private static char EXTENDS;
    private static char SUPER;
    private static char INSTANCEOF;
    private int api;
    
    public SignatureVisitor() {
        super();
        if (lIllIlIIllIl$255f299(262144) && lIllIlIIllIl$255f299(327680)) {
            throw new IllegalArgumentException();
        }
    }
    
    public void visitFormalTypeParameter(final String s) {
    }
    
    public SignatureVisitor visitClassBound() {
        return this;
    }
    
    public SignatureVisitor visitInterfaceBound() {
        return this;
    }
    
    public SignatureVisitor visitSuperclass() {
        return this;
    }
    
    public SignatureVisitor visitInterface() {
        return this;
    }
    
    public SignatureVisitor visitParameterType() {
        return this;
    }
    
    public SignatureVisitor visitReturnType() {
        return this;
    }
    
    public SignatureVisitor visitExceptionType() {
        return this;
    }
    
    public void visitBaseType(final char c) {
    }
    
    public void visitTypeVariable(final String s) {
    }
    
    public SignatureVisitor visitArrayType() {
        return this;
    }
    
    public void visitClassType(final String s) {
    }
    
    public void visitInnerClassType(final String s) {
    }
    
    public void visitTypeArgument() {
    }
    
    public SignatureVisitor visitTypeArgument(final char c) {
        return this;
    }
    
    public void visitEnd() {
    }
    
    private static boolean lIllIlIIllIl$255f299(final int n) {
        return 327680 != n;
    }
}
