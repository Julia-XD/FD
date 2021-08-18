### FUND 
# 新增了user.sql
# 只有一个admin用户有增删改权限 一般用户只能查
## 密码 abc123
# 增删改权限要求只添加了一部分接口 修改在SpringMvcConfig中
# 访问接口 需要在swagger的除了登录以外接口 需要 右上角填入登录返回的token
# 登录相关功能需要安装Redis 可以参考->  https://www.runoob.com/redis/redis-install.html