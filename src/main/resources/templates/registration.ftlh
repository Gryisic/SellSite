<!DOCTYPE html>
<html>
<head>
    <title>SellSite</title>
</head>
<body>
<h1>SellSite</h1><hr>
<h4>Приём в партию</h4>
<form action="/login" method="post">
    Имя: <input type="text" name="name"><br><br>
    Партийный билет: <input type="email" name="username"><br><br>
    Номер аппарата: <input type="text" name="phoneNumber"><br><br>
    Кодовое слово: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Отправить заявку">
</form>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>