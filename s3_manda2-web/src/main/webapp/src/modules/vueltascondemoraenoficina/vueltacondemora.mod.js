(function (ng) {
    var mod = ng.module("vueltaModule", ['ui.router']);
     mod.constant("vueltaContext", "data/vueltas.json");
   mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
            var basePath = 'src/modules/vueltascondemoraenoficina/';
            
             $stateProvider.state('vueltacondemoraList', {
                 url: '/vueltascondemoraenoficina',
                  views: {
                      'mainView': { 
                          templateUrl: basePath + 'vueltacondemora.list.html',
                          controller: 'vueltaCtrl',
                          controllerAs: 'ctrl'
                      }
                  }
             } )
             $stateProvider.state('vueltacondemoraList2',{
                  url: '/vueltascondemoraenoficina',
                   views: { 
                       'detailView': {
                          templateUrl: basePath + 'vueltascondemora.list2.html',
                          controller: 'vueltaCtrl',
                          controllerAs: 'ctrl'
                           
                       }
                   }
             })
              
             $stateProvider.state('vueltacondemoraList3',{
                  url: '/vueltascondemoraenoficina',
                   views: { 
                       'detailView': {
                          templateUrl: basePath + 'vueltascondemora.list3.html',
                          controller: 'vueltaCtrl',
                          controllerAs: 'ctrl'
                           
                       }
                   }
             })
                     
             $stateProvider.state('vueltacondemoraLista',{
                  url: '/vueltascondemoraenoficina/list',
                   views: { 
                       'mainView': {
                          templateUrl: basePath + 'vueltascondemora.lista.html',
                          controller: 'vueltaCtrl',
                          controllerAs: 'ctrl'
                           
                       }
                   }
             }
           );
         }    
   ]  );
})(window.angular);
   

