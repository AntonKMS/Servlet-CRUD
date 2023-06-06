<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html lang="ru">
<html>
<head>
    <title>Update</title>
</head>
<body>
    <div>Модель автомобиля: < value="${requestScope.car.modelCar}"></></div>
    <div>Гос. знак: < value="${requestScope.car.numberCar}"></></div>
</body>
</html>
