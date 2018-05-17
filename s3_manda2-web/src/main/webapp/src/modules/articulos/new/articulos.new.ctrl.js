(function (ng) {
        var mod = ng.module("articulosModule");
        mod.constant("articulosContext", "api/articulos");
        mod.controller('articulosNewCtrl', ['$scope', '$http', 'articulosContext', '$state', '$rootScope',

            function ($scope, $http, articulosContext, $state, $rootScope) {
                $rootScope.edit = false;

                $scope.data = {};

                $scope.createArticulos = function () {
                    $http.post(articulosContext, {
                        rutaImagen: $scope.articulosRutaImagen,
                        nombre: $scope.articulosNombre,
                        precio: $scope.articulosPrecio,
                       
                    }).then(function (response) {
                        $state.go('articulosList', {articulosId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);