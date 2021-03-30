


import java.util.concurrent.*;

public class RandomBounds
{
    public static void main(String[] args)
    {
        timedAbort(3, "timedAbort end");
        switch(args.length == 0 ? "" : args[0])
        {
        case "lower":
            while(Math.random() != 0.0)
                ; // Keep trying
            System.out.println("Produced 0.0!");
            break;
        case "upper":
            while(Math.random() != 1.0)
                ; // Keep trying
            System.out.println("Produced 1.0!");
            break;
        default:
            System.out.println("Usage:");
            System.out.println("\tRandomBounds lower");
            System.out.println("\tRandomBounds upper");
            System.exit(1);
        }
    }

    public static CompletableFuture<Void> timedAbort(double t, String msg)
    {
        return CompletableFuture.runAsync(() ->
        {
            try
            {
                System.out.println("begin");
                TimeUnit.MILLISECONDS.sleep((int)(1000 * t));
            }
            catch(InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println(msg);
            System.exit(0);
        });
    }

}
