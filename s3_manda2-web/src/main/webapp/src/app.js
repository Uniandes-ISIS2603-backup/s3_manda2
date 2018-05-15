(function (ng) {
    var app = ng.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        // Internal modules dependencies       
        'clienteModule',
        'empleadoModule',
        'reclamoModule',
        'inicioModule',
        'compraModule',
        'compraModule',
        'vueltaModule',
        'paypalModule',
        'pseModule',
        'tarjetacreditoModule',
        'pagoModulo',
        'billeteraModulo',
        'entregaModule',
        'reservasModule',
        'articulosModule',
        'loginModule'
    ]);
    app.config(['$qProvider', function ($qProvider) {
        $qProvider.errorOnUnhandledRejections(false);
    }]);
    app.controller('ScrollController', ['$scope', '$location', '$anchorScroll', '$state',
        function ($scope, $location, $anchorScroll, $state) {
            $scope.gotoAnchor = function (ancla) {
                $location.hash(ancla);
                $anchorScroll();
            };
            $scope.isadmin= function () {

            }
            $scope.irVuelta= function () {
                if($scope.isadmin()){
                    $state.go('vueltacondemoraList',{},{});
                }
            }



        }]);

})(window.angular);
