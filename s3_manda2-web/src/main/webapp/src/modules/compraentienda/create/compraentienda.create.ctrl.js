(function(ng){
    var mod = ng.module("compraModule");
    mod.constant("compraContext", "api/comprasentienda");
    mod.controller('compraCreateCtrl', ['$scope', '$http', 'compraContext', '$state',
        function ($scope, $http, compraContext, $state) {
             $scope.data = {'id':1};
            
            $scope.createCompra = function(){
                $http.post(compraContext, $scope.data).then(function (response){
                   $state.go('compraentiendaList', {idCompra: response.id}, {reload:true});
            }); 
         
        }  ;     
         }]);
}
)(window.angular);