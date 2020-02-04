package cn.Hanabi.modules.Combat;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import net.minecraft.entity.player.*;
import net.minecraft.entity.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.client.*;
import net.minecraft.client.gui.*;
import com.google.common.collect.*;
import net.minecraft.client.network.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class AntiBot extends Mod
{
    private static Value mode;
    private int count;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIlIIIII;
    
    public AntiBot() {
        super("AntiBot", Category.COMBAT);
        this.count = 0;
        AntiBot.mode.addValue("Hypixel");
        AntiBot.mode.addValue("Mineplex");
        this.setState(true);
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        final boolean currentMode = AntiBot.mode.isCurrentMode("Hypixel");
        if (b == null) {
            Label_0195: {
                if (currentMode) {
                    for (final EntityPlayer entityPlayer : AntiBot.mc.field_71441_e.field_73010_i) {
                        if (b != null) {
                            break Label_0195;
                        }
                        EntityPlayer entityPlayer3;
                        final EntityPlayer entityPlayer2 = entityPlayer3 = entityPlayer;
                        Label_0185: {
                            if (b == null) {
                                if (entityPlayer2 == AntiBot.mc.field_71439_g) {
                                    break Label_0185;
                                }
                                entityPlayer3 = entityPlayer;
                            }
                            if (entityPlayer3 != null) {
                                boolean b4;
                                boolean func_70089_S;
                                boolean b3;
                                final boolean b2 = b3 = (func_70089_S = (b4 = getTabPlayerList().contains(entityPlayer)));
                                if (b == null) {
                                    if (b2) {
                                        break Label_0185;
                                    }
                                    final boolean b5;
                                    b3 = (b5 = (func_70089_S = (b4 = entityPlayer.func_145748_c_().func_150254_d().toLowerCase().contains("[npc"))));
                                }
                                if (b == null) {
                                    if (b2) {
                                        break Label_0185;
                                    }
                                    func_70089_S = (b3 = (b4 = entityPlayer.func_145748_c_().func_150254_d().startsWith(AntiBot.lIlIIIII[0])));
                                }
                                if (b == null) {
                                    if (!b3) {
                                        break Label_0185;
                                    }
                                    b4 = (func_70089_S = entityPlayer.func_70089_S());
                                }
                                if (b == null) {
                                    if (!func_70089_S) {
                                        break Label_0185;
                                    }
                                    b4 = isHypixelNPC(entityPlayer);
                                }
                                if (!b4) {
                                    AntiBot.mc.field_71441_e.func_72900_e((Entity)entityPlayer);
                                    ++this.count;
                                }
                            }
                        }
                        if (b != null) {
                            break;
                        }
                    }
                    this.setDisplayName("Hypixel");
                }
            }
            AntiBot.mode.isCurrentMode("Mineplex");
        }
        if (currentMode) {
            this.setDisplayName("Mineplex");
        }
    }
    
    public static boolean isBot(final Entity entity) {
        final int[] b = Class139.b();
        final boolean b2 = entity instanceof EntityPlayer;
        if (b == null) {
            if (b2) {
                final boolean state = Class4.getModule("AntiBot").state;
                if (b == null) {
                    if (state) {
                        final EntityPlayer entityPlayer = (EntityPlayer)entity;
                        final boolean currentMode;
                        final boolean b3 = currentMode = AntiBot.mode.isCurrentMode("Hypixel");
                        if (b == null) {
                            if (b3) {
                                final boolean contains = getTabPlayerList().contains(entityPlayer);
                                if (b == null) {
                                    if (contains) {
                                        final boolean hypixelNPC = isHypixelNPC(entityPlayer);
                                        if (b == null) {
                                            if (!hypixelNPC) {
                                                return false;
                                            }
                                        }
                                    }
                                }
                                return contains;
                            }
                            AntiBot.mode.isCurrentMode("Mineplex");
                        }
                        final boolean naN;
                        if (b == null) {
                            if (b3) {
                                naN = Float.isNaN(entityPlayer.func_110143_aJ());
                                if (b == null) {
                                    if (!naN) {
                                        return true;
                                    }
                                }
                            }
                        }
                        return naN;
                    }
                }
            }
        }
        return b2;
    }
    
    private static List<EntityPlayer> getTabPlayerList() {
        final int[] b = Class139.b();
        final NetHandlerPlayClient field_71174_a = Minecraft.func_71410_x().field_71439_g.field_71174_a;
        final ArrayList<EntityPlayer> list = new ArrayList<EntityPlayer>();
        final int[] array = b;
        new GuiPlayerTabOverlay(Minecraft.func_71410_x(), Minecraft.func_71410_x().field_71456_v);
        for (final NetworkPlayerInfo networkPlayerInfo : null.sortedCopy((Iterable)field_71174_a.func_175106_d())) {
            if (array == null) {
                if (networkPlayerInfo == null && array == null) {
                    continue;
                }
                list.add(Minecraft.func_71410_x().field_71441_e.func_72924_a(networkPlayerInfo.func_178845_a().getName()));
            }
            if (array != null) {
                break;
            }
        }
        return list;
    }
    
    private static boolean isHypixelNPC(final EntityPlayer entityPlayer) {
        final int[] b = Class139.b();
        final String substring = entityPlayer.func_145748_c_().func_150254_d().substring(2);
        final int[] array = b;
        entityPlayer.func_95999_t();
        final boolean startsWith;
        final boolean b2 = startsWith = substring.startsWith(AntiBot.lIlIIIII[1]);
        final boolean endsWith;
        if (array == null) {
            if (!b2) {
                endsWith = substring.endsWith("§r");
                if (array != null) {
                    return (array == null && b2) || endsWith;
                }
                if (endsWith) {
                    return true;
                }
            }
            substring.contains("[NPC]");
        }
        return (array == null && b2) || endsWith;
    }
    
    static {
        llIlIIllI();
        Class169.a(6510378443330290270L, 8621790198719532787L, MethodHandles.lookup().lookupClass()).a(199729981112359L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(AntiBot.lIlIIIII[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(AntiBot.lIlIIIII[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(45790550122167L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[10];
        int n2 = 0;
        String s;
        int n3 = (s = AntiBot.lIlIIIII[4]).length();
        int n4 = 16;
        int n5 = -1;
    Label_0152:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s3.getBytes(AntiBot.lIlIIIII[6]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = AntiBot.lIlIIIII[5]).length();
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
                            break Label_0152;
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
        d = new String[10];
        AntiBot.mode = new Value("AntiBot", "Mode", 0);
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5036;
        if (AntiBot.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = AntiBot.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(AntiBot.lIlIIIII[7]);
                    array[1] = SecretKeyFactory.getInstance(AntiBot.lIlIIIII[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    AntiBot.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(AntiBot.lIlIIIII[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            AntiBot.d[n3] = b(((Cipher)array[0]).doFinal(AntiBot.c[n3].getBytes(AntiBot.lIlIIIII[10])));
        }
        return AntiBot.d[n3];
    }
    
    private static void llIlIIllI() {
        (lIlIIIII = new String[14])[0] = "§";
        AntiBot.lIlIIIII[1] = "§";
        AntiBot.lIlIIIII[2] = "DES/CBC/PKCS5Padding";
        AntiBot.lIlIIIII[3] = "DES";
        AntiBot.lIlIIIII[4] = "uw\u008d\u0090÷\u0006®`\u000e\u009c\u001f/\u0013Inx\u0010\u0087ðeÜS¨!©I\u0084úA1f\u0092\u008f\u0010F\u0093<·¥>Ûw[x\u0010¾õíÙ§ ì\u0084iR¶w`\u0012ê\u008e\u001a\u000b\u007fSa9¬)0ë\u001c\u000eÞ¡\u0092\u0001\u0098ï`j\u0080½\u0010ÂÈ©¹ÌPQÜ\"uÔ¼Ô8\u008a2\u0018Y´\u0002{`\u001a¨d\u008a½XÄ.ø©èZä\u0094T\u0080\u0018¾|\u0010¼BãÁ\u008eõÛq®yN;7Ø¥\b\u0010ö\u009a¸F>\u0093ÏfÀSt¢^ð¢Ù";
        AntiBot.lIlIIIII[5] = "hPÓ\u009aùÆ\u0083k6î(Îµvô\u0018\u0010Ì\u001f~\bÐ\u001d{¨}3\u0012x ÷ú\u0011";
        AntiBot.lIlIIIII[6] = "ISO-8859-1";
        AntiBot.lIlIIIII[7] = "DES/CBC/PKCS5Padding";
        AntiBot.lIlIIIII[8] = "DES";
        AntiBot.lIlIIIII[9] = "你不觉得你现在就像个跳梁小丑一样的在取悦我吗你见缝插针的功夫是无孔不入的你就是一个废物你懂吗你乱七八糟的告诉我好不好你这个小伙子你难以抵挡我平平淡淡的语言NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2004\u2004 ";
        AntiBot.lIlIIIII[10] = "ISO-8859-1";
        AntiBot.lIlIIIII[11] = "你不觉得你现在就像个跳梁小丑一样的在取悦我吗你见缝插针的功夫是无孔不入的你就是一个废物你懂吗你乱七八糟的告诉我好不好你这个小伙子你难以抵挡我平平淡淡的语言NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2002\u2004\u2004 ";
        AntiBot.lIlIIIII[12] = " : ";
        AntiBot.lIlIIIII[13] = " : ";
    }
    
    private static String llIlIIIIl(final String s, final String s2) {
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
    
    private static String llIlIIlII(final String s, final String s2) {
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
    
    private static String llIlIIIII(String s, final String s2) {
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
    
    private static boolean lllllIIII(final Object o, final Object o2) {
        return o != o2;
    }
}
