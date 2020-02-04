package cn.Hanabi.modules.World;

import cn.Hanabi.modules.*;
import cn.Hanabi.events.*;
import net.minecraft.client.gui.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class IRC extends Mod
{
    public static Class206 client;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] llIIllIIlll;
    
    public IRC() {
        super("IRC", Category.WORLD);
    }
    
    @EventTarget
    private static void onKey(final EventKey eventKey) {
        if (eventKey.key == 52) {
            IRC.mc.func_147108_a((GuiScreen)new GuiChat());
        }
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        this.setDisplayName(String.valueOf(new StringBuilder("Online:").append(Class20.userList.size())));
    }
    
    static {
        lIIIllIllIlIl();
        Class169.a(7613122640492016498L, 2697432693543155822L, MethodHandles.lookup().lookupClass()).a(275587560679870L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(IRC.llIIllIIlll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(IRC.llIIllIIlll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(52784345374192L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = IRC.llIIllIIlll[2]).length();
        int char1 = 16;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            c2[n2++] = b(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(IRC.llIIllIIlll[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        c = c2;
        d = new String[2];
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
    
    private static String b(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x1A98;
        if (IRC.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = IRC.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(IRC.llIIllIIlll[4]);
                    array[1] = SecretKeyFactory.getInstance(IRC.llIIllIIlll[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    IRC.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(IRC.llIIllIIlll[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            IRC.d[n3] = b(((Cipher)array[0]).doFinal(IRC.c[n3].getBytes(IRC.llIIllIIlll[7])));
        }
        return IRC.d[n3];
    }
    
    private static void lIIIllIllIlIl() {
        (llIIllIIlll = new String[11])[0] = "DES/CBC/PKCS5Padding";
        IRC.llIIllIIlll[1] = "DES";
        IRC.llIIllIIlll[2] = "]\u0089dhè\u0015C\tÌ8X½\u009a\"\u001c\u0007\u0010ïd\u0004¤fmÓgþ\u009eb«¾ÌÏ#";
        IRC.llIIllIIlll[3] = "ISO-8859-1";
        IRC.llIIllIIlll[4] = "DES/CBC/PKCS5Padding";
        IRC.llIIllIIlll[5] = "DES";
        IRC.llIIllIIlll[6] = "看着你那可悲可笑的滑稽样你还和我说啥了啊我看你都无法反驳我了呢大哥最后告诉你弟弟你给我说话呢我可不喜爱你这没速度的B你可以回去多修炼几年再跟我抗衡NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c \u2004\u2005";
        IRC.llIIllIIlll[7] = "ISO-8859-1";
        IRC.llIIllIIlll[8] = "看着你那可悲可笑的滑稽样你还和我说啥了啊我看你都无法反驳我了呢大哥最后告诉你弟弟你给我说话呢我可不喜爱你这没速度的B你可以回去多修炼几年再跟我抗衡NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c \u2004\u2005";
        IRC.llIIllIIlll[9] = " : ";
        IRC.llIIllIIlll[10] = " : ";
    }
    
    private static String lIIIllIllIIII(String s, final String s2) {
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
    
    private static String lIIIllIlIlIll(final String s, final String s2) {
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
    
    private static String lIIIllIlIlIIl(final String s, final String s2) {
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
