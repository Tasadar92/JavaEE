<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
        <title>Affichage d'une commande</title>
        <link type="text/css" rel="stylesheet" href="<c:url value="/inc/style.css"/>" />
    </head>
    <body>
        <c:import url="/inc/menu.jsp" />
        <div id="corps">
            <p class="info">${ message }</p>
            <c:if test="${ !erreur }">
                <p>Client</p>
                <p>Nom : <c:out value="${ commande.client.nom }"/></p>
                <p>Pr�nom : <c:out value="${ commande.client.prenom }"/></p>
                <p>Adresse : <c:out value="${ commande.client.adresse }"/></p>
                <p>Num�ro de t�l�phone : <c:out value="${ commande.client.telephone }"/></p>
                <p>Email : <c:out value="${ commande.client.email }"/></p>
                
                <p>Commande</p>
                <p>Date  : <c:out value="${ commande.date }"/></p> 
                <p>Montant  : <c:out value="${ commande.montant }"/></p> 
                <p>Mode de paiement  : <c:out value="${ commande.modePaiement }"/></p> 
                <p>Statut du paiement  : <c:out value="${ commande.statutPaiement }"/></p> 
                <p>Mode de livraison  : <c:out value="${ commande.modeLivraison }"/></p> 
                <p>Statut de la livraison  : <c:out value="${ commande.statutLivraison }"/></p> 
            </c:if>
        </div>
    </body>
</html>