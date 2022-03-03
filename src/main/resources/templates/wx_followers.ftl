<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>followers</title>
</head>
<body>
    <p>all followers are shown bellow:</p>
    <#if followers??>
        <table border="1px" width="600px">
            <thead>
            <tr><td>#</td><td>ID</td><td>appId</td><td>appName</td><td>source</td><td>time</td><td>UID</td></tr>
            </thead>
            <tbody>
            <#list followers as follower>
                <tr>
                    <td>${follower_index + 1}</td>
                    <td>${follower.id}</td>
                    <td>${follower.appId}</td>
                    <td>${follower.appName}</td>
                    <td>${follower.source}</td>
                    <td>${follower.time}</td>
                    <td>${follower.uid}</td>
                </tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <p>nothing</p>
    </#if>
</body>
</html>