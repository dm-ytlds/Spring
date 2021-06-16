### pack01:
以@Component为例的使用步骤

    加入maven的依赖；
    在创建类的同时在类的上方写上：@Component(value="对象别名")；
    在资源配置文件（.xml）中，用context标签，声明组件扫描器(component-scan)，组件就是java对象。
        其中。base-package：指定注解在你的项目中的包名；
    component-scan工作方式：spring会扫描遍历base-package指定的包，把包中和子包中所有的类都扫描一遍。找到类中的注解，按照注解的功能，创建对象或属性赋值。

### pack02:
@Value：简单类型的属性赋值
    
    属性：value是String类型的，表示基本数据类型的属性值；
    位置：（1）在属性定义的上面，无需set方法，推荐使用；
         （2）在set方法的上面
@Autowired：spring框架提供的注解，实现引用类型的赋值。

    spring中通过注解给引用数据类型赋值，使用的是自动注入原理，支持byName，byType。默认使用byType自动注入。