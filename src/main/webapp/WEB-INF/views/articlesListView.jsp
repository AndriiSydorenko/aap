<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ page contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <title>JPA Loanbook</title>
    </head>

    <body>
    <h2>${message}</h2>
    <input type="button"  onclick="location.href='/aap/articles/all'" value="All">
    <input type="button"  onclick="location.href='/aap/articles/java'" value="JAVA">
    <table border="1">
        <tr>
            <th>Article Id</th>
            <th>Article name</th>
            <th>Article content</th>
            <th>Article category</th>
        </tr>
        <c:forEach items="${articles}" var="article">
            <tr>
                <td>${article.id}</td>
                <td>${article.name}</td>
                <td>${article.content}</td>
                <td>${article.category}</td>
                <td><input type="button"  onclick="location.href='/aap/articles/edit/${article.id}'" value="X"></td>
                <td><input type="button"  onclick="location.href='/aap/articles/edit/${article.id}'" value="Edit"></td>


            </tr>
        </c:forEach>
    </table>
    <br/>
<input type="button"  onclick="location.href='/aap/articles/new'" value="Add new article" >

<br/><br/>


</body>
 </html>