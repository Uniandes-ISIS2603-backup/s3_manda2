(function (ng) {
        var mod = ng.module("pagoModulo");
        mod.constant("pagoContext", "api/pagos");
        mod.controller('pagoDeleteCtrl', ['$scope', '$http', 'pagoContext', '$state',

            function ($scope, $http, pagoContext, $state) {
                var idPago = $state.params.pagoId;

                $scope.deletePago = function () {
                    $http.delete(pagoContext + '/' + idPago, {}).then(function (response) {
                        $state.go('pagoList', {pagoId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);