(function (ng) {
    var mod = ng.module('articulosModule');
    mod.constant('articulosContext', 'api/articulos');
    mod.controller('articulosCreateCtrl', ['$scope', '$http', 'articulosContext', '$state', '$stateParams',
        function ($scope, $http, articulosContext, $state, $stateParams) {
            $http({
                method: 'POST',
                url: articulosContext,
                data: $stateParams
            }).then(function (response) {
                $scope.articuloActual = response.data;
            });
        }]);
})(window.angular);