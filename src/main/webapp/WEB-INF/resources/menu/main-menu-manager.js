app.controller('main-menu-controller', function ($scope) {
    $scope.firstTabClicked = function () {
        $scope.$emit(Event.LOAD_CONTENT, MenuComponent.TAB_1);
    };

    $scope.secondTabClicked = function () {
        $scope.$emit(Event.LOAD_CONTENT, MenuComponent.TAB_2);
    };

    $scope.thirdTabClicked = function () {
        $scope.$emit(Event.LOAD_CONTENT, MenuComponent.TAB_3);
    };
});

