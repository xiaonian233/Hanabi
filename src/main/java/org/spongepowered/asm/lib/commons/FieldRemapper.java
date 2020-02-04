package org.spongepowered.asm.lib.commons;

import org.spongepowered.asm.lib.*;

public final class FieldRemapper extends FieldVisitor
{
    private final Remapper remapper;
    
    public FieldRemapper(final FieldVisitor fieldVisitor, final Remapper remapper) {
        this(fieldVisitor, remapper, (byte)0);
    }
    
    private FieldRemapper(final FieldVisitor fieldVisitor, final Remapper remapper, final byte b) {
        super(fieldVisitor);
        this.remapper = remapper;
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final boolean b) {
        final AnnotationVisitor visitAnnotation;
        if ((visitAnnotation = this.fv.visitAnnotation(this.remapper.mapDesc(s), b)) == null) {
            return null;
        }
        return new AnnotationRemapper(visitAnnotation, this.remapper);
    }
    
    public final AnnotationVisitor visitTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        final AnnotationVisitor visitTypeAnnotation;
        if ((visitTypeAnnotation = super.visitTypeAnnotation(n, typePath, this.remapper.mapDesc(s), b)) == null) {
            return null;
        }
        return new AnnotationRemapper(visitTypeAnnotation, this.remapper);
    }
}
