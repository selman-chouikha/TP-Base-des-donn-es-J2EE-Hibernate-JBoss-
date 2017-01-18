// Closes the sidebar menu
$("#menu-close").click(function(e) {
    e.preventDefault();
    $("#sidebar-wrapper").toggleClass("active");
});

// Opens the sidebar menu
$("#menu-toggle").click(function(e) {
    e.preventDefault();
    if( $.trim($(this).text())=='Ajouter'){
    	this.innerText="Annuler";
        
    }else{
    	this.innerText="Ajouter";
        
    }
    $("#sidebar-wrapper").toggleClass("active");
});