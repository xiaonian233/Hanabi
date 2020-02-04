package org.spongepowered.asm.lib.tree.analysis;

import org.spongepowered.asm.lib.*;
import java.util.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public final class BasicValue implements Value
{
    public static final BasicValue UNINITIALIZED_VALUE;
    public static final BasicValue INT_VALUE;
    public static final BasicValue FLOAT_VALUE;
    public static final BasicValue LONG_VALUE;
    public static final BasicValue DOUBLE_VALUE;
    public static final BasicValue REFERENCE_VALUE;
    public static final BasicValue RETURNADDRESS_VALUE;
    public final Type type;
    private static final String[] llIllIII;
    
    public BasicValue(final Type type) {
        super();
        this.type = type;
    }
    
    private Type getType() {
        return this.type;
    }
    
    public final int getSize() {
        if (this.type == Type.LONG_TYPE || lIIlllIIIl(this.type, Type.DOUBLE_TYPE)) {
            return 2;
        }
        return 1;
    }
    
    public final boolean isReference() {
        return this.type != null && (this.type.sort == 10 || this.type.sort == 9);
    }
    
    public final boolean equals(final Object o) {
        if (lIIlllIIIl(o, this)) {
            return true;
        }
        if (!(o instanceof BasicValue)) {
            return false;
        }
        if (this.type == null) {
            return ((BasicValue)o).type == null;
        }
        return this.type.equals(((BasicValue)o).type);
    }
    
    public final int hashCode() {
        if (this.type == null) {
            return 0;
        }
        return this.type.hashCode();
    }
    
    public final String toString() {
        if (lIIlllIIIl(this, BasicValue.UNINITIALIZED_VALUE)) {
            return BasicValue.llIllIII[0];
        }
        if (lIIlllIIIl(this, BasicValue.RETURNADDRESS_VALUE)) {
            return BasicValue.llIllIII[1];
        }
        if (lIIlllIIIl(this, BasicValue.REFERENCE_VALUE)) {
            return BasicValue.llIllIII[2];
        }
        return this.type.getDescriptor();
    }
    
    static {
        lIIllIllIl();
        UNINITIALIZED_VALUE = new BasicValue(null);
        INT_VALUE = new BasicValue(Type.INT_TYPE);
        FLOAT_VALUE = new BasicValue(Type.FLOAT_TYPE);
        LONG_VALUE = new BasicValue(Type.LONG_TYPE);
        DOUBLE_VALUE = new BasicValue(Type.DOUBLE_TYPE);
        REFERENCE_VALUE = new BasicValue(Type.getObjectType(BasicValue.llIllIII[3]));
        RETURNADDRESS_VALUE = new BasicValue(Type.VOID_TYPE);
    }
    
    private static void lIIllIllIl() {
        (llIllIII = new String[4])[0] = ".";
        BasicValue.llIllIII[1] = "A";
        BasicValue.llIllIII[2] = "R";
        BasicValue.llIllIII[3] = "java/lang/Object";
    }
    
    private static String lIIllIlIll(String s, final String s2) {
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
    
    private static String lIIllIllII(final String s, final String s2) {
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
    
    private static boolean lIIlllIIII(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIlllIIIl(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIlllIIll$255f299(final int n) {
        return n != 10;
    }
}
