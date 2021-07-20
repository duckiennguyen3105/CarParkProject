<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page import="fa.trainning.entities.Member" %>
<%--
  Created by IntelliJ IDEA.
  User: khangtu
  Date: 16/03/2021
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Searched</title>
    <style>
        table {
            counter-reset: tableCount;
        }
        .counterCell:before {
            content: counter(tableCount);
            counter-increment: tableCount;
        }
    </style>
</head>
<body>
<jsp:include page="_navbar.jsp"/>
<div class="container-fluid">
    <div class="row flex-xl-nowrap">
        <jsp:include page="_sidebar.jsp"/>

        <div class="col col-md-9 border-left " id="main">
            <%if (session.getAttribute("member") != null) {%>
            <div class="mt-3">
                <h3 class="font-weight-bold">${fn:length(listContent)} results for “${key}”</h3>
            </div>
            <hr class="divider" />
            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4 border border-start mr-5">
                <div
                        class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h5">Edit From Elements</h1>
                </div>
                <c:if test="${fn:length(listContent) > 0}">
                    <table class="table">
                        <thead class="thead-dark">
                        <tr>
                            <th scope="col">#</th>
                            <th scope="col">Title</th>
                            <th scope="col">Brief</th>
                            <th scope="col">Created At</th>
                            <th scope="col">Actions</th>
                        </tr>
                        </thead>
                        <tbody>
                        <jsp:useBean id="listContent" scope="request" type="java.util.List"/>
                        <c:forEach  items="${listContent}"  var="content">
                            <tr>
                                <th scope="row" class="counterCell"></th>
                                <td><c:out value="${content.title}" /></td>
                                <td><c:out value="${content.brief}" /></td>
                                <td><c:out value="${content.createdDate}" /></td>
                                <td>
                                    <%if (session.getAttribute("member") != null){%>
                                        <%Member member = (Member) session.getAttribute("member");%>
                                        <a  href="${pageContext.request.contextPath}/ServletEditContent?id=<c:out value='${content.contentId}'/>"><i class="fa fa-pencil mr-3"></i></a>
                                        <a onclick="return confirm('Are you sure you want to delete this item?');"
                                           href="${pageContext.request.contextPath}/ServletDeleteContent?id=<c:out value='${content.contentId}'/>&member_id=<%=member.getMemberID()%>" >
                                            <i class="fa fa-trash text-danger"></i>
                                        </a>
                                    <%}%>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </c:if>

                <c:if test="${fn:length(listContent) == 0}">
                    <div class="alert alert-warning text-center" role="alert">
                        There is no match!
                    </div>
                </c:if>
            </main>
            <%} else {%>
            <jsp:include page="_404.jsp"/>
            <%}%>
        </div>
    </div>
</div>


</body>
</html>
