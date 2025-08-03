## ✅ **1️⃣ Core Java Design Patterns**

**Creational Patterns**

* **Singleton** → `Runtime.getRuntime()`, Spring beans by default.
* **Factory Method** → `Calendar.getInstance()`.
* **Abstract Factory** → `DocumentBuilderFactory`, `SessionFactory` (Hibernate).
* **Builder** → `StringBuilder`, `StringBuffer`, `java.time.LocalDateTime` builder-like chaining.
* **Prototype** → `Object.clone()`.

**Structural Patterns**

* **Adapter** → `java.util.Arrays.asList()` (array → List).
* **Decorator** → `BufferedReader` wrapping `FileReader`.
* **Proxy** → `java.lang.reflect.Proxy` (dynamic proxies).
* **Composite** → `AWT`/`Swing` components (`Container` with child components).

**Behavioral Patterns**

* **Template Method** → `java.util.AbstractList` (`subList` etc.).
* **Observer** → `java.util.Observer` & `Observable` (deprecated, but pattern is common).
* **Iterator** → `java.util.Iterator`.
* **Strategy** → `Comparator` interface.
* **Command** → `Runnable` is a command pattern.
* **Chain of Responsibility** → Servlet filters.

---

## ✅ **2️⃣ Advanced Java / JEE Patterns**

* **DAO (Data Access Object)** → Used to separate persistence logic.
* **DTO (Data Transfer Object)** → POJO for transferring data between layers.
* **Business Delegate** → Used in EJB/JEE to decouple presentation and business tiers.
* **Service Locator** → Lookup pattern for EJBs/resources (less relevant with Spring DI).
* **Front Controller** → `DispatcherServlet` in Spring MVC.
* **Intercepting Filter** → Servlet Filters.
* **MVC** → Spring MVC.

---

## ✅ **3️⃣ Spring Framework Patterns**

* **Singleton** → Default Spring bean scope.
* **Prototype** → Spring prototype bean scope.
* **Factory Method** → `FactoryBean<T>`.
* **Proxy** → AOP proxies (`@Transactional`, `@Cacheable`).
* **Template Method** → `JdbcTemplate`, `RestTemplate`.
* **Dependency Injection** → Not a GoF pattern, but key architectural pattern.
* **Observer** → `ApplicationEventPublisher` / `@EventListener`.

---

## ✅ **4️⃣ Hibernate / Spring Data JPA Patterns**

* **DAO** → Repositories follow DAO.
* **Proxy** → Lazy loading (`HibernateProxy`).
* **Unit of Work** → Transaction management (`Session` / `EntityManager`).
* **Identity Map** → First-level cache in Hibernate session.
* **Template Method** → `HibernateTemplate` (Spring ORM).
* **Repository Pattern** → `CrudRepository`, `JpaRepository`.

---

## ✅ **5️⃣ Microservices Patterns**

* **API Gateway** → Single entry point for requests.
* **Service Discovery** → Eureka, Consul.
* **Circuit Breaker** → Resilience4j, Hystrix.
* **Client-side Load Balancer** → Ribbon (old), Spring Cloud LoadBalancer.
* **Bulkhead** → Isolation of resources.
* **Retry Pattern** → Spring Retry, Resilience4j.
* **Saga Pattern** → Managing distributed transactions.
* **Event Sourcing** → Store events instead of state (optional).
* **CQRS** → Command Query Responsibility Segregation.
* **Strangler Fig** → Gradual replacement of legacy monoliths.

---

## ✅ **6️⃣ Gang of Four (GoF) — Full List**

**Creational**

1. Singleton
2. Factory Method
3. Abstract Factory
4. Builder
5. Prototype

**Structural**
6\. Adapter
7\. Bridge
8\. Composite
9\. Decorator
10\. Facade
11\. Flyweight
12\. Proxy

**Behavioral**
13\. Chain of Responsibility
14\. Command
15\. Interpreter
16\. Iterator
17\. Mediator
18\. Memento
19\. Observer
20\. State
21\. Strategy
22\. Template Method
23\. Visitor

---

## ✅ **How to prepare answers**

📌 **Interview Tip**
When asked: *“What design patterns do you use?”* — don’t just list them:
✅ Name the pattern
✅ Mention **where you used it**
✅ Explain **why** you used it

Example:

> *“I used Singleton as the default bean scope in Spring because beans are stateless services. For data access, we use DAO and Repository to separate persistence logic. For resilience in microservices, we implemented Circuit Breaker using Resilience4j.”*

---

## ✅ **Bonus: Must-Mention Combo**

> *“In my projects, I often use Factory, Singleton, Proxy, Template Method, Strategy, MVC, and Repository. In microservices, patterns like API Gateway, Service Discovery, Circuit Breaker, and Retry are very common.”*

---

## 🎯 **Next Step**

If you’d like, I can:

* Make this into a **1-page PDF cheat sheet**
* Create **flashcards for quick revision**
* Give you **real Java code snippets** for any pattern
* Or prepare **mock questions & answers**

Just say **“Yes — prepare that for me!”** and I’ll do it! 🚀
