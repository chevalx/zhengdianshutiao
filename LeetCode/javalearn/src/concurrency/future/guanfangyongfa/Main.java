package concurrency.future.guanfangyongfa;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.*;

/**
 * Learn Java from https://www.liaoxuefeng.com/
 * 在调用get()时，如果异步任务已经完成，我们就直接获得结果。如果异步任务还没有完成，那么get()会阻塞，直到任务完成后才返回结果。
 * @author liaoxuefeng
 */
public class Main {
	public static void main(String[] args) throws Exception {
		ExecutorService es = Executors.newFixedThreadPool(4);
		Future<BigDecimal> future = es.submit(new Task("601857"));
		System.out.println(Thread.currentThread().getName() + " before get");
		System.out.println(Thread.currentThread().getName() + " " + future.get()); // 主线程在这里阻塞，直到异步任务完成
		System.out.println(Thread.currentThread().getName() + " after get");
		es.shutdown();
		// 执行结果
//		main before get
//		pool-1-thread-1
//		main 20.36
//		main after get
		System.out.println("=================================");
		ExecutorService es2 = Executors.newFixedThreadPool(4);
		Future<BigDecimal> future1 = es2.submit(new Task("601587"));
		System.out.println(Thread.currentThread().getName() + " before get");
		System.out.println(Thread.currentThread().getName() + " " + future1.get(5, TimeUnit.SECONDS));
		System.out.println(Thread.currentThread().getName() + " after get");
		es2.shutdown();
		//执行结果
//		main before get
//		pool-2-thread-1
//		Exception in thread "main" java.util.concurrent.TimeoutException
//		at java.util.concurrent.FutureTask.get(FutureTask.java:205)
//		at concurrency.future.guanfangyongfa.Main.main(Main.java:29)
	}
}

class Task implements Callable<BigDecimal> {

	public Task(String code) {
	}

	@Override
	public BigDecimal call() throws Exception {
		System.out.println(Thread.currentThread().getName());
		Thread.sleep(10000);
		double d = 5 + Math.random() * 20;
		return new BigDecimal(d).setScale(2, RoundingMode.DOWN);
	}
}
