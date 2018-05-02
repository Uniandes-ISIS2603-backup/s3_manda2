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
           
           $stateProvider.state('compraentiendaList', {
                 url: '/comprasentienda',
                  views: {
                      'despliegueServicios': { 
                          templateUrl: basePath + 'compraentienda.list.html',
                          controller: 'vueltaCtrl',
                          controllerAs: 'ctrl'
                      }
                  }
             } )
           .state('compraentiendaCreate', {
                 url: '/create',
                  views: {
                      'despliegueServicios': { 
                          templateUrl: basePath + 'create/compraentienda.create.html',
                          controller: 'compraCreateCtrl'
                      }
                  }
             } )
             .state('compraentiendaDelete', {
                 url: '/delete/(idCompra:int)',
                 param: {
                     idCompra : null
                 },
                  views: {
                      'despliegueServicios': { 
                          templateUrl: basePath + 'delete/compraentienda.delete.html',
                          controller: 'compraDeleteCtrl',
                      }
                  }
             } ); 
        }          
    ]);
})(window.angular);

