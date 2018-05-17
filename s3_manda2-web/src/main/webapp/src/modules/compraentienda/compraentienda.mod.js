(function (ng) {

    //states
    // views
    //main view que defini antes en el index
    //controlador
    //template
    var mod = ng.module("compraModule", ['ui.router']);
    mod.constant("compraContext", "api/comprasentienda");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        var basePath = 'src/modules/compraentienda/';

        $stateProvider.state('compraentiendaList', {
            url: '/compraentienda',
            views: {
                'serviciosIndexView': {
                    templateUrl: basePath + 'compraentienda.list.html',
                    controller: 'compraCtrl',
                    controllerAs: 'ctrl'
                }
            }
        })
            .state('compraentiendaCreate', {
                url: '/create',
                views: {
                    'serviciosIndexVew': {
                        templateUrl: basePath + 'create/compraentienda.create.html',
                        controller: 'compraCreateCtrl',
                        controllerAs:'ctrl'
                    }
                }
            })
            .state('compraentiendaDelete', {
                url: '/delete/(idCompra:int)',
                param: {
                    idCompra: null
                },
                views: {
                    'serviciosIndexView': {
                        templateUrl: basePath + 'delete/compraentienda.delete.html',
                        controller: 'compraDeleteCtrl',
                        controllerAs:'ctrl'
                    }
                }
            });
    }
    ]);
})(window.angular);

