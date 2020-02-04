package org.spongepowered.asm.mixin.transformer.debug;

import java.io.*;
import java.util.concurrent.*;
import javax.crypto.*;
import java.nio.charset.*;
import javax.crypto.spec.*;
import java.security.*;
import java.util.*;

public final class RuntimeDecompilerAsync extends RuntimeDecompiler implements Runnable, Thread.UncaughtExceptionHandler
{
    private final BlockingQueue<File> queue;
    private final Thread thread;
    private boolean run;
    private static final String[] lIlllllllIl;
    
    private RuntimeDecompilerAsync(final File file) {
        super(file);
        this.queue = new LinkedBlockingQueue<File>();
        this.run = true;
        (this.thread = new Thread(this, RuntimeDecompilerAsync.lIlllllllIl[0])).setDaemon(true);
        this.thread.setPriority(1);
        this.thread.setUncaughtExceptionHandler(this);
        this.thread.start();
    }
    
    @Override
    public final void decompile(final File file) {
        if (this.run) {
            this.queue.offer(file);
            return;
        }
        super.decompile(file);
    }
    
    @Override
    public final void run() {
        while (this.run) {
            try {
                final BlockingQueue<File> queue = this.queue;
                try {
                    super.decompile(queue.take());
                }
                catch (InterruptedException ex2) {
                    this.run = false;
                }
                continue;
            }
            catch (Exception ex) {
                ex.printStackTrace();
                continue;
            }
            break;
        }
    }
    
    @Override
    public final void uncaughtException(final Thread thread, final Throwable t) {
        this.logger.error(RuntimeDecompilerAsync.lIlllllllIl[1], new Object[] { t.getClass().getName(), t.getMessage() });
        this.run = false;
        File file;
        while ((file = this.queue.poll()) != null) {
            this.decompile(file);
        }
    }
    
    private void flush() {
        this.run = false;
        File file;
        while ((file = this.queue.poll()) != null) {
            this.decompile(file);
        }
    }
    
    static {
        lIIIIIlllIIlI();
    }
    
    private static void lIIIIIlllIIlI() {
        (lIlllllllIl = new String[2])[0] = "Decompiler thread";
        RuntimeDecompilerAsync.lIlllllllIl[1] = "Async decompiler encountered an error and will terminate. Further decompile requests will be handled synchronously. {} {}";
    }
    
    private static String lIIIIIllIIlIl(final String s, final String s2) {
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
}
