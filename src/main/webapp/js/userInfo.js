var request = {
	QueryString : function(val) {
		var uri = window.location.search;
		var re = new RegExp("" + val + "\=([^\&\?]*)", "ig");
		return ((uri.match(re)) ? (uri.match(re)[0].substr(val.length + 1))
				: null);
	},
	QueryStrings : function() {
		var uri = window.location.search;
		var re = /\w*\=([^\&\?]*)/ig;
		var retval = [];
		while ((arr = re.exec(uri)) != null)
			retval.push(arr[0]);
		return retval;
	},
	setQuery : function(val1, val2) {
		var a = this.QueryStrings();
		var retval = "";
		var seted = false;
		var re = new RegExp("^" + val1 + "\=([^\&\?]*)$", "ig");
		for (var i = 0; i < a.length; i++) {
			if (re.test(a[i])) {
				seted = true;
				a[i] = val1 + "=" + val2;
			}
		}
		retval = a.join("&");
		return "?" + retval
				+ (seted ? "" : (retval ? "&" : "") + val1 + "=" + val2);
	}
}
nicakname = decodeURI(request.QueryString("nickname"));
city = decodeURI(request.QueryString("city"));
img = decodeURI(request.QueryString("headimgurl"));
sex = decodeURI(request.QueryString("sex"));
userId = decodeURI(request.QueryString("userId"));

// 房间ID
roomId = decodeURI(request.QueryString("roomid"));
// 玩家状态
userStatus = decodeURI(request.QueryString("userStatus"));
// 房间状态
roomState = decodeURI(request.QueryString("roomState"));
// 房间名字(xxx的房间)
roomName = decodeURI(request.QueryString("roomName"));
user = decodeURI(request.QueryString("user"));
//准备玩家信息
list = decodeURI(request.QueryString("list"));
