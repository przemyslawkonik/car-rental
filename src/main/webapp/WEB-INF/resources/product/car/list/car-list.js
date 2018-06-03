app.controller('car-list-controller', function($scope, $http) {
    $http(new Request(ReqType.GET, '/cars')).then(function (value) {
        $scope.carList = value.data;
    })
});