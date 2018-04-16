(function (ng) {
    var mod = ng.module('pseModule', ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/pse/';

            $urlRouterProvider.otherwise('pse');

            $stateProvider.state('mediodepagoList.pseDetail', {
                url: 'pse',
                views: {
                    'mediodepagoDetail': {
                        templateUrl: basePath + 'pse.detail.html',
                        controller: 'pseDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
        }]);
})(window.angular);
