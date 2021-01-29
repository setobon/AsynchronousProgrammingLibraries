import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import models.Account;
import models.Response;
import org.checkerframework.checker.units.qual.A;
import services.impl.AutomaticCashierService;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        AutomaticCashierService automaticCashierService = new AutomaticCashierService();

        Account account = new Account(001, "1234567890", 1000000.0);
        double amount = 300000.0;


        ExecutorService threadPool = Executors.newCachedThreadPool();
        ListeningExecutorService service = MoreExecutors.listeningDecorator(threadPool);

        ListenableFuture<Response> guavaFuture = service.submit(
                ()->automaticCashierService.withdraw(account, amount));

        ListenableFuture<Response> guavaFuture2 = service.submit(
                ()->automaticCashierService.getBalanceOfAccount(account));

        Response result = guavaFuture.get();
        Response result2 = guavaFuture2.get();

        System.out.println("Transaction " + result );
        System.out.println("Balance " + result2 );

        threadPool.shutdown();



    }
}
