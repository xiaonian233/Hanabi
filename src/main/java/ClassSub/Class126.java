package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.modules.*;
import org.lwjgl.input.*;
import net.minecraftforge.fml.common.*;
import cn.Hanabi.value.*;
import java.io.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.security.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class126
{
    private String fileDir;
    private Minecraft mc;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIlIIIllIl;
    
    public Class126() {
        final int[] b = Class139.b();
        super();
        this.mc = Minecraft.func_71410_x();
        this.fileDir = String.valueOf(new StringBuilder().append(this.mc.field_71412_D.getAbsolutePath()).append(Class126.lIIlIIIllIl[0]).append("Hanabi"));
        final File file = new File(this.fileDir);
        final int[] array = b;
        final boolean exists = file.exists();
        if (array == null) {
            if (!exists) {
                file.mkdirs();
            }
        }
    }
    
    public final void save() throws Exception {
        final int[] b = Class139.b();
        final File file = new File(String.valueOf(new StringBuilder().append(this.fileDir).append("/keys.txt")));
        final File file2 = new File(String.valueOf(new StringBuilder().append(this.fileDir).append("/mods.txt")));
        final File file3 = new File(String.valueOf(new StringBuilder().append(this.fileDir).append("/values.txt")));
        final int[] array = b;
        final File file4 = file;
        try {
            final boolean exists = file4.exists();
            if (array == null) {
                if (!exists) {
                    file.createNewFile();
                }
            }
            final PrintWriter printWriter = new PrintWriter(file);
            final Class139 instance = Class139.INSTANCE;
            final Iterator<Mod> iterator = Class4.getModules().iterator();
            Label_0261: {
                while (iterator.hasNext()) {
                    final Mod mod;
                    final int keybind;
                    final int contains;
                    final int n = contains = (keybind = (mod = iterator.next()).keybind);
                    if (array != null) {
                        break Label_0261;
                    }
                    String keyName = null;
                    Label_0192: {
                        if (array == null) {
                            if (n < 0) {
                                keyName = "None";
                                break Label_0192;
                            }
                            final int keybind2 = mod.keybind;
                        }
                        keyName = Keyboard.getKeyName(n);
                    }
                    printWriter.write(String.valueOf(new StringBuilder().append(mod.getName()).append(Class126.lIIlIIIllIl[1]).append(keyName).append(Class126.lIIlIIIllIl[2])));
                    if (array != null) {
                        break;
                    }
                }
                printWriter.close();
                final Class263 aes_UTILS = Class139.AES_UTILS;
                final String hwid_VERIFY = Class139.HWID_VERIFY;
                try {
                    final int contains;
                    int keybind = contains = (aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID()) ? 1 : 0);
                    Label_0280: {
                        if (array == null) {
                            if (contains != 0) {
                                break Label_0280;
                            }
                            FMLCommonHandler.instance().exitJava(0, true);
                            keybind = (true ? 1 : 0);
                        }
                        Class258.sleep = (keybind != 0);
                    }
                }
                catch (Exception ex2) {
                    FMLCommonHandler.instance().exitJava(0, true);
                    Class258.sleep = true;
                }
            }
            final boolean exists2 = file2.exists();
            if (array == null) {
                if (!exists2) {
                    file2.createNewFile();
                }
            }
            final PrintWriter printWriter2 = new PrintWriter(file2);
            final Class139 instance2 = Class139.INSTANCE;
            while (true) {
                while (true) {
                    for (final Mod mod2 : Class4.getModules()) {
                        printWriter2.print(String.valueOf(new StringBuilder().append(mod2.getName()).append(Class126.lIIlIIIllIl[3]).append(mod2.state).append(Class126.lIIlIIIllIl[4])));
                        if (array != null) {
                            if (!file3.exists()) {
                                file3.createNewFile();
                            }
                            final PrintWriter printWriter3 = new PrintWriter(file3);
                            final PrintWriter printWriter5;
                            final PrintWriter printWriter4 = printWriter5;
                            final Iterator<Value> iterator3 = Value.list.iterator();
                            while (iterator3.hasNext()) {
                                final Value value;
                                final String name = (value = iterator3.next()).name;
                                if (array != null) {
                                    return;
                                }
                                boolean b3;
                                final boolean b2 = b3 = value.isValueBoolean;
                                if (array == null) {
                                    if (b2) {
                                        printWriter4.print(String.valueOf(new StringBuilder().append(name).append(":b:").append(value.value).append(Class126.lIIlIIIllIl[5])));
                                        if (array == null) {
                                            continue;
                                        }
                                    }
                                    final boolean isValueDouble;
                                    b3 = (isValueDouble = value.isValueDouble);
                                }
                                if (array == null) {
                                    if (b2) {
                                        printWriter4.print(String.valueOf(new StringBuilder().append(name).append(":d:").append(value.value).append(Class126.lIIlIIIllIl[6])));
                                        if (array == null) {
                                            continue;
                                        }
                                    }
                                    b3 = value.isValueMode;
                                }
                                if (!b3 && array == null) {
                                    continue;
                                }
                                printWriter4.print(String.valueOf(new StringBuilder().append(name).append(":s:").append(value.modeTitle).append(Class126.lIIlIIIllIl[7]).append(value.getCurrentMode()).append(Class126.lIIlIIIllIl[8])));
                                if (array != null) {
                                    break;
                                }
                            }
                            printWriter4.close();
                            return;
                        }
                        if (array != null) {
                            break;
                        }
                    }
                    final PrintWriter printWriter5 = printWriter2;
                    if (array == null) {
                        printWriter5.close();
                        continue;
                    }
                    break;
                }
                continue;
            }
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public final void load() {
        final int[] b = Class139.b();
        final File file = new File(String.valueOf(new StringBuilder().append(this.fileDir).append("/keys.txt")));
        final int[] array = b;
        final File file2 = new File(String.valueOf(new StringBuilder().append(this.fileDir).append("/mods.txt")));
        final File file3 = new File(String.valueOf(new StringBuilder().append(this.fileDir).append("/values.txt")));
        final File file4 = file;
        try {
            final boolean exists = file4.exists();
            boolean contains = false;
            Label_0235: {
                Label_0231: {
                    Label_0115: {
                        if (array == null) {
                            if (exists) {
                                break Label_0115;
                            }
                            file.createNewFile();
                        }
                        if (array == null) {
                            break Label_0231;
                        }
                    }
                    final BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
                Label_0132:
                    while (true) {
                        final String line = bufferedReader.readLine();
                        String s = null;
                        while (s != null) {
                            final String s2 = line;
                            final String s3 = Class126.lIIlIIIllIl[9];
                            if (array == null) {
                                contains = s2.contains(s3);
                                if (array != null) {
                                    break Label_0235;
                                }
                                if (!contains && array == null) {
                                    continue Label_0132;
                                }
                                final String s4 = Class126.lIIlIIIllIl[10];
                            }
                            final String[] split = s2.split(s3);
                            final Class139 instance = Class139.INSTANCE;
                            final Mod module = Class4.getModule(split[0]);
                            s = split[1];
                            if (array == null) {
                                final int keyIndex = Keyboard.getKeyIndex(s);
                                if (module == null || (keyIndex == -1 && array == null)) {
                                    continue Label_0132;
                                }
                                module.keybind = keyIndex;
                                if (array != null) {
                                    break;
                                }
                                continue Label_0132;
                            }
                        }
                        break;
                    }
                }
                file2.exists();
            }
            Label_0445: {
                boolean b2 = false;
                Label_0430: {
                    Label_0251: {
                        if (array == null) {
                            if (contains) {
                                break Label_0251;
                            }
                            file2.createNewFile();
                        }
                        if (array == null) {
                            break Label_0430;
                        }
                    }
                    String line2;
                    while ((line2 = new BufferedReader(new FileReader(file2)).readLine()) != null) {
                        final String s5 = line2;
                        final String s6 = Class126.lIIlIIIllIl[11];
                        if (array == null) {
                            final boolean contains2;
                            b2 = (contains2 = s5.contains(s6));
                            if (array != null) {
                                break Label_0445;
                            }
                            if (!b2 && array == null) {
                                continue;
                            }
                            final String s7 = Class126.lIIlIIIllIl[12];
                        }
                        final String[] split2 = s5.split(s6);
                        final Class139 instance2 = Class139.INSTANCE;
                        final Mod module2 = Class4.getModule(split2[0]);
                        final boolean boolean1 = Boolean.parseBoolean(split2[1]);
                        Mod mod2;
                        final Mod mod = mod2 = module2;
                        if (array == null) {
                            if (mod == null && array == null) {
                                continue;
                            }
                            final Mod mod3;
                            mod2 = (mod3 = module2);
                        }
                        final int[] array2 = array;
                        try {
                            Label_0420: {
                                final Mod mod4;
                                if (array2 == null) {
                                    if (!mod.getName().equals("Fly")) {
                                        mod4 = module2;
                                        if (array == null) {
                                            if (!mod4.getName().equals("Blink")) {
                                                final Mod mod5 = module2;
                                                if (array == null) {
                                                    if (!mod5.getName().equals("Scaffold")) {
                                                        module2.setState(boolean1, false);
                                                        if (array == null) {
                                                            break Label_0420;
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                                mod4.setState(false, false);
                            }
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                        if (array != null) {
                            break;
                        }
                    }
                }
                final Class263 aes_UTILS = Class139.AES_UTILS;
                final String hwid_VERIFY = Class139.HWID_VERIFY;
                try {
                    final boolean contains3 = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
                    Label_0464: {
                        if (array == null) {
                            if (b2) {
                                break Label_0464;
                            }
                            FMLCommonHandler.instance().exitJava(0, true);
                        }
                        Class258.sleep = contains3;
                    }
                }
                catch (Exception ex3) {
                    FMLCommonHandler.instance().exitJava(0, true);
                    Class258.sleep = true;
                }
            }
            final boolean exists2 = file3.exists();
            Label_0502: {
                if (array == null) {
                    if (exists2) {
                        break Label_0502;
                    }
                    file3.createNewFile();
                }
                if (array == null) {
                    return;
                }
            }
            String line3;
        Label_0548_Outer:
            while ((line3 = new BufferedReader(new FileReader(file3)).readLine()) != null) {
                if (array != null) {
                    return;
                }
                final String s8 = line3;
                final String s9 = Class126.lIIlIIIllIl[13];
            Label_0548:
                while (true) {
                    Label_0562: {
                        if (array != null) {
                            break Label_0562;
                        }
                        s8.contains(s9);
                        final boolean b3;
                        if (!b3 && array == null) {
                            continue Label_0548_Outer;
                        }
                        final String s10 = Class126.lIIlIIIllIl[14];
                    }
                    final String[] split3 = s8.split(s9);
                    for (final Value value : Value.list) {
                        boolean b7;
                        boolean equalsIgnoreCase;
                        boolean b6;
                        final boolean b5;
                        boolean b4;
                        final boolean b3 = b4 = (b5 = (b6 = (equalsIgnoreCase = (b7 = split3[0].equalsIgnoreCase(value.name)))));
                        if (array != null) {
                            continue Label_0548;
                        }
                        if (array == null) {
                            if (!b3 && array == null) {
                                continue Label_0548_Outer;
                            }
                            b4 = (b6 = (equalsIgnoreCase = (b7 = value.isValueBoolean)));
                        }
                        final boolean b8;
                        Label_0683: {
                            if (array == null) {
                                if (b4) {
                                    b8 = (b6 = (equalsIgnoreCase = (b7 = split3[1].equalsIgnoreCase(Class126.lIIlIIIllIl[15]))));
                                    if (array != null) {
                                        break Label_0683;
                                    }
                                    if (b8) {
                                        value.value = (T)Boolean.parseBoolean(split3[2]);
                                        if (array == null) {
                                            continue Label_0548_Outer;
                                        }
                                    }
                                }
                                equalsIgnoreCase = (b7 = value.isValueDouble);
                            }
                        }
                        final boolean b9;
                        Label_0735: {
                            if (array == null) {
                                if (b8) {
                                    b9 = (equalsIgnoreCase = (b7 = split3[1].equalsIgnoreCase(Class126.lIIlIIIllIl[16])));
                                    if (array != null) {
                                        break Label_0735;
                                    }
                                    if (b9) {
                                        value.value = (T)Double.parseDouble(split3[2]);
                                        if (array == null) {
                                            continue Label_0548_Outer;
                                        }
                                    }
                                }
                                equalsIgnoreCase = (b6 = (b7 = value.isValueMode));
                            }
                        }
                        if (array == null) {
                            if (!b9) {
                                continue Label_0548_Outer;
                            }
                            b7 = (equalsIgnoreCase = split3[1].equalsIgnoreCase(Class126.lIIlIIIllIl[17]));
                        }
                        if (array == null) {
                            if (!equalsIgnoreCase) {
                                continue Label_0548_Outer;
                            }
                            b7 = split3[2].equalsIgnoreCase(value.modeTitle);
                        }
                        if (!b7 && array == null) {
                            continue Label_0548_Outer;
                        }
                        value.setCurrentMode(Integer.parseInt(split3[3]));
                        if (array != null) {
                            break;
                        }
                    }
                    break;
                }
                if (array != null) {
                    break;
                }
            }
        }
        catch (Exception ex2) {
            ex2.printStackTrace();
        }
    }
    
    static {
        llIlIIIlIIlI();
        Class169.a(807622372224679079L, 1104904652143756581L, MethodHandles.lookup().lookupClass()).a(266558772001323L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class126.lIIlIIIllIl[18]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class126.lIIlIIIllIl[19]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(9577436000775L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[14];
        int n2 = 0;
        String s;
        int n3 = (s = Class126.lIIlIIIllIl[20]).length();
        int n4 = 32;
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
                    final String intern = a(instance.doFinal(s3.getBytes(Class126.lIIlIIIllIl[22]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s.charAt(n5);
                                continue Label_0152;
                            }
                            n3 = (s = Class126.lIIlIIIllIl[21]).length();
                            n4 = 16;
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
        c = new String[14];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x34F4;
        if (Class126.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class126.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class126.lIIlIIIllIl[23]);
                    array[1] = SecretKeyFactory.getInstance(Class126.lIIlIIIllIl[24]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class126.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class126.lIIlIIIllIl[25], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class126.c[n3] = a(((Cipher)array[0]).doFinal(Class126.b[n3].getBytes(Class126.lIIlIIIllIl[26])));
        }
        return Class126.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class126.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llIlIIIlIIlI() {
        (lIIlIIIllIl = new String[30])[0] = "/";
        Class126.lIIlIIIllIl[1] = ":";
        Class126.lIIlIIIllIl[2] = "\n";
        Class126.lIIlIIIllIl[3] = ":";
        Class126.lIIlIIIllIl[4] = "\n";
        Class126.lIIlIIIllIl[5] = "\n";
        Class126.lIIlIIIllIl[6] = "\n";
        Class126.lIIlIIIllIl[7] = ":";
        Class126.lIIlIIIllIl[8] = "\n";
        Class126.lIIlIIIllIl[9] = ":";
        Class126.lIIlIIIllIl[10] = ":";
        Class126.lIIlIIIllIl[11] = ":";
        Class126.lIIlIIIllIl[12] = ":";
        Class126.lIIlIIIllIl[13] = ":";
        Class126.lIIlIIIllIl[14] = ":";
        Class126.lIIlIIIllIl[15] = "b";
        Class126.lIIlIIIllIl[16] = "d";
        Class126.lIIlIIIllIl[17] = "s";
        Class126.lIIlIIIllIl[18] = "DES/CBC/PKCS5Padding";
        Class126.lIIlIIIllIl[19] = "DES";
        Class126.lIIlIIIllIl[20] = "¡\u0088ÜN'ô%P!@VÙ÷ãy\u008cëCÃ(0\u0093n\r\u009d\u0090Ööë\u001aÝ%\u0018Úo&\u0097~©ê·fwOß\u001eb\u001c<\u007fª4\u0094=í5ø\u0010ßäÏÉ~32z\u001cåÞôy\u009e\u0085g  ¯\u0095\u0005¤\u0092FÐG~\nUÇ-\u0018\u0080ø\u008f@§îµ\u0010^\nDÜ²(ü\fZ\u0010òô\u0017ÿ\u0006£v\u009eÝXiE\u00ad\u008c¹f \u0012Y#\u0083T\u009dÚÎ4ExyÉtë\u0001ªÓ\u008d^\u0007¨~g¥e8ÌÓ`\u0004×\u0010Æ/ì'EÖú$½\u0016ý¹\u0016&\nÒ\u0010\u0095Ò\u008d\tØ¥_ý¶? üH^SO\u0010\u0002\u001cÉç¶\u0095F\u0006eÚî@\u0002Â:\u007f Rý8\u000e\u00800ß\u0012ó\u0091\u0011\u008c>Ñ\u0085¨Ûw¾)\u0088\u008eá-ýnZ\u0003DØ\u00900\u0010ùÎL\u000f\u0089\u0019äæÂ_\u0098\u000bnr¿¶ \u0092[ïS¯\u0018¢\t]èD\u001f4Ç\u0002cª\u0096/ç\u00ad\u0092øvp^·;§P\bò";
        Class126.lIIlIIIllIl[21] = "\u0005÷\u001b¢®QZû\u008a\u000f\u009f¦d\u008c\\c\u0018\\~$;í°\u0003p7ÐÉ;ï\u0018ËFÛt~åS¡¢è";
        Class126.lIIlIIIllIl[22] = "ISO-8859-1";
        Class126.lIIlIIIllIl[23] = "DES/CBC/PKCS5Padding";
        Class126.lIIlIIIllIl[24] = "DES";
        Class126.lIIlIIIllIl[25] = "你还大言不惭的吹嘘你的速度是不是啊本人不是大手没有词汇好么你开始回光返照的继续和我抗争到底了你这孩子你还自以为东方不败的词汇无中生有的无端反抗你因为你笑几下你就是春晚的赵本山了吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u200d\u200f\u2002";
        Class126.lIIlIIIllIl[26] = "ISO-8859-1";
        Class126.lIIlIIIllIl[27] = "你还大言不惭的吹嘘你的速度是不是啊本人不是大手没有词汇好么你开始回光返照的继续和我抗争到底了你这孩子你还自以为东方不败的词汇无中生有的无端反抗你因为你笑几下你就是春晚的赵本山了吗NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL \u200d\u200f\u2002";
        Class126.lIIlIIIllIl[28] = " : ";
        Class126.lIIlIIIllIl[29] = " : ";
    }
    
    private static String llIlIIIIlllI(String s, final String s2) {
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
    
    private static String llIlIIIIlIll(final String s, final String s2) {
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
    
    private static String llIlIIIIllIl(final String s, final String s2) {
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
    
    private static boolean llIlIIIlllIl(final int n) {
        return n < 0;
    }
}
