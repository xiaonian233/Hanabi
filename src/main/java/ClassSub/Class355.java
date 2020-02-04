package ClassSub;

import java.lang.invoke.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class Class355
{
    private static boolean verbose;
    private static boolean forcedVerbose;
    private static final String forceVerboseProperty;
    private static final String forceVerbosePropertyOnValue;
    private static Class77 logSystem;
    private static final long a;
    private static final String[] lIlIIIIlIlI;
    
    private Class355() {
        super();
    }
    
    private static void setLogSystem(final Class77 logSystem) {
        Class355.logSystem = logSystem;
    }
    
    private static void setVerbose(final boolean b) {
        final int[] b2 = Class139.b();
        final boolean forcedVerbose = Class355.forcedVerbose;
        if (b2 == null && forcedVerbose) {
            return;
        }
        Class355.verbose = forcedVerbose;
    }
    
    private static void checkVerboseLogSetting() {
        try {
            AccessController.doPrivileged((PrivilegedAction<Object>)new Class29());
        }
        catch (Throwable t) {}
    }
    
    public static void setForcedVerboseOn() {
        Class355.forcedVerbose = true;
        Class355.verbose = true;
    }
    
    private static void error(final String s, final Throwable t) {
        Class355.logSystem.error(s, t);
    }
    
    public static void error(final Throwable t) {
        Class355.logSystem.error(t);
    }
    
    public static void error(final String s) {
        Class355.logSystem.error(s);
    }
    
    public static void warn(final String s) {
        Class355.logSystem.warn(s);
    }
    
    public static void warn(final String s, final Throwable t) {
        Class355.logSystem.warn(s, t);
    }
    
    public static void info(final String s) {
        final int[] b = Class139.b();
        final boolean verbose = Class355.verbose;
        Label_0020: {
            if (b == null) {
                if (verbose) {
                    break Label_0020;
                }
                final boolean forcedVerbose = Class355.forcedVerbose;
            }
            if (!verbose) {
                return;
            }
        }
        Class355.logSystem.info(s);
    }
    
    public static void debug(final String s) {
        final int[] b = Class139.b();
        final boolean verbose = Class355.verbose;
        Label_0020: {
            if (b == null) {
                if (verbose) {
                    break Label_0020;
                }
                final boolean forcedVerbose = Class355.forcedVerbose;
            }
            if (!verbose) {
                return;
            }
        }
        Class355.logSystem.debug(s);
    }
    
    static {
        lllIIIIlIIII();
        Class169.a(8100143617847066773L, 5888955564810831515L, MethodHandles.lookup().lookupClass()).a(11298410844601L);
        final String[] array = new String[2];
        int n = 0;
        final String s;
        final int length = (s = Class355.lIlIIIIlIlI[0]).length();
        int char1 = 4;
        int n2 = -1;
        while (true) {
            final int n3 = 111;
            ++n2;
            final String s2 = s;
            final int n4 = n2;
            final char[] charArray = s2.substring(n4, n4 + char1).toCharArray();
            final int length2 = charArray.length;
            int n5 = 0;
            while (true) {
                Label_0199: {
                    if (!lllIIIIlIlll(length2, 1)) {
                        break Label_0199;
                    }
                    final int n6 = n5;
                    final char c = charArray[n6];
                    int n7 = 0;
                    switch (n5 % 7) {
                        case 0: {
                            n7 = 119;
                            break;
                        }
                        case 1: {
                            n7 = 95;
                            break;
                        }
                        case 2: {
                            n7 = 45;
                            break;
                        }
                        case 3: {
                            n7 = 110;
                            break;
                        }
                        case 4: {
                            n7 = 38;
                            break;
                        }
                        case 5: {
                            n7 = 18;
                            break;
                        }
                        default: {
                            n7 = 45;
                            break;
                        }
                    }
                    charArray[n6] = (char)(c ^ (n3 ^ n7));
                    ++n5;
                }
                if (!lllIIIIlIlll(length2, n5)) {
                    continue;
                }
                break;
            }
            array[n++] = new String(charArray).intern();
            if ((n2 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n2);
        }
        Class355.verbose = true;
        Class355.forcedVerbose = false;
        Class355.logSystem = new Class44();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static void lllIIIIlIIII() {
        (lIlIIIIlIlI = new String[] { null })[0] = "lB7d!wB%/'\u00185|Q5og\u000e.qS)//\u00120{U\u0014d;\u001f-kU\u000en.";
    }
    
    private static String lllIIIIIllll(final String s, final String s2) {
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
    
    private static boolean lllIIIIlIlll(final int n, final int n2) {
        return n <= n2;
    }
}
