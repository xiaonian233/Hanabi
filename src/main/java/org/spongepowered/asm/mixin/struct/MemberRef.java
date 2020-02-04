package org.spongepowered.asm.mixin.struct;

import org.spongepowered.asm.util.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import org.spongepowered.asm.lib.*;
import org.spongepowered.asm.mixin.transformer.throwables.*;
import org.spongepowered.asm.lib.tree.*;

public abstract class MemberRef
{
    private static final int[] H_OPCODES;
    private static final String[] lIIIIllllIl;
    
    public MemberRef() {
        super();
    }
    
    public abstract boolean isField();
    
    public abstract int getOpcode();
    
    public abstract void setOpcode$13462e();
    
    public abstract String getOwner();
    
    public abstract void setOwner(final String p0);
    
    public abstract String getName();
    
    public abstract void setName(final String p0);
    
    public abstract String getDesc();
    
    public abstract void setDesc(final String p0);
    
    @Override
    public String toString() {
        return String.format(MemberRef.lIIIIllllIl[0], Bytecode.getOpcodeName(this.getOpcode()), this.getOwner(), this.getName(), this.isField() ? MemberRef.lIIIIllllIl[1] : MemberRef.lIIIIllllIl[2], this.getDesc());
    }
    
    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof MemberRef)) {
            return false;
        }
        final MemberRef memberRef = (MemberRef)o;
        return this.getOpcode() == memberRef.getOpcode() && this.getOwner().equals(memberRef.getOwner()) && this.getName().equals(memberRef.getName()) && this.getDesc().equals(memberRef.getDesc());
    }
    
    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }
    
    static int opcodeFromTag(final int n) {
        if (n >= 0 && n < 10) {
            return MemberRef.H_OPCODES[n];
        }
        return 0;
    }
    
    static int tagFromOpcode$134621() {
        for (int i = 1; i < 10; ++i) {
            if (MemberRef.H_OPCODES[i] == 182) {
                return i;
            }
        }
        return 0;
    }
    
    static {
        llIIIIllIIII();
        H_OPCODES = new int[] { 0, 180, 178, 181, 179, 182, 184, 183, 183, 185 };
    }
    
    private static void llIIIIllIIII() {
        (lIIIIllllIl = new String[3])[0] = "%s for %s.%s%s%s";
        MemberRef.lIIIIllllIl[1] = ":";
        MemberRef.lIIIIllllIl[2] = "";
    }
    
    private static String llIIIIlIlIll(final String s, final String s2) {
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
    
    private static String llIIIIlIllIl(final String s, final String s2) {
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
    
    private static String llIIIIlIllII(String s, final String s2) {
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
    
    private static boolean llIllIlllllI(final int n) {
        return n >= 0;
    }
}
