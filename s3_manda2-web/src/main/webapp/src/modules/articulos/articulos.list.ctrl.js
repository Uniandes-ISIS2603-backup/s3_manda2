(function(ng){
    var mod = ng.module('articulosModule');
    mod.constant('articulosContext', 'api/articulos');
    mod.controller('articulosListCtrl', ['$scope', '$http', 'articulosContext',
        function($scope, $http, articulosContext){
            $http.get(articulosContext).then(function(response){
                $scope.articulosRecords = response.data;
            });
        }
    ]);
})(window.angular);
