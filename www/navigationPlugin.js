var exec = require('cordova/exec');

exports.baiDuMap = function (arg0, arg1, arg2, arg3, arg4,success, error) {
    exec(success, error, 'navigationPlugin', 'baiDuMap' , [arg0,arg1,arg2,arg3,arg4]);
};

exports.gaoDeMap = function (arg0, arg1, arg2, arg3, arg4,success, error){
    exec(success, error , 'navigationPlugin', 'gaoDeMap' ,[arg0,arg1,arg2,arg3,arg4]);
};
exports.isInstallBaiduMap = function (arg0, success, error){
    exec(success, error , 'navigationPlugin', 'isInstallBaiduMap' ,[arg0]);
};
exports.isInstallGaodeMap = function (arg0, success, error){
    exec(success, error , 'navigationPlugin', 'isInstallGaodeMap' ,[arg0]);
};