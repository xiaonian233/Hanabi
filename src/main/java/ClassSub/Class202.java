package ClassSub;

import java.util.*;

final class Class202 extends LinkedHashMap
{
    private Class181 this$0;
    
    Class202(final Class181 this$0) {
        this.this$0 = this$0;
        super(200, 1.0f, true);
    }
    
    @Override
    protected final boolean removeEldestEntry(final Map.Entry entry) {
        Class181.access$002(this.this$0, entry.getValue());
        Class181.access$102(this.this$0, Class181.access$000(this.this$0).id);
        return false;
    }
}
