var app = angular.module('desktop', []);

app.controller('overview-manager-controller', function ($scope, $http) {
    $scope.$on(Action.LOAD_CONTENT, function (event, data, model) {
        $scope.menuContent = data;
        $scope.model = model;
    });

    $scope.handleHomepageClick = function () {
        $scope.menuContent = null;
        $scope.model = null;
    };

    $scope.registerButtonClicked = function () {
        $scope.menuContent = Component.REGISTER_BUTTON;
    };

    $scope.handleLogin = function () {
        angular.element('#login-form').submit();
    };

    $http(new Request(ReqType.GET, ReqEndpoint.AUTHENTICATION)).then(function (value) {
        $scope.isLogged = value.data;
        if($scope.isLogged) {
            $http(new Request(ReqType.GET, ReqEndpoint.AUTHENTICATED_CUSTOMER)).then(function (value) {
                $scope.authenticatedCustomer = value.data;
            });
        }
    });

    $scope.submitRentCar = function (form) {
        let carId = $scope.model.id;
        $http.post(ReqEndpoint.RENT_CAR + carId, $scope.order).then(function (value) {
            $scope.$emit(Action.LOAD_CONTENT, Component.SUCCESS_RENT_CAR_INFO);
        });
    };
});
