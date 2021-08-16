<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>notes</title>
</head>
<body>
    <p>all notes are as follows:</p>
    <#if notes??>
        <table border="1px">
            <thead>
            <tr><td>ID</td><td>name</td><td>message</td></tr>
            </thead>
            <tbody>
            <#list notes as note>
                <tr><td>${note.id}</td><td>${note.name}</td><td>${note.message}</td></tr>
            </#list>
            </tbody>
        </table>
        <#else>
            <p>nothing</p>
    </#if>
</body>
</html>