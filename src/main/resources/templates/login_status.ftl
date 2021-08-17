<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>login status</title>
</head>
<body>

    <#if username??>
        <p>current login user: ${username}</p>
    <#else>
        <p>no login user!</p>
    </#if>

</body>
</html>