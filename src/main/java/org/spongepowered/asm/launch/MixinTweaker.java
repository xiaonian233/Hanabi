package org.spongepowered.asm.launch;

import java.io.*;
import net.minecraft.launchwrapper.*;
import org.spongepowered.asm.launch.platform.*;
import java.util.*;

public final class MixinTweaker implements ITweaker
{
    public MixinTweaker() {
        super();
        MixinBootstrap.start();
    }
    
    public final void acceptOptions(final List<String> list, final File file, final File file2, final String s) {
        MixinBootstrap.doInit(list);
    }
    
    public final void injectIntoClassLoader(final LaunchClassLoader launchClassLoader) {
        MixinBootstrap.inject();
    }
    
    public final String getLaunchTarget() {
        final Iterator<MixinContainer> iterator = MixinBootstrap.getPlatform().containers.values().iterator();
    Label_0017:
        while (iterator.hasNext()) {
            final Iterator<IMixinPlatformAgent> iterator2 = iterator.next().agents.iterator();
            while (true) {
                while (iterator2.hasNext()) {
                    final String launchTarget;
                    if ((launchTarget = iterator2.next().getLaunchTarget()) != null) {
                        final String s2;
                        final String s = s2 = launchTarget;
                        final String s3 = s2;
                        if (s != null) {
                            return s3;
                        }
                        continue Label_0017;
                    }
                }
                String s2;
                final String s = s2 = null;
                continue;
            }
        }
        return MixinPlatformManager.llIlll[12];
    }
    
    public final String[] getLaunchArguments() {
        return new String[0];
    }
}
