<!DOCTYPE html>
<html>
<head>
    <title>SellingSite</title>
</head>
<body>
<H1>SellingSite</H1><hr>
<H4>Инфа о отечественном продукте</H4>
<#list images as image>
    <img src="/images/${image.id}" height="60px"/><br><br>
</#list>
<b>Название товара: </b>${product.title}<br>
<b>Описание товара: </b>${product.description}<br>
<b>Цена: </b>${product.price}<br>
<b>Город: </b>${product.city}<br>
<b>Автор: </b>${product.author}<br>
<hr>
<h3>Удалить товар</h3>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Удалить товар"/>
</form>
</body>
</html>