# 🛠Spring 뿌시기🛠

### 프로젝트 환경

✔ Project: Gradle Project

✔ Spring Boot: 2.4.4

✔ Language: Java 11

✔ Packaging: Jar

✔ Dependencies: Spring Web, Thymeleaf

✔ Test: JUnit5

✔ IDE : Eclipse

---

## 💻STUDY

### 🔥Spring
- 스프링 빈을 등록하는 두가지 방법

  ✔컴포넌트 스캔과 자동 의존관계 생성 : @Controller, @Service, @Repository(@Component를 포함) 사용하고 
@Autowired로 의존성 주입, @SpringBootApplication(@Component Scan 포함)이 있는 패키지의 하위패키지에서 Component Scan한다.

  ✔자바 코드로 직접 스프링빈 등록하기  : SpringConfig를 만들어서 @Configuration으로 직접 구현한다. @Bean을 사용해 스프링빈을 등록한다.
@Controller는 사용해야한다.
  
  
         DI 인젝션하는 법에는 필드주입, 생성자 주입, Setter주입이 있다. 
  *의존관계가 실행중에 동적으로 변하는 경우는 없으므로 생성자 주입을 추천*

- Web 기능 : @Controller가 있을경우 정적파일보다 먼저 확인

### 🔥JAVA

- `java.util.Optional<T>` : “존재할 수도 있지만 안 할 수도 있는 객체”, 즉, “null이 될 수도 있는 객체”을 감싸고 있는 일종의 래퍼 클래스입니다. 따라서 Optional 인스턴스는 모든 타입의 참조 변수를 저장할 수 있습니다. 이러한 Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 제공되는 메소드로 간단히 회피할 수 있습니다.
      즉, *복잡한 조건문 없이도 널(null) 값으로 인해 발생하는 예외를 처리할 수 있게 됩니다.*

- `Optional.ofNullable(value)` : null인지 아닌지 확신할 수 없는 객체를 담고 있는 Optional 객체를 생성합니다.
- `Optional.ifPresent(Consumer<? super T> consumer)`: 이 메소드는 특정 결과를 반환하는 대신에 Optional 객체가 감싸고 있는 값이 존재할 경우에만 실행될 로직을 함수형 인자로 넘길 수 있습니다.
- `ConcurrentHashMap` : 검색과 갱신 전체에 걸쳐 Thread-Safe 함을 보장하면서도 높은 성능을 보장하는 HashMap 이다. HashMap처럼 기본적으로는 Hashtable 과 동일한 Spec을 제공한다. ConcurrentHashMap의 검색 작업(get 포함)은 Lock이 이루어지지 않으며 갱신 작업(put 및 remove 포함)과 동시에 수행 될 수 있다.

### 🔥JUnit 테스트

- `@AfterEach` : 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다. 이렇게 되면 다음 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있다. `@AfterEach` 를 사용하면 각 테스트가 종료될 때 마다 이 기능을 실행한다.

---

## 📢ISSUE

❓ Spring-Boot 에서 JAVA11을 선택하고 실제로 환경에서는 JAVA8을 사용중이면 오류발생

❓ SourceTree 사용시 SSL 인증서 오류 발생 → SourceTree 도구에서 SSL 인증서 받아서 적용