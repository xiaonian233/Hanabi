package cn.Hanabi.modules.Ghost;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.entity.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.item.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class AutoClicker extends Mod
{
    private Class220 left;
    private Class220 right;
    private Random random;
    private static boolean isClicking;
    private boolean isDone;
    private int timer;
    private Value<Double> maxCps;
    private Value<Double> minCps;
    private Value<Boolean> blockHit;
    private Value<Boolean> jitter;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIIIllll;
    
    public AutoClicker() {
        super("AutoClicker", Category.GHOST);
        this.left = new Class220();
        new Class220();
        this.random = new Random();
        this.isDone = true;
        this.maxCps = new Value<Double>("AutoClicker_MaxCPS", 12.0, 1.0, 20.0, 1.0);
        this.minCps = new Value<Double>("AutoClicker_MinCPS", 8.0, 1.0, 20.0, 1.0);
        this.blockHit = new Value<Boolean>("AutoClicker_BlockHit", Boolean.FALSE);
        this.jitter = new Value<Boolean>("AutoClicker_Jitter", Boolean.FALSE);
    }
    
    @Override
    public final void onEnable() {
        this.isDone = true;
        this.timer = 0;
        super.onEnable();
    }
    
    @Override
    public final void onDisable() {
        this.isDone = true;
        super.onDisable();
    }
    
    private long getDelay() {
        return (long)((int)(Object)this.maxCps.value + this.random.nextDouble() * ((int)(Object)this.minCps.value - (int)(Object)this.maxCps.value));
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        Double n;
        final EntityPlayerSP entityPlayerSP = (EntityPlayerSP)(n = (Double)AutoClicker.mc.field_71439_g);
        int n4 = 0;
        int isDone = 0;
        Label_0512: {
            Label_0508: {
                if (b == null) {
                    if (entityPlayerSP == null) {
                        break Label_0508;
                    }
                    n = this.minCps.value;
                }
                int n3;
                final int n2 = n3 = (isDone = (n4 = (int)(Object)n));
                if (b == null) {
                    if (n2 > (int)(Object)this.maxCps.value) {
                        this.minCps.value = this.maxCps.value;
                    }
                    final int n5;
                    n3 = (n5 = (isDone = (n4 = (((IKeyBinding)AutoClicker.mc.field_71474_y.field_74312_F).getPress() ? 1 : 0))));
                }
                Label_0235: {
                    if (b == null) {
                        Label_0218: {
                            if (n2 != 0) {
                                final int n6 = n3 = (isDone = (n4 = (AutoClicker.mc.field_71439_g.func_71039_bw() ? 1 : 0)));
                                if (b != null) {
                                    break Label_0235;
                                }
                                if (n6 != 0) {
                                    final int[] b2 = Class139.b();
                                    final EntityPlayerSP field_71439_g = AutoClicker.mc.field_71439_g;
                                    Label_0214: {
                                        if (b2 == null) {
                                            if (field_71439_g.field_82175_bq) {
                                                final EntityPlayerSP field_71439_g2 = AutoClicker.mc.field_71439_g;
                                                if (b2 != null) {
                                                    break Label_0214;
                                                }
                                                if (field_71439_g2.field_110158_av < ((IEntityLivingBase)AutoClicker.mc.field_71439_g).runGetArmSwingAnimationEnd() / 2) {
                                                    final EntityPlayerSP field_71439_g3 = AutoClicker.mc.field_71439_g;
                                                    if (b2 != null) {
                                                        break Label_0214;
                                                    }
                                                    if (field_71439_g3.field_110158_av >= 0) {
                                                        break Label_0218;
                                                    }
                                                }
                                            }
                                            AutoClicker.mc.field_71439_g.field_110158_av = -1;
                                            final EntityPlayerSP field_71439_g4 = AutoClicker.mc.field_71439_g;
                                        }
                                    }
                                    field_71439_g.field_82175_bq = true;
                                }
                            }
                        }
                        isDone = (n3 = (n4 = (((IKeyBinding)AutoClicker.mc.field_71474_y.field_74312_F).getPress() ? 1 : 0)));
                    }
                }
                if (b != null) {
                    break Label_0512;
                }
                if (n3 != 0) {
                    final int n7 = isDone = (n4 = (AutoClicker.mc.field_71439_g.func_71039_bw() ? 1 : 0));
                    if (b != null) {
                        break Label_0512;
                    }
                    if (n7 == 0) {
                        final int n8 = isDone = (n4 = (this.left.isDelayComplete(Double.valueOf(1000.0 / (long)((int)(Object)this.maxCps.value + this.random.nextDouble() * ((int)(Object)this.minCps.value - (int)(Object)this.maxCps.value)))) ? 1 : 0));
                        if (b != null) {
                            break Label_0512;
                        }
                        if (n8 != 0) {
                            final boolean booleanValue = this.jitter.value;
                            if (b == null && booleanValue) {
                                final Random random = this.random;
                                final int[] b3 = Class139.b();
                                final boolean nextBoolean = random.nextBoolean();
                                if (b3 == null) {
                                    if (nextBoolean) {
                                        if (random.nextBoolean()) {
                                            final EntityPlayerSP field_71439_g5 = AutoClicker.mc.field_71439_g;
                                            field_71439_g5.field_70125_A -= (float)(random.nextFloat() * 0.6);
                                            if (b3 == null) {
                                                goto Label_0496;
                                            }
                                        }
                                        final EntityPlayerSP field_71439_g6 = AutoClicker.mc.field_71439_g;
                                        field_71439_g6.field_70125_A += (float)(random.nextFloat() * 0.6);
                                        if (b3 == null) {
                                            goto Label_0496;
                                        }
                                    }
                                    random.nextBoolean();
                                }
                                if (nextBoolean) {
                                    final EntityPlayerSP field_71439_g7 = AutoClicker.mc.field_71439_g;
                                    field_71439_g7.field_70177_z -= (float)(random.nextFloat() * 0.6);
                                    if (b3 == null) {
                                        goto Label_0496;
                                    }
                                }
                                final EntityPlayerSP field_71439_g8 = AutoClicker.mc.field_71439_g;
                                field_71439_g8.field_70177_z += (float)(random.nextFloat() * 0.6);
                                goto Label_0496;
                            }
                            this.left.lastMs = System.currentTimeMillis();
                        }
                    }
                }
            }
            n4 = (isDone = (this.isDone ? 1 : 0));
        }
        AutoClicker autoClicker = null;
        AutoClicker autoClicker2 = null;
        Label_0635: {
            if (b == null) {
                if (isDone != 0) {
                    return;
                }
                autoClicker = this;
                autoClicker2 = this;
                if (b != null) {
                    break Label_0635;
                }
                n4 = this.timer;
            }
            Label_0604: {
                switch (n4) {
                    case 0: {
                        ((IKeyBinding)AutoClicker.mc.field_71474_y.field_74313_G).setPress(Boolean.FALSE);
                        if (b != null) {
                            break Label_0604;
                        }
                        break;
                    }
                    case 1:
                    case 2: {
                        ((IKeyBinding)AutoClicker.mc.field_71474_y.field_74313_G).setPress(Boolean.TRUE);
                        if (b != null) {
                            break Label_0604;
                        }
                        break;
                    }
                    case 3: {
                        ((IKeyBinding)AutoClicker.mc.field_71474_y.field_74313_G).setPress(Boolean.FALSE);
                        this.isDone = true;
                        this.timer = -1;
                        break;
                    }
                }
            }
            autoClicker = this;
            autoClicker2 = this;
        }
        autoClicker.timer = autoClicker2.timer + 1;
    }
    
    private static void swingItemNoPacket() {
        final int[] b = Class139.b();
        final EntityPlayerSP field_71439_g = AutoClicker.mc.field_71439_g;
        Label_0093: {
            if (b == null) {
                if (field_71439_g.field_82175_bq) {
                    final EntityPlayerSP field_71439_g2 = AutoClicker.mc.field_71439_g;
                    if (b != null) {
                        break Label_0093;
                    }
                    if (field_71439_g2.field_110158_av < ((IEntityLivingBase)AutoClicker.mc.field_71439_g).runGetArmSwingAnimationEnd() / 2) {
                        final EntityPlayerSP field_71439_g3 = AutoClicker.mc.field_71439_g;
                        if (b != null) {
                            break Label_0093;
                        }
                        if (field_71439_g3.field_110158_av >= 0) {
                            return;
                        }
                    }
                }
                AutoClicker.mc.field_71439_g.field_110158_av = -1;
                final EntityPlayerSP field_71439_g4 = AutoClicker.mc.field_71439_g;
            }
        }
        field_71439_g.field_82175_bq = true;
    }
    
    @EventTarget
    private void onCrink$1d47864b() {
        final int[] b = Class139.b();
        final ItemStack func_71045_bC = AutoClicker.mc.field_71439_g.func_71045_bC();
        final int[] array = b;
        Object value;
        final ItemStack itemStack = (ItemStack)(value = func_71045_bC);
        if (array == null) {
            if (itemStack == null) {
                return;
            }
            value = this.blockHit.value;
        }
        int n3;
        int isDone;
        int n2;
        final int n = n2 = (isDone = (n3 = (((boolean)value) ? 1 : 0)));
        if (array == null) {
            if (n == 0) {
                return;
            }
            final int n4;
            n2 = (n4 = (isDone = (n3 = ((func_71045_bC.func_77973_b() instanceof ItemSword) ? 1 : 0))));
        }
        if (array == null) {
            if (n == 0) {
                return;
            }
            isDone = (n2 = (n3 = (AutoClicker.mc.field_71439_g.func_71039_bw() ? 1 : 0)));
        }
        if (array == null) {
            if (n2 != 0) {
                return;
            }
            n3 = (isDone = (this.isDone ? 1 : 0));
        }
        AutoClicker autoClicker = null;
        Label_0104: {
            if (array == null) {
                if (isDone == 0) {
                    return;
                }
                autoClicker = this;
                if (array != null) {
                    break Label_0104;
                }
                n3 = this.timer;
            }
            if (n3 <= 0) {
                autoClicker = this;
                break Label_0104;
            }
            return;
        }
        autoClicker.isDone = false;
    }
    
    private static void jitter(final Random random) {
        final int[] b = Class139.b();
        final boolean nextBoolean = random.nextBoolean();
        if (b == null) {
            if (nextBoolean) {
                if (random.nextBoolean()) {
                    final EntityPlayerSP field_71439_g = AutoClicker.mc.field_71439_g;
                    field_71439_g.field_70125_A -= (float)(random.nextFloat() * 0.6);
                    if (b == null) {
                        return;
                    }
                }
                final EntityPlayerSP field_71439_g2 = AutoClicker.mc.field_71439_g;
                field_71439_g2.field_70125_A += (float)(random.nextFloat() * 0.6);
                if (b == null) {
                    return;
                }
            }
            random.nextBoolean();
        }
        if (nextBoolean) {
            final EntityPlayerSP field_71439_g3 = AutoClicker.mc.field_71439_g;
            field_71439_g3.field_70177_z -= (float)(random.nextFloat() * 0.6);
            if (b == null) {
                return;
            }
        }
        final EntityPlayerSP field_71439_g4 = AutoClicker.mc.field_71439_g;
        field_71439_g4.field_70177_z += (float)(random.nextFloat() * 0.6);
    }
    
    static {
        lIlllIIII();
        Class169.a(-3562021093588485L, 4004240423529552805L, MethodHandles.lookup().lookupClass()).a(143289056708429L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(AutoClicker.lIIIllll[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(AutoClicker.lIIIllll[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(34955828021037L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = AutoClicker.lIIIllll[2]).length();
        int n4 = 32;
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
                    final String intern = b(instance.doFinal(s3.getBytes(AutoClicker.lIIIllll[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0150;
                            }
                            n3 = (s = AutoClicker.lIIIllll[3]).length();
                            n4 = 40;
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
        d = new String[5];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x2A5;
        if (AutoClicker.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = AutoClicker.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(AutoClicker.lIIIllll[5]);
                    array[1] = SecretKeyFactory.getInstance(AutoClicker.lIIIllll[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    AutoClicker.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(AutoClicker.lIIIllll[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            AutoClicker.d[n3] = b(((Cipher)array[0]).doFinal(AutoClicker.c[n3].getBytes(AutoClicker.lIIIllll[8])));
        }
        return AutoClicker.d[n3];
    }
    
    private static void lIlllIIII() {
        (lIIIllll = new String[12])[0] = "DES/CBC/PKCS5Padding";
        AutoClicker.lIIIllll[1] = "DES";
        AutoClicker.lIIIllll[2] = "\u000f\u009f\u008a\u001f\u0084\u0000<Ð\u0090@\u001f£ËÃc=¼£x\u008fàµÔJ?4$,\u009e>õa([P]¨I3ÊìÈWÝ\rç\u0088~ú\u0087«\u0011;\u0085\u0013uúµ\u000f=®MÜíYÁVC££\u009cÇÐ0w\u0084s°×Ý\u0080\u00106½\u0005\u001a\u0010âz\u0002R$p\u0006\u0004wÛù2NmÅÜ§6¢>f¾\u0082\u0011àÄx\u0006ß\"\u0018Y\u0096Ü?";
        AutoClicker.lIIIllll[3] = "ç³BÍð\u000ef<ß\u0006)\u0007\u0083\u0013\bi\u0010\"´ÞÁkZ\u00061\u0002µÏ\u0019È1¸MEË\u0004\u009b\u001dÐ\u0018(ÃÎ\u0092»?Zo\u001bÍ}¸\u0016ÃÆ-m\u0015\u008b×äôÅ»*\u0010éç÷°{'\u009b\u0080æHõx8 X";
        AutoClicker.lIIIllll[4] = "ISO-8859-1";
        AutoClicker.lIIIllll[5] = "DES/CBC/PKCS5Padding";
        AutoClicker.lIIIllll[6] = "DES";
        AutoClicker.lIIIllll[7] = "小伙子别悬心吊胆的啊你那弱小的身躯能承受住我那犀利的语言么你是不是想用你婆婆妈妈的词汇击败你老老实实的爹爹我啊你干什么啊在你登峰造极的爸爸我面前班门弄斧是不是啊你小心你登峰造极的爹爹我大义灭亲啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u2009\u200c\u2009";
        AutoClicker.lIIIllll[8] = "ISO-8859-1";
        AutoClicker.lIIIllll[9] = "小伙子别悬心吊胆的啊你那弱小的身躯能承受住我那犀利的语言么你是不是想用你婆婆妈妈的词汇击败你老老实实的爹爹我啊你干什么啊在你登峰造极的爸爸我面前班门弄斧是不是啊你小心你登峰造极的爹爹我大义灭亲啊NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200e\u2009\u200c\u2009";
        AutoClicker.lIIIllll[10] = " : ";
        AutoClicker.lIIIllll[11] = " : ";
    }
    
    private static String lIllIIlll(final String s, final String s2) {
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
    
    private static String lIllIlIII(String s, final String s2) {
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
    
    private static String lIllIlllI(final String s, final String s2) {
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
    
    private static boolean lIlllIlll(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIllllIll(final int n) {
        return n < 0;
    }
    
    private static boolean lIlllllII(final int n) {
        return n > 0;
    }
}
