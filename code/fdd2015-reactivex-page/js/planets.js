$(document).ready(function(){
    var $suggestionInput = $('#suggestion-search');
    var $suggestions = $('#suggestions-result');

// --------------------------------------------------------------------------

    var keyups = Rx.Observable.fromEvent($suggestionInput, 'keyup')
        .pluck('target', 'value')
        .filter(text => text.length > 2)
        .debounce(300)
        .distinctUntilChanged()
        .flatMap(value => $.ajax({
            url: 'http://localhost:4567/users/find?username=' + value,
            dataType: 'json'
         }).promise());

// --------------------------------------------------------------------------

    keyups.subscribe(
        function(data) {
            $suggestions
                .empty()
                .append($.map(data,
                            u => $('<li>')
                                    .addClass('collection-item')
                                    .text(u.fullName + ' (' + u.position + ')')));
        },
        function(error) {
            console.log('error');
            console.log(error);
        });
});
