package org.spongepowered.asm.bridge;

import java.lang.reflect.*;
import org.objectweb.asm.commons.*;
import org.spongepowered.asm.mixin.extensibility.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class RemapperAdapterFML extends RemapperAdapter
{
    private static final String DEOBFUSCATING_REMAPPER_CLASS;
    private static final String DEOBFUSCATING_REMAPPER_CLASS_FORGE;
    private static final String DEOBFUSCATING_REMAPPER_CLASS_LEGACY;
    private static final String INSTANCE_FIELD;
    private static final String UNMAP_METHOD;
    private final Method mdUnmap;
    private static final String[] lIIIlIl;
    
    private RemapperAdapterFML(final Remapper remapper, final Method mdUnmap) {
        super(remapper);
        this.logger.info(RemapperAdapterFML.lIIIlIl[0], new Object[] { remapper });
        this.mdUnmap = mdUnmap;
    }
    
    @Override
    public final String unmap(final String s) {
        try {
            return this.mdUnmap.invoke(this.remapper, s).toString();
        }
        catch (Exception ex) {
            return s;
        }
    }
    
    private static IRemapper create() {
        try {
            final Class<?> fmlDeobfuscatingRemapper;
            return new RemapperAdapterFML((Remapper)(fmlDeobfuscatingRemapper = getFMLDeobfuscatingRemapper()).getDeclaredField(RemapperAdapterFML.lIIIlIl[1]).get(null), fmlDeobfuscatingRemapper.getDeclaredMethod(RemapperAdapterFML.lIIIlIl[2], String.class));
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static Class<?> getFMLDeobfuscatingRemapper() throws ClassNotFoundException {
        final String s = RemapperAdapterFML.lIIIlIl[3];
        try {
            return Class.forName(s);
        }
        catch (ClassNotFoundException ex) {
            return Class.forName(RemapperAdapterFML.lIIIlIl[4]);
        }
    }
    
    static {
        lIlIlIll();
    }
    
    private static void lIlIlIll() {
        (lIIIlIl = new String[10])[0] = "Initialised Mixin FML Remapper Adapter with {}";
        RemapperAdapterFML.lIIIlIl[1] = "INSTANCE";
        RemapperAdapterFML.lIIIlIl[2] = "unmap";
        RemapperAdapterFML.lIIIlIl[3] = "net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper";
        RemapperAdapterFML.lIIIlIl[4] = "cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper";
        RemapperAdapterFML.lIIIlIl[5] = "unmap";
        RemapperAdapterFML.lIIIlIl[6] = "fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper";
        RemapperAdapterFML.lIIIlIl[7] = "net.minecraftforge.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper";
        RemapperAdapterFML.lIIIlIl[8] = "cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper";
        RemapperAdapterFML.lIIIlIl[9] = "INSTANCE";
    }
    
    private static String lIlIIIIl(final String s, final String s2) {
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
    
    private static String lIIlllll(final String s, final String s2) {
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
    
    private static String lIlIIllI(String s, final String s2) {
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
