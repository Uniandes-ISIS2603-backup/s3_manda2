(function (ng) {
    
    var mod = ng.module("entregaModule", ['ui.router']);
    mod.constant("entregasContext", "api/entregasdedocumentos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/entregadedocumentos/';
            
            $stateProvider.state('entregas', {
                url: '/entregas',
                abstract: true,
                views: {
                    'despliegueServicios': {
                        templateUrl: basePath + 'entregas.html',
                        controller: 'entregaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('entregasList', {
                
                url: '/list',
                parent: 'entregas',
                 views: {
                    'listView': {
                        templateUrl: basePath + 'entregas.list.html',
                    }
                }
            });
            /**
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
            */
        }]);
})(window.angular);
