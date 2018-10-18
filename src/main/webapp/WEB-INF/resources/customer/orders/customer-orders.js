app.controller('customer-orders-controller', function ($scope, $http) {
    $http(new Request(ReqType.GET, ReqEndpoint.AUTHENTICATED_CUSTOMER)).then(function (value) {
        $scope.authenticatedCustomer = value.data;
        $http.post(ReqEndpoint.GET_CUSTOMER_ORDERS, $scope.authenticatedCustomer).then(function (value) {
            $scope.orderList = value.data;
        })
    });
});