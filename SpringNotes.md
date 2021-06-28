 Spring 框架

![](figs\Spring体系结构图.png)

框架就是一个软件。

### IOC（Inversion of Control）：控制反转

意义：把对象的创建，赋值，管理工作都交给代码之外的“容器”来完成。

控制：创建对象，对象的属性赋值，对象之间的关系管理。

反转：把原来的开发人员管理，创建的对象的权限转移给代码之外的容器来实现。由容器代替开发人员来管理对象，创建对象，并给属性赋值。

能够实现业务对象之间的解耦合，例如service和dao对象之间的解耦合。

### IOC之DI（Dependency Injection）：依赖注入

DI是IOC的技术实现。

DI的意义：只需要在程序中提供要使用的对象名称就可以了，只与对象如何在容器中创建，赋值，查找等都由容器内部来实现。

Spring框架使用DI实现了IOC的功能，Spring底层创建对象，使用的是反射机制。

```
Spring的实现步骤：

    1.创建maven项目；
    2.加入maven依赖；
        Spring的依赖，junit依赖。
    3.创建类（接口和实现类）
    4.创建Spring需要使用的配置文件。
        声明类的信息，类有Spring创建和管理。
```

```text
di：依赖注入，表示创建对象，给属性赋值。
di的实现由两种：
    1.在spring的配置文件中，使用标签和属性完成，叫做基于XML 文件的di实现。
    2.使用spring中的注解，完成属性赋值，叫做基于注解的di实现。

di的语法分类：
    1.set注入（设值注入，常用）：spring调用类的set方法，在set方法可以实现属性的赋值。
    2.构造注入：spring调用类的有参数构造方法，创建对象。在构造方法中完成赋值。

基本数据类型的set注入：
    <bean id="" class="">
        <property name="属性名字" value="属性的值" />
        <property ... >
    </bean>

引用数据类型的set注入：
    <bean id="" class="">
        <property name="属性名称" ref="bean的id(对象的名称)" />
        ...
    </bean>
    
构造注入：spring调用类的有参数构造方法，在创建对象的同时，在构建方法中给属性赋值。
    构造注入使用<constructor-arg>标签
    构造标签的属性：
        name：表示构造方法的形参名
        index：表示构造方法的参数的位置，参数从左往右位置是0, 1, 2, ...。（可省略）
        value：构造方法的形参类型是简单类型，使用value
        ref：构造方法形参类型是引用数据类型时，使用ref
```

spring的对象默认创建时间是：

​									在创建spring的容器时，会创建配置文件中所有的对象。

spring创建对象时：默认调用无参数构造方法。

<font color="#FA0E00">spring不但可以创建自己写的类对象，也可以创建已有的类的对象。</font>

spring-context和spring-webmvc是spring中的两个模块。

​	spring-context：是IoC的功能，用来创建对象。

​	spring-webmvc中也会用到spring-context中创建对象的功能，spring-context是一个基础模块，很重要。

junit：工具类库，做测试使用的。

​	单元：指定的是方法，一个类中有很多方法，一个方法称为单元。

使用单元测试，

​	1.需要加入junit依赖：

​	<dependency>

​		...

​	</dependency>

​	2.创建测试作用的类：叫做测试类

​	3.创建测试方法

---

2021-06-15

引用类型属性之自动注入

​	引用类型的自动注入：spring框架根据某些规则可以自动给引用类型赋值。使用的规则常是byName， byType。

​	byName（按名字注入）：java<font color=#FF00FF>类中引用类型的属性名和spring容器中（配置文件）<bean>的id名称是一样的</font>。且数据类型是一致的。这样，容器中的bean，spring能够赋值给引用类型。

​	语法规则：

```xml
<bean id="" class="" autowire="byName">
    <!--注意：里面的基本数据类型，必须是property属性标签赋值才可以，构造注入的constructor-arg标签不行-->
    <property name="" value="" />
	...
</bean>
```

​	byType（按类型注入）：java类中引用类型的数据类型和spring容器中（配置文件）<bean>的class属性是同源关系的，这样的bean能够赋值给引用数据类型。

​		注意：同源就是一类的意思。 

---

包含关系的配置文件（多个分支配置文件）

​	有一个主配置文件：包含其他的配置文件，主配置文件中一般是不定义对象的。

​	语法：<import resource="其他配置文件的路径" />

​	关键字："classpath:"表示类路径（target目录下的class文件路径）；在spring的配置文件中要指定其他文件的位置，需要使用classpath，告诉spring到哪里去加载文件。



基于注解的di

​	通过注解完成java对象创建和属性赋值。

​	使用注解的步骤：

​	1.加入maven的依赖spring-context的同时，间接加入spring-context的依赖。使用注解必须使用spring-aop依赖。

​	2.在类中加入spring的注解（多个不同功能的注解）。

​	3.在spring的配置文件中，加入一个组件扫描器的标签，说明注解在项目中位置。

​	学到的注解：

​		(1) @Component

​		(2) @Respotory

​		(3) @Service

​		(4) @Controller

​		(5) @Value

​		(6) @Autowired

​		(7) @Resource

​	4.以@Component为例的使用步骤

​		加入maven的依赖；

​		在创建类的同时在类的上方写上：@Component(value="对象别名")；

​		在资源配置文件（.xml）中，用context标签，声明组件扫描器(component-scan)，组件就是java对象。

​		其中。base-package：指定注解在你的项目中的包名；

​		component-scan工作方式：spring会扫描遍历base-package指定的包，把包中和子包中所有的类都扫描一遍。找到类中的注解，按照注解的功能，创建对象或属性赋值。

---

2021-06-16

spring中和@Component功能一致，创建对象的注解还有：

​	@Repository：用在持久层类上面的，所以将其放在dao的实现类上面，表示创建dao对象，dao对象时能够访问数据库的；

​	@Service：用早业务层类的上面，所以将其放在service的实现类上面，创建service对象，service对象是做业务处理的，可以做事务等功能。

​	@Controller：用在控制器类的上面，常见控制器对象的，控制器对象能够接受用户提交的参数，显示请求的处理结果。



指定多个包的三种方式：

 	1. 使用多次组件扫描器，指定不同的包。
 	2. 使用分隔符（;或者,）分隔多个包名。
 	3. 指定父包

​    @Value：简单类型的属性赋值

​		属性：value是String类型的，表示基本数据类型的属性值；

​		位置：（1）在属性定义的上面，无需set方法，推荐使用；

​					（2）在set方法的上面

​	@Autowired：spring框架提供的注解，实现引用类型的赋值。

​		属性：

​			required，是一个boolean类型，默认required=true。

​			required=true：表示引用数据类型赋值失败，程序终止并报错。

​			required=false：引用类型如果赋值失败，程序正常执行，引用数据类型是null。

​		spring中通过注解给引用数据类型赋值，使用的是自动注入原理，支持byName，byType。默认使用byType自动注入。

​		使用byName方式：

​			1.在属性上面加入@Autowired；

​			2.在属性上面加入@Qualifier(value="bean的id")：表示使用指定名称的bean完成赋值。

​	@Resource：属于JDK中的注解，spring框架支持该注解的使用。使用的也是自动注入原理。支持byName，byType，默认是byName。

​		使用方式：

​			放在引用数据类型属性的上面，@Resource(name="bean的id 或者 @Component里面的value值")。

### AOP(Aspect Orient Programming) 面向切面编程

动态代理：可以在程序的执行过程中，创建代理对象。

通过代理对象执行方法，给目标类的方法增加额外的功能。

JDK动态代理实现步骤：

​	创建目标类，SomeServiceImpl目标类，给它的doSome，doOther增加输出时间，输出事务。

​	创建InvocationHandler接口的实现类，在这个类中实现给目标增加功能。

​	使用jdk中类的Proxy，创建代理对象，实现创建对象的能力。

AOP底层，就是采用动态代理模式实现的。采用两种代理：JDK的动态代理和CGLIB的动态代理。

​	JDK动态代理：使用JDK中的Proxy，Method，InvocationHandler创建代理对象。

​	CGLIB动态代理：是一个第三方的工具库，创建代理对象，原理是继承。通过继承目标类，创建子类。子类就是代理对象。要求：目标类不能是final的，方法也不能用final修饰。

​	动态代理的作用：

​		在目标类源代码不改变的情况下，增加功能；

​		减少代码的重复；

​		专注业务逻辑代码；

​		解耦合，让业务功能和非业务功能（日志等）分离。

怎么理解面向切面编程？？？

​	（1）需要在分析项目功能时，找出切面；

​	（2）合理的安排切面的执行时间（在目标方法之前还是之后执行）；

​	（3）合理的安排切面执行的位置，在哪个类的哪个方法增加功能。



AOP使用的时机：

​	（1）在多个类中，加入同一个功能；

​	（2）当要给项目存在的类修改功能，但是原有类的功能不完善，但是还没有源代码，使用aop就可以增加功能；

​	（3）给业务方法增加事务，或日志等的输出。 



术语：

​	（1）Aspect：切面，表示增强的功能，非业务功能，常见的切面功能有：日志，事务，统计信息，参数检查，权限验证等等。

​	（2）JoinPoint：连接点，连接业务方法和切面的位置。

​	（3）Pointcut：切入点，指多个连接点方法的集合。

​	（4）目标对象：需要增加功能方法对应的那个类就是目标对象。

​	（5）Advice：通知，表示切面功能执行的时间。

一个切面的三个关键要素：

​	（1）切面的功能代码。用来干什么；

​	（2）切面的执行位置。使用Pointcut表示切面执行的位置；

​	（3）切面的执行时间。使用Advice表示执行时间。（在目标方法之前，还是在目标方法之后执行）



AOP的实现

​	aspectJ：专门做aop框架。spring框架中集成了aspectJ框架，通过spring就能使用aspectJ的功能。

​	aspectJ框架实现aop有两种方式：

​		(1) 使用xml框架的配置文件：配置全局事务；

​		(2) 使用注解，在项目中做aop功能，一般都使用注解，aspectJ有5个注解。



学习使用aspectJ框架的使用

​	（1）切面的执行时间，在规范中叫做Advice（通知，增强），在aspectJ框架中使用注解表示的。也可以使用xml配置文件中的标签。

​		(1) @Before; (2) @AfterReturning; (3) @Around; (4) @AfterThrowing; (5) @After .

​	（2）表示切面执行的位置。



使用aspectj实现AOP的基本步骤：

​	1.新建maven项目；

​	2.加入依赖：

​		spring依赖；

​		aspectj依赖；

​		junit单元测试。

​	3.创建目标类：接口和它的实现类。

​	4.创建切面类：

​		在类的上面加入@Aspect；

​		在类中定义方法，方法就是切面要执行的功能代码。在方法的上面加入aspectj中的通知注解，例如：@Before，还需要指定切入点表达式execution()；

​	5.创建spring的配置文件：声明对象，把对象交给容器统一管理。

​		使用注解或者bean标签的形式声明对象。

​	6.创建测试类，从spring容器中获取目标对象（即代理对象）。通过代理执行方法，实现aop的功能增强。

```java
JoinPoint的使用：指定通知方法中的参数
JoinPoint：业务方法，要加入切面功能的业务方法
作用：
	可以在通知方法中获取方法执行时的信息，例如方法名称，方法的实参。
	如果切面功能中需要用到方法的信息，就加入JoinPoint；
	JoinPoint参数的值是由框架赋予，必须是第一个位置的参数。
public void myBefore(JoinPoint jp) {
	// 获取方法的完整定义
    System.out.println("方法的定义：" + jp.getSignature());
    System.out.println("方法的名称：" + jp.getSignature().getName());
    // 获取方法的实参
    Object args[] = jp.getArgs();
    for(Object arg : args) {
        System.out.println(arg);
    }
    System.out.println("执行切面方法myBefore()");
}
```

```
后置通知：@AfterReturning
属性：
	1.value 切入点表达式
	2.returning 自定义的变量，表示目标方法的返回值；
位置：
	在方法定义的上面
特点：
	1.在目标方法之后执行；
	2.能够获取到目标方法的返回值，可以根据这个返回值做不同的处理功能；
	3.可以修改这个返回值，
```

```
环绕通知：@Around
环绕通知方法的定义格式：
	1.public
	2.必须有一个返回值，推荐使用object
	3.方法名称自定义
	4.方法有参数，固定的参数proceedingJoinPoint
属性：
	value：切入点表达式
位置：
	在方法体中定义
特点：
	1.功能最强的通知；
	2.在目标方法的前和后都能增强功能；
	3.控制目标方法是否被调用执行；
	4.修改原来的目标方法的执行结果，最后调用。
	
环绕通知，等同于jdk动态代理的InvocationHandler接口
	参数：ProceedingJoinPoint 等同于 Method
		作用：执行目标方法
	返回值：返回目标的执行结果，可以被修改。

```

```
Pointcut：定义和管理切入点，如果项目中有多个切入点表达式是重复的，即可以复用，则可以使用@Pointcut。
属性：
	value：切入点表达式
位置：
	在自定义的方法上面
特点：
	当使用@Pointcut定义在一个方法的上面，此时这个方法的名称就是切入点表达式的别名，其它的通知中，value属性就可以使用这个方法名称，代替切入点表达式。
```

### 合并mybatis和Spring框架

用的技术是：ioc。（原因：ioc能够创建对象。可以把mybatis框架中的对象交给spring统一创建。）

使用mybatis必然会用到dao代理。要使用dao代理对象，就需要使用getMapper()方法。

使用getMapper()方法需要的条件：

​	1.获取SqlSession对象，需要使用SqlSessionFactory的openSession()方法。

​	2.创建SqlSessionFactory对象，通过读取mybatis的主配置文件，能创建SqlSessionFactory对象。

使用独立的连接池替换mybatis默认自带的，把连接池也交给spring创建。

主配置文件：

```xml
1.数据库信息

```

实现步骤：

spring的事务处理

​	什么是事务？

​		事务是指一组sql语句的集合。 
