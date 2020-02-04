package org.spongepowered.asm.lib.util;

import java.lang.reflect.*;
import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.lib.tree.analysis.*;
import java.io.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import org.spongepowered.asm.lib.*;
import java.util.*;

public class CheckMethodAdapter extends MethodVisitor
{
    public int version;
    private int access;
    private boolean startCode;
    private boolean endCode;
    private boolean endMethod;
    private int insnCount;
    private final Map<Label, Integer> labels;
    private Set<Label> usedLabels;
    private int expandedFrames;
    private int compressedFrames;
    private int lastFrame;
    private List<Label> handlers;
    private static final int[] TYPE;
    private static Field labelStatusField;
    private static final String[] llIllIIIIII;
    
    private CheckMethodAdapter(final MethodVisitor methodVisitor) {
        this(methodVisitor, new HashMap<Label, Integer>());
    }
    
    public CheckMethodAdapter(final MethodVisitor methodVisitor, final Map<Label, Integer> map) {
        this(methodVisitor, map, (byte)0);
        if (lIIllIIlIlIII(this.getClass(), CheckMethodAdapter.class)) {
            throw new IllegalStateException();
        }
    }
    
    private CheckMethodAdapter(final MethodVisitor methodVisitor, final Map<Label, Integer> labels, final byte b) {
        super(methodVisitor);
        this.lastFrame = -1;
        this.labels = labels;
        this.usedLabels = new HashSet<Label>();
        this.handlers = new ArrayList<Label>();
    }
    
    public CheckMethodAdapter(final int access, final String s, final String s2, final MethodVisitor methodVisitor, final Map<Label, Integer> map) {
        this(new MethodNode(access, s, s2) {
            private /* synthetic */ MethodVisitor val$cmv;
            private static final String[] lIlIIIIIl;
            
            CheckMethodAdapter$1(final int n, final String s, final String s2) {
                super(n, s, s2, null, null, (byte)0);
            }
            
            public final void visitEnd() {
                final Analyzer<BasicValue> analyzer = new Analyzer<BasicValue>(new BasicVerifier());
                final String[] lIlIIIIIl = CheckMethodAdapter$1.lIlIIIIIl;
                final int n = 0;
                try {
                    analyzer.analyze(lIlIIIIIl[n], this);
                }
                catch (Exception ex2) {
                    final Exception ex = ex2;
                    if (ex2 instanceof IndexOutOfBoundsException && this.maxLocals == 0 && this.maxStack == 0) {
                        throw new RuntimeException(CheckMethodAdapter$1.lIlIIIIIl[1]);
                    }
                    ex.printStackTrace();
                    final StringWriter stringWriter = new StringWriter();
                    final PrintWriter printWriter = new PrintWriter(stringWriter, true);
                    CheckClassAdapter.printAnalyzerResult(this, analyzer, printWriter);
                    printWriter.close();
                    throw new RuntimeException(String.valueOf(new StringBuilder().append(ex.getMessage()).append(' ').append(stringWriter.toString())));
                }
                this.accept(methodVisitor);
            }
            
            static {
                lllIIIIIll();
            }
            
            private static void lllIIIIIll() {
                (lIlIIIIIl = new String[2])[0] = "dummy";
                CheckMethodAdapter$1.lIlIIIIIl[1] = "Data flow checking option requires valid, non zero maxLocals and maxStack values.";
            }
            
            private static String lllIIIIIIl(final String s, final String s2) {
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
            
            private static String lllIIIIIlI(String s, final String s2) {
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
        }, map);
        this.access = access;
    }
    
    public final void visitParameter(final String s, final int n) {
        if (s != null) {
            checkUnqualifiedName(this.version, s, CheckMethodAdapter.llIllIIIIII[0]);
        }
        CheckClassAdapter.checkAccess(n, 36880);
        super.visitParameter(s, n);
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final boolean b) {
        this.checkEndMethod();
        checkDesc$505cbf4b(s);
        return new CheckAnnotationAdapter(super.visitAnnotation(s, b));
    }
    
    public final AnnotationVisitor visitTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        this.checkEndMethod();
        final int n2;
        if (lIIllIIlIlIlI(n2 = n >>> 24, 1) && lIIllIIlIlIlI(n2, 18) && lIIllIIlIlIlI(n2, 20) && lIIllIIlIlIlI(n2, 21) && lIIllIIlIlIlI(n2, 22) && lIIllIIlIlIlI(n2, 23)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[1]).append(Integer.toHexString(n2))));
        }
        CheckClassAdapter.checkTypeRefAndPath(n, typePath);
        checkDesc$505cbf4b(s);
        return new CheckAnnotationAdapter(super.visitTypeAnnotation(n, typePath, s, b));
    }
    
    public final AnnotationVisitor visitAnnotationDefault() {
        this.checkEndMethod();
        return new CheckAnnotationAdapter(super.visitAnnotationDefault(), false);
    }
    
    public final AnnotationVisitor visitParameterAnnotation(final int n, final String s, final boolean b) {
        this.checkEndMethod();
        checkDesc$505cbf4b(s);
        return new CheckAnnotationAdapter(super.visitParameterAnnotation(n, s, b));
    }
    
    public final void visitAttribute(final Attribute attribute) {
        this.checkEndMethod();
        if (attribute == null) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[2]);
        }
        super.visitAttribute(attribute);
    }
    
    public final void visitCode() {
        if ((this.access & 0x400) != 0x0) {
            throw new RuntimeException(CheckMethodAdapter.llIllIIIIII[3]);
        }
        this.startCode = true;
        super.visitCode();
    }
    
    public final void visitFrame(final int n, final int n2, final Object[] array, final int n3, final Object[] array2) {
        if (this.insnCount == this.lastFrame) {
            throw new IllegalStateException(CheckMethodAdapter.llIllIIIIII[4]);
        }
        this.lastFrame = this.insnCount;
        int n4 = 0;
        int n5 = 0;
        switch (n) {
            case -1:
            case 0: {
                n4 = Integer.MAX_VALUE;
                n5 = Integer.MAX_VALUE;
                break;
            }
            case 3: {
                n4 = 0;
                n5 = 0;
                break;
            }
            case 4: {
                n4 = 0;
                n5 = 1;
                break;
            }
            case 1:
            case 2: {
                n4 = 3;
                n5 = 0;
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[5]).append(n)));
            }
        }
        if (lIIllIIlIllll(n2, n4)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[6]).append(n2).append(CheckMethodAdapter.llIllIIIIII[7]).append(n)));
        }
        if (lIIllIIlIllll(n3, n5)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[8]).append(n3).append(CheckMethodAdapter.llIllIIIIII[9]).append(n)));
        }
        if (lIIllIIlIlIlI(n, 2)) {
            if (n2 > 0 && (array == null || array.length < n2)) {
                throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[10]);
            }
            for (int i = 0; i < n2; ++i) {
                this.checkFrameValue(array[i]);
            }
        }
        if (n3 > 0 && (array2 == null || array2.length < n3)) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[11]);
        }
        for (int j = 0; j < n3; ++j) {
            this.checkFrameValue(array2[j]);
        }
        if (n == -1) {
            ++this.expandedFrames;
        }
        else {
            ++this.compressedFrames;
        }
        if (this.expandedFrames > 0 && this.compressedFrames > 0) {
            throw new RuntimeException(CheckMethodAdapter.llIllIIIIII[12]);
        }
        super.visitFrame(n, n2, array, n3, array2);
    }
    
    public final void visitInsn(final int n) {
        this.checkStartCode();
        this.checkEndCode();
        checkOpcode(n, 0);
        super.visitInsn(n);
        ++this.insnCount;
    }
    
    public final void visitIntInsn(final int n, final int n2) {
        this.checkStartCode();
        this.checkEndCode();
        checkOpcode(n, 1);
        switch (n) {
            case 16: {
                final String s = CheckMethodAdapter.llIllIIIIII[13];
                if (!lIIllIIllIIll(n2, -128) || lIIllIIlIllll(n2, 127)) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s).append(CheckMethodAdapter.llIllIIIIII[76]).append(n2)));
                }
                break;
            }
            case 17: {
                checkSignedShort(n2, CheckMethodAdapter.llIllIIIIII[14]);
                break;
            }
            default: {
                if (!lIIllIIllIIll(n2, 4) || lIIllIIlIllll(n2, 11)) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[15]).append(n2)));
                }
                break;
            }
        }
        super.visitIntInsn(n, n2);
        ++this.insnCount;
    }
    
    public final void visitVarInsn(final int n, final int n2) {
        this.checkStartCode();
        this.checkEndCode();
        checkOpcode(n, 2);
        checkUnsignedShort(n2, CheckMethodAdapter.llIllIIIIII[16]);
        super.visitVarInsn(n, n2);
        ++this.insnCount;
    }
    
    public final void visitTypeInsn(final int n, final String s) {
        this.checkStartCode();
        this.checkEndCode();
        checkOpcode(n, 3);
        checkInternalName(s, CheckMethodAdapter.llIllIIIIII[17]);
        if (n == 187 && s.charAt(0) == '[') {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[18]).append(s)));
        }
        super.visitTypeInsn(n, s);
        ++this.insnCount;
    }
    
    public final void visitFieldInsn(final int n, final String s, final String s2, final String s3) {
        this.checkStartCode();
        this.checkEndCode();
        checkOpcode(n, 4);
        checkInternalName(s, CheckMethodAdapter.llIllIIIIII[19]);
        checkUnqualifiedName(this.version, s2, CheckMethodAdapter.llIllIIIIII[20]);
        checkDesc$505cbf4b(s3);
        super.visitFieldInsn(n, s, s2, s3);
        ++this.insnCount;
    }
    
    @Deprecated
    public final void visitMethodInsn(final int n, final String s, final String s2, final String s3) {
        if (lIIllIIllIIll(327680, 327680)) {
            super.visitMethodInsn(n, s, s2, s3);
            return;
        }
        this.doVisitMethodInsn(n, s, s2, s3, n == 185);
    }
    
    public final void visitMethodInsn(final int n, final String s, final String s2, final String s3, final boolean b) {
        this.doVisitMethodInsn(n, s, s2, s3, b);
    }
    
    private void doVisitMethodInsn(final int n, final String s, final String s2, final String s3, final boolean b) {
        this.checkStartCode();
        this.checkEndCode();
        checkOpcode(n, 5);
        if (n != 183 || !CheckMethodAdapter.llIllIIIIII[21].equals(s2)) {
            checkMethodIdentifier(this.version, s2, CheckMethodAdapter.llIllIIIIII[22]);
        }
        checkInternalName(s, CheckMethodAdapter.llIllIIIIII[23]);
        checkMethodDesc(s3);
        if (n == 182 && b) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[24]);
        }
        if (n == 185 && !b) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[25]);
        }
        if (n == 183 && b && (this.version & 0xFFFF) < 52) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[26]);
        }
        if (this.mv != null) {
            this.mv.visitMethodInsn(n, s, s2, s3, b);
        }
        ++this.insnCount;
    }
    
    public final void visitInvokeDynamicInsn(final String s, final String s2, final Handle handle, final Object... array) {
        this.checkStartCode();
        this.checkEndCode();
        checkMethodIdentifier(this.version, s, CheckMethodAdapter.llIllIIIIII[27]);
        checkMethodDesc(s2);
        if (lIIllIIlIlIlI(handle.tag, 6) && lIIllIIlIlIlI(handle.tag, 8)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[28]).append(handle.tag)));
        }
        for (int i = 0; i < array.length; ++i) {
            this.checkLDCConstant(array[i]);
        }
        super.visitInvokeDynamicInsn(s, s2, handle, array);
        ++this.insnCount;
    }
    
    public final void visitJumpInsn(final int n, final Label label) {
        this.checkStartCode();
        this.checkEndCode();
        checkOpcode(n, 6);
        this.checkLabel(label, false, CheckMethodAdapter.llIllIIIIII[29]);
        checkNonDebugLabel(label);
        super.visitJumpInsn(n, label);
        this.usedLabels.add(label);
        ++this.insnCount;
    }
    
    public final void visitLabel(final Label label) {
        this.checkStartCode();
        this.checkEndCode();
        this.checkLabel(label, false, CheckMethodAdapter.llIllIIIIII[30]);
        if (this.labels.get(label) != null) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[31]);
        }
        this.labels.put(label, this.insnCount);
        super.visitLabel(label);
    }
    
    public final void visitLdcInsn(final Object o) {
        this.checkStartCode();
        this.checkEndCode();
        this.checkLDCConstant(o);
        super.visitLdcInsn(o);
        ++this.insnCount;
    }
    
    public final void visitIincInsn(final int n, final int n2) {
        this.checkStartCode();
        this.checkEndCode();
        checkUnsignedShort(n, CheckMethodAdapter.llIllIIIIII[32]);
        checkSignedShort(n2, CheckMethodAdapter.llIllIIIIII[33]);
        super.visitIincInsn(n, n2);
        ++this.insnCount;
    }
    
    public final void visitTableSwitchInsn(final int n, final int n2, final Label label, final Label... array) {
        this.checkStartCode();
        this.checkEndCode();
        if (n2 < n) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[34]).append(n2).append(CheckMethodAdapter.llIllIIIIII[35]).append(n)));
        }
        this.checkLabel(label, false, CheckMethodAdapter.llIllIIIIII[36]);
        checkNonDebugLabel(label);
        if (array == null || lIIllIIlIlIlI(array.length, n2 - n + 1)) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[37]);
        }
        for (int i = 0; i < array.length; ++i) {
            this.checkLabel(array[i], false, String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[38]).append(i)));
            checkNonDebugLabel(array[i]);
        }
        super.visitTableSwitchInsn(n, n2, label, array);
        for (int j = 0; j < array.length; ++j) {
            this.usedLabels.add(array[j]);
        }
        ++this.insnCount;
    }
    
    public final void visitLookupSwitchInsn(final Label label, final int[] array, final Label[] array2) {
        this.checkEndCode();
        this.checkStartCode();
        this.checkLabel(label, false, CheckMethodAdapter.llIllIIIIII[39]);
        checkNonDebugLabel(label);
        if (array == null || array2 == null || lIIllIIlIlIlI(array.length, array2.length)) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[40]);
        }
        for (int i = 0; i < array2.length; ++i) {
            this.checkLabel(array2[i], false, String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[41]).append(i)));
            checkNonDebugLabel(array2[i]);
        }
        super.visitLookupSwitchInsn(label, array, array2);
        this.usedLabels.add(label);
        for (int j = 0; j < array2.length; ++j) {
            this.usedLabels.add(array2[j]);
        }
        ++this.insnCount;
    }
    
    public final void visitMultiANewArrayInsn(final String s, final int n) {
        this.checkStartCode();
        this.checkEndCode();
        checkDesc$505cbf4b(s);
        if (lIIllIIlIlIlI(s.charAt(0), 91)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[42]).append(s)));
        }
        if (n <= 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[43]).append(n)));
        }
        if (lIIllIIlIllll(n, s.lastIndexOf(91) + 1)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[44]).append(n)));
        }
        super.visitMultiANewArrayInsn(s, n);
        ++this.insnCount;
    }
    
    public final AnnotationVisitor visitInsnAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        this.checkStartCode();
        this.checkEndCode();
        final int n2;
        if (lIIllIIlIlIlI(n2 = n >>> 24, 67) && lIIllIIlIlIlI(n2, 68) && lIIllIIlIlIlI(n2, 69) && lIIllIIlIlIlI(n2, 70) && lIIllIIlIlIlI(n2, 71) && lIIllIIlIlIlI(n2, 72) && lIIllIIlIlIlI(n2, 73) && lIIllIIlIlIlI(n2, 74) && lIIllIIlIlIlI(n2, 75)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[45]).append(Integer.toHexString(n2))));
        }
        CheckClassAdapter.checkTypeRefAndPath(n, typePath);
        checkDesc$505cbf4b(s);
        return new CheckAnnotationAdapter(super.visitInsnAnnotation(n, typePath, s, b));
    }
    
    public final void visitTryCatchBlock(final Label label, final Label label2, final Label label3, final String s) {
        this.checkStartCode();
        this.checkEndCode();
        this.checkLabel(label, false, CheckMethodAdapter.llIllIIIIII[46]);
        this.checkLabel(label2, false, CheckMethodAdapter.llIllIIIIII[47]);
        this.checkLabel(label3, false, CheckMethodAdapter.llIllIIIIII[48]);
        checkNonDebugLabel(label);
        checkNonDebugLabel(label2);
        checkNonDebugLabel(label3);
        if (this.labels.get(label) != null || this.labels.get(label2) != null || this.labels.get(label3) != null) {
            throw new IllegalStateException(CheckMethodAdapter.llIllIIIIII[49]);
        }
        if (s != null) {
            checkInternalName(s, CheckMethodAdapter.llIllIIIIII[50]);
        }
        super.visitTryCatchBlock(label, label2, label3, s);
        this.handlers.add(label);
        this.handlers.add(label2);
    }
    
    public final AnnotationVisitor visitTryCatchAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        this.checkStartCode();
        this.checkEndCode();
        final int n2;
        if (lIIllIIlIlIlI(n2 = n >>> 24, 66)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[51]).append(Integer.toHexString(n2))));
        }
        CheckClassAdapter.checkTypeRefAndPath(n, typePath);
        checkDesc$505cbf4b(s);
        return new CheckAnnotationAdapter(super.visitTryCatchAnnotation(n, typePath, s, b));
    }
    
    public final void visitLocalVariable(final String s, final String s2, final String s3, final Label label, final Label label2, final int n) {
        this.checkStartCode();
        this.checkEndCode();
        checkUnqualifiedName(this.version, s, CheckMethodAdapter.llIllIIIIII[52]);
        checkDesc$505cbf4b(s2);
        this.checkLabel(label, true, CheckMethodAdapter.llIllIIIIII[53]);
        this.checkLabel(label2, true, CheckMethodAdapter.llIllIIIIII[54]);
        checkUnsignedShort(n, CheckMethodAdapter.llIllIIIIII[55]);
        if (this.labels.get(label2) < this.labels.get(label)) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[56]);
        }
        super.visitLocalVariable(s, s2, s3, label, label2, n);
    }
    
    public final AnnotationVisitor visitLocalVariableAnnotation(final int n, final TypePath typePath, final Label[] array, final Label[] array2, final int[] array3, final String s, final boolean b) {
        this.checkStartCode();
        this.checkEndCode();
        final int n2;
        if (lIIllIIlIlIlI(n2 = n >>> 24, 64) && lIIllIIlIlIlI(n2, 65)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[57]).append(Integer.toHexString(n2))));
        }
        CheckClassAdapter.checkTypeRefAndPath(n, typePath);
        checkDesc$505cbf4b(s);
        if (array == null || array2 == null || array3 == null || array2.length != array.length || lIIllIIlIlIlI(array3.length, array.length)) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[58]);
        }
        for (int i = 0; i < array.length; ++i) {
            this.checkLabel(array[i], true, CheckMethodAdapter.llIllIIIIII[59]);
            this.checkLabel(array2[i], true, CheckMethodAdapter.llIllIIIIII[60]);
            checkUnsignedShort(array3[i], CheckMethodAdapter.llIllIIIIII[61]);
            if (this.labels.get(array2[i]) < this.labels.get(array[i])) {
                throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[62]);
            }
        }
        return super.visitLocalVariableAnnotation(n, typePath, array, array2, array3, s, b);
    }
    
    public final void visitLineNumber(final int n, final Label label) {
        this.checkStartCode();
        this.checkEndCode();
        checkUnsignedShort(n, CheckMethodAdapter.llIllIIIIII[63]);
        this.checkLabel(label, true, CheckMethodAdapter.llIllIIIIII[64]);
        super.visitLineNumber(n, label);
    }
    
    public final void visitMaxs(final int n, final int n2) {
        this.checkStartCode();
        this.checkEndCode();
        this.endCode = true;
        final Iterator<Label> iterator = this.usedLabels.iterator();
        while (iterator.hasNext()) {
            if (this.labels.get(iterator.next()) == null) {
                throw new IllegalStateException(CheckMethodAdapter.llIllIIIIII[65]);
            }
        }
        int i = 0;
        while (i < this.handlers.size()) {
            final Integer n3 = this.labels.get(this.handlers.get(i++));
            final Integer n4 = this.labels.get(this.handlers.get(i++));
            if (n3 == null || n4 == null) {
                throw new IllegalStateException(CheckMethodAdapter.llIllIIIIII[66]);
            }
            if (lIIllIlIIlIII(n4, n3)) {
                throw new IllegalStateException(CheckMethodAdapter.llIllIIIIII[67]);
            }
        }
        checkUnsignedShort(n, CheckMethodAdapter.llIllIIIIII[68]);
        checkUnsignedShort(n2, CheckMethodAdapter.llIllIIIIII[69]);
        super.visitMaxs(n, n2);
    }
    
    public final void visitEnd() {
        this.checkEndMethod();
        this.endMethod = true;
        super.visitEnd();
    }
    
    private void checkStartCode() {
        if (!this.startCode) {
            throw new IllegalStateException(CheckMethodAdapter.llIllIIIIII[70]);
        }
    }
    
    private void checkEndCode() {
        if (this.endCode) {
            throw new IllegalStateException(CheckMethodAdapter.llIllIIIIII[71]);
        }
    }
    
    private void checkEndMethod() {
        if (this.endMethod) {
            throw new IllegalStateException(CheckMethodAdapter.llIllIIIIII[72]);
        }
    }
    
    private void checkFrameValue(final Object o) {
        if (!lIIllIIlIlIII(o, Opcodes.TOP) || !lIIllIIlIlIII(o, Opcodes.INTEGER) || !lIIllIIlIlIII(o, Opcodes.FLOAT) || !lIIllIIlIlIII(o, Opcodes.LONG) || !lIIllIIlIlIII(o, Opcodes.DOUBLE) || !lIIllIIlIlIII(o, Opcodes.NULL) || lIIllIlIIlIIl(o, Opcodes.UNINITIALIZED_THIS)) {
            return;
        }
        if (o instanceof String) {
            checkInternalName((String)o, CheckMethodAdapter.llIllIIIIII[73]);
            return;
        }
        if (!(o instanceof Label)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[74]).append(o)));
        }
        this.usedLabels.add((Label)o);
    }
    
    private static void checkOpcode(final int n, final int n2) {
        if (n < 0 || !lIIllIlIIlIII(n, 199) || lIIllIIlIlIlI(CheckMethodAdapter.TYPE[n], n2)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[75]).append(n)));
        }
    }
    
    private static void checkSignedByte(final int n, final String s) {
        if (!lIIllIIllIIll(n, -128) || lIIllIIlIllll(n, 127)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s).append(CheckMethodAdapter.llIllIIIIII[76]).append(n)));
        }
    }
    
    private static void checkSignedShort(final int n, final String s) {
        if (!lIIllIIllIIll(n, -32768) || lIIllIIlIllll(n, 32767)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s).append(CheckMethodAdapter.llIllIIIIII[77]).append(n)));
        }
    }
    
    private static void checkUnsignedShort(final int n, final String s) {
        if (n < 0 || lIIllIIlIllll(n, 65535)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s).append(CheckMethodAdapter.llIllIIIIII[78]).append(n)));
        }
    }
    
    static void checkConstant(final Object o) {
        if (!(o instanceof Integer) && !(o instanceof Float) && !(o instanceof Long) && !(o instanceof Double) && !(o instanceof String)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[79]).append(o)));
        }
    }
    
    private void checkLDCConstant(final Object o) {
        if (o instanceof Type) {
            final int sort;
            if (lIIllIIlIlIlI(sort = ((Type)o).sort, 10) && lIIllIIlIlIlI(sort, 9) && lIIllIIlIlIlI(sort, 11)) {
                throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[80]);
            }
            if (lIIllIIlIlIlI(sort, 11) && (this.version & 0xFFFF) < 49) {
                throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[81]);
            }
            if (sort == 11 && (this.version & 0xFFFF) < 51) {
                throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[82]);
            }
        }
        else {
            if (!(o instanceof Handle)) {
                checkConstant(o);
                return;
            }
            if ((this.version & 0xFFFF) < 51) {
                throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[83]);
            }
            final int tag;
            if (!lIIllIIllIIll(tag = ((Handle)o).tag, 1) || lIIllIIlIllll(tag, 9)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[84]).append(tag)));
            }
        }
    }
    
    static void checkUnqualifiedName(int i, String s, final String s2) {
        if ((i & 0xFFFF) < 49) {
            final String s3 = s;
            s = s2;
            checkIdentifier(s3, 0, -1, s);
            return;
        }
        for (i = 0; i < s.length(); ++i) {
            if (lIIllIIlIlIlI(CheckMethodAdapter.llIllIIIIII[85].indexOf(s.charAt(i)), -1)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[86]).append(s2).append(CheckMethodAdapter.llIllIIIIII[87]).append(s)));
            }
        }
    }
    
    static void checkIdentifier(final String s, final String s2) {
        checkIdentifier(s, 0, -1, s2);
    }
    
    static void checkIdentifier(final String s, int i, int n, final String s2) {
        if (s != null) {
            if (n == -1) {
                if (lIIllIlIIlIII(s.length(), i)) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[88]).append(s2).append(CheckMethodAdapter.llIllIIIIII[89])));
                }
            }
            else if (lIIllIlIIlIII(n, i)) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[88]).append(s2).append(CheckMethodAdapter.llIllIIIIII[89])));
            }
            if (!Character.isJavaIdentifierStart(s.charAt(i))) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[90]).append(s2).append(CheckMethodAdapter.llIllIIIIII[91]).append(s)));
            }
            for (n = ((n == -1) ? s.length() : n), ++i; i < n; ++i) {
                if (!Character.isJavaIdentifierPart(s.charAt(i))) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[92]).append(s2).append(CheckMethodAdapter.llIllIIIIII[93]).append(s)));
                }
            }
            return;
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[88]).append(s2).append(CheckMethodAdapter.llIllIIIIII[89])));
    }
    
    static void checkMethodIdentifier(int i, final String s, final String s2) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[94]).append(s2).append(CheckMethodAdapter.llIllIIIIII[95])));
        }
        if (lIIllIIllIIll(i & 0xFFFF, 49)) {
            for (i = 0; i < s.length(); ++i) {
                if (lIIllIIlIlIlI(CheckMethodAdapter.llIllIIIIII[96].indexOf(s.charAt(i)), -1)) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[97]).append(s2).append(CheckMethodAdapter.llIllIIIIII[98]).append(s)));
                }
            }
            return;
        }
        if (!Character.isJavaIdentifierStart(s.charAt(0))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[99]).append(s2).append(CheckMethodAdapter.llIllIIIIII[100]).append(s)));
        }
        for (i = 1; i < s.length(); ++i) {
            if (!Character.isJavaIdentifierPart(s.charAt(i))) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[101]).append(s2).append(CheckMethodAdapter.llIllIIIIII[102]).append(s)));
            }
        }
    }
    
    static void checkInternalName(final String s, final String s2) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[103]).append(s2).append(CheckMethodAdapter.llIllIIIIII[104])));
        }
        if (s.charAt(0) == '[') {
            checkDesc$505cbf4b(s);
            return;
        }
        checkInternalName(s, 0, -1, s2);
    }
    
    private static void checkInternalName(final String s, int n, int n2, final String s2) {
        n2 = ((n2 == -1) ? s.length() : n2);
        while (true) {
            final int n3 = 47;
            final int n4 = n + 1;
            try {
                int index;
                if (!lIIllIIlIlIlI(index = s.indexOf(n3, n4), -1) || lIIllIIlIllll(index, n2)) {
                    index = n2;
                }
                checkIdentifier(s, n, index, null);
                n = index + 1;
                if (index == n2) {
                    return;
                }
                continue;
            }
            catch (IllegalArgumentException ex) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[105]).append(s2).append(CheckMethodAdapter.llIllIIIIII[106]).append(s)));
            }
        }
    }
    
    static void checkDesc$505cbf4b(final String s) {
        if (lIIllIIlIlIlI(checkDesc(s, 0, false), s.length())) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[107]).append(s)));
        }
    }
    
    private static int checkDesc(String s, int n, boolean b) {
        while (s != null && !lIIllIIllIIll(n, s.length())) {
            switch (s.charAt(n)) {
                case 'V': {
                    if (b) {
                        return n + 1;
                    }
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[109]).append(s)));
                }
                case 'B':
                case 'C':
                case 'D':
                case 'F':
                case 'I':
                case 'J':
                case 'S':
                case 'Z': {
                    return n + 1;
                }
                case '[': {
                    int n2;
                    for (n2 = n + 1; n2 < s.length() && s.charAt(n2) == '['; ++n2) {}
                    if (n2 < s.length()) {
                        final String s2 = s;
                        final int n3 = n2;
                        b = false;
                        n = n3;
                        s = s2;
                        continue;
                    }
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[110]).append(s)));
                }
                case 'L': {
                    final int index;
                    if (!lIIllIIlIlIlI(index = s.indexOf(59, n), -1) || index - n < 2) {
                        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[111]).append(s)));
                    }
                    final String s3 = s;
                    final int n4 = n + 1;
                    final int n5 = index;
                    final String s4 = null;
                    try {
                        checkInternalName(s3, n4, n5, s4);
                    }
                    catch (IllegalArgumentException ex) {
                        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[112]).append(s)));
                    }
                    return index + 1;
                }
                default: {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[113]).append(s)));
                }
            }
        }
        throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[108]);
    }
    
    static void checkMethodDesc(final String s) {
        if (s == null || s.length() == 0) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[114]);
        }
        if (s.charAt(0) != '(' || s.length() < 3) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[115]).append(s)));
        }
        int checkDesc = 1;
        Label_0156: {
            if (lIIllIIlIlIlI(s.charAt(1), 41)) {
                while (s.charAt(checkDesc) != 'V') {
                    if ((checkDesc = checkDesc(s, checkDesc, false)) >= s.length() || s.charAt(checkDesc) == ')') {
                        break Label_0156;
                    }
                }
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[116]).append(s)));
            }
        }
        if (lIIllIIlIlIlI(checkDesc(s, checkDesc + 1, true), s.length())) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[117]).append(s)));
        }
    }
    
    private void checkLabel(final Label label, final boolean b, final String s) {
        if (label == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[118]).append(s).append(CheckMethodAdapter.llIllIIIIII[119])));
        }
        if (b && this.labels.get(label) == null) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckMethodAdapter.llIllIIIIII[120]).append(s).append(CheckMethodAdapter.llIllIIIIII[121])));
        }
    }
    
    private static void checkNonDebugLabel(final Label label) {
        final Field labelStatusField = getLabelStatusField();
        int n;
        try {
            n = (int)((labelStatusField == null) ? 0 : labelStatusField.get(label));
        }
        catch (IllegalAccessException ex) {
            throw new Error(CheckMethodAdapter.llIllIIIIII[122]);
        }
        if ((n & 0x1) != 0x0) {
            throw new IllegalArgumentException(CheckMethodAdapter.llIllIIIIII[123]);
        }
    }
    
    private static Field getLabelStatusField() {
        if (CheckMethodAdapter.labelStatusField == null && (CheckMethodAdapter.labelStatusField = getLabelField(CheckMethodAdapter.llIllIIIIII[124])) == null) {
            CheckMethodAdapter.labelStatusField = getLabelField(CheckMethodAdapter.llIllIIIIII[125]);
        }
        return CheckMethodAdapter.labelStatusField;
    }
    
    private static Field getLabelField(final String s) {
        final Class<Label> clazz = Label.class;
        try {
            final Field declaredField;
            (declaredField = clazz.getDeclaredField(s)).setAccessible(true);
            return declaredField;
        }
        catch (NoSuchFieldException ex) {
            return null;
        }
    }
    
    static {
        lIIllIIIlIllI();
        final String s;
        TYPE = new int[(s = CheckMethodAdapter.llIllIIIIII[126]).length()];
        for (int i = 0; i < CheckMethodAdapter.TYPE.length; ++i) {
            CheckMethodAdapter.TYPE[i] = s.charAt(i) - 'A' - '\u0001';
        }
    }
    
    private static void lIIllIIIlIllI() {
        (llIllIIIIII = new String[127])[0] = "name";
        CheckMethodAdapter.llIllIIIIII[1] = "Invalid type reference sort 0x";
        CheckMethodAdapter.llIllIIIIII[2] = "Invalid attribute (must not be null)";
        CheckMethodAdapter.llIllIIIIII[3] = "Abstract methods cannot have code";
        CheckMethodAdapter.llIllIIIIII[4] = "At most one frame can be visited at a given code location.";
        CheckMethodAdapter.llIllIIIIII[5] = "Invalid frame type ";
        CheckMethodAdapter.llIllIIIIII[6] = "Invalid nLocal=";
        CheckMethodAdapter.llIllIIIIII[7] = " for frame type ";
        CheckMethodAdapter.llIllIIIIII[8] = "Invalid nStack=";
        CheckMethodAdapter.llIllIIIIII[9] = " for frame type ";
        CheckMethodAdapter.llIllIIIIII[10] = "Array local[] is shorter than nLocal";
        CheckMethodAdapter.llIllIIIIII[11] = "Array stack[] is shorter than nStack";
        CheckMethodAdapter.llIllIIIIII[12] = "Expanded and compressed frames must not be mixed.";
        CheckMethodAdapter.llIllIIIIII[13] = "Invalid operand";
        CheckMethodAdapter.llIllIIIIII[14] = "Invalid operand";
        CheckMethodAdapter.llIllIIIIII[15] = "Invalid operand (must be an array type code T_...): ";
        CheckMethodAdapter.llIllIIIIII[16] = "Invalid variable index";
        CheckMethodAdapter.llIllIIIIII[17] = "type";
        CheckMethodAdapter.llIllIIIIII[18] = "NEW cannot be used to create arrays: ";
        CheckMethodAdapter.llIllIIIIII[19] = "owner";
        CheckMethodAdapter.llIllIIIIII[20] = "name";
        CheckMethodAdapter.llIllIIIIII[21] = "<init>";
        CheckMethodAdapter.llIllIIIIII[22] = "name";
        CheckMethodAdapter.llIllIIIIII[23] = "owner";
        CheckMethodAdapter.llIllIIIIII[24] = "INVOKEVIRTUAL can't be used with interfaces";
        CheckMethodAdapter.llIllIIIIII[25] = "INVOKEINTERFACE can't be used with classes";
        CheckMethodAdapter.llIllIIIIII[26] = "INVOKESPECIAL can't be used with interfaces prior to Java 8";
        CheckMethodAdapter.llIllIIIIII[27] = "name";
        CheckMethodAdapter.llIllIIIIII[28] = "invalid handle tag ";
        CheckMethodAdapter.llIllIIIIII[29] = "label";
        CheckMethodAdapter.llIllIIIIII[30] = "label";
        CheckMethodAdapter.llIllIIIIII[31] = "Already visited label";
        CheckMethodAdapter.llIllIIIIII[32] = "Invalid variable index";
        CheckMethodAdapter.llIllIIIIII[33] = "Invalid increment";
        CheckMethodAdapter.llIllIIIIII[34] = "Max = ";
        CheckMethodAdapter.llIllIIIIII[35] = " must be greater than or equal to min = ";
        CheckMethodAdapter.llIllIIIIII[36] = "default label";
        CheckMethodAdapter.llIllIIIIII[37] = "There must be max - min + 1 labels";
        CheckMethodAdapter.llIllIIIIII[38] = "label at index ";
        CheckMethodAdapter.llIllIIIIII[39] = "default label";
        CheckMethodAdapter.llIllIIIIII[40] = "There must be the same number of keys and labels";
        CheckMethodAdapter.llIllIIIIII[41] = "label at index ";
        CheckMethodAdapter.llIllIIIIII[42] = "Invalid descriptor (must be an array type descriptor): ";
        CheckMethodAdapter.llIllIIIIII[43] = "Invalid dimensions (must be greater than 0): ";
        CheckMethodAdapter.llIllIIIIII[44] = "Invalid dimensions (must not be greater than dims(desc)): ";
        CheckMethodAdapter.llIllIIIIII[45] = "Invalid type reference sort 0x";
        CheckMethodAdapter.llIllIIIIII[46] = "start label";
        CheckMethodAdapter.llIllIIIIII[47] = "end label";
        CheckMethodAdapter.llIllIIIIII[48] = "handler label";
        CheckMethodAdapter.llIllIIIIII[49] = "Try catch blocks must be visited before their labels";
        CheckMethodAdapter.llIllIIIIII[50] = "type";
        CheckMethodAdapter.llIllIIIIII[51] = "Invalid type reference sort 0x";
        CheckMethodAdapter.llIllIIIIII[52] = "name";
        CheckMethodAdapter.llIllIIIIII[53] = "start label";
        CheckMethodAdapter.llIllIIIIII[54] = "end label";
        CheckMethodAdapter.llIllIIIIII[55] = "Invalid variable index";
        CheckMethodAdapter.llIllIIIIII[56] = "Invalid start and end labels (end must be greater than start)";
        CheckMethodAdapter.llIllIIIIII[57] = "Invalid type reference sort 0x";
        CheckMethodAdapter.llIllIIIIII[58] = "Invalid start, end and index arrays (must be non null and of identical length";
        CheckMethodAdapter.llIllIIIIII[59] = "start label";
        CheckMethodAdapter.llIllIIIIII[60] = "end label";
        CheckMethodAdapter.llIllIIIIII[61] = "Invalid variable index";
        CheckMethodAdapter.llIllIIIIII[62] = "Invalid start and end labels (end must be greater than start)";
        CheckMethodAdapter.llIllIIIIII[63] = "Invalid line number";
        CheckMethodAdapter.llIllIIIIII[64] = "start label";
        CheckMethodAdapter.llIllIIIIII[65] = "Undefined label used";
        CheckMethodAdapter.llIllIIIIII[66] = "Undefined try catch block labels";
        CheckMethodAdapter.llIllIIIIII[67] = "Emty try catch block handler range";
        CheckMethodAdapter.llIllIIIIII[68] = "Invalid max stack";
        CheckMethodAdapter.llIllIIIIII[69] = "Invalid max locals";
        CheckMethodAdapter.llIllIIIIII[70] = "Cannot visit instructions before visitCode has been called.";
        CheckMethodAdapter.llIllIIIIII[71] = "Cannot visit instructions after visitMaxs has been called.";
        CheckMethodAdapter.llIllIIIIII[72] = "Cannot visit elements after visitEnd has been called.";
        CheckMethodAdapter.llIllIIIIII[73] = "Invalid stack frame value";
        CheckMethodAdapter.llIllIIIIII[74] = "Invalid stack frame value: ";
        CheckMethodAdapter.llIllIIIIII[75] = "Invalid opcode: ";
        CheckMethodAdapter.llIllIIIIII[76] = " (must be a signed byte): ";
        CheckMethodAdapter.llIllIIIIII[77] = " (must be a signed short): ";
        CheckMethodAdapter.llIllIIIIII[78] = " (must be an unsigned short): ";
        CheckMethodAdapter.llIllIIIIII[79] = "Invalid constant: ";
        CheckMethodAdapter.llIllIIIIII[80] = "Illegal LDC constant value";
        CheckMethodAdapter.llIllIIIIII[81] = "ldc of a constant class requires at least version 1.5";
        CheckMethodAdapter.llIllIIIIII[82] = "ldc of a method type requires at least version 1.7";
        CheckMethodAdapter.llIllIIIIII[83] = "ldc of a handle requires at least version 1.7";
        CheckMethodAdapter.llIllIIIIII[84] = "invalid handle tag ";
        CheckMethodAdapter.llIllIIIIII[85] = ".;[/";
        CheckMethodAdapter.llIllIIIIII[86] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[87] = " (must be a valid unqualified name): ";
        CheckMethodAdapter.llIllIIIIII[88] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[89] = " (must not be null or empty)";
        CheckMethodAdapter.llIllIIIIII[90] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[91] = " (must be a valid Java identifier): ";
        CheckMethodAdapter.llIllIIIIII[92] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[93] = " (must be a valid Java identifier): ";
        CheckMethodAdapter.llIllIIIIII[94] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[95] = " (must not be null or empty)";
        CheckMethodAdapter.llIllIIIIII[96] = ".;[/<>";
        CheckMethodAdapter.llIllIIIIII[97] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[98] = " (must be a valid unqualified name): ";
        CheckMethodAdapter.llIllIIIIII[99] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[100] = " (must be a '<init>', '<clinit>' or a valid Java identifier): ";
        CheckMethodAdapter.llIllIIIIII[101] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[102] = " (must be '<init>' or '<clinit>' or a valid Java identifier): ";
        CheckMethodAdapter.llIllIIIIII[103] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[104] = " (must not be null or empty)";
        CheckMethodAdapter.llIllIIIIII[105] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[106] = " (must be a fully qualified class name in internal form): ";
        CheckMethodAdapter.llIllIIIIII[107] = "Invalid descriptor: ";
        CheckMethodAdapter.llIllIIIIII[108] = "Invalid type descriptor (must not be null or empty)";
        CheckMethodAdapter.llIllIIIIII[109] = "Invalid descriptor: ";
        CheckMethodAdapter.llIllIIIIII[110] = "Invalid descriptor: ";
        CheckMethodAdapter.llIllIIIIII[111] = "Invalid descriptor: ";
        CheckMethodAdapter.llIllIIIIII[112] = "Invalid descriptor: ";
        CheckMethodAdapter.llIllIIIIII[113] = "Invalid descriptor: ";
        CheckMethodAdapter.llIllIIIIII[114] = "Invalid method descriptor (must not be null or empty)";
        CheckMethodAdapter.llIllIIIIII[115] = "Invalid descriptor: ";
        CheckMethodAdapter.llIllIIIIII[116] = "Invalid descriptor: ";
        CheckMethodAdapter.llIllIIIIII[117] = "Invalid descriptor: ";
        CheckMethodAdapter.llIllIIIIII[118] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[119] = " (must not be null)";
        CheckMethodAdapter.llIllIIIIII[120] = "Invalid ";
        CheckMethodAdapter.llIllIIIIII[121] = " (must be visited first)";
        CheckMethodAdapter.llIllIIIIII[122] = "Internal error";
        CheckMethodAdapter.llIllIIIIII[123] = "Labels used for debug info cannot be reused for control flow";
        CheckMethodAdapter.llIllIIIIII[124] = "a";
        CheckMethodAdapter.llIllIIIIII[125] = "status";
        CheckMethodAdapter.llIllIIIIII[126] = "BBBBBBBBBBBBBBBBCCIAADDDDDAAAAAAAAAAAAAAAAAAAABBBBBBBBDDDDDAAAAAAAAAAAAAAAAAAAABBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBBJBBBBBBBBBBBBBBBBBBBBHHHHHHHHHHHHHHHHDKLBBBBBBFFFFGGGGAECEBBEEBBAMHHAA";
    }
    
    private static String lIIlIlIlllIll(final String s, final String s2) {
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
    
    private static String lIIlIlIllIlll(final String s, final String s2) {
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
    
    private static String lIIlIlIlllIlI(String s, final String s2) {
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
    
    private static boolean lIIllIIllIIll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIllIlIIlIII(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lIIllIIlIllll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIllIIlIlIII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIllIlIIlIIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIllIlIIlIlI(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIllIIllIIII(final int n) {
        return n > 0;
    }
    
    private static boolean lIIllIIlIlIlI(final int n, final int n2) {
        return n != n2;
    }
}
