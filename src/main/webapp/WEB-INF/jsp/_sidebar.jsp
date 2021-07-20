<%@ page import="fa.trainning.entities.Member" %><%--
  Created by IntelliJ IDEA.
  User: khangtu
  Date: 12/03/2021
  Time: 14:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Side Bar</title>
</head>
<body>

<div class="col-md-3 col-xl-2 bd-sidebar mt-3">
    <%if (session.getAttribute("member") != null){%>

    <%Member member = (Member) session.getAttribute("member");%>
    <form role="search" onkeyup="myFunction()" class="bd-search d-flex align-items-center"  action="${pageContext.request.contextPath}/ServletSearchContent?id=<%=member.getMemberID()%>" method="post">
        <input name="key" type="search" class="form-control" id="search-input" placeholder="Search..."
               aria-label="Search for..." autocomplete="off" data-docs-version="4.6">
        <button class="btn bd-search-docs-toggle d-md-none p-0 ml-3" type="button" data-toggle="collapse"
                data-target="#bd-docs-nav" aria-controls="bd-docs-nav" aria-expanded="false"
                aria-label="Toggle docs navigation">
        </button>

        <button class="btn bd-search-docs-toggle d-md-none p-0 ml-3" type="button" data-toggle="collapse"
                data-target="#bd-docs-nav" aria-controls="bd-docs-nav" aria-expanded="false"
                aria-label="Toggle docs navigation">
            <i class="fa fa-bars"></i>
        </button>
    </form>


    <hr class="divider" />

    <div class="collapse d-md-block row text-secondary" id="bd-docs-nav">
        <nav class="bd-links" aria-label="Main navigation">
            <div class="bd-toc-item active">
                <ul class="nav bd-sidenav list-group">
                    <li class=" bd-sidenav-active list-group-item  border-0 text-secondary">
<%--                        <%if (session.getAttribute("member") != null){%>--%>

<%--                        <%Member member = (Member) session.getAttribute("member");%>--%>
                        <a href="${pageContext.request.contextPath}/ServletViewAllContent?id=<%=member.getMemberID()%>" class=" text-secondary"><i
                                class="fa fa-stack-exchange "></i> View
                            Contents</a>
<%--                        <%}%>--%>

                    </li>
                    <li class="list-group-item  border-0">
                        <a href="${pageContext.request.contextPath}/add-content.jsp" class=" text-secondary"><i class=" fa fa-edit "></i>
                            Form
                            Contents</a>
                    </li>
                    <li class="list-group-item  border-0">
                        <div>
                            <div class="update-message result-hidden text-center" >
                                <div  id="message" class="alert alert-success">
                                    <div id="resultMessage"></div>
                                </div>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
    </div>
    <%}%>

</div>

</body>
</html>

<script>
    function myFunction() {
        var input, filter, table, tr, td, i, txtValue;
        input = document.getElementById("search-input");
        filter = input.value.toUpperCase();
        table = document.getElementById("myTable");
        tr = table.getElementsByTagName("tr");

        for (i = 0; i < tr.length; i++) {
            td = tr[i].getElementsByTagName("td")[0];
            if (td) {
                txtValue = td.textContent || td.innerText;
                if (txtValue.toUpperCase().indexOf(filter) > -1) {
                    tr[i].style.display = "";
                } else {
                    tr[i].style.display = "none";
                }
            }
        }
    }
</script>
