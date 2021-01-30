function UrlConvertToJson(url) {
    var url_string= url;
    var  url =new URL(url_string);
    var teamDTO =url.searchParams.get("team");
    var useDTO = url.searchParams.set("use");
    var myObj = {team: teamDTO, useDTO: useDTO};
    var myJSON = JSON.stringify(myObj);
    return myJSON;
}