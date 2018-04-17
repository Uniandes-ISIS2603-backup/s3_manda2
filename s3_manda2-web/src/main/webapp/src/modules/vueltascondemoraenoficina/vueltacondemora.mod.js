(function (ng) {
    var mod = ng.module("vueltaModule", ['ui.router']);
   mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/vueltascondemoraenoficina/';
            
             $stateProvider.state('vueltacondemoraList', {
                 url: '/vueltascondemoraenoficina/list',
                  views: {
                      'mainView': { 
                          templateUrl: basePath + 'vueltacondemora.list.html',
                          controller: 'vueltaCtrl',
                          controllerAs: 'ctrl'
                      }
                  }
             } );
         }    
   ]  );
})(window.angular);
   

