(function (ng){
    var mod = ng.module("compraModule", ['ui.router']);
    
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
           var basePath = 'src/modules/compraentienda/' ;
           
            $urlRouterProvider.otherwise("");
            
            $stateProvider.state ('comprastiendaList',{
                url: '/compraentienda/lista',
                  views: { 
                    'mainView': {
                        templateUrl: basePath + 'compraentienda.list.html',
                        controller: 'compraCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            }); 
        }          
    ]);
})(window.angular);

