<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset='utf-8'>
    <meta http-equiv='X-UA-Compatible' content='IE=edge'>
    <title>펜션</title>
    <meta name='viewport' content='width=device-width, initial-scale=1'>
    <style>
        *{
            margin: 0;
            padding: 0;
        }
        .flex_container{
            display: flex;
            flex-direction: column;
            width: 1200px;
            margin: 0 auto;
            font-size: 0px;
        }
        #member_bar{
            height: 50px;
            background-color: #e9e9e9;
            text-align: right;
        }
        #member_bar img{
            width: 50px;
            float: left;
        }
        #member_bar > div > p{
            width: 200px;
            float: left;
            font-size: 16px;
            text-align: left;
            padding-left: 5px;
            margin-top: 2px;
        }
        #member_bar > div{
            width: 300px;
            display: inline-block;
        } 
        nav{
            padding:20px 100px;
            background-color: #e9e9e9;
        }
        nav ul{
            list-style-type: none;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
        }
       
        nav a:link,nav a:visited{
            font-size: 20px;
            font-weight: bold;
            text-decoration: none;
            color:black;
        }
        .ad_img {
            position: relative;
        }
        .ad_img button{
            background: none;
            border: none;
            position: absolute;
            background-color: rgba(255, 255, 255, 0.5);
            width: 50px;
            height: 50px;
        }
        .ad_img button img{
            width: 50px;
        }
        .left_arrow{
            top : calc(50% - 50px);
        }
        .right_arrow{
            top : calc(50% - 50px);
            right: 0px;
            transform: rotate(180deg);            
        }
        section{
            margin-top: 20px;
            font-size: 16px;
        }
        article{
            padding: 0px 30px;
            display: flex;
            flex-direction: row;
            justify-content: flex-start;
        }
        article > img{
            width: 70%;
            margin-right: 10px;
        }
        article > div >  p{
            margin-top: 10px;
        }
        footer{
            margin-top: 50px;
            padding:15px 10px;
            font-size: 16px;
            background-color: #e9e9e9;
        }
        footer ul{
            list-style-type: none;
        }
        footer ul li{
            margin: 5px 0px;
        }
    </style>
</head>
<body>
    <div class="flex_container">
        <jsp:include page="template/pheader.jsp"></jsp:include>
        <section>
            <article>
                <img src="resource/images/map.png">
                <div>
                    <h2>오시는길</h2>
                    <p>모든 국민은 직업선택의 자유를 가진다. 대법관의 임기는 6년으로 하며, 법률이 정하는 바에 의하여 연임할 수 있다. 헌법재판소 재판관은 정당에 가입하거나 정치에 관여할 수 없다.</p>
                    <p>모든 국민은 주거의 자유를 침해받지 아니한다. 주거에 대한 압수나 수색을 할 때에는 검사의 신청에 의하여 법관이 발부한 영장을 제시하여야 한다. 군인은 현역을 면한 후가 아니면 국무위원으로 임명될 수 없다.</p>
                </div>
            </article>
        </section>
        <jsp:include page="template/pfooter.jsp"></jsp:include>
    </div>    
</body>
</html>