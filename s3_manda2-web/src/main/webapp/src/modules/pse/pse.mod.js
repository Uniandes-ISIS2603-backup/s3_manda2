(function (ng) {
    var mod = ng.module('pseModule', ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/pse/';

            $urlRouterProvider.otherwise('pse');

            $stateProvider.state('pseList', {
                url: 'pses',
                views: {
                    'mainView' : {
                        templateUrl: basePath + 'pse.list.html',
                        controller: 'pseListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('pseDelete', {
                url: '/delete/{idPse:int}',
                param: {
                    idPse: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/delete/pse.delete.html',
                        controller: 'pseDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);
