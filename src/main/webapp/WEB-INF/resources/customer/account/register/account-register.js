app.controller('register-controller', function ($scope, $http) {
    $scope.isEmailUnique = true;

    $scope.submitRegistration = function (form) {
        $http.post(ReqEndpoint.REGISTER_ACCOUNT, $scope.account).then(function (value) {
            $scope.$emit(Action.LOAD_CONTENT, Component.SUCCESS_REGISTER_INFO);
        })
    };

    $scope.checkEmail = function () {
        var endpoint = ReqEndpoint.FIND_CUSTOMER + '?email=' + $scope.form.email.$viewValue;
        $http(new Request(ReqType.GET, endpoint)).then(function (value) {
            $scope.isEmailUnique = value.data.customer == null;
        })
    };
});
