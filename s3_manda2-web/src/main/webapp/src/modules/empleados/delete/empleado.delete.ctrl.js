(function (ng) {
    var mod = ng.module("empleadoModule");
    mod.constant("empleadoContext", "api/empleados");
    mod.controller('empleadoDeleteCtrl', ['$scope', '$http', 'empleadoContext', '$state',
        
        function ($scope, $http, empleadoContext, $state) {
            var idEmpleado = $state.params.empleadoId;
            
            $scope.deleteEmpleado = function () {
                $http.delete(empleadoContext + '/' + idEmpleado, {}).then(function (response) {
                    $state.go('empleadosList', {empleadoId: response.data.id}, {reload: true});
                });
            };
        }
    ]);
}
)(window.angular);