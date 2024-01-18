var nodes = [{id: 1, label: 'V1'},{id: 2, label: 'V2'},{id: 3, label: 'V3'},{id: 4, label: 'V4'},{id: 5, label: 'V5'},{id: 6, label: 'V6'},];
var edges = [{from: 1, to: 2, label: '50.0'},{from: 1, to: 5, label: '10.0'},{from: 1, to: 6, label: '3.0'},{from: 2, to: 3, label: '50.0'},{from: 3, to: 4, label: '10.0'},];
var container = document.getElementById("mynetwork");
var data = {
  nodes: nodes,
  edges: edges,
};
var options = {};
var network = new vis.Network(container, data, options);