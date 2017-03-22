/**
 * 
 */

var app = angular.module('app', []);

app.controller('MainCtrl', function($scope){
	$scope.message = 'World';
	
});

/***
	Attribute, 예시: <div foo></div>
	Element, 예시: <foo></foo>
	Class, 예시: <div class="foo"></div>
	CoMment, 예시: <!-- directive: foo -->
 */
app.directive('customSelectBox', function(){
	return {
		restrict: 'E',
		template: '<select name="select" ng-options="d.id as d.name for d in data.selectData"></select>',
        link:function(scope,elem,attrs){
        	scope.data = {
    			selectData: []	
    		};
    		var obj = {};
    		obj.id = '1';
    		obj.name = '홍길동';
    		$scope.data['selectData'].push(obj);
    		var obj = {};
    		obj.id = '2';
    		obj.name = '김길동';
    		$scope.data['selectData'].push(obj);
    		console.log($scope.data.selectData);        	
        }
	}
});
