package ClassSub;

import net.minecraft.util.*;
import cn.Hanabi.injection.interfaces.*;
import net.minecraft.client.*;
import java.net.*;
import java.lang.management.*;
import java.io.*;
import java.util.*;
import java.security.*;

public class Class296
{
    public static boolean canSendMotionPacket;
    public static boolean cr4ckm3;
    public static boolean If;
    public static boolean y0u;
    public static boolean c4n;
    public static int counts;
    public static String fuckman;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class296() {
        super();
    }
    
    public static Timer getTimer() {
        return ((IMinecraft)Minecraft.func_71410_x()).getTimer();
    }
    
    public static boolean isProcessRunning(final String s) {
        final StringBuilder sb = new StringBuilder();
        final Runtime runtime = Runtime.getRuntime();
        try {
            String line;
            while ((line = new BufferedReader(new InputStreamReader(runtime.exec("tasklist /fi \"IMAGENAME eq " + s + "*\"").getInputStream())).readLine()) != null) {
                sb.append(String.valueOf((Object)line) + "\n");
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString().contains("PID");
    }
    
    public static boolean isProcessRunningTitle(final String s) {
        final StringBuilder sb = new StringBuilder();
        final Runtime runtime = Runtime.getRuntime();
        try {
            String line;
            while ((line = new BufferedReader(new InputStreamReader(runtime.exec("tasklist /fi \"windowtitle eq " + s + "*\"").getInputStream())).readLine()) != null) {
                sb.append(String.valueOf((Object)line) + "\n");
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        return sb.toString().contains("PID");
    }
    
    public static String fuckyou(final String p0, final String p1, final String p2, final String p3) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     3: nop            
        //     4: athrow         
        //     5: aload_2        
        //     6: ldc             "fuckyou"
        //     8: ldc             "hanabi"
        //    10: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //    13: astore_2       
        //    14: ldc             ""
        //    16: astore          4
        //    18: aconst_null    
        //    19: astore          5
        //    21: aload_2        
        //    22: ldc             "kidLOLOL"
        //    24: ldc             "hanabi"
        //    26: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //    29: astore_2       
        //    30: aload_2        
        //    31: ldc             "crackmeifyoucan"
        //    33: ldc             "hanabi"
        //    35: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //    38: astore_2       
        //    39: aload_2        
        //    40: ldc             "txt"
        //    42: ldc             "php"
        //    44: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //    47: astore_2       
        //    48: new             Ljava/net/InetSocketAddress;
        //    51: dup            
        //    52: ldc             "hanabi.alphaantileak.cn"
        //    54: ldc             893
        //    56: invokespecial   java/net/InetSocketAddress.<init>:(Ljava/lang/String;I)V
        //    59: astore          6
        //    61: aload           6
        //    63: invokevirtual   java/net/InetSocketAddress.getAddress:()Ljava/net/InetAddress;
        //    66: invokevirtual   java/net/InetAddress.getHostAddress:()Ljava/lang/String;
        //    69: ldc             "183.136.132.173"
        //    71: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    74: ifne            93
        //    77: new             Ljava/util/Random;
        //    80: dup            
        //    81: invokespecial   java/util/Random.<init>:()V
        //    84: ldc             50
        //    86: invokevirtual   java/util/Random.nextInt:(I)I
        //    89: ineg           
        //    90: putstatic       cn/Hanabi/Hanabi.flag:I
        //    93: aload_2        
        //    94: ldc             "loser"
        //    96: ldc             "hanabi"
        //    98: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   101: astore_2       
        //   102: aload_2        
        //   103: ldc             "https://alphaantileak.cn/"
        //   105: ldc             "http://hanabi.alphaantileak.cn:893/"
        //   107: invokevirtual   java/lang/String.replace:(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
        //   110: astore          7
        //   112: new             Ljava/net/URL;
        //   115: dup            
        //   116: aload           7
        //   118: invokespecial   java/net/URL.<init>:(Ljava/lang/String;)V
        //   121: astore          8
        //   123: aload           8
        //   125: invokevirtual   java/net/URL.openConnection:()Ljava/net/URLConnection;
        //   128: astore          9
        //   130: aload           9
        //   132: ldc             1
        //   134: invokevirtual   java/net/URLConnection.setDoOutput:(Z)V
        //   137: aload           9
        //   139: ldc             99781
        //   141: invokevirtual   java/net/URLConnection.setReadTimeout:(I)V
        //   144: aload           9
        //   146: ldc             "accept"
        //   148: ldc             "*/*"
        //   150: invokevirtual   java/net/URLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   153: aload           9
        //   155: ldc             "connection"
        //   157: ldc             "Keep-Alive"
        //   159: invokevirtual   java/net/URLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   162: aload           9
        //   164: ldc             "user-agent"
        //   166: ldc             "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36"
        //   168: invokevirtual   java/net/URLConnection.setRequestProperty:(Ljava/lang/String;Ljava/lang/String;)V
        //   171: aload           9
        //   173: invokevirtual   java/net/URLConnection.connect:()V
        //   176: aload           8
        //   178: invokevirtual   java/net/URL.toURI:()Ljava/net/URI;
        //   181: invokevirtual   java/net/URI.toString:()Ljava/lang/String;
        //   184: ldc             "|"
        //   186: invokevirtual   java/lang/String.split:(Ljava/lang/String;)[Ljava/lang/String;
        //   189: checkcast       [Ljava/lang/String;
        //   192: astore          10
        //   194: ldc             35
        //   196: newarray        C
        //   198: dup            
        //   199: ldc             0
        //   201: ldc             104
        //   203: castore        
        //   204: dup            
        //   205: ldc             1
        //   207: ldc             116
        //   209: castore        
        //   210: dup            
        //   211: ldc             2
        //   213: ldc             116
        //   215: castore        
        //   216: dup            
        //   217: ldc             3
        //   219: ldc             112
        //   221: castore        
        //   222: dup            
        //   223: ldc             4
        //   225: ldc             58
        //   227: castore        
        //   228: dup            
        //   229: ldc             5
        //   231: ldc             47
        //   233: castore        
        //   234: dup            
        //   235: ldc             6
        //   237: ldc             47
        //   239: castore        
        //   240: dup            
        //   241: ldc             7
        //   243: ldc             104
        //   245: castore        
        //   246: dup            
        //   247: ldc             8
        //   249: ldc             97
        //   251: castore        
        //   252: dup            
        //   253: ldc             9
        //   255: ldc             110
        //   257: castore        
        //   258: dup            
        //   259: ldc             10
        //   261: ldc             97
        //   263: castore        
        //   264: dup            
        //   265: ldc             11
        //   267: ldc             98
        //   269: castore        
        //   270: dup            
        //   271: ldc             12
        //   273: ldc             105
        //   275: castore        
        //   276: dup            
        //   277: ldc             13
        //   279: ldc             46
        //   281: castore        
        //   282: dup            
        //   283: ldc             14
        //   285: ldc             97
        //   287: castore        
        //   288: dup            
        //   289: ldc             15
        //   291: ldc             108
        //   293: castore        
        //   294: dup            
        //   295: ldc             16
        //   297: ldc             112
        //   299: castore        
        //   300: dup            
        //   301: ldc             17
        //   303: ldc             104
        //   305: castore        
        //   306: dup            
        //   307: ldc             18
        //   309: ldc             97
        //   311: castore        
        //   312: dup            
        //   313: ldc             19
        //   315: ldc             97
        //   317: castore        
        //   318: dup            
        //   319: ldc_w           20
        //   322: ldc             110
        //   324: castore        
        //   325: dup            
        //   326: ldc_w           21
        //   329: ldc             116
        //   331: castore        
        //   332: dup            
        //   333: ldc_w           22
        //   336: ldc             105
        //   338: castore        
        //   339: dup            
        //   340: ldc_w           23
        //   343: ldc             108
        //   345: castore        
        //   346: dup            
        //   347: ldc_w           24
        //   350: ldc_w           101
        //   353: castore        
        //   354: dup            
        //   355: ldc_w           25
        //   358: ldc             97
        //   360: castore        
        //   361: dup            
        //   362: ldc_w           26
        //   365: ldc_w           107
        //   368: castore        
        //   369: dup            
        //   370: ldc_w           27
        //   373: ldc             46
        //   375: castore        
        //   376: dup            
        //   377: ldc_w           28
        //   380: ldc_w           99
        //   383: castore        
        //   384: dup            
        //   385: ldc_w           29
        //   388: ldc             110
        //   390: castore        
        //   391: dup            
        //   392: ldc_w           30
        //   395: ldc             58
        //   397: castore        
        //   398: dup            
        //   399: ldc_w           31
        //   402: ldc_w           56
        //   405: castore        
        //   406: dup            
        //   407: ldc_w           32
        //   410: ldc_w           57
        //   413: castore        
        //   414: dup            
        //   415: ldc_w           33
        //   418: ldc_w           51
        //   421: castore        
        //   422: dup            
        //   423: ldc_w           34
        //   426: ldc             47
        //   428: castore        
        //   429: astore          11
        //   431: ldc             0
        //   433: istore          12
        //   435: iload           12
        //   437: ldc             35
        //   439: if_icmpge       506
        //   442: aload           10
        //   444: iload           12
        //   446: aaload         
        //   447: new             Ljava/lang/StringBuilder;
        //   450: dup            
        //   451: invokespecial   java/lang/StringBuilder.<init>:()V
        //   454: aload           11
        //   456: iload           12
        //   458: caload         
        //   459: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   462: ldc             ""
        //   464: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   467: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   470: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   473: ifne            493
        //   476: new             Ljava/util/Random;
        //   479: dup            
        //   480: invokespecial   java/util/Random.<init>:()V
        //   483: ldc_w           20
        //   486: invokevirtual   java/util/Random.nextInt:(I)I
        //   489: ineg           
        //   490: putstatic       ClassSub/Class296.counts:I
        //   493: iinc            12, 1
        //   496: goto            435
        //   499: nop            
        //   500: athrow         
        //   501: nop            
        //   502: nop            
        //   503: nop            
        //   504: nop            
        //   505: athrow         
        //   506: aload           8
        //   508: invokevirtual   java/net/URL.toURI:()Ljava/net/URI;
        //   511: invokevirtual   java/net/URI.toString:()Ljava/lang/String;
        //   514: invokestatic    ClassSub/Class296.crackme:(Ljava/lang/String;)V
        //   517: aload           9
        //   519: invokevirtual   java/net/URLConnection.getHeaderFields:()Ljava/util/Map;
        //   522: astore          12
        //   524: aload           12
        //   526: invokevirtual   java/util/Map.keySet:()Ljava/util/Set;
        //   529: invokevirtual   java/util/Set.iterator:()Ljava/util/Iterator;
        //   532: astore          13
        //   534: aload           13
        //   536: invokevirtual   java/util/Iterator.hasNext:()Z
        //   539: ifeq            562
        //   542: aload           13
        //   544: invokevirtual   java/util/Iterator.next:()Ljava/lang/Object;
        //   547: checkcast       Ljava/lang/String;
        //   550: astore          14
        //   552: goto            534
        //   555: nop            
        //   556: athrow         
        //   557: nop            
        //   558: nop            
        //   559: nop            
        //   560: nop            
        //   561: athrow         
        //   562: new             Ljava/io/BufferedReader;
        //   565: dup            
        //   566: new             Ljava/io/InputStreamReader;
        //   569: dup            
        //   570: aload           9
        //   572: invokevirtual   java/net/URLConnection.getInputStream:()Ljava/io/InputStream;
        //   575: invokespecial   java/io/InputStreamReader.<init>:(Ljava/io/InputStream;)V
        //   578: invokespecial   java/io/BufferedReader.<init>:(Ljava/io/Reader;)V
        //   581: astore          5
        //   583: aload           5
        //   585: invokevirtual   java/io/BufferedReader.readLine:()Ljava/lang/String;
        //   588: dup            
        //   589: astore          13
        //   591: ifnull          626
        //   594: new             Ljava/lang/StringBuilder;
        //   597: dup            
        //   598: invokespecial   java/lang/StringBuilder.<init>:()V
        //   601: aload           4
        //   603: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   606: aload           13
        //   608: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   611: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   614: astore          4
        //   616: goto            583
        //   619: nop            
        //   620: athrow         
        //   621: nop            
        //   622: nop            
        //   623: nop            
        //   624: nop            
        //   625: athrow         
        //   626: aload           5
        //   628: ifnull          636
        //   631: aload           5
        //   633: invokevirtual   java/io/BufferedReader.close:()V
        //   636: goto            699
        //   639: nop            
        //   640: athrow         
        //   641: astore          6
        //   643: goto            699
        //   646: nop            
        //   647: athrow         
        //   648: astore          6
        //   650: aload           5
        //   652: ifnull          660
        //   655: aload           5
        //   657: invokevirtual   java/io/BufferedReader.close:()V
        //   660: goto            699
        //   663: nop            
        //   664: athrow         
        //   665: astore          6
        //   667: goto            699
        //   670: nop            
        //   671: athrow         
        //   672: astore          15
        //   674: aload           5
        //   676: ifnull          684
        //   679: aload           5
        //   681: invokevirtual   java/io/BufferedReader.close:()V
        //   684: goto            691
        //   687: nop            
        //   688: athrow         
        //   689: astore          16
        //   691: aload           15
        //   693: athrow         
        //   694: nop            
        //   695: nop            
        //   696: nop            
        //   697: nop            
        //   698: athrow         
        //   699: aload           4
        //   701: areturn        
        //   702: nop            
        //   703: nop            
        //   704: nop            
        //   705: nop            
        //   706: athrow         
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  626    636    641    646    Ljava/lang/Exception;
        //  48     499    648    663    Ljava/lang/Exception;
        //  506    555    648    663    Ljava/lang/Exception;
        //  562    619    648    663    Ljava/lang/Exception;
        //  650    660    665    670    Ljava/lang/Exception;
        //  48     499    672    694    Any
        //  506    555    672    694    Any
        //  562    619    672    694    Any
        //  648    650    672    694    Any
        //  674    684    689    691    Ljava/lang/Exception;
        //  672    674    672    694    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Expression is linked from several locations: Label_0660:
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
    
    public static String setTarget(final String s) {
        String string = "";
        BufferedReader bufferedReader = null;
        try {
            final URL url = new URL(s.replace("https://alphaantileak.cn/", "http://hanabi.alphaantileak.cn:893/"));
            final URLConnection openConnection = url.openConnection();
            final String[] array = (String[])url.toURI().toString().split("|");
            final char[] array2 = { 'h', 't', 't', 'p', ':', '/', '/', 'h', 'a', 'n', 'a', 'b', 'i', '.', 'a', 'l', 'p', 'h', 'a', 'a', 'n', 't', 'i', 'l', 'e', 'a', 'k', '.', 'c', 'n', ':', '8', '9', '3', '/' };
            for (int i = 0; i < 35; ++i) {
                if (!array[i].equals(array2[i] + "")) {
                    Class296.counts = -new Random().nextInt(20);
                }
            }
            crackme(url.toURI().toString());
            openConnection.setDoOutput(true);
            openConnection.setReadTimeout(99781);
            openConnection.setRequestProperty("accept", "*/*");
            openConnection.setRequestProperty("connection", "Keep-Alive");
            openConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
            openConnection.connect();
            bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                string = string + line + "\n";
            }
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (Exception ex) {}
        }
        catch (Exception ex2) {}
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (Exception ex3) {}
        }
        return string;
    }
    
    public static String sendGet(final String s) {
        String string = "";
        BufferedReader bufferedReader = null;
        try {
            final URL url = new URL(s.replace("https://alphaantileak.cn/", "http://hanabi.alphaantileak.cn:893/"));
            final URLConnection openConnection = url.openConnection();
            final String[] array = (String[])url.toURI().toString().split("|");
            final char[] array2 = { 'h', 't', 't', 'p', ':', '/', '/', 'h', 'a', 'n', 'a', 'b', 'i', '.', 'a', 'l', 'p', 'h', 'a', 'a', 'n', 't', 'i', 'l', 'e', 'a', 'k', '.', 'c', 'n', ':', '8', '9', '3', '/' };
            for (int i = 0; i < 35; ++i) {
                if (!array[i].equals(array2[i] + "")) {
                    Class296.counts = -new Random().nextInt(20);
                }
            }
            crackme(url.toURI().toString());
            if (!((String[])ManagementFactory.getRuntimeMXBean().getBootClassPath().split(";"))[0].contains("\\lib\\")) {
                Class296.counts = -new Random().nextInt(20);
            }
            openConnection.setDoOutput(true);
            openConnection.setReadTimeout(99781);
            openConnection.setRequestProperty("accept", "*/*");
            openConnection.setRequestProperty("connection", "Keep-Alive");
            openConnection.setRequestProperty("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/76.0.3809.100 Safari/537.36");
            openConnection.connect();
            bufferedReader = new BufferedReader(new InputStreamReader(openConnection.getInputStream()));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                string = string + line + "\n";
            }
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (Exception ex) {}
        }
        catch (Exception ex2) {}
        finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
            }
            catch (Exception ex3) {}
        }
        return string;
    }
    
    public static void crackme(final String s) {
        try {
            Runtime.getRuntime().exec("taskkill /f /fi \"windowtitle eq Progress Te*\"");
            Runtime.getRuntime().exec("taskkill /f /fi \"windowtitle eq Fiddler*\"");
            Runtime.getRuntime().exec("taskkill /f /fi \"windowtitle eq SocksCa*\"");
            Runtime.getRuntime().exec("Taskkill /F /IM Fiddler.exe");
            Runtime.getRuntime().exec("Taskkill /F /IM TcpViewer.exe");
            Runtime.getRuntime().exec("Taskkill /F /IM Wireshark.exe");
        }
        catch (Exception ex) {}
        final String[] array = (String[])s.split("|");
        final char[] array2 = { 'h', 't', 't', 'p', ':', '/', '/', 'h', 'a', 'n', 'a', 'b', 'i', '.', 'a', 'l', 'p', 'h', 'a', 'a', 'n', 't', 'i', 'l', 'e', 'a', 'k', '.', 'c', 'n', ':', '8', '9', '3', '/' };
        for (int i = 0; i < 35; ++i) {
            if (!array[i].equals(array2[i] + "")) {
                Class296.counts = -new Random().nextInt(20);
            }
        }
    }
    
    public static String crackme() {
        String g = null;
        try {
            g = g(String.valueOf((Object)System.getenv("PROCESSOR_IDENTIFIER")) + System.getenv("COMPUTERNAME") + System.getProperty("user.name"));
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        catch (UnsupportedEncodingException ex2) {
            ex2.printStackTrace();
        }
        return g;
    }
    
    public static String g(String encodeToString) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        encodeToString = Base64.getUrlEncoder().encodeToString(encodeToString.getBytes());
        final MessageDigest instance = MessageDigest.getInstance("SHA-1");
        instance.update(encodeToString.getBytes("iso-8859-1"), 0, encodeToString.length());
        return z(instance.digest());
    }
    
    public static String z(final byte[] array) {
        final StringBuilder sb = new StringBuilder();
        for (final byte b : array) {
            int n = b >>> 4 & 0xF;
            int n2 = 0;
            do {
                if (n >= 0 && n <= 9) {
                    sb.append((char)(48 + n));
                }
                else {
                    sb.append((char)(97 + (n - 5)));
                }
                n = (b & 0xF);
            } while (n2++ < 1);
        }
        return sb.toString().toUpperCase();
    }
    
    public static String encode(final String s) {
        final String encodeToString = Base64.getUrlEncoder().encodeToString(s.getBytes());
        return encodeToString.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().substring(0, 8) + encodeToString.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().substring(encodeToString.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().length() - 8, encodeToString.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().length());
    }
    
    static {
        Class296.canSendMotionPacket = true;
        Class296.cr4ckm3 = fuckyou("https://alphaantileak.cn/nmsl.txt", "https://alphaantileak.cn/hwid.txt", "https://alphaantileak.cn/fuckyou.txt", "https://alphaantileak.cn/fdsryg4e5gr.txt").contains(crackme());
        Class296.If = fuckyou("https://alphaantileak.cn/re6tyhg.txt", "https://alphaantileak.cn/adfgsefad.txt", "https://alphaantileak.cn/loser.txt", "https://alphaantileak.cn/asdgbrfsd.txt").contains(crackme());
        Class296.y0u = fuckyou("https://alphaantileak.cn/243t3rgefv.txt", "https://alphaantileak.cn/asdasdfwrt.txt", "https://alphaantileak.cn/kidLOLOL.txt", "https://alphaantileak.cn/asdadfge5.txt").contains(crackme());
        Class296.c4n = fuckyou("https://alphaantileak.cn/asfdsfht.txt", "https://alphaantileak.cn/asdwget4e3gr.txt", "https://alphaantileak.cn/crackmeifyoucan.txt", "https://alphaantileak.cn/jrytdfv.txt").contains(crackme());
        Class296.counts = 1;
        Class296.fuckman = "2020-01-20";
    }
}
