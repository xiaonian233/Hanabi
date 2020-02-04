package ClassSub;

import java.awt.font.*;
import java.awt.image.*;
import java.util.*;
import java.lang.invoke.*;
import java.nio.*;
import java.awt.*;

public final class Class301
{
    private static final Class79 GL;
    private static int MAX_GLYPH_SIZE;
    private static ByteBuffer scratchByteBuffer;
    private static IntBuffer scratchIntBuffer;
    private static BufferedImage scratchImage;
    private static Graphics2D scratchGraphics;
    public static FontRenderContext renderContext;
    private final Class48 unicodeFont;
    private final int pageWidth;
    private final int pageHeight;
    final Class85 pageImage;
    private int pageX;
    private int pageY;
    private int rowHeight;
    private boolean orderAscending;
    private final List pageGlyphs;
    private static final long a;
    
    public static Graphics2D getScratchGraphics() {
        return Class301.scratchGraphics;
    }
    
    public Class301(final Class48 unicodeFont, final int pageWidth, final int pageHeight) throws Class119 {
        super();
        this.pageGlyphs = new ArrayList(32);
        this.unicodeFont = unicodeFont;
        this.pageWidth = pageWidth;
        this.pageHeight = pageHeight;
        this.pageImage = new Class85(pageWidth, pageHeight);
    }
    
    public final int loadGlyphs(final List list, final int n) throws Class119 {
        final int[] b = Class139.b();
        final int rowHeight = this.rowHeight;
        Label_0189: {
            if (b == null) {
                if (rowHeight != 0) {
                    if (b != null) {
                        break Label_0189;
                    }
                    if (n == -1) {
                        int pageX = this.pageX;
                        int pageY = this.pageY;
                        int rowHeight2 = this.rowHeight;
                        final Iterator iterator = this.getIterator(list);
                        while (iterator.hasNext()) {
                            final Class262 class262;
                            final short width = (class262 = iterator.next()).width;
                            final short height = class262.height;
                            final short n5;
                            int n4;
                            int n3;
                            final int n2 = n3 = (n4 = (n5 = (short)(pageX + width)));
                            if (b != null) {
                                break Label_0189;
                            }
                            int pageWidth2;
                            int pageWidth;
                            final int n6 = pageWidth = (pageWidth2 = this.pageWidth);
                            Label_0152: {
                                Label_0143: {
                                    if (b == null) {
                                        if (lllIIllIIlI(n2, n6)) {
                                            pageX = 0;
                                            pageY += rowHeight2;
                                            rowHeight2 = height;
                                            if (b == null) {
                                                break Label_0143;
                                            }
                                        }
                                        final short n7;
                                        n3 = (n7 = (short)(n4 = height));
                                        final int n8;
                                        pageWidth = (n8 = (pageWidth2 = rowHeight2));
                                    }
                                    if (b != null) {
                                        break Label_0152;
                                    }
                                    if (lllIIllIlII(n2, n6)) {
                                        rowHeight2 = height;
                                    }
                                }
                                n4 = (n3 = pageY + rowHeight2);
                                pageWidth2 = (pageWidth = this.pageWidth);
                            }
                            if (b == null) {
                                if (lllIIllIIlI(n3, pageWidth)) {
                                    return 0;
                                }
                                n4 = pageX;
                                pageWidth2 = width;
                            }
                            pageX = n4 + pageWidth2;
                            if (b != null) {
                                break;
                            }
                        }
                    }
                }
                Class286.white.bind();
                this.pageImage.bind();
            }
        }
        int n9 = rowHeight;
        final Iterator iterator2 = this.getIterator(list);
    Label_0505_Outer:
        while (iterator2.hasNext()) {
            final Class262 class263 = iterator2.next();
            final int min = Math.min(256, class263.width);
            final int min2 = Math.min(256, class263.height);
            final int rowHeight3;
            int n12;
            int n11;
            final int n10 = n11 = (n12 = (rowHeight3 = this.rowHeight));
            if (b != null) {
                return rowHeight3;
            }
            Label_0686: {
                Class301 class268 = null;
                boolean orderAscending2 = false;
                int orderAscending = 0;
                Label_0667: {
                    int pageWidth3 = 0;
                    Label_0659: {
                        Label_0387: {
                            if (b == null) {
                                if (n10 == 0) {
                                    this.rowHeight = min2;
                                    if (b == null) {
                                        break Label_0387;
                                    }
                                }
                                final int n13;
                                n11 = (n13 = (n12 = this.pageX + min));
                            }
                            final int n14 = pageWidth3 = this.pageWidth;
                            if (b == null) {
                                if (lllIIllIIlI(n10, n14)) {
                                    Class301 class264 = this;
                                    if (b == null) {
                                        if (lllIIllIIlI(this.pageY + this.rowHeight + min2, this.pageHeight)) {
                                            break;
                                        }
                                        this.pageX = 0;
                                        this.pageY += this.rowHeight;
                                        class264 = this;
                                    }
                                    class264.rowHeight = min2;
                                    if (b == null) {
                                        break Label_0387;
                                    }
                                }
                                n12 = (n11 = min2);
                                final int rowHeight4;
                                pageWidth3 = (rowHeight4 = this.rowHeight);
                            }
                            if (b != null) {
                                break Label_0659;
                            }
                            if (lllIIllIlII(n11, n14)) {
                                Class301 class265 = this;
                                if (b == null) {
                                    if (lllIIllIIlI(this.pageY + min2, this.pageHeight)) {
                                        break;
                                    }
                                    class265 = this;
                                }
                                class265.rowHeight = min2;
                            }
                        }
                        final Class262 class266 = class263;
                        final int n15 = min;
                        final int n16 = min2;
                        final int n17 = n15;
                        final Class262 class267 = class266;
                        Class301.scratchGraphics.setComposite(AlphaComposite.Clear);
                        Class301.scratchGraphics.fillRect(0, 0, 256, 256);
                        Class301.scratchGraphics.setComposite(AlphaComposite.SrcOver);
                        Class301.scratchGraphics.setColor(Color.white);
                        final int[] b2 = Class139.b();
                        final Iterator iterator3 = this.unicodeFont.effects.iterator();
                        final int[] array = b2;
                        while (true) {
                            while (iterator3.hasNext()) {
                                iterator3.next().draw$6279793e(Class301.scratchGraphics, class267);
                                if (array != null) {
                                    final WritableRaster raster = Class301.scratchImage.getRaster();
                                    final int[] array2 = new int[n17];
                                    int i = 0;
                                    while (true) {
                                        while (i < n16) {
                                            raster.getDataElements(0, i, n17, 1, array2);
                                            Class301.scratchIntBuffer.put(array2);
                                            ++i;
                                            if (array == null) {
                                                if (array != null) {
                                                    break;
                                                }
                                                continue Label_0505_Outer;
                                            }
                                            else {
                                                this.pageGlyphs.add(class263);
                                                class268 = this;
                                                final int pageX2 = orderAscending = ((orderAscending2 = (this.pageX + min != 0)) ? 1 : 0);
                                                if (b == null) {
                                                    this.pageX = pageX2;
                                                    iterator2.remove();
                                                    n12 = ++n9;
                                                    pageWidth3 = n;
                                                    break Label_0659;
                                                }
                                                break Label_0667;
                                            }
                                        }
                                        Class301.GL.glTexSubImage2D$57066784(this.pageX, this.pageY, n17, n16, Class301.scratchByteBuffer);
                                        Class301.scratchIntBuffer.clear();
                                        class267.image = this.pageImage.getSubImage(this.pageX, this.pageY, n17, n16);
                                        continue;
                                    }
                                }
                                if (array != null) {
                                    break;
                                }
                            }
                            class267.shape = null;
                            continue;
                        }
                    }
                    if (n12 != pageWidth3) {
                        break Label_0686;
                    }
                    class268 = this;
                    orderAscending2 = ((orderAscending = (this.orderAscending ? 1 : 0)) != 0);
                }
                if (b == null) {
                    if (orderAscending == 0) {
                        orderAscending2 = true;
                    }
                    else {
                        orderAscending2 = false;
                    }
                }
                class268.orderAscending = orderAscending2;
                if (b == null) {
                    break;
                }
            }
            if (b != null) {
                break;
            }
        }
        Class154.bindNone();
        final boolean orderAscending3 = this.orderAscending;
        if (b == null && orderAscending3) {}
        this.orderAscending = orderAscending3;
        return n9;
    }
    
    private void renderGlyph(final Class262 class262, final int n, final int n2) throws Class119 {
        Class301.scratchGraphics.setComposite(AlphaComposite.Clear);
        Class301.scratchGraphics.fillRect(0, 0, 256, 256);
        Class301.scratchGraphics.setComposite(AlphaComposite.SrcOver);
        Class301.scratchGraphics.setColor(Color.white);
        final int[] b = Class139.b();
        final Iterator<Class2> iterator = (Iterator<Class2>)this.unicodeFont.effects.iterator();
        final int[] array = b;
        while (true) {
            while (iterator.hasNext()) {
                iterator.next().draw$6279793e(Class301.scratchGraphics, class262);
                if (array != null) {
                    final WritableRaster raster = Class301.scratchImage.getRaster();
                    final int[] array2 = new int[n];
                    int i = 0;
                    while (i < n2) {
                        raster.getDataElements(0, i, n, 1, array2);
                        Class301.scratchIntBuffer.put(array2);
                        ++i;
                        if (array != null) {
                            return;
                        }
                        if (array != null) {
                            break;
                        }
                    }
                    Class301.GL.glTexSubImage2D$57066784(this.pageX, this.pageY, n, n2, Class301.scratchByteBuffer);
                    Class301.scratchIntBuffer.clear();
                    class262.image = this.pageImage.getSubImage(this.pageX, this.pageY, n, n2);
                    return;
                }
                if (array != null) {
                    break;
                }
            }
            class262.shape = null;
            continue;
        }
    }
    
    private Iterator getIterator(final List list) {
        if (this.orderAscending) {
            return list.iterator();
        }
        return new Class189(list.listIterator(list.size()));
    }
    
    private List getGlyphs() {
        return this.pageGlyphs;
    }
    
    private Class85 getImage() {
        return this.pageImage;
    }
    
    static {
        Class169.a(2036322900757568413L, 6048862892950722207L, MethodHandles.lookup().lookupClass()).a(66422429542839L);
        GL = Class110.get();
        (Class301.scratchByteBuffer = ByteBuffer.allocateDirect(262144)).order(ByteOrder.LITTLE_ENDIAN);
        Class301.scratchIntBuffer = Class301.scratchByteBuffer.asIntBuffer();
        (Class301.scratchGraphics = (Graphics2D)(Class301.scratchImage = new BufferedImage(256, 256, 2)).getGraphics()).setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        Class301.scratchGraphics.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        Class301.scratchGraphics.setRenderingHint(RenderingHints.KEY_FRACTIONALMETRICS, RenderingHints.VALUE_FRACTIONALMETRICS_ON);
        Class301.renderContext = Class301.scratchGraphics.getFontRenderContext();
    }
    
    private static Exception a(final Exception ex) {
        return ex;
    }
    
    private static boolean lllIIllIIlI(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lllIIllIlII(final int n, final int n2) {
        return n > n2;
    }
}
