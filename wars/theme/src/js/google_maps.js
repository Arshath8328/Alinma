if(window.google){
	renderMap();
  } else{
	$.ajax('https://maps.googleapis.com/maps/api/js?key=AIzaSyBKTNSoVO9OcSG2HUDWiBz6ofr9mX-ekPY&callback=renderMap', {
	  crossDomain: true,
	  dataType: 'script'
	});
  }

function renderMap() {
	var $el = $('.acf-map');
	// var
	var $markers = $(document).find('.marker');
	// vars
	var args = {
		zoom        : 12,
		center      : new google.maps.LatLng(0, 0),
		mapTypeId   : google.maps.MapTypeId.ROADMAP,
		scrollwheel: false,
		mapTypeControlOptions: {
			mapTypeIds: [google.maps.MapTypeId.ROADMAP]
			}
		};
	// create map               
	var map = new google.maps.Map($el[0], args);
	// add a markers reference
	map.markers = [];
	map.infowindows = [];
	// add markers
	index=0;
	$markers.each(function(){
		add_marker($(this), map, index);
		index++;
	});
// center map
center_map(map);
}
function add_marker($marker, map, index) {
	// var
	var latlng = new google.maps.LatLng($marker.attr('data-lat'), $marker.attr('data-lng'));
	// create marker
	var marker = new google.maps.Marker({
		position    : latlng,
		map         : map
		});
	var zoomLevel = parseInt($marker.attr('data-zoom')); 
	map.setZoom(zoomLevel);
	map.panTo(marker.position);
	// add to array
	map.markers.push(marker);
	// if marker contains HTML, add it to an infoWindow
	if($marker.html()) {
		$marker.attr('id', 'p'+index);
		$(document).on('click', '#p'+index+' h3' , function(){
			$('#selectCity').val(index);
			$("div.marker").removeClass("active");
			$(this).parent("div").addClass("active");
			if(index == 0)
			{
				center_map(map);
			}else{
				if (map.infowindows.length)
                {
					for (index = 0; index < map.infowindows.length; ++index) {
						map.infowindows[index].close();
					}
				}
				infowindow.open(map, marker);
			center_map(map);
			}
			
		});
		// create info window
		var infowindow = new google.maps.InfoWindow({
			content     : $marker.html(),
		});
		map.infowindows.push(infowindow);
		// show info window when marker is clicked
		google.maps.event.addListener(marker, 'click', function() {
			infowindow.open(map, marker);
		});
	}
}
function center_map(map) {
	// vars
	var bounds = new google.maps.LatLngBounds();
	// loop through all markers and create bounds
	$.each( map.markers, function(i, marker){
		var latlng = new google.maps.LatLng(marker.position.lat(), marker.position.lng());
		bounds.extend( latlng );
	});
	// only 1 marker?
	if(map.markers.length == 1) {
		// set center of map
		alert(bounds);
		map.setCenter( bounds.getCenter() );
	}
	else {
		// fit to bounds
		map.fitBounds(bounds);
		//map.setZoom(10);
	}
}
$(document).on('click', '#selectCityBtn', function(){
	var locIndex = $('#selectCity').val();
	var locId = '#p'+locIndex+' h3';
	$(locId).click();
});