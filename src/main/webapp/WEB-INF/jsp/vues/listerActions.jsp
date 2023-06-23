<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
    <h1>Listing des Jeux</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="/authentification/accueil" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Actions</h2>
    <div class="container">
        <h3>Liste des Actions</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Numéro d'action</th>
                <th class="col-md-2">Libellé d'action</th>

            </tr>

            <c:forEach items="${mesActions}" var="item">
                <tr>
                    <td>${item.numAction}</td>
                    <td>${item.libAction}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>

</html>