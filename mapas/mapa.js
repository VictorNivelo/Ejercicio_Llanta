var osmUrl = 'https://tile.openstreetmap.org/{z}/{x}/{y}.png',
                    osmAttrib = '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors',
                    osm = L.tileLayer(osmUrl, {maxZoom: 15, attribution: osmAttrib});

            var map = L.map('map').setView([-4.036, -79.201], 15);

            L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
                attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
            }).addTo(map);
L.marker([-79.2000255, -79.2000255]).addTo(map).bindPopup("1")
.openPopup();
L.marker([-78.2000255, -78.2000255]).addTo(map).bindPopup("2")
.openPopup();
L.marker([-77.2000255, -77.2000255]).addTo(map).bindPopup("3")
.openPopup();
L.marker([-76.2000255, -76.2000255]).addTo(map).bindPopup("4")
.openPopup();
L.marker([-80.2000255, -80.2000255]).addTo(map).bindPopup("5")
.openPopup();
L.marker([-81.2000255, -81.2000255]).addTo(map).bindPopup("6")
.openPopup();
L.marker([-81.2000255, -83.2000255]).addTo(map).bindPopup("escuela 7")
.openPopup();
L.marker([-81.2000255, -89.2000255]).addTo(map).bindPopup("escuela 8")
.openPopup();
L.marker([-81.2000255, -59.2000255]).addTo(map).bindPopup("escuela 9")
.openPopup();
L.marker([-81.2000255, -60.2000255]).addTo(map).bindPopup("escuela 10")
.openPopup();
