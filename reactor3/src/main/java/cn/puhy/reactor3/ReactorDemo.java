package cn.puhy.reactor3;

import org.junit.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
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
        // range(0,10) 生成从“1”开始的，自增为1的“6”个整型数据
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
        // takeLast后n个
        Flux.range(1, 10).takeLast(3).subscribe(System.out::println);
        System.out.println("--------------");
        // takeWhile 是先判断条件是否成立，然后再决定是否取元素
        Flux.range(1, 10).takeWhile(c -> c > 1 && c < 5).subscribe(System.out::println);
        System.out.println("--------------");
        // takeUntil 是先取元素，直到遇到条件成立，才停下
        Flux.range(1, 10).takeUntil(c -> c > 1 && c < 5).subscribe(System.out::println);
        System.out.println("--------------");
        // takeUntilOther 则是先取元素，直到别一个Flux序列产生元素
        Flux.range(1, 4).takeUntilOther(Flux.never()).subscribe(System.out::println);
    }

    @Test
    public void reduceTest() {
        // 把1到10累加求和
        Flux.range(1, 10).reduce((x, y) -> x + y).subscribe(System.out::println);
        // 先指定一个起始值10，然后在这个起始值基础上再累加
        Flux.range(1, 10).reduceWith(() -> 10, (x, y) -> x + y).subscribe(System.out::println);
    }

    @Test
    public void mergeTest() {
        // merge就是将把多个Flux按元素实际产生的顺序合并
        Flux.merge(Flux.interval(Duration.of(500, ChronoUnit.MILLIS)).take(5),
                Flux.interval(Duration.of(2000, ChronoUnit.MILLIS), Duration.of(500, ChronoUnit.MILLIS)).take(5))
                .toStream().forEach(System.out::println);

        System.out.println("-----------------------------");
        // mergeSequential是按多个Flux被订阅的顺序来合并
        Flux.mergeSequential(Flux.interval(Duration.of(500, ChronoUnit.MILLIS)).take(5),
                Flux.interval(Duration.of(600, ChronoUnit.MILLIS), Duration.of(500, ChronoUnit.MILLIS)).take(5))
                .toStream().forEach(System.out::println);
    }

    @Test
    public void combineLatestTest() {
        // 将所有流中的最新产生的元素合并成一个新的元素，作为返回结果流中的元素。只要其中任何一个流中产生了新的元素，合并操作就会被执行一次
        Flux.combineLatest(
                Arrays::toString,
                Flux.interval(Duration.of(10000, ChronoUnit.MILLIS)).take(3),
                Flux.just("A", "B"))
                .toStream().forEach(System.out::println);

        System.out.println("------------------");

        Flux.combineLatest(
                Arrays::toString,
                Flux.just(0, 1),
                Flux.just("A", "B"))
                .toStream().forEach(System.out::println);

        System.out.println("------------------");

        Flux.combineLatest(
                Arrays::toString,
                Flux.interval(Duration.of(1000, ChronoUnit.MILLIS)).take(2),
                Flux.interval(Duration.of(10000, ChronoUnit.MILLIS)).take(2))
                .toStream().forEach(System.out::println);
    }

    @Test
    public void firstTest() {
        // 只取第一个Flux的元素
        Flux.first(Flux.fromArray(new String[]{"A", "B"}),
                Flux.just(1, 2, 3))
                .subscribe(System.out::println);
    }

    @Test
    public void mapTest() {
        // 把一种类型的元素序列转换为另一种类型
        Flux.just('A', 'B', 'C').map(a -> (int) (a)).subscribe(System.out::println);
    }

    @Test
    public void subscribeTest1() {
        // 订阅错误消息
        Flux.just("A", "B", "C")
                .concatWith(Flux.error(new IndexOutOfBoundsException("下标越界啦！")))
                .subscribe(System.out::println, (str) -> System.out.println("错误：" + str));
    }

    @Test
    public void subscribeTest2() {
        // 遇到错误时，用其它指定值返回
        Flux.just("A", "B", "C")
                .concatWith(Flux.error(new IndexOutOfBoundsException("下标越界啦！")))
                .onErrorReturn("XX")
                .subscribe(System.out::println, System.err::println);
    }

    @Test
    public void subscribeTest3() {
        // 根据异常的类型，有选择性的处理返回值
        Flux.just("A", "B", "C")
                .concatWith(Flux.error(new IndexOutOfBoundsException("下标越界啦！")))
                .onErrorResume(e -> {
                    if (e instanceof IndexOutOfBoundsException) {
                        return Flux.just("X", "Y", "Z");
                    } else {
                        return Mono.empty();
                    }
                })
                .subscribe(System.out::println, System.err::println);
    }

    @Test
    public void subscribeTest4() {
        // 遇到异常，就重试
        Flux.just("A", "B", "C")
                .concatWith(Flux.error(new IndexOutOfBoundsException("下标越界啦！")))
                //重试1次
                .retry(1)
                .subscribe(System.out::println, System.err::println);
    }
}
