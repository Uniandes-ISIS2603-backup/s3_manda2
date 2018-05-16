(function (ng) {
    var mod = ng.module("vueltaModule", ['ui.router']);
    mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        var basePath = 'src/modules/vueltascondemoraenoficina/';

        $stateProvider.state('vueltacondemoraList', {
            url: '/vueltascondemoraenoficina',
            views: {
                'despliegueServicios': {
                    templateUrl: basePath + 'vueltascondemora.lista.html',
                    controller: 'vueltaCtrl',
                    controllerAs: 'ctrl'
                }
            }
        })
            .state('vueltacondemoraAgregar', {
                url: '/create',
                views: {
                    'despliegueServicios': {
                        templateUrl: basePath + 'create/vueltacondemora.create.html',
                        controller: 'vueltaCreateCtrl'
                    }
                }
            })
            .state('vueltacondemoraDelete', {
                url: '/delete/(idVuelta:int)',
                param: {
                    idVuelta: null
                },
                views: {
                    'despliegueServicios': {
                        templateUrl: basePath + 'delete/vueltacondemora.delete.html',
                        controller: 'vueltaDeleteCtrl',
                    }
                }
            })
        ;

    }
    ]);
})(window.angular);
 