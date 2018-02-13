#### 授权使用
- 用户拥有role和permission，还有是否授权三种要求。
##### 需要授权时
```java
    @GetMapping("/user")
    @RequiresAuthentication
    public Object requireAuthentication() {

        return new ResponseBean(1, "已经授权后接口", null);

    }

```
- @RequiresAuthentication  这个注解代表需要授权才能访问的接口
##### 需要某个角色才能访问
```java
  @GetMapping("/name")
    @RequiresRoles("admin")
    public Object requireRole() {
        return new ResponseBean(1, "该用户拥有角色  ‘admin’ ", null);
    }
```
- @RequiresRoles("admin")  这个注解代表需要某个角色才能访问
##### 需要某种权限的时候
```java
    @GetMapping("/getuser")
    @RequiresPermissions("userInfo:add")
    public ResponseEntity<?> getuser() {
        UserInfo userInfo = userInfoRepository.findByUsername("admin");
        System.out.println(userInfo.getRoleList());
        return ResponseEntity
                .ok()
                .body(userInfo);

    }
```
- @RequiresPermissions("userInfo:add")  这个注解就是需要某个权限的时候才能访问
##### 如果你觉得这种方式太麻烦了，还有一个全局配置的方法。
```java
        Map<String, String> filterRuleMap = new HashMap<>();
        // 所有请求通过我们自己的JWT Filter
        filterRuleMap.put("/**", "jwt");
        // 访问401和404页面不通过我们的Filter
        filterRuleMap.put("/401", "anon");
        filterRuleMap.put("/login","anon");
        filterRuleMap.put("/getuser","anon");

        factoryBean.setFilterChainDefinitionMap(filterRuleMap);
```
-  这个在shiroConfiguration 这个类下面，根据过滤顺序，你把你要添加的目录放进去，格式如上，
- anon  表示不用权限， 默认是不用授权的。
- authc 代表需要授权
- 同样这个地方可以过滤role 或是permission  ，考虑到那个接口很杂，就没有配置
##### 授权的时候。
- 先是需要访问 /login 这个接口拿到token ，需要的参数是（username = admin ， password =123456 ）
- 然后我们的需要授权的接口需要在请求头里面放  “Authorization”，然后接上访问/login拿到的token。
- 调试推荐用postman

##### swagger-ui
-