package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.transformers.*;
import org.spongepowered.asm.util.perf.*;
import org.spongepowered.asm.service.*;
import org.spongepowered.asm.mixin.injection.invoke.arg.*;
import org.spongepowered.asm.mixin.transformer.ext.extensions.*;
import org.apache.logging.log4j.*;
import java.text.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.transformer.throwables.*;
import org.spongepowered.asm.mixin.refmap.*;
import org.spongepowered.asm.mixin.transformer.ext.*;
import org.spongepowered.asm.mixin.throwables.*;
import org.spongepowered.asm.mixin.extensibility.*;
import org.spongepowered.asm.lib.tree.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

public class MixinTransformer extends TreeTransformer
{
    private static final String MIXIN_AGENT_CLASS;
    private static final String METRONOME_AGENT_CLASS;
    private static Logger logger;
    public final IMixinService service;
    public final List<MixinConfig> configs;
    private final List<MixinConfig> pendingConfigs;
    public final ReEntranceLock lock;
    private final String sessionId;
    private final Extensions extensions;
    private final IHotSwap hotSwapper;
    private final MixinPostProcessor postProcessor;
    private final Profiler profiler;
    private MixinEnvironment currentEnvironment;
    private Level verboseLoggingLevel;
    private boolean errorState;
    private int transformedCount;
    public static final String[] lIllIlIlIl;
    
    MixinTransformer() {
        super();
        this.service = MixinService.getService();
        this.configs = new ArrayList<MixinConfig>();
        this.pendingConfigs = new ArrayList<MixinConfig>();
        this.sessionId = UUID.randomUUID().toString();
        this.verboseLoggingLevel = Level.DEBUG;
        this.errorState = false;
        this.transformedCount = 0;
        final MixinEnvironment currentEnvironment = MixinEnvironment.getCurrentEnvironment();
        if (MixinEnvironment.getActiveTransformer() instanceof ITransformer) {
            throw new MixinException(String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[0]).append(this)));
        }
        MixinEnvironment.setActiveTransformer(this);
        this.lock = this.service.getReEntranceLock();
        this.extensions = new Extensions(this);
        this.hotSwapper = this.initHotSwapper(currentEnvironment);
        this.postProcessor = new MixinPostProcessor();
        this.extensions.add(new ArgsClassGenerator());
        this.extensions.add(new InnerClassGenerator());
        this.extensions.add(new ExtensionClassExporter(currentEnvironment));
        this.extensions.add(new ExtensionCheckClass());
        this.extensions.add(new ExtensionCheckInterfaces());
        this.profiler = MixinEnvironment.getProfiler();
    }
    
    private IHotSwap initHotSwapper(final MixinEnvironment mixinEnvironment) {
        if (!mixinEnvironment.getOption(MixinEnvironment.Option.HOT_SWAP)) {
            return null;
        }
        try {
            MixinTransformer.logger.info(MixinTransformer.lIllIlIlIl[1]);
            return (IHotSwap)Class.forName(MixinTransformer.lIllIlIlIl[2]).getDeclaredConstructor(MixinTransformer.class).newInstance(this);
        }
        catch (Throwable t) {
            MixinTransformer.logger.info(MixinTransformer.lIllIlIlIl[3], new Object[] { t.getClass().getSimpleName(), t.getMessage() });
            return null;
        }
    }
    
    private void audit(final MixinEnvironment mixinEnvironment) {
        final HashSet<String> set = new HashSet<String>();
        final Iterator<MixinConfig> iterator = this.configs.iterator();
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
                this.service.getClassProvider().findClass$3555389e(s);
            }
            catch (ClassNotFoundException ex) {
                logger.error(String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[6]).append(s)), (Throwable)ex);
            }
        }
        final Iterator<MixinConfig> iterator3 = this.configs.iterator();
        while (iterator3.hasNext()) {
            for (final String s3 : Collections.unmodifiableSet((Set<? extends String>)iterator3.next().unhandledTargets)) {
                logger.error(String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[8]).append(s3)), (Throwable)new ClassAlreadyLoadedException(String.valueOf(new StringBuilder().append(s3).append(MixinTransformer.lIllIlIlIl[7]))));
            }
        }
        if (mixinEnvironment.getOption(MixinEnvironment.Option.DEBUG_PROFILER)) {
            this.printProfilerSummary();
        }
    }
    
    public final void printProfilerSummary() {
        final DecimalFormat decimalFormat = new DecimalFormat(MixinTransformer.lIllIlIlIl[9]);
        final DecimalFormat decimalFormat2 = new DecimalFormat(MixinTransformer.lIllIlIlIl[10]);
        final PrettyPrinter printer$10807035 = this.profiler.printer$10807035();
        final long totalTime = this.profiler.get(MixinTransformer.lIllIlIlIl[11]).getTotalTime();
        final long totalTime2 = this.profiler.get(MixinTransformer.lIllIlIlIl[12]).getTotalTime();
        final long totalTime3 = this.profiler.get(MixinTransformer.lIllIlIlIl[13]).getTotalTime();
        final long totalTime4 = this.profiler.get(MixinTransformer.lIllIlIlIl[14]).getTotalTime();
        final long totalTime5 = this.profiler.get(MixinTransformer.lIllIlIlIl[15]).getTotalTime();
        final long totalTime6 = this.profiler.get(MixinTransformer.lIllIlIlIl[16]).getTotalTime();
        final long totalTime7 = this.profiler.get(MixinTransformer.lIllIlIlIl[17]).getTotalTime();
        final long totalTime8 = this.profiler.get(MixinTransformer.lIllIlIlIl[18]).getTotalTime();
        final long n2;
        final double n = (n2 = totalTime5 - totalTime6 - totalTime7 - totalTime8) / totalTime5 * 100.0;
        final double n3 = totalTime6 / totalTime5 * 100.0;
        final double n4 = totalTime7 / totalTime5 * 100.0;
        final double n5 = totalTime8 / totalTime5 * 100.0;
        long n6 = 0L;
        Profiler.Section section = null;
        final Iterator<Profiler.Section> iterator = this.profiler.getSections().iterator();
        while (iterator.hasNext()) {
            final Profiler.Section section2;
            final long n7;
            if ((n7 = ((section2 = iterator.next()).name.startsWith(MixinTransformer.lIllIlIlIl[19]) ? section2.getTotalTime() : 0L)) > n6) {
                n6 = n7;
                section = section2;
            }
        }
        printer$10807035.hr('*').add(MixinTransformer.lIllIlIlIl[20]).hr('*').add();
        final String s = MixinTransformer.lIllIlIlIl[21];
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[22], s, totalTime5, decimalFormat.format(totalTime5 * 0.001)).add();
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[23], s, totalTime, decimalFormat.format(totalTime * 0.001));
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[24], s, totalTime2, decimalFormat.format(totalTime2 * 0.001));
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[25], s, totalTime3, decimalFormat.format(totalTime3 * 0.001));
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[26], s, totalTime4, decimalFormat.format(totalTime4 * 0.001)).add();
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[27], (Object)MixinTransformer.lIllIlIlIl[28]);
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[29], s, totalTime6, decimalFormat.format(totalTime6 * 0.001));
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[30], s, totalTime7, decimalFormat.format(totalTime7 * 0.001)).add();
        if (section != null) {
            printer$10807035.kv(MixinTransformer.lIllIlIlIl[31], (Object)section.name);
            printer$10807035.kv(MixinTransformer.lIllIlIlIl[32], (Object)section.info);
            printer$10807035.kv(MixinTransformer.lIllIlIlIl[33], MixinTransformer.lIllIlIlIl[34], section.getTotalSeconds());
            printer$10807035.kv(MixinTransformer.lIllIlIlIl[35], MixinTransformer.lIllIlIlIl[36], section.getTotalCount()).add();
        }
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[37], MixinTransformer.lIllIlIlIl[38], n2, decimalFormat2.format(n));
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[39], MixinTransformer.lIllIlIlIl[40], totalTime6, decimalFormat2.format(n3));
        printer$10807035.kv(MixinTransformer.lIllIlIlIl[41], MixinTransformer.lIllIlIlIl[42], totalTime7, decimalFormat2.format(n4));
        if (totalTime8 > 0L) {
            printer$10807035.kv(MixinTransformer.lIllIlIlIl[43], MixinTransformer.lIllIlIlIl[44], totalTime8, decimalFormat2.format(n5));
        }
        printer$10807035.add();
        try {
            final Map map = (Map)this.service.getClassProvider().findAgentClass$3555389e(MixinTransformer.lIllIlIlIl[45]).getDeclaredMethod(MixinTransformer.lIllIlIlIl[46], (Class<?>[])new Class[0]).invoke(null, new Object[0]);
            printer$10807035.hr('*').add(MixinTransformer.lIllIlIlIl[47]).hr('*').add();
            int max = 10;
            final Iterator<Map.Entry<String, V>> iterator2 = map.entrySet().iterator();
            while (iterator2.hasNext()) {
                max = Math.max(max, iterator2.next().getKey().length());
            }
            final Iterator<Map.Entry<String, V>> iterator3 = map.entrySet().iterator();
            while (iterator3.hasNext()) {
                final Object o;
                final String s2 = ((Map.Entry<String, Long>)(o = iterator3.next())).getKey();
                long totalTime9 = 0L;
                for (final Profiler.Section section3 : this.profiler.getSections()) {
                    if (s2.equals(section3.info)) {
                        totalTime9 = section3.getTotalTime();
                        break;
                    }
                }
                if (totalTime9 > 0L) {
                    printer$10807035.add(String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[48]).append(max).append(MixinTransformer.lIllIlIlIl[49])), s2, ((Map.Entry<K, Long>)o).getValue() + totalTime9, String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[50]).append(totalTime9)));
                }
                else {
                    printer$10807035.add(String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[51]).append(max).append(MixinTransformer.lIllIlIlIl[52])), s2, ((Map.Entry<K, Long>)o).getValue());
                }
            }
            printer$10807035.add();
        }
        catch (Throwable t) {}
        printer$10807035.print(System.err);
    }
    
    @Override
    public final String getName() {
        return this.getClass().getName();
    }
    
    @Override
    public final boolean isDelegationExcluded() {
        return true;
    }
    
    @Override
    public final synchronized byte[] transformClassBytes(final String s, final String s2, byte[] array) {
        if (s2 == null || this.errorState) {
            return array;
        }
        final MixinEnvironment currentEnvironment = MixinEnvironment.getCurrentEnvironment();
        if (array == null) {
            for (final IClassGenerator classGenerator : this.extensions.generatorsView) {
                final Profiler.Section begin$67bb2acd = this.profiler.begin$67bb2acd(MixinTransformer.lIllIlIlIl[53], classGenerator.getClass().getSimpleName().toLowerCase());
                array = classGenerator.generate(s2);
                begin$67bb2acd.end();
                if (array != null) {
                    this.extensions.export(currentEnvironment, s2.replace('.', '/'), false, array);
                    return array;
                }
            }
            return array;
        }
        final ReEntranceLock lock;
        final ReEntranceLock reEntranceLock = lock = this.lock;
        ++reEntranceLock.depth;
        final ReEntranceLock reEntranceLock2 = lock;
        reEntranceLock2.semaphore |= reEntranceLock2.check();
        final boolean check = lock.check();
        final Profiler.Section begin = this.profiler.begin(0, MixinTransformer.lIllIlIlIl[54]);
        if (!check) {
            final MixinEnvironment mixinEnvironment = currentEnvironment;
            try {
                final MixinEnvironment mixinEnvironment2 = mixinEnvironment;
                if (this.currentEnvironment != mixinEnvironment2) {
                    this.select(mixinEnvironment2);
                }
                else if (Mixins.getUnvisitedCount() > 0 && this.transformedCount == 0) {
                    this.select(mixinEnvironment2);
                }
            }
            catch (Exception ex) {
                this.lock.pop();
                begin.end();
                throw new MixinException(ex);
            }
        }
        try {
            final MixinPostProcessor postProcessor;
            if ((postProcessor = this.postProcessor).syntheticInnerClasses.contains(s2) || postProcessor.loadable.contains(s2)) {
                final Profiler.Section begin2 = this.profiler.begin(0, MixinTransformer.lIllIlIlIl[55]);
                final byte[] transformClassBytes = this.postProcessor.transformClassBytes(s, s2, array);
                begin2.end();
                this.extensions.export(currentEnvironment, s2, false, transformClassBytes);
                return transformClassBytes;
            }
            Set<Object> set = null;
            boolean b = false;
            final Iterator<MixinConfig> iterator2 = this.configs.iterator();
            while (iterator2.hasNext()) {
                final MixinConfig mixinConfig;
                if (s2.startsWith((mixinConfig = iterator2.next()).mixinPackage)) {
                    b = true;
                }
                else {
                    if (!mixinConfig.mixinMapping.containsKey(s2)) {
                        continue;
                    }
                    if (set == null) {
                        set = new TreeSet<Object>();
                    }
                    final Set<Object> set2 = set;
                    final MixinConfig mixinConfig2;
                    List<MixinInfo> list;
                    if ((list = (mixinConfig2 = mixinConfig).mixinMapping.get(s2)) == null) {
                        list = new ArrayList<MixinInfo>();
                        mixinConfig2.mixinMapping.put(s2, list);
                    }
                    set2.addAll(list);
                }
            }
            if (b) {
                throw new NoClassDefFoundError(String.format(MixinTransformer.lIllIlIlIl[56], s2));
            }
            if (set != null) {
                if (check) {
                    MixinTransformer.logger.warn(MixinTransformer.lIllIlIlIl[57], (Throwable)new MixinException());
                    throw new MixinApplyError(MixinTransformer.lIllIlIlIl[58]);
                }
                if (this.hotSwapper != null) {
                    this.hotSwapper.registerTargetClass(s2, array);
                }
                final Profiler profiler = this.profiler;
                final String s3 = MixinTransformer.lIllIlIlIl[59];
                try {
                    final Profiler.Section begin3 = profiler.begin(0, s3);
                    final TargetClassContext targetClassContext = new TargetClassContext(currentEnvironment, this.extensions, this.sessionId, s2, this.readClass$17965cb6(array), (SortedSet<MixinInfo>)set);
                    begin3.end();
                    array = this.applyMixins(currentEnvironment, targetClassContext);
                    ++this.transformedCount;
                }
                catch (InvalidMixinException ex2) {
                    this.dumpClassOnFailure(s2, array, currentEnvironment);
                    this.handleMixinError(s2, ex2, currentEnvironment, ErrorPhase.APPLY);
                }
            }
            return array;
        }
        catch (Throwable t2) {
            final Throwable t = t2;
            t2.printStackTrace();
            this.dumpClassOnFailure(s2, array, currentEnvironment);
            throw new MixinTransformerError(MixinTransformer.lIllIlIlIl[60], t);
        }
        finally {
            this.lock.pop();
            begin.end();
        }
    }
    
    private List<String> reload(final String s, final byte[] array) {
        if (this.lock.depth > 0) {
            throw new MixinApplyError(MixinTransformer.lIllIlIlIl[61]);
        }
        final ArrayList<Object> list = (ArrayList<Object>)new ArrayList<String>();
        final Iterator<MixinConfig> iterator = this.configs.iterator();
        while (iterator.hasNext()) {
            list.addAll(iterator.next().reloadMixin(s, array));
        }
        return (List<String>)list;
    }
    
    private void checkSelect(final MixinEnvironment mixinEnvironment) {
        if (this.currentEnvironment != mixinEnvironment) {
            this.select(mixinEnvironment);
            return;
        }
        if (Mixins.getUnvisitedCount() > 0 && this.transformedCount == 0) {
            this.select(mixinEnvironment);
        }
    }
    
    private void select(final MixinEnvironment currentEnvironment) {
        this.verboseLoggingLevel = (currentEnvironment.getOption(MixinEnvironment.Option.DEBUG_VERBOSE) ? Level.INFO : Level.DEBUG);
        if (this.transformedCount > 0) {
            MixinTransformer.logger.log(this.verboseLoggingLevel, MixinTransformer.lIllIlIlIl[62], new Object[] { this.currentEnvironment, this.transformedCount });
        }
        MixinTransformer.logger.log(this.verboseLoggingLevel, MixinTransformer.lIllIlIlIl[65], new Object[] { lIIIlIIIIIll(this.currentEnvironment, currentEnvironment) ? MixinTransformer.lIllIlIlIl[63] : MixinTransformer.lIllIlIlIl[64], currentEnvironment });
        this.profiler.setActive(true);
        this.profiler.mark(String.valueOf(new StringBuilder().append(currentEnvironment.phase.toString()).append(MixinTransformer.lIllIlIlIl[66])));
        final Profiler.Section begin = this.profiler.begin(0, MixinTransformer.lIllIlIlIl[67]);
        this.selectConfigs(currentEnvironment);
        this.extensions.select(currentEnvironment);
        final int prepareConfigs = this.prepareConfigs(currentEnvironment);
        this.currentEnvironment = currentEnvironment;
        this.transformedCount = 0;
        begin.end();
        final long time = begin.getTime();
        final double seconds;
        if ((seconds = begin.getSeconds()) > 0.25) {
            MixinTransformer.logger.log(this.verboseLoggingLevel, MixinTransformer.lIllIlIlIl[73], new Object[] { prepareConfigs, new DecimalFormat(MixinTransformer.lIllIlIlIl[71]).format(seconds), new DecimalFormat(MixinTransformer.lIllIlIlIl[72]).format(time / prepareConfigs), this.profiler.get(MixinTransformer.lIllIlIlIl[68]).getTime(), this.profiler.get(MixinTransformer.lIllIlIlIl[69]).getTime(), this.profiler.get(MixinTransformer.lIllIlIlIl[70]).getTime() });
        }
        this.profiler.mark(String.valueOf(new StringBuilder().append(currentEnvironment.phase.toString()).append(MixinTransformer.lIllIlIlIl[74])));
        this.profiler.setActive(currentEnvironment.getOption(MixinEnvironment.Option.DEBUG_PROFILER));
    }
    
    private void selectConfigs(final MixinEnvironment mixinEnvironment) {
        final Iterator<Config> iterator = Mixins.getConfigs().iterator();
        while (iterator.hasNext()) {
            final Config config = iterator.next();
            try {
                final MixinConfig config2;
                final MixinConfig mixinConfig;
                (mixinConfig = (config2 = config.config)).visited = true;
                if (!MixinConfig.llllIIIIlII(mixinConfig.env, mixinEnvironment)) {
                    continue;
                }
                iterator.remove();
                MixinTransformer.logger.log(this.verboseLoggingLevel, MixinTransformer.lIllIlIlIl[75], new Object[] { config2 });
                final MixinConfig mixinConfig2;
                if (!(mixinConfig2 = config2).mixinPackage.endsWith(MixinConfig.lIlIIIlIIl[14])) {
                    final StringBuilder sb = new StringBuilder();
                    final MixinConfig mixinConfig3 = mixinConfig2;
                    mixinConfig3.mixinPackage = String.valueOf(sb.append(mixinConfig3.mixinPackage).append(MixinConfig.lIlIIIlIIl[15]));
                }
                boolean b = false;
                if (mixinConfig2.refMapperConfig == null && mixinConfig2.refMapperConfig == null) {
                    b = true;
                    mixinConfig2.refMapperConfig = MixinConfig.lIlIIIlIIl[16];
                }
                final MixinConfig mixinConfig4 = mixinConfig2;
                mixinConfig4.refMapper = ReferenceMapper.read(mixinConfig4.refMapperConfig);
                final MixinConfig mixinConfig5 = mixinConfig2;
                mixinConfig5.verboseLogging |= mixinConfig2.env.getOption(MixinEnvironment.Option.DEBUG_VERBOSE);
                if (!b && mixinConfig2.refMapper.isDefault() && !mixinConfig2.env.getOption(MixinEnvironment.Option.DISABLE_REFMAP)) {
                    mixinConfig2.logger.warn(MixinConfig.lIlIIIlIIl[17], new Object[] { mixinConfig2.refMapperConfig, mixinConfig2 });
                }
                if (mixinConfig2.env.getOption(MixinEnvironment.Option.REFMAP_REMAP)) {
                    final MixinConfig mixinConfig6 = mixinConfig2;
                    mixinConfig6.refMapper = RemappingReferenceMapper.of$9b947e4(mixinConfig6.refMapper);
                }
                this.pendingConfigs.add(config2);
            }
            catch (Exception ex) {
                MixinTransformer.logger.warn(String.format(MixinTransformer.lIllIlIlIl[76], config), (Throwable)ex);
            }
        }
        Collections.sort(this.pendingConfigs);
    }
    
    private int prepareConfigs(final MixinEnvironment mixinEnvironment) {
        int n = 0;
        final IHotSwap hotSwapper = this.hotSwapper;
        final Iterator<MixinConfig> iterator = this.pendingConfigs.iterator();
        while (iterator.hasNext()) {
            final MixinConfig mixinConfig;
            (mixinConfig = iterator.next()).addListener(this.postProcessor);
            if (hotSwapper != null) {
                mixinConfig.addListener(new MixinConfig.IListener() {
                    private /* synthetic */ IHotSwap val$hotSwapper;
                    private /* synthetic */ MixinTransformer this$0;
                    
                    MixinTransformer$1() {
                        super();
                    }
                    
                    @Override
                    public final void onPrepare(final MixinInfo mixinInfo) {
                        hotSwapper.registerMixinClass(mixinInfo.className);
                    }
                    
                    @Override
                    public final void onInit(final MixinInfo mixinInfo) {
                    }
                });
            }
        }
        for (final MixinConfig mixinConfig2 : this.pendingConfigs) {
            final Logger logger = MixinTransformer.logger;
            try {
                final Level verboseLoggingLevel = this.verboseLoggingLevel;
                final String s = MixinTransformer.lIllIlIlIl[77];
                final Object[] array = { mixinConfig2, null };
                final int n2 = 1;
                try {
                    array[n2] = MixinConfig.getDeclaredMixinCount();
                    logger.log(verboseLoggingLevel, s, array);
                    final MixinConfig mixinConfig3;
                    if (!(mixinConfig3 = mixinConfig2).prepared) {
                        mixinConfig3.prepared = true;
                        switch (MixinConfig.MixinConfig$1.$SwitchMap$org$spongepowered$asm$mixin$MixinEnvironment$Side[mixinConfig3.env.getSide().ordinal()]) {
                            case 1: {
                                break;
                            }
                            case 2: {
                                break;
                            }
                            default: {
                                mixinConfig3.logger.warn(MixinConfig.lIlIIIlIIl[18]);
                                break;
                            }
                        }
                    }
                    n += mixinConfig2.mixins.size();
                }
                catch (InvalidMixinException ex) {
                    this.handleMixinPrepareError(mixinConfig2, ex, mixinEnvironment);
                }
                continue;
            }
            catch (Exception ex2) {
                MixinTransformer.logger.error(String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[78]).append(mixinConfig2.name).append(MixinTransformer.lIllIlIlIl[79]).append(ex2.getMessage())), (Throwable)ex2);
                continue;
            }
            break;
        }
        final Iterator<MixinConfig> iterator3 = this.pendingConfigs.iterator();
        while (iterator3.hasNext()) {
            iterator3.next();
        }
        for (final MixinConfig mixinConfig5 : this.pendingConfigs) {
            final MixinConfig mixinConfig4 = mixinConfig5;
            try {
                mixinConfig4.postInitialise();
            }
            catch (InvalidMixinException ex3) {
                this.handleMixinPrepareError(mixinConfig5, ex3, mixinEnvironment);
            }
            catch (Exception ex4) {
                MixinTransformer.logger.error(String.valueOf(new StringBuilder().append(MixinTransformer.lIllIlIlIl[80]).append(mixinConfig5.name).append(MixinTransformer.lIllIlIlIl[81]).append(ex4.getMessage())), (Throwable)ex4);
            }
        }
        this.configs.addAll(this.pendingConfigs);
        Collections.sort(this.configs);
        this.pendingConfigs.clear();
        return n;
    }
    
    private byte[] applyMixins(final MixinEnvironment mixinEnvironment, final TargetClassContext targetClassContext) {
        final Profiler.Section begin = this.profiler.begin(0, MixinTransformer.lIllIlIlIl[82]);
        final Iterator<IExtension> iterator = this.extensions.activeExtensions.iterator();
        while (iterator.hasNext()) {
            iterator.next().preApply(targetClassContext);
        }
        final Profiler.Section next = begin.next(MixinTransformer.lIllIlIlIl[83]);
        targetClassContext.applyMixins();
        final Profiler.Section next2 = next.next(MixinTransformer.lIllIlIlIl[84]);
        final Extensions extensions = this.extensions;
        try {
            final Iterator<IExtension> iterator2 = extensions.activeExtensions.iterator();
            while (iterator2.hasNext()) {
                iterator2.next().postApply(targetClassContext);
            }
        }
        catch (ExtensionCheckClass.ValidationFailedException ex) {
            MixinTransformer.logger.info(ex.getMessage());
            if (targetClassContext.forceExport || mixinEnvironment.getOption(MixinEnvironment.Option.DEBUG_EXPORT)) {
                this.writeClass(targetClassContext);
            }
        }
        next2.end();
        return this.writeClass(targetClassContext);
    }
    
    private static void apply(final TargetClassContext targetClassContext) {
        targetClassContext.applyMixins();
    }
    
    private void handleMixinPrepareError(final MixinConfig mixinConfig, final InvalidMixinException ex, final MixinEnvironment mixinEnvironment) throws MixinPrepareError {
        this.handleMixinError(mixinConfig.name, ex, mixinEnvironment, ErrorPhase.PREPARE);
    }
    
    private void handleMixinApplyError(final String s, final InvalidMixinException ex, final MixinEnvironment mixinEnvironment) throws MixinApplyError {
        this.handleMixinError(s, ex, mixinEnvironment, ErrorPhase.APPLY);
    }
    
    private void handleMixinError(final String s, final InvalidMixinException ex, final MixinEnvironment mixinEnvironment, final ErrorPhase errorPhase) throws Error {
        this.errorState = true;
        final IMixinInfo mixin;
        if ((mixin = ex.mixin) == null) {
            MixinTransformer.logger.error(MixinTransformer.lIllIlIlIl[85], (Throwable)ex);
            throw ex;
        }
        final IMixinConfig config = mixin.getConfig();
        final MixinEnvironment.Phase phase = mixin.getPhase();
        IMixinErrorHandler.ErrorAction errorAction = config.isRequired() ? IMixinErrorHandler.ErrorAction.ERROR : IMixinErrorHandler.ErrorAction.WARN;
        if (mixinEnvironment.getOption(MixinEnvironment.Option.DEBUG_VERBOSE)) {
            new PrettyPrinter().add(MixinTransformer.lIllIlIlIl[86]).centre().hr('-').kvWidth(10).kv(MixinTransformer.lIllIlIlIl[87], (Object)errorPhase.name()).kv(MixinTransformer.lIllIlIlIl[88], (Object)mixin.getClassName()).kv(MixinTransformer.lIllIlIlIl[89], (Object)config.getName()).kv(MixinTransformer.lIllIlIlIl[90], phase).hr('-').add(MixinTransformer.lIllIlIlIl[91], ex.getClass().getName()).hr('-').addWrapped(MixinTransformer.lIllIlIlIl[92], ex.getMessage()).hr('-').add(ex, 8).trace(errorAction.logLevel);
        }
        mixin.getPhase();
        final Iterator<IMixinErrorHandler> iterator = this.getErrorHandlers$706071e2().iterator();
        while (iterator.hasNext()) {
            final IMixinErrorHandler.ErrorAction onError$7346b0cb;
            if ((onError$7346b0cb = errorPhase.onError$7346b0cb(iterator.next(), mixin, errorAction)) != null) {
                errorAction = onError$7346b0cb;
            }
        }
        MixinTransformer.logger.log(errorAction.logLevel, errorPhase.getLogMessage(s, ex, mixin), (Throwable)ex);
        this.errorState = false;
        if (lIIIlIIIIIll(errorAction, IMixinErrorHandler.ErrorAction.ERROR)) {
            throw new MixinApplyError(errorPhase.getErrorMessage(mixin, config, phase), ex);
        }
    }
    
    private List<IMixinErrorHandler> getErrorHandlers$706071e2() {
        final ArrayList<IMixinErrorHandler> list = new ArrayList<IMixinErrorHandler>();
        for (final String s : Mixins.getErrorHandlerClasses()) {
            try {
                MixinTransformer.logger.info(MixinTransformer.lIllIlIlIl[93], new Object[] { s });
                final IMixinErrorHandler mixinErrorHandler;
                if ((mixinErrorHandler = (IMixinErrorHandler)this.service.getClassProvider().findClass$3555389e(s).newInstance()) == null) {
                    continue;
                }
                list.add(mixinErrorHandler);
            }
            catch (Throwable t) {}
        }
        return list;
    }
    
    private byte[] writeClass(final TargetClassContext targetClassContext) {
        return this.writeClass(targetClassContext.className, targetClassContext.classNode, targetClassContext.forceExport);
    }
    
    private byte[] writeClass(final String s, final ClassNode classNode, final boolean b) {
        final Profiler.Section begin = this.profiler.begin(0, MixinTransformer.lIllIlIlIl[94]);
        final byte[] writeClass = this.writeClass(classNode);
        begin.end();
        this.extensions.export(this.currentEnvironment, s, b, writeClass);
        return writeClass;
    }
    
    private void dumpClassOnFailure(final String s, final byte[] array, final MixinEnvironment mixinEnvironment) {
        if (mixinEnvironment.getOption(MixinEnvironment.Option.DUMP_TARGET_ON_FAILURE)) {
            this.extensions.getExtension(ExtensionClassExporter.class).dumpClass(String.valueOf(new StringBuilder().append(s.replace('.', '/')).append(MixinTransformer.lIllIlIlIl[95])), array);
        }
    }
    
    static {
        lIIIIlllIIIl();
        MixinTransformer.logger = LogManager.getLogger(MixinTransformer.lIllIlIlIl[98]);
    }
    
    private static void lIIIIlllIIIl() {
        (lIllIlIlIl = new String[99])[0] = "Terminating MixinTransformer instance ";
        MixinTransformer.lIllIlIlIl[1] = "Attempting to load Hot-Swap agent";
        MixinTransformer.lIllIlIlIl[2] = "org.spongepowered.tools.agent.MixinAgent";
        MixinTransformer.lIllIlIlIl[3] = "Hot-swap agent could not be loaded, hot swapping of mixins won't work. {}: {}";
        MixinTransformer.lIllIlIlIl[4] = "mixin/audit";
        MixinTransformer.lIllIlIlIl[5] = "Force-loading class {}";
        MixinTransformer.lIllIlIlIl[6] = "Could not force-load ";
        MixinTransformer.lIllIlIlIl[7] = " was already classloaded";
        MixinTransformer.lIllIlIlIl[8] = "Could not force-load ";
        MixinTransformer.lIllIlIlIl[9] = "(###0.000";
        MixinTransformer.lIllIlIlIl[10] = "(###0.0";
        MixinTransformer.lIllIlIlIl[11] = "mixin.prepare";
        MixinTransformer.lIllIlIlIl[12] = "mixin.read";
        MixinTransformer.lIllIlIlIl[13] = "mixin.apply";
        MixinTransformer.lIllIlIlIl[14] = "mixin.write";
        MixinTransformer.lIllIlIlIl[15] = "mixin";
        MixinTransformer.lIllIlIlIl[16] = "class.load";
        MixinTransformer.lIllIlIlIl[17] = "class.transform";
        MixinTransformer.lIllIlIlIl[18] = "mixin.debug.export";
        MixinTransformer.lIllIlIlIl[19] = "class.transform.";
        MixinTransformer.lIllIlIlIl[20] = "Summary";
        MixinTransformer.lIllIlIlIl[21] = "%9d ms %12s seconds)";
        MixinTransformer.lIllIlIlIl[22] = "Total mixin time";
        MixinTransformer.lIllIlIlIl[23] = "Preparing mixins";
        MixinTransformer.lIllIlIlIl[24] = "Reading input";
        MixinTransformer.lIllIlIlIl[25] = "Applying mixins";
        MixinTransformer.lIllIlIlIl[26] = "Writing output";
        MixinTransformer.lIllIlIlIl[27] = "of which";
        MixinTransformer.lIllIlIlIl[28] = "";
        MixinTransformer.lIllIlIlIl[29] = "Time spent loading from disk";
        MixinTransformer.lIllIlIlIl[30] = "Time spent transforming classes";
        MixinTransformer.lIllIlIlIl[31] = "Worst transformer";
        MixinTransformer.lIllIlIlIl[32] = "Class";
        MixinTransformer.lIllIlIlIl[33] = "Time spent";
        MixinTransformer.lIllIlIlIl[34] = "%s seconds";
        MixinTransformer.lIllIlIlIl[35] = "called";
        MixinTransformer.lIllIlIlIl[36] = "%d times";
        MixinTransformer.lIllIlIlIl[37] = "   Time allocation:     Processing mixins";
        MixinTransformer.lIllIlIlIl[38] = "%9d ms %10s%% of total)";
        MixinTransformer.lIllIlIlIl[39] = "Loading classes";
        MixinTransformer.lIllIlIlIl[40] = "%9d ms %10s%% of total)";
        MixinTransformer.lIllIlIlIl[41] = "Running transformers";
        MixinTransformer.lIllIlIlIl[42] = "%9d ms %10s%% of total)";
        MixinTransformer.lIllIlIlIl[43] = "Exporting classes (debug)";
        MixinTransformer.lIllIlIlIl[44] = "%9d ms %10s%% of total)";
        MixinTransformer.lIllIlIlIl[45] = "org.spongepowered.metronome.Agent";
        MixinTransformer.lIllIlIlIl[46] = "getTimes";
        MixinTransformer.lIllIlIlIl[47] = "Transformer Times";
        MixinTransformer.lIllIlIlIl[48] = "%-";
        MixinTransformer.lIllIlIlIl[49] = "s %8s ms %8s ms in mixin)";
        MixinTransformer.lIllIlIlIl[50] = "(";
        MixinTransformer.lIllIlIlIl[51] = "%-";
        MixinTransformer.lIllIlIlIl[52] = "s %8s ms";
        MixinTransformer.lIllIlIlIl[53] = "generator";
        MixinTransformer.lIllIlIlIl[54] = "mixin";
        MixinTransformer.lIllIlIlIl[55] = "postprocessor";
        MixinTransformer.lIllIlIlIl[56] = "%s is a mixin class and cannot be referenced directly";
        MixinTransformer.lIllIlIlIl[57] = "Re-entrance detected, this will cause serious problems.";
        MixinTransformer.lIllIlIlIl[58] = "Re-entrance error.";
        MixinTransformer.lIllIlIlIl[59] = "read";
        MixinTransformer.lIllIlIlIl[60] = "An unexpected critical error was encountered";
        MixinTransformer.lIllIlIlIl[61] = "Cannot reload mixin if re-entrant lock entered";
        MixinTransformer.lIllIlIlIl[62] = "Ending {}, applied {} mixins";
        MixinTransformer.lIllIlIlIl[63] = "Checking for additional";
        MixinTransformer.lIllIlIlIl[64] = "Preparing";
        MixinTransformer.lIllIlIlIl[65] = "{} mixins for {}";
        MixinTransformer.lIllIlIlIl[66] = ":prepare";
        MixinTransformer.lIllIlIlIl[67] = "prepare";
        MixinTransformer.lIllIlIlIl[68] = "class.load";
        MixinTransformer.lIllIlIlIl[69] = "class.transform";
        MixinTransformer.lIllIlIlIl[70] = "mixin.plugin";
        MixinTransformer.lIllIlIlIl[71] = "###0.000";
        MixinTransformer.lIllIlIlIl[72] = "###0.0";
        MixinTransformer.lIllIlIlIl[73] = "Prepared {} mixins in {} sec ({}ms avg) ({}ms load, {}ms transform, {}ms plugin)";
        MixinTransformer.lIllIlIlIl[74] = ":apply";
        MixinTransformer.lIllIlIlIl[75] = "Selecting config {}";
        MixinTransformer.lIllIlIlIl[76] = "Failed to select mixin config: %s";
        MixinTransformer.lIllIlIlIl[77] = "Preparing {} ({})";
        MixinTransformer.lIllIlIlIl[78] = "Error encountered whilst initialising mixin config '";
        MixinTransformer.lIllIlIlIl[79] = "': ";
        MixinTransformer.lIllIlIlIl[80] = "Error encountered during mixin config postInit step'";
        MixinTransformer.lIllIlIlIl[81] = "': ";
        MixinTransformer.lIllIlIlIl[82] = "preapply";
        MixinTransformer.lIllIlIlIl[83] = "apply";
        MixinTransformer.lIllIlIlIl[84] = "postapply";
        MixinTransformer.lIllIlIlIl[85] = "InvalidMixinException has no mixin!";
        MixinTransformer.lIllIlIlIl[86] = "Invalid Mixin";
        MixinTransformer.lIllIlIlIl[87] = "Action";
        MixinTransformer.lIllIlIlIl[88] = "Mixin";
        MixinTransformer.lIllIlIlIl[89] = "Config";
        MixinTransformer.lIllIlIlIl[90] = "Phase";
        MixinTransformer.lIllIlIlIl[91] = "    %s";
        MixinTransformer.lIllIlIlIl[92] = "    %s";
        MixinTransformer.lIllIlIlIl[93] = "Instancing error handler class {}";
        MixinTransformer.lIllIlIlIl[94] = "write";
        MixinTransformer.lIllIlIlIl[95] = ".target";
        MixinTransformer.lIllIlIlIl[96] = "org.spongepowered.tools.agent.MixinAgent";
        MixinTransformer.lIllIlIlIl[97] = "org.spongepowered.metronome.Agent";
        MixinTransformer.lIllIlIlIl[98] = "mixin";
    }
    
    private static String lIIIIlIIlIlI(String s, final String s2) {
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
    
    private static String lIIIIlIIllII(final String s, final String s2) {
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
    
    private static String lIIIIlIIllIl(final String s, final String s2) {
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
    
    private static boolean lIIIlIIIIIIl(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIIlIIIIIll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static boolean lIIIIllllllI(final int n) {
        return n > 0;
    }
    
    private static int lIIIIlllllIl(final long n, final long n2) {
        return lcmp(n, n2);
    }
    
    private static int lIIIlIIIIIlI$25399e8(final double n) {
        return dcmpl(n, 0.25);
    }
}
