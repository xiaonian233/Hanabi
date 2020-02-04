package org.spongepowered.asm.lib.signature;

public class SignatureWriter extends SignatureVisitor
{
    private final StringBuilder buf;
    private boolean hasFormals;
    private boolean hasParameters;
    private int argumentStack;
    
    public SignatureWriter() {
        super();
        this.buf = new StringBuilder();
    }
    
    public void visitFormalTypeParameter(final String s) {
        if (!this.hasFormals) {
            this.hasFormals = true;
            this.buf.append('<');
        }
        this.buf.append(s);
        this.buf.append(':');
    }
    
    public final SignatureVisitor visitClassBound() {
        return this;
    }
    
    public final SignatureVisitor visitInterfaceBound() {
        this.buf.append(':');
        return this;
    }
    
    public final SignatureVisitor visitSuperclass() {
        this.endFormals();
        return this;
    }
    
    public final SignatureVisitor visitInterface() {
        return this;
    }
    
    public final SignatureVisitor visitParameterType() {
        this.endFormals();
        if (!this.hasParameters) {
            this.hasParameters = true;
            this.buf.append('(');
        }
        return this;
    }
    
    public final SignatureVisitor visitReturnType() {
        this.endFormals();
        if (!this.hasParameters) {
            this.buf.append('(');
        }
        this.buf.append(')');
        return this;
    }
    
    public final SignatureVisitor visitExceptionType() {
        this.buf.append('^');
        return this;
    }
    
    public final void visitBaseType(final char c) {
        this.buf.append(c);
    }
    
    public void visitTypeVariable(final String s) {
        this.buf.append('T');
        this.buf.append(s);
        this.buf.append(';');
    }
    
    public final SignatureVisitor visitArrayType() {
        this.buf.append('[');
        return this;
    }
    
    public final void visitClassType(final String s) {
        this.buf.append('L');
        this.buf.append(s);
        this.argumentStack *= 2;
    }
    
    public final void visitInnerClassType(final String s) {
        this.endArguments();
        this.buf.append('.');
        this.buf.append(s);
        this.argumentStack *= 2;
    }
    
    public final void visitTypeArgument() {
        if (this.argumentStack % 2 == 0) {
            ++this.argumentStack;
            this.buf.append('<');
        }
        this.buf.append('*');
    }
    
    public final SignatureVisitor visitTypeArgument(final char c) {
        if (this.argumentStack % 2 == 0) {
            ++this.argumentStack;
            this.buf.append('<');
        }
        if (c != '=') {
            this.buf.append(c);
        }
        return this;
    }
    
    public final void visitEnd() {
        this.endArguments();
        this.buf.append(';');
    }
    
    public String toString() {
        return String.valueOf(this.buf);
    }
    
    private void endFormals() {
        if (this.hasFormals) {
            this.hasFormals = false;
            this.buf.append('>');
        }
    }
    
    private void endArguments() {
        if (this.argumentStack % 2 != 0) {
            this.buf.append('>');
        }
        this.argumentStack /= 2;
    }
    
    private static boolean lIllIIlIIlIl$255f299(final int n) {
        return n != 61;
    }
}
