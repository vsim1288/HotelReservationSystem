var app = angular.module('hotel-directives', []);

app.directive("home", function() {
	return {
		rectrict: 'E',
		templateUrl: "home.html"
	};
});

app.directive("booking", function() {
	return {
		restrict: 'E',
		templateUrl: "booking.html"
	};
});

app.directive("gallery", function() {
	return {
		restrict: 'E',
		templateUrl: "gallery.html"
	};
});

app.directive("contact", function() {
	return {
		restrict: 'E',
		templateUrl: "contact.html"
	}
});

app.directive("pageTabs", function() {
	return {
		restrict: 'E',
		templateUrl: "page-tabs.html",
		controller: function() {
			this.tab = 1;
			
			this.isSet = function(checkTab) {
				return this.tab === checkTab;
			};
			
			this.setTab = function(activeTab) {
				this.tab = activeTab;
			};
		},
		controllerAs: "tab"
	};
});