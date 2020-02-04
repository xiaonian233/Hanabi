package ClassSub;

import java.util.*;

final class Class74
{
    ArrayList points;
    private Class95 this$0;
    
    public Class74() {
        super();
        this.points = new ArrayList();
    }
    
    private boolean contains(final Class122 class122) {
        return this.points.contains(class122);
    }
    
    public final void add(final Class122 class122) {
        this.points.add(class122);
    }
    
    private void remove(final Class122 class122) {
        this.points.remove(class122);
    }
    
    private int size() {
        return this.points.size();
    }
    
    public final Class122 get(final int n) {
        return this.points.get(n);
    }
    
    private void clear() {
        this.points.clear();
    }
}
