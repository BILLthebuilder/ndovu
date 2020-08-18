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
                $('input[name=tAccNo]').val('');
                $('input[name=tAmount]').val('');
                window.location.href = 'http://localhost:8080/finances/display/display.html';
                console.log(data);
            });
        event.preventDefault();
    });

});
