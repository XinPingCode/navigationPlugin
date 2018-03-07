# navigationPlugin
a cordova plugin use BaiduMap and GaodeMap to navigation

cordova.plugins.navigationPlugin.baiDuMap(origin_latitude,origin_longitude,destination_latitude,destination_longitude,option,result =>{
      console.log("re:",result);
    },error =>console.log("err:",error));
    
option：transit（meaning bus）,driving,walking,riding.default:driving
    
cordova.plugins.navigationPlugin.gaoDeMap(origin_latitude,origin_longitude,destination_latitude,destination_longitude,"0",result =>{
      console.log("re:",result);
    },error =>console.log("err:",error));
