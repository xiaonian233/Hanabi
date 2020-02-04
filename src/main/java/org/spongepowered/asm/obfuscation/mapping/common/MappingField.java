package org.spongepowered.asm.obfuscation.mapping.common;

import org.spongepowered.asm.obfuscation.mapping.*;
import com.google.common.base.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public class MappingField implements IMapping<MappingField>
{
    public final String owner;
    public final String name;
    public final String desc;
    private static final String[] lIlIlIlII;
    
    private MappingField(final String s, final String s2) {
        this(s, s2, null);
    }
    
    public MappingField(final String owner, final String name, final String desc) {
        super();
        this.owner = owner;
        this.name = name;
        this.desc = desc;
    }
    
    @Override
    public final Type getType() {
        return Type.FIELD;
    }
    
    @Override
    public final String getName() {
        return this.name;
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
    
    private static MappingField getSuper() {
        return null;
    }
    
    public final MappingField move(final String s) {
        return new MappingField(s, this.name, this.desc);
    }
    
    private MappingField remap(final String s) {
        return new MappingField(this.owner, s, this.desc);
    }
    
    public final MappingField transform(final String s) {
        return new MappingField(this.owner, this.name, s);
    }
    
    @Override
    public final MappingField copy() {
        return new MappingField(this.owner, this.name, this.desc);
    }
    
    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[] { this.toString() });
    }
    
    @Override
    public boolean equals(final Object o) {
        return this == o || (o instanceof MappingField && Objects.equal((Object)this.toString(), (Object)((MappingField)o).toString()));
    }
    
    @Override
    public String serialise() {
        return this.toString();
    }
    
    @Override
    public String toString() {
        return String.format(MappingField.lIlIlIlII[0], this.owner, this.name, Strings.nullToEmpty(this.desc));
    }
    
    @Override
    public final /* bridge */ Object getSuper() {
        return null;
    }
    
    @Override
    public final /* bridge */ Object copy() {
        return this.copy();
    }
    
    @Override
    public final /* bridge */ Object transform$9543ced() {
        return this.transform(null);
    }
    
    @Override
    public final /* bridge */ Object remap(final String s) {
        return new MappingField(this.owner, s, this.desc);
    }
    
    @Override
    public final /* bridge */ Object move$9543ced() {
        return this.move(null);
    }
    
    static {
        lllIlIIIIl();
    }
    
    private static void lllIlIIIIl() {
        (lIlIlIlII = new String[] { null })[0] = "L%s;%s:%s";
    }
    
    private static String lllIIlllII(final String s, final String s2) {
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
    
    private static boolean lllIlIIIll(final Object o, final Object o2) {
        return o == o2;
    }
}
