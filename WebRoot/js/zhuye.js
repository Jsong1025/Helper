$(function() {
	$('#d_login_form').submit(function (event){
	    var action = '/account/login/?to='+window.location.href;
	    $(this).attr('action', action);
	});
	
	$('#art_remove_a').on('click', function(){
		return confirm('删除这篇文章吗？');
	});
	
	$('#btn_load_ipost').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/post/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_ipost').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_ipost').html('继续加载');
				}else if(data.arts){
					var len = data.arts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var art = data.arts[i];
						strHtml+='<div class="col-sm-6"><div class="thumbnail list-theme list-theme-post">';
						strHtml+='<a href="/post/'+art.id+'/"><img alt="'+art.title+'" src="'+art.coverPic+'" class="img-responsive cover2"/></a>';
						strHtml+='<div class="caption">';
						strHtml+='<p><small><a href="/collection/'+art.firstTopicId+'/" class="text-muted">'+art.firstTopicName+'</a></small></p>';
						strHtml+='<h3><a href="/post/'+art.id+'/">'+art.title+'</a></h3>';
						strHtml+='<span class="avatar avatar40"><a href="/u/'+art.createUserId+'/"><img class="img-circle img-responsive" src="'+art.createUserHead+'" alt="'+art.createUserName+'"></a></span>';
						strHtml+='<p class="text-right"><small class="text-muted"><a href="/u/'+art.createUserId+'/" class="text-muted">'+art.createUserName+'</a></small></p>';
						strHtml+='</div></div></div>';
					}
					$('#ipost_list').append(strHtml);
					$('#btn_load_ipost').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#btn_load_cpost').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/collection/'+tid+'/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_cpost').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_cpost').html('继续加载');
				}else if(data.arts){
					var len = data.arts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var article = data.arts[i];
						strHtml+='<div class="col-sm-6"><div class="thumbnail list-theme list-theme-post">';
						strHtml+='<a href="/post/'+article.articleId+'/"><img alt="'+article.articleTitle+'" src="'+article.articleCoverPic+'" class="img-responsive cover2"/></a>';
						strHtml+='<div class="caption">';
						strHtml+='<p><small><a href="/collection/'+article.topicId+'/" class="text-muted">'+data.topicName+'</a></small></p>';
						strHtml+='<h3><a href="/post/'+article.articleId+'/">'+article.articleTitle+'</a></h3>';
						strHtml+='<span class="avatar avatar40"><a href="/u/'+article.articleUserId+'/"><img class="img-circle img-responsive" src="'+article.articleUserHead+'" alt="'+article.articleUserName+'"></a></span>';
						strHtml+='<p class="text-right"><small class="text-muted"><a href="/u/'+article.articleUserId+'/" class="text-muted">'+article.articleUserName+'</a></small></p>';
						strHtml+='</div></div></div>';
					}
					$('#cpost_list').append(strHtml);
					$('#btn_load_cpost').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#btn_load_scpost').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/topic/'+stId+'/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_scpost').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_scpost').html('继续加载');
				}else if(data.arts){
					var len = data.arts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var article = data.arts[i];
						strHtml+='<div id="sta_'+article.articleId+'" class="col-sm-4"><div class="thumbnail list-theme list-theme-post">';
						strHtml+='<a href="/post/'+article.articleId+'/"><img alt="'+article.articleTitle+'" src="'+article.articleCoverPic+'" class="img-responsive cover2"/></a>';
						strHtml+='<div class="caption"><p>';
						if(article.articleFirstTopicId > 0)strHtml+='<small><a href="/collection/'+article.articleFirstTopicId+'/" class="text-muted">'+article.articleFirstTopicName+'</a></small>';
						else strHtml+='&nbsp;';
						strHtml+='</p><h3><a href="/post/'+article.articleId+'/">'+article.articleTitle+'</a></h3>';
						strHtml+='<span class="avatar avatar40"><a href="/u/'+article.articleUserId+'/"><img class="img-circle img-responsive" src="'+article.articleUserHead+'" alt="'+article.articleUserName+'"></a></span>';
						strHtml+='<p class="text-right"><small class="text-muted"><a href="/u/'+article.articleUserId+'/" class="text-muted">'+article.articleUserName+'</a></small></p>';
						strHtml+="</div>";
						if(data.rem)strHtml+='<div class="btn-group iconbar"><button name="rem_art_f_t" type="button" data-rem="'+article.articleId+'" data-toggle="button" class="btn btn-icon-small" title="从专题中移除"><span class="glyphicon glyphicon-remove"></span></button></div>';
						strHtml+='</div></div>';
					}
					$('#scpost_list').append(strHtml);
					$('#btn_load_scpost').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#btn_load_upost').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/u/'+cuid+'/post/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_upost').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_upost').html('继续加载');
				}else if(data.arts){
					var len = data.arts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var art = data.arts[i];
						strHtml+='<div class="col-sm-6"><div class="thumbnail list-theme list-theme-post">';
						strHtml+='<a href="/post/'+art.id+'/"><img alt="'+art.title+'" src="'+art.coverPic+'" class="img-responsive cover2"/></a>';
						strHtml+='<div class="caption">';
						strHtml+='<p><small><a href="/collection/'+art.firstTopicId+'/" title="前往 '+art.firstTopicName+'" class="text-muted">'+art.firstTopicName+'</a></small></p>';
						strHtml+='<h3><a href="/post/'+art.id+'/">'+art.title+'</a></h3>';
						strHtml+='<p class="text-right"><small class="text-muted"></small></p></div></div></div>';
					}
					$('#post_list').append(strHtml);
					$('#btn_load_upost').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#btn_load_ucollection').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/u/'+cuid+'/collection/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_ucollection').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_ucollection').html('继续加载');
				}else if(data.ts){
					var len = data.ts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var t = data.ts[i];
						strHtml+='<div class="col-xs-6 col-sm-3"><div class="thumbnail list-theme list-theme-column">';
						strHtml+='<a href="/collection/'+t.id+'/"  title="前往 '+t.name+'"><img  alt="'+t.name+'" src="'+t.coverPic+'" class="img-responsive cover"/></a>';
						strHtml+='<div class="caption">';
						strHtml+='<h3><a href="/collection/'+t.id+'/">'+t.name+'</a></h3>';
						strHtml+='<p class="text-muted"><a href="/u/'+t.createUserId+'/" class="text-muted">'+t.createUserName+'</a> 主编，共'+t.articleCount+'篇</p>';
						strHtml+='</div></div></div>';
					}
					$('#collection_list').append(strHtml);
					$('#btn_load_ucollection').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#btn_load_utopic').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/u/'+cuid+'/topic/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_utopic').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_utopic').html('继续加载');
				}else if(data.ts){
					var len = data.ts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var t = data.ts[i];
						strHtml+='<div class="col-sm-6"><div class="thumbnail list-theme list-theme-topic">';
						strHtml+='<a href="/topic/'+t.id+'/"><img alt="'+t.name+'" src="'+t.coverPic+'" class="img-responsive cover"></a>';
						strHtml+='<div class="caption"><div class="caption-content"><h3><a href="/topic/'+t.id+'/">专题</a></h3><div class="divider"></div>';
						strHtml+='<h4><a href="/topic/'+t.id+'/">${ptu:esapieh(t.name)}</a></h4>';
						strHtml+='<p><small>'+t.createUserName+' 主编，共'+t.articleCount+'篇</small></p>';
						strHtml+='</div></div></div></div>';
					}
					$('#topic_list').append(strHtml);
					$('#btn_load_utopic').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#btn_load_topics').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/topic/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_topics').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_topics').html('继续加载');
				}else if(data.ts){
					var len = data.ts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var t = data.ts[i];
						strHtml+='<div class="col-sm-6"><div class="thumbnail list-theme list-theme-topic">';
						strHtml+='<a href="/topic/'+t.id+'/"><img alt="'+t.name+'" src="'+t.coverPic+'" class="img-responsive cover"></a>';
						strHtml+='<div class="caption"><div class="caption-content"><h3><a href="/topic/'+t.id+'/">专题</a></h3><div class="divider"></div>';
						strHtml+='<h4><a href="/topic/'+t.id+'/">${ptu:esapieh(t.name)}</a></h4>';
						strHtml+='<p><small>'+t.createUserName+' 主编，共'+t.articleCount+'篇</small></p>';
						strHtml+='</div></div></div></div>';
					}
					$('#topics').append(strHtml);
					$('#btn_load_topics').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#btn_load_ulike').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/u/'+cuid+'/like/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_ulike').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_ulike').html('继续加载');
				}else if(data.arts){
					var len = data.arts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var art = data.arts[i];
						strHtml+='<div class="col-sm-6"><div class="thumbnail list-theme list-theme-post">';
						strHtml+='<a href="/post/'+art.likeId+'/"><img alt="'+art.title+'" src="'+art.coverPic+'" class="img-responsive cover2"/></a>';
						strHtml+='<div class="caption">';
						strHtml+='<p><small><a href="/collection/'+art.firstTopicId+'/" title="前往 '+art.firstTopicName+'" class="text-muted">'+art.firstTopicName+'</a></small></p>';
						strHtml+='<h3><a href="/post/'+art.likeId+'/">'+art.title+'</a></h3>';
						strHtml+='<span class="avatar avatar40"><a href="/u/'+art.createUserId+'/"><img class="img-circle img-responsive" src="'+art.createUserHead+'" alt="'+art.createUserName+'"></a></span>';
						strHtml+='<p class="text-right"><small class="text-muted"><a href="/u/'+art.createUserId+'/" class="text-muted">'+art.createUserName+'</a></small></p>';
						strHtml+='</div></div></div>';
					}
					$('#like_list').append(strHtml);
					$('#btn_load_ulike').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#btn_load_udraft').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/u/'+cuid+'/draft/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_udraft').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_udraft').html('继续加载');
				}else if(data.arts){
					var len = data.arts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var art = data.arts[i];
						strHtml+='<div class="col-sm-6"><div class="thumbnail list-theme list-theme-post">';
						strHtml+='<a href="/post/'+art.id+'/"><img alt="'+art.title+'" src="'+art.coverPic+'" class="img-responsive cover2"/></a>';
						strHtml+='<div class="caption">';
						strHtml+='<p><small><a href="/collection/'+art.firstTopicId+'/" title="前往 '+art.firstTopicName+'" class="text-muted">'+art.firstTopicName+'</a></small></p>';
						strHtml+='<h3><a href="/post/'+art.id+'/">'+art.title+'</a></h3>';
						strHtml+='<p class="text-right"><small class="text-muted"></small></p></div></div></div>';
					}
					$('#draft_list').append(strHtml);
					$('#btn_load_udraft').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#btn_load_collections').click(function(){
		$(this).html('努力加载中...');
		$.ajax({
			url : '/collection/js/2/',
			type : 'POST',
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_load_collection').html('继续加载');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
					$('#btn_load_collections').html('继续加载');
				}else if(data.ts){
					var len = data.ts.length;
					if(len < 1) return false;
					var strHtml='';
					for(var i=0;i<len;i++){
						var t = data.ts[i];
						strHtml+='<div class="col-xs-6 col-sm-4"><div class="thumbnail list-theme list-theme-column">';
						strHtml+='<a href="/collection/'+t.id+'/"  title="前往 '+t.name+'"><img  alt="'+t.name+'" src="'+t.coverPic+'" class="img-responsive cover"/></a>';
						strHtml+='<div class="caption">';
						strHtml+='<h3><a href="/collection/'+t.id+'/">'+t.name+'</a></h3>';
						strHtml+='<p class="text-muted"><a href="/u/'+t.createUserId+'/" class="text-muted">'+t.createUserName+'</a> 主编，共'+t.articleCount+'篇</p>';
						strHtml+='</div></div></div>';
					}
					$('#collections').append(strHtml);
					$('#btn_load_collections').parent().hide();
					$('.pagination').show();
				}
			}
		});
	});
	
	$('#b_like').click(function() {
		var liked = $('#u_liked').val();
		if(liked === 'true')$('#u_liked').val('false');
		else $('#u_liked').val('true');
		if (lu_id) {
			var d={};
			d['artid']=art_id;
			d['uid']=lu_id;
			d['ltype']=1;
			d['type']=1;
			if(liked === 'true')d['type']=-1;
			$.ajax({
				url : '/post/like/',
				type : 'POST',
				data : d,
				cache: false,
				dataType : 'json',
				error : function() {
				},
				success : function(data) {
					if(data.error){
						alert(data.desc);
					}else{
						if(liked === 'true'){
							$('#s_like').attr('class','glyphicon glyphicon-heart-empty');
							$('#like_char').html('喜欢');
							var c = $('#like_count').html() - 0;
							if(c > 0)$('#like_count').html(c-1);
						}else{
							$('#s_like').attr('class','glyphicon glyphicon-heart');
							$('#like_char').html('已喜欢');
							var c = $('#like_count').html() - 0;
							$('#like_count').html(c+1);
						}
						//$('#like_u').prepend('<a href="#"><span class="avatar"><img class="img-circle" src="/assets/img/avatar.png" alt="0"></span></a>');
					}
				}
			});
		}
	});
	
	$('#b_add_to_column').click(function(){
		if($('input[type="radio"][name="st"]:checked').length == 0){
			alert('必须选择一个专题');
			return false;
		}
		var v = $.parseJSON($('input[type="radio"][name="st"]:checked').val());
		var d={};
		d['uId']=v.uId;
		d['artId']=v.artId;
		d['tId']=v.tId;
		$(this).html('添加中...');
		$(this).attr("disabled", true);
		$.ajax({
			url : '/post/addToColumn/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#b_add_to_column').html('添加');
				$('#b_add_to_column').attr("disabled", false);
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					alert('添加成功');
					$('#b_add_to_column_cancel').trigger('click');
				}
				$('#b_add_to_column').html('添加');
				$('#b_add_to_column').attr("disabled", false);
			}
		});
	});
	
	//昵称验证
	function nameValidate(name){
		name = $.trim(name);
		if(name==''){
			return '昵称不能为空';
		}else{
			var reg=/^[-_a-zA-Z0-9\u4e00-\u9fa5]{2,30}$/;
			if(!reg.test(name)){
				return '昵称格式错误';
			}else{
				return 'ok';
			}
		}
	};
	
	//邮箱验证
	function mailValidate(mail){
		mail = $.trim(mail);
		if(mail==''){
			return '邮箱不能为空';
		}else{
			var reg=/^[A-Za-z0-9._-]+@[A-Za-z0-9.-]+\.[a-zA-Z]{2,4}$/;
			if(!reg.test(mail)){
				return '输入的邮箱格式错误';
			}else{
				return 'ok';
			}
		}
	};
	
	$('#btn_uinfo').click(function(){
		var name = $('#name').val();
		var vr = nameValidate(name);
		if(vr != 'ok'){
			alert(vr);
			return false;
		}
		var description = $('#description').val();
		var reg = new RegExp("\r?\n","g");
		description = description.replace(reg,"<br>");  
		var d={};
		d['name']=name;
		d['description']=description;
		d['location']=$('#location').val();
		$(this).html('保存中...');
		$(this).attr("disabled", true);
		$.ajax({
			url : '/account/settings/uinfo/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_uinfo').html('保存');
				$('#btn_uinfo').attr("disabled", false);
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					alert('保存成功');
					$('#lab_name').html(data.name);
				}
				$('#btn_uinfo').html('保存');
				$('#btn_uinfo').attr("disabled", false);
			}
		});
	});
	
	$('#f_head').bind('change', function(){
		var file = this.files;
		if(file.length < 1){
            alert('图片错误!');
            return;
        }
        file = file[0];
        if(file.type.indexOf('image') == -1){
            alert('请上传正确的图片文件！');
            return;
        }
	  	if(!file){
	    	alert('请选择上传图片！');
	    	return;
	    }
	  	$('#btn_head').html('图片上传中...');
	  	$('#btn_head').attr('disabled', true);
		var formData = new FormData();
	  	formData.append("file", file);
	  	$.ajax({
		    url: '/account/settings/uploadHead/',
		    data: formData,
		    cache: false,
		    processData: false,
		    contentType: false,
		    type: 'POST',
		    error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_head').html('选择头像');
				$('#btn_head').attr('disabled', false);
			},
		    success: function(data){
		    	if(data.error != null){
		    		alert(data.desc);
		    		$('#btn_head').html('选择头像');
		    		$('#btn_head').attr('disabled', false);
		    	}else{
					$('#head_b').attr('src',data.head_b);
					$('#head_s').attr('src',data.head_s);
					$('#btn_head').html('选择头像');
					$('#btn_head').attr('disabled', false);
		    	}
		    }
		});
	});
	
	$('#btn_head').click(function(){
		$('#f_head').trigger('click');
	});
	
	$('#btn_mail').click(function(){
		var mailNew = $('#mailNew').val();
		var passwd = $('#passwd').val();
		passwd = $.trim(passwd);
		var mv = mailValidate(mailNew);
		if(mv != 'ok'){
			alert(mv);
			return false;
		}
		if(passwd == ''){
			alert('密码不能为空');
			return false;
		}
		var d={};
		d['mailNew']=mailNew;
		d['passwd']=passwd;
		$(this).html('保存中...');
		$(this).attr("disabled", true);
		$.ajax({
			url : '/account/settings/mail/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_mail').attr("disabled", false);
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					alert('保存成功，系统已发送验证邮件去新邮箱');
					$('#lab_mail').html(data.mail);
					$('#p_mail').html(data.mail);
					$('#mailNew').val('');
					$('#passwd').val('');
				}
				$('#btn_mail').html('保存');
				$('#btn_mail').attr("disabled", false);
			}
		});
	});
	
	$('#btn_passwd').click(function(){
		var passwdOld = $('#passwdOld').val();
		var passwdNew = $('#passwdNew').val();
		var repasswdNew = $('#repasswdNew').val();
		passwdOld = $.trim(passwdOld);
		passwdNew = $.trim(passwdNew);
		repasswdNew = $.trim(repasswdNew);
		if(passwdOld == '' || passwdNew == '' || repasswdNew == ''){
			alert('密码不能为空');
			return false;
		}
		if(passwdNew != repasswdNew){
			alert('两次密码输入不一致');
			return false;
		}
		var d={};
		d['passwdOld']=passwdOld;
		d['passwdNew']=passwdNew;
		$(this).html('保存中...');
		$(this).attr("disabled", true);
		$.ajax({
			url : '/account/settings/passwd/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_passwd').attr("disabled", false);
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					alert('保存成功');
					$('#passwdOld').val('');
					$('#passwdNew').val('');
					$('#repasswdNew').val('');
				}
				$('#btn_passwd').html('保存');
				$('#btn_passwd').attr("disabled", false);
			}
		});
	});
	
	$('#btn_pdomain').click(function(){
		var pdomain = $('#pdomain').val();
		pdomain = $.trim(pdomain);

		if(pdomain == ''){
			alert('域名不能为空');
			return false;
		}
		var d={};
		d['pdomain']=pdomain;
		$(this).html('保存中...');
		$(this).attr("disabled", true);
		$.ajax({
			url : '/account/settings/pdomain/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_pdomain').attr("disabled", false);
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					alert('保存成功');
					$('#pdomain').val(data.pdomain);
				}
				$('#btn_pdomain').html('保存');
				$('#btn_pdomain').attr("disabled", false);
			}
		});
	});
	
	$('#btn_sub').click(function(){
		var subscribed = $("input[name='subscribe']:checked").val();
		var d={};
		if(typeof subscribed == "undefined"){
			d['subscribed']='';
		}else{
			d['subscribed']=subscribed;
		}
		$(this).html('保存中...');
		$(this).attr("disabled", true);
		$.ajax({
			url : '/account/settings/subscribe/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_sub').attr("disabled", false);
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					alert('保存成功');
				}
				$('#btn_sub').html('保存');
				$('#btn_sub').attr("disabled", false);
			}
		});
	});
	
	$('body').delegate('a[name=del_comment]','click',function(){
		var cId = $(this).attr('data-del');
		var d={};
		d['cId']=cId;
		d['artId']=art_id;
		$.ajax({
			url : '/removeCommentJS/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					$('#d_c_'+cId).remove();
				}
			}
		});
    });
	
	$('body').delegate('a[name=re_comment]','click',function(){
		var j = $(this).attr('data-re');
		var v = $.parseJSON(j);
		var cId = v.cid;
		if(typeof $('#rc_d'+cId).attr('class') == 'undefined'){
			var strHtml='<div id="rc_d'+cId+'" class="media media-card1">';
			strHtml+='<div class="media-body"><textarea class="form-control mb10" rows="3" name="recomment_'+cId+'" placeholder="写下我的评论"></textarea>';
			strHtml+='<a href="javascript:void(0);" id="a_rec'+cId+'" name="publishRec" data-rc=\''+j+'\' class="btn btn-primary">提交</a> <a href="javascript:void(0);" name="cancelRec" data-c="'+cId+'" class="btn btn-default">取消</a></div></div>';
			$('#d_rc_'+cId).append(strHtml);
		}else{
			$('#rc_d'+cId).toggle();
		}
    });
	
	$('body').delegate('a[name=publishRec]','click',function(){
		var v = $.parseJSON($(this).attr('data-rc'));
		var recomment = $('textarea[name=recomment_'+v.cid+']').val();
    	recomment = $.trim(recomment);
		if(recomment == ''){
			alert('评论不能为空！');
			return false;
		}
		var d={};
		d['comment']=recomment;
		d['artId']=art_id;
		d['artUId']=art_uid;
		d['recId']=v.cid;
		d['reUId']=v.cuid;
		d['reUName']=v.cun;
		d['reUPdomain']=v.cup;
		$(this).html('提交中...');
		$(this).attr("disabled", true);
		$.ajax({
			url : '/addCommentJS/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#a_rec'+rcid).html('提交');
				$('#a_rec'+rcid).attr("disabled", false);
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					var c = data.comment;
					var strHtml = '<div id="d_c_'+c.id+'" class="media media-card1"><a class="pull-left" href="/u/'+data.pul+'/">';
					strHtml+='<span class="avatar avatar60"><img class="media-object img-circle img-responsive" src="'+c.userHead+'"></span></a>';
					strHtml+='<div class="media-body" name="re_comment_div1"><h5><a href="/u/'+data.pul+'/">'+c.userName+'</a>';
					if(c.userType==1)strHtml+='<small class="text-muted">(作者)</small>';
					if(data.isRe)strHtml+='<small>回复</small><a href="/u/'+data.repul+'/">'+c.replyUserName+'</a>';
					strHtml+='</h5><div><p>'+c.comment+'</p></div>';
					strHtml+='<div class="link-list"><span class="text-muted">刚刚</span><a href="javascript:void(0);" name="del_comment" data-del="'+c.id+'" class="text-muted"><span class="glyphicon glyphicon-trash"></span> 删除</a></div>';
					strHtml+='</div></div>';
					$('#comment_list').append(strHtml);
					$('textarea[name=recomment_'+v.cid+']').val('');
					$('#rc_d'+v.cid).toggle();
					$('html, body').animate({scrollTop: $('#d_c_'+c.id).offset().top}, 1500);
				}
				$('#a_rec'+rcid).html('提交');
				$('#a_rec'+rcid).attr("disabled", false);
			}
		});
	});
	
	$('body').delegate('a[name=cancelRec]','click',function(){
		var cId = $(this).attr('data-c');
		$('#rc_d'+cId).toggle();
	});
	
	$('#btn_comment_add').click(function(){
		var comment = $('textarea[name=comment]').val();
		comment = $.trim(comment);
		if(comment == ''){
			alert('评论不能为空！');
			return false;
		}
		var d={};
		d['comment']=comment;
		d['artId']=art_id;
		d['artUId']=art_uid;
		$(this).html('提交中...');
		$(this).attr("disabled", true);
		$.ajax({
			url : '/addCommentJS/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_comment_add').html('提交');
				$('#btn_comment_add').attr("disabled", false);
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					var c = data.comment;
					var strHtml = '<div id="d_c_'+c.id+'" class="media media-card1"><a class="pull-left" href="/u/'+data.pul+'/">';
					strHtml+='<span class="avatar avatar60"><img class="media-object img-circle img-responsive" src="'+c.userHead+'"></span></a>';
					strHtml+='<div class="media-body" name="re_comment_div1"><h5><a href="'+data.pul+'">'+c.userName+'</a>';
					if(c.userType==1)strHtml+='<small class="text-muted">(作者)</small>';
					if(data.isRe)strHtml+='<small>回复</small><a href="'+data.repul+'">'+c.replyUserName+'</a>';
					strHtml+='</h5><div><p>'+c.comment+'</p></div>';
					strHtml+='<div class="link-list"><span class="text-muted">刚刚</span><a href="javascript:void(0);" name="del_comment" data-del="'+c.id+'" class="text-muted"><span class="glyphicon glyphicon-trash"></span> 删除</a></div>';
					strHtml+='</div></div>';
					$('#comment_list').append(strHtml);
					if(!data.isRe)$('textarea[name=comment]').val('');
				}
				$('#btn_comment_add').html('提交');
				$('#btn_comment_add').attr("disabled", false);
			}
		});
	});
	
	$('#btn_comment_more').click(function(){
		var p = $(this).attr('data-page');
		var d={};
		d['artId']=art_id;
		d['page']=p;
		$(this).html('努力加载中...');
		$(this).attr("disabled", true);
		$.ajax({
			url : '/commentPageJS/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
				$('#btn_comment_more').html('加载更多评论');
				$('#btn_comment_more').attr("disabled", false);
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					var cs = data.comments;
					var len = cs.length;
					if(len < 1)return false;
					var strHtml = '';
					for(var i=0; i<len; i++){
						var c = cs[i];
						strHtml += '<div id="d_c_'+c.id+'" class="media media-card1"><a class="pull-left" href="/u/'+c.userPdomain+'/">';
						strHtml+='<span class="avatar avatar60"><img class="media-object img-circle img-responsive" src="'+c.userHead+'"></span></a>';
						strHtml+='<div class="media-body" id="d_rc_'+c.id+'"><h5><a href="'+c.userPdomain+'">'+c.userName+'</a>';
						if(c.userType==1)strHtml+='<small class="text-muted">(作者)</small>';
						if(data.isRe)strHtml+='<small>回复</small><a href="'+c.replyUserPdomain+'">'+c.replyUserName+'</a>';
						strHtml+='</h5><div><p>'+c.comment+'</p></div>';
						strHtml+='<div class="link-list"><span class="text-muted">'+c.scTime+'</span>';
						if(lu_id != c.userId+'')strHtml+='<a href="javascript:void(0);" name="re_comment" data-re=\'{"cid":'+c.id+',"cuid":'+c.userId+',"cun":"'+c.userName+'","cup":"'+c.userPdomain+'"}\' class="text-muted">回复</a>';
						if(lu_id == c.userId+'')strHtml+='<a href="javascript:void(0);" name="del_comment" data-del="'+c.id+'" class="text-muted"><span class="glyphicon glyphicon-trash"></span> 删除</a>';
						strHtml+='</div></div></div>';
					}
					var mp = $('#btn_comment_more').parent().parent();
					$(strHtml).insertBefore($(mp));
					if(data.hasMore)$('#btn_comment_more').attr("data-page", data.npage);
					else $(mp).hide();
				}
				$('#btn_comment_more').html('加载更多评论');
				$('#btn_comment_more').attr("disabled", false);
			}
		});
	});
	
	$('body').delegate('button[name=st_p]','click',function(){
		var pub = $(this).attr('data-st');
		var d={};
		d['stId']=stId;
		d['publish']=pub;
		$.ajax({
			url : '/topic/js/publish/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					if(pub == 1 || pub == '1'){
						$('button[name=st_p]').removeClass('btn-primary').addClass('btn-default');
						$('button[name=st_p]').html('取消发布');
						$('button[name=st_p]').attr('data-st','0');
					}
					if(pub == 0 || pub == '0'){
						$('button[name=st_p]').removeClass('btn-default').addClass('btn-primary');
						$('button[name=st_p]').html('发布专题');
						$('button[name=st_p]').attr('data-st','1');
					}
				}
			}
		});
	});
	
	$('body').delegate('button[name=rem_art_f_t]','click',function(){
		var artId = $(this).attr('data-rem');
		var d={};
		d['stId']=stId;
		d['artId']=artId;
		$.ajax({
			url : '/topic/js/removeArticle/',
			type : 'POST',
			data : d,
			cache: false,
			dataType : 'json',
			error : function() {
				alert('系统故障，稍微重试！');
			},
			success : function(data) {
				if(data.error){
					alert(data.desc);
				}else{
					$('#sta_'+artId).remove();
				}
			}
		});
	});
});