(function (ng) {
    
    var mod = ng.module("reclamoModule", ['ui.router']);
    mod.constant("reclamoContext", "api/reclamos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/reclamos/';
            
            $stateProvider.state('reclamos', {
                 url: '/reclamos/',
                abstract: true,
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reclamos.html',
                        controller: 'empleadoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('reclamosList', {
                
                url: 'list',
                parent:'reclamos',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'reclamos.list.html',
                        controller: 'reclamoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('reclamoDetail', {
                url: '/{reclamoId:int}/detail',
                parent:'reclamos',
                param: {
                    reclamoId:null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'reclamos.list.html',
                        controller: 'reclamoCtrl',
                        controllerAs: 'ctrl'
                    },
                    'mainView': {
                        templateUrl: basePath + 'reclamo.detail.html',
                        controller: 'reclamoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('reclamoDetail2', {
                url: '/datosReclamo',
                parent:'reclamos',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reclamo.detail.html',
                        controller: 'reclamoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('reclamoCreate', {
                url: '/create',
                parent:'reclamos',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'create/reclamo.create.html',
                        controller: 'reclamoCreateCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('borrarReclamo', {
                url: '/delete/{reclamoId:int}',
                parent:'reclamos',
                param: {
                    empleadoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'delete/reclamo.delete.html',
                        controller: 'reclamoDeleteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('updateReclamo',{
               url: '/update/{reclamoId:int}',
                parent:'reclamos',
                param: {
                    empleadoId: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'create/reclamo.create.html',
                        controller: 'reclamoUpdateCtrl',
                        controllerAs: 'ctrl'
                    }
                } 
            });
        }]);
})(window.angular);
