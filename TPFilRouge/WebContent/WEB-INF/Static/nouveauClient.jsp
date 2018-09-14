<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<legend>Informations client</legend>
<%-- Si et seulement si la Map des clients en session n'est pas vide, alors on propose un choix à l'utilisateur --%>
<c:if test="${ !empty sessionScope.clients }">
	<label for="choixNouveauClient">Nouveau client ? <span class="requis">*</span></label>
    <input type="radio" id="choixNouveauClient" name="choixNouveauClient" value="nouveauClient" checked /> Oui
    <input type="radio" id="choixNouveauClient" name="choixNouveauClient" value="ancienClient" /> Non
    <br/><br />
</c:if>
                   
<c:set var="client" value="${ commande.client }" scope="request" />
	<div id="nouveauClient">
    	<c:import url="/inc/inc_client_form.jsp" />
    </div>
                    
<%-- Si et seulement si la Map des clients en session n'est pas vide, alors on crée la liste déroulante --%>
<c:if test="${ !empty sessionScope.clients }">
  	<div id="ancienClient">
       	<select name="listeClients" id="listeClients">
           	<option value="">Choisissez un client...</option>
	        <%-- Boucle sur la map des clients --%>
            <c:forEach items="${ sessionScope.clients }" var="mapClients">
              	<%--  L'expression EL ${mapClients.value} permet de cibler l'objet Client stocké en tant que valeur dans la Map, 
                   	  et on cible ensuite simplement ses propriétés nom et prenom comme on le ferait avec n'importe quel bean. --%>
                <option value="${ mapClients.value.nom }">${ mapClients.value.prenom } ${ mapClients.value.nom }</option>
            </c:forEach>
        </select>
  	</div>
</c:if>
