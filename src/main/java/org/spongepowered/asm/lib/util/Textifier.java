package org.spongepowered.asm.lib.util;

import java.io.*;
import org.spongepowered.asm.lib.signature.*;
import org.spongepowered.asm.lib.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class Textifier extends Printer
{
    private static int INTERNAL_NAME;
    private static int FIELD_DESCRIPTOR;
    private static int FIELD_SIGNATURE;
    private static int METHOD_DESCRIPTOR;
    private static int METHOD_SIGNATURE;
    private static int CLASS_SIGNATURE;
    private static int TYPE_DECLARATION;
    private static int CLASS_DECLARATION;
    private static int PARAMETERS_DECLARATION;
    private static int HANDLE_DESCRIPTOR;
    private String tab;
    private String tab2;
    private String tab3;
    private String ltab;
    private Map<Label, String> labelNames;
    private int access;
    private int valueNumber;
    private static final String[] llIllIIlIII;
    
    public Textifier() {
        this((byte)0);
        if (this.getClass() != Textifier.class) {
            throw new IllegalStateException();
        }
    }
    
    private Textifier(final byte b) {
        super();
        this.tab = Textifier.llIllIIlIII[0];
        this.tab2 = Textifier.llIllIIlIII[1];
        this.tab3 = Textifier.llIllIIlIII[2];
        this.ltab = Textifier.llIllIIlIII[3];
        this.valueNumber = 0;
    }
    
    public static void main(final String[] array) throws Exception {
        int n = 0;
        int n2 = 2;
        int n3 = 1;
        if (!lIIllIlIllllI(array.length, 1) || lIIllIlIlllll(array.length, 2)) {
            n3 = 0;
        }
        if (n3 != 0 && Textifier.llIllIIlIII[4].equals(array[0])) {
            n = 1;
            n2 = 0;
            if (lIIllIllIIIIl(array.length, 2)) {
                n3 = 0;
            }
        }
        if (n3 == 0) {
            System.err.println(Textifier.llIllIIlIII[5]);
            System.err.println(Textifier.llIllIIlIII[6]);
            return;
        }
        ClassReader classReader;
        if (array[n].endsWith(Textifier.llIllIIlIII[7]) || array[n].indexOf(92) >= 0 || lIIllIlIlllll(array[n].indexOf(47), -1)) {
            classReader = new ClassReader(new FileInputStream(array[n]));
        }
        else {
            classReader = new ClassReader(array[n]);
        }
        classReader.accept(new TraceClassVisitor(new PrintWriter(System.out)), n2);
    }
    
    public final void visit(int i, final int access, final String s, final String s2, final String s3, final String[] array) {
        this.access = access;
        final int n = i & 0xFFFF;
        final int n2 = i >>> 16;
        this.buf.setLength(0);
        this.buf.append(Textifier.llIllIIlIII[8]).append(n).append('.').append(n2).append(Textifier.llIllIIlIII[9]).append(i).append(Textifier.llIllIIlIII[10]);
        if ((access & 0x20000) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[11]);
        }
        this.buf.append(Textifier.llIllIIlIII[12]).append(Integer.toHexString(access).toUpperCase()).append('\n');
        this.appendDescriptor(5, s2);
        if (s2 != null) {
            final TraceSignatureVisitor traceSignatureVisitor = new TraceSignatureVisitor(access);
            new SignatureReader(s2).accept(traceSignatureVisitor);
            this.buf.append(Textifier.llIllIIlIII[13]).append(s).append(String.valueOf(traceSignatureVisitor.declaration)).append('\n');
        }
        this.appendAccess(access & 0xFFFFFFDF);
        if ((access & 0x2000) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[14]);
        }
        else if ((access & 0x200) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[15]);
        }
        else if ((access & 0x4000) == 0x0) {
            this.buf.append(Textifier.llIllIIlIII[16]);
        }
        this.appendDescriptor(0, s);
        if (s3 != null && !Textifier.llIllIIlIII[17].equals(s3)) {
            this.buf.append(Textifier.llIllIIlIII[18]);
            this.appendDescriptor(0, s3);
            this.buf.append(' ');
        }
        if (array != null && array.length > 0) {
            this.buf.append(Textifier.llIllIIlIII[19]);
            for (i = 0; i < array.length; ++i) {
                this.appendDescriptor(0, array[i]);
                this.buf.append(' ');
            }
        }
        this.buf.append(Textifier.llIllIIlIII[20]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitSource(final String s, final String s2) {
        this.buf.setLength(0);
        if (s != null) {
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[21]).append(s).append('\n');
        }
        if (s2 != null) {
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[22]).append(s2).append('\n');
        }
        if (this.buf.length() > 0) {
            this.text.add(this.buf.toString());
        }
    }
    
    public final void visitOuterClass(final String s, final String s2, final String s3) {
        this.buf.setLength(0);
        this.buf.append(this.tab).append(Textifier.llIllIIlIII[23]);
        this.appendDescriptor(0, s);
        this.buf.append(' ');
        if (s2 != null) {
            this.buf.append(s2).append(' ');
        }
        this.appendDescriptor(3, s3);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    private Textifier visitClassAnnotation(final String s, final boolean b) {
        this.text.add(Textifier.llIllIIlIII[24]);
        return this.visitAnnotation(s, b);
    }
    
    public final Printer visitClassTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        this.text.add(Textifier.llIllIIlIII[25]);
        return this.visitTypeAnnotation(n, typePath, s, b);
    }
    
    public final void visitClassAttribute(final Attribute attribute) {
        this.text.add(Textifier.llIllIIlIII[26]);
        this.visitAttribute(attribute);
    }
    
    public final void visitInnerClass(final String s, final String s2, final String s3, final int n) {
        this.buf.setLength(0);
        this.buf.append(this.tab).append(Textifier.llIllIIlIII[27]);
        this.buf.append(Integer.toHexString(n & 0xFFFFFFDF).toUpperCase()).append('\n');
        this.buf.append(this.tab);
        this.appendAccess(n);
        this.buf.append(Textifier.llIllIIlIII[28]);
        this.appendDescriptor(0, s);
        this.buf.append(' ');
        this.appendDescriptor(0, s2);
        this.buf.append(' ');
        this.appendDescriptor(0, s3);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    private Textifier visitField(final int n, final String s, final String s2, final String s3, final Object o) {
        this.buf.setLength(0);
        this.buf.append('\n');
        if ((n & 0x20000) != 0x0) {
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[29]);
        }
        this.buf.append(this.tab).append(Textifier.llIllIIlIII[30]).append(Integer.toHexString(n).toUpperCase()).append('\n');
        if (s3 != null) {
            this.buf.append(this.tab);
            this.appendDescriptor(2, s3);
            final TraceSignatureVisitor traceSignatureVisitor = new TraceSignatureVisitor(0);
            new SignatureReader(s3).acceptType(traceSignatureVisitor);
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[31]).append(String.valueOf(traceSignatureVisitor.declaration)).append('\n');
        }
        this.buf.append(this.tab);
        this.appendAccess(n);
        this.appendDescriptor(1, s2);
        this.buf.append(' ').append(s);
        if (o != null) {
            this.buf.append(Textifier.llIllIIlIII[32]);
            if (o instanceof String) {
                this.buf.append('\"').append(o).append('\"');
            }
            else {
                this.buf.append(o);
            }
        }
        this.buf.append('\n');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        return textifier;
    }
    
    private Textifier visitMethod(final int n, final String s, final String s2, String value, final String[] array) {
        this.buf.setLength(0);
        this.buf.append('\n');
        if ((n & 0x20000) != 0x0) {
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[33]);
        }
        this.buf.append(this.tab).append(Textifier.llIllIIlIII[34]).append(Integer.toHexString(n).toUpperCase()).append('\n');
        if (value != null) {
            this.buf.append(this.tab);
            this.appendDescriptor(4, value);
            final TraceSignatureVisitor traceSignatureVisitor = new TraceSignatureVisitor(0);
            new SignatureReader(value).accept(traceSignatureVisitor);
            value = String.valueOf(traceSignatureVisitor.declaration);
            final TraceSignatureVisitor traceSignatureVisitor2;
            final String s3 = ((traceSignatureVisitor2 = traceSignatureVisitor).returnType == null) ? null : String.valueOf(traceSignatureVisitor2.returnType);
            final TraceSignatureVisitor traceSignatureVisitor3;
            final String s4 = ((traceSignatureVisitor3 = traceSignatureVisitor).exceptions == null) ? null : String.valueOf(traceSignatureVisitor3.exceptions);
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[35]).append(s3).append(' ').append(s).append(value);
            if (s4 != null) {
                this.buf.append(Textifier.llIllIIlIII[36]).append(s4);
            }
            this.buf.append('\n');
        }
        this.buf.append(this.tab);
        this.appendAccess(n & 0xFFFFFFBF);
        if ((n & 0x100) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[37]);
        }
        if ((n & 0x80) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[38]);
        }
        if ((n & 0x40) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[39]);
        }
        if ((this.access & 0x200) != 0x0 && (n & 0x400) == 0x0 && (n & 0x8) == 0x0) {
            this.buf.append(Textifier.llIllIIlIII[40]);
        }
        this.buf.append(s);
        this.appendDescriptor(3, s2);
        if (array != null && array.length > 0) {
            this.buf.append(Textifier.llIllIIlIII[41]);
            for (int i = 0; i < array.length; ++i) {
                this.appendDescriptor(0, array[i]);
                this.buf.append(' ');
            }
        }
        this.buf.append('\n');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        return textifier;
    }
    
    public final void visitClassEnd() {
        this.text.add(Textifier.llIllIIlIII[42]);
    }
    
    public final void visit(final String s, final Object o) {
        this.buf.setLength(0);
        this.appendComa(this.valueNumber++);
        if (s != null) {
            this.buf.append(s).append('=');
        }
        if (o instanceof String) {
            Printer.appendString(this.buf, (String)o);
        }
        else if (o instanceof Type) {
            this.buf.append(((Type)o).getClassName()).append(Textifier.llIllIIlIII[46]);
        }
        else if (o instanceof Byte) {
            this.visitByte((byte)o);
        }
        else if (o instanceof Boolean) {
            this.visitBoolean((boolean)o);
        }
        else if (o instanceof Short) {
            this.visitShort((short)o);
        }
        else if (o instanceof Character) {
            this.visitChar((char)o);
        }
        else if (o instanceof Integer) {
            this.visitInt((int)o);
        }
        else if (o instanceof Float) {
            this.visitFloat((float)o);
        }
        else if (o instanceof Long) {
            this.visitLong((long)o);
        }
        else if (o instanceof Double) {
            this.visitDouble((double)o);
        }
        else if (o.getClass().isArray()) {
            this.buf.append('{');
            if (o instanceof byte[]) {
                final byte[] array = (byte[])o;
                for (int i = 0; i < array.length; ++i) {
                    this.appendComa(i);
                    this.visitByte(array[i]);
                }
            }
            else if (o instanceof boolean[]) {
                final boolean[] array2 = (boolean[])o;
                for (int j = 0; j < array2.length; ++j) {
                    this.appendComa(j);
                    this.visitBoolean(array2[j]);
                }
            }
            else if (o instanceof short[]) {
                final short[] array3 = (short[])o;
                for (int k = 0; k < array3.length; ++k) {
                    this.appendComa(k);
                    this.visitShort(array3[k]);
                }
            }
            else if (o instanceof char[]) {
                final char[] array4 = (char[])o;
                for (int l = 0; l < array4.length; ++l) {
                    this.appendComa(l);
                    this.visitChar(array4[l]);
                }
            }
            else if (o instanceof int[]) {
                final int[] array5 = (int[])o;
                for (int n = 0; n < array5.length; ++n) {
                    this.appendComa(n);
                    this.visitInt(array5[n]);
                }
            }
            else if (o instanceof long[]) {
                final long[] array6 = (long[])o;
                for (int n2 = 0; n2 < array6.length; ++n2) {
                    this.appendComa(n2);
                    this.visitLong(array6[n2]);
                }
            }
            else if (o instanceof float[]) {
                final float[] array7 = (float[])o;
                for (int n3 = 0; n3 < array7.length; ++n3) {
                    this.appendComa(n3);
                    this.visitFloat(array7[n3]);
                }
            }
            else if (o instanceof double[]) {
                final double[] array8 = (double[])o;
                for (int n4 = 0; n4 < array8.length; ++n4) {
                    this.appendComa(n4);
                    this.visitDouble(array8[n4]);
                }
            }
            this.buf.append('}');
        }
        this.text.add(this.buf.toString());
    }
    
    private void visitInt(final int n) {
        this.buf.append(n);
    }
    
    private void visitLong(final long n) {
        this.buf.append(n).append('L');
    }
    
    private void visitFloat(final float n) {
        this.buf.append(n).append('F');
    }
    
    private void visitDouble(final double n) {
        this.buf.append(n).append('D');
    }
    
    private void visitChar(final char c) {
        this.buf.append(Textifier.llIllIIlIII[43]).append((int)c);
    }
    
    private void visitShort(final short n) {
        this.buf.append(Textifier.llIllIIlIII[44]).append(n);
    }
    
    private void visitByte(final byte b) {
        this.buf.append(Textifier.llIllIIlIII[45]).append(b);
    }
    
    private void visitBoolean(final boolean b) {
        this.buf.append(b);
    }
    
    private void visitString(final String s) {
        Printer.appendString(this.buf, s);
    }
    
    private void visitType(final Type type) {
        this.buf.append(type.getClassName()).append(Textifier.llIllIIlIII[46]);
    }
    
    public final void visitEnum(final String s, final String s2, final String s3) {
        this.buf.setLength(0);
        this.appendComa(this.valueNumber++);
        if (s != null) {
            this.buf.append(s).append('=');
        }
        this.appendDescriptor(1, s2);
        this.buf.append('.').append(s3);
        this.text.add(this.buf.toString());
    }
    
    private Textifier visitAnnotation(final String s, final String s2) {
        this.buf.setLength(0);
        this.appendComa(this.valueNumber++);
        if (s != null) {
            this.buf.append(s).append('=');
        }
        this.buf.append('@');
        this.appendDescriptor(1, s2);
        this.buf.append('(');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.text.add(Textifier.llIllIIlIII[47]);
        return textifier;
    }
    
    private Textifier visitArray(final String s) {
        this.buf.setLength(0);
        this.appendComa(this.valueNumber++);
        if (s != null) {
            this.buf.append(s).append('=');
        }
        this.buf.append('{');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.text.add(Textifier.llIllIIlIII[48]);
        return textifier;
    }
    
    public final void visitAnnotationEnd() {
    }
    
    private Textifier visitFieldAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    public final Printer visitFieldTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return this.visitTypeAnnotation(n, typePath, s, b);
    }
    
    public final void visitFieldAttribute(final Attribute attribute) {
        this.visitAttribute(attribute);
    }
    
    public final void visitFieldEnd() {
    }
    
    public final void visitParameter(final String s, final int n) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[49]);
        this.appendAccess(n);
        this.buf.append(' ').append((s == null) ? Textifier.llIllIIlIII[50] : s).append('\n');
        this.text.add(this.buf.toString());
    }
    
    private Textifier visitAnnotationDefault() {
        this.text.add(String.valueOf(new StringBuilder().append(this.tab2).append(Textifier.llIllIIlIII[51])));
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.text.add(Textifier.llIllIIlIII[52]);
        return textifier;
    }
    
    private Textifier visitMethodAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    public final Printer visitMethodTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return this.visitTypeAnnotation(n, typePath, s, b);
    }
    
    private Textifier visitParameterAnnotation(final int n, final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append('@');
        this.appendDescriptor(1, s);
        this.buf.append('(');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.text.add(b ? Textifier.llIllIIlIII[53] : Textifier.llIllIIlIII[54]);
        this.text.add(n);
        this.text.add(Textifier.llIllIIlIII[55]);
        return textifier;
    }
    
    public final void visitMethodAttribute(final Attribute attribute) {
        this.buf.setLength(0);
        this.buf.append(this.tab).append(Textifier.llIllIIlIII[56]);
        this.appendDescriptor(-1, attribute.type);
        this.buf.append(Textifier.llIllIIlIII[57]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitCode() {
    }
    
    public final void visitFrame(final int n, final int n2, final Object[] array, final int n3, final Object[] array2) {
        this.buf.setLength(0);
        this.buf.append(this.ltab);
        this.buf.append(Textifier.llIllIIlIII[58]);
        switch (n) {
            case -1:
            case 0: {
                this.buf.append(Textifier.llIllIIlIII[59]);
                this.appendFrameTypes(n2, array);
                this.buf.append(Textifier.llIllIIlIII[60]);
                this.appendFrameTypes(n3, array2);
                this.buf.append(']');
                break;
            }
            case 1: {
                this.buf.append(Textifier.llIllIIlIII[61]);
                this.appendFrameTypes(n2, array);
                this.buf.append(']');
                break;
            }
            case 2: {
                this.buf.append(Textifier.llIllIIlIII[62]).append(n2);
                break;
            }
            case 3: {
                this.buf.append(Textifier.llIllIIlIII[63]);
                break;
            }
            case 4: {
                this.buf.append(Textifier.llIllIIlIII[64]);
                this.appendFrameTypes(1, array2);
                break;
            }
        }
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitInsn(final int n) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.OPCODES[n]).append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitIntInsn(final int n, final int n2) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.OPCODES[n]).append(' ').append((n == 188) ? Textifier.TYPES[n2] : Integer.toString(n2)).append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitVarInsn(final int n, final int n2) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.OPCODES[n]).append(' ').append(n2).append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitTypeInsn(final int n, final String s) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.OPCODES[n]).append(' ');
        this.appendDescriptor(0, s);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitFieldInsn(final int n, final String s, final String s2, final String s3) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.OPCODES[n]).append(' ');
        this.appendDescriptor(0, s);
        this.buf.append('.').append(s2).append(Textifier.llIllIIlIII[65]);
        this.appendDescriptor(1, s3);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    @Deprecated
    public final void visitMethodInsn(final int n, final String s, final String s2, final String s3) {
        if (lIIllIlIllllI(327680, 327680)) {
            super.visitMethodInsn(n, s, s2, s3);
            return;
        }
        this.doVisitMethodInsn$3f9d0ac8(n, s, s2, s3);
    }
    
    public final void visitMethodInsn(final int n, final String s, final String s2, final String s3, final boolean b) {
        this.doVisitMethodInsn$3f9d0ac8(n, s, s2, s3);
    }
    
    private void doVisitMethodInsn$3f9d0ac8(final int n, final String s, final String s2, final String s3) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.OPCODES[n]).append(' ');
        this.appendDescriptor(0, s);
        this.buf.append('.').append(s2).append(' ');
        this.appendDescriptor(3, s3);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitInvokeDynamicInsn(final String s, final String s2, final Handle handle, final Object... array) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[66]).append(' ');
        this.buf.append(s);
        this.appendDescriptor(3, s2);
        this.buf.append(Textifier.llIllIIlIII[67]);
        this.buf.append('\n');
        this.buf.append(this.tab3);
        this.appendHandle(handle);
        this.buf.append('\n');
        this.buf.append(this.tab3).append(Textifier.llIllIIlIII[68]);
        if (array.length == 0) {
            this.buf.append(Textifier.llIllIIlIII[69]);
        }
        else {
            this.buf.append('\n');
            for (int i = 0; i < array.length; ++i) {
                this.buf.append(this.tab3);
                final Object o;
                if ((o = array[i]) instanceof String) {
                    Printer.appendString(this.buf, (String)o);
                }
                else if (o instanceof Type) {
                    final Type type;
                    if ((type = (Type)o).sort == 11) {
                        this.appendDescriptor(3, type.getDescriptor());
                    }
                    else {
                        this.buf.append(type.getDescriptor()).append(Textifier.llIllIIlIII[70]);
                    }
                }
                else if (o instanceof Handle) {
                    this.appendHandle((Handle)o);
                }
                else {
                    this.buf.append(o);
                }
                this.buf.append(Textifier.llIllIIlIII[71]);
            }
            this.buf.setLength(this.buf.length() - 3);
        }
        this.buf.append('\n');
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[72]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitJumpInsn(final int n, final Label label) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.OPCODES[n]).append(' ');
        this.appendLabel(label);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitLabel(final Label label) {
        this.buf.setLength(0);
        this.buf.append(this.ltab);
        this.appendLabel(label);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitLdcInsn(final Object o) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[73]);
        if (o instanceof String) {
            Printer.appendString(this.buf, (String)o);
        }
        else if (o instanceof Type) {
            this.buf.append(((Type)o).getDescriptor()).append(Textifier.llIllIIlIII[74]);
        }
        else {
            this.buf.append(o);
        }
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitIincInsn(final int n, final int n2) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[75]).append(n).append(' ').append(n2).append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitTableSwitchInsn(final int n, int i, final Label label, final Label... array) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[76]);
        for (i = 0; i < array.length; ++i) {
            this.buf.append(this.tab3).append(n + i).append(Textifier.llIllIIlIII[77]);
            this.appendLabel(array[i]);
            this.buf.append('\n');
        }
        this.buf.append(this.tab3).append(Textifier.llIllIIlIII[78]);
        this.appendLabel(label);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitLookupSwitchInsn(final Label label, final int[] array, final Label[] array2) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[79]);
        for (int i = 0; i < array2.length; ++i) {
            this.buf.append(this.tab3).append(array[i]).append(Textifier.llIllIIlIII[80]);
            this.appendLabel(array2[i]);
            this.buf.append('\n');
        }
        this.buf.append(this.tab3).append(Textifier.llIllIIlIII[81]);
        this.appendLabel(label);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitMultiANewArrayInsn(final String s, final int n) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[82]);
        this.appendDescriptor(1, s);
        this.buf.append(' ').append(n).append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final Printer visitInsnAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return this.visitTypeAnnotation(n, typePath, s, b);
    }
    
    public final void visitTryCatchBlock(final Label label, final Label label2, final Label label3, final String s) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[83]);
        this.appendLabel(label);
        this.buf.append(' ');
        this.appendLabel(label2);
        this.buf.append(' ');
        this.appendLabel(label3);
        this.buf.append(' ');
        this.appendDescriptor(0, s);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final Printer visitTryCatchAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[84]);
        this.appendDescriptor(1, s);
        this.buf.append('(');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.buf.setLength(0);
        this.buf.append(Textifier.llIllIIlIII[85]);
        this.appendTypeReference(n);
        this.buf.append(Textifier.llIllIIlIII[86]).append(typePath);
        this.buf.append(b ? Textifier.llIllIIlIII[87] : Textifier.llIllIIlIII[88]);
        this.text.add(this.buf.toString());
        return textifier;
    }
    
    public final void visitLocalVariable(final String s, final String s2, final String s3, final Label label, final Label label2, final int n) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[89]).append(s).append(' ');
        this.appendDescriptor(1, s2);
        this.buf.append(' ');
        this.appendLabel(label);
        this.buf.append(' ');
        this.appendLabel(label2);
        this.buf.append(' ').append(n).append('\n');
        if (s3 != null) {
            this.buf.append(this.tab2);
            this.appendDescriptor(2, s3);
            final TraceSignatureVisitor traceSignatureVisitor = new TraceSignatureVisitor(0);
            new SignatureReader(s3).acceptType(traceSignatureVisitor);
            this.buf.append(this.tab2).append(Textifier.llIllIIlIII[90]).append(String.valueOf(traceSignatureVisitor.declaration)).append('\n');
        }
        this.text.add(this.buf.toString());
    }
    
    public final Printer visitLocalVariableAnnotation(int i, final TypePath typePath, final Label[] array, final Label[] array2, final int[] array3, final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[91]);
        this.appendDescriptor(1, s);
        this.buf.append('(');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.buf.setLength(0);
        this.buf.append(Textifier.llIllIIlIII[92]);
        this.appendTypeReference(i);
        this.buf.append(Textifier.llIllIIlIII[93]).append(typePath);
        for (i = 0; i < array.length; ++i) {
            this.buf.append(Textifier.llIllIIlIII[94]);
            this.appendLabel(array[i]);
            this.buf.append(Textifier.llIllIIlIII[95]);
            this.appendLabel(array2[i]);
            this.buf.append(Textifier.llIllIIlIII[96]).append(array3[i]).append(Textifier.llIllIIlIII[97]);
        }
        this.buf.append(b ? Textifier.llIllIIlIII[98] : Textifier.llIllIIlIII[99]);
        this.text.add(this.buf.toString());
        return textifier;
    }
    
    public final void visitLineNumber(final int n, final Label label) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[100]).append(n).append(' ');
        this.appendLabel(label);
        this.buf.append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitMaxs(final int n, final int n2) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[101]).append(n).append('\n');
        this.text.add(this.buf.toString());
        this.buf.setLength(0);
        this.buf.append(this.tab2).append(Textifier.llIllIIlIII[102]).append(n2).append('\n');
        this.text.add(this.buf.toString());
    }
    
    public final void visitMethodEnd() {
    }
    
    private Textifier visitAnnotation(final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(this.tab).append('@');
        this.appendDescriptor(1, s);
        this.buf.append('(');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.text.add(b ? Textifier.llIllIIlIII[103] : Textifier.llIllIIlIII[104]);
        return textifier;
    }
    
    private Textifier visitTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(this.tab).append('@');
        this.appendDescriptor(1, s);
        this.buf.append('(');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.buf.setLength(0);
        this.buf.append(Textifier.llIllIIlIII[105]);
        this.appendTypeReference(n);
        this.buf.append(Textifier.llIllIIlIII[106]).append(typePath);
        this.buf.append(b ? Textifier.llIllIIlIII[107] : Textifier.llIllIIlIII[108]);
        this.text.add(this.buf.toString());
        return textifier;
    }
    
    private void visitAttribute(final Attribute attribute) {
        this.buf.setLength(0);
        this.buf.append(this.tab).append(Textifier.llIllIIlIII[109]);
        this.appendDescriptor(-1, attribute.type);
        this.buf.append(Textifier.llIllIIlIII[110]);
        this.text.add(this.buf.toString());
    }
    
    private static Textifier createTextifier() {
        return new Textifier();
    }
    
    private void appendDescriptor(final int n, final String s) {
        if (!lIIllIllIIIIl(n, 5) || !lIIllIllIIIIl(n, 2) || n == 4) {
            if (s != null) {
                this.buf.append(Textifier.llIllIIlIII[111]).append(s).append('\n');
            }
        }
        else {
            this.buf.append(s);
        }
    }
    
    private void appendLabel(final Label label) {
        if (this.labelNames == null) {
            this.labelNames = new HashMap<Label, String>();
        }
        String value;
        if ((value = this.labelNames.get(label)) == null) {
            value = String.valueOf(new StringBuilder().append(Textifier.llIllIIlIII[112]).append(this.labelNames.size()));
            this.labelNames.put(label, value);
        }
        this.buf.append(value);
    }
    
    private void appendHandle(final Handle handle) {
        final int tag = handle.tag;
        this.buf.append(Textifier.llIllIIlIII[113]).append(Integer.toHexString(tag)).append(Textifier.llIllIIlIII[114]);
        boolean b = false;
        switch (tag) {
            case 1: {
                this.buf.append(Textifier.llIllIIlIII[115]);
                break;
            }
            case 2: {
                this.buf.append(Textifier.llIllIIlIII[116]);
                break;
            }
            case 3: {
                this.buf.append(Textifier.llIllIIlIII[117]);
                break;
            }
            case 4: {
                this.buf.append(Textifier.llIllIIlIII[118]);
                break;
            }
            case 9: {
                this.buf.append(Textifier.llIllIIlIII[119]);
                b = true;
                break;
            }
            case 7: {
                this.buf.append(Textifier.llIllIIlIII[120]);
                b = true;
                break;
            }
            case 6: {
                this.buf.append(Textifier.llIllIIlIII[121]);
                b = true;
                break;
            }
            case 5: {
                this.buf.append(Textifier.llIllIIlIII[122]);
                b = true;
                break;
            }
            case 8: {
                this.buf.append(Textifier.llIllIIlIII[123]);
                b = true;
                break;
            }
        }
        this.buf.append('\n');
        this.buf.append(this.tab3);
        this.appendDescriptor(0, handle.owner);
        this.buf.append('.');
        this.buf.append(handle.name);
        if (!b) {
            this.buf.append('(');
        }
        this.appendDescriptor(9, handle.desc);
        if (!b) {
            this.buf.append(')');
        }
    }
    
    private void appendAccess(final int n) {
        if ((n & 0x1) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[124]);
        }
        if ((n & 0x2) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[125]);
        }
        if ((n & 0x4) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[126]);
        }
        if ((n & 0x10) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[127]);
        }
        if ((n & 0x8) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[128]);
        }
        if ((n & 0x20) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[129]);
        }
        if ((n & 0x40) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[130]);
        }
        if ((n & 0x80) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[131]);
        }
        if ((n & 0x400) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[132]);
        }
        if ((n & 0x800) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[133]);
        }
        if ((n & 0x1000) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[134]);
        }
        if ((n & 0x8000) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[135]);
        }
        if ((n & 0x4000) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[136]);
        }
    }
    
    private void appendComa(final int n) {
        if (n != 0) {
            this.buf.append(Textifier.llIllIIlIII[137]);
        }
    }
    
    private void appendTypeReference(final int n) {
        final TypeReference typeReference;
        switch ((typeReference = new TypeReference(n)).value >>> 24) {
            case 0: {
                this.buf.append(Textifier.llIllIIlIII[138]).append(typeReference.getTypeParameterIndex());
            }
            case 1: {
                this.buf.append(Textifier.llIllIIlIII[139]).append(typeReference.getTypeParameterIndex());
            }
            case 16: {
                this.buf.append(Textifier.llIllIIlIII[140]).append(typeReference.getSuperTypeIndex());
            }
            case 17: {
                this.buf.append(Textifier.llIllIIlIII[141]).append(typeReference.getTypeParameterIndex()).append(Textifier.llIllIIlIII[142]).append(typeReference.getTypeParameterBoundIndex());
            }
            case 18: {
                this.buf.append(Textifier.llIllIIlIII[143]).append(typeReference.getTypeParameterIndex()).append(Textifier.llIllIIlIII[144]).append(typeReference.getTypeParameterBoundIndex());
            }
            case 19: {
                this.buf.append(Textifier.llIllIIlIII[145]);
            }
            case 20: {
                this.buf.append(Textifier.llIllIIlIII[146]);
            }
            case 21: {
                this.buf.append(Textifier.llIllIIlIII[147]);
            }
            case 22: {
                this.buf.append(Textifier.llIllIIlIII[148]).append(typeReference.getFormalParameterIndex());
            }
            case 23: {
                this.buf.append(Textifier.llIllIIlIII[149]).append(typeReference.getExceptionIndex());
            }
            case 64: {
                this.buf.append(Textifier.llIllIIlIII[150]);
            }
            case 65: {
                this.buf.append(Textifier.llIllIIlIII[151]);
            }
            case 66: {
                this.buf.append(Textifier.llIllIIlIII[152]).append(typeReference.getTryCatchBlockIndex());
            }
            case 67: {
                this.buf.append(Textifier.llIllIIlIII[153]);
            }
            case 68: {
                this.buf.append(Textifier.llIllIIlIII[154]);
            }
            case 69: {
                this.buf.append(Textifier.llIllIIlIII[155]);
            }
            case 70: {
                this.buf.append(Textifier.llIllIIlIII[156]);
            }
            case 71: {
                this.buf.append(Textifier.llIllIIlIII[157]).append(typeReference.value & 0xFF);
            }
            case 72: {
                this.buf.append(Textifier.llIllIIlIII[158]).append(typeReference.value & 0xFF);
            }
            case 73: {
                this.buf.append(Textifier.llIllIIlIII[159]).append(typeReference.value & 0xFF);
            }
            case 74: {
                this.buf.append(Textifier.llIllIIlIII[160]).append(typeReference.value & 0xFF);
            }
            case 75: {
                this.buf.append(Textifier.llIllIIlIII[161]).append(typeReference.value & 0xFF);
                break;
            }
        }
    }
    
    private void appendFrameTypes(final int n, final Object[] array) {
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                this.buf.append(' ');
            }
            if (array[i] instanceof String) {
                final String s;
                if ((s = (String)array[i]).startsWith(Textifier.llIllIIlIII[162])) {
                    this.appendDescriptor(1, s);
                }
                else {
                    this.appendDescriptor(0, s);
                }
            }
            else if (array[i] instanceof Integer) {
                switch ((int)array[i]) {
                    case 0: {
                        this.appendDescriptor(1, Textifier.llIllIIlIII[163]);
                        break;
                    }
                    case 1: {
                        this.appendDescriptor(1, Textifier.llIllIIlIII[164]);
                        break;
                    }
                    case 2: {
                        this.appendDescriptor(1, Textifier.llIllIIlIII[165]);
                        break;
                    }
                    case 3: {
                        this.appendDescriptor(1, Textifier.llIllIIlIII[166]);
                        break;
                    }
                    case 4: {
                        this.appendDescriptor(1, Textifier.llIllIIlIII[167]);
                        break;
                    }
                    case 5: {
                        this.appendDescriptor(1, Textifier.llIllIIlIII[168]);
                        break;
                    }
                    case 6: {
                        this.appendDescriptor(1, Textifier.llIllIIlIII[169]);
                        break;
                    }
                }
            }
            else {
                this.appendLabel((Label)array[i]);
            }
        }
    }
    
    public final /* bridge */ Printer visitParameterAnnotation(final int n, final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(this.tab2).append('@');
        this.appendDescriptor(1, s);
        this.buf.append('(');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.text.add(b ? Textifier.llIllIIlIII[53] : Textifier.llIllIIlIII[54]);
        this.text.add(n);
        this.text.add(Textifier.llIllIIlIII[55]);
        return textifier;
    }
    
    public final /* bridge */ Printer visitMethodAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    public final /* bridge */ Printer visitAnnotationDefault() {
        this.text.add(String.valueOf(new StringBuilder().append(this.tab2).append(Textifier.llIllIIlIII[51])));
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.text.add(Textifier.llIllIIlIII[52]);
        return textifier;
    }
    
    public final /* bridge */ Printer visitFieldAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    public final /* bridge */ Printer visitArray(final String s) {
        this.buf.setLength(0);
        this.appendComa(this.valueNumber++);
        if (s != null) {
            this.buf.append(s).append('=');
        }
        this.buf.append('{');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.text.add(Textifier.llIllIIlIII[48]);
        return textifier;
    }
    
    public final /* bridge */ Printer visitAnnotation(final String s, String s2) {
        final String s3 = s2;
        s2 = s;
        this.buf.setLength(0);
        this.appendComa(this.valueNumber++);
        if (s2 != null) {
            this.buf.append(s2).append('=');
        }
        this.buf.append('@');
        this.appendDescriptor(1, s3);
        this.buf.append('(');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        this.text.add(Textifier.llIllIIlIII[47]);
        return textifier;
    }
    
    public final /* bridge */ Printer visitMethod(final int n, final String s, String s2, String s3, final String[] array) {
        final String s4 = s2;
        final String s5 = s3;
        s3 = s4;
        s2 = s;
        this.buf.setLength(0);
        this.buf.append('\n');
        if ((n & 0x20000) != 0x0) {
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[33]);
        }
        this.buf.append(this.tab).append(Textifier.llIllIIlIII[34]).append(Integer.toHexString(n).toUpperCase()).append('\n');
        if (s5 != null) {
            this.buf.append(this.tab);
            this.appendDescriptor(4, s5);
            final TraceSignatureVisitor traceSignatureVisitor = new TraceSignatureVisitor(0);
            new SignatureReader(s5).accept(traceSignatureVisitor);
            final String value = String.valueOf(traceSignatureVisitor.declaration);
            final TraceSignatureVisitor traceSignatureVisitor2;
            final String s6 = ((traceSignatureVisitor2 = traceSignatureVisitor).returnType == null) ? null : String.valueOf(traceSignatureVisitor2.returnType);
            final TraceSignatureVisitor traceSignatureVisitor3;
            final String s7 = ((traceSignatureVisitor3 = traceSignatureVisitor).exceptions == null) ? null : String.valueOf(traceSignatureVisitor3.exceptions);
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[35]).append(s6).append(' ').append(s2).append(value);
            if (s7 != null) {
                this.buf.append(Textifier.llIllIIlIII[36]).append(s7);
            }
            this.buf.append('\n');
        }
        this.buf.append(this.tab);
        this.appendAccess(n & 0xFFFFFFBF);
        if ((n & 0x100) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[37]);
        }
        if ((n & 0x80) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[38]);
        }
        if ((n & 0x40) != 0x0) {
            this.buf.append(Textifier.llIllIIlIII[39]);
        }
        if ((this.access & 0x200) != 0x0 && (n & 0x400) == 0x0 && (n & 0x8) == 0x0) {
            this.buf.append(Textifier.llIllIIlIII[40]);
        }
        this.buf.append(s2);
        this.appendDescriptor(3, s3);
        if (array != null && array.length > 0) {
            this.buf.append(Textifier.llIllIIlIII[41]);
            for (int i = 0; i < array.length; ++i) {
                this.appendDescriptor(0, array[i]);
                this.buf.append(' ');
            }
        }
        this.buf.append('\n');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        return textifier;
    }
    
    public final /* bridge */ Printer visitField(final int n, final String s, String s2, String s3, final Object o) {
        final String s4 = s2;
        final String s5 = s3;
        s3 = s4;
        s2 = s;
        this.buf.setLength(0);
        this.buf.append('\n');
        if ((n & 0x20000) != 0x0) {
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[29]);
        }
        this.buf.append(this.tab).append(Textifier.llIllIIlIII[30]).append(Integer.toHexString(n).toUpperCase()).append('\n');
        if (s5 != null) {
            this.buf.append(this.tab);
            this.appendDescriptor(2, s5);
            final TraceSignatureVisitor traceSignatureVisitor = new TraceSignatureVisitor(0);
            new SignatureReader(s5).acceptType(traceSignatureVisitor);
            this.buf.append(this.tab).append(Textifier.llIllIIlIII[31]).append(String.valueOf(traceSignatureVisitor.declaration)).append('\n');
        }
        this.buf.append(this.tab);
        this.appendAccess(n);
        this.appendDescriptor(1, s3);
        this.buf.append(' ').append(s2);
        if (o != null) {
            this.buf.append(Textifier.llIllIIlIII[32]);
            if (o instanceof String) {
                this.buf.append('\"').append(o).append('\"');
            }
            else {
                this.buf.append(o);
            }
        }
        this.buf.append('\n');
        this.text.add(this.buf.toString());
        final Textifier textifier = new Textifier();
        this.text.add(textifier.text);
        return textifier;
    }
    
    public final /* bridge */ Printer visitClassAnnotation(final String s, final boolean b) {
        this.text.add(Textifier.llIllIIlIII[24]);
        return this.visitAnnotation(s, b);
    }
    
    static {
        lIIllIlIlIIII();
    }
    
    private static void lIIllIlIlIIII() {
        (llIllIIlIII = new String[170])[0] = "  ";
        Textifier.llIllIIlIII[1] = "    ";
        Textifier.llIllIIlIII[2] = "      ";
        Textifier.llIllIIlIII[3] = "   ";
        Textifier.llIllIIlIII[4] = "-debug";
        Textifier.llIllIIlIII[5] = "Prints a disassembled view of the given class.";
        Textifier.llIllIIlIII[6] = "Usage: Textifier [-debug] <fully qualified class name or class file name>";
        Textifier.llIllIIlIII[7] = ".class";
        Textifier.llIllIIlIII[8] = "// class version ";
        Textifier.llIllIIlIII[9] = " (";
        Textifier.llIllIIlIII[10] = ")\n";
        Textifier.llIllIIlIII[11] = "// DEPRECATED\n";
        Textifier.llIllIIlIII[12] = "// access flags 0x";
        Textifier.llIllIIlIII[13] = "// declaration: ";
        Textifier.llIllIIlIII[14] = "@interface ";
        Textifier.llIllIIlIII[15] = "interface ";
        Textifier.llIllIIlIII[16] = "class ";
        Textifier.llIllIIlIII[17] = "java/lang/Object";
        Textifier.llIllIIlIII[18] = " extends ";
        Textifier.llIllIIlIII[19] = " implements ";
        Textifier.llIllIIlIII[20] = " {\n\n";
        Textifier.llIllIIlIII[21] = "// compiled from: ";
        Textifier.llIllIIlIII[22] = "// debug info: ";
        Textifier.llIllIIlIII[23] = "OUTERCLASS ";
        Textifier.llIllIIlIII[24] = "\n";
        Textifier.llIllIIlIII[25] = "\n";
        Textifier.llIllIIlIII[26] = "\n";
        Textifier.llIllIIlIII[27] = "// access flags 0x";
        Textifier.llIllIIlIII[28] = "INNERCLASS ";
        Textifier.llIllIIlIII[29] = "// DEPRECATED\n";
        Textifier.llIllIIlIII[30] = "// access flags 0x";
        Textifier.llIllIIlIII[31] = "// declaration: ";
        Textifier.llIllIIlIII[32] = " = ";
        Textifier.llIllIIlIII[33] = "// DEPRECATED\n";
        Textifier.llIllIIlIII[34] = "// access flags 0x";
        Textifier.llIllIIlIII[35] = "// declaration: ";
        Textifier.llIllIIlIII[36] = " throws ";
        Textifier.llIllIIlIII[37] = "native ";
        Textifier.llIllIIlIII[38] = "varargs ";
        Textifier.llIllIIlIII[39] = "bridge ";
        Textifier.llIllIIlIII[40] = "default ";
        Textifier.llIllIIlIII[41] = " throws ";
        Textifier.llIllIIlIII[42] = "}\n";
        Textifier.llIllIIlIII[43] = "(char)";
        Textifier.llIllIIlIII[44] = "(short)";
        Textifier.llIllIIlIII[45] = "(byte)";
        Textifier.llIllIIlIII[46] = ".class";
        Textifier.llIllIIlIII[47] = ")";
        Textifier.llIllIIlIII[48] = "}";
        Textifier.llIllIIlIII[49] = "// parameter ";
        Textifier.llIllIIlIII[50] = "<no name>";
        Textifier.llIllIIlIII[51] = "default=";
        Textifier.llIllIIlIII[52] = "\n";
        Textifier.llIllIIlIII[53] = ") // parameter ";
        Textifier.llIllIIlIII[54] = ") // invisible, parameter ";
        Textifier.llIllIIlIII[55] = "\n";
        Textifier.llIllIIlIII[56] = "ATTRIBUTE ";
        Textifier.llIllIIlIII[57] = " : unknown\n";
        Textifier.llIllIIlIII[58] = "FRAME ";
        Textifier.llIllIIlIII[59] = "FULL [";
        Textifier.llIllIIlIII[60] = "] [";
        Textifier.llIllIIlIII[61] = "APPEND [";
        Textifier.llIllIIlIII[62] = "CHOP ";
        Textifier.llIllIIlIII[63] = "SAME";
        Textifier.llIllIIlIII[64] = "SAME1 ";
        Textifier.llIllIIlIII[65] = " : ";
        Textifier.llIllIIlIII[66] = "INVOKEDYNAMIC";
        Textifier.llIllIIlIII[67] = " [";
        Textifier.llIllIIlIII[68] = "// arguments:";
        Textifier.llIllIIlIII[69] = " none";
        Textifier.llIllIIlIII[70] = ".class";
        Textifier.llIllIIlIII[71] = ", \n";
        Textifier.llIllIIlIII[72] = "]\n";
        Textifier.llIllIIlIII[73] = "LDC ";
        Textifier.llIllIIlIII[74] = ".class";
        Textifier.llIllIIlIII[75] = "IINC ";
        Textifier.llIllIIlIII[76] = "TABLESWITCH\n";
        Textifier.llIllIIlIII[77] = ": ";
        Textifier.llIllIIlIII[78] = "default: ";
        Textifier.llIllIIlIII[79] = "LOOKUPSWITCH\n";
        Textifier.llIllIIlIII[80] = ": ";
        Textifier.llIllIIlIII[81] = "default: ";
        Textifier.llIllIIlIII[82] = "MULTIANEWARRAY ";
        Textifier.llIllIIlIII[83] = "TRYCATCHBLOCK ";
        Textifier.llIllIIlIII[84] = "TRYCATCHBLOCK @";
        Textifier.llIllIIlIII[85] = ") : ";
        Textifier.llIllIIlIII[86] = ", ";
        Textifier.llIllIIlIII[87] = "\n";
        Textifier.llIllIIlIII[88] = " // invisible\n";
        Textifier.llIllIIlIII[89] = "LOCALVARIABLE ";
        Textifier.llIllIIlIII[90] = "// declaration: ";
        Textifier.llIllIIlIII[91] = "LOCALVARIABLE @";
        Textifier.llIllIIlIII[92] = ") : ";
        Textifier.llIllIIlIII[93] = ", ";
        Textifier.llIllIIlIII[94] = " [ ";
        Textifier.llIllIIlIII[95] = " - ";
        Textifier.llIllIIlIII[96] = " - ";
        Textifier.llIllIIlIII[97] = " ]";
        Textifier.llIllIIlIII[98] = "\n";
        Textifier.llIllIIlIII[99] = " // invisible\n";
        Textifier.llIllIIlIII[100] = "LINENUMBER ";
        Textifier.llIllIIlIII[101] = "MAXSTACK = ";
        Textifier.llIllIIlIII[102] = "MAXLOCALS = ";
        Textifier.llIllIIlIII[103] = ")\n";
        Textifier.llIllIIlIII[104] = ") // invisible\n";
        Textifier.llIllIIlIII[105] = ") : ";
        Textifier.llIllIIlIII[106] = ", ";
        Textifier.llIllIIlIII[107] = "\n";
        Textifier.llIllIIlIII[108] = " // invisible\n";
        Textifier.llIllIIlIII[109] = "ATTRIBUTE ";
        Textifier.llIllIIlIII[110] = " : unknown\n";
        Textifier.llIllIIlIII[111] = "// signature ";
        Textifier.llIllIIlIII[112] = "L";
        Textifier.llIllIIlIII[113] = "// handle kind 0x";
        Textifier.llIllIIlIII[114] = " : ";
        Textifier.llIllIIlIII[115] = "GETFIELD";
        Textifier.llIllIIlIII[116] = "GETSTATIC";
        Textifier.llIllIIlIII[117] = "PUTFIELD";
        Textifier.llIllIIlIII[118] = "PUTSTATIC";
        Textifier.llIllIIlIII[119] = "INVOKEINTERFACE";
        Textifier.llIllIIlIII[120] = "INVOKESPECIAL";
        Textifier.llIllIIlIII[121] = "INVOKESTATIC";
        Textifier.llIllIIlIII[122] = "INVOKEVIRTUAL";
        Textifier.llIllIIlIII[123] = "NEWINVOKESPECIAL";
        Textifier.llIllIIlIII[124] = "public ";
        Textifier.llIllIIlIII[125] = "private ";
        Textifier.llIllIIlIII[126] = "protected ";
        Textifier.llIllIIlIII[127] = "final ";
        Textifier.llIllIIlIII[128] = "static ";
        Textifier.llIllIIlIII[129] = "synchronized ";
        Textifier.llIllIIlIII[130] = "volatile ";
        Textifier.llIllIIlIII[131] = "transient ";
        Textifier.llIllIIlIII[132] = "abstract ";
        Textifier.llIllIIlIII[133] = "strictfp ";
        Textifier.llIllIIlIII[134] = "synthetic ";
        Textifier.llIllIIlIII[135] = "mandated ";
        Textifier.llIllIIlIII[136] = "enum ";
        Textifier.llIllIIlIII[137] = ", ";
        Textifier.llIllIIlIII[138] = "CLASS_TYPE_PARAMETER ";
        Textifier.llIllIIlIII[139] = "METHOD_TYPE_PARAMETER ";
        Textifier.llIllIIlIII[140] = "CLASS_EXTENDS ";
        Textifier.llIllIIlIII[141] = "CLASS_TYPE_PARAMETER_BOUND ";
        Textifier.llIllIIlIII[142] = ", ";
        Textifier.llIllIIlIII[143] = "METHOD_TYPE_PARAMETER_BOUND ";
        Textifier.llIllIIlIII[144] = ", ";
        Textifier.llIllIIlIII[145] = "FIELD";
        Textifier.llIllIIlIII[146] = "METHOD_RETURN";
        Textifier.llIllIIlIII[147] = "METHOD_RECEIVER";
        Textifier.llIllIIlIII[148] = "METHOD_FORMAL_PARAMETER ";
        Textifier.llIllIIlIII[149] = "THROWS ";
        Textifier.llIllIIlIII[150] = "LOCAL_VARIABLE";
        Textifier.llIllIIlIII[151] = "RESOURCE_VARIABLE";
        Textifier.llIllIIlIII[152] = "EXCEPTION_PARAMETER ";
        Textifier.llIllIIlIII[153] = "INSTANCEOF";
        Textifier.llIllIIlIII[154] = "NEW";
        Textifier.llIllIIlIII[155] = "CONSTRUCTOR_REFERENCE";
        Textifier.llIllIIlIII[156] = "METHOD_REFERENCE";
        Textifier.llIllIIlIII[157] = "CAST ";
        Textifier.llIllIIlIII[158] = "CONSTRUCTOR_INVOCATION_TYPE_ARGUMENT ";
        Textifier.llIllIIlIII[159] = "METHOD_INVOCATION_TYPE_ARGUMENT ";
        Textifier.llIllIIlIII[160] = "CONSTRUCTOR_REFERENCE_TYPE_ARGUMENT ";
        Textifier.llIllIIlIII[161] = "METHOD_REFERENCE_TYPE_ARGUMENT ";
        Textifier.llIllIIlIII[162] = "[";
        Textifier.llIllIIlIII[163] = "T";
        Textifier.llIllIIlIII[164] = "I";
        Textifier.llIllIIlIII[165] = "F";
        Textifier.llIllIIlIII[166] = "D";
        Textifier.llIllIIlIII[167] = "J";
        Textifier.llIllIIlIII[168] = "N";
        Textifier.llIllIIlIII[169] = "U";
    }
    
    private static String lIIlIlIllllII(final String s, final String s2) {
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
    
    private static String lIIlIlIlllllI(String s, final String s2) {
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
    
    private static String lIIlIlIllllIl(final String s, final String s2) {
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
    
    private static boolean lIIllIlIllllI(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIllIllIIlIl$255f299(final int n) {
        return n < 0;
    }
    
    private static boolean lIIllIlIlllll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIllIlIlllIl(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIllIllIllII(final int n) {
        return n > 0;
    }
    
    private static boolean lIIllIllIIIIl(final int n, final int n2) {
        return n != n2;
    }
}
