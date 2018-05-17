(function (ng) {

    var mod = ng.module("cuentaModule", ['ui.router']);
    mod.constant("cuentaContext", "api/cuenta");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        var basePath = 'src/modules/cuenta/';

        $stateProvider.state('cuentaDetalle', {
            url: '/cuenta',
            abstract: true,
            views: {
                'cuentaView': {
                    templateUrl: basePath + 'cuenta1.html',
                    controller: ['$scope', '$http', 'cuentaContext', '$state',
                        function ($scope, $http, cuentaContext, $state) {

                            $scope.usuarioActual = undefined;

                            $http.get('api/clientes/1000').then(function (response) {
                                console.log(1);
                                $scope.usuarioActual = response.data;
                                console.log(response.data);
                            });

                        }
                    ],
                    controllerAs: 'ctrl'
                }
            }
        });
        $stateProvider.state('datosPersonalesCuenta', {

            url: '/datospersonales',
            parent: 'cuentaDetalle',
            views: {
                'vistacambia': {
                    
                    templateUrl: basePath + 'datospersonales.html',
                }
            }
        });
        $stateProvider.state('pagosCuenta', {

            url: '/pagos',
            parent: 'cuentaDetalle',
            views: {
                'vistacambia': {
                    templateUrl: basePath + 'pagos.html',
                }
            }
        });
        $stateProvider.state('billeterasCuenta', {

            url: '/billeterasCuenta',
            parent: 'cuentaDetalle',
            views: {
                'vistacambia': {
                    templateUrl: basePath + 'billeteraCuenta.html',
                }
            }
        });
        $stateProvider.state('historialServicioCuenta', {

            url: '/historialServicios',
            parent: 'cuentaDetalle',
            views: {
                'vistacambia': {
                    templateUrl: basePath + 'historialServicioCuenta.html'
                }
            }
        });
    }]);
})(window.angular);
