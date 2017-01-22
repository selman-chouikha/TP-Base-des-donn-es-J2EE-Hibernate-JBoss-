<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/Header.jsp">
	<jsp:param name="title" value="Liste des comptes Twitter" />
</jsp:include>

<hr>
<div class="container">
	<h6>Followers de ${name}</h6>

	<!-- Users attributes -->
	<div class="row" id="users-wrapper">
		<!-- Users table -->
		<div class="well col-md-6">
			<table class="table table-sm table-hover" id="users-table">
				<thead>
					<tr class="row">
						<th class="col-md-6">Name</th>
						<th class="col-md-6">Screen Name</th>
					</tr>
				</thead>
				<c:if test="${empty followers}">
					<tr>
						<td colspan="2" align="center" style="font-weight: bold;">
							Aucun Utilisateur enregistré</td>
					</tr>
				</c:if>
				<c:if test="${not empty followers}">
					<tbody>
						<c:forEach items="${followers}" var="follower"
							varStatus="indexUser">
							<tr class="row" id="${indexUser.index}">
								<td class="col-md-6">${follower.name}</td>
								<td class="col-md-6">@${follower.screenName}</td>
							</tr>
							<input type="hidden" name="id" id="id_${indexUser.index}"
								value="${follower.id}">
							<input type="hidden" name="name" id="name_${indexUser.index}"
								value="${follower.name}">
							<input type="hidden" name="screen" id="screen_${indexUser.index}"
								value="${follower.screenName}">
							<input type="hidden" name="date" id="date_${indexUser.index}"
								value="${follower.date.jour}-${follower.date.mois}-${follower.date.annee} à ${follower.date.time}">
							<input type="hidden" name="description"
								id="description_${indexUser.index}"
								value="${follower.description}">
							<input type="hidden" name="location"
								id="location_${indexUser.index}" value="${follower.location}">
							<input type="hidden" name="url" id="url_${indexUser.index}"
								value="${follower.url}">
						</c:forEach>

					</tbody>
				</c:if>
			</table>
		</div>
		<!-- End users table -->

		<!-- User description -->
		<div class="col-md-6" id="users-description">

			<input type="hidden" id="idUser" value="">
			<div class="row">
				<h3 class="col-md-6">Nom :</h3>
				<div id="nom-utilisateur" class="col-md-6"></div>
			</div>
			<div id="screen-utilisateur"></div>
			<div class="row">
				<h3 class="col-md-6">Date creation :</h3>
				<div id="date-creation" class="col-md-6"></div>
			</div>
			<div class="row">
				<h3 class="col-md-6">Description :</h3>
				<div id="description-utilisateur" class="col-md-6"></div>
			</div>
			<div class="row">
				<h3 class="col-md-6">Localisation :</h3>
				<div id="location-utilisateur" class="col-md-6"></div>
			</div>
			<div class="row">
				<h3 class="col-md-6">URL :</h3>
				<div id="url-utilisateur" class="col-md-6"></div>
			</div>
		</div>
		<!-- End User description -->
	</div>
	<!-- End Users attributes -->
</div>
<!-- End Container-Fluid -->

<jsp:include page="includes/Footer.jsp">
	<jsp:param name="year" value="2017" />
</jsp:include>