package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.signature.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class CheckSignatureAdapter extends SignatureVisitor
{
    private static int CLASS_SIGNATURE;
    private static int METHOD_SIGNATURE;
    private static int TYPE_SIGNATURE;
    private static final int EMPTY;
    private static final int FORMAL;
    private static final int BOUND;
    private static final int SUPER;
    private static final int PARAM;
    private static final int RETURN;
    private static final int SIMPLE_TYPE;
    private static final int CLASS_TYPE;
    private static final int END;
    private final int type;
    private int state;
    private boolean canBeVoid;
    private final SignatureVisitor sv;
    private static final String[] lIIIlllIIlI;
    
    private CheckSignatureAdapter(final SignatureVisitor signatureVisitor) {
        this(signatureVisitor, (byte)0);
    }
    
    private CheckSignatureAdapter(final SignatureVisitor sv, final byte b) {
        super();
        this.state = 1;
        this.sv = sv;
    }
    
    public final void visitFormalTypeParameter(final String s) {
        if (!llIIlllIIIIl(2, 2) || (llIIlllIIIIl(this.state, 1) && llIIlllIIIIl(this.state, 2) && llIIlllIIIIl(this.state, 4))) {
            throw new IllegalStateException();
        }
        CheckMethodAdapter.checkIdentifier(s, CheckSignatureAdapter.lIIIlllIIlI[0]);
        this.state = 2;
        if (this.sv != null) {
            this.sv.visitFormalTypeParameter(s);
        }
    }
    
    public final SignatureVisitor visitClassBound() {
        if (llIIlllIIIIl(this.state, 2)) {
            throw new IllegalStateException();
        }
        this.state = 4;
        return new CheckSignatureAdapter((this.sv == null) ? null : this.sv.visitClassBound());
    }
    
    public final SignatureVisitor visitInterfaceBound() {
        if (llIIlllIIIIl(this.state, 2) && llIIlllIIIIl(this.state, 4)) {
            throw new IllegalArgumentException();
        }
        return new CheckSignatureAdapter((this.sv == null) ? null : this.sv.visitInterfaceBound());
    }
    
    public final SignatureVisitor visitSuperclass() {
        throw new IllegalArgumentException();
    }
    
    public final SignatureVisitor visitInterface() {
        if (llIIlllIIIIl(this.state, 8)) {
            throw new IllegalStateException();
        }
        return new CheckSignatureAdapter((this.sv == null) ? null : this.sv.visitInterface());
    }
    
    public final SignatureVisitor visitParameterType() {
        throw new IllegalArgumentException();
    }
    
    public final SignatureVisitor visitReturnType() {
        throw new IllegalArgumentException();
    }
    
    public final SignatureVisitor visitExceptionType() {
        if (llIIlllIIIIl(this.state, 32)) {
            throw new IllegalStateException();
        }
        return new CheckSignatureAdapter((this.sv == null) ? null : this.sv.visitExceptionType());
    }
    
    public final void visitBaseType(final char c) {
        if (llIIlllIIIIl(this.state, 1)) {
            throw new IllegalStateException();
        }
        if (c == 'V') {
            throw new IllegalArgumentException();
        }
        if (CheckSignatureAdapter.lIIIlllIIlI[1].indexOf(c) == -1) {
            throw new IllegalArgumentException();
        }
        this.state = 64;
        if (this.sv != null) {
            this.sv.visitBaseType(c);
        }
    }
    
    public final void visitTypeVariable(final String s) {
        if (llIIlllIIIIl(this.state, 1)) {
            throw new IllegalStateException();
        }
        CheckMethodAdapter.checkIdentifier(s, CheckSignatureAdapter.lIIIlllIIlI[2]);
        this.state = 64;
        if (this.sv != null) {
            this.sv.visitTypeVariable(s);
        }
    }
    
    public final SignatureVisitor visitArrayType() {
        if (llIIlllIIIIl(this.state, 1)) {
            throw new IllegalStateException();
        }
        this.state = 64;
        return new CheckSignatureAdapter((this.sv == null) ? null : this.sv.visitArrayType());
    }
    
    public final void visitClassType(final String s) {
        if (llIIlllIIIIl(this.state, 1)) {
            throw new IllegalStateException();
        }
        CheckMethodAdapter.checkInternalName(s, CheckSignatureAdapter.lIIIlllIIlI[3]);
        this.state = 128;
        if (this.sv != null) {
            this.sv.visitClassType(s);
        }
    }
    
    public final void visitInnerClassType(final String s) {
        if (llIIlllIIIIl(this.state, 128)) {
            throw new IllegalStateException();
        }
        CheckMethodAdapter.checkIdentifier(s, CheckSignatureAdapter.lIIIlllIIlI[4]);
        if (this.sv != null) {
            this.sv.visitInnerClassType(s);
        }
    }
    
    public final void visitTypeArgument() {
        if (llIIlllIIIIl(this.state, 128)) {
            throw new IllegalStateException();
        }
        if (this.sv != null) {
            this.sv.visitTypeArgument();
        }
    }
    
    public final SignatureVisitor visitTypeArgument(final char c) {
        if (llIIlllIIIIl(this.state, 128)) {
            throw new IllegalStateException();
        }
        if (CheckSignatureAdapter.lIIIlllIIlI[5].indexOf(c) == -1) {
            throw new IllegalArgumentException();
        }
        return new CheckSignatureAdapter((this.sv == null) ? null : this.sv.visitTypeArgument(c));
    }
    
    public final void visitEnd() {
        if (llIIlllIIIIl(this.state, 128)) {
            throw new IllegalStateException();
        }
        this.state = 256;
        if (this.sv != null) {
            this.sv.visitEnd();
        }
    }
    
    static {
        llIIllIlllll();
    }
    
    private static void llIIllIlllll() {
        (lIIIlllIIlI = new String[6])[0] = "formal type parameter";
        CheckSignatureAdapter.lIIIlllIIlI[1] = "ZCBSIFJD";
        CheckSignatureAdapter.lIIIlllIIlI[2] = "type variable";
        CheckSignatureAdapter.lIIIlllIIlI[3] = "class name";
        CheckSignatureAdapter.lIIIlllIIlI[4] = "inner class name";
        CheckSignatureAdapter.lIIIlllIIlI[5] = "+-=";
    }
    
    private static String llIIllIllIIl(final String s, final String s2) {
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
    
    private static String llIIllIlllIl(String s, final String s2) {
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
    
    private static String llIIllIllllI(final String s, final String s2) {
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
    
    private static boolean llIIlllIIIIl(final int n, final int n2) {
        return n != n2;
    }
}
