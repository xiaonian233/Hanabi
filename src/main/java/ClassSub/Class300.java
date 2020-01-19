package ClassSub;

public class Class300
{
    private float[] matrixPosition;
    public static final boolean Cracked_By_Somebody_Dumped_BY_Ganga_SupportedbySucen;
    
    public Class300() {
        super();
        this.matrixPosition = new float[] { 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f };
    }
    
    public Class300(final Class300 class300) {
        super();
        this.matrixPosition = new float[9];
        for (int i = 0; i < 9; ++i) {
            this.matrixPosition[i] = class300.matrixPosition[i];
        }
    }
    
    public Class300(final Class300 class300, final Class300 class301) {
        this(class300);
        this.concatenate(class301);
    }
    
    public Class300(final float[] array) {
        super();
        if (array.length != 6) {
            throw new RuntimeException("The parameter must be a float array of length 6.");
        }
        this.matrixPosition = new float[] { array[0], array[1], array[2], array[3], array[4], array[5], 0.0f, 0.0f, 1.0f };
    }
    
    public Class300(final float n, final float n2, final float n3, final float n4, final float n5, final float n6) {
        super();
        this.matrixPosition = new float[] { n, n2, n3, n4, n5, n6, 0.0f, 0.0f, 1.0f };
    }
    
    public void transform(final float[] array, final int n, final float[] array2, final int n2, final int n3) {
        final float[] array3 = (array == array2) ? new float[n3 * 2] : array2;
        for (int i = 0; i < n3 * 2; i += 2) {
            for (int j = 0; j < 6; j += 3) {
                array3[i + j / 3] = array[i + n] * this.matrixPosition[j] + array[i + n + 1] * this.matrixPosition[j + 1] + 1.0f * this.matrixPosition[j + 2];
            }
        }
        if (array == array2) {
            for (int k = 0; k < n3 * 2; k += 2) {
                array2[k + n2] = array3[k];
                array2[k + n2 + 1] = array3[k + 1];
            }
        }
    }
    
    public Class300 concatenate(final Class300 class300) {
        final float[] matrixPosition = new float[9];
        final float n = this.matrixPosition[0] * class300.matrixPosition[0] + this.matrixPosition[1] * class300.matrixPosition[3];
        final float n2 = this.matrixPosition[0] * class300.matrixPosition[1] + this.matrixPosition[1] * class300.matrixPosition[4];
        final float n3 = this.matrixPosition[0] * class300.matrixPosition[2] + this.matrixPosition[1] * class300.matrixPosition[5] + this.matrixPosition[2];
        final float n4 = this.matrixPosition[3] * class300.matrixPosition[0] + this.matrixPosition[4] * class300.matrixPosition[3];
        final float n5 = this.matrixPosition[3] * class300.matrixPosition[1] + this.matrixPosition[4] * class300.matrixPosition[4];
        final float n6 = this.matrixPosition[3] * class300.matrixPosition[2] + this.matrixPosition[4] * class300.matrixPosition[5] + this.matrixPosition[5];
        matrixPosition[0] = n;
        matrixPosition[1] = n2;
        matrixPosition[2] = n3;
        matrixPosition[3] = n4;
        matrixPosition[4] = n5;
        matrixPosition[5] = n6;
        this.matrixPosition = matrixPosition;
        return this;
    }
    
    @Override
    public String toString() {
        return ("Transform[[" + this.matrixPosition[0] + "," + this.matrixPosition[1] + "," + this.matrixPosition[2] + "][" + this.matrixPosition[3] + "," + this.matrixPosition[4] + "," + this.matrixPosition[5] + "][" + this.matrixPosition[6] + "," + this.matrixPosition[7] + "," + this.matrixPosition[8] + "]]").toString();
    }
    
    public float[] getMatrixPosition() {
        return this.matrixPosition;
    }
    
    public static Class300 createRotateTransform(final float n) {
        return new Class300((float)Class165.cos(n), -(float)Class165.sin(n), 0.0f, (float)Class165.sin(n), (float)Class165.cos(n), 0.0f);
    }
    
    public static Class300 createRotateTransform(final float n, final float n2, final float n3) {
        final Class300 rotateTransform = createRotateTransform(n);
        final float n4 = rotateTransform.matrixPosition[3];
        final float n5 = 1.0f - rotateTransform.matrixPosition[4];
        rotateTransform.matrixPosition[2] = n2 * n5 + n3 * n4;
        rotateTransform.matrixPosition[5] = n3 * n5 - n2 * n4;
        return rotateTransform;
    }
    
    public static Class300 createTranslateTransform(final float n, final float n2) {
        return new Class300(1.0f, 0.0f, n, 0.0f, 1.0f, n2);
    }
    
    public static Class300 createScaleTransform(final float n, final float n2) {
        return new Class300(n, 0.0f, 0.0f, 0.0f, n2, 0.0f);
    }
    
    public Class271 transform(final Class271 class271) {
        final float[] array = { class271.x, class271.y };
        final float[] array2 = new float[2];
        this.transform(array, 0, array2, 0, 1);
        return new Class271(array2[0], array2[1]);
    }
}
