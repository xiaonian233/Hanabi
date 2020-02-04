package org.spongepowered.asm.lib.tree.analysis;

import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.lib.tree.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class Frame<V extends Value>
{
    V returnValue;
    private V[] values;
    public int locals;
    public int top;
    private static final String[] lIlIlIIIlI;
    
    public Frame(final int locals, final int n) {
        super();
        this.values = new Value[locals + n];
        this.locals = locals;
    }
    
    public Frame(final Frame<? extends V> frame) {
        this(frame.locals, frame.values.length - frame.locals);
        this.init(frame);
    }
    
    public final Frame<V> init(final Frame<? extends V> frame) {
        this.returnValue = (V)frame.returnValue;
        System.arraycopy(frame.values, 0, this.values, 0, this.values.length);
        this.top = frame.top;
        return this;
    }
    
    private void setReturn(final V returnValue) {
        this.returnValue = returnValue;
    }
    
    private int getLocals() {
        return this.locals;
    }
    
    private int getMaxStackSize() {
        return this.values.length - this.locals;
    }
    
    public final V getLocal(final int n) throws IndexOutOfBoundsException {
        if (lllllIIIlIl(n, this.locals)) {
            throw new IndexOutOfBoundsException(Frame.lIlIlIIIlI[0]);
        }
        return (V)this.values[n];
    }
    
    public final void setLocal(final int n, final V v) throws IndexOutOfBoundsException {
        if (lllllIIIlIl(n, this.locals)) {
            throw new IndexOutOfBoundsException(String.valueOf(new StringBuilder().append(Frame.lIlIlIIIlI[1]).append(n)));
        }
        this.values[n] = v;
    }
    
    private int getStackSize() {
        return this.top;
    }
    
    public final V getStack(final int n) throws IndexOutOfBoundsException {
        return (V)this.values[n + this.locals];
    }
    
    private void clearStack() {
        this.top = 0;
    }
    
    public V pop() throws IndexOutOfBoundsException {
        if (this.top == 0) {
            throw new IndexOutOfBoundsException(Frame.lIlIlIIIlI[2]);
        }
        final Value[] values = this.values;
        final int top = this.top - 1;
        this.top = top;
        return (V)values[top + this.locals];
    }
    
    public void push(final V v) throws IndexOutOfBoundsException {
        if (lllllIIIlIl(this.top + this.locals, this.values.length)) {
            throw new IndexOutOfBoundsException(Frame.lIlIlIIIlI[3]);
        }
        this.values[this.top++ + this.locals] = v;
    }
    
    public void execute(final AbstractInsnNode abstractInsnNode, final Interpreter<V> interpreter) throws AnalyzerException {
        switch (abstractInsnNode.getOpcode()) {
            case 0: {}
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18: {
                this.push(interpreter.newOperation(abstractInsnNode));
            }
            case 21:
            case 22:
            case 23:
            case 24:
            case 25: {
                this.push(interpreter.copyOperation(abstractInsnNode, this.getLocal(((VarInsnNode)abstractInsnNode).var)));
            }
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53: {
                this.push(interpreter.binaryOperation(abstractInsnNode, this.pop(), this.pop()));
            }
            case 54:
            case 55:
            case 56:
            case 57:
            case 58: {
                final Value copyOperation = interpreter.copyOperation(abstractInsnNode, this.pop());
                final int var = ((VarInsnNode)abstractInsnNode).var;
                this.setLocal(var, (V)copyOperation);
                if (copyOperation.getSize() == 2) {
                    this.setLocal(var + 1, interpreter.newValue(null));
                }
                if (var > 0) {
                    final Value local;
                    if ((local = this.getLocal(var - 1)) != null && local.getSize() == 2) {
                        this.setLocal(var - 1, interpreter.newValue(null));
                    }
                    return;
                }
                break;
            }
            case 79:
            case 80:
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86: {
                interpreter.ternaryOperation(abstractInsnNode, this.pop(), this.pop(), this.pop());
            }
            case 87: {
                if (this.pop().getSize() == 2) {
                    throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[4]);
                }
                break;
            }
            case 88: {
                if (this.pop().getSize() == 1 && lllllIIlIlI(this.pop().getSize(), 1)) {
                    throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[5]);
                }
                break;
            }
            case 89: {
                final Value pop;
                if (lllllIIlIlI((pop = this.pop()).getSize(), 1)) {
                    throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[6]);
                }
                this.push((V)pop);
                this.push(interpreter.copyOperation(abstractInsnNode, (V)pop));
            }
            case 90: {
                final Value pop2 = this.pop();
                final Value pop3 = this.pop();
                if (pop2.getSize() != 1 || lllllIIlIlI(pop3.getSize(), 1)) {
                    throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[7]);
                }
                this.push(interpreter.copyOperation(abstractInsnNode, (V)pop2));
                this.push((V)pop3);
                this.push((V)pop2);
            }
            case 91: {
                final Value pop4;
                if ((pop4 = this.pop()).getSize() == 1) {
                    final Value pop5;
                    if ((pop5 = this.pop()).getSize() != 1) {
                        this.push(interpreter.copyOperation(abstractInsnNode, (V)pop4));
                        this.push((V)pop5);
                        this.push((V)pop4);
                        return;
                    }
                    final Value pop6;
                    if ((pop6 = this.pop()).getSize() == 1) {
                        this.push(interpreter.copyOperation(abstractInsnNode, (V)pop4));
                        this.push((V)pop6);
                        this.push((V)pop5);
                        this.push((V)pop4);
                        return;
                    }
                }
                throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[8]);
            }
            case 92: {
                final Value pop7;
                if ((pop7 = this.pop()).getSize() != 1) {
                    this.push((V)pop7);
                    this.push(interpreter.copyOperation(abstractInsnNode, (V)pop7));
                    return;
                }
                final Value pop8;
                if ((pop8 = this.pop()).getSize() == 1) {
                    this.push((V)pop8);
                    this.push((V)pop7);
                    this.push(interpreter.copyOperation(abstractInsnNode, (V)pop8));
                    this.push(interpreter.copyOperation(abstractInsnNode, (V)pop7));
                    return;
                }
                throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[9]);
            }
            case 93: {
                final Value pop9;
                if ((pop9 = this.pop()).getSize() == 1) {
                    final V pop10;
                    final Value pop11;
                    if ((pop10 = this.pop()).getSize() == 1 && (pop11 = this.pop()).getSize() == 1) {
                        this.push(interpreter.copyOperation(abstractInsnNode, pop10));
                        this.push(interpreter.copyOperation(abstractInsnNode, (V)pop9));
                        this.push((V)pop11);
                        this.push(pop10);
                        this.push((V)pop9);
                        return;
                    }
                }
                else {
                    final Value pop12;
                    if ((pop12 = this.pop()).getSize() == 1) {
                        this.push(interpreter.copyOperation(abstractInsnNode, (V)pop9));
                        this.push((V)pop12);
                        this.push((V)pop9);
                        return;
                    }
                }
                throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[10]);
            }
            case 94: {
                final Value pop13;
                if ((pop13 = this.pop()).getSize() == 1) {
                    final Value pop14;
                    if ((pop14 = this.pop()).getSize() == 1) {
                        final Value pop15;
                        if ((pop15 = this.pop()).getSize() != 1) {
                            this.push(interpreter.copyOperation(abstractInsnNode, (V)pop14));
                            this.push(interpreter.copyOperation(abstractInsnNode, (V)pop13));
                            this.push((V)pop15);
                            this.push((V)pop14);
                            this.push((V)pop13);
                            return;
                        }
                        final Value pop16;
                        if ((pop16 = this.pop()).getSize() == 1) {
                            this.push(interpreter.copyOperation(abstractInsnNode, (V)pop14));
                            this.push(interpreter.copyOperation(abstractInsnNode, (V)pop13));
                            this.push((V)pop16);
                            this.push((V)pop15);
                            this.push((V)pop14);
                            this.push((V)pop13);
                            return;
                        }
                    }
                }
                else {
                    final Value pop17;
                    if ((pop17 = this.pop()).getSize() != 1) {
                        this.push(interpreter.copyOperation(abstractInsnNode, (V)pop13));
                        this.push((V)pop17);
                        this.push((V)pop13);
                        return;
                    }
                    final Value pop18;
                    if ((pop18 = this.pop()).getSize() == 1) {
                        this.push(interpreter.copyOperation(abstractInsnNode, (V)pop13));
                        this.push((V)pop18);
                        this.push((V)pop17);
                        this.push((V)pop13);
                        return;
                    }
                }
                throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[11]);
            }
            case 95: {
                final Value pop19 = this.pop();
                final V pop20;
                if ((pop20 = this.pop()).getSize() != 1 || lllllIIlIlI(pop19.getSize(), 1)) {
                    throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[12]);
                }
                this.push(interpreter.copyOperation(abstractInsnNode, (V)pop19));
                this.push(interpreter.copyOperation(abstractInsnNode, pop20));
            }
            case 96:
            case 97:
            case 98:
            case 99:
            case 100:
            case 101:
            case 102:
            case 103:
            case 104:
            case 105:
            case 106:
            case 107:
            case 108:
            case 109:
            case 110:
            case 111:
            case 112:
            case 113:
            case 114:
            case 115: {
                this.push(interpreter.binaryOperation(abstractInsnNode, this.pop(), this.pop()));
            }
            case 116:
            case 117:
            case 118:
            case 119: {
                this.push(interpreter.unaryOperation(abstractInsnNode, this.pop()));
            }
            case 120:
            case 121:
            case 122:
            case 123:
            case 124:
            case 125:
            case 126:
            case 127:
            case 128:
            case 129:
            case 130:
            case 131: {
                this.push(interpreter.binaryOperation(abstractInsnNode, this.pop(), this.pop()));
            }
            case 132: {
                final int var2 = ((IincInsnNode)abstractInsnNode).var;
                this.setLocal(var2, interpreter.unaryOperation(abstractInsnNode, this.getLocal(var2)));
            }
            case 133:
            case 134:
            case 135:
            case 136:
            case 137:
            case 138:
            case 139:
            case 140:
            case 141:
            case 142:
            case 143:
            case 144:
            case 145:
            case 146:
            case 147: {
                this.push(interpreter.unaryOperation(abstractInsnNode, this.pop()));
            }
            case 148:
            case 149:
            case 150:
            case 151:
            case 152: {
                this.push(interpreter.binaryOperation(abstractInsnNode, this.pop(), this.pop()));
            }
            case 153:
            case 154:
            case 155:
            case 156:
            case 157:
            case 158: {
                interpreter.unaryOperation(abstractInsnNode, this.pop());
            }
            case 159:
            case 160:
            case 161:
            case 162:
            case 163:
            case 164:
            case 165:
            case 166: {
                interpreter.binaryOperation(abstractInsnNode, this.pop(), this.pop());
            }
            case 167: {}
            case 168: {
                this.push(interpreter.newOperation(abstractInsnNode));
            }
            case 169: {}
            case 170:
            case 171: {
                interpreter.unaryOperation(abstractInsnNode, this.pop());
            }
            case 172:
            case 173:
            case 174:
            case 175:
            case 176: {
                final Value pop21 = this.pop();
                interpreter.unaryOperation(abstractInsnNode, (V)pop21);
                interpreter.returnOperation(abstractInsnNode, (V)pop21, this.returnValue);
            }
            case 177: {
                if (this.returnValue != null) {
                    throw new AnalyzerException(abstractInsnNode, Frame.lIlIlIIIlI[13]);
                }
                break;
            }
            case 178: {
                this.push(interpreter.newOperation(abstractInsnNode));
            }
            case 179: {
                interpreter.unaryOperation(abstractInsnNode, this.pop());
            }
            case 180: {
                this.push(interpreter.unaryOperation(abstractInsnNode, this.pop()));
            }
            case 181: {
                interpreter.binaryOperation(abstractInsnNode, this.pop(), this.pop());
            }
            case 182:
            case 183:
            case 184:
            case 185: {
                final ArrayList<Object> list = new ArrayList<Object>();
                String desc;
                for (int i = Type.getArgumentTypes(desc = ((MethodInsnNode)abstractInsnNode).desc).length; i > 0; --i) {
                    list.add(0, this.pop());
                }
                if (lllllIIlIlI(abstractInsnNode.getOpcode(), 184)) {
                    list.add(0, this.pop());
                }
                if (lllllIIlllI(Type.getReturnType(desc), Type.VOID_TYPE)) {
                    interpreter.naryOperation(abstractInsnNode, (List<? extends V>)list);
                    return;
                }
                this.push(interpreter.naryOperation(abstractInsnNode, (List<? extends V>)list));
            }
            case 186: {
                final ArrayList<Object> list2 = new ArrayList<Object>();
                String desc2;
                for (int j = Type.getArgumentTypes(desc2 = ((InvokeDynamicInsnNode)abstractInsnNode).desc).length; j > 0; --j) {
                    list2.add(0, this.pop());
                }
                if (lllllIIlllI(Type.getReturnType(desc2), Type.VOID_TYPE)) {
                    interpreter.naryOperation(abstractInsnNode, (List<? extends V>)list2);
                    return;
                }
                this.push(interpreter.naryOperation(abstractInsnNode, (List<? extends V>)list2));
            }
            case 187: {
                this.push(interpreter.newOperation(abstractInsnNode));
            }
            case 188:
            case 189:
            case 190: {
                this.push(interpreter.unaryOperation(abstractInsnNode, this.pop()));
            }
            case 191: {
                interpreter.unaryOperation(abstractInsnNode, this.pop());
            }
            case 192:
            case 193: {
                this.push(interpreter.unaryOperation(abstractInsnNode, this.pop()));
            }
            case 194:
            case 195: {
                interpreter.unaryOperation(abstractInsnNode, this.pop());
            }
            case 197: {
                final ArrayList<Object> list3 = new ArrayList<Object>();
                for (int k = ((MultiANewArrayInsnNode)abstractInsnNode).dims; k > 0; --k) {
                    list3.add(0, this.pop());
                }
                this.push(interpreter.naryOperation(abstractInsnNode, (List<? extends V>)list3));
            }
            case 198:
            case 199: {
                interpreter.unaryOperation(abstractInsnNode, this.pop());
            }
            default: {
                throw new RuntimeException(String.valueOf(new StringBuilder().append(Frame.lIlIlIIIlI[14]).append(abstractInsnNode.getOpcode())));
            }
        }
    }
    
    public final boolean merge(final Frame<? extends V> frame, final Interpreter<V> interpreter) throws AnalyzerException {
        if (lllllIIlIlI(this.top, frame.top)) {
            throw new AnalyzerException(null, Frame.lIlIlIIIlI[15]);
        }
        boolean b = false;
        for (int i = 0; i < this.locals + this.top; ++i) {
            final Value merge;
            if (!(merge = interpreter.merge((V)this.values[i], (V)frame.values[i])).equals(this.values[i])) {
                this.values[i] = merge;
                b = true;
            }
        }
        return b;
    }
    
    public final boolean merge(final Frame<? extends V> frame, final boolean[] array) {
        boolean b = false;
        for (int i = 0; i < this.locals; ++i) {
            if (!array[i] && !this.values[i].equals(frame.values[i])) {
                this.values[i] = frame.values[i];
                b = true;
            }
        }
        return b;
    }
    
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.locals; ++i) {
            sb.append(this.getLocal(i));
        }
        sb.append(' ');
        for (int j = 0; j < this.top; ++j) {
            sb.append(this.getStack(j).toString());
        }
        return String.valueOf(sb);
    }
    
    static {
        lllllIIIlII();
    }
    
    private static void lllllIIIlII() {
        (lIlIlIIIlI = new String[16])[0] = "Trying to access an inexistant local variable";
        Frame.lIlIlIIIlI[1] = "Trying to access an inexistant local variable ";
        Frame.lIlIlIIIlI[2] = "Cannot pop operand off an empty stack.";
        Frame.lIlIlIIIlI[3] = "Insufficient maximum stack size.";
        Frame.lIlIlIIIlI[4] = "Illegal use of POP";
        Frame.lIlIlIIIlI[5] = "Illegal use of POP2";
        Frame.lIlIlIIIlI[6] = "Illegal use of DUP";
        Frame.lIlIlIIIlI[7] = "Illegal use of DUP_X1";
        Frame.lIlIlIIIlI[8] = "Illegal use of DUP_X2";
        Frame.lIlIlIIIlI[9] = "Illegal use of DUP2";
        Frame.lIlIlIIIlI[10] = "Illegal use of DUP2_X1";
        Frame.lIlIlIIIlI[11] = "Illegal use of DUP2_X2";
        Frame.lIlIlIIIlI[12] = "Illegal use of SWAP";
        Frame.lIlIlIIIlI[13] = "Incompatible return type";
        Frame.lIlIlIIIlI[14] = "Illegal opcode ";
        Frame.lIlIlIIIlI[15] = "Incompatible stack heights";
    }
    
    private static String lllllIIIIll(final String s, final String s2) {
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
    
    private static String lllllIIIIlI(final String s, final String s2) {
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
    
    private static String lllllIIIIIl(String s, final String s2) {
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
    
    private static boolean lllllIIIlIl(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lllllIIlllI(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lllllIIlIII(final int n) {
        return n > 0;
    }
    
    private static boolean lllllIIlIlI(final int n, final int n2) {
        return n != n2;
    }
}
