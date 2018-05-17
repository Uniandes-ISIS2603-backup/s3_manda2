(function (ng) {
    var mod = ng.module("vueltaModule", ['ui.router']);
    mod.constant("vueltaContext", "api/vueltascondemoraenoficina");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        var basePath = 'src/modules/vueltascondemoraenoficina/';
        
        $stateProvider.state('vueltas', {
                url: '/vueltas',
                views: {
                    'serviciosIndexView': {
                        templateUrl: basePath + 'vueltas.html',
                        controller: 'vueltaCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });


        $stateProvider.state('vueltacondemoraList', {
            url: '/vueltascondemoralist',
            parent: 'vueltas',
            views: {
                'listView': {
                    templateUrl: basePath + 'vueltascondemora.lista.html',
                    controller: 'vueltaCtrl',
                    controllerAs: 'ctrl'
                }
            }
        });
            $stateProvider.state('vueltacondemoraAgregar', {
                url: '/create',
                views: {
                    'serviciosIndexView': {
                        templateUrl: basePath + 'create/vueltacondemora.create.html',
                        controller: 'vueltaCreateCtrl'
                    }
                }
            });
            
            $stateProvider.state('vueltasUpdate', {
                url: '/update/{vueltaId:int}',
                parent: 'vueltas',
                param: {
                    vueltaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + '/create/vueltacondemora.create.html',
                        controller: 'vueltaUpdateCtrl'
                    }

                }

            });
            
            $stateProvider.state('vueltacondemoraDelete', {
                url: '/delete/{vueltaId:int}',
                parent: 'vueltas',
                param: {
                    vueltaId: null
                },
                views: {
                    'detailView': {
                        templateUrl: basePath + 'delete/vueltacondemora.delete.html',
                        controller: 'vueltaDeleteCtrl',
                        controllerAs:'ctrl'
                    }
                }
            }) ;
            $stateProvider.state('vueltasDetail', {
                url: '/{vueltaId:int}/vueltasDetail',
                parent: 'vueltas',
                param: {
                    vueltaId: null
                },
                views: {
                        'listView': {
                            templateUrl: basePath + 'vueltascondemora.lista.html',
                            controller: 'vueltaCtrl',
                            controllerAs: 'ctrl'
                        },
                        'detailView': {
                            templateUrl: basePath + 'vueltascondemora.detail.html',
                            controller: 'vueltasDetailCtrl',
                            controllerAs: 'ctrl'
                        }
                }

            });

    }
    ]);
})(window.angular);
 