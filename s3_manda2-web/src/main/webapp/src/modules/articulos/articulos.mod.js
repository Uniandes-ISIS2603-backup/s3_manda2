(function (ng) {

    var mod = ng.module("articulosModule", ['ui.router']);
    mod.constant("articulosContext", "api/articulos");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {

            var basePath = 'src/modules/articulos/';

            $stateProvider.state('articulos', {
                url: '/articulos',
                abstract: true,
                views: {
                    'articulosView': {
                        templateUrl: basePath + 'articulos.html',
                        controller: 'articulosCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            });

            $stateProvider.state('articulosList', {

                url: '/list',
                parent: 'articulos',
                views: {
                    'listView': {
                        templateUrl: basePath + 'articulos.list.html',
                    }
                }
            });
            $stateProvider.state('articulosDetail', {
                url: '/{articulosRutaImagen:string}/detail',
                parent: 'articulos',
                param: {
                    articulosId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + 'articulos.list.html',
                        controller: 'articulosCtrl',
                        controllerAs: 'ctrl'
                    },
                    'detailView': {
                        templateUrl: basePath + 'articulos.detail.html'
                    }
                }

            });
            $stateProvider.state('articulosSubDetail', {
                url: '/datosPersonales',
                parent: 'articulosDetail',
                views: {
                    'articulosView': {
                        templateUrl: basePath + 'articulos.SubDetail.html',
                        controller: 'articulosDetailCtrl',
                        controllerAs: 'ctrl'
                    }

                }

            });
            
            $stateProvider.state('articulosCreate', {
                url: '/create',
                parent: 'articulos',
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/articulos.new.html',
                        controller: 'articulosNewCtrl'
                    }

                }

            });
            $stateProvider.state('articulosUpdate', {
                url: '/update/{articulosRutaImagen:int}',
                parent: 'articulos',
                param: {
                    articulosId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/new/articulos.new.html',
                        controller: 'articulosUpdateCtrl'
                    }

                }

            });
            $stateProvider.state('articulosDelete', {
                url: '/delete/{articulosRutaImagen:int}',
                parent: 'articulos',
                param: {
                    articulosId: null
                },
                views: {
                    'listView': {
                        templateUrl: basePath + '/delete/articulos.delete.html',
                        controller: 'articulosDeleteCtrl'
                    }

                }

            });
        }]);
})(window.angular);
