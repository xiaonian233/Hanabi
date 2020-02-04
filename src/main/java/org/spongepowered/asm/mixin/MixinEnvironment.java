package org.spongepowered.asm.mixin;

import org.spongepowered.asm.util.perf.*;
import org.spongepowered.asm.obfuscation.*;
import org.spongepowered.asm.launch.*;
import org.spongepowered.asm.mixin.extensibility.*;
import org.spongepowered.asm.service.*;
import org.spongepowered.asm.mixin.transformer.*;
import org.spongepowered.asm.mixin.throwables.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import com.google.common.collect.*;
import org.spongepowered.asm.util.*;
import org.apache.logging.log4j.*;
import org.apache.logging.log4j.core.appender.*;
import org.apache.logging.log4j.core.*;

public final class MixinEnvironment implements ITokenProvider
{
    private static final Set<String> excludeTransformers;
    private static MixinEnvironment currentEnvironment;
    private static Phase currentPhase;
    private static CompatibilityLevel compatibility;
    private static boolean showHeader;
    private static final Logger logger;
    private static final Profiler profiler;
    private final IMixinService service;
    public final Phase phase;
    private final String configsKey;
    private final boolean[] options;
    private final Set<String> tokenProviderClasses;
    private final List<TokenProviderWrapper> tokenProviders;
    private final Map<String, Integer> internalTokens;
    public final RemapperChain remappers;
    public Side side;
    private List<ILegacyClassTransformer> transformers;
    public String obfuscationContext;
    private static final String[] lIllIlIIIII;
    
    MixinEnvironment(final Phase phase) {
        super();
        this.tokenProviderClasses = new HashSet<String>();
        this.tokenProviders = new ArrayList<TokenProviderWrapper>();
        this.internalTokens = new HashMap<String, Integer>();
        this.remappers = new RemapperChain();
        this.obfuscationContext = null;
        this.service = MixinService.getService();
        this.phase = phase;
        this.configsKey = String.valueOf(new StringBuilder().append(MixinEnvironment.lIllIlIIIII[0]).append(this.phase.name.toLowerCase()));
        final String version;
        if ((version = getVersion()) == null || !MixinEnvironment.lIllIlIIIII[1].equals(version)) {
            throw new MixinException(MixinEnvironment.lIllIlIIIII[2]);
        }
        this.service.checkEnv(this);
        this.options = new boolean[Option.values().length];
        Option[] values;
        for (int length = (values = Option.values()).length, i = 0; i < length; ++i) {
            final Option option = values[i];
            this.options[option.ordinal()] = option.getBooleanValue();
        }
        if (MixinEnvironment.showHeader) {
            MixinEnvironment.showHeader = false;
            this.printHeader(version);
        }
    }
    
    private void printHeader(final Object o) {
        final String codeSource = this.getCodeSource();
        final String name = this.service.getName();
        final Side side = this.getSide();
        MixinEnvironment.logger.info(MixinEnvironment.lIllIlIIIII[3], new Object[] { o, codeSource, name, side });
        final boolean option;
        if ((option = this.getOption(Option.DEBUG_VERBOSE)) || this.getOption(Option.DEBUG_EXPORT) || this.getOption(Option.DEBUG_PROFILER)) {
            final PrettyPrinter prettyPrinter;
            (prettyPrinter = new PrettyPrinter(32)).add(MixinEnvironment.lIllIlIIIII[4], option ? MixinEnvironment.lIllIlIIIII[5] : MixinEnvironment.lIllIlIIIII[6]).centre().hr('*');
            prettyPrinter.kv(MixinEnvironment.lIllIlIIIII[7], (Object)codeSource);
            prettyPrinter.kv(MixinEnvironment.lIllIlIIIII[8], o);
            prettyPrinter.kv(MixinEnvironment.lIllIlIIIII[9], CompatibilityLevel.JAVA_8.isSupported()).hr('*');
            prettyPrinter.kv(MixinEnvironment.lIllIlIIIII[10], (Object)name);
            prettyPrinter.kv(MixinEnvironment.lIllIlIIIII[11], (Object)this.service.getClass().getName()).hr('*');
            Option[] values;
            for (int length = (values = Option.values()).length, i = 0; i < length; ++i) {
                final Option option2 = values[i];
                final StringBuilder sb = new StringBuilder();
                for (int j = 0; j < option2.depth; ++j) {
                    sb.append(MixinEnvironment.lIllIlIIIII[12]);
                }
                prettyPrinter.kv(option2.property, MixinEnvironment.lIllIlIIIII[13], sb, option2);
            }
            prettyPrinter.hr('*').kv(MixinEnvironment.lIllIlIIIII[14], side);
            prettyPrinter.print(System.err);
        }
    }
    
    private String getCodeSource() {
        try {
            return this.getClass().getProtectionDomain().getCodeSource().getLocation().toString();
        }
        catch (Throwable t) {
            return MixinEnvironment.lIllIlIIIII[15];
        }
    }
    
    private Phase getPhase() {
        return this.phase;
    }
    
    @Deprecated
    private List<String> getMixinConfigs() {
        List<String> list;
        if ((list = GlobalProperties.get(this.configsKey)) == null) {
            list = new ArrayList<String>();
            GlobalProperties.put(this.configsKey, list);
        }
        return list;
    }
    
    @Deprecated
    public final MixinEnvironment addConfiguration(final String s) {
        MixinEnvironment.logger.warn(MixinEnvironment.lIllIlIIIII[16]);
        Mixins.addConfiguration(s, this);
        return this;
    }
    
    final void registerConfig(final String s) {
        List<String> list;
        if ((list = GlobalProperties.get(this.configsKey)) == null) {
            list = new ArrayList<String>();
            GlobalProperties.put(this.configsKey, list);
        }
        final List<String> list2;
        if (!(list2 = list).contains(s)) {
            list2.add(s);
        }
    }
    
    @Deprecated
    private MixinEnvironment registerErrorHandlerClass(final String s) {
        Mixins.registerErrorHandlerClass(s);
        return this;
    }
    
    public final MixinEnvironment registerTokenProviderClass(final String s) {
        if (!this.tokenProviderClasses.contains(s)) {
            try {
                final IEnvironmentTokenProvider environmentTokenProvider = (IEnvironmentTokenProvider)this.service.getClassProvider().findClass$3555389e(s).newInstance();
                if (environmentTokenProvider != null && !this.tokenProviderClasses.contains(environmentTokenProvider.getClass().getName())) {
                    final String name = environmentTokenProvider.getClass().getName();
                    final TokenProviderWrapper tokenProviderWrapper = new TokenProviderWrapper(environmentTokenProvider);
                    MixinEnvironment.logger.info(MixinEnvironment.lIllIlIIIII[18], new Object[] { name, this });
                    this.tokenProviders.add(tokenProviderWrapper);
                    this.tokenProviderClasses.add(name);
                    Collections.sort(this.tokenProviders);
                }
            }
            catch (Throwable t) {
                MixinEnvironment.logger.error(String.valueOf(new StringBuilder().append(MixinEnvironment.lIllIlIIIII[17]).append(s)), t);
            }
        }
        return this;
    }
    
    private MixinEnvironment registerTokenProvider(final IEnvironmentTokenProvider environmentTokenProvider) {
        if (environmentTokenProvider != null && !this.tokenProviderClasses.contains(environmentTokenProvider.getClass().getName())) {
            final String name = environmentTokenProvider.getClass().getName();
            final TokenProviderWrapper tokenProviderWrapper = new TokenProviderWrapper(environmentTokenProvider);
            MixinEnvironment.logger.info(MixinEnvironment.lIllIlIIIII[18], new Object[] { name, this });
            this.tokenProviders.add(tokenProviderWrapper);
            this.tokenProviderClasses.add(name);
            Collections.sort(this.tokenProviders);
        }
        return this;
    }
    
    @Override
    public final Integer getToken(String upperCase) {
        upperCase = upperCase.toUpperCase();
        final Iterator<TokenProviderWrapper> iterator = this.tokenProviders.iterator();
        while (iterator.hasNext()) {
            final Integer token$3de5502f;
            if ((token$3de5502f = iterator.next().provider.getToken$3de5502f()) != null) {
                return token$3de5502f;
            }
        }
        return this.internalTokens.get(upperCase);
    }
    
    @Deprecated
    private static Set<String> getErrorHandlerClasses() {
        return Mixins.getErrorHandlerClasses();
    }
    
    public static Object getActiveTransformer() {
        return GlobalProperties.get(MixinEnvironment.lIllIlIIIII[19]);
    }
    
    public static void setActiveTransformer(final ITransformer transformer) {
        GlobalProperties.put(MixinEnvironment.lIllIlIIIII[20], transformer);
    }
    
    private MixinEnvironment setSide(final Side side) {
        if (side != null && lllllIIllIll(this.getSide(), Side.UNKNOWN) && lllllIIlllII(side, Side.UNKNOWN)) {
            this.side = side;
        }
        return this;
    }
    
    public final Side getSide() {
        if (this.side == null) {
            Side[] values;
            for (int length = (values = Side.values()).length, i = 0; i < length; ++i) {
                final Side side;
                if ((side = values[i]).detect()) {
                    this.side = side;
                    break;
                }
            }
        }
        if (this.side != null) {
            return this.side;
        }
        return Side.UNKNOWN;
    }
    
    public static String getVersion() {
        return GlobalProperties.get(MixinEnvironment.lIllIlIIIII[21]);
    }
    
    public final boolean getOption(final Option option) {
        return this.options[option.ordinal()];
    }
    
    private void setOption(final Option option, final boolean b) {
        this.options[option.ordinal()] = b;
    }
    
    public static String getOptionValue(final Option option) {
        return option.getStringValue();
    }
    
    public static <E extends Enum<E>> E getOption(final Option option, final E e) {
        return option.getEnumValue(e);
    }
    
    private void setObfuscationContext(final String obfuscationContext) {
        this.obfuscationContext = obfuscationContext;
    }
    
    private String getObfuscationContext() {
        return this.obfuscationContext;
    }
    
    private String getRefmapObfuscationContext() {
        final String stringValue;
        if ((stringValue = Option.OBFUSCATION_TYPE.getStringValue()) != null) {
            return stringValue;
        }
        return this.obfuscationContext;
    }
    
    private RemapperChain getRemappers() {
        return this.remappers;
    }
    
    private void audit() {
        final Object activeTransformer;
        if ((activeTransformer = getActiveTransformer()) instanceof MixinTransformer) {
            final MixinTransformer mixinTransformer = (MixinTransformer)activeTransformer;
            final HashSet<String> set = new HashSet<String>();
            final Iterator<MixinConfig> iterator = mixinTransformer.configs.iterator();
            while (iterator.hasNext()) {
                set.addAll((Collection<?>)Collections.unmodifiableSet((Set<?>)iterator.next().unhandledTargets));
            }
            final Logger logger = LogManager.getLogger(MixinTransformer.lIllIlIlIl[4]);
            for (final String s : set) {
                final Logger logger2 = logger;
                final String s2 = MixinTransformer.lIllIlIlIl[5];
                final Object[] array = { s };
                try {
                    logger2.info(s2, array);
                    mixinTransformer.service.getClassProvider().findClass$3555389e(s);
                }
                catch (ClassNotFoundException ex) {
                    logger.error(String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[6]).append(s)), (Throwable)ex);
                }
            }
            final Iterator<MixinConfig> iterator3 = mixinTransformer.configs.iterator();
            while (iterator3.hasNext()) {
                for (final String s3 : Collections.unmodifiableSet((Set<? extends String>)iterator3.next().unhandledTargets)) {
                    logger.error(String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[8]).append(s3)), (Throwable)new ClassAlreadyLoadedException(String.valueOf(new StringBuilder().append(s3).append(MixinTransformer.lIllIlIlIl[7]))));
                }
            }
            if (this.getOption(Option.DEBUG_PROFILER)) {
                mixinTransformer.printProfilerSummary();
            }
        }
    }
    
    public final List<ILegacyClassTransformer> getTransformers() {
        if (this.transformers == null) {
            MixinEnvironment.logger.debug(MixinEnvironment.lIllIlIIIII[22]);
            this.transformers = new ArrayList<ILegacyClassTransformer>();
            final Iterator<ITransformer> iterator = this.service.getTransformers().iterator();
            while (iterator.hasNext()) {
                final ITransformer transformer;
                if ((transformer = iterator.next()) instanceof ILegacyClassTransformer) {
                    final ILegacyClassTransformer legacyClassTransformer;
                    final String name = (legacyClassTransformer = (ILegacyClassTransformer)transformer).getName();
                    boolean b = true;
                    final Iterator<String> iterator2 = MixinEnvironment.excludeTransformers.iterator();
                    while (iterator2.hasNext()) {
                        if (name.contains(iterator2.next())) {
                            b = false;
                            break;
                        }
                    }
                    if (b && !legacyClassTransformer.isDelegationExcluded()) {
                        MixinEnvironment.logger.debug(MixinEnvironment.lIllIlIIIII[23], new Object[] { name });
                        this.transformers.add(legacyClassTransformer);
                    }
                    else {
                        MixinEnvironment.logger.debug(MixinEnvironment.lIllIlIIIII[24], new Object[] { name });
                    }
                }
            }
            MixinEnvironment.logger.debug(MixinEnvironment.lIllIlIIIII[25], new Object[] { this.transformers.size() });
        }
        return Collections.unmodifiableList((List<? extends ILegacyClassTransformer>)this.transformers);
    }
    
    public final void addTransformerExclusion(final String s) {
        MixinEnvironment.excludeTransformers.add(s);
        this.transformers = null;
    }
    
    private void buildTransformerDelegationList() {
        MixinEnvironment.logger.debug(MixinEnvironment.lIllIlIIIII[22]);
        this.transformers = new ArrayList<ILegacyClassTransformer>();
        final Iterator<ITransformer> iterator = this.service.getTransformers().iterator();
        while (iterator.hasNext()) {
            final ITransformer transformer;
            if ((transformer = iterator.next()) instanceof ILegacyClassTransformer) {
                final ILegacyClassTransformer legacyClassTransformer;
                final String name = (legacyClassTransformer = (ILegacyClassTransformer)transformer).getName();
                boolean b = true;
                final Iterator<String> iterator2 = MixinEnvironment.excludeTransformers.iterator();
                while (iterator2.hasNext()) {
                    if (name.contains(iterator2.next())) {
                        b = false;
                        break;
                    }
                }
                if (b && !legacyClassTransformer.isDelegationExcluded()) {
                    MixinEnvironment.logger.debug(MixinEnvironment.lIllIlIIIII[23], new Object[] { name });
                    this.transformers.add(legacyClassTransformer);
                }
                else {
                    MixinEnvironment.logger.debug(MixinEnvironment.lIllIlIIIII[24], new Object[] { name });
                }
            }
        }
        MixinEnvironment.logger.debug(MixinEnvironment.lIllIlIIIII[25], new Object[] { this.transformers.size() });
    }
    
    @Override
    public final String toString() {
        return String.format(MixinEnvironment.lIllIlIIIII[26], this.getClass().getSimpleName(), this.phase);
    }
    
    private static Phase getCurrentPhase() {
        if (lllllIIllIll(MixinEnvironment.currentPhase, Phase.NOT_INITIALISED)) {
            init(Phase.PREINIT);
        }
        return MixinEnvironment.currentPhase;
    }
    
    public static void init(final Phase currentPhase) {
        if (lllllIIllIll(MixinEnvironment.currentPhase, Phase.NOT_INITIALISED)) {
            MixinEnvironment.currentPhase = currentPhase;
            MixinEnvironment.profiler.setActive(getEnvironment(currentPhase).getOption(Option.DEBUG_PROFILER));
            MixinLogWatcher.begin();
        }
    }
    
    public static MixinEnvironment getEnvironment(final Phase phase) {
        if (phase == null) {
            return Phase.DEFAULT.getEnvironment();
        }
        return phase.getEnvironment();
    }
    
    public static MixinEnvironment getDefaultEnvironment() {
        return getEnvironment(Phase.DEFAULT);
    }
    
    public static MixinEnvironment getCurrentEnvironment() {
        if (MixinEnvironment.currentEnvironment == null) {
            MixinEnvironment.currentEnvironment = getEnvironment(getCurrentPhase());
        }
        return MixinEnvironment.currentEnvironment;
    }
    
    public static CompatibilityLevel getCompatibilityLevel() {
        return MixinEnvironment.compatibility;
    }
    
    @Deprecated
    public static void setCompatibilityLevel(final CompatibilityLevel compatibility) throws IllegalArgumentException {
        if (!MixinEnvironment.lIllIlIIIII[27].equals(Thread.currentThread().getStackTrace()[2].getClassName())) {
            MixinEnvironment.logger.warn(MixinEnvironment.lIllIlIIIII[28]);
        }
        if (lllllIIlllII(compatibility, MixinEnvironment.compatibility) && compatibility.isAtLeast(MixinEnvironment.compatibility)) {
            if (!compatibility.isSupported()) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(MixinEnvironment.lIllIlIIIII[29]).append(compatibility).append(MixinEnvironment.lIllIlIIIII[30])));
            }
            MixinEnvironment.compatibility = compatibility;
            MixinEnvironment.logger.info(MixinEnvironment.lIllIlIIIII[31], new Object[] { compatibility });
        }
    }
    
    public static Profiler getProfiler() {
        return MixinEnvironment.profiler;
    }
    
    static void gotoPhase(final Phase currentPhase) {
        if (currentPhase == null || currentPhase.ordinal < 0) {
            throw new IllegalArgumentException(MixinEnvironment.lIllIlIIIII[32]);
        }
        if (currentPhase.ordinal > getCurrentPhase().ordinal) {
            MixinService.getService().beginPhase();
        }
        if (lllllIIllIll(currentPhase, Phase.DEFAULT)) {
            MixinLogWatcher.end();
        }
        MixinEnvironment.currentPhase = currentPhase;
        MixinEnvironment.currentEnvironment = getEnvironment(getCurrentPhase());
    }
    
    static {
        lllllIIlIIlI();
        excludeTransformers = Sets.newHashSet((Object[])new String[] { MixinEnvironment.lIllIlIIIII[33], MixinEnvironment.lIllIlIIIII[34], MixinEnvironment.lIllIlIIIII[35], MixinEnvironment.lIllIlIIIII[36] });
        MixinEnvironment.currentPhase = Phase.NOT_INITIALISED;
        MixinEnvironment.compatibility = Option.DEFAULT_COMPATIBILITY_LEVEL.getEnumValue(CompatibilityLevel.JAVA_6);
        MixinEnvironment.showHeader = true;
        logger = LogManager.getLogger(MixinEnvironment.lIllIlIIIII[37]);
        profiler = new Profiler();
    }
    
    private static void lllllIIlIIlI() {
        (lIllIlIIIII = new String[38])[0] = "mixin.configs.";
        MixinEnvironment.lIllIlIIIII[1] = "0.7.10";
        MixinEnvironment.lIllIlIIIII[2] = "Environment conflict, mismatched versions or you didn't call MixinBootstrap.init()";
        MixinEnvironment.lIllIlIIIII[3] = "SpongePowered MIXIN Subsystem Version={} Source={} Service={} Env={}";
        MixinEnvironment.lIllIlIIIII[4] = "SpongePowered MIXIN%s";
        MixinEnvironment.lIllIlIIIII[5] = " (Verbose debugging enabled)";
        MixinEnvironment.lIllIlIIIII[6] = "";
        MixinEnvironment.lIllIlIIIII[7] = "Code source";
        MixinEnvironment.lIllIlIIIII[8] = "Internal Version";
        MixinEnvironment.lIllIlIIIII[9] = "Java 8 Supported";
        MixinEnvironment.lIllIlIIIII[10] = "Service Name";
        MixinEnvironment.lIllIlIIIII[11] = "Service Class";
        MixinEnvironment.lIllIlIIIII[12] = "- ";
        MixinEnvironment.lIllIlIIIII[13] = "%s<%s>";
        MixinEnvironment.lIllIlIIIII[14] = "Detected Side";
        MixinEnvironment.lIllIlIIIII[15] = "Unknown";
        MixinEnvironment.lIllIlIIIII[16] = "MixinEnvironment::addConfiguration is deprecated and will be removed. Use Mixins::addConfiguration instead!";
        MixinEnvironment.lIllIlIIIII[17] = "Error instantiating ";
        MixinEnvironment.lIllIlIIIII[18] = "Adding new token provider {} to {}";
        MixinEnvironment.lIllIlIIIII[19] = "mixin.transformer";
        MixinEnvironment.lIllIlIIIII[20] = "mixin.transformer";
        MixinEnvironment.lIllIlIIIII[21] = "mixin.initialised";
        MixinEnvironment.lIllIlIIIII[22] = "Rebuilding transformer delegation list:";
        MixinEnvironment.lIllIlIIIII[23] = "  Adding:    {}";
        MixinEnvironment.lIllIlIIIII[24] = "  Excluding: {}";
        MixinEnvironment.lIllIlIIIII[25] = "Transformer delegation list created with {} entries";
        MixinEnvironment.lIllIlIIIII[26] = "%s[%s]";
        MixinEnvironment.lIllIlIIIII[27] = "org.spongepowered.asm.mixin.transformer.MixinConfig";
        MixinEnvironment.lIllIlIIIII[28] = "MixinEnvironment::setCompatibilityLevel is deprecated and will be removed. Set level via config instead!";
        MixinEnvironment.lIllIlIIIII[29] = "The requested compatibility level ";
        MixinEnvironment.lIllIlIIIII[30] = " could not be set. Level is not supported";
        MixinEnvironment.lIllIlIIIII[31] = "Compatibility level set to {}";
        MixinEnvironment.lIllIlIIIII[32] = "Cannot go to the specified phase, phase is null or invalid";
        MixinEnvironment.lIllIlIIIII[33] = "net.minecraftforge.fml.common.asm.transformers.EventSubscriptionTransformer";
        MixinEnvironment.lIllIlIIIII[34] = "cpw.mods.fml.common.asm.transformers.EventSubscriptionTransformer";
        MixinEnvironment.lIllIlIIIII[35] = "net.minecraftforge.fml.common.asm.transformers.TerminalTransformer";
        MixinEnvironment.lIllIlIIIII[36] = "cpw.mods.fml.common.asm.transformers.TerminalTransformer";
        MixinEnvironment.lIllIlIIIII[37] = "mixin";
    }
    
    private static String lllllIIIlllI(String s, final String s2) {
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
    
    private static String lllllIIIlIII(final String s, final String s2) {
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
    
    private static String lllllIIIlIIl(final String s, final String s2) {
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
    
    private static boolean lllllIIllllI(final int n, final int n2) {
        return n > n2;
    }
    
    public static boolean lllllIIlllII(final Object o, final Object o2) {
        return o != o2;
    }
    
    public static boolean lllllIIllIll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lllllIIlllIl(final int n) {
        return n < 0;
    }
}
