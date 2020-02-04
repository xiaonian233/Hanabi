package ClassSub;

import com.google.common.base.*;
import net.minecraft.scoreboard.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

final class Class219 implements Predicate<Score>
{
    private Class25 this$0;
    private static final long a;
    private static final String[] lIIIllIIlII;
    
    Class219() {
        super();
    }
    
    private static boolean apply(final Score score) {
        final int[] b = Class139.b();
        final String func_96653_e = score.func_96653_e();
        if (b == null) {
            if (func_96653_e == null) {
                return false;
            }
            score.func_96653_e();
        }
        final boolean startsWith = func_96653_e.startsWith(Class219.lIIIllIIlII[0]);
        if (b != null || startsWith) {
            return startsWith;
        }
        return false;
    }
    
    public final /* bridge */ boolean apply(final Object o) {
        final Score score = (Score)o;
        final int[] b = Class139.b();
        final String func_96653_e = score.func_96653_e();
        if (b == null) {
            if (func_96653_e == null) {
                return false;
            }
            score.func_96653_e();
        }
        final boolean startsWith = func_96653_e.startsWith(Class219.lIIIllIIlII[0]);
        if (b != null || startsWith) {
            return startsWith;
        }
        return false;
    }
    
    static {
        llIIlIllllII();
        Class169.a(-8838104728915877547L, 815371861009587896L, MethodHandles.lookup().lookupClass()).a(43912237256683L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static void llIIlIllllII() {
        (lIIIllIIlII = new String[] { null })[0] = "#";
    }
    
    private static String llIIlIlllIll(final String s, final String s2) {
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
