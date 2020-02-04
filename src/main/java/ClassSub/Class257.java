package ClassSub;

import java.io.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class Class257
{
    private static String I;
    private String data;
    private int type$299aaa4;
    private static final long b;
    private static final String[] llIIllllII;
    
    public Class257(final String data) {
        super();
        this.data = data;
    }
    
    private String getData() {
        return this.data;
    }
    
    private void sendPacketToAllClient() {
        final int[] b = Class139.b();
        final Iterator<Class20> iterator = Class20.userList.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final Class20 class20;
            final PrintWriter printWriter = (class20 = iterator.next()).printWriter;
            Label_0052: {
                if (array == null) {
                    if (printWriter == null) {
                        break Label_0052;
                    }
                    final PrintWriter printWriter2 = class20.printWriter;
                }
                printWriter.println(this.data);
            }
            if (array != null) {
                break;
            }
        }
    }
    
    private void sendPacketToClient(final Class20 class20) {
        final int[] b = Class139.b();
        Class20 class21 = class20;
        Label_0027: {
            if (b == null) {
                if (class20 == null) {
                    break Label_0027;
                }
                class21 = class20;
            }
            class21.printWriter.println(this.data);
            if (b == null) {
                return;
            }
        }
        Class14.LOGGER.log(this.data);
    }
    
    public final void sendPacketToServer(final PrintWriter printWriter) {
        printWriter.println(this.data);
    }
    
    static {
        lIIlIllIIIlI();
        Class169.a(6740753922104401097L, 4342491694947097223L, MethodHandles.lookup().lookupClass()).a(122052629390121L);
        final int n = 51;
        final char[] charArray = Class257.llIIllllII[0].toCharArray();
        final int length = charArray.length;
        int n2 = 0;
        while (true) {
            Label_0139: {
                if (!lIIlIllIlllI(length, 1)) {
                    break Label_0139;
                }
                final int n3 = n2;
                final char c = charArray[n3];
                int n4 = 0;
                switch (n2 % 7) {
                    case 0: {
                        n4 = 38;
                        break;
                    }
                    case 1: {
                        n4 = 115;
                        break;
                    }
                    case 2: {
                        n4 = 125;
                        break;
                    }
                    case 3: {
                        n4 = 2;
                        break;
                    }
                    case 4: {
                        n4 = 5;
                        break;
                    }
                    case 5: {
                        n4 = 80;
                        break;
                    }
                    default: {
                        n4 = 120;
                        break;
                    }
                }
                charArray[n3] = (char)(c ^ (n ^ n4));
                ++n2;
            }
            if (lIIlIllIlllI(length, n2)) {
                new String(charArray).intern();
                return;
            }
            continue;
        }
    }
    
    private static RuntimeException b(final RuntimeException ex) {
        return ex;
    }
    
    private static void lIIlIllIIIlI() {
        (llIIllllII = new String[] { null })[0] = "/z";
    }
    
    private static String lIIlIlIlllll(final String s, final String s2) {
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
    
    private static boolean lIIlIllIlllI(final int n, final int n2) {
        return n <= n2;
    }
}
