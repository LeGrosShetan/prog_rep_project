<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
    <h1>Listing des adhérents</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="/authentification/accueil" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des Apprenants</h2>
    <div class="container">
        <h3>Liste des Apprenants</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Numero Apprenant</th>
                <th class="col-md-2">Nom</th>
                <th class="col-md-2">Prénom</th>

            </tr>

            <c:forEach items="${mesApprenants}" var="item">
                <tr>
                    <td>${item.numApprenant}</td>
                    <td>${item.nomAdherent}</td>
                    <td>${item.prenomAdherent}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>

</html>