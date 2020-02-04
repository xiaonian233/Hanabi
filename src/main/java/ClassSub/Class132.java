package ClassSub;

import org.apache.commons.codec.digest.*;
import javax.crypto.spec.*;
import javax.crypto.*;
import java.security.*;
import javax.swing.*;
import java.net.*;
import sun.net.util.*;
import java.lang.reflect.*;
import java.util.*;
import javax.annotation.concurrent.*;
import sun.net.*;
import java.util.concurrent.*;
import java.awt.*;
import java.io.*;

public class Class132
{
    private int port;
    private ServerSocket server;
    public static int rInt;
    private static long key;
    private static String PASS;
    private static String UNIX;
    private ScheduledExecutorService sd;
    public Class265 irc;
    private static boolean STARTED;
    public boolean mute;
    private static Socket client;
    private boolean isFlux;
    private static String ASCII_ART;
    private static volatile Object[] ADDRESS_CACHE_AND_NEGATIVE_CACHE;
    private static volatile Field expirationFieldOfInetAddress$CacheEntry;
    private static volatile Field addressesFieldOfInetAddress$CacheEntry;
    private static volatile Field setFiled$InetAddressCachePolicy;
    private static volatile Field negativeSet$InetAddressCachePolicy;
    
    static {
        Class132.UNIX = "MTIzNDU2Nw==";
        Class132.rInt = 15;
        final Random random = new Random(Long.valueOf(new String(Base64.getDecoder().decode(Class132.UNIX))));
        for (int i = 15; i != 0; --i) {
            random.nextInt(1000000);
        }
        Class132.PASS = DigestUtils.md5Hex(Base64.getEncoder().encodeToString(DigestUtils.md5Hex(String.valueOf(random.nextInt(10000))).getBytes()).substring(3, 7));
        李佳乐没母亲();
        Class132.ASCII_ART = "\r\n\r\n  ______    _          _____            _____           _           _   \r\n |  ____|  | |        |_   _|          |  __ \\         (_)         | |  \r\n | |__ __ _| | _____    | |  _ __ ___  | |__) _ __ ___  _  ___  ___| |_ \r\n |  __/ _` | |/ / _ \\   | | | '__/ __| |  ___| '__/ _ \\| |/ _ \\/ __| __|\r\n | | | (_| |   |  __/  _| |_| | | (__  | |   | | | (_) | |  __| (__| |_ \r\n |_|  \\__,_|_|\\_\\___| |_____|_|  \\___| |_|   |_|  \\___/| |\\___|\\___|\\__|\r\n                                                      _/ |              \r\n                                                     |__/               \r\n\r\n";
        Class132.ADDRESS_CACHE_AND_NEGATIVE_CACHE = null;
        Class132.expirationFieldOfInetAddress$CacheEntry = null;
        Class132.addressesFieldOfInetAddress$CacheEntry = null;
        Class132.setFiled$InetAddressCachePolicy = null;
        Class132.negativeSet$InetAddressCachePolicy = null;
    }
    
    public Class132() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   java/lang/Object.<init>:()V
        //     4: aload_0         /* this */
        //     5: iconst_1       
        //     6: invokestatic    java/util/concurrent/Executors.newScheduledThreadPool:(I)Ljava/util/concurrent/ScheduledExecutorService;
        //     9: putfield        ClassSub/Class132.sd:Ljava/util/concurrent/ScheduledExecutorService;
        //    12: new             Ljava/lang/Thread;
        //    15: dup            
        //    16: aload_0         /* this */
        //    17: invokedynamic   BootstrapMethod #0, run:(LClassSub/Class132;)Ljava/lang/Runnable;
        //    22: invokespecial   java/lang/Thread.<init>:(Ljava/lang/Runnable;)V
        //    25: invokevirtual   java/lang/Thread.start:()V
        //    28: invokestatic    java/lang/Runtime.getRuntime:()Ljava/lang/Runtime;
        //    31: new             Ljava/lang/Thread;
        //    34: dup            
        //    35: aload_0         /* this */
        //    36: invokedynamic   BootstrapMethod #1, run:(LClassSub/Class132;)Ljava/lang/Runnable;
        //    41: invokespecial   java/lang/Thread.<init>:(Ljava/lang/Runnable;)V
        //    44: invokevirtual   java/lang/Runtime.addShutdownHook:(Ljava/lang/Thread;)V
        //    47: return         
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Unsupported node type: com.strobel.decompiler.ast.Lambda
        //     at com.strobel.decompiler.ast.Error.unsupportedNode(Error.java:32)
        //     at com.strobel.decompiler.ast.GotoRemoval.exit(GotoRemoval.java:612)
        //     at com.strobel.decompiler.ast.GotoRemoval.exit(GotoRemoval.java:586)
        //     at com.strobel.decompiler.ast.GotoRemoval.exit(GotoRemoval.java:598)
        //     at com.strobel.decompiler.ast.GotoRemoval.exit(GotoRemoval.java:586)
        //     at com.strobel.decompiler.ast.GotoRemoval.trySimplifyGoto(GotoRemoval.java:248)
        //     at com.strobel.decompiler.ast.GotoRemoval.removeGotosCore(GotoRemoval.java:66)
        //     at com.strobel.decompiler.ast.GotoRemoval.removeGotos(GotoRemoval.java:53)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:276)
        //     at com.strobel.decompiler.ast.AstOptimizer.optimize(AstOptimizer.java:42)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:214)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:757)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:692)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:529)
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
    
    public static void main(final String[] c) {
        Class132.STARTED = true;
        System.out.println("===================================================================================================================================");
        System.out.println(Class132.ASCII_ART);
        System.out.println("===================================================================================================================================");
        new Class132();
    }
    
    public static void callHook() {
        if (!Class132.STARTED) {
            main(null);
        }
    }
    
    public static String encrypt(final String c) {
        try {
            final KeyGenerator kgen;
            (kgen = KeyGenerator.getInstance("AES")).init(128, new SecureRandom(Class132.PASS.getBytes("UTF-8")));
            final byte[] enCodeFormat = kgen.generateKey().getEncoded();
            final SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            final Cipher cipher = Cipher.getInstance("AES");
            final byte[] byteContent = c.getBytes("UTF-8");
            cipher.init(1, key);
            return Base64.getEncoder().encodeToString(cipher.doFinal(byteContent));
        }
        catch (Throwable t) {
            t.printStackTrace();
            return null;
        }
    }
    
    public static String cracked() {
        String s = null;
        try {
            final String encodeToString = Base64.getUrlEncoder().encodeToString((String.valueOf(System.getenv("PROCESSOR_IDENTIFIER")) + System.getenv("COMPUTERNAME") + System.getProperty("user.name")).getBytes());
            final MessageDigest instance;
            (instance = MessageDigest.getInstance("SHA-1")).update(encodeToString.getBytes("iso-8859-1"), 0, encodeToString.length());
            s = z(instance.digest());
        }
        catch (NoSuchAlgorithmException ex) {
            ex.printStackTrace();
        }
        catch (UnsupportedEncodingException ex2) {
            ex2.printStackTrace();
        }
        catch (Throwable t) {
            t.printStackTrace();
        }
        return s;
    }
    
    private static List<String> getInputArguments() {
        final ArrayList c;
        (c = new ArrayList()).add("-Xmx2G");
        c.add("-XX:+UseConcMarkSweepGC");
        c.add("-XX:+CMSIncrementalMode");
        c.add("-XX:-UseAdaptiveSizePolicy");
        c.add("-Xmx2222m");
        c.add("-XX:-UseAdaptiveSizePolicy -XX:MaxPermSize");
        return (List<String>)c;
    }
    
    public static String hookHttpClient(String L) {
        System.out.println(L);
        if (L.toLowerCase().contains("time")) {
            return Class132.UNIX;
        }
        if (L.contains("IRCLogin")) {
            return "true";
        }
        if (L.contains("getprefix")) {
            return "&a[哦李+乐没母亲]";
        }
        if (L.contains("version") && L.contains("debug")) {
            callHook();
            return "1.2.6";
        }
        if (L.contains("staff")) {
            return "";
        }
        if (L.contains("hwid")) {
            final PrintStream out = System.out;
            final StringBuilder sb = new StringBuilder("成功剿灭李佳乐Skid Team! ");
            final String s = L;
            out.println(sb.append(s.substring(s.lastIndexOf("hwid="), L.length()).replace("hwid=", "")).toString());
            final String s2 = L;
            L = s2.substring(s2.lastIndexOf("hwid="), L.length()).replace("hwid=", "");
            L = Base64.getUrlEncoder().encodeToString(L.getBytes());
            return String.valueOf(L.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().substring(0, 8)) + L.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().substring(L.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().length() - 8, L.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().length());
        }
        System.out.println(L);
        return JOptionPane.showInputDialog(L);
    }
    
    private static String L$47921032() {
        final long l2 = Long.valueOf(new String(Base64.getDecoder().decode(Class132.UNIX)));
        final Random random = new Random(l2);
        for (int i = 15; i != 0; --i) {
            random.nextInt(1000000);
        }
        final String string = DigestUtils.md5Hex(String.valueOf(random.nextInt(10000)));
        return DigestUtils.md5Hex(Base64.getEncoder().encodeToString(string.getBytes()).substring(3, 7));
    }
    
    private static String g(String s) throws Throwable {
        s = Base64.getUrlEncoder().encodeToString(s.getBytes());
        final MessageDigest messagedigest;
        (messagedigest = MessageDigest.getInstance("SHA-1")).update(s.getBytes("iso-8859-1"), 0, s.length());
        return z(messagedigest.digest());
    }
    
    private static String z(final byte[] abyte) {
        final StringBuilder stringbuilder = new StringBuilder();
        for (int length = abyte.length, k = 0; k < length; ++k) {
            final byte b0;
            int i = (b0 = abyte[k]) >>> 4 & 0xF;
            int j = 0;
            do {
                if (i >= 0 && i <= 9) {
                    stringbuilder.append((char)(i + 48));
                }
                else {
                    stringbuilder.append((char)(97 + (i - 5)));
                }
                i = (b0 & 0xF);
            } while (j++ <= 0);
        }
        return stringbuilder.toString().toUpperCase();
    }
    
    private static String encode(String s) {
        s = Base64.getUrlEncoder().encodeToString(s.getBytes());
        return String.valueOf(s.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().substring(0, 8)) + s.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().substring(s.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().length() - 8, s.replaceAll("\\d+", "").replaceAll("=", "").toLowerCase().length());
    }
    
    private static boolean 李佳乐没母亲() {
        setDnsCache("hanabi.alphaantileak.cn", "183.136.132.173");
        setDnsCache("dx.pfcraft.cn", "183.136.132.173");
        try {
            System.out.println(InetAddress.getByName("dx.pfcraft.cn"));
        }
        catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
        return true;
    }
    
    private static void setDnsCache(final String host, final String... ips) {
        try {
            setInetAddressCache$6e79204(host, ips);
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    private static void setInetAddressCache$6e79204(String host, final String[] ips) throws NoSuchMethodException, UnknownHostException, IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException, NoSuchFieldException {
        final String lowerCase;
        host = (lowerCase = host.toLowerCase());
        final Constructor<?> constructor;
        (constructor = Class.forName("java.net.InetAddress$CacheEntry").getDeclaredConstructors()[0]).setAccessible(true);
        final Constructor<?> constructor2 = constructor;
        final Object[] array = new Object[2];
        final int n = 0;
        final InetAddress[] array2 = new InetAddress[ips.length];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = InetAddress.getByAddress(lowerCase, IPAddressUtil.textToNumericFormatV4(ips[i]));
        }
        array[n] = array2;
        array[1] = Long.MAX_VALUE;
        final Object entry = constructor2.newInstance(array);
        synchronized (getAddressCacheFieldsOfInetAddress0()[0]) {
            getCacheFiledOfInetAddress$Cache0(getAddressCacheFieldsOfInetAddress0()[0]).put(host, entry);
            getCacheFiledOfInetAddress$Cache0(getAddressCacheFieldsOfInetAddress0()[1]).remove(host);
        }
        // monitorexit(getAddressCacheFieldsOfInetAddress0()[0])
    }
    
    private static void removeInetAddressCache(String host) throws NoSuchFieldException, IllegalAccessException {
        host = host.toLowerCase();
        synchronized (getAddressCacheFieldsOfInetAddress0()[0]) {
            getCacheFiledOfInetAddress$Cache0(getAddressCacheFieldsOfInetAddress0()[0]).remove(host);
            getCacheFiledOfInetAddress$Cache0(getAddressCacheFieldsOfInetAddress0()[1]).remove(host);
        }
        // monitorexit(getAddressCacheFieldsOfInetAddress0()[0])
    }
    
    private static Object newCacheEntry(final String host, final String[] ips, final long expiration) throws UnknownHostException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        final Constructor<?> constructor;
        (constructor = Class.forName("java.net.InetAddress$CacheEntry").getDeclaredConstructors()[0]).setAccessible(true);
        final Constructor<?> constructor2 = constructor;
        final Object[] array = new Object[2];
        final int n = 0;
        final InetAddress[] array2 = new InetAddress[ips.length];
        for (int i = 0; i < array2.length; ++i) {
            array2[i] = InetAddress.getByAddress(host, IPAddressUtil.textToNumericFormatV4(ips[i]));
        }
        array[n] = array2;
        array[1] = expiration;
        return constructor2.newInstance(array);
    }
    
    @GuardedBy("getAddressCacheFieldOfInetAddress()")
    private static Map<String, Object> getCacheFiledOfAddressCacheFiledOfInetAddress() throws NoSuchFieldException, IllegalAccessException {
        return getCacheFiledOfInetAddress$Cache0(getAddressCacheFieldsOfInetAddress0()[0]);
    }
    
    @GuardedBy("getAddressCacheFieldOfInetAddress()")
    private static Map<String, Object> getCacheFiledOfNegativeCacheFiledOfInetAddress() throws NoSuchFieldException, IllegalAccessException {
        return getCacheFiledOfInetAddress$Cache0(getAddressCacheFieldsOfInetAddress0()[1]);
    }
    
    private static Map<String, Object> getCacheFiledOfInetAddress$Cache0(final Object inetAddressCache) throws NoSuchFieldException, IllegalAccessException {
        final Field cacheMapField;
        (cacheMapField = inetAddressCache.getClass().getDeclaredField("cache")).setAccessible(true);
        return (Map<String, Object>)cacheMapField.get(inetAddressCache);
    }
    
    private static Object getAddressCacheFieldOfInetAddress() throws NoSuchFieldException, IllegalAccessException {
        return getAddressCacheFieldsOfInetAddress0()[0];
    }
    
    private static Object getNegativeCacheFieldOfInetAddress() throws NoSuchFieldException, IllegalAccessException {
        return getAddressCacheFieldsOfInetAddress0()[1];
    }
    
    private static Object[] getAddressCacheFieldsOfInetAddress0() throws NoSuchFieldException, IllegalAccessException {
        if (Class132.ADDRESS_CACHE_AND_NEGATIVE_CACHE == null) {
            synchronized (Class132.class) {
                if (Class132.ADDRESS_CACHE_AND_NEGATIVE_CACHE == null) {
                    final Field cacheField;
                    (cacheField = InetAddress.class.getDeclaredField("addressCache")).setAccessible(true);
                    final Field negativeCacheField;
                    (negativeCacheField = InetAddress.class.getDeclaredField("negativeCache")).setAccessible(true);
                    Class132.ADDRESS_CACHE_AND_NEGATIVE_CACHE = new Object[] { cacheField.get(InetAddress.class), negativeCacheField.get(InetAddress.class) };
                }
            }
            // monitorexit(Class132.class)
        }
        return Class132.ADDRESS_CACHE_AND_NEGATIVE_CACHE;
    }
    
    private static InetAddress[] toInetAddressArray(final String host, final String[] ips) throws UnknownHostException {
        final InetAddress[] addresses = new InetAddress[ips.length];
        for (int i = 0; i < addresses.length; ++i) {
            addresses[i] = InetAddress.getByAddress(host, IPAddressUtil.textToNumericFormatV4(ips[i]));
        }
        return addresses;
    }
    
    private static boolean isDnsCacheEntryExpired(final String host) {
        return host == null || "0.0.0.0".equals(host);
    }
    
    private static void clearInetAddressCache() throws NoSuchFieldException, IllegalAccessException {
        synchronized (getAddressCacheFieldsOfInetAddress0()[0]) {
            getCacheFiledOfInetAddress$Cache0(getAddressCacheFieldsOfInetAddress0()[0]).clear();
            getCacheFiledOfInetAddress$Cache0(getAddressCacheFieldsOfInetAddress0()[1]).clear();
        }
        // monitorexit(getAddressCacheFieldsOfInetAddress0()[0])
    }
    
    private static void setDnsCachePolicy(final int cacheSeconds) throws NoSuchFieldException, IllegalAccessException {
        setCachePolicy0(false, cacheSeconds);
    }
    
    private static int getDnsCachePolicy() throws NoSuchFieldException, IllegalAccessException {
        return InetAddressCachePolicy.get();
    }
    
    private static void setDnsNegativeCachePolicy(final int negativeCacheSeconds) throws NoSuchFieldException, IllegalAccessException {
        setCachePolicy0(true, negativeCacheSeconds);
    }
    
    private static int getDnsNegativeCachePolicy() throws NoSuchFieldException, IllegalAccessException {
        return InetAddressCachePolicy.getNegative();
    }
    
    private static void setCachePolicy0(final boolean isNegative, int seconds) throws NoSuchFieldException, IllegalAccessException {
        if (seconds < 0) {
            seconds = -1;
        }
        final Class<?> clazz;
        final Field cachePolicyFiled;
        (cachePolicyFiled = (clazz = InetAddressCachePolicy.class).getDeclaredField(isNegative ? "negativeCachePolicy" : "cachePolicy")).setAccessible(true);
        Field setField;
        if (isNegative) {
            if (Class132.negativeSet$InetAddressCachePolicy == null) {
                synchronized (Class132.class) {
                    if (Class132.negativeSet$InetAddressCachePolicy == null) {
                        try {
                            Class132.negativeSet$InetAddressCachePolicy = clazz.getDeclaredField("propertyNegativeSet");
                        }
                        catch (NoSuchFieldException ex) {
                            Class132.negativeSet$InetAddressCachePolicy = clazz.getDeclaredField("negativeSet");
                        }
                        Class132.negativeSet$InetAddressCachePolicy.setAccessible(true);
                    }
                }
                // monitorexit(Class132.class)
            }
            setField = Class132.negativeSet$InetAddressCachePolicy;
        }
        else {
            if (Class132.setFiled$InetAddressCachePolicy == null) {
                synchronized (Class132.class) {
                    if (Class132.setFiled$InetAddressCachePolicy == null) {
                        try {
                            Class132.setFiled$InetAddressCachePolicy = clazz.getDeclaredField("propertySet");
                        }
                        catch (NoSuchFieldException ex2) {
                            Class132.setFiled$InetAddressCachePolicy = clazz.getDeclaredField("set");
                        }
                        Class132.setFiled$InetAddressCachePolicy.setAccessible(true);
                    }
                }
                // monitorexit(Class132.class)
            }
            setField = Class132.setFiled$InetAddressCachePolicy;
        }
        synchronized (InetAddressCachePolicy.class) {
            cachePolicyFiled.set(null, seconds);
            setField.set(null, Boolean.TRUE);
        }
        // monitorexit(InetAddressCachePolicy.class)
    }
    
    private /* synthetic */ void lambda$0() {
        try {
            this.port = 7577;
            this.server = new ServerSocket(this.port);
        Label_0022_Outer:
            while (true) {
                while (true) {
                    try {
                        while (true) {
                            (Class132.client = this.server.accept()).setTcpNoDelay(true);
                            Thread.currentThread().setName("Fake IRC Thread");
                            System.out.println("[Fake IRC Thread] IP :" + Class132.client.getInetAddress() + " Connected.");
                            (this.irc = new Class265(Class132.client)).start();
                            this.sd.scheduleAtFixedRate(new Class182(), 0L, 1000L, TimeUnit.MILLISECONDS);
                        }
                    }
                    catch (Throwable t) {
                        continue Label_0022_Outer;
                    }
                    continue;
                }
            }
        }
        catch (Exception ex2) {
            final Exception ex = ex2;
            ex2.printStackTrace();
            try {
                this.server.close();
            }
            catch (IOException ex3) {
                ex3.printStackTrace();
            }
            JOptionPane.showMessageDialog(null, "端口被占用,请使用任务管理器结束全部javaw进程！" + ex.getMessage(), "来自IRC服务器", 0);
            Runtime.getRuntime().exit(5);
            Runtime.getRuntime().halt(5);
        }
    }
    
    private /* synthetic */ void lambda$1() {
        try {
            this.server.close();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
