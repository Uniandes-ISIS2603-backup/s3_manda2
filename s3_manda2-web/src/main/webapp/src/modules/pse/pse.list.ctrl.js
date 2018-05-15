(function (ng) {
    var mod = ng.module('pseModule');
    mod.constant('pseContext', 'api/pses');
    mod.controller('pseListCtrl', ['$scope', '$http', 'pseContext',
        function ($scope, $http, pseContext) {
            $http.get(pseContext).then(function (response) {
                $scope.pseRecords = response.data;
            });
        }
    ]);
})(window.angular);
