package org.spongepowered.asm.lib.commons;

import org.spongepowered.asm.lib.*;

public class ClassRemapper extends ClassVisitor
{
    private Remapper remapper;
    private String className;
    
    private ClassRemapper(final ClassVisitor classVisitor, final Remapper remapper) {
        this(classVisitor, remapper, (byte)0);
    }
    
    public ClassRemapper(final ClassVisitor classVisitor, final Remapper remapper, final byte b) {
        super(classVisitor);
        this.remapper = remapper;
    }
    
    public final void visit(final int n, final int n2, final String className, final String s, final String s2, final String[] array) {
        this.className = className;
        super.visit(n, n2, this.remapper.mapType(className), this.remapper.mapSignature(s, false), this.remapper.mapType(s2), (String[])((array == null) ? null : this.remapper.mapTypes(array)));
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final boolean b) {
        final AnnotationVisitor visitAnnotation;
        if ((visitAnnotation = super.visitAnnotation(this.remapper.mapDesc(s), b)) == null) {
            return null;
        }
        return this.createAnnotationRemapper(visitAnnotation);
    }
    
    public final AnnotationVisitor visitTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        final AnnotationVisitor visitTypeAnnotation;
        if ((visitTypeAnnotation = super.visitTypeAnnotation(n, typePath, this.remapper.mapDesc(s), b)) == null) {
            return null;
        }
        return this.createAnnotationRemapper(visitTypeAnnotation);
    }
    
    public final FieldVisitor visitField(final int n, final String s, final String s2, final String s3, final Object o) {
        final FieldVisitor visitField;
        if ((visitField = super.visitField(n, this.remapper.mapFieldName$e96e693(this.className, s), this.remapper.mapDesc(s2), this.remapper.mapSignature(s3, true), this.remapper.mapValue(o))) == null) {
            return null;
        }
        return new FieldRemapper(visitField, this.remapper);
    }
    
    public final MethodVisitor visitMethod(final int n, final String s, final String s2, final String s3, final String[] array) {
        final MethodVisitor visitMethod;
        if ((visitMethod = super.visitMethod(n, this.remapper.mapMethodName(this.className, s, s2), this.remapper.mapMethodDesc(s2), this.remapper.mapSignature(s3, false), (String[])((array == null) ? null : this.remapper.mapTypes(array)))) == null) {
            return null;
        }
        return new MethodRemapper(visitMethod, this.remapper);
    }
    
    public void visitInnerClass(final String s, final String s2, final String s3, final int n) {
        super.visitInnerClass(this.remapper.mapType(s), (s2 == null) ? null : this.remapper.mapType(s2), s3, n);
    }
    
    public final void visitOuterClass(final String s, final String s2, final String s3) {
        super.visitOuterClass(this.remapper.mapType(s), (s2 == null) ? null : this.remapper.mapMethodName(s, s2, s3), (s3 == null) ? null : this.remapper.mapMethodDesc(s3));
    }
    
    private FieldVisitor createFieldRemapper(final FieldVisitor fieldVisitor) {
        return new FieldRemapper(fieldVisitor, this.remapper);
    }
    
    private MethodVisitor createMethodRemapper(final MethodVisitor methodVisitor) {
        return new MethodRemapper(methodVisitor, this.remapper);
    }
    
    private AnnotationVisitor createAnnotationRemapper(final AnnotationVisitor annotationVisitor) {
        return new AnnotationRemapper(annotationVisitor, this.remapper);
    }
}
