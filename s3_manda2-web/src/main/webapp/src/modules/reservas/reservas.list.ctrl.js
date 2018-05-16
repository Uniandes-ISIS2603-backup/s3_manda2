(function (ng) {
    var mod = ng.module('reservasModule');
    mod.constant('reservasContext', 'api/organizaciones');
    mod.controller('reservasListCtrl', ['$scope', '$http', 'reservasContext',
        function ($scope, $http, reservasContext) {
            $http.get(reservasContext).then(function (response) {
                $scope.reservasRecords = response.data;
            });
        }
    ]);
})(window.angular);