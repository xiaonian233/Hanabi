package org.spongepowered.asm.mixin.transformer.ext;

import org.spongepowered.asm.mixin.transformer.*;
import org.spongepowered.asm.mixin.*;
import com.google.common.collect.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class Extensions
{
    private final MixinTransformer transformer;
    private final List<IExtension> extensions;
    private final Map<Class<? extends IExtension>, IExtension> extensionMap;
    private final List<IClassGenerator> generators;
    public final List<IClassGenerator> generatorsView;
    private final Map<Class<? extends IClassGenerator>, IClassGenerator> generatorMap;
    public List<IExtension> activeExtensions;
    private static final String[] lIlllIIIIIl;
    
    public Extensions(final MixinTransformer transformer) {
        super();
        this.extensions = new ArrayList<IExtension>();
        this.extensionMap = new HashMap<Class<? extends IExtension>, IExtension>();
        this.generators = new ArrayList<IClassGenerator>();
        this.generatorsView = Collections.unmodifiableList((List<? extends IClassGenerator>)this.generators);
        this.generatorMap = new HashMap<Class<? extends IClassGenerator>, IClassGenerator>();
        this.activeExtensions = Collections.emptyList();
        this.transformer = transformer;
    }
    
    private MixinTransformer getTransformer() {
        return this.transformer;
    }
    
    public final void add(final IExtension extension) {
        this.extensions.add(extension);
        this.extensionMap.put(extension.getClass(), extension);
    }
    
    private List<IExtension> getExtensions() {
        return Collections.unmodifiableList((List<? extends IExtension>)this.extensions);
    }
    
    private List<IExtension> getActiveExtensions() {
        return this.activeExtensions;
    }
    
    public final <T extends IExtension> T getExtension(final Class<? extends IExtension> clazz) {
        return lookup((Class<? extends T>)clazz, (Map<Class<? extends T>, T>)this.extensionMap, (List<T>)this.extensions);
    }
    
    public final void select(final MixinEnvironment mixinEnvironment) {
        final ImmutableList.Builder builder = ImmutableList.builder();
        final Iterator<IExtension> iterator = this.extensions.iterator();
        while (iterator.hasNext()) {
            final IExtension extension;
            if ((extension = iterator.next()).checkActive(mixinEnvironment)) {
                builder.add((Object)extension);
            }
        }
        this.activeExtensions = (List<IExtension>)builder.build();
    }
    
    private void preApply(final ITargetClassContext targetClassContext) {
        final Iterator<IExtension> iterator = this.activeExtensions.iterator();
        while (iterator.hasNext()) {
            iterator.next().preApply(targetClassContext);
        }
    }
    
    private void postApply(final ITargetClassContext targetClassContext) {
        final Iterator<IExtension> iterator = this.activeExtensions.iterator();
        while (iterator.hasNext()) {
            iterator.next().postApply(targetClassContext);
        }
    }
    
    public final void export(final MixinEnvironment mixinEnvironment, final String s, final boolean b, final byte[] array) {
        final Iterator<IExtension> iterator = this.activeExtensions.iterator();
        while (iterator.hasNext()) {
            iterator.next().export(mixinEnvironment, s, b, array);
        }
    }
    
    public final void add(final IClassGenerator classGenerator) {
        this.generators.add(classGenerator);
        this.generatorMap.put(classGenerator.getClass(), classGenerator);
    }
    
    private List<IClassGenerator> getGenerators() {
        return this.generatorsView;
    }
    
    public final <T extends IClassGenerator> T getGenerator(final Class<? extends IClassGenerator> clazz) {
        return lookup((Class<? extends T>)clazz, (Map<Class<? extends T>, T>)this.generatorMap, (List<T>)this.generators);
    }
    
    private static <T> T lookup(final Class<? extends T> clazz, final Map<Class<? extends T>, T> map, final List<T> list) {
        T value;
        if ((value = map.get(clazz)) == null) {
            for (final T next : list) {
                if (clazz.isAssignableFrom(next.getClass())) {
                    value = next;
                    break;
                }
            }
            if (value == null) {
                throw new IllegalArgumentException(String.valueOf(new StringBuilder().append(Extensions.lIlllIIIIIl[0]).append(clazz.getName()).append(Extensions.lIlllIIIIIl[1])));
            }
            map.put(clazz, value);
        }
        return value;
    }
    
    static {
        lllllllIIIlI();
    }
    
    private static void lllllllIIIlI() {
        (lIlllIIIIIl = new String[2])[0] = "Extension for <";
        Extensions.lIlllIIIIIl[1] = "> could not be found";
    }
    
    private static String lllllllIIIII(final String s, final String s2) {
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
    
    private static String lllllllIIIIl(String s, final String s2) {
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
