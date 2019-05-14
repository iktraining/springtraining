package com.example.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
//参照ライブラリの中になかったため手動でorg.aspectj.langのjarファイルを入れた
//http://www.java2s.com/Code/Jar/a/Downloadaspectjrt1611jar.htm

import com.example.aop.business.domain.Product;

@Aspect
@Component
public class MyFirstAspect {
	@Before("execution(* findProduct(String))")
	public void before(JoinPoint jp) {
		System.out.println("Hello Before! *** メソッドが呼ばれる前に出てくるよ");
		Signature sig = jp.getSignature();
		System.out.println("----> メソッド名を取得 : "+sig.getName());
		Object[] o = jp.getArgs();
		System.out.println("----> 仮引数の値を取得する : "+ o[0]);
	}

	@After("execution(* findProduct(String))")
	public void after() {
		System.out.println("Hello After! *** メソッドが呼ばれた後に出てくるよ");
	}

	@AfterReturning(value = "execution(* findProduct(String))", returning = "product")
	public void afterReturning(JoinPoint jp, Product product) {
		System.out.println("Hello AfterReterning! *** メソッドを呼んだ後に出てくるよ");
		Signature sig = jp.getSignature();
		System.out.println("----> メソッド名を取得する : "+ sig.getName());
		Object[] o = jp.getArgs();
		System.out.println("----> 仮引数の値を取得する : "+ o[0]);
	}

	@Around("execution(* findProduct(String))")
	public Product around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("Hello Around! before *** メソッドを呼ぶ前に出てくるよ");

		Signature sig = pjp.getSignature();
		System.out.println("----> aop:around メソッド名を取得する : "+ sig.getName());
		Product p = (Product)pjp.proceed();
		System.out.println("Hello Around! after *** メソッドを呼んだ後に出てくるよ");
		return p;
	}

	@AfterThrowing(value = "execution(* findByProductName(String))", throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("Hello Throwing! *** 例外になったら出てくるよ");
		System.out.println("exception value = "+ ex.toString());
	}
}
