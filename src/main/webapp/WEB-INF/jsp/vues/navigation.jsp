<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/authentification/accueil">Application Permis Piste</a>
        </div>
        <p class="navbar-text">Permis Piste</p>
        <ul class="nav navbar-nav">
            <li><a href="/authentification/accueil"> <span class="glyphicon glyphicon-home"></span> Accueil</a></li>
            <c:if test="${sessionScope.id == null }">
            <li class="dropdown">
                <a class="nav navbar-nav navbar-right"  href="/authentification/login">
                    <span class="glyphicon glyphicon-user"></span>
                    Se Connecter
                    <span class="caret"></span>
                </a>
            </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="/mission/getMissions">
                        <span class="glyphicon glyphicon-user"></span>
                        Missions
                        <span class="caret"></span>
                    </a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Apprenants
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/apprenant/ajoutApprenant"> <span class="glyphicon glyphicon-plus"></span> Ajouter un apprenant</a></li>
                        <li><a href="/apprenant/getApprenants"><span class="glyphicon glyphicon-th-list"></span> Lister les apprenants</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="/jeu/getJeux">
                        <span class="glyphicon glyphicon-user"></span>
                        Jeux
                        <span class="caret"></span>
                    </a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="/action/getActions">
                        <span class="glyphicon glyphicon-user"></span>
                        Actions
                        <span class="caret"></span>
                    </a>
                </li>
            </c:if>
            <c:if test="${sessionScope.id > 0  }">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="/mission/listerMissions">
                        <span class="glyphicon glyphicon-user"></span>
                        Missions
                        <span class="caret"></span>
                    </a>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Apprenants
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/apprenant/getApprenants"><span class="glyphicon glyphicon-th-list"></span> Lister les apprenants</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Jeux
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/jeu/getJeux"> <span class="glyphicon glyphicon-plus"></span> Lister tous les jeux</a></li>
                        <li><a href="${pageContext.request.contextPath}/user/5"><span class="glyphicon glyphicon-th-list"></span> Lister mes jeux</a></li>
                    </ul>
                </li>
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <span class="glyphicon glyphicon-user"></span>
                        Actions
                        <span class="caret"></span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/action/getActions"><span class="glyphicon glyphicon-th-list"></span> Lister les actions</a></li>
                    </ul>
                </li>

                <li><a href="javascript:window.close();"><span class="glyphicon glyphicon-log-out"></span> Quitter</a></li>
            </c:if>
        </ul>
    </div>
</nav>
