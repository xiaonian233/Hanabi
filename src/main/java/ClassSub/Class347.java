package ClassSub;

import java.util.*;

public final class Class347 implements Comparator<Class56>
{
    private Class174 this$0;
    
    public Class347() {
        super();
    }
    
    private static int compare(final Class56 class56, final Class56 class57) {
        return (int)(class56.squareDistanceToFromTarget + class56.totalCost - (class57.squareDistanceToFromTarget + class57.totalCost));
    }
    
    @Override
    public final /* bridge */ int compare(final Object o, final Object o2) {
        final Class56 class56 = (Class56)o;
        final Class56 class57 = (Class56)o2;
        return (int)(class56.squareDistanceToFromTarget + class56.totalCost - (class57.squareDistanceToFromTarget + class57.totalCost));
    }
}
