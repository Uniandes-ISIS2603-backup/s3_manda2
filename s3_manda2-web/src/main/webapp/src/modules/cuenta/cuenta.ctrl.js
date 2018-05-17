(function (ng) {
        var mod = ng.module("cuentaModule");
        mod.constant("cuentaContext", "api/cuenta");
        mod.controller('cuentaCtrl', ['$scope', '$http', 'cuentaContext',
            function ($scope, $http, cuentaContext) {
                $http.get(cuentaContext).then(function (response) {
                    $scope.clientesRecords = response.data;
                });
            }
        ]);
    }
)(window.angular);