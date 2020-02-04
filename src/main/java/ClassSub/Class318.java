package ClassSub;

import java.lang.invoke.*;

public final class Class318
{
    private final int height;
    private final int width;
    private int posXCenter;
    private int posZCenter;
    private int posXStart;
    private int posZStart;
    private byte[] blockData;
    private static final long a;
    
    private Class318(final int n) {
        super();
        this.height = (1 + n * 2) * 16;
        this.width = (1 + n * 2) * 16;
        this.blockData = new byte[this.height * this.width];
    }
    
    private void fillInChunkData(final Class148 class148) {
        int n = Math.abs(0) + Math.abs(0);
        final int[] b = Class139.b();
        int n2 = 0;
        final byte[] topLayerData;
        final int length = (topLayerData = class148.topLayerData).length;
        final int[] array = b;
        int i = 0;
        while (i < length) {
            final byte b2 = topLayerData[i];
            if (array == null) {
                Label_0076: {
                    if (n2 != 0) {
                        final int n3 = n2 % 16;
                        if (array == null) {
                            if (n3 != 0) {
                                break Label_0076;
                            }
                            final int n4 = n + (this.width - 16);
                        }
                        n = n3;
                    }
                }
                this.blockData[n] = b2;
                ++n2;
                ++i;
            }
            if (array != null) {
                break;
            }
        }
    }
    
    private byte[] getBlockData() {
        return this.blockData;
    }
    
    static {
        Class169.a(1805889410443907801L, 2727030783507125020L, MethodHandles.lookup().lookupClass()).a(202734373849231L);
    }
    
    private static RuntimeException a(final RuntimeException ex) {
        return ex;
    }
}
