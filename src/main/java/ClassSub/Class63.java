package ClassSub;

import net.minecraft.util.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class Class63
{
    public double x;
    public double y;
    public double z;
    private static final String[] lIIIIIllIlI;
    
    public Class63(final double x, final double y, final double z) {
        super();
        this.x = x;
        this.y = y;
        this.z = z;
    }
    
    private double getX() {
        return this.x;
    }
    
    private double getY() {
        return this.y;
    }
    
    private double getZ() {
        return this.z;
    }
    
    public final Class63 addVector(final double n, final double n2, final double n3) {
        return new Class63(this.x + n, this.y + n2, this.z + n3);
    }
    
    public final Class63 floor() {
        return new Class63(Math.floor(this.x), Math.floor(this.y), Math.floor(this.z));
    }
    
    public final double squareDistanceTo(final Class63 class63) {
        return Math.pow(class63.x - this.x, 2.0) + Math.pow(class63.y - this.y, 2.0) + Math.pow(class63.z - this.z, 2.0);
    }
    
    private Class63 add(final Class63 class63) {
        return this.addVector(class63.x, class63.y, class63.z);
    }
    
    private Vec3 mc() {
        return new Vec3(this.x, this.y, this.z);
    }
    
    @Override
    public final String toString() {
        return String.valueOf(new StringBuilder().append(Class63.lIIIIIllIlI[0]).append(this.x).append(Class63.lIIIIIllIlI[1]).append(this.y).append(Class63.lIIIIIllIlI[2]).append(this.z).append(Class63.lIIIIIllIlI[3]));
    }
    
    static {
        lIlllllIlIll();
    }
    
    private static void lIlllllIlIll() {
        (lIIIIIllIlI = new String[4])[0] = "[";
        Class63.lIIIIIllIlI[1] = ";";
        Class63.lIIIIIllIlI[2] = ";";
        Class63.lIIIIIllIlI[3] = "]";
    }
    
    private static String lIlllllIlIII(String s, final String s2) {
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
    
    private static String lIlllllIlIlI(final String s, final String s2) {
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
    
    private static String lIlllllIlIIl(final String s, final String s2) {
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
