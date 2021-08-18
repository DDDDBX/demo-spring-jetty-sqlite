<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login status</title>
</head>
<body>

    <#if message??>
        <p>${message}</p>
    </#if>
    <#if currentUser??>
        <p>current login user: ${currentUser.name}</p>
        <br>
        <a href="/myapp/logout">[click me to logout] 点我注销登录</a>
        <br>
    <#else>
        <p>no login user!</p>
        <br>
        <a href="/myapp/loginPage">[to login page] 立即登录</a>
        <br>
    </#if>
    <br>
    <a href="/myapp/index">[back to index] 返回主页</a>

</body>
</html>