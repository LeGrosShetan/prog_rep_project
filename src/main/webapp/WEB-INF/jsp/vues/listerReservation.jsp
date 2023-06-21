<%--
  Created by IntelliJ IDEA.
  User: justi
  Date: 15/03/2023
  Time: 09:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
    <h1>Listing des adhérents</h1>
</div>
<div class="container">
    <h3>
        Liste des réservations
    </h3>
    <table class="table table-hover">
        <tr>
            <th class="col">Date</th>
            <th class="col">NomAd</th>
            <th class="col">PrénomAD</th>
            <th class="col">VilleAd</th>
            <th class="col">Etat</th>
            <th class="col">Titre</th>
            <th class="col">Prix</th>
            <th class="col">Nom Propriétaire</th>
            <th class="col">Prénom Propriétaire</th>
        </tr>

        <c:forEach items="${mesReservations}" var="item">
            <tr>
                <td>
                    <fmt:formatDate value="${item.date}" var="formattedDate"
                                    type="date" pattern="dd/MM/yyyy"/>
                        ${formattedDate}
                </td>
                <td>${item.nomAdherent}</td>
                <td>${item.prenomAdherent}</td>
                <td>${item.villeAdherent}</td>
                <td>${item.etatOeuvrevente}</td>
                <td>${item.titreOeuvrevente}</td>
                <td>${item.prixOeuvrevente}</td>
                <td>${item.nomProprietaire}</td>
                <td>${item.prenomProprietaire}</td>
            </tr>
        </c:forEach>
    </table>
</div>

<%@include file="footer.jsp"%>
</body>
</html>