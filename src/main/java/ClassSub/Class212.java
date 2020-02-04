package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.value.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.entity.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import java.util.*;
import javax.crypto.spec.*;

public final class Class212
{
    public Minecraft mc;
    public Value<Double> timer;
    private static final long a;
    private static final String b;
    private static final String[] llIIIlIIIII;
    
    public Class212() {
        super();
        this.mc = Minecraft.func_71410_x();
        this.timer = new Value<Double>("Fly_MotionSpeed", 1.0, 1.0, 10.0, 1.0);
    }
    
    private void onPre() {
        final int[] b = Class139.b();
        this.mc.field_71439_g.field_70181_x = 0.0;
        final int[] array = b;
        Label_0053: {
            Label_0049: {
                if (b == null) {
                    if (!Class333.MovementInput()) {
                        break Label_0049;
                    }
                    Class333.setSpeed(this.timer.value * 0.5);
                }
                if (array == null) {
                    break Label_0053;
                }
            }
            Class333.setSpeed(0.0);
        }
        final boolean press = ((IKeyBinding)this.mc.field_71474_y.field_74311_E).getPress();
        final Minecraft mc;
        Label_0127: {
            if (array == null) {
                if (press) {
                    final EntityPlayerSP field_71439_g = this.mc.field_71439_g;
                    --field_71439_g.field_70181_x;
                    if (array == null) {
                        return;
                    }
                }
                mc = this.mc;
                if (array != null) {
                    break Label_0127;
                }
                ((IKeyBinding)mc.field_71474_y.field_74314_A).getPress();
            }
            if (!press) {
                return;
            }
            final Minecraft mc2 = this.mc;
        }
        final EntityPlayerSP field_71439_g2 = mc.field_71439_g;
        ++field_71439_g2.field_70181_x;
    }
    
    static {
        lIIIIlllIllIl();
        Class169.a(3852168550196129940L, 224398022980935893L, MethodHandles.lookup().lookupClass()).a(81238418842110L);
        final Cipher instance = Cipher.getInstance(Class212.llIIIlIIIII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class212.llIIIlIIIII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(64552167210879L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        a(instance.doFinal(Class212.llIIIlIIIII[2].getBytes(Class212.llIIIlIIIII[3]))).intern();
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
    
    private static void lIIIIlllIllIl() {
        (llIIIlIIIII = new String[4])[0] = "DES/CBC/PKCS5Padding";
        Class212.llIIIlIIIII[1] = "DES";
        Class212.llIIIlIIIII[2] = ".\u008e\u0016¸\u0016>ÆæÛ\u009aàéíe\u0088Á";
        Class212.llIIIlIIIII[3] = "ISO-8859-1";
    }
    
    private static String lIIIIlllIlIll(String s, final String s2) {
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
    
    private static String lIIIIlllIlIIl(final String s, final String s2) {
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
    
    private static String lIIIIlllIllII(final String s, final String s2) {
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
