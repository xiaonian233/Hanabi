package ClassSub;

public final class Class148
{
    private int chunkX;
    private int chunkZ;
    byte[] topLayerData;
    
    private Class148(final byte[] topLayerData) {
        super();
        this.topLayerData = new byte[256];
        this.topLayerData = topLayerData;
    }
    
    private static int getChunkX() {
        return 0;
    }
    
    private static int getChunkZ() {
        return 0;
    }
    
    private byte[] getTopLayerData() {
        return this.topLayerData;
    }
    
    private void setTopLayerData(final byte[] topLayerData) {
        this.topLayerData = topLayerData;
    }
}
