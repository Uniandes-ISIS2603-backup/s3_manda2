(function (ng) {
    let mod = ng.module('pagoModulo');
    mod.constant("pagoContext", 'api/pagos');
    mod.controller('pagosCtrl', ['$scope', '$http', "pagoContext",
        function ($scope, $http, pagoContext) {
            $scope.pagosRecords = [];

            $scope.pagosRecords.push({
                fecha: new Date(), estadoTransaccion: "cancelado", id:0
            });
            $http.get(pagoContext).then(function (response) {
                $scope.pagosRecords = response.data;
            });
        }
    ]);
})(window.angular);