package cn.Hanabi.modules.Player;

import cn.Hanabi.value.*;
import cn.Hanabi.modules.*;
import java.io.*;
import com.darkmagician6.eventapi.*;
import net.minecraft.entity.*;
import net.minecraft.client.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Teams extends Mod
{
    public static Value<Boolean> clientfriend;
    private Class220 timer;
    private static boolean clientfriendOld;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map f;
    private static final String[] lIllIllIIII;
    
    public Teams() {
        super("Teams", Category.PLAYER);
        this.timer = new Class220();
    }
    
    @Override
    public final void onDisable() {
    }
    
    @EventTarget
    private void onUpdate$3d4b95ff() {
        final int[] b = Class139.b();
        if (this.timer.isDelayComplete(3000L) && Teams.mc.field_71439_g != null) {
            Serializable s2;
            final String s = (String)(s2 = Class20.getIRCUserByNameAndType(Class206.type, Teams.username).inGamename);
            Label_0159: {
                final boolean equalsIgnoreCase;
                Label_0109: {
                    if (b == null) {
                        if (s != null) {
                            equalsIgnoreCase = s.equalsIgnoreCase(Teams.mc.field_71439_g.func_70005_c_());
                            if (b != null) {
                                break Label_0109;
                            }
                            if (equalsIgnoreCase) {
                                final boolean clientfriendOld = Teams.clientfriendOld;
                                if (b != null) {
                                    break Label_0109;
                                }
                                if (clientfriendOld == Teams.clientfriend.value) {
                                    break Label_0159;
                                }
                            }
                        }
                        s2 = Teams.clientfriend.value;
                    }
                    (boolean)s2;
                }
                Teams.clientfriendOld = equalsIgnoreCase;
                new Class324(Teams.mc.field_71439_g.func_70005_c_(), Teams.clientfriend.value ? "true" : "false").sendPacketToServer(Class206.socket.writer);
            }
            this.timer.lastMs = System.currentTimeMillis();
        }
    }
    
    private static boolean isMod(final String s) {
        if (Class206.ignMap.get(s) == null || s == null) {
            return false;
        }
        Class20.getIRCUserByNameAndType(Class206.type, Class206.ignMap.get(s));
        return false;
    }
    
    public static boolean isOnSameTeam(final Entity entity) {
        final int[] b = Class139.b();
        boolean b4;
        boolean b3;
        boolean b2 = b3 = (b4 = isMod(entity.func_70005_c_()));
        if (b == null) {
            b2 = (b3 = (b4 = Teams.clientfriend.value));
        }
        Label_0052: {
            if (b == null) {
                if (b3) {
                    b4 = (b2 = isClientFriend(entity));
                    if (b != null) {
                        break Label_0052;
                    }
                }
                b4 = (b2 = Class4.getModule("Teams").state);
            }
        }
        if (b == null) {
            Label_0198: {
                if (b2) {
                    final boolean b5 = b4 = Minecraft.func_71410_x().field_71439_g.func_145748_c_().func_150260_c().startsWith(Teams.lIllIllIIII[0]);
                    if (b != null) {
                        return b4;
                    }
                    if (b5) {
                        boolean length;
                        final int n = (length = (Minecraft.func_71410_x().field_71439_g.func_145748_c_().func_150260_c().length() != 0)) ? 1 : 0;
                        if (b == null) {
                            Label_0149: {
                                if (n > 2) {
                                    final int n2 = (b4 = (entity.func_145748_c_().func_150260_c().length() != 0)) ? 1 : 0;
                                    if (b == null) {
                                        if (n2 <= 2) {
                                            break Label_0149;
                                        }
                                        final boolean equals;
                                        b4 = (equals = Minecraft.func_71410_x().field_71439_g.func_145748_c_().func_150260_c().substring(0, 2).equals(entity.func_145748_c_().func_150260_c().substring(0, 2)));
                                    }
                                    if (b != null) {
                                        return b4;
                                    }
                                    if (n2 != 0) {
                                        return true;
                                    }
                                    break Label_0198;
                                }
                            }
                            length = false;
                        }
                        return length;
                    }
                }
            }
            b4 = false;
        }
        return b4;
    }
    
    public static boolean isClientFriend(final Entity entity) {
        isClientFriend(entity.func_70005_c_());
        return false;
    }
    
    public static boolean isClientFriend(final String s) {
        final int[] b = Class139.b();
        final boolean booleanValue = Teams.clientfriend.value;
        if (b == null) {
            if (booleanValue) {
                isMod(s);
                if (b == null) {
                    final Iterator<String> iterator = (Iterator<String>)new ArrayList<Object>(Class206.ignMap.keySet()).iterator();
                    while (iterator.hasNext()) {
                        final boolean equals;
                        final boolean b2 = equals = s.equals(iterator.next());
                        if (b != null) {
                            return equals;
                        }
                        if (b != null || b2) {
                            return b2;
                        }
                        if (b != null) {
                            break;
                        }
                    }
                    return false;
                }
            }
        }
        return booleanValue;
    }
    
    static {
        lllllIlllIlI();
        Class169.a(-2061078187231292777L, 8045814147557981916L, MethodHandles.lookup().lookupClass()).a(149146623250767L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Teams.lIllIllIIII[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Teams.lIllIllIIII[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(13880850853277L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Teams.lIllIllIIII[3]).length();
        int n4 = 16;
        int n5 = -1;
    Label_0151:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = b(instance.doFinal(s3.getBytes(Teams.lIllIllIIII[5]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0151;
                            }
                            n3 = (s = Teams.lIllIllIIII[4]).length();
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
                            break Label_0151;
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
        Teams.clientfriend = new Value<Boolean>("Teams_ClientFriends", Boolean.TRUE);
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x6F19;
        if (Teams.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Teams.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Teams.lIllIllIIII[6]);
                    array[1] = SecretKeyFactory.getInstance(Teams.lIllIllIIII[7]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Teams.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Teams.lIllIllIIII[8], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Teams.d[n3] = b(((Cipher)array[0]).doFinal(Teams.c[n3].getBytes(Teams.lIllIllIIII[9])));
        }
        return Teams.d[n3];
    }
    
    private static void lllllIlllIlI() {
        (lIllIllIIII = new String[13])[0] = "§";
        Teams.lIllIllIIII[1] = "DES/CBC/PKCS5Padding";
        Teams.lIllIllIIII[2] = "DES";
        Teams.lIllIllIIII[3] = "\u008ei6tðVÒßÆøE!å#¯:\u0010&\u001ay\u0089§¶e\ttÔ¯\u009d\u00ad-uª(¦\u001c©\u0019\u0093\u001crE\u0096´\\«iª.\u0084\u0081\u007f`³¥Äp8eË¸§·\u0018\u0089º|ý\u001e@àï\u0004â";
        Teams.lIllIllIIII[4] = "zcÖª\n0a\nE\u0081²¹Ë)\u0093Â\u0010\u0012dÖvR\u0019ÑO\r¿ çÉ/ò*";
        Teams.lIllIllIIII[5] = "ISO-8859-1";
        Teams.lIllIllIIII[6] = "DES/CBC/PKCS5Padding";
        Teams.lIllIllIIII[7] = "DES";
        Teams.lIllIllIIII[8] = "你们自己的那些手段你们自己清楚吧我草你麻痹的是不是因为只有你妈妈才能拯救你知道吗你告诉我啊你用你稀稀拉拉的言语攻击我啊你为什么总是那么无知NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u200f \u200f";
        Teams.lIllIllIIII[9] = "ISO-8859-1";
        Teams.lIllIllIIII[10] = "你们自己的那些手段你们自己清楚吧我草你麻痹的是不是因为只有你妈妈才能拯救你知道吗你告诉我啊你用你稀稀拉拉的言语攻击我啊你为什么总是那么无知NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200c\u200f \u200f";
        Teams.lIllIllIIII[11] = " : ";
        Teams.lIllIllIIII[12] = " : ";
    }
    
    private static String lllllIlIlIlI(final String s, final String s2) {
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
    
    private static String lllllIlIllII(final String s, final String s2) {
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
    
    private static String lllllIlIlllI(String s, final String s2) {
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
    
    private static boolean llllllIIlIlI$255f299(final int n) {
        return n <= 2;
    }
    
    private static boolean llllllIIlIIl$255f299(final int n) {
        return n > 2;
    }
    
    private static boolean llllllIIIllI(final int n, final int n2) {
        return n != n2;
    }
}
