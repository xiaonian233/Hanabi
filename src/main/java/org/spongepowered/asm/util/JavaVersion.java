package org.spongepowered.asm.util;

import java.util.regex.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public abstract class JavaVersion
{
    private static double current;
    private static final String[] llIIIIlllll;
    
    private JavaVersion() {
        super();
    }
    
    public static double current() {
        if (JavaVersion.current == 0.0) {
            final Matcher matcher;
            JavaVersion.current = ((matcher = Pattern.compile(JavaVersion.llIIIIlllll[1]).matcher(System.getProperty(JavaVersion.llIIIIlllll[0]))).find() ? Double.parseDouble(matcher.group()) : 1.6);
        }
        return JavaVersion.current;
    }
    
    private static double resolveCurrentVersion() {
        final Matcher matcher;
        if ((matcher = Pattern.compile(JavaVersion.llIIIIlllll[1]).matcher(System.getProperty(JavaVersion.llIIIIlllll[0]))).find()) {
            return Double.parseDouble(matcher.group());
        }
        return 1.6;
    }
    
    static {
        lIIIIlllIlIlI();
        JavaVersion.current = 0.0;
    }
    
    private static void lIIIIlllIlIlI() {
        (llIIIIlllll = new String[2])[0] = "java.version";
        JavaVersion.llIIIIlllll[1] = "[0-9]+\\.[0-9]+";
    }
    
    private static String lIIIIlllIIlll(final String s, final String s2) {
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
    
    private static String lIIIIlllIlIII(final String s, final String s2) {
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
    
    private static int lIIIIlllIlllI$25399e8(final double n) {
        return dcmpl(n, 0.0);
    }
}
