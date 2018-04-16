(function (ng) {
    var mod = ng.module("tarjetacreditoModule");
    mod.constant("tarjetacreditoContext", "api/tarjetacreditos");
    mod.controller('tarjetacreditoDetailCtrl', ['$scope', '$http', 'tarjetacreditoContext', '$state',
    function($scope, $http, tarjetacreditoContext, $state){
        $http.get("data/billeteras.json").then(function(response){
            billetera = response.data;
            $scope.tarjetacreditoData = billetera.tarjetacredito;
        });
    }]);
})(window.angular);