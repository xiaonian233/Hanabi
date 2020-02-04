package org.spongepowered.asm.mixin.injection.invoke.arg;

public abstract class Args
{
    private Object[] values;
    
    private Args(final Object[] values) {
        super();
        this.values = values;
    }
    
    private int size() {
        return this.values.length;
    }
    
    private <T> T get(final int n) {
        return (T)this.values[n];
    }
    
    public abstract <T> void set$1ef468a();
    
    public abstract void setAll$1b4f7664();
}
