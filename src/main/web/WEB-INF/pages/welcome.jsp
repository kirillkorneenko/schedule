<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Schedule</title>
</head>
<body>
<h1>Расписание</h1>

    <c:forEach items="${dayWeek}" var="day">
        <h3>${day.dayWeek}</h3>
    <table>
        <tr>
            <th width="100">Время</th>
            <th width="100">По каким неделям</th>
            <th width="100">Название предмета</th>
            <th width="40">Тип Занятия</th>
            <th width="300">Преподаватель</th>
            <th width="80">Аудитория</th>
            <th width="90">Удалить</th>
        </tr>
        <hr>
        <c:forEach items="${shedules}" var="schedule">
            <tr>
                <c:if test="${day.id == schedule.daysweekByCodDayWeek.id}">
                <td>${schedule.callsByLessonNumber.start} - ${schedule.callsByLessonNumber.end}</td>
                    <td>${schedule.weekNumber}</td>
                <td>${schedule.subjectByCodeDiscipline.nameSubject}</td>
                <td>${schedule.subjectByCodeDiscipline.type}</td>
                <td>${schedule.teacherByCodeTeacher.surname} ${schedule.teacherByCodeTeacher.name} ${schedule.teacherByCodeTeacher.patronymic}</td>
                <td>${schedule.lecturehallByCodeAudience.housing}</td>
                <td> <a href="<c:url value="/delete/${schedule.id}.form"/> "/> Удалить  </td>
        </c:if>
            </tr>
        </c:forEach>
    </table>
    </c:forEach>


<c:if test="${test}">
    <h3>Ваше рассписание устарело, обновите его</h3>
    <form action="/updateSchedule.form" method="post">
        <button name="update" value="update"> Обновить</button>
    </form>
</c:if>
<br>
<form action="/index.form">
    <button name="end" value="end"><h4>Выход</h4></button>
</form>
<br/>

</body>
</html>
