(function (ng){
     let mod = ng.module('billeteraModulo', ['ui.router']);

     mod.config(['$stateProvider', '$urlRouterProvider',
                   function($stateProvider, $urlRouterProvider){
                        $urlRouterProvider.otherwise('/billeteras');



                        $stateProvider
                            .state('billeteras', {
                                url:'/billeteras',
                                views: {
                                    'mainView': {
                                        templateUrl: 'src/modules/billeteras/billeteras.list.html',
                                        controller: 'billeteraCtrl'}
                                }


                            })
                            .state('billeterasDetail', {
                                url: '/billeteras/{billetera_id}',
                                params: {
                                    billetera_id: null
                                },
                                views: {
                                    'mainView': {
                                        templateUrl: 'src/modules/billeteras/billeteras.detail.list.html',
                                        // controller: 'pagosDetailCtrl'

                                    }
                                }
                            })
                            .state('createBilletera', {
                                url: '/createBilletera',
                                views: {
                                    'mainView': {
                                        templateUrl: 'src/modules/billeteras/createBilletera.list.html',
                                        controller: 'createBilleteraCtrl'
                                    }
                                }
                            });



                   }
                ]);
 })(window.angular);