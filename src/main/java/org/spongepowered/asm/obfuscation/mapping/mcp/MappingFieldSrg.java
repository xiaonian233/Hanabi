package org.spongepowered.asm.obfuscation.mapping.mcp;

import org.spongepowered.asm.obfuscation.mapping.common.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class MappingFieldSrg extends MappingField
{
    private final String srg;
    private static final String[] lIlIlIIIllI;
    
    public MappingFieldSrg(final String srg) {
        final int lastIndex;
        final int lastIndex2;
        super((srg != null && (lastIndex = srg.lastIndexOf(47)) >= 0) ? srg.substring(0, lastIndex) : null, (srg == null) ? null : (((lastIndex2 = srg.lastIndexOf(47)) >= 0) ? srg.substring(lastIndex2 + 1) : srg), null);
        this.srg = srg;
    }
    
    public MappingFieldSrg(final MappingField mappingField) {
        super(mappingField.owner, mappingField.getName(), null);
        this.srg = String.valueOf(new StringBuilder().append(mappingField.owner).append(MappingFieldSrg.lIlIlIIIllI[0]).append(mappingField.getName()));
    }
    
    @Override
    public final String serialise() {
        return this.srg;
    }
    
    private static String getNameFromSrg(final String s) {
        if (s == null) {
            return null;
        }
        final int lastIndex;
        if ((lastIndex = s.lastIndexOf(47)) >= 0) {
            return s.substring(lastIndex + 1);
        }
        return s;
    }
    
    private static String getOwnerFromSrg(final String s) {
        if (s == null) {
            return null;
        }
        final int lastIndex;
        if ((lastIndex = s.lastIndexOf(47)) >= 0) {
            return s.substring(0, lastIndex);
        }
        return null;
    }
    
    static {
        lllIlIllllIl();
    }
    
    private static void lllIlIllllIl() {
        (lIlIlIIIllI = new String[] { null })[0] = "/";
    }
    
    private static String lllIlIlllIlI(final String s, final String s2) {
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
    
    private static boolean lllIllIIIIIl$255f299(final int n) {
        return n >= 0;
    }
}
