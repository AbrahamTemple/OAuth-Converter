# 使用转换器从token中获取对应的client信息

## 需求

当我们已经可以通过认证成功后的token对资源服务器进行访问，就会陷入一个疑惑

我们怎么样才能知道使用这个token的访问者到底是谁？

从之前的经验我们可得知每个不同的client_id其授权得到的token都是不同的

也就是说这个问题的前提是必须绑定每个用户使用的client_id都不一样，通过这个client_id再去查询对应的用户

然后我们可以通过DefaultAccessTokenConverter来解决这个问题

## 原理图

![Screenshot](design.png)
