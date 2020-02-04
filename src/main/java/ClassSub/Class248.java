package ClassSub;

import cn.Hanabi.command.*;
import org.jetbrains.annotations.*;
import cn.Hanabi.modules.Player.*;
import java.io.*;
import java.lang.invoke.*;
import javax.crypto.*;
import java.security.spec.*;
import net.minecraft.client.*;
import java.security.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.util.*;

public final class Class248 extends Command
{
    private static String fileDir;
    private static final long c;
    private static final String[] d;
    private static final String[] e;
    private static final Map f;
    private static final String[] llIlllIIlII;
    
    public Class248() {
        super(invokedynamic(z:(IJ)Ljava/lang/String;, 21545, 0x2E8ED41E55E042B2L ^ (Class248.c ^ 0x2FA5FCE4BB48L)), new String[0]);
    }
    
    @Override
    public final void run(final String p0, @NotNull final String[] p1) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: ldc2_w          71415996345540
        //     6: lxor           
        //     7: lstore_3       
        //     8: ldc2_w          -4343303223278483577
        //    11: lload_3        
        //    12: invokedynamic   BootstrapMethod #1, U:(JJ)[I
        //    17: astore_1       
        //    18: aload_2        
        //    19: aload_1        
        //    20: ifnonnull       104
        //    23: arraylength    
        //    24: iconst_1       
        //    25: if_icmpeq       32
        //    28: iconst_1       
        //    29: goto            33
        //    32: iconst_0       
        //    33: ifeq            84
        //    36: goto            49
        //    39: ldc2_w          -4353128535136852146
        //    42: lload_3        
        //    43: invokedynamic   BootstrapMethod #1, U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;
        //    48: athrow         
        //    49: ldc             8245
        //    51: ldc2_w          8763943099370037539
        //    54: lload_3        
        //    55: lxor           
        //    56: invokedynamic   BootstrapMethod #0, z:(IJ)Ljava/lang/String;
        //    61: getstatic       ClassSub/Class153.WARNING:LClassSub/Class153;
        //    64: invokestatic    ClassSub/Class23.sendClientMessage:(Ljava/lang/String;LClassSub/Class153;)V
        //    67: aload_1        
        //    68: ifnull          282
        //    71: goto            84
        //    74: ldc2_w          -4353128535136852146
        //    77: lload_3        
        //    78: invokedynamic   BootstrapMethod #1, U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;
        //    83: athrow         
        //    84: aload_2        
        //    85: iconst_0       
        //    86: aaload         
        //    87: putstatic       cn/Hanabi/modules/Player/Spammer.prefix:Ljava/lang/String;
        //    90: aload_2        
        //    91: goto            104
        //    94: ldc2_w          -4353128535136852146
        //    97: lload_3        
        //    98: invokedynamic   BootstrapMethod #1, U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;
        //   103: athrow         
        //   104: iconst_0       
        //   105: aaload         
        //   106: putstatic       cn/Hanabi/modules/Player/AutoAbuse.prefix:Ljava/lang/String;
        //   109: getstatic       ClassSub/Class248.c:J
        //   112: ldc2_w          123582842086040
        //   115: lxor           
        //   116: lstore          5
        //   118: ldc2_w          1001290248230898139
        //   121: lload           5
        //   123: invokedynamic   BootstrapMethod #2, U:(JJ)[I
        //   128: new             Ljava/io/File;
        //   131: dup            
        //   132: new             Ljava/lang/StringBuilder;
        //   135: dup            
        //   136: invokespecial   java/lang/StringBuilder.<init>:()V
        //   139: getstatic       ClassSub/Class248.fileDir:Ljava/lang/String;
        //   142: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   145: ldc             23500
        //   147: ldc2_w          370742201172612227
        //   150: lload           5
        //   152: lxor           
        //   153: invokedynamic   BootstrapMethod #3, z:(IJ)Ljava/lang/String;
        //   158: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   161: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   164: invokespecial   java/io/File.<init>:(Ljava/lang/String;)V
        //   167: astore          7
        //   169: astore_1       
        //   170: aload           7
        //   172: invokevirtual   java/io/File.exists:()Z
        //   175: aload_1        
        //   176: ifnonnull       215
        //   179: ifne            216
        //   182: goto            196
        //   185: ldc2_w          993787259553442066
        //   188: lload           5
        //   190: invokedynamic   BootstrapMethod #4, U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;
        //   195: athrow         
        //   196: aload           7
        //   198: invokevirtual   java/io/File.createNewFile:()Z
        //   201: goto            215
        //   204: ldc2_w          993787259553442066
        //   207: lload           5
        //   209: invokedynamic   BootstrapMethod #5, U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;
        //   214: athrow         
        //   215: pop            
        //   216: new             Ljava/io/PrintWriter;
        //   219: dup            
        //   220: aload           7
        //   222: invokespecial   java/io/PrintWriter.<init>:(Ljava/io/File;)V
        //   225: dup            
        //   226: astore          5
        //   228: getstatic       cn/Hanabi/modules/Player/Spammer.prefix:Ljava/lang/String;
        //   231: invokevirtual   java/io/PrintWriter.print:(Ljava/lang/String;)V
        //   234: aload           5
        //   236: invokevirtual   java/io/PrintWriter.close:()V
        //   239: goto            245
        //   242: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   245: new             Ljava/lang/StringBuilder;
        //   248: dup            
        //   249: invokespecial   java/lang/StringBuilder.<init>:()V
        //   252: ldc             10023
        //   254: ldc2_w          6352754355123119669
        //   257: lload_3        
        //   258: lxor           
        //   259: invokedynamic   BootstrapMethod #0, z:(IJ)Ljava/lang/String;
        //   264: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   267: aload_2        
        //   268: iconst_0       
        //   269: aaload         
        //   270: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   273: invokestatic    java/lang/String.valueOf:(Ljava/lang/Object;)Ljava/lang/String;
        //   276: getstatic       ClassSub/Class153.SUCCESS:LClassSub/Class153;
        //   279: invokestatic    ClassSub/Class23.sendClientMessage:(Ljava/lang/String;LClassSub/Class153;)V
        //   282: return         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  179    201    204    215    Ljava/lang/Exception;
        //  172    182    185    196    Ljava/lang/Exception;
        //  172    239    242    245    Ljava/lang/Exception;
        //  20     36     39     49     Ljava/lang/RuntimeException;
        //  23     71     74     84     Ljava/lang/RuntimeException;
        //  56     91     94     104    Ljava/lang/RuntimeException;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0032:
        //     at com.strobel.decompiler.ast.Error.expressionLinkedFromMultipleLocations(Error.java:27)
        //     at com.strobel.decompiler.ast.AstOptimizer.mergeDisparateObjectInitializations(AstOptimizer.java:2596)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:235)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
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
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @NotNull
    @Override
    public final List<String> autocomplete(final int n, final String[] array) {
        return new ArrayList<String>();
    }
    
    private static void saveText() {
        final long n = Class248.c ^ 0x7065DF672298L;
        final int[] array = invokedynamic(U:(JJ)[I, 1001290248230898139L, n);
        final File file = new File(String.valueOf(new StringBuilder().append(Class248.fileDir).append(invokedynamic(z:(IJ)Ljava/lang/String;, 23500, 0x52524115423D483L ^ n))));
        final int[] array2 = array;
        final File file2 = file;
        try {
            Label_0081: {
                boolean exists;
                try {
                    exists = file2.exists();
                    if (array2 != null) {
                        break Label_0081;
                    }
                    if (!exists) {
                        break Label_0081;
                    }
                    break Label_0081;
                }
                catch (Exception ex) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex, 993787259553442066L, n);
                }
                try {
                    if (!exists) {
                        file.createNewFile();
                    }
                }
                catch (Exception ex2) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex2, 993787259553442066L, n);
                }
            }
            final PrintWriter printWriter;
            (printWriter = new PrintWriter(file)).print(Spammer.prefix);
            printWriter.close();
        }
        catch (Exception ex3) {
            ex3.printStackTrace();
        }
    }
    
    public static void loadText() throws IOException {
        final long n = Class248.c ^ 0x231DE23062ABL;
        final int[] array = invokedynamic(U:(JJ)[I, 5608704834922007016L, n);
        final File file = new File(String.valueOf(new StringBuilder().append(Class248.fileDir).append(invokedynamic(z:(IJ)Ljava/lang/String;, 30074, 0x629750EF75B1BA01L ^ n))));
        final int[] array2 = array;
        final File file2 = file;
        Label_0103: {
            Label_0081: {
                boolean exists;
                try {
                    exists = file2.exists();
                    if (array2 != null) {
                        break Label_0081;
                    }
                    if (!exists) {
                        break Label_0081;
                    }
                    break Label_0103;
                }
                catch (Exception ex) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex, 5618793896427039009L, n);
                }
                try {
                    if (exists) {
                        break Label_0103;
                    }
                    file.createNewFile();
                }
                catch (Exception ex2) {
                    throw invokedynamic(U:(Ljava/lang/Exception;JJ)Ljava/lang/Exception;, ex2, 5618793896427039009L, n);
                }
            }
            if (array2 == null) {
                return;
            }
        }
        String line;
        while ((line = new BufferedReader(new FileReader(file)).readLine()) != null) {
            final String s = line;
            try {
                AutoAbuse.prefix = (Spammer.prefix = String.valueOf(s));
                continue;
            }
            catch (Exception ex3) {
                if (array2 == null) {
                    continue;
                }
            }
            break;
        }
    }
    
    static {
        lIIllIIlIIIII();
        final long n = (c = Class169.a(-244857092140060097L, 4321086894940359679L, MethodHandles.lookup().lookupClass()).a(118333104613856L)) ^ 0x5908B60F6AA6L;
        f = new HashMap(13);
        final Cipher instance = Cipher.getInstance(Class248.llIlllIIlII[0]);
        final int n2 = 2;
        final SecretKeyFactory instance2 = SecretKeyFactory.getInstance(Class248.llIlllIIlII[1]);
        final byte[] array = new byte[8];
        array[0] = (byte)(n >>> 56);
        for (int i = 1; i < 8; ++i) {
            array[i] = (byte)(n << i * 8 >>> 56);
        }
        instance.init(n2, instance2.generateSecret(new DESKeySpec(array)), new IvParameterSpec(new byte[8]));
        final String[] d2 = new String[6];
        int n3 = 0;
        String s;
        int n4 = (s = Class248.llIlllIIlII[2]).length();
        int n5 = 16;
        int n6 = -1;
    Label_0164:
        while (true) {
            while (true) {
                ++n6;
                final String s2 = s;
                final int n7 = n6;
                String s3 = s2.substring(n7, n7 + n5);
                int n8 = -1;
                while (true) {
                    final String intern = a(instance.doFinal(s3.getBytes(Class248.llIlllIIlII[4]))).intern();
                    switch (n8) {
                        default: {
                            d2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                continue Label_0164;
                            }
                            n4 = (s = Class248.llIlllIIlII[3]).length();
                            n5 = 32;
                            n6 = -1;
                            break;
                        }
                        case 0: {
                            d2[n3++] = intern;
                            if ((n6 += n5) < n4) {
                                n5 = s.charAt(n6);
                                break;
                            }
                            break Label_0164;
                        }
                    }
                    ++n6;
                    final String s4 = s;
                    final int n9 = n6;
                    s3 = s4.substring(n9, n9 + n5);
                    n8 = 0;
                }
            }
            break;
        }
        d = d2;
        e = new String[6];
        Class248.fileDir = String.valueOf(new StringBuilder().append(Minecraft.func_71410_x().field_71412_D.getAbsolutePath()).append(invokedynamic(z:(IJ)Ljava/lang/String;, 2720, 0x2D079BEDBB444DD7L ^ n)));
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
        final int n3 = n ^ (int)(n2 & 0x7FFFL) ^ 0x2C7;
        if (Class248.e[n3] == null) {
            Object[] array;
            try {
                final Long value = Thread.currentThread().getId();
                if ((array = Class248.f.get(value)) == null) {
                    (array = new Object[3])[0] = Cipher.getInstance(Class248.llIlllIIlII[5]);
                    array[1] = SecretKeyFactory.getInstance(Class248.llIlllIIlII[6]);
                    array[2] = new IvParameterSpec(new byte[8]);
                    Class248.f.put(value, array);
                }
            }
            catch (Exception ex) {
                throw new RuntimeException(Class248.llIlllIIlII[7], ex);
            }
            final byte[] array2;
            (array2 = new byte[8])[0] = (byte)(n2 >>> 56);
            for (int i = 1; i < 8; ++i) {
                array2[i] = (byte)(n2 << i * 8 >>> 56);
            }
            ((Cipher)array[0]).init(2, ((SecretKeyFactory)array[1]).generateSecret(new DESKeySpec(array2)), (AlgorithmParameterSpec)array[2]);
            Class248.e[n3] = a(((Cipher)array[0]).doFinal(Class248.d[n3].getBytes(Class248.llIlllIIlII[8])));
        }
        return Class248.e[n3];
    }
    
    private static void lIIllIIlIIIII() {
        (llIlllIIlII = new String[12])[0] = "DES/CBC/PKCS5Padding";
        Class248.llIlllIIlII[1] = "DES";
        Class248.llIlllIIlII[2] = "m\u0097sQ>WÂd\u0099îD\fC5Þ¿\u0010À\u0091\u0097\u0015¤QKíbªhP÷û\u00ad \u0018Æp\u0097\\ºÂ¹ëU\u009c]D\u0003Fù\u0088&.96Ñ2põ\u0010º:¾\ræ>«\u0081á/BûIq\u0016\u009a";
        Class248.llIlllIIlII[3] = "¬÷\u008cb¶x6õ¤P\u001aô\u0088Ã\u007f6H\u0082cê;\u001cÇ}ZàÖ\u0001±\u001beµ \u007f¹n\u00ad\u008fÛl\u0080\u008d\u008cêGÓeFß÷Ys;6\u001f\u009b\u001b\u0080%¯ÍI\u0016[\u0093";
        Class248.llIlllIIlII[4] = "ISO-8859-1";
        Class248.llIlllIIlII[5] = "DES/CBC/PKCS5Padding";
        Class248.llIlllIIlII[6] = "DES";
        Class248.llIlllIIlII[7] = "你怎么到现在都不理解我揍你的原意呢请收起你的嘴脸你认为就你这点词汇能把我打倒在这小小的网络世界中吗你不觉得你现在像个跳梁小丑一样的取悦大家吗你难道不是疯疯癫癫的你还要逞能什么呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003\u2002\u2006\u200a";
        Class248.llIlllIIlII[8] = "ISO-8859-1";
        Class248.llIlllIIlII[9] = "你怎么到现在都不理解我揍你的原意呢请收起你的嘴脸你认为就你这点词汇能把我打倒在这小小的网络世界中吗你不觉得你现在像个跳梁小丑一样的取悦大家吗你难道不是疯疯癫癫的你还要逞能什么呢NMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSLNMSL\u2003\u2002\u2006\u200a";
        Class248.llIlllIIlII[10] = " : ";
        Class248.llIlllIIlII[11] = " : ";
    }
    
    private static String lIIllIIIlllII(final String s, final String s2) {
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
    
    private static String lIIllIIIlllll(final String s, final String s2) {
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
    
    private static String lIIllIIIllllI(String s, final String s2) {
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
    
    private static boolean lIIllIIllllII$255f299(final int n) {
        return n != 1;
    }
}
