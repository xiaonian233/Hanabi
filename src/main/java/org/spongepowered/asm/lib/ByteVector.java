package org.spongepowered.asm.lib;

public final class ByteVector
{
    byte[] data;
    int length;
    
    public ByteVector() {
        super();
        this.data = new byte[64];
    }
    
    public ByteVector(final int n) {
        super();
        this.data = new byte[n];
    }
    
    public final ByteVector putByte(final int n) {
        int length;
        if (lllllllIlII((length = this.length) + 1, this.data.length)) {
            this.enlarge(1);
        }
        this.data[length++] = (byte)n;
        this.length = length;
        return this;
    }
    
    final ByteVector put11(final int n, final int n2) {
        int length;
        if (lllllllIlII((length = this.length) + 2, this.data.length)) {
            this.enlarge(2);
        }
        final byte[] data = this.data;
        data[length++] = (byte)n;
        data[length++] = (byte)n2;
        this.length = length;
        return this;
    }
    
    public final ByteVector putShort(final int n) {
        int length;
        if (lllllllIlII((length = this.length) + 2, this.data.length)) {
            this.enlarge(2);
        }
        final byte[] data = this.data;
        data[length++] = (byte)(n >>> 8);
        data[length++] = (byte)n;
        this.length = length;
        return this;
    }
    
    final ByteVector put12(final int n, final int n2) {
        int length;
        if (lllllllIlII((length = this.length) + 3, this.data.length)) {
            this.enlarge(3);
        }
        final byte[] data;
        (data = this.data)[length++] = (byte)n;
        data[length++] = (byte)(n2 >>> 8);
        data[length++] = (byte)n2;
        this.length = length;
        return this;
    }
    
    public final ByteVector putInt(final int n) {
        int length;
        if (lllllllIlII((length = this.length) + 4, this.data.length)) {
            this.enlarge(4);
        }
        final byte[] data;
        (data = this.data)[length++] = (byte)(n >>> 24);
        data[length++] = (byte)(n >>> 16);
        data[length++] = (byte)(n >>> 8);
        data[length++] = (byte)n;
        this.length = length;
        return this;
    }
    
    public final ByteVector putLong(final long n) {
        int length;
        if (lllllllIlII((length = this.length) + 8, this.data.length)) {
            this.enlarge(8);
        }
        final byte[] data = this.data;
        final int n2 = (int)(n >>> 32);
        data[length++] = (byte)(n2 >>> 24);
        data[length++] = (byte)(n2 >>> 16);
        data[length++] = (byte)(n2 >>> 8);
        data[length++] = (byte)n2;
        final int n3 = (int)n;
        data[length++] = (byte)(n3 >>> 24);
        data[length++] = (byte)(n3 >>> 16);
        data[length++] = (byte)(n3 >>> 8);
        data[length++] = (byte)n3;
        this.length = length;
        return this;
    }
    
    public final ByteVector putUTF8(final String s) {
        final int length;
        if (lllllllIlII(length = s.length(), 65535)) {
            throw new IllegalArgumentException();
        }
        int length2;
        if (lllllllIlII((length2 = this.length) + 2 + length, this.data.length)) {
            this.enlarge(length + 2);
        }
        final byte[] data;
        (data = this.data)[length2++] = (byte)(length >>> 8);
        data[length2++] = (byte)length;
        for (int i = 0; i < length; ++i) {
            final char char1;
            if ((char1 = s.charAt(i)) <= '\0' || !lllllllIlll$255f299(char1)) {
                this.length = length2;
                return this.encodeUTF8(s, i, 65535);
            }
            data[length2++] = (byte)char1;
        }
        this.length = length2;
        return this;
    }
    
    final ByteVector encodeUTF8(final String s, int i, int length) {
        final int length2 = s.length();
        int n = i;
        for (int j = i; j < length2; ++j) {
            final char char1;
            if ((char1 = s.charAt(j)) > '\0' && lllllllIlll$255f299(char1)) {
                ++n;
            }
            else if (lllllllIlII(char1, 2047)) {
                n += 3;
            }
            else {
                n += 2;
            }
        }
        if (lllllllIlII(n, length)) {
            throw new IllegalArgumentException();
        }
        final int n2;
        if ((n2 = this.length - i - 2) >= 0) {
            this.data[n2] = (byte)(n >>> 8);
            this.data[n2 + 1] = (byte)n;
        }
        if (lllllllIlII(this.length + n - i, this.data.length)) {
            this.enlarge(n - i);
        }
        length = this.length;
        while (i < length2) {
            final char char2;
            if ((char2 = s.charAt(i)) > '\0' && lllllllIlll$255f299(char2)) {
                this.data[length++] = (byte)char2;
            }
            else if (lllllllIlII(char2, 2047)) {
                this.data[length++] = (byte)('à' | (char2 >> 12 & '\u000f'));
                this.data[length++] = (byte)('\u0080' | (char2 >> 6 & '?'));
                this.data[length++] = (byte)('\u0080' | (char2 & '?'));
            }
            else {
                this.data[length++] = (byte)('À' | (char2 >> 6 & '\u001f'));
                this.data[length++] = (byte)('\u0080' | (char2 & '?'));
            }
            ++i;
        }
        this.length = length;
        return this;
    }
    
    public final ByteVector putByteArray(final byte[] array, final int n, final int n2) {
        if (lllllllIlII(this.length + n2, this.data.length)) {
            this.enlarge(n2);
        }
        if (array != null) {
            System.arraycopy(array, n, this.data, this.length, n2);
        }
        this.length += n2;
        return this;
    }
    
    private void enlarge(int n) {
        final int n2 = 2 * this.data.length;
        n += this.length;
        final byte[] data = new byte[lllllllIlII(n2, n) ? n2 : n];
        System.arraycopy(this.data, 0, data, 0, this.length);
        this.data = data;
    }
    
    private static boolean lllllllIllI$255f299(final int n) {
        return n > 0;
    }
    
    private static boolean lllllllIlll$255f299(final int n) {
        return n <= 127;
    }
    
    private static boolean lllllllIlII(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lllllllllII(final int n) {
        return n >= 0;
    }
}
