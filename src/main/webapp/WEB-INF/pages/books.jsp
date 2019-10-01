<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
    <title>КНИГИ</title>
</head>
<body>

<h2>Книги</h2>
<table>
    <tr>
        <th>номер</th>
        <th>название</th>
        <th>жанр</th>
        <th>издательство</th>
        <th>год издания</th>
        <th>номер автора</th>
        <th>действие</th>
    </tr>
    <c:forEach var="book" items="${booksList}">
        <tr>
            <td>${book.id}</td>
            <td>${book.title}</td>
            <td>${book.genre}</td>
            <td>${book.edition}</td>
            <td>${book.editionYear}</td>
            <td>${book.idAuthor.id}</td>
            <td>
                <a href="/book/edit/${book.id}">редактировать</a>
                <a href="/book/delete/${book.id}">удалить</a>
            </td>
        </tr>
    </c:forEach>
</table>

<h2>Добавить</h2>
<c:url value="/book/add" var="add"/>
<a href="${add}">Добавить новую книгу</a>

</body>
</html>
