(function (ng) {
        var mod = ng.module("reclamoModule");
        mod.constant("reclamoContext", "api/reclamos");
        mod.controller('empleadoUpdateCtrl', ['$scope', '$http', 'reclamoContext', '$state', '$rootScope',

            function ($scope, $http, reclamoContext, $state, $rootScope) {
                $rootScope.edit = true;

                var idReclamo= $state.params.reclamoId;

                $http.get(reclamoContext + '/' + idReclamo).then(function (response) {
                    var reclamo = response.data;
                    $scope.reclamoId = reclamo.id;
                    $scope.reclamoNumero = reclamo.numero;
                    $scope.reclamoMensaje = reclamo.mensaje;

                });
                console.log("hola");
                $scope.createEmpleado = function () {
                    console.log($scope.empleadoNombre);
                    $http.put(reclamoContext + "/" + idReclamo, {
                        id: $scope.reclamoId,
                        numero: $scope.reclamoNumero,
                        mensaje: $scope.reclamoMensaje
                    }).then(function (response) {
                        //Empleado created successfully
                        $state.go('reclamosList', {reclamoId: response.data.id}, {reload: true});
                    });
                };
            }
        ]);
    }
)(window.angular);