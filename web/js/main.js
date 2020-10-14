var CheckPage = document.getElementById("CheckPage");
var ExitPage = document.getElementById("ExitPage");

function goToDownload() {
    CheckPage.action="getDownloadList.do";
    CheckPage.submit();
}

function returnBack() {
    ExitPage.action = "exitLogin.do";
    ExitPage.submit();
}


function goToUserManager() {
    CheckPage.action = "userManager.do";
    CheckPage.submit();
}

function goToResourceManager() {
    CheckPage.action = "resourceManager.do";
    CheckPage.submit();
}

function goToCenterOfUser() {
    CheckPage.action = "userCenter.do";
    CheckPage.submit();
}

function gotoMain() {
    window.location.href = "main.jsp";
}



