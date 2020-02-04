package org.spongepowered.asm.lib;

import java.io.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class ClassReader
{
    private static boolean SIGNATURES;
    private static boolean ANNOTATIONS;
    private static boolean FRAMES;
    private static boolean WRITER;
    private static boolean RESIZE;
    private static int SKIP_CODE;
    private static int SKIP_DEBUG;
    private static int SKIP_FRAMES;
    private static int EXPAND_FRAMES;
    private static int EXPAND_ASM_INSNS;
    public final byte[] b;
    final int[] items;
    final String[] strings;
    final int maxStringLength;
    public final int header;
    static final String[] lIlIlIIIlII;
    
    public ClassReader(final byte[] array) {
        this(array, (byte)0);
    }
    
    private ClassReader(final byte[] b, final byte b2) {
        super();
        this.b = b;
        if (lllIlllIlllI(this.readShort(6), 52)) {
            throw new IllegalArgumentException();
        }
        this.items = new int[this.readUnsignedShort(8)];
        final int length = this.items.length;
        this.strings = new String[length];
        int maxStringLength = 0;
        int header = 10;
        for (int i = 1; i < length; ++i) {
            this.items[i] = header + 1;
            int n = 0;
            switch (b[header]) {
                case 3:
                case 4:
                case 9:
                case 10:
                case 11:
                case 12:
                case 18: {
                    n = 5;
                    break;
                }
                case 5:
                case 6: {
                    n = 9;
                    ++i;
                    break;
                }
                case 1: {
                    if (lllIlllIlllI(n = 3 + this.readUnsignedShort(header + 1), maxStringLength)) {
                        maxStringLength = n;
                        break;
                    }
                    break;
                }
                case 15: {
                    n = 4;
                    break;
                }
                default: {
                    n = 3;
                    break;
                }
            }
            header += n;
        }
        this.maxStringLength = maxStringLength;
        this.header = header;
    }
    
    private int getAccess() {
        return this.readUnsignedShort(this.header);
    }
    
    private String getClassName() {
        return this.readClass(this.header + 2, new char[this.maxStringLength]);
    }
    
    private String getSuperName() {
        return this.readClass(this.header + 4, new char[this.maxStringLength]);
    }
    
    private String[] getInterfaces() {
        int n = this.header + 6;
        final int unsignedShort;
        final String[] array = new String[unsignedShort = this.readUnsignedShort(n)];
        if (unsignedShort > 0) {
            final char[] array2 = new char[this.maxStringLength];
            for (int i = 0; i < unsignedShort; ++i) {
                n += 2;
                array[i] = this.readClass(n, array2);
            }
        }
        return array;
    }
    
    private void copyPool(final ClassWriter classWriter) {
        final char[] array = new char[this.maxStringLength];
        final int length;
        final Item[] items = new Item[length = this.items.length];
        for (int i = 1; i < length; ++i) {
            final int n = this.items[i];
            final byte b = this.b[n - 1];
            final Item item = new Item(i);
            switch (b) {
                case 9:
                case 10:
                case 11: {
                    final int n2 = this.items[this.readUnsignedShort(n + 2)];
                    item.set(b, this.readClass(n, array), this.readUTF8(n2, array), this.readUTF8(n2 + 2, array));
                    break;
                }
                case 3: {
                    item.set(this.readInt(n));
                    break;
                }
                case 4: {
                    item.set(Float.intBitsToFloat(this.readInt(n)));
                    break;
                }
                case 12: {
                    item.set(b, this.readUTF8(n, array), this.readUTF8(n + 2, array), null);
                    break;
                }
                case 5: {
                    item.set(this.readLong(n));
                    ++i;
                    break;
                }
                case 6: {
                    item.set(Double.longBitsToDouble(this.readLong(n)));
                    ++i;
                    break;
                }
                case 1: {
                    String s;
                    if ((s = this.strings[i]) == null) {
                        final int n3 = this.items[i];
                        final String[] strings = this.strings;
                        final int n4 = i;
                        final String utf = this.readUTF(n3 + 2, this.readUnsignedShort(n3), array);
                        strings[n4] = utf;
                        s = utf;
                    }
                    item.set(b, s, null, null);
                    break;
                }
                case 15: {
                    final int n5 = this.items[this.readUnsignedShort(n + 1)];
                    final int n6 = this.items[this.readUnsignedShort(n5 + 2)];
                    item.set(20 + this.readByte(n), this.readClass(n5, array), this.readUTF8(n6, array), this.readUTF8(n6 + 2, array));
                    break;
                }
                case 18: {
                    if (classWriter.bootstrapMethods == null) {
                        final Item[] array2 = items;
                        final char[] array3 = array;
                        final Item[] array4 = array2;
                        int attributes = this.getAttributes();
                        boolean b2 = false;
                        for (int j = this.readUnsignedShort(attributes); j > 0; --j) {
                            if (ClassReader.lIlIlIIIlII[0].equals(this.readUTF8(attributes + 2, array3))) {
                                b2 = true;
                                break;
                            }
                            attributes += 6 + this.readInt(attributes + 4);
                        }
                        if (b2) {
                            final int unsignedShort = this.readUnsignedShort(attributes + 8);
                            int k = 0;
                            int n7 = attributes + 10;
                            while (k < unsignedShort) {
                                final int n8 = n7 - attributes - 10;
                                int hashCode = this.readConst(this.readUnsignedShort(n7), array3).hashCode();
                                for (int l = this.readUnsignedShort(n7 + 2); l > 0; --l) {
                                    hashCode ^= this.readConst(this.readUnsignedShort(n7 + 4), array3).hashCode();
                                    n7 += 2;
                                }
                                n7 += 4;
                                final Item item2;
                                (item2 = new Item(k)).set(n8, hashCode & Integer.MAX_VALUE);
                                final int n9 = item2.hashCode % array4.length;
                                item2.next = array4[n9];
                                array4[n9] = item2;
                                ++k;
                            }
                            final int int1 = this.readInt(attributes + 4);
                            final ByteVector bootstrapMethods;
                            (bootstrapMethods = new ByteVector(int1 + 62)).putByteArray(this.b, attributes + 10, int1 - 2);
                            classWriter.bootstrapMethodsCount = unsignedShort;
                            classWriter.bootstrapMethods = bootstrapMethods;
                        }
                    }
                    final int n10 = this.items[this.readUnsignedShort(n + 2)];
                    item.set(this.readUTF8(n10, array), this.readUTF8(n10 + 2, array), this.readUnsignedShort(n));
                    break;
                }
                default: {
                    item.set(b, this.readUTF8(n, array), null, null);
                    break;
                }
            }
            final int n11 = item.hashCode % items.length;
            item.next = items[n11];
            items[n11] = item;
        }
        final int n12 = this.items[1] - 1;
        classWriter.pool.putByteArray(this.b, n12, this.header - n12);
        classWriter.items = items;
        classWriter.threshold = (int)(0.75 * length);
        classWriter.index = length;
    }
    
    private void copyBootstrapMethods(final ClassWriter classWriter, final Item[] array, final char[] array2) {
        int attributes = this.getAttributes();
        boolean b = false;
        for (int i = this.readUnsignedShort(attributes); i > 0; --i) {
            if (ClassReader.lIlIlIIIlII[0].equals(this.readUTF8(attributes + 2, array2))) {
                b = true;
                break;
            }
            attributes += 6 + this.readInt(attributes + 4);
        }
        if (!b) {
            return;
        }
        final int unsignedShort = this.readUnsignedShort(attributes + 8);
        int j = 0;
        int n = attributes + 10;
        while (j < unsignedShort) {
            final int n2 = n - attributes - 10;
            int hashCode = this.readConst(this.readUnsignedShort(n), array2).hashCode();
            for (int k = this.readUnsignedShort(n + 2); k > 0; --k) {
                hashCode ^= this.readConst(this.readUnsignedShort(n + 4), array2).hashCode();
                n += 2;
            }
            n += 4;
            final Item item;
            (item = new Item(j)).set(n2, hashCode & Integer.MAX_VALUE);
            final int n3 = item.hashCode % array.length;
            item.next = array[n3];
            array[n3] = item;
            ++j;
        }
        final int int1 = this.readInt(attributes + 4);
        final ByteVector bootstrapMethods;
        (bootstrapMethods = new ByteVector(int1 + 62)).putByteArray(this.b, attributes + 10, int1 - 2);
        classWriter.bootstrapMethodsCount = unsignedShort;
        classWriter.bootstrapMethods = bootstrapMethods;
    }
    
    public ClassReader(final InputStream inputStream) throws IOException {
        this(readClass(inputStream, false));
    }
    
    public ClassReader(final String s) throws IOException {
        this(readClass(ClassLoader.getSystemResourceAsStream(String.valueOf(new StringBuilder().append(s.replace('.', '/')).append(ClassReader.lIlIlIIIlII[1]))), true));
    }
    
    private static byte[] readClass(final InputStream inputStream, final boolean b) throws IOException {
        if (inputStream == null) {
            throw new IOException(ClassReader.lIlIlIIIlII[2]);
        }
        try {
            byte[] array;
            int n;
            int read;
            int read2 = 0;
            byte[] array2 = null;
            for (array = new byte[inputStream.available()], n = 0; (read = inputStream.read(array, n, array.length - n)) != -1; array2[n++] = (byte)read2, array = array2) {
                if ((n += read) == array.length) {
                    if ((read2 = inputStream.read()) < 0) {
                        return array;
                    }
                    array2 = new byte[array.length + 1000];
                    System.arraycopy(array, 0, array2, 0, n);
                }
            }
            if (n < array.length) {
                final byte[] array3 = new byte[n];
                System.arraycopy(array, 0, array3, 0, n);
                array = array3;
            }
            return array;
        }
        finally {
            if (b) {
                inputStream.close();
            }
        }
    }
    
    public final void accept(final ClassVisitor classVisitor, final int n) {
        this.accept(classVisitor, new Attribute[0], n);
    }
    
    private void accept(final ClassVisitor classVisitor, final Attribute[] attrs, int flags) {
        int header = this.header;
        final char[] buffer = new char[this.maxStringLength];
        final Context context;
        (context = new Context()).attrs = attrs;
        context.flags = flags;
        context.buffer = buffer;
        int unsignedShort = this.readUnsignedShort(header);
        final String class1 = this.readClass(header + 2, buffer);
        final String class2 = this.readClass(header + 4, buffer);
        final String[] array = new String[this.readUnsignedShort(header + 6)];
        header += 8;
        for (int i = 0; i < array.length; ++i) {
            array[i] = this.readClass(header, buffer);
            header += 2;
        }
        String utf8 = null;
        String utf9 = null;
        String utf10 = null;
        String class3 = null;
        String utf11 = null;
        String utf12 = null;
        int n = 0;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        Attribute next = null;
        int attributes = this.getAttributes();
        for (int unsignedShort2 = this.readUnsignedShort(attributes); lllIllllIIll(unsignedShort2); --unsignedShort2) {
            final String utf13 = this.readUTF8(attributes + 2, buffer);
            if (ClassReader.lIlIlIIIlII[3].equals(utf13)) {
                utf9 = this.readUTF8(attributes + 8, buffer);
            }
            else if (ClassReader.lIlIlIIIlII[4].equals(utf13)) {
                n5 = attributes + 8;
            }
            else if (ClassReader.lIlIlIIIlII[5].equals(utf13)) {
                class3 = this.readClass(attributes + 8, buffer);
                final int unsignedShort3;
                if ((unsignedShort3 = this.readUnsignedShort(attributes + 10)) != 0) {
                    utf11 = this.readUTF8(this.items[unsignedShort3], buffer);
                    utf12 = this.readUTF8(this.items[unsignedShort3] + 2, buffer);
                }
            }
            else if (ClassReader.lIlIlIIIlII[6].equals(utf13)) {
                utf8 = this.readUTF8(attributes + 8, buffer);
            }
            else if (ClassReader.lIlIlIIIlII[7].equals(utf13)) {
                n = attributes + 8;
            }
            else if (ClassReader.lIlIlIIIlII[8].equals(utf13)) {
                n3 = attributes + 8;
            }
            else if (ClassReader.lIlIlIIIlII[9].equals(utf13)) {
                unsignedShort |= 0x20000;
            }
            else if (ClassReader.lIlIlIIIlII[10].equals(utf13)) {
                unsignedShort |= 0x41000;
            }
            else if (ClassReader.lIlIlIIIlII[11].equals(utf13)) {
                final int int1 = this.readInt(attributes + 4);
                final int n6 = attributes + 8;
                final int n7 = int1;
                utf10 = this.readUTF(n6, n7, new char[n7]);
            }
            else if (ClassReader.lIlIlIIIlII[12].equals(utf13)) {
                n2 = attributes + 8;
            }
            else if (ClassReader.lIlIlIIIlII[13].equals(utf13)) {
                n4 = attributes + 8;
            }
            else if (ClassReader.lIlIlIIIlII[14].equals(utf13)) {
                final int[] bootstrapMethods = new int[this.readUnsignedShort(attributes + 8)];
                int j = 0;
                int n8 = attributes + 10;
                while (j < bootstrapMethods.length) {
                    bootstrapMethods[j] = n8;
                    n8 += 2 + this.readUnsignedShort(n8 + 2) << 1;
                    ++j;
                }
                context.bootstrapMethods = bootstrapMethods;
            }
            else {
                final Attribute attribute$616e4f99$4bc56248;
                if ((attribute$616e4f99$4bc56248 = this.readAttribute$616e4f99$4bc56248(attrs, utf13, attributes + 8, this.readInt(attributes + 4))) != null) {
                    attribute$616e4f99$4bc56248.next = next;
                    next = attribute$616e4f99$4bc56248;
                }
            }
            attributes += 6 + this.readInt(attributes + 4);
        }
        classVisitor.visit(this.readInt(this.items[1] - 7), unsignedShort, class1, utf8, class2, array);
        if ((flags & 0x2) == 0x0 && (utf9 != null || utf10 != null)) {
            classVisitor.visitSource(utf9, utf10);
        }
        if (class3 != null) {
            classVisitor.visitOuterClass(class3, utf11, utf12);
        }
        if (n != 0) {
            int unsignedShort4 = this.readUnsignedShort(n);
            int annotationValues = n + 2;
            while (lllIllllIIll(unsignedShort4)) {
                annotationValues = this.readAnnotationValues(annotationValues + 2, buffer, true, classVisitor.visitAnnotation(this.readUTF8(annotationValues, buffer), true));
                --unsignedShort4;
            }
        }
        if (n2 != 0) {
            int unsignedShort5 = this.readUnsignedShort(n2);
            int annotationValues2 = n2 + 2;
            while (lllIllllIIll(unsignedShort5)) {
                annotationValues2 = this.readAnnotationValues(annotationValues2 + 2, buffer, true, classVisitor.visitAnnotation(this.readUTF8(annotationValues2, buffer), false));
                --unsignedShort5;
            }
        }
        if (n3 != 0) {
            int unsignedShort6 = this.readUnsignedShort(n3);
            int annotationValues3 = n3 + 2;
            while (lllIllllIIll(unsignedShort6)) {
                final int annotationTarget = this.readAnnotationTarget(context, annotationValues3);
                annotationValues3 = this.readAnnotationValues(annotationTarget + 2, buffer, true, classVisitor.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget, buffer), true));
                --unsignedShort6;
            }
        }
        if (n4 != 0) {
            int unsignedShort7 = this.readUnsignedShort(n4);
            int annotationValues4 = n4 + 2;
            while (lllIllllIIll(unsignedShort7)) {
                final int annotationTarget2 = this.readAnnotationTarget(context, annotationValues4);
                annotationValues4 = this.readAnnotationValues(annotationTarget2 + 2, buffer, true, classVisitor.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget2, buffer), false));
                --unsignedShort7;
            }
        }
        while (next != null) {
            final Attribute next2 = next.next;
            next.next = null;
            classVisitor.visitAttribute(next);
            next = next2;
        }
        if (n5 != 0) {
            int n9 = n5 + 2;
            for (int unsignedShort8 = this.readUnsignedShort(n5); lllIllllIIll(unsignedShort8); --unsignedShort8) {
                classVisitor.visitInnerClass(this.readClass(n9, buffer), this.readClass(n9 + 2, buffer), this.readUTF8(n9 + 4, buffer), this.readUnsignedShort(n9 + 6));
                n9 += 8;
            }
        }
        int n10 = this.header + 10 + 2 * array.length;
        for (int unsignedShort9 = this.readUnsignedShort(n10 - 2); lllIllllIIll(unsignedShort9); --unsignedShort9) {
            final Context context2 = context;
            int n11 = n10;
            final Context context3 = context2;
            final char[] buffer2 = context3.buffer;
            int unsignedShort10 = this.readUnsignedShort(n11);
            final String utf14 = this.readUTF8(n11 + 2, buffer2);
            final String utf15 = this.readUTF8(n11 + 4, buffer2);
            n11 += 6;
            String utf16 = null;
            int n12 = 0;
            int n13 = 0;
            int n14 = 0;
            int n15 = 0;
            Object o = null;
            Attribute next3 = null;
            for (int unsignedShort11 = this.readUnsignedShort(n11); lllIllllIIll(unsignedShort11); --unsignedShort11) {
                final String utf17 = this.readUTF8(n11 + 2, buffer2);
                if (ClassReader.lIlIlIIIlII[15].equals(utf17)) {
                    final int unsignedShort12;
                    o = (((unsignedShort12 = this.readUnsignedShort(n11 + 8)) == 0) ? null : this.readConst(unsignedShort12, buffer2));
                }
                else if (ClassReader.lIlIlIIIlII[16].equals(utf17)) {
                    utf16 = this.readUTF8(n11 + 8, buffer2);
                }
                else if (ClassReader.lIlIlIIIlII[17].equals(utf17)) {
                    unsignedShort10 |= 0x20000;
                }
                else if (ClassReader.lIlIlIIIlII[18].equals(utf17)) {
                    unsignedShort10 |= 0x41000;
                }
                else if (ClassReader.lIlIlIIIlII[19].equals(utf17)) {
                    n12 = n11 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[20].equals(utf17)) {
                    n14 = n11 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[21].equals(utf17)) {
                    n13 = n11 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[22].equals(utf17)) {
                    n15 = n11 + 8;
                }
                else {
                    final Attribute attribute$616e4f99$4bc56249;
                    if ((attribute$616e4f99$4bc56249 = this.readAttribute$616e4f99$4bc56248(context3.attrs, utf17, n11 + 8, this.readInt(n11 + 4))) != null) {
                        attribute$616e4f99$4bc56249.next = next3;
                        next3 = attribute$616e4f99$4bc56249;
                    }
                }
                n11 += 6 + this.readInt(n11 + 4);
            }
            n11 += 2;
            final FieldVisitor visitField;
            int n16;
            if ((visitField = classVisitor.visitField(unsignedShort10, utf14, utf15, utf16, o)) == null) {
                n16 = n11;
            }
            else {
                if (n12 != 0) {
                    int unsignedShort13 = this.readUnsignedShort(n12);
                    int annotationValues5 = n12 + 2;
                    while (lllIllllIIll(unsignedShort13)) {
                        annotationValues5 = this.readAnnotationValues(annotationValues5 + 2, buffer2, true, visitField.visitAnnotation(this.readUTF8(annotationValues5, buffer2), true));
                        --unsignedShort13;
                    }
                }
                if (n13 != 0) {
                    int unsignedShort14 = this.readUnsignedShort(n13);
                    int annotationValues6 = n13 + 2;
                    while (lllIllllIIll(unsignedShort14)) {
                        annotationValues6 = this.readAnnotationValues(annotationValues6 + 2, buffer2, true, visitField.visitAnnotation(this.readUTF8(annotationValues6, buffer2), false));
                        --unsignedShort14;
                    }
                }
                if (n14 != 0) {
                    int unsignedShort15 = this.readUnsignedShort(n14);
                    int annotationValues7 = n14 + 2;
                    while (lllIllllIIll(unsignedShort15)) {
                        final int annotationTarget3 = this.readAnnotationTarget(context3, annotationValues7);
                        annotationValues7 = this.readAnnotationValues(annotationTarget3 + 2, buffer2, true, visitField.visitTypeAnnotation(context3.typeRef, context3.typePath, this.readUTF8(annotationTarget3, buffer2), true));
                        --unsignedShort15;
                    }
                }
                if (n15 != 0) {
                    int unsignedShort16 = this.readUnsignedShort(n15);
                    int annotationValues8 = n15 + 2;
                    while (lllIllllIIll(unsignedShort16)) {
                        final int annotationTarget4 = this.readAnnotationTarget(context3, annotationValues8);
                        annotationValues8 = this.readAnnotationValues(annotationTarget4 + 2, buffer2, true, visitField.visitTypeAnnotation(context3.typeRef, context3.typePath, this.readUTF8(annotationTarget4, buffer2), false));
                        --unsignedShort16;
                    }
                }
                while (next3 != null) {
                    final Attribute next4 = next3.next;
                    next3.next = null;
                    visitField.visitAttribute(next3);
                    next3 = next4;
                }
                visitField.visitEnd();
                n16 = n11;
            }
            n10 = n16;
        }
        n10 += 2;
        for (int unsignedShort17 = this.readUnsignedShort(n10 - 2); lllIllllIIll(unsignedShort17); --unsignedShort17) {
            final Context context4 = context;
            int n17 = n10;
            final Context context5 = context4;
            final char[] buffer3 = context5.buffer;
            context5.access = this.readUnsignedShort(n17);
            context5.name = this.readUTF8(n17 + 2, buffer3);
            context5.desc = this.readUTF8(n17 + 4, buffer3);
            n17 += 6;
            int n18 = 0;
            int n19 = 0;
            String[] array2 = null;
            String utf18 = null;
            int n20 = 0;
            int n21 = 0;
            int n22 = 0;
            int n23 = 0;
            int n24 = 0;
            int n25 = 0;
            int n26 = 0;
            int n27 = 0;
            final int classReaderOffset = n17;
            Attribute next5 = null;
            for (int unsignedShort18 = this.readUnsignedShort(n17); lllIllllIIll(unsignedShort18); --unsignedShort18) {
                final String utf19 = this.readUTF8(n17 + 2, buffer3);
                if (ClassReader.lIlIlIIIlII[23].equals(utf19)) {
                    if ((context5.flags & 0x1) == 0x0) {
                        n18 = n17 + 8;
                    }
                }
                else if (ClassReader.lIlIlIIIlII[24].equals(utf19)) {
                    array2 = new String[this.readUnsignedShort(n17 + 8)];
                    n19 = n17 + 10;
                    for (int k = 0; k < array2.length; ++k) {
                        array2[k] = this.readClass(n19, buffer3);
                        n19 += 2;
                    }
                }
                else if (ClassReader.lIlIlIIIlII[25].equals(utf19)) {
                    utf18 = this.readUTF8(n17 + 8, buffer3);
                }
                else if (ClassReader.lIlIlIIIlII[26].equals(utf19)) {
                    final Context context6 = context5;
                    context6.access |= 0x20000;
                }
                else if (ClassReader.lIlIlIIIlII[27].equals(utf19)) {
                    n21 = n17 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[28].equals(utf19)) {
                    n23 = n17 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[29].equals(utf19)) {
                    n25 = n17 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[30].equals(utf19)) {
                    final Context context7 = context5;
                    context7.access |= 0x41000;
                }
                else if (ClassReader.lIlIlIIIlII[31].equals(utf19)) {
                    n22 = n17 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[32].equals(utf19)) {
                    n24 = n17 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[33].equals(utf19)) {
                    n26 = n17 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[34].equals(utf19)) {
                    n27 = n17 + 8;
                }
                else if (ClassReader.lIlIlIIIlII[35].equals(utf19)) {
                    n20 = n17 + 8;
                }
                else {
                    final Attribute attribute$616e4f99$4bc56250;
                    if ((attribute$616e4f99$4bc56250 = this.readAttribute$616e4f99$4bc56248(context5.attrs, utf19, n17 + 8, this.readInt(n17 + 4))) != null) {
                        attribute$616e4f99$4bc56250.next = next5;
                        next5 = attribute$616e4f99$4bc56250;
                    }
                }
                n17 += 6 + this.readInt(n17 + 4);
            }
            n17 += 2;
            int n28 = 0;
            Label_7010: {
                final MethodVisitor visitMethod;
                if ((visitMethod = classVisitor.visitMethod(context5.access, context5.name, context5.desc, utf18, array2)) == null) {
                    n28 = n17;
                }
                else {
                    final MethodWriter methodWriter;
                    if (visitMethod instanceof MethodWriter && llllIIIIIIII((methodWriter = (MethodWriter)visitMethod).cw.cr, this) && llllIIIIIIII(utf18, methodWriter.signature)) {
                        int n29 = 0;
                        if (array2 == null) {
                            n29 = ((methodWriter.exceptionCount == 0) ? 1 : 0);
                        }
                        else if (array2.length == methodWriter.exceptionCount) {
                            n29 = 1;
                            for (flags = array2.length - 1; llllIIIIIIIl(flags); --flags) {
                                n19 -= 2;
                                if (llllIIIIIIlI(methodWriter.exceptions[flags], this.readUnsignedShort(n19))) {
                                    n29 = 0;
                                    break;
                                }
                            }
                        }
                        if (n29 != 0) {
                            methodWriter.classReaderOffset = classReaderOffset;
                            methodWriter.classReaderLength = n17 - classReaderOffset;
                            n28 = n17;
                            break Label_7010;
                        }
                    }
                    if (n20 != 0) {
                        for (int n30 = this.b[n20] & 0xFF, n31 = n20 + 1; lllIllllIIll(n30); --n30, n31 += 4) {
                            visitMethod.visitParameter(this.readUTF8(n31, buffer3), this.readUnsignedShort(n31 + 2));
                        }
                    }
                    if (n25 != 0) {
                        final AnnotationVisitor visitAnnotationDefault = visitMethod.visitAnnotationDefault();
                        this.readAnnotationValue(n25, buffer3, null, visitAnnotationDefault);
                        if (visitAnnotationDefault != null) {
                            visitAnnotationDefault.visitEnd();
                        }
                    }
                    if (n21 != 0) {
                        int unsignedShort19 = this.readUnsignedShort(n21);
                        int annotationValues9 = n21 + 2;
                        while (lllIllllIIll(unsignedShort19)) {
                            annotationValues9 = this.readAnnotationValues(annotationValues9 + 2, buffer3, true, visitMethod.visitAnnotation(this.readUTF8(annotationValues9, buffer3), true));
                            --unsignedShort19;
                        }
                    }
                    if (n22 != 0) {
                        int unsignedShort20 = this.readUnsignedShort(n22);
                        int annotationValues10 = n22 + 2;
                        while (lllIllllIIll(unsignedShort20)) {
                            annotationValues10 = this.readAnnotationValues(annotationValues10 + 2, buffer3, true, visitMethod.visitAnnotation(this.readUTF8(annotationValues10, buffer3), false));
                            --unsignedShort20;
                        }
                    }
                    if (n23 != 0) {
                        int unsignedShort21 = this.readUnsignedShort(n23);
                        int annotationValues11 = n23 + 2;
                        while (lllIllllIIll(unsignedShort21)) {
                            final int annotationTarget5 = this.readAnnotationTarget(context5, annotationValues11);
                            annotationValues11 = this.readAnnotationValues(annotationTarget5 + 2, buffer3, true, visitMethod.visitTypeAnnotation(context5.typeRef, context5.typePath, this.readUTF8(annotationTarget5, buffer3), true));
                            --unsignedShort21;
                        }
                    }
                    if (n24 != 0) {
                        int unsignedShort22 = this.readUnsignedShort(n24);
                        int annotationValues12 = n24 + 2;
                        while (lllIllllIIll(unsignedShort22)) {
                            final int annotationTarget6 = this.readAnnotationTarget(context5, annotationValues12);
                            annotationValues12 = this.readAnnotationValues(annotationTarget6 + 2, buffer3, true, visitMethod.visitTypeAnnotation(context5.typeRef, context5.typePath, this.readUTF8(annotationTarget6, buffer3), false));
                            --unsignedShort22;
                        }
                    }
                    if (n26 != 0) {
                        this.readParameterAnnotations(visitMethod, context5, n26, true);
                    }
                    if (n27 != 0) {
                        this.readParameterAnnotations(visitMethod, context5, n27, false);
                    }
                    while (next5 != null) {
                        final Attribute next6 = next5.next;
                        next5.next = null;
                        visitMethod.visitAttribute(next5);
                        next5 = next6;
                    }
                    if (n18 != 0) {
                        visitMethod.visitCode();
                        final MethodWriter methodWriter2 = (MethodWriter)visitMethod;
                        final Context context8 = context5;
                        int l = n18;
                        final Context context9 = context8;
                        final MethodWriter methodWriter3 = methodWriter2;
                        final byte[] b = this.b;
                        final char[] buffer4 = context9.buffer;
                        final int unsignedShort23 = this.readUnsignedShort(l);
                        final int unsignedShort24 = this.readUnsignedShort(l + 2);
                        final int int2 = this.readInt(l + 4);
                        l += 8;
                        final int n32 = l;
                        final int n33 = l + int2;
                        final Context context10 = context9;
                        final Label[] labels = new Label[int2 + 2];
                        context10.labels = labels;
                        final Label[] array3 = labels;
                        readLabel(int2 + 1, array3);
                        while (l < n33) {
                            final int n34 = l - n32;
                            switch (ClassWriter.TYPE[b[l] & 0xFF]) {
                                case 0:
                                case 4: {
                                    ++l;
                                    continue;
                                }
                                case 9: {
                                    readLabel(n34 + this.readShort(l + 1), array3);
                                    l += 3;
                                    continue;
                                }
                                case 18: {
                                    readLabel(n34 + this.readUnsignedShort(l + 1), array3);
                                    l += 3;
                                    continue;
                                }
                                case 10: {
                                    readLabel(n34 + this.readInt(l + 1), array3);
                                    l += 5;
                                    continue;
                                }
                                case 17: {
                                    if ((b[l + 1] & 0xFF) == 0x84) {
                                        l += 6;
                                        continue;
                                    }
                                    l += 4;
                                    continue;
                                }
                                case 14: {
                                    l = l + 4 - (n34 & 0x3);
                                    readLabel(n34 + this.readInt(l), array3);
                                    for (int n35 = this.readInt(l + 8) - this.readInt(l + 4) + 1; lllIllllIIll(n35); --n35) {
                                        readLabel(n34 + this.readInt(l + 12), array3);
                                        l += 4;
                                    }
                                    l += 12;
                                    continue;
                                }
                                case 15: {
                                    l = l + 4 - (n34 & 0x3);
                                    readLabel(n34 + this.readInt(l), array3);
                                    for (int int3 = this.readInt(l + 4); lllIllllIIll(int3); --int3) {
                                        readLabel(n34 + this.readInt(l + 12), array3);
                                        l += 8;
                                    }
                                    l += 8;
                                    continue;
                                }
                                case 1:
                                case 3:
                                case 11: {
                                    l += 2;
                                    continue;
                                }
                                case 2:
                                case 5:
                                case 6:
                                case 12:
                                case 13: {
                                    l += 3;
                                    continue;
                                }
                                case 7:
                                case 8: {
                                    l += 5;
                                    continue;
                                }
                                default: {
                                    l += 4;
                                    continue;
                                }
                            }
                        }
                        for (int unsignedShort25 = this.readUnsignedShort(l); lllIllllIIll(unsignedShort25); --unsignedShort25) {
                            methodWriter3.visitTryCatchBlock(readLabel(this.readUnsignedShort(l + 2), array3), readLabel(this.readUnsignedShort(l + 4), array3), readLabel(this.readUnsignedShort(l + 6), array3), this.readUTF8(this.items[this.readUnsignedShort(l + 8)], buffer4));
                            l += 8;
                        }
                        l += 2;
                        int[] typeAnnotations = null;
                        int[] typeAnnotations2 = null;
                        int n36 = 0;
                        int n37 = 0;
                        int n38 = -1;
                        int n39 = -1;
                        int n40 = 0;
                        int n41 = 0;
                        boolean b2 = true;
                        final boolean b3 = (context9.flags & 0x8) != 0x0;
                        int frame = 0;
                        int n42 = 0;
                        int n43 = 0;
                        Context context11 = null;
                        Attribute next7 = null;
                        for (int unsignedShort26 = this.readUnsignedShort(l); lllIllllIIll(unsignedShort26); --unsignedShort26) {
                            final String utf20 = this.readUTF8(l + 2, buffer4);
                            if (ClassReader.lIlIlIIIlII[36].equals(utf20)) {
                                if ((context9.flags & 0x2) == 0x0) {
                                    n40 = l + 8;
                                    int unsignedShort27 = this.readUnsignedShort(l + 8);
                                    int n44 = l;
                                    while (lllIllllIIll(unsignedShort27)) {
                                        final int unsignedShort28 = this.readUnsignedShort(n44 + 10);
                                        if (array3[unsignedShort28] == null) {
                                            final Label label = readLabel(unsignedShort28, array3);
                                            label.status |= 0x1;
                                        }
                                        final int n45 = unsignedShort28 + this.readUnsignedShort(n44 + 12);
                                        if (array3[n45] == null) {
                                            final Label label2 = readLabel(n45, array3);
                                            label2.status |= 0x1;
                                        }
                                        n44 += 10;
                                        --unsignedShort27;
                                    }
                                }
                            }
                            else if (ClassReader.lIlIlIIIlII[37].equals(utf20)) {
                                n41 = l + 8;
                            }
                            else if (ClassReader.lIlIlIIIlII[38].equals(utf20)) {
                                if ((context9.flags & 0x2) == 0x0) {
                                    int unsignedShort29 = this.readUnsignedShort(l + 8);
                                    int n46 = l;
                                    while (lllIllllIIll(unsignedShort29)) {
                                        final int unsignedShort30 = this.readUnsignedShort(n46 + 10);
                                        if (array3[unsignedShort30] == null) {
                                            final Label label3 = readLabel(unsignedShort30, array3);
                                            label3.status |= 0x1;
                                        }
                                        Label next8;
                                        for (next8 = array3[unsignedShort30]; lllIllllIIll(next8.line); next8 = next8.next) {
                                            if (next8.next == null) {
                                                next8.next = new Label();
                                            }
                                        }
                                        next8.line = this.readUnsignedShort(n46 + 12);
                                        n46 += 4;
                                        --unsignedShort29;
                                    }
                                }
                            }
                            else if (ClassReader.lIlIlIIIlII[39].equals(utf20)) {
                                n38 = (((typeAnnotations = this.readTypeAnnotations(methodWriter3, context9, l + 8, 1 != 0)).length == 0 || this.readByte(typeAnnotations[0]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations[0] + 1));
                            }
                            else if (ClassReader.lIlIlIIIlII[40].equals(utf20)) {
                                n39 = (((typeAnnotations2 = this.readTypeAnnotations(methodWriter3, context9, l + 8, 0 != 0)).length == 0 || this.readByte(typeAnnotations2[0]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations2[0] + 1));
                            }
                            else if (ClassReader.lIlIlIIIlII[41].equals(utf20)) {
                                if ((context9.flags & 0x4) == 0x0) {
                                    frame = l + 10;
                                    n42 = this.readInt(l + 4);
                                    n43 = this.readUnsignedShort(l + 8);
                                }
                            }
                            else if (ClassReader.lIlIlIIIlII[42].equals(utf20)) {
                                if ((context9.flags & 0x4) == 0x0) {
                                    b2 = false;
                                    frame = l + 10;
                                    n42 = this.readInt(l + 4);
                                    n43 = this.readUnsignedShort(l + 8);
                                }
                            }
                            else {
                                for (int n47 = 0; n47 < context9.attrs.length; ++n47) {
                                    if (context9.attrs[n47].type.equals(utf20)) {
                                        final Attribute read$19eaea9b;
                                        (read$19eaea9b = context9.attrs[n47].read$19eaea9b(this, l + 8, this.readInt(l + 4))).next = next7;
                                        next7 = read$19eaea9b;
                                    }
                                }
                            }
                            l += 6 + this.readInt(l + 4);
                        }
                        if (frame != 0) {
                            (context11 = context9).offset = -1;
                            context11.mode = 0;
                            context11.localCount = 0;
                            context11.localDiff = 0;
                            context11.stackCount = 0;
                            context11.local = new Object[unsignedShort24];
                            context11.stack = new Object[unsignedShort23];
                            if (b3) {
                                this.getImplicitFrame(context9);
                            }
                            for (int n48 = frame; n48 < frame + n42 - 2; ++n48) {
                                final int unsignedShort31;
                                if (b[n48] == 8 && llllIIIIIIIl(unsignedShort31 = this.readUnsignedShort(n48 + 1)) && unsignedShort31 < int2 && (b[n32 + unsignedShort31] & 0xFF) == 0xBB) {
                                    readLabel(unsignedShort31, array3);
                                }
                            }
                        }
                        if ((context9.flags & 0x100) != 0x0) {
                            methodWriter3.visitFrame(-1, unsignedShort24, null, 0, null);
                        }
                        final int n49 = ((context9.flags & 0x100) == 0x0) ? -33 : 0;
                        int n50 = n32;
                        while (n50 < n33) {
                            final int n51 = n50 - n32;
                            final Label label4;
                            if ((label4 = array3[n51]) != null) {
                                Label label5 = label4.next;
                                label4.next = null;
                                methodWriter3.visitLabel(label4);
                                if ((context9.flags & 0x2) == 0x0 && lllIllllIIll(label4.line)) {
                                    methodWriter3.visitLineNumber(label4.line, label4);
                                    while (label5 != null) {
                                        methodWriter3.visitLineNumber(label5.line, label4);
                                        label5 = label5.next;
                                    }
                                }
                            }
                            while (context11 != null && (!llllIIIIIIlI(context11.offset, n51) || context11.offset == -1)) {
                                if (llllIIIIIIlI(context11.offset, -1)) {
                                    if (!b2 || b3) {
                                        methodWriter3.visitFrame(-1, context11.localCount, context11.local, context11.stackCount, context11.stack);
                                    }
                                    else {
                                        methodWriter3.visitFrame(context11.mode, context11.localDiff, context11.local, context11.stackCount, context11.stack);
                                    }
                                }
                                if (lllIllllIIll(n43)) {
                                    frame = this.readFrame(frame, b2, b3, context11);
                                    --n43;
                                }
                                else {
                                    context11 = null;
                                }
                            }
                            int n52 = b[n50] & 0xFF;
                            switch (ClassWriter.TYPE[n52]) {
                                case 0: {
                                    methodWriter3.visitInsn(n52);
                                    ++n50;
                                    break;
                                }
                                case 4: {
                                    if (lllIlllIlllI(n52, 54)) {
                                        n52 -= 59;
                                        methodWriter3.visitVarInsn(54 + (n52 >> 2), n52 & 0x3);
                                    }
                                    else {
                                        n52 -= 26;
                                        methodWriter3.visitVarInsn(21 + (n52 >> 2), n52 & 0x3);
                                    }
                                    ++n50;
                                    break;
                                }
                                case 9: {
                                    methodWriter3.visitJumpInsn(n52, array3[n51 + this.readShort(n50 + 1)]);
                                    n50 += 3;
                                    break;
                                }
                                case 10: {
                                    methodWriter3.visitJumpInsn(n52 + n49, array3[n51 + this.readInt(n50 + 1)]);
                                    n50 += 5;
                                    break;
                                }
                                case 18: {
                                    final int n53 = (n52 < 218) ? (n52 - 49) : (n52 - 20);
                                    final Label label6 = array3[n51 + this.readUnsignedShort(n50 + 1)];
                                    if (!llllIIIIIIlI(n53, 167) || n53 == 168) {
                                        methodWriter3.visitJumpInsn(n53 + 33, label6);
                                    }
                                    else {
                                        final int n54 = llllIIIIIIll(n53, 166) ? ((n53 + 1 ^ 0x1) - 1) : (n53 ^ 0x1);
                                        final Label label7 = new Label();
                                        methodWriter3.visitJumpInsn(n54, label7);
                                        methodWriter3.visitJumpInsn(200, label6);
                                        methodWriter3.visitLabel(label7);
                                        if (frame != 0 && (context11 == null || llllIIIIIIlI(context11.offset, n51 + 3))) {
                                            methodWriter3.visitFrame(256, 0, null, 0, null);
                                        }
                                    }
                                    n50 += 3;
                                    break;
                                }
                                case 17: {
                                    final int n55;
                                    if ((n55 = (b[n50 + 1] & 0xFF)) == 132) {
                                        methodWriter3.visitIincInsn(this.readUnsignedShort(n50 + 2), this.readShort(n50 + 4));
                                        n50 += 6;
                                        break;
                                    }
                                    methodWriter3.visitVarInsn(n55, this.readUnsignedShort(n50 + 2));
                                    n50 += 4;
                                    break;
                                }
                                case 14: {
                                    n50 = n50 + 4 - (n51 & 0x3);
                                    final int n56 = n51 + this.readInt(n50);
                                    final int int4 = this.readInt(n50 + 4);
                                    final int int5;
                                    final Label[] array4 = new Label[(int5 = this.readInt(n50 + 8)) - int4 + 1];
                                    n50 += 12;
                                    for (int n57 = 0; n57 < array4.length; ++n57) {
                                        array4[n57] = array3[n51 + this.readInt(n50)];
                                        n50 += 4;
                                    }
                                    methodWriter3.visitTableSwitchInsn(int4, int5, array3[n56], array4);
                                    break;
                                }
                                case 15: {
                                    n50 = n50 + 4 - (n51 & 0x3);
                                    final int n58 = n51 + this.readInt(n50);
                                    final int int6;
                                    final int[] array5 = new int[int6 = this.readInt(n50 + 4)];
                                    final Label[] array6 = new Label[int6];
                                    n50 += 8;
                                    for (int n59 = 0; n59 < int6; ++n59) {
                                        array5[n59] = this.readInt(n50);
                                        array6[n59] = array3[n51 + this.readInt(n50 + 4)];
                                        n50 += 8;
                                    }
                                    methodWriter3.visitLookupSwitchInsn(array3[n58], array5, array6);
                                    break;
                                }
                                case 3: {
                                    methodWriter3.visitVarInsn(n52, b[n50 + 1] & 0xFF);
                                    n50 += 2;
                                    break;
                                }
                                case 1: {
                                    methodWriter3.visitIntInsn(n52, b[n50 + 1]);
                                    n50 += 2;
                                    break;
                                }
                                case 2: {
                                    methodWriter3.visitIntInsn(n52, this.readShort(n50 + 1));
                                    n50 += 3;
                                    break;
                                }
                                case 11: {
                                    methodWriter3.visitLdcInsn(this.readConst(b[n50 + 1] & 0xFF, buffer4));
                                    n50 += 2;
                                    break;
                                }
                                case 12: {
                                    methodWriter3.visitLdcInsn(this.readConst(this.readUnsignedShort(n50 + 1), buffer4));
                                    n50 += 3;
                                    break;
                                }
                                case 6:
                                case 7: {
                                    final int n60 = this.items[this.readUnsignedShort(n50 + 1)];
                                    final boolean b4 = b[n60 - 1] == 11;
                                    final String class4 = this.readClass(n60, buffer4);
                                    final int n61 = this.items[this.readUnsignedShort(n60 + 2)];
                                    final String utf21 = this.readUTF8(n61, buffer4);
                                    final String utf22 = this.readUTF8(n61 + 2, buffer4);
                                    if (n52 < 182) {
                                        methodWriter3.visitFieldInsn(n52, class4, utf21, utf22);
                                    }
                                    else {
                                        methodWriter3.visitMethodInsn(n52, class4, utf21, utf22, b4);
                                    }
                                    if (n52 == 185) {
                                        n50 += 5;
                                        break;
                                    }
                                    n50 += 3;
                                    break;
                                }
                                case 8: {
                                    final int n62 = this.items[this.readUnsignedShort(n50 + 1)];
                                    int n63 = context9.bootstrapMethods[this.readUnsignedShort(n62)];
                                    final Handle handle = (Handle)this.readConst(this.readUnsignedShort(n63), buffer4);
                                    final int unsignedShort32;
                                    final Object[] array7 = new Object[unsignedShort32 = this.readUnsignedShort(n63 + 2)];
                                    n63 += 4;
                                    for (int n64 = 0; n64 < unsignedShort32; ++n64) {
                                        array7[n64] = this.readConst(this.readUnsignedShort(n63), buffer4);
                                        n63 += 2;
                                    }
                                    final int n65 = this.items[this.readUnsignedShort(n62 + 2)];
                                    methodWriter3.visitInvokeDynamicInsn(this.readUTF8(n65, buffer4), this.readUTF8(n65 + 2, buffer4), handle, array7);
                                    n50 += 5;
                                    break;
                                }
                                case 5: {
                                    methodWriter3.visitTypeInsn(n52, this.readClass(n50 + 1, buffer4));
                                    n50 += 3;
                                    break;
                                }
                                case 13: {
                                    methodWriter3.visitIincInsn(b[n50 + 1] & 0xFF, b[n50 + 2]);
                                    n50 += 3;
                                    break;
                                }
                                default: {
                                    methodWriter3.visitMultiANewArrayInsn(this.readClass(n50 + 1, buffer4), b[n50 + 3] & 0xFF);
                                    n50 += 4;
                                    break;
                                }
                            }
                            while (typeAnnotations != null && n36 < typeAnnotations.length && llllIIIIIIll(n38, n51)) {
                                if (n38 == n51) {
                                    final int annotationTarget7 = this.readAnnotationTarget(context9, typeAnnotations[n36]);
                                    this.readAnnotationValues(annotationTarget7 + 2, buffer4, true, methodWriter3.visitInsnAnnotation(context9.typeRef, context9.typePath, this.readUTF8(annotationTarget7, buffer4), true));
                                }
                                n38 = ((++n36 >= typeAnnotations.length || this.readByte(typeAnnotations[n36]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations[n36] + 1));
                            }
                            while (typeAnnotations2 != null && n37 < typeAnnotations2.length && llllIIIIIIll(n39, n51)) {
                                if (n39 == n51) {
                                    final int annotationTarget8 = this.readAnnotationTarget(context9, typeAnnotations2[n37]);
                                    this.readAnnotationValues(annotationTarget8 + 2, buffer4, true, methodWriter3.visitInsnAnnotation(context9.typeRef, context9.typePath, this.readUTF8(annotationTarget8, buffer4), false));
                                }
                                n39 = ((++n37 >= typeAnnotations2.length || this.readByte(typeAnnotations2[n37]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations2[n37] + 1));
                            }
                        }
                        if (array3[int2] != null) {
                            methodWriter3.visitLabel(array3[int2]);
                        }
                        if ((context9.flags & 0x2) == 0x0 && n40 != 0) {
                            int[] array8 = null;
                            if (n41 != 0) {
                                for (int n66 = n41 + 2, length = (array8 = new int[this.readUnsignedShort(n41) * 3]).length; lllIllllIIll(length); array8[--length] = n66 + 6, array8[--length] = this.readUnsignedShort(n66 + 8), array8[--length] = this.readUnsignedShort(n66), n66 += 10) {}
                            }
                            int n67 = n40 + 2;
                            for (int unsignedShort33 = this.readUnsignedShort(n40); lllIllllIIll(unsignedShort33); --unsignedShort33) {
                                final int unsignedShort34 = this.readUnsignedShort(n67);
                                final int unsignedShort35 = this.readUnsignedShort(n67 + 2);
                                final int unsignedShort36 = this.readUnsignedShort(n67 + 8);
                                String utf23 = null;
                                if (array8 != null) {
                                    for (int n68 = 0; n68 < array8.length; n68 += 3) {
                                        if (array8[n68] == unsignedShort34 && array8[n68 + 1] == unsignedShort36) {
                                            utf23 = this.readUTF8(array8[n68 + 2], buffer4);
                                            break;
                                        }
                                    }
                                }
                                methodWriter3.visitLocalVariable(this.readUTF8(n67 + 4, buffer4), this.readUTF8(n67 + 6, buffer4), utf23, array3[unsignedShort34], array3[unsignedShort34 + unsignedShort35], unsignedShort36);
                                n67 += 10;
                            }
                        }
                        if (typeAnnotations != null) {
                            for (int n69 = 0; n69 < typeAnnotations.length; ++n69) {
                                if (this.readByte(typeAnnotations[n69]) >> 1 == 32) {
                                    final int annotationTarget9 = this.readAnnotationTarget(context9, typeAnnotations[n69]);
                                    this.readAnnotationValues(annotationTarget9 + 2, buffer4, true, methodWriter3.visitLocalVariableAnnotation(context9.typeRef, context9.typePath, context9.start, context9.end, context9.index, this.readUTF8(annotationTarget9, buffer4), true));
                                }
                            }
                        }
                        if (typeAnnotations2 != null) {
                            for (int n70 = 0; n70 < typeAnnotations2.length; ++n70) {
                                if (this.readByte(typeAnnotations2[n70]) >> 1 == 32) {
                                    final int annotationTarget10 = this.readAnnotationTarget(context9, typeAnnotations2[n70]);
                                    this.readAnnotationValues(annotationTarget10 + 2, buffer4, true, methodWriter3.visitLocalVariableAnnotation(context9.typeRef, context9.typePath, context9.start, context9.end, context9.index, this.readUTF8(annotationTarget10, buffer4), false));
                                }
                            }
                        }
                        while (next7 != null) {
                            final Attribute next9 = next7.next;
                            next7.next = null;
                            methodWriter3.visitAttribute(next7);
                            next7 = next9;
                        }
                        methodWriter3.visitMaxs(unsignedShort23, unsignedShort24);
                    }
                    visitMethod.visitEnd();
                    n28 = n17;
                }
            }
            n10 = n28;
        }
        classVisitor.visitEnd();
    }
    
    private int readField(final ClassVisitor classVisitor, final Context context, int n) {
        final char[] buffer = context.buffer;
        int unsignedShort = this.readUnsignedShort(n);
        final String utf8 = this.readUTF8(n + 2, buffer);
        final String utf9 = this.readUTF8(n + 4, buffer);
        n += 6;
        String utf10 = null;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        Object o = null;
        Attribute next = null;
        for (int i = this.readUnsignedShort(n); i > 0; --i) {
            final String utf11 = this.readUTF8(n + 2, buffer);
            if (ClassReader.lIlIlIIIlII[15].equals(utf11)) {
                final int unsignedShort2;
                o = (((unsignedShort2 = this.readUnsignedShort(n + 8)) == 0) ? null : this.readConst(unsignedShort2, buffer));
            }
            else if (ClassReader.lIlIlIIIlII[16].equals(utf11)) {
                utf10 = this.readUTF8(n + 8, buffer);
            }
            else if (ClassReader.lIlIlIIIlII[17].equals(utf11)) {
                unsignedShort |= 0x20000;
            }
            else if (ClassReader.lIlIlIIIlII[18].equals(utf11)) {
                unsignedShort |= 0x41000;
            }
            else if (ClassReader.lIlIlIIIlII[19].equals(utf11)) {
                n2 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[20].equals(utf11)) {
                n4 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[21].equals(utf11)) {
                n3 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[22].equals(utf11)) {
                n5 = n + 8;
            }
            else {
                final Attribute attribute$616e4f99$4bc56248;
                if ((attribute$616e4f99$4bc56248 = this.readAttribute$616e4f99$4bc56248(context.attrs, utf11, n + 8, this.readInt(n + 4))) != null) {
                    attribute$616e4f99$4bc56248.next = next;
                    next = attribute$616e4f99$4bc56248;
                }
            }
            n += 6 + this.readInt(n + 4);
        }
        n += 2;
        final FieldVisitor visitField;
        if ((visitField = classVisitor.visitField(unsignedShort, utf8, utf9, utf10, o)) == null) {
            return n;
        }
        if (n2 != 0) {
            int j = this.readUnsignedShort(n2);
            int annotationValues = n2 + 2;
            while (j > 0) {
                annotationValues = this.readAnnotationValues(annotationValues + 2, buffer, true, visitField.visitAnnotation(this.readUTF8(annotationValues, buffer), true));
                --j;
            }
        }
        if (n3 != 0) {
            int k = this.readUnsignedShort(n3);
            int annotationValues2 = n3 + 2;
            while (k > 0) {
                annotationValues2 = this.readAnnotationValues(annotationValues2 + 2, buffer, true, visitField.visitAnnotation(this.readUTF8(annotationValues2, buffer), false));
                --k;
            }
        }
        if (n4 != 0) {
            int l = this.readUnsignedShort(n4);
            int annotationValues3 = n4 + 2;
            while (l > 0) {
                final int annotationTarget = this.readAnnotationTarget(context, annotationValues3);
                annotationValues3 = this.readAnnotationValues(annotationTarget + 2, buffer, true, visitField.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget, buffer), true));
                --l;
            }
        }
        if (n5 != 0) {
            int unsignedShort3 = this.readUnsignedShort(n5);
            int annotationValues4 = n5 + 2;
            while (unsignedShort3 > 0) {
                final int annotationTarget2 = this.readAnnotationTarget(context, annotationValues4);
                annotationValues4 = this.readAnnotationValues(annotationTarget2 + 2, buffer, true, visitField.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget2, buffer), false));
                --unsignedShort3;
            }
        }
        while (next != null) {
            final Attribute next2 = next.next;
            next.next = null;
            visitField.visitAttribute(next);
            next = next2;
        }
        visitField.visitEnd();
        return n;
    }
    
    private int readMethod(final ClassVisitor classVisitor, final Context context, int n) {
        final char[] buffer = context.buffer;
        context.access = this.readUnsignedShort(n);
        context.name = this.readUTF8(n + 2, buffer);
        context.desc = this.readUTF8(n + 4, buffer);
        n += 6;
        int i = 0;
        int n2 = 0;
        String[] array = null;
        String utf8 = null;
        int n3 = 0;
        int n4 = 0;
        int n5 = 0;
        int n6 = 0;
        int n7 = 0;
        int n8 = 0;
        int n9 = 0;
        int n10 = 0;
        final int classReaderOffset = n;
        Attribute next = null;
        for (int j = this.readUnsignedShort(n); j > 0; --j) {
            final String utf9 = this.readUTF8(n + 2, buffer);
            if (ClassReader.lIlIlIIIlII[23].equals(utf9)) {
                if ((context.flags & 0x1) == 0x0) {
                    i = n + 8;
                }
            }
            else if (ClassReader.lIlIlIIIlII[24].equals(utf9)) {
                array = new String[this.readUnsignedShort(n + 8)];
                n2 = n + 10;
                for (int k = 0; k < array.length; ++k) {
                    array[k] = this.readClass(n2, buffer);
                    n2 += 2;
                }
            }
            else if (ClassReader.lIlIlIIIlII[25].equals(utf9)) {
                utf8 = this.readUTF8(n + 8, buffer);
            }
            else if (ClassReader.lIlIlIIIlII[26].equals(utf9)) {
                context.access |= 0x20000;
            }
            else if (ClassReader.lIlIlIIIlII[27].equals(utf9)) {
                n4 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[28].equals(utf9)) {
                n6 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[29].equals(utf9)) {
                n8 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[30].equals(utf9)) {
                context.access |= 0x41000;
            }
            else if (ClassReader.lIlIlIIIlII[31].equals(utf9)) {
                n5 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[32].equals(utf9)) {
                n7 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[33].equals(utf9)) {
                n9 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[34].equals(utf9)) {
                n10 = n + 8;
            }
            else if (ClassReader.lIlIlIIIlII[35].equals(utf9)) {
                n3 = n + 8;
            }
            else {
                final Attribute attribute$616e4f99$4bc56248;
                if ((attribute$616e4f99$4bc56248 = this.readAttribute$616e4f99$4bc56248(context.attrs, utf9, n + 8, this.readInt(n + 4))) != null) {
                    attribute$616e4f99$4bc56248.next = next;
                    next = attribute$616e4f99$4bc56248;
                }
            }
            n += 6 + this.readInt(n + 4);
        }
        n += 2;
        final MethodVisitor visitMethod;
        if ((visitMethod = classVisitor.visitMethod(context.access, context.name, context.desc, utf8, array)) == null) {
            return n;
        }
        final MethodWriter methodWriter;
        if (visitMethod instanceof MethodWriter && llllIIIIIIII((methodWriter = (MethodWriter)visitMethod).cw.cr, this) && llllIIIIIIII(utf8, methodWriter.signature)) {
            int n11 = 0;
            if (array == null) {
                n11 = ((methodWriter.exceptionCount == 0) ? 1 : 0);
            }
            else if (array.length == methodWriter.exceptionCount) {
                n11 = 1;
                for (int l = array.length - 1; l >= 0; --l) {
                    n2 -= 2;
                    if (llllIIIIIIlI(methodWriter.exceptions[l], this.readUnsignedShort(n2))) {
                        n11 = 0;
                        break;
                    }
                }
            }
            if (n11 != 0) {
                methodWriter.classReaderOffset = classReaderOffset;
                methodWriter.classReaderLength = n - classReaderOffset;
                return n;
            }
        }
        if (n3 != 0) {
            for (int n12 = this.b[n3] & 0xFF, n13 = n3 + 1; n12 > 0; --n12, n13 += 4) {
                visitMethod.visitParameter(this.readUTF8(n13, buffer), this.readUnsignedShort(n13 + 2));
            }
        }
        if (n8 != 0) {
            final AnnotationVisitor visitAnnotationDefault = visitMethod.visitAnnotationDefault();
            this.readAnnotationValue(n8, buffer, null, visitAnnotationDefault);
            if (visitAnnotationDefault != null) {
                visitAnnotationDefault.visitEnd();
            }
        }
        if (n4 != 0) {
            int unsignedShort = this.readUnsignedShort(n4);
            int annotationValues = n4 + 2;
            while (unsignedShort > 0) {
                annotationValues = this.readAnnotationValues(annotationValues + 2, buffer, true, visitMethod.visitAnnotation(this.readUTF8(annotationValues, buffer), true));
                --unsignedShort;
            }
        }
        if (n5 != 0) {
            int unsignedShort2 = this.readUnsignedShort(n5);
            int annotationValues2 = n5 + 2;
            while (unsignedShort2 > 0) {
                annotationValues2 = this.readAnnotationValues(annotationValues2 + 2, buffer, true, visitMethod.visitAnnotation(this.readUTF8(annotationValues2, buffer), false));
                --unsignedShort2;
            }
        }
        if (n6 != 0) {
            int unsignedShort3 = this.readUnsignedShort(n6);
            int annotationValues3 = n6 + 2;
            while (unsignedShort3 > 0) {
                final int annotationTarget = this.readAnnotationTarget(context, annotationValues3);
                annotationValues3 = this.readAnnotationValues(annotationTarget + 2, buffer, true, visitMethod.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget, buffer), true));
                --unsignedShort3;
            }
        }
        if (n7 != 0) {
            int unsignedShort4 = this.readUnsignedShort(n7);
            int annotationValues4 = n7 + 2;
            while (unsignedShort4 > 0) {
                final int annotationTarget2 = this.readAnnotationTarget(context, annotationValues4);
                annotationValues4 = this.readAnnotationValues(annotationTarget2 + 2, buffer, true, visitMethod.visitTypeAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget2, buffer), false));
                --unsignedShort4;
            }
        }
        if (n9 != 0) {
            this.readParameterAnnotations(visitMethod, context, n9, true);
        }
        if (n10 != 0) {
            this.readParameterAnnotations(visitMethod, context, n10, false);
        }
        while (next != null) {
            final Attribute next2 = next.next;
            next.next = null;
            visitMethod.visitAttribute(next);
            next = next2;
        }
        if (i != 0) {
            visitMethod.visitCode();
            final MethodWriter methodWriter2 = (MethodWriter)visitMethod;
            final byte[] b = this.b;
            final char[] buffer2 = context.buffer;
            final int unsignedShort5 = this.readUnsignedShort(i);
            final int unsignedShort6 = this.readUnsignedShort(i + 2);
            final int int1 = this.readInt(i + 4);
            i += 8;
            final int n14 = i;
            final int n15 = i + int1;
            final Label[] labels = new Label[int1 + 2];
            context.labels = labels;
            final Label[] array2 = labels;
            readLabel(int1 + 1, array2);
            while (i < n15) {
                final int n16 = i - n14;
                switch (ClassWriter.TYPE[b[i] & 0xFF]) {
                    case 0:
                    case 4: {
                        ++i;
                        continue;
                    }
                    case 9: {
                        readLabel(n16 + this.readShort(i + 1), array2);
                        i += 3;
                        continue;
                    }
                    case 18: {
                        readLabel(n16 + this.readUnsignedShort(i + 1), array2);
                        i += 3;
                        continue;
                    }
                    case 10: {
                        readLabel(n16 + this.readInt(i + 1), array2);
                        i += 5;
                        continue;
                    }
                    case 17: {
                        if ((b[i + 1] & 0xFF) == 0x84) {
                            i += 6;
                            continue;
                        }
                        i += 4;
                        continue;
                    }
                    case 14: {
                        i = i + 4 - (n16 & 0x3);
                        readLabel(n16 + this.readInt(i), array2);
                        for (int n17 = this.readInt(i + 8) - this.readInt(i + 4) + 1; n17 > 0; --n17) {
                            readLabel(n16 + this.readInt(i + 12), array2);
                            i += 4;
                        }
                        i += 12;
                        continue;
                    }
                    case 15: {
                        i = i + 4 - (n16 & 0x3);
                        readLabel(n16 + this.readInt(i), array2);
                        for (int int2 = this.readInt(i + 4); int2 > 0; --int2) {
                            readLabel(n16 + this.readInt(i + 12), array2);
                            i += 8;
                        }
                        i += 8;
                        continue;
                    }
                    case 1:
                    case 3:
                    case 11: {
                        i += 2;
                        continue;
                    }
                    case 2:
                    case 5:
                    case 6:
                    case 12:
                    case 13: {
                        i += 3;
                        continue;
                    }
                    case 7:
                    case 8: {
                        i += 5;
                        continue;
                    }
                    default: {
                        i += 4;
                        continue;
                    }
                }
            }
            for (int unsignedShort7 = this.readUnsignedShort(i); unsignedShort7 > 0; --unsignedShort7) {
                methodWriter2.visitTryCatchBlock(readLabel(this.readUnsignedShort(i + 2), array2), readLabel(this.readUnsignedShort(i + 4), array2), readLabel(this.readUnsignedShort(i + 6), array2), this.readUTF8(this.items[this.readUnsignedShort(i + 8)], buffer2));
                i += 8;
            }
            i += 2;
            int[] typeAnnotations = null;
            int[] typeAnnotations2 = null;
            int n18 = 0;
            int n19 = 0;
            int n20 = -1;
            int n21 = -1;
            int n22 = 0;
            int n23 = 0;
            boolean b2 = true;
            final boolean b3 = (context.flags & 0x8) != 0x0;
            int frame = 0;
            int n24 = 0;
            int n25 = 0;
            Context context2 = null;
            Attribute next3 = null;
            for (int unsignedShort8 = this.readUnsignedShort(i); unsignedShort8 > 0; --unsignedShort8) {
                final String utf10 = this.readUTF8(i + 2, buffer2);
                if (ClassReader.lIlIlIIIlII[36].equals(utf10)) {
                    if ((context.flags & 0x2) == 0x0) {
                        n22 = i + 8;
                        int unsignedShort9 = this.readUnsignedShort(i + 8);
                        int n26 = i;
                        while (unsignedShort9 > 0) {
                            final int unsignedShort10 = this.readUnsignedShort(n26 + 10);
                            if (array2[unsignedShort10] == null) {
                                final Label label = readLabel(unsignedShort10, array2);
                                label.status |= 0x1;
                            }
                            final int n27 = unsignedShort10 + this.readUnsignedShort(n26 + 12);
                            if (array2[n27] == null) {
                                final Label label2 = readLabel(n27, array2);
                                label2.status |= 0x1;
                            }
                            n26 += 10;
                            --unsignedShort9;
                        }
                    }
                }
                else if (ClassReader.lIlIlIIIlII[37].equals(utf10)) {
                    n23 = i + 8;
                }
                else if (ClassReader.lIlIlIIIlII[38].equals(utf10)) {
                    if ((context.flags & 0x2) == 0x0) {
                        int unsignedShort11 = this.readUnsignedShort(i + 8);
                        int n28 = i;
                        while (unsignedShort11 > 0) {
                            final int unsignedShort12 = this.readUnsignedShort(n28 + 10);
                            if (array2[unsignedShort12] == null) {
                                final Label label3 = readLabel(unsignedShort12, array2);
                                label3.status |= 0x1;
                            }
                            Label next4;
                            for (next4 = array2[unsignedShort12]; next4.line > 0; next4 = next4.next) {
                                if (next4.next == null) {
                                    next4.next = new Label();
                                }
                            }
                            next4.line = this.readUnsignedShort(n28 + 12);
                            n28 += 4;
                            --unsignedShort11;
                        }
                    }
                }
                else if (ClassReader.lIlIlIIIlII[39].equals(utf10)) {
                    n20 = (((typeAnnotations = this.readTypeAnnotations(methodWriter2, context, i + 8, 1 != 0)).length == 0 || this.readByte(typeAnnotations[0]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations[0] + 1));
                }
                else if (ClassReader.lIlIlIIIlII[40].equals(utf10)) {
                    n21 = (((typeAnnotations2 = this.readTypeAnnotations(methodWriter2, context, i + 8, 0 != 0)).length == 0 || this.readByte(typeAnnotations2[0]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations2[0] + 1));
                }
                else if (ClassReader.lIlIlIIIlII[41].equals(utf10)) {
                    if ((context.flags & 0x4) == 0x0) {
                        frame = i + 10;
                        n24 = this.readInt(i + 4);
                        n25 = this.readUnsignedShort(i + 8);
                    }
                }
                else if (ClassReader.lIlIlIIIlII[42].equals(utf10)) {
                    if ((context.flags & 0x4) == 0x0) {
                        b2 = false;
                        frame = i + 10;
                        n24 = this.readInt(i + 4);
                        n25 = this.readUnsignedShort(i + 8);
                    }
                }
                else {
                    for (int n29 = 0; n29 < context.attrs.length; ++n29) {
                        if (context.attrs[n29].type.equals(utf10)) {
                            final Attribute read$19eaea9b;
                            (read$19eaea9b = context.attrs[n29].read$19eaea9b(this, i + 8, this.readInt(i + 4))).next = next3;
                            next3 = read$19eaea9b;
                        }
                    }
                }
                i += 6 + this.readInt(i + 4);
            }
            if (frame != 0) {
                context2 = context;
                context.offset = -1;
                context2.mode = 0;
                context2.localCount = 0;
                context2.localDiff = 0;
                context2.stackCount = 0;
                context2.local = new Object[unsignedShort6];
                context2.stack = new Object[unsignedShort5];
                if (b3) {
                    this.getImplicitFrame(context);
                }
                for (int n30 = frame; n30 < frame + n24 - 2; ++n30) {
                    final int unsignedShort13;
                    if (b[n30] == 8 && (unsignedShort13 = this.readUnsignedShort(n30 + 1)) >= 0 && unsignedShort13 < int1 && (b[n14 + unsignedShort13] & 0xFF) == 0xBB) {
                        readLabel(unsignedShort13, array2);
                    }
                }
            }
            if ((context.flags & 0x100) != 0x0) {
                methodWriter2.visitFrame(-1, unsignedShort6, null, 0, null);
            }
            final int n31 = ((context.flags & 0x100) == 0x0) ? -33 : 0;
            int n32 = n14;
            while (n32 < n15) {
                final int n33 = n32 - n14;
                final Label label4;
                if ((label4 = array2[n33]) != null) {
                    Label label5 = label4.next;
                    label4.next = null;
                    methodWriter2.visitLabel(label4);
                    if ((context.flags & 0x2) == 0x0 && label4.line > 0) {
                        methodWriter2.visitLineNumber(label4.line, label4);
                        while (label5 != null) {
                            methodWriter2.visitLineNumber(label5.line, label4);
                            label5 = label5.next;
                        }
                    }
                }
                while (context2 != null && (!llllIIIIIIlI(context2.offset, n33) || context2.offset == -1)) {
                    if (llllIIIIIIlI(context2.offset, -1)) {
                        if (!b2 || b3) {
                            methodWriter2.visitFrame(-1, context2.localCount, context2.local, context2.stackCount, context2.stack);
                        }
                        else {
                            methodWriter2.visitFrame(context2.mode, context2.localDiff, context2.local, context2.stackCount, context2.stack);
                        }
                    }
                    if (n25 > 0) {
                        frame = this.readFrame(frame, b2, b3, context2);
                        --n25;
                    }
                    else {
                        context2 = null;
                    }
                }
                int n34 = b[n32] & 0xFF;
                switch (ClassWriter.TYPE[n34]) {
                    case 0: {
                        methodWriter2.visitInsn(n34);
                        ++n32;
                        break;
                    }
                    case 4: {
                        if (lllIlllIlllI(n34, 54)) {
                            n34 -= 59;
                            methodWriter2.visitVarInsn(54 + (n34 >> 2), n34 & 0x3);
                        }
                        else {
                            n34 -= 26;
                            methodWriter2.visitVarInsn(21 + (n34 >> 2), n34 & 0x3);
                        }
                        ++n32;
                        break;
                    }
                    case 9: {
                        methodWriter2.visitJumpInsn(n34, array2[n33 + this.readShort(n32 + 1)]);
                        n32 += 3;
                        break;
                    }
                    case 10: {
                        methodWriter2.visitJumpInsn(n34 + n31, array2[n33 + this.readInt(n32 + 1)]);
                        n32 += 5;
                        break;
                    }
                    case 18: {
                        final int n35 = (n34 < 218) ? (n34 - 49) : (n34 - 20);
                        final Label label6 = array2[n33 + this.readUnsignedShort(n32 + 1)];
                        if (!llllIIIIIIlI(n35, 167) || n35 == 168) {
                            methodWriter2.visitJumpInsn(n35 + 33, label6);
                        }
                        else {
                            final int n36 = llllIIIIIIll(n35, 166) ? ((n35 + 1 ^ 0x1) - 1) : (n35 ^ 0x1);
                            final Label label7 = new Label();
                            methodWriter2.visitJumpInsn(n36, label7);
                            methodWriter2.visitJumpInsn(200, label6);
                            methodWriter2.visitLabel(label7);
                            if (frame != 0 && (context2 == null || llllIIIIIIlI(context2.offset, n33 + 3))) {
                                methodWriter2.visitFrame(256, 0, null, 0, null);
                            }
                        }
                        n32 += 3;
                        break;
                    }
                    case 17: {
                        final int n37;
                        if ((n37 = (b[n32 + 1] & 0xFF)) == 132) {
                            methodWriter2.visitIincInsn(this.readUnsignedShort(n32 + 2), this.readShort(n32 + 4));
                            n32 += 6;
                            break;
                        }
                        methodWriter2.visitVarInsn(n37, this.readUnsignedShort(n32 + 2));
                        n32 += 4;
                        break;
                    }
                    case 14: {
                        n32 = n32 + 4 - (n33 & 0x3);
                        final int n38 = n33 + this.readInt(n32);
                        final int int3 = this.readInt(n32 + 4);
                        final int int4;
                        final Label[] array3 = new Label[(int4 = this.readInt(n32 + 8)) - int3 + 1];
                        n32 += 12;
                        for (int n39 = 0; n39 < array3.length; ++n39) {
                            array3[n39] = array2[n33 + this.readInt(n32)];
                            n32 += 4;
                        }
                        methodWriter2.visitTableSwitchInsn(int3, int4, array2[n38], array3);
                        break;
                    }
                    case 15: {
                        n32 = n32 + 4 - (n33 & 0x3);
                        final int n40 = n33 + this.readInt(n32);
                        final int int5;
                        final int[] array4 = new int[int5 = this.readInt(n32 + 4)];
                        final Label[] array5 = new Label[int5];
                        n32 += 8;
                        for (int n41 = 0; n41 < int5; ++n41) {
                            array4[n41] = this.readInt(n32);
                            array5[n41] = array2[n33 + this.readInt(n32 + 4)];
                            n32 += 8;
                        }
                        methodWriter2.visitLookupSwitchInsn(array2[n40], array4, array5);
                        break;
                    }
                    case 3: {
                        methodWriter2.visitVarInsn(n34, b[n32 + 1] & 0xFF);
                        n32 += 2;
                        break;
                    }
                    case 1: {
                        methodWriter2.visitIntInsn(n34, b[n32 + 1]);
                        n32 += 2;
                        break;
                    }
                    case 2: {
                        methodWriter2.visitIntInsn(n34, this.readShort(n32 + 1));
                        n32 += 3;
                        break;
                    }
                    case 11: {
                        methodWriter2.visitLdcInsn(this.readConst(b[n32 + 1] & 0xFF, buffer2));
                        n32 += 2;
                        break;
                    }
                    case 12: {
                        methodWriter2.visitLdcInsn(this.readConst(this.readUnsignedShort(n32 + 1), buffer2));
                        n32 += 3;
                        break;
                    }
                    case 6:
                    case 7: {
                        final int n42 = this.items[this.readUnsignedShort(n32 + 1)];
                        final boolean b4 = b[n42 - 1] == 11;
                        final String class1 = this.readClass(n42, buffer2);
                        final int n43 = this.items[this.readUnsignedShort(n42 + 2)];
                        final String utf11 = this.readUTF8(n43, buffer2);
                        final String utf12 = this.readUTF8(n43 + 2, buffer2);
                        if (n34 < 182) {
                            methodWriter2.visitFieldInsn(n34, class1, utf11, utf12);
                        }
                        else {
                            methodWriter2.visitMethodInsn(n34, class1, utf11, utf12, b4);
                        }
                        if (n34 == 185) {
                            n32 += 5;
                            break;
                        }
                        n32 += 3;
                        break;
                    }
                    case 8: {
                        final int n44 = this.items[this.readUnsignedShort(n32 + 1)];
                        int n45 = context.bootstrapMethods[this.readUnsignedShort(n44)];
                        final Handle handle = (Handle)this.readConst(this.readUnsignedShort(n45), buffer2);
                        final int unsignedShort14;
                        final Object[] array6 = new Object[unsignedShort14 = this.readUnsignedShort(n45 + 2)];
                        n45 += 4;
                        for (int n46 = 0; n46 < unsignedShort14; ++n46) {
                            array6[n46] = this.readConst(this.readUnsignedShort(n45), buffer2);
                            n45 += 2;
                        }
                        final int n47 = this.items[this.readUnsignedShort(n44 + 2)];
                        methodWriter2.visitInvokeDynamicInsn(this.readUTF8(n47, buffer2), this.readUTF8(n47 + 2, buffer2), handle, array6);
                        n32 += 5;
                        break;
                    }
                    case 5: {
                        methodWriter2.visitTypeInsn(n34, this.readClass(n32 + 1, buffer2));
                        n32 += 3;
                        break;
                    }
                    case 13: {
                        methodWriter2.visitIincInsn(b[n32 + 1] & 0xFF, b[n32 + 2]);
                        n32 += 3;
                        break;
                    }
                    default: {
                        methodWriter2.visitMultiANewArrayInsn(this.readClass(n32 + 1, buffer2), b[n32 + 3] & 0xFF);
                        n32 += 4;
                        break;
                    }
                }
                while (typeAnnotations != null && n18 < typeAnnotations.length && llllIIIIIIll(n20, n33)) {
                    if (n20 == n33) {
                        final int annotationTarget3 = this.readAnnotationTarget(context, typeAnnotations[n18]);
                        this.readAnnotationValues(annotationTarget3 + 2, buffer2, true, methodWriter2.visitInsnAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget3, buffer2), true));
                    }
                    n20 = ((++n18 >= typeAnnotations.length || this.readByte(typeAnnotations[n18]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations[n18] + 1));
                }
                while (typeAnnotations2 != null && n19 < typeAnnotations2.length && llllIIIIIIll(n21, n33)) {
                    if (n21 == n33) {
                        final int annotationTarget4 = this.readAnnotationTarget(context, typeAnnotations2[n19]);
                        this.readAnnotationValues(annotationTarget4 + 2, buffer2, true, methodWriter2.visitInsnAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget4, buffer2), false));
                    }
                    n21 = ((++n19 >= typeAnnotations2.length || this.readByte(typeAnnotations2[n19]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations2[n19] + 1));
                }
            }
            if (array2[int1] != null) {
                methodWriter2.visitLabel(array2[int1]);
            }
            if ((context.flags & 0x2) == 0x0 && n22 != 0) {
                int[] array7 = null;
                if (n23 != 0) {
                    for (int n48 = n23 + 2, length = (array7 = new int[this.readUnsignedShort(n23) * 3]).length; length > 0; array7[--length] = n48 + 6, array7[--length] = this.readUnsignedShort(n48 + 8), array7[--length] = this.readUnsignedShort(n48), n48 += 10) {}
                }
                int n49 = n22 + 2;
                for (int unsignedShort15 = this.readUnsignedShort(n22); unsignedShort15 > 0; --unsignedShort15) {
                    final int unsignedShort16 = this.readUnsignedShort(n49);
                    final int unsignedShort17 = this.readUnsignedShort(n49 + 2);
                    final int unsignedShort18 = this.readUnsignedShort(n49 + 8);
                    String utf13 = null;
                    if (array7 != null) {
                        for (int n50 = 0; n50 < array7.length; n50 += 3) {
                            if (array7[n50] == unsignedShort16 && array7[n50 + 1] == unsignedShort18) {
                                utf13 = this.readUTF8(array7[n50 + 2], buffer2);
                                break;
                            }
                        }
                    }
                    methodWriter2.visitLocalVariable(this.readUTF8(n49 + 4, buffer2), this.readUTF8(n49 + 6, buffer2), utf13, array2[unsignedShort16], array2[unsignedShort16 + unsignedShort17], unsignedShort18);
                    n49 += 10;
                }
            }
            if (typeAnnotations != null) {
                for (int n51 = 0; n51 < typeAnnotations.length; ++n51) {
                    if (this.readByte(typeAnnotations[n51]) >> 1 == 32) {
                        final int annotationTarget5 = this.readAnnotationTarget(context, typeAnnotations[n51]);
                        this.readAnnotationValues(annotationTarget5 + 2, buffer2, true, methodWriter2.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, this.readUTF8(annotationTarget5, buffer2), true));
                    }
                }
            }
            if (typeAnnotations2 != null) {
                for (int n52 = 0; n52 < typeAnnotations2.length; ++n52) {
                    if (this.readByte(typeAnnotations2[n52]) >> 1 == 32) {
                        final int annotationTarget6 = this.readAnnotationTarget(context, typeAnnotations2[n52]);
                        this.readAnnotationValues(annotationTarget6 + 2, buffer2, true, methodWriter2.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, this.readUTF8(annotationTarget6, buffer2), false));
                    }
                }
            }
            while (next3 != null) {
                final Attribute next5 = next3.next;
                next3.next = null;
                methodWriter2.visitAttribute(next3);
                next3 = next5;
            }
            methodWriter2.visitMaxs(unsignedShort5, unsignedShort6);
        }
        visitMethod.visitEnd();
        return n;
    }
    
    private void readCode(final MethodVisitor methodVisitor, final Context context, int i) {
        final byte[] b = this.b;
        final char[] buffer = context.buffer;
        final int unsignedShort = this.readUnsignedShort(i);
        final int unsignedShort2 = this.readUnsignedShort(i + 2);
        final int int1 = this.readInt(i + 4);
        i += 8;
        final int n = i;
        final int n2 = i + int1;
        final Label[] labels = new Label[int1 + 2];
        context.labels = labels;
        final Label[] array = labels;
        readLabel(int1 + 1, array);
        while (i < n2) {
            final int n3 = i - n;
            switch (ClassWriter.TYPE[b[i] & 0xFF]) {
                case 0:
                case 4: {
                    ++i;
                    continue;
                }
                case 9: {
                    readLabel(n3 + this.readShort(i + 1), array);
                    i += 3;
                    continue;
                }
                case 18: {
                    readLabel(n3 + this.readUnsignedShort(i + 1), array);
                    i += 3;
                    continue;
                }
                case 10: {
                    readLabel(n3 + this.readInt(i + 1), array);
                    i += 5;
                    continue;
                }
                case 17: {
                    if ((b[i + 1] & 0xFF) == 0x84) {
                        i += 6;
                        continue;
                    }
                    i += 4;
                    continue;
                }
                case 14: {
                    i = i + 4 - (n3 & 0x3);
                    readLabel(n3 + this.readInt(i), array);
                    for (int j = this.readInt(i + 8) - this.readInt(i + 4) + 1; j > 0; --j) {
                        readLabel(n3 + this.readInt(i + 12), array);
                        i += 4;
                    }
                    i += 12;
                    continue;
                }
                case 15: {
                    i = i + 4 - (n3 & 0x3);
                    readLabel(n3 + this.readInt(i), array);
                    for (int k = this.readInt(i + 4); k > 0; --k) {
                        readLabel(n3 + this.readInt(i + 12), array);
                        i += 8;
                    }
                    i += 8;
                    continue;
                }
                case 1:
                case 3:
                case 11: {
                    i += 2;
                    continue;
                }
                case 2:
                case 5:
                case 6:
                case 12:
                case 13: {
                    i += 3;
                    continue;
                }
                case 7:
                case 8: {
                    i += 5;
                    continue;
                }
                default: {
                    i += 4;
                    continue;
                }
            }
        }
        for (int l = this.readUnsignedShort(i); l > 0; --l) {
            methodVisitor.visitTryCatchBlock(readLabel(this.readUnsignedShort(i + 2), array), readLabel(this.readUnsignedShort(i + 4), array), readLabel(this.readUnsignedShort(i + 6), array), this.readUTF8(this.items[this.readUnsignedShort(i + 8)], buffer));
            i += 8;
        }
        i += 2;
        Object typeAnnotations = null;
        Object typeAnnotations2 = null;
        int n4 = 0;
        int n5 = 0;
        int n6 = -1;
        int n7 = -1;
        int n8 = 0;
        int n9 = 0;
        boolean b2 = true;
        final boolean b3 = (context.flags & 0x8) != 0x0;
        int frame = 0;
        int n10 = 0;
        int n11 = 0;
        Context context2 = null;
        Attribute next = null;
        for (int unsignedShort3 = this.readUnsignedShort(i); unsignedShort3 > 0; --unsignedShort3) {
            final String utf8 = this.readUTF8(i + 2, buffer);
            if (ClassReader.lIlIlIIIlII[36].equals(utf8)) {
                if ((context.flags & 0x2) == 0x0) {
                    n8 = i + 8;
                    int unsignedShort4 = this.readUnsignedShort(i + 8);
                    int n12 = i;
                    while (unsignedShort4 > 0) {
                        final int unsignedShort5 = this.readUnsignedShort(n12 + 10);
                        if (array[unsignedShort5] == null) {
                            final Label label = readLabel(unsignedShort5, array);
                            label.status |= 0x1;
                        }
                        final int n13 = unsignedShort5 + this.readUnsignedShort(n12 + 12);
                        if (array[n13] == null) {
                            final Label label2 = readLabel(n13, array);
                            label2.status |= 0x1;
                        }
                        n12 += 10;
                        --unsignedShort4;
                    }
                }
            }
            else if (ClassReader.lIlIlIIIlII[37].equals(utf8)) {
                n9 = i + 8;
            }
            else if (ClassReader.lIlIlIIIlII[38].equals(utf8)) {
                if ((context.flags & 0x2) == 0x0) {
                    int unsignedShort6 = this.readUnsignedShort(i + 8);
                    int n14 = i;
                    while (unsignedShort6 > 0) {
                        final int unsignedShort7 = this.readUnsignedShort(n14 + 10);
                        if (array[unsignedShort7] == null) {
                            final Label label3 = readLabel(unsignedShort7, array);
                            label3.status |= 0x1;
                        }
                        Label next2;
                        for (next2 = array[unsignedShort7]; next2.line > 0; next2 = next2.next) {
                            if (next2.next == null) {
                                next2.next = new Label();
                            }
                        }
                        next2.line = this.readUnsignedShort(n14 + 12);
                        n14 += 4;
                        --unsignedShort6;
                    }
                }
            }
            else if (ClassReader.lIlIlIIIlII[39].equals(utf8)) {
                n6 = (((typeAnnotations = this.readTypeAnnotations(methodVisitor, context, i + 8, 1 != 0)).length == 0 || this.readByte(typeAnnotations[0]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations[0] + 1));
            }
            else if (ClassReader.lIlIlIIIlII[40].equals(utf8)) {
                n7 = (((typeAnnotations2 = this.readTypeAnnotations(methodVisitor, context, i + 8, 0 != 0)).length == 0 || this.readByte(typeAnnotations2[0]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations2[0] + 1));
            }
            else if (ClassReader.lIlIlIIIlII[41].equals(utf8)) {
                if ((context.flags & 0x4) == 0x0) {
                    frame = i + 10;
                    n10 = this.readInt(i + 4);
                    n11 = this.readUnsignedShort(i + 8);
                }
            }
            else if (ClassReader.lIlIlIIIlII[42].equals(utf8)) {
                if ((context.flags & 0x4) == 0x0) {
                    b2 = false;
                    frame = i + 10;
                    n10 = this.readInt(i + 4);
                    n11 = this.readUnsignedShort(i + 8);
                }
            }
            else {
                for (int n15 = 0; n15 < context.attrs.length; ++n15) {
                    if (context.attrs[n15].type.equals(utf8)) {
                        final Attribute read$19eaea9b;
                        (read$19eaea9b = context.attrs[n15].read$19eaea9b(this, i + 8, this.readInt(i + 4))).next = next;
                        next = read$19eaea9b;
                    }
                }
            }
            i += 6 + this.readInt(i + 4);
        }
        if (frame != 0) {
            context2 = context;
            context.offset = -1;
            context2.mode = 0;
            context2.localCount = 0;
            context2.localDiff = 0;
            context2.stackCount = 0;
            context2.local = new Object[unsignedShort2];
            context2.stack = new Object[unsignedShort];
            if (b3) {
                this.getImplicitFrame(context);
            }
            for (int n16 = frame; n16 < frame + n10 - 2; ++n16) {
                final int unsignedShort8;
                if (b[n16] == 8 && (unsignedShort8 = this.readUnsignedShort(n16 + 1)) >= 0 && unsignedShort8 < int1 && (b[n + unsignedShort8] & 0xFF) == 0xBB) {
                    readLabel(unsignedShort8, array);
                }
            }
        }
        if ((context.flags & 0x100) != 0x0) {
            methodVisitor.visitFrame(-1, unsignedShort2, null, 0, null);
        }
        final int n17 = ((context.flags & 0x100) == 0x0) ? -33 : 0;
        i = n;
        while (i < n2) {
            final int n18 = i - n;
            final Label label4;
            if ((label4 = array[n18]) != null) {
                Label label5 = label4.next;
                label4.next = null;
                methodVisitor.visitLabel(label4);
                if ((context.flags & 0x2) == 0x0 && label4.line > 0) {
                    methodVisitor.visitLineNumber(label4.line, label4);
                    while (label5 != null) {
                        methodVisitor.visitLineNumber(label5.line, label4);
                        label5 = label5.next;
                    }
                }
            }
            while (context2 != null && (!llllIIIIIIlI(context2.offset, n18) || context2.offset == -1)) {
                if (llllIIIIIIlI(context2.offset, -1)) {
                    if (!b2 || b3) {
                        methodVisitor.visitFrame(-1, context2.localCount, context2.local, context2.stackCount, context2.stack);
                    }
                    else {
                        methodVisitor.visitFrame(context2.mode, context2.localDiff, context2.local, context2.stackCount, context2.stack);
                    }
                }
                if (n11 > 0) {
                    frame = this.readFrame(frame, b2, b3, context2);
                    --n11;
                }
                else {
                    context2 = null;
                }
            }
            int n19 = b[i] & 0xFF;
            switch (ClassWriter.TYPE[n19]) {
                case 0: {
                    methodVisitor.visitInsn(n19);
                    ++i;
                    break;
                }
                case 4: {
                    if (lllIlllIlllI(n19, 54)) {
                        n19 -= 59;
                        methodVisitor.visitVarInsn(54 + (n19 >> 2), n19 & 0x3);
                    }
                    else {
                        n19 -= 26;
                        methodVisitor.visitVarInsn(21 + (n19 >> 2), n19 & 0x3);
                    }
                    ++i;
                    break;
                }
                case 9: {
                    methodVisitor.visitJumpInsn(n19, array[n18 + this.readShort(i + 1)]);
                    i += 3;
                    break;
                }
                case 10: {
                    methodVisitor.visitJumpInsn(n19 + n17, array[n18 + this.readInt(i + 1)]);
                    i += 5;
                    break;
                }
                case 18: {
                    final int n20 = (n19 < 218) ? (n19 - 49) : (n19 - 20);
                    final Label label6 = array[n18 + this.readUnsignedShort(i + 1)];
                    if (!llllIIIIIIlI(n20, 167) || n20 == 168) {
                        methodVisitor.visitJumpInsn(n20 + 33, label6);
                    }
                    else {
                        final int n21 = llllIIIIIIll(n20, 166) ? ((n20 + 1 ^ 0x1) - 1) : (n20 ^ 0x1);
                        final Label label7 = new Label();
                        methodVisitor.visitJumpInsn(n21, label7);
                        methodVisitor.visitJumpInsn(200, label6);
                        methodVisitor.visitLabel(label7);
                        if (frame != 0 && (context2 == null || llllIIIIIIlI(context2.offset, n18 + 3))) {
                            methodVisitor.visitFrame(256, 0, null, 0, null);
                        }
                    }
                    i += 3;
                    break;
                }
                case 17: {
                    final int n22;
                    if ((n22 = (b[i + 1] & 0xFF)) == 132) {
                        methodVisitor.visitIincInsn(this.readUnsignedShort(i + 2), this.readShort(i + 4));
                        i += 6;
                        break;
                    }
                    methodVisitor.visitVarInsn(n22, this.readUnsignedShort(i + 2));
                    i += 4;
                    break;
                }
                case 14: {
                    i = i + 4 - (n18 & 0x3);
                    final int n23 = n18 + this.readInt(i);
                    final int int2 = this.readInt(i + 4);
                    final int int3;
                    final Label[] array2 = new Label[(int3 = this.readInt(i + 8)) - int2 + 1];
                    i += 12;
                    for (int n24 = 0; n24 < array2.length; ++n24) {
                        array2[n24] = array[n18 + this.readInt(i)];
                        i += 4;
                    }
                    methodVisitor.visitTableSwitchInsn(int2, int3, array[n23], array2);
                    break;
                }
                case 15: {
                    i = i + 4 - (n18 & 0x3);
                    final int n25 = n18 + this.readInt(i);
                    final int int4;
                    final int[] array3 = new int[int4 = this.readInt(i + 4)];
                    final Label[] array4 = new Label[int4];
                    i += 8;
                    for (int n26 = 0; n26 < int4; ++n26) {
                        array3[n26] = this.readInt(i);
                        array4[n26] = array[n18 + this.readInt(i + 4)];
                        i += 8;
                    }
                    methodVisitor.visitLookupSwitchInsn(array[n25], array3, array4);
                    break;
                }
                case 3: {
                    methodVisitor.visitVarInsn(n19, b[i + 1] & 0xFF);
                    i += 2;
                    break;
                }
                case 1: {
                    methodVisitor.visitIntInsn(n19, b[i + 1]);
                    i += 2;
                    break;
                }
                case 2: {
                    methodVisitor.visitIntInsn(n19, this.readShort(i + 1));
                    i += 3;
                    break;
                }
                case 11: {
                    methodVisitor.visitLdcInsn(this.readConst(b[i + 1] & 0xFF, buffer));
                    i += 2;
                    break;
                }
                case 12: {
                    methodVisitor.visitLdcInsn(this.readConst(this.readUnsignedShort(i + 1), buffer));
                    i += 3;
                    break;
                }
                case 6:
                case 7: {
                    final int n27 = this.items[this.readUnsignedShort(i + 1)];
                    final boolean b4 = b[n27 - 1] == 11;
                    final String class1 = this.readClass(n27, buffer);
                    final int n28 = this.items[this.readUnsignedShort(n27 + 2)];
                    final String utf9 = this.readUTF8(n28, buffer);
                    final String utf10 = this.readUTF8(n28 + 2, buffer);
                    if (n19 < 182) {
                        methodVisitor.visitFieldInsn(n19, class1, utf9, utf10);
                    }
                    else {
                        methodVisitor.visitMethodInsn(n19, class1, utf9, utf10, b4);
                    }
                    if (n19 == 185) {
                        i += 5;
                        break;
                    }
                    i += 3;
                    break;
                }
                case 8: {
                    final int n29 = this.items[this.readUnsignedShort(i + 1)];
                    int n30 = context.bootstrapMethods[this.readUnsignedShort(n29)];
                    final Handle handle = (Handle)this.readConst(this.readUnsignedShort(n30), buffer);
                    final int unsignedShort9;
                    final Object[] array5 = new Object[unsignedShort9 = this.readUnsignedShort(n30 + 2)];
                    n30 += 4;
                    for (int n31 = 0; n31 < unsignedShort9; ++n31) {
                        array5[n31] = this.readConst(this.readUnsignedShort(n30), buffer);
                        n30 += 2;
                    }
                    final int n32 = this.items[this.readUnsignedShort(n29 + 2)];
                    methodVisitor.visitInvokeDynamicInsn(this.readUTF8(n32, buffer), this.readUTF8(n32 + 2, buffer), handle, array5);
                    i += 5;
                    break;
                }
                case 5: {
                    methodVisitor.visitTypeInsn(n19, this.readClass(i + 1, buffer));
                    i += 3;
                    break;
                }
                case 13: {
                    methodVisitor.visitIincInsn(b[i + 1] & 0xFF, b[i + 2]);
                    i += 3;
                    break;
                }
                default: {
                    methodVisitor.visitMultiANewArrayInsn(this.readClass(i + 1, buffer), b[i + 3] & 0xFF);
                    i += 4;
                    break;
                }
            }
            while (typeAnnotations != null && n4 < ((__Null)typeAnnotations).length && llllIIIIIIll(n6, n18)) {
                if (n6 == n18) {
                    final int annotationTarget = this.readAnnotationTarget(context, typeAnnotations[n4]);
                    this.readAnnotationValues(annotationTarget + 2, buffer, true, methodVisitor.visitInsnAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget, buffer), true));
                }
                n6 = ((++n4 >= ((__Null)typeAnnotations).length || this.readByte(typeAnnotations[n4]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations[n4] + 1));
            }
            while (typeAnnotations2 != null && n5 < ((__Null)typeAnnotations2).length && llllIIIIIIll(n7, n18)) {
                if (n7 == n18) {
                    final int annotationTarget2 = this.readAnnotationTarget(context, typeAnnotations2[n5]);
                    this.readAnnotationValues(annotationTarget2 + 2, buffer, true, methodVisitor.visitInsnAnnotation(context.typeRef, context.typePath, this.readUTF8(annotationTarget2, buffer), false));
                }
                n7 = ((++n5 >= ((__Null)typeAnnotations2).length || this.readByte(typeAnnotations2[n5]) < 67) ? -1 : this.readUnsignedShort(typeAnnotations2[n5] + 1));
            }
        }
        if (array[int1] != null) {
            methodVisitor.visitLabel(array[int1]);
        }
        if ((context.flags & 0x2) == 0x0 && n8 != 0) {
            int[] array6 = null;
            if (n9 != 0) {
                i = n9 + 2;
                for (int length = (array6 = new int[this.readUnsignedShort(n9) * 3]).length; length > 0; array6[--length] = i + 6, array6[--length] = this.readUnsignedShort(i + 8), array6[--length] = this.readUnsignedShort(i), i += 10) {}
            }
            i = n8 + 2;
            for (int unsignedShort10 = this.readUnsignedShort(n8); unsignedShort10 > 0; --unsignedShort10) {
                final int unsignedShort11 = this.readUnsignedShort(i);
                final int unsignedShort12 = this.readUnsignedShort(i + 2);
                final int unsignedShort13 = this.readUnsignedShort(i + 8);
                String utf11 = null;
                if (array6 != null) {
                    for (int n33 = 0; n33 < array6.length; n33 += 3) {
                        if (array6[n33] == unsignedShort11 && array6[n33 + 1] == unsignedShort13) {
                            utf11 = this.readUTF8(array6[n33 + 2], buffer);
                            break;
                        }
                    }
                }
                methodVisitor.visitLocalVariable(this.readUTF8(i + 4, buffer), this.readUTF8(i + 6, buffer), utf11, array[unsignedShort11], array[unsignedShort11 + unsignedShort12], unsignedShort13);
                i += 10;
            }
        }
        if (typeAnnotations != null) {
            for (int n34 = 0; n34 < ((__Null)typeAnnotations).length; ++n34) {
                if (this.readByte(typeAnnotations[n34]) >> 1 == 32) {
                    final int annotationTarget3 = this.readAnnotationTarget(context, typeAnnotations[n34]);
                    this.readAnnotationValues(annotationTarget3 + 2, buffer, true, methodVisitor.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, this.readUTF8(annotationTarget3, buffer), true));
                }
            }
        }
        if (typeAnnotations2 != null) {
            for (int n35 = 0; n35 < ((__Null)typeAnnotations2).length; ++n35) {
                if (this.readByte(typeAnnotations2[n35]) >> 1 == 32) {
                    final int annotationTarget4 = this.readAnnotationTarget(context, typeAnnotations2[n35]);
                    this.readAnnotationValues(annotationTarget4 + 2, buffer, true, methodVisitor.visitLocalVariableAnnotation(context.typeRef, context.typePath, context.start, context.end, context.index, this.readUTF8(annotationTarget4, buffer), false));
                }
            }
        }
        while (next != null) {
            final Attribute next3 = next.next;
            next.next = null;
            methodVisitor.visitAttribute(next);
            next = next3;
        }
        methodVisitor.visitMaxs(unsignedShort, unsignedShort2);
    }
    
    private int[] readTypeAnnotations(final MethodVisitor methodVisitor, final Context context, int n, final boolean b) {
        final char[] buffer = context.buffer;
        final int[] array = new int[this.readUnsignedShort(n)];
        n += 2;
        for (int i = 0; i < array.length; ++i) {
            array[i] = n;
            final int int1;
            switch ((int1 = this.readInt(n)) >>> 24) {
                case 0:
                case 1:
                case 22: {
                    n += 2;
                    break;
                }
                case 19:
                case 20:
                case 21: {
                    ++n;
                    break;
                }
                case 64:
                case 65: {
                    for (int j = this.readUnsignedShort(n + 1); j > 0; --j) {
                        final int unsignedShort = this.readUnsignedShort(n + 3);
                        final int unsignedShort2 = this.readUnsignedShort(n + 5);
                        readLabel(unsignedShort, context.labels);
                        readLabel(unsignedShort + unsignedShort2, context.labels);
                        n += 6;
                    }
                    n += 3;
                    break;
                }
                case 71:
                case 72:
                case 73:
                case 74:
                case 75: {
                    n += 4;
                    break;
                }
                default: {
                    n += 3;
                    break;
                }
            }
            final int byte1 = this.readByte(n);
            if (int1 >>> 24 == 66) {
                final TypePath typePath = (byte1 == 0) ? null : new TypePath(this.b, n);
                n += 1 + byte1 * 2;
                n = this.readAnnotationValues(n + 2, buffer, true, methodVisitor.visitTryCatchAnnotation(int1, typePath, this.readUTF8(n, buffer), b));
            }
            else {
                n = this.readAnnotationValues(n + 3 + byte1 * 2, buffer, true, null);
            }
        }
        return array;
    }
    
    private int readAnnotationTarget(final Context context, int n) {
        final int int1;
        int typeRef = 0;
        switch ((int1 = this.readInt(n)) >>> 24) {
            case 0:
            case 1:
            case 22: {
                typeRef = (int1 & 0xFFFF0000);
                n += 2;
                break;
            }
            case 19:
            case 20:
            case 21: {
                typeRef = (int1 & 0xFF000000);
                ++n;
                break;
            }
            case 64:
            case 65: {
                typeRef = (int1 & 0xFF000000);
                final int unsignedShort = this.readUnsignedShort(n + 1);
                context.start = new Label[unsignedShort];
                context.end = new Label[unsignedShort];
                context.index = new int[unsignedShort];
                n += 3;
                for (int i = 0; i < unsignedShort; ++i) {
                    final int unsignedShort2 = this.readUnsignedShort(n);
                    final int unsignedShort3 = this.readUnsignedShort(n + 2);
                    context.start[i] = readLabel(unsignedShort2, context.labels);
                    context.end[i] = readLabel(unsignedShort2 + unsignedShort3, context.labels);
                    context.index[i] = this.readUnsignedShort(n + 4);
                    n += 6;
                }
                break;
            }
            case 71:
            case 72:
            case 73:
            case 74:
            case 75: {
                typeRef = (int1 & 0xFF0000FF);
                n += 4;
                break;
            }
            default: {
                final int n2 = int1;
                typeRef = (n2 & ((n2 >>> 24 < 67) ? -256 : -16777216));
                n += 3;
                break;
            }
        }
        final int byte1 = this.readByte(n);
        context.typeRef = typeRef;
        context.typePath = ((byte1 == 0) ? null : new TypePath(this.b, n));
        return n + 1 + byte1 * 2;
    }
    
    private void readParameterAnnotations(final MethodVisitor methodVisitor, final Context context, int annotationValues, final boolean b) {
        final int n = this.b[annotationValues++] & 0xFF;
        int n2;
        int i;
        for (n2 = Type.getArgumentTypes(context.desc).length - n, i = 0; i < n2; ++i) {
            final AnnotationVisitor visitParameterAnnotation;
            if ((visitParameterAnnotation = methodVisitor.visitParameterAnnotation(i, ClassReader.lIlIlIIIlII[43], false)) != null) {
                visitParameterAnnotation.visitEnd();
            }
        }
        final char[] buffer = context.buffer;
        while (i < n + n2) {
            int j = this.readUnsignedShort(annotationValues);
            annotationValues += 2;
            while (j > 0) {
                annotationValues = this.readAnnotationValues(annotationValues + 2, buffer, true, methodVisitor.visitParameterAnnotation(i, this.readUTF8(annotationValues, buffer), b));
                --j;
            }
            ++i;
        }
    }
    
    private int readAnnotationValues(int n, final char[] array, final boolean b, final AnnotationVisitor annotationVisitor) {
        int i = this.readUnsignedShort(n);
        n += 2;
        if (b) {
            while (i > 0) {
                n = this.readAnnotationValue(n + 2, array, this.readUTF8(n, array), annotationVisitor);
                --i;
            }
        }
        else {
            while (i > 0) {
                n = this.readAnnotationValue(n, array, null, annotationVisitor);
                --i;
            }
        }
        if (annotationVisitor != null) {
            annotationVisitor.visitEnd();
        }
        return n;
    }
    
    private int readAnnotationValue(int n, char[] array, final String s, final AnnotationVisitor annotationVisitor) {
        if (annotationVisitor != null) {
            Label_1190: {
                switch (this.b[n++] & 0xFF) {
                    case 68:
                    case 70:
                    case 73:
                    case 74: {
                        annotationVisitor.visit(s, this.readConst(this.readUnsignedShort(n), array));
                        n += 2;
                        break;
                    }
                    case 66: {
                        annotationVisitor.visit(s, (byte)this.readInt(this.items[this.readUnsignedShort(n)]));
                        n += 2;
                        break;
                    }
                    case 90: {
                        annotationVisitor.visit(s, (this.readInt(this.items[this.readUnsignedShort(n)]) == 0) ? Boolean.FALSE : Boolean.TRUE);
                        n += 2;
                        break;
                    }
                    case 83: {
                        annotationVisitor.visit(s, (short)this.readInt(this.items[this.readUnsignedShort(n)]));
                        n += 2;
                        break;
                    }
                    case 67: {
                        annotationVisitor.visit(s, (char)this.readInt(this.items[this.readUnsignedShort(n)]));
                        n += 2;
                        break;
                    }
                    case 115: {
                        annotationVisitor.visit(s, this.readUTF8(n, array));
                        n += 2;
                        break;
                    }
                    case 101: {
                        annotationVisitor.visitEnum(s, this.readUTF8(n, array), this.readUTF8(n + 2, array));
                        n += 4;
                        break;
                    }
                    case 99: {
                        annotationVisitor.visit(s, Type.getType(this.readUTF8(n, array)));
                        n += 2;
                        break;
                    }
                    case 64: {
                        n = this.readAnnotationValues(n + 2, array, true, annotationVisitor.visitAnnotation(s, this.readUTF8(n, array)));
                        break;
                    }
                    case 91: {
                        final int unsignedShort = this.readUnsignedShort(n);
                        n += 2;
                        if (unsignedShort == 0) {
                            return this.readAnnotationValues(n - 2, array, false, annotationVisitor.visitArray(s));
                        }
                        switch (this.b[n++] & 0xFF) {
                            case 66: {
                                final byte[] array2 = new byte[unsignedShort];
                                for (int i = 0; i < unsignedShort; ++i) {
                                    array2[i] = (byte)this.readInt(this.items[this.readUnsignedShort(n)]);
                                    n += 3;
                                }
                                annotationVisitor.visit(s, array2);
                                --n;
                                break Label_1190;
                            }
                            case 90: {
                                final boolean[] array3 = new boolean[unsignedShort];
                                for (int j = 0; j < unsignedShort; ++j) {
                                    array3[j] = (this.readInt(this.items[this.readUnsignedShort(n)]) != 0);
                                    n += 3;
                                }
                                annotationVisitor.visit(s, array3);
                                --n;
                                break Label_1190;
                            }
                            case 83: {
                                final short[] array4 = new short[unsignedShort];
                                for (int k = 0; k < unsignedShort; ++k) {
                                    array4[k] = (short)this.readInt(this.items[this.readUnsignedShort(n)]);
                                    n += 3;
                                }
                                annotationVisitor.visit(s, array4);
                                --n;
                                break Label_1190;
                            }
                            case 67: {
                                array = new char[unsignedShort];
                                for (int l = 0; l < unsignedShort; ++l) {
                                    array[l] = (char)this.readInt(this.items[this.readUnsignedShort(n)]);
                                    n += 3;
                                }
                                annotationVisitor.visit(s, array);
                                --n;
                                break Label_1190;
                            }
                            case 73: {
                                final int[] array5 = new int[unsignedShort];
                                for (int n2 = 0; n2 < unsignedShort; ++n2) {
                                    array5[n2] = this.readInt(this.items[this.readUnsignedShort(n)]);
                                    n += 3;
                                }
                                annotationVisitor.visit(s, array5);
                                --n;
                                break Label_1190;
                            }
                            case 74: {
                                final long[] array6 = new long[unsignedShort];
                                for (int n3 = 0; n3 < unsignedShort; ++n3) {
                                    array6[n3] = this.readLong(this.items[this.readUnsignedShort(n)]);
                                    n += 3;
                                }
                                annotationVisitor.visit(s, array6);
                                --n;
                                break Label_1190;
                            }
                            case 70: {
                                final float[] array7 = new float[unsignedShort];
                                for (int n4 = 0; n4 < unsignedShort; ++n4) {
                                    array7[n4] = Float.intBitsToFloat(this.readInt(this.items[this.readUnsignedShort(n)]));
                                    n += 3;
                                }
                                annotationVisitor.visit(s, array7);
                                --n;
                                break Label_1190;
                            }
                            case 68: {
                                final double[] array8 = new double[unsignedShort];
                                for (int n5 = 0; n5 < unsignedShort; ++n5) {
                                    array8[n5] = Double.longBitsToDouble(this.readLong(this.items[this.readUnsignedShort(n)]));
                                    n += 3;
                                }
                                annotationVisitor.visit(s, array8);
                                --n;
                                break Label_1190;
                            }
                            default: {
                                n = this.readAnnotationValues(n - 3, array, false, annotationVisitor.visitArray(s));
                                break Label_1190;
                            }
                        }
                        break;
                    }
                }
            }
            return n;
        }
        switch (this.b[n] & 0xFF) {
            case 101: {
                return n + 5;
            }
            case 64: {
                return this.readAnnotationValues(n + 3, array, true, null);
            }
            case 91: {
                return this.readAnnotationValues(n + 1, array, false, null);
            }
            default: {
                return n + 3;
            }
        }
    }
    
    private void getImplicitFrame(final Context context) {
        final String desc = context.desc;
        final Object[] local = context.local;
        int localCount = 0;
        if ((context.access & 0x8) == 0x0) {
            if (ClassReader.lIlIlIIIlII[44].equals(context.name)) {
                final Object[] array = local;
                final int n = 0;
                ++localCount;
                array[n] = Opcodes.UNINITIALIZED_THIS;
            }
            else {
                final Object[] array2 = local;
                final int n2 = 0;
                ++localCount;
                array2[n2] = this.readClass(this.header + 2, context.buffer);
            }
        }
        int n3 = 1;
        while (true) {
            final int n4 = n3;
            switch (desc.charAt(n3++)) {
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                case 'Z': {
                    local[localCount++] = Opcodes.INTEGER;
                    continue;
                }
                case 'F': {
                    local[localCount++] = Opcodes.FLOAT;
                    continue;
                }
                case 'J': {
                    local[localCount++] = Opcodes.LONG;
                    continue;
                }
                case 'D': {
                    local[localCount++] = Opcodes.DOUBLE;
                    continue;
                }
                case '[': {
                    while (desc.charAt(n3) == '[') {
                        ++n3;
                    }
                    if (desc.charAt(n3) == 'L') {
                        ++n3;
                        while (llllIIIIIIlI(desc.charAt(n3), 59)) {
                            ++n3;
                        }
                    }
                    local[localCount++] = desc.substring(n4, ++n3);
                    continue;
                }
                case 'L': {
                    while (llllIIIIIIlI(desc.charAt(n3), 59)) {
                        ++n3;
                    }
                    local[localCount++] = desc.substring(n4 + 1, n3++);
                    continue;
                }
                default: {
                    context.localCount = localCount;
                }
            }
        }
    }
    
    private int readFrame(int n, final boolean b, final boolean b2, final Context context) {
        final char[] buffer = context.buffer;
        final Label[] labels = context.labels;
        int n2;
        if (b) {
            n2 = (this.b[n++] & 0xFF);
        }
        else {
            n2 = 255;
            context.offset = -1;
        }
        context.localDiff = 0;
        int unsignedShort;
        if (n2 < 64) {
            unsignedShort = n2;
            context.mode = 3;
            context.stackCount = 0;
        }
        else if (n2 < 128) {
            unsignedShort = n2 - 64;
            n = this.readFrameType(context.stack, 0, n, buffer, labels);
            context.mode = 4;
            context.stackCount = 1;
        }
        else {
            unsignedShort = this.readUnsignedShort(n);
            n += 2;
            if (n2 == 247) {
                n = this.readFrameType(context.stack, 0, n, buffer, labels);
                context.mode = 4;
                context.stackCount = 1;
            }
            else if (llllIIIIIlII$255f299(n2) && n2 < 251) {
                context.mode = 2;
                context.localDiff = 251 - n2;
                context.localCount -= context.localDiff;
                context.stackCount = 0;
            }
            else if (n2 == 251) {
                context.mode = 3;
                context.stackCount = 0;
            }
            else if (n2 < 255) {
                int n3 = b2 ? context.localCount : 0;
                for (int i = n2 - 251; i > 0; --i) {
                    n = this.readFrameType(context.local, n3++, n, buffer, labels);
                }
                context.mode = 1;
                context.localDiff = n2 - 251;
                context.localCount += context.localDiff;
                context.stackCount = 0;
            }
            else {
                context.mode = 0;
                int j = this.readUnsignedShort(n);
                n += 2;
                context.localDiff = j;
                context.localCount = j;
                int n4 = 0;
                while (j > 0) {
                    n = this.readFrameType(context.local, n4++, n, buffer, labels);
                    --j;
                }
                int k = this.readUnsignedShort(n);
                n += 2;
                context.stackCount = k;
                int n5 = 0;
                while (k > 0) {
                    n = this.readFrameType(context.stack, n5++, n, buffer, labels);
                    --k;
                }
            }
        }
        readLabel(context.offset += unsignedShort + 1, labels);
        return n;
    }
    
    private int readFrameType(final Object[] array, final int n, int n2, final char[] array2, final Label[] array3) {
        switch (this.b[n2++] & 0xFF) {
            case 0: {
                array[n] = Opcodes.TOP;
                break;
            }
            case 1: {
                array[n] = Opcodes.INTEGER;
                break;
            }
            case 2: {
                array[n] = Opcodes.FLOAT;
                break;
            }
            case 3: {
                array[n] = Opcodes.DOUBLE;
                break;
            }
            case 4: {
                array[n] = Opcodes.LONG;
                break;
            }
            case 5: {
                array[n] = Opcodes.NULL;
                break;
            }
            case 6: {
                array[n] = Opcodes.UNINITIALIZED_THIS;
                break;
            }
            case 7: {
                array[n] = this.readClass(n2, array2);
                n2 += 2;
                break;
            }
            default: {
                array[n] = readLabel(this.readUnsignedShort(n2), array3);
                n2 += 2;
                break;
            }
        }
        return n2;
    }
    
    private static Label readLabel(final int n, final Label[] array) {
        if (array[n] == null) {
            array[n] = new Label();
        }
        return array[n];
    }
    
    final int getAttributes() {
        int n = this.header + 8 + this.readUnsignedShort(this.header + 6) * 2;
        for (int i = this.readUnsignedShort(n); i > 0; --i) {
            for (int j = this.readUnsignedShort(n + 8); j > 0; --j) {
                n += 6 + this.readInt(n + 12);
            }
            n += 8;
        }
        n += 2;
        for (int k = this.readUnsignedShort(n); k > 0; --k) {
            for (int l = this.readUnsignedShort(n + 8); l > 0; --l) {
                n += 6 + this.readInt(n + 12);
            }
            n += 8;
        }
        return n + 2;
    }
    
    private Attribute readAttribute$616e4f99$4bc56248(final Attribute[] array, final String s, final int n, final int n2) {
        for (int i = 0; i < array.length; ++i) {
            if (array[i].type.equals(s)) {
                return array[i].read$19eaea9b(this, n, n2);
            }
        }
        return new Attribute(s).read$19eaea9b(this, n, n2);
    }
    
    private int getItemCount() {
        return this.items.length;
    }
    
    private int getItem(final int n) {
        return this.items[n];
    }
    
    private int getMaxStringLength() {
        return this.maxStringLength;
    }
    
    public final int readByte(final int n) {
        return this.b[n] & 0xFF;
    }
    
    public final int readUnsignedShort(final int n) {
        final byte[] b = this.b;
        return (b[n] & 0xFF) << 8 | (b[n + 1] & 0xFF);
    }
    
    private short readShort(final int n) {
        final byte[] b = this.b;
        return (short)((b[n] & 0xFF) << 8 | (b[n + 1] & 0xFF));
    }
    
    public final int readInt(final int n) {
        final byte[] b;
        return ((b = this.b)[n] & 0xFF) << 24 | (b[n + 1] & 0xFF) << 16 | (b[n + 2] & 0xFF) << 8 | (b[n + 3] & 0xFF);
    }
    
    public final long readLong(final int n) {
        return this.readInt(n) << 32 | (this.readInt(n + 4) & 0xFFFFFFFFL);
    }
    
    public final String readUTF8(int n, final char[] array) {
        final int unsignedShort = this.readUnsignedShort(n);
        if (n == 0 || unsignedShort == 0) {
            return null;
        }
        final String s;
        if ((s = this.strings[unsignedShort]) != null) {
            return s;
        }
        n = this.items[unsignedShort];
        return this.strings[unsignedShort] = this.readUTF(n + 2, this.readUnsignedShort(n), array);
    }
    
    final String readUTF(int i, int n, final char[] array) {
        n += i;
        final byte[] b = this.b;
        int n2 = 0;
        int n3 = 0;
        int n4 = 0;
        while (i < n) {
            final byte b2 = b[i++];
            switch (n3) {
                case 0: {
                    final int n5;
                    if ((n5 = (b2 & 0xFF)) < 128) {
                        array[n2++] = (char)n5;
                        continue;
                    }
                    if (n5 < 224 && lllIlllIlllI(n5, 191)) {
                        n4 = (char)(n5 & 0x1F);
                        n3 = 1;
                        continue;
                    }
                    n4 = (char)(n5 & 0xF);
                    n3 = 2;
                    continue;
                }
                case 1: {
                    array[n2++] = (char)(n4 << 6 | (b2 & 0x3F));
                    n3 = 0;
                    continue;
                }
                case 2: {
                    n4 = (char)(n4 << 6 | (b2 & 0x3F));
                    n3 = 1;
                    continue;
                }
            }
        }
        return new String(array, 0, n2);
    }
    
    public final String readClass(final int n, final char[] array) {
        return this.readUTF8(this.items[this.readUnsignedShort(n)], array);
    }
    
    public final Object readConst(int n, final char[] array) {
        n = this.items[n];
        switch (this.b[n - 1]) {
            case 3: {
                return this.readInt(n);
            }
            case 4: {
                return Float.intBitsToFloat(this.readInt(n));
            }
            case 5: {
                return this.readLong(n);
            }
            case 6: {
                return Double.longBitsToDouble(this.readLong(n));
            }
            case 7: {
                return Type.getObjectType(this.readUTF8(n, array));
            }
            case 8: {
                return this.readUTF8(n, array);
            }
            case 16: {
                return Type.getMethodType(this.readUTF8(n, array));
            }
            default: {
                final int byte1 = this.readByte(n);
                final int[] items;
                n = (items = this.items)[this.readUnsignedShort(n + 1)];
                final boolean b = this.b[n - 1] == 11;
                final String class1 = this.readClass(n, array);
                n = items[this.readUnsignedShort(n + 2)];
                return new Handle(byte1, class1, this.readUTF8(n, array), this.readUTF8(n + 2, array), b);
            }
        }
    }
    
    static {
        lllIllIlIIIl();
    }
    
    private static void lllIllIlIIIl() {
        (lIlIlIIIlII = new String[45])[0] = "BootstrapMethods";
        ClassReader.lIlIlIIIlII[1] = ".class";
        ClassReader.lIlIlIIIlII[2] = "Class not found";
        ClassReader.lIlIlIIIlII[3] = "SourceFile";
        ClassReader.lIlIlIIIlII[4] = "InnerClasses";
        ClassReader.lIlIlIIIlII[5] = "EnclosingMethod";
        ClassReader.lIlIlIIIlII[6] = "Signature";
        ClassReader.lIlIlIIIlII[7] = "RuntimeVisibleAnnotations";
        ClassReader.lIlIlIIIlII[8] = "RuntimeVisibleTypeAnnotations";
        ClassReader.lIlIlIIIlII[9] = "Deprecated";
        ClassReader.lIlIlIIIlII[10] = "Synthetic";
        ClassReader.lIlIlIIIlII[11] = "SourceDebugExtension";
        ClassReader.lIlIlIIIlII[12] = "RuntimeInvisibleAnnotations";
        ClassReader.lIlIlIIIlII[13] = "RuntimeInvisibleTypeAnnotations";
        ClassReader.lIlIlIIIlII[14] = "BootstrapMethods";
        ClassReader.lIlIlIIIlII[15] = "ConstantValue";
        ClassReader.lIlIlIIIlII[16] = "Signature";
        ClassReader.lIlIlIIIlII[17] = "Deprecated";
        ClassReader.lIlIlIIIlII[18] = "Synthetic";
        ClassReader.lIlIlIIIlII[19] = "RuntimeVisibleAnnotations";
        ClassReader.lIlIlIIIlII[20] = "RuntimeVisibleTypeAnnotations";
        ClassReader.lIlIlIIIlII[21] = "RuntimeInvisibleAnnotations";
        ClassReader.lIlIlIIIlII[22] = "RuntimeInvisibleTypeAnnotations";
        ClassReader.lIlIlIIIlII[23] = "Code";
        ClassReader.lIlIlIIIlII[24] = "Exceptions";
        ClassReader.lIlIlIIIlII[25] = "Signature";
        ClassReader.lIlIlIIIlII[26] = "Deprecated";
        ClassReader.lIlIlIIIlII[27] = "RuntimeVisibleAnnotations";
        ClassReader.lIlIlIIIlII[28] = "RuntimeVisibleTypeAnnotations";
        ClassReader.lIlIlIIIlII[29] = "AnnotationDefault";
        ClassReader.lIlIlIIIlII[30] = "Synthetic";
        ClassReader.lIlIlIIIlII[31] = "RuntimeInvisibleAnnotations";
        ClassReader.lIlIlIIIlII[32] = "RuntimeInvisibleTypeAnnotations";
        ClassReader.lIlIlIIIlII[33] = "RuntimeVisibleParameterAnnotations";
        ClassReader.lIlIlIIIlII[34] = "RuntimeInvisibleParameterAnnotations";
        ClassReader.lIlIlIIIlII[35] = "MethodParameters";
        ClassReader.lIlIlIIIlII[36] = "LocalVariableTable";
        ClassReader.lIlIlIIIlII[37] = "LocalVariableTypeTable";
        ClassReader.lIlIlIIIlII[38] = "LineNumberTable";
        ClassReader.lIlIlIIIlII[39] = "RuntimeVisibleTypeAnnotations";
        ClassReader.lIlIlIIIlII[40] = "RuntimeInvisibleTypeAnnotations";
        ClassReader.lIlIlIIIlII[41] = "StackMapTable";
        ClassReader.lIlIlIIIlII[42] = "StackMap";
        ClassReader.lIlIlIIIlII[43] = "Ljava/lang/Synthetic;";
        ClassReader.lIlIlIIIlII[44] = "<init>";
    }
    
    private static String lllIlIllIlll(final String s, final String s2) {
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
    
    private static String lllIlIlllIII(String s, final String s2) {
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
    
    private static String lllIlIllIllI(final String s, final String s2) {
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
    
    private static boolean llllIIIIIlII$255f299(final int n) {
        return n >= 248;
    }
    
    private static boolean llllIIIIIIll(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lllIlllIlllI(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean llllIIIIIIII(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean llllIIIIIIIl(final int n) {
        return n >= 0;
    }
    
    private static boolean lllIlllllllI(final int n) {
        return n < 0;
    }
    
    private static boolean lllIllllIIll(final int n) {
        return n > 0;
    }
    
    private static boolean llllIIIIIIlI(final int n, final int n2) {
        return n != n2;
    }
}
