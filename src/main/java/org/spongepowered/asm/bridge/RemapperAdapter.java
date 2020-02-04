package org.spongepowered.asm.bridge;

import org.spongepowered.asm.mixin.extensibility.*;
import org.spongepowered.asm.util.*;
import org.objectweb.asm.commons.*;
import org.apache.logging.log4j.*;
import java.nio.charset.*;
import javax.crypto.*;
import java.util.*;
import javax.crypto.spec.*;
import java.security.*;

public abstract class RemapperAdapter implements IRemapper, ObfuscationUtil.IClassRemapper
{
    protected final Logger logger;
    protected final Remapper remapper;
    private static final String[] lIIIIlIlIII;
    
    public RemapperAdapter(final Remapper remapper) {
        super();
        this.logger = LogManager.getLogger(RemapperAdapter.lIIIIlIlIII[0]);
        this.remapper = remapper;
    }
    
    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
    
    @Override
    public final String mapMethodName(String unmap, final String s, String unmapDescriptor) {
        this.logger.debug(RemapperAdapter.lIIIIlIlIII[1], new Object[] { this, s, unmapDescriptor, unmap });
        final String mapMethodName;
        if (!(mapMethodName = this.remapper.mapMethodName(unmap, s, unmapDescriptor)).equals(s)) {
            return mapMethodName;
        }
        unmap = this.unmap(unmap);
        unmapDescriptor = ObfuscationUtil.unmapDescriptor(unmapDescriptor, this);
        this.logger.debug(RemapperAdapter.lIIIIlIlIII[2], new Object[] { this, s, unmapDescriptor, unmap });
        return this.remapper.mapMethodName(unmap, s, unmapDescriptor);
    }
    
    @Override
    public final String mapFieldName(String unmap, final String s, String unmapDescriptor) {
        this.logger.debug(RemapperAdapter.lIIIIlIlIII[3], new Object[] { this, s, unmapDescriptor, unmap });
        final String mapFieldName;
        if (!(mapFieldName = this.remapper.mapFieldName(unmap, s, unmapDescriptor)).equals(s)) {
            return mapFieldName;
        }
        unmap = this.unmap(unmap);
        unmapDescriptor = ObfuscationUtil.unmapDescriptor(unmapDescriptor, this);
        this.logger.debug(RemapperAdapter.lIIIIlIlIII[4], new Object[] { this, s, unmapDescriptor, unmap });
        return this.remapper.mapFieldName(unmap, s, unmapDescriptor);
    }
    
    @Override
    public final String map(final String s) {
        this.logger.debug(RemapperAdapter.lIIIIlIlIII[5], new Object[] { this, s });
        return this.remapper.map(s);
    }
    
    @Override
    public String unmap(final String s) {
        return s;
    }
    
    @Override
    public final String mapDesc(final String s) {
        return this.remapper.mapDesc(s);
    }
    
    @Override
    public final String unmapDesc(final String s) {
        return ObfuscationUtil.unmapDescriptor(s, this);
    }
    
    static {
        llIIIIIIlIII();
    }
    
    private static void llIIIIIIlIII() {
        (lIIIIlIlIII = new String[6])[0] = "mixin";
        RemapperAdapter.lIIIIlIlIII[1] = "{} is remapping method {}{} for {}";
        RemapperAdapter.lIIIIlIlIII[2] = "{} is remapping obfuscated method {}{} for {}";
        RemapperAdapter.lIIIIlIlIII[3] = "{} is remapping field {}{} for {}";
        RemapperAdapter.lIIIIlIlIII[4] = "{} is remapping obfuscated field {}{} for {}";
        RemapperAdapter.lIIIIlIlIII[5] = "{} is remapping class {}";
    }
    
    private static String llIIIIIIIlll(String s, final String s2) {
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
    
    private static String llIIIIIIIllI(final String s, final String s2) {
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
