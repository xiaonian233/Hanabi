package org.spongepowered.asm.obfuscation.mapping.common;

import org.spongepowered.asm.obfuscation.mapping.*;
import com.google.common.base.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class MappingMethod implements IMapping<MappingMethod>
{
    public final String owner;
    public final String name;
    public final String desc;
    private static final String[] lIIllIIllII;
    
    public MappingMethod(final String s, final String s2) {
        final int lastIndex;
        final int lastIndex2;
        this((s != null && (lastIndex = s.lastIndexOf(47)) >= 0) ? s.substring(0, lastIndex) : null, (s == null) ? null : (((lastIndex2 = s.lastIndexOf(47)) >= 0) ? s.substring(lastIndex2 + 1) : s), s2);
    }
    
    public MappingMethod(final String owner, final String name, final String desc) {
        super();
        this.owner = owner;
        this.name = name;
        this.desc = desc;
    }
    
    @Override
    public final Type getType() {
        return Type.METHOD;
    }
    
    @Override
    public final String getName() {
        if (this.name == null) {
            return null;
        }
        return String.valueOf(new StringBuilder().append((this.owner != null) ? String.valueOf(new StringBuilder().append(this.owner).append(MappingMethod.lIIllIIllII[0])) : MappingMethod.lIIllIIllII[1]).append(this.name));
    }
    
    @Override
    public final String getSimpleName() {
        return this.name;
    }
    
    @Override
    public final String getOwner() {
        return this.owner;
    }
    
    @Override
    public final String getDesc() {
        return this.desc;
    }
    
    @Override
    public MappingMethod getSuper() {
        return null;
    }
    
    public final boolean isConstructor() {
        return MappingMethod.lIIllIIllII[2].equals(this.name);
    }
    
    public final MappingMethod move(final String s) {
        return new MappingMethod(s, this.name, this.desc);
    }
    
    @Override
    public MappingMethod remap(final String s) {
        return new MappingMethod(this.owner, s, this.desc);
    }
    
    public MappingMethod transform$9edaa() {
        return new MappingMethod(this.owner, this.name, null);
    }
    
    @Override
    public MappingMethod copy() {
        return new MappingMethod(this.owner, this.name, this.desc);
    }
    
    public final MappingMethod addPrefix(final String s) {
        final String name;
        if ((name = this.name) == null || name.startsWith(s)) {
            return this;
        }
        return new MappingMethod(this.owner, String.valueOf(new StringBuilder().append(s).append(name)), this.desc);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[] { this.getName(), this.desc });
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof MappingMethod && (Objects.equal((Object)this.name, (Object)((MappingMethod)o).name) && Objects.equal((Object)this.desc, (Object)((MappingMethod)o).desc)));
    }
    
    @Override
    public final String serialise() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        final String desc = this.desc;
        return String.format(MappingMethod.lIIllIIllII[3], this.getName(), (desc != null) ? MappingMethod.lIIllIIllII[4] : MappingMethod.lIIllIIllII[5], (desc != null) ? desc : MappingMethod.lIIllIIllII[6]);
    }
    
    private static String getBaseName(final String s) {
        if (s == null) {
            return null;
        }
        final int lastIndex;
        if ((lastIndex = s.lastIndexOf(47)) >= 0) {
            return s.substring(lastIndex + 1);
        }
        return s;
    }
    
    private static String getOwnerFromName(final String s) {
        if (s == null) {
            return null;
        }
        final int lastIndex;
        if ((lastIndex = s.lastIndexOf(47)) >= 0) {
            return s.substring(0, lastIndex);
        }
        return null;
    }
    
    @Override
    public /* bridge */ Object getSuper() {
        return this.getSuper();
    }
    
    @Override
    public /* bridge */ Object copy() {
        return this.copy();
    }
    
    @Override
    public /* bridge */ Object transform$9543ced() {
        return this.transform$9edaa();
    }
    
    @Override
    public /* bridge */ Object remap(final String s) {
        return this.remap(s);
    }
    
    @Override
    public final /* bridge */ Object move$9543ced() {
        return this.move(null);
    }
    
    static {
        llIllIIlllII();
    }
    
    private static void llIllIIlllII() {
        (lIIllIIllII = new String[7])[0] = "/";
        MappingMethod.lIIllIIllII[1] = "";
        MappingMethod.lIIllIIllII[2] = "<init>";
        MappingMethod.lIIllIIllII[3] = "%s%s%s";
        MappingMethod.lIIllIIllII[4] = " ";
        MappingMethod.lIIllIIllII[5] = "";
        MappingMethod.lIIllIIllII[6] = "";
    }
    
    private static String llIllIIllIll(final String s, final String s2) {
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
    
    private static String llIllIIllIIl(final String s, final String s2) {
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
    
    private static String llIllIIllIlI(String s, final String s2) {
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
    
    private static boolean llIllIlIIlIl$255f299(final int n) {
        return n >= 0;
    }
    
    private static boolean llIllIlIIlII(final Object o, final Object o2) {
        return o == o2;
    }
}
