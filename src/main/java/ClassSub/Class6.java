package ClassSub;

final class Class6 extends Thread
{
    private Class70 this$0;
    
    Class6() {
        super();
    }
    
    @Override
    public final void run() {
        final long n = 50L;
        try {
            Thread.sleep(n);
        }
        catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        Class70.renderingValue = null;
    }
}
