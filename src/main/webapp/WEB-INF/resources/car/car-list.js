app.controller('car-list-controller', function($scope, $http) {
    $http(new Request(ReqType.GET, ReqEndpoint.GET_CAR_LIST)).then(function (value) {
        $scope.carList = value.data;
    });

    $scope.onRentClick = function (car) {
        $scope.$emit(Action.LOAD_CONTENT, Component.RENT_CAR_FORM, car);
    };
});