(function(ng){
    var mod = ng.module('tarjetacreditoModule');
    mod.constant('tarjetacreditoContext', 'api/tarjetascreditos');
    mod.controller('tarjetacreditoDeleteCtrl', ['$scope', '$http', 'tarjetacreditoContext', '$state',
    function($scope, $http, tarjetacreditoContext, $state){
        var idTarjetacredito = $state.params.idTarjetacredito;
        
        $scope.deleteTarjetacredito = function(){
            $http.delete(tarjetacreditoContext + '/' + idTarjetacredito, {}).then(function(response){
                $state.go('tarjetacreditoList', {idTarjetacredito: response.data.id}, {reload:true});
            });
        };
    }]);
})(window.angular);