var app = angular.module('desktop', []);

app.controller('overview-manager-controller', function($scope) {
    $scope.$on(Action.LOAD_CONTENT, function(event, data) { $scope.menuContent = data });
});
