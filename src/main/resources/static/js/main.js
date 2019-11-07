/* -- Toggle sidebar -- */
$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});

/* ---------------------------------------------------
    Code Editor
----------------------------------------------------- 
/*var editor = ace.edit("editor");
editor.setTheme("ace/theme/dreamweaver");//dreamweaver, cloud, iplastic
editor.session.setMode("ace/mode/java");


function putInPTag(){
    var text = editor.getValue();
    document.getElementById("insert").innerHTML = text;
    editor.setValue("that worked");
}

*/
/* -- Read from file -- */


/* -- Write to file -- */
//by Rob
//based on: https://www.geeksforgeeks.org/javascript-program-to-write-data-in-a-text-file/
//and: https://www.quora.com/How-can-we-read-and-write-a-file-using-JavaScript 
//be careful with activating ActiveXObjects

/*
const fs = require('fs');
let data ="This is simple test.";
fs.writeFile('../Output.txt', data, (err) => {   
    // In case of a error throw err. 
    if (err) throw err; 
});*/

//0 for reading; 3 for writing
//file = fopen('Example.txt',3);
