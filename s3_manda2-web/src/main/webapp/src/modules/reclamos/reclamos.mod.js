(function (ng) {

    var mod = ng.module("reclamoModule", ['ui.router']);
    mod.constant("reclamoContext", "api/reclamos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

        var basePath = 'src/modules/reclamos/';

        $stateProvider.state('reclamosList', {

            url: '/reclamos',
            views: {
                'listReclamoView': {
                    templateUrl: basePath + 'reclamos.list.html',
                    controller: 'reclamoCtrl',
                    controllerAs: 'ctrl'
                }
            }
        });
        $stateProvider.state('reclamoDetail', {
            url: '/{reclamoId:int}/detail',
            param: {
                reclamoId: null
            },
            views: {
                'detailView': {
                    templateUrl: basePath + 'reclamos.list.html',
                    controller: 'reclamoCtrl',
                    controllerAs: 'ctrl'
                },
                'listReclamoView': {
                    templateUrl: basePath + 'reclamo.detail.html',
                    controller: 'reclamoDetailCtrl',
                    controllerAs: 'ctrl'
                }
            }

        });
        $stateProvider.state('reclamoDetail2', {
            url: '/datosReclamo',
            views: {
                'listReclamoView': {
                    templateUrl: basePath + 'reclamo.detail.html',
                    controller: 'reclamoDetailCtrl',
                    controllerAs: 'ctrl'
                }
            }

        });
        $stateProvider.state('reclamoCreate', {
            url: '/create',
            views: {
                'listReclamoView': {
                    templateUrl: basePath + 'create/reclamo.create.html',
                    controller: 'reclamoCreateCtrl',
                    controllerAs: 'ctrl'
                }
            }

        });
        $stateProvider.state('reclamoDelete', {
            url: '/delete/{reclamoId : int}',
            param:{
                reclamoId: null
            },
            views: {
                'listReclamoView': {
                    templateUrl: basePath + 'create/reclamo.create.html',
                    controller: 'reclamoDeleteCtrl'
                }
            }

        });
        $stateProvider.state('reclamoUpdate', {
            url: '/update/{reclamoId : int}',
            param:{
                reclamoId: null
            },
            views: {
                'listReclamoView': {
                    templateUrl: basePath + 'create/reclamo.create.html',
                    controller: 'empleadoUpdateCtrl',
                }
            }

        });
    }]);
})(window.angular);
