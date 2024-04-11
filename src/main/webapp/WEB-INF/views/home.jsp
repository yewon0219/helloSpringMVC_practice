<%--
  Created by IntelliJ IDEA.
  User: nykim
  Date: 2022/12/13
  Time: 12:55 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <p><a href="${pageContext.request.contextPath}/offers">Show current offers</a></p>
  <p><a href="${pageContext.request.contextPath}/createoffer">Add a new offers</a></p>

  <c:if test="${pageContext.request.userPrincipal.name != null}">
    <a href="javascript:document.getElementById('logout').submit()">Logout</a>
  </c:if>

  <form id="logout"  action="<c:url value="/logout" />"method="post">
    <input type="hidden" name="${_csrf.parameterName}"value="${_csrf.token}" />
  </form>

  </body>
</html>
