(function (ng) {
    var mod = ng.module('tarjetacreditoModule', ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetacredito/';

            $urlRouterProvider.otherwise('tarjetacredito');

            $stateProvider.state('tarjetacreditoList', {
                url: 'tarjetascredito',
                views: {
                    'mainView' : {
                        templateUrl: basePath + 'tarjetacredito.list.html',
                        controller: 'tarjetacreditoListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('tarjetacreditoDelete', {
                url: '/delete/{idTarjetacredito:int}',
                param: {
                    idTarjetacredito: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/tarjetacredito.delete.html',
                        controller: 'tarjetacreditoDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);
