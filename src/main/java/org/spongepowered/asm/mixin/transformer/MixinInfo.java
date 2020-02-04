package org.spongepowered.asm.mixin.transformer;

import org.spongepowered.asm.util.perf.*;
import java.lang.annotation.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import org.spongepowered.asm.mixin.extensibility.*;
import org.apache.logging.log4j.*;
import java.io.*;
import org.spongepowered.asm.service.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.lib.tree.*;
import org.spongepowered.asm.mixin.injection.*;
import org.spongepowered.asm.util.*;
import org.spongepowered.asm.mixin.injection.struct.*;
import org.spongepowered.asm.mixin.transformer.throwables.*;
import org.spongepowered.asm.lib.*;

public final class MixinInfo implements Comparable<MixinInfo>, IMixinInfo
{
    private static final IMixinService classLoaderUtil;
    private static int mixinOrder;
    private final transient Logger logger;
    final transient Profiler profiler;
    public final transient MixinConfig parent;
    final String name;
    final String className;
    final int priority;
    private final boolean virtual;
    final List<ClassInfo> targetClasses;
    final List<String> targetClassNames;
    private final transient int order;
    private final transient IMixinService service;
    private final transient IMixinConfigPlugin plugin;
    private final transient MixinEnvironment.Phase phase;
    final transient ClassInfo info;
    final transient SubType type;
    private final transient boolean strict;
    transient State pendingState;
    transient State state;
    static final String[] lIlIlIIIlll;
    
    private MixinInfo(final IMixinService service, final MixinConfig parent, final String name) {
        super();
        this.logger = LogManager.getLogger(MixinInfo.lIlIlIIIlll[0]);
        this.profiler = MixinEnvironment.getProfiler();
        this.order = MixinInfo.mixinOrder++;
        this.service = service;
        this.parent = parent;
        this.name = name;
        this.className = String.valueOf(new StringBuilder().append(parent.mixinPackage).append(name));
        this.phase = parent.env.phase;
        this.strict = parent.env.getOption(MixinEnvironment.Option.DEBUG_TARGETS);
        try {
            final String className = this.className;
            try {
                this.pendingState = new State(this.loadMixinClass$44c4d6c8(className));
                this.info = this.pendingState.classInfo;
                this.type = SubType.getTypeFor(this);
            }
            catch (InvalidMixinException ex) {
                throw ex;
            }
        }
        catch (Exception ex2) {
            throw new InvalidMixinException(this, ex2);
        }
        if (!this.type.isLoadable()) {
            MixinInfo.classLoaderUtil.registerInvalidClass(this.className);
        }
        try {
            final State pendingState = this.pendingState;
            try {
                this.priority = this.readPriority(pendingState.getClassNode());
                this.virtual = (Annotations.getInvisible(this.pendingState.getClassNode(), Pseudo.class) != null);
                this.targetClasses = this.readTargetClasses$2157053f(this.pendingState.getClassNode());
                this.targetClassNames = Collections.unmodifiableList((List<? extends String>)Lists.transform((List)this.targetClasses, Functions.toStringFunction()));
            }
            catch (InvalidMixinException ex3) {
                throw ex3;
            }
        }
        catch (Exception ex4) {
            throw new InvalidMixinException(this, ex4);
        }
    }
    
    final void validate() {
        if (this.pendingState == null) {
            throw new IllegalStateException(String.valueOf(new StringBuilder().append(MixinInfo.lIlIlIIIlll[1]).append(this)));
        }
        try {
            this.pendingState.validate(this.type, this.targetClasses);
            this.state = this.pendingState;
        }
        finally {
            this.pendingState = null;
        }
    }
    
    protected final List<ClassInfo> readTargetClasses$2157053f(final MixinClassNode mixinClassNode) {
        if (mixinClassNode == null) {
            return Collections.emptyList();
        }
        final AnnotationNode invisible;
        if ((invisible = Annotations.getInvisible(mixinClassNode, Mixin.class)) == null) {
            throw new InvalidMixinException(this, String.format(MixinInfo.lIlIlIIIlll[2], this.className));
        }
        final ArrayList<ClassInfo> list = new ArrayList<ClassInfo>();
        final List list2 = Annotations.getValue(invisible, MixinInfo.lIlIlIIIlll[3]);
        final List list3 = Annotations.getValue(invisible, MixinInfo.lIlIlIIIlll[4]);
        if (list2 != null) {
            this.readTargets$7e3a6157(list, Lists.transform((List)list2, (Function)new Function<Type, String>() {
                private /* synthetic */ MixinInfo this$0;
                
                MixinInfo$1() {
                    super();
                }
                
                private static String apply(final Type type) {
                    return type.getClassName();
                }
                
                public final /* bridge */ Object apply(final Object o) {
                    return ((Type)o).getClassName();
                }
            }), false);
        }
        if (list3 != null) {
            this.readTargets$7e3a6157(list, Lists.transform((List)list3, (Function)new Function<String, String>() {
                private /* synthetic */ MixinInfo this$0;
                
                MixinInfo$2() {
                    this.this$0 = this$0;
                    super();
                }
                
                private String apply(String s) {
                    final MixinConfig parent = this.this$0.parent;
                    final String name = this.this$0.info.name;
                    final String s2 = s;
                    s = name;
                    return parent.getReferenceMapper().remap(s, s2);
                }
                
                public final /* bridge */ Object apply(final Object o) {
                    return this.this$0.parent.getReferenceMapper().remap(this.this$0.info.name, (String)o);
                }
            }), true);
        }
        return list;
    }
    
    private void readTargets$7e3a6157(final Collection<ClassInfo> collection, final Collection<String> collection2, final boolean b) {
        final Iterator<String> iterator = collection2.iterator();
        while (iterator.hasNext()) {
            final String replace = iterator.next().replace('/', '.');
            if (MixinInfo.classLoaderUtil.isClassLoaded(replace) && !(this.pendingState instanceof Reloaded)) {
                final String format = String.format(MixinInfo.lIlIlIIIlll[5], this, replace);
                if (this.parent.required) {
                    throw new MixinTargetAlreadyLoadedException(this, format, replace);
                }
                this.logger.error(format);
            }
            this.profiler.begin(0, MixinInfo.lIlIlIIIlll[6]).end();
            final String s = replace;
            final ClassInfo forName;
            ClassInfo classInfo2;
            ClassInfo classInfo;
            if ((forName = ClassInfo.forName(s)) == null) {
                if (this.virtual) {
                    this.logger.debug(MixinInfo.lIlIlIIIlll[7], new Object[] { s, this });
                }
                else {
                    this.handleTargetError(String.format(MixinInfo.lIlIlIIIlll[8], s, this));
                }
                classInfo = (classInfo2 = null);
            }
            else {
                this.type.validateTarget(s, forName);
                if (b && forName.isPublic() && !this.virtual) {
                    this.handleTargetError(String.format(MixinInfo.lIlIlIIIlll[9], s, this));
                }
                classInfo = (classInfo2 = forName);
            }
            final ClassInfo classInfo3 = classInfo2;
            if (classInfo != null && !collection.contains(classInfo3)) {
                collection.add(classInfo3);
                final ClassInfo classInfo4;
                if ((classInfo4 = classInfo3).isMixin) {
                    throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(ClassInfo.llIlIIIlllI[28]).append(classInfo4.name).append(ClassInfo.llIlIIIlllI[29]).append(this.className).append(ClassInfo.llIlIIIlllI[30])));
                }
                classInfo4.mixins.add(this);
            }
        }
    }
    
    private boolean shouldApplyMixin$2598ce0d() {
        this.profiler.begin(0, MixinInfo.lIlIlIIIlll[6]).end();
        return true;
    }
    
    private ClassInfo getTarget(final String s, final boolean b) throws InvalidMixinException {
        final ClassInfo forName;
        if ((forName = ClassInfo.forName(s)) == null) {
            if (this.virtual) {
                this.logger.debug(MixinInfo.lIlIlIIIlll[7], new Object[] { s, this });
            }
            else {
                this.handleTargetError(String.format(MixinInfo.lIlIlIIIlll[8], s, this));
            }
            return null;
        }
        this.type.validateTarget(s, forName);
        if (b && forName.isPublic() && !this.virtual) {
            this.handleTargetError(String.format(MixinInfo.lIlIlIIIlll[9], s, this));
        }
        return forName;
    }
    
    private void handleTargetError(final String s) {
        if (this.strict) {
            this.logger.error(s);
            throw new InvalidMixinException(this, s);
        }
        this.logger.warn(s);
    }
    
    protected final int readPriority(final ClassNode classNode) {
        if (classNode == null) {
            return this.parent.mixinPriority;
        }
        final AnnotationNode invisible;
        if ((invisible = Annotations.getInvisible(classNode, Mixin.class)) == null) {
            throw new InvalidMixinException(this, String.format(MixinInfo.lIlIlIIIlll[10], this.className));
        }
        final Integer n;
        if ((n = Annotations.getValue(invisible, MixinInfo.lIlIlIIIlll[11])) == null) {
            return this.parent.mixinPriority;
        }
        return n;
    }
    
    private static boolean readPseudo(final ClassNode classNode) {
        return Annotations.getInvisible(classNode, Pseudo.class) != null;
    }
    
    private boolean isReloading() {
        return this.pendingState instanceof Reloaded;
    }
    
    final State getState() {
        if (this.state != null) {
            return this.state;
        }
        return this.pendingState;
    }
    
    private ClassInfo getClassInfo() {
        return this.info;
    }
    
    @Override
    public final IMixinConfig getConfig() {
        return this.parent;
    }
    
    private MixinConfig getParent() {
        return this.parent;
    }
    
    @Override
    public final int getPriority() {
        return this.priority;
    }
    
    @Override
    public final String getName() {
        return this.name;
    }
    
    @Override
    public final String getClassName() {
        return this.className;
    }
    
    @Override
    public final String getClassRef() {
        return this.info.name;
    }
    
    @Override
    public final byte[] getClassBytes() {
        return this.getState().mixinBytes;
    }
    
    @Override
    public final boolean isDetachedSuper() {
        return this.getState().detachedSuper;
    }
    
    private boolean isUnique() {
        return this.getState().unique;
    }
    
    private boolean isVirtual() {
        return this.virtual;
    }
    
    private boolean isAccessor() {
        return this.type instanceof SubType.Accessor;
    }
    
    private boolean isLoadable() {
        return this.type.isLoadable();
    }
    
    private Level getLoggingLevel() {
        return this.parent.getLoggingLevel();
    }
    
    @Override
    public final MixinEnvironment.Phase getPhase() {
        return this.phase;
    }
    
    @Override
    public final MixinClassNode getClassNode(final int n) {
        return this.getState().createClassNode(n);
    }
    
    @Override
    public final List<String> getTargetClasses() {
        return this.targetClassNames;
    }
    
    final List<InterfaceInfo> getSoftImplements() {
        return Collections.unmodifiableList(this.getState().getSoftImplements());
    }
    
    private Set<String> getSyntheticInnerClasses() {
        return Collections.unmodifiableSet((Set<? extends String>)this.getState().getSyntheticInnerClasses());
    }
    
    private Set<String> getInnerClasses() {
        return Collections.unmodifiableSet((Set<? extends String>)this.getState().innerClasses);
    }
    
    private List<ClassInfo> getTargets() {
        return Collections.unmodifiableList((List<? extends ClassInfo>)this.targetClasses);
    }
    
    private Set<String> getInterfaces() {
        return this.getState().getInterfaces();
    }
    
    private MixinTargetContext createContextFor(final TargetClassContext targetClassContext) {
        final MixinClassNode classNode = this.getClassNode(8);
        final Profiler.Section begin = this.profiler.begin(0, MixinInfo.lIlIlIIIlll[12]);
        final MixinTargetContext context = this.type.createPreProcessor(classNode).prepare().createContextFor(targetClassContext);
        begin.end();
        return context;
    }
    
    private byte[] loadMixinClass$44c4d6c8(final String s) throws ClassNotFoundException {
        byte[] classBytes$44c4d6c8;
        try {
            final String classRestrictions;
            if ((classRestrictions = this.service.getClassRestrictions(s)).length() > 0) {
                this.logger.error(MixinInfo.lIlIlIIIlll[13], new Object[] { classRestrictions, this, s });
            }
            classBytes$44c4d6c8 = this.service.getBytecodeProvider().getClassBytes$44c4d6c8(s);
        }
        catch (ClassNotFoundException ex2) {
            throw new ClassNotFoundException(String.format(MixinInfo.lIlIlIIIlll[14], s));
        }
        catch (IOException ex) {
            this.logger.warn(MixinInfo.lIlIlIIIlll[15], new Object[] { s });
            throw new InvalidMixinException(this, MixinInfo.lIlIlIIIlll[16], ex);
        }
        return classBytes$44c4d6c8;
    }
    
    private void reloadMixin(final byte[] array) {
        if (this.pendingState != null) {
            throw new IllegalStateException(MixinInfo.lIlIlIIIlll[17]);
        }
        this.pendingState = new Reloaded(this.state, array);
        this.validate();
    }
    
    private int compareTo(final MixinInfo mixinInfo) {
        if (mixinInfo == null) {
            return 0;
        }
        if (mixinInfo.priority == this.priority) {
            return this.order - mixinInfo.order;
        }
        return this.priority - mixinInfo.priority;
    }
    
    private static void preApply$5d5ead09() {
    }
    
    private void postApply$5d5ead09(final String s) {
        this.parent.unhandledTargets.remove(s);
    }
    
    @Override
    public final String toString() {
        return String.format(MixinInfo.lIlIlIIIlll[20], this.parent.name, this.name);
    }
    
    @Override
    public final /* bridge */ int compareTo(final Object o) {
        final MixinInfo mixinInfo = (MixinInfo)o;
        if (mixinInfo == null) {
            return 0;
        }
        if (mixinInfo.priority == this.priority) {
            return this.order - mixinInfo.order;
        }
        return this.priority - mixinInfo.priority;
    }
    
    @Override
    public final /* bridge */ ClassNode getClassNode(final int n) {
        return this.getClassNode(n);
    }
    
    static {
        lllIllIlIlIl();
        classLoaderUtil = MixinService.getService();
        MixinInfo.mixinOrder = 0;
    }
    
    private static void lllIllIlIlIl() {
        (lIlIlIIIlll = new String[21])[0] = "mixin";
        MixinInfo.lIlIlIIIlll[1] = "No pending validation state for ";
        MixinInfo.lIlIlIIIlll[2] = "The mixin '%s' is missing an @Mixin annotation";
        MixinInfo.lIlIlIIIlll[3] = "value";
        MixinInfo.lIlIlIIIlll[4] = "targets";
        MixinInfo.lIlIlIIIlll[5] = "Critical problem: %s target %s was already transformed.";
        MixinInfo.lIlIlIIIlll[6] = "plugin";
        MixinInfo.lIlIlIIIlll[7] = "Skipping virtual target {} for {}";
        MixinInfo.lIlIlIIIlll[8] = "@Mixin target %s was not found %s";
        MixinInfo.lIlIlIIIlll[9] = "@Mixin target %s is public in %s and should be specified in value";
        MixinInfo.lIlIlIIIlll[10] = "The mixin '%s' is missing an @Mixin annotation";
        MixinInfo.lIlIlIIIlll[11] = "priority";
        MixinInfo.lIlIlIIIlll[12] = "pre";
        MixinInfo.lIlIlIIIlll[13] = "Classloader restrictions [{}] encountered loading {}, name: {}";
        MixinInfo.lIlIlIIIlll[14] = "The specified mixin '%s' was not found";
        MixinInfo.lIlIlIIIlll[15] = "Failed to load mixin {}, the specified mixin will not be applied";
        MixinInfo.lIlIlIIIlll[16] = "An error was encountered whilst loading the mixin class";
        MixinInfo.lIlIlIIIlll[17] = "Cannot reload mixin while it is initialising";
        MixinInfo.lIlIlIIIlll[18] = "plugin";
        MixinInfo.lIlIlIIIlll[19] = "plugin";
        MixinInfo.lIlIlIIIlll[20] = "%s:%s";
    }
    
    private static String lllIlIlllllI(final String s, final String s2) {
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
    
    private static String lllIlIllllll(final String s, final String s2) {
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
    
    private static String lllIllIlIIlI(String s, final String s2) {
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
    
    private static boolean lIIIIIlIIIIll(final int n) {
        return n > 0;
    }
}
