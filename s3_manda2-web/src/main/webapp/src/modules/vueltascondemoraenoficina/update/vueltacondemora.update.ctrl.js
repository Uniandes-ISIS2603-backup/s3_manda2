(function(ng){
     var mod = ng.module('vueltaModule');
     mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
     mod.controller('vueltaUpdateCtrl', ['$scope', '$http', 'vueltaContext', '$state','$rootScope',
         
          function ($scope, $http, vueltaContext, $state, $rootScope){
              $rootScope.edit = true;
               var idVuelta = $state.params.vueltaId;
               
               $http.get(vueltaContext + '/' + idVuelta).then(function (response) {
                var vuelta = response.data;
                    $scope.vueltaId= vuelta.id;
                    $scope.vueltaNombre= vuelta.nombre;
                    $scope.vueltaCalificacion=vuelta.calificacion;
                    $scope.vueltaCosto=vuelta.costo;
                    $scope.vueltaDescripcion=vuelta.descripcion;
                    $scope.vueltaEstado=vuelta.estado;
                    $scope.vueltaPuntoDeEncuentro=vuelta.puntoDeEncuentro;
                    $scope.vueltaPuntoDeRealizacion=vuelta.puntoDeRealizacion;
                    $scope.vueltaCostoDeTransporte=vuelta.costoDeTransporte;
                    $scope.vueltaCostoDuracion=vuelta.costoDuracion;
            });
            $scope.createVuelta = function () {
                $http.put(vueltaContext + "/" + idVuelta, {
                    id: $scope.vueltaId,
                    nombre: $scope.vueltaNombre,
                    calificacion: $scope.vueltaCalificacion,
                    costo: $scope.vueltaCosto,
                    descripcion: $scope.vueltaDescripcion,
                    estado: $scope.vueltaEstado,
                    puntoDeEncuentro: $scope.vueltaPuntoDeEncuentro,
                    puntoDeRealizacion: $scope.vueltaPuntoDeRealizacion,
                    costoDeTransporte: $scope.vueltaCostoDeTransporte,
                    costoDuracion: $scope.vueltaCostoDuracion
                }).then(function (response) {
                    //vuelta created successfully
                    $state.go('vueltacondemoraList', {vueltaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);