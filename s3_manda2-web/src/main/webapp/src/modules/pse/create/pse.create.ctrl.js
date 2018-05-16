(function (ng) {
    var mod = ng.module('pseModule');
    mod.constant('pseContext', 'api/pses');
    mod.controller('pseCreateCtrl', ['$scope', '$http', 'pseContext', '$state',
        function ($scope, $http, pseContext, $state) {
            $scope.data = {'id': 1};

            $scope.createPse = function () {
                $http.post(pseContext, $scope.data).then(function (response) {
                    $state.go('pseList', {idPse: response.id}, {reload: true});
                });
            };
        }]);
})(window.angular);