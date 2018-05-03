(function(ng){
    var mod = ng.module("vueltaModule");
    mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
    mod.controller('vueltaCreateCtrl', ['$scope', '$http', 'vueltaContext', '$state','$rootScope',
        function ($scope, $http, vueltaContext, $state , $rootScope) {
            
             $rootScope.edit = false;
            
             $scope.data = {};
             
            $scope.createVuelta = function(){
                $http.post(vueltaContext, {
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
                    $state.go('vueltacondemoraList', {vueltaId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

