package cn.puhy.spring.transaction.annotationcfg;

import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//绑定到txManager1的事务管理器
@Transactional("txManager1")
public @interface TxManager1Transaction {

}
