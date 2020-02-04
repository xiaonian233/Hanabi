package org.spongepowered.tools.obfuscation.mapping.mcp;

import org.spongepowered.tools.obfuscation.mapping.common.*;
import com.google.common.collect.*;
import com.google.common.base.*;
import org.spongepowered.asm.obfuscation.mapping.mcp.*;
import org.spongepowered.asm.mixin.throwables.*;
import java.io.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;
import com.google.common.io.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;

public final class MappingProviderSrg extends MappingProvider
{
    public MappingProviderSrg() {
        super();
    }
    
    @Override
    public final void read(final File file) throws IOException {
        Files.readLines(file, Charset.defaultCharset(), (LineProcessor)new LineProcessor<String>() {
            private /* synthetic */ BiMap val$packageMap = MappingProviderSrg.this.packageMap;
            private /* synthetic */ BiMap val$classMap = MappingProviderSrg.this.classMap;
            private /* synthetic */ BiMap val$fieldMap = MappingProviderSrg.this.fieldMap;
            private /* synthetic */ BiMap val$methodMap = MappingProviderSrg.this.methodMap;
            private /* synthetic */ File val$input;
            private /* synthetic */ MappingProviderSrg this$0;
            private static final String[] lllIllIlll;
            
            MappingProviderSrg$1() {
                super();
            }
            
            private static String getResult() {
                return null;
            }
            
            public final boolean processLine(final String s) throws IOException {
                if (Strings.isNullOrEmpty(s) || s.startsWith(MappingProviderSrg$1.lllIllIlll[0])) {
                    return true;
                }
                final String substring = s.substring(0, 2);
                final String[] split = s.substring(4).split(MappingProviderSrg$1.lllIllIlll[1]);
                if (substring.equals(MappingProviderSrg$1.lllIllIlll[2])) {
                    this.val$packageMap.forcePut((Object)split[0], (Object)split[1]);
                }
                else if (substring.equals(MappingProviderSrg$1.lllIllIlll[3])) {
                    this.val$classMap.forcePut((Object)split[0], (Object)split[1]);
                }
                else if (substring.equals(MappingProviderSrg$1.lllIllIlll[4])) {
                    this.val$fieldMap.forcePut((Object)new MappingFieldSrg(split[0]).copy(), (Object)new MappingFieldSrg(split[1]).copy());
                }
                else {
                    if (!substring.equals(MappingProviderSrg$1.lllIllIlll[5])) {
                        throw new MixinException(String.valueOf(new StringBuilder().append(MappingProviderSrg$1.lllIllIlll[6]).append(file)));
                    }
                    this.val$methodMap.forcePut((Object)new MappingMethod(split[0], split[1]), (Object)new MappingMethod(split[2], split[3]));
                }
                return true;
            }
            
            public final /* bridge */ Object getResult() {
                return null;
            }
            
            static {
                lIlIlIIllIlI();
            }
            
            private static void lIlIlIIllIlI() {
                (lllIllIlll = new String[7])[0] = "#";
                MappingProviderSrg$1.lllIllIlll[1] = " ";
                MappingProviderSrg$1.lllIllIlll[2] = "PK";
                MappingProviderSrg$1.lllIllIlll[3] = "CL";
                MappingProviderSrg$1.lllIllIlll[4] = "FD";
                MappingProviderSrg$1.lllIllIlll[5] = "MD";
                MappingProviderSrg$1.lllIllIlll[6] = "Invalid SRG file: ";
            }
            
            private static String lIlIlIIllIIl(final String s, final String s2) {
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
            
            private static String lIlIlIIllIII(final String s, final String s2) {
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
            
            private static String lIlIlIIlIlll(String s, final String s2) {
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
        });
    }
    
    @Override
    public final MappingField getFieldMapping(MappingField mappingField) {
        if (mappingField.desc != null) {
            mappingField = new MappingFieldSrg(mappingField);
        }
        return (MappingField)this.fieldMap.get((Object)mappingField);
    }
}
