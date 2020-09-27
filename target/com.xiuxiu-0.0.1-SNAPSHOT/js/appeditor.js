/*! AppEdit v1.1.0 github http://www.sucaihuo.com/ */
function AppEdit (el){
    this._init_(el);
}

AppEdit.prototype = {
    constructor : AppEdit,
    _init_ : function(info) {
		this.barsbox = " <div class='pin-toast-container'><div class='pin-toast'></div></div>  <div class='bars-box ng-hide' class='addModulesBars'><div class=bars-box-justify style='top: auto; left: 726px;'><div class=bars-box-position><div class=bars-box-arrow></div><div class='cancleAdd' class=cancleAdd></div><p class='bars-box-title ng-binding'>+添加模块</p><div class='select-modules-bars clear' id=select-modules-bars><ul class=add-module-box><li class='onClickAddText'><div class=add-text-btn></div>文字<li class=upload-button><form enctype='multipart/form-data' id='uploadForm' style='margin: 0em;'><input id=upImage type=file multiple></form><div class=add-image-btn></div>图片<!--<li ng-click='onClickAddVedio()'><div class=add-video-btn></div>视频<li class='onClickAddGoods'><div class=add-good-btn></div>商品<li class='onClickAddLine'><div class=add-line-gap-btn></div>分割线--></ul></div></div></div><div class=bars-box-back class='cancleAdd'></div></div>";
		this.emptycontent	 = "<div class='empty-content ng-hide'>详情目前为空</div>";
		this.itemstart = "<div class='click-item item ng-scope'><div><div class='model-box ";
		this.itemstart_append = " ng-scope'>";
		this.itemend = "<div class='note-ope ng-hide'><div class=add-btn></div><div class=move-up></div><div class='move-down ng-hide'></div><div class=note-del></div></div></div><div class='choice-tips choice-bottom ng-hide'></div></div></div>";
		this.barsend = "<div class='addModulesbtn'>+添加模块</div>";

    	var id = info.el || '#editor_id';
	    var name = info.name || 'appEdit' ;
		var json = info.data || '';

		var self = this;

		self.info = info;
		var data = [];
		this.name = name;
		this.id = id = (id + " ");
		
		if(json != '') {
		   json = json.replace("\r\n", "<br>");
		   json = json.replace(/\\r\n/g, "<br>");
		   json = json.replace(/\r/ig, "").replace(/\n/ig,"");
		   
		   data=eval("("+json+")");  
		}
		
		$(id).addClass('cpc-diary-edit ng-isolate-scope ng-not-empty ng-valid ng-dirty ng-valid-parse');
		
		var html = self.barsbox;
		html += '<div class="editor-list"><div id="ueditor" style="padding-bottom: 10px;"><div class="diary-list">' + self.emptycontent;
		
		for(var i=0;i<data.length;i++){
			if(data[i].text != undefined) {
				html += this.bytext(data[i].text);
			} else if(data[i].image != undefined) {
				html += this.byimage(data[i].image);
			}
		}
		
		html += "</div>";
		html += "</div>";
		html += self.barsend;
		html += "</div>";
		html += "</div>";
		html += "</div>";
		html += "</div>";
		html += "</div>";
		
		$(id).append(html);
		
		
		$(self.id + ".onClickAddText").click(function() {
			var current = $(self.id + ".click-item .choice-bottom:not(.ng-hide)").parent().parent('.click-item');
			

			if(  $(self.id + ".choice-tips:not(.ng-hide)").is($(self.id + ".choice-tips").eq(0)) && !$(self.id + ".choice-tips").eq(0).parent().find('textarea').length && !$(self.id + ".choice-tips").eq(0).parent().find('img').length ) {
				current.replaceWith(self.bytext(" "));
			} else {
				current.after(self.bytext(" "));
			}
			
			$(self.id + ".addModulesBars").addClass('ng-hide');
			$(self.id + '.bars-box').addClass('ng-hide');
			$(self.id + '.bars-box').addClass('ng-hide');
			
			$(current).find('.choice-bottom').addClass('ng-hide');
			$("body").removeClass('modal-open');
			self.init();
			self.add_after();
		});

			
		$(self.id + ".addModulesbtn").click(function() {
			$("body").addClass('modal-open');
			$(this).after("<div class='mark addModulesBars'></div>");
			$(self.id + '.bars-box').removeClass('ng-hide');
			$(self.id + '.empty-content').addClass('ng-hide');
			$(self.id + '.empty-content input').remove();

			var append = self.itemstart + " text-model-wrapper " + self.itemstart_append +  self.itemend;

			$(self.id + ".diary-list").prepend(append);
			$(self.id + ".diary-list .click-item").first().find('.choice-bottom').removeClass("ng-hide");
			var current = $(self.id + ".click-item .choice-bottom:not(.ng-hide)").parent().parent('.click-item');

			if($("#ueditor").scrollTop() != 0) {
				$("#ueditor").animate({scrollTop: 0}, 1000,function() {self.set_top(current);});
			} else {
				self.set_top(current);
			}
		});


		$(self.uploadbutton()).change(function(e) {
			
			var current;
			var length = this.files.length;
			if(!current || current == undefined) {
				current = obj = $(self.id + ".click-item .choice-bottom:not(.ng-hide)").parent().parent('.click-item');	
  			}		

  			var current_inx;
  			$(self.id + ".click-item").each(function(inx,el) {
  				if($(this).is(current)) current_inx = inx;
  			});
			
			var html = self.itemstart + " image-model-wrapper " + self.itemstart_append + "<div class='img-loading'><img src='.'data:image/gif;base64,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'' style='width:unset;height: unset;'></div>" + self.itemend;
			for (var i = 0; i < length; i++) {

				if(!/\.(gif|jpg|jpeg|png|GIF|JPG|PNG)$/.test( this.files[i].name ))
			    {
			        self.toast("请上传图片格式文件");
			        
			        //清空
					$(self.uploadbutton()).val("");
			        return false;
			    }

				if(  $(self.id + ".choice-tips:not(.ng-hide)").is($(self.id +".choice-tips").eq(0)) && !$(self.id + ".choice-tips").eq(0).parent().find('textarea').length && !$(self.id + ".choice-tips").eq(0).parent().find('img').length ) {
					$(current).replaceWith(html);
					
					current = $(self.id + ".click-item").eq(current_inx);
					$(current).find(".choice-bottom").addClass("ng-hide");
				} else {
					$(current).find(".choice-bottom").addClass("ng-hide");
					$(current).after(html);
					current = $(current).next();
				}

				self.init();
				self.add_after();

				$(self.id + '.bars-box').addClass('ng-hide');
				$("body").removeClass('modal-open');
				$(self.id + ".addModulesBars").addClass('ng-hide');
				
				self.info.imageupload != undefined  ? self.info.imageupload(this.files[i],current) : self.showImage(this.files[i],current); 
			}
			

			//清空
			$(self.uploadbutton()).val("");
		});


		$(self.id + ".cancleAdd").click(function() {
			$(self.id + ".bars-box-back").mousedown();
		});		

		$(self.id + ".upload-button").click(function() {
			document.getElementById("upImage").click();
		});

		$(self.id + ".model-box").hover(function() {
			$(this).addClass('hover');
			if($(self.id + '.click-item').length == 1) {
				$(self.id + '.click-item').first().find('.note-ope').find('.move-down').addClass('ng-hide');
				$(self.id + '.click-item').first().find('.note-ope').find('.move-up').addClass('ng-hide');
			} else {
				$(self.id + '.click-item').first().find('.note-ope').find('.move-down').removeClass('ng-hide');
				$(self.id + '.click-item').first().find('.note-ope').find('.move-up').addClass('ng-hide');
				$(self.id + '.click-item').not($('.click-item').first()).not($('.click-item').last()).find('.note-ope').find('.move-down').removeClass('ng-hide');
				$(self.id + '.click-item').not($('.click-item').first()).not($('.click-item').last()).find('.note-ope').find('.move-up').removeClass('ng-hide');
				$(self.id + '.click-item').last().find('.note-ope').find('.move-up').removeClass('ng-hide');
				$(self.id + '.click-item').last().find('.note-ope').find('.move-down').addClass('ng-hide');
			}

			$(this).find('.note-ope').removeClass('ng-hide');	
		});
		
		$(self.id + ".move-down").mousedown(function() {
			var current = $(this).parent().parent().parent().parent('.click-item');
			var next = $(current).next(".click-item");
	
			$(next).insertBefore(current);
		});
		
		$(self.id + ".move-up").mousedown(function() {
			var current = $(this).parent().parent().parent().parent('.click-item');
			var prev = $(current).prev(".click-item");
			
			$(prev).insertAfter(current);
		});
		
		$(self.id + ".model-box").mouseleave(function() {
			$(this).find('.note-ope').addClass('ng-hide');
			$(this).removeClass('hover');
		});
		
		$(self.id + ".note-del").mousedown(function() {
			if(self.info.del != undefined) {
				if(self.info.del()) 
				  $(this).parent().parent().parent().parent('.click-item').remove();	
			} else if(confirm("是否删除该模块")) 
				$(this).parent().parent().parent().parent('.click-item').remove();

			if($(self.id + ".click-item input").length <= 0) {
				$(self.id + '.empty-content').removeClass('ng-hide');
				$(self.id + '.empty-content').append("<input name='" + self.name + "' type='hidden'/>")
			}
			self.add_after();
		});
		
		$(self.id + ".bars-box-back").mousedown(function() {
			$(self.id + ".click-item .choice-bottom:not(.ng-hide)").addClass('ng-hide');
			$(self.id + ".addModulesBars").addClass('ng-hide');
			$(self.id + '.bars-box').addClass('ng-hide');
			
			$("body").removeClass('modal-open');

			if($(self.id + ".click-item input").length <= 0) {
				$(self.id + '.empty-content').removeClass('ng-hide');
				$(self.id + '.empty-content').append("<input name='" + self.name + "' type='hidden'/>")
			}
		});
		
		$(self.id + ".textarea").removeClass('txt-show-area');
		$(self.id + ".textarea").blur(function() {
			$(this).removeClass('removeClass');	
			$(this).prev('.moni-textarea').text($(this).val());
			$(this).next('input').val($(this).val());
		});
			
		$(self.id + ".moni-textarea").click(function() {
			$(this).next('.textarea').addClass('txt-show-area');	
			$(this).next('.textarea').val($(this).text());
			$(this).next('input').val($(this).text());
		});
		
		$(self.id + ".add-btn").mousedown(function() {
			var current = $(this).parent().parent().parent().parent('.click-item');
			$("body").addClass('modal-open');
			$(this).after("<div class='mark addModulesBars'></div>");
			$(self.id + '.bars-box').removeClass('ng-hide');
			$(self.id + '.empty-content').addClass('ng-hide');
			$(self.id + '.empty-content input').remove();

			$(current).find('.choice-tips').removeClass('ng-hide');
			
			//var append = self.itemstart + " text-model-wrapper " + self.itemstart_append + "<div class='choice-tips choice-bottom'  ></div>" +  self.itemend;
			//$(current).after(append);

			self.set_top(current);
		});
		
		

		$(id + '#ueditor').hover(function(e) {
			self.unScroll();
		},function(e){
			self.removeUnScroll();
		});

		if(data.length <= 0) {
			$(self.id + '.empty-content').removeClass('ng-hide');
			$(self.id + '.empty-content').append("<input name='" + self.name + "' type='hidden'/>")
		}	
    },
    showImage : function(file,current) {
    	var self = this;
		var reader = new FileReader();  
        reader.readAsDataURL(file);
    	reader.onload = function(e){
    		self.uploadafter(e.target.result,current);  
		}
    },
    unScroll : function() {
        var top = $(document).scrollTop();
        $(document).on('scroll.unable',function (e) {
            $(document).scrollTop(top);
        })
    },
    removeUnScroll : function() {
    	$(document).unbind("scroll.unable");
    },
	byimage : function($val) {
		var hidden = "<input name='" + this.name + "' value='" + $val + "' type='hidden'/>";
		
		this.log(hidden);
		return this.itemstart + " image-model-wrapper " + this.itemstart_append + "<div class='img-loading ng-hide'><img src='data:image/gif;base64,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' style='width:unset;height: unset;'></div>" + "<img name='file3' onerror=\"javascript:this.src='data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAASwAAAEsCAMAAABOo35HAAADAFBMVEUAAAABAQECAgIDAwMEBAQFBQUGBgYHBwcICAgJCQkKCgoLCwsMDAwNDQ0ODg4PDw8QEBARERESEhITExMUFBQVFRUWFhYXFxcYGBgZGRkaGhobGxscHBwdHR0eHh4fHx8gICAhISEiIiIjIyMkJCQlJSUmJiYnJycoKCgpKSkqKiorKyssLCwtLS0uLi4vLy8wMDAxMTEyMjIzMzM0NDQ1NTU2NjY3Nzc4ODg5OTk6Ojo7Ozs8PDw9PT0+Pj4/Pz9AQEBBQUFCQkJDQ0NERERFRUVGRkZHR0dISEhJSUlKSkpLS0tMTExNTU1OTk5PT09QUFBRUVFSUlJTU1NUVFRVVVVWVlZXV1dYWFhZWVlaWlpbW1tcXFxdXV1eXl5fX19gYGBhYWFiYmJjY2NkZGRlZWVmZmZnZ2doaGhpaWlqampra2tsbGxtbW1ubm5vb29wcHBxcXFycnJzc3N0dHR1dXV2dnZ3d3d4eHh5eXl6enp7e3t8fHx9fX1+fn5/f3+AgICBgYGCgoKDg4OEhISFhYWGhoaHh4eIiIiJiYmKioqLi4uMjIyNjY2Ojo6Pj4+QkJCRkZGSkpKTk5OUlJSVlZWWlpaXl5eYmJiZmZmampqbm5ucnJydnZ2enp6fn5+goKChoaGioqKjo6OkpKSlpaWmpqanp6eoqKipqamqqqqrq6usrKytra2urq6vr6+wsLCxsbGysrKzs7O0tLS1tbW2tra3t7e4uLi5ubm6urq7u7u8vLy9vb2+vr6/v7/AwMDBwcHCwsLDw8PExMTFxcXGxsbHx8fIyMjJycnKysrLy8vMzMzNzc3Ozs7Pz8/Q0NDR0dHS0tLT09PU1NTV1dXW1tbX19fY2NjZ2dna2trb29vc3Nzd3d3e3t7f39/g4ODh4eHi4uLj4+Pk5OTl5eXm5ubn5+fo6Ojp6enq6urr6+vs7Ozt7e3u7u7v7+/w8PDx8fHy8vLz8/P09PT19fX29vb39/f4+Pj5+fn6+vr7+/v8/Pz9/f3+/v7////isF19AAAACXBIWXMAAAsTAAALEwEAmpwYAAAFFmlUWHRYTUw6Y29tLmFkb2JlLnhtcAAAAAAAPD94cGFja2V0IGJlZ2luPSLvu78iIGlkPSJXNU0wTXBDZWhpSHpyZVN6TlRjemtjOWQiPz4gPHg6eG1wbWV0YSB4bWxuczp4PSJhZG9iZTpuczptZXRhLyIgeDp4bXB0az0iQWRvYmUgWE1QIENvcmUgNS42LWMxNDAgNzkuMTYwNDUxLCAyMDE3LzA1LzA2LTAxOjA4OjIxICAgICAgICAiPiA8cmRmOlJERiB4bWxuczpyZGY9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkvMDIvMjItcmRmLXN5bnRheC1ucyMiPiA8cmRmOkRlc2NyaXB0aW9uIHJkZjphYm91dD0iIiB4bWxuczp4bXA9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC8iIHhtbG5zOmRjPSJodHRwOi8vcHVybC5vcmcvZGMvZWxlbWVudHMvMS4xLyIgeG1sbnM6cGhvdG9zaG9wPSJodHRwOi8vbnMuYWRvYmUuY29tL3Bob3Rvc2hvcC8xLjAvIiB4bWxuczp4bXBNTT0iaHR0cDovL25zLmFkb2JlLmNvbS94YXAvMS4wL21tLyIgeG1sbnM6c3RFdnQ9Imh0dHA6Ly9ucy5hZG9iZS5jb20veGFwLzEuMC9zVHlwZS9SZXNvdXJjZUV2ZW50IyIgeG1wOkNyZWF0b3JUb29sPSJBZG9iZSBQaG90b3Nob3AgQ0MgKE1hY2ludG9zaCkiIHhtcDpDcmVhdGVEYXRlPSIyMDE3LTEwLTIwVDE2OjQyOjQ2KzA4OjAwIiB4bXA6TW9kaWZ5RGF0ZT0iMjAxNy0xMC0yMFQxNjo1Mzo0OSswODowMCIgeG1wOk1ldGFkYXRhRGF0ZT0iMjAxNy0xMC0yMFQxNjo1Mzo0OSswODowMCIgZGM6Zm9ybWF0PSJpbWFnZS9wbmciIHBob3Rvc2hvcDpDb2xvck1vZGU9IjIiIHBob3Rvc2hvcDpJQ0NQcm9maWxlPSJzUkdCIElFQzYxOTY2LTIuMSIgeG1wTU06SW5zdGFuY2VJRD0ieG1wLmlpZDo2NzNiOWE1Ny0wNTA1LTQzZmItOGU4OS02NmViMzkxMjg4OTIiIHhtcE1NOkRvY3VtZW50SUQ9InhtcC5kaWQ6NjczYjlhNTctMDUwNS00M2ZiLThlODktNjZlYjM5MTI4ODkyIiB4bXBNTTpPcmlnaW5hbERvY3VtZW50SUQ9InhtcC5kaWQ6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'\" ondragstart='return false' src='" + $val + "'>" + hidden+ this.itemend;
	},
	bytext : function($val) {
		var hidden = "<input name='" + this.name + "[][text]" + "' value='" + $val + "' type='hidden'/>";
		
		this.log(hidden);
		return this.itemstart + " text-model-wrapper " + this.itemstart_append +  "<div class='moni-textarea ng-binding'>" + $val + '</div>' + "<textarea id='textareaNumber0' class='textarea ng-pristine ng-valid ng-not-empty ng-touched' >" + $val + "</textarea>" + hidden + this.itemend;
	},
	textafter : function() {
		$(self.id + ".click-item .choice-bottom:not(.ng-hide)").parent().parent().parent('.click-item').replaceWith(this.bytext($val))

		$(self.id + ".addModulesBars").addClass('ng-hide');
		$(self.id + '.bars-box').addClass('ng-hide');
		$("body").removeClass('modal-open');

		this.init();
		this.add_after();
	},
	uploadafter : function($val,current) {
		var self = this;
		$(current).removeClass('ng-hide');
		$(current).replaceWith(self.byimage($val));
		this.init();
		this.add_after();	
	},
	uploadbutton : function(obj) {
		return $(this.id + "#upImage")
	},
	init : function() {
	 	var self = this;
		$(self.id + ".model-box").unbind('hover');
		$(self.id + ".model-box").unbind('mouseleave');
		$(self.id + ".note-del").unbind('mousedown');
		
		$(self.id + ".model-box").hover(function() {
			$(this).find('.note-ope').removeClass('ng-hide');
			$(this).addClass('hover');
			
			self.init();
		});
		
		$(self.id + ".model-box").mouseleave(function() {
			$(this).find('.note-ope').addClass('ng-hide');
			$(this).removeClass('hover');
			
			self.init();
		});
		
		$(self.id + ".note-del").mousedown(function() {
			if(self.info.del != undefined) {
				self.info.del();
			} else if(confirm("是否删除该模块")) 
				$(this).parent().parent().parent().parent('.click-item').remove();
			
			if($(self.id + ".click-item input").length <= 0) {
				$(self.id + '.empty-content').removeClass('ng-hide');
				$(self.id + '.empty-content').append("<input name='" + self.name + "' type='hidden'/>")
			}
			self.init();
			self.add_after();
		});
		
		
	},
	set_top : function(current) {
		var self = this;
		var has = 0;
		if(current) {
			var top = 0;
			$(self.id + ".click-item").each(function() {
				top += $(this).outerHeight();
				self.log(top);
				has++;
				if($(this).is(current)) {
				   return false;	
				}
			});
		} 
		var offsettop=0;
		if(self.info.offset.top != undefined) {
			offsettop = parseFloat(self.info.offset.top);
		}
		
		if($(self.id + ".click-item input").length == has) 
			$(self.id + "#ueditor").animate({scrollTop: top}, 0);
		top = top - $(self.id + "#ueditor").scrollTop();
		top -= $(self.id+".click-item .choice-bottom:not(.ng-hide)").outerHeight() / 2 + 20;
		top = (top + $(self.id).offset().top - offsettop - $(window).scrollTop());

		$(self.id + ".bars-box-justify").attr('style',"top: " + top + "px;left: " + ($(self.id + "#ueditor").offset().left + $("#ueditor").outerWidth() + 21) + "px;");
	},		
	add_after : function() {
		var self = this;
		$(self.id + ".add-btn").unbind('mousedown');
		$(self.id + ".move-up").unbind('mousedown');
		$(self.id + ".move-down").unbind('mousedown');
		$(self.id + ".textarea").unbind('blur');
		$(self.id + ".moni-textarea").unbind('click');
		
		if($(self.id + '.click-item').length == 1) {
			$(self.id + '.click-item').first().find('.note-ope').find('.move-down').addClass('ng-hide');
			$(self.id + '.click-item').first().find('.note-ope').find('.move-up').addClass('ng-hide');
		} else {
			$(self.id + '.click-item').first().find('.note-ope').find('.move-down').removeClass('ng-hide');
			$(self.id + '.click-item').first().find('.note-ope').find('.move-up').addClass('ng-hide');
			$(self.id + '.click-item').not($('.click-item').first()).not($('.click-item').last()).find('.note-ope').find('.move-down').removeClass('ng-hide');
			$(self.id + '.click-item').not($('.click-item').first()).not($('.click-item').last()).find('.note-ope').find('.move-up').removeClass('ng-hide');
			$(self.id + '.click-item').last().find('.note-ope').find('.move-up').removeClass('ng-hide');
			$(self.id + '.click-item').last().find('.note-ope').find('.move-down').addClass('ng-hide');
		}

		$(self.id + ".move-down").mousedown(function() {
			var current = $(this).parent().parent().parent().parent('.click-item');
			var next = $(current).next(".click-item");
			$(next).insertBefore(current);
			
			
			self.add_after();

		});
		
		$(self.id + ".move-up").mousedown(function() {
			var current = $(this).parent().parent().parent().parent('.click-item');
			var prev = $(current).prev(".click-item");
			$(prev).insertAfter(current);
			
			
			
			self.add_after();
	
		});
		
		$(self.id + ".add-btn").mousedown(function() {
			var current = $(this).parent().parent().parent().parent('.click-item');
			
			$("body").addClass('modal-open');
			$(this).after("<div class='mark addModulesBars'></div>");
			$(self.id + '.bars-box').removeClass('ng-hide');
			$(self.id + '.empty-content').addClass('ng-hide');
			$(self.id + '.empty-content input').remove();
			
			$(current).find('.choice-tips').removeClass('ng-hide');
			//var append = self.itemstart + " text-model-wrapper " + self.itemstart_append + "<div class='choice-tips choice-bottom'  ></div>" +  self.itemend;
			//$(current).after(append);
				
			self.add_after();
		
			self.set_top(current);

		});
		
		$(self.id + ".textarea").blur(function() {
			$(this).removeClass('txt-show-area');
			
			$(this).prev('.moni-textarea').text($(this).val());
			$(this).next('input').val($(this).val());
			self.add_after();	
		});
		
		$(self.id + ".moni-textarea").click(function() {
			$(this).next('.textarea').addClass('txt-show-area');	
			$(this).next('.textarea').val($(this).text());
			
			self.add_after();	
		});
		
	},
	log : function(data) {
		if(this.info.debug == true) 
		{
			console.log(data);
		}
	},
	/********************
	 * 取窗口滚动条高度 
	 ******************/
	getScrollTop : function ()
	{
	    var scrollTop=0;
	    if(document.documentElement&&document.documentElement.scrollTop)
	    {
	        scrollTop=document.documentElement.scrollTop;
	    }
	    else if(document.body)
	    {
	        scrollTop=document.body.scrollTop;
	    }
	    return scrollTop;
 	},
	/********************
	 * 取窗口可视范围的高度 
	 *******************/
	getClientHeight : function ()
	{
	    var clientHeight=0;
	    if(document.body.clientHeight&&document.documentElement.clientHeight)
	    {
	        var clientHeight = (document.body.clientHeight<document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;        
	    }
	    else
	    {
	        var clientHeight = (document.body.clientHeight>document.documentElement.clientHeight)?document.body.clientHeight:document.documentElement.clientHeight;    
	    }
	    return clientHeight;
	},
	/********************
	 * 取文档内容实际高度 
	 *******************/
	getScrollHeight : function()
	{
	    return Math.max(document.body.scrollHeight,document.documentElement.scrollHeight);
	},
	toast : function(message,time) {
		if(!time) time = 2000;
		var self = this;
		$(self.id + ".pin-toast-container").css({ "display" : "block" , "opacity" : 1 });
		$(self.id + ".pin-toast-container .pin-toast").css({ "display" : "block" , "opacity" : 1 });
		$(this.id + ".pin-toast-container .pin-toast").text(message);
		
		setTimeout(function() {
			$(self.id + ".pin-toast-container").css({ "display" : "none" , "opacity" : 0 });
			$(self.id + ".pin-toast-container .pin-toast").css({ "display" : "none" , "opacity" : 0 });
		},time);
	}
}
