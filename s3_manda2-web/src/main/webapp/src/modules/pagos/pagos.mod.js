(function (ng){
    let mod = ng.module('pagoModulo', ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider',

        function($stateProvider, $urlRouterProvider){
            $urlRouterProvider.otherwise('/pagos');


            $stateProvider
                .state('pagoList', {
                    url:'/pagos1',
                    views: {
                        'mainView': {
                            templateUrl: 'src/modules/pagos/pagos.list.html',
                            controller: 'pagosCtrl'}
                    }


                })
                .state('pagosDetail', {

                    url: '/{pago_id}',
                    params: {
                        pago_id: null
                    },

                    views: {
                        'detailView': {
                            templateUrl: 'src/modules/pagos/pagos.detail.list.html',
                            controller: 'pagosDetailCtrl'

                        }
                    }
                });



        }
    ]);
})(window.angular);

