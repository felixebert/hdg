"use strict";
var hdvmap = {};
(function(hdvmap, L) {
	var Map = L.Map.extend({
		initialize: function(id, options) {
			return L.Map.prototype.initialize.call(this, id, L.Util.extend({
				maxZoom: 18
			}, options));
		},
		addOsmLayer: function() {
			this.addLayer(new L.TileLayer('http://{s}.tile.openstreetmap.de/tiles/osmde/{z}/{x}/{y}.png', {
				maxZoom: 18,
				attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors'
			}));
		}
	});
	
	var nrwMap = null;
	var initMap = function() {
		var pos = {
			mlat : 51.259755,
			mlon : 6.780068,
			zoom : 10
		};
		nrwMap = new Map('leaflet-map');
		nrwMap.setView([ pos.mlat, pos.mlon ], pos.zoom);
		nrwMap.addOsmLayer();
	};
	
	var circles = [];
	var drawCircle = function(region, opacity) {
		var circle = L.circle([region.bgrad, region.lgrad], 3250, {
			color: '#7D26CD',
			fillColor: '#7D26CD',
			fillOpacity: opacity
		});
		circle.addTo(nrwMap);
		
		var formattedCosts = region.ausgaben.toFixed(2);
		circle.bindPopup("<p><strong>" + region.bkreis + "</strong></p><p>" + formattedCosts + " &euro; Kulturausgaben pro Einwohner im Jahr 2009</p>");
		
		circles.push(circle);
	};
	
	var maxValue = 0;
	var calcMaxValue = function(data) {
		$.each(data, function(index, region) {
			if(region.ausgaben > maxValue) {
				maxValue = region.ausgaben;
			}
		});
	};
	
	var maxOpacity = 0.9;
	var calculateOpacity = function(value) {
		return value / maxValue * maxOpacity;
	};
	
	var drawCircles = function(data) {
		$.each(data, function(index, region) {
			if(region.bgrad && region.lgrad) {
				drawCircle(region, calculateOpacity(region.ausgaben));
			}
		});
	};
	
	var clearCircles = function() {
		$.each(circles, function(index, circle) {
			nrwMap.removeLayer(circle);
		});
	};
	
	hdvmap.init = function(data) {
		initMap();
	};
	hdvmap.refresh = function(data) {
		clearCircles();
		calcMaxValue(data);
		drawCircles(data);
	};
}(hdvmap, L));
