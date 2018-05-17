(function (ng) {
        var mod = ng.module("articulosModule");
        mod.constant("articulosContext", "api/articulos");
        mod.controller('articulosDeleteCtrl', ['$scope', '$http', 'articulosContext', '$state',

            function ($scope, $http, articulosContext, $state) {
                var rutaImagenArticulos = $state.params.articulosRutaImagen;

                $scope.deleteArticulos = function () {
                    $http.delete(articulosContext + '/' + rutImagenArticulos, {}).then(function (response) {
                        $state.go('articulosList', {articulosId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);