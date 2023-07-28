<!DOCTYPE html>
<html>
<head>
    <title>SellingSite</title>
</head>
<body>
<H1>SellingSite | <a href="/login">Войти</a> </H1><hr>
<H4>Товары импортозамещённые</H4>
<form action="/" method="get">
    Ищем по названию: <input type="text" name="title"><br>
    <input type="submit" value="Поиск"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">LET ME IN...</a></p>
    </div>
    <#else>
    <h3>Санкций нет</h3>
</#list>
<hr>
<h3>Создать товар</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Название: <input type="text" name="title"/><br><br>
    Описание: <input type="text" name="description"/><br><br>
    Цена: <input type="number" name="price"/><br><br>
    Город: <input type="text" name="city"/><br><br>
    Автор: <input type="text" name="author"/><br><br>
    Фотографии: <input type="file" name="files" multiple/><br><br>

    <input type="submit" value="Добавить товар"/>
</form>
</body>
</html>