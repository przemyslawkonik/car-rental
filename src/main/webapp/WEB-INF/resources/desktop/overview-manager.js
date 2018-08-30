var app = angular.module('desktop', []);

app.controller('overview-manager-controller', function($scope, $http) {
    $scope.$on(Action.LOAD_CONTENT, function(event, data) { $scope.menuContent = data });

    $scope.registerButtonClicked = function () {
        $scope.menuContent = Component.REGISTER_BUTTON;
    };

    $scope.handleLogin = function () {
        angular.element('#login-form').submit();
    };

    $http(new Request(ReqType.GET, ReqEndpoint.AUTHENTICATION)).then(function (value) {
        $scope.isLogged = value.data;
    })
});
