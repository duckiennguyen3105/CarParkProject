<%--
  Created by IntelliJ IDEA.
  User: khangtu
  Date: 12/03/2021
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="fa.trainning.entities.Member" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>

<jsp:include page="_navbar.jsp"/>
<div class="container-fluid">
    <div class="row flex-xl-nowrap">
        <jsp:include page="_sidebar.jsp"/>

        <div class="col col-md-9 border-left" id="main">
            <div class="mt-3">
                <h3 class="font-weight-bold">Edit Profile</h3>
            </div>
            <hr class="divider"/>
            <main class="col-md-9 ms-sm-auto col-lg-12 px-md-4 border border-start mr-5">
                <%if (session.getAttribute("member") != null) {%>

                <div
                        class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                    <h1 class="h5">Profile From Elements</h1>
                </div>
                <div class="row">
                    <div class="col-md-12">
                        <div class="p-3 ">
                            <%Member memberSession = (Member) session.getAttribute("member");%>
                            <form id="myForm"
                                  action="${pageContext.request.contextPath}/ServletMemberUpdate?id=<%=memberSession.getMemberID()%>"
                                  method="post" name="update" onsubmit="return checkEditProfile()">
                                <c:if test="${member != null}">

                                    <div class="row mt-2">
                                        <div class="col-md-12"><label class="labels">First Name</label>
                                            <input name="firstName" type="text" class="form-control"
                                                   placeholder="Enter the first name" value="${member.firstName}">
                                            <div class="invalid-feedback" id="invalid-firstname">First name must be
                                                characters and
                                                not contain number (1-20 character)
                                            </div>
                                        </div>

                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-md-12"><label class="labels">Last Name</label><input
                                                name="lastName" type="text"
                                                class="form-control" value="${member.lastName}"
                                                placeholder="Enter the last name"></div>
                                        <div class="invalid-feedback" id="invalid-lastname">Last name must be characters
                                            and
                                            not contain number (1-20 character)
                                        </div>
                                    </div>
                                    <div class="row mt-2">
                                        <div class="col-md-12"><label class="labels">Email</label>
                                            <p><%=memberSession.getEmail()%>
                                            </p></div>
                                        <div class="col-md-12 mt-2"><label class="labels">Phone</label>
                                            <input name="phone" type="text" class="form-control"
                                                   placeholder="Enter phone number" value="${member.phone}">
                                            <div class="invalid-feedback" id="invalid-phone">Must be number (10-11
                                                number)
                                            </div>
                                        </div>

                                    </div>
                                    <div class="mb-3 mt-2">
                                        <label class="order-form-label">Description</label>
                                        <textarea name="description" class="form-control"
                                                  id="formControlTextareaDescription"
                                                  rows="3">${member.description}</textarea>
                                    </div>

                                    <div class="row mt-4">
                                        <div class="col-md-6 text-center">
                                            <button onclick=btnUpdateClick("myForm")
                                                    class="btn btn-primary col-md-6 profile-button"
                                                    type="submit">Save Profile
                                            </button>
                                        </div>
                                        <div class="col-md-6 text-center">
                                            <button onclick=resetForm("myForm")
                                                    class="btn btn-primary col-md-6 profile-button"
                                                    type="button">Reset
                                            </button>
                                        </div>
                                    </div>
                                </c:if>
                            </form>
                        </div>
                    </div>
                </div>
            </main>
            <!-- Main Page -->
        </div>
        <%} else {%>
        <jsp:include page="_404.jsp"/>
        <%}%>
    </div>
</div>

</body>
</html>