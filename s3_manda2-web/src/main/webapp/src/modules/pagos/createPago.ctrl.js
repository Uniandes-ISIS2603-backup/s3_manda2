(function (ng) {
    let mod = ng.module('pagoModulo');
    mod.constant("pagoContext", 'api/pagos');
    mod.controller('createPagoCtrl', ['$scope', '$http', "pagoContext", "$state",
        function ($scope, $http, pagoContext, $state) {
            $scope.data = {'id': 1};
            $scope.createPago = function () {
                $http.post(pagoContext, $scope.data).then(function (response) {
                    $state.go('pagoList', {idPago: response.id}, {reload: true});
                });
            };
        }]);
})(window.angular);