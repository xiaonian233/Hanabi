package org.spongepowered.tools.obfuscation;

import org.spongepowered.tools.obfuscation.interfaces.*;
import org.spongepowered.tools.obfuscation.mapping.*;
import org.spongepowered.tools.obfuscation.service.*;
import javax.tools.*;
import java.util.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;

public final class ObfuscationManager implements IObfuscationManager
{
    private final IMixinAnnotationProcessor ap;
    private final List<ObfuscationEnvironment> environments;
    private final IObfuscationDataProvider obfs;
    private final IReferenceManager refs;
    private final List<IMappingConsumer> consumers;
    private boolean initDone;
    
    public ObfuscationManager(final IMixinAnnotationProcessor ap) {
        super();
        this.environments = new ArrayList<ObfuscationEnvironment>();
        this.consumers = new ArrayList<IMappingConsumer>();
        this.ap = ap;
        this.obfs = new ObfuscationDataProvider(ap, this.environments);
        this.refs = new ReferenceManager(ap, this.environments);
    }
    
    @Override
    public final void init() {
        if (this.initDone) {
            return;
        }
        this.initDone = true;
        final ObfuscationServices instance = ObfuscationServices.getInstance();
        final IMixinAnnotationProcessor ap = this.ap;
        final ObfuscationServices obfuscationServices = instance;
        final ServiceLoader<IObfuscationService> serviceLoader = instance.serviceLoader;
        try {
            for (final IObfuscationService obfuscationService : serviceLoader) {
                if (!obfuscationServices.services.contains(obfuscationService)) {
                    obfuscationServices.services.add(obfuscationService);
                    final String simpleName = obfuscationService.getClass().getSimpleName();
                    final Collection<ObfuscationTypeDescriptor> obfuscationTypes;
                    if ((obfuscationTypes = obfuscationService.getObfuscationTypes()) == null) {
                        continue;
                    }
                    for (final ObfuscationTypeDescriptor obfuscationTypeDescriptor : obfuscationTypes) {
                        final IMixinAnnotationProcessor mixinAnnotationProcessor = ap;
                        try {
                            ap.printMessage(Diagnostic.Kind.NOTE, String.valueOf(new StringBuilder().append(simpleName).append(ObfuscationServices.lIlIlIIlIIl[0]).append(ObfuscationType.create(obfuscationTypeDescriptor, mixinAnnotationProcessor)).append(ObfuscationServices.lIlIlIIlIIl[1])));
                        }
                        catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        }
        catch (ServiceConfigurationError serviceConfigurationError) {
            ap.printMessage(Diagnostic.Kind.ERROR, String.valueOf(new StringBuilder().append(serviceConfigurationError.getClass().getSimpleName()).append(ObfuscationServices.lIlIlIIlIIl[2]).append(serviceConfigurationError.getMessage())));
            serviceConfigurationError.printStackTrace();
        }
        final Iterator<ObfuscationType> iterator3 = ObfuscationType.types().iterator();
        while (iterator3.hasNext()) {
            final ObfuscationType obfuscationType;
            if ((obfuscationType = iterator3.next()).getInputFileNames().size() > 0) {
                this.environments.add(obfuscationType.createEnvironment());
            }
        }
    }
    
    @Override
    public final IObfuscationDataProvider getDataProvider() {
        return this.obfs;
    }
    
    @Override
    public final IReferenceManager getReferenceManager() {
        return this.refs;
    }
    
    @Override
    public final IMappingConsumer createMappingConsumer() {
        final Mappings mappings = new Mappings();
        this.consumers.add(mappings);
        return mappings;
    }
    
    @Override
    public final List<ObfuscationEnvironment> getEnvironments() {
        return this.environments;
    }
    
    @Override
    public final void writeMappings() {
        for (final ObfuscationEnvironment obfuscationEnvironment : this.environments) {
            final List<IMappingConsumer> consumers = this.consumers;
            final ObfuscationEnvironment obfuscationEnvironment2 = obfuscationEnvironment;
            final IMappingConsumer.MappingSet<MappingField> set = new IMappingConsumer.MappingSet<MappingField>();
            final IMappingConsumer.MappingSet set2 = new IMappingConsumer.MappingSet<MappingMethod>();
            for (final IMappingConsumer mappingConsumer : consumers) {
                set.addAll((Collection<?>)mappingConsumer.getFieldMappings(obfuscationEnvironment2.type));
                set2.addAll((Collection<?>)mappingConsumer.getMethodMappings(obfuscationEnvironment2.type));
            }
            obfuscationEnvironment2.mappingWriter.write(obfuscationEnvironment2.outFileName, obfuscationEnvironment2.type, set, (IMappingConsumer.MappingSet<MappingMethod>)set2);
        }
    }
    
    @Override
    public final void writeReferences() {
        this.refs.write();
    }
}
