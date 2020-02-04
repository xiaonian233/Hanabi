package ClassSub;

import org.jetbrains.annotations.*;
import cn.Hanabi.modules.Movement.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Render.*;
import net.minecraftforge.fml.common.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.modules.World.*;
import cn.Hanabi.modules.Player.*;
import cn.Hanabi.modules.Ghost.*;
import cn.Hanabi.hmlProject.*;
import cn.Hanabi.events.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.utils.fontmanager.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class4
{
    @NotNull
    public static List<Mod> modules;
    public static boolean needsort;
    private static ArrayList<Mod> sortedModList;
    private static ArrayList<Mod> enabledModList;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIlIIIlllIl;
    
    public Class4() {
        super();
        EventManager.register(this);
    }
    
    private static void addModules() {
        addModule(new Hitbox());
        addModule(new KeepSprint());
        addModule(new Velocity());
        addModule(new KillAura());
        addModule(new Criticals());
        addModule(new AutoSword());
        addModule(new Reach());
        addModule(new TPHit());
        addModule(new BowAimbot());
        addModule(new Sprint());
        final int[] b = Class139.b();
        addModule(new Speed());
        addModule(new Fly());
        addModule(new Strafe());
        addModule(new LongJump());
        addModule(new NoSlow());
        addModule(new FakeLag());
        final int[] array = b;
        addModule(new Step());
        addModule(new AutoArmor());
        addModule(new InvCleaner());
        addModule(new InvMove());
        addModule(new NoFall());
        addModule(new AutoAbuse());
        addModule(new Spammer());
        addModule(new StaffAnalyzer());
        addModule(new ChestStealer());
        addModule(new Nuker());
        addModule(new Blink());
        addModule(new FastPlace());
        addModule(new AutoTools());
        addModule(new AutoGG());
        addModule(new Class156("AutoPlay", Category.PLAYER));
        addModule(new Class332("NoCommand", Category.PLAYER));
        addModule(new Class3());
        addModule(new Nametags_());
        addModule(new Fullbright());
        addModule(new ESP());
        addModule(new Projectiles());
        addModule(new BedESP());
        addModule(new ChestESP());
        addModule(new HitAnimation());
        addModule(new CaveFinder());
        addModule(new Chams());
        addModule(new OreTargets());
        addModule(new NameProtect());
        addModule(new TabGUI());
        final Class263 aes_UTILS = Class139.AES_UTILS;
        final String hwid_VERIFY = Class139.HWID_VERIFY;
        try {
            final boolean contains = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
            Label_0498: {
                if (array == null) {
                    if (contains) {
                        break Label_0498;
                    }
                    FMLCommonHandler.instance().exitJava(0, true);
                }
                Class258.sleep = contains;
            }
        }
        catch (Exception ex) {
            FMLCommonHandler.instance().exitJava(0, true);
            Class258.sleep = true;
        }
        addModule(new AntiBot());
        addModule(new Teams());
        addModule(new Scaffold());
        addModule(new AntiFall());
        addModule(new AutoL());
        addModule(new IRC());
        addModule(new HideAndSeek());
        addModule(new Eagle());
        addModule(new Class102());
        addModule(new SpeedMine());
        addModule(new NoObsidian());
        addModule(new AntiSpammer());
        addModule(new TP2Bed());
        addModule(new AimAssist());
        addModule(new AutoClicker());
        addModule(new LegitVelocity());
        HMLUtils.onModManagerLoad$2eb07009();
    }
    
    public static void addModule(@NotNull final Mod mod) {
        Class4.modules.add(mod);
    }
    
    @NotNull
    public static List<Mod> getModules() {
        return Class4.modules;
    }
    
    @NotNull
    public static List<Mod> getModules(final Category category) {
        final int[] b = Class139.b();
        final ArrayList<Mod> list = new ArrayList<Mod>();
        final int[] array = b;
        final Iterator<Mod> iterator = Class4.modules.iterator();
        while (iterator.hasNext()) {
            final Mod mod;
            if (lllIIlIIllIl((mod = iterator.next()).category, category)) {
                list.add(mod);
            }
            if (array != null) {
                break;
            }
        }
        return list;
    }
    
    @NotNull
    public static <T extends Mod> T getModule(final Class<T> clazz) {
        return (T)Class4.modules.stream().filter(Class4::lambda$getModule$0).findFirst().orElse(null);
    }
    
    public static Mod getModule(@NotNull final String s) {
        try {
            return getModule$49fab75c(s);
        }
        catch (Exception ex) {
            return new Class142("NMSL", Category.COMBAT);
        }
    }
    
    public static Mod getModule$49fab75c(@NotNull final String s) {
        return Class4.modules.stream().filter(Class4::lambda$getModule$1).findFirst().orElse(null);
    }
    
    @EventTarget
    private static void onKey(@NotNull final EventKey eventKey) {
        final int[] b = Class139.b();
        final Iterator<Mod> iterator = Class4.modules.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            Mod mod3;
            final Mod mod2;
            final Mod mod = mod2 = (mod3 = iterator.next());
            Label_0068: {
                if (array == null) {
                    if (mod.keybind != eventKey.key) {
                        break Label_0068;
                    }
                    mod3 = mod2;
                }
                final boolean state = mod2.state;
                if (array == null && state) {}
                mod3.setState(state, true);
            }
            if (array != null) {
                break;
            }
        }
    }
    
    public static List<Mod> getModList() {
        return Class4.modules;
    }
    
    public static ArrayList<Mod> getEnabledModList() {
        final int[] b = Class139.b();
        final ArrayList<Mod> list = new ArrayList<Mod>();
        final Iterator<Mod> iterator = Class4.modules.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final Mod mod;
            final boolean state = (mod = iterator.next()).state;
            if (array == null) {
                if (state) {
                    list.add(mod);
                }
            }
            if (array != null) {
                break;
            }
        }
        return list;
    }
    
    public static ArrayList<Mod> getEnabledModListHUD() {
        final int[] b = Class139.b();
        if (Class4.needsort) {
            Class4.enabledModList = new ArrayList<Mod>();
            final Iterator<Mod> iterator = Class4.modules.iterator();
            while (iterator.hasNext()) {
                Class4.enabledModList.add(iterator.next());
                if (b != null) {
                    return Class4.enabledModList;
                }
                if (b != null) {
                    break;
                }
            }
            Class4.enabledModList.sort(Class4::lambda$getEnabledModListHUD$2);
            Class4.needsort = false;
        }
        return Class4.enabledModList;
    }
    
    private static int lambda$getEnabledModListHUD$2(final UnicodeFontRenderer unicodeFontRenderer, final Mod mod, final Mod mod2) {
        final int[] b = Class139.b();
        final StringBuilder append = new StringBuilder().append(mod2.getName());
        final String displayName = mod2.displayName;
        if (b == null) {
            if (displayName != null) {
                String.valueOf(new StringBuilder().append(mod2.displayName).append(".."));
            }
            else {
                final String s = Class4.lIlIIIlllIl[0];
            }
        }
        final int func_78256_a = unicodeFontRenderer.func_78256_a(String.valueOf(append.append(displayName)));
        final StringBuilder append2 = new StringBuilder().append(mod.getName());
        final String displayName2 = mod.displayName;
        if (b == null) {
            if (displayName2 != null) {
                String.valueOf(new StringBuilder().append(mod.displayName).append(".."));
            }
            else {
                final String s2 = Class4.lIlIIIlllIl[1];
            }
        }
        return func_78256_a - unicodeFontRenderer.func_78256_a(String.valueOf(append2.append(displayName2)));
    }
    
    private static boolean lambda$getModule$1(final boolean b, final String s, final Mod mod) {
        final int[] b2 = Class139.b();
        boolean equals = b;
        final boolean equalsIgnoreCase;
        if (b2 == null) {
            if (!b) {
                equalsIgnoreCase = s.equalsIgnoreCase(mod.getName());
                if (b2 != null) {
                    return equalsIgnoreCase;
                }
                if (equalsIgnoreCase) {
                    return equalsIgnoreCase;
                }
            }
            equals = s.equals(mod.getName());
        }
        if (b2 == null) {
            if (!equals) {
                return false;
            }
        }
        return equalsIgnoreCase;
    }
    
    private static boolean lambda$getModule$0(final Class clazz, final Mod mod) {
        return lllIIlIIllIl(mod.getClass(), clazz);
    }
    
    static {
        lllIIlIIlIII();
        Class169.a(7040482294207842768L, 8724188341419003151L, MethodHandles.lookup().lookupClass()).a(24436715218247L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class4.lIlIIIlllIl[2]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class4.lIlIIIlllIl[3]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(126630557060158L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class4.lIlIIIlllIl[4]).length();
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class4.lIlIIIlllIl[6]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class4.lIlIIIlllIl[5]).length();
                            n4 = 32;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
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
        b = b2;
        c = new String[5];
        Class4.modules = new ArrayList<Mod>();
        Class4.needsort = true;
        new ArrayList();
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
    
    private static String a(final int n, final long n2) {
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x7473;
        if (Class4.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class4.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class4.lIlIIIlllIl[7]);
                    array[1] = SecretKeyFactory.getInstance(Class4.lIlIIIlllIl[8]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class4.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class4.lIlIIIlllIl[9], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class4.c[n3] = a(((Cipher)array[0]).doFinal(Class4.b[n3].getBytes(Class4.lIlIIIlllIl[10])));
        }
        return Class4.c[n3];
    }
    
    private static Object a$dd29b59(final MutableCallSite mutableCallSite, final Object[] array) {
        final String a = a((int)array[0], (long)array[1]);
        mutableCallSite.setTarget(MethodHandles.dropArguments(MethodHandles.constant(String.class, a), 0, Integer.TYPE, Long.TYPE));
        return a;
    }
    
    private static CallSite a(final MethodHandles.Lookup p0, final String p1, final MethodType p2) {
        // 
        // This method could not be decompiled.
        // 
        // Could not show original bytecode, likely due to the same error.
        // 
        // The error that occurred was:
        // 
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class4.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
        //     at com.strobel.assembler.metadata.MethodReader.readBody(MethodReader.java:65)
        //     at com.strobel.assembler.metadata.MethodDefinition.tryLoadBody(MethodDefinition.java:729)
        //     at com.strobel.assembler.metadata.MethodDefinition.getBody(MethodDefinition.java:83)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:202)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:655)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:532)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:499)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:141)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:130)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:105)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at us.deathmarine.luyten.FileSaver.doSaveForgeJarDecompiled(FileSaver.java:228)
        //     at us.deathmarine.luyten.FileSaver.lambda$saveAllForgeDir$0(FileSaver.java:142)
        //     at java.lang.Thread.run(Unknown Source)
        // Caused by: java.lang.ClassCastException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private static void lllIIlIIlIII() {
        (lIlIIIlllIl = new String[14])[0] = "";
        Class4.lIlIIIlllIl[1] = "";
        Class4.lIlIIIlllIl[2] = "DES/CBC/PKCS5Padding";
        Class4.lIlIIIlllIl[3] = "DES";
        Class4.lIlIIIlllIl[4] = "Å4k\u0080cN\u008dºrfG\u0084ú?÷C {wY¿÷\u008e_c\u0084µgM{AI\u009af-\u0099¹\u0004±û\u0003#%lf3âît\u0010\u0013\u008b¢ä¼nxUC\u0088´\rÞ&\u0011S";
        Class4.lIlIIIlllIl[5] = "\u0094x@²¾Õ\u0016n7ü£è`Âà»\f$\rüR\u0015\u000b\u009c^W\u001bJ\u009f\u0085#H\u0010,b!´M'ØÿÏ?\u0085Ñ\u0084\"¯\u008a";
        Class4.lIlIIIlllIl[6] = "ISO-8859-1";
        Class4.lIlIIIlllIl[7] = "DES/CBC/PKCS5Padding";
        Class4.lIlIIIlllIl[8] = "DES";
        Class4.lIlIIIlllIl[9] = "一个被我打的手足无措的人有什么脸面再来拿出这些冠冕堂皇的措辞我求你了你有没有发现你说的都是一堆废话井底之蛙你明白我的意思么继续沉睡好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u200c\u2008\u2004";
        Class4.lIlIIIlllIl[10] = "ISO-8859-1";
        Class4.lIlIIIlllIl[11] = "一个被我打的手足无措的人有什么脸面再来拿出这些冠冕堂皇的措辞我求你了你有没有发现你说的都是一堆废话井底之蛙你明白我的意思么继续沉睡好吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u200f\u200c\u2008\u2004";
        Class4.lIlIIIlllIl[12] = " : ";
        Class4.lIlIIIlllIl[13] = " : ";
    }
    
    private static String lllIIlIIIIII(final String s, final String s2) {
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
    
    private static String lllIIIllllll(final String s, final String s2) {
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
    
    private static String lllIIlIIIIIl(String s, final String s2) {
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
    
    private static boolean lllIIlIIllIl(final Object o, final Object o2) {
        return o == o2;
    }
}
