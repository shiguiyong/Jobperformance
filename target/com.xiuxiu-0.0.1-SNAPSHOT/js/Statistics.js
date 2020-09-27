
$(function(){
			

	var nowurl = document.URL;
	var fromurl = document.referrer;
	document.getElementById('nowurl').value = nowurl;
	document.getElementById('fromurl').value = fromurl;


	var os = function () {
		var ua = navigator.userAgent,
			isWindowsPhone = /(?:Windows Phone)/.test(ua),
			isSymbian = /(?:SymbianOS)/.test(ua) || isWindowsPhone,
			isAndroid = /(?:Android)/.test(ua),
			isFireFox = /(?:Firefox)/.test(ua),
			isChrome = /(?:Chrome|CriOS)/.test(ua),
			isTablet = /(?:iPad|PlayBook)/.test(ua) || (isAndroid && !/(?:Mobile)/.test(ua)) || (isFireFox && /(?:Tablet)/.test(ua)),
			isPhone = /(?:iPhone)/.test(ua) && !isTablet,
			isPc = !isPhone && !isAndroid && !isSymbian;
		return {
			isTablet: isTablet,
			isPhone: isPhone,
			isAndroid: isAndroid,
			isPc: isPc
		};
	}();

	if (os.isAndroid) {
		document.getElementById("equipment").value = "安卓";
		console.log("安卓")
	} else if (os.isPhone) {
		document.getElementById("equipment").value = "苹果";
		console.log("苹果")
	} else if (os.isTablet) {
		document.getElementById("equipment").value = "平板";
		console.log("平板")
	} else if (os.isPc) {
		document.getElementById("equipment").value = "电脑";
		console.log("电脑")
	}


	function getIsWxClient() {
		var all = document.getElementById("lsframe2");

		var ua = navigator.userAgent.toLowerCase();
		if (ua.match(/MicroMessenger/i) == "micromessenger") {
			document.getElementById("lsframe2").value = "微信环境";
		} else if (ua.match(/MicroMessenger/i) != "micromessenger" && os.isPhone) {
			document.getElementById("lsframe2").value = "非微信";
		} else if (ua.match(/MicroMessenger/i) != "micromessenger" && os.isAndroid) {
			document.getElementById("lsframe2").value = "非微信";
		} else if (ua.match(/MicroMessenger/i) != "micromessenger" && os.isPc) {
			document.getElementById("lsframe2").value = "非微信";
		} else if (ua.match(/MicroMessenger/i) != "micromessenger" && os.isTablet) {
			document.getElementById("lsframe2").value = "非微信";

		}
	}




		getIsWxClient();



	var d, s = "";
	d = new Date();
	s += d.getFullYear() + "年" + (d.getMonth() + 1) + "月" + d.getDate() + "日" + d.getHours() + "时" + d.getMinutes() + "分" + d.getSeconds() + "秒";
	document.getElementById("addtime").value = s;
		})