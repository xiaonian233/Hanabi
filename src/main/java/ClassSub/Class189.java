package ClassSub;

import java.util.*;

final class Class189 implements Iterator
{
    private ListIterator val$iter;
    private Class301 this$0;
    
    Class189(final ListIterator val$iter) {
        this.val$iter = val$iter;
        super();
    }
    
    @Override
    public final boolean hasNext() {
        return this.val$iter.hasPrevious();
    }
    
    @Override
    public final Object next() {
        return this.val$iter.previous();
    }
    
    @Override
    public final void remove() {
        this.val$iter.remove();
    }
}
