package cn.puhy.spring.spel;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class ScriptTest {

    public static void main(String[] args) throws ScriptException, NoSuchMethodException {

        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("JavaScript");
        String script = "function sum(a, b) { return a + b}";
        engine.eval(script);
        Invocable invocable = (Invocable) engine;
        Object result = invocable.invokeFunction("sum", 200, 100);
        System.out.println(result);
    }
}
