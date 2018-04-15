(function (ng){
    var mod = ng.module('mediodepagoModule', ['ui-router']);
    mod.constant('mediodepagoContext', 'api/mediosdepago');
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
        var basePath = 'src/modules/mediodepago/';
        $urlRouterProvider.otherwise('mediodepagoList');
        
        $stateProvider.state('mediodepagoList', {
            url: 'mediosdepago',
            abstract: true,
            views: {
                //Cambiar el nombre por ListView!!!
                'mainView': {
                    templateUrl: basePath + 'mediodepago.list.html',
                    controller: 'mediodepagoCtrl',
                    controllerAs: 'ctrl'
                }
            }
        });
    }]);
})(window.angular);