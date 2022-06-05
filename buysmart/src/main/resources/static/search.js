$(document).ready(function() {
    $('#myInput').on('keyup', function(event) {
        event.preventDefault();
        /* Act on the event */
        var tukhoa = $(this).val().toLowerCase();
        $('#input-search ul').filter(function() {
            $(this).toggle($(this).text().toLowerCase().indexOf(tukhoa)>-1);
        });
    });
});