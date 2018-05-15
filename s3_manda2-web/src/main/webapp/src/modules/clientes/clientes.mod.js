
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
(function (ng) {
    
    var mod = ng.module("clienteModule", ['ui.router']);
    mod.constant("clientesContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/clientes/';
            
            $stateProvider.state('clientes', {
                url: '/clientes',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            
            $stateProvider.state('clientesList', {
                
                url: '/list',
                parent: 'clientes',
                 views: {
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html',
                    }
                }
            });
            $stateProvider.state('clienteDetail', {
                url: '/{clienteId:int}/detail',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'clientes.list.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'cliente.detail.html'
                    }
                }

            });
            $stateProvider.state('clienteSubDetail', {
                url: '/datosPersonales',
                parent: 'clienteDetail',
                views: {
                    'clienteView': {
                        templateUrl: basePath + 'cliente.SubDetail.html',
                        controller: 'clienteDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                    
                }

            });
            $stateProvider.state('clientesCreate', {
                url: '/create',
                parent: 'clientes',
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/clientes.new.html',
                        controller: 'clienteNewCtrl'
                    }
                    
                }

            });
            $stateProvider.state('clienteUpdate', {
                url: '/update/{clienteId:int}',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/clientes.new.html',
                        controller: 'clienteUpdateCtrl'
                    }
                    
                }

            });
            $stateProvider.state('clienteDelete', {
                url: '/delete/{clienteId:int}',
                parent: 'clientes',
                param: {
                    clienteId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/delete/clientes.delete.html',
                        controller: 'clienteDeleteCtrl'
                    }
                    
                }

            });
        }]);
})(window.angular);
