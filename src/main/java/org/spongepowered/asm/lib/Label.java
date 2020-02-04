package org.spongepowered.asm.lib;

import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class Label
{
    private static int DEBUG;
    private static int RESOLVED;
    private static int RESIZED;
    private static int PUSHED;
    private static int TARGET;
    private static int STORE;
    private static int REACHABLE;
    private static int JSR;
    private static int RET;
    private static int SUBROUTINE;
    private static int VISITED;
    private static int VISITED2;
    public Object info;
    int status;
    int line;
    int position;
    private int referenceCount;
    private int[] srcAndRefPositions;
    int inputStackTop;
    int outputStackMax;
    Frame frame;
    Label successor;
    Edge successors;
    Label next;
    private static final String[] lIIlIIIlIll;
    
    public Label() {
        super();
    }
    
    private int getOffset() {
        if ((this.status & 0x2) == 0x0) {
            throw new IllegalStateException(Label.lIIlIIIlIll[0]);
        }
        return this.position;
    }
    
    final void put$1f42ce97(final ByteVector byteVector, final int n, final boolean b) {
        if ((this.status & 0x2) == 0x0) {
            if (b) {
                this.addReference(-1 - n, byteVector.length);
                byteVector.putInt(-1);
                return;
            }
            this.addReference(n, byteVector.length);
            byteVector.putShort(-1);
        }
        else {
            if (b) {
                byteVector.putInt(this.position - n);
                return;
            }
            byteVector.putShort(this.position - n);
        }
    }
    
    private void addReference(final int n, final int n2) {
        if (this.srcAndRefPositions == null) {
            this.srcAndRefPositions = new int[6];
        }
        if (llIlIIIIIlIl(this.referenceCount, this.srcAndRefPositions.length)) {
            final int[] srcAndRefPositions = new int[this.srcAndRefPositions.length + 6];
            System.arraycopy(this.srcAndRefPositions, 0, srcAndRefPositions, 0, this.srcAndRefPositions.length);
            this.srcAndRefPositions = srcAndRefPositions;
        }
        this.srcAndRefPositions[this.referenceCount++] = n;
        this.srcAndRefPositions[this.referenceCount++] = n2;
    }
    
    final boolean resolve$3a297a34(final int position, final byte[] array) {
        boolean b = false;
        this.status |= 0x2;
        this.position = position;
        int i = 0;
        while (i < this.referenceCount) {
            final int n = this.srcAndRefPositions[i++];
            int n2 = this.srcAndRefPositions[i++];
            if (n >= 0) {
                final int n3;
                if (!llIlIIIIIlIl(n3 = position - n, -32768) || n3 > 32767) {
                    final int n4;
                    if ((n4 = (array[n2 - 1] & 0xFF)) <= 168) {
                        array[n2 - 1] = (byte)(n4 + 49);
                    }
                    else {
                        array[n2 - 1] = (byte)(n4 + 20);
                    }
                    b = true;
                }
                array[n2++] = (byte)(n3 >>> 8);
                array[n2] = (byte)n3;
            }
            else {
                final int n5 = position + n + 1;
                array[n2++] = (byte)(n5 >>> 24);
                array[n2++] = (byte)(n5 >>> 16);
                array[n2++] = (byte)(n5 >>> 8);
                array[n2] = (byte)n5;
            }
        }
        return b;
    }
    
    final Label getFirst() {
        if (this.frame == null) {
            return this;
        }
        return this.frame.owner;
    }
    
    private boolean inSubroutine(final long n) {
        return (this.status & 0x400) != 0x0 && (this.srcAndRefPositions[(int)(n >>> 32)] & (int)n) != 0x0;
    }
    
    private boolean inSameSubroutine(final Label label) {
        if ((this.status & 0x400) == 0x0 || (label.status & 0x400) == 0x0) {
            return false;
        }
        for (int i = 0; i < this.srcAndRefPositions.length; ++i) {
            if ((this.srcAndRefPositions[i] & label.srcAndRefPositions[i]) != 0x0) {
                return true;
            }
        }
        return false;
    }
    
    private void addToSubroutine(final long n, final int n2) {
        if ((this.status & 0x400) == 0x0) {
            this.status |= 0x400;
            this.srcAndRefPositions = new int[n2 / 32 + 1];
        }
        final int[] srcAndRefPositions = this.srcAndRefPositions;
        final int n3 = (int)(n >>> 32);
        srcAndRefPositions[n3] |= (int)n;
    }
    
    final void visitSubroutine(final Label label, final long n, final int n2) {
        Label next = this;
        while (next != null) {
            final Label label2;
            next = (label2 = next).next;
            label2.next = null;
            if (label != null) {
                if ((label2.status & 0x800) != 0x0) {
                    continue;
                }
                final Label label3 = label2;
                label3.status |= 0x800;
                if ((label2.status & 0x100) != 0x0) {
                    boolean b = false;
                    Label_0139: {
                        final Label label4;
                        if (((label4 = label2).status & 0x400) == 0x0 || (label.status & 0x400) == 0x0) {
                            b = false;
                        }
                        else {
                            for (int i = 0; i < label4.srcAndRefPositions.length; ++i) {
                                if ((label4.srcAndRefPositions[i] & label.srcAndRefPositions[i]) != 0x0) {
                                    b = true;
                                    break Label_0139;
                                }
                            }
                            b = false;
                        }
                    }
                    if (!b) {
                        final Edge successors;
                        (successors = new Edge()).info = label2.inputStackTop;
                        successors.successor = label.successors.successor;
                        successors.next = label2.successors;
                        label2.successors = successors;
                    }
                }
            }
            else {
                final Label label5;
                if (((label5 = label2).status & 0x400) != 0x0 && (label5.srcAndRefPositions[(int)(n >>> 32)] & (int)n) != 0x0) {
                    continue;
                }
                final Label label6;
                if (((label6 = label2).status & 0x400) == 0x0) {
                    final Label label7 = label6;
                    label7.status |= 0x400;
                    label6.srcAndRefPositions = new int[n2 / 32 + 1];
                }
                final int[] srcAndRefPositions = label6.srcAndRefPositions;
                final int n3 = (int)(n >>> 32);
                srcAndRefPositions[n3] |= (int)n;
            }
            for (Edge edge = label2.successors; edge != null; edge = edge.next) {
                if (((label2.status & 0x80) == 0x0 || edge != label2.successors.next) && edge.successor.next == null) {
                    edge.successor.next = next;
                    next = edge.successor;
                }
            }
        }
    }
    
    public String toString() {
        return String.valueOf(new StringBuilder().append(Label.lIIlIIIlIll[1]).append(System.identityHashCode(this)));
    }
    
    static {
        llIlIIIIIIIl();
    }
    
    private static void llIlIIIIIIIl() {
        (lIIlIIIlIll = new String[2])[0] = "Label offset position has not been resolved yet";
        Label.lIIlIIIlIll[1] = "L";
    }
    
    private static String llIlIIIIIIII(final String s, final String s2) {
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
    
    private static boolean llIlIIIIIlIl(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean llIlIIIIlIIl$255f299(final int n) {
        return n <= 168;
    }
    
    private static boolean llIlIIIIlIII$255f299(final int n) {
        return n > 32767;
    }
    
    private static boolean llIlIIIIllII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean llIlIIIIIlll(final int n) {
        return n >= 0;
    }
}
