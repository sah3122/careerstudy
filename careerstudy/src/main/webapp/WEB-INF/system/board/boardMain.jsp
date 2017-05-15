<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<h2 id="container_title">공지사항<span class="sound_only"> 목록</span></h2>
        <!-- 게시판 목록 시작 { -->
        <div id="bo_list" style="width:100%">
            <div id="bo_gall" style="width:80%100%">
                <!-- 게시판 카테고리 시작 { -->
                <!-- } 게시판 카테고리 끝 -->
                <!-- 게시판 페이지 정보 및 버튼 시작 { -->
                <div class="bo_fx">
                   <!--  <div id="bo_list_total">
                        <span>Total 0건</span> 1 페이지
                    </div> -->
                </div>
                <!-- } 게시판 페이지 정보 및 버튼 끝 -->
                <form name="fboardlist" id="fboardlist" action="./board_list_update.php" onsubmit="return fboardlist_submit(this);" method="post">
                    <div class="tbl_head01 tbl_wrap">
                        <table>
                            <caption>게시판 목록</caption>
                            <thead>
                                <tr>
						            <th scope="col">번호</th>
						            <th scope="col">제목</th>
						            <th scope="col">글쓴이</th>
						            <th scope="col"><a href="#">날짜</a></th>
						            <th scope="col"><a href="#">조회</a></th>
						        </tr>
						    </thead>
						    <tbody>
						        <tr class="">
						            <td class="td_num">1</td>
						            <td class="td_subject">               
						                <a href="#">오픈기념이벤트 행사중 (배달용)</a>
									</td>
						            <td class="td_name sv_use"><span class="sv_member">최고관리자</span></td>
						            <td class="td_date">10-07</td>
						            <td class="td_num">63</td>
								</tr>
							</tbody>
                        </table>
                    </div>
                    <div class="bo_fx">
                    </div>
                </form>
            </div>
            <!-- 페이지 -->
            <!-- 게시판 검색 시작 { -->
            <fieldset id="bo_sch">
                <legend>게시물 검색</legend>
                <form name="fsearch" method="get">
                    <input type="hidden" name="bo_table" value="yunint_board">
                    <input type="hidden" name="sca" value="">
                    <input type="hidden" name="sop" value="and">
                    <label for="sfl" class="sound_only">검색대상</label>
                    <select name="sfl" id="sfl">
                        <option value="wr_subject">제목</option>
                        <option value="wr_content">내용</option>
                        <option value="wr_subject||wr_content">제목+내용</option>
                        <option value="mb_id,1">회원아이디</option>
                        <option value="mb_id,0">회원아이디(코)</option>
                        <option value="wr_name,1">글쓴이</option>
                        <option value="wr_name,0">글쓴이(코)</option>
                    </select>
                    <label for="stx" class="sound_only">검색어<strong class="sound_only"> 필수</strong></label>
                    <input type="text" name="stx" value="" required id="stx" class="frm_input required" size="15" maxlength="20">
                    <input type="submit" value="검색" class="btn_submit">
                </form>
            </fieldset>
            <!-- } 게시판 검색 끝 -->
            <!-- } 게시판 목록 끝 -->
        </div>

        <style>
        /*
#sns{ margin:0 auto; height:auto; overflow:hidden; }
#sns img{width:100%; height:auto;}
.call{width:25%;  float:left;}
.txt{width:25%;  float:left;}
.kakao{width:25%;  float:left;}
.map{width:25%;  float:left;}

/*#footer영역*/
#footer{
width:100%;
height:180px;
background:#2a2a2a;
position:relative;
}

#footerin .flogo{
color:#ffffff;
position:absolute;
top:20px;
left:50%;
margin-left:-180px;
font-weight:400;
}
 #footerin .fright{
position:absolute;
bottom:45px;

right:50%;
margin-right:-75px;
}
#footerin .hp{

position:absolute;
bottom:15px;
color:#545454;
right:50%;
margin-right:-90px;
}



@media screen and (min-width:640px){

#wrap{min-width:640px;}
#header .utill{display:none;}
#footerin .hp{color:#545454; position:absolute; bottom:10px; right:50%; margin-right:-100px;}
}

@media screen and (min-width:1024px){
#wrap{min-width:1024px;}

#sns{display:none;}
/*#footer영역*/
#footer{
width:100%;
height:140px;
background:#2a2a2a;
position:relative;
}
#footerin .flogo{
color:#ffffff;
position:absolute;
top:20px;
left:50%;
margin-left:-500px;
font-weight:400;
}

#footerin .hp{
position:absolute;
bottom:15px;
color:#545454;
right:50%;
margin-right:-90px;
}
#footerin .fright{
color:#ffffff;
position:absolute;
bottom:20px;
right:50%;
margin-right:-480px;
}
}
*/
        </style>
        <!-- 사용스킨 : basic -->
        <!-- ie6,7에서 사이드뷰가 게시판 목록에서 아래 사이드뷰에 가려지는 현상 수정 -->
        <!--[if lte IE 7]>
<script>
$(function() {
    var $sv_use = $(".sv_use");
    var count = $sv_use.length;

    $sv_use.each(function() {
        $(this).css("z-index", count);
        $(this).css("position", "relative");
        count = count - 1;
    });
});
</script>
<![endif]-->
<script type="text/javascript">
    $(document).ready(function() {
        var nation = $('.gnb_comm');

        var url = window.location.href;
        var ready = "N";
        nation.find('>li>a').each(
            function() { //국가쪽 클릭했을때 에 색깔넣기
                if (url == (this.href)) {
                    $(this).attr("class", "on");
                    $(this).parent('li').find('>div').attr("class", 'smnu_lst'); //
                    ready = "Y";
                }
            });

    });
</script>