<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<html>
<head>
    <title>
        <h2>Car parking</h2>
    </title>
</head>
<body>
<hr>
    <table border="1" cellpadding="5" >
        <caption>
            <h2>Список автомобилей</h2>
        </caption>
        <thead>
        <tr>
            <th>Парковочное место</th>
            <th>Модель автомобиля</th>
        </tr>
        </thead>
        <tbody>
            <c:forEach items="${cars}" var="car">

                <tr>
                    <td>${car.getParkingSpace()}</td>
                    <td>${car.getModelCar()}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <h2>Добавить автомобиль</h2>
        <form method="post" action="">
            <label><input type="number" name="place"></label>Место<br>
            <label><input type="text" name="car"></label>Автомобиль<br>
            <input type="submit" value="Ok" name="Ok"><br>
        </form>
</body>
</html>