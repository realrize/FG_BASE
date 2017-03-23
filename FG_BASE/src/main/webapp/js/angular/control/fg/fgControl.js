/**
 * 
 */

var app = angular.module('app', []);

app.controller('MainCtrl', function($scope){
	$scope.message = 'World';
	
	$scope.data = {
		selectData: []	
	};
	
	$scope.country={};
	
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
		template: '<select name="select"  ng-model="selData" ng-options="d.id as d.name for d in data.selectData"></select>',
        link:function(scope, elem, attrs){
    		var obj = {};
    		obj.id = '1';
    		obj.name = '홍길동';
    		scope.data['selectData'].push(obj);
    		var obj = {};
    		obj.id = '2';
    		obj.name = '김길동';
    		scope.data['selectData'].push(obj);
    		
    		scope.selData = '2';
        }
	};
});

app.directive('sel', function() {
    return {
      template: '<select ng-model="selectedValue" ng-options="c.name for c in countries"></select>',
      restrict: 'E',
      scope: {
         selectedValue: '='
      },
      link:function(scope,elem,attrs){
         scope.countries = [
		      {name:'Vereinigte Arabische Emirate', value:'AE'},
		     {name:'Andorra', value:'AD'},
		];
         scope.selectedValue=scope.countries[1];
      }
    };
});
