<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Hello</title>
  </head>
  <body>
  <br>
  <h1>Вход в систему</h1>
  <form action="/entrance.form" method="POST">
    Пользователь: <input type="text" name="user" size="10"><br>
    Пароль:       <input type="password" name="password" size="10"><br>
  <p>
    <c:if test="${test}">
      <h3>Неверно введен логин или пароль</h3>
    <br/>
      </c:if>
    <table>
      <tr>
        <th><small>
          <button name="enter" value="enter">Ввод</button>
        </small>

        <th><small>
        <button name="registration" value="registration">Зарегистрироваться</button>
        </small>
    </table>

  </body>
</html>
