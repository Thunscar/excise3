window.setInterval(ChangeLeaveTime,1000);
var i = 5;


function returnBack() {
    window.history.back(-1);
}

function ChangeLeaveTime() {
    i = i - 1;
    if(i == 0){
        returnBack();
    }else{
        document.getElementById("time").innerText = i;
    }
}
