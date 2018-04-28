(function (ng) {
    var mod = ng.module('paypalModule', ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/paypal/';

//            $urlRouterProvider.otherwise('paypal');

            $stateProvider.state('paypalList', {
                url: 'paypals',
                views: {
                    'mainView' : {
                        templateUrl: basePath + 'paypal.list.html',
                        controller: 'paypalListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }).state('paypalCreate', {
                url: '/create',
                views: {
                    'mainView': {
                        templateUrl: basePath + 'create/paypal.create.html',
                        controller: 'paypalCreateCtrl'
                    }
                }
            }).state('paypalUpdate', {
                url: '/update/{idPaypal:int}',
                param: {
                    idPaypal: null
                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'create/paypal.create.html',
                        controller: 'paypalUpdateCtrl'
                    }
                }
            }).state('paypalDelete', {
                url: '/delete/{idPaypal:int}',
                param: {
                    idPaypal: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'delete/paypal.delete.html',
                        controller: 'paypalDeleteCtrl'
                    }
                }
            });
        }]);
})(window.angular);
