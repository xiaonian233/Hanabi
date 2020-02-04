package ClassSub;

import net.minecraft.client.*;
import cn.Hanabi.modules.Player.*;
import net.minecraftforge.fml.common.*;
import javax.swing.*;
import java.awt.*;
import javax.crypto.*;
import java.security.spec.*;
import java.lang.invoke.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class206
{
    public static String username;
    private static String password;
    public static Class290 heartBeatTimer;
    private static String SERVER_IP;
    private static int SERVER_PORT;
    public static Class348 socket;
    public static Class297 type;
    public static Class1 loginPacket;
    public static HashMap<String, String> ignMap;
    private static boolean isVerifyed;
    private static final long a;
    private static final String[] b;
    private static final String[] c;
    private static final Map d;
    private static final String[] lIIIlIIllII;
    
    public Class206() {
        super();
    }
    
    public static void start(final String username, final String s) {
        Class206.username = username;
        (Class206.socket = new Class348()).start();
        Class206.loginPacket = new Class1(username, s, Class94.getHWID(), 2.2);
    }
    
    public static void output(final String s) {
        final int[] b = Class139.b();
        String s2 = s;
        if (b == null) {
            if (s == null) {
                return;
            }
            s2 = s;
        }
        Class333.tellPlayer(s2);
    }
    
    public static void processMessage(String replace) {
        final int[] b = Class139.b();
        String s2;
        final String s = s2 = replace;
        Label_0029: {
            if (b != null) {
                break Label_0029;
            }
            if (s == null) {
                return;
            }
            final String s3 = replace;
            final String[] liiIlIIllII = Class206.lIIIlIIllII;
            final int n = 0;
            try {
                s2 = (replace = s3.replace(liiIlIIllII[n], Class206.lIIIlIIllII[1]));
                if (b == null) {
                    if (s == null) {
                        return;
                    }
                    s2 = replace;
                }
                final String[] split;
                boolean b7;
                boolean equals;
                boolean b6;
                boolean b5;
                boolean b4;
                boolean b3;
                final boolean b2 = b3 = (b4 = (b5 = (b6 = (equals = (b7 = (split = s2.split(invokedynamic(w:(IJ)Ljava/lang/String;, 20308, 8554826917011855337L)))[0].equals(invokedynamic(w:(IJ)Ljava/lang/String;, 28905, 4802811505122584650L)))))));
                if (b == null) {
                    if (b2) {
                        final Class190 class190 = new Class190(replace);
                        final String value = String.valueOf(new StringBuilder().append(invokedynamic(w:(IJ)Ljava/lang/String;, 23469, 4719525640262255380L)).append(Class297.getClientName()).append(Class206.lIIIlIIllII[2]).append(class190.user.prefix).append(invokedynamic(w:(IJ)Ljava/lang/String;, 26082, 2171986448408558918L)).append(class190.user.username).append(Class206.lIIIlIIllII[3]).append(class190.chatMessage));
                        final String s4 = invokedynamic(w:(IJ)Ljava/lang/String;, 3409, 4433578218784642544L);
                        Label_0239: {
                            if (b == null) {
                                if (!Class4.getModule(s4).state) {
                                    break Label_0239;
                                }
                                String.valueOf(new StringBuilder().append(invokedynamic(w:(IJ)Ljava/lang/String;, 19828, 5640553660670645713L)).append(value.replace(Class206.lIIIlIIllII[4], Class206.lIIIlIIllII[5])));
                            }
                            output(s4);
                        }
                        if (b == null) {
                            return;
                        }
                    }
                    final boolean b8;
                    b3 = (b8 = (b4 = (b5 = (b6 = (equals = (b7 = split[0].equals(invokedynamic(w:(IJ)Ljava/lang/String;, 9108, 720178793911581500L))))))));
                }
                if (b == null) {
                    if (b2) {
                        final String message = new Class166(replace, (byte)0).message;
                        final boolean isGameInit = Class258.isGameInit;
                        Label_0406: {
                            final String s6;
                            Label_0403: {
                                Label_0373: {
                                    if (b == null) {
                                        if (!isGameInit) {
                                            final boolean startsWith = message.startsWith(invokedynamic(w:(IJ)Ljava/lang/String;, 4662, 2780146250792323726L));
                                            if (b == null && !startsWith) {
                                                final boolean startsWith2 = message.startsWith(invokedynamic(w:(IJ)Ljava/lang/String;, 10848, 5864266860624376519L));
                                                if (b != null) {
                                                    break Label_0373;
                                                }
                                                if (startsWith2) {
                                                    goto Label_0331;
                                                }
                                            }
                                            else {
                                                Class258.sleep = startsWith;
                                                final String s5 = message;
                                                Class100.showMessageBox(s5, s5.startsWith(invokedynamic(w:(IJ)Ljava/lang/String;, 8576, 7035142634033248550L)));
                                            }
                                        }
                                        s6 = invokedynamic(w:(IJ)Ljava/lang/String;, 22121, 8341926650062540485L);
                                        if (b != null) {
                                            break Label_0403;
                                        }
                                        final boolean state = Class4.getModule(s6).state;
                                    }
                                }
                                if (!isGameInit) {
                                    break Label_0406;
                                }
                                String.valueOf(new StringBuilder().append(invokedynamic(w:(IJ)Ljava/lang/String;, 23834, 6174844076138595745L)).append(message));
                            }
                            output(s6);
                        }
                        if (b == null) {
                            return;
                        }
                    }
                    b4 = (b3 = (b5 = (b6 = (equals = (b7 = split[0].equals(invokedynamic(w:(IJ)Ljava/lang/String;, 11125, 924241336125223898L)))))));
                }
                if (b == null) {
                    if (b3) {
                        Class333.tellPlayer(invokedynamic(w:(IJ)Ljava/lang/String;, 7209, 2018634524400698498L));
                        new Class50().start();
                        if (b == null) {
                            return;
                        }
                    }
                    b5 = (b4 = (b6 = (equals = (b7 = split[0].equals(invokedynamic(w:(IJ)Ljava/lang/String;, 6101, 3406321194271559530L))))));
                }
                if (b == null) {
                    if (b4) {
                        final Class321 class191 = new Class321(replace);
                        String.valueOf(new StringBuilder().append(class191.user.username).append(Class206.lIIIlIIllII[6]).append(class191.user.inGamename));
                        final HashMap<String, String> ignMap = Class206.ignMap;
                        final String inGamename = class191.user.inGamename;
                        if (b == null) {
                            if (ignMap.containsKey(inGamename)) {
                                Class206.ignMap.remove(class191.user.inGamename);
                            }
                            final HashMap<String, String> ignMap2 = Class206.ignMap;
                            final String inGamename2 = class191.user.inGamename;
                        }
                        ignMap.put(inGamename, class191.user.username);
                        if (b == null) {
                            return;
                        }
                    }
                    b6 = (b5 = (equals = (b7 = split[0].equals(invokedynamic(w:(IJ)Ljava/lang/String;, 7468, 7269772284631434640L)))));
                }
                if (b == null) {
                    if (b5) {
                        Minecraft.func_71410_x().field_71439_g.func_71165_d(new Class72(replace).command);
                        if (b == null) {
                            return;
                        }
                    }
                    equals = (b6 = (b7 = split[0].equals(invokedynamic(w:(IJ)Ljava/lang/String;, 119, 1025460756653856989L))));
                }
                if (b == null) {
                    if (b6) {
                        Class20.userList.remove(new Class118(replace).user);
                        if (b == null) {
                            return;
                        }
                    }
                    b7 = (equals = split[0].equals(invokedynamic(w:(IJ)Ljava/lang/String;, 8965, 4617026268197845931L)));
                }
                if (b == null) {
                    if (equals) {
                        final Class62 class192 = new Class62(replace);
                        Class206.heartBeatTimer.lastMs = System.currentTimeMillis();
                        if (class192.needIGN && Minecraft.func_71410_x().field_71439_g != null) {
                            new Class324(Minecraft.func_71410_x().field_71439_g.func_70005_c_(), ((boolean)Teams.clientfriend.value) ? invokedynamic(w:(IJ)Ljava/lang/String;, 32392, 6542411816411801128L) : invokedynamic(w:(IJ)Ljava/lang/String;, 20004, 4036104323673560717L)).sendPacketToServer(Class206.socket.writer);
                        }
                        if (b == null) {
                            return;
                        }
                    }
                    b7 = split[0].equals(invokedynamic(w:(IJ)Ljava/lang/String;, 15007, 8219288115703603749L));
                }
                if (b7) {
                    final Class64 class193 = new Class64(replace);
                    try {
                        Class139.HWID_VERIFY = class193.result;
                        final boolean contains = (Class139.AES_UTILS = new Class263(class193.key)).decrypt(Class139.HWID_VERIFY).contains(Class94.getHWID());
                        if (b == null && !contains) {
                            FMLCommonHandler.instance().exitJava(0, true);
                            Class258.sleep = true;
                        }
                    }
                    catch (Exception ex) {
                        JOptionPane.showMessageDialog((Component)null, invokedynamic(w:(IJ)Ljava/lang/String;, 27802, 85776035312153655L));
                        FMLCommonHandler.instance().exitJava(0, true);
                        Class258.sleep = true;
                    }
                }
            }
            catch (Exception ex2) {}
        }
    }
    
    static {
        llIIlIIIIlll();
        Class169.a(7647660949255408103L, 8431566338882456792L, MethodHandles.lookup().lookupClass()).a(150140842483310L);
        d = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class206.lIIIlIIllII[7]);
        final int n = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class206.lIIIlIIllII[8]);
        final byte[] array = new byte[8];
        array[0] = 0;
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(118589149317327L << i * 8 >>> 56);
        }
        instance.init(n, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] b2 = new String[24];
        int n2 = 0;
        final String s = "í·é\u0004=Lß7çá\u0081\u009e\u0094öé\u008e\u0010²CGÀo®P\u007f\u0085¿\u0086\u0080{\u0000Õ\u0097H¹éó\u008aÄ\u000eE=n\u000ekä¬æä$¼\u008dÎ*\fÍ0¦@W£9ýþû\fx7\u008e¼Á\u00adËy\u000b\u0083n^\u0005G\u0082²\u0086\u0094§¶j\u0011o~Âø»9Æ.\u001a]!Ý\u007f-\u008d\u0081»õ\u0010qå\u0002wú\u0093êßÖð\u0017¼K¼Ti\u0088[qÕ\u0000¼h\u0097u\u0084\u0080\u00176Ê|\u0083cS\u0091ùàÿ«d~\u0016ºÜ\u0094\u00047~U\u008a¶;ãR\u0002\u0084ÎEJ\u008cCþ\u0012\u0082\u0088ú9À\u0013ÈJZ¡(²\u0015yb\u001b\u0099ÿ}ÆQÄwy¡op\u008c\u0007\u0088Ã3x\u0018+Â\u0090\u0086dø&@\t\u0002Êêh°8ª3doi\u0082\u0082-\u0010\u0007\u008cúÁüç'*¡\fÂïÓÉ\u008f¿åbJA°a@2´¿\u000e\u009e<\u0000L5 \u008fb^\u009dåS\u0000\u0018qÿ0a\u0001~\u0000ÎOmd|k)ªáË\u008c!5]þo\u0013\u0010u\"6'L®è\t\u0011\u0019k\u009b÷'\u0013x Æ£´N\u008b\u0010\u0095èLl«\u009fñÆ¬\u0016ÞÇ7¼R\u001aôäó_ÔPz|Ü\u0010 Ð\u0096*Ó(0vlåà/ÓÈ{cNíFÎç\u0003¶Lµ\u0019×\u009d^oZx~\u0010Í¢t!aû®\u0007æ\rµ~\u001cÐ\u008a\u000e\u0018t\u0098ñ\u0083\\=%\u0086J\u0092WQÎTpÂ-\u0019\u0000>W\u00ad\u008e²\u0010ô¡Þ \u009c*^jªËÞ\u0099ãH/¬\u0010ÔgS\u000e\u0011OÖ°Ï\u0005\u007f\u0003\u0018_nU úW\u008b\u001b Ü}Ú¬GÎ'tC\u0000ø{Û}Ó£GS=_Êg\u0082¿£ªn\u0010Kñ>\u001d\u0011\u009f\u000e9ÆTÇ\u0011|\u0096BÞ\u0010A\u009bgñ°\u0095ö\u000f\u0006`\u001a§é\u00ad\u001b¸ Ã¼ýÇ\u0006\u001d\"êäÌ\u0084æZQb\\2ZP<P\u001e{IÐ¯I´+\n\u0010$\u00104O»Æ¡H\u009aÞ!\u0005<òÓ.\u00adZ\u0010>[#\u001c|¯G&°£Ö*û³½\u009b\u0010êÛ¾9\u0012¹{\u009cI\u009cG\u000bÄÚ_\u0094 \u000fñS¹òl7¹Ì\fõ\u0083rdOñ\u000e|ñæ½ó\u0004\u007f»\u00adr\u0006\u0081~7\u0082 D+\u0000\\í>Bê~\u000br\u001aRÄ\u0007OÏH\u0085o#ö\u0098\u00858h÷\bäµ\nf";
        String s2 = "í·é\u0004=Lß7çá\u0081\u009e\u0094öé\u008e\u0010²CGÀo®P\u007f\u0085¿\u0086\u0080{\u0000Õ\u0097H¹éó\u008aÄ\u000eE=n\u000ekä¬æä$¼\u008dÎ*\fÍ0¦@W£9ýþû\fx7\u008e¼Á\u00adËy\u000b\u0083n^\u0005G\u0082²\u0086\u0094§¶j\u0011o~Âø»9Æ.\u001a]!Ý\u007f-\u008d\u0081»õ\u0010qå\u0002wú\u0093êßÖð\u0017¼K¼Ti\u0088[qÕ\u0000¼h\u0097u\u0084\u0080\u00176Ê|\u0083cS\u0091ùàÿ«d~\u0016ºÜ\u0094\u00047~U\u008a¶;ãR\u0002\u0084ÎEJ\u008cCþ\u0012\u0082\u0088ú9À\u0013ÈJZ¡(²\u0015yb\u001b\u0099ÿ}ÆQÄwy¡op\u008c\u0007\u0088Ã3x\u0018+Â\u0090\u0086dø&@\t\u0002Êêh°8ª3doi\u0082\u0082-\u0010\u0007\u008cúÁüç'*¡\fÂïÓÉ\u008f¿åbJA°a@2´¿\u000e\u009e<\u0000L5 \u008fb^\u009dåS\u0000\u0018qÿ0a\u0001~\u0000ÎOmd|k)ªáË\u008c!5]þo\u0013\u0010u\"6'L®è\t\u0011\u0019k\u009b÷'\u0013x Æ£´N\u008b\u0010\u0095èLl«\u009fñÆ¬\u0016ÞÇ7¼R\u001aôäó_ÔPz|Ü\u0010 Ð\u0096*Ó(0vlåà/ÓÈ{cNíFÎç\u0003¶Lµ\u0019×\u009d^oZx~\u0010Í¢t!aû®\u0007æ\rµ~\u001cÐ\u008a\u000e\u0018t\u0098ñ\u0083\\=%\u0086J\u0092WQÎTpÂ-\u0019\u0000>W\u00ad\u008e²\u0010ô¡Þ \u009c*^jªËÞ\u0099ãH/¬\u0010ÔgS\u000e\u0011OÖ°Ï\u0005\u007f\u0003\u0018_nU úW\u008b\u001b Ü}Ú¬GÎ'tC\u0000ø{Û}Ó£GS=_Êg\u0082¿£ªn\u0010Kñ>\u001d\u0011\u009f\u000e9ÆTÇ\u0011|\u0096BÞ\u0010A\u009bgñ°\u0095ö\u000f\u0006`\u001a§é\u00ad\u001b¸ Ã¼ýÇ\u0006\u001d\"êäÌ\u0084æZQb\\2ZP<P\u001e{IÐ¯I´+\n\u0010$\u00104O»Æ¡H\u009aÞ!\u0005<òÓ.\u00adZ\u0010>[#\u001c|¯G&°£Ö*û³½\u009b\u0010êÛ¾9\u0012¹{\u009cI\u009cG\u000bÄÚ_\u0094 \u000fñS¹òl7¹Ì\fõ\u0083rdOñ\u000e|ñæ½ó\u0004\u007f»\u00adr\u0006\u0081~7\u0082 D+\u0000\\í>Bê~\u000br\u001aRÄ\u0007OÏH\u0085o#ö\u0098\u00858h÷\bäµ\nf";
        int n3 = s.length();
        int n4 = 16;
        int n5 = -1;
    Label_0149:
        while (true) {
            while (true) {
                ++n5;
                final String s3 = s2;
                final int n6 = n5;
                String s4 = s3.substring(n6, n6 + n4);
                int n7 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s4.getBytes(Class206.lIIIlIIllII[10]))).intern();
                    switch (n7) {
                        default: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                continue Label_0149;
                            }
                            n3 = (s2 = Class206.lIIIlIIllII[9]).length();
                            n4 = 16;
                            n5 = -1;
                            break;
                        }
                        case 0: {
                            b2[n2++] = intern;
                            if ((n5 += n4) < n3) {
                                n4 = s2.charAt(n5);
                                break;
                            }
                            break Label_0149;
                        }
                    }
                    ++n5;
                    final String s5 = s2;
                    final int n8 = n5;
                    s4 = s5.substring(n8, n8 + n4);
                    n7 = 0;
                }
            }
            break;
        }
        b = b2;
        c = new String[24];
        // invokedynamic(w:(IJ)Ljava/lang/String;, 9443, 208459601745869889L)
        Class206.heartBeatTimer = new Class290();
        Class206.type = Class225.getTypeByName(invokedynamic(w:(IJ)Ljava/lang/String;, 4251, 2274801542941591589L));
        Class206.ignMap = new HashMap<String, String>();
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x58AF;
        if (Class206.c[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class206.d.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class206.lIIIlIIllII[11]);
                    array[1] = SecretKeyFactory.getInstance(Class206.lIIIlIIllII[12]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class206.d.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class206.lIIIlIIllII[13], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class206.c[n3] = a(((Cipher)array[0]).doFinal(Class206.b[n3].getBytes(Class206.lIIIlIIllII[14])));
        }
        return Class206.c[n3];
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
        // com.strobel.assembler.metadata.MethodBodyParseException: An error occurred while parsing the bytecode of method 'ClassSub/Class206.a:(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;'.
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
    
    private static void llIIlIIIIlll() {
        (lIIIlIIllII = new String[18])[0] = "�";
        Class206.lIIIlIIllII[1] = "";
        Class206.lIIIlIIllII[2] = "]";
        Class206.lIIIlIIllII[3] = ":";
        Class206.lIIIlIIllII[4] = "&";
        Class206.lIIIlIIllII[5] = "§";
        Class206.lIIIlIIllII[6] = " ";
        Class206.lIIIlIIllII[7] = "DES/CBC/PKCS5Padding";
        Class206.lIIIlIIllII[8] = "DES";
        Class206.lIIIlIIllII[9] = "2\u0088ý`ÑE\u008fz\u0095¿\u008d«f'Ä\u000e\u0010°\u0004a\u009f\u0007\u000bÐ\u009aTGðÅÈ\u0017fZ";
        Class206.lIIIlIIllII[10] = "ISO-8859-1";
        Class206.lIIIlIIllII[11] = "DES/CBC/PKCS5Padding";
        Class206.lIIIlIIllII[12] = "DES";
        Class206.lIIIlIIllII[13] = "别那么天真了好吗传说已经幻灭你到底是怎么长大的你仿佛在跟我诉说你妈妈劈腿的经过我简直不屑与你废话NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2001 \u200d\u200f";
        Class206.lIIIlIIllII[14] = "ISO-8859-1";
        Class206.lIIIlIIllII[15] = "别那么天真了好吗传说已经幻灭你到底是怎么长大的你仿佛在跟我诉说你妈妈劈腿的经过我简直不屑与你废话NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2001 \u200d\u200f";
        Class206.lIIIlIIllII[16] = " : ";
        Class206.lIIIlIIllII[17] = " : ";
    }
    
    private static String llIIlIIIIlII(final String s, final String s2) {
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
    
    private static String llIIlIIIIlIl(String s, final String s2) {
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
    
    private static String llIIlIIIIllI(final String s, final String s2) {
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
