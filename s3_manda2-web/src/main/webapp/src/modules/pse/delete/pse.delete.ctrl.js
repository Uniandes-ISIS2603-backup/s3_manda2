(function (ng) {
    var mod = ng.module('pseModule');
    mod.constant('pseContext', 'api/pses');
    mod.controller('pseDeleteCtrl', ['$scope', '$http', 'pseContext', '$state',
        function ($scope, $http, pseContext, $state) {
            var idPse = $state.params.idPse;

            $scope.deletePse = function () {
                $http.delete(pseContext + '/' + idPse, {}).then(function (response) {
                    $state.go('pseList', {idPse: response.data.id}, {reload: true});
                });
            };
        }]);
})(window.angular);