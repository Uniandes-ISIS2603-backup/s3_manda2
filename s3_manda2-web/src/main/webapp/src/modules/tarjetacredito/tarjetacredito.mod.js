(function (ng) {
    var mod = ng.module('tarjetacreditoModule', ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/tarjetacredito/';

            $urlRouterProvider.otherwise('tarjetacredito');

            $stateProvider.state('mediodepagoList.tarjetacreditoDetail', {
                url: 'tarjetacredito',
                views: {
                    'mediodepagoDetail': {
                        templateUrl: basePath + 'tarjetacredito.detail.html',
                        controller: 'tarjetacreditoDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
