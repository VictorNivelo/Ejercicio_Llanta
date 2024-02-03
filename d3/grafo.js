var nodes = new vis.DataSet([
{id: 1, label: " 1"},
{id: 2, label: " 2"},
{id: 3, label: " 3"},
{id: 4, label: " 4"},
{id: 5, label: " 5"},
{id: 6, label: " 6"},
{id: 7, label: " escuela 7"},
{id: 8, label: " escuela 8"},
{id: 9, label: " escuela 9"},
{id: 10, label: " escuela 10"},
]);

var edges = new vis.DataSet([
{from: 1, to: 4, label: "341.33"},
{from: 1, to: 7, label: "235.05"},
{from: 5, to: 10, label: "374.42"},
]);

var container = document.getElementById("mynetwork");
      var data = {
        nodes: nodes,
        edges: edges,
      };
      var options = {};
      var network = new vis.Network(container, data, options);