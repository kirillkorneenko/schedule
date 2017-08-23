<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 18.08.2017
  Time: 2:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
</head>
<body>
<h1>Регистрация посетителей</h1>
<form action="/registration.form" method="post">
    Логин: <input type="text" name="login" size="10"><br>
    Пароль: <input type="password" name="password" size="10"><br>
    Номер группы:<input type="number" name="numberGroup"><br>
    Фамилия: <input type="text" name="name"><br>
    Имя: <input type="text" name="surname"><br>
    <p>
    <table>
        <tr>
            <th><small>
                <button name="save" value="save">Сохранить</button>
            </small>
            <th><small>
            <button name="cancel" value="cancel">Выйти</button>
            </small>
    </table>
</form>
</form>
</body>
</html>
