package ClassSub;

import org.jetbrains.annotations.*;
import cn.Hanabi.command.*;
import cn.Hanabi.hmlProject.*;
import net.minecraftforge.fml.common.*;
import java.util.function.*;
import java.util.stream.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class336
{
    @NotNull
    private List<Command> commands;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIlIIIlllII;
    
    public Class336() {
        super();
        this.commands = new ArrayList<Command>();
    }
    
    private void addCommands() {
        this.addCommand(new Class152());
        this.addCommand(new Bind());
        this.addCommand(new Class248());
        this.addCommand(new Class133());
        this.addCommand(new Class224());
        this.addCommand(new Class345());
        this.addCommand(new Binds());
        this.addCommand(new Config());
        this.addCommand(new Fcmd());
        this.addCommand(new Crash());
        this.addCommand(new Checkuser());
        this.addCommand(new Whois());
        HMLUtils.onCommandManagerLoad(this);
    }
    
    public final void addCommand(final Command command) {
        this.commands.add(command);
    }
    
    public final boolean executeCommand(@NotNull String s) {
        final Object b = Class139.b();
        final String substring = s.substring(1);
        s = (String)b;
        final String[] split = substring.split(Class336.lIlIIIlllII[0]);
        final Class263 aes_UTILS = Class139.AES_UTILS;
        final String hwid_VERIFY = Class139.HWID_VERIFY;
        try {
            final boolean contains = aes_UTILS.decrypt(hwid_VERIFY).contains(Class94.getHWID());
            Label_0054: {
                if (s == null) {
                    if (contains) {
                        break Label_0054;
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
        final String[] array = split;
        if (s == null && array.length == 0) {
            return false;
        }
        final Command command = this.commands.stream().filter(Class336::lambda$executeCommand$0).findFirst().orElse(null);
        try {
            if (command == null) {
                final String s2 = "IRC";
                if (s == null && Class4.getModule(s2).state) {
                    new Class190(Class20.getIRCUserByNameAndType(Class206.type, Class206.username), substring).sendPacketToServer(Class206.socket.writer);
                    if (s != null) {
                        goto Label_0170;
                    }
                }
                else {
                    Class23.sendClientMessage(s2, Class153.ERROR);
                }
                return true;
            }
            final String[] array2 = new String[split.length - 1];
            System.arraycopy(split, 1, array2, 0, split.length - 1);
            command.run(split[0], array2);
            return true;
        }
        catch (Class109 class109) {
            Class100.send(String.valueOf(new StringBuilder("§c").append(class109.getMessage())));
            return true;
        }
    }
    
    public final Collection<String> autoComplete(@NotNull final String s) {
        final int[] b = Class139.b();
        final String substring = s.substring(1);
        final int[] array = b;
        final String[] split = substring.split(Class336.lIlIIIlllII[1]);
        final ArrayList<Object> list = new ArrayList<Object>();
        Object orElse;
        final String[] array2 = (String[])(orElse = split);
        Command command = null;
        Label_0082: {
            if (array == null) {
                if (array2.length <= 0) {
                    command = null;
                    break Label_0082;
                }
                orElse = this.commands.stream().filter(Class336::lambda$autoComplete$1).findFirst().orElse(null);
            }
            command = (Command)orElse;
        }
        final Command command2 = command;
        Label_0113: {
            if (split.length < 2) {
                int n = 0;
                Label_0192: {
                    if (command2 != null) {
                        final boolean b2 = (n = (s.endsWith(Class336.lIlIIIlllII[2]) ? 1 : 0)) != 0;
                        if (array != null) {
                            break Label_0192;
                        }
                        if (b2) {
                            break Label_0113;
                        }
                    }
                    n = split.length;
                }
                if (n == 1) {
                    for (final Command command3 : this.commands) {
                        final List<? super Object> list3;
                        final ArrayList<Object> list2 = (ArrayList<Object>)(list3 = list);
                        if (array != null) {
                            return (Collection<String>)list3;
                        }
                        list2.addAll(command3.getNameAndAliases());
                        if (array != null) {
                            break;
                        }
                    }
                    List<? super Object> list3 = list.stream().map((Function<? super String, ?>)Class336::lambda$autoComplete$2).filter(Class336::lambda$autoComplete$3).collect((Collector<? super Object, ?, List<? super Object>>)Collectors.toList());
                    return (Collection<String>)list3;
                }
                return (Collection<String>)list;
            }
        }
        if (command2 == null) {
            return (Collection<String>)list;
        }
        final String[] array3 = new String[split.length - 1];
        System.arraycopy(split, 1, array3, 0, split.length - 1);
        final Command command4 = command2;
        final int length = array3.length;
        final int endsWith = s.endsWith(Class336.lIlIIIlllII[3]) ? 1 : 0;
        if (array == null && endsWith == 0) {}
        final List<String> autocomplete;
        if ((autocomplete = command4.autocomplete(length + endsWith, array3)) == null) {
            return new ArrayList<String>();
        }
        return autocomplete;
    }
    
    private static boolean lambda$autoComplete$3(final String s, final String s2) {
        return s2.toLowerCase().startsWith(s.toLowerCase());
    }
    
    private static String lambda$autoComplete$2(final String s) {
        return String.valueOf(new StringBuilder().append(Class336.lIlIIIlllII[4]).append(s));
    }
    
    private static boolean lambda$autoComplete$1(final String[] array, final Command command) {
        return command.match(array[0]);
    }
    
    private static boolean lambda$executeCommand$0(final String s, final Command command) {
        return command.match(s);
    }
    
    static {
        lllIIIlllllI();
        Class169.a(5956515604135346860L, 985409877455477961L, MethodHandles.lookup().lookupClass()).a(170594652536803L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class336.lIlIIIlllII[5]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class336.lIlIIIlllII[6]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(23252701154280L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[3];
        int n2 = 0;
        final String s;
        final int length = (s = Class336.lIlIIIlllII[7]).length();
        int char1 = 80;
        int n3 = -1;
        while (true) {
            ++n3;
            final String s2 = s;
            final int n4 = n3;
            b2[n2++] = a(instance.doFinal(s2.substring(n4, n4 + char1).getBytes(Class336.lIlIIIlllII[8]))).intern();
            if ((n3 += char1) >= length) {
                break;
            }
            char1 = s.charAt(n3);
        }
        b = b2;
        c = new String[3];
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0xA66;
        if (Class336.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class336.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class336.lIlIIIlllII[9]);
                    array[1] = SecretKeyFactory.getInstance(Class336.lIlIIIlllII[10]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class336.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class336.lIlIIIlllII[11], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class336.c[n3] = a(((Cipher)array[0]).doFinal(Class336.b[n3].getBytes(Class336.lIlIIIlllII[12])));
        }
        return Class336.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class336.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void lllIIIlllllI() {
        (lIlIIIlllII = new String[16])[0] = " ";
        Class336.lIlIIIlllII[1] = " ";
        Class336.lIlIIIlllII[2] = " ";
        Class336.lIlIIIlllII[3] = " ";
        Class336.lIlIIIlllII[4] = ".";
        Class336.lIlIIIlllII[5] = "DES/CBC/PKCS5Padding";
        Class336.lIlIIIlllII[6] = "DES";
        Class336.lIlIIIlllII[7] = ">ý\u0017²\\\u0018\u0014\rì\u0019ßNMô9CóÒïÄ®c±ò\n\u000bÚ\u0002åu¿\u000b\u0012õsM¸R§îìëq;b\u0091p«'\n\u0083\u0005\u0095\u0010qÂË(\u0084ê£½î\u0019\r¦\u0002x\u001aIÑý\u0012WX29K\u0014\u001c\u0010òpO\u0013\rò´ÄJ8\u001bÌS^´q\u0010=E\u0089¯\u001cé\u008f®Vm9gPBßi";
        Class336.lIlIIIlllII[8] = "ISO-8859-1";
        Class336.lIlIIIlllII[9] = "DES/CBC/PKCS5Padding";
        Class336.lIlIIIlllII[10] = "DES";
        Class336.lIlIIIlllII[11] = "你以为你自己是多么牛逼的人物可以飞扬跋扈的和我唧唧歪歪的絮叨你真的恶心到我了你这个不要脸皮的下贱痞子货没点实力还在我面前耀武扬威的你不嫌丢脸吗所以请你滚蛋吧你那些所谓的词汇低俗不堪对你亲爹我来说没有丝毫的心情涟漪呵呵NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u200c\u2005 ";
        Class336.lIlIIIlllII[12] = "ISO-8859-1";
        Class336.lIlIIIlllII[13] = "你以为你自己是多么牛逼的人物可以飞扬跋扈的和我唧唧歪歪的絮叨你真的恶心到我了你这个不要脸皮的下贱痞子货没点实力还在我面前耀武扬威的你不嫌丢脸吗所以请你滚蛋吧你那些所谓的词汇低俗不堪对你亲爹我来说没有丝毫的心情涟漪呵呵NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2009\u200c\u2005 ";
        Class336.lIlIIIlllII[14] = " : ";
        Class336.lIlIIIlllII[15] = " : ";
    }
    
    private static String lllIIIlllIll(final String s, final String s2) {
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
    
    private static String lllIIIllllIl(final String s, final String s2) {
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
    
    private static String lllIIIllllII(String s, final String s2) {
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
    
    private static boolean lllIIlIIIllI$255f299(final int n) {
        return n > 0;
    }
}
