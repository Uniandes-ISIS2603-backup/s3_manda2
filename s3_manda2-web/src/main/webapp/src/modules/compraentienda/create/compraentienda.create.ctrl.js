(function(ng){
    var mod = ng.module("compraModule");
    mod.constant("compraContext", "api/comprasentienda");
    mod.controller('compraCreateCtrl', ['$scope', '$http', 'compraContext', '$state','$rootScope',
        function ($scope, $http, compraContext, $state, $rootScope) {
             $rootScope.edit = false;
            
             $scope.data = {};
            
           $scope.createVuelta = function(){
                $http.post(compraContext, {
                    id: $scope.compraId,
                    nombre: $scope.compraNombre,
                    calificacion: $scope.compraCalificacion,
                    costo: $scope.compraCosto,
                    descripcion: $scope.compraDescripcion,
                    estado: $scope.compraEstado,
                    puntoDeEncuentro: $scope.compraPuntoDeEncuentro,
                    puntoDeRealizacion: $scope.compraPuntoDeRealizacion,
                    costoDeTransporte: $scope.compraCostoDeTransporte
                }).then(function (response) {
                    $state.go('compraentiendaList', {compraId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);

