package cn.puhy.reactor;

import org.junit.Test;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

/**
 * @author PUHY
 * 2018-10-11 21:39
 */
public class ReactorDemo {

    @Test
    public void fluxJustTest() {
        // 发射一段数据
        Flux.just(3, 2, 1).subscribe(System.out::println);
    }

    @Test
    public void fluxIntervalTest() throws InterruptedException {
        // 每隔一定时间，发射一个数据
        Flux.interval(Duration.of(500, ChronoUnit.MILLIS)).subscribe(System.out::println);
        //防止程序过早退出，放一个CountDownLatch拦住
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }

    @Test
    public void fluxEmptyTest() {
        Flux.empty().subscribe(System.out::println);
    }

    @Test
    public void fluxGenerateTest() {
        Flux.generate(i -> {
            i.next("AAAAA");
            //i.next("BBBBB");//注意generate中next只能调用1次
            i.complete();
        }).subscribe(System.out::println);

        final Random rnd = new Random();
        Flux.generate(ArrayList::new, (list, item) -> {
            Integer value = rnd.nextInt(100);
            list.add(value);
            item.next(value);
            if (list.size() >= 10) {
                // 完成，相当于终止
                item.complete();
            }
            return list;
        }).subscribe(System.out::println);
    }

    @Test
    public void fluxCreateTest() {
        // next没有调用次数限制
        Flux.create(i -> {
            i.next("A");
            i.next("B");
            i.complete();
        }).subscribe(System.out::println);

        Flux.create(item -> {
            for (int i = 0; i < 10; i++) {
                item.next(i);
            }
        }).subscribe(System.out::println);
    }

    @Test
    public void fluxBufferTest() throws InterruptedException {
        // 缓存3个数据再发射
        Flux.range(0, 10).buffer(3).subscribe(System.out::println);

        System.out.println("--------------");
        // 每隔1秒，产生1个递增数字，而缓冲区每2秒才算充满，相当于每凑足2个数字后，才输出
        Flux.interval(Duration.of(1, ChronoUnit.SECONDS))
                .bufferTimeout(2, Duration.of(2, ChronoUnit.SECONDS))
                .subscribe(System.out::println);

        //防止程序过早退出，放一个CountDownLatch拦住
        CountDownLatch latch = new CountDownLatch(1);
        latch.await();
    }

    @Test
    public void fluxFilterTest() {
        // 过滤
        Flux.range(0, 10).filter(c -> c % 2 == 0).subscribe(System.out::println);
    }

    @Test
    public void fluxZipTest() {
        // 按位合并
        Flux.just("A", "B", "C").zipWith(Flux.just("1", "2", "3")).subscribe(System.out::println);
    }

    @Test
    public void fluxTakeTest() {
        // take前n个
        Flux.range(1, 10).take(3).subscribe(System.out::println);
        System.out.println("--------------");
        Flux.range(1, 10).takeLast(3).subscribe(System.out::println);
        System.out.println("--------------");
        Flux.range(1, 10).takeWhile(c -> c > 1 && c < 5).subscribe(System.out::println);
        System.out.println("--------------");
        Flux.range(1, 10).takeUntil(c -> c > 1 && c < 5).subscribe(System.out::println);
        System.out.println("--------------");
        Flux.range(1, 4).takeUntilOther(Flux.never()).subscribe(System.out::println);
    }
}
