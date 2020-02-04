package org.spongepowered.tools.obfuscation;

import org.spongepowered.tools.obfuscation.mapping.*;
import org.spongepowered.asm.obfuscation.mapping.common.*;
import java.util.*;
import org.spongepowered.asm.obfuscation.mapping.*;

final class Mappings implements IMappingConsumer
{
    private final Map<ObfuscationType, MappingSet<MappingField>> fieldMappings;
    private final Map<ObfuscationType, MappingSet<MappingMethod>> methodMappings;
    UniqueMappings unique;
    
    public Mappings() {
        super();
        this.fieldMappings = new HashMap<ObfuscationType, MappingSet<MappingField>>();
        this.methodMappings = new HashMap<ObfuscationType, MappingSet<MappingMethod>>();
        this.init();
    }
    
    private void init() {
        for (final ObfuscationType obfuscationType : ObfuscationType.types()) {
            this.fieldMappings.put(obfuscationType, new MappingSet<MappingField>());
            this.methodMappings.put(obfuscationType, new MappingSet<MappingMethod>());
        }
    }
    
    private IMappingConsumer asUnique() {
        if (this.unique == null) {
            this.unique = new UniqueMappings(this);
        }
        return this.unique;
    }
    
    @Override
    public final MappingSet<MappingField> getFieldMappings(final ObfuscationType obfuscationType) {
        final MappingSet<MappingField> set;
        if ((set = this.fieldMappings.get(obfuscationType)) != null) {
            return set;
        }
        return new MappingSet<MappingField>();
    }
    
    @Override
    public final MappingSet<MappingMethod> getMethodMappings(final ObfuscationType obfuscationType) {
        final MappingSet<MappingMethod> set;
        if ((set = this.methodMappings.get(obfuscationType)) != null) {
            return set;
        }
        return new MappingSet<MappingMethod>();
    }
    
    @Override
    public final void clear() {
        this.fieldMappings.clear();
        this.methodMappings.clear();
        if (this.unique != null) {
            this.unique.clearMaps();
        }
        this.init();
    }
    
    @Override
    public final void addFieldMapping(final ObfuscationType obfuscationType, final MappingField mappingField, final MappingField mappingField2) {
        MappingSet<MappingField> set;
        if ((set = this.fieldMappings.get(obfuscationType)) == null) {
            set = new MappingSet<MappingField>();
            this.fieldMappings.put(obfuscationType, set);
        }
        set.add(new MappingSet.Pair<MappingField>(mappingField, mappingField2));
    }
    
    @Override
    public final void addMethodMapping(final ObfuscationType obfuscationType, final MappingMethod mappingMethod, final MappingMethod mappingMethod2) {
        MappingSet<MappingMethod> set;
        if ((set = this.methodMappings.get(obfuscationType)) == null) {
            set = new MappingSet<MappingMethod>();
            this.methodMappings.put(obfuscationType, set);
        }
        set.add(new MappingSet.Pair<MappingMethod>(mappingMethod, mappingMethod2));
    }
}
