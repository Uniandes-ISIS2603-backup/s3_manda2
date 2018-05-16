(function (ng) {
    var mod = ng.module('paypalModule');
    mod.constant('paypalContext', 'api/paypals');
    mod.controller('paypalCreateCtrl', ['$scope', '$http', 'paypalContext', '$state',
        function ($scope, $http, paypalContext, $state) {
            $scope.data = {'id': 1};

            $scope.createPaypal = function () {
                $http.post(paypalContext, $scope.data).then(function (response) {
                    $state.go('paypalList', {idPaypal: response.id}, {reload: true});
                });
            };
        }]);
})(window.angular);