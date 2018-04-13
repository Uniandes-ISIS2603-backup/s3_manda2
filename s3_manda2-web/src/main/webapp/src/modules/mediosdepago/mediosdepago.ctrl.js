(function (ng){
    var mod = ng.module('mediodepagoModule');
    mod.controller('mediodepagoCtrl', ['$scope', '$http', 'mediosdepagoContext', '$state',
    function($scope, $http, mediosdepagoContext, $state){
        $http.get('data/mediosdepago/{{}}').then(function(response))
    }]);
})(window.angular)