package org.spongepowered.asm.lib;

public final class TypePath
{
    private static int ARRAY_ELEMENT;
    private static int INNER_TYPE;
    private static int WILDCARD_BOUND;
    private static int TYPE_ARGUMENT;
    byte[] b;
    int offset;
    
    TypePath(final byte[] b, final int offset) {
        super();
        this.b = b;
        this.offset = offset;
    }
    
    public final int getLength() {
        return this.b[this.offset];
    }
    
    public final int getStep(final int n) {
        return this.b[this.offset + n * 2 + 1];
    }
    
    public final int getStepArgument(final int n) {
        return this.b[this.offset + n * 2 + 2];
    }
    
    private static TypePath fromString(final String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        final int length = s.length();
        final ByteVector byteVector;
        (byteVector = new ByteVector(length)).putByte(0);
        int i = 0;
        while (i < length) {
            final char char1;
            if ((char1 = s.charAt(i++)) == '[') {
                byteVector.put11(0, 0);
            }
            else if (char1 == '.') {
                byteVector.put11(1, 0);
            }
            else if (char1 == '*') {
                byteVector.put11(2, 0);
            }
            else {
                if (!llIllIIIIllI$255f299(char1) || !llIllIIIIlll$255f299(char1)) {
                    continue;
                }
                int n = char1 - '0';
                char char2;
                while (i < length && llIllIIIIllI$255f299(char2 = s.charAt(i)) && llIllIIIIlll$255f299(char2)) {
                    n = n * 10 + char2 - 48;
                    ++i;
                }
                if (i < length && s.charAt(i) == ';') {
                    ++i;
                }
                byteVector.put11(3, n);
            }
        }
        byteVector.data[0] = (byte)(byteVector.length / 2);
        return new TypePath(byteVector.data, 0);
    }
    
    public final String toString() {
        final int length = this.getLength();
        final StringBuilder sb = new StringBuilder(length * 2);
        for (int i = 0; i < length; ++i) {
            switch (this.getStep(i)) {
                case 0: {
                    sb.append('[');
                    break;
                }
                case 1: {
                    sb.append('.');
                    break;
                }
                case 2: {
                    sb.append('*');
                    break;
                }
                case 3: {
                    sb.append(this.getStepArgument(i)).append(';');
                    break;
                }
                default: {
                    sb.append('_');
                    break;
                }
            }
        }
        return String.valueOf(sb);
    }
    
    private static boolean llIllIIIIllI$255f299(final int n) {
        return n >= 48;
    }
    
    private static boolean llIllIIIIlll$255f299(final int n) {
        return n <= 57;
    }
}
