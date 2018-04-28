(function (ng){
     let mod = ng.module('billeteraModulo', ['ui.router']);

     mod.config(['$stateProvider', '$urlRouterProvider',
                   function($stateProvider, $urlRouterProvider){
                        <!--<--$urlRouterProvider.otherwise('/billeteras');-->


                        $stateProvider
                            .state('billeteras', {
                                url:'/billeteras',
                                views: {
                                    'mainView': {
                                        templateUrl: 'src/modules/billeteras/billeteras.list.html',
                                        controller: 'billeteraCtrl'}
                                }


                            });


                   }
                ]);
 })(window.angular);