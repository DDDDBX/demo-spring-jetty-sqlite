<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>QR code</title>
</head>
<body>

    <#if param??>
        <p>parameter: ${param}</p>
    </#if>
    <br>
<#--    <img src="/myapp/files/img/${img_name}">-->
<#--    <br>-->
    <img src="${qrcode_url}" alt="二维码加载失败">
    <br>
    <p>打开微信[扫一扫]，关注该应用！</p>
    <br>
    <a href="/myapp/index">[back to index] 返回主页</a>

</body>
</html>