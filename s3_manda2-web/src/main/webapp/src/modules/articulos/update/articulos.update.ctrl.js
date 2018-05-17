(function (ng) {
        var mod = ng.module("articulosModule");
        mod.constant("articulosContext", "api/articulos");
        mod.controller('articulosUpdateCtrl', ['$scope', '$http', 'articulosContext', '$state', '$rootScope',

            function ($scope, $http, articulosContext, $state, $rootScope) {
                $rootScope.edit = true;

                var idArticulos = $state.params.articulosId;

                $http.get(articulosContext + '/' + idArticulos).then(function (response) {
                    var articulos = response.data;
                    $scope.articulosRutaImagen = articulos.idRutaImagen;
                    $scope.articulosNombre = articulos.nombre;
                    $scope.articulosPrecio = articulos.precio;
                   
                });
                $scope.createArticulos = function () {
                    console.log($scope.articulosNombre);
                    console.log($scope.articulosCedula);
                    $http.put(articulosContext + "/" + idArticulos, {
                        rutaImagen: $state.params.articulosRutaImagen,
                        nombre: $scope.articulosNombre,
                        precio: $scope.articulosPrecio,
                       
                    }).then(function (response) {
                        //Author created successfully
                        $state.go('articulosList', {articulosRutaImagen: response.data.rutaImagen}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);