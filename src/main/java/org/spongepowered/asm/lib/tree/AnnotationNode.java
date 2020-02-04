package org.spongepowered.asm.lib.tree;

import org.spongepowered.asm.lib.*;
import java.util.*;

public class AnnotationNode extends AnnotationVisitor
{
    public String desc;
    public List<Object> values;
    
    public AnnotationNode(final String s) {
        this(s, (byte)0);
        if (this.getClass() != AnnotationNode.class) {
            throw new IllegalStateException();
        }
    }
    
    public AnnotationNode(final String desc, final byte b) {
        super();
        this.desc = desc;
    }
    
    AnnotationNode(final List<Object> values) {
        super();
        this.values = values;
    }
    
    public final void visit(final String s, final Object o) {
        if (this.values == null) {
            this.values = new ArrayList<Object>((this.desc != null) ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(s);
        }
        if (o instanceof byte[]) {
            final byte[] array = (byte[])o;
            final ArrayList list = new ArrayList<Byte>(array.length);
            for (int length = array.length, i = 0; i < length; ++i) {
                list.add(array[i]);
            }
            this.values.add(list);
            return;
        }
        if (o instanceof boolean[]) {
            final boolean[] array2 = (boolean[])o;
            final ArrayList list2 = new ArrayList<Boolean>(array2.length);
            for (int length2 = array2.length, j = 0; j < length2; ++j) {
                list2.add(array2[j]);
            }
            this.values.add(list2);
            return;
        }
        if (o instanceof short[]) {
            final short[] array3 = (short[])o;
            final ArrayList list3 = new ArrayList<Short>(array3.length);
            for (int length3 = array3.length, k = 0; k < length3; ++k) {
                list3.add(array3[k]);
            }
            this.values.add(list3);
            return;
        }
        if (o instanceof char[]) {
            final char[] array4 = (char[])o;
            final ArrayList list4 = new ArrayList<Character>(array4.length);
            for (int length4 = array4.length, l = 0; l < length4; ++l) {
                list4.add(array4[l]);
            }
            this.values.add(list4);
            return;
        }
        if (o instanceof int[]) {
            final int[] array5 = (int[])o;
            final ArrayList list5 = new ArrayList<Integer>(array5.length);
            for (int length5 = array5.length, n = 0; n < length5; ++n) {
                list5.add(array5[n]);
            }
            this.values.add(list5);
            return;
        }
        if (o instanceof long[]) {
            final long[] array6 = (long[])o;
            final ArrayList list6 = new ArrayList<Long>(array6.length);
            for (int length6 = array6.length, n2 = 0; n2 < length6; ++n2) {
                list6.add(array6[n2]);
            }
            this.values.add(list6);
            return;
        }
        if (o instanceof float[]) {
            final float[] array7 = (float[])o;
            final ArrayList list7 = new ArrayList<Float>(array7.length);
            for (int length7 = array7.length, n3 = 0; n3 < length7; ++n3) {
                list7.add(array7[n3]);
            }
            this.values.add(list7);
            return;
        }
        if (o instanceof double[]) {
            final double[] array8 = (double[])o;
            final ArrayList list8 = new ArrayList<Double>(array8.length);
            for (int length8 = array8.length, n4 = 0; n4 < length8; ++n4) {
                list8.add(array8[n4]);
            }
            this.values.add(list8);
            return;
        }
        this.values.add(o);
    }
    
    public final void visitEnum(final String s, final String s2, final String s3) {
        if (this.values == null) {
            this.values = new ArrayList<Object>((this.desc != null) ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(s);
        }
        this.values.add(new String[] { s2, s3 });
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final String s2) {
        if (this.values == null) {
            this.values = new ArrayList<Object>((this.desc != null) ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(s);
        }
        final AnnotationNode annotationNode = new AnnotationNode(s2);
        this.values.add(annotationNode);
        return annotationNode;
    }
    
    public final AnnotationVisitor visitArray(final String s) {
        if (this.values == null) {
            this.values = new ArrayList<Object>((this.desc != null) ? 2 : 1);
        }
        if (this.desc != null) {
            this.values.add(s);
        }
        final ArrayList<Object> list = new ArrayList<Object>();
        this.values.add(list);
        return new AnnotationNode(list);
    }
    
    public final void visitEnd() {
    }
    
    private static void check$13462e() {
    }
    
    public final void accept(final AnnotationVisitor annotationVisitor) {
        if (annotationVisitor != null) {
            if (this.values != null) {
                for (int i = 0; i < this.values.size(); i += 2) {
                    accept(annotationVisitor, (String)this.values.get(i), this.values.get(i + 1));
                }
            }
            annotationVisitor.visitEnd();
        }
    }
    
    static void accept(final AnnotationVisitor annotationVisitor, final String s, final Object o) {
        if (annotationVisitor != null) {
            if (o instanceof String[]) {
                final String[] array = (String[])o;
                annotationVisitor.visitEnum(s, array[0], array[1]);
                return;
            }
            if (o instanceof AnnotationNode) {
                final AnnotationNode annotationNode = (AnnotationNode)o;
                annotationNode.accept(annotationVisitor.visitAnnotation(s, annotationNode.desc));
                return;
            }
            if (o instanceof List) {
                final AnnotationVisitor visitArray;
                if ((visitArray = annotationVisitor.visitArray(s)) != null) {
                    final List list = (List)o;
                    for (int i = 0; i < list.size(); ++i) {
                        accept(visitArray, null, list.get(i));
                    }
                    visitArray.visitEnd();
                }
                return;
            }
            annotationVisitor.visit(s, o);
        }
    }
    
    private static boolean lllIIIllIIII(final Object o, final Object o2) {
        return o != o2;
    }
}
