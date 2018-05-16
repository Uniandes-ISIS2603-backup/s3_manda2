(function (ng) {
        var mod = ng.module("entregaModule");
        mod.constant("entregaContext", "api/entregasdedocumentos");
        mod.controller('entregaCtrl', ['$scope', '$http', 'entregaContext',
            function ($scope, $http, entregaContext) {
                $http.get(entregaContext).then(function (response) {
                    $scope.entregasRecords = response.data;
                });
            }
        ]);
    }
)(window.angular);