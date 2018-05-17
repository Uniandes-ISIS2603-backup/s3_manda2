(function (ng) {
    var mod = ng.module('reservasModule', ['ui.router']);
    mod.constant("compraContext", "api/servicios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouteProvider) {
        var basePath = 'src/modules/reservas/';
        $stateProvider
            .state('reservasList', {
                url: '/reservas',
                views: {
                    'serviciosIndexView': {
                        templateUrl: basePath + 'reservas.list.html',
                        controller: 'reservasListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            .state('reservasCrear', {
                url: "/reservas/crear",
                params: {
                    "type": null,
                    "calificacion": null,
                    "costo": null,
                    "descripcion": null,
                    "estado": null,
                    "id": null,
                    "nombre": null,
                    "puntoDeEncuentro": null,
                    "puntoDeRealizacion": null,
                    "costoDuracion": null,
                    "costoTransporte": null


                },
                views: {
                    "serviciosIndexView": {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: 'reservasCreateCtrl'
                    }
                }
            })
            .state('reservasDetail', {
                url: '/reservas/{id_reserva}',
                params: {
                    id_reserva: null

                },
                views: {
                    'serviciosIndexView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: 'reservasDetailCtrl'
                    }
                }

            });
    }
    ]);
})(window.angular);