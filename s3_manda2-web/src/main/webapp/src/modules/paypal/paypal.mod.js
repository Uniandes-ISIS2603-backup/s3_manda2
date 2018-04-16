(function(ng){
    var mod = ng.module('paypalModule', ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
            var basePath = 'src/modules/paypal/';
            
            $urlRouterProvider.otherwise('paypal');
            
            $stateProvider.state('payPalDetail', {
                url: 'paypal',
                views: {
                    'mediodepagoDetail': {
                        templateUrl: basePath + 'paypal.detail.html',
                        controller: 'paypalDetailCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });
    }]);
})(angular.window);
