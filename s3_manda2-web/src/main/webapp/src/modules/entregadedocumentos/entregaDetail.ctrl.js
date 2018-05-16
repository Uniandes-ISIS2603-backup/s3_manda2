(function (ng) {
        var mod = ng.module("entregaModule");
        mod.constant("entregaContext", "api/entregasdedocumentos");
        mod.controller('entregaDetailCtrl', ['$scope', '$http', 'entregaContext', '$state',
            function ($scope, $http, entregaContext, $state) {
                if (($state.params.entregaId !== undefined) && ($state.params.entregaId !== null)) {
                    $http.get(entregaContext + '/' + $state.params.entregaId).then(function (response) {
                        $scope.entregaActual = response.data;
                    });
                }
            }
        ]);
    }
)(window.angular);