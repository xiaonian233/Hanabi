package ClassSub;

import java.io.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class Class316 extends Class349
{
    private static final long b;
    private static final String[] lllIIIIII;
    
    public Class316(final String s) {
        super(s);
    }
    
    @Override
    public final void loadFile() throws IOException {
        final int[] b = Class139.b();
        final BufferedReader bufferedReader = new BufferedReader(new FileReader(this.getFile()));
        final int[] array = b;
        String line;
        String[] split;
        int i;
        int length;
        Label_0132_Outer:Label_0151_Outer:
        while ((line = bufferedReader.readLine()) != null) {
            split = line.split(Class316.lllIIIIII[0]);
            if (array != null) {
                return;
            }
            i = 0;
        Label_0151:
            while (true) {
                while (true) {
                    while (i < 2) {
                        split[i].replace(Class316.lllIIIIII[1], Class316.lllIIIIII[2]);
                        ++i;
                        if (array == null) {
                            if (array != null) {
                                break;
                            }
                            continue Label_0132_Outer;
                        }
                        else {
                            Class312.registry.add(new Class159(split[0], split[1]));
                            if (array != null) {
                                break Label_0132_Outer;
                            }
                            continue Label_0132_Outer;
                        }
                    }
                    length = split.length;
                    if (array != null) {
                        continue Label_0151;
                    }
                    if (length <= 2) {
                        continue Label_0151_Outer;
                    }
                    Class312.registry.add(new Class159(split[0], split[1], split[2]));
                    if (array != null) {
                        continue Label_0151_Outer;
                    }
                    break;
                }
                continue Label_0151;
            }
        }
        bufferedReader.close();
    }
    
    @Override
    public final void saveFile() throws IOException {
        final int[] b = Class139.b();
        final PrintWriter printWriter = new PrintWriter(new FileWriter(this.getFile()));
        final Iterator<Class159> iterator = Class312.registry.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final Class159 class159 = iterator.next();
            if (array != null) {
                return;
            }
            Label_0180: {
                Label_0121: {
                    if (array == null) {
                        if (!class159.mask.equals(Class316.lllIIIIII[3])) {
                            break Label_0121;
                        }
                        printWriter.println(String.valueOf(new StringBuilder().append(String.valueOf(class159.username)).append(Class316.lllIIIIII[4]).append(class159.password)));
                    }
                    if (array == null) {
                        break Label_0180;
                    }
                }
                printWriter.println(String.valueOf(new StringBuilder().append(String.valueOf(class159.username)).append(Class316.lllIIIIII[5]).append(class159.password).append(Class316.lllIIIIII[6]).append(class159.mask)));
            }
            if (array != null) {
                break;
            }
        }
        printWriter.close();
    }
    
    static {
        lIIlllllIll();
        Class169.a(-1694858467271543929L, 2515519262403942018L, MethodHandles.lookup().lookupClass()).a(150109728183179L);
    }
    
    private static IOException a(final IOException ex) {
        return ex;
    }
    
    private static void lIIlllllIll() {
        (lllIIIIII = new String[7])[0] = ":";
        Class316.lllIIIIII[1] = " ";
        Class316.lllIIIIII[2] = "";
        Class316.lllIIIIII[3] = "";
        Class316.lllIIIIII[4] = ":";
        Class316.lllIIIIII[5] = ":";
        Class316.lllIIIIII[6] = ":";
    }
    
    private static String lIIlllllIIl(final String s, final String s2) {
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
    
    private static String lIIlllllIlI(String s, final String s2) {
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
    
    private static String lIIlllllIII(final String s, final String s2) {
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
    
    private static boolean lIlIIIIIIlI$255f299(final int n) {
        return n > 2;
    }
}
