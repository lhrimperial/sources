// axios.interceptors.request.use(function (config) {
//     config.headers.Authorization = localStorage.Authorization;
//     return config;
// }, function (error) {
//     return Promise.reject(error);
// });

var tools = {
    isEmpty: function (value) {
        return value == null || value == '' || value == undefined;
    }
}

Date.prototype.Format = function (fmt) { //author: meizz
    var o = {
        "M+": this.getMonth() + 1, //月份
        "d+": this.getDate(), //日
        "h+": this.getHours(), //小时
        "m+": this.getMinutes(), //分
        "s+": this.getSeconds(), //秒
        "q+": Math.floor((this.getMonth() + 3) / 3), //季度
        "S": this.getMilliseconds() //毫秒
    };
    if (/(y+)/.test(fmt)) fmt = fmt.replace(RegExp.$1, (this.getFullYear() + "").substr(4 - RegExp.$1.length));
    for (var k in o)
        if (new RegExp("(" + k + ")").test(fmt)) fmt = fmt.replace(RegExp.$1, (RegExp.$1.length == 1) ? (o[k]) : (("00" + o[k]).substr(("" + o[k]).length)));
    return fmt;
};

/**
 * 定义Map类型
 */
function Map() {
    this.container = new Object();
}
/**
 * Map put方法
 */
Map.prototype.put = function(key, value) {
    if(this.containsKey(key)){
        delete this.container[key];
    }
    this.container[key] = value;
}
/**
 * Map get方法
 */
Map.prototype.get = function(key) {
    return this.container[key];
}
/**
 * Map key集合
 */
Map.prototype.keySet = function() {
    var keyset = new Array();
    var count = 0;
    for ( var key in this.container) {
        // 跳过object的extend函数
        if (key == 'extend') {
            continue;
        }
        keyset[count] = key;
        count++;
    }
    return keyset;
}
/**
 * Map tostring
 */
Map.prototype.size = function() {
    var count = 0;
    for ( var key in this.container) {
        // 跳过object的extend函数
        if (key == 'extend') {
            continue;
        }
        count++;
    }
    return count;
}

Map.prototype.remove = function(key) {
    delete this.container[key];
}

Map.prototype.clear = function(){
    for ( var key in this.container) {
        // 跳过object的extend函数
        if (key == 'extend') {
            continue;
        }
        delete this.container[key];
    }
}

Map.prototype.containsKey = function(key) {
    var bln = false;
    try {
        for (var i = 0, keys = this.keySet(), len = keys.length; i < len; i++) {
            if (keys[i] == key) {
                bln = true;
            }
        }
    } catch (e) {
        bln = false;
    }
    return bln;
}

Map.prototype.toString = function() {
    var str = "";
    for (var i = 0, keys = this.keySet(), len = keys.length; i < len; i++) {
        str = str + keys[i] + "=" + this.container[keys[i]] + ";\n";
    }
    return str;
}