<%--
  Created by IntelliJ IDEA.
  User: christian
  Date: 07/02/2021
  Time: 16:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>

<div class="jumbotron text-center">
    <h1>Listing des Emprunts</h1>
</div>

<div class="container">
    <a class="btn btn-secondary" href="/index.htm" role="button"><span class="glyphicon
    glyphicon-menu-left"></span> Retour accueil</a>
    <h2>Tableau des emprunts</h2>
    <div class="container">
        <h3>Liste des Emprunts</h3>
        <table class="table table-hover">
            <tr>
                <th class="col">ID Emprunt</th>
                <th class="col">DateEmprunt</th>
                <th class="col">DateRetour</th>
                <th class="col">Nom Ad</th>
                <th class="col">Prénom Ad</th>
                <th class="col">Ville Ad</th>
                <th class="col">Id Oeuvre</th>
                <th class="col">Titre Oeuvre</th>
                <th class="col">Nom Propriétaire</th>
                <th class="col">Prénom Propriétaire</th>
            </tr>
            <c:forEach items="${mesEmprunts}" var="item">
                <tr>
                    <td>${item[0].idEmprunt}</td>
                    <td>   <fmt:formatDate value="${item[0].dateEmprunt}" var="formattedDate"
                                           type="date" pattern="dd/MM/yyyy" />
                            ${formattedDate}
                    </td>
                    <td>   <fmt:formatDate value="${item[0].dateRetour}" var="formattedDate"
                                           type="date" pattern="dd/MM/yyyy" />
                            ${formattedDate}
                    </td>
                    <td>${item[1].nomAdherent}</td>
                    <td>${item[1].prenomAdherent}</td>
                    <td>${item[1].villeAdherent}</td>
                    <td>${item[2].idOeuvrepret}</td>
                    <td>${item[2].titreOeuvrepret}</td>
                    <td>${item[3].nomProprietaire}</td>
                    <td>${item[3].prenomProprietaire}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>
</html>