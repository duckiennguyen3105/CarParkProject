<%@ page import="fa.trainning.entities.Member" %>
<%--
  Created by IntelliJ IDEA.
  User: khangtu
  Date: 12/03/2021
  Time: 14:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="initial-load.jsp"/>
    <meta charset="UTF-8">
    <title>Navigation Bar</title>
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-light bg-light border border-bottom">
        <%if (session.getAttribute("member") != null){%>
        <%Member member = (Member) session.getAttribute("member");%>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/ServletViewAllContent?id=<%=member.getMemberID()%>">CMS</a>
        <%} else {%>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/login.jsp">CMS</a>
        <%}%>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent-4"
                aria-controls="navbarSupportedContent-4" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <%if (session.getAttribute("member") != null){%>
        <div class="collapse navbar-collapse" id="navbarSupportedContent-4">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                       aria-haspopup="true" aria-expanded="false">
                        <i class="fa fa-user"></i> </a>
                    <div class="dropdown-menu dropdown-menu-right dropdown-info"
                         aria-labelledby="navbarDropdownMenuLink-4">
                        <%if (session.getAttribute("member") != null){%>

                        <%Member member = (Member) session.getAttribute("member");%>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletMemberEdit?id=<%=member.getMemberID()%>"><span><i class="fa fa-user mr-2"></i></span>My
                            account</a>
                        <%}%>
                        <div class="dropdown-divider"></div>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/ServletMemberLogout"><span><i class="fa fa-sign-out mr-2"></i></span>Log out</a>
                    </div>
                </li>
            </ul>
        </div>
        <%}%>

    </nav>
</body>
</html>
