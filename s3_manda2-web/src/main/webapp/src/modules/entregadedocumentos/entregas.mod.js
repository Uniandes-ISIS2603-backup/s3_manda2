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
            
            $stateProvider.state('entregaDetail', {
                url: '/{entregaId:int}/entregaDetail',
                parent: 'entregas',
                param: {
                    entregaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'entregas.list.html',
                        controller: 'entregaCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'entregas.detail.html',
                        controller: 'entregaDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('entregasCreate', {
                url: '/create',
                parent: 'entregas',
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/entregas.new.html',
                        controller: 'entregaNewCtrl'
                    }
                    
                }

            });
            $stateProvider.state('entregaUpdate', {
                url: '/update/{entregaId:int}',
                parent: 'entregas',
                param: {
                    entregaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/entregas.new.html',
                        controller: 'entregasUpdateCtrl'
                    }
                    
                }

            });
            $stateProvider.state('entregaDelete', {
                url: '/delete/{entregaId:int}',
                parent: 'entregas',
                param: {
                    entregaId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/delete/entregas.delete.html',
                        controller: 'entregaDeleteCtrl'
                    }
                    
                }

            }); 
        }]);
})(window.angular);
