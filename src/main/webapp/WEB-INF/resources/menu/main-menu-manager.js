app.controller('main-menu-controller', function ($scope) {
    $scope.firstTabClicked = function () {
        $scope.$emit(Action.LOAD_CONTENT, Component.TAB_1);
    };

    $scope.secondTabClicked = function () {
        $scope.$emit(Action.LOAD_CONTENT, Component.TAB_2);
    };

    $scope.thirdTabClicked = function () {
        $scope.$emit(Action.LOAD_CONTENT, Component.TAB_3);
    };
});

