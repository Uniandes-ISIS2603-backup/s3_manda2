(function (ng) {
    
    var mod = ng.module("empleadoModule", ['ui.router']);
    mod.constant("empleadoContext", "api/empleados");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/empleados/';
            
            $urlRouterProvider.otherwise("/empleadosList");
            
            $stateProvider.state('empleadosList', {
                
                url: '/empleados/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'empleados.list2.html',
                        controller: 'empleadoCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('empleadoDetail', {
                url: '/empleados/list/detail',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'empleados.list2.html',
                        controller: 'empleadoCtrl',
                        controllerAs: 'ctrl'
                    },
                    'mainView': {
                        templateUrl: basePath + 'empleado.detail.html',
                        controller: 'empleadoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('empleadoDetail2', {
                url: '/empleados/list/detail',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'empleado.detail.html',
                        controller: 'empleadoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('empleadoSubDetail', {
                url: '/empleado/list/detail/datosPersonales',
                parent: 'empleadoDetail',
                views: {
                    'empleadoView': {
                        templateUrl: basePath + 'empleado.Subdetail.html',
                        controller: 'empleadoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                    
                }

            });
        }]);
})(window.angular);
