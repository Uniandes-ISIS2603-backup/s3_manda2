/**Clase reservas*/
(function (ng) {
    var mod = ng.module('reservasModule', ['ui.router']);
    /*constante que da el vinculo a reservas*/
    mod.constant("compraContext", "api/servicios");
    mod.config(['$stateProvider', '$urlRouterProvider', function ($stateProvider, $urlRouteProvider) {
        var basePath = 'src/modules/reservas/';
<<<<<<< HEAD
=======
        /*El scope que se encarga de manejar la ruta de reservas*/
        $urlRouteProvider.otherwise('reservas');
>>>>>>> master
        $stateProvider
            .state('reservasList', {
                url: '/reservas',
                views: {
                    /**Se encarga de vincular reservas al mainview para que aparezca en el index este tipo de servicio*/
                    'mainView': {
                        templateUrl: basePath + 'reservas.list.html',
                        controller: 'reservasListCtrl',
                        controllerAs: 'ctrl'
                    }
                }
            })
            /**Estado para crear un areserva*/
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
                    "mainView": {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: 'reservasCreateCtrl'
                    }
                }
            })
            /**Estado paraotener la informacion de una reserva*/
            .state('reservasDetail', {
                url: '/reservas/{id_reserva}',
                params: {
                    id_reserva: null

                },
                views: {
                    'mainView': {
                        templateUrl: basePath + 'reservas.detail.html',
                        controller: 'reservasDetailCtrl'
                    }
                }

            });
    }
    ]);
})(window.angular);