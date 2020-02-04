package org.spongepowered.asm.util;

import com.google.common.base.*;
import java.util.regex.*;
import org.apache.logging.log4j.*;
import java.io.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class PrettyPrinter
{
    private final HorizontalRule horizontalRule;
    private final List<Object> lines;
    public Table table;
    public boolean recalcWidth;
    protected int width;
    private int wrapWidth;
    private int kvKeyWidth;
    protected String kvFormat;
    private static final String[] lllIlllIIl;
    
    public PrettyPrinter() {
        this(100);
    }
    
    public PrettyPrinter(final int width) {
        super();
        this.horizontalRule = new HorizontalRule(new char[] { '*' });
        this.lines = new ArrayList<Object>();
        this.recalcWidth = false;
        this.width = 100;
        this.wrapWidth = 80;
        this.kvKeyWidth = 10;
        this.kvFormat = makeKvFormat(this.kvKeyWidth);
        this.width = width;
    }
    
    private PrettyPrinter wrapTo(final int wrapWidth) {
        this.wrapWidth = wrapWidth;
        return this;
    }
    
    private int wrapTo() {
        return this.wrapWidth;
    }
    
    private PrettyPrinter table() {
        this.table = new Table();
        return this;
    }
    
    private PrettyPrinter table(final String... array) {
        this.table = new Table();
        for (int length = array.length, i = 0; i < length; ++i) {
            this.table.addColumn(array[i]);
        }
        return this;
    }
    
    public final PrettyPrinter table(final Object... array) {
        this.table = new Table();
        Column column = null;
        for (int length = array.length, i = 0; i < length; ++i) {
            final Object o;
            if ((o = array[i]) instanceof String) {
                column = this.table.addColumn((String)o);
            }
            else if (o instanceof Integer && column != null) {
                final int intValue;
                if ((intValue = (int)o) > 0) {
                    column.setWidth(intValue);
                }
                else if (intValue < 0) {
                    final Column column2 = column;
                    final int n = -intValue;
                    final Column column3 = column2;
                    column2.size = Math.min(column2.size, column3.maxWidth);
                    column3.maxWidth = Math.max(1, n);
                    column3.updateFormat();
                }
            }
            else if (o instanceof Alignment && column != null) {
                final Column column4 = column;
                final Alignment align = (Alignment)o;
                final Column column5 = column4;
                column4.align = align;
                column5.updateFormat();
            }
            else if (o != null) {
                column = this.table.addColumn(o.toString());
            }
        }
        return this;
    }
    
    private PrettyPrinter spacing(final int n) {
        if (this.table == null) {
            this.table = new Table();
        }
        final Table table;
        (table = this.table).colSpacing = Math.max(0, n);
        table.updateFormat();
        return this;
    }
    
    private PrettyPrinter th() {
        return this.th(false);
    }
    
    public final PrettyPrinter th(final boolean b) {
        if (this.table == null) {
            this.table = new Table();
        }
        if (!b || this.table.addHeader) {
            this.table.addHeader = false;
            this.addLine(this.table);
        }
        return this;
    }
    
    private PrettyPrinter tr(final Object... array) {
        this.th(true);
        final Table table = this.table;
        final Row row = new Row(table, array);
        table.rows.add(row);
        this.addLine(row);
        this.recalcWidth = true;
        return this;
    }
    
    public final PrettyPrinter add() {
        this.addLine(PrettyPrinter.lllIlllIIl[0]);
        return this;
    }
    
    public final PrettyPrinter add(final String s) {
        this.addLine(s);
        this.width = Math.max(this.width, s.length());
        return this;
    }
    
    public final PrettyPrinter add(String format, final Object... array) {
        format = String.format(format, array);
        this.addLine(format);
        this.width = Math.max(this.width, format.length());
        return this;
    }
    
    private PrettyPrinter add(final Object[] array) {
        return this.add(array, PrettyPrinter.lllIlllIIl[1]);
    }
    
    private PrettyPrinter add(final Object[] array, final String s) {
        for (int length = array.length, i = 0; i < length; ++i) {
            this.add(s, array[i]);
        }
        return this;
    }
    
    private PrettyPrinter addIndexed(final Object[] array) {
        final String value = String.valueOf(new StringBuilder().append(PrettyPrinter.lllIlllIIl[2]).append(String.valueOf(array.length - 1).length()).append(PrettyPrinter.lllIlllIIl[3]));
        for (int i = 0; i < array.length; ++i) {
            this.add(value, i, array[i]);
        }
        return this;
    }
    
    private PrettyPrinter addWithIndices(final Collection<?> collection) {
        final Object[] array = collection.toArray();
        final String value = String.valueOf(new StringBuilder().append(PrettyPrinter.lllIlllIIl[2]).append(String.valueOf(array.length - 1).length()).append(PrettyPrinter.lllIlllIIl[3]));
        for (int i = 0; i < array.length; ++i) {
            this.add(value, i, array[i]);
        }
        return this;
    }
    
    public final PrettyPrinter add(final IPrettyPrintable prettyPrintable) {
        if (prettyPrintable != null) {
            prettyPrintable.print(this);
        }
        return this;
    }
    
    private PrettyPrinter add(final Throwable t) {
        return this.add(t, 4);
    }
    
    public final PrettyPrinter add(Throwable cause, final int n) {
        while (cause != null) {
            this.add(PrettyPrinter.lllIlllIIl[4], cause.getClass().getName(), cause.getMessage());
            this.add(cause.getStackTrace(), n);
            cause = cause.getCause();
        }
        return this;
    }
    
    private PrettyPrinter add(final StackTraceElement[] array, final int n) {
        final String repeat = Strings.repeat(PrettyPrinter.lllIlllIIl[5], n);
        for (int length = array.length, i = 0; i < length; ++i) {
            this.add(PrettyPrinter.lllIlllIIl[6], repeat, array[i]);
        }
        return this;
    }
    
    private PrettyPrinter add(final Object o) {
        return this.append(o, 0, Strings.repeat(PrettyPrinter.lllIlllIIl[7], 0));
    }
    
    private PrettyPrinter add$7d7ac78(final Object o) {
        return this.append(o, 0, Strings.repeat(PrettyPrinter.lllIlllIIl[7], 0));
    }
    
    private PrettyPrinter append(final Object o, final int n, final String s) {
        if (o instanceof String) {
            return this.add(PrettyPrinter.lllIlllIIl[8], s, o);
        }
        if (o instanceof Iterable) {
            final Iterator<Object> iterator = ((Iterable)o).iterator();
            while (iterator.hasNext()) {
                this.append(iterator.next(), n, s);
            }
            return this;
        }
        if (o instanceof Map) {
            this.kvWidth(n);
            return this.add((Map<?, ?>)o);
        }
        if (o instanceof IPrettyPrintable) {
            return this.add((IPrettyPrintable)o);
        }
        if (o instanceof Throwable) {
            return this.add((Throwable)o, n);
        }
        if (o.getClass().isArray()) {
            return this.add((Object[])o, String.valueOf(new StringBuilder().append(n).append(PrettyPrinter.lllIlllIIl[9])));
        }
        return this.add(PrettyPrinter.lllIlllIIl[10], s, o);
    }
    
    public final PrettyPrinter addWrapped(final String s, final Object... array) {
        return this.addWrapped(this.wrapWidth, s, array);
    }
    
    public final PrettyPrinter addWrapped(int n, String replace, final Object... array) {
        String group = PrettyPrinter.lllIlllIIl[11];
        replace = String.format(replace, array).replace(PrettyPrinter.lllIlllIIl[12], PrettyPrinter.lllIlllIIl[13]);
        final Matcher matcher;
        if ((matcher = Pattern.compile(PrettyPrinter.lllIlllIIl[14]).matcher(replace)).matches()) {
            group = matcher.group(1);
        }
        final int n2 = n;
        final String s = replace;
        final String s2 = group;
        try {
            final String s3 = s2;
            String value = s;
            n = n2;
            final ArrayList<String> list = new ArrayList<String>();
            while (lIlIlllllIII(value.length(), n)) {
                int lastIndex;
                if ((lastIndex = value.lastIndexOf(32, n)) < 10) {
                    lastIndex = n;
                }
                list.add(value.substring(0, lastIndex));
                value = String.valueOf(new StringBuilder().append(s3).append(value.substring(lastIndex + 1)));
            }
            if (value.length() > 0) {
                list.add(value);
            }
            final Iterator<Object> iterator = list.iterator();
            while (iterator.hasNext()) {
                this.addLine(iterator.next());
            }
        }
        catch (Exception ex) {
            this.add(replace);
        }
        return this;
    }
    
    private static List<String> getWrapped(final int n, String value, final String s) {
        final ArrayList<String> list = new ArrayList<String>();
        while (lIlIlllllIII(value.length(), n)) {
            int lastIndex;
            if ((lastIndex = value.lastIndexOf(32, n)) < 10) {
                lastIndex = n;
            }
            list.add(value.substring(0, lastIndex));
            value = String.valueOf(new StringBuilder().append(s).append(value.substring(lastIndex + 1)));
        }
        if (value.length() > 0) {
            list.add(value);
        }
        return list;
    }
    
    public final PrettyPrinter kv(final String s, final String s2, final Object... array) {
        return this.kv(s, (Object)String.format(s2, array));
    }
    
    public final PrettyPrinter kv(final String s, final Object o) {
        this.addLine(new KeyValue(s, o));
        return this.kvWidth(s.length());
    }
    
    public final PrettyPrinter kvWidth(final int kvKeyWidth) {
        if (lIlIlllllIII(kvKeyWidth, this.kvKeyWidth)) {
            this.kvKeyWidth = kvKeyWidth;
            this.kvFormat = makeKvFormat(kvKeyWidth);
        }
        this.recalcWidth = true;
        return this;
    }
    
    private PrettyPrinter add(final Map<?, ?> map) {
        final Iterator<Map.Entry<Object, ?>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            final Object o;
            this.kv((((Map.Entry<Object, V>)(o = iterator.next())).getKey() == null) ? PrettyPrinter.lllIlllIIl[15] : ((Map.Entry<Object, V>)o).getKey().toString(), ((Map.Entry)o).getValue());
        }
        return this;
    }
    
    private PrettyPrinter hr() {
        return this.hr('*');
    }
    
    public final PrettyPrinter hr(final char c) {
        this.addLine(new HorizontalRule(new char[] { c }));
        return this;
    }
    
    public final PrettyPrinter centre() {
        if (!this.lines.isEmpty() && this.lines.get(this.lines.size() - 1) instanceof String) {
            this.addLine(new CentredText(this.lines.remove(this.lines.size() - 1)));
        }
        return this;
    }
    
    public final void addLine(final Object o) {
        if (o == null) {
            return;
        }
        this.lines.add(o);
        this.recalcWidth |= (o instanceof IVariableWidthEntry);
    }
    
    private PrettyPrinter trace() {
        return this.trace(System.err, LogManager.getLogger(getDefaultLoggerName()));
    }
    
    public final PrettyPrinter trace(final Level level) {
        return this.trace(getDefaultLoggerName(), level);
    }
    
    private PrettyPrinter trace(final String s) {
        return this.trace(System.err, LogManager.getLogger(s));
    }
    
    private PrettyPrinter trace(final String s, final Level level) {
        return this.trace(System.err, LogManager.getLogger(s), level);
    }
    
    private PrettyPrinter trace(final Logger logger) {
        return this.trace(System.err, logger);
    }
    
    private PrettyPrinter trace(final Logger logger, final Level level) {
        return this.trace(System.err, logger, level);
    }
    
    private PrettyPrinter trace(final PrintStream printStream) {
        return this.trace(printStream, LogManager.getLogger(getDefaultLoggerName()));
    }
    
    private PrettyPrinter trace(final PrintStream printStream, final Level level) {
        return this.trace(printStream, LogManager.getLogger(getDefaultLoggerName()), level);
    }
    
    private PrettyPrinter trace(final PrintStream printStream, final String s) {
        return this.trace(printStream, LogManager.getLogger(s));
    }
    
    private PrettyPrinter trace(final PrintStream printStream, final String s, final Level level) {
        return this.trace(printStream, LogManager.getLogger(s), level);
    }
    
    private PrettyPrinter trace(final PrintStream printStream, final Logger logger) {
        return this.trace(printStream, logger, Level.DEBUG);
    }
    
    private PrettyPrinter trace(final PrintStream printStream, final Logger logger, final Level level) {
        this.log(logger, level);
        this.print(printStream);
        return this;
    }
    
    private PrettyPrinter print() {
        return this.print(System.err);
    }
    
    public final PrettyPrinter print(final PrintStream printStream) {
        this.updateWidth();
        printSpecial(printStream, this.horizontalRule);
        final Iterator<ISpecialEntry> iterator = this.lines.iterator();
        while (iterator.hasNext()) {
            final ISpecialEntry next;
            if ((next = iterator.next()) instanceof ISpecialEntry) {
                printSpecial(printStream, next);
            }
            else {
                final String string = next.toString();
                if (string == null) {
                    continue;
                }
                printStream.printf(String.valueOf(new StringBuilder().append(PrettyPrinter.lllIlllIIl[17]).append(this.width).append(PrettyPrinter.lllIlllIIl[18])), string);
            }
        }
        printSpecial(printStream, this.horizontalRule);
        return this;
    }
    
    private static void printSpecial(final PrintStream printStream, final ISpecialEntry specialEntry) {
        printStream.printf(PrettyPrinter.lllIlllIIl[16], specialEntry.toString());
    }
    
    private void printString(final PrintStream printStream, final String s) {
        if (s != null) {
            printStream.printf(String.valueOf(new StringBuilder().append(PrettyPrinter.lllIlllIIl[17]).append(this.width).append(PrettyPrinter.lllIlllIIl[18])), s);
        }
    }
    
    private PrettyPrinter log(final Logger logger) {
        return this.log(logger, Level.INFO);
    }
    
    private PrettyPrinter log(final Logger logger, final Level level) {
        this.updateWidth();
        logSpecial(logger, level, this.horizontalRule);
        final Iterator<ISpecialEntry> iterator = this.lines.iterator();
        while (iterator.hasNext()) {
            final ISpecialEntry next;
            if ((next = iterator.next()) instanceof ISpecialEntry) {
                logSpecial(logger, level, next);
            }
            else {
                final String string = next.toString();
                if (string == null) {
                    continue;
                }
                logger.log(level, String.format(String.valueOf(new StringBuilder().append(PrettyPrinter.lllIlllIIl[20]).append(this.width).append(PrettyPrinter.lllIlllIIl[21])), string));
            }
        }
        logSpecial(logger, level, this.horizontalRule);
        return this;
    }
    
    private static void logSpecial(final Logger logger, final Level level, final ISpecialEntry specialEntry) {
        logger.log(level, PrettyPrinter.lllIlllIIl[19], new Object[] { specialEntry.toString() });
    }
    
    private void logString(final Logger logger, final Level level, final String s) {
        if (s != null) {
            logger.log(level, String.format(String.valueOf(new StringBuilder().append(PrettyPrinter.lllIlllIIl[20]).append(this.width).append(PrettyPrinter.lllIlllIIl[21])), s));
        }
    }
    
    private void updateWidth() {
        if (this.recalcWidth) {
            this.recalcWidth = false;
            final Iterator<IVariableWidthEntry> iterator = this.lines.iterator();
            while (iterator.hasNext()) {
                final IVariableWidthEntry next;
                if ((next = iterator.next()) instanceof IVariableWidthEntry) {
                    this.width = Math.min(4096, Math.max(this.width, next.getWidth()));
                }
            }
        }
    }
    
    private static String makeKvFormat(final int n) {
        return String.format(PrettyPrinter.lllIlllIIl[22], n);
    }
    
    private static String getDefaultLoggerName() {
        final String className;
        final int lastIndex;
        if ((lastIndex = (className = new Throwable().getStackTrace()[2].getClassName()).lastIndexOf(46)) == -1) {
            return className;
        }
        return className.substring(lastIndex + 1);
    }
    
    private static void dumpStack() {
        new PrettyPrinter().add(new Exception(PrettyPrinter.lllIlllIIl[23])).print(System.err);
    }
    
    private static void print(final Throwable t) {
        new PrettyPrinter().add(t, 4).print(System.err);
    }
    
    static {
        lIlIlIlIlIll();
    }
    
    private static void lIlIlIlIlIll() {
        (lllIlllIIl = new String[24])[0] = "";
        PrettyPrinter.lllIlllIIl[1] = "%s";
        PrettyPrinter.lllIlllIIl[2] = "[%";
        PrettyPrinter.lllIlllIIl[3] = "d] %s";
        PrettyPrinter.lllIlllIIl[4] = "%s: %s";
        PrettyPrinter.lllIlllIIl[5] = " ";
        PrettyPrinter.lllIlllIIl[6] = "%s%s";
        PrettyPrinter.lllIlllIIl[7] = " ";
        PrettyPrinter.lllIlllIIl[8] = "%s%s";
        PrettyPrinter.lllIlllIIl[9] = "%s";
        PrettyPrinter.lllIlllIIl[10] = "%s%s";
        PrettyPrinter.lllIlllIIl[11] = "";
        PrettyPrinter.lllIlllIIl[12] = "\t";
        PrettyPrinter.lllIlllIIl[13] = "    ";
        PrettyPrinter.lllIlllIIl[14] = "^(\\s+)(.*)$";
        PrettyPrinter.lllIlllIIl[15] = "null";
        PrettyPrinter.lllIlllIIl[16] = "/*%s*/\n";
        PrettyPrinter.lllIlllIIl[17] = "/* %-";
        PrettyPrinter.lllIlllIIl[18] = "s */\n";
        PrettyPrinter.lllIlllIIl[19] = "/*{}*/";
        PrettyPrinter.lllIlllIIl[20] = "/* %-";
        PrettyPrinter.lllIlllIIl[21] = "s */";
        PrettyPrinter.lllIlllIIl[22] = "%%%ds : %%s";
        PrettyPrinter.lllIlllIIl[23] = "Stack trace";
    }
    
    private static String lIlIlIIllIll(final String s, final String s2) {
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
    
    private static String lIlIlIIlllIl(final String s, final String s2) {
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
    
    private static String lIlIlIlIIlII(String s, final String s2) {
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
    
    private static boolean lIlIlllllIII(final int n, final int n2) {
        return n > n2;
    }
    
    private static boolean lIlIllllIllI(final int n) {
        return n < 0;
    }
    
    private static boolean lIlIllllIlIl(final int n) {
        return n > 0;
    }
}
