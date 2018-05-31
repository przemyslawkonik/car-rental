var app = angular.module('desktop', []);

app.controller('overview-manager-controller', function($scope) {
    $scope.$on(Event.LOAD_CONTENT, function(event, data) { $scope.menuContent = data });
});

var MenuComponent = {
    TAB_1 : 'resources/desktop/test.html',
    TAB_2 : 'resources/desktop/test2.html',
    TAB_3 : 'resources/desktop/test3.html'
};

var Event = {
    LOAD_CONTENT : 'LOAD_CONTENT'
};