### 步骤：

    新建maven项目；
    添加maven依赖项:
        1.spring依赖；
        2.mybatis依赖；
        3.mysql驱动；
        4.spring的事务依赖；
        5.mybatis和spring的集成依赖
    创建实体类；
    创建dao接口和mapper文件；
    创建mybatis主配置文件；
    创建Service接口和实现类，属性是dao；
    创建spring的配置文件：声明mybatis的对象交给spring创建
        1.数据源；2.SqlSessionFactory；3.dao对象；4.声明自定义的service
    创建测试类，获取service对象，通过service调用dao完成数据库的访问。

