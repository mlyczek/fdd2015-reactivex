$(document).ready(function() {
    var $userNameInput = $('#user-search');
    var $log = $('#log');

// --------------------------------------------------------------------------

    var keyups = Rx.Observable.fromEvent($userNameInput, 'keyup')
        .pluck('target', 'value');
//        .filter(text => text.length > 2);
//        .debounce(500);
//        .distinctUntilChanged();

// --------------------------------------------------------------------------

    keyups.subscribe(
        function(data) {
            var logLine = $('<p>');
            var logText = $('<span>').text(data);
            var time = $('<span>')
                .addClass('grey-text')
                .text('[' + new Date().toLocaleTimeString() + ']');

            logLine.append(time).append(' ').append(logText);

            $log.prepend(logLine);
        },
        function(error) {
            var errorLine = $('<p>').addClass('deep-orange-text text-darken-3').text(error);
            $log.prepend(errorLine);
        });
});
