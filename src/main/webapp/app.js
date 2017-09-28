(function() {
	var app = angular.module('hotelTristar', []);
	var images = ["images/hotel-1.jpg", "images/hotel-2.jpg", "images/hotel-3.jpg"];

	app.controller('GalleryController', function() {
		this.images = images;
		this.imageIndex = 0;
		this.currentImageChange = function(imageNumber) {
			console.log(imageNumber);
			this.imageIndex = imageNumber || 0;
		};
	});

	app.directive("home", function() {
		return {
			restrict : 'E',
			templateUrl : "/home.html"
		};
	});

	app.directive("booking", function() {
		return {
			restrict : 'E',
			templateUrl : "/booking.html"
		};
	});

	app.directive("gallery", function() {
		return {
			restrict : 'E',
			templateUrl : "/gallery.html"
		};
	});

	app.directive("contact", function() {
		return {
			restrict : 'E',
			templateUrl : "/contact.html"
		}
	});

	app.directive("pageTabs", function() {
		return {
			restrict : 'E',
			templateUrl : "/page-tabs.html",
			controller : function() {
				this.tab = 1;

				this.isSet = function(checkTab) {
					return this.tab === checkTab;
				};

				this.setTab = function(activeTab) {
					this.tab = activeTab;
				};
			},
			controllerAs : "tab"
		};
	});
})();