app.controller('car-list-controller', function($scope, $http) {
    $http(new Request(ReqType.GET, ReqEndpoint.GET_CAR_LIST)).then(function (value) {
        $scope.carList = value.data;
    })
});