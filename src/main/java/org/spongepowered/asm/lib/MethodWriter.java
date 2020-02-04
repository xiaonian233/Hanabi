package org.spongepowered.asm.lib;

import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

final class MethodWriter extends MethodVisitor
{
    private static int ACC_CONSTRUCTOR;
    private static int SAME_FRAME;
    private static int SAME_LOCALS_1_STACK_ITEM_FRAME;
    private static int RESERVED;
    private static int SAME_LOCALS_1_STACK_ITEM_FRAME_EXTENDED;
    private static int CHOP_FRAME;
    private static int SAME_FRAME_EXTENDED;
    private static int APPEND_FRAME;
    private static int FULL_FRAME;
    private static int FRAMES;
    private static int INSERTED_FRAMES;
    private static int MAXS;
    private static int NOTHING;
    final ClassWriter cw;
    private int access;
    private final int name;
    private final int desc;
    private final String descriptor;
    String signature;
    int classReaderOffset;
    int classReaderLength;
    int exceptionCount;
    int[] exceptions;
    private ByteVector annd;
    private AnnotationWriter anns;
    private AnnotationWriter ianns;
    private AnnotationWriter tanns;
    private AnnotationWriter itanns;
    private AnnotationWriter[] panns;
    private AnnotationWriter[] ipanns;
    private int synthetics;
    private Attribute attrs;
    private ByteVector code;
    private int maxStack;
    private int maxLocals;
    private int currentLocals;
    private int frameCount;
    private ByteVector stackMap;
    private int previousFrameOffset;
    private int[] previousFrame;
    private int[] frame;
    private int handlerCount;
    private Handler firstHandler;
    private Handler lastHandler;
    private int methodParametersCount;
    private ByteVector methodParameters;
    private int localVarCount;
    private ByteVector localVar;
    private int localVarTypeCount;
    private ByteVector localVarType;
    private int lineNumberCount;
    private ByteVector lineNumber;
    private int lastCodeOffset;
    private AnnotationWriter ctanns;
    private AnnotationWriter ictanns;
    private Attribute cattrs;
    private int subroutines;
    private final int compute;
    private Label labels;
    private Label previousBlock;
    private Label currentBlock;
    private int stackSize;
    private int maxStackSize;
    private static final String[] llIllIlllIl;
    
    MethodWriter(final ClassWriter cw, final int access, final String s, final String descriptor, final String signature, final String[] array, final int compute) {
        super();
        this.code = new ByteVector();
        if (cw.firstMethod == null) {
            cw.firstMethod = this;
        }
        else {
            cw.lastMethod.mv = this;
        }
        cw.lastMethod = this;
        this.cw = cw;
        this.access = access;
        if (MethodWriter.llIllIlllIl[0].equals(s)) {
            this.access |= 0x80000;
        }
        this.name = cw.newUTF8(s);
        this.desc = cw.newUTF8(descriptor);
        this.descriptor = descriptor;
        this.signature = signature;
        if (array != null && array.length > 0) {
            this.exceptionCount = array.length;
            this.exceptions = new int[this.exceptionCount];
            for (int i = 0; i < this.exceptionCount; ++i) {
                this.exceptions[i] = cw.newClass(array[i]);
            }
        }
        this.compute = compute;
        if (lIIllIIlllIlI(compute, 3)) {
            int n = Type.getArgumentsAndReturnSizes(this.descriptor) >> 2;
            if ((access & 0x8) != 0x0) {
                --n;
            }
            this.maxLocals = n;
            this.currentLocals = n;
            this.labels = new Label();
            final Label labels = this.labels;
            labels.status |= 0x8;
            this.visitLabel(this.labels);
        }
    }
    
    public final void visitParameter(final String s, final int n) {
        if (this.methodParameters == null) {
            this.methodParameters = new ByteVector();
        }
        ++this.methodParametersCount;
        this.methodParameters.putShort((s == null) ? 0 : this.cw.newUTF8(s)).putShort(n);
    }
    
    public final AnnotationVisitor visitAnnotationDefault() {
        this.annd = new ByteVector();
        return new AnnotationWriter(this.cw, false, this.annd, null, 0);
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final boolean b) {
        final ByteVector byteVector;
        (byteVector = new ByteVector()).putShort(this.cw.newUTF8(s)).putShort(0);
        final ClassWriter cw = this.cw;
        final boolean b2 = true;
        final ByteVector byteVector2 = byteVector;
        final AnnotationWriter annotationWriter = new AnnotationWriter(cw, b2, byteVector2, byteVector2, 2);
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
        byteVector.putShort(this.cw.newUTF8(s)).putShort(0);
        final ClassWriter cw = this.cw;
        final boolean b2 = true;
        final ByteVector byteVector2 = byteVector;
        final AnnotationWriter annotationWriter = new AnnotationWriter(cw, b2, byteVector2, byteVector2, byteVector.length - 2);
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
    
    public final AnnotationVisitor visitParameterAnnotation(final int n, final String s, final boolean b) {
        final ByteVector byteVector = new ByteVector();
        if (MethodWriter.llIllIlllIl[1].equals(s)) {
            this.synthetics = Math.max(this.synthetics, n + 1);
            return new AnnotationWriter(this.cw, false, byteVector, null, 0);
        }
        byteVector.putShort(this.cw.newUTF8(s)).putShort(0);
        final ClassWriter cw = this.cw;
        final boolean b2 = true;
        final ByteVector byteVector2 = byteVector;
        final AnnotationWriter annotationWriter = new AnnotationWriter(cw, b2, byteVector2, byteVector2, 2);
        if (b) {
            if (this.panns == null) {
                this.panns = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
            }
            annotationWriter.next = this.panns[n];
            this.panns[n] = annotationWriter;
        }
        else {
            if (this.ipanns == null) {
                this.ipanns = new AnnotationWriter[Type.getArgumentTypes(this.descriptor).length];
            }
            annotationWriter.next = this.ipanns[n];
            this.ipanns[n] = annotationWriter;
        }
        return annotationWriter;
    }
    
    public final void visitAttribute(final Attribute attrs) {
        attrs.next = this.attrs;
        this.attrs = attrs;
    }
    
    public final void visitCode() {
    }
    
    public final void visitFrame(int i, final int n, final Object[] array, final int n2, Object[] array2) {
        if (this.compute == 0) {
            return;
        }
        if (this.compute == 1) {
            if (this.currentBlock.frame == null) {
                this.currentBlock.frame = new CurrentFrame();
                this.currentBlock.frame.owner = this.currentBlock;
                this.currentBlock.frame.initInputFrame(this.cw, this.access, Type.getArgumentTypes(this.descriptor), n);
                this.visitImplicitFirstFrame();
            }
            else {
                if (i == -1) {
                    final Frame frame = this.currentBlock.frame;
                    final ClassWriter cw = this.cw;
                    final Object[] array3 = array2;
                    array2 = array;
                    final ClassWriter classWriter = cw;
                    final Frame frame2 = frame;
                    for (int j = Frame.convert(classWriter, n, array2, frame2.inputLocals); j < array2.length; frame2.inputLocals[j++] = 16777216) {}
                    int n3 = 0;
                    for (int k = 0; k < n2; ++k) {
                        if (!Frame.llIllIIllIl(array3[k], Opcodes.LONG) || Frame.llIllIIlllI(array3[k], Opcodes.DOUBLE)) {
                            ++n3;
                        }
                    }
                    Frame.convert(classWriter, n2, array3, frame2.inputStack = new int[n2 + n3]);
                    frame2.outputStackTop = 0;
                    frame2.initializationCount = 0;
                }
                this.visitFrame(this.currentBlock.frame);
            }
        }
        else if (i == -1) {
            if (this.previousFrame == null) {
                this.visitImplicitFirstFrame();
            }
            this.currentLocals = n;
            int startFrame = this.startFrame(this.code.length, n, n2);
            for (i = 0; i < n; ++i) {
                if (array[i] instanceof String) {
                    this.frame[startFrame++] = (0x1700000 | this.cw.addType((String)array[i]));
                }
                else if (array[i] instanceof Integer) {
                    this.frame[startFrame++] = (int)array[i];
                }
                else {
                    this.frame[startFrame++] = (0x1800000 | this.cw.addUninitializedType(MethodWriter.llIllIlllIl[2], ((Label)array[i]).position));
                }
            }
            for (i = 0; i < n2; ++i) {
                if (array2[i] instanceof String) {
                    this.frame[startFrame++] = (0x1700000 | this.cw.addType((String)array2[i]));
                }
                else if (array2[i] instanceof Integer) {
                    this.frame[startFrame++] = (int)array2[i];
                }
                else {
                    this.frame[startFrame++] = (0x1800000 | this.cw.addUninitializedType(MethodWriter.llIllIlllIl[3], ((Label)array2[i]).position));
                }
            }
            this.endFrame();
        }
        else {
            int length;
            if (this.stackMap == null) {
                this.stackMap = new ByteVector();
                length = this.code.length;
            }
            else if ((length = this.code.length - this.previousFrameOffset - 1) < 0) {
                if (i == 3) {
                    return;
                }
                throw new IllegalStateException();
            }
            switch (i) {
                case 0: {
                    this.currentLocals = n;
                    this.stackMap.putByte(255).putShort(length).putShort(n);
                    for (i = 0; i < n; ++i) {
                        this.writeFrameType(array[i]);
                    }
                    this.stackMap.putShort(n2);
                    for (i = 0; i < n2; ++i) {
                        this.writeFrameType(array2[i]);
                    }
                    break;
                }
                case 1: {
                    this.currentLocals += n;
                    this.stackMap.putByte(n + 251).putShort(length);
                    for (i = 0; i < n; ++i) {
                        this.writeFrameType(array[i]);
                    }
                    break;
                }
                case 2: {
                    this.currentLocals -= n;
                    this.stackMap.putByte(251 - n).putShort(length);
                    break;
                }
                case 3: {
                    if (length < 64) {
                        this.stackMap.putByte(length);
                        break;
                    }
                    this.stackMap.putByte(251).putShort(length);
                    break;
                }
                case 4: {
                    if (length < 64) {
                        this.stackMap.putByte(length + 64);
                    }
                    else {
                        this.stackMap.putByte(247).putShort(length);
                    }
                    this.writeFrameType(array2[0]);
                    break;
                }
            }
            this.previousFrameOffset = this.code.length;
            ++this.frameCount;
        }
        this.maxStack = Math.max(this.maxStack, n2);
        this.maxLocals = Math.max(this.maxLocals, this.currentLocals);
    }
    
    public final void visitInsn(final int n) {
        this.lastCodeOffset = this.code.length;
        this.code.putByte(n);
        if (this.currentBlock != null) {
            if (this.compute == 0 || this.compute == 1) {
                this.currentBlock.frame.execute(n, 0, null, null);
            }
            else {
                final int n2;
                if (lIIllIlIIIllI(n2 = this.stackSize + Frame.SIZE[n], this.maxStackSize)) {
                    this.maxStackSize = n2;
                }
                this.stackSize = n2;
            }
            if ((lIIllIlIIIlll(n, 172) && !lIIllIlIIIllI(n, 177)) || n == 191) {
                this.noSuccessor();
            }
        }
    }
    
    public final void visitIntInsn(final int n, final int n2) {
        this.lastCodeOffset = this.code.length;
        if (this.currentBlock != null) {
            if (this.compute == 0 || this.compute == 1) {
                this.currentBlock.frame.execute(n, n2, null, null);
            }
            else if (lIIllIIlllIlI(n, 188)) {
                final int n3;
                if (lIIllIlIIIllI(n3 = this.stackSize + 1, this.maxStackSize)) {
                    this.maxStackSize = n3;
                }
                this.stackSize = n3;
            }
        }
        if (n == 17) {
            this.code.put12(n, n2);
            return;
        }
        this.code.put11(n, n2);
    }
    
    public final void visitVarInsn(final int n, final int n2) {
        this.lastCodeOffset = this.code.length;
        if (this.currentBlock != null) {
            if (this.compute == 0 || this.compute == 1) {
                this.currentBlock.frame.execute(n, n2, null, null);
            }
            else if (n == 169) {
                final Label currentBlock = this.currentBlock;
                currentBlock.status |= 0x100;
                this.currentBlock.inputStackTop = this.stackSize;
                this.noSuccessor();
            }
            else {
                final int n3;
                if (lIIllIlIIIllI(n3 = this.stackSize + Frame.SIZE[n], this.maxStackSize)) {
                    this.maxStackSize = n3;
                }
                this.stackSize = n3;
            }
        }
        if (lIIllIIlllIlI(this.compute, 3)) {
            int maxLocals;
            if (!lIIllIIlllIlI(n, 22) || !lIIllIIlllIlI(n, 24) || !lIIllIIlllIlI(n, 55) || n == 57) {
                maxLocals = n2 + 2;
            }
            else {
                maxLocals = n2 + 1;
            }
            if (lIIllIlIIIllI(maxLocals, this.maxLocals)) {
                this.maxLocals = maxLocals;
            }
        }
        if (n2 < 4 && lIIllIIlllIlI(n, 169)) {
            int n4;
            if (n < 54) {
                n4 = 26 + (n - 21 << 2) + n2;
            }
            else {
                n4 = 59 + (n - 54 << 2) + n2;
            }
            this.code.putByte(n4);
        }
        else if (lIIllIlIIIlll(n2, 256)) {
            this.code.putByte(196).put12(n, n2);
        }
        else {
            this.code.put11(n, n2);
        }
        if (lIIllIlIIIlll(n, 54) && this.compute == 0 && this.handlerCount > 0) {
            this.visitLabel(new Label());
        }
    }
    
    public final void visitTypeInsn(final int n, final String s) {
        this.lastCodeOffset = this.code.length;
        final Item classItem = this.cw.newClassItem(s);
        if (this.currentBlock != null) {
            if (this.compute == 0 || this.compute == 1) {
                this.currentBlock.frame.execute(n, this.code.length, this.cw, classItem);
            }
            else if (n == 187) {
                final int n2;
                if (lIIllIlIIIllI(n2 = this.stackSize + 1, this.maxStackSize)) {
                    this.maxStackSize = n2;
                }
                this.stackSize = n2;
            }
        }
        this.code.put12(n, classItem.index);
    }
    
    public final void visitFieldInsn(final int n, final String s, final String s2, final String s3) {
        this.lastCodeOffset = this.code.length;
        final Item fieldItem = this.cw.newFieldItem(s, s2, s3);
        if (this.currentBlock != null) {
            if (this.compute == 0 || this.compute == 1) {
                this.currentBlock.frame.execute(n, 0, this.cw, fieldItem);
            }
            else {
                final char char1 = s3.charAt(0);
                int n2 = 0;
                switch (n) {
                    case 178: {
                        n2 = this.stackSize + ((!lIIllIIlllIlI(char1, 68) || char1 == 'J') ? 2 : 1);
                        break;
                    }
                    case 179: {
                        n2 = this.stackSize + ((!lIIllIIlllIlI(char1, 68) || char1 == 'J') ? -2 : -1);
                        break;
                    }
                    case 180: {
                        n2 = this.stackSize + ((!lIIllIIlllIlI(char1, 68) || char1 == 'J') ? 1 : 0);
                        break;
                    }
                    default: {
                        n2 = this.stackSize + ((!lIIllIIlllIlI(char1, 68) || char1 == 'J') ? -3 : -2);
                        break;
                    }
                }
                if (lIIllIlIIIllI(n2, this.maxStackSize)) {
                    this.maxStackSize = n2;
                }
                this.stackSize = n2;
            }
        }
        this.code.put12(n, fieldItem.index);
    }
    
    public final void visitMethodInsn(final int n, final String s, final String s2, final String s3, final boolean b) {
        this.lastCodeOffset = this.code.length;
        final Item methodItem;
        int n2 = (methodItem = this.cw.newMethodItem(s, s2, s3, b)).intVal;
        if (this.currentBlock != null) {
            if (this.compute == 0 || this.compute == 1) {
                this.currentBlock.frame.execute(n, 0, this.cw, methodItem);
            }
            else {
                if (n2 == 0) {
                    n2 = Type.getArgumentsAndReturnSizes(s3);
                    methodItem.intVal = n2;
                }
                int n3;
                if (n == 184) {
                    n3 = this.stackSize - (n2 >> 2) + (n2 & 0x3) + 1;
                }
                else {
                    n3 = this.stackSize - (n2 >> 2) + (n2 & 0x3);
                }
                if (lIIllIlIIIllI(n3, this.maxStackSize)) {
                    this.maxStackSize = n3;
                }
                this.stackSize = n3;
            }
        }
        if (n == 185) {
            if (n2 == 0) {
                n2 = Type.getArgumentsAndReturnSizes(s3);
                methodItem.intVal = n2;
            }
            this.code.put12(185, methodItem.index).put11(n2 >> 2, 0);
            return;
        }
        this.code.put12(n, methodItem.index);
    }
    
    public final void visitInvokeDynamicInsn(final String s, final String s2, final Handle handle, final Object... array) {
        this.lastCodeOffset = this.code.length;
        final Item invokeDynamicItem;
        int intVal = (invokeDynamicItem = this.cw.newInvokeDynamicItem(s, s2, handle, array)).intVal;
        if (this.currentBlock != null) {
            if (this.compute == 0 || this.compute == 1) {
                this.currentBlock.frame.execute(186, 0, this.cw, invokeDynamicItem);
            }
            else {
                if (intVal == 0) {
                    intVal = Type.getArgumentsAndReturnSizes(s2);
                    invokeDynamicItem.intVal = intVal;
                }
                final int n;
                if (lIIllIlIIIllI(n = this.stackSize - (intVal >> 2) + (intVal & 0x3) + 1, this.maxStackSize)) {
                    this.maxStackSize = n;
                }
                this.stackSize = n;
            }
        }
        this.code.put12(186, invokeDynamicItem.index);
        this.code.putShort(0);
    }
    
    public final void visitJumpInsn(int n, final Label label) {
        final boolean b;
        n = ((b = lIIllIlIIIlll(n, 200)) ? (n - 33) : n);
        this.lastCodeOffset = this.code.length;
        Label label2 = null;
        if (this.currentBlock != null) {
            if (this.compute == 0) {
                this.currentBlock.frame.execute(n, 0, null, null);
                final Label first = label.getFirst();
                first.status |= 0x10;
                this.addSuccessor(0, label);
                if (lIIllIIlllIlI(n, 167)) {
                    label2 = new Label();
                }
            }
            else if (this.compute == 1) {
                this.currentBlock.frame.execute(n, 0, null, null);
            }
            else if (n == 168) {
                if ((label.status & 0x200) == 0x0) {
                    label.status |= 0x200;
                    ++this.subroutines;
                }
                final Label currentBlock = this.currentBlock;
                currentBlock.status |= 0x80;
                this.addSuccessor(this.stackSize + 1, label);
                label2 = new Label();
            }
            else {
                this.addSuccessor(this.stackSize += Frame.SIZE[n], label);
            }
        }
        if ((label.status & 0x2) != 0x0 && label.position - this.code.length < -32768) {
            if (n == 167) {
                this.code.putByte(200);
            }
            else if (n == 168) {
                this.code.putByte(201);
            }
            else {
                if (label2 != null) {
                    final Label label3 = label2;
                    label3.status |= 0x10;
                }
                this.code.putByte(lIIllIlIIlIll(n, 166) ? ((n + 1 ^ 0x1) - 1) : (n ^ 0x1));
                this.code.putShort(8);
                this.code.putByte(200);
            }
            label.put$1f42ce97(this.code, this.code.length - 1, true);
        }
        else if (b) {
            this.code.putByte(n + 33);
            label.put$1f42ce97(this.code, this.code.length - 1, true);
        }
        else {
            this.code.putByte(n);
            label.put$1f42ce97(this.code, this.code.length - 1, false);
        }
        if (this.currentBlock != null) {
            if (label2 != null) {
                this.visitLabel(label2);
            }
            if (n == 167) {
                this.noSuccessor();
            }
        }
    }
    
    public final void visitLabel(final Label owner) {
        final ClassWriter cw = this.cw;
        cw.hasAsmInsns |= owner.resolve$3a297a34(this.code.length, this.code.data);
        if ((owner.status & 0x1) != 0x0) {
            return;
        }
        if (this.compute == 0) {
            if (this.currentBlock != null) {
                if (owner.position == this.currentBlock.position) {
                    final Label currentBlock = this.currentBlock;
                    currentBlock.status |= (owner.status & 0x10);
                    owner.frame = this.currentBlock.frame;
                    return;
                }
                this.addSuccessor(0, owner);
            }
            this.currentBlock = owner;
            if (owner.frame == null) {
                owner.frame = new Frame();
                owner.frame.owner = owner;
            }
            if (this.previousBlock != null) {
                if (owner.position == this.previousBlock.position) {
                    final Label previousBlock = this.previousBlock;
                    previousBlock.status |= (owner.status & 0x10);
                    owner.frame = this.previousBlock.frame;
                    this.currentBlock = this.previousBlock;
                    return;
                }
                this.previousBlock.successor = owner;
            }
            this.previousBlock = owner;
            return;
        }
        if (this.compute != 1) {
            if (this.compute == 2) {
                if (this.currentBlock != null) {
                    this.currentBlock.outputStackMax = this.maxStackSize;
                    this.addSuccessor(this.stackSize, owner);
                }
                this.currentBlock = owner;
                this.stackSize = 0;
                this.maxStackSize = 0;
                if (this.previousBlock != null) {
                    this.previousBlock.successor = owner;
                }
                this.previousBlock = owner;
            }
            return;
        }
        if (this.currentBlock == null) {
            this.currentBlock = owner;
            return;
        }
        this.currentBlock.frame.owner = owner;
    }
    
    public final void visitLdcInsn(final Object o) {
        this.lastCodeOffset = this.code.length;
        final Item constItem = this.cw.newConstItem(o);
        if (this.currentBlock != null) {
            if (this.compute == 0 || this.compute == 1) {
                this.currentBlock.frame.execute(18, 0, this.cw, constItem);
            }
            else {
                int n;
                if (!lIIllIIlllIlI(constItem.type, 5) || constItem.type == 6) {
                    n = this.stackSize + 2;
                }
                else {
                    n = this.stackSize + 1;
                }
                if (lIIllIlIIIllI(n, this.maxStackSize)) {
                    this.maxStackSize = n;
                }
                this.stackSize = n;
            }
        }
        final int index = constItem.index;
        if (!lIIllIIlllIlI(constItem.type, 5) || constItem.type == 6) {
            this.code.put12(20, index);
            return;
        }
        if (lIIllIlIIIlll(index, 256)) {
            this.code.put12(19, index);
            return;
        }
        this.code.put11(18, index);
    }
    
    public final void visitIincInsn(final int n, final int n2) {
        this.lastCodeOffset = this.code.length;
        if (this.currentBlock != null && (this.compute == 0 || this.compute == 1)) {
            this.currentBlock.frame.execute(132, n, null, null);
        }
        final int maxLocals;
        if (lIIllIIlllIlI(this.compute, 3) && lIIllIlIIIllI(maxLocals = n + 1, this.maxLocals)) {
            this.maxLocals = maxLocals;
        }
        if (!lIIllIlIIlIll(n, 255) || !lIIllIlIIlIll(n2, 127) || n2 < -128) {
            this.code.putByte(196).put12(132, n).putShort(n2);
            return;
        }
        this.code.putByte(132).put11(n, n2);
    }
    
    public final void visitTableSwitchInsn(int i, final int n, final Label label, final Label... array) {
        this.lastCodeOffset = this.code.length;
        final int length = this.code.length;
        this.code.putByte(170);
        this.code.putByteArray(null, 0, (4 - this.code.length % 4) % 4);
        label.put$1f42ce97(this.code, length, true);
        this.code.putInt(i).putInt(n);
        for (i = 0; i < array.length; ++i) {
            array[i].put$1f42ce97(this.code, length, true);
        }
        this.visitSwitchInsn(label, array);
    }
    
    public final void visitLookupSwitchInsn(final Label label, final int[] array, final Label[] array2) {
        this.lastCodeOffset = this.code.length;
        final int length = this.code.length;
        this.code.putByte(171);
        this.code.putByteArray(null, 0, (4 - this.code.length % 4) % 4);
        label.put$1f42ce97(this.code, length, true);
        this.code.putInt(array2.length);
        for (int i = 0; i < array2.length; ++i) {
            this.code.putInt(array[i]);
            array2[i].put$1f42ce97(this.code, length, true);
        }
        this.visitSwitchInsn(label, array2);
    }
    
    private void visitSwitchInsn(final Label label, final Label[] array) {
        if (this.currentBlock != null) {
            if (this.compute == 0) {
                this.currentBlock.frame.execute(171, 0, null, null);
                this.addSuccessor(0, label);
                final Label first = label.getFirst();
                first.status |= 0x10;
                for (int i = 0; i < array.length; ++i) {
                    this.addSuccessor(0, array[i]);
                    final Label first2 = array[i].getFirst();
                    first2.status |= 0x10;
                }
            }
            else {
                this.addSuccessor(--this.stackSize, label);
                for (int j = 0; j < array.length; ++j) {
                    this.addSuccessor(this.stackSize, array[j]);
                }
            }
            this.noSuccessor();
        }
    }
    
    public final void visitMultiANewArrayInsn(final String s, final int n) {
        this.lastCodeOffset = this.code.length;
        final Item classItem = this.cw.newClassItem(s);
        if (this.currentBlock != null) {
            if (this.compute == 0 || this.compute == 1) {
                this.currentBlock.frame.execute(197, n, this.cw, classItem);
            }
            else {
                this.stackSize += 1 - n;
            }
        }
        this.code.put12(197, classItem.index).putByte(n);
    }
    
    public final AnnotationVisitor visitInsnAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        final ByteVector byteVector = new ByteVector();
        AnnotationWriter.putTarget((n & 0xFF0000FF) | this.lastCodeOffset << 8, typePath, byteVector);
        byteVector.putShort(this.cw.newUTF8(s)).putShort(0);
        final ClassWriter cw = this.cw;
        final boolean b2 = true;
        final ByteVector byteVector2 = byteVector;
        final AnnotationWriter annotationWriter = new AnnotationWriter(cw, b2, byteVector2, byteVector2, byteVector.length - 2);
        if (b) {
            annotationWriter.next = this.ctanns;
            this.ctanns = annotationWriter;
        }
        else {
            annotationWriter.next = this.ictanns;
            this.ictanns = annotationWriter;
        }
        return annotationWriter;
    }
    
    public final void visitTryCatchBlock(final Label start, final Label end, final Label handler, final String desc) {
        ++this.handlerCount;
        final Handler lastHandler;
        (lastHandler = new Handler()).start = start;
        lastHandler.end = end;
        lastHandler.handler = handler;
        lastHandler.desc = desc;
        lastHandler.type = ((desc != null) ? this.cw.newClass(desc) : 0);
        if (this.lastHandler == null) {
            this.firstHandler = lastHandler;
        }
        else {
            this.lastHandler.next = lastHandler;
        }
        this.lastHandler = lastHandler;
    }
    
    public final AnnotationVisitor visitTryCatchAnnotation(final int n, final TypePath typePath, final String s, final boolean b) {
        final ByteVector byteVector = new ByteVector();
        AnnotationWriter.putTarget(n, typePath, byteVector);
        byteVector.putShort(this.cw.newUTF8(s)).putShort(0);
        final ClassWriter cw = this.cw;
        final boolean b2 = true;
        final ByteVector byteVector2 = byteVector;
        final AnnotationWriter annotationWriter = new AnnotationWriter(cw, b2, byteVector2, byteVector2, byteVector.length - 2);
        if (b) {
            annotationWriter.next = this.ctanns;
            this.ctanns = annotationWriter;
        }
        else {
            annotationWriter.next = this.ictanns;
            this.ictanns = annotationWriter;
        }
        return annotationWriter;
    }
    
    public final void visitLocalVariable(final String s, final String s2, final String s3, final Label label, final Label label2, final int n) {
        if (s3 != null) {
            if (this.localVarType == null) {
                this.localVarType = new ByteVector();
            }
            ++this.localVarTypeCount;
            this.localVarType.putShort(label.position).putShort(label2.position - label.position).putShort(this.cw.newUTF8(s)).putShort(this.cw.newUTF8(s3)).putShort(n);
        }
        if (this.localVar == null) {
            this.localVar = new ByteVector();
        }
        ++this.localVarCount;
        this.localVar.putShort(label.position).putShort(label2.position - label.position).putShort(this.cw.newUTF8(s)).putShort(this.cw.newUTF8(s2)).putShort(n);
        if (lIIllIIlllIlI(this.compute, 3)) {
            final char char1 = s2.charAt(0);
            final int maxLocals;
            if (lIIllIlIIIllI(maxLocals = n + ((!lIIllIIlllIlI(char1, 74) || char1 == 'D') ? 2 : 1), this.maxLocals)) {
                this.maxLocals = maxLocals;
            }
        }
    }
    
    public final AnnotationVisitor visitLocalVariableAnnotation(int i, final TypePath typePath, final Label[] array, final Label[] array2, final int[] array3, final String s, final boolean b) {
        final ByteVector byteVector;
        (byteVector = new ByteVector()).putByte(i >>> 24).putShort(array.length);
        for (i = 0; i < array.length; ++i) {
            byteVector.putShort(array[i].position).putShort(array2[i].position - array[i].position).putShort(array3[i]);
        }
        if (typePath == null) {
            byteVector.putByte(0);
        }
        else {
            i = typePath.b[typePath.offset] * 2 + 1;
            byteVector.putByteArray(typePath.b, typePath.offset, i);
        }
        byteVector.putShort(this.cw.newUTF8(s)).putShort(0);
        final ClassWriter cw = this.cw;
        final boolean b2 = true;
        final ByteVector byteVector2 = byteVector;
        final AnnotationWriter annotationWriter = new AnnotationWriter(cw, b2, byteVector2, byteVector2, byteVector.length - 2);
        if (b) {
            annotationWriter.next = this.ctanns;
            this.ctanns = annotationWriter;
        }
        else {
            annotationWriter.next = this.ictanns;
            this.ictanns = annotationWriter;
        }
        return annotationWriter;
    }
    
    public final void visitLineNumber(final int n, final Label label) {
        if (this.lineNumber == null) {
            this.lineNumber = new ByteVector();
        }
        ++this.lineNumberCount;
        this.lineNumber.putShort(label.position);
        this.lineNumber.putShort(n);
    }
    
    public final void visitMaxs(int maxStack, int i) {
        if (this.compute == 0) {
            for (Handler handler = this.firstHandler; handler != null; handler = handler.next) {
                Label label = handler.start.getFirst();
                final Label first = handler.handler.getFirst();
                final Label first2 = handler.end.getFirst();
                final int info = 0x1700000 | this.cw.addType((handler.desc == null) ? MethodWriter.llIllIlllIl[4] : handler.desc);
                final Label label2 = first;
                label2.status |= 0x10;
                while (lIIllIlIIllII(label, first2)) {
                    final Edge successors;
                    (successors = new Edge()).info = info;
                    successors.successor = first;
                    successors.next = label.successors;
                    label.successors = successors;
                    label = label.successor;
                }
            }
            final Frame frame;
            (frame = this.labels.frame).initInputFrame(this.cw, this.access, Type.getArgumentTypes(this.descriptor), this.maxLocals);
            this.visitFrame(frame);
            int max = 0;
            Label next = this.labels;
            while (next != null) {
                final Label label3 = next;
                next = next.next;
                label3.next = null;
                final Frame frame2 = label3.frame;
                if ((label3.status & 0x10) != 0x0) {
                    final Label label4 = label3;
                    label4.status |= 0x20;
                }
                final Label label5 = label3;
                label5.status |= 0x40;
                final int n;
                if (lIIllIlIIIllI(n = frame2.inputStack.length + label3.outputStackMax, max)) {
                    max = n;
                }
                for (Edge edge = label3.successors; edge != null; edge = edge.next) {
                    final Label first3 = edge.successor.getFirst();
                    if (frame2.merge(this.cw, first3.frame, edge.info) && first3.next == null) {
                        first3.next = next;
                        next = first3;
                    }
                }
            }
            for (Label label6 = this.labels; label6 != null; label6 = label6.successor) {
                final Frame frame3 = label6.frame;
                if ((label6.status & 0x20) != 0x0) {
                    this.visitFrame(frame3);
                }
                if ((label6.status & 0x40) == 0x0) {
                    final Label successor = label6.successor;
                    final int position = label6.position;
                    if (lIIllIlIIIlll(maxStack = ((successor == null) ? this.code.length : successor.position) - 1, position)) {
                        max = Math.max(max, 1);
                        for (i = position; i < maxStack; ++i) {
                            this.code.data[i] = 0;
                        }
                        this.code.data[maxStack] = -65;
                        this.startFrame(position, 0, 1);
                        this.frame[3] = (0x1700000 | this.cw.addType(MethodWriter.llIllIlllIl[5]));
                        this.endFrame();
                        this.firstHandler = Handler.remove(this.firstHandler, label6, successor);
                    }
                }
            }
            Handler handler2 = this.firstHandler;
            this.handlerCount = 0;
            while (handler2 != null) {
                ++this.handlerCount;
                handler2 = handler2.next;
            }
            this.maxStack = max;
            return;
        }
        if (this.compute == 2) {
            for (Handler handler3 = this.firstHandler; handler3 != null; handler3 = handler3.next) {
                Label label7 = handler3.start;
                final Label handler4 = handler3.handler;
                while (lIIllIlIIllII(label7, handler3.end)) {
                    final Edge edge2;
                    (edge2 = new Edge()).info = Integer.MAX_VALUE;
                    edge2.successor = handler4;
                    if ((label7.status & 0x80) == 0x0) {
                        edge2.next = label7.successors;
                        label7.successors = edge2;
                    }
                    else {
                        edge2.next = label7.successors.next.next;
                        label7.successors.next.next = edge2;
                    }
                    label7 = label7.successor;
                }
            }
            if (this.subroutines > 0) {
                int n2 = 0;
                this.labels.visitSubroutine(null, 1L, this.subroutines);
                for (Label label8 = this.labels; label8 != null; label8 = label8.successor) {
                    final Label successor2;
                    if ((label8.status & 0x80) != 0x0 && ((successor2 = label8.successors.next.successor).status & 0x400) == 0x0) {
                        ++n2;
                        successor2.visitSubroutine(null, n2 / 32L << 32 | 1L << n2 % 32, this.subroutines);
                    }
                }
                for (Label label9 = this.labels; label9 != null; label9 = label9.successor) {
                    if ((label9.status & 0x80) != 0x0) {
                        for (Label label10 = this.labels; label10 != null; label10 = label10.successor) {
                            final Label label11 = label10;
                            label11.status &= 0xFFFFF7FF;
                        }
                        label9.successors.next.successor.visitSubroutine(label9, 0L, this.subroutines);
                    }
                }
            }
            int n3 = 0;
            Label next2 = this.labels;
            while (next2 != null) {
                final Label label12 = next2;
                next2 = next2.next;
                final int inputStackTop;
                final int n4;
                if (lIIllIlIIIllI(n4 = (inputStackTop = label12.inputStackTop) + label12.outputStackMax, n3)) {
                    n3 = n4;
                }
                Edge edge3 = label12.successors;
                if ((label12.status & 0x80) != 0x0) {
                    edge3 = edge3.next;
                }
                while (edge3 != null) {
                    final Label successor3;
                    if (((successor3 = edge3.successor).status & 0x8) == 0x0) {
                        successor3.inputStackTop = ((edge3.info == Integer.MAX_VALUE) ? 1 : (inputStackTop + edge3.info));
                        final Label label13 = successor3;
                        label13.status |= 0x8;
                        successor3.next = next2;
                        next2 = successor3;
                    }
                    edge3 = edge3.next;
                }
            }
            this.maxStack = Math.max(maxStack, n3);
            return;
        }
        this.maxStack = maxStack;
        this.maxLocals = i;
    }
    
    public final void visitEnd() {
    }
    
    private void addSuccessor(final int info, final Label successor) {
        final Edge successors;
        (successors = new Edge()).info = info;
        successors.successor = successor;
        successors.next = this.currentBlock.successors;
        this.currentBlock.successors = successors;
    }
    
    private void noSuccessor() {
        if (this.compute == 0) {
            final Label previousBlock;
            (previousBlock = new Label()).frame = new Frame();
            (previousBlock.frame.owner = previousBlock).resolve$3a297a34(this.code.length, this.code.data);
            this.previousBlock.successor = previousBlock;
            this.previousBlock = previousBlock;
        }
        else {
            this.currentBlock.outputStackMax = this.maxStackSize;
        }
        if (lIIllIIlllIlI(this.compute, 1)) {
            this.currentBlock = null;
        }
    }
    
    private void visitFrame(final Frame frame) {
        int n = 0;
        int i = 0;
        int n2 = 0;
        final int[] inputLocals = frame.inputLocals;
        final int[] inputStack = frame.inputStack;
        for (int j = 0; j < inputLocals.length; ++j) {
            final int n3;
            if ((n3 = inputLocals[j]) == 16777216) {
                ++n;
            }
            else {
                i += n + 1;
                n = 0;
            }
            if (!lIIllIIlllIlI(n3, 16777220) || n3 == 16777219) {
                ++j;
            }
        }
        for (int k = 0; k < inputStack.length; ++k) {
            final int n4 = inputStack[k];
            ++n2;
            if (!lIIllIIlllIlI(n4, 16777220) || n4 == 16777219) {
                ++k;
            }
        }
        int startFrame = this.startFrame(frame.owner.position, i, n2);
        int n5 = 0;
        while (i > 0) {
            final int n6 = inputLocals[n5];
            this.frame[startFrame++] = n6;
            if (!lIIllIIlllIlI(n6, 16777220) || n6 == 16777219) {
                ++n5;
            }
            ++n5;
            --i;
        }
        for (int l = 0; l < inputStack.length; ++l) {
            final int n7 = inputStack[l];
            this.frame[startFrame++] = n7;
            if (!lIIllIIlllIlI(n7, 16777220) || n7 == 16777219) {
                ++l;
            }
        }
        this.endFrame();
    }
    
    private void visitImplicitFirstFrame() {
        int startFrame = this.startFrame(0, this.descriptor.length() + 1, 0);
        if ((this.access & 0x8) == 0x0) {
            if ((this.access & 0x80000) == 0x0) {
                final int[] frame = this.frame;
                final int n = 3;
                ++startFrame;
                frame[n] = (0x1700000 | this.cw.addType(this.cw.thisName));
            }
            else {
                final int[] frame2 = this.frame;
                final int n2 = 3;
                ++startFrame;
                frame2[n2] = 6;
            }
        }
        int n3 = 1;
        while (true) {
            final int n4 = n3;
            switch (this.descriptor.charAt(n3++)) {
                case 'B':
                case 'C':
                case 'I':
                case 'S':
                case 'Z': {
                    this.frame[startFrame++] = 1;
                    continue;
                }
                case 'F': {
                    this.frame[startFrame++] = 2;
                    continue;
                }
                case 'J': {
                    this.frame[startFrame++] = 4;
                    continue;
                }
                case 'D': {
                    this.frame[startFrame++] = 3;
                    continue;
                }
                case '[': {
                    while (this.descriptor.charAt(n3) == '[') {
                        ++n3;
                    }
                    if (this.descriptor.charAt(n3) == 'L') {
                        ++n3;
                        while (lIIllIIlllIlI(this.descriptor.charAt(n3), 59)) {
                            ++n3;
                        }
                    }
                    this.frame[startFrame++] = (0x1700000 | this.cw.addType(this.descriptor.substring(n4, ++n3)));
                    continue;
                }
                case 'L': {
                    while (lIIllIIlllIlI(this.descriptor.charAt(n3), 59)) {
                        ++n3;
                    }
                    this.frame[startFrame++] = (0x1700000 | this.cw.addType(this.descriptor.substring(n4 + 1, n3++)));
                    continue;
                }
                default: {
                    this.frame[1] = startFrame - 3;
                    this.endFrame();
                }
            }
        }
    }
    
    private int startFrame(final int n, final int n2, final int n3) {
        final int n4 = n2 + 3 + n3;
        if (this.frame == null || this.frame.length < n4) {
            this.frame = new int[n4];
        }
        this.frame[0] = n;
        this.frame[1] = n2;
        this.frame[2] = n3;
        return 3;
    }
    
    private void endFrame() {
        if (this.previousFrame != null) {
            if (this.stackMap == null) {
                this.stackMap = new ByteVector();
            }
            this.writeFrame();
            ++this.frameCount;
        }
        this.previousFrame = this.frame;
        this.frame = null;
    }
    
    private void writeFrame() {
        final int n = this.frame[1];
        final int n2 = this.frame[2];
        if ((this.cw.version & 0xFFFF) < 50) {
            this.stackMap.putShort(this.frame[0]).putShort(n);
            this.writeFrameTypes(3, n + 3);
            this.stackMap.putShort(n2);
            this.writeFrameTypes(n + 3, n + 3 + n2);
            return;
        }
        int n3 = this.previousFrame[1];
        int n4 = 255;
        int n5 = 0;
        int n6;
        if (this.frameCount == 0) {
            n6 = this.frame[0];
        }
        else {
            n6 = this.frame[0] - this.previousFrame[0] - 1;
        }
        if (n2 == 0) {
            switch (n5 = n - n3) {
                case -3:
                case -2:
                case -1: {
                    n4 = 248;
                    n3 = n;
                    break;
                }
                case 0: {
                    n4 = ((n6 < 64) ? 0 : 251);
                    break;
                }
                case 1:
                case 2:
                case 3: {
                    n4 = 252;
                    break;
                }
            }
        }
        else if (n == n3 && n2 == 1) {
            n4 = ((n6 < 63) ? 64 : 247);
        }
        if (lIIllIIlllIlI(n4, 255)) {
            int n7 = 3;
            for (int i = 0; i < n3; ++i) {
                if (lIIllIIlllIlI(this.frame[n7], this.previousFrame[n7])) {
                    n4 = 255;
                    break;
                }
                ++n7;
            }
        }
        switch (n4) {
            case 0: {
                this.stackMap.putByte(n6);
            }
            case 64: {
                this.stackMap.putByte(n6 + 64);
                this.writeFrameTypes(n + 3, n + 4);
            }
            case 247: {
                this.stackMap.putByte(247).putShort(n6);
                this.writeFrameTypes(n + 3, n + 4);
            }
            case 251: {
                this.stackMap.putByte(251).putShort(n6);
            }
            case 248: {
                this.stackMap.putByte(n5 + 251).putShort(n6);
            }
            case 252: {
                this.stackMap.putByte(n5 + 251).putShort(n6);
                this.writeFrameTypes(n3 + 3, n + 3);
            }
            default: {
                this.stackMap.putByte(255).putShort(n6).putShort(n);
                this.writeFrameTypes(3, n + 3);
                this.stackMap.putShort(n2);
                this.writeFrameTypes(n + 3, n + 3 + n2);
            }
        }
    }
    
    private void writeFrameTypes(int i, final int n) {
        while (i < n) {
            final int n3;
            final int n2;
            if ((n2 = ((n3 = this.frame[i]) & 0xF0000000)) == 0) {
                final int n4 = n3 & 0xFFFFF;
                switch (n3 & 0xFF00000) {
                    case 24117248: {
                        this.stackMap.putByte(7).putShort(this.cw.newClass(this.cw.typeTable[n4].strVal1));
                        break;
                    }
                    case 25165824: {
                        this.stackMap.putByte(8).putShort(this.cw.typeTable[n4].intVal);
                        break;
                    }
                    default: {
                        this.stackMap.putByte(n4);
                        break;
                    }
                }
            }
            else {
                final StringBuilder sb = new StringBuilder();
                int n5 = n2 >> 28;
                while (n5-- > 0) {
                    sb.append('[');
                }
                if ((n3 & 0xFF00000) == 0x1700000) {
                    sb.append('L');
                    sb.append(this.cw.typeTable[n3 & 0xFFFFF].strVal1);
                    sb.append(';');
                }
                else {
                    switch (n3 & 0xF) {
                        case 1: {
                            sb.append('I');
                            break;
                        }
                        case 2: {
                            sb.append('F');
                            break;
                        }
                        case 3: {
                            sb.append('D');
                            break;
                        }
                        case 9: {
                            sb.append('Z');
                            break;
                        }
                        case 10: {
                            sb.append('B');
                            break;
                        }
                        case 11: {
                            sb.append('C');
                            break;
                        }
                        case 12: {
                            sb.append('S');
                            break;
                        }
                        default: {
                            sb.append('J');
                            break;
                        }
                    }
                }
                this.stackMap.putByte(7).putShort(this.cw.newClass(String.valueOf(sb)));
            }
            ++i;
        }
    }
    
    private void writeFrameType(final Object o) {
        if (o instanceof String) {
            this.stackMap.putByte(7).putShort(this.cw.newClass((String)o));
            return;
        }
        if (o instanceof Integer) {
            this.stackMap.putByte((int)o);
            return;
        }
        this.stackMap.putByte(8).putShort(((Label)o).position);
    }
    
    final int getSize() {
        if (this.classReaderOffset != 0) {
            return 6 + this.classReaderLength;
        }
        int n = 8;
        if (this.code.length > 0) {
            if (lIIllIlIIIllI(this.code.length, 65535)) {
                throw new RuntimeException(MethodWriter.llIllIlllIl[6]);
            }
            this.cw.newUTF8(MethodWriter.llIllIlllIl[7]);
            n = 8 + (18 + this.code.length + 8 * this.handlerCount);
            if (this.localVar != null) {
                this.cw.newUTF8(MethodWriter.llIllIlllIl[8]);
                n += 8 + this.localVar.length;
            }
            if (this.localVarType != null) {
                this.cw.newUTF8(MethodWriter.llIllIlllIl[9]);
                n += 8 + this.localVarType.length;
            }
            if (this.lineNumber != null) {
                this.cw.newUTF8(MethodWriter.llIllIlllIl[10]);
                n += 8 + this.lineNumber.length;
            }
            if (this.stackMap != null) {
                this.cw.newUTF8(lIIllIlIIIlll(this.cw.version & 0xFFFF, 50) ? MethodWriter.llIllIlllIl[11] : MethodWriter.llIllIlllIl[12]);
                n += 8 + this.stackMap.length;
            }
            if (this.ctanns != null) {
                this.cw.newUTF8(MethodWriter.llIllIlllIl[13]);
                n += 8 + this.ctanns.getSize();
            }
            if (this.ictanns != null) {
                this.cw.newUTF8(MethodWriter.llIllIlllIl[14]);
                n += 8 + this.ictanns.getSize();
            }
        }
        if (this.exceptionCount > 0) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[15]);
            n += 8 + 2 * this.exceptionCount;
        }
        if ((this.access & 0x1000) != 0x0 && (!lIIllIlIIIlll(this.cw.version & 0xFFFF, 49) || (this.access & 0x40000) != 0x0)) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[16]);
            n += 6;
        }
        if ((this.access & 0x20000) != 0x0) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[17]);
            n += 6;
        }
        if (this.signature != null) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[18]);
            this.cw.newUTF8(this.signature);
            n += 8;
        }
        if (this.methodParameters != null) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[19]);
            n += 7 + this.methodParameters.length;
        }
        if (this.annd != null) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[20]);
            n += 6 + this.annd.length;
        }
        if (this.anns != null) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[21]);
            n += 8 + this.anns.getSize();
        }
        if (this.ianns != null) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[22]);
            n += 8 + this.ianns.getSize();
        }
        if (this.tanns != null) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[23]);
            n += 8 + this.tanns.getSize();
        }
        if (this.itanns != null) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[24]);
            n += 8 + this.itanns.getSize();
        }
        if (this.panns != null) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[25]);
            n += 7 + 2 * (this.panns.length - this.synthetics);
            for (int n2 = this.panns.length - 1; lIIllIlIIIlll(n2, this.synthetics); --n2) {
                n += ((this.panns[n2] == null) ? 0 : this.panns[n2].getSize());
            }
        }
        if (this.ipanns != null) {
            this.cw.newUTF8(MethodWriter.llIllIlllIl[26]);
            n += 7 + 2 * (this.ipanns.length - this.synthetics);
            for (int n3 = this.ipanns.length - 1; lIIllIlIIIlll(n3, this.synthetics); --n3) {
                n += ((this.ipanns[n3] == null) ? 0 : this.ipanns[n3].getSize());
            }
        }
        if (this.attrs != null) {
            n += this.attrs.getSize$51cf92e0(this.cw);
        }
        return n;
    }
    
    final void put(final ByteVector byteVector) {
        byteVector.putShort(this.access & ~(0xE0000 | (this.access & 0x40000) / 64)).putShort(this.name).putShort(this.desc);
        if (this.classReaderOffset != 0) {
            byteVector.putByteArray(this.cw.cr.b, this.classReaderOffset, this.classReaderLength);
            return;
        }
        int n = 0;
        if (this.code.length > 0) {
            ++n;
        }
        if (this.exceptionCount > 0) {
            ++n;
        }
        if ((this.access & 0x1000) != 0x0 && (!lIIllIlIIIlll(this.cw.version & 0xFFFF, 49) || (this.access & 0x40000) != 0x0)) {
            ++n;
        }
        if ((this.access & 0x20000) != 0x0) {
            ++n;
        }
        if (this.signature != null) {
            ++n;
        }
        if (this.methodParameters != null) {
            ++n;
        }
        if (this.annd != null) {
            ++n;
        }
        if (this.anns != null) {
            ++n;
        }
        if (this.ianns != null) {
            ++n;
        }
        if (this.tanns != null) {
            ++n;
        }
        if (this.itanns != null) {
            ++n;
        }
        if (this.panns != null) {
            ++n;
        }
        if (this.ipanns != null) {
            ++n;
        }
        if (this.attrs != null) {
            n += this.attrs.getCount();
        }
        byteVector.putShort(n);
        if (this.code.length > 0) {
            int n2 = 12 + this.code.length + 8 * this.handlerCount;
            if (this.localVar != null) {
                n2 += 8 + this.localVar.length;
            }
            if (this.localVarType != null) {
                n2 += 8 + this.localVarType.length;
            }
            if (this.lineNumber != null) {
                n2 += 8 + this.lineNumber.length;
            }
            if (this.stackMap != null) {
                n2 += 8 + this.stackMap.length;
            }
            if (this.ctanns != null) {
                n2 += 8 + this.ctanns.getSize();
            }
            if (this.ictanns != null) {
                n2 += 8 + this.ictanns.getSize();
            }
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[27])).putInt(n2);
            byteVector.putShort(this.maxStack).putShort(this.maxLocals);
            byteVector.putInt(this.code.length).putByteArray(this.code.data, 0, this.code.length);
            byteVector.putShort(this.handlerCount);
            if (this.handlerCount > 0) {
                for (Handler handler = this.firstHandler; handler != null; handler = handler.next) {
                    byteVector.putShort(handler.start.position).putShort(handler.end.position).putShort(handler.handler.position).putShort(handler.type);
                }
            }
            int n3 = 0;
            if (this.localVar != null) {
                ++n3;
            }
            if (this.localVarType != null) {
                ++n3;
            }
            if (this.lineNumber != null) {
                ++n3;
            }
            if (this.stackMap != null) {
                ++n3;
            }
            if (this.ctanns != null) {
                ++n3;
            }
            if (this.ictanns != null) {
                ++n3;
            }
            byteVector.putShort(n3);
            if (this.localVar != null) {
                byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[28]));
                byteVector.putInt(this.localVar.length + 2).putShort(this.localVarCount);
                byteVector.putByteArray(this.localVar.data, 0, this.localVar.length);
            }
            if (this.localVarType != null) {
                byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[29]));
                byteVector.putInt(this.localVarType.length + 2).putShort(this.localVarTypeCount);
                byteVector.putByteArray(this.localVarType.data, 0, this.localVarType.length);
            }
            if (this.lineNumber != null) {
                byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[30]));
                byteVector.putInt(this.lineNumber.length + 2).putShort(this.lineNumberCount);
                byteVector.putByteArray(this.lineNumber.data, 0, this.lineNumber.length);
            }
            if (this.stackMap != null) {
                byteVector.putShort(this.cw.newUTF8(lIIllIlIIIlll(this.cw.version & 0xFFFF, 50) ? MethodWriter.llIllIlllIl[31] : MethodWriter.llIllIlllIl[32]));
                byteVector.putInt(this.stackMap.length + 2).putShort(this.frameCount);
                byteVector.putByteArray(this.stackMap.data, 0, this.stackMap.length);
            }
            if (this.ctanns != null) {
                byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[33]));
                this.ctanns.put(byteVector);
            }
            if (this.ictanns != null) {
                byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[34]));
                this.ictanns.put(byteVector);
            }
        }
        if (this.exceptionCount > 0) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[35])).putInt(2 * this.exceptionCount + 2);
            byteVector.putShort(this.exceptionCount);
            for (int i = 0; i < this.exceptionCount; ++i) {
                byteVector.putShort(this.exceptions[i]);
            }
        }
        if ((this.access & 0x1000) != 0x0 && (!lIIllIlIIIlll(this.cw.version & 0xFFFF, 49) || (this.access & 0x40000) != 0x0)) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[36])).putInt(0);
        }
        if ((this.access & 0x20000) != 0x0) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[37])).putInt(0);
        }
        if (this.signature != null) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[38])).putInt(2).putShort(this.cw.newUTF8(this.signature));
        }
        if (this.methodParameters != null) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[39]));
            byteVector.putInt(this.methodParameters.length + 1).putByte(this.methodParametersCount);
            byteVector.putByteArray(this.methodParameters.data, 0, this.methodParameters.length);
        }
        if (this.annd != null) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[40]));
            byteVector.putInt(this.annd.length);
            byteVector.putByteArray(this.annd.data, 0, this.annd.length);
        }
        if (this.anns != null) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[41]));
            this.anns.put(byteVector);
        }
        if (this.ianns != null) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[42]));
            this.ianns.put(byteVector);
        }
        if (this.tanns != null) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[43]));
            this.tanns.put(byteVector);
        }
        if (this.itanns != null) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[44]));
            this.itanns.put(byteVector);
        }
        if (this.panns != null) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[45]));
            AnnotationWriter.put(this.panns, this.synthetics, byteVector);
        }
        if (this.ipanns != null) {
            byteVector.putShort(this.cw.newUTF8(MethodWriter.llIllIlllIl[46]));
            AnnotationWriter.put(this.ipanns, this.synthetics, byteVector);
        }
        if (this.attrs != null) {
            this.attrs.put$2136a1dd(this.cw, byteVector);
        }
    }
    
    static {
        lIIllIIIllIll();
    }
    
    private static void lIIllIIIllIll() {
        (llIllIlllIl = new String[47])[0] = "<init>";
        MethodWriter.llIllIlllIl[1] = "Ljava/lang/Synthetic;";
        MethodWriter.llIllIlllIl[2] = "";
        MethodWriter.llIllIlllIl[3] = "";
        MethodWriter.llIllIlllIl[4] = "java/lang/Throwable";
        MethodWriter.llIllIlllIl[5] = "java/lang/Throwable";
        MethodWriter.llIllIlllIl[6] = "Method code too large!";
        MethodWriter.llIllIlllIl[7] = "Code";
        MethodWriter.llIllIlllIl[8] = "LocalVariableTable";
        MethodWriter.llIllIlllIl[9] = "LocalVariableTypeTable";
        MethodWriter.llIllIlllIl[10] = "LineNumberTable";
        MethodWriter.llIllIlllIl[11] = "StackMapTable";
        MethodWriter.llIllIlllIl[12] = "StackMap";
        MethodWriter.llIllIlllIl[13] = "RuntimeVisibleTypeAnnotations";
        MethodWriter.llIllIlllIl[14] = "RuntimeInvisibleTypeAnnotations";
        MethodWriter.llIllIlllIl[15] = "Exceptions";
        MethodWriter.llIllIlllIl[16] = "Synthetic";
        MethodWriter.llIllIlllIl[17] = "Deprecated";
        MethodWriter.llIllIlllIl[18] = "Signature";
        MethodWriter.llIllIlllIl[19] = "MethodParameters";
        MethodWriter.llIllIlllIl[20] = "AnnotationDefault";
        MethodWriter.llIllIlllIl[21] = "RuntimeVisibleAnnotations";
        MethodWriter.llIllIlllIl[22] = "RuntimeInvisibleAnnotations";
        MethodWriter.llIllIlllIl[23] = "RuntimeVisibleTypeAnnotations";
        MethodWriter.llIllIlllIl[24] = "RuntimeInvisibleTypeAnnotations";
        MethodWriter.llIllIlllIl[25] = "RuntimeVisibleParameterAnnotations";
        MethodWriter.llIllIlllIl[26] = "RuntimeInvisibleParameterAnnotations";
        MethodWriter.llIllIlllIl[27] = "Code";
        MethodWriter.llIllIlllIl[28] = "LocalVariableTable";
        MethodWriter.llIllIlllIl[29] = "LocalVariableTypeTable";
        MethodWriter.llIllIlllIl[30] = "LineNumberTable";
        MethodWriter.llIllIlllIl[31] = "StackMapTable";
        MethodWriter.llIllIlllIl[32] = "StackMap";
        MethodWriter.llIllIlllIl[33] = "RuntimeVisibleTypeAnnotations";
        MethodWriter.llIllIlllIl[34] = "RuntimeInvisibleTypeAnnotations";
        MethodWriter.llIllIlllIl[35] = "Exceptions";
        MethodWriter.llIllIlllIl[36] = "Synthetic";
        MethodWriter.llIllIlllIl[37] = "Deprecated";
        MethodWriter.llIllIlllIl[38] = "Signature";
        MethodWriter.llIllIlllIl[39] = "MethodParameters";
        MethodWriter.llIllIlllIl[40] = "AnnotationDefault";
        MethodWriter.llIllIlllIl[41] = "RuntimeVisibleAnnotations";
        MethodWriter.llIllIlllIl[42] = "RuntimeInvisibleAnnotations";
        MethodWriter.llIllIlllIl[43] = "RuntimeVisibleTypeAnnotations";
        MethodWriter.llIllIlllIl[44] = "RuntimeInvisibleTypeAnnotations";
        MethodWriter.llIllIlllIl[45] = "RuntimeVisibleParameterAnnotations";
        MethodWriter.llIllIlllIl[46] = "RuntimeInvisibleParameterAnnotations";
    }
    
    private static String lIIllIIIIIIII(final String s, final String s2) {
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
    
    private static String lIIlIllllllll(String s, final String s2) {
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
    
    private static String lIIlIlllllllI(final String s, final String s2) {
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
    
    private static boolean lIIllIlIIIlll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIllIlIIlIll(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lIIllIlIIIllI(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIIllIlIIllII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIllIlIIIlIl(final int n) {
        return n < 0;
    }
    
    private static boolean lIIllIIlllIII(final int n) {
        return n > 0;
    }
    
    private static boolean lIIllIIlllIlI(final int n, final int n2) {
        return n != n2;
    }
}
