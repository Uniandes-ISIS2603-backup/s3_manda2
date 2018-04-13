(function (ng){
    var mod = ng.module('mediodepagoModule', ['ui-router']);
    mod.constant('mediosdepagoContext', 'api/mediosdepago');
    mod.config(['$stateProvider', '$urlRouterProvider', function($stateProvider, $urlRouterProvider){
        var basePath = 'src/modules/mediosdepago/';
        $urlRouterProvider.otherwise('mediosdepagoList');
        
        $stateProvider.state('mediosdepagoList', {
            url: 'mediosdepago',
            abstract: true,
            views: {
                'listView': {
                    templateUrl: basePath + 'mediosdepago.list.html',
                    controller: 'mediodepagoCtrl',
                    controllerAs: 'ctrl'
                }
            }
        });
    }]);
})(window.angular)