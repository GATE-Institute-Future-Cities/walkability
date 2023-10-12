async function postData(url = 'http://localhost:8080/route') {
    const response = await fetch(url, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: {}
    });
    return await response.json();
}

postData('http://localhost:8080/route')
    .then((data) => {
        console.log("Hello")


        console.log(data);

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
                        domain: "YOUR_DOMAIN"
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
                        JSON.parse(data)
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
    })
