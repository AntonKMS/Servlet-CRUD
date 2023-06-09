<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<html>
<head>
    <title>Car parking</title>
</head>
<body>
    <table border="1" cellpadding="5" >
        <caption>
            <h2>Список автомобилей</h2>
        </caption>
        <thead>
        <tr>
            <th>Модель автомобиля</th>
            <th>Гос. номер</th>
            <th>Изменить</th>
            <th>Удалить</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${requestScope.cars}" var="car">

                <tr>
                    <td>${car.modelCar}</td>
                    <td>${car.numberCar}</td>
                    <td>
                        <a href="update?action=/update&id=${car.id}">Update</a>
                    </td>
                    <td>
                        <form method="post" action="delete">
                            <input type="number" hidden name="id" value="${car.id}"/>
                            <input type="submit" name="delete" value="Delete"/>
                        </form>
                    </td>
                </tr>

            </c:forEach>
        </tbody>
    </table>
    <h2>Добавить автомобиль</h2>
    <form method="post" action="addcar">
        <label><input type="text" name="model"></label>Модель<br>
        <label><input type="text" name="number"></label>Гос. номер<br>
        <input type="submit" value="Ok" name="Ok"><br>
    </form>


</body>
</html>