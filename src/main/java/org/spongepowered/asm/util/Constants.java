package org.spongepowered.asm.util;

import java.io.*;
import org.spongepowered.asm.mixin.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public abstract class Constants
{
    private static String CTOR;
    private static String CLINIT;
    private static String IMAGINARY_SUPER;
    private static String DEBUG_OUTPUT_PATH;
    private static String MIXIN_PACKAGE;
    public static final String MIXIN_PACKAGE_REF;
    private static String STRING;
    private static String OBJECT;
    private static String CLASS;
    private static String SYNTHETIC_PACKAGE;
    private static char UNICODE_SNOWMAN;
    public static final File DEBUG_OUTPUT_DIR;
    private static final String[] llIIlIIllIl;
    
    private Constants() {
        super();
    }
    
    static {
        lIIIlIllIIlIl();
        Mixin.class.getPackage().getName();
        MIXIN_PACKAGE_REF = "org.spongepowered.asm.mixin".replace('.', '/');
        DEBUG_OUTPUT_DIR = new File(Constants.llIIlIIllIl[8]);
    }
    
    private static void lIIIlIllIIlIl() {
        (llIIlIIllIl = new String[9])[0] = "<init>";
        Constants.llIIlIIllIl[1] = "Ljava/lang/Object;";
        Constants.llIIlIIllIl[2] = "Ljava/lang/String;";
        Constants.llIIlIIllIl[3] = "org.spongepowered.asm.synthetic";
        Constants.llIIlIIllIl[4] = "super$";
        Constants.llIIlIIllIl[5] = ".mixin.out";
        Constants.llIIlIIllIl[6] = "Ljava/lang/Class;";
        Constants.llIIlIIllIl[7] = "<clinit>";
        Constants.llIIlIIllIl[8] = ".mixin.out";
    }
    
    private static String lIIIlIllIIIlI(final String s, final String s2) {
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
    
    private static String lIIIlIllIIIll(final String s, final String s2) {
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
    
    private static String lIIIlIllIIlII(String s, final String s2) {
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
