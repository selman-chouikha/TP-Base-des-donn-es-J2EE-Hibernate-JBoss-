<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<jsp:include page="includes/Header.jsp">
	<jsp:param name="title" value="Liste des comptes Twitter" />
</jsp:include>

<hr>
<div class="container">
	<h6>Tweets de ${name}</h6>
	<!-- Tweets table -->
	<div class="well">
		<table class="table table-sm table-hover" id="tweets-table">
			<thead>
				<tr class="row">
					<th class="col-md-5">Texte</th>
					<th class="col-md-3">Media</th>
					<th class="col-md-3">Date</th>
					<th class="col-md-1">Likes</th>
				</tr>
			</thead>
			<c:if test="${empty tweets}">
				<tr>
					<td colspan="2" align="center" style="font-weight: bold;">
						Aucun Tweet enregistré</td>
				</tr>
			</c:if>
			<c:if test="${not empty tweets}">
				<tbody>
					<c:forEach items="${tweets}" var="tweet">
						<tr class="row">
							<td class="col-md-5">${tweet.text}</td>
							<td class="col-md-3">${tweet.lien.lien}</td>
							<td class="col-md-3">${tweet.date.jour}-${tweet.date.mois}-${tweet.date.annee}
								à ${tweet.date.time}</td>
							<td class="col-md-1">${tweet.nbOfLikes}</td>
						</tr>
					</c:forEach>

				</tbody>
			</c:if>
		</table>
	</div>
	<!-- End Tweets table -->
</div>
<!-- End Container-Fluid -->

<jsp:include page="includes/Footer.jsp">
	<jsp:param name="year" value="2017" />
</jsp:include>