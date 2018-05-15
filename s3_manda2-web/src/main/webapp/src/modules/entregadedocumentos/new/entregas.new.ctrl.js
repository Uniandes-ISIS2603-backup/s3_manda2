(function (ng) {
        var mod = ng.module("entregaModule");
        mod.constant("entregaContext", "api/entregasdedocumentos");
        mod.controller('entregaNewCtrl', ['$scope', '$http', 'entregaContext', '$state', '$rootScope',

            function ($scope, $http, entregaContext, $state, $rootScope) {
                $rootScope.edit = false;

                $scope.data = {};

                $scope.createEntrega = function () {
                    $http.post(entregaContext, {
                        id: $scope.entregaId,
                        nombre: $scope.entregaNombre,
                        calificacion: $scope.entregaCalificacion,
                        costo: $scope.entregaCosto,
                        descripcion: $scope.entregaDescripcion,
                        estado: $scope.entregaEstado,
                        puntoDeEncuentro: $scope.entregaPuntoDeEncuentro,
                        puntoDeRealizacion: $scope.entregaPuntoDeRealizacion,
                        costoDeTransporte: $scope.entregaCostoDeTransporte,
                        porcentajeExtra: $scope.entregaPorcentajeExtra
                    }).then(function (response) {
                        $state.go('entregasList', {entregaId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);