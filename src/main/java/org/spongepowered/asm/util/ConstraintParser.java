package org.spongepowered.asm.util;

import org.spongepowered.asm.lib.tree.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.regex.*;
import org.spongepowered.asm.util.throwables.*;
import java.util.*;

public final class ConstraintParser
{
    private static final String[] lIllllIlII;
    
    private ConstraintParser() {
        super();
    }
    
    public static Constraint parse(final String s) {
        if (s == null || s.length() == 0) {
            return Constraint.NONE;
        }
        final String[] split = s.replaceAll(ConstraintParser.lIllllIlII[0], ConstraintParser.lIllllIlII[1]).toUpperCase().split(ConstraintParser.lIllllIlII[2]);
        Constraint constraint = null;
        for (int length = split.length, i = 0; i < length; ++i) {
            final Constraint constraint2 = new Constraint(split[i]);
            if (constraint == null) {
                constraint = constraint2;
            }
            else {
                final Constraint constraint3 = constraint;
                final Constraint next = constraint2;
                Constraint next2;
                for (next2 = constraint3; next2.next != null; next2 = next2.next) {}
                next2.next = next;
            }
        }
        if (constraint != null) {
            return constraint;
        }
        return Constraint.NONE;
    }
    
    public static Constraint parse(final AnnotationNode annotationNode) {
        return parse(Annotations.getValue(annotationNode, ConstraintParser.lIllllIlII[3], ConstraintParser.lIllllIlII[4]));
    }
    
    static {
        lIIIlIlIlIII();
    }
    
    private static void lIIIlIlIlIII() {
        (lIllllIlII = new String[5])[0] = "\\s";
        ConstraintParser.lIllllIlII[1] = "";
        ConstraintParser.lIllllIlII[2] = ";";
        ConstraintParser.lIllllIlII[3] = "constraints";
        ConstraintParser.lIllllIlII[4] = "";
    }
    
    private static String lIIIlIlIIlll(String s, final String s2) {
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
    
    private static String lIIIlIlIIIII(final String s, final String s2) {
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
}
