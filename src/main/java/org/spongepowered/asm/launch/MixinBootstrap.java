package org.spongepowered.asm.launch;

import org.spongepowered.asm.launch.platform.*;
import org.spongepowered.asm.service.*;
import java.net.*;
import org.spongepowered.asm.mixin.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public abstract class MixinBootstrap
{
    private static String VERSION;
    private static final Logger logger;
    private static boolean initialised;
    private static boolean initState;
    private static MixinPlatformManager platform;
    private static final String[] llIllIIIII;
    
    private MixinBootstrap() {
        super();
    }
    
    @Deprecated
    private static void addProxy() {
        MixinService.getService().beginPhase();
    }
    
    public static MixinPlatformManager getPlatform() {
        if (MixinBootstrap.platform == null) {
            final MixinPlatformManager value;
            if ((value = GlobalProperties.get(MixinBootstrap.llIllIIIII[0])) instanceof MixinPlatformManager) {
                MixinBootstrap.platform = value;
            }
            else {
                MixinBootstrap.platform = new MixinPlatformManager();
                GlobalProperties.put(MixinBootstrap.llIllIIIII[1], MixinBootstrap.platform);
                final MixinPlatformManager platform = MixinBootstrap.platform;
                MixinPlatformManager.logger.debug(MixinPlatformManager.llIlll[0]);
                final MixinPlatformManager mixinPlatformManager = platform;
                try {
                    final URI uri;
                    if ((uri = mixinPlatformManager.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()) != null) {
                        MixinPlatformManager.logger.debug(MixinPlatformManager.llIlll[1], new Object[] { uri });
                        final MixinPlatformManager mixinPlatformManager2 = platform;
                        mixinPlatformManager2.primaryContainer = mixinPlatformManager2.addContainer(uri);
                    }
                }
                catch (URISyntaxException ex) {
                    ex.printStackTrace();
                }
                platform.scanClasspath();
            }
        }
        return MixinBootstrap.platform;
    }
    
    public static void init() {
        if (!start()) {
            return;
        }
        doInit(null);
    }
    
    static boolean start() {
        if (!isSubsystemRegistered()) {
            registerSubsystem(MixinBootstrap.llIllIIIII[5]);
            if (!MixinBootstrap.initialised) {
                MixinBootstrap.initialised = true;
                final String property;
                if ((property = System.getProperty(MixinBootstrap.llIllIIIII[6])) != null && property.contains(MixinBootstrap.llIllIIIII[7])) {
                    System.setProperty(MixinBootstrap.llIllIIIII[8], MixinBootstrap.llIllIIIII[9]);
                }
                final MixinEnvironment.Phase initialPhase;
                if (lIlIIIIlllII(initialPhase = MixinService.getService().getInitialPhase(), MixinEnvironment.Phase.DEFAULT)) {
                    MixinBootstrap.logger.error(MixinBootstrap.llIllIIIII[10]);
                    MixinEnvironment.init(initialPhase);
                    getPlatform().prepare(null);
                    MixinBootstrap.initState = false;
                }
                else {
                    MixinEnvironment.init(initialPhase);
                }
                MixinService.getService().beginPhase();
            }
            getPlatform();
            return true;
        }
        if (!checkSubsystemVersion()) {
            throw new MixinInitialisationError(String.valueOf(new StringBuilder().append(MixinBootstrap.llIllIIIII[2]).append(getActiveSubsystemVersion()).append(MixinBootstrap.llIllIIIII[3]).append(MixinBootstrap.llIllIIIII[4])));
        }
        return false;
    }
    
    static void doInit(final List<String> list) {
        if (MixinBootstrap.initialised) {
            getPlatform().getPhaseProviderClasses();
            if (MixinBootstrap.initState) {
                getPlatform().prepare(list);
                MixinService.getService().init();
            }
            return;
        }
        if (isSubsystemRegistered()) {
            MixinBootstrap.logger.warn(MixinBootstrap.llIllIIIII[11]);
            return;
        }
        throw new IllegalStateException(MixinBootstrap.llIllIIIII[12]);
    }
    
    static void inject() {
        getPlatform().inject();
    }
    
    private static boolean isSubsystemRegistered() {
        return GlobalProperties.get(MixinBootstrap.llIllIIIII[13]) != null;
    }
    
    private static boolean checkSubsystemVersion() {
        return MixinBootstrap.llIllIIIII[14].equals(getActiveSubsystemVersion());
    }
    
    private static Object getActiveSubsystemVersion() {
        final Object value;
        if ((value = GlobalProperties.get(MixinBootstrap.llIllIIIII[15])) != null) {
            return value;
        }
        return MixinBootstrap.llIllIIIII[16];
    }
    
    private static void registerSubsystem(final String s) {
        GlobalProperties.put(MixinBootstrap.llIllIIIII[17], s);
    }
    
    static {
        lIIlllIIIIlI();
        logger = LogManager.getLogger(MixinBootstrap.llIllIIIII[19]);
        MixinBootstrap.initialised = false;
        MixinBootstrap.initState = true;
        MixinService.boot();
        MixinService.getService().prepare();
    }
    
    private static void lIIlllIIIIlI() {
        (llIllIIIII = new String[20])[0] = "mixin.platform";
        MixinBootstrap.llIllIIIII[1] = "mixin.platform";
        MixinBootstrap.llIllIIIII[2] = "Mixin subsystem version ";
        MixinBootstrap.llIllIIIII[3] = " was already initialised. Cannot bootstrap version ";
        MixinBootstrap.llIllIIIII[4] = "0.7.10";
        MixinBootstrap.llIllIIIII[5] = "0.7.10";
        MixinBootstrap.llIllIIIII[6] = "sun.java.command";
        MixinBootstrap.llIllIIIII[7] = "GradleStart";
        MixinBootstrap.llIllIIIII[8] = "mixin.env.remapRefMap";
        MixinBootstrap.llIllIIIII[9] = "true";
        MixinBootstrap.llIllIIIII[10] = "Initialising mixin subsystem after game pre-init phase! Some mixins may be skipped.";
        MixinBootstrap.llIllIIIII[11] = "Multiple Mixin containers present, init suppressed for 0.7.10";
        MixinBootstrap.llIllIIIII[12] = "MixinBootstrap.doInit() called before MixinBootstrap.start()";
        MixinBootstrap.llIllIIIII[13] = "mixin.initialised";
        MixinBootstrap.llIllIIIII[14] = "0.7.10";
        MixinBootstrap.llIllIIIII[15] = "mixin.initialised";
        MixinBootstrap.llIllIIIII[16] = "";
        MixinBootstrap.llIllIIIII[17] = "mixin.initialised";
        MixinBootstrap.llIllIIIII[18] = "0.7.10";
        MixinBootstrap.llIllIIIII[19] = "mixin";
    }
    
    private static String lIIllIllllIl(final String s, final String s2) {
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
    
    private static String lIIllIllllII(final String s, final String s2) {
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
    
    private static String lIIllIlllllI(String s, final String s2) {
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
    
    private static boolean lIlIIIIlllII(final Object o, final Object o2) {
        return o == o2;
    }
}
