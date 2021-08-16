<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>notes</title>
</head>
<body>
    <p>all notes are shown bellow:</p>
    <#if notes??>
        <table border="1px" width="600px">
            <thead>
            <tr><td>#</td><td>ID</td><td>name</td><td>message</td></tr>
            </thead>
            <tbody>
            <#list notes as note>
                <tr><td>${note_index + 1}</td><td>${note.id}</td><td>${note.name}</td><td>${note.message}</td></tr>
            </#list>
            </tbody>
        </table>
    <#else>
        <p>nothing</p>
    </#if>
</body>
</html>