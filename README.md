# wenziyue-mybatis-plus-starter

🚀 这是一个基于 MyBatis-Plus 的 Spring Boot Starter，封装了分页配置与扩展服务能力，旨在提升开发效率、统一分页接口规范，支持快速接入并可扩展使用。

---

## ✨ 功能介绍

- ✅ 集成 MyBatis-Plus 分页插件
- ✅ 提供统一的分页请求对象 `PageRequest`
- ✅ 提供分页返回对象 `PageResult`，统一结构
- ✅ 提供可复用的分页扩展服务接口 `PageExtendService`
- ✅ 提供实体类基类 `BaseEntity`
- ✅ 默认启用乐观锁插件配置
- ✅ 自动配置，无需手动注入分页插件

---

## 🧩 如何使用

### 1. 引入依赖

首先在settings.xml中添加以下认证信息
```xml
<server>
    <id>wenziyue-mybatis-plus</id>
    <username>你的GitHub用户名</username>
    <password>你的GitHub Token（建议只赋予 read:packages 权限）</password>
</server>
```

再在 `pom.xml` 中添加 GitHub 仓库地址：

```xml
<!-- pom.xml 中添加仓库地址（id 要与上面保持一致） -->
<repositories>
    <repository>
        <id>wenziyue-mybatis-plus</id>
        <url>https://maven.pkg.github.com/wenziyue1984/wenziyue-mybatis-plus-starter</url>
    </repository>
</repositories>
```
然后引入依赖：

```xml
<dependency>
    <groupId>com.wenziyue</groupId>
    <artifactId>wenziyue-mybatis-plus-starter</artifactId>
    <version>1.0.0（请使用最新版本）</version>
</dependency>
```

> 💡 注意：你需要在 Maven 的 `settings.xml` 中配置 GitHub Token 授权，才能访问私有或 GitHub Packages 的依赖。

### 2. 在你的 Service 中使用分页服务

继承 PageExtendService<T>，即可直接使用分页能力：

```java
public interface UserService extends PageExtendService<UserPO> {
}
```

调用方式：

```java
long current = 1L;
long size = 10L;
PageRequest pageRequest = new PageRequest(dto.getSize(), dto.getCurrent());
PageResult<UserPO> result = userService.page(pageRequest, queryWrapper);
```

### 4. 自动启用分页插件

默认已配置分页插件和乐观锁插件，无需额外注入：

```java

@Configuration
public class MyBatisPlusConfig {
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        ...
    }
}
```

---

## ✅ 已支持的特性

| **功能模块** | **支持情况** |
|----------|----------|
| 分页插件     | ✅        |
| 乐观锁插件    | ✅        |
| 分页扩展接口   | ✅        |
| 通用返回结构体  | ✅        |
| 实体类基类    | ✅        |

---

## 🔧 快速测试

项目中附带 test-app 模块作为测试入口，可本地运行并调试。

---

## 📂 仓库地址

👉 https://github.com/wenziyue1984/wenziyue-mybatis-plus-starter

---

## 📄 License

MIT License

---

## 🙋‍♀️ 作者

👤 [@wenziyue1984](https://github.com/wenziyue1984)

欢迎 Issue、Star 或提交 PR，一起成长 🌱

---