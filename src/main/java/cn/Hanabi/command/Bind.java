package cn.Hanabi.command;

import cn.Hanabi.modules.*;
import org.jetbrains.annotations.*;
import org.lwjgl.input.*;
import java.util.function.*;
import java.util.stream.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import java.lang.invoke.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Bind extends Command
{
    private boolean active;
    @Nullable
    private Mod currentModule;
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] lIIIIllIll;
    
    public Bind() {
        super("bind", new String[0]);
        this.active = false;
        this.currentModule = null;
        EventManager.register(this);
    }
    
    @Override
    public final void run(final String s, @NotNull final String[] array) {
        final int[] b = Class139.b();
        String[] array2 = array;
        if (b == null) {
            if (array.length == 0) {
                throw new Class109(String.valueOf(new StringBuilder("Usage: .").append(s).append(" <module> [<none/show>]")));
            }
            final Class139 instance = Class139.INSTANCE;
            array2 = array;
        }
        final Mod module$49fab75c;
        if ((module$49fab75c = Class4.getModule$49fab75c(array2[0])) == null) {
            throw new Class109(String.valueOf(new StringBuilder("The module '").append(array[0]).append("' does not exist")));
        }
        int n2;
        int equalsIgnoreCase;
        final int n = equalsIgnoreCase = (n2 = array.length);
        if (b == null) {
            if (n <= 1) {
                this.active = true;
                this.currentModule = module$49fab75c;
                Class100.info("Please press a key");
                return;
            }
            final int n3;
            equalsIgnoreCase = (n3 = (n2 = (array[1].equalsIgnoreCase("none") ? 1 : 0)));
        }
        if (b == null) {
            if (n != 0) {
                module$49fab75c.keybind = 0;
                Class100.success(String.valueOf(new StringBuilder("§1").append(module$49fab75c.getName()).append("§7 was bound to §1NONE")));
                if (b == null) {
                    return;
                }
            }
            n2 = (equalsIgnoreCase = (array[1].equalsIgnoreCase("show") ? 1 : 0));
        }
        if (b == null) {
            if (equalsIgnoreCase != 0) {
                Class100.success(String.valueOf(new StringBuilder("§1").append(module$49fab75c.getName()).append("§7 is bound to §1").append(Keyboard.getKeyName(module$49fab75c.keybind))));
                if (b == null) {
                    return;
                }
            }
            n2 = Keyboard.getKeyIndex(array[1].toUpperCase());
        }
        final int keybind = n2;
        module$49fab75c.keybind = keybind;
        Class100.success(String.valueOf(new StringBuilder("§1").append(module$49fab75c.getName()).append("§7 was bound to §1").append(Keyboard.getKeyName(keybind))));
    }
    
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        final int[] b = Class139.b();
        String s = Bind.lIIIIllIll[0];
        final int[] array2 = b;
        int n2 = 0;
        int n3 = n;
        int length = 0;
        int n5 = 0;
        Label_0057: {
            Label_0055: {
                final int n4;
                Label_0039: {
                    Label_0038: {
                        if (array2 == null) {
                            if (n != 0) {
                                n4 = (n5 = (length = array.length));
                                if (array2 != null) {
                                    break Label_0039;
                                }
                                if (n4 != 0) {
                                    break Label_0038;
                                }
                            }
                            n3 = 1;
                        }
                        n2 = n3;
                        if (array2 == null) {
                            break Label_0055;
                        }
                    }
                    length = n;
                    n5 = n;
                }
                if (array2 != null) {
                    break Label_0057;
                }
                if (n4 == 1) {
                    n2 = 1;
                    s = array[0];
                }
            }
            length = (n5 = n2);
        }
        if (array2 == null) {
            if (n5 != 0) {
                final String s2 = s;
                final Class139 instance = Class139.INSTANCE;
                return Class4.getModules().stream().filter((Predicate<? super Object>)Bind::lambda$autocomplete$0).map((Function<? super Object, ?>)Mod::getName).collect((Collector<? super Object, ?, List<String>>)Collectors.toList());
            }
            length = n;
        }
        if (length == 2) {
            final ArrayList<String> list;
            (list = new ArrayList<String>()).add("none");
            list.add("show");
            return list;
        }
        return new ArrayList<String>();
    }
    
    @EventTarget
    private void onKey(@NotNull final EventKey eventKey) {
        final int[] b = Class139.b();
        Bind bind = this;
        if (b == null) {
            if (!this.active) {
                return;
            }
            this.currentModule.keybind = eventKey.key;
            Class100.success(String.valueOf(new StringBuilder("§1").append(this.currentModule.getName()).append("§7 was bound to §1").append(Keyboard.getKeyName(eventKey.key))));
            this.active = false;
            bind = this;
        }
        bind.currentModule = null;
    }
    
    private static boolean lambda$autocomplete$0(final String s, final Mod mod) {
        return mod.getName().toLowerCase().startsWith(s);
    }
    
    static {
        llIIIIllIll();
        Class169.a(-7662941534046043747L, 6975813776143448404L, MethodHandles.lookup().lookupClass()).a(159054461817844L);
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Bind.lIIIIllIll[1]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Bind.lIIIIllIll[2]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(125061527147583L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[18];
        int n2 = 0;
        String s;
        int n3 = (s = Bind.lIIIIllIll[3]).length();
        int n4 = 40;
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
                    final String intern = a(instance.doFinal(s3.getBytes(Bind.lIIIIllIll[5]))).intern();
                    switch (n7) {
                        default: {
                            d2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0151;
                            }
                            n3 = (s = Bind.lIIIIllIll[4]).length();
                            n4 = 32;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            d2[n2++] = intern;
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
        d = d2;
        e = new String[18];
    }
    
    private static Class109 a(final Class109 class109) {
        return class109;
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
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7667;
        if (Bind.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Bind.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Bind.lIIIIllIll[6]);
                    array[1] = SecretKeyFactory.getInstance(Bind.lIIIIllIll[7]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Bind.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Bind.lIIIIllIll[8], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Bind.e[n3] = a(((Cipher)array[0]).doFinal(Bind.d[n3].getBytes(Bind.lIIIIllIll[9])));
        }
        return Bind.e[n3];
    }
    
    private static void llIIIIllIll() {
        (lIIIIllIll = new String[13])[0] = "";
        Bind.lIIIIllIll[1] = "DES/CBC/PKCS5Padding";
        Bind.lIIIIllIll[2] = "DES";
        Bind.lIIIIllIll[3] = "\u0084\u0013Xö;^\u008aå\bØÆ\u0092Ïÿ*\u0080xK\u0016ù\u0094\u000e\u0096\u0001\u0011ÍÈð¦8ä\u009b)\b2x\u0003\u009fGÙ(Ð\u0088\u0010\u0091¤'ï\u008f\u0018=\u001bÑ\u0007jr vâë\u0007@qé\u009cCçÿ\f\u009bqì\u0002\u0092}«yjÈ§½ FCòYwó\nu¢ÊV®ÝPá\u0082\u0083¡\u0007Ñ\u0003Yý³`s\u008fH\u008c\u0083ª\u0098\u0010ì\u009c÷`\u0099\\ãÐ\u0094\u008c\u0005\u00adzÆ¥\u0099\u0010[ \u000b\u0003Ð\u009cà\u0094eÅ\u001ccv'\\\u001e\u0010ùV)ZO,#Ìa·Î¤Á®±3\u0010¡(è~Ò1Aªà\u0015\u001fi\u0090\u009d©#\u0010\u0010\u008d·z³ì\u000b¼\u0084±JTº+$\t\u0018\u000f¿È\u008f½\u0015y?¸v`\u0007RV·óza.¨þ*Ëá\u0010é\tp\u0091Vf\u0083Õ\u0011Ì]U\u0084ç,<\u0010?ðñ\u0086\u0098GûQi9w\\Ð×Çë(\u009bóR\u0097\u0015ÄLU*\u0096g\t\u0090`\u0084A\u0091»Må\u001eb¼TÛeA\u0016¾50&dÔ\u008a]Q\u0082\r\u0086\u0018\u0007e\u001e\u0084,×¬!\u009esíÍLRùd\u0096\"ÄÂ£t\u0080{\u0010È\u0017\u001e#èÊ¶$\u001c Q\u00038 \u0098x\u0010dÔ¡FKI\u0096?\u00120Éb(¯\u008cM [1\u0003Cñ\u00ad\r\u008a«\u0011+Ñ\b\n=ú2Ótí\u0019õjÔv\u0004FNý>\u0093Ç";
        Bind.lIIIIllIll[4] = "%ÒÐ6ÿ]®\u0089î}z\u007f6Ó\fB\u009a\u007fPs\u0010P\u000bL©\u008ejÐð2\"R\u0010CÆHÉ°\\5@§\u0088ñ\\\u00ad!`\u0015";
        Bind.lIIIIllIll[5] = "ISO-8859-1";
        Bind.lIIIIllIll[6] = "DES/CBC/PKCS5Padding";
        Bind.lIIIIllIll[7] = "DES";
        Bind.lIIIIllIll[8] = "你到底是怎么长大的自己是不是已经感觉无能为力了啊人身攻击难道你没发现我一直在低头注视着你吗请你拿起你的锅铲继续掂勺去好吗因为你扣字就相当于侮辱键盘NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u2003\u2009\u2009";
        Bind.lIIIIllIll[9] = "ISO-8859-1";
        Bind.lIIIIllIll[10] = "你到底是怎么长大的自己是不是已经感觉无能为力了啊人身攻击难道你没发现我一直在低头注视着你吗请你拿起你的锅铲继续掂勺去好吗因为你扣字就相当于侮辱键盘NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u2003\u2009\u2009";
        Bind.lIIIIllIll[11] = " : ";
        Bind.lIIIIllIll[12] = " : ";
    }
    
    private static String llIIIIlIllI(final String s, final String s2) {
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
    
    private static String llIIIIllIII(final String s, final String s2) {
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
    
    private static String llIIIIlIlll(String s, final String s2) {
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
    
    private static boolean llIIIlIIllI$255f299(final int n) {
        return n > 1;
    }
}
