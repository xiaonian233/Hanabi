package org.spongepowered.asm.lib.util;

import org.spongepowered.asm.lib.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

public final class CheckAnnotationAdapter extends AnnotationVisitor
{
    private final boolean named;
    private boolean end;
    private static final String[] lllllIlIlI;
    
    public CheckAnnotationAdapter(final AnnotationVisitor annotationVisitor) {
        this(annotationVisitor, true);
    }
    
    CheckAnnotationAdapter(final AnnotationVisitor annotationVisitor, final boolean named) {
        super(327680, annotationVisitor);
        this.named = named;
    }
    
    public final void visit(final String s, final Object o) {
        this.checkEnd();
        this.checkName(s);
        if (!(o instanceof Byte) && !(o instanceof Boolean) && !(o instanceof Character) && !(o instanceof Short) && !(o instanceof Integer) && !(o instanceof Long) && !(o instanceof Float) && !(o instanceof Double) && !(o instanceof String) && !(o instanceof Type) && !(o instanceof byte[]) && !(o instanceof boolean[]) && !(o instanceof char[]) && !(o instanceof short[]) && !(o instanceof int[]) && !(o instanceof long[]) && !(o instanceof float[]) && !(o instanceof double[])) {
            throw new IllegalArgumentException(CheckAnnotationAdapter.lllllIlIlI[0]);
        }
        if (o instanceof Type && ((Type)o).sort == 11) {
            throw new IllegalArgumentException(CheckAnnotationAdapter.lllllIlIlI[1]);
        }
        if (this.av != null) {
            this.av.visit(s, o);
        }
    }
    
    public final void visitEnum(final String s, final String s2, final String s3) {
        this.checkEnd();
        this.checkName(s);
        CheckMethodAdapter.checkDesc$505cbf4b(s2);
        if (s3 == null) {
            throw new IllegalArgumentException(CheckAnnotationAdapter.lllllIlIlI[2]);
        }
        if (this.av != null) {
            this.av.visitEnum(s, s2, s3);
        }
    }
    
    public final AnnotationVisitor visitAnnotation(final String s, final String s2) {
        this.checkEnd();
        this.checkName(s);
        CheckMethodAdapter.checkDesc$505cbf4b(s2);
        return new CheckAnnotationAdapter((this.av == null) ? null : this.av.visitAnnotation(s, s2));
    }
    
    public final AnnotationVisitor visitArray(final String s) {
        this.checkEnd();
        this.checkName(s);
        return new CheckAnnotationAdapter((this.av == null) ? null : this.av.visitArray(s), false);
    }
    
    public final void visitEnd() {
        this.checkEnd();
        this.end = true;
        if (this.av != null) {
            this.av.visitEnd();
        }
    }
    
    private void checkEnd() {
        if (this.end) {
            throw new IllegalStateException(CheckAnnotationAdapter.lllllIlIlI[3]);
        }
    }
    
    private void checkName(final String s) {
        if (this.named && s == null) {
            throw new IllegalArgumentException(CheckAnnotationAdapter.lllllIlIlI[4]);
        }
    }
    
    static {
        lIllIlIIIIll();
    }
    
    private static void lIllIlIIIIll() {
        (lllllIlIlI = new String[5])[0] = "Invalid annotation value";
        CheckAnnotationAdapter.lllllIlIlI[1] = "Invalid annotation value";
        CheckAnnotationAdapter.lllllIlIlI[2] = "Invalid enum value";
        CheckAnnotationAdapter.lllllIlIlI[3] = "Cannot call a visit method after visitEnd has been called";
        CheckAnnotationAdapter.lllllIlIlI[4] = "Annotation value name must not be null";
    }
    
    private static String lIllIlIIIIlI(String s, final String s2) {
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
    
    private static String lIllIlIIIIIl(final String s, final String s2) {
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
}
