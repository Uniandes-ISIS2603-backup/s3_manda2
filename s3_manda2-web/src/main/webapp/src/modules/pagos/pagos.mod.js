(function (ng) {
    let mod = ng.module('pagoModulo', ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider',

        function ($stateProvider, $urlRouterProvider) {

            $stateProvider
                .state('pagoList', {
                    url: '/pagos',
                    views: {
                        'pagoView': {
                            templateUrl: 'src/modules/pagos/pagos.list.html',
                            controller: 'pagosCtrl'
                        }
                    }
                })
                .state('pagosDetail', {
                    url: '/pagos/{pago_id}',
                    params: {
                        pago_id: null
                    },
                    views: {
                        'pagoView': {
                            templateUrl: 'src/modules/pagos/pagos.detail.list.html',
                            controller: 'pagosDetailCtrl'

                        }
                    }
                })
                .state('createPago', {
                    url: '/createPago',
                    views: {
                        'pagoView': {
                            templateUrl: 'src/modules/pagos/createPago.list.html',
                            controller: 'createPagoCtrl'
                        }
                    }
                });

        }
    ]);
})(window.angular);
