var showHideState = false;
$(document).ready(function() {

	if (!showHideState) {
		$('.showHideBlock').hide();
		showHideState = true;
	}
	$('.showHideComment').click(function() {
		var cmId = '#showHide_'+$(this).attr('id');
		$(cmId).toggle();
	});
});