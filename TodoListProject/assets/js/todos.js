// Check off specific to-dos by clicking
$("li").click(function() {
	$(this).toggleClass("completed");
});

// Click on X to delete to-do
$("span").on("click", function(event) {
	$(this).parent().fadeOut(500, function() {
		$(this).remove();
	});
	event.stopPropagation();
});

// Add new to-do
$("input[type='text']").keypress(function(event) {
	if(event.which === 13) {
		// Grab new to-do text from input
		var toDoText = $(this).val();
		// Create a new li and add to ul
	}
});