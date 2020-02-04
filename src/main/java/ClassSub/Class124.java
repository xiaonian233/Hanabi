package ClassSub;

import java.io.*;

public interface Class124 extends Serializable
{
    int getTriangleCount();
    
    float[] getTrianglePoint(final int p0, final int p1);
    
    void addPolyPoint(final float p0, final float p1);
    
    void startHole();
    
    boolean triangulate();
}
