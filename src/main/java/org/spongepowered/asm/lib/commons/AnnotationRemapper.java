package org.spongepowered.asm.lib.commons;

import org.spongepowered.asm.lib.*;

public final class AnnotationRemapper extends AnnotationVisitor
{
    private Remapper remapper;
    
    public AnnotationRemapper(final AnnotationVisitor annotationVisitor, final Remapper remapper) {
        this(annotationVisitor, remapper, (byte)0);
    }
    
    private AnnotationRemapper(final AnnotationVisitor annotationVisitor, final Remapper remapper, final byte b) {
        super(327680, annotationVisitor);
        this.remapper = remapper;
    }
    
    public final void visit(final String s, final Object o) {
        this.av.visit(s, this.remapper.mapValue(o));
    }
    
    public final void visitEnum(final String s, final String s2, final String s3) {
        this.av.visitEnum(s, this.remapper.mapDesc(s2), s3);
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final String s2) {
        final AnnotationVisitor visitAnnotation;
        if ((visitAnnotation = this.av.visitAnnotation(s, this.remapper.mapDesc(s2))) == null) {
            return null;
        }
        if (llIIlllll(visitAnnotation, this.av)) {
            return this;
        }
        return new AnnotationRemapper(visitAnnotation, this.remapper);
    }
    
    public final AnnotationVisitor visitArray(final String s) {
        final AnnotationVisitor visitArray;
        if ((visitArray = this.av.visitArray(s)) == null) {
            return null;
        }
        if (llIIlllll(visitArray, this.av)) {
            return this;
        }
        return new AnnotationRemapper(visitArray, this.remapper);
    }
    
    private static boolean llIIlllll(final Object o, final Object o2) {
        return o == o2;
    }
}
