$(document).ready(function() {
	$("#add-follower").click(function(e) {
		document.location = "users.php?action=addFollowers&id=" + $("#idUser").val();
	});
	$("#add-tweet").click(function(e) {
		document.location = "users.php?action=addTweets&id=" + $("#idUser").val();
	});
	$("#add-user").click(function(e) {
		if ($('#add-follow').prop('checked') == true) {
			$('#add-user').attr('value', 'addAll');
		} else {
			$('#add-user').attr('value', 'add');
		}
	});
	$("tr.row").click(function(e){  
		var idx = this.id;
		$("#idUser").val($('#id_'+idx).val());
		$("#nom-utilisateur").html($('#name_'+idx).val());
		$("#screen-utilisateur").html('@'+$('#screen_'+idx).val());
		$("#date-creation").html($('#date_'+idx).val());
		$("#description-utilisateur").html($('#description_'+idx).val());
		$("#location-utilisateur").html($('#location_'+idx).val());
		$("#url-utilisateur").html($('#url_'+idx).val());
		$("#users-description").attr('class', 'col-md-6 active');
		  e.stopPropagation();
		});
});
