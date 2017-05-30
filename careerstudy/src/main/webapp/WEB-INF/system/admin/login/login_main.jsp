<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<script>
	$(document).ready(function(){
		$("#user_password").keypress(function(e) { 
		    if (e.keyCode == 13){
		    	fn_login_do();
		    }    
		});	
	});
	
	function fn_login_do(){
		$("#loginForm").attr("action","/admin/login/loginDone.do").submit();
	}
</script>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">진로교육 관리자 페이지</h3>
                </div>
                <div class="panel-body">
                    <form id="loginForm" name="loginForm" method="post" role="form">
                        <fieldset>
                            <div class="form-group">
                                <input class="form-control" placeholder="id" name="user_id" id="user_id" type="id" autofocus />
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="Password" name="user_password" id="user_password" type="password" value="" />
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">Remember Me
                                </label>
                            </div>
                            <!-- Change this to a button or input when using this as a form -->
                            <a href="#" class="btn btn-lg btn-success btn-block" onClick="fn_login_do()">Login</a>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
