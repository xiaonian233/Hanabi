package ClassSub;

import java.lang.invoke.*;

public final class Class306<T>
{
    String text;
    Class127<T> listener;
    T object;
    private static final long a;
    
    public Class306(final String text, final Class127<T> listener, final T object) {
        super();
        this.text = text;
        this.listener = listener;
        this.object = object;
    }
    
    private String getText() {
        return this.text;
    }
    
    private void setText(final String text) {
        this.text = text;
    }
    
    private Class127<T> getListener() {
        return this.listener;
    }
    
    private void setListener(final Class127<T> listener) {
        this.listener = listener;
    }
    
    private T getObject() {
        return this.object;
    }
    
    private void setObject(final T object) {
        this.object = object;
    }
    
    private void press() {
        final int[] b = Class139.b();
        final Class127<T> listener = this.listener;
        if (b == null) {
            if (listener == null) {
                return;
            }
            final Class127<T> listener2 = this.listener;
        }
        listener.onClick(this);
    }
    
    static {
        Class169.a(6518713820217905668L, 8765429768295030139L, MethodHandles.lookup().lookupClass()).a(58682053880871L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
