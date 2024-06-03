# TodoItem
一个简单的可以登陆注册的没有任何验证的待办事项项目的，用来交作业的，简单纯后端MVC项目。

> 前端文件说明在最后。vue.js-todolist-master
>



## 技术栈

Java + SpringBoot框架

maven做管理

MybatisPlus做持久层



## 简单的介绍

Web课的一个结课作业，顺便给自己暗示复习一下Java到底怎么写不然全忘光了光靠软考去了。



### 目录结构：

src/main/java/com/example/demo/
├── controller/
│   ├── UserController.java
│   └── TodoItemController.java
├── model/
│   ├── User.java
│   └── TodoItem.java
├── mapper/
│   ├── UserMapper.java
│   └── TodoItemMapper.java
├── service/
│   ├── UserService.java
│   ├── UserServiceImpl.java
│   ├── TodoItemService.java
│   └── TodoItemServiceImpl.java
└── DemoApplication.java

### 如何运行：

进入WebApplication 直接运行即可。

别忘了在application.yml里更改你的数据库和端口。



### 依赖文件：

```java
<dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <scope>runtime</scope>
    </dependency>
    <dependency>
        <groupId>org.projectlombok</groupId>
        <artifactId>lombok</artifactId>
        <optional>true</optional>
    </dependency>
    <dependency>
        <groupId>com.baomidou</groupId>
        <artifactId>mybatis-plus-boot-starter</artifactId>
        <version>3.5.6</version>
    </dependency>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-test</artifactId>
        <scope>test</scope>
    </dependency>
</dependencies>
<dependencyManagement>
    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-dependencies</artifactId>
            <version>${spring-boot.version}</version>
            <type>pom</type>
            <scope>import</scope>
        </dependency>
    </dependencies>
```



### 整体代码说明：

标准的SSM框架代码：

**controller**

主要是用于接受前端的数据，在前端测试时看这里基本上解决99%的问题



**mapper**

和数据库链接的持久层，偷懒喜欢用MybatisPlus

（爱国，就用国人的依赖！）

[官方文档]: https://baomidou.com/

不用自己写简单sql语句简直薄纱一切。



**service**

服务层，主要是卡在中间不上不下的交互，具体实现都在这里。



**utils**

通用工具类，里面有个跨域代码，前端用奇怪的端口的时候记得去里面改跨域api。



## 写在后面

由于是纯后端项目，自己可以试试看Api，但是毕竟是Web课作业，前端还是要有，我这里提供一个我自己用的Starred的同站的开源项目，感谢一下这位老哥：

[vue.js-todo]: https://github.com/carrieguo/vue.js-todolist

做得很好！但是是纯前端项目，需要自己稍微的小改一下。我也可以提供更改过的，也会发在这个仓库里。

喜欢的记得点个Star！

