(function (ng) {
    
    var mod = ng.module("reclamoModule", ['ui.router']);
    mod.constant("reclamoContext", "api/reclamos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/reclamos/';
            
            $stateProvider.state('reclamosList', {
                
                url: '/reclamos',
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
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reclamo.detail.html',
                        controller: 'reclamoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
        }]);
})(window.angular);
