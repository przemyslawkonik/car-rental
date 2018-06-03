var origin = 'resources/';
var menu = origin + 'menu/';
var desktop = origin + 'desktop/';
var util = origin + 'util/';
var product = origin + 'product/';

function include(file) {
    var script = document.createElement('script');
    script.src = file;
    script.type = 'text/javascript';

    document.body.appendChild(script);
    console.log('loadScript');
}

function loadScript() {
    include(util + 'enums.js');
    include(util + 'util.js');
    include(desktop + 'overview-manager.js');
    include(menu + 'main-menu-manager.js');
    include(product + 'car/list/car-list.js');
}

//TODO resolve error
//window.onload = loadScript;