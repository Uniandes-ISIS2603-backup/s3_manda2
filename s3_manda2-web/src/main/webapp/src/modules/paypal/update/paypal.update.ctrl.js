(function (ng) {
    var mod = ng.module('paypalModule');
    mod.constant('paypalContext', 'api/paypals');
    mod.controller('paypalUpdateCtrl', ['$scope', '$http', 'paypalContext', '$state', '$rootScope',
        function ($scope, $http, paypalContext, $state, $rootScope) {
            $rootScope.update = true;
            var idPaypal = $state.params.idPaypal;
            $scope.data = {'id': 1};

            $scope.createPaypal = function () {
                $http.put(paypalContext + '/' + idPaypal, $scope.data).then(function (response) {
                    $state.go('paypalList', {idPaypal: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);