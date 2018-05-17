(function (ng) {

    var mod = ng.module("cuentaModule", ['ui.router']);
    mod.constant("cuentaContext", "api/cuenta");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/cuenta/';

            $stateProvider.state('cuentaDetalle', {
                url: '/cuenta',
                views: {
                    'cuentaView': {
                        templateUrl: basePath + 'cuenta1.html',
                        controller: 'cuentaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
