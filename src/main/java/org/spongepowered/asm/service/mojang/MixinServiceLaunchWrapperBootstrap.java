package org.spongepowered.asm.service.mojang;

import org.spongepowered.asm.service.*;
import net.minecraft.launchwrapper.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

public final class MixinServiceLaunchWrapperBootstrap implements IMixinServiceBootstrap
{
    private static final String SERVICE_PACKAGE;
    private static final String MIXIN_UTIL_PACKAGE;
    private static final String ASM_PACKAGE;
    private static final String MIXIN_PACKAGE;
    private static final String[] lIIllIllIII;
    
    public MixinServiceLaunchWrapperBootstrap() {
        super();
    }
    
    @Override
    public final String getName() {
        return MixinServiceLaunchWrapperBootstrap.lIIllIllIII[0];
    }
    
    @Override
    public final String getServiceClassName() {
        return MixinServiceLaunchWrapperBootstrap.lIIllIllIII[1];
    }
    
    @Override
    public final void bootstrap() {
        Launch.classLoader.addClassLoaderExclusion(MixinServiceLaunchWrapperBootstrap.lIIllIllIII[2]);
        Launch.classLoader.addClassLoaderExclusion(MixinServiceLaunchWrapperBootstrap.lIIllIllIII[3]);
        Launch.classLoader.addClassLoaderExclusion(MixinServiceLaunchWrapperBootstrap.lIIllIllIII[4]);
        Launch.classLoader.addClassLoaderExclusion(MixinServiceLaunchWrapperBootstrap.lIIllIllIII[5]);
    }
    
    static {
        llIllIllIllI();
    }
    
    private static void llIllIllIllI() {
        (lIIllIllIII = new String[10])[0] = "LaunchWrapper";
        MixinServiceLaunchWrapperBootstrap.lIIllIllIII[1] = "org.spongepowered.asm.service.mojang.MixinServiceLaunchWrapper";
        MixinServiceLaunchWrapperBootstrap.lIIllIllIII[2] = "org.spongepowered.asm.service.";
        MixinServiceLaunchWrapperBootstrap.lIIllIllIII[3] = "org.spongepowered.asm.lib.";
        MixinServiceLaunchWrapperBootstrap.lIIllIllIII[4] = "org.spongepowered.asm.mixin.";
        MixinServiceLaunchWrapperBootstrap.lIIllIllIII[5] = "org.spongepowered.asm.util.";
        MixinServiceLaunchWrapperBootstrap.lIIllIllIII[6] = "org.spongepowered.asm.service.";
        MixinServiceLaunchWrapperBootstrap.lIIllIllIII[7] = "org.spongepowered.asm.util.";
        MixinServiceLaunchWrapperBootstrap.lIIllIllIII[8] = "org.spongepowered.asm.lib.";
        MixinServiceLaunchWrapperBootstrap.lIIllIllIII[9] = "org.spongepowered.asm.mixin.";
    }
    
    private static String llIllIllIIIl(String s, final String s2) {
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
    
    private static String llIllIllIIlI(final String s, final String s2) {
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
    
    private static String llIllIllIIll(final String s, final String s2) {
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
