(function (ng) {
    var mod = ng.module('paypalModule');
    mod.constant('paypalContext', 'api/paypals');
    mod.controller('paypalListCtrl', ['$scope', '$http', 'paypalContext',
        function ($scope, $http, paypalContext) {
            $http.get(paypalContext).then(function (response) {
                $scope.paypalRecords = response.data;
            });
        }
    ]);
})(window.angular);
