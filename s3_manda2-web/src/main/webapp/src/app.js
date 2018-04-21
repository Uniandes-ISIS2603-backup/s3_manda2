(function (ng) {
    var app = angular.module('mainApp', [
        // External dependencies
        'ui.router',
        'ui.bootstrap',
        // Internal modules dependencies       
        'mediodepagoModule',
        'clienteModule',
        'empleadoModule',
        'reclamoModule',
        'inicioModule',
        'compraModule',
        'vueltaModule'
    ]);
    app.config(['$qProvider', function ($qProvider) {
            $qProvider.errorOnUnhandledRejections(false);
        }]);
})(window.angular);

