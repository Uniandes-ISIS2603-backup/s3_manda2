(function (ng) {
    var mod = ng.module("reclamoModule");
    mod.constant("reclamoContext", "api/reclamo");
    mod.controller('reclamoUpdateCtrl', ['$scope', '$http', 'reclamoContext', '$state', '$rootScope',

        function ($scope, $http, reclamoContext, $state, $rootScope) {
            $rootScope.edit = true;
            var id = $state.params.reclamoId;

            $http.get(reclamoContext + '/' + id).then(function (response) {
                var reclamo = response.data;
                $scope.reclamoId = reclamo.id;
                $scope.reclamoNumero = reclamo.nombre;
                $scope.reclamoMensaje = reclamo.mensaje;
            });
            $scope.createReclamo = function () {
                $http.put(reclamoContext + "/" + id, {
                    id: $state.params.id,
                    numero: $scope.reclamoNumero,
                    mensaje: $scope.reclamoMensaje
                    
                }).then(function (response) {
                   $state.go('reclamosList', {id: response.data.id}, {reload: true});   
                });
            };
        }]);
}
)(window.angular);