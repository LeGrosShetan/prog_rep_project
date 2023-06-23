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
    <h2>Tableau des Jeux</h2>
    <div class="container">
        <h3>Liste des Jeux</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Numéro de mission</th>
                <th class="col-md-2">Libellé de mission</th>

            </tr>

            <c:forEach items="${mesJeux}" var="item">
                <tr>
                    <td>${item.numJeu}</td>
                    <td>${item.libelleJeu}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>

</html>