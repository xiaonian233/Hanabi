package cn.Hanabi.utils.fontmanager;

import cn.Hanabi.modules.*;
import java.awt.*;
import net.minecraft.client.*;
import net.minecraft.client.resources.*;
import ClassSub.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class FontManager
{
    public static String fontName;
    private HashMap fonts;
    public UnicodeFontRenderer comfortaa10;
    private UnicodeFontRenderer comfortaa11;
    public UnicodeFontRenderer comfortaa12;
    private UnicodeFontRenderer comfortaa13;
    public UnicodeFontRenderer comfortaa15;
    public UnicodeFontRenderer comfortaa16;
    public UnicodeFontRenderer comfortaa17;
    private UnicodeFontRenderer comfortaa18;
    private UnicodeFontRenderer comfortaa20;
    private UnicodeFontRenderer comfortaa25;
    private UnicodeFontRenderer comfortaa30;
    private UnicodeFontRenderer comfortaa35;
    private UnicodeFontRenderer comfortaa40;
    private UnicodeFontRenderer comfortaa45;
    private UnicodeFontRenderer comfortaa50;
    private UnicodeFontRenderer comfortaa70;
    private UnicodeFontRenderer raleway10;
    private UnicodeFontRenderer raleway11;
    private UnicodeFontRenderer raleway12;
    private UnicodeFontRenderer raleway13;
    private UnicodeFontRenderer raleway15;
    public UnicodeFontRenderer raleway16;
    public UnicodeFontRenderer raleway17;
    private UnicodeFontRenderer raleway18;
    private UnicodeFontRenderer raleway20;
    private UnicodeFontRenderer raleway25;
    private UnicodeFontRenderer raleway30;
    private UnicodeFontRenderer raleway35;
    private UnicodeFontRenderer raleway40;
    private UnicodeFontRenderer raleway45;
    private UnicodeFontRenderer raleway50;
    private UnicodeFontRenderer raleway70;
    private UnicodeFontRenderer usans10;
    private UnicodeFontRenderer usans11;
    private UnicodeFontRenderer usans12;
    private UnicodeFontRenderer usans13;
    private UnicodeFontRenderer usans14;
    public UnicodeFontRenderer usans15;
    public UnicodeFontRenderer usans16;
    private UnicodeFontRenderer usans17;
    public UnicodeFontRenderer usans18;
    private UnicodeFontRenderer usans19;
    private UnicodeFontRenderer usans20;
    private UnicodeFontRenderer usans21;
    private UnicodeFontRenderer usans22;
    private UnicodeFontRenderer usans23;
    private UnicodeFontRenderer usans24;
    private UnicodeFontRenderer usans25;
    private UnicodeFontRenderer usans30;
    private UnicodeFontRenderer usans35;
    private UnicodeFontRenderer usans40;
    private UnicodeFontRenderer usans45;
    private UnicodeFontRenderer usans50;
    private UnicodeFontRenderer usans70;
    private UnicodeFontRenderer icon10;
    private UnicodeFontRenderer icon11;
    private UnicodeFontRenderer icon12;
    private UnicodeFontRenderer icon13;
    private UnicodeFontRenderer icon14;
    private UnicodeFontRenderer icon15;
    public UnicodeFontRenderer icon16;
    private UnicodeFontRenderer icon17;
    private UnicodeFontRenderer icon18;
    private UnicodeFontRenderer icon19;
    public UnicodeFontRenderer icon20;
    private UnicodeFontRenderer icon21;
    private UnicodeFontRenderer icon22;
    private UnicodeFontRenderer icon23;
    private UnicodeFontRenderer icon24;
    public UnicodeFontRenderer icon25;
    public UnicodeFontRenderer icon30;
    private UnicodeFontRenderer icon35;
    private UnicodeFontRenderer icon40;
    private UnicodeFontRenderer icon45;
    private UnicodeFontRenderer icon50;
    public UnicodeFontRenderer icon70;
    public UnicodeFontRenderer icon100;
    public UnicodeFontRenderer icon130;
    private UnicodeFontRenderer alt10;
    private UnicodeFontRenderer alt11;
    private UnicodeFontRenderer alt12;
    private UnicodeFontRenderer alt13;
    private UnicodeFontRenderer alt14;
    private UnicodeFontRenderer alt15;
    private UnicodeFontRenderer alt16;
    private UnicodeFontRenderer alt17;
    private UnicodeFontRenderer alt18;
    private UnicodeFontRenderer alt19;
    private UnicodeFontRenderer alt20;
    private UnicodeFontRenderer alt21;
    private UnicodeFontRenderer alt22;
    private UnicodeFontRenderer alt23;
    private UnicodeFontRenderer alt24;
    private UnicodeFontRenderer alt25;
    private UnicodeFontRenderer alt30;
    private UnicodeFontRenderer alt35;
    private UnicodeFontRenderer alt40;
    private UnicodeFontRenderer alt45;
    private UnicodeFontRenderer alt50;
    private UnicodeFontRenderer alt70;
    private UnicodeFontRenderer alt100;
    private UnicodeFontRenderer alt130;
    public UnicodeFontRenderer wqy16;
    public UnicodeFontRenderer wqy18;
    private UnicodeFontRenderer wqy25;
    private static String[] a;
    private static final long b;
    private static final String[] c;
    private static final String[] d;
    private static final Map e;
    private static final String[] llIIIIlIIl;
    
    public FontManager() {
        super();
        this.fonts = new HashMap();
    }
    
    private void initFonts() {
        this.comfortaa10 = this.getFont("comfortaa", 10.0f);
        this.getFont("comfortaa", 11.0f);
        this.comfortaa12 = this.getFont("comfortaa", 12.0f);
        this.getFont("comfortaa", 13.0f);
        this.comfortaa15 = this.getFont("comfortaa", 15.0f);
        this.comfortaa16 = this.getFont("comfortaa", 16.0f);
        this.comfortaa17 = this.getFont("comfortaa", 17.0f);
        this.getFont("comfortaa", 18.0f);
        this.getFont("comfortaa", 20.0f);
        this.getFont("comfortaa", 25.0f);
        this.getFont("comfortaa", 30.0f);
        this.getFont("comfortaa", 35.0f);
        this.getFont("comfortaa", 40.0f);
        this.getFont("comfortaa", 45.0f);
        this.getFont("comfortaa", 50.0f);
        this.getFont("comfortaa", 70.0f);
        this.getFont("raleway", 10.0f);
        this.getFont("raleway", 11.0f);
        this.getFont("raleway", 12.0f);
        this.getFont("raleway", 13.0f);
        this.getFont("raleway", 15.0f);
        this.raleway16 = this.getFont("raleway", 16.0f);
        this.raleway17 = this.getFont("raleway", 17.0f);
        this.getFont("raleway", 18.0f);
        this.getFont("raleway", 20.0f);
        this.getFont("raleway", 25.0f);
        final String[] a = FontManager.a;
        this.getFont("raleway", 30.0f);
        this.getFont("raleway", 35.0f);
        this.getFont("raleway", 40.0f);
        this.getFont("raleway", 45.0f);
        this.getFont("raleway", 50.0f);
        this.getFont("raleway", 70.0f);
        this.getFont$6bf6f084("usans", 10.0f);
        this.getFont$6bf6f084("usans", 11.0f);
        this.getFont$6bf6f084("usans", 12.0f);
        this.getFont$6bf6f084("usans", 13.0f);
        this.getFont$6bf6f084("usans", 14.0f);
        this.usans15 = this.getFont$6bf6f084("usans", 15.0f);
        this.usans16 = this.getFont$6bf6f084("usans", 16.0f);
        this.getFont$6bf6f084("usans", 17.0f);
        this.usans18 = this.getFont$6bf6f084("usans", 18.0f);
        final String[] array = a;
        this.getFont$6bf6f084("usans", 19.0f);
        this.getFont$6bf6f084("usans", 20.0f);
        this.getFont$6bf6f084("usans", 21.0f);
        this.getFont$6bf6f084("usans", 22.0f);
        this.getFont$6bf6f084("usans", 23.0f);
        this.getFont$6bf6f084("usans", 24.0f);
        this.getFont$6bf6f084("usans", 25.0f);
        this.getFont$6bf6f084("usans", 30.0f);
        this.getFont$6bf6f084("usans", 35.0f);
        this.getFont$6bf6f084("usans", 40.0f);
        this.getFont$6bf6f084("usans", 45.0f);
        this.getFont$6bf6f084("usans", 50.0f);
        this.getFont$6bf6f084("usans", 70.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 10.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 11.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 12.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 13.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 14.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 15.0f);
        this.icon16 = this.getFontWithCustomGlyph$24c8c416("icon", 16.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 17.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 18.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 19.0f);
        this.icon20 = this.getFontWithCustomGlyph$24c8c416("icon", 20.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 21.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 22.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 23.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 24.0f);
        this.icon25 = this.getFontWithCustomGlyph$24c8c416("icon", 25.0f);
        this.icon30 = this.getFontWithCustomGlyph$24c8c416("icon", 30.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 35.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 40.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 45.0f);
        this.getFontWithCustomGlyph$24c8c416("icon", 50.0f);
        this.icon70 = this.getFontWithCustomGlyph$24c8c416("icon", 70.0f);
        this.icon100 = this.getFontWithCustomGlyph$24c8c416("icon", 100.0f);
        this.icon130 = this.getFontWithCustomGlyph$24c8c416("icon", 130.0f);
        this.wqy16 = this.getFontWithCJK("wqy_microhei", 16.0f);
        this.wqy18 = this.getFontWithCJK("wqy_microhei", 18.0f);
        this.getFontWithCJK("wqy_microhei", 25.0f);
        Class139.INSTANCE.loadFont = false;
        if (array == null) {
            Mod.b(new Mod[4]);
        }
    }
    
    public final UnicodeFontRenderer getFontWithCustomGlyph$24c8c416(final String fontName, final float n) {
        final String[] a = FontManager.a;
        FontManager.fontName = fontName;
        final String[] array = a;
        UnicodeFontRenderer unicodeFontRenderer = null;
        FontManager fontManager = this;
        final String[] array2 = array;
        try {
            Label_0077: {
                if (array2 != null) {
                    if (this.fonts.containsKey(fontName)) {
                        fontManager = this;
                        if (array == null) {
                            break Label_0077;
                        }
                        if (this.fonts.get(fontName).containsKey(n)) {
                            return this.fonts.get(fontName).get(n);
                        }
                    }
                    fontManager = this;
                }
            }
            (unicodeFontRenderer = new UnicodeFontRenderer(Font.createFont(0, fontManager.getClass().getResourceAsStream(String.valueOf(new StringBuilder("/assets/minecraft/Client/fonts/").append(fontName).append(".ttf")))).deriveFont(n), (byte)0)).func_78264_a(true);
            final UnicodeFontRenderer unicodeFontRenderer2 = unicodeFontRenderer;
            Minecraft.func_71410_x();
            unicodeFontRenderer2.func_78275_b(null.func_135044_b());
            final HashMap<Float, UnicodeFontRenderer> hashMap = new HashMap<Float, UnicodeFontRenderer>();
            HashMap hashMap3;
            final HashMap hashMap2 = hashMap3 = this.fonts;
            String s = fontName;
            if (array != null) {
                if (hashMap2.containsKey(fontName)) {
                    hashMap.putAll(this.fonts.get(fontName));
                }
                hashMap.put(n, unicodeFontRenderer);
                hashMap3 = this.fonts;
                s = fontName;
            }
            hashMap3.put(s, hashMap);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return unicodeFontRenderer;
    }
    
    public final UnicodeFontRenderer getFontWithCJK(final String fontName, final float n) {
        final String[] a = FontManager.a;
        FontManager.fontName = fontName;
        final String[] array = a;
        UnicodeFontRenderer unicodeFontRenderer = null;
        FontManager fontManager = this;
        final String[] array2 = array;
        try {
            Label_0074: {
                if (array2 != null) {
                    if (this.fonts.containsKey(fontName)) {
                        fontManager = this;
                        if (array == null) {
                            break Label_0074;
                        }
                        if (this.fonts.get(fontName).containsKey(n)) {
                            return this.fonts.get(fontName).get(n);
                        }
                    }
                    fontManager = this;
                }
            }
            (unicodeFontRenderer = new UnicodeFontRenderer(Font.createFont(0, fontManager.getClass().getResourceAsStream(String.valueOf(new StringBuilder("/assets/minecraft/Client/fonts/").append(fontName).append(".ttf")))).deriveFont(n), '\0')).func_78264_a(true);
            final UnicodeFontRenderer unicodeFontRenderer2 = unicodeFontRenderer;
            Minecraft.func_71410_x();
            unicodeFontRenderer2.func_78275_b(null.func_135044_b());
            final HashMap<Float, UnicodeFontRenderer> hashMap = new HashMap<Float, UnicodeFontRenderer>();
            HashMap hashMap3;
            final HashMap hashMap2 = hashMap3 = this.fonts;
            String s = fontName;
            if (array != null) {
                if (hashMap2.containsKey(fontName)) {
                    hashMap.putAll(this.fonts.get(fontName));
                }
                hashMap.put(n, unicodeFontRenderer);
                hashMap3 = this.fonts;
                s = fontName;
            }
            hashMap3.put(s, hashMap);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return unicodeFontRenderer;
    }
    
    public final UnicodeFontRenderer getFont$6bf6f084(final String fontName, final float n) {
        final String[] a = FontManager.a;
        FontManager.fontName = fontName;
        UnicodeFontRenderer unicodeFontRenderer = null;
        FontManager fontManager = this;
        final String[] array = a;
        try {
            Label_0074: {
                if (array != null) {
                    if (this.fonts.containsKey(fontName)) {
                        fontManager = this;
                        if (a == null) {
                            break Label_0074;
                        }
                        if (this.fonts.get(fontName).containsKey(n)) {
                            return this.fonts.get(fontName).get(n);
                        }
                    }
                    fontManager = this;
                }
            }
            (unicodeFontRenderer = new UnicodeFontRenderer(Font.createFont(0, fontManager.getClass().getResourceAsStream(String.valueOf(new StringBuilder("/assets/minecraft/Client/fonts/").append(fontName).append(".otf")))).deriveFont(n))).func_78264_a(true);
            final UnicodeFontRenderer unicodeFontRenderer2 = unicodeFontRenderer;
            Minecraft.func_71410_x();
            unicodeFontRenderer2.func_78275_b(null.func_135044_b());
            final HashMap<Float, UnicodeFontRenderer> hashMap = new HashMap<Float, UnicodeFontRenderer>();
            HashMap hashMap3;
            final HashMap hashMap2 = hashMap3 = this.fonts;
            String s = fontName;
            if (a != null) {
                if (hashMap2.containsKey(fontName)) {
                    hashMap.putAll(this.fonts.get(fontName));
                }
                hashMap.put(n, unicodeFontRenderer);
                hashMap3 = this.fonts;
                s = fontName;
            }
            hashMap3.put(s, hashMap);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return unicodeFontRenderer;
    }
    
    public final UnicodeFontRenderer getFont(final String fontName, final float n) {
        final String[] a = FontManager.a;
        FontManager.fontName = fontName;
        final String[] array = a;
        UnicodeFontRenderer unicodeFontRenderer = null;
        FontManager fontManager = this;
        final String[] array2 = array;
        try {
            Label_0074: {
                if (array2 != null) {
                    if (this.fonts.containsKey(fontName)) {
                        fontManager = this;
                        if (array == null) {
                            break Label_0074;
                        }
                        if (this.fonts.get(fontName).containsKey(n)) {
                            return this.fonts.get(fontName).get(n);
                        }
                    }
                    fontManager = this;
                }
            }
            (unicodeFontRenderer = new UnicodeFontRenderer(Font.createFont(0, fontManager.getClass().getResourceAsStream(String.valueOf(new StringBuilder("/assets/minecraft/Client/fonts/").append(fontName).append(".ttf")))).deriveFont(n))).func_78264_a(true);
            final UnicodeFontRenderer unicodeFontRenderer2 = unicodeFontRenderer;
            Minecraft.func_71410_x();
            unicodeFontRenderer2.func_78275_b(null.func_135044_b());
            final HashMap<Float, UnicodeFontRenderer> hashMap = new HashMap<Float, UnicodeFontRenderer>();
            HashMap hashMap3;
            final HashMap hashMap2 = hashMap3 = this.fonts;
            String s = fontName;
            if (array != null) {
                if (hashMap2.containsKey(fontName)) {
                    hashMap.putAll(this.fonts.get(fontName));
                }
                hashMap.put(n, unicodeFontRenderer);
                hashMap3 = this.fonts;
                s = fontName;
            }
            hashMap3.put(s, hashMap);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return unicodeFontRenderer;
    }
    
    static {
        lIIIlllIIIll();
        Class169.a(3524575727928840835L, 2590140459745285532L, MethodHandles.lookup().lookupClass()).a(120334412156318L);
        final String[] a = new String[3];
        e = new HashMap(13);
        FontManager.a = a;
        final Cipher instance = Cipher.getInstance(FontManager.llIIIIlIIl[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(FontManager.llIIIIlIIl[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(75672705890271L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] c2 = new String[15];
        int n2 = 0;
        String s;
        int n3 = (s = FontManager.llIIIIlIIl[2]).length();
        int n4 = 24;
        int n5 = -1;
    Label_0158:
        while (true) {
            while (true) {
                ++n5;
                final String s2 = s;
                final int n6 = n5;
                String s3 = s2.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(FontManager.llIIIIlIIl[4]))).intern();
                    switch (n7) {
                        default: {
                            c2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0158;
                            }
                            n3 = (s = FontManager.llIIIIlIIl[3]).length();
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
                            break Label_0158;
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
        d = new String[15];
        FontManager.fontName = FontManager.llIIIIlIIl[5];
    }
    
    public static void b(final String[] a) {
        FontManager.a = a;
    }
    
    public static String[] b() {
        return FontManager.a;
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x4031;
        if (FontManager.d[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = FontManager.e.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(FontManager.llIIIIlIIl[6]);
                    array[1] = SecretKeyFactory.getInstance(FontManager.llIIIIlIIl[7]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    FontManager.e.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(FontManager.llIIIIlIIl[8], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            FontManager.d[n3] = a(((Cipher)array[0]).doFinal(FontManager.c[n3].getBytes(FontManager.llIIIIlIIl[9])));
        }
        return FontManager.d[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'cn/Hanabi/utils/fontmanager/FontManager.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lIIIlllIIIll() {
        (llIIIIlIIl = new String[13])[0] = "DES/CBC/PKCS5Padding";
        FontManager.llIIIIlIIl[1] = "DES";
        FontManager.llIIIIlIIl[2] = "\u0006\u0005ÅÐàò^¬bG~Í\u0007@ó~«\u00ad¡°ðfÝ( Mí\u0002gÄ\u009aÿ\rç\"§%íÓ\u008b¤|\u008bÏ\u0011®Ñ\u008a}\u00983ÿ\u001a\u0094o8=\u0010\u00902Áv3»\u001d*X ³ÜË\u0082®q8~Ò³\u0006»=¥¹\f5À\r7\u0003].Ã\u008e\u001aüèÛ©:¬Èòâ± \u0010.É\u0086O¤_Ê\u0014FiÛz=í¾El½Z/7×Þ\u0081\u0089\u0010Râ¢K53à{j\u0012Ú\u0092µ\u0082ÐÂ\u0018÷¡¦X@[ß\u0013 Ë\\×d\u0097ÿ´$\u000fñ³¢è:Ò\u0010\u0093ÃÃ,ÜÎL²Fn\u008a;ã\u000ejÿ\u0010T=ÐÁgDúñ?\u009dp\u001eX²à6 \u009cs~i¥\u0004\u0017\u0080XNÏ)R\bV\u009dG\u0094]Ëy\u0004JÃþN\u0092&W&ÔN\u0010o*ù\u0013\u0086G.rE*XtÃ!¢\u000b\u0010úÎ\u00162û&\u001c¶óeô4·¿v!\u0010Èëüm£\u0091I¹\u0000¾¬\u0018XBqP\u0010\u0085ç#}l\u00888\u0010`-\u008ey´\u008a¹Î";
        FontManager.llIIIIlIIl[3] = "á#SdÊ\u00ad¾Ê\u0000Ë\u001c\u0089Ö\u0099\tÕ8«b^\u0092ñR&]ËQÍÒ÷õÞèØuDß(ºøPÍ\u0081ù\u0090-ü¸\u0000P\u0088÷}O×Ò|ãÛ±\u000f\u001bñ¦\u0091«Û\u0014~L¹\u0083n";
        FontManager.llIIIIlIIl[4] = "ISO-8859-1";
        FontManager.llIIIIlIIl[5] = "";
        FontManager.llIIIIlIIl[6] = "DES/CBC/PKCS5Padding";
        FontManager.llIIIIlIIl[7] = "DES";
        FontManager.llIIIIlIIl[8] = "cn/Hanabi/utils/fontmanager/FontManager";
        FontManager.llIIIIlIIl[9] = "ISO-8859-1";
        FontManager.llIIIIlIIl[10] = "cn/Hanabi/utils/fontmanager/FontManager";
        FontManager.llIIIIlIIl[11] = " : ";
        FontManager.llIIIIlIIl[12] = " : ";
    }
    
    private static String lIIIllIlIIIl(final String s, final String s2) {
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
    
    private static String lIIIllIlllll(String s, final String s2) {
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
    
    private static String lIIIllIlIIlI(final String s, final String s2) {
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
