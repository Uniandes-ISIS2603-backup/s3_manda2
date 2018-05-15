(function (ng) {
    var mod = ng.module('pseModule');
    mod.constant('pseContext', 'api/pses');
    mod.controller('pseUpdateCtrl', ['$scope', '$http', 'pseContext', '$state', '$rootScope',
        function ($scope, $http, pseContext, $state, $rootScope) {
            $rootScope.update = true;
            var idPse = $state.params.idPse;
            $scope.data = {'id': 1};

            $scope.createPse = function () {
                $http.put(pseContext + '/' + idPse, $scope.data).then(function (response) {
                    $state.go('pseList', {idPse: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);