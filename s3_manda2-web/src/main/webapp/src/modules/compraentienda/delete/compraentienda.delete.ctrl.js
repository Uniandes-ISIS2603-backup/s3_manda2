(function(ng){
     var mod = ng.module('compraModule');
     mod.constant("compraContext", "api/comprasentienda");
     mod.controller('compraDeleteCtrl', ['$scope', '$http', 'vueltaContext', '$state',
         function ($scope, $http, compraContext, $state){
             var idCompra = $state.params.idCompra;
             
             $scope.deleteCompra = function(){
                    $http.delete(compraContext + '/'+ idCompra, {}).then(function (response){
                   $state.go('compraentiendaList', {idCompra: response.id}, {reload:true});
          });
            };
        }]);
})(window.angular);