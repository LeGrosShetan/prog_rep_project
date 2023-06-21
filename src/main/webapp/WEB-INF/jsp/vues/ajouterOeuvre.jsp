<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
    <H1> Ajout d'une oeuvre ${mesProprios.size()}</H1>
</div>
<form method="post" action="/oeuvres/insererOeuvre" onsubmit="return teste()">
    <div class="col-md-12 well well-md">
        <h1>Informations</h1>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Nom de l'oeuvre : </label>
            <div class="col-md-3">
                <INPUT type="text" name="txtnom" value="" id="nom" class="form-control" min="0">
            </div>

        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Etat de l'oeuvre : </label>
            <div class="col-md-3">
                <label style="padding-right: 5px;font-size: 150%;">R :</label>
                <INPUT type="radio" name="txtetat" value="R" id="etatR">
                <label style="padding-right: 5px;font-size: 150%;padding-left: 15px;">S :</label>
                <INPUT type="radio" name="txtetat" value="S" id="etatS">
            </div>
        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Prix de l'oeuvre : </label>
            <div class="col-md-3">
                <INPUT type="number" name="numberprix" value="" id="prix" class="form-control" min="0">
            </div>
        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>
        <div class="form-group">
            <label class="col-md-3 control-label">Proprietaire de l'oeuvre : </label>
            <div class="col-md-3">
                <SELECT type="number" name="numberproprio" value="" id="proprietaire" class="form-control" min="0">
                    <c:forEach items="${mesProprios}" var="item">
                        <option value="${item.idProprietaire}">${item.nomProprietaire}</option>
                    </c:forEach>
                    <option value="0">null</option>
                </SELECT>
            </div>
        </div>
        <div class="row" >
            <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
            </div>
        </div>

        <div class="form-group">
            <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
                Ajouter
            </button>

            <button type="button" class="btn btn-default btn-primary"
                    onclick="{
                            window.location = 'index.jsp';
                        }">
                <span class="glyphicon glyphicon-remove"></span> Annuler

            </button>
        </div>
    </div>
</form>
</body>
<%@include file="footer.jsp"%>
</html>