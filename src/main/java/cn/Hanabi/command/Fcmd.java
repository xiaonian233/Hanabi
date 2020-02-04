package cn.Hanabi.command;

import org.jetbrains.annotations.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Fcmd extends Command
{
    private static final long c;
    private static final String d;
    private static final String[] lIIlIlllIIl;
    
    public Fcmd() {
        super("fcmd", new String[0]);
    }
    
    @Override
    public final void run(final String s, @NotNull final String[] array) {
        final int[] b = Class139.b();
        try {
            if (array.length >= 2) {
                String value = Fcmd.lIIlIlllIIl[0];
                int i = 1;
                while (i <= array.length - 1) {
                    value = String.valueOf(new StringBuilder().append(value).append(array[i]).append(Fcmd.lIIlIlllIIl[1]));
                    ++i;
                    if (b != null) {
                        return;
                    }
                    if (b != null) {
                        break;
                    }
                }
                new Class72(array[0], value).sendPacketToServer(Class206.socket.writer);
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
    
    static {
        llIlIllIllIl();
        Class169.a(5430480375984759122L, 1057418948304808205L, MethodHandles.lookup().lookupClass()).a(182531738219617L);
        final Cipher instance = Cipher.getInstance(Fcmd.lIIlIlllIIl[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Fcmd.lIIlIlllIIl[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(80765657250440L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Fcmd.lIIlIlllIIl[4].getBytes(Fcmd.lIIlIlllIIl[5]))).intern();
    }
    
    private static Exception a(final Exception ex) {
        return ex;
    }
    
    private static String a(final byte[] array) {
        int n = 0;
        final int length;
        final char[] array2 = new char[length = array.length];
        for (int i = 0; i < length; ++i) {
            final int n2;
            if ((n2 = (0xFF & array[i])) < 192) {
                array2[n++] = (char)n2;
            }
            else if (n2 < 224) {
                array2[n++] = (char)((char)((char)(n2 & 0x1F) << 6) | (char)(array[++i] & 0x3F));
            }
            else if (i < length - 2) {
                array2[n++] = (char)((char)((char)((char)(n2 & 0xF) << 12) | (char)(array[++i] & 0x3F) << 6) | (char)(array[++i] & 0x3F));
            }
        }
        return new String(array2, 0, n);
    }
    
    private static void llIlIllIllIl() {
        (lIIlIlllIIl = new String[6])[0] = "";
        Fcmd.lIIlIlllIIl[1] = " ";
        Fcmd.lIIlIlllIIl[2] = "DES/CBC/PKCS5Padding";
        Fcmd.lIIlIlllIIl[3] = "DES";
        Fcmd.lIIlIlllIIl[4] = "[\u0087Üéé\u008bð\u0015";
        Fcmd.lIIlIlllIIl[5] = "ISO-8859-1";
    }
    
    private static String llIlIllIllII(String s, final String s2) {
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
    
    private static String llIlIllIlIll(final String s, final String s2) {
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
    
    private static boolean llIlIllIlllI$255f299(final int n) {
        return n >= 2;
    }
    
    private static boolean llIlIllIllll(final int n, final int n2) {
        return n <= n2;
    }
}
