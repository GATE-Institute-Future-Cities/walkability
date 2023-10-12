

const getCoord = document.getElementById("coord").innerText;
const coord=getCoord.replace("Coordinates: ","");
//const i = JSON.stringify(coord[0]);;
const firstCommaIndex = coord.indexOf(",");
const secondCommaIndex = coord.indexOf(",", firstCommaIndex + 1);

const i = coord.substring(1,secondCommaIndex);

console.log(getCoord);
console.log(coord);
console.log(i);

const key = 'wMDUgzjq5zORdI24zDFS';
const map = new maplibregl.Map({
    container: 'map', // container id
    style: `https://api.maptiler.com/maps/streets-v2/style.json?key=${key}`, // style URL
    center: JSON.parse(i), // starting position [lng, lat]
    zoom: 16 // starting zoom
});
map.addControl(new maplibregl.NavigationControl(), 'bottom-right');
map.addControl(
    new maplibregl.GeolocateControl({
        positionOptions: {
            enableHighAccuracy: true
        },
        trackUserLocation: true
    }));
map.on('error', function (err) {
    throw new Error("To load the map, you must replace YOUR_MAPTILER_API_KEY_HERE first, see README");
});
    

fetch(`https://api.maptiler.com/geolocation/ip.json?key=${key}`)
    .then((response) => response.json())


map.on('load', function () {
    map.addSource('maine', {
        'type': 'geojson',
        'data': {
            "type": "FeatureCollection",
            "features": [
                {
                    "type": "Feature",
                    "id": 0,
                    "geometry":
                        {
                            "type": "LineString",
                            "coordinates": JSON.parse(coord)

                        },
                    "properties":
                        {
                            "FID": 0,
                            "id": 164,
                            "name": "ул. 25",
                            "type": "Тротоар",
                            "modified_a": "2020/04/07 16:11:38.000",
                            "modified_b": "kaloyan"
                        }
                }]
        }
    });
    map.addLayer({
        'id': 'grand_teton',
        'type': 'line',
        'source': 'maine',
        'layout': {},
        'paint': {
            'line-color': '#FF0000',
            'line-width': 2
        }
    });
});
