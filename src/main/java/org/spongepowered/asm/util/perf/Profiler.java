package org.spongepowered.asm.util.perf;

import com.google.common.base.*;
import org.spongepowered.asm.util.*;
import java.text.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class Profiler
{
    private static int ROOT;
    private static int FINE;
    private final Map<String, Section> sections;
    private final List<String> phases;
    private final Deque<Section> stack;
    private boolean active;
    private static final String[] lIllllIlIlI;
    
    public Profiler() {
        super();
        this.sections = new TreeMap<String, Section>();
        this.phases = new ArrayList<String>();
        this.stack = new LinkedList<Section>();
        this.phases.add(Profiler.lIllllIlIlI[0]);
    }
    
    public final void setActive(final boolean active) {
        if ((!this.active && active) || !active) {
            this.reset();
        }
        this.active = active;
    }
    
    private void reset() {
        final Iterator<Section> iterator = this.sections.values().iterator();
        while (iterator.hasNext()) {
            iterator.next().invalidate();
        }
        this.sections.clear();
        this.phases.clear();
        this.phases.add(Profiler.lIllllIlIlI[1]);
        this.stack.clear();
    }
    
    public final Section get(final String s) {
        Section section;
        if ((section = this.sections.get(s)) == null) {
            section = (this.active ? new LiveSection(s, this.phases.size() - 1) : new Section(s));
            this.sections.put(s, section);
        }
        return section;
    }
    
    private Section getSubSection(final String s, final String s2, final Section section) {
        Section section2;
        if ((section2 = this.sections.get(s)) == null) {
            section2 = new SubSection(s, this.phases.size() - 1, s2, section);
            this.sections.put(s, section2);
        }
        return section2;
    }
    
    private boolean isHead(final Section section) {
        return this.stack.peek() == section;
    }
    
    private Section begin(final String... array) {
        return this.begin$67bb2acd(array);
    }
    
    public final Section begin$67bb2acd(final String... array) {
        return this.begin(0, Joiner.on('.').join((Object[])array));
    }
    
    private Section begin(final String s) {
        return this.begin(0, s);
    }
    
    public final Section begin(int fine, String value) {
        boolean root = (fine & 0x1) != 0x0;
        fine = (((fine & 0x2) != 0x0) ? 1 : 0);
        String value2 = value;
        final Section section;
        if ((section = this.stack.peek()) != null) {
            value2 = String.valueOf(new StringBuilder().append(section.name).append(root ? Profiler.lIllllIlIlI[2] : Profiler.lIllllIlIlI[3]).append(value2));
            if (section.root && !root) {
                final int lastIndex = section.name.lastIndexOf(Profiler.lIllllIlIlI[4]);
                value = String.valueOf(new StringBuilder().append((lastIndex >= 0) ? section.name.substring(lastIndex + 4) : section.name).append(Profiler.lIllllIlIlI[5]).append(value));
                root = true;
            }
        }
        Section value3 = this.get(root ? value : value2);
        if (root && section != null && this.active) {
            final String s = value2;
            final String name = section.name;
            final Section section2 = value3;
            value = name;
            final String s2 = s;
            Section section3;
            if ((section3 = this.sections.get(s2)) == null) {
                section3 = new SubSection(s2, this.phases.size() - 1, value, section2);
                this.sections.put(s2, section3);
            }
            value3 = section3;
        }
        final Section section4;
        (section4 = value3).fine = (fine != 0);
        section4.root = root;
        this.stack.push(value3);
        return value3.start();
    }
    
    final void end(final Section section) {
        final Deque<Section> stack = this.stack;
        try {
            Section section3;
            final Section section2 = section3 = stack.pop();
            while (lIIIIIlIlIllI(section3, section)) {
                if (section3 == null && this.active) {
                    if (section2 == null) {
                        throw new IllegalStateException(String.valueOf(new StringBuilder().append(Profiler.lIllllIlIlI[6]).append(section).append(Profiler.lIllllIlIlI[7])));
                    }
                    throw new IllegalStateException(String.valueOf(new StringBuilder().append(Profiler.lIllllIlIlI[8]).append(section).append(Profiler.lIllllIlIlI[9]).append(section2)));
                }
                else {
                    section3 = this.stack.pop();
                }
            }
        }
        catch (NoSuchElementException ex) {
            if (this.active) {
                throw new IllegalStateException(String.valueOf(new StringBuilder().append(Profiler.lIllllIlIlI[10]).append(section).append(Profiler.lIllllIlIlI[11])));
            }
        }
    }
    
    public final void mark(final String s) {
        long n = 0L;
        final Iterator<Section> iterator = this.sections.values().iterator();
        while (iterator.hasNext()) {
            n += iterator.next().getTime();
        }
        if (n == 0L) {
            this.phases.set(this.phases.size() - 1, s);
            return;
        }
        this.phases.add(s);
        final Iterator<Section> iterator2 = this.sections.values().iterator();
        while (iterator2.hasNext()) {
            iterator2.next().mark();
        }
    }
    
    public final Collection<Section> getSections() {
        return Collections.unmodifiableCollection((Collection<? extends Section>)this.sections.values());
    }
    
    public final PrettyPrinter printer$10807035() {
        final PrettyPrinter prettyPrinter = new PrettyPrinter();
        final int n = this.phases.size() + 4;
        final int[] array = { 0, 1, 2, n - 2, n - 1 };
        final Object[] array2 = new Object[n * 2];
        int i = 0;
        int n2 = 0;
        while (i < n) {
            array2[n2 + 1] = PrettyPrinter.Alignment.RIGHT;
            if (i == array[0]) {
                array2[n2] = String.valueOf(new StringBuilder().append(Profiler.lIllllIlIlI[13]).append(Profiler.lIllllIlIlI[14]));
                array2[n2 + 1] = PrettyPrinter.Alignment.LEFT;
            }
            else if (i == array[1]) {
                array2[n2] = Profiler.lIllllIlIlI[15];
            }
            else if (i == array[3]) {
                array2[n2] = Profiler.lIllllIlIlI[16];
            }
            else if (i == array[4]) {
                array2[n2] = Profiler.lIllllIlIlI[17];
            }
            else if (i - array[2] < this.phases.size()) {
                array2[n2] = this.phases.get(i - array[2]);
            }
            else {
                array2[n2] = Profiler.lIllllIlIlI[18];
            }
            n2 = ++i * 2;
        }
        prettyPrinter.table(array2).th(false).hr('*').add();
        final Iterator<Section> iterator = this.sections.values().iterator();
        while (iterator.hasNext()) {
            final Section section;
            if (!(section = iterator.next()).fine) {
                printSectionRow$3bc33bc4(prettyPrinter, n, array, section);
            }
        }
        return prettyPrinter.add();
    }
    
    private static void printSectionRow$3bc33bc4(final PrettyPrinter prettyPrinter, final int n, final int[] array, final Section section) {
        final boolean liiiiIlIlIllI = lIIIIIlIlIllI(section.getDelegate(), section);
        final Object[] array2 = new Object[n];
        int n2 = 1;
        array2[0] = String.valueOf(new StringBuilder().append(liiiiIlIlIllI ? Profiler.lIllllIlIlI[20] : Profiler.lIllllIlIlI[21]).append(section.name));
        long[] times;
        for (int length = (times = section.getTimes()).length, i = 0; i < length; ++i) {
            final long n3 = times[i];
            if (n2 == array[1]) {
                array2[n2++] = String.valueOf(new StringBuilder().append(section.getTotalTime()).append(Profiler.lIllllIlIlI[22]));
            }
            if (n2 >= array[2] && n2 < array2.length) {
                array2[n2++] = String.valueOf(new StringBuilder().append(n3).append(Profiler.lIllllIlIlI[23]));
            }
        }
        array2[array[3]] = section.getTotalCount();
        array2[array[4]] = new DecimalFormat(Profiler.lIllllIlIlI[24]).format(section.getTotalAverageTime());
        for (int j = 0; j < array2.length; ++j) {
            if (array2[j] == null) {
                array2[j] = Profiler.lIllllIlIlI[25];
            }
        }
        prettyPrinter.th(true);
        final PrettyPrinter.Table table = prettyPrinter.table;
        final PrettyPrinter.Row row = new PrettyPrinter.Row(table, array2);
        table.rows.add(row);
        prettyPrinter.addLine(row);
        prettyPrinter.recalcWidth = true;
    }
    
    static {
        lIIIIIlIIIllI();
    }
    
    private static void lIIIIIlIIIllI() {
        (lIllllIlIlI = new String[26])[0] = "Initial";
        Profiler.lIllllIlIlI[1] = "Initial";
        Profiler.lIllllIlIlI[2] = " -> ";
        Profiler.lIllllIlIlI[3] = ".";
        Profiler.lIllllIlIlI[4] = " -> ";
        Profiler.lIllllIlIlI[5] = ".";
        Profiler.lIllllIlIlI[6] = "Attempted to pop ";
        Profiler.lIllllIlIlI[7] = " but the stack is empty";
        Profiler.lIllllIlIlI[8] = "Attempted to pop ";
        Profiler.lIllllIlIlI[9] = " which was not in the stack, head was ";
        Profiler.lIllllIlIlI[10] = "Attempted to pop ";
        Profiler.lIllllIlIlI[11] = " but the stack is empty";
        Profiler.lIllllIlIlI[12] = "";
        Profiler.lIllllIlIlI[13] = "  ";
        Profiler.lIllllIlIlI[14] = "Section";
        Profiler.lIllllIlIlI[15] = "    TOTAL";
        Profiler.lIllllIlIlI[16] = "    Count";
        Profiler.lIllllIlIlI[17] = "Avg. ";
        Profiler.lIllllIlIlI[18] = "";
        Profiler.lIllllIlIlI[19] = "  > ";
        Profiler.lIllllIlIlI[20] = "+ ";
        Profiler.lIllllIlIlI[21] = "  ";
        Profiler.lIllllIlIlI[22] = " ms";
        Profiler.lIllllIlIlI[23] = " ms";
        Profiler.lIllllIlIlI[24] = "   ###0.000 ms";
        Profiler.lIllllIlIlI[25] = "-";
    }
    
    private static String lIIIIIIllllII(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("Blowfish")).init(2, new SecretKeySpec(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), "Blowfish"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static String lIIIIIIlllIlI(String s, final String s2) {
        s = new String(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8)), StandardCharsets.UTF_8);
        final StringBuilder sb = new StringBuilder();
        final char[] charArray = s2.toCharArray();
        int n = 0;
        char[] charArray2;
        for (int length = (charArray2 = s.toCharArray()).length, i = 0; i < length; ++i) {
            sb.append((char)(charArray2[i] ^ charArray[n % charArray.length]));
            ++n;
        }
        return String.valueOf(sb);
    }
    
    private static String lIIIIIIlllIll(final String s, final String s2) {
        final String s3 = "MD5";
        try {
            final Cipher instance;
            (instance = Cipher.getInstance("DES")).init(2, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance(s3).digest(s2.getBytes(StandardCharsets.UTF_8)), 8), "DES"));
            return new String(instance.doFinal(Base64.getDecoder().decode(s.getBytes(StandardCharsets.UTF_8))), StandardCharsets.UTF_8);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    
    private static boolean lIIIIIlIllIll(final int n, final int n2) {
        return n >= n2;
    }
    
    private static boolean lIIIIIlIlIlIl$255f299(final int n) {
        return n >= 0;
    }
    
    private static boolean lIIIIIlIlIllI(final Object o, final Object o2) {
        return o != o2;
    }
    
    private static boolean lIIIIIlIlIIll(final Object o, final Object o2) {
        return o == o2;
    }
    
    private static int lIIIIIlIlIlll$2566aa8(final long n) {
        return lcmp(n, 0L);
    }
}
