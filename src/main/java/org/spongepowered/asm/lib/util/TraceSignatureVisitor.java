package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.signature.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class TraceSignatureVisitor extends SignatureVisitor
{
    final StringBuilder declaration;
    private boolean isInterface;
    private boolean seenFormalParameter;
    private boolean seenInterfaceBound;
    private boolean seenParameter;
    private boolean seenInterface;
    StringBuilder returnType;
    StringBuilder exceptions;
    private int argumentStack;
    private int arrayStack;
    private String separator;
    private static final String[] llIlIIlIII;
    
    public TraceSignatureVisitor(final int n) {
        super();
        this.separator = TraceSignatureVisitor.llIlIIlIII[0];
        this.isInterface = ((n & 0x200) != 0x0);
        this.declaration = new StringBuilder();
    }
    
    private TraceSignatureVisitor(final StringBuilder declaration) {
        super();
        this.separator = TraceSignatureVisitor.llIlIIlIII[1];
        this.declaration = declaration;
    }
    
    public final void visitFormalTypeParameter(final String s) {
        this.declaration.append(this.seenFormalParameter ? TraceSignatureVisitor.llIlIIlIII[2] : TraceSignatureVisitor.llIlIIlIII[3]).append(s);
        this.seenFormalParameter = true;
        this.seenInterfaceBound = false;
    }
    
    public final SignatureVisitor visitClassBound() {
        this.separator = TraceSignatureVisitor.llIlIIlIII[4];
        this.startType();
        return this;
    }
    
    public final SignatureVisitor visitInterfaceBound() {
        this.separator = (this.seenInterfaceBound ? TraceSignatureVisitor.llIlIIlIII[5] : TraceSignatureVisitor.llIlIIlIII[6]);
        this.seenInterfaceBound = true;
        this.startType();
        return this;
    }
    
    public final SignatureVisitor visitSuperclass() {
        this.endFormals();
        this.separator = TraceSignatureVisitor.llIlIIlIII[7];
        this.startType();
        return this;
    }
    
    public final SignatureVisitor visitInterface() {
        this.separator = (this.seenInterface ? TraceSignatureVisitor.llIlIIlIII[8] : (this.isInterface ? TraceSignatureVisitor.llIlIIlIII[9] : TraceSignatureVisitor.llIlIIlIII[10]));
        this.seenInterface = true;
        this.startType();
        return this;
    }
    
    public final SignatureVisitor visitParameterType() {
        this.endFormals();
        if (this.seenParameter) {
            this.declaration.append(TraceSignatureVisitor.llIlIIlIII[11]);
        }
        else {
            this.seenParameter = true;
            this.declaration.append('(');
        }
        this.startType();
        return this;
    }
    
    public final SignatureVisitor visitReturnType() {
        this.endFormals();
        if (this.seenParameter) {
            this.seenParameter = false;
        }
        else {
            this.declaration.append('(');
        }
        this.declaration.append(')');
        this.returnType = new StringBuilder();
        return new TraceSignatureVisitor(this.returnType);
    }
    
    public final SignatureVisitor visitExceptionType() {
        if (this.exceptions == null) {
            this.exceptions = new StringBuilder();
        }
        else {
            this.exceptions.append(TraceSignatureVisitor.llIlIIlIII[12]);
        }
        return new TraceSignatureVisitor(this.exceptions);
    }
    
    public final void visitBaseType(final char c) {
        switch (c) {
            case 'V': {
                this.declaration.append(TraceSignatureVisitor.llIlIIlIII[13]);
                break;
            }
            case 'B': {
                this.declaration.append(TraceSignatureVisitor.llIlIIlIII[14]);
                break;
            }
            case 'J': {
                this.declaration.append(TraceSignatureVisitor.llIlIIlIII[15]);
                break;
            }
            case 'Z': {
                this.declaration.append(TraceSignatureVisitor.llIlIIlIII[16]);
                break;
            }
            case 'I': {
                this.declaration.append(TraceSignatureVisitor.llIlIIlIII[17]);
                break;
            }
            case 'S': {
                this.declaration.append(TraceSignatureVisitor.llIlIIlIII[18]);
                break;
            }
            case 'C': {
                this.declaration.append(TraceSignatureVisitor.llIlIIlIII[19]);
                break;
            }
            case 'F': {
                this.declaration.append(TraceSignatureVisitor.llIlIIlIII[20]);
                break;
            }
            default: {
                this.declaration.append(TraceSignatureVisitor.llIlIIlIII[21]);
                break;
            }
        }
        this.endType();
    }
    
    public final void visitTypeVariable(final String s) {
        this.declaration.append(s);
        this.endType();
    }
    
    public final SignatureVisitor visitArrayType() {
        this.startType();
        this.arrayStack |= 0x1;
        return this;
    }
    
    public final void visitClassType(final String s) {
        if (TraceSignatureVisitor.llIlIIlIII[22].equals(s)) {
            if (this.argumentStack % 2 != 0 || this.seenParameter) {
                this.declaration.append(this.separator).append(s.replace('/', '.'));
            }
        }
        else {
            this.declaration.append(this.separator).append(s.replace('/', '.'));
        }
        this.separator = TraceSignatureVisitor.llIlIIlIII[23];
        this.argumentStack *= 2;
    }
    
    public final void visitInnerClassType(final String s) {
        if (this.argumentStack % 2 != 0) {
            this.declaration.append('>');
        }
        this.argumentStack /= 2;
        this.declaration.append('.');
        this.declaration.append(this.separator).append(s.replace('/', '.'));
        this.separator = TraceSignatureVisitor.llIlIIlIII[24];
        this.argumentStack *= 2;
    }
    
    public final void visitTypeArgument() {
        if (this.argumentStack % 2 == 0) {
            ++this.argumentStack;
            this.declaration.append('<');
        }
        else {
            this.declaration.append(TraceSignatureVisitor.llIlIIlIII[25]);
        }
        this.declaration.append('?');
    }
    
    public final SignatureVisitor visitTypeArgument(final char c) {
        if (this.argumentStack % 2 == 0) {
            ++this.argumentStack;
            this.declaration.append('<');
        }
        else {
            this.declaration.append(TraceSignatureVisitor.llIlIIlIII[26]);
        }
        if (c == '+') {
            this.declaration.append(TraceSignatureVisitor.llIlIIlIII[27]);
        }
        else if (c == '-') {
            this.declaration.append(TraceSignatureVisitor.llIlIIlIII[28]);
        }
        this.startType();
        return this;
    }
    
    public final void visitEnd() {
        if (this.argumentStack % 2 != 0) {
            this.declaration.append('>');
        }
        this.argumentStack /= 2;
        this.endType();
    }
    
    private String getDeclaration() {
        return String.valueOf(this.declaration);
    }
    
    private String getReturnType() {
        if (this.returnType == null) {
            return null;
        }
        return String.valueOf(this.returnType);
    }
    
    private String getExceptions() {
        if (this.exceptions == null) {
            return null;
        }
        return String.valueOf(this.exceptions);
    }
    
    private void endFormals() {
        if (this.seenFormalParameter) {
            this.declaration.append('>');
            this.seenFormalParameter = false;
        }
    }
    
    private void startType() {
        this.arrayStack *= 2;
    }
    
    private void endType() {
        if (this.arrayStack % 2 == 0) {
            this.arrayStack /= 2;
            return;
        }
        while (this.arrayStack % 2 != 0) {
            this.arrayStack /= 2;
            this.declaration.append(TraceSignatureVisitor.llIlIIlIII[29]);
        }
    }
    
    static {
        lIIllIIlIlll();
    }
    
    private static void lIIllIIlIlll() {
        (llIlIIlIII = new String[30])[0] = "";
        TraceSignatureVisitor.llIlIIlIII[1] = "";
        TraceSignatureVisitor.llIlIIlIII[2] = ", ";
        TraceSignatureVisitor.llIlIIlIII[3] = "<";
        TraceSignatureVisitor.llIlIIlIII[4] = " extends ";
        TraceSignatureVisitor.llIlIIlIII[5] = ", ";
        TraceSignatureVisitor.llIlIIlIII[6] = " extends ";
        TraceSignatureVisitor.llIlIIlIII[7] = " extends ";
        TraceSignatureVisitor.llIlIIlIII[8] = ", ";
        TraceSignatureVisitor.llIlIIlIII[9] = " extends ";
        TraceSignatureVisitor.llIlIIlIII[10] = " implements ";
        TraceSignatureVisitor.llIlIIlIII[11] = ", ";
        TraceSignatureVisitor.llIlIIlIII[12] = ", ";
        TraceSignatureVisitor.llIlIIlIII[13] = "void";
        TraceSignatureVisitor.llIlIIlIII[14] = "byte";
        TraceSignatureVisitor.llIlIIlIII[15] = "long";
        TraceSignatureVisitor.llIlIIlIII[16] = "boolean";
        TraceSignatureVisitor.llIlIIlIII[17] = "int";
        TraceSignatureVisitor.llIlIIlIII[18] = "short";
        TraceSignatureVisitor.llIlIIlIII[19] = "char";
        TraceSignatureVisitor.llIlIIlIII[20] = "float";
        TraceSignatureVisitor.llIlIIlIII[21] = "double";
        TraceSignatureVisitor.llIlIIlIII[22] = "java/lang/Object";
        TraceSignatureVisitor.llIlIIlIII[23] = "";
        TraceSignatureVisitor.llIlIIlIII[24] = "";
        TraceSignatureVisitor.llIlIIlIII[25] = ", ";
        TraceSignatureVisitor.llIlIIlIII[26] = ", ";
        TraceSignatureVisitor.llIlIIlIII[27] = "? extends ";
        TraceSignatureVisitor.llIlIIlIII[28] = "? super ";
        TraceSignatureVisitor.llIlIIlIII[29] = "[]";
    }
    
    private static String lIIllIIIlIII(final String s, final String s2) {
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
    
    private static String lIIllIIIlIIl(final String s, final String s2) {
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
    
    private static String lIIllIIIIlll(String s, final String s2) {
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
}
