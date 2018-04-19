(function (ng) {
    
    var mod = ng.module("clienteModule", ['ui.router']);
    mod.constant("clientesContext", "api/clientes");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            
            var basePath = 'src/modules/clientes/';
            
            $urlRouterProvider.otherwise("/clientesList");
            
            $stateProvider.state('clientesList', {
                
                url: '/clientes/list',
                 views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.list.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
            $stateProvider.state('clienteDetail', {
                url: '/clientes/list/detail',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'clientes.list.html',
                        controller: 'clienteCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'cliente.detail.html',
                        controller: 'clienteDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('clienteDetail2', {
                url: '/clientes/list/detail',
                views: {
                    'detailView': {
                        templateUrl: basePath + 'cliente.detail.html',
                        controller: 'clienteDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }

            });
            $stateProvider.state('clienteSubDetail', {
                url: '/clientes/list/detail/datosPersonales',
                parent: 'clienteDetail',
                views: {
                    'clienteView': {
                        templateUrl: basePath + 'cliente.SubDetail.html',
                        controller: 'clienteDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                    
                }

            });
        }]);
})(window.angular);
