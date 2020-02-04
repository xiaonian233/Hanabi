package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.lib.tree.analysis.*;
import org.spongepowered.asm.lib.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import java.io.*;

public class CheckClassAdapter extends ClassVisitor
{
    private int version;
    private boolean start;
    private boolean source;
    private boolean outer;
    private boolean end;
    private Map<Label, Integer> labels;
    private boolean checkDataFlow;
    private static final String[] lIllIIIIIl;
    
    public static void main(final String[] array) throws Exception {
        if (lIIIIIlIlIll(array.length, 1)) {
            System.err.println(CheckClassAdapter.lIllIIIIIl[0]);
            System.err.println(CheckClassAdapter.lIllIIIIIl[1]);
            return;
        }
        ClassReader classReader;
        if (array[0].endsWith(CheckClassAdapter.lIllIIIIIl[2])) {
            classReader = new ClassReader(new FileInputStream(array[0]));
        }
        else {
            classReader = new ClassReader(array[0]);
        }
        verify(classReader, false, new PrintWriter(System.err));
    }
    
    private static void verify$1736f62c(ClassReader classReader, final boolean b, final PrintWriter printWriter) {
        final ClassNode classNode = new ClassNode();
        classReader.accept(new CheckClassAdapter(classNode, false), 2);
        classReader = (ClassReader)((classNode.superName == null) ? null : Type.getObjectType(classNode.superName));
        final List<MethodNode> methods = classNode.methods;
        final ArrayList<Type> list = new ArrayList<Type>();
        final Iterator<String> iterator = classNode.interfaces.iterator();
        while (iterator.hasNext()) {
            list.add(Type.getObjectType(iterator.next()));
        }
        for (int i = 0; i < methods.size(); ++i) {
            final MethodNode methodNode = methods.get(i);
            final Analyzer analyzer2;
            final Analyzer analyzer = analyzer2 = new Analyzer<BasicValue>((Interpreter<Value>)new SimpleVerifier(Type.getObjectType(classNode.name), (Type)classReader, list, (classNode.access & 0x200) != 0x0));
            final ClassNode classNode2 = classNode;
            try {
                analyzer.analyze(classNode2.name, methodNode);
                if (!b) {
                    continue;
                }
            }
            catch (Exception ex) {
                ex.printStackTrace(printWriter);
            }
            printAnalyzerResult(methodNode, (Analyzer<BasicValue>)analyzer2, printWriter);
        }
        printWriter.flush();
    }
    
    public static void verify(final ClassReader classReader, final boolean b, final PrintWriter printWriter) {
        verify$1736f62c(classReader, b, printWriter);
    }
    
    static void printAnalyzerResult(final MethodNode methodNode, final Analyzer<BasicValue> analyzer, final PrintWriter printWriter) {
        final Frame<BasicValue>[] frames = analyzer.frames;
        final Textifier textifier = new Textifier();
        final TraceMethodVisitor traceMethodVisitor = new TraceMethodVisitor(textifier);
        printWriter.println(String.valueOf(new StringBuilder().append(methodNode.name).append(methodNode.desc)));
        for (int i = 0; i < methodNode.instructions.size(); ++i) {
            methodNode.instructions.get(i).accept(traceMethodVisitor);
            final StringBuilder sb = new StringBuilder();
            final Frame<BasicValue> frame;
            if ((frame = frames[i]) == null) {
                sb.append('?');
            }
            else {
                for (int j = 0; j < frame.locals; ++j) {
                    sb.append(getShortName(frame.getLocal(j).toString())).append(' ');
                }
                sb.append(CheckClassAdapter.lIllIIIIIl[3]);
                for (int k = 0; k < frame.top; ++k) {
                    sb.append(getShortName(frame.getStack(k).toString())).append(' ');
                }
            }
            while (sb.length() < methodNode.maxStack + methodNode.maxLocals + 1) {
                sb.append(' ');
            }
            printWriter.print(Integer.toString(i + 100000).substring(1));
            printWriter.print(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[4]).append((Object)sb).append(CheckClassAdapter.lIllIIIIIl[5]).append(textifier.text.get(textifier.text.size() - 1))));
        }
        for (int l = 0; l < methodNode.tryCatchBlocks.size(); ++l) {
            methodNode.tryCatchBlocks.get(l).accept(traceMethodVisitor);
            printWriter.print(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[6]).append(textifier.text.get(textifier.text.size() - 1))));
        }
        printWriter.println();
    }
    
    private static String getShortName(final String s) {
        final int lastIndex = s.lastIndexOf(47);
        int length = s.length();
        if (s.charAt(length - 1) == ';') {
            --length;
        }
        if (lastIndex == -1) {
            return s;
        }
        return s.substring(lastIndex + 1, length);
    }
    
    public CheckClassAdapter(final ClassVisitor classVisitor) {
        this(classVisitor, true);
    }
    
    private CheckClassAdapter(final ClassVisitor classVisitor, final boolean b) {
        this(classVisitor, b, (byte)0);
        if (this.getClass() != CheckClassAdapter.class) {
            throw new IllegalStateException();
        }
    }
    
    private CheckClassAdapter(final ClassVisitor classVisitor, final boolean checkDataFlow, final byte b) {
        super(classVisitor);
        this.labels = new HashMap<Label, Integer>();
        this.checkDataFlow = checkDataFlow;
    }
    
    public final void visit(final int version, final int n, final String s, final String s2, final String s3, final String[] array) {
        if (this.start) {
            throw new IllegalStateException(CheckClassAdapter.lIllIIIIIl[7]);
        }
        this.start = true;
        this.checkState();
        checkAccess(n, 423473);
        if (s == null || !s.endsWith(CheckClassAdapter.lIllIIIIIl[8])) {
            CheckMethodAdapter.checkInternalName(s, CheckClassAdapter.lIllIIIIIl[9]);
        }
        if (CheckClassAdapter.lIllIIIIIl[10].equals(s)) {
            if (s3 != null) {
                throw new IllegalArgumentException(CheckClassAdapter.lIllIIIIIl[11]);
            }
        }
        else {
            CheckMethodAdapter.checkInternalName(s3, CheckClassAdapter.lIllIIIIIl[12]);
        }
        if (s2 != null) {
            checkClassSignature(s2);
        }
        if ((n & 0x200) != 0x0 && !CheckClassAdapter.lIllIIIIIl[13].equals(s3)) {
            throw new IllegalArgumentException(CheckClassAdapter.lIllIIIIIl[14]);
        }
        if (array != null) {
            for (int i = 0; i < array.length; ++i) {
                CheckMethodAdapter.checkInternalName(array[i], String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[15]).append(i)));
            }
        }
        super.visit(this.version = version, n, s, s2, s3, array);
    }
    
    public final void visitSource(final String s, final String s2) {
        this.checkState();
        if (this.source) {
            throw new IllegalStateException(CheckClassAdapter.lIllIIIIIl[16]);
        }
        this.source = true;
        super.visitSource(s, s2);
    }
    
    public final void visitOuterClass(final String s, final String s2, final String s3) {
        this.checkState();
        if (this.outer) {
            throw new IllegalStateException(CheckClassAdapter.lIllIIIIIl[17]);
        }
        this.outer = true;
        if (s == null) {
            throw new IllegalArgumentException(CheckClassAdapter.lIllIIIIIl[18]);
        }
        if (s3 != null) {
            CheckMethodAdapter.checkMethodDesc(s3);
        }
        super.visitOuterClass(s, s2, s3);
    }
    
    public final void visitInnerClass(final String s, final String s2, final String s3, final int n) {
        this.checkState();
        CheckMethodAdapter.checkInternalName(s, CheckClassAdapter.lIllIIIIIl[19]);
        if (s2 != null) {
            CheckMethodAdapter.checkInternalName(s2, CheckClassAdapter.lIllIIIIIl[20]);
        }
        if (s3 != null) {
            int n2;
            for (n2 = 0; n2 < s3.length() && Character.isDigit(s3.charAt(n2)); ++n2) {}
            if (n2 == 0 || n2 < s3.length()) {
                CheckMethodAdapter.checkIdentifier(s3, n2, -1, CheckClassAdapter.lIllIIIIIl[21]);
            }
        }
        checkAccess(n, 30239);
        super.visitInnerClass(s, s2, s3, n);
    }
    
    public final FieldVisitor visitField(final int n, final String s, final String s2, final String s3, final Object o) {
        this.checkState();
        checkAccess(n, 413919);
        CheckMethodAdapter.checkUnqualifiedName(this.version, s, CheckClassAdapter.lIllIIIIIl[22]);
        CheckMethodAdapter.checkDesc$505cbf4b(s2);
        final int checkFieldTypeSignature;
        if (s3 != null && lIIIIIlIlIll(checkFieldTypeSignature = checkFieldTypeSignature(s3, 0), s3.length())) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s3).append(CheckClassAdapter.lIllIIIIIl[37]).append(checkFieldTypeSignature)));
        }
        if (o != null) {
            CheckMethodAdapter.checkConstant(o);
        }
        return new CheckFieldAdapter(super.visitField(n, s, s2, s3, o));
    }
    
    public final MethodVisitor visitMethod(final int n, final String s, final String s2, final String s3, final String[] array) {
        this.checkState();
        checkAccess(n, 400895);
        if (!CheckClassAdapter.lIllIIIIIl[23].equals(s) && !CheckClassAdapter.lIllIIIIIl[24].equals(s)) {
            CheckMethodAdapter.checkMethodIdentifier(this.version, s, CheckClassAdapter.lIllIIIIIl[25]);
        }
        CheckMethodAdapter.checkMethodDesc(s2);
        if (s3 != null) {
            int checkFormalTypeParameters$505cff29 = 0;
            if (getChar(s3, 0) == '<') {
                checkFormalTypeParameters$505cff29 = checkFormalTypeParameters$505cff29(s3);
            }
            int n2;
            for (n2 = checkChar('(', s3, checkFormalTypeParameters$505cff29); lIIIIIlIlIll(CheckClassAdapter.lIllIIIIIl[35].indexOf(getChar(s3, n2)), -1); n2 = checkTypeSignature(s3, n2)) {}
            int n3 = checkChar(')', s3, n2);
            if (getChar(s3, n3) == 'V') {
                ++n3;
            }
            else {
                n3 = checkTypeSignature(s3, n3);
            }
            while (getChar(s3, n3) == '^') {
                ++n3;
                if (getChar(s3, n3) == 'L') {
                    n3 = checkClassTypeSignature(s3, n3);
                }
                else {
                    n3 = checkTypeVariableSignature(s3, n3);
                }
            }
            if (lIIIIIlIlIll(n3, s3.length())) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s3).append(CheckClassAdapter.lIllIIIIIl[36]).append(n3)));
            }
        }
        if (array != null) {
            for (int i = 0; i < array.length; ++i) {
                CheckMethodAdapter.checkInternalName(array[i], String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[26]).append(i)));
            }
        }
        CheckMethodAdapter checkMethodAdapter;
        if (this.checkDataFlow) {
            checkMethodAdapter = new CheckMethodAdapter(n, s, s2, super.visitMethod(n, s, s2, s3, array), this.labels);
        }
        else {
            checkMethodAdapter = new CheckMethodAdapter(super.visitMethod(n, s, s2, s3, array), this.labels);
        }
        checkMethodAdapter.version = this.version;
        return checkMethodAdapter;
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final boolean b) {
        this.checkState();
        CheckMethodAdapter.checkDesc$505cbf4b(s);
        return new CheckAnnotationAdapter(super.visitAnnotation(s, b));
    }
    
    public final AnnotationVisitor visitTypeAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        this.checkState();
        final int n2;
        if ((n2 = n >>> 24) != 0 && lIIIIIlIlIll(n2, 17) && lIIIIIlIlIll(n2, 16)) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[27]).append(Integer.toHexString(n2))));
        }
        checkTypeRefAndPath(n, typePath);
        CheckMethodAdapter.checkDesc$505cbf4b(s);
        return new CheckAnnotationAdapter(super.visitTypeAnnotation(n, typePath, s, b));
    }
    
    public final void visitAttribute(final Attribute attribute) {
        this.checkState();
        if (attribute == null) {
            throw new IllegalArgumentException(CheckClassAdapter.lIllIIIIIl[28]);
        }
        super.visitAttribute(attribute);
    }
    
    public final void visitEnd() {
        this.checkState();
        this.end = true;
        super.visitEnd();
    }
    
    private void checkState() {
        if (!this.start) {
            throw new IllegalStateException(CheckClassAdapter.lIllIIIIIl[29]);
        }
        if (this.end) {
            throw new IllegalStateException(CheckClassAdapter.lIllIIIIIl[30]);
        }
    }
    
    static void checkAccess(final int n, int n2) {
        if ((n & ~n2) != 0x0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[31]).append(n)));
        }
        n2 = (((n & 0x1) != 0x0) ? 1 : 0);
        if (lIIIIIlllIll$255f299(n2 + (((n & 0x2) != 0x0) ? 1 : 0) + (((n & 0x4) != 0x0) ? 1 : 0))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[32]).append(n)));
        }
        n2 = (((n & 0x10) != 0x0) ? 1 : 0);
        if (lIIIIIlllIll$255f299(n2 + (((n & 0x400) != 0x0) ? 1 : 0))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[33]).append(n)));
        }
    }
    
    private static void checkClassSignature(final String s) {
        int n = 0;
        if (getChar(s, 0) == '<') {
            n = checkFormalTypeParameters$505cff29(s);
        }
        do {
            n = checkClassTypeSignature(s, n);
        } while (getChar(s, n) == 'L');
        if (lIIIIIlIlIll(n, s.length())) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s).append(CheckClassAdapter.lIllIIIIIl[34]).append(n)));
        }
    }
    
    private static void checkMethodSignature(final String s) {
        int checkFormalTypeParameters$505cff29 = 0;
        if (getChar(s, 0) == '<') {
            checkFormalTypeParameters$505cff29 = checkFormalTypeParameters$505cff29(s);
        }
        int n;
        for (n = checkChar('(', s, checkFormalTypeParameters$505cff29); lIIIIIlIlIll(CheckClassAdapter.lIllIIIIIl[35].indexOf(getChar(s, n)), -1); n = checkTypeSignature(s, n)) {}
        int n2 = checkChar(')', s, n);
        if (getChar(s, n2) == 'V') {
            ++n2;
        }
        else {
            n2 = checkTypeSignature(s, n2);
        }
        while (getChar(s, n2) == '^') {
            ++n2;
            if (getChar(s, n2) == 'L') {
                n2 = checkClassTypeSignature(s, n2);
            }
            else {
                n2 = checkTypeVariableSignature(s, n2);
            }
        }
        if (lIIIIIlIlIll(n2, s.length())) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s).append(CheckClassAdapter.lIllIIIIIl[36]).append(n2)));
        }
    }
    
    private static void checkFieldSignature(final String s) {
        final int checkFieldTypeSignature;
        if (lIIIIIlIlIll(checkFieldTypeSignature = checkFieldTypeSignature(s, 0), s.length())) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s).append(CheckClassAdapter.lIllIIIIIl[37]).append(checkFieldTypeSignature)));
        }
    }
    
    static void checkTypeRefAndPath(int i, final TypePath typePath) {
        int n = 0;
        switch (i >>> 24) {
            case 0:
            case 1:
            case 22: {
                n = -65536;
                break;
            }
            case 19:
            case 20:
            case 21:
            case 64:
            case 65:
            case 67:
            case 68:
            case 69:
            case 70: {
                n = -16777216;
                break;
            }
            case 16:
            case 17:
            case 18:
            case 23:
            case 66: {
                n = -256;
                break;
            }
            case 71:
            case 72:
            case 73:
            case 74:
            case 75: {
                n = -16776961;
                break;
            }
            default: {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[38]).append(Integer.toHexString(i >>> 24))));
            }
        }
        if ((i & ~n) != 0x0) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[39]).append(Integer.toHexString(i))));
        }
        if (typePath != null) {
            int step;
            for (i = 0; i < typePath.getLength(); ++i) {
                if ((step = typePath.getStep(i)) != 0 && lIIIIIlIlIll(step, 1) && lIIIIIlIlIll(step, 3) && lIIIIIlIlIll(step, 2)) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[40]).append(i).append(CheckClassAdapter.lIllIIIIIl[41]).append(typePath)));
                }
                if (lIIIIIlIlIll(step, 3) && typePath.getStepArgument(i) != 0) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(CheckClassAdapter.lIllIIIIIl[42]).append(i).append(CheckClassAdapter.lIllIIIIIl[43]).append(typePath)));
                }
            }
        }
    }
    
    private static int checkFormalTypeParameters$505cff29(final String s) {
        int n;
        for (n = checkFormalTypeParameter(s, checkChar('<', s, 0)); lIIIIIlIlIll(getChar(s, n), 62); n = checkFormalTypeParameter(s, n)) {}
        return n + 1;
    }
    
    private static int checkFormalTypeParameter(final String s, int n) {
        n = checkIdentifier(s, n);
        n = checkChar(':', s, n);
        if (lIIIIIlIlIll(CheckClassAdapter.lIllIIIIIl[44].indexOf(getChar(s, n)), -1)) {
            n = checkFieldTypeSignature(s, n);
        }
        while (getChar(s, n) == ':') {
            n = checkFieldTypeSignature(s, n + 1);
        }
        return n;
    }
    
    private static int checkFieldTypeSignature(final String s, final int n) {
        switch (getChar(s, n)) {
            case 'L': {
                return checkClassTypeSignature(s, n);
            }
            case '[': {
                return checkTypeSignature(s, n + 1);
            }
            default: {
                return checkTypeVariableSignature(s, n);
            }
        }
    }
    
    private static int checkClassTypeSignature(final String s, int n) {
        for (n = checkChar('L', s, n), n = checkIdentifier(s, n); getChar(s, n) == '/'; n = checkIdentifier(s, n + 1)) {}
        if (getChar(s, n) == '<') {
            n = checkTypeArguments(s, n);
        }
        while (getChar(s, n) == '.') {
            n = checkIdentifier(s, n + 1);
            if (getChar(s, n) == '<') {
                n = checkTypeArguments(s, n);
            }
        }
        return checkChar(';', s, n);
    }
    
    private static int checkTypeArguments(final String s, int n) {
        for (n = checkChar('<', s, n), n = checkTypeArgument(s, n); lIIIIIlIlIll(getChar(s, n), 62); n = checkTypeArgument(s, n)) {}
        return n + 1;
    }
    
    private static int checkTypeArgument(final String s, int n) {
        final char char1;
        if ((char1 = getChar(s, n)) == '*') {
            return n + 1;
        }
        if (!lIIIIIlIlIll(char1, 43) || char1 == '-') {
            ++n;
        }
        return checkFieldTypeSignature(s, n);
    }
    
    private static int checkTypeVariableSignature(final String s, int n) {
        n = checkChar('T', s, n);
        n = checkIdentifier(s, n);
        return checkChar(';', s, n);
    }
    
    private static int checkTypeSignature(final String s, final int n) {
        switch (getChar(s, n)) {
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
            default: {
                return checkFieldTypeSignature(s, n);
            }
        }
    }
    
    private static int checkIdentifier(final String s, int n) {
        if (!Character.isJavaIdentifierStart(getChar(s, n))) {
            throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s).append(CheckClassAdapter.lIllIIIIIl[45]).append(n)));
        }
        do {
            ++n;
        } while (Character.isJavaIdentifierPart(getChar(s, n)));
        return n;
    }
    
    private static int checkChar(final char c, final String s, final int n) {
        if (getChar(s, n) == c) {
            return n + 1;
        }
        throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(s).append(CheckClassAdapter.lIllIIIIIl[46]).append(c).append(CheckClassAdapter.lIllIIIIIl[47]).append(n)));
    }
    
    private static char getChar(final String s, final int n) {
        if (n < s.length()) {
            return s.charAt(n);
        }
        return '\0';
    }
    
    static {
        lIIIIIlIIIIl();
    }
    
    private static void lIIIIIlIIIIl() {
        (lIllIIIIIl = new String[48])[0] = "Verifies the given class.";
        CheckClassAdapter.lIllIIIIIl[1] = "Usage: CheckClassAdapter <fully qualified class name or class file name>";
        CheckClassAdapter.lIllIIIIIl[2] = ".class";
        CheckClassAdapter.lIllIIIIIl[3] = " : ";
        CheckClassAdapter.lIllIIIIIl[4] = " ";
        CheckClassAdapter.lIllIIIIIl[5] = " : ";
        CheckClassAdapter.lIllIIIIIl[6] = " ";
        CheckClassAdapter.lIllIIIIIl[7] = "visit must be called only once";
        CheckClassAdapter.lIllIIIIIl[8] = "package-info";
        CheckClassAdapter.lIllIIIIIl[9] = "class name";
        CheckClassAdapter.lIllIIIIIl[10] = "java/lang/Object";
        CheckClassAdapter.lIllIIIIIl[11] = "The super class name of the Object class must be 'null'";
        CheckClassAdapter.lIllIIIIIl[12] = "super class name";
        CheckClassAdapter.lIllIIIIIl[13] = "java/lang/Object";
        CheckClassAdapter.lIllIIIIIl[14] = "The super class name of interfaces must be 'java/lang/Object'";
        CheckClassAdapter.lIllIIIIIl[15] = "interface name at index ";
        CheckClassAdapter.lIllIIIIIl[16] = "visitSource can be called only once.";
        CheckClassAdapter.lIllIIIIIl[17] = "visitOuterClass can be called only once.";
        CheckClassAdapter.lIllIIIIIl[18] = "Illegal outer class owner";
        CheckClassAdapter.lIllIIIIIl[19] = "class name";
        CheckClassAdapter.lIllIIIIIl[20] = "outer class name";
        CheckClassAdapter.lIllIIIIIl[21] = "inner class name";
        CheckClassAdapter.lIllIIIIIl[22] = "field name";
        CheckClassAdapter.lIllIIIIIl[23] = "<init>";
        CheckClassAdapter.lIllIIIIIl[24] = "<clinit>";
        CheckClassAdapter.lIllIIIIIl[25] = "method name";
        CheckClassAdapter.lIllIIIIIl[26] = "exception name at index ";
        CheckClassAdapter.lIllIIIIIl[27] = "Invalid type reference sort 0x";
        CheckClassAdapter.lIllIIIIIl[28] = "Invalid attribute (must not be null)";
        CheckClassAdapter.lIllIIIIIl[29] = "Cannot visit member before visit has been called.";
        CheckClassAdapter.lIllIIIIIl[30] = "Cannot visit member after visitEnd has been called.";
        CheckClassAdapter.lIllIIIIIl[31] = "Invalid access flags: ";
        CheckClassAdapter.lIllIIIIIl[32] = "public private and protected are mutually exclusive: ";
        CheckClassAdapter.lIllIIIIIl[33] = "final and abstract are mutually exclusive: ";
        CheckClassAdapter.lIllIIIIIl[34] = ": error at index ";
        CheckClassAdapter.lIllIIIIIl[35] = "ZCBSIFJDL[T";
        CheckClassAdapter.lIllIIIIIl[36] = ": error at index ";
        CheckClassAdapter.lIllIIIIIl[37] = ": error at index ";
        CheckClassAdapter.lIllIIIIIl[38] = "Invalid type reference sort 0x";
        CheckClassAdapter.lIllIIIIIl[39] = "Invalid type reference 0x";
        CheckClassAdapter.lIllIIIIIl[40] = "Invalid type path step ";
        CheckClassAdapter.lIllIIIIIl[41] = " in ";
        CheckClassAdapter.lIllIIIIIl[42] = "Invalid type path step argument for step ";
        CheckClassAdapter.lIllIIIIIl[43] = " in ";
        CheckClassAdapter.lIllIIIIIl[44] = "L[T";
        CheckClassAdapter.lIllIIIIIl[45] = ": identifier expected at index ";
        CheckClassAdapter.lIllIIIIIl[46] = ": '";
        CheckClassAdapter.lIllIIIIIl[47] = "' expected at index ";
    }
    
    private static String lIIIIIIIllIl(final String s, final String s2) {
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
    
    private static String lIIIIIIIlIII(String s, final String s2) {
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
    
    private static String lIIIIIIIlIIl(final String s, final String s2) {
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
    
    private static boolean lIIIIIlllIll$255f299(final int n) {
        return n > 1;
    }
    
    private static boolean lIIIIIllIIlI(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIIIIlIlIll(final int n, final int n2) {
        return n != n2;
    }
}
