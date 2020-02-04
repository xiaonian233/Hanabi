package ClassSub;

import org.jetbrains.annotations.*;
import cn.Hanabi.utils.fontmanager.*;
import com.darkmagician6.eventapi.*;
import cn.Hanabi.modules.Movement.*;
import cn.Hanabi.modules.*;
import cn.Hanabi.modules.Render.*;
import net.minecraftforge.fml.common.*;
import cn.Hanabi.modules.Combat.*;
import cn.Hanabi.modules.World.*;
import cn.Hanabi.modules.Player.*;
import cn.Hanabi.modules.Ghost.*;
import cn.Hanabi.hmlProject.*;
import cn.Hanabi.command.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class139
{
    @NotNull
    private static String CLIENT_NAME;
    @NotNull
    private static String CLIENT_AUTHOR;
    private static double CLIENT_VERSION_NUMBER = 2.2;
    @NotNull
    private static String CLIENT_VERSION;
    @NotNull
    private static String CLIENT_INITIALS;
    public static Class139 INSTANCE;
    public static String HWID_VERIFY;
    public static Class263 AES_UTILS;
    private Class4 moduleManager;
    public Class336 commandManager;
    public Class126 fileManager;
    public FontManager fontManager;
    public Class89 rotate;
    public boolean loadFont;
    private Class96 altFileMgr;
    public Class25 sbm;
    private HMLManager hmlManager;
    private static int[] a;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map e;
    private static final String[] lIIlllIlIlI;
    
    public Class139() {
        super();
        this.loadFont = true;
        Class139.INSTANCE = this;
    }
    
    private void startClient() {
        final int[] a = Class139.a;
        new HMLManager();
        final int[] array = a;
        this.fileManager = new Class126();
        this.commandManager = new Class336();
        new Class4();
        this.fontManager = new FontManager();
        final FontManager fontManager2;
        final FontManager fontManager = fontManager2 = this.fontManager;
        fontManager.comfortaa10 = fontManager.getFont("comfortaa", 10.0f);
        fontManager2.getFont("comfortaa", 11.0f);
        final FontManager fontManager3 = fontManager2;
        fontManager3.comfortaa12 = fontManager3.getFont("comfortaa", 12.0f);
        fontManager2.getFont("comfortaa", 13.0f);
        final FontManager fontManager4 = fontManager2;
        fontManager4.comfortaa15 = fontManager4.getFont("comfortaa", 15.0f);
        final FontManager fontManager5 = fontManager2;
        fontManager5.comfortaa16 = fontManager5.getFont("comfortaa", 16.0f);
        final FontManager fontManager6 = fontManager2;
        fontManager6.comfortaa17 = fontManager6.getFont("comfortaa", 17.0f);
        fontManager2.getFont("comfortaa", 18.0f);
        fontManager2.getFont("comfortaa", 20.0f);
        fontManager2.getFont("comfortaa", 25.0f);
        fontManager2.getFont("comfortaa", 30.0f);
        fontManager2.getFont("comfortaa", 35.0f);
        fontManager2.getFont("comfortaa", 40.0f);
        fontManager2.getFont("comfortaa", 45.0f);
        fontManager2.getFont("comfortaa", 50.0f);
        fontManager2.getFont("comfortaa", 70.0f);
        fontManager2.getFont("raleway", 10.0f);
        fontManager2.getFont("raleway", 11.0f);
        fontManager2.getFont("raleway", 12.0f);
        fontManager2.getFont("raleway", 13.0f);
        fontManager2.getFont("raleway", 15.0f);
        final FontManager fontManager7 = fontManager2;
        fontManager7.raleway16 = fontManager7.getFont("raleway", 16.0f);
        final FontManager fontManager8 = fontManager2;
        fontManager8.raleway17 = fontManager8.getFont("raleway", 17.0f);
        fontManager2.getFont("raleway", 18.0f);
        fontManager2.getFont("raleway", 20.0f);
        fontManager2.getFont("raleway", 25.0f);
        final String[] b = FontManager.b();
        fontManager2.getFont("raleway", 30.0f);
        fontManager2.getFont("raleway", 35.0f);
        fontManager2.getFont("raleway", 40.0f);
        fontManager2.getFont("raleway", 45.0f);
        fontManager2.getFont("raleway", 50.0f);
        fontManager2.getFont("raleway", 70.0f);
        fontManager2.getFont$6bf6f084("usans", 10.0f);
        fontManager2.getFont$6bf6f084("usans", 11.0f);
        fontManager2.getFont$6bf6f084("usans", 12.0f);
        fontManager2.getFont$6bf6f084("usans", 13.0f);
        fontManager2.getFont$6bf6f084("usans", 14.0f);
        final FontManager fontManager9 = fontManager2;
        fontManager9.usans15 = fontManager9.getFont$6bf6f084("usans", 15.0f);
        final FontManager fontManager10 = fontManager2;
        fontManager10.usans16 = fontManager10.getFont$6bf6f084("usans", 16.0f);
        fontManager2.getFont$6bf6f084("usans", 17.0f);
        final FontManager fontManager11 = fontManager2;
        fontManager11.usans18 = fontManager11.getFont$6bf6f084("usans", 18.0f);
        final String[] array2 = b;
        fontManager2.getFont$6bf6f084("usans", 19.0f);
        fontManager2.getFont$6bf6f084("usans", 20.0f);
        fontManager2.getFont$6bf6f084("usans", 21.0f);
        fontManager2.getFont$6bf6f084("usans", 22.0f);
        fontManager2.getFont$6bf6f084("usans", 23.0f);
        fontManager2.getFont$6bf6f084("usans", 24.0f);
        fontManager2.getFont$6bf6f084("usans", 25.0f);
        fontManager2.getFont$6bf6f084("usans", 30.0f);
        fontManager2.getFont$6bf6f084("usans", 35.0f);
        fontManager2.getFont$6bf6f084("usans", 40.0f);
        fontManager2.getFont$6bf6f084("usans", 45.0f);
        fontManager2.getFont$6bf6f084("usans", 50.0f);
        fontManager2.getFont$6bf6f084("usans", 70.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 10.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 11.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 12.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 13.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 14.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 15.0f);
        final FontManager fontManager12 = fontManager2;
        fontManager12.icon16 = fontManager12.getFontWithCustomGlyph$24c8c416("icon", 16.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 17.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 18.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 19.0f);
        final FontManager fontManager13 = fontManager2;
        fontManager13.icon20 = fontManager13.getFontWithCustomGlyph$24c8c416("icon", 20.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 21.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 22.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 23.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 24.0f);
        final FontManager fontManager14 = fontManager2;
        fontManager14.icon25 = fontManager14.getFontWithCustomGlyph$24c8c416("icon", 25.0f);
        final FontManager fontManager15 = fontManager2;
        fontManager15.icon30 = fontManager15.getFontWithCustomGlyph$24c8c416("icon", 30.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 35.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 40.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 45.0f);
        fontManager2.getFontWithCustomGlyph$24c8c416("icon", 50.0f);
        final FontManager fontManager16 = fontManager2;
        fontManager16.icon70 = fontManager16.getFontWithCustomGlyph$24c8c416("icon", 70.0f);
        final FontManager fontManager17 = fontManager2;
        fontManager17.icon100 = fontManager17.getFontWithCustomGlyph$24c8c416("icon", 100.0f);
        final FontManager fontManager18 = fontManager2;
        fontManager18.icon130 = fontManager18.getFontWithCustomGlyph$24c8c416("icon", 130.0f);
        final FontManager fontManager19 = fontManager2;
        fontManager19.wqy16 = fontManager19.getFontWithCJK("wqy_microhei", 16.0f);
        final FontManager fontManager20 = fontManager2;
        fontManager20.wqy18 = fontManager20.getFontWithCJK("wqy_microhei", 18.0f);
        fontManager2.getFontWithCJK("wqy_microhei", 25.0f);
        Class139.INSTANCE.loadFont = false;
        if (array2 == null) {
            Mod.b(new Mod[4]);
        }
        EventManager.register(this.rotate = new Class89());
        EventManager.register(new Class315());
        new Class96();
        Class96.loadFiles();
        Class23.notifications.clear();
        final int[] array3 = array;
        try {
            if (array3 == null) {
                Class139.HWID_VERIFY = (Class139.AES_UTILS = new Class263(15)).encrypt(Class94.getHWID());
                Class4.addModule(new Hitbox());
                Class4.addModule(new KeepSprint());
                Class4.addModule(new Velocity());
                Class4.addModule(new KillAura());
                Class4.addModule(new Criticals());
                Class4.addModule(new AutoSword());
                Class4.addModule(new Reach());
                Class4.addModule(new TPHit());
                Class4.addModule(new BowAimbot());
                Class4.addModule(new Sprint());
                final int[] a2 = Class139.a;
                Class4.addModule(new Speed());
                Class4.addModule(new Fly());
                Class4.addModule(new Strafe());
                Class4.addModule(new LongJump());
                Class4.addModule(new NoSlow());
                Class4.addModule(new FakeLag());
                final int[] array4 = a2;
                Class4.addModule(new Step());
                Class4.addModule(new AutoArmor());
                Class4.addModule(new InvCleaner());
                Class4.addModule(new InvMove());
                Class4.addModule(new NoFall());
                Class4.addModule(new AutoAbuse());
                Class4.addModule(new Spammer());
                Class4.addModule(new StaffAnalyzer());
                Class4.addModule(new ChestStealer());
                Class4.addModule(new Nuker());
                Class4.addModule(new Blink());
                Class4.addModule(new FastPlace());
                Class4.addModule(new AutoTools());
                Class4.addModule(new AutoGG());
                Class4.addModule(new Class156("AutoPlay", Category.PLAYER));
                Class4.addModule(new Class332("NoCommand", Category.PLAYER));
                Class4.addModule(new Class3());
                Class4.addModule(new Nametags_());
                Class4.addModule(new Fullbright());
                Class4.addModule(new ESP());
                Class4.addModule(new Projectiles());
                Class4.addModule(new BedESP());
                Class4.addModule(new ChestESP());
                Class4.addModule(new HitAnimation());
                Class4.addModule(new CaveFinder());
                Class4.addModule(new Chams());
                Class4.addModule(new OreTargets());
                Class4.addModule(new NameProtect());
                Class4.addModule(new TabGUI());
                final Class263 aes_UTILS = Class139.AES_UTILS;
                final String hwid_VERIFY = Class139.HWID_VERIFY;
                try {
                    final boolean contains = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
                    Label_1430: {
                        if (array4 == null) {
                            if (contains) {
                                break Label_1430;
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
                Class4.addModule(new AntiBot());
                Class4.addModule(new Teams());
                Class4.addModule(new Scaffold());
                Class4.addModule(new AntiFall());
                Class4.addModule(new AutoL());
                Class4.addModule(new IRC());
                Class4.addModule(new HideAndSeek());
                Class4.addModule(new Eagle());
                Class4.addModule(new Class102());
                Class4.addModule(new SpeedMine());
                Class4.addModule(new NoObsidian());
                Class4.addModule(new AntiSpammer());
                Class4.addModule(new TP2Bed());
                Class4.addModule(new AimAssist());
                Class4.addModule(new AutoClicker());
                Class4.addModule(new LegitVelocity());
                HMLUtils.onModManagerLoad$2eb07009();
            }
            final Class336 commandManager;
            (commandManager = this.commandManager).addCommand(new Class152());
            commandManager.addCommand(new Bind());
            commandManager.addCommand(new Class248());
            commandManager.addCommand(new Class133());
            commandManager.addCommand(new Class224());
            commandManager.addCommand(new Class345());
            commandManager.addCommand(new Binds());
            commandManager.addCommand(new Config());
            commandManager.addCommand(new Fcmd());
            commandManager.addCommand(new Crash());
            commandManager.addCommand(new Checkuser());
            commandManager.addCommand(new Whois());
            HMLUtils.onCommandManagerLoad(commandManager);
        }
        catch (Exception ex2) {
            FMLCommonHandler.instance().exitJava(0, true);
            Class258.sleep = true;
        }
        this.fileManager.load();
    }
    
    private void stopClient() {
        try {
            this.fileManager.save();
        }
        catch (Exception ex) {
            System.err.println("Failed to save settings:");
            ex.printStackTrace();
        }
    }
    
    static {
        llIlllIllIlI();
        Class169.a(8321975931723248704L, 3273614210399299324L, MethodHandles.lookup().lookupClass()).a(33444213171002L);
        final int[] a = null;
        e = new HashMap(13);
        Class139.a = a;
        final Cipher instance = Cipher.getInstance(Class139.lIIlllIlIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class139.lIIlllIlIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(114987165857390L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[5];
        int n2 = 0;
        String s;
        int n3 = (s = Class139.lIIlllIlIlI[2]).length();
        int n4 = 16;
        int n5 = -1;
    Label_0154:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class139.lIIlllIlIlI[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0154;
                            }
                            n3 = (s = Class139.lIIlllIlIlI[3]).length();
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
                            break Label_0154;
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
        final ArrayList<Character> list = new ArrayList<Character>();
        char[] charArray;
        for (int length = (charArray = "Hanabi".toCharArray()).length, j = 0; j < length; ++j) {
            final char c3;
            if (Character.toUpperCase(c3 = charArray[j]) == c3) {
                list.add(c3);
            }
        }
        final char[] array2 = new char[list.size()];
        for (int k = 0; k < list.size(); ++k) {
            array2[k] = (char)list.get(k);
        }
        new String(array2);
    }
    
    public static void b(final int[] a) {
        Class139.a = a;
    }
    
    public static int[] b() {
        return Class139.a;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x43B1;
        if (Class139.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class139.e.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class139.lIIlllIlIlI[5]);
                    array[1] = SecretKeyFactory.getInstance(Class139.lIIlllIlIlI[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class139.e.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class139.lIIlllIlIlI[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class139.d[n3] = a(((Cipher)array[0]).doFinal(Class139.c[n3].getBytes(Class139.lIIlllIlIlI[8])));
        }
        return Class139.d[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class139.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llIlllIllIlI() {
        (lIIlllIlIlI = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class139.lIIlllIlIlI[1] = "DES";
        Class139.lIIlllIlIlI[2] = "8B¨qÇfùqù&¶\u001eU_²¿\u0010Ä`\u0019x¾´û\u0085ðT\u000bGp\u008b¤\u001c8æFÌ\u0001f¤R²3Ñ7\tÅ^Ò½\u0019¹\u001cN4#fV\u0088.KM-Z\u0095A\u001e\u0011&Þg´\u0096½Ñ\u0086\u008dÂ\u0014T8O¯\u0006õ:\u0080\u007f\u0091P";
        Class139.lIIlllIlIlI[3] = "\u0004Ëä»\u008aû-\u001d¶g\b\u0091ã\u00844æ å%ük\u0002/[n¾\u0095O®Äô|\u008c\u00adóAvÌÒëT%¡\u0002<\u0011§\u0018\u000b";
        Class139.lIIlllIlIlI[4] = "ISO-8859-1";
        Class139.lIIlllIlIlI[5] = "DES/CBC/PKCS5Padding";
        Class139.lIIlllIlIlI[6] = "DES";
        Class139.lIIlllIlIlI[7] = "我这不是问你吗你是不是听不懂你登峰造极的爹爹说的话啊从地球到太阳都有我的光在火星看到我你肯定是继续躲盖好你的棺材门其实你根本不敢回击我的是不是NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2004\u2003\u200a\u2003";
        Class139.lIIlllIlIlI[8] = "ISO-8859-1";
        Class139.lIIlllIlIlI[9] = "我这不是问你吗你是不是听不懂你登峰造极的爹爹说的话啊从地球到太阳都有我的光在火星看到我你肯定是继续躲盖好你的棺材门其实你根本不敢回击我的是不是NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2004\u2003\u200a\u2003";
        Class139.lIIlllIlIlI[10] = " : ";
        Class139.lIIlllIlIlI[11] = " : ";
    }
    
    private static String llIlllIlIIlI(final String s, final String s2) {
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
    
    private static String llIlllIlIIIl(String s, final String s2) {
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
    
    private static String llIlllIlIlIl(final String s, final String s2) {
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
