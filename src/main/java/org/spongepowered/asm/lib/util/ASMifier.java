package org.spongepowered.asm.lib.util;

import java.io.*;
import org.spongepowered.asm.lib.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class ASMifier extends Printer
{
    private String name;
    private int id;
    private Map<Label, String> labelNames;
    private static final int ACCESS_CLASS;
    private static final int ACCESS_FIELD;
    private static final int ACCESS_INNER;
    private static final String[] lIIlIIlI;
    
    public ASMifier() {
        this(ASMifier.lIIlIIlI[0], 0);
        if (this.getClass() != ASMifier.class) {
            throw new IllegalStateException();
        }
    }
    
    private ASMifier(final String name, final int id) {
        super();
        this.name = name;
        this.id = id;
    }
    
    public static void main(final String[] array) throws Exception {
        int n = 0;
        int n2 = 2;
        int n3 = 1;
        if (!lIIIllllII(array.length, 1) || lIIIllllIl(array.length, 2)) {
            n3 = 0;
        }
        if (n3 != 0 && ASMifier.lIIlIIlI[1].equals(array[0])) {
            n = 1;
            n2 = 0;
            if (lIIIllllll(array.length, 2)) {
                n3 = 0;
            }
        }
        if (n3 == 0) {
            System.err.println(ASMifier.lIIlIIlI[2]);
            System.err.println(ASMifier.lIIlIIlI[3]);
            return;
        }
        ClassReader classReader;
        if (array[n].endsWith(ASMifier.lIIlIIlI[4]) || array[n].indexOf(92) >= 0 || lIIIllllIl(array[n].indexOf(47), -1)) {
            classReader = new ClassReader(new FileInputStream(array[n]));
        }
        else {
            classReader = new ClassReader(array[n]);
        }
        classReader.accept(new TraceClassVisitor(new ASMifier(), new PrintWriter(System.out)), n2);
    }
    
    public final void visit(int i, final int n, final String s, final String s2, final String s3, final String[] array) {
        final int lastIndex;
        String substring;
        if ((lastIndex = s.lastIndexOf(47)) == -1) {
            substring = s;
        }
        else {
            this.text.add(String.valueOf(new StringBuilder().append(ASMifier.lIIlIIlI[5]).append(s.substring(0, lastIndex).replace('/', '.')).append(ASMifier.lIIlIIlI[6])));
            substring = s.substring(lastIndex + 1);
        }
        this.text.add(ASMifier.lIIlIIlI[7]);
        this.text.add(ASMifier.lIIlIIlI[8]);
        this.text.add(String.valueOf(new StringBuilder().append(ASMifier.lIIlIIlI[9]).append(substring).append(ASMifier.lIIlIIlI[10])));
        this.text.add(ASMifier.lIIlIIlI[11]);
        this.text.add(ASMifier.lIIlIIlI[12]);
        this.text.add(ASMifier.lIIlIIlI[13]);
        this.text.add(ASMifier.lIIlIIlI[14]);
        this.text.add(ASMifier.lIIlIIlI[15]);
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[16]);
        switch (i) {
            case 196653: {
                this.buf.append(ASMifier.lIIlIIlI[17]);
                break;
            }
            case 46: {
                this.buf.append(ASMifier.lIIlIIlI[18]);
                break;
            }
            case 47: {
                this.buf.append(ASMifier.lIIlIIlI[19]);
                break;
            }
            case 48: {
                this.buf.append(ASMifier.lIIlIIlI[20]);
                break;
            }
            case 49: {
                this.buf.append(ASMifier.lIIlIIlI[21]);
                break;
            }
            case 50: {
                this.buf.append(ASMifier.lIIlIIlI[22]);
                break;
            }
            case 51: {
                this.buf.append(ASMifier.lIIlIIlI[23]);
                break;
            }
            default: {
                this.buf.append(i);
                break;
            }
        }
        this.buf.append(ASMifier.lIIlIIlI[24]);
        this.appendAccess(n | 0x40000);
        this.buf.append(ASMifier.lIIlIIlI[25]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[26]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[27]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[28]);
        if (array != null && array.length > 0) {
            this.buf.append(ASMifier.lIIlIIlI[29]);
            for (i = 0; i < array.length; ++i) {
                this.buf.append((i == 0) ? ASMifier.lIIlIIlI[30] : ASMifier.lIIlIIlI[31]);
                this.appendConstant(array[i]);
            }
            this.buf.append(ASMifier.lIIlIIlI[32]);
        }
        else {
            this.buf.append(ASMifier.lIIlIIlI[33]);
        }
        this.buf.append(ASMifier.lIIlIIlI[34]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitSource(final String s, final String s2) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[35]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[36]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[37]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitOuterClass(final String s, final String s2, final String s3) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[38]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[39]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[40]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[41]);
        this.text.add(this.buf.toString());
    }
    
    private ASMifier visitClassAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    private ASMifier visitClassTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return this.visitTypeAnnotation(n, typePath, s, b);
    }
    
    public final void visitClassAttribute(final Attribute attribute) {
        this.visitAttribute(attribute);
    }
    
    public final void visitInnerClass(final String s, final String s2, final String s3, final int n) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[42]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[43]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[44]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[45]);
        this.appendAccess(n | 0x100000);
        this.buf.append(ASMifier.lIIlIIlI[46]);
        this.text.add(this.buf.toString());
    }
    
    private ASMifier visitField(final int n, final String s, final String s2, final String s3, final Object o) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[47]);
        this.buf.append(ASMifier.lIIlIIlI[48]);
        this.appendAccess(n | 0x80000);
        this.buf.append(ASMifier.lIIlIIlI[49]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[50]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[51]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[52]);
        this.appendConstant(o);
        this.buf.append(ASMifier.lIIlIIlI[53]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[54], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[55]);
        return asMifier;
    }
    
    private ASMifier visitMethod(int i, final String s, final String s2, final String s3, final String[] array) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[56]);
        this.buf.append(ASMifier.lIIlIIlI[57]);
        this.appendAccess(i);
        this.buf.append(ASMifier.lIIlIIlI[58]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[59]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[60]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[61]);
        if (array != null && array.length > 0) {
            this.buf.append(ASMifier.lIIlIIlI[62]);
            for (i = 0; i < array.length; ++i) {
                this.buf.append((i == 0) ? ASMifier.lIIlIIlI[63] : ASMifier.lIIlIIlI[64]);
                this.appendConstant(array[i]);
            }
            this.buf.append(ASMifier.lIIlIIlI[65]);
        }
        else {
            this.buf.append(ASMifier.lIIlIIlI[66]);
        }
        this.buf.append(ASMifier.lIIlIIlI[67]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[68], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[69]);
        return asMifier;
    }
    
    public final void visitClassEnd() {
        this.text.add(ASMifier.lIIlIIlI[70]);
        this.text.add(ASMifier.lIIlIIlI[71]);
        this.text.add(ASMifier.lIIlIIlI[72]);
        this.text.add(ASMifier.lIIlIIlI[73]);
    }
    
    public final void visit(final String s, final Object o) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[74]).append(this.id).append(ASMifier.lIIlIIlI[75]);
        appendConstant(this.buf, s);
        this.buf.append(ASMifier.lIIlIIlI[76]);
        appendConstant(this.buf, o);
        this.buf.append(ASMifier.lIIlIIlI[77]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitEnum(final String s, final String s2, final String s3) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[78]).append(this.id).append(ASMifier.lIIlIIlI[79]);
        appendConstant(this.buf, s);
        this.buf.append(ASMifier.lIIlIIlI[80]);
        appendConstant(this.buf, s2);
        this.buf.append(ASMifier.lIIlIIlI[81]);
        appendConstant(this.buf, s3);
        this.buf.append(ASMifier.lIIlIIlI[82]);
        this.text.add(this.buf.toString());
    }
    
    private ASMifier visitAnnotation(final String s, final String s2) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[83]);
        this.buf.append(ASMifier.lIIlIIlI[84]).append(this.id + 1).append(ASMifier.lIIlIIlI[85]);
        this.buf.append(this.id).append(ASMifier.lIIlIIlI[86]);
        appendConstant(this.buf, s);
        this.buf.append(ASMifier.lIIlIIlI[87]);
        appendConstant(this.buf, s2);
        this.buf.append(ASMifier.lIIlIIlI[88]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[89], this.id + 1);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[90]);
        return asMifier;
    }
    
    private ASMifier visitArray(final String s) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[91]);
        this.buf.append(ASMifier.lIIlIIlI[92]).append(this.id + 1).append(ASMifier.lIIlIIlI[93]);
        this.buf.append(this.id).append(ASMifier.lIIlIIlI[94]);
        appendConstant(this.buf, s);
        this.buf.append(ASMifier.lIIlIIlI[95]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[96], this.id + 1);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[97]);
        return asMifier;
    }
    
    public final void visitAnnotationEnd() {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[98]).append(this.id).append(ASMifier.lIIlIIlI[99]);
        this.text.add(this.buf.toString());
    }
    
    private ASMifier visitFieldAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    private ASMifier visitFieldTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return this.visitTypeAnnotation(n, typePath, s, b);
    }
    
    public final void visitFieldAttribute(final Attribute attribute) {
        this.visitAttribute(attribute);
    }
    
    public final void visitFieldEnd() {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[100]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitParameter(final String s, final int n) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[101]);
        Printer.appendString(this.buf, s);
        this.buf.append(ASMifier.lIIlIIlI[102]);
        this.appendAccess(n);
        this.text.add(this.buf.append(ASMifier.lIIlIIlI[103]).toString());
    }
    
    private ASMifier visitAnnotationDefault() {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[104]).append(ASMifier.lIIlIIlI[105]).append(this.name).append(ASMifier.lIIlIIlI[106]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[107], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[108]);
        return asMifier;
    }
    
    private ASMifier visitMethodAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    private ASMifier visitMethodTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return this.visitTypeAnnotation(n, typePath, s, b);
    }
    
    private ASMifier visitParameterAnnotation(final int n, final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[109]).append(ASMifier.lIIlIIlI[110]).append(this.name).append(ASMifier.lIIlIIlI[111]).append(n).append(ASMifier.lIIlIIlI[112]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[113]).append(b).append(ASMifier.lIIlIIlI[114]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[115], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[116]);
        return asMifier;
    }
    
    public final void visitMethodAttribute(final Attribute attribute) {
        this.visitAttribute(attribute);
    }
    
    public final void visitCode() {
        this.text.add(String.valueOf(new StringBuilder().append(this.name).append(ASMifier.lIIlIIlI[117])));
    }
    
    public final void visitFrame(final int n, final int n2, final Object[] array, final int n3, final Object[] array2) {
        this.buf.setLength(0);
        switch (n) {
            case -1:
            case 0: {
                this.declareFrameTypes(n2, array);
                this.declareFrameTypes(n3, array2);
                if (n == -1) {
                    this.buf.append(this.name).append(ASMifier.lIIlIIlI[118]);
                }
                else {
                    this.buf.append(this.name).append(ASMifier.lIIlIIlI[119]);
                }
                this.buf.append(n2).append(ASMifier.lIIlIIlI[120]);
                this.appendFrameTypes(n2, array);
                this.buf.append(ASMifier.lIIlIIlI[121]).append(n3).append(ASMifier.lIIlIIlI[122]);
                this.appendFrameTypes(n3, array2);
                this.buf.append('}');
                break;
            }
            case 1: {
                this.declareFrameTypes(n2, array);
                this.buf.append(this.name).append(ASMifier.lIIlIIlI[123]).append(n2).append(ASMifier.lIIlIIlI[124]);
                this.appendFrameTypes(n2, array);
                this.buf.append(ASMifier.lIIlIIlI[125]);
                break;
            }
            case 2: {
                this.buf.append(this.name).append(ASMifier.lIIlIIlI[126]).append(n2).append(ASMifier.lIIlIIlI[127]);
                break;
            }
            case 3: {
                this.buf.append(this.name).append(ASMifier.lIIlIIlI[128]);
                break;
            }
            case 4: {
                this.declareFrameTypes(1, array2);
                this.buf.append(this.name).append(ASMifier.lIIlIIlI[129]);
                this.appendFrameTypes(1, array2);
                this.buf.append('}');
                break;
            }
        }
        this.buf.append(ASMifier.lIIlIIlI[130]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitInsn(final int n) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[131]).append(ASMifier.OPCODES[n]).append(ASMifier.lIIlIIlI[132]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitIntInsn(final int n, final int n2) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[133]).append(ASMifier.OPCODES[n]).append(ASMifier.lIIlIIlI[134]).append((n == 188) ? ASMifier.TYPES[n2] : Integer.toString(n2)).append(ASMifier.lIIlIIlI[135]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitVarInsn(final int n, final int n2) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[136]).append(ASMifier.OPCODES[n]).append(ASMifier.lIIlIIlI[137]).append(n2).append(ASMifier.lIIlIIlI[138]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitTypeInsn(final int n, final String s) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[139]).append(ASMifier.OPCODES[n]).append(ASMifier.lIIlIIlI[140]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[141]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitFieldInsn(final int n, final String s, final String s2, final String s3) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[142]).append(ASMifier.OPCODES[n]).append(ASMifier.lIIlIIlI[143]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[144]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[145]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[146]);
        this.text.add(this.buf.toString());
    }
    
    @Deprecated
    public final void visitMethodInsn(final int n, final String s, final String s2, final String s3) {
        if (lIIIllllII(327680, 327680)) {
            super.visitMethodInsn(n, s, s2, s3);
            return;
        }
        this.doVisitMethodInsn(n, s, s2, s3, n == 185);
    }
    
    public final void visitMethodInsn(final int n, final String s, final String s2, final String s3, final boolean b) {
        this.doVisitMethodInsn(n, s, s2, s3, b);
    }
    
    private void doVisitMethodInsn(final int n, final String s, final String s2, final String s3, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[147]).append(ASMifier.OPCODES[n]).append(ASMifier.lIIlIIlI[148]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[149]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[150]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[151]);
        this.buf.append(b ? ASMifier.lIIlIIlI[152] : ASMifier.lIIlIIlI[153]);
        this.buf.append(ASMifier.lIIlIIlI[154]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitInvokeDynamicInsn(final String s, final String s2, final Handle handle, final Object... array) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[155]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[156]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[157]);
        this.appendConstant(handle);
        this.buf.append(ASMifier.lIIlIIlI[158]);
        for (int i = 0; i < array.length; ++i) {
            this.appendConstant(array[i]);
            if (lIIIllllll(i, array.length - 1)) {
                this.buf.append(ASMifier.lIIlIIlI[159]);
            }
        }
        this.buf.append(ASMifier.lIIlIIlI[160]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitJumpInsn(final int n, final Label label) {
        this.buf.setLength(0);
        this.declareLabel(label);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[161]).append(ASMifier.OPCODES[n]).append(ASMifier.lIIlIIlI[162]);
        this.appendLabel(label);
        this.buf.append(ASMifier.lIIlIIlI[163]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitLabel(final Label label) {
        this.buf.setLength(0);
        this.declareLabel(label);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[164]);
        this.appendLabel(label);
        this.buf.append(ASMifier.lIIlIIlI[165]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitLdcInsn(final Object o) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[166]);
        this.appendConstant(o);
        this.buf.append(ASMifier.lIIlIIlI[167]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitIincInsn(final int n, final int n2) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[168]).append(n).append(ASMifier.lIIlIIlI[169]).append(n2).append(ASMifier.lIIlIIlI[170]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitTableSwitchInsn(final int n, final int n2, final Label label, final Label... array) {
        this.buf.setLength(0);
        for (int i = 0; i < array.length; ++i) {
            this.declareLabel(array[i]);
        }
        this.declareLabel(label);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[171]).append(n).append(ASMifier.lIIlIIlI[172]).append(n2).append(ASMifier.lIIlIIlI[173]);
        this.appendLabel(label);
        this.buf.append(ASMifier.lIIlIIlI[174]);
        for (int j = 0; j < array.length; ++j) {
            this.buf.append((j == 0) ? ASMifier.lIIlIIlI[175] : ASMifier.lIIlIIlI[176]);
            this.appendLabel(array[j]);
        }
        this.buf.append(ASMifier.lIIlIIlI[177]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitLookupSwitchInsn(final Label label, final int[] array, final Label[] array2) {
        this.buf.setLength(0);
        for (int i = 0; i < array2.length; ++i) {
            this.declareLabel(array2[i]);
        }
        this.declareLabel(label);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[178]);
        this.appendLabel(label);
        this.buf.append(ASMifier.lIIlIIlI[179]);
        for (int j = 0; j < array.length; ++j) {
            this.buf.append((j == 0) ? ASMifier.lIIlIIlI[180] : ASMifier.lIIlIIlI[181]).append(array[j]);
        }
        this.buf.append(ASMifier.lIIlIIlI[182]);
        for (int k = 0; k < array2.length; ++k) {
            this.buf.append((k == 0) ? ASMifier.lIIlIIlI[183] : ASMifier.lIIlIIlI[184]);
            this.appendLabel(array2[k]);
        }
        this.buf.append(ASMifier.lIIlIIlI[185]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitMultiANewArrayInsn(final String s, final int n) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[186]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[187]).append(n).append(ASMifier.lIIlIIlI[188]);
        this.text.add(this.buf.toString());
    }
    
    private ASMifier visitInsnAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return this.visitTypeAnnotation(ASMifier.lIIlIIlI[189], n, typePath, s, b);
    }
    
    public final void visitTryCatchBlock(final Label label, final Label label2, final Label label3, final String s) {
        this.buf.setLength(0);
        this.declareLabel(label);
        this.declareLabel(label2);
        this.declareLabel(label3);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[190]);
        this.appendLabel(label);
        this.buf.append(ASMifier.lIIlIIlI[191]);
        this.appendLabel(label2);
        this.buf.append(ASMifier.lIIlIIlI[192]);
        this.appendLabel(label3);
        this.buf.append(ASMifier.lIIlIIlI[193]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[194]);
        this.text.add(this.buf.toString());
    }
    
    private ASMifier visitTryCatchAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return this.visitTypeAnnotation(ASMifier.lIIlIIlI[195], n, typePath, s, b);
    }
    
    public final void visitLocalVariable(final String s, final String s2, final String s3, final Label label, final Label label2, final int n) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[196]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[197]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[198]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[199]);
        this.appendLabel(label);
        this.buf.append(ASMifier.lIIlIIlI[200]);
        this.appendLabel(label2);
        this.buf.append(ASMifier.lIIlIIlI[201]).append(n).append(ASMifier.lIIlIIlI[202]);
        this.text.add(this.buf.toString());
    }
    
    public final Printer visitLocalVariableAnnotation(int i, final TypePath typePath, final Label[] array, final Label[] array2, final int[] array3, final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[203]).append(ASMifier.lIIlIIlI[204]).append(this.name).append(ASMifier.lIIlIIlI[205]);
        this.buf.append(i);
        if (typePath == null) {
            this.buf.append(ASMifier.lIIlIIlI[206]);
        }
        else {
            this.buf.append(ASMifier.lIIlIIlI[207]).append(typePath).append(ASMifier.lIIlIIlI[208]);
        }
        this.buf.append(ASMifier.lIIlIIlI[209]);
        for (i = 0; i < array.length; ++i) {
            this.buf.append((i == 0) ? ASMifier.lIIlIIlI[210] : ASMifier.lIIlIIlI[211]);
            this.appendLabel(array[i]);
        }
        this.buf.append(ASMifier.lIIlIIlI[212]);
        for (i = 0; i < array2.length; ++i) {
            this.buf.append((i == 0) ? ASMifier.lIIlIIlI[213] : ASMifier.lIIlIIlI[214]);
            this.appendLabel(array2[i]);
        }
        this.buf.append(ASMifier.lIIlIIlI[215]);
        for (i = 0; i < array3.length; ++i) {
            this.buf.append((i == 0) ? ASMifier.lIIlIIlI[216] : ASMifier.lIIlIIlI[217]).append(array3[i]);
        }
        this.buf.append(ASMifier.lIIlIIlI[218]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[219]).append(b).append(ASMifier.lIIlIIlI[220]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[221], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[222]);
        return asMifier;
    }
    
    public final void visitLineNumber(final int n, final Label label) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[223]).append(n).append(ASMifier.lIIlIIlI[224]);
        this.appendLabel(label);
        this.buf.append(ASMifier.lIIlIIlI[225]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitMaxs(final int n, final int n2) {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[226]).append(n).append(ASMifier.lIIlIIlI[227]).append(n2).append(ASMifier.lIIlIIlI[228]);
        this.text.add(this.buf.toString());
    }
    
    public final void visitMethodEnd() {
        this.buf.setLength(0);
        this.buf.append(this.name).append(ASMifier.lIIlIIlI[229]);
        this.text.add(this.buf.toString());
    }
    
    private ASMifier visitAnnotation(final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[230]).append(ASMifier.lIIlIIlI[231]).append(this.name).append(ASMifier.lIIlIIlI[232]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[233]).append(b).append(ASMifier.lIIlIIlI[234]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[235], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[236]);
        return asMifier;
    }
    
    private ASMifier visitTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        return this.visitTypeAnnotation(ASMifier.lIIlIIlI[237], n, typePath, s, b);
    }
    
    private ASMifier visitTypeAnnotation(final String s, final int n, final TypePath typePath, final String s2, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[238]).append(ASMifier.lIIlIIlI[239]).append(this.name).append(ASMifier.lIIlIIlI[240]).append(s).append(ASMifier.lIIlIIlI[241]);
        this.buf.append(n);
        if (typePath == null) {
            this.buf.append(ASMifier.lIIlIIlI[242]);
        }
        else {
            this.buf.append(ASMifier.lIIlIIlI[243]).append(typePath).append(ASMifier.lIIlIIlI[244]);
        }
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[245]).append(b).append(ASMifier.lIIlIIlI[246]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[247], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[248]);
        return asMifier;
    }
    
    private void visitAttribute(final Attribute attribute) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[249]).append(attribute.type).append('\n');
        this.text.add(this.buf.toString());
    }
    
    private static ASMifier createASMifier(final String s, final int n) {
        return new ASMifier(s, n);
    }
    
    private void appendAccess(final int n) {
        int n2 = 1;
        if ((n & 0x1) != 0x0) {
            this.buf.append(ASMifier.lIIlIIlI[254]);
            n2 = 0;
        }
        if ((n & 0x2) != 0x0) {
            this.buf.append(ASMifier.lIIlIIlI[255]);
            n2 = 0;
        }
        if ((n & 0x4) != 0x0) {
            this.buf.append(ASMifier.lIIlIIlI[256]);
            n2 = 0;
        }
        if ((n & 0x10) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[257]);
            }
            this.buf.append(ASMifier.lIIlIIlI[258]);
            n2 = 0;
        }
        if ((n & 0x8) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[259]);
            }
            this.buf.append(ASMifier.lIIlIIlI[260]);
            n2 = 0;
        }
        if ((n & 0x20) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[261]);
            }
            if ((n & 0x40000) == 0x0) {
                this.buf.append(ASMifier.lIIlIIlI[262]);
            }
            else {
                this.buf.append(ASMifier.lIIlIIlI[263]);
            }
            n2 = 0;
        }
        if ((n & 0x40) != 0x0 && (n & 0x80000) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[264]);
            }
            this.buf.append(ASMifier.lIIlIIlI[265]);
            n2 = 0;
        }
        if ((n & 0x40) != 0x0 && (n & 0x40000) == 0x0 && (n & 0x80000) == 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[266]);
            }
            this.buf.append(ASMifier.lIIlIIlI[267]);
            n2 = 0;
        }
        if ((n & 0x80) != 0x0 && (n & 0x40000) == 0x0 && (n & 0x80000) == 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[268]);
            }
            this.buf.append(ASMifier.lIIlIIlI[269]);
            n2 = 0;
        }
        if ((n & 0x80) != 0x0 && (n & 0x80000) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[270]);
            }
            this.buf.append(ASMifier.lIIlIIlI[271]);
            n2 = 0;
        }
        if ((n & 0x100) != 0x0 && (n & 0x40000) == 0x0 && (n & 0x80000) == 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[272]);
            }
            this.buf.append(ASMifier.lIIlIIlI[273]);
            n2 = 0;
        }
        if ((n & 0x4000) != 0x0 && ((n & 0x40000) != 0x0 || (n & 0x80000) != 0x0 || (n & 0x100000) != 0x0)) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[274]);
            }
            this.buf.append(ASMifier.lIIlIIlI[275]);
            n2 = 0;
        }
        if ((n & 0x2000) != 0x0 && ((n & 0x40000) != 0x0 || (n & 0x100000) != 0x0)) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[276]);
            }
            this.buf.append(ASMifier.lIIlIIlI[277]);
            n2 = 0;
        }
        if ((n & 0x400) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[278]);
            }
            this.buf.append(ASMifier.lIIlIIlI[279]);
            n2 = 0;
        }
        if ((n & 0x200) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[280]);
            }
            this.buf.append(ASMifier.lIIlIIlI[281]);
            n2 = 0;
        }
        if ((n & 0x800) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[282]);
            }
            this.buf.append(ASMifier.lIIlIIlI[283]);
            n2 = 0;
        }
        if ((n & 0x1000) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[284]);
            }
            this.buf.append(ASMifier.lIIlIIlI[285]);
            n2 = 0;
        }
        if ((n & 0x20000) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[286]);
            }
            this.buf.append(ASMifier.lIIlIIlI[287]);
            n2 = 0;
        }
        if ((n & 0x8000) != 0x0) {
            if (n2 == 0) {
                this.buf.append(ASMifier.lIIlIIlI[288]);
            }
            this.buf.append(ASMifier.lIIlIIlI[289]);
            n2 = 0;
        }
        if (n2 != 0) {
            this.buf.append('0');
        }
    }
    
    private void appendConstant(final Object o) {
        appendConstant(this.buf, o);
    }
    
    private static void appendConstant(final StringBuffer sb, final Object o) {
        if (o == null) {
            sb.append(ASMifier.lIIlIIlI[290]);
            return;
        }
        if (o instanceof String) {
            Printer.appendString(sb, (String)o);
            return;
        }
        if (o instanceof Type) {
            sb.append(ASMifier.lIIlIIlI[291]);
            sb.append(((Type)o).getDescriptor());
            sb.append(ASMifier.lIIlIIlI[292]);
            return;
        }
        if (o instanceof Handle) {
            sb.append(ASMifier.lIIlIIlI[293]);
            final Handle handle = (Handle)o;
            sb.append(ASMifier.lIIlIIlI[294]).append(ASMifier.HANDLE_TAG[handle.tag]).append(ASMifier.lIIlIIlI[295]);
            sb.append(handle.owner).append(ASMifier.lIIlIIlI[296]);
            sb.append(handle.name).append(ASMifier.lIIlIIlI[297]);
            sb.append(handle.desc).append(ASMifier.lIIlIIlI[298]);
            return;
        }
        if (o instanceof Byte) {
            sb.append(ASMifier.lIIlIIlI[299]).append(o).append(')');
            return;
        }
        if (o instanceof Boolean) {
            sb.append(o ? ASMifier.lIIlIIlI[300] : ASMifier.lIIlIIlI[301]);
            return;
        }
        if (o instanceof Short) {
            sb.append(ASMifier.lIIlIIlI[302]).append(o).append(')');
            return;
        }
        if (o instanceof Character) {
            sb.append(ASMifier.lIIlIIlI[303]).append((int)(char)o).append(')');
            return;
        }
        if (o instanceof Integer) {
            sb.append(ASMifier.lIIlIIlI[304]).append(o).append(')');
            return;
        }
        if (o instanceof Float) {
            sb.append(ASMifier.lIIlIIlI[305]).append(o).append(ASMifier.lIIlIIlI[306]);
            return;
        }
        if (o instanceof Long) {
            sb.append(ASMifier.lIIlIIlI[307]).append(o).append(ASMifier.lIIlIIlI[308]);
            return;
        }
        if (o instanceof Double) {
            sb.append(ASMifier.lIIlIIlI[309]).append(o).append(ASMifier.lIIlIIlI[310]);
            return;
        }
        if (o instanceof byte[]) {
            final byte[] array = (byte[])o;
            sb.append(ASMifier.lIIlIIlI[311]);
            for (int i = 0; i < array.length; ++i) {
                sb.append((i == 0) ? ASMifier.lIIlIIlI[312] : ASMifier.lIIlIIlI[313]).append(array[i]);
            }
            sb.append('}');
            return;
        }
        if (o instanceof boolean[]) {
            final boolean[] array2 = (boolean[])o;
            sb.append(ASMifier.lIIlIIlI[314]);
            for (int j = 0; j < array2.length; ++j) {
                sb.append((j == 0) ? ASMifier.lIIlIIlI[315] : ASMifier.lIIlIIlI[316]).append(array2[j]);
            }
            sb.append('}');
            return;
        }
        if (o instanceof short[]) {
            final short[] array3 = (short[])o;
            sb.append(ASMifier.lIIlIIlI[317]);
            for (int k = 0; k < array3.length; ++k) {
                sb.append((k == 0) ? ASMifier.lIIlIIlI[318] : ASMifier.lIIlIIlI[319]).append(ASMifier.lIIlIIlI[320]).append(array3[k]);
            }
            sb.append('}');
            return;
        }
        if (o instanceof char[]) {
            final char[] array4 = (char[])o;
            sb.append(ASMifier.lIIlIIlI[321]);
            for (int l = 0; l < array4.length; ++l) {
                sb.append((l == 0) ? ASMifier.lIIlIIlI[322] : ASMifier.lIIlIIlI[323]).append(ASMifier.lIIlIIlI[324]).append((int)array4[l]);
            }
            sb.append('}');
            return;
        }
        if (o instanceof int[]) {
            final int[] array5 = (int[])o;
            sb.append(ASMifier.lIIlIIlI[325]);
            for (int n = 0; n < array5.length; ++n) {
                sb.append((n == 0) ? ASMifier.lIIlIIlI[326] : ASMifier.lIIlIIlI[327]).append(array5[n]);
            }
            sb.append('}');
            return;
        }
        if (o instanceof long[]) {
            final long[] array6 = (long[])o;
            sb.append(ASMifier.lIIlIIlI[328]);
            for (int n2 = 0; n2 < array6.length; ++n2) {
                sb.append((n2 == 0) ? ASMifier.lIIlIIlI[329] : ASMifier.lIIlIIlI[330]).append(array6[n2]).append('L');
            }
            sb.append('}');
            return;
        }
        if (o instanceof float[]) {
            final float[] array7 = (float[])o;
            sb.append(ASMifier.lIIlIIlI[331]);
            for (int n3 = 0; n3 < array7.length; ++n3) {
                sb.append((n3 == 0) ? ASMifier.lIIlIIlI[332] : ASMifier.lIIlIIlI[333]).append(array7[n3]).append('f');
            }
            sb.append('}');
            return;
        }
        if (o instanceof double[]) {
            final double[] array8 = (double[])o;
            sb.append(ASMifier.lIIlIIlI[334]);
            for (int n4 = 0; n4 < array8.length; ++n4) {
                sb.append((n4 == 0) ? ASMifier.lIIlIIlI[335] : ASMifier.lIIlIIlI[336]).append(array8[n4]).append('d');
            }
            sb.append('}');
        }
    }
    
    private void declareFrameTypes(final int n, final Object[] array) {
        for (int i = 0; i < n; ++i) {
            if (array[i] instanceof Label) {
                this.declareLabel((Label)array[i]);
            }
        }
    }
    
    private void appendFrameTypes(final int n, final Object[] array) {
        for (int i = 0; i < n; ++i) {
            if (i > 0) {
                this.buf.append(ASMifier.lIIlIIlI[337]);
            }
            if (array[i] instanceof String) {
                this.appendConstant(array[i]);
            }
            else if (array[i] instanceof Integer) {
                switch ((int)array[i]) {
                    case 0: {
                        this.buf.append(ASMifier.lIIlIIlI[338]);
                        break;
                    }
                    case 1: {
                        this.buf.append(ASMifier.lIIlIIlI[339]);
                        break;
                    }
                    case 2: {
                        this.buf.append(ASMifier.lIIlIIlI[340]);
                        break;
                    }
                    case 3: {
                        this.buf.append(ASMifier.lIIlIIlI[341]);
                        break;
                    }
                    case 4: {
                        this.buf.append(ASMifier.lIIlIIlI[342]);
                        break;
                    }
                    case 5: {
                        this.buf.append(ASMifier.lIIlIIlI[343]);
                        break;
                    }
                    case 6: {
                        this.buf.append(ASMifier.lIIlIIlI[344]);
                        break;
                    }
                }
            }
            else {
                this.appendLabel((Label)array[i]);
            }
        }
    }
    
    private void declareLabel(final Label label) {
        if (this.labelNames == null) {
            this.labelNames = new HashMap<Label, String>();
        }
        if (this.labelNames.get(label) == null) {
            final String value = String.valueOf(new StringBuilder().append(ASMifier.lIIlIIlI[345]).append(this.labelNames.size()));
            this.labelNames.put(label, value);
            this.buf.append(ASMifier.lIIlIIlI[346]).append(value).append(ASMifier.lIIlIIlI[347]);
        }
    }
    
    private void appendLabel(final Label label) {
        this.buf.append(this.labelNames.get(label));
    }
    
    public final /* bridge */ Printer visitTryCatchAnnotation(int n, final TypePath typePath, final String s, final boolean b) {
        final int n2 = n;
        n = (b ? 1 : 0);
        return this.visitTypeAnnotation(ASMifier.lIIlIIlI[195], n2, typePath, s, n != 0);
    }
    
    public final /* bridge */ Printer visitInsnAnnotation(int n, final TypePath typePath, final String s, final boolean b) {
        final int n2 = n;
        n = (b ? 1 : 0);
        return this.visitTypeAnnotation(ASMifier.lIIlIIlI[189], n2, typePath, s, n != 0);
    }
    
    public final /* bridge */ Printer visitParameterAnnotation(final int n, final String s, final boolean b) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[109]).append(ASMifier.lIIlIIlI[110]).append(this.name).append(ASMifier.lIIlIIlI[111]).append(n).append(ASMifier.lIIlIIlI[112]);
        this.appendConstant(s);
        this.buf.append(ASMifier.lIIlIIlI[113]).append(b).append(ASMifier.lIIlIIlI[114]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[115], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[116]);
        return asMifier;
    }
    
    public final /* bridge */ Printer visitMethodTypeAnnotation(int n, final TypePath typePath, final String s, final boolean b) {
        final int n2 = n;
        n = (b ? 1 : 0);
        return this.visitTypeAnnotation(n2, typePath, s, b);
    }
    
    public final /* bridge */ Printer visitMethodAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    public final /* bridge */ Printer visitAnnotationDefault() {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[104]).append(ASMifier.lIIlIIlI[105]).append(this.name).append(ASMifier.lIIlIIlI[106]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[107], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[108]);
        return asMifier;
    }
    
    public final /* bridge */ Printer visitFieldTypeAnnotation(int n, final TypePath typePath, final String s, final boolean b) {
        final int n2 = n;
        n = (b ? 1 : 0);
        return this.visitTypeAnnotation(n2, typePath, s, b);
    }
    
    public final /* bridge */ Printer visitFieldAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    public final /* bridge */ Printer visitArray(final String s) {
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[91]);
        this.buf.append(ASMifier.lIIlIIlI[92]).append(this.id + 1).append(ASMifier.lIIlIIlI[93]);
        this.buf.append(this.id).append(ASMifier.lIIlIIlI[94]);
        appendConstant(this.buf, s);
        this.buf.append(ASMifier.lIIlIIlI[95]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[96], this.id + 1);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[97]);
        return asMifier;
    }
    
    public final /* bridge */ Printer visitAnnotation(final String s, String s2) {
        final String s3 = s2;
        s2 = s;
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[83]);
        this.buf.append(ASMifier.lIIlIIlI[84]).append(this.id + 1).append(ASMifier.lIIlIIlI[85]);
        this.buf.append(this.id).append(ASMifier.lIIlIIlI[86]);
        appendConstant(this.buf, s2);
        this.buf.append(ASMifier.lIIlIIlI[87]);
        appendConstant(this.buf, s3);
        this.buf.append(ASMifier.lIIlIIlI[88]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[89], this.id + 1);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[90]);
        return asMifier;
    }
    
    public final /* bridge */ Printer visitMethod(final int n, final String s, String s2, String s3, final String[] array) {
        final String s4 = s2;
        final String s5 = s3;
        s3 = s4;
        s2 = s;
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[56]);
        this.buf.append(ASMifier.lIIlIIlI[57]);
        this.appendAccess(n);
        this.buf.append(ASMifier.lIIlIIlI[58]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[59]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[60]);
        this.appendConstant(s5);
        this.buf.append(ASMifier.lIIlIIlI[61]);
        if (array != null && array.length > 0) {
            this.buf.append(ASMifier.lIIlIIlI[62]);
            for (int i = 0; i < array.length; ++i) {
                this.buf.append((i == 0) ? ASMifier.lIIlIIlI[63] : ASMifier.lIIlIIlI[64]);
                this.appendConstant(array[i]);
            }
            this.buf.append(ASMifier.lIIlIIlI[65]);
        }
        else {
            this.buf.append(ASMifier.lIIlIIlI[66]);
        }
        this.buf.append(ASMifier.lIIlIIlI[67]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[68], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[69]);
        return asMifier;
    }
    
    public final /* bridge */ Printer visitField(final int n, final String s, String s2, String s3, final Object o) {
        final String s4 = s2;
        final String s5 = s3;
        s3 = s4;
        s2 = s;
        this.buf.setLength(0);
        this.buf.append(ASMifier.lIIlIIlI[47]);
        this.buf.append(ASMifier.lIIlIIlI[48]);
        this.appendAccess(n | 0x80000);
        this.buf.append(ASMifier.lIIlIIlI[49]);
        this.appendConstant(s2);
        this.buf.append(ASMifier.lIIlIIlI[50]);
        this.appendConstant(s3);
        this.buf.append(ASMifier.lIIlIIlI[51]);
        this.appendConstant(s5);
        this.buf.append(ASMifier.lIIlIIlI[52]);
        this.appendConstant(o);
        this.buf.append(ASMifier.lIIlIIlI[53]);
        this.text.add(this.buf.toString());
        final ASMifier asMifier = createASMifier(ASMifier.lIIlIIlI[54], 0);
        this.text.add(asMifier.text);
        this.text.add(ASMifier.lIIlIIlI[55]);
        return asMifier;
    }
    
    public final /* bridge */ Printer visitClassTypeAnnotation(int n, final TypePath typePath, final String s, final boolean b) {
        final int n2 = n;
        n = (b ? 1 : 0);
        return this.visitTypeAnnotation(n2, typePath, s, b);
    }
    
    public final /* bridge */ Printer visitClassAnnotation(final String s, final boolean b) {
        return this.visitAnnotation(s, b);
    }
    
    static {
        lIIIIllIll();
    }
    
    private static void lIIIIllIll() {
        (lIIlIIlI = new String[348])[0] = "cw";
        ASMifier.lIIlIIlI[1] = "-debug";
        ASMifier.lIIlIIlI[2] = "Prints the ASM code to generate the given class.";
        ASMifier.lIIlIIlI[3] = "Usage: ASMifier [-debug] <fully qualified class name or class file name>";
        ASMifier.lIIlIIlI[4] = ".class";
        ASMifier.lIIlIIlI[5] = "package asm.";
        ASMifier.lIIlIIlI[6] = ";\n";
        ASMifier.lIIlIIlI[7] = "import java.util.*;\n";
        ASMifier.lIIlIIlI[8] = "import org.objectweb.asm.*;\n";
        ASMifier.lIIlIIlI[9] = "public class ";
        ASMifier.lIIlIIlI[10] = "Dump implements Opcodes {\n\n";
        ASMifier.lIIlIIlI[11] = "public static byte[] dump () throws Exception {\n\n";
        ASMifier.lIIlIIlI[12] = "ClassWriter cw = new ClassWriter(0);\n";
        ASMifier.lIIlIIlI[13] = "FieldVisitor fv;\n";
        ASMifier.lIIlIIlI[14] = "MethodVisitor mv;\n";
        ASMifier.lIIlIIlI[15] = "AnnotationVisitor av0;\n\n";
        ASMifier.lIIlIIlI[16] = "cw.visit(";
        ASMifier.lIIlIIlI[17] = "V1_1";
        ASMifier.lIIlIIlI[18] = "V1_2";
        ASMifier.lIIlIIlI[19] = "V1_3";
        ASMifier.lIIlIIlI[20] = "V1_4";
        ASMifier.lIIlIIlI[21] = "V1_5";
        ASMifier.lIIlIIlI[22] = "V1_6";
        ASMifier.lIIlIIlI[23] = "V1_7";
        ASMifier.lIIlIIlI[24] = ", ";
        ASMifier.lIIlIIlI[25] = ", ";
        ASMifier.lIIlIIlI[26] = ", ";
        ASMifier.lIIlIIlI[27] = ", ";
        ASMifier.lIIlIIlI[28] = ", ";
        ASMifier.lIIlIIlI[29] = "new String[] {";
        ASMifier.lIIlIIlI[30] = " ";
        ASMifier.lIIlIIlI[31] = ", ";
        ASMifier.lIIlIIlI[32] = " }";
        ASMifier.lIIlIIlI[33] = "null";
        ASMifier.lIIlIIlI[34] = ");\n\n";
        ASMifier.lIIlIIlI[35] = "cw.visitSource(";
        ASMifier.lIIlIIlI[36] = ", ";
        ASMifier.lIIlIIlI[37] = ");\n\n";
        ASMifier.lIIlIIlI[38] = "cw.visitOuterClass(";
        ASMifier.lIIlIIlI[39] = ", ";
        ASMifier.lIIlIIlI[40] = ", ";
        ASMifier.lIIlIIlI[41] = ");\n\n";
        ASMifier.lIIlIIlI[42] = "cw.visitInnerClass(";
        ASMifier.lIIlIIlI[43] = ", ";
        ASMifier.lIIlIIlI[44] = ", ";
        ASMifier.lIIlIIlI[45] = ", ";
        ASMifier.lIIlIIlI[46] = ");\n\n";
        ASMifier.lIIlIIlI[47] = "{\n";
        ASMifier.lIIlIIlI[48] = "fv = cw.visitField(";
        ASMifier.lIIlIIlI[49] = ", ";
        ASMifier.lIIlIIlI[50] = ", ";
        ASMifier.lIIlIIlI[51] = ", ";
        ASMifier.lIIlIIlI[52] = ", ";
        ASMifier.lIIlIIlI[53] = ");\n";
        ASMifier.lIIlIIlI[54] = "fv";
        ASMifier.lIIlIIlI[55] = "}\n";
        ASMifier.lIIlIIlI[56] = "{\n";
        ASMifier.lIIlIIlI[57] = "mv = cw.visitMethod(";
        ASMifier.lIIlIIlI[58] = ", ";
        ASMifier.lIIlIIlI[59] = ", ";
        ASMifier.lIIlIIlI[60] = ", ";
        ASMifier.lIIlIIlI[61] = ", ";
        ASMifier.lIIlIIlI[62] = "new String[] {";
        ASMifier.lIIlIIlI[63] = " ";
        ASMifier.lIIlIIlI[64] = ", ";
        ASMifier.lIIlIIlI[65] = " }";
        ASMifier.lIIlIIlI[66] = "null";
        ASMifier.lIIlIIlI[67] = ");\n";
        ASMifier.lIIlIIlI[68] = "mv";
        ASMifier.lIIlIIlI[69] = "}\n";
        ASMifier.lIIlIIlI[70] = "cw.visitEnd();\n\n";
        ASMifier.lIIlIIlI[71] = "return cw.toByteArray();\n";
        ASMifier.lIIlIIlI[72] = "}\n";
        ASMifier.lIIlIIlI[73] = "}\n";
        ASMifier.lIIlIIlI[74] = "av";
        ASMifier.lIIlIIlI[75] = ".visit(";
        ASMifier.lIIlIIlI[76] = ", ";
        ASMifier.lIIlIIlI[77] = ");\n";
        ASMifier.lIIlIIlI[78] = "av";
        ASMifier.lIIlIIlI[79] = ".visitEnum(";
        ASMifier.lIIlIIlI[80] = ", ";
        ASMifier.lIIlIIlI[81] = ", ";
        ASMifier.lIIlIIlI[82] = ");\n";
        ASMifier.lIIlIIlI[83] = "{\n";
        ASMifier.lIIlIIlI[84] = "AnnotationVisitor av";
        ASMifier.lIIlIIlI[85] = " = av";
        ASMifier.lIIlIIlI[86] = ".visitAnnotation(";
        ASMifier.lIIlIIlI[87] = ", ";
        ASMifier.lIIlIIlI[88] = ");\n";
        ASMifier.lIIlIIlI[89] = "av";
        ASMifier.lIIlIIlI[90] = "}\n";
        ASMifier.lIIlIIlI[91] = "{\n";
        ASMifier.lIIlIIlI[92] = "AnnotationVisitor av";
        ASMifier.lIIlIIlI[93] = " = av";
        ASMifier.lIIlIIlI[94] = ".visitArray(";
        ASMifier.lIIlIIlI[95] = ");\n";
        ASMifier.lIIlIIlI[96] = "av";
        ASMifier.lIIlIIlI[97] = "}\n";
        ASMifier.lIIlIIlI[98] = "av";
        ASMifier.lIIlIIlI[99] = ".visitEnd();\n";
        ASMifier.lIIlIIlI[100] = ".visitEnd();\n";
        ASMifier.lIIlIIlI[101] = ".visitParameter(";
        ASMifier.lIIlIIlI[102] = ", ";
        ASMifier.lIIlIIlI[103] = ");\n";
        ASMifier.lIIlIIlI[104] = "{\n";
        ASMifier.lIIlIIlI[105] = "av0 = ";
        ASMifier.lIIlIIlI[106] = ".visitAnnotationDefault();\n";
        ASMifier.lIIlIIlI[107] = "av";
        ASMifier.lIIlIIlI[108] = "}\n";
        ASMifier.lIIlIIlI[109] = "{\n";
        ASMifier.lIIlIIlI[110] = "av0 = ";
        ASMifier.lIIlIIlI[111] = ".visitParameterAnnotation(";
        ASMifier.lIIlIIlI[112] = ", ";
        ASMifier.lIIlIIlI[113] = ", ";
        ASMifier.lIIlIIlI[114] = ");\n";
        ASMifier.lIIlIIlI[115] = "av";
        ASMifier.lIIlIIlI[116] = "}\n";
        ASMifier.lIIlIIlI[117] = ".visitCode();\n";
        ASMifier.lIIlIIlI[118] = ".visitFrame(Opcodes.F_NEW, ";
        ASMifier.lIIlIIlI[119] = ".visitFrame(Opcodes.F_FULL, ";
        ASMifier.lIIlIIlI[120] = ", new Object[] {";
        ASMifier.lIIlIIlI[121] = "}, ";
        ASMifier.lIIlIIlI[122] = ", new Object[] {";
        ASMifier.lIIlIIlI[123] = ".visitFrame(Opcodes.F_APPEND,";
        ASMifier.lIIlIIlI[124] = ", new Object[] {";
        ASMifier.lIIlIIlI[125] = "}, 0, null";
        ASMifier.lIIlIIlI[126] = ".visitFrame(Opcodes.F_CHOP,";
        ASMifier.lIIlIIlI[127] = ", null, 0, null";
        ASMifier.lIIlIIlI[128] = ".visitFrame(Opcodes.F_SAME, 0, null, 0, null";
        ASMifier.lIIlIIlI[129] = ".visitFrame(Opcodes.F_SAME1, 0, null, 1, new Object[] {";
        ASMifier.lIIlIIlI[130] = ");\n";
        ASMifier.lIIlIIlI[131] = ".visitInsn(";
        ASMifier.lIIlIIlI[132] = ");\n";
        ASMifier.lIIlIIlI[133] = ".visitIntInsn(";
        ASMifier.lIIlIIlI[134] = ", ";
        ASMifier.lIIlIIlI[135] = ");\n";
        ASMifier.lIIlIIlI[136] = ".visitVarInsn(";
        ASMifier.lIIlIIlI[137] = ", ";
        ASMifier.lIIlIIlI[138] = ");\n";
        ASMifier.lIIlIIlI[139] = ".visitTypeInsn(";
        ASMifier.lIIlIIlI[140] = ", ";
        ASMifier.lIIlIIlI[141] = ");\n";
        ASMifier.lIIlIIlI[142] = ".visitFieldInsn(";
        ASMifier.lIIlIIlI[143] = ", ";
        ASMifier.lIIlIIlI[144] = ", ";
        ASMifier.lIIlIIlI[145] = ", ";
        ASMifier.lIIlIIlI[146] = ");\n";
        ASMifier.lIIlIIlI[147] = ".visitMethodInsn(";
        ASMifier.lIIlIIlI[148] = ", ";
        ASMifier.lIIlIIlI[149] = ", ";
        ASMifier.lIIlIIlI[150] = ", ";
        ASMifier.lIIlIIlI[151] = ", ";
        ASMifier.lIIlIIlI[152] = "true";
        ASMifier.lIIlIIlI[153] = "false";
        ASMifier.lIIlIIlI[154] = ");\n";
        ASMifier.lIIlIIlI[155] = ".visitInvokeDynamicInsn(";
        ASMifier.lIIlIIlI[156] = ", ";
        ASMifier.lIIlIIlI[157] = ", ";
        ASMifier.lIIlIIlI[158] = ", new Object[]{";
        ASMifier.lIIlIIlI[159] = ", ";
        ASMifier.lIIlIIlI[160] = "});\n";
        ASMifier.lIIlIIlI[161] = ".visitJumpInsn(";
        ASMifier.lIIlIIlI[162] = ", ";
        ASMifier.lIIlIIlI[163] = ");\n";
        ASMifier.lIIlIIlI[164] = ".visitLabel(";
        ASMifier.lIIlIIlI[165] = ");\n";
        ASMifier.lIIlIIlI[166] = ".visitLdcInsn(";
        ASMifier.lIIlIIlI[167] = ");\n";
        ASMifier.lIIlIIlI[168] = ".visitIincInsn(";
        ASMifier.lIIlIIlI[169] = ", ";
        ASMifier.lIIlIIlI[170] = ");\n";
        ASMifier.lIIlIIlI[171] = ".visitTableSwitchInsn(";
        ASMifier.lIIlIIlI[172] = ", ";
        ASMifier.lIIlIIlI[173] = ", ";
        ASMifier.lIIlIIlI[174] = ", new Label[] {";
        ASMifier.lIIlIIlI[175] = " ";
        ASMifier.lIIlIIlI[176] = ", ";
        ASMifier.lIIlIIlI[177] = " });\n";
        ASMifier.lIIlIIlI[178] = ".visitLookupSwitchInsn(";
        ASMifier.lIIlIIlI[179] = ", new int[] {";
        ASMifier.lIIlIIlI[180] = " ";
        ASMifier.lIIlIIlI[181] = ", ";
        ASMifier.lIIlIIlI[182] = " }, new Label[] {";
        ASMifier.lIIlIIlI[183] = " ";
        ASMifier.lIIlIIlI[184] = ", ";
        ASMifier.lIIlIIlI[185] = " });\n";
        ASMifier.lIIlIIlI[186] = ".visitMultiANewArrayInsn(";
        ASMifier.lIIlIIlI[187] = ", ";
        ASMifier.lIIlIIlI[188] = ");\n";
        ASMifier.lIIlIIlI[189] = "visitInsnAnnotation";
        ASMifier.lIIlIIlI[190] = ".visitTryCatchBlock(";
        ASMifier.lIIlIIlI[191] = ", ";
        ASMifier.lIIlIIlI[192] = ", ";
        ASMifier.lIIlIIlI[193] = ", ";
        ASMifier.lIIlIIlI[194] = ");\n";
        ASMifier.lIIlIIlI[195] = "visitTryCatchAnnotation";
        ASMifier.lIIlIIlI[196] = ".visitLocalVariable(";
        ASMifier.lIIlIIlI[197] = ", ";
        ASMifier.lIIlIIlI[198] = ", ";
        ASMifier.lIIlIIlI[199] = ", ";
        ASMifier.lIIlIIlI[200] = ", ";
        ASMifier.lIIlIIlI[201] = ", ";
        ASMifier.lIIlIIlI[202] = ");\n";
        ASMifier.lIIlIIlI[203] = "{\n";
        ASMifier.lIIlIIlI[204] = "av0 = ";
        ASMifier.lIIlIIlI[205] = ".visitLocalVariableAnnotation(";
        ASMifier.lIIlIIlI[206] = ", null, ";
        ASMifier.lIIlIIlI[207] = ", TypePath.fromString(\"";
        ASMifier.lIIlIIlI[208] = "\"), ";
        ASMifier.lIIlIIlI[209] = "new Label[] {";
        ASMifier.lIIlIIlI[210] = " ";
        ASMifier.lIIlIIlI[211] = ", ";
        ASMifier.lIIlIIlI[212] = " }, new Label[] {";
        ASMifier.lIIlIIlI[213] = " ";
        ASMifier.lIIlIIlI[214] = ", ";
        ASMifier.lIIlIIlI[215] = " }, new int[] {";
        ASMifier.lIIlIIlI[216] = " ";
        ASMifier.lIIlIIlI[217] = ", ";
        ASMifier.lIIlIIlI[218] = " }, ";
        ASMifier.lIIlIIlI[219] = ", ";
        ASMifier.lIIlIIlI[220] = ");\n";
        ASMifier.lIIlIIlI[221] = "av";
        ASMifier.lIIlIIlI[222] = "}\n";
        ASMifier.lIIlIIlI[223] = ".visitLineNumber(";
        ASMifier.lIIlIIlI[224] = ", ";
        ASMifier.lIIlIIlI[225] = ");\n";
        ASMifier.lIIlIIlI[226] = ".visitMaxs(";
        ASMifier.lIIlIIlI[227] = ", ";
        ASMifier.lIIlIIlI[228] = ");\n";
        ASMifier.lIIlIIlI[229] = ".visitEnd();\n";
        ASMifier.lIIlIIlI[230] = "{\n";
        ASMifier.lIIlIIlI[231] = "av0 = ";
        ASMifier.lIIlIIlI[232] = ".visitAnnotation(";
        ASMifier.lIIlIIlI[233] = ", ";
        ASMifier.lIIlIIlI[234] = ");\n";
        ASMifier.lIIlIIlI[235] = "av";
        ASMifier.lIIlIIlI[236] = "}\n";
        ASMifier.lIIlIIlI[237] = "visitTypeAnnotation";
        ASMifier.lIIlIIlI[238] = "{\n";
        ASMifier.lIIlIIlI[239] = "av0 = ";
        ASMifier.lIIlIIlI[240] = ".";
        ASMifier.lIIlIIlI[241] = "(";
        ASMifier.lIIlIIlI[242] = ", null, ";
        ASMifier.lIIlIIlI[243] = ", TypePath.fromString(\"";
        ASMifier.lIIlIIlI[244] = "\"), ";
        ASMifier.lIIlIIlI[245] = ", ";
        ASMifier.lIIlIIlI[246] = ");\n";
        ASMifier.lIIlIIlI[247] = "av";
        ASMifier.lIIlIIlI[248] = "}\n";
        ASMifier.lIIlIIlI[249] = "// ATTRIBUTE ";
        ASMifier.lIIlIIlI[250] = "{\n";
        ASMifier.lIIlIIlI[251] = "attr";
        ASMifier.lIIlIIlI[252] = ".visitAttribute(attr);\n";
        ASMifier.lIIlIIlI[253] = "}\n";
        ASMifier.lIIlIIlI[254] = "ACC_PUBLIC";
        ASMifier.lIIlIIlI[255] = "ACC_PRIVATE";
        ASMifier.lIIlIIlI[256] = "ACC_PROTECTED";
        ASMifier.lIIlIIlI[257] = " + ";
        ASMifier.lIIlIIlI[258] = "ACC_FINAL";
        ASMifier.lIIlIIlI[259] = " + ";
        ASMifier.lIIlIIlI[260] = "ACC_STATIC";
        ASMifier.lIIlIIlI[261] = " + ";
        ASMifier.lIIlIIlI[262] = "ACC_SYNCHRONIZED";
        ASMifier.lIIlIIlI[263] = "ACC_SUPER";
        ASMifier.lIIlIIlI[264] = " + ";
        ASMifier.lIIlIIlI[265] = "ACC_VOLATILE";
        ASMifier.lIIlIIlI[266] = " + ";
        ASMifier.lIIlIIlI[267] = "ACC_BRIDGE";
        ASMifier.lIIlIIlI[268] = " + ";
        ASMifier.lIIlIIlI[269] = "ACC_VARARGS";
        ASMifier.lIIlIIlI[270] = " + ";
        ASMifier.lIIlIIlI[271] = "ACC_TRANSIENT";
        ASMifier.lIIlIIlI[272] = " + ";
        ASMifier.lIIlIIlI[273] = "ACC_NATIVE";
        ASMifier.lIIlIIlI[274] = " + ";
        ASMifier.lIIlIIlI[275] = "ACC_ENUM";
        ASMifier.lIIlIIlI[276] = " + ";
        ASMifier.lIIlIIlI[277] = "ACC_ANNOTATION";
        ASMifier.lIIlIIlI[278] = " + ";
        ASMifier.lIIlIIlI[279] = "ACC_ABSTRACT";
        ASMifier.lIIlIIlI[280] = " + ";
        ASMifier.lIIlIIlI[281] = "ACC_INTERFACE";
        ASMifier.lIIlIIlI[282] = " + ";
        ASMifier.lIIlIIlI[283] = "ACC_STRICT";
        ASMifier.lIIlIIlI[284] = " + ";
        ASMifier.lIIlIIlI[285] = "ACC_SYNTHETIC";
        ASMifier.lIIlIIlI[286] = " + ";
        ASMifier.lIIlIIlI[287] = "ACC_DEPRECATED";
        ASMifier.lIIlIIlI[288] = " + ";
        ASMifier.lIIlIIlI[289] = "ACC_MANDATED";
        ASMifier.lIIlIIlI[290] = "null";
        ASMifier.lIIlIIlI[291] = "Type.getType(\"";
        ASMifier.lIIlIIlI[292] = "\")";
        ASMifier.lIIlIIlI[293] = "new Handle(";
        ASMifier.lIIlIIlI[294] = "Opcodes.";
        ASMifier.lIIlIIlI[295] = ", \"";
        ASMifier.lIIlIIlI[296] = "\", \"";
        ASMifier.lIIlIIlI[297] = "\", \"";
        ASMifier.lIIlIIlI[298] = "\")";
        ASMifier.lIIlIIlI[299] = "new Byte((byte)";
        ASMifier.lIIlIIlI[300] = "Boolean.TRUE";
        ASMifier.lIIlIIlI[301] = "Boolean.FALSE";
        ASMifier.lIIlIIlI[302] = "new Short((short)";
        ASMifier.lIIlIIlI[303] = "new Character((char)";
        ASMifier.lIIlIIlI[304] = "new Integer(";
        ASMifier.lIIlIIlI[305] = "new Float(\"";
        ASMifier.lIIlIIlI[306] = "\")";
        ASMifier.lIIlIIlI[307] = "new Long(";
        ASMifier.lIIlIIlI[308] = "L)";
        ASMifier.lIIlIIlI[309] = "new Double(\"";
        ASMifier.lIIlIIlI[310] = "\")";
        ASMifier.lIIlIIlI[311] = "new byte[] {";
        ASMifier.lIIlIIlI[312] = "";
        ASMifier.lIIlIIlI[313] = ",";
        ASMifier.lIIlIIlI[314] = "new boolean[] {";
        ASMifier.lIIlIIlI[315] = "";
        ASMifier.lIIlIIlI[316] = ",";
        ASMifier.lIIlIIlI[317] = "new short[] {";
        ASMifier.lIIlIIlI[318] = "";
        ASMifier.lIIlIIlI[319] = ",";
        ASMifier.lIIlIIlI[320] = "(short)";
        ASMifier.lIIlIIlI[321] = "new char[] {";
        ASMifier.lIIlIIlI[322] = "";
        ASMifier.lIIlIIlI[323] = ",";
        ASMifier.lIIlIIlI[324] = "(char)";
        ASMifier.lIIlIIlI[325] = "new int[] {";
        ASMifier.lIIlIIlI[326] = "";
        ASMifier.lIIlIIlI[327] = ",";
        ASMifier.lIIlIIlI[328] = "new long[] {";
        ASMifier.lIIlIIlI[329] = "";
        ASMifier.lIIlIIlI[330] = ",";
        ASMifier.lIIlIIlI[331] = "new float[] {";
        ASMifier.lIIlIIlI[332] = "";
        ASMifier.lIIlIIlI[333] = ",";
        ASMifier.lIIlIIlI[334] = "new double[] {";
        ASMifier.lIIlIIlI[335] = "";
        ASMifier.lIIlIIlI[336] = ",";
        ASMifier.lIIlIIlI[337] = ", ";
        ASMifier.lIIlIIlI[338] = "Opcodes.TOP";
        ASMifier.lIIlIIlI[339] = "Opcodes.INTEGER";
        ASMifier.lIIlIIlI[340] = "Opcodes.FLOAT";
        ASMifier.lIIlIIlI[341] = "Opcodes.DOUBLE";
        ASMifier.lIIlIIlI[342] = "Opcodes.LONG";
        ASMifier.lIIlIIlI[343] = "Opcodes.NULL";
        ASMifier.lIIlIIlI[344] = "Opcodes.UNINITIALIZED_THIS";
        ASMifier.lIIlIIlI[345] = "l";
        ASMifier.lIIlIIlI[346] = "Label ";
        ASMifier.lIIlIIlI[347] = " = new Label();\n";
    }
    
    private static String lIlllIIIl(final String s, final String s2) {
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
    
    private static String lIlllIIlI(String s, final String s2) {
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
    
    private static String lIlllIlII(final String s, final String s2) {
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
    
    private static boolean lIIIllllII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIlIIIIIl$255f299(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIllllIl(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIIlllIll(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIlIIIlIl(final int n) {
        return n > 0;
    }
    
    private static boolean lIIIllllll(final int n, final int n2) {
        return n != n2;
    }
}
