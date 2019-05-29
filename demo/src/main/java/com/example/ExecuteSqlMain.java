package com.example;

import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class ExecuteSqlMain {
	public static void main(String[] args) {
		//Create Spring Container
		//define xmlfile
		ApplicationContext ctx = new ClassPathXmlApplicationContext("com/example/config/spring-db.xml");

		//Get the Template objects
		JdbcTemplate jdbcTemplate = ctx.getBean(JdbcTemplate.class);
		NamedParameterJdbcTemplate nameParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);

		//selct文 domainへ変更しない場合
		//queryForInt
		int count = jdbcTemplate.queryForObject("select count(*) from pet", Integer.class);
		System.out.println(count);

		String ownerName = "東京太郎";
		count = jdbcTemplate.queryForObject(
				"select count(*) from pet where owner_name=?", Integer.class, ownerName);
		System.out.println(count);

		//queryForObject
		int id = 1;
		String petName = jdbcTemplate.queryForObject(
				"select pet_name from pet where pet_id=?", String.class, id);
		System.out.println(petName);

		Date birthDate = jdbcTemplate.queryForObject(
				"select birth_date from pet where pet_id=?", Date.class, id);
		System.out.println(birthDate);

	}
}
