(function (ng){
    
    //states
       // views
         //main view que defini antes en el index
         //controlador
         //template
    var mod = ng.module("compraModule", ['ui.router']);
    mod.constant("compraContext", "api/comprasentienda");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
           var basePath = 'src/modules/compraentienda/' ;
           
            $urlRouterProvider.otherwise("");
            
            $stateProvider.state ('comprastiendaList',{
                url: '/compraentienda',
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

