package ClassSub;

import java.io.*;
import java.util.*;
import java.nio.charset.*;

public final class Class196
{
    private static final String[] lIlIllIIlll;
    
    public Class196() {
        super();
    }
    
    private static Class71 getTexture(final String s, final InputStream inputStream) throws IOException {
        return getTexture(s, inputStream, false, 9729);
    }
    
    private static Class71 getTexture(final String s, final InputStream inputStream, final boolean b) throws IOException {
        return getTexture(s, inputStream, b, 9729);
    }
    
    private static Class71 getTexture(final String s, final InputStream inputStream, final int n) throws IOException {
        return getTexture(s, inputStream, false, n);
    }
    
    private static Class71 getTexture(final String s, final InputStream inputStream, final boolean b, final int n) throws IOException {
        return Class294.get().getTexture(inputStream, String.valueOf(new StringBuilder().append(inputStream.toString()).append(Class196.lIlIllIIlll[0]).append(s)), b, n);
    }
    
    static {
        llllIIlIlIlI();
    }
    
    private static void llllIIlIlIlI() {
        (lIlIllIIlll = new String[] { null })[0] = ".";
    }
    
    private static String llllIIlIlIIl(String s, final String s2) {
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
