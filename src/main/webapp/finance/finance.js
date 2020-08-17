$(document).ready(function() {
    $('form').submit(function(event) {
        const formData = {
            'tAccNo'              : $('input[name=tAccNo]').val(),
            'tAmount'             : $('input[name=tAmount]').val(),
        };
        $.ajax({
            type        : 'POST',
            url         : 'http://localhost:8080/finances/save',
            data        : formData,
        })
            .done(function(data) {
                console.log(data);
            });
        event.preventDefault();
    });

});
