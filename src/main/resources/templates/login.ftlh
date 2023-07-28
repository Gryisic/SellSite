<!DOCTYPE html>
<html>
<head>
    <title>SellSite</title>
</head>
<body>
<h1>SellSite</h1><hr>
<h4>Войти на заседание</h4>
<form action="/login" method="post">
    Партийный билет: <input type="email" name="username"><br><br>
    Кодовое слово: <input type="password" name="password"><br><br>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вход">
</form>
<a href="/registration">Вступить в партию</a>
</body>
</html>