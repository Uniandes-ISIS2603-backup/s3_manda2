(function (ng) {
    var mod = ng.module('paypalModule');
    mod.constant('paypalContext', 'api/paypals');
    mod.controller('paypalUpdateCtrl', '$scope', '$http', 'paypalContext', '$state',
            function ($scope, $http, paypalContext, $state) {
                var idPaypal = $state.params.idPaypal;
                $scope.data = {};
                
                $scope.updatedPaypal = {
                    'id': idPaypal,
                    'nombreCliente': $state.params.nombreCliente,
                    'linkPayPal': $state.params.linkPaypal
                };
                $scope.updatePaypal = function () {
                    $http.put(paypalContext + '/' + idPaypal, $scope.updatedPaypal).then(function (response) {
                        $state.go('paypalList', {idPaypal: response.data.id}, {reload: true});
                    })
                };
            });
})(window.angular);