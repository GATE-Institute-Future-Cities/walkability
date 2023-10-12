

async function postData(url = 'http://localhost:8080/map') {
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: {}
    });
    return await response.json();
}

postData('http://localhost:8080/map')
    .then((data) => {
        
        let jsonn = JSON.stringify(data).replaceAll("},{\"feature_info\":", ",").replace("{\"feature_info\":", "");
        jsonn = jsonn.substring(0, jsonn.length - 2);
        jsonn = jsonn.concat("]").toString();

        const key = 'wMDUgzjq5zORdI24zDFS';
        const map = new maplibregl.Map({
            container: 'map', // container id
            style: `https://api.maptiler.com/maps/streets-v2/style.json?key=${key}`, // style URL
            center: [23.318998724, 42.673830638], // starting position [lng, lat]
            zoom: 12 // starting zoom
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
            .then((data) => {
                let {country_code} = data;
                window.cookieconsent.initialise({
                    cookie: {
                        domain: "https://YOUR_DOMAIN"
                    },
                    palette: {
                        popup: {background: "#EFF3FB", text: "#333359", link: "#3170FE"},
                        button: {background: "#3170FE"},
                    },
                    theme: "classic",
                    type: "opt-out",
                    revokable: true,
                    content: {
                        href: "https://YOUR_DOMAIN/privacy-policy/"
                    },
                    law: {
                        regionalLaw: false,
                        countryCode: country_code
                    },
                    legal: country_code
                });
            });

        map.on('load', function () {
            map.addSource('maine', {
                'type': 'geojson',
                'data': {
                    "type": "FeatureCollection",
                    "features":
                        JSON.parse(jsonn)
                }
            });

            map.addLayer({
                'id': 'grand_teton',
                'type': 'line',
                'source': 'maine',
                'layout': {},
                'paint': {
                    'line-color': '#000',
                    'line-width': 2
                }
            });
        })



        var draw = new MapboxDraw();
        map.addControl(draw, 'top-right');

        var feature = null;
        map.on('draw.create', function(e) {

            if (feature) {
                draw.delete(feature.id); // Изтриване на предишната линия
            }

            feature = e.features[0];
            var geometry = feature.geometry;


            console.log(geometry);

            var popup = document.getElementById('lineDraw');
            popup.style.display = 'block';
        });

        var submitButton = document.getElementById('submit-button');
        submitButton.addEventListener('click', function() {

            var popup = document.getElementById('lineDraw');
            popup.style.display = 'none';

            draw.deleteAll();
        });

        var submitButton = document.getElementById('submit-button');
        submitButton.addEventListener('click', function() {
            var name = document.getElementById('name').value;
            console.log(name);
            var type = document.getElementById('lineType').value;
            console.log(type);


            if (feature) {
                var coordinates = feature.geometry.coordinates;
                var lineType = feature.geometry.type;
                console.log(coordinates);
                var length = distance(coordinates[0][1], coordinates[0][0], coordinates[coordinates.length-1][1],coordinates[coordinates.length-1][0]);
                console.log(length);

                var data = {
                    name: name,
                    type: type,
                    coordinates: coordinates,
                    lineType: lineType,
                    length: length
                };

                fetch('http://localhost:8080/map/add', {
                    method: 'POST',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(data)
                })
                    .then(function(response) {
                        console.log('Success:', response);
                    })
                    .catch(function(error) {
                        console.error('Error:', error);
                    });
            }

            var popup = document.getElementById('lineDraw');
            popup.style.display = 'none';

            draw.deleteAll();
        });

        var popup = new maplibregl.Popup({
            closeButton: true,
            closeOnClick: true
            //maxWidth: 'none'

        });

        map.on('click', 'grand_teton', function (e) {


            let coordinates = e.lngLat;//координатите на клика

            if (navigator.geolocation) {
                navigator.geolocation.getCurrentPosition(showPosition);
            } else {
                alert("Geolocation is not supported by this browser.");
            }

            function showPosition(position) {
                var latitude = position.coords.latitude;
                var longitude = position.coords.longitude;

                console.log(latitude);
                console.log(longitude);

                //let coordinates = e.lngLat;//координатите на клика

                console.log(coordinates.lat);
                console.log(coordinates)

                var result = distance(latitude, longitude, coordinates.lat, coordinates.lng)

                var p = result <= 500;

                document.getElementById("p").value = p;

            }

            map.getCanvas().style.cursor = 'pointer';

            let id = e.features[0].id + 1;
            let name = e.features[0].properties.name
            let type = e.features[0].properties.type;
            let modifiedDate = e.features[0].properties.modified_a;
            let modifiedPerson = e.features[0].properties.modified_b;


            let urlMore = "http://localhost:8080/map/pedestriansection/" + id;
            let urlRating = "http://localhost:8080/questions/";
            let urlResult = "http://localhost:8080/questions/";
            let urlCriteria = "http://localhost:8080/questions/";


            if (name.toLowerCase().includes("алея")) {
                urlRating = urlRating + "alley/";
                urlResult = urlResult + "alley/";
                urlCriteria = urlCriteria + "alley/";
            } else if (type.toLowerCase().includes("алея")) {
                urlRating = urlRating + "alley/";
                urlResult = urlResult + "alley/";
                urlCriteria = urlCriteria + "alley/";
            } else if (name.toLowerCase().includes("тротоар")) {
                urlRating = urlRating + "sidewalk/";
                urlResult = urlResult + "sidewalk/";
                urlCriteria = urlCriteria + "sidewalk/";
            } else if (type.toLowerCase().includes("тротоар")) {
                urlRating = urlRating + "sidewalk/";
                urlResult = urlResult + "sidewalk/";
                urlCriteria = urlCriteria + "sidewalk/";
            } else if (name.toLowerCase().includes("пресичане")) {
                urlRating = urlRating + "crossing/";
                urlResult = urlResult + "crossing/";
                urlCriteria = urlCriteria + "crossing/";
            } else if (type.toLowerCase().includes("пресичане")) {
                urlRating = urlRating + "crossing/";
                urlResult = urlResult + "crossing/";
                urlCriteria = urlCriteria + "crossing/";
            }

            urlResult = urlResult + "result/" + id;
            urlCriteria = urlCriteria + "result/criteria/" + id;

            urlRating = urlRating + id;
            let but = '<a class="button" href="' + urlMore + '" className="btn">Learn More</a>';
            but = but + '<a class="button" href="' + urlRating + '" className="btn">Questionnaire</a>';
            but = but + '<a class="button" href="' + urlResult + '" className="btn">Result Table</a>';
            but = but + '<a class="button" href="' + urlCriteria + '" className="btn">Result Criteria</a>';

            let info = "<p><b>Име: </b>" + name + "</p>" + "<p><b>Тип: </b>" + type + "</p>" + "<p><b>Модифициран от: </b>" + modifiedPerson + "</p>" + "<p><b>Модифициран на: </b>" + modifiedDate + "</p>" + but;

            var rolee;

            fetch('http://localhost:8080/map/info')
                .then(response => response.json())
                .then(data => {
                    rolee=data.role;
                    document.getElementById("role").value = rolee;
                    console.log(rolee);
                })
                .catch(error => {
                    // Обработване на грешки
                    console.log(error);
                });

            console.log(document.getElementById("p").value);
            console.log(document.getElementById("role").value);

            if(document.getElementById("p").value==="true"||document.getElementById("role").value!=="USER"){

                popup.setLngLat(coordinates).setHTML(info).addTo(map);
            }
        });


        // Change the cursor to a pointer when the mouse is over the places layer.
        map.on('mouseenter', 'grand_teton', function () {
            map.getCanvas().style.cursor = 'pointer';
        });

        // Change it back to a pointer when it leaves.
        map.on('mouseleave', 'grand_teton', function () {
            map.getCanvas().style.cursor = '';
        });


        function distance(lat1, lon1, lat2, lon2) {
            const R = 6371e3; // Earth's mean radius in meters
            const φ1 = lat1 * Math.PI / 180; // convert latitudes to radians
            const φ2 = lat2 * Math.PI / 180;
            const Δφ = (lat2 - lat1) * Math.PI / 180; // delta latitudes
            const Δλ = (lon2 - lon1) * Math.PI / 180; // delta longitudes

            const a = Math.sin(Δφ / 2) * Math.sin(Δφ / 2) +
                Math.cos(φ1) * Math.cos(φ2) *
                Math.sin(Δλ / 2) * Math.sin(Δλ / 2);
            const c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

            const d = R * c; // distance in meters

            return d;
        }

        var firstClick = true;
        map.on('click', function (ev) {//взема координатите при клик на мишката
            var latLng = map.unproject(ev.point);
            var lat = latLng.lat;
            var lng = latLng.lng;

            if (firstClick) {
                var coordinates = document.getElementById("input");
                coordinates.value = lat + ", " + lng;
                firstClick = false;
            } else {
                var coordinates = document.getElementById("input2");
                coordinates.value = lat + ", " + lng;
                firstClick = true;
            }


        });

    });

function openForm() {
    document.getElementById("myForm").style.display = "block";
}

function closeForm() {
    document.getElementById("myForm").style.display = "none";
}

function closeForm2() {
    document.getElementById("lineDraw").style.display = "none";
}

function cleanForm() {
    document.getElementById("input").value = "";
    document.getElementById("input2").value = "";
}

function searchForm() {
    var coord1 = document.getElementById("input").value;
    var coord2 = document.getElementById("input2").value;
    console.log(coord1);

    const data = {coord1: coord1, coord2: coord2};

    fetch('http://localhost:8080/route', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
        .then(response => response.text())
        .then(dataa => {
            // Обработка на получените данни от бекенда
            console.log(dataa)
            const key = 'wMDUgzjq5zORdI24zDFS';
            const map = new maplibregl.Map({
                container: 'map', // container id
                style: `https://api.maptiler.com/maps/streets-v2/style.json?key=${key}`, // style URL
                center: [23.318998724, 42.673830638], // starting position [lng, lat]
                zoom: 12 // starting zoom
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
                .then((data) => {
                    let {country_code} = data;
                    window.cookieconsent.initialise({
                        cookie: {
                            domain: "https://YOUR_DOMAIN"
                        },
                        palette: {
                            popup: {background: "#EFF3FB", text: "#333359", link: "#3170FE"},
                            button: {background: "#3170FE"},
                        },
                        theme: "classic",
                        type: "opt-out",
                        revokable: true,
                        content: {
                            href: "https://YOUR_DOMAIN/privacy-policy/"
                        },
                        law: {
                            regionalLaw: false,
                            countryCode: country_code
                        },
                        legal: country_code
                    });
                });

            map.on('load', function () {
                map.addSource('maine', {
                    'type': 'geojson',
                    'data': {
                        "type": "FeatureCollection",
                        "features":
                            JSON.parse(dataa)
                    }
                });

                map.addLayer({
                    'id': 'grand_teton',
                    'type': 'line',
                    'source': 'maine',
                    'layout': {},
                    'paint': {
                        'line-color': 'rgba(25,170,0,0.8)',
                        'line-width': 2
                    }
                });
            })

            console.log('Processed data:', dataa);
        })
        .catch(error => {
            console.error('Error:', error);
        });
}