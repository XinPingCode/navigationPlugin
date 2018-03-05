# navigationPlugin
a cordova plugin use BaiduMap and GaodeMap to navigation

cordova.plugins.navigationPlugin.baiDuMap(origin_latitude,origin_longitude,destination_latitude,destination_longitude,"driving",result =>{
      console.log("re:",result);
    },error =>console.log("err:",error));
    
cordova.plugins.navigationPlugin.gaoDeMap(origin_latitude,origin_longitude,destination_latitude,destination_longitude,"0",result =>{
      console.log("re:",result);
    },error =>console.log("err:",error));
