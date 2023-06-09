<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<html>
<head>
    <title>Update</title>
</head>
<body>
    <div>Модель автомобиля: < value="${requestScope.car.modelCar}}"></></div>
    <div>Гос. знак: < value="${requestScope.car.numberCar}"></></div>

<br />
    <form method="post" action="update">

        <label>Марка: <input type="text" name="model" /></label><br>
        <label>Номер: <input type="text" name="number" /></label><br>

        <input type="number" hidden name="id" value="${requestScope.car.id}"/>

        <input type="submit" value="Ok" name="Ok"><br>
    </form>

</body>
</html>
