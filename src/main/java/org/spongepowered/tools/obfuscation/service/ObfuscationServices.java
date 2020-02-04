package org.spongepowered.tools.obfuscation.service;

import org.spongepowered.tools.obfuscation.interfaces.*;
import javax.tools.*;
import org.spongepowered.tools.obfuscation.*;
import java.util.*;
import java.nio.charset.*;

public final class ObfuscationServices
{
    private static ObfuscationServices instance;
    public final ServiceLoader<IObfuscationService> serviceLoader;
    public final Set<IObfuscationService> services;
    public static final String[] lIlIlIIlIIl;
    
    private ObfuscationServices() {
        super();
        this.services = new HashSet<IObfuscationService>();
        this.serviceLoader = ServiceLoader.load(IObfuscationService.class, this.getClass().getClassLoader());
    }
    
    public static ObfuscationServices getInstance() {
        if (ObfuscationServices.instance == null) {
            ObfuscationServices.instance = new ObfuscationServices();
        }
        return ObfuscationServices.instance;
    }
    
    private void initProviders(final IMixinAnnotationProcessor mixinAnnotationProcessor) {
        final ServiceLoader<IObfuscationService> serviceLoader = this.serviceLoader;
        try {
            for (final IObfuscationService obfuscationService : serviceLoader) {
                if (!this.services.contains(obfuscationService)) {
                    this.services.add(obfuscationService);
                    final String simpleName = obfuscationService.getClass().getSimpleName();
                    final Collection<ObfuscationTypeDescriptor> obfuscationTypes;
                    if ((obfuscationTypes = obfuscationService.getObfuscationTypes()) == null) {
                        continue;
                    }
                    for (final ObfuscationTypeDescriptor obfuscationTypeDescriptor : obfuscationTypes) {
                        try {
                            mixinAnnotationProcessor.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append(simpleName).append(ObfuscationServices.lIlIlIIlIIl[0]).append(ObfuscationType.create(obfuscationTypeDescriptor, mixinAnnotationProcessor)).append(ObfuscationServices.lIlIlIIlIIl[1])));
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
        catch (ServiceConfigurationError serviceConfigurationError) {
            mixinAnnotationProcessor.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(serviceConfigurationError.getClass().getSimpleName()).append(ObfuscationServices.lIlIlIIlIIl[2]).append(serviceConfigurationError.getMessage())));
            serviceConfigurationError.printStackTrace();
        }
    }
    
    private Set<String> getSupportedOptions() {
        final HashSet<Object> set = (HashSet<Object>)new HashSet<String>();
        final Iterator<IObfuscationService> iterator = this.serviceLoader.iterator();
        while (iterator.hasNext()) {
            final Set<String> supportedOptions;
            if ((supportedOptions = iterator.next().getSupportedOptions()) != null) {
                set.addAll(supportedOptions);
            }
        }
        return (Set<String>)set;
    }
    
    private IObfuscationService getService(final Class<? extends IObfuscationService> clazz) {
        for (final IObfuscationService obfuscationService : this.serviceLoader) {
            if (clazz.getName().equals(obfuscationService.getClass().getName())) {
                return obfuscationService;
            }
        }
        return null;
    }
    
    static {
        lllIllIIIlII();
    }
    
    private static void lllIllIIIlII() {
        (lIlIlIIlIIl = new String[3])[0] = " supports type: \"";
        ObfuscationServices.lIlIlIIlIIl[1] = "\"";
        ObfuscationServices.lIlIlIIlIIl[2] = ": ";
    }
    
    private static String lllIllIIIIll(String s, final String s2) {
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
