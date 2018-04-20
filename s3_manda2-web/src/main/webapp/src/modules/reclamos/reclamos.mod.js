(function (ng) {
    
    var mod = ng.module("reclamoModule", ['ui.router']);
    mod.constant("reclamoContext", "api/reclamos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/reclamos/';
            
            $urlRouterProvider.otherwise("/reclamosList");
            
            $stateProvider.state('reclamosList', {
                
                url: '/reclamos/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'reclamos.list.html',
                        controller: 'reclamoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('reclamoDetail', {
                url: '/reclamos/list/detail',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reclamos.list.html',
                        controller: 'reclamoCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'reclamo.detail.html',
                        controller: 'reclamoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('reclamoDetail2', {
                url: '/reclamos/list/detail',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'reclamo.detail.html',
                        controller: 'reclamoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
        }]);
})(window.angular);
