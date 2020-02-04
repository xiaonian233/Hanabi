package ClassSub;

import java.net.*;
import org.jetbrains.annotations.*;
import net.minecraft.util.*;
import com.mojang.authlib.yggdrasil.*;
import com.mojang.authlib.*;
import net.minecraft.client.*;
import java.awt.*;
import org.lwjgl.input.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class0
{
    private static final Random RANDOM;
    private static final long a;
    private static final String b;
    private static final String[] llIIlllIIIl;
    
    public Class0() {
        super();
    }
    
    private static int random(final int n, final int n2) {
        final int[] b = Class139.b();
        int nextInt = n2;
        int n3 = n;
        if (b == null) {
            if (n2 <= n) {
                return n;
            }
            nextInt = Class0.RANDOM.nextInt(n2 - n);
            n3 = n;
        }
        return nextInt + n3;
    }
    
    private static Session createSession(final String username, final String password, @NotNull final Proxy proxy) throws Exception {
        final YggdrasilUserAuthentication yggdrasilUserAuthentication;
        (yggdrasilUserAuthentication = (YggdrasilUserAuthentication)new YggdrasilAuthenticationService(proxy, Class0.llIIlllIIIl[0]).createUserAuthentication(Agent.MINECRAFT)).setUsername(username);
        yggdrasilUserAuthentication.setPassword(password);
        yggdrasilUserAuthentication.logIn();
        return new Session(yggdrasilUserAuthentication.getSelectedProfile().getName(), yggdrasilUserAuthentication.getSelectedProfile().getId().toString(), yggdrasilUserAuthentication.getAuthenticatedToken(), "mojang");
    }
    
    private static double getDirection() {
        final int[] b = Class139.b();
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        final int[] array = b;
        float field_70177_z = func_71410_x.field_71439_g.field_70177_z;
        final float field_70701_bs = func_71410_x.field_71439_g.field_70701_bs;
        if (array == null && field_70701_bs < 0.0f) {
            field_70177_z += 180.0f;
            goto Label_0045;
        }
        float n = field_70701_bs;
        float n4;
        float n3;
        final float n2 = n3 = (n4 = fcmpg(func_71410_x.field_71439_g.field_70701_bs, 0.0f));
        Label_0114: {
            Label_0105: {
                if (array == null) {
                    if (n2 < 0) {
                        n = -0.5f;
                        if (array == null) {
                            break Label_0105;
                        }
                    }
                    final float n5;
                    n3 = (n5 = (n4 = fcmpl(func_71410_x.field_71439_g.field_70701_bs, 0.0f)));
                }
                if (array != null) {
                    break Label_0114;
                }
                if (n2 > 0) {
                    n = 0.5f;
                }
            }
            n4 = (n3 = fcmpl(func_71410_x.field_71439_g.field_70702_br, 0.0f));
        }
        final float field_70702_br;
        if (array == null) {
            if (n3 > 0) {
                field_70177_z -= 90.0f * n;
            }
            field_70702_br = func_71410_x.field_71439_g.field_70702_br;
            if (array != null) {
                return Math.toRadians(field_70702_br);
            }
            n4 = fcmpg(field_70702_br, 0.0f);
        }
        if (n4 < 0) {
            field_70177_z += 90.0f * n;
        }
        return Math.toRadians(field_70702_br);
    }
    
    public static Point calculateMouseLocation() {
        final Minecraft func_71410_x = Minecraft.func_71410_x();
        final int[] b = Class139.b();
        int field_74335_Z = func_71410_x.field_71474_y.field_74335_Z;
        final int[] array = b;
        final int n = field_74335_Z;
        if (array == null && n == 0) {
            field_74335_Z = 1000;
            goto Label_0027;
        }
        int i = n;
        while (i < field_74335_Z) {
            final int n2 = func_71410_x.field_71443_c / (i + 1);
            final int n3 = 320;
            if (array == null) {
                if (!lIIlIIIIIIIII(n2, n3)) {
                    break;
                }
                final int n4 = func_71410_x.field_71440_d / (i + 1);
            }
            if (!lIIlIIIIIIIII(n2, n3)) {
                break;
            }
            ++i;
            if (array != null) {
                break;
            }
        }
        return new Point(Mouse.getX() / i, func_71410_x.field_71440_d / i - Mouse.getY() / i - 1);
    }
    
    static {
        lIIIllllIllll();
        Class169.a(1083524043503981412L, 8646320095943790214L, MethodHandles.lookup().lookupClass()).a(104979161242664L);
        final Cipher instance = Cipher.getInstance(Class0.llIIlllIIIl[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class0.llIIlllIIIl[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(134474803962777L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class0.llIIlllIIIl[3].getBytes(Class0.llIIlllIIIl[4]))).intern();
        RANDOM = new Random();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
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
    
    private static void lIIIllllIllll() {
        (llIIlllIIIl = new String[5])[0] = "";
        Class0.llIIlllIIIl[1] = "DES/CBC/PKCS5Padding";
        Class0.llIIlllIIIl[2] = "DES";
        Class0.llIIlllIIIl[3] = "ÍV\u0010B\u0086óÈ\u008a";
        Class0.llIIlllIIIl[4] = "ISO-8859-1";
    }
    
    private static String lIIIllllIIlll(final String s, final String s2) {
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
    
    private static String lIIIllllIlIll(String s, final String s2) {
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
    
    private static String lIIIllllIlIlI(final String s, final String s2) {
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
    
    private static boolean lIIlIIIIIIIII(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIIlllllIllI(final int n, final int n2) {
        return n <= n2;
    }
    
    private static boolean lIIIllllllIll(final int n) {
        return n < 0;
    }
    
    private static boolean lIIIlllllllIl(final int n) {
        return n > 0;
    }
    
    private static int lIIIllllllIlI$2548a28(final float n) {
        return fcmpl(n, 0.0f);
    }
    
    private static int lIIIllllllIIl$2548a28(final float n) {
        return fcmpg(n, 0.0f);
    }
}
