(function (ng) {
        var mod = ng.module("entregaModule");
        mod.constant("entregaContext", "api/entregasdedocumentos");
        mod.controller('entregaDeleteCtrl', ['$scope', '$http', 'entregaContext', '$state',

            function ($scope, $http, entregaContext, $state) {
                var idEntrega = $state.params.entregaId;

                $scope.deleteEntrega = function () {
                    $http.delete(entregaContext + '/' + idEntrega, {}).then(function (response) {
                        $state.go('entregasList', {entregaId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);