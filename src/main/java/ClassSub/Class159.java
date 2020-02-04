package ClassSub;

import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class Class159
{
    String mask;
    final String username;
    String password;
    private static final String[] llIIlIIlIlI;
    
    public Class159(final String s, final String s2) {
        this(s, s2, Class159.llIIlIIlIlI[0]);
    }
    
    public Class159(final String username, final String password, final String mask) {
        super();
        this.mask = Class159.llIIlIIlIlI[1];
        this.username = username;
        this.password = password;
        this.mask = mask;
    }
    
    private String getMask() {
        return this.mask;
    }
    
    private String getPassword() {
        return this.password;
    }
    
    private String getUsername() {
        return this.username;
    }
    
    private void setMask(final String mask) {
        this.mask = mask;
    }
    
    private void setPassword(final String password) {
        this.password = password;
    }
    
    static {
        lIIIlIllIIIIl();
    }
    
    private static void lIIIlIllIIIIl() {
        (llIIlIIlIlI = new String[2])[0] = "";
        Class159.llIIlIIlIlI[1] = "";
    }
    
    private static String lIIIlIlIlllIl(final String s, final String s2) {
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
    
    private static String lIIIlIlIllllI(final String s, final String s2) {
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
