package org.spongepowered.asm.mixin.transformer;

import net.minecraft.launchwrapper.*;
import org.spongepowered.asm.service.*;
import org.apache.logging.log4j.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class Proxy implements IClassTransformer, ILegacyClassTransformer
{
    private static List<Proxy> proxies;
    private static MixinTransformer transformer;
    private boolean isActive;
    private static final String[] lIIllllIIll;
    
    public Proxy() {
        super();
        this.isActive = true;
        final Iterator<Proxy> iterator = Proxy.proxies.iterator();
        while (iterator.hasNext()) {
            iterator.next().isActive = false;
        }
        Proxy.proxies.add(this);
        LogManager.getLogger(Proxy.lIIllllIIll[0]).debug(Proxy.lIIllllIIll[1], new Object[] { Proxy.proxies.size() });
    }
    
    public final byte[] transform(final String s, final String s2, final byte[] array) {
        if (this.isActive) {
            return Proxy.transformer.transformClassBytes(s, s2, array);
        }
        return array;
    }
    
    public final String getName() {
        return this.getClass().getName();
    }
    
    public final boolean isDelegationExcluded() {
        return true;
    }
    
    public final byte[] transformClassBytes(final String s, final String s2, final byte[] array) {
        if (this.isActive) {
            return Proxy.transformer.transformClassBytes(s, s2, array);
        }
        return array;
    }
    
    static {
        llIlllllIIIl();
        Proxy.proxies = new ArrayList<Proxy>();
        Proxy.transformer = new MixinTransformer();
    }
    
    private static void llIlllllIIIl() {
        (lIIllllIIll = new String[2])[0] = "mixin";
        Proxy.lIIllllIIll[1] = "Adding new mixin transformer proxy #{}";
    }
    
    private static String llIllllIllll(final String s, final String s2) {
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
    
    private static String llIlllllIIII(String s, final String s2) {
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
}
