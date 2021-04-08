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

# 💻STUDY

### JAVA

- `java.util.Optional<T>` : Integer나 Double 클래스처럼 'T'타입의 객체를 포장해 주는 래퍼 클래스(Wrapper class)입니다. 따라서 Optional 인스턴스는 모든 타입의 참조 변수를 저장할 수 있습니다. 이러한 Optional 객체를 사용하면 예상치 못한 NullPointerException 예외를 제공되는 메소드로 간단히 회피할 수 있습니다.

      즉, *복잡한 조건문 없이도 널(null) 값으로 인해 발생하는 예외를 처리할 수 있게 됩니다.*

- `ConcurrentHashMap` : 검색과 갱신 전체에 걸쳐 Thread-Safe 함을 보장하면서도 높은 성능을 보장하는 HashMap 이다. HashMap처럼 기본적으로는 Hashtable 과 동일한 Spec을 제공한다. ConcurrentHashMap의 검색 작업(get 포함)은 Lock이 이루어지지 않으며 갱신 작업(put 및 remove 포함)과 동시에 수행 될 수 있다.

### JUnit 테스트

- `@AfterEach` : 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다. 이렇게 되면 다음 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있다. `@AfterEach` 를 사용하면 각 테스트가 종료될 때 마다 이 기능을 실행한다.

---

# 📢ISSUE

❓ Spring-Boot 에서 JAVA11을 선택하고 실제로 환경에서는 JAVA8을 사용중이면 오류발생

❓ SourceTree 사용시 SSL 인증서 오류 발생 → SourceTree 도구에서 SSL 인증서 받아서 적용