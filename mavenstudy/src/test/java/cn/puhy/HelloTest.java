package cn.puhy;

import org.junit.*;

public class HelloTest {

    @Test
    public void sayHelloTest() {
        Hello hello = new Hello();
        Assert.assertEquals(hello.sayHello("puhy"), "hello puhy");
    }
}
