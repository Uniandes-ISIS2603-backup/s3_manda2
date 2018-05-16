
/**
 * @ngdoc overview
 * @name billeteras.mmodule: billeteraModulo
 * @description 
 * Definición del módulo Angular de Billeteras. El módulo encapsula todos los controladores y 
 * templates HTML que estan relacionados con las billeteras directamente. En la configuración del módulo 
 * se injecta la dependencia de iui.router que es la que se utiliza para la configuración de las URLs bajo 
 * las cuales se accede al módulo. Los estados definidos en este modulo son:
 * 
 * | ESTADO          | URL                        | VISTAS                         |
 * |-----------------|----------------------------|--------------------------------|
 * | billeteras      | /billeteras                | mainView:                      |
 * |                 |                            | billeteras.list.html           |
 * |                 |                            |                                |
 * | billeterasDetail| /billeteras/{billetera_id} | mainView                       |
 * |                 |                            | books.list.html                |
 * |                 |                            |                                |
 * | createBilletera |/createBilletera            | mainView:                      |
 * |                 |                            | createBilletera.list.html      |
 * |-----------------|----------------------------|--------------------------------|
 * 
 * 
 */
(function (ng){
     let mod = ng.module('billeteraModulo', ['ui.router']);

     mod.config(['$stateProvider', '$urlRouterProvider',
                   function($stateProvider, $urlRouterProvider){
                      



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