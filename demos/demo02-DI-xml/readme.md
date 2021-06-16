
demo02-DI-xml

di：依赖注入，表示创建对象，给属性赋值。
di的实现由两种：

    1.在spring的配置文件中，使用标签和属性完成，叫做基于XML 文件的di实现。
    2.使用spring中的注解，完成属性赋值，叫做基于注解的di实现。
di的语法分类：

    1.set注入（设值注入，常用）：spring调用类的set方法，在set方法可以实现属性的赋值。
    2.构造注入：spring调用类的有参数构造方法，创建对象。在构造方法中完成赋值。

简单类型的set注入：

    <bean id="" class="">
        <property name="属性名字" value="属性的值" />
        <property ... >
    </bean>
    测试代码详见pack01

引用类型的set注入：

    <bean id="" class="">
        <property name="属性名称" ref="bean的id(对象的名称)" />
        ...
    </bean>
    测试代码详见pack02
        
构造注入：spring调用类的有参数构造方法，在创建对象的同时，在构建方法中给属性赋值。
    
    构造注入在bean标签中使用<constructor-arg>子标签
    构造标签的属性：
        name：表示构造方法的形参名
        index：表示构造方法的参数的位置，参数从左往右位置是0, 1, 2, ...
        value：构造方法的形参类型是简单类型，使用value
        ref：构造方法形参类型是引用数据类型时，使用ref
    测试代码详见pack03

引用类型属性之自动注入

引用类型的自动注入：spring框架根据某些规则可以给引用类型赋值。不用在给引用类型赋值。使用的规则常是byName， byType。

    byName（按名字注入）：java类中引用类型的属性名和spring容器中（配置文件）<bean>的id名称是一样的。且数据类型是一致的。这样的容器中的bean，spring能够赋值给引用类型。
    语法规则：

        <bean id="" class="" autowire="byName">
            <!--注意：里面的基本书籍类型，必须是property属性标签赋值才可以-->
            <property name="" value="" />
            ...
        </bean>

    byType（按类型注入）：java类中引用类型的数据类型和spring容器中（配置文件）<bean>的class属性是同源关系的，这样的bean能够赋值给引用数据类型。
    注意：同源就是一类的意思。 
    测试代码详见pack04