app.controller('main-menu-controller', function ($scope, $http) {
    $scope.firstTabClicked = function () {
        $scope.$emit(Action.LOAD_CONTENT, Component.TAB_1);
    };

    $scope.secondTabClicked = function () {
        $scope.$emit(Action.LOAD_CONTENT, Component.TAB_2);
    };

    $http(new Request(ReqType.GET, ReqEndpoint.AUTHENTICATION)).then(function (value) {
        $scope.isLogged = value.data;
    });
});

