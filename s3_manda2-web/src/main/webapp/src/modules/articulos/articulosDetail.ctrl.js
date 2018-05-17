(function (ng) {
        var mod = ng.module("articulosModule");
        mod.constant("articulosContext", "api/articuloss");
        mod.controller('articulosDetailCtrl', ['$scope', '$http', 'articulosContext', '$state',
            function ($scope, $http, articulosContext, $state) {
                if (($state.params.articulosRutaImagen !== undefined) && ($state.params.articulosRutaImagen !== null)) {
                    $http.get(articulosContext + '/' + $state.params.articulosRutaImagen).then(function (response) {
                        $scope.articulosActual = response.data;
                        console.log($scope.articulosActual);
                    });
                }
            }
        ]);
    }
)(window.angular);