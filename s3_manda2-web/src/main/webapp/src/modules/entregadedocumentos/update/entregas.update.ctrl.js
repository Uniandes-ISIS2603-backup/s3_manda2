(function (ng) {
        var mod = ng.module("entregaModule");
        mod.constant("entregaContext", "api/entregasdedocumentos");
        mod.controller('entregasUpdateCtrl', ['$scope', '$http', 'entregaContext', '$state', '$rootScope',

            function ($scope, $http, entregaContext, $state, $rootScope) {
                $rootScope.edit = true;

                var idEntrega = $state.params.entregaId;

                //Consulto la entrega
                $http.get(entregaContext + '/' + idEntrega).then(function (response) {
                    var entrega = response.data;
                    $scope.entregaId = entrega.id;
                    $scope.entregaNombre = entrega.nombre;
                    $scope.entregaCalificacion = entrega.calificacion = entrega.calificacion;
                    $scope.entregaCosto = entrega.costo;
                    $scope.entregaDescripcion = entrega.descripcion;
                    $scope.entregaEstado = entrega.estado;
                    $scope.entregaPuntoDeEncuentro = entrega.puntoDeEncuentro;
                    $scope.entregaPuntoDeRealizacion = entrega.puntoDeRealizacion;
                    $scope.entregaCostoDeTransporte = entrega.costoDeTransporte;
                    $scope.entregaPorcentajeExtra = entrega.porcentajeExtra;
                });
                $scope.createEntrega = function () {
                    $http.put(entregaContext + "/" + idEntrega, {
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
                        //Author created successfully
                        $state.go('entregasList', {entregaId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);