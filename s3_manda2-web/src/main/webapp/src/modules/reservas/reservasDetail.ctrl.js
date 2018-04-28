(function (ng) {
        var mod = ng.module("reservasModule");
        mod.constant("reservasContext2", "api/reservas");
        mod.controller('reservasDetailCtrl', ['$scope', '$http', 'reservasContext2',
            function ($scope, $http, reservasContext2) {
                $http.get('data/reservasDetail.json').then(function (response) {
                    $scope.reservasDetailRecords = response.data;
                });
            }
        ]);
    }
)(window.angular);