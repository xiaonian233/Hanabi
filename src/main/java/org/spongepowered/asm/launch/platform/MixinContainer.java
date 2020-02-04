package org.spongepowered.asm.launch.platform;

import java.net.*;
import org.apache.logging.log4j.*;
import java.lang.reflect.*;
import org.spongepowered.asm.launch.*;
import org.spongepowered.asm.service.*;
import java.util.*;
import java.nio.charset.*;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;

public final class MixinContainer
{
    private static final List<String> agentClasses;
    private final Logger logger;
    private final URI uri;
    public final List<IMixinPlatformAgent> agents;
    private static final String[] llIIlllllI;
    
    public MixinContainer(final MixinPlatformManager mixinPlatformManager, final URI uri) {
        super();
        this.logger = LogManager.getLogger(MixinContainer.llIIlllllI[0]);
        this.agents = new ArrayList<IMixinPlatformAgent>();
        this.uri = uri;
        for (final String s : MixinContainer.agentClasses) {
            try {
                final Class<?> forName;
                final Constructor<?> declaredConstructor = (forName = Class.forName(s)).getDeclaredConstructor(MixinPlatformManager.class, URI.class);
                this.logger.debug(MixinContainer.llIIlllllI[1], new Object[] { forName.getSimpleName(), this.uri });
                this.agents.add((IMixinPlatformAgent)declaredConstructor.newInstance(mixinPlatformManager, uri));
            }
            catch (Exception ex) {
                this.logger.catching((Throwable)ex);
            }
        }
    }
    
    private URI getURI() {
        return this.uri;
    }
    
    public final Collection<String> getPhaseProviders() {
        final ArrayList<String> list = new ArrayList<String>();
        final Iterator<IMixinPlatformAgent> iterator = this.agents.iterator();
        while (iterator.hasNext()) {
            final String phaseProvider;
            if ((phaseProvider = iterator.next().getPhaseProvider()) != null) {
                list.add(phaseProvider);
            }
        }
        return list;
    }
    
    public final void prepare() {
        for (final IMixinPlatformAgent mixinPlatformAgent : this.agents) {
            this.logger.debug(MixinContainer.llIIlllllI[2], new Object[] { mixinPlatformAgent });
            mixinPlatformAgent.prepare();
        }
    }
    
    public final void initPrimaryContainer() {
        for (final IMixinPlatformAgent mixinPlatformAgent : this.agents) {
            this.logger.debug(MixinContainer.llIIlllllI[3], new Object[] { mixinPlatformAgent });
            mixinPlatformAgent.initPrimaryContainer();
        }
    }
    
    public final void inject() {
        for (final IMixinPlatformAgent mixinPlatformAgent : this.agents) {
            this.logger.debug(MixinContainer.llIIlllllI[4], new Object[] { mixinPlatformAgent });
            mixinPlatformAgent.inject();
        }
    }
    
    private String getLaunchTarget() {
        final Iterator<IMixinPlatformAgent> iterator = this.agents.iterator();
        while (iterator.hasNext()) {
            final String launchTarget;
            if ((launchTarget = iterator.next().getLaunchTarget()) != null) {
                return launchTarget;
            }
        }
        return null;
    }
    
    static {
        lIIlIlllIIII();
        agentClasses = new ArrayList<String>();
        GlobalProperties.put(MixinContainer.llIIlllllI[5], MixinContainer.agentClasses);
        final Iterator<String> iterator = MixinService.getService().getPlatformAgents().iterator();
        while (iterator.hasNext()) {
            MixinContainer.agentClasses.add(iterator.next());
        }
        MixinContainer.agentClasses.add(MixinContainer.llIIlllllI[6]);
    }
    
    private static void lIIlIlllIIII() {
        (llIIlllllI = new String[7])[0] = "mixin";
        MixinContainer.llIIlllllI[1] = "Instancing new {} for {}";
        MixinContainer.llIIlllllI[2] = "Processing prepare() for {}";
        MixinContainer.llIIlllllI[3] = "Processing launch tasks for {}";
        MixinContainer.llIIlllllI[4] = "Processing inject() for {}";
        MixinContainer.llIIlllllI[5] = "mixin.agents";
        MixinContainer.llIIlllllI[6] = "org.spongepowered.asm.launch.platform.MixinPlatformAgentDefault";
    }
    
    private static String lIIlIllIllII(String s, final String s2) {
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
    
    private static String lIIlIllIllIl(final String s, final String s2) {
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
}
