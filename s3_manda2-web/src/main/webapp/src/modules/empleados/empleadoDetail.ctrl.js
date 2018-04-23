(function (ng) {
    var mod = ng.module("empleadoModule");
    mod.constant("empleadoContext2", "api/empleados");
    mod.controller('empleadoDetailCtrl', ['$scope', '$http', 'empleadoContext2',
        function ($scope, $http, empleadoContext2) {
            $http.get('data/empleadoDetail.json').then(function (response) {
                $scope.empleadoDetailRecords = response.data;
            });
        }
    ]);
}
)(window.angular);
