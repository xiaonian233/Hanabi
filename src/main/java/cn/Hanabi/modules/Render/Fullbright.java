package cn.Hanabi.modules.Render;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.potion.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Fullbright extends Mod
{
    private Value<String> mode;
    private float oldGammaSetting;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIlIIllIIII;
    
    public Fullbright() {
        super("Fullbright", Category.RENDER);
        (this.mode = new Value<String>("Fullbright", "Mode", 0)).addValue("Gamma");
        this.mode.addValue("Potion");
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        final boolean currentMode = this.mode.isCurrentMode("Gamma");
        Fullbright fullbright = null;
        Label_0067: {
            if (b == null) {
                if (currentMode) {
                    this.setDisplayName("Gamma");
                    this.oldGammaSetting = Fullbright.mc.field_71474_y.field_74333_Y;
                    Fullbright.mc.field_71474_y.field_74333_Y = 1000.0f;
                }
                fullbright = this;
                if (b != null) {
                    break Label_0067;
                }
                this.mode.isCurrentMode("Potion");
            }
            if (!currentMode) {
                return;
            }
            fullbright = this;
        }
        fullbright.setDisplayName("Potion");
        Fullbright.mc.field_71439_g.func_70690_d(new PotionEffect(Potion.field_76439_r.func_76396_c(), 4000, 1));
    }
    
    @Override
    public final void onEnable() {
        super.onEnable();
    }
    
    @Override
    public final void onDisable() {
        Fullbright.mc.field_71474_y.field_74333_Y = this.oldGammaSetting;
        super.onDisable();
    }
    
    static {
        lllIIllllllI();
        Class169.a(-3154165387497467138L, 8874794736744725566L, MethodHandles.lookup().lookupClass()).a(8789860042507L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Fullbright.lIlIIllIIII[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Fullbright.lIlIIllIIII[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(97688603421492L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[7];
        int n2 = 0;
        String s;
        int n3 = (s = Fullbright.lIlIIllIIII[2]).length();
        int n4 = 16;
        int n5 = -1;
    Label_0150:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s3.getBytes(Fullbright.lIlIIllIIII[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = Fullbright.lIlIIllIIII[3]).length();
                            n4 = 16;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                break;
                            }
                            break Label_0150;
                        }
                    }
                    ++n5;
                    final String s4 = s;
                    final int n8 = n5;
                    s3 = s4.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        c = c2;
        d = new String[7];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7D51;
        if (Fullbright.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Fullbright.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Fullbright.lIlIIllIIII[5]);
                    array[1] = SecretKeyFactory.getInstance(Fullbright.lIlIIllIIII[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Fullbright.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Fullbright.lIlIIllIIII[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Fullbright.d[n3] = b(((Cipher)array[0]).doFinal(Fullbright.c[n3].getBytes(Fullbright.lIlIIllIIII[8])));
        }
        return Fullbright.d[n3];
    }
    
    private static void lllIIllllllI() {
        (lIlIIllIIII = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Fullbright.lIlIIllIIII[1] = "DES";
        Fullbright.lIlIIllIIII[2] = "\u0018æ ³\u0019B\u0086\u009aØÁâ\u0099?\u0018OÍ\u0010GæS\u0097NAË-\u009e)\u009bV\u0000\u0094\u009d, O\u009a\u0090ÈÓ=Ío\u0011£\u0086 \u00adiaN¸)ãòÅ³xÁù\u0095\u0084îO´A\u001a\u0010\u00ad\u0081\u0088/#Ufi§\u001aì.Ä\u009aÞ\u0010\u00105¡¿v~W½fC\u0083¾NãPê1";
        Fullbright.lIlIIllIIII[3] = " 6Î(ª\u0090\u0092û\u0099\u008e'\u009b=N×\u000b r\u0099¿dbì\u0081³\u0005Ç\u0083Þ©Å\u0005Ã(qÌ®5á²\u0016iÕó§\u000bF\u0095r";
        Fullbright.lIlIIllIIII[4] = "ISO-8859-1";
        Fullbright.lIlIIllIIII[5] = "DES/CBC/PKCS5Padding";
        Fullbright.lIlIIllIIII[6] = "DES";
        Fullbright.lIlIIllIIII[7] = "回去练几年再跟我战一次好不好呢你干什么用你稀稀拉拉的言语去大言不惭的吹嘘啊你是不是家家户户都知晓的耀武扬威窝囊废啊你继续和我开始一下华丽唠嗑可以了吗你说话好吗我求你了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u2009\u2006\u2009";
        Fullbright.lIlIIllIIII[8] = "ISO-8859-1";
        Fullbright.lIlIIllIIII[9] = "回去练几年再跟我战一次好不好呢你干什么用你稀稀拉拉的言语去大言不惭的吹嘘啊你是不是家家户户都知晓的耀武扬威窝囊废啊你继续和我开始一下华丽唠嗑可以了吗你说话好吗我求你了NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200b\u2009\u2006\u2009";
        Fullbright.lIlIIllIIII[10] = " : ";
        Fullbright.lIlIIllIIII[11] = " : ";
    }
    
    private static String lllIIllllIIl(final String s, final String s2) {
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
    
    private static String lllIIllllIII(final String s, final String s2) {
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
    
    private static String lllIIllllIlI(String s, final String s2) {
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
