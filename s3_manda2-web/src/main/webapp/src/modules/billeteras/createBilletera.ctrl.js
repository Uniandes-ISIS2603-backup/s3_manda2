(function (ng) {
    let mod = ng.module('billeteraModulo');
    mod.constant("billeteraContext", 'api/billeteras');
    mod.controller('createBilleteraCtrl', ['$scope', '$http', "billeteraContext", "$state",
        function ($scope, $http, billeteraContext, $state) {
            $scope.data = {'id': 1};
            $scope.createBilletera = function () {
                $http.post(billeteraContext, $scope.data).then(function (response) {
                    $state.go('billeteras', {idBilletera: response.id}, {reload: true});
                });
            };
        }]);
})(window.angular);