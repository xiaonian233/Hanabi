package org.spongepowered.asm.launch.platform;

import java.net.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

public final class MixinPlatformAgentDefault extends MixinPlatformAgentAbstract
{
    private static final String[] lIIlIIllllI;
    
    private MixinPlatformAgentDefault(final URI uri) {
        super(uri);
    }
    
    @Override
    public final void prepare() {
        final String value;
        if ((value = this.attributes.get(MixinPlatformAgentDefault.lIIlIIllllI[0])) != null) {
            MixinPlatformManager.setCompatibilityLevel(value);
        }
        final String value2;
        if ((value2 = this.attributes.get(MixinPlatformAgentDefault.lIIlIIllllI[1])) != null) {
            String[] split;
            for (int length = (split = value2.split(MixinPlatformAgentDefault.lIIlIIllllI[2])).length, i = 0; i < length; ++i) {
                MixinPlatformManager.addConfig(split[i].trim());
            }
        }
        final String value3;
        if ((value3 = this.attributes.get(MixinPlatformAgentDefault.lIIlIIllllI[3])) != null) {
            String[] split2;
            for (int length2 = (split2 = value3.split(MixinPlatformAgentDefault.lIIlIIllllI[4])).length, j = 0; j < length2; ++j) {
                MixinPlatformManager.addTokenProvider(split2[j].trim());
            }
        }
    }
    
    @Override
    public final void initPrimaryContainer() {
    }
    
    @Override
    public final void inject() {
    }
    
    @Override
    public final String getLaunchTarget() {
        return this.attributes.get(MixinPlatformAgentDefault.lIIlIIllllI[5]);
    }
    
    static {
        llIlIlIIIlIl();
    }
    
    private static void llIlIlIIIlIl() {
        (lIIlIIllllI = new String[6])[0] = "MixinCompatibilityLevel";
        MixinPlatformAgentDefault.lIIlIIllllI[1] = "MixinConfigs";
        MixinPlatformAgentDefault.lIIlIIllllI[2] = ",";
        MixinPlatformAgentDefault.lIIlIIllllI[3] = "MixinTokenProviders";
        MixinPlatformAgentDefault.lIIlIIllllI[4] = ",";
        MixinPlatformAgentDefault.lIIlIIllllI[5] = "Main-Class";
    }
    
    private static String llIlIlIIIlII(String s, final String s2) {
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
    
    private static String llIlIlIIIIII(final String s, final String s2) {
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
    
    private static String llIlIlIIIIIl(final String s, final String s2) {
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
