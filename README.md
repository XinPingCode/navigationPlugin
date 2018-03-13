# navigationPlugin
a cordova plugin use BaiduMap and GaodeMap to navigation

cordova.plugins.navigationPlugin.baiDuMap(origin_latitude,origin_longitude,destination_latitude,destination_longitude,option,result =>{
      console.log("result:",result);
    },error =>console.log("error:",error));
    
option:transit（meaning bus）,driving,walking,riding.default:driving

cordova.plugins.navigationPlugin.gaoDeMap(origin_latitude,origin_longitude,destination_latitude,destination_longitude,t,result =>{
      console.log("result:",result);
    },error =>console.log("error:",error));
    
t:t = 0（meaning driving）= 1（meaning bus）= 2（meaning walking）= 3（meaning riding）= 4（meaning train）= 5（meaning coach）

 cordova.plugins.navigationPlugin.isInstallBaiduMap(1,result =>{
      console.log("result:",result);
    },error =>console.log("error:",error));
    
 cordova.plugins.navigationPlugin.isInstallGaodeMap(1,result =>{
      console.log("result:",result);
    },error =>console.log("error:",error));
      
    
    
