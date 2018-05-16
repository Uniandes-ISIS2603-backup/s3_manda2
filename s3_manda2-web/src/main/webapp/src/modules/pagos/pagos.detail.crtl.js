(function (ng) {
    let mod = ng.module('pagoModulo');
    mod.constant("pagoContext", 'api/pagos');
    mod.controller('pagosDetailCtrl', ['$scope', '$http', "pagoContext", '$stateParams',
        function ($scope, $http, pagoContext, $stateParams) {

            $http.get(pagoContext + '/' + $stateParams.pago_id, {}).then(function (response) {
                $scope.pagoIdRecords = response.data;
            });
        }

    ]);
})(window.angular);


