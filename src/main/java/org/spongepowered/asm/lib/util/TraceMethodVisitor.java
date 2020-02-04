package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.*;

public final class TraceMethodVisitor extends MethodVisitor
{
    private Printer p;
    
    public TraceMethodVisitor(final Printer printer) {
        this(null, printer);
    }
    
    public TraceMethodVisitor(final MethodVisitor methodVisitor, final Printer p2) {
        super(methodVisitor);
        this.p = p2;
    }
    
    public final void visitParameter(final String s, final int n) {
        this.p.visitParameter(s, n);
        super.visitParameter(s, n);
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final boolean b) {
        return new TraceAnnotationVisitor((this.mv == null) ? null : this.mv.visitAnnotation(s, b), this.p.visitMethodAnnotation(s, b));
    }
    
    public final AnnotationVisitor visitTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return new TraceAnnotationVisitor((this.mv == null) ? null : this.mv.visitTypeAnnotation(n, typePath, s, b), this.p.visitMethodTypeAnnotation(n, typePath, s, b));
    }
    
    public final void visitAttribute(final Attribute attribute) {
        this.p.visitMethodAttribute(attribute);
        super.visitAttribute(attribute);
    }
    
    public final AnnotationVisitor visitAnnotationDefault() {
        return new TraceAnnotationVisitor((this.mv == null) ? null : this.mv.visitAnnotationDefault(), this.p.visitAnnotationDefault());
    }
    
    public final AnnotationVisitor visitParameterAnnotation(final int n, final String s, final boolean b) {
        return new TraceAnnotationVisitor((this.mv == null) ? null : this.mv.visitParameterAnnotation(n, s, b), this.p.visitParameterAnnotation(n, s, b));
    }
    
    public final void visitCode() {
        this.p.visitCode();
        super.visitCode();
    }
    
    public final void visitFrame(final int n, final int n2, final Object[] array, final int n3, final Object[] array2) {
        this.p.visitFrame(n, n2, array, n3, array2);
        super.visitFrame(n, n2, array, n3, array2);
    }
    
    public final void visitInsn(final int n) {
        this.p.visitInsn(n);
        super.visitInsn(n);
    }
    
    public final void visitIntInsn(final int n, final int n2) {
        this.p.visitIntInsn(n, n2);
        super.visitIntInsn(n, n2);
    }
    
    public final void visitVarInsn(final int n, final int n2) {
        this.p.visitVarInsn(n, n2);
        super.visitVarInsn(n, n2);
    }
    
    public final void visitTypeInsn(final int n, final String s) {
        this.p.visitTypeInsn(n, s);
        super.visitTypeInsn(n, s);
    }
    
    public final void visitFieldInsn(final int n, final String s, final String s2, final String s3) {
        this.p.visitFieldInsn(n, s, s2, s3);
        super.visitFieldInsn(n, s, s2, s3);
    }
    
    @Deprecated
    public final void visitMethodInsn(final int n, final String s, final String s2, final String s3) {
        super.visitMethodInsn(n, s, s2, s3);
    }
    
    public final void visitMethodInsn(final int n, final String s, final String s2, final String s3, final boolean b) {
        this.p.visitMethodInsn(n, s, s2, s3, b);
        if (this.mv != null) {
            this.mv.visitMethodInsn(n, s, s2, s3, b);
        }
    }
    
    public final void visitInvokeDynamicInsn(final String s, final String s2, final Handle handle, final Object... array) {
        this.p.visitInvokeDynamicInsn(s, s2, handle, array);
        super.visitInvokeDynamicInsn(s, s2, handle, array);
    }
    
    public final void visitJumpInsn(final int n, final Label label) {
        this.p.visitJumpInsn(n, label);
        super.visitJumpInsn(n, label);
    }
    
    public final void visitLabel(final Label label) {
        this.p.visitLabel(label);
        super.visitLabel(label);
    }
    
    public final void visitLdcInsn(final Object o) {
        this.p.visitLdcInsn(o);
        super.visitLdcInsn(o);
    }
    
    public final void visitIincInsn(final int n, final int n2) {
        this.p.visitIincInsn(n, n2);
        super.visitIincInsn(n, n2);
    }
    
    public final void visitTableSwitchInsn(final int n, final int n2, final Label label, final Label... array) {
        this.p.visitTableSwitchInsn(n, n2, label, array);
        super.visitTableSwitchInsn(n, n2, label, array);
    }
    
    public final void visitLookupSwitchInsn(final Label label, final int[] array, final Label[] array2) {
        this.p.visitLookupSwitchInsn(label, array, array2);
        super.visitLookupSwitchInsn(label, array, array2);
    }
    
    public final void visitMultiANewArrayInsn(final String s, final int n) {
        this.p.visitMultiANewArrayInsn(s, n);
        super.visitMultiANewArrayInsn(s, n);
    }
    
    public final AnnotationVisitor visitInsnAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return new TraceAnnotationVisitor((this.mv == null) ? null : this.mv.visitInsnAnnotation(n, typePath, s, b), this.p.visitInsnAnnotation(n, typePath, s, b));
    }
    
    public final void visitTryCatchBlock(final Label label, final Label label2, final Label label3, final String s) {
        this.p.visitTryCatchBlock(label, label2, label3, s);
        super.visitTryCatchBlock(label, label2, label3, s);
    }
    
    public final AnnotationVisitor visitTryCatchAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return new TraceAnnotationVisitor((this.mv == null) ? null : this.mv.visitTryCatchAnnotation(n, typePath, s, b), this.p.visitTryCatchAnnotation(n, typePath, s, b));
    }
    
    public final void visitLocalVariable(final String s, final String s2, final String s3, final Label label, final Label label2, final int n) {
        this.p.visitLocalVariable(s, s2, s3, label, label2, n);
        super.visitLocalVariable(s, s2, s3, label, label2, n);
    }
    
    public final AnnotationVisitor visitLocalVariableAnnotation(final int n, final TypePath typePath, final Label[] array, final Label[] array2, final int[] array3, final String s, final boolean b) {
        return new TraceAnnotationVisitor((this.mv == null) ? null : this.mv.visitLocalVariableAnnotation(n, typePath, array, array2, array3, s, b), this.p.visitLocalVariableAnnotation(n, typePath, array, array2, array3, s, b));
    }
    
    public final void visitLineNumber(final int n, final Label label) {
        this.p.visitLineNumber(n, label);
        super.visitLineNumber(n, label);
    }
    
    public final void visitMaxs(final int n, final int n2) {
        this.p.visitMaxs(n, n2);
        super.visitMaxs(n, n2);
    }
    
    public final void visitEnd() {
        this.p.visitMethodEnd();
        super.visitEnd();
    }
    
    private static boolean llIIIIllIIIl$255f299(final int n) {
        return n >= 327680;
    }
}
