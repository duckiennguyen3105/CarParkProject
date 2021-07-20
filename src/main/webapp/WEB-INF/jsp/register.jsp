<%--
  Created by IntelliJ IDEA.
  User: khangtu
  Date: 12/03/2021
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="_navbar.jsp"/>
<div class="container my-5 ">
        <section id="register-form">
            <!--Grid row-->
            <div class="row justify-content-center align-self-center">

                    <!--Grid column-->
                <div class="col-md-6 mb-4">
                    <!--Section: Live preview-->
                    <section>

                        <!-- Default form register -->
                        <form  class="text-center border p-5" action="${pageContext.request.contextPath}/ServletMemberRegister" method="post" name="register" onsubmit="return checkRegister()" autocomplete="off">

                            <p class="h4 mb-4">Sign up</p>
                            <!-- E-mail -->
                            <div class="mb-4">
                                <input name="user_name" type="text" id="username" class="form-control"
                                       placeholder="User name" required>
                                <div class="invalid-feedback  mb-4" id="invalid-username">User name cannot contain special characters(1-20 characters)</div>
                            </div>
                            <!-- E-mail -->
                            <div class="mb-4">
                                <input name="email" type="email" id="email" class="form-control"
                                       placeholder="E-mail" required>
                                <div class="invalid-feedback  mb-4" id="invalid-email">Must be [a..Z][0..9]@[a..Z].[a..Z]
                                </div>
                                <p style="color: red">${errorEmail}</p>
                            </div>

                            <!-- Password -->
                            <div class="mb-4">
                                <input name="password" type="password" id="password" class="form-control" placeholder="Password"
                                        required>
                                <div class="invalid-feedback" id="invalid-password">[7 to 15 characters which contain only characters, numeric digits, underscore and first character must be a letter]
                                </div>
                            </div>
                            <div class="mb-4">
                                <input type="password" id="confirm_password" name="confirm_password"
                                       class="form-control validate " placeholder="Re Password"
                                       required>
                                <div class="invalid-feedback" id="invalid-confirm-password">
                                </div>
                                <!-- Sign up button -->
                            </div>
                            <button class="btn btn-info my-4 btn-block waves-effect waves-light" type="submit">Register</button>

                            <!-- Register -->
                            <p>Already a member?
                                <a href="${pageContext.request.contextPath}/login.jsp">Login</a>
                            </p>

                            <!-- Social register -->
                            <p>or sign up with:</p>

                            <a type="button" class="light-blue-text mx-2">
                                <i class="fa fa-facebook-f"></i>
                            </a>
                            <a type="button" class="light-blue-text mx-2">
                                <i class="fa fa-twitter"></i>
                            </a>
                            <a type="button" class="light-blue-text mx-2">
                                <i class="fa fa-linkedin"></i>
                            </a>
                            <a type="button" class="light-blue-text mx-2">
                                <i class="fa fa-github"></i>
                            </a>

                            <hr>

                            <!-- Terms of service -->
                            <p>By clicking
                                <em>Sign up</em> you agree to our
                                <a href="" target="_blank">terms of service</a>

                            </p>
                        </form>
                        <!-- Default form register -->

                    </section>
                    <!--Section: Live preview-->

                </div>
                <!--Grid column-->
            </div>
            <!--Grid row-->

        </section>
    </div>
</body>
</html>
