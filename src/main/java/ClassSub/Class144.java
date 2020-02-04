package ClassSub;

import java.awt.*;
import org.jetbrains.annotations.*;
import java.util.function.*;
import net.minecraft.client.gui.*;
import org.lwjgl.opengl.*;
import cn.Hanabi.utils.fontmanager.*;
import net.minecraft.util.*;
import net.minecraft.client.audio.*;
import cn.Hanabi.modules.*;
import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class144 extends GuiScreen
{
    @NotNull
    public static Color PANEL_MAIN_COLOR;
    @NotNull
    public static Color PANEL_SECONDARY_COLOR;
    @NotNull
    private List<Class249> panels;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIIlIIlIlI;
    
    public Class144() {
        super();
        this.panels = new ArrayList<Class249>();
    }
    
    private void init() {
        final int[] b = Class139.b();
        int n = 0;
        final int[] array = b;
        final Category[] values;
        final int length = (values = Category.values()).length;
        int i = 0;
        while (i < length) {
            final Category category = values[i];
            final Class249 class249 = new Class249(category.toString(), n);
            final Class139 instance = Class139.INSTANCE;
            Class4.getModules().stream().filter(Class144::lambda$init$0).forEach((Consumer<? super Object>)Class144::lambda$init$1);
            if (array == null) {
                if (class249.buttons.size() > 0) {
                    this.panels.add(class249);
                    n += (int)120.0;
                }
                ++i;
            }
            if (array != null) {
                break;
            }
        }
    }
    
    public final void func_73863_a(final int n, final int n2, final float n3) {
        final UnicodeFontRenderer comfortaa16 = Class139.INSTANCE.fontManager.comfortaa16;
        final int[] b = Class139.b();
        final Iterator<Class249> iterator = this.panels.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            final Class249 class249;
            Gui.func_73734_a((class249 = iterator.next()).x - 2, class249.y - 2, class249.x + class249.width + 2, class249.y + 20, Class102.rainbow$134621());
            if (array != null) {
                return;
            }
            GL11.glLineWidth(class249.drag ? 2.0f : 1.0f);
            Class300.drawRect(2, class249.x - 2, class249.y - 2, class249.x + class249.width + 2, class249.y + 20, Class144.PANEL_MAIN_COLOR.hashCode());
            final String panelName = class249.panelName;
            final float n4 = class249.x + 2.0f;
            final float n5 = class249.y + 5.0f;
        Label_0188:
            while (true) {
                UnicodeFontRenderer unicodeFontRenderer = null;
                String name = null;
                float n6 = 0.0f;
                float n7 = 0.0f;
                int n8 = 0;
                unicodeFontRenderer.func_175063_a(name, n6, n7, n8);
                int i = 0;
                while (i < class249.buttons.size()) {
                    final Class158 class250 = class249.buttons.get(i);
                    Gui.func_73734_a(class249.x, class249.y + 20 + i * 20, class249.x + class249.width, class249.y + i * 20 + 40, Class144.PANEL_MAIN_COLOR.getRGB());
                    unicodeFontRenderer = comfortaa16;
                    name = class250.module.getName();
                    n6 = class249.x + 5.0f;
                    n7 = class249.y + 20 + i * 20 + 7;
                    int state;
                    n8 = (state = (class250.module.state ? 1 : 0));
                    if (array != null) {
                        continue Label_0188;
                    }
                    if (array == null) {
                        if (n8 != 0) {
                            state = 65280;
                        }
                        else {
                            state = 16777215;
                        }
                    }
                    unicodeFontRenderer.func_175063_a(name, n6, n7, state);
                    final Class158 class251 = class250;
                    final int n9 = class249.x + class249.width;
                    final int n10 = class249.y + 20 + i * 20 + 7;
                    final int x = n9;
                    final Class158 class252 = class251;
                    final int[] b2 = Class139.b();
                    int y = n10 + 1;
                    int max = 0;
                    final int[] array2 = b2;
                    final boolean isExtended = class252.isExtended;
                    if (array2 == null && isExtended) {
                        final Iterator<Class230<?>> iterator2 = class252.settings.iterator();
                        while (true) {
                            while (iterator2.hasNext()) {
                                final Class230<?> class253;
                                (class253 = iterator2.next()).update();
                                class253.setX(x);
                                class253.setY(y);
                                y += class253.getHeight() + 2;
                                max = Math.max(class253.getWidth(), max);
                                if (array2 != null) {
                                    final Iterator<Class230<?>> iterator3 = class252.settings.iterator();
                                    while (iterator3.hasNext()) {
                                        iterator3.next().draw();
                                        if (array2 != null) {
                                            goto Label_0562;
                                        }
                                    }
                                    goto Label_0562;
                                }
                                if (array2 != null) {
                                    break;
                                }
                            }
                            ++y;
                            Gui.func_73734_a(x, n10, max + x, y, Class144.PANEL_MAIN_COLOR.getRGB());
                            continue;
                        }
                    }
                    ++i;
                    if (array != null) {
                        break;
                    }
                }
                break;
            }
            final Class249 class254 = class249;
            Label_0609: {
                if (array == null) {
                    if (!class254.drag) {
                        break Label_0609;
                    }
                    class249.x = n + class249.dragX;
                }
                class254.y = n2 + class249.dragY;
            }
            if (array != null) {
                break;
            }
        }
        super.func_73863_a(n, n2, n3);
    }
    
    protected final void func_73864_a(final int n, final int n2, final int n3) throws IOException {
        final int[] b = Class139.b();
        int n4 = n3;
        if (b == null) {
            int size = 0;
            int n5 = 0;
            Label_0045: {
                if (n3 != 0) {
                    size = n3;
                    n5 = 1;
                    if (b != null) {
                        break Label_0045;
                    }
                    if (n3 != 1) {
                        return;
                    }
                }
                size = this.panels.size();
                n5 = 1;
            }
            n4 = size - n5;
        }
        int n6 = n4;
    Label_0515:
        do {
            int i = 0;
        Label_0050:
            while (i >= 0) {
                final Class249 class249 = this.panels.get(n6);
                if (b != null) {
                    return;
                }
                final Class249 class250 = class249;
                final int[] b2 = Class139.b();
                int n7 = n;
                int n8 = n;
                int n9 = n;
                int x;
                int y;
                final int n10 = y = (x = class250.x);
                int n12 = 0;
                int n13 = 0;
                Label_0173: {
                    Label_0172: {
                        if (b2 == null) {
                            if (!Class249.lIllllIlIlIl(n, n10)) {
                                break Label_0172;
                            }
                            n7 = n;
                            n8 = n;
                            n9 = n;
                            final int n11;
                            y = (n11 = (x = class250.x + class250.width));
                        }
                        if (b2 == null) {
                            if (!Class249.lIllllIlIllI(n9, n10)) {
                                break Label_0172;
                            }
                            n7 = n2;
                            n8 = n2;
                            x = (y = class250.y);
                        }
                        Label_0169: {
                            if (b2 == null) {
                                if (!Class249.lIllllIlIlIl(n8, y)) {
                                    break Label_0172;
                                }
                                n12 = n2;
                                n13 = n2;
                                n7 = n2;
                                if (b2 != null) {
                                    break Label_0169;
                                }
                                x = class250.y + 20;
                            }
                            if (!Class249.lIllllIlIllI(n7, x)) {
                                break Label_0172;
                            }
                            n12 = (n13 = 1);
                        }
                        break Label_0173;
                    }
                    n12 = (n13 = 0);
                }
                Label_0248: {
                    if (b == null) {
                        if (n13 != 0) {
                            n12 = n3;
                            if (b != null) {
                                break Label_0248;
                            }
                            if (n3 == 0) {
                                class249.drag = true;
                                final Class249 class251 = class249;
                                class251.dragX = class251.x - n;
                                final Class249 class252 = class249;
                                class252.dragY = class252.y - n2;
                                this.panels.remove(class249);
                                this.panels.add(class249);
                                if (b == null) {
                                    break;
                                }
                            }
                        }
                        n12 = 0;
                    }
                }
                int j = n12;
                while (j < class249.buttons.size()) {
                    final Class158 class253 = class249.buttons.get(j);
                    int n14;
                    int hover$6046c8d9;
                    i = (hover$6046c8d9 = (n14 = (Class158.isHover$6046c8d9(class249.x, class249.y + 20 + j * 20, class249.width, n, n2) ? 1 : 0)));
                    if (b != null) {
                        continue Label_0050;
                    }
                    Label_0420: {
                        if (b == null) {
                            if (i != 0) {
                                n14 = n3;
                                hover$6046c8d9 = n3;
                                if (b != null) {
                                    break Label_0420;
                                }
                                if (n3 == 0) {
                                    final Mod module = class253.module;
                                    final boolean state = class253.module.state;
                                    if (b == null && state) {}
                                    module.setState(state, true);
                                    this.field_146297_k.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("random.bow"), 1.0f));
                                    if (b == null) {
                                        break Label_0515;
                                    }
                                }
                            }
                            n14 = (hover$6046c8d9 = (Class158.isHover$6046c8d9(class249.x, class249.y + 20 + j * 20, class249.width, n, n2) ? 1 : 0));
                        }
                    }
                    Label_0496: {
                        if (b == null) {
                            if (hover$6046c8d9 != 0) {
                                n14 = n3;
                                if (b != null) {
                                    break Label_0496;
                                }
                                if (n3 == 1) {
                                    final Class158 class254 = class253;
                                    final boolean isExtended = class254.isExtended;
                                    if (b == null && isExtended) {}
                                    class254.isExtended = isExtended;
                                    this.field_146297_k.func_147118_V().func_147682_a((ISound)PositionedSoundRecord.func_147674_a(new ResourceLocation("random.bow"), 1.0f));
                                    if (b == null) {
                                        break Label_0515;
                                    }
                                }
                            }
                            n14 = (class253.onMouseClick(n, n2, n3) ? 1 : 0);
                        }
                    }
                    if (n14 != 0) {
                        break Label_0515;
                    }
                    ++j;
                    if (b != null) {
                        break;
                    }
                }
                --n6;
            }
            break;
        } while (b == null);
        super.func_73864_a(n, n2, n3);
    }
    
    protected final void func_146286_b(final int n, final int n2, final int n3) {
        final int[] b = Class139.b();
        final Iterator<Class249> iterator = this.panels.iterator();
        final int[] array = b;
        while (iterator.hasNext()) {
            iterator.next().drag = false;
            if (array != null) {
                return;
            }
            if (array != null) {
                break;
            }
        }
        super.func_146286_b(n, n2, n3);
    }
    
    public final void func_146281_b() {
        this.field_146297_k.field_71460_t.func_181022_b();
    }
    
    private static void lambda$init$1(final Class249 class249, final Mod mod) {
        class249.buttons.add(new Class158(mod));
    }
    
    private static boolean lambda$init$0(final Category category, final Mod mod) {
        return mod.category == category;
    }
    
    static {
        llIIIllIllII();
        Class169.a(260784240464252517L, 5294788418239737657L, MethodHandles.lookup().lookupClass()).a(21477676711911L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class144.lIIIlIIlIlI[0]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class144.lIIIlIIlIlI[1]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(56928908406669L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[2];
        int n2 = 0;
        final String s;
        final int length = (s = Class144.lIIIlIIlIlI[2]).length();
        int char1 = 32;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class144.lIIIlIIlIlI[3]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[2];
        Class144.PANEL_MAIN_COLOR = new Color(0, 0, 0, 200);
        Class144.PANEL_SECONDARY_COLOR = new Color(4359924);
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x5F5A;
        if (Class144.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class144.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class144.lIIIlIIlIlI[4]);
                    array[1] = SecretKeyFactory.getInstance(Class144.lIIIlIIlIlI[5]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class144.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class144.lIIIlIIlIlI[6], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class144.c[n3] = a(((Cipher)array[0]).doFinal(Class144.b[n3].getBytes(Class144.lIIIlIIlIlI[7])));
        }
        return Class144.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class144.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llIIIllIllII() {
        (lIIIlIIlIlI = new String[11])[0] = "DES/CBC/PKCS5Padding";
        Class144.lIIIlIIlIlI[1] = "DES";
        Class144.lIIIlIIlIlI[2] = "\u0089û\u0098\rº\u0003al\u001c}B(qOq\u0017ï\f\u0088¹wJ)\u0096\u0018Ú×ÏÈq\u0083i Ö³Ü\u0083\u0098}*_ÖÄ1!?PÆ\u0091®\u0017Æ:!¯É9Çn\u0000\u0002-\u0082G«";
        Class144.lIIIlIIlIlI[3] = "ISO-8859-1";
        Class144.lIIIlIIlIlI[4] = "DES/CBC/PKCS5Padding";
        Class144.lIIIlIIlIlI[5] = "DES";
        Class144.lIIIlIIlIlI[6] = "你怎么可以妄自菲薄啊小伙子老老实实的当你的窝囊废去啊你真的恶心到我了你这个不要脸皮的下贱痞子货是不是压的你根本无法喘息心里开始激动NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u200e\u200c\u2005";
        Class144.lIIIlIIlIlI[7] = "ISO-8859-1";
        Class144.lIIIlIIlIlI[8] = "你怎么可以妄自菲薄啊小伙子老老实实的当你的窝囊废去啊你真的恶心到我了你这个不要脸皮的下贱痞子货是不是压的你根本无法喘息心里开始激动NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2008\u200e\u200c\u2005";
        Class144.lIIIlIIlIlI[9] = " : ";
        Class144.lIIIlIIlIlI[10] = " : ";
    }
    
    private static String llIIIllIlIll(final String s, final String s2) {
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
    
    private static String llIIIllIlIIl(final String s, final String s2) {
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
    
    private static String llIIIllIlIlI(String s, final String s2) {
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
    
    private static boolean llIIlIIlIllI(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean llIIlIIlIIll(final int n) {
        return n >= 0;
    }
    
    private static boolean llIIlIIIllll(final int n) {
        return n > 0;
    }
    
    private static boolean llIIlIIlIIlI$255f299(final int n) {
        return n != 1;
    }
}
