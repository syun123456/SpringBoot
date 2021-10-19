package com.syun.pojo;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties(prefix= "person") //跟配置文件中的person物件綁定，要在pom.xml加入依賴(spring-boot-configuration-processor)
//@Validated  JSR-303，用來驗證賦予的數值是否符合規定
public class Person {
	
	//@Value("${name}") 從yaml配置文件取得值
	//@Email() 需搭配@Validated使用，表示name須符合Email格式，要導入依賴
	private String name;
	private Integer age;
	private Boolean happy;
	private Date birth;
	private Map<String, Object> maps;
	private List<Object> lists;
	private Dog dog;
	
	public Person() {
		
	}
	
	public Person(String name, Integer age, Boolean happy, Date birth, Map<String, Object> maps, List<Object> lists,
			Dog dog) {
		super();
		this.name = name;
		this.age = age;
		this.happy = happy;
		this.birth = birth;
		this.maps = maps;
		this.lists = lists;
		this.dog = dog;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Boolean getHappy() {
		return happy;
	}
	public void setHappy(Boolean happy) {
		this.happy = happy;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public Map<String, Object> getMaps() {
		return maps;
	}
	public void setMaps(Map<String, Object> maps) {
		this.maps = maps;
	}
	public List<Object> getLists() {
		return lists;
	}
	public void setLists(List<Object> lists) {
		this.lists = lists;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", happy=" + happy + ", birth=" + birth + ", maps=" + maps
				+ ", lists=" + lists + ", dog=" + dog + "]";
	}

}
