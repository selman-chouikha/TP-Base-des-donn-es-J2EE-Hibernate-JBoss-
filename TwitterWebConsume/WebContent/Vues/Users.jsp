<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/Header.jsp">
	<jsp:param name="title" value="Liste des comptes Twitter" />
</jsp:include>

<hr>
<div class="container">
	<div class="row">
		<div class="btn-toolbar col-md-1">
			<button class="btn btn-primary" id="menu-toggle">Ajouter</button>

		</div>
		<div class="col-md-5">${exception}</div>
	</div>
	<!-- Users attributes -->
	<div class="row" id="users-wrapper">
		<!-- Users table -->
		<div class="well col-md-6">
			<table class="table table-sm table-hover">
				<thead>
					<tr class="row">
						<th class="col-md-5">Name</th>
						<th class="col-md-5">Screen Name</th>
					</tr>
				</thead>
				<tbody>

					<c:forEach items="${users}" var="user" varStatus="indexUser">
						<tr class="row" id="${indexUser.index}">
							<td class="col-md-5">${user.name}</td>
							<td class="col-md-5">@${user.screenName}</td>
							<td class="col-md-2"><a
								href="javascript:deleteUser('${user.id}')" id="delete-user"
								role="button" data-toggle="modal"><i class="icon-remove"></i></a></td>
						</tr>

						<input type="hidden" name="name" id="name_${indexUser.index}"
							value="${user.name}">
						<input type="hidden" name="screen" id="screen_${indexUser.index}"
							value="${user.screenName}">

						<input type="hidden" name="date" id="date_${indexUser.index}"
							value="${user.date.jour}-${user.date.mois}-${user.date.annee} à ${user.date.time}">
						<input type="hidden" name="description"
							id="description_${indexUser.index}" value="${user.description}">
						<input type="hidden" name="location"
							id="location_${indexUser.index}" value="${user.location}">
						<input type="hidden" name="url" id="url_${indexUser.index}"
							value="${user.url}">
					</c:forEach>
				</tbody>
			</table>
		</div>
		<!-- End users table -->

		<!-- User description -->
		<div class="col-md-6" id="users-description">
			<div class="row">
				<h3  class="col-md-6">Nom :</h3>
				<div id="nom-utilisateur"  class="col-md-6"></div>
			</div>
			<div id="screen-utilisateur" ></div>
			<div class="row">
				<h3  class="col-md-6">Date creation :</h3>
				<div id="date-creation"  class="col-md-6"></div>
			</div>
			<div class="row">
				<h3  class="col-md-6">Description :</h3>
				<div id="description-utilisateur"  class="col-md-6"></div>
			</div>
			<div class="row">
				<h3  class="col-md-6">Localisation :</h3>
				<div id="location-utilisateur"  class="col-md-6"></div>
			</div>
			<div class="row">
				<h3  class="col-md-6">URL :</h3>
				<div id="url-utilisateur"  class="col-md-6"></div>
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