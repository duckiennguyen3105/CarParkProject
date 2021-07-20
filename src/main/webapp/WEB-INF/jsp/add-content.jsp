<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="fa.trainning.entities.Member" %><%--
  Created by IntelliJ IDEA.
  User: khangtu
  Date: 12/03/2021
  Time: 14:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Content</title>
</head>
<body>
<jsp:include page="_navbar.jsp"/>
<div class="container-fluid">
    <div class="row flex-xl-nowrap">

        <jsp:include page="_sidebar.jsp"/>

        <div class="col col-md-9 border-left" id="main">
            <%if (session.getAttribute("member") != null) {%>
            <div class="mt-3">
                <c:if test="${content != null}">
                    <h3 class="font-weight-bold">Edit Content</h3>
                </c:if>
                <c:if test="${content == null}">
                    <h3 class="font-weight-bold">Add Content</h3>
                </c:if>
            </div>
            <hr class="divider"/>

            <!-- Main Page -->
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4  mr-5">
                <div
                        class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h5">Content From Elements</h1>
                </div>
                <%Member member = (Member) session.getAttribute("member");%>
                <c:if test="${content != null}">
                <form id="formContent"
                      action="${pageContext.request.contextPath}/ServletUpdateContent?id=<c:out value='${content.contentId}'/>&member_id=<%=member.getMemberID()%>"
                      method="post" name="edit_content">
                    </c:if>
                    <c:if test="${content == null}">
                    <form id="formContent"
                          action="${pageContext.request.contextPath}/ServletCreateContent?id=<%=member.getMemberID()%>"
                          method="post" name="add_content">
                        </c:if>
                        <div class="mb-3">
                            <label for="inputTitle" class="order-form-label">Title</label>
                            <input name="title" type="text" class="form-control" id="inputTitle"
                                   placeholder="Enter the title" value="<c:out value='${content.title}' />" required>
                        </div>
                        <div class="mb-3">
                            <label for="formControlTextareaBrief" class="order-form-label">Brief</label>
                            <textarea name="brief" class="form-control" id="formControlTextareaBrief" rows="3" required><c:out
                                    value='${content.brief}'/></textarea>
                        </div>
                        <div class="mb-3">
                            <label for="formControlTextareaContent" class="order-form-label">Content</label>
                            <textarea name="content" class="form-control" id="formControlTextareaContent" rows="5"
                                      required><c:out value='${content.content}'/></textarea>
                        </div>
                        <div class="mb-5">

                            <c:if test="${content != null}">
                                <button onclick=btnUpdateContentClick("formContent") type="button"
                                        class="btn btn-success "
                                        style="width: 20%; ">Update
                                </button>
                            </c:if>
                            <c:if test="${content == null}">
                                <button onclick=btnAddContentClick("formContent") type="button" class="btn btn-success "
                                        style="width: 20%; ">Add
                                </button>
                            </c:if>
                            <button type="button" onclick=resetForm("formContent") class="btn btn-danger "
                                    style="width: 20%; ">Reset
                            </button>
                        </div>
                    </form>
            </main>
            <%} else {%>
            <jsp:include page="_404.jsp"/>
            <%}%>
        </div>
    </div>
</div>
</body>
</html>
