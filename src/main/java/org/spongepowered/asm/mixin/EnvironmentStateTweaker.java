package org.spongepowered.asm.mixin;

import java.io.*;
import net.minecraft.launchwrapper.*;
import org.spongepowered.asm.launch.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class EnvironmentStateTweaker implements ITweaker
{
    private static final String[] lIIIIIIIIIl;
    
    public EnvironmentStateTweaker() {
        super();
    }
    
    public final void acceptOptions(final List<String> list, final File file, final File file2, final String s) {
    }
    
    public final void injectIntoClassLoader(final LaunchClassLoader launchClassLoader) {
        MixinBootstrap.getPlatform().inject();
    }
    
    public final String getLaunchTarget() {
        return EnvironmentStateTweaker.lIIIIIIIIIl[0];
    }
    
    public final String[] getLaunchArguments() {
        MixinEnvironment.gotoPhase(MixinEnvironment.Phase.DEFAULT);
        return new String[0];
    }
    
    static {
        lIlllIIllIII();
    }
    
    private static void lIlllIIllIII() {
        (lIIIIIIIIIl = new String[] { null })[0] = "";
    }
    
    private static String lIlllIIlIlll(final String s, final String s2) {
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
}
