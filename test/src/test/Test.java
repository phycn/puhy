package test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
	public static void main(String[] args) {
		Test t = new Test();
		try {
			t.method1();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void method1() throws Exception {

		try {
			method2();
		} catch(Exception e) {
		    throw e;
		}

	}

	private void method2() throws Exception {
		throw new Exception("报错了！！！！");
	}
}


