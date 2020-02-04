package org.spongepowered.asm.lib;

import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

public class ClassWriter extends ClassVisitor
{
    private static int COMPUTE_MAXS;
    private static int COMPUTE_FRAMES;
    private static int ACC_SYNTHETIC_ATTRIBUTE;
    private static int TO_ACC_SYNTHETIC;
    private static int NOARG_INSN;
    private static int SBYTE_INSN;
    private static int SHORT_INSN;
    private static int VAR_INSN;
    private static int IMPLVAR_INSN;
    private static int TYPE_INSN;
    private static int FIELDORMETH_INSN;
    private static int ITFMETH_INSN;
    private static int INDYMETH_INSN;
    private static int LABEL_INSN;
    private static int LABELW_INSN;
    private static int LDC_INSN;
    private static int LDCW_INSN;
    private static int IINC_INSN;
    private static int TABL_INSN;
    private static int LOOK_INSN;
    private static int MANA_INSN;
    private static int WIDE_INSN;
    private static int ASM_LABEL_INSN;
    private static int F_INSERT;
    static final byte[] TYPE;
    private static int CLASS;
    private static int FIELD;
    private static int METH;
    private static int IMETH;
    private static int STR;
    private static int INT;
    private static int FLOAT;
    private static int LONG;
    private static int DOUBLE;
    private static int NAME_TYPE;
    private static int UTF8;
    private static int MTYPE;
    private static int HANDLE;
    private static int INDY;
    private static int HANDLE_BASE;
    private static int TYPE_NORMAL;
    private static int TYPE_UNINIT;
    private static int TYPE_MERGED;
    private static int BSM;
    ClassReader cr;
    int version;
    int index;
    final ByteVector pool;
    Item[] items;
    int threshold;
    private Item key;
    private Item key2;
    private Item key3;
    private Item key4;
    Item[] typeTable;
    private short typeCount;
    private int access;
    private int name;
    String thisName;
    private int signature;
    private int superName;
    private int interfaceCount;
    private int[] interfaces;
    private int sourceFile;
    private ByteVector sourceDebug;
    private int enclosingMethodOwner;
    private int enclosingMethod;
    private AnnotationWriter anns;
    private AnnotationWriter ianns;
    private AnnotationWriter tanns;
    private AnnotationWriter itanns;
    private Attribute attrs;
    private int innerClassesCount;
    private ByteVector innerClasses;
    int bootstrapMethodsCount;
    ByteVector bootstrapMethods;
    FieldWriter firstField;
    FieldWriter lastField;
    MethodWriter firstMethod;
    MethodWriter lastMethod;
    private int compute;
    boolean hasAsmInsns;
    private static final String[] lIlIllIII;
    
    public ClassWriter(final int n) {
        super();
        this.index = 1;
        this.pool = new ByteVector();
        this.items = new Item[256];
        this.threshold = (int)(0.75 * this.items.length);
        this.key = new Item();
        this.key2 = new Item();
        this.key3 = new Item();
        this.key4 = new Item();
        this.compute = (((n & 0x2) != 0x0) ? 0 : (((n & 0x1) != 0x0) ? 2 : 3));
    }
    
    public ClassWriter(final ClassReader cr, final int n) {
        this(n);
        final char[] array = new char[cr.maxStringLength];
        final int length;
        final Item[] items = new Item[length = cr.items.length];
        for (int i = 1; i < length; ++i) {
            final int n2 = cr.items[i];
            final byte b = cr.b[n2 - 1];
            final Item item = new Item(i);
            switch (b) {
                case 9:
                case 10:
                case 11: {
                    final int n3 = cr.items[cr.readUnsignedShort(n2 + 2)];
                    item.set(b, cr.readClass(n2, array), cr.readUTF8(n3, array), cr.readUTF8(n3 + 2, array));
                    break;
                }
                case 3: {
                    item.set(cr.readInt(n2));
                    break;
                }
                case 4: {
                    item.set(Float.intBitsToFloat(cr.readInt(n2)));
                    break;
                }
                case 12: {
                    item.set(b, cr.readUTF8(n2, array), cr.readUTF8(n2 + 2, array), null);
                    break;
                }
                case 5: {
                    item.set(cr.readLong(n2));
                    ++i;
                    break;
                }
                case 6: {
                    item.set(Double.longBitsToDouble(cr.readLong(n2)));
                    ++i;
                    break;
                }
                case 1: {
                    String s;
                    if ((s = cr.strings[i]) == null) {
                        final int n4 = cr.items[i];
                        final String[] strings = cr.strings;
                        final int n5 = i;
                        final String utf = cr.readUTF(n4 + 2, cr.readUnsignedShort(n4), array);
                        strings[n5] = utf;
                        s = utf;
                    }
                    item.set(b, s, null, null);
                    break;
                }
                case 15: {
                    final int n6 = cr.items[cr.readUnsignedShort(n2 + 1)];
                    final int n7 = cr.items[cr.readUnsignedShort(n6 + 2)];
                    item.set(20 + cr.readByte(n2), cr.readClass(n6, array), cr.readUTF8(n7, array), cr.readUTF8(n7 + 2, array));
                    break;
                }
                case 18: {
                    if (this.bootstrapMethods == null) {
                        final Item[] array2 = items;
                        final char[] array3 = array;
                        final Item[] array4 = array2;
                        int attributes = cr.getAttributes();
                        boolean b2 = false;
                        for (int j = cr.readUnsignedShort(attributes); j > 0; --j) {
                            if (ClassReader.lIlIlIIIlII[0].equals(cr.readUTF8(attributes + 2, array3))) {
                                b2 = true;
                                break;
                            }
                            attributes += 6 + cr.readInt(attributes + 4);
                        }
                        if (b2) {
                            final int unsignedShort = cr.readUnsignedShort(attributes + 8);
                            int k = 0;
                            int n8 = attributes + 10;
                            while (k < unsignedShort) {
                                final int n9 = n8 - attributes - 10;
                                int hashCode = cr.readConst(cr.readUnsignedShort(n8), array3).hashCode();
                                for (int l = cr.readUnsignedShort(n8 + 2); l > 0; --l) {
                                    hashCode ^= cr.readConst(cr.readUnsignedShort(n8 + 4), array3).hashCode();
                                    n8 += 2;
                                }
                                n8 += 4;
                                final Item item2;
                                (item2 = new Item(k)).set(n9, hashCode & Integer.MAX_VALUE);
                                final int n10 = item2.hashCode % array4.length;
                                item2.next = array4[n10];
                                array4[n10] = item2;
                                ++k;
                            }
                            final int int1 = cr.readInt(attributes + 4);
                            final ByteVector bootstrapMethods;
                            (bootstrapMethods = new ByteVector(int1 + 62)).putByteArray(cr.b, attributes + 10, int1 - 2);
                            this.bootstrapMethodsCount = unsignedShort;
                            this.bootstrapMethods = bootstrapMethods;
                        }
                    }
                    final int n11 = cr.items[cr.readUnsignedShort(n2 + 2)];
                    item.set(cr.readUTF8(n11, array), cr.readUTF8(n11 + 2, array), cr.readUnsignedShort(n2));
                    break;
                }
                default: {
                    item.set(b, cr.readUTF8(n2, array), null, null);
                    break;
                }
            }
            final int n12 = item.hashCode % items.length;
            item.next = items[n12];
            items[n12] = item;
        }
        final int n13 = cr.items[1] - 1;
        this.pool.putByteArray(cr.b, n13, cr.header - n13);
        this.items = items;
        this.threshold = (int)(0.75 * length);
        this.index = length;
        this.cr = cr;
    }
    
    public final void visit(int i, final int access, final String thisName, final String s, final String s2, final String[] array) {
        this.version = i;
        this.access = access;
        this.name = this.newClass(thisName);
        this.thisName = thisName;
        if (s != null) {
            this.signature = this.newUTF8(s);
        }
        this.superName = ((s2 == null) ? 0 : this.newClass(s2));
        if (array != null && array.length > 0) {
            this.interfaceCount = array.length;
            this.interfaces = new int[this.interfaceCount];
            for (i = 0; i < this.interfaceCount; ++i) {
                this.interfaces[i] = this.newClass(array[i]);
            }
        }
    }
    
    public final void visitSource(final String s, final String s2) {
        if (s != null) {
            this.sourceFile = this.newUTF8(s);
        }
        if (s2 != null) {
            this.sourceDebug = new ByteVector().encodeUTF8(s2, 0, Integer.MAX_VALUE);
        }
    }
    
    public final void visitOuterClass(final String s, final String s2, final String s3) {
        this.enclosingMethodOwner = this.newClass(s);
        if (s2 != null && s3 != null) {
            this.enclosingMethod = this.newNameType(s2, s3);
        }
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final boolean b) {
        final ByteVector byteVector;
        (byteVector = new ByteVector()).putShort(this.newUTF8(s)).putShort(0);
        final boolean b2 = true;
        final ByteVector byteVector2 = byteVector;
        final AnnotationWriter annotationWriter = new AnnotationWriter(this, b2, byteVector2, byteVector2, 2);
        if (b) {
            annotationWriter.next = this.anns;
            this.anns = annotationWriter;
        }
        else {
            annotationWriter.next = this.ianns;
            this.ianns = annotationWriter;
        }
        return annotationWriter;
    }
    
    public final AnnotationVisitor visitTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        final ByteVector byteVector = new ByteVector();
        AnnotationWriter.putTarget(n, typePath, byteVector);
        byteVector.putShort(this.newUTF8(s)).putShort(0);
        final boolean b2 = true;
        final ByteVector byteVector2 = byteVector;
        final AnnotationWriter annotationWriter = new AnnotationWriter(this, b2, byteVector2, byteVector2, byteVector.length - 2);
        if (b) {
            annotationWriter.next = this.tanns;
            this.tanns = annotationWriter;
        }
        else {
            annotationWriter.next = this.itanns;
            this.itanns = annotationWriter;
        }
        return annotationWriter;
    }
    
    public final void visitAttribute(final Attribute attrs) {
        attrs.next = this.attrs;
        this.attrs = attrs;
    }
    
    public final void visitInnerClass(final String s, final String s2, final String s3, final int n) {
        if (this.innerClasses == null) {
            this.innerClasses = new ByteVector();
        }
        final Item classItem;
        if ((classItem = this.newClassItem(s)).intVal == 0) {
            ++this.innerClassesCount;
            this.innerClasses.putShort(classItem.index);
            this.innerClasses.putShort((s2 == null) ? 0 : this.newClass(s2));
            this.innerClasses.putShort((s3 == null) ? 0 : this.newUTF8(s3));
            this.innerClasses.putShort(n);
            classItem.intVal = this.innerClassesCount;
        }
    }
    
    public final FieldVisitor visitField(final int n, final String s, final String s2, final String s3, final Object o) {
        return new FieldWriter(this, n, s, s2, s3, o);
    }
    
    public final MethodVisitor visitMethod(final int n, final String s, final String s2, final String s3, final String[] array) {
        return new MethodWriter(this, n, s, s2, s3, array, this.compute);
    }
    
    public final void visitEnd() {
    }
    
    public final byte[] toByteArray() {
        while (!lIIIIlIIIll(this.index, 65535)) {
            int n = 24 + 2 * this.interfaceCount;
            int n2 = 0;
            for (FieldWriter firstField = this.firstField; firstField != null; firstField = (FieldWriter)firstField.fv) {
                ++n2;
                final int n3 = n;
                final FieldWriter fieldWriter = firstField;
                int n4 = 8;
                if (fieldWriter.value != 0) {
                    fieldWriter.cw.newUTF8(FieldWriter.llIIIIIlIlI[0]);
                    n4 += 8;
                }
                if ((fieldWriter.access & 0x1000) != 0x0 && (!FieldWriter.lIIlIllIllIll$255f299(fieldWriter.cw.version & 0xFFFF) || (fieldWriter.access & 0x40000) != 0x0)) {
                    fieldWriter.cw.newUTF8(FieldWriter.llIIIIIlIlI[1]);
                    n4 += 6;
                }
                if ((fieldWriter.access & 0x20000) != 0x0) {
                    fieldWriter.cw.newUTF8(FieldWriter.llIIIIIlIlI[2]);
                    n4 += 6;
                }
                if (fieldWriter.signature != 0) {
                    fieldWriter.cw.newUTF8(FieldWriter.llIIIIIlIlI[3]);
                    n4 += 8;
                }
                if (fieldWriter.anns != null) {
                    fieldWriter.cw.newUTF8(FieldWriter.llIIIIIlIlI[4]);
                    n4 += 8 + fieldWriter.anns.getSize();
                }
                if (fieldWriter.ianns != null) {
                    fieldWriter.cw.newUTF8(FieldWriter.llIIIIIlIlI[5]);
                    n4 += 8 + fieldWriter.ianns.getSize();
                }
                if (fieldWriter.tanns != null) {
                    fieldWriter.cw.newUTF8(FieldWriter.llIIIIIlIlI[6]);
                    n4 += 8 + fieldWriter.tanns.getSize();
                }
                if (fieldWriter.itanns != null) {
                    fieldWriter.cw.newUTF8(FieldWriter.llIIIIIlIlI[7]);
                    n4 += 8 + fieldWriter.itanns.getSize();
                }
                if (fieldWriter.attrs != null) {
                    n4 += fieldWriter.attrs.getSize$51cf92e0(fieldWriter.cw);
                }
                n = n3 + n4;
            }
            int n5 = 0;
            for (MethodWriter firstMethod = this.firstMethod; firstMethod != null; firstMethod = (MethodWriter)firstMethod.mv) {
                ++n5;
                n += firstMethod.getSize();
            }
            int n6 = 0;
            if (this.bootstrapMethods != null) {
                ++n6;
                n += 8 + this.bootstrapMethods.length;
                this.newUTF8(ClassWriter.lIlIllIII[1]);
            }
            if (this.signature != 0) {
                ++n6;
                n += 8;
                this.newUTF8(ClassWriter.lIlIllIII[2]);
            }
            if (this.sourceFile != 0) {
                ++n6;
                n += 8;
                this.newUTF8(ClassWriter.lIlIllIII[3]);
            }
            if (this.sourceDebug != null) {
                ++n6;
                n += this.sourceDebug.length + 6;
                this.newUTF8(ClassWriter.lIlIllIII[4]);
            }
            if (this.enclosingMethodOwner != 0) {
                ++n6;
                n += 10;
                this.newUTF8(ClassWriter.lIlIllIII[5]);
            }
            if ((this.access & 0x20000) != 0x0) {
                ++n6;
                n += 6;
                this.newUTF8(ClassWriter.lIlIllIII[6]);
            }
            if ((this.access & 0x1000) != 0x0 && (!lIIIIlIIlII$255f299(this.version & 0xFFFF) || (this.access & 0x40000) != 0x0)) {
                ++n6;
                n += 6;
                this.newUTF8(ClassWriter.lIlIllIII[7]);
            }
            if (this.innerClasses != null) {
                ++n6;
                n += 8 + this.innerClasses.length;
                this.newUTF8(ClassWriter.lIlIllIII[8]);
            }
            if (this.anns != null) {
                ++n6;
                n += 8 + this.anns.getSize();
                this.newUTF8(ClassWriter.lIlIllIII[9]);
            }
            if (this.ianns != null) {
                ++n6;
                n += 8 + this.ianns.getSize();
                this.newUTF8(ClassWriter.lIlIllIII[10]);
            }
            if (this.tanns != null) {
                ++n6;
                n += 8 + this.tanns.getSize();
                this.newUTF8(ClassWriter.lIlIllIII[11]);
            }
            if (this.itanns != null) {
                ++n6;
                n += 8 + this.itanns.getSize();
                this.newUTF8(ClassWriter.lIlIllIII[12]);
            }
            if (this.attrs != null) {
                n6 += this.attrs.getCount();
                n += this.attrs.getSize$51cf92e0(this);
            }
            final ByteVector byteVector;
            (byteVector = new ByteVector(n + this.pool.length)).putInt(-889275714).putInt(this.version);
            byteVector.putShort(this.index).putByteArray(this.pool.data, 0, this.pool.length);
            byteVector.putShort(this.access & ~(0x60000 | (this.access & 0x40000) / 64)).putShort(this.name).putShort(this.superName);
            byteVector.putShort(this.interfaceCount);
            for (int i = 0; i < this.interfaceCount; ++i) {
                byteVector.putShort(this.interfaces[i]);
            }
            byteVector.putShort(n2);
            for (FieldWriter firstField2 = this.firstField; firstField2 != null; firstField2 = (FieldWriter)firstField2.fv) {
                final FieldWriter fieldWriter2 = firstField2;
                final ByteVector byteVector2 = byteVector;
                final FieldWriter fieldWriter3 = fieldWriter2;
                byteVector2.putShort(fieldWriter3.access & ~(0x60000 | (fieldWriter3.access & 0x40000) / 64)).putShort(fieldWriter3.name).putShort(fieldWriter3.desc);
                int n7 = 0;
                if (fieldWriter3.value != 0) {
                    ++n7;
                }
                if ((fieldWriter3.access & 0x1000) != 0x0 && (!FieldWriter.lIIlIllIllIll$255f299(fieldWriter3.cw.version & 0xFFFF) || (fieldWriter3.access & 0x40000) != 0x0)) {
                    ++n7;
                }
                if ((fieldWriter3.access & 0x20000) != 0x0) {
                    ++n7;
                }
                if (fieldWriter3.signature != 0) {
                    ++n7;
                }
                if (fieldWriter3.anns != null) {
                    ++n7;
                }
                if (fieldWriter3.ianns != null) {
                    ++n7;
                }
                if (fieldWriter3.tanns != null) {
                    ++n7;
                }
                if (fieldWriter3.itanns != null) {
                    ++n7;
                }
                if (fieldWriter3.attrs != null) {
                    n7 += fieldWriter3.attrs.getCount();
                }
                byteVector2.putShort(n7);
                if (fieldWriter3.value != 0) {
                    byteVector2.putShort(fieldWriter3.cw.newUTF8(FieldWriter.llIIIIIlIlI[8]));
                    byteVector2.putInt(2).putShort(fieldWriter3.value);
                }
                if ((fieldWriter3.access & 0x1000) != 0x0 && (!FieldWriter.lIIlIllIllIll$255f299(fieldWriter3.cw.version & 0xFFFF) || (fieldWriter3.access & 0x40000) != 0x0)) {
                    byteVector2.putShort(fieldWriter3.cw.newUTF8(FieldWriter.llIIIIIlIlI[9])).putInt(0);
                }
                if ((fieldWriter3.access & 0x20000) != 0x0) {
                    byteVector2.putShort(fieldWriter3.cw.newUTF8(FieldWriter.llIIIIIlIlI[10])).putInt(0);
                }
                if (fieldWriter3.signature != 0) {
                    byteVector2.putShort(fieldWriter3.cw.newUTF8(FieldWriter.llIIIIIlIlI[11]));
                    byteVector2.putInt(2).putShort(fieldWriter3.signature);
                }
                if (fieldWriter3.anns != null) {
                    byteVector2.putShort(fieldWriter3.cw.newUTF8(FieldWriter.llIIIIIlIlI[12]));
                    fieldWriter3.anns.put(byteVector2);
                }
                if (fieldWriter3.ianns != null) {
                    byteVector2.putShort(fieldWriter3.cw.newUTF8(FieldWriter.llIIIIIlIlI[13]));
                    fieldWriter3.ianns.put(byteVector2);
                }
                if (fieldWriter3.tanns != null) {
                    byteVector2.putShort(fieldWriter3.cw.newUTF8(FieldWriter.llIIIIIlIlI[14]));
                    fieldWriter3.tanns.put(byteVector2);
                }
                if (fieldWriter3.itanns != null) {
                    byteVector2.putShort(fieldWriter3.cw.newUTF8(FieldWriter.llIIIIIlIlI[15]));
                    fieldWriter3.itanns.put(byteVector2);
                }
                if (fieldWriter3.attrs != null) {
                    fieldWriter3.attrs.put$2136a1dd(fieldWriter3.cw, byteVector2);
                }
            }
            byteVector.putShort(n5);
            for (MethodWriter firstMethod2 = this.firstMethod; firstMethod2 != null; firstMethod2 = (MethodWriter)firstMethod2.mv) {
                firstMethod2.put(byteVector);
            }
            byteVector.putShort(n6);
            if (this.bootstrapMethods != null) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[13]));
                byteVector.putInt(this.bootstrapMethods.length + 2).putShort(this.bootstrapMethodsCount);
                byteVector.putByteArray(this.bootstrapMethods.data, 0, this.bootstrapMethods.length);
            }
            if (this.signature != 0) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[14])).putInt(2).putShort(this.signature);
            }
            if (this.sourceFile != 0) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[15])).putInt(2).putShort(this.sourceFile);
            }
            if (this.sourceDebug != null) {
                final int length = this.sourceDebug.length;
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[16])).putInt(length);
                byteVector.putByteArray(this.sourceDebug.data, 0, length);
            }
            if (this.enclosingMethodOwner != 0) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[17])).putInt(4);
                byteVector.putShort(this.enclosingMethodOwner).putShort(this.enclosingMethod);
            }
            if ((this.access & 0x20000) != 0x0) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[18])).putInt(0);
            }
            if ((this.access & 0x1000) != 0x0 && (!lIIIIlIIlII$255f299(this.version & 0xFFFF) || (this.access & 0x40000) != 0x0)) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[19])).putInt(0);
            }
            if (this.innerClasses != null) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[20]));
                byteVector.putInt(this.innerClasses.length + 2).putShort(this.innerClassesCount);
                byteVector.putByteArray(this.innerClasses.data, 0, this.innerClasses.length);
            }
            if (this.anns != null) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[21]));
                this.anns.put(byteVector);
            }
            if (this.ianns != null) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[22]));
                this.ianns.put(byteVector);
            }
            if (this.tanns != null) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[23]));
                this.tanns.put(byteVector);
            }
            if (this.itanns != null) {
                byteVector.putShort(this.newUTF8(ClassWriter.lIlIllIII[24]));
                this.itanns.put(byteVector);
            }
            if (this.attrs != null) {
                this.attrs.put$2136a1dd(this, byteVector);
            }
            if (!this.hasAsmInsns) {
                return byteVector.data;
            }
            this.anns = null;
            this.ianns = null;
            this.attrs = null;
            this.innerClassesCount = 0;
            this.innerClasses = null;
            this.firstField = null;
            this.lastField = null;
            this.firstMethod = null;
            this.lastMethod = null;
            this.compute = 1;
            this.hasAsmInsns = false;
            new ClassReader(byteVector.data).accept(this, 264);
        }
        throw new RuntimeException(ClassWriter.lIlIllIII[0]);
    }
    
    final Item newConstItem(final Object o) {
        if (o instanceof Integer) {
            return this.newInteger((int)o);
        }
        if (o instanceof Byte) {
            return this.newInteger((int)o);
        }
        if (o instanceof Character) {
            return this.newInteger((char)o);
        }
        if (o instanceof Short) {
            return this.newInteger((int)o);
        }
        if (o instanceof Boolean) {
            return this.newInteger(((boolean)o) ? 1 : 0);
        }
        if (o instanceof Float) {
            return this.newFloat((float)o);
        }
        if (o instanceof Long) {
            return this.newLong((long)o);
        }
        if (o instanceof Double) {
            return this.newDouble((double)o);
        }
        if (o instanceof String) {
            final String s = (String)o;
            this.key2.set(8, s, null, null);
            Item value;
            if ((value = this.get(this.key2)) == null) {
                this.pool.put12(8, this.newUTF8(s));
                value = new Item(this.index++, this.key2);
                this.put(value);
            }
            return value;
        }
        if (o instanceof Type) {
            final Type type;
            final int sort;
            if ((sort = (type = (Type)o).sort) == 10) {
                return this.newClassItem(type.getInternalName());
            }
            if (sort == 11) {
                return this.newMethodTypeItem(type.getDescriptor());
            }
            return this.newClassItem(type.getDescriptor());
        }
        else {
            if (o instanceof Handle) {
                final Handle handle = (Handle)o;
                return this.newHandleItem(handle.tag, handle.owner, handle.name, handle.desc, handle.itf);
            }
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(ClassWriter.lIlIllIII[25]).append(o)));
        }
    }
    
    private int newConst(final Object o) {
        return this.newConstItem(o).index;
    }
    
    public final int newUTF8(final String s) {
        this.key.set(1, s, null, null);
        Item value;
        if ((value = this.get(this.key)) == null) {
            this.pool.putByte(1).putUTF8(s);
            value = new Item(this.index++, this.key);
            this.put(value);
        }
        return value.index;
    }
    
    final Item newClassItem(final String s) {
        this.key2.set(7, s, null, null);
        Item value;
        if ((value = this.get(this.key2)) == null) {
            this.pool.put12(7, this.newUTF8(s));
            value = new Item(this.index++, this.key2);
            this.put(value);
        }
        return value;
    }
    
    public final int newClass(final String s) {
        return this.newClassItem(s).index;
    }
    
    private Item newMethodTypeItem(final String s) {
        this.key2.set(16, s, null, null);
        Item value;
        if ((value = this.get(this.key2)) == null) {
            this.pool.put12(16, this.newUTF8(s));
            value = new Item(this.index++, this.key2);
            this.put(value);
        }
        return value;
    }
    
    private int newMethodType(final String s) {
        return this.newMethodTypeItem(s).index;
    }
    
    private Item newHandleItem(final int n, final String s, final String s2, final String s3, final boolean b) {
        this.key4.set(n + 20, s, s2, s3);
        Item value;
        if ((value = this.get(this.key4)) == null) {
            if (lIIIIlIIlll$255f299(n)) {
                this.put112$4868d30e(n, this.newField(s, s2, s3));
            }
            else {
                this.put112$4868d30e(n, this.newMethod(s, s2, s3, b));
            }
            value = new Item(this.index++, this.key4);
            this.put(value);
        }
        return value;
    }
    
    @Deprecated
    private int newHandle(final int n, final String s, final String s2, final String s3) {
        return this.newHandle(n, s, s2, s3, n == 9);
    }
    
    private int newHandle(final int n, final String s, final String s2, final String s3, final boolean b) {
        return this.newHandleItem(n, s, s2, s3, b).index;
    }
    
    final Item newInvokeDynamicItem(final String s, final String s2, final Handle handle, final Object... array) {
        ByteVector bootstrapMethods;
        if ((bootstrapMethods = this.bootstrapMethods) == null) {
            final ByteVector bootstrapMethods2 = new ByteVector();
            this.bootstrapMethods = bootstrapMethods2;
            bootstrapMethods = bootstrapMethods2;
        }
        final int length = bootstrapMethods.length;
        int hashCode = handle.hashCode();
        bootstrapMethods.putShort(this.newHandle(handle.tag, handle.owner, handle.name, handle.desc, handle.itf));
        final int length2 = array.length;
        bootstrapMethods.putShort(length2);
        for (final Object o : array) {
            hashCode ^= o.hashCode();
            bootstrapMethods.putShort(this.newConstItem(o).index);
        }
        final byte[] data = bootstrapMethods.data;
        final int n = length2 + 2 << 1;
        final int n3;
        final int n2 = n3 = (hashCode & Integer.MAX_VALUE);
        final Item[] items = this.items;
        Item item = items[n2 % items.length];
    Label_0157:
        while (item != null) {
            if (item.type == 33 && !lIIIIlIlIII(item.hashCode, n3)) {
                final int intVal = item.intVal;
                for (int j = 0; j < n; ++j) {
                    if (lIIIIlIlIII(data[length + j], data[intVal + j])) {
                        item = item.next;
                        continue Label_0157;
                    }
                }
                break;
            }
            item = item.next;
        }
        int index;
        if (item != null) {
            index = item.index;
            bootstrapMethods.length = length;
        }
        else {
            index = this.bootstrapMethodsCount++;
            final Item item2;
            (item2 = new Item(index)).set(length, n3);
            this.put(item2);
        }
        this.key3.set(s, s2, index);
        Item value;
        if ((value = this.get(this.key3)) == null) {
            this.put122(18, index, this.newNameType(s, s2));
            value = new Item(this.index++, this.key3);
            this.put(value);
        }
        return value;
    }
    
    private int newInvokeDynamic(final String s, final String s2, final Handle handle, final Object... array) {
        return this.newInvokeDynamicItem(s, s2, handle, array).index;
    }
    
    final Item newFieldItem(final String s, final String s2, final String s3) {
        this.key3.set(9, s, s2, s3);
        Item value;
        if ((value = this.get(this.key3)) == null) {
            this.put122(9, this.newClass(s), this.newNameType(s2, s3));
            value = new Item(this.index++, this.key3);
            this.put(value);
        }
        return value;
    }
    
    private int newField(final String s, final String s2, final String s3) {
        return this.newFieldItem(s, s2, s3).index;
    }
    
    final Item newMethodItem(final String s, final String s2, final String s3, final boolean b) {
        final int n = b ? 11 : 10;
        this.key3.set(n, s, s2, s3);
        Item value;
        if ((value = this.get(this.key3)) == null) {
            this.put122(n, this.newClass(s), this.newNameType(s2, s3));
            value = new Item(this.index++, this.key3);
            this.put(value);
        }
        return value;
    }
    
    private int newMethod(final String s, final String s2, final String s3, final boolean b) {
        return this.newMethodItem(s, s2, s3, b).index;
    }
    
    final Item newInteger(final int n) {
        this.key.set(n);
        Item value;
        if ((value = this.get(this.key)) == null) {
            this.pool.putByte(3).putInt(n);
            value = new Item(this.index++, this.key);
            this.put(value);
        }
        return value;
    }
    
    final Item newFloat(final float n) {
        this.key.set(n);
        Item value;
        if ((value = this.get(this.key)) == null) {
            this.pool.putByte(4).putInt(this.key.intVal);
            value = new Item(this.index++, this.key);
            this.put(value);
        }
        return value;
    }
    
    final Item newLong(final long n) {
        this.key.set(n);
        Item value;
        if ((value = this.get(this.key)) == null) {
            this.pool.putByte(5).putLong(n);
            value = new Item(this.index, this.key);
            this.index += 2;
            this.put(value);
        }
        return value;
    }
    
    final Item newDouble(final double n) {
        this.key.set(n);
        Item value;
        if ((value = this.get(this.key)) == null) {
            this.pool.putByte(6).putLong(this.key.longVal);
            value = new Item(this.index, this.key);
            this.index += 2;
            this.put(value);
        }
        return value;
    }
    
    private Item newString(final String s) {
        this.key2.set(8, s, null, null);
        Item value;
        if ((value = this.get(this.key2)) == null) {
            this.pool.put12(8, this.newUTF8(s));
            value = new Item(this.index++, this.key2);
            this.put(value);
        }
        return value;
    }
    
    private int newNameType(final String s, String s2) {
        final String s3 = s2;
        s2 = s;
        this.key2.set(12, s2, s3, null);
        Item value;
        if ((value = this.get(this.key2)) == null) {
            this.put122(12, this.newUTF8(s2), this.newUTF8(s3));
            value = new Item(this.index++, this.key2);
            this.put(value);
        }
        return value.index;
    }
    
    private Item newNameTypeItem(final String s, final String s2) {
        this.key2.set(12, s, s2, null);
        Item value;
        if ((value = this.get(this.key2)) == null) {
            this.put122(12, this.newUTF8(s), this.newUTF8(s2));
            value = new Item(this.index++, this.key2);
            this.put(value);
        }
        return value;
    }
    
    final int addType(final String s) {
        this.key.set(30, s, null, null);
        Item item;
        if ((item = this.get(this.key)) == null) {
            item = this.addType$67ce3d3f();
        }
        return item.index;
    }
    
    final int addUninitializedType(final String strVal1, final int intVal) {
        this.key.type = 31;
        this.key.intVal = intVal;
        this.key.strVal1 = strVal1;
        this.key.hashCode = (Integer.MAX_VALUE & 31 + strVal1.hashCode() + intVal);
        Item item;
        if ((item = this.get(this.key)) == null) {
            item = this.addType$67ce3d3f();
        }
        return item.index;
    }
    
    private Item addType$67ce3d3f() {
        ++this.typeCount;
        final Item item = new Item(this.typeCount, this.key);
        this.put(item);
        if (this.typeTable == null) {
            this.typeTable = new Item[16];
        }
        if (this.typeCount == this.typeTable.length) {
            final Item[] typeTable = new Item[2 * this.typeTable.length];
            System.arraycopy(this.typeTable, 0, typeTable, 0, this.typeTable.length);
            this.typeTable = typeTable;
        }
        return this.typeTable[this.typeCount] = item;
    }
    
    final int getMergedType(final int n, final int n2) {
        this.key2.type = 32;
        this.key2.longVal = (n | n2 << 32);
        this.key2.hashCode = (Integer.MAX_VALUE & n + 32 + n2);
        Item value;
        if ((value = this.get(this.key2)) == null) {
            this.key2.intVal = this.addType(this.getCommonSuperClass(this.typeTable[n].strVal1, this.typeTable[n2].strVal1));
            value = new Item(0, this.key2);
            this.put(value);
        }
        return value.intVal;
    }
    
    protected String getCommonSuperClass(final String s, final String s2) {
        final ClassLoader classLoader = this.getClass().getClassLoader();
        final char c = '/';
        final char c2 = '.';
        Class<?> clazz;
        Class<?> forName;
        try {
            clazz = Class.forName(s.replace(c, c2), false, classLoader);
            forName = Class.forName(s2.replace('/', '.'), false, classLoader);
        }
        catch (Exception ex) {
            throw new RuntimeException(ex.toString());
        }
        if (clazz.isAssignableFrom(forName)) {
            return s;
        }
        if (forName.isAssignableFrom(clazz)) {
            return s2;
        }
        if (clazz.isInterface() || forName.isInterface()) {
            return ClassWriter.lIlIllIII[26];
        }
        while (!(clazz = clazz.getSuperclass()).isAssignableFrom(forName)) {}
        return clazz.getName().replace('.', '/');
    }
    
    private Item get(final Item item) {
        Item next;
        for (next = this.items[item.hashCode % this.items.length]; next != null && (next.type != item.type || !item.isEqualTo(next)); next = next.next) {}
        return next;
    }
    
    private void put(final Item item) {
        if (lIIIIlIIIll(this.index + this.typeCount, this.threshold)) {
            int i;
            final int n;
            final Item[] items = new Item[n = (i = this.items.length) * 2 + 1];
            --i;
            while (i >= 0) {
                Item next;
                for (Item item2 = this.items[i]; item2 != null; item2 = next) {
                    final int n2 = item2.hashCode % n;
                    next = item2.next;
                    item2.next = items[n2];
                    items[n2] = item2;
                }
                --i;
            }
            this.items = items;
            this.threshold = (int)(n * 0.75);
        }
        final int n3 = item.hashCode % this.items.length;
        item.next = this.items[n3];
        this.items[n3] = item;
    }
    
    private void put122(final int n, final int n2, final int n3) {
        this.pool.put12(n, n2).putShort(n3);
    }
    
    private void put112$4868d30e(final int n, final int n2) {
        this.pool.put11(15, n).putShort(n2);
    }
    
    static {
        lllIllIlIl();
        final byte[] type = new byte[220];
        final String s = ClassWriter.lIlIllIII[27];
        for (int i = 0; i < 220; ++i) {
            type[i] = (byte)(s.charAt(i) - 'A');
        }
        TYPE = type;
    }
    
    private static void lllIllIlIl() {
        (lIlIllIII = new String[28])[0] = "Class file too large!";
        ClassWriter.lIlIllIII[1] = "BootstrapMethods";
        ClassWriter.lIlIllIII[2] = "Signature";
        ClassWriter.lIlIllIII[3] = "SourceFile";
        ClassWriter.lIlIllIII[4] = "SourceDebugExtension";
        ClassWriter.lIlIllIII[5] = "EnclosingMethod";
        ClassWriter.lIlIllIII[6] = "Deprecated";
        ClassWriter.lIlIllIII[7] = "Synthetic";
        ClassWriter.lIlIllIII[8] = "InnerClasses";
        ClassWriter.lIlIllIII[9] = "RuntimeVisibleAnnotations";
        ClassWriter.lIlIllIII[10] = "RuntimeInvisibleAnnotations";
        ClassWriter.lIlIllIII[11] = "RuntimeVisibleTypeAnnotations";
        ClassWriter.lIlIllIII[12] = "RuntimeInvisibleTypeAnnotations";
        ClassWriter.lIlIllIII[13] = "BootstrapMethods";
        ClassWriter.lIlIllIII[14] = "Signature";
        ClassWriter.lIlIllIII[15] = "SourceFile";
        ClassWriter.lIlIllIII[16] = "SourceDebugExtension";
        ClassWriter.lIlIllIII[17] = "EnclosingMethod";
        ClassWriter.lIlIllIII[18] = "Deprecated";
        ClassWriter.lIlIllIII[19] = "Synthetic";
        ClassWriter.lIlIllIII[20] = "InnerClasses";
        ClassWriter.lIlIllIII[21] = "RuntimeVisibleAnnotations";
        ClassWriter.lIlIllIII[22] = "RuntimeInvisibleAnnotations";
        ClassWriter.lIlIllIII[23] = "RuntimeVisibleTypeAnnotations";
        ClassWriter.lIlIllIII[24] = "RuntimeInvisibleTypeAnnotations";
        ClassWriter.lIlIllIII[25] = "value ";
        ClassWriter.lIlIllIII[26] = "java/lang/Object";
        ClassWriter.lIlIllIII[27] = "AAAAAAAAAAAAAAAABCLMMDDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAADDDDDEEEEEEEEEEEEEEEEEEEEAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAANAAAAAAAAAAAAAAAAAAAAJJJJJJJJJJJJJJJJDOPAAAAAAGGGGGGGHIFBFAAFFAARQJJKKSSSSSSSSSSSSSSSSSS";
    }
    
    private static String lllIlIlIIl(String s, final String s2) {
        s = new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        final StringBuilder sb = new StringBuilder();
        final char[] charArray = s2.toCharArray();
        int n = 0;
        char[] charArray2;
        for (int length = (charArray2 = s.toCharArray()).length, i = 0; i < length; ++i) {
            sb.append((char)(charArray2[i] ^ charArray[n % charArray.length]));
            ++n;
        }
        return String.valueOf(sb);
    }
    
    private static String lllIlIlIlI(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("DES")).init(2, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), 8), "DES"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String lllIlIllIl(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("Blowfish")).init(2, new SecretKeySpec(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), "Blowfish"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static boolean lIIIIlIIlII$255f299(final int n) {
        return n >= 49;
    }
    
    private static boolean lIIIIlIIlll$255f299(final int n) {
        return n <= 4;
    }
    
    private static boolean lIIIIlIIIll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIIIlIlllI(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIIIlIIIII(final int n) {
        return n > 0;
    }
    
    private static boolean lIIIIlIlIII(final int n, final int n2) {
        return n != n2;
    }
}
