(function (ng) {
    var mod = ng.module('articulosModule', ['ui.router']);

    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouterProvider) {
        var basePath = 'src/modules/articulos/';

        $urlRouterProvider.otherwise('articulosList');

        $stateProvider.state('articulosList', {
            url: '/articulos',
            views: {
                'mainView': {
                    templateUrl: basePath + 'articulos.list.html',
                    controller: 'articulosListCtrl',
                    controllerAs: 'ctrl'
                }
            }
        }).state('articulosCreate', {
            url: '/articulo/create',
            params: {
                nombreArticulo: null,
                rutaImagen: null,
                precio: null
            },
            views: {
                'mainView': {
                    templateUrl: basePath + 'create/articulos.detail.html',
                    controller: 'articulosCreateCtrl'
                }
            }
        }).state('articulosUpdate', {
            url: '/update/{idArticulos:int}',
            param: {
                idArticulos: null
            },
            views: {
                'mainView': {
                    templateUrl: basePath + 'create/articulos.create.html',
                    controller: 'articulosUpdateCtrl'
                }
            }
        }).state('articulosDelete', {
            url: '/delete/{idArticulos:int}',
            param: {
                idArticulos: null
            },
            views: {
                'detailView': {
                    templateUrl: basePath + 'delete/articulos.delete.html',
                    controller: 'articulosDeleteCtrl'
                }
            }
        });
    }]);
})(window.angular);
