(function (ng) {
    var app = angular.module('mainApp', [
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
        'billeteraModulo'
    ]);
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);

