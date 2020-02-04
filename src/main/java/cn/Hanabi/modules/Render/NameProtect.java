package cn.Hanabi.modules.Render;

import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.network.play.server.*;
import net.minecraft.util.*;
import net.minecraft.client.*;
import net.minecraft.network.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class NameProtect extends Mod
{
    private static final long b;
    private static final String c;
    private static final String[] lIllIIIIl;
    
    public NameProtect() {
        super("NameProtect", Category.RENDER);
    }
    
    @EventTarget
    private static void onPacket(final EventPacket eventPacket) {
        final int[] b = Class139.b();
        final Minecraft mc = NameProtect.mc;
        if (b == null) {
            if (mc.field_71439_g == null) {
                return;
            }
            final Minecraft mc2 = NameProtect.mc;
        }
        if (mc.field_71441_e != null) {
            final Packet packet = eventPacket.packet;
            if (b == null) {
                if (!(packet instanceof S02PacketChat)) {
                    return;
                }
                final Packet packet2 = eventPacket.packet;
            }
            new ChatComponentText(((S02PacketChat)packet).func_148915_c().func_150254_d().replace(NameProtect.mc.field_71439_g.func_70005_c_(), NameProtect.username));
        }
    }
    
    static {
        lllIlllllI();
        Class169.a(3853153278674910146L, 6090887068866261302L, MethodHandles.lookup().lookupClass()).a(34963517311547L);
        final Cipher instance = Cipher.getInstance(NameProtect.lIllIIIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(NameProtect.lIllIIIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(58128470077868L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        b(instance.doFinal(NameProtect.lIllIIIIl[2].getBytes(NameProtect.lIllIIIIl[3]))).intern();
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
    
    private static String b(final byte[] array) {
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
    
    private static void lllIlllllI() {
        (lIllIIIIl = new String[4])[0] = "DES/CBC/PKCS5Padding";
        NameProtect.lIllIIIIl[1] = "DES";
        NameProtect.lIllIIIIl[2] = "Q\u0016\n\u009b\u0093Í\u000b\u009bÊÞL>4\u0005\u0006Ú";
        NameProtect.lIllIIIIl[3] = "ISO-8859-1";
    }
    
    private static String lllIlllIlI(final String s, final String s2) {
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
    
    private static String lllIllllIl(String s, final String s2) {
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
    
    private static String lllIlllIll(final String s, final String s2) {
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
